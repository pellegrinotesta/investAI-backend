package com.development.spring.invest_ai.InvestAI.mapper;

import com.development.spring.invest_ai.InvestAI.dtos.UserDTO;
import com.development.spring.invest_ai.InvestAI.entity.User;
import com.development.spring.invest_ai.InvestAI.libs.web.dtos.PageDTO;
import com.development.spring.invest_ai.InvestAI.profile.dtos.PatchProfileDTO;
import org.mapstruct.*;
import org.springframework.data.domain.Page;

import java.util.List;

@Mapper(componentModel = "spring",
        builder = @Builder(disableBuilder = true))
public interface UserMapper {

    UserDTO convertModelToDTO(User user);

    User convertDtoToModel(UserDTO userDTO);

    List<UserDTO> convertModelsToDtos(List<User> users);

    User convertProfileDTOtoUser(PatchProfileDTO profileDTO);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateModel(User source, @MappingTarget User target);

    default PageDTO<UserDTO> convertModelsPageToDtosPage(Page<User> modelsPage) {
        return PageDTO.<UserDTO>builder()
                .content(convertModelsToDtos(modelsPage.getContent()))
                .first(modelsPage.isFirst())
                .last(modelsPage.isLast())
                .number(modelsPage.getNumber())
                .numberOfElements(modelsPage.getNumberOfElements())
                .size(modelsPage.getSize())
                .sort(modelsPage.getSort().toList())
                .totalElements(modelsPage.getTotalElements())
                .totalPages(modelsPage.getTotalPages())
                .build();
    }

}
