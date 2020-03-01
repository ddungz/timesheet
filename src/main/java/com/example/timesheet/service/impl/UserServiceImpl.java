package com.example.timesheet.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.example.timesheet.model.request.TimesheetListShowRequest;
import com.example.timesheet.model.Schedule;
import com.example.timesheet.service.ProjectService;
import com.example.timesheet.service.ScheduleService;
import com.example.timesheet.spec.UserSpecification;
import lombok.RequiredArgsConstructor;
import org.apache.log4j.Logger;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.timesheet.auth.jwt.JwtProvider;
import com.example.timesheet.exception.ApiException;
//import com.example.smoke.model.Role;
import com.example.timesheet.model.User;
import com.example.timesheet.model.request.UserSearchRequest;
import com.example.timesheet.model.response.ApiResponse;
import com.example.timesheet.repository.UserRepository;
import com.example.timesheet.service.UserService;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

	private static final Logger logger = Logger.getLogger(UserServiceImpl.class);

	private final AuthenticationManager authenticationManager;

	private final PasswordEncoder encoder;

	private final JwtProvider tokenProvider;

	private final UserRepository userRepository;

	private final ProjectService projectService;

	private final ScheduleService scheduleService;


	@Override
	public Optional<User> findById(Long id) {
		return userRepository.findById(id);
	}

	@Override
	public User getOne(Long id) {
		return userRepository.getOne(id);
	}


	@Override
	public List<User> findByDepartmentAndScheduleDetails(String month, String departmentCode, String groupCode) {
		List<User> users = new ArrayList<>();
		Optional<List<User>> usersOptional = userRepository.findByDepartmentAndScheduleDetails(month, departmentCode, groupCode);
		usersOptional.ifPresent(u -> users.addAll(u));
		return users;
	}

	public List<User> getUsersByTimesheetListShowRequestSpec(TimesheetListShowRequest showRequest) {
		UserSpecification specification = new UserSpecification();
		List<User> users = userRepository.findAll(specification.timesheetListShowRequestSpec(showRequest));
		return users;
	}

	public User getOneWithTargetSchedule(Long id, String month) {
		Optional<User> userOptional = this.findById(id).map(user -> {
			Optional<Schedule> schedule = scheduleService.findByUserIdAndMonth(id, month);

			return user;
		});
		return userOptional.get();
	}

	@Override
	public User getUserWithScheduleByTargetMonth(Long id, String month) {
		Optional<User> userOptional = this.findById(id);
		userOptional.ifPresent(user -> {
			Optional<Schedule> schedules = scheduleService.findByUserIdAndMonth(id, month);
			schedules.ifPresent(sch -> user.getSchedules().add(schedules.get()));
		});
		userOptional.orElseThrow(() -> new ApiException("User time sheet not found with userID" + id + " and month " + month, HttpStatus.NOT_FOUND));
		return userOptional.get();
	}

	@Override
	public Page<User> getUserWithPagination(Pageable page) {
		return userRepository.findUserWithPagination(page);
	}

	@Override
	public User getUser(Long id) {
		return userRepository.findById(id).orElseThrow(() ->
			new ApiException("User ID " + id + " was not found", HttpStatus.NOT_FOUND)
		);
	}

	@Override
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	@Override
	public List<User> search(UserSearchRequest searchRequest) {
		try {
//			return userMapper.search(searchRequest);
			return null;
		} catch (Exception e) {
			throw new ApiException(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@Override
	public ResponseEntity<?> getUserDetails(String authHeader) {
		try {
			String token = null;
			String username = null;

			if (authHeader != null && authHeader.startsWith("Bearer ")) {
				token = authHeader.replace("Bearer ", "");
			}
			token = "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhc2FoaW5ha2EiLCJpYXQiOjE1Nzk2ODMwMTgsImV4cCI6MTU3OTc2OTQxOH0.H8fpCEaJD0pLG7aNxRZx70mnDp71viL-NJYt1WmjV1vMzm5WRLvkKPDVpNMLAGCPKwsvhCYVzUQZCGp11ZcHWw";
			if (token != null && tokenProvider.validateJwtToken(token)) {
				username = tokenProvider.getUserNameFromJwtToken(token);
			}

			Optional<User> user = userRepository.findByUsername(username);
			if (!user.isPresent())
				throw new ApiException("User not found", HttpStatus.BAD_REQUEST);

			ApiResponse<User> response = ApiResponse.ApiResponseBuilder.instance().withStatus(200).withMessage("ok")
					.withSuccess(true).withData(user).build();

			return new ResponseEntity<>(response, HttpStatus.OK);
		} catch (Exception ex) {
			logger.error("ERROR = " + ex.getMessage(), ex);
			ApiResponse<User> response = ApiResponse.ApiResponseBuilder.instance()
					.withStatus(HttpStatus.BAD_REQUEST.value()).withMessage("User not found").withSuccess(false).build();
			return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
		}
	}

//	@Override
//	public User findByIdAndSchedulesMonth(Long id, String month) {
//		return userRepository.findByIdAndSchedulesMonth(id, month).orElseThrow(() -> new ApiException("User " + "does not reported for ", HttpStatus.NOT_FOUND));
//	}
}
