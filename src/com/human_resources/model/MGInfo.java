package com.human_resources.model;

import java.io.Serializable;

public class MGInfo implements Serializable{ 
        private String mgid;
        private String mgpass;
        private String mgname;
        private String mgdob;
        private String mggender;
        private String mgphn;
        private String mgsalary;
               
	
	
	public MGInfo(){
		
	}

	public String getMgdob() {
		return mgdob;
	}

	public void setMgdob(String mgdob) {
		this.mgdob = mgdob;
	}

	public String getMggender() {
		return mggender;
	}

	public void setMggender(String mggender) {
		this.mggender = mggender;
	}

	public String getMgphn() {
		return mgphn;
	}

	public void setMgphn(String mgphn) {
		this.mgphn = mgphn;
	}

	public String getMgsalary() {
		return mgsalary;
	}

	public void setMgsalary(String mgsalary) {
		this.mgsalary = mgsalary;
	}

	public String getMgid() {
		return mgid;
	}

	public void setMgid(String mgid) {
		this.mgid = mgid;
	}

	public String getMgname() {
		return mgname;
	}

	public void setMgname(String mgname) {
		this.mgname = mgname;
	}

	public String getMgpass() {
		return mgpass;
	}

	public void setMgpass(String mgpass) {
		this.mgpass = mgpass;
	}
	
}
