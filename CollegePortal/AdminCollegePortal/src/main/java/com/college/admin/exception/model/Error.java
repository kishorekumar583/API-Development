package com.college.admin.exception.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(propOrder = { "source", "reasonCode", "description" })
@XmlAccessorType(XmlAccessType.NONE)
public class Error {
	@XmlElement(name = "source")
	private String source;
	@XmlElement(name = "reasoncode")
	private String reasonCode;
	@XmlElement(name = "description")
	private String description;

	public Error() {

	}

	public Error(String source, String reasonCode, String description) {
		this.source = source;
		this.reasonCode = reasonCode;
		this.description = description;
	}

	public Error(CollegePortalErrorCodes collegePortalErrorCodes) {
		this.source = collegePortalErrorCodes.getSource();
		this.reasonCode = collegePortalErrorCodes.getReasoncode();
		this.description = collegePortalErrorCodes.getDescription();
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getReasonCode() {
		return reasonCode;
	}

	public void setReasonCode(String reasonCode) {
		this.reasonCode = reasonCode;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
