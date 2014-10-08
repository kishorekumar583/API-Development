package com.college.admin.endpoint;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.springframework.stereotype.Component;

@Component
@Path("/")
@Produces({"application/xml", "application/json"})
public class CollegeAdminService {
	
	@GET
	@Path("/service")
	public int serviceTest(){
		return 200;
	}

}
