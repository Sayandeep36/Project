package com.human_resources.model;

import java.io.Serializable;

public class HRInfo implements Serializable{ 
        private String hrid;
        private String hrpass;
        private String hrname;
        private String hrdob;
        private String hrgender;
        private String hrphn;
        private String hrsalary;
	
	public HRInfo(){
		
	}

	public String getHrid() {
		return hrid;
	}

	public void setHrid(String hrid) {
		this.hrid = hrid;
	}

	public String getHrpass() {
		return hrpass;
	}

	public void setHrpass(String hrpass) {
		this.hrpass = hrpass;
	}

	public String getHrname() {
		return hrname;
	}

	public void setHrname(String hrname) {
		this.hrname = hrname;
	}

	public String getHrdob() {
		return hrdob;
	}

	public void setHrdob(String hrdob) {
		this.hrdob = hrdob;
	}

	public String getHrgender() {
		return hrgender;
	}

	public void setHrgender(String hrgender) {
		this.hrgender = hrgender;
	}

	public String getHrphn() {
		return hrphn;
	}

	public void setHrphn(String hrphn) {
		this.hrphn = hrphn;
	}

	public String getHrsalary() {
		return hrsalary;
	}

	public void setHrsalary(String hrsalary) {
		this.hrsalary = hrsalary;
	}
	
}
