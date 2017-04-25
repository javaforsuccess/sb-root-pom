package org.pratap.ws.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity
public class OsDetails {
	
	@Id
	@GeneratedValue
	private Long seqNo;
	private String regNo;
	private String osArchitecture;
	private int noOfProcessorsAvailable;
	private String osName;
	private double sysLoadAverage;
	private String osVersion;
	
	
	public OsDetails() {
		// TODO Auto-generated constructor stub
	}
	
	public OsDetails(String regNo, String osArchitecture, int noOfProcessorsAvailable, String osName,
			double sysLoadAverage, String osVersion) {
		super();
		this.regNo = regNo;
		this.osArchitecture = osArchitecture;
		this.noOfProcessorsAvailable = noOfProcessorsAvailable;
		this.osName = osName;
		this.sysLoadAverage = sysLoadAverage;
		this.osVersion = osVersion;
	}
	
	
	public Long getSeqNo() {
		return seqNo;
	}

	public void setSeqNo(Long seqNo) {
		this.seqNo = seqNo;
	}

	public String getRegNo() {
		return regNo;
	}
	public void setRegNo(String regNo) {
		this.regNo = regNo;
	}
	public String getOsArchitecture() {
		return osArchitecture;
	}
	public void setOsArchitecture(String osArchitecture) {
		this.osArchitecture = osArchitecture;
	}
	public int getNoOfProcessorsAvailable() {
		return noOfProcessorsAvailable;
	}
	public void setNoOfProcessorsAvailable(int noOfProcessorsAvailable) {
		this.noOfProcessorsAvailable = noOfProcessorsAvailable;
	}
	public String getOsName() {
		return osName;
	}
	public void setOsName(String osName) {
		this.osName = osName;
	}
	public double getSysLoadAverage() {
		return sysLoadAverage;
	}
	public void setSysLoadAverage(double sysLoadAverage) {
		this.sysLoadAverage = sysLoadAverage;
	}
	public String getOsVersion() {
		return osVersion;
	}
	public void setOsVersion(String osVersion) {
		this.osVersion = osVersion;
	}

}
