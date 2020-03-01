package com.example.timesheet.mapper;

import java.util.List;

import com.example.timesheet.model.request.UserSearchRequest;
import org.apache.ibatis.annotations.Mapper;

import com.example.timesheet.model.User;

@Mapper
public interface UserMapper {
	List<User> findAll();

	List<User> search(UserSearchRequest searchRequest);
	
	User findOne(Long id);
	
//	void save(User user);
//
//	void update(User use);
//
//	void delete(Long id);
}
