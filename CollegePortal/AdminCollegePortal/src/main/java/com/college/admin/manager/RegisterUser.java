package com.college.admin.manager;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

import javax.inject.Inject;

import org.springframework.stereotype.Component;

import com.college.admin.dao.data.CreateUserDao;
import com.college.admin.exception.config.CollegePortalException;
import com.college.admin.exception.model.CollegePortalErrorCodes;
import com.college.admin.model.request.User;
import com.college.admin.model.response.SampleResponse;

@Component
public class RegisterUser {

	@Inject
	private CreateUserDao createUserDao;
	private static final int SUCCESS_CODE = 200;
	private static final String SALT_LABEL="ki$$u$sdASDF434#SAFASF34WERNMSDAOI394@$@4&#%^$*";

	public SampleResponse addUser(User user) throws CollegePortalException {
		updatePassword(user);
		int customerId = createUserDao.registerUser(user);
		SampleResponse response = new SampleResponse();
		response.setCustomerId(customerId);
		response.setResponseCode(SUCCESS_CODE);
		return response;
	}

	private static void updatePassword(User user) throws CollegePortalException {
		StringBuilder sb;
		try {
			MessageDigest md = MessageDigest.getInstance("SHA-1");
			md.update(SALT_LABEL.getBytes());
			byte[] bytes = md.digest(user.getUserPass().getBytes());
			sb = new StringBuilder();
			for (int i = 0; i < bytes.length; i++) {
				sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
			}
		} catch (NoSuchAlgorithmException e) {
			throw new CollegePortalException(CollegePortalErrorCodes.INTERNAL_ERROR);
		}
		user.setUserPass(sb.toString());
	}

}
