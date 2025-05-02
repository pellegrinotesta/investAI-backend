package com.development.spring.invest_ai.InvestAI.profile.controllers;



import com.development.spring.invest_ai.InvestAI.dtos.UserDTO;
import com.development.spring.invest_ai.InvestAI.entity.User;
import com.development.spring.invest_ai.InvestAI.mapper.UserMapper;
import com.development.spring.invest_ai.InvestAI.profile.dtos.PatchProfileDTO;
import com.development.spring.invest_ai.InvestAI.profile.service.ProfileService;
import com.development.spring.invest_ai.InvestAI.security.models.JwtAuthentication;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("profile")
public class ProfileController {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private ProfileService profileService;

    @GetMapping
    public UserDTO getProfile(JwtAuthentication jwtAuthentication) {
        return userMapper.convertModelToDTO(profileService.getProfile(jwtAuthentication));
    }

    @PatchMapping
    public UserDTO partialUpdate(JwtAuthentication jwtAuthentication, @RequestBody PatchProfileDTO patchProfileDTO) {
        User user = userMapper.convertProfileDTOtoUser(patchProfileDTO);
        return userMapper.convertModelToDTO(
                profileService.partialUpdate(jwtAuthentication, user, patchProfileDTO.getNewPassword())
        );
    }

}
