package com.example.timesheet.repository;

import com.example.timesheet.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long>, CrudRepository<User, Long>, JpaSpecificationExecutor<User> {

	@Query("select u from User u")
	Page<User> findUserWithPagination(Pageable page);
	
	Optional<User> findByUsername(String username);

	Boolean existsByUsername(String username);

    Boolean existsByEmail(String email);

    @Query(
		"select u from User u join fetch u.schedules s " +
		"where (:departmentCode is null or :departmentCode='' or u.departmentCode=:departmentCode) and (:groupCode is null or :groupCode='' or u.groupCode=:groupCode) and s.month=:month and u.excludedType is null and u.deletedAt is null"
	)
    Optional<List<User>> findByDepartmentAndScheduleDetails(@Param("month") String month, @Param("departmentCode") String departmentCode, @Param("groupCode") String groupCode);
}
