package com.example.timesheet.controller.rest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import com.example.timesheet.model.dto.TimesheetListShowDto;
import com.example.timesheet.exception.RequestValidationException;

import com.example.timesheet.model.User;
import com.example.timesheet.repository.UserRepository;
import com.example.timesheet.service.UserService;
import com.example.timesheet.util.DateTimeUtil;
import com.example.timesheet.util.ValidationUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import com.example.timesheet.model.request.TimesheetListShowRequest;
import com.example.timesheet.model.response.ApiResponse;
import com.example.timesheet.service.DepartmentService;
import com.example.timesheet.service.TimesheetService;

@RestController
@RequestMapping(value = "/api/timesheets", produces = { MediaType.APPLICATION_JSON_VALUE })
public class TimesheetRestController {
	
	@Autowired
	private TimesheetService timesheetService;

	@Autowired
	private DepartmentService departmentService;

	@Autowired
	private UserService userService;
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private ValidationUtil validationUtil;


	// TIMESHEET LIST

	/**
	 * User
	 * 		Projects[0]
	 * 		Schedules[0]
	 * 			ScheduleApprovals
	 * 			Timesheets
	 * Department
	 * Group
	 *
	 * where schedule.month = :month
	 * 		user.departmentCode = :departmentCode
	 * 		user.groupCode = :groupCode
	 *
	 *
	 * @param request
	 * @param bindingResult
	 * @return
	 * @throws ParseException
	 */
    @RequestMapping(value = "/show", method = RequestMethod.GET)
    public ResponseEntity<ApiResponse> show(@Valid TimesheetListShowRequest request, BindingResult bindingResult) throws ParseException {
		validateTimesheetListShowRequest(bindingResult);

//    	List<TimesheetListShowDto> users = userRepository.findByQuery(searchRequest.getMonth(), searchRequest.getDepartmentCode(), searchRequest.getGroupCode());
//    	List<User> users = userService.getUsersByTimesheetListShowRequestSpec(searchRequest);

		String month = DateTimeUtil.formatDate(request.getMonth(), "yyyy/MM", "yyyy-MM");
    	List<User> users = userService.findByDepartmentAndScheduleDetails(month, request.getDepartmentCode(), request.getGroupCode());
    	ApiResponse response = ApiResponse.ApiResponseBuilder.instance().withStatus(200).withSuccess(true).withMessage(null).withData(users).build();

    	return new ResponseEntity<>(response, HttpStatus.OK);
    }

    // TIMESHEET SINGLE
	@RequestMapping(value = "/{user_id}/show", method = RequestMethod.GET)
	public ResponseEntity<ApiResponse> timesheetSingleShow(@PathVariable(value = "user_id") Long userId, @RequestParam(name = "month") String month) {
		User user = userService.getUserWithScheduleByTargetMonth(userId, month);

		ApiResponse response = ApiResponse.ApiResponseBuilder.instance()
			.withStatus(200)
			.withSuccess(true)
			.withData(user)
			.build();

		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	private void validateTimesheetListShowRequest(BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			throw new RequestValidationException("Validation exception",
					validationUtil.getErrorMessages(bindingResult),
					HttpStatus.UNPROCESSABLE_ENTITY,
					HttpStatus.UNPROCESSABLE_ENTITY.value());
		}
	}

}
