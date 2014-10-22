package com.college.admin.endpoint;

import org.springframework.stereotype.Component;

import com.college.admin.exception.config.CollegePortalException;
import com.college.admin.exception.model.CollegePortalErrorCodes;
import com.college.admin.model.response.SampleResponse;

@Component
public class CollegeAdminService implements ICollegeAdminService {

	@Override
	public SampleResponse serviceTest() {
		SampleResponse response = new SampleResponse();
		response.setSample(200);
		return response;
	}

	@Override
	public SampleResponse testException() throws CollegePortalException {
		throw new CollegePortalException(CollegePortalErrorCodes.DATABASE_EXCEPTION);
	}

}
