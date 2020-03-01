package com.example.timesheet.spec;

import com.example.timesheet.model.request.TimesheetListShowRequest;
import com.example.timesheet.model.Department;
import com.example.timesheet.model.Schedule;
import com.example.timesheet.model.User;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;

public class UserSpecification {

    public static Specification<User> timesheetListShowRequestSpec(TimesheetListShowRequest showRequest) {
        return null;
//        return Specification.where(scheduleMonthEqual(showRequest.getMonth()))
//                .and(departmentCodeIsNotNullAndGroupCodeIsNull(showRequest.getDepartmentCode(), showRequest.getGroupCode()))
//                .and(departmentCodeIsNotNullAndGroupCodeIsNotNull(showRequest.getDepartmentCode(), showRequest.getGroupCode()));
    }

    private static Specification<User> scheduleMonthEqual(String month) {
        return ((root, query, criteriaBuilder) -> {
            if(month != null) {
                Join<User, Schedule> join = root.join("schedules", JoinType.INNER);
                return criteriaBuilder.equal(join.get("month"), month);
            }
            return null;
        });
    }

    private static Specification<User> departmentCodeIsNotNullAndGroupCodeIsNull(String departmentCode, String groupCode) {
        return ((root, query, criteriaBuilder) -> {
            if(departmentCode != null && groupCode == null) {
                criteriaBuilder.equal(root.get("departmentCode"), departmentCode);
                Join<User, Department> join = root.join("department", JoinType.INNER);
                return criteriaBuilder.equal(join.get("code"), departmentCode);
            }
            return null;
        });
    }

    private static Specification<User> departmentCodeIsNotNullAndGroupCodeIsNotNull(String departmentCode, String groupCode) {
        return ((root, query, criteriaBuilder) -> {
            if(departmentCode != null && groupCode != null) {
                criteriaBuilder.equal(root.get("departmentCode"), departmentCode);
                criteriaBuilder.equal(root.get("groupCode"), groupCode);
                Join<User, Department> join = root.join("group", JoinType.INNER);
                criteriaBuilder.equal(join.get("code"), groupCode);
                return criteriaBuilder.equal(join.get("parentCode"), departmentCode);
            }
            return null;
        });
    }
}
