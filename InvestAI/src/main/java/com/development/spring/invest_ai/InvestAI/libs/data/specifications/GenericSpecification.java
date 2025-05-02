package com.development.spring.invest_ai.InvestAI.libs.data.specifications;


import jakarta.persistence.criteria.Path;
import jakarta.persistence.criteria.Root;
import org.springframework.data.jpa.domain.Specification;

public interface GenericSpecification<E, A> extends Specification<E> {
    Path<A> getFieldPath(Root<E> paramRoot);
}
