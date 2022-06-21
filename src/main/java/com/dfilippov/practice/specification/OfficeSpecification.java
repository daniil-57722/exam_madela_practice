package com.dfilippov.practice.specification;

import com.dfilippov.practice.entity.OfficeEntity;
import com.dfilippov.practice.entity.OrganizationEntity;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.Collection;

public class OfficeSpecification {

    public static Specification<OfficeEntity> createSpecification(Long organization, String name, String phone, Boolean isActive){
        return (root, cq, cb) -> {
            final Collection<Predicate> predicates = new ArrayList<>();
            final Predicate orgPredicate = cb.equal(root.get("organization").get("id"),  organization);
            predicates.add(orgPredicate);
            if(name!=null){
                final Predicate innPredicate = cb.like(root.get("name"), "%"+name+"%");
                predicates.add(innPredicate);
            }
            if(phone!=null){
                final Predicate isActivePredicate = cb.equal(root.get("phone"), phone);
                predicates.add(isActivePredicate);
            }
            if(isActive!=null){
                final Predicate isActivePredicate = cb.equal(root.get("isActive"), isActive);
                predicates.add(isActivePredicate);
            }
            return cb.and(predicates.toArray(new Predicate[predicates.size()]));
        };
    }
}
