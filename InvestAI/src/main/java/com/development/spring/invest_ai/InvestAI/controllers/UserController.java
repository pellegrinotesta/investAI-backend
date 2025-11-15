package com.development.spring.invest_ai.InvestAI.controllers;

import com.development.spring.invest_ai.InvestAI.dtos.ResponseDTO;
import com.development.spring.invest_ai.InvestAI.dtos.UserDTO;
import com.development.spring.invest_ai.InvestAI.dtos.UserRegistrationDTO;
import com.development.spring.invest_ai.InvestAI.mapper.UserMapper;
import com.development.spring.invest_ai.InvestAI.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("user")
public class UserController {

    private final UserService userService;
    private final UserMapper userMapper;

    @PostMapping("first-registration")
    public ResponseDTO<UserDTO> firstRegistration(@RequestBody UserRegistrationDTO request) {
        ResponseDTO<UserDTO> res = new ResponseDTO<>();
        try {

            res.setOk(true);
            res.setData(userMapper.convertModelToDTO(userService.firstRegistration(request)));

        }catch (Exception e) {
            res.setOk(false);
            res.setMessage(e.getMessage());
        }

        return res;
    }
}
