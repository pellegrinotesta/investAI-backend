package com.development.spring.invest_ai.InvestAI.libs.web.services;


import com.development.spring.invest_ai.InvestAI.libs.data.models.IdentifiableEntity;

public interface CrudService<Model extends IdentifiableEntity<Id>, Id, SearchCriteria> extends CreateService<Model, Id>, DeleteService<Model, Id>, ReadService<Model, Id>, UpdateService<Model, Id>, SearchService<Model, SearchCriteria>, AdvancedSearchService<Model>, RepositoryService<Model, Id> {}
