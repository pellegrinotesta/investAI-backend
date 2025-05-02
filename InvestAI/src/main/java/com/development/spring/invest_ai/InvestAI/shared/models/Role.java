package com.development.spring.invest_ai.InvestAI.shared.models;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {

    ADMIN,
    CLIENTE;


    public String getAuthority() {
        return this.name();
    }

}
