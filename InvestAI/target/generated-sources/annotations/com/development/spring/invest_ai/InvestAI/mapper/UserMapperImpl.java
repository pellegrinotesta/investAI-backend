package com.development.spring.invest_ai.InvestAI.mapper;

import com.development.spring.invest_ai.InvestAI.dtos.UserDTO;
import com.development.spring.invest_ai.InvestAI.entity.User;
import com.development.spring.invest_ai.InvestAI.profile.dtos.PatchProfileDTO;
import com.development.spring.invest_ai.InvestAI.shared.models.Role;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-05-02T17:10:33+0200",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 3.42.0.z20250331-1358, environment: Java 21.0.6 (Eclipse Adoptium)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public UserDTO convertModelToDTO(User user) {
        if ( user == null ) {
            return null;
        }

        UserDTO userDTO = new UserDTO();

        userDTO.setId( user.getId() );
        userDTO.setPassword( user.getPassword() );
        userDTO.setEmail( user.getEmail() );
        userDTO.setName( user.getName() );
        userDTO.setSurname( user.getSurname() );
        userDTO.setStatus( user.getStatus() );
        Set<Role> set = user.getRoles();
        if ( set != null ) {
            userDTO.setRoles( new LinkedHashSet<Role>( set ) );
        }

        return userDTO;
    }

    @Override
    public User convertDtoToModel(UserDTO userDTO) {
        if ( userDTO == null ) {
            return null;
        }

        User user = new User();

        user.setId( userDTO.getId() );
        user.setEmail( userDTO.getEmail() );
        user.setName( userDTO.getName() );
        user.setPassword( userDTO.getPassword() );
        user.setStatus( userDTO.getStatus() );
        user.setSurname( userDTO.getSurname() );
        Set<Role> set = userDTO.getRoles();
        if ( set != null ) {
            user.setRoles( new LinkedHashSet<Role>( set ) );
        }

        return user;
    }

    @Override
    public List<UserDTO> convertModelsToDtos(List<User> users) {
        if ( users == null ) {
            return null;
        }

        List<UserDTO> list = new ArrayList<UserDTO>( users.size() );
        for ( User user : users ) {
            list.add( convertModelToDTO( user ) );
        }

        return list;
    }

    @Override
    public User convertProfileDTOtoUser(PatchProfileDTO profileDTO) {
        if ( profileDTO == null ) {
            return null;
        }

        User user = new User();

        user.setEmail( profileDTO.getEmail() );
        user.setName( profileDTO.getName() );
        user.setPassword( profileDTO.getPassword() );
        user.setSurname( profileDTO.getSurname() );

        return user;
    }

    @Override
    public void updateModel(User source, User target) {
        if ( source == null ) {
            return;
        }

        if ( source.getId() != null ) {
            target.setId( source.getId() );
        }
        if ( source.getEmail() != null ) {
            target.setEmail( source.getEmail() );
        }
        if ( source.getName() != null ) {
            target.setName( source.getName() );
        }
        if ( source.getPassword() != null ) {
            target.setPassword( source.getPassword() );
        }
        if ( source.getStatus() != null ) {
            target.setStatus( source.getStatus() );
        }
        if ( source.getSurname() != null ) {
            target.setSurname( source.getSurname() );
        }
        if ( target.getRoles() != null ) {
            Set<Role> set = source.getRoles();
            if ( set != null ) {
                target.getRoles().clear();
                target.getRoles().addAll( set );
            }
        }
        else {
            Set<Role> set = source.getRoles();
            if ( set != null ) {
                target.setRoles( new LinkedHashSet<Role>( set ) );
            }
        }
    }
}
