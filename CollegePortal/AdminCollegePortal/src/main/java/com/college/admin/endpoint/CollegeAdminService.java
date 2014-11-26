package com.college.admin.endpoint;

import javax.inject.Inject;

import org.springframework.stereotype.Component;

import com.college.admin.dao.data.SimpleCall;
import com.college.admin.exception.config.CollegePortalException;
import com.college.admin.exception.model.CollegePortalErrorCodes;
import com.college.admin.manager.RegisterUser;
import com.college.admin.model.request.User;
import com.college.admin.model.response.SampleResponse;

@Component
public class CollegeAdminService implements ICollegeAdminService {

	@Inject
	private SimpleCall simpleJdbcCall;

	@Inject
	private RegisterUser registerUser;

	@Override
	public SampleResponse serviceTest() throws CollegePortalException {
		simpleJdbcCall.getCustCount();
		SampleResponse response = new SampleResponse();
		response.setResponseCode(200);
		return response;
	}

	@Override
	public User testException() throws CollegePortalException {
		User user = new User();
		user.setUserName("test");
		user.setUserPass("asf");
		return user;
	}

	@Override
	public SampleResponse addUser(User user) throws CollegePortalException {
		return registerUser.addUser(user);
	}

}
