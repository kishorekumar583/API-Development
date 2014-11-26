package com.college.admin.dao.data;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Component;

import com.college.admin.exception.config.CollegePortalException;
import com.college.admin.exception.model.CollegePortalErrorCodes;

@Component
public class SimpleCall extends BaseDao {

	public int getCustCount() throws CollegePortalException {
		String sql = "select count(*) from CUST";
		MapSqlParameterSource params = new MapSqlParameterSource();
		int i = 0;
		try {
			i = fetchObject(sql, params, Integer.class);
		} catch (Exception e) {
			throw new CollegePortalException(CollegePortalErrorCodes.DATABASE_EXCEPTION);
		}
		return i;
	}

}
