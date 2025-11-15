package com.development.spring.invest_ai.InvestAI.service;

import com.development.spring.invest_ai.InvestAI.components.UserSpecificationsFactory;
import com.development.spring.invest_ai.InvestAI.dtos.UserRegistrationDTO;
import com.development.spring.invest_ai.InvestAI.entity.Cliente;
import com.development.spring.invest_ai.InvestAI.entity.User;
import com.development.spring.invest_ai.InvestAI.libs.data.models.Filter;
import com.development.spring.invest_ai.InvestAI.libs.utils.ComparableWrapper;
import com.development.spring.invest_ai.InvestAI.libs.utils.Pair;
import com.development.spring.invest_ai.InvestAI.mapper.UserMapper;
import com.development.spring.invest_ai.InvestAI.repository.UserRepository;
import com.development.spring.invest_ai.InvestAI.security.services.LoginAttemptService;
import com.development.spring.invest_ai.InvestAI.security.services.SessionService;
import com.development.spring.invest_ai.InvestAI.shared.models.Role;
import com.development.spring.invest_ai.InvestAI.shared.services.BasicService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.mapping.PropertyReferenceException;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.*;
import java.util.function.Function;

@Service
public class UserService extends BasicService {

    private final LoginAttemptService loginAttemptService;
    private final UserMapper userMapper;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final Logger logger = LoggerFactory.getLogger(UserService.class);
    private final UserSpecificationsFactory userSpecificationsFactory;
    private final EmailService emailService;
    private static final String USER_ID_NOT_FOUND = "User with id %d not found.";

    private final Map<String, Function<User, ComparableWrapper>> sortingFields = new HashMap<>() {{
        put("name", user -> user.getName() != null ? new ComparableWrapper(user.getName()) : null);
        put("surname", user -> user.getSurname() != null ? new ComparableWrapper(user.getSurname()) : null);
        put("roles", user -> user.getRoles() != null ? new ComparableWrapper(user.getRoles()) : null);
    }};


    public UserService(LoginAttemptService loginAttemptService, UserMapper userMapper, SessionService sessionService, UserRepository userRepository, PasswordEncoder passwordEncoder, UserSpecificationsFactory userSpecificationsFactory, EmailService emailService) {
        this.userMapper = userMapper;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.userSpecificationsFactory = userSpecificationsFactory;
        this.emailService = emailService;
        this.loginAttemptService = loginAttemptService;
    }

    public User create(User user) {
        user.setId(null);
        String tempPassword = PasswordTokenService.generateRandomString();
        user.setPassword(tempPassword);
        User newUser = save(user);
       // emailService.sendTempPasswordEmail(user.getEmail(), tempPassword);

        return newUser;
    }

    public User resetPassword(Long id) {
        Optional<User> optUser = userRepository.findById(id);
        if (optUser.isPresent()) {
            User user = optUser.get();
            String tempPassword = PasswordTokenService.generateRandomString();
            user.setPassword(tempPassword);
            userRepository.save(user);
            //emailService.sendTempPasswordEmail(user.getEmail(), tempPassword);
            return user;
        }
        return null;
    }

