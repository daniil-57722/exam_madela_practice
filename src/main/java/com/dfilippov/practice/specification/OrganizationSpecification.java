package com.dfilippov.practice.specification;

import com.dfilippov.practice.entity.OrganizationEntity;
import com.dfilippov.practice.repository.OrganizationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.Collection;

public class OrganizationSpecification {
    @Autowired
    OrganizationRepository organizationRepository;

    public static Specification<OrganizationEntity> createSpecification(String name, String inn, Boolean isActive){
        return (root, cq, cb) -> {
            final Collection<Predicate> predicates = new ArrayList<>();
            final Predicate namePredicate = cb.like(root.get("name"), "%" + name + "%");
            predicates.add(namePredicate);
            if(inn!=null){
                final Predicate innPredicate = cb.like(root.get("inn"), inn);
                predicates.add(innPredicate);
            }
            if(isActive!=null){
                final Predicate isActivePredicate = cb.equal(root.get("isActive"), isActive);
                predicates.add(isActivePredicate);
            }
            return cb.and(predicates.toArray(new Predicate[predicates.size()]));
        };
    }
}
