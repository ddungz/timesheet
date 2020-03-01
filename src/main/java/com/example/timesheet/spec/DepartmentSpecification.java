package com.example.timesheet.spec;

import com.example.timesheet.model.Department;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class DepartmentSpecification implements Specification<Department> {

    public static Specification<Department> isDepartment() {
        return (root, query, criteria) -> {
            return criteria.isNull(root.get("parent_code"));
        };
    }

    @Override
    public Specification<Department> and(Specification<Department> other) {
        return null;
    }

    @Override
    public Specification<Department> or(Specification<Department> other) {
        return null;
    }

    @Override
    public Predicate toPredicate(Root<Department> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        return null;
    }
}
