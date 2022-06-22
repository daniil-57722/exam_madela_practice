package com.dfilippov.practice.specification;

import com.dfilippov.practice.entity.OfficeEntity;
import com.dfilippov.practice.entity.UserEntity;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.Collection;

public class UserSpecification {
    public static Specification<UserEntity> createSpecification(OfficeEntity office, String firstname, String lastname, String middlename, Long docCode, Long countryId) {
        return (root, cq, cb) -> {
            final Collection<Predicate> predicates = new ArrayList<>();
            final Predicate officePredicate = cb.equal(root.get("office"), office);
            predicates.add(officePredicate);
            if(firstname!=null){
                final Predicate firstnamePredicate = cb.like(root.get("firstname"), firstname);
                predicates.add(firstnamePredicate);
            }
            if(lastname!=null){
                final Predicate lastnamePredicate = cb.like(root.get("lastname"), lastname);
                predicates.add(lastnamePredicate);
            }
            if(middlename!=null){
                final Predicate middlenamePredicate = cb.like(root.get("middlename"), middlename);
                predicates.add(middlenamePredicate);
            }
            if(docCode!=null){
                final Predicate docCodePredicate = cb.equal(root.get("docCode"), docCode);
                predicates.add(docCodePredicate);
            }
            if(countryId!=null){
                final Predicate countryIdPredicate = cb.equal(root.get("countryId"), countryId);
                predicates.add(countryIdPredicate);
            }
            return cb.and(predicates.toArray(new Predicate[predicates.size()]));
        };
    }
}
