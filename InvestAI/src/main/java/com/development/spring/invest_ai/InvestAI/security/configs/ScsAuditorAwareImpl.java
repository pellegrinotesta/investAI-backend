package com.development.spring.invest_ai.InvestAI.security.configs;

import com.development.spring.invest_ai.InvestAI.security.models.JwtAuthentication;
import com.development.spring.invest_ai.InvestAI.security.services.SessionService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.AuditorAware;

import java.util.Optional;

@RequiredArgsConstructor
public class ScsAuditorAwareImpl implements AuditorAware<Long> {

    @Autowired
    private SessionService sessionService;

    @Override
    public Optional<Long> getCurrentAuditor() {
        JwtAuthentication jwtAuthentication = sessionService.getCurrentUser();
        return jwtAuthentication != null
                ? Optional.of(jwtAuthentication.getId())
                : Optional.empty();
    }
}
