package com.human_resources.model;

import java.io.Serializable;

public class DesigInfo implements Serializable
{
	private String did;
	private String dname;
	private String salary;
	private String cl;
	private String pl;
	
	
	public DesigInfo()
	{}
	public String getDid() {
		return did;
	}

	public void setDid(String did) {
		this.did = did;
	}
	
	public String getDname() {
		return dname;
	}

	public void setDname(String dname) {
		this.dname = dname;
	}

	public String getSalary() {
		return salary;
	}

	public void setSalary(String salary) {
		this.salary = salary;
	}

	public String getCl() {
		return cl;
	}

	public void setCl(String cl) {
		this.cl = cl;
	}

	public String getPl() {
		return pl;
	}

	public void setPl(String pl) {
		this.pl = pl;
	}

	
	
}
