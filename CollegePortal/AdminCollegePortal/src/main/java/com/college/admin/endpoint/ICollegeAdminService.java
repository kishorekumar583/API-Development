package com.college.admin.endpoint;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.springframework.stereotype.Component;

import com.college.admin.exception.config.CollegePortalException;
import com.college.admin.model.response.SampleResponse;

@Component
@Path("/")
@Produces({ "application/xml", "application/json" })
@Consumes({ "application/xml", "application/json" })
public interface ICollegeAdminService {

	@GET
	@Path("/service")
	public SampleResponse serviceTest();

	@GET
	@Path("/exception")
	public SampleResponse testException() throws CollegePortalException;
}
