package com.development.spring.invest_ai.InvestAI.repository;

import com.development.spring.invest_ai.InvestAI.entity.Avviso;
import com.development.spring.invest_ai.InvestAI.libs.data.repositories.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AvvisoRepository extends CrudRepository<Avviso, Long> {
}
