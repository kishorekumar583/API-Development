package com.college.admin.dao.data;

import org.springframework.dao.DataAccessException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.college.admin.exception.config.CollegePortalException;
import com.college.admin.exception.model.CollegePortalErrorCodes;
import com.college.admin.model.request.User;

@Repository
public class CreateUserDao extends BaseDao {

	private static final String SEQ_NAME = "user_id_seq";
	private static final int USER_LEVEL = 1;

	public int registerUser(User user) throws CollegePortalException {
		String sql = "Insert into users (user_id,user_name,user_pass,user_email,user_date,user_level) values"
				+ "(nextVal(:seqName),:userName,:userPass,:userEmail,CURRENT_TIMESTAMP,:userLevel)";
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("seqName", SEQ_NAME);
		params.addValue("userName", user.getUserName());
		params.addValue("userPass", user.getUserPass());
		params.addValue("userEmail", user.getUserEmailAddress());
		params.addValue("userLevel", USER_LEVEL);
		KeyHolder keyHolder = new GeneratedKeyHolder();
		try {
			insertObject(sql, params, keyHolder, new String[] { "user_id" });
		} catch (DuplicateKeyException e) {
			throw new CollegePortalException(CollegePortalErrorCodes.DUPLICATE_KEY_EXCEPTION);
		} catch (DataAccessException e) {

			throw new CollegePortalException(CollegePortalErrorCodes.DATABASE_EXCEPTION);
			// TODO: handle exception
		}

		return keyHolder.getKey().intValue();
	}

}

// Insert into users
// (user_id,user_name,user_pass,user_email,user_date,user_level)
// values(nextVal('user_id_seq'),'Kittu','test','kittu@gmail.com','2014-12-12
// 00:00:00',23)
