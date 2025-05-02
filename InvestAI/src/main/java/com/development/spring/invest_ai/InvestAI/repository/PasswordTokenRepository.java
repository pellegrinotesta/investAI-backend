package com.development.spring.invest_ai.InvestAI.repository;


import com.development.spring.invest_ai.InvestAI.entity.PasswordResetToken;
import com.development.spring.invest_ai.InvestAI.libs.data.repositories.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface PasswordTokenRepository extends CrudRepository<PasswordResetToken, Long> {

    List<PasswordResetToken> findByExpiryDateBefore(Date now);
    PasswordResetToken findByToken(String Token);
}
