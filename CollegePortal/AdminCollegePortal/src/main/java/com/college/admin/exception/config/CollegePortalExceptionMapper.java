package com.college.admin.exception.config;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class CollegePortalExceptionMapper implements ExceptionMapper<CollegePortalException> {

	public Response toResponse(CollegePortalException exception) {

		return Response.status(Status.BAD_REQUEST).entity(exception.getErrors()).build();
	}

}
