package com.college.admin.model.response;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement
@XmlType
@XmlAccessorType(XmlAccessType.NONE)
public class SampleResponse {
	@XmlElement
	private int sample;

	public int getSample() {
		return sample;
	}

	public void setSample(int sample) {
		this.sample = sample;
	}
	
	

}
