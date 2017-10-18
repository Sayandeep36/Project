package com.human_resources.model;

import java.io.Serializable;

public class FeedbackInfo implements Serializable{
	
	private String uid;

	public FeedbackInfo()
	{
		
	}

	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	private String query;
	public String getQuery() {
		return query;
	}
	public void setQuery(String query) {
		this.query = query;
	}
	public String getReply() {
		return reply;
	}
	public void setReply(String reply) {
		this.reply = reply;
	}
	private String reply;

	

}
