package com.development.spring.invest_ai.InvestAI.libs.web.services;


import com.development.spring.invest_ai.InvestAI.libs.data.models.IdentifiableEntity;
import com.development.spring.invest_ai.InvestAI.libs.data.repositories.CrudRepository;

public interface RepositoryService<Model extends IdentifiableEntity<Id>, Id> {
    CrudRepository<Model, Id> getRepository();
}
