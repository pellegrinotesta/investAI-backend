package com.development.spring.invest_ai.InvestAI.repository;

import com.development.spring.invest_ai.InvestAI.entity.Strumento;
import com.development.spring.invest_ai.InvestAI.libs.data.repositories.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StrumentoRepository extends CrudRepository<Strumento, Long> {
}
