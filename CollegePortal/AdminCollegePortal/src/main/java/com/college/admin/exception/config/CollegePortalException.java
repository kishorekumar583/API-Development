package com.college.admin.exception.config;

import com.college.admin.exception.model.CollegePortalErrorCodes;
import com.college.admin.exception.model.Error;
import com.college.admin.exception.model.Errors;

public class CollegePortalException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Errors errors;

	public CollegePortalException() {

	}

	public CollegePortalException(String source, String reasonCode, String description, Throwable cause) {
		super(cause);
		this.errors = new Errors();
		errors.addError(new Error(source, reasonCode, description));
	}

	public CollegePortalException(String source, String reasonCode, String description) {
		this.errors = new Errors();
		errors.addError(new Error(source, reasonCode, description));
	}

	public CollegePortalException(CollegePortalErrorCodes colleportalErrorCodes) {
		this.errors = new Errors();
		errors.addError(new Error(colleportalErrorCodes));
	}

	public Errors getErrors() {
		return errors;
	}

}
