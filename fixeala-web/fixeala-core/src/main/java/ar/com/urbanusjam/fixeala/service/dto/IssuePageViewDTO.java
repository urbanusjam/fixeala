package ar.com.urbanusjam.fixeala.service.dto;

import java.io.Serializable;

public class IssuePageViewDTO extends IssueMainActionDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private String ipAddress;

	public String getIpAddress() {
		return ipAddress;
	}

	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

}