    @Transactional
    public Page<User> searchAdvanced(Optional<Filter<User>> filter, Pageable pageable) {
        try {

            Pair<Boolean, String> sortingInfo = isSortedOnNonDirectlyMappedField(sortingFields, pageable);
            boolean isSorted = sortingInfo.getFirst();
            String sortingProperty = sortingInfo.getSecond();
            Page<User> usersPage;

            if(isSorted) {
                List<User> users = filter.map(userFilter ->
                        userRepository.findAll(getSpecificationForAdvancedSearch(userFilter))
                ).orElseGet(userRepository::findAll);

                usersPage = getPage(sortingFields, users, pageable, sortingProperty);

            } else {
                usersPage = filter.map(userFilter ->
                        userRepository.findAll(getSpecificationForAdvancedSearch(userFilter), pageable)
                ).orElseGet(() -> userRepository.findAll(pageable));

            }

            usersPage = removeDuplicates(usersPage);
            return applyRoleVisibilityFilter(usersPage);

        } catch (PropertyReferenceException ex) {
            String message = String.format(INVALID_SEARCH_CRITERIA, ex.getMessage());
            logger.debug(message);
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, message);
        }
    }

    private Page<User> applyRoleVisibilityFilter(Page<User> usersPage) {

        List<User> filteredUsers = new ArrayList<>();

        for (User user : usersPage.getContent()) {
            if (!user.getRoles().contains(Role.ADMIN))
                filteredUsers.add(user);
        }
        return new PageImpl<>(filteredUsers, usersPage.getPageable(), usersPage.getTotalElements());
    }



    private Specification<User> getSpecificationForAdvancedSearch(Filter<User> userFilter){
        return userFilter.toSpecification(userSpecificationsFactory);
    }

    public User update(User user) {

        Optional<User> oldUserOptional = userRepository.findById(user.getId());
        if (oldUserOptional.isEmpty())
            throw buildEntityWithIdNotFoundException(user.getId(), USER_ID_NOT_FOUND);

        return save(user);
    }

    public User partialUpdate(User user) {

        Optional<User> oldUserOptional = userRepository.findById(user.getId());
        if (oldUserOptional.isEmpty()) {
            throw buildEntityWithIdNotFoundException(user.getId(), USER_ID_NOT_FOUND);
        }
        User oldUser = oldUserOptional.get();

//        if(!hasUserPermissionToChangeRoles(oldUser.getRoles()))
//            throw buildDumCannotModifyPermissionsException();
//
//        if(isUserEnabled(user))
//            loginAttemptService.clearCache(oldUser.getEmail());

        userMapper.updateModel(user, oldUser);
        return saveFromPartialUpdate(oldUser, user);
    }

    public User save(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return save(userRepository, user);
    }

    public User getById(Long id) {
        return getById(userRepository, id, USER_ID_NOT_FOUND);
    }

    public void deleteById(Long id) {
        Optional<User> oldUserOptional = userRepository.findById(id);

        if (oldUserOptional.isEmpty())
            throw buildEntityWithIdNotFoundException(id, USER_ID_NOT_FOUND);

        User oldUser = oldUserOptional.get();


        deleteById(userRepository, id);
    }

    public List<User> getAll(){
        return getAll(userRepository);
    }

    private User saveFromPartialUpdate(User oldUser, User user) {
        if (user.getPassword() != null) {
            oldUser.setPassword(passwordEncoder.encode(oldUser.getPassword()));
        }
        try {
            return userRepository.save(oldUser);
        } catch (DataIntegrityViolationException ex) {
            String message = CONSTRAINT_VIOLATION;
            logger.debug(message);
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, message);
        }
    }

    public boolean existsByUserId(Long userId){
        Optional<User> optionalUser = userRepository.findByUserId(userId);
        return optionalUser.isPresent();
    }

    public User firstRegistration(UserRegistrationDTO dto) {
        if (userRepository.findByEmail(dto.getEmail()).isPresent()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Email is already in use.");
        }

        Set<Role> assignedRoles = new HashSet<>();
        assignedRoles.add(Role.CLIENTE);

        User user = User.builder()
                .name(dto.getName())
                .surname(dto.getSurname())
                .email(dto.getEmail())
                .password(passwordEncoder.encode(dto.getPassword()))
                .roles(assignedRoles)
                .build();

        Cliente cliente = Cliente.builder()
                .codiceFiscale(dto.getCodiceFiscale())
                .dataRegistrazione(new Date())
                .indirizzo(dto.getIndirizzo())
                .telefono(dto.getTelefono())
                .dataNascita(dto.getDataNascita())
                .user(user)
                .build();

        user.setCliente(cliente);

        return save(user);
    }

}
