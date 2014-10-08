package com.college.admin.endpoint;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.springframework.stereotype.Component;

import com.college.admin.model.response.SampleResponse;

@Component
@Path("/")
@Produces({ "application/xml", "application/json" })
@Consumes({ "application/xml", "application/json" })
public class CollegeAdminService {

	@GET
	@Path("/service")
	public SampleResponse serviceTest() {
		SampleResponse response = new SampleResponse();
		response.setSample(200);
		return response;
	}

}
