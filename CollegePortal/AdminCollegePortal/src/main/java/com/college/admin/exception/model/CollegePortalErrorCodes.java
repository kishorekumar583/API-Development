package com.college.admin.exception.model;

public enum CollegePortalErrorCodes {

	DATABASE_EXCEPTION("INPUT", "DB_EXCEPTION", "Database connection exception"),
	INTERNAL_ERROR("INPUT", "DB_EXCEPTION", "Database connection exception"),
	DUPLICATE_KEY_EXCEPTION("INPUT", "DB_EXCEPTION", "Duplicate key userid already exist");

	private String source;
	private String reasoncode;
	private String description;

	private CollegePortalErrorCodes(String source, String reasoncode, String description) {
		this.source = source;
		this.reasoncode = reasoncode;
		this.description = description;
	}

	public String getSource() {
		return source;
	}

	public String getReasoncode() {
		return reasoncode;
	}

	public String getDescription() {
		return description;
	}

}
