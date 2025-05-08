package com.development.spring.invest_ai.InvestAI.repository;

import com.development.spring.invest_ai.InvestAI.entity.Cliente;
import com.development.spring.invest_ai.InvestAI.libs.data.repositories.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends CrudRepository<Cliente, Long> {
}
