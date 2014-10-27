package com.gamedu.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ActionSession {
	private Date timeStamp;
	private int userId;
	private int gameId;
	private int sessionid;
	private int type;
	private List<Data> listData;	
	
	
	
	public ActionSession() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ActionSession(int sessionid, int gameId, int userId,  int type) {
		super();
		this.timeStamp = new Date();
		this.userId = userId;
		this.gameId = gameId;
		this.sessionid = sessionid;
		this.type = type;
		this.listData = new ArrayList<Data>();
	}
	
	
	public Date getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(Date timeStamp) {
		this.timeStamp = timeStamp;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getGameId() {
		return gameId;
	}
	public void setGameId(int gameId) {
		this.gameId = gameId;
	}
	public int getSessionid() {
		return sessionid;
	}
	public void setSessionid(int sessionid) {
		this.sessionid = sessionid;
	}
	public int isType() {
		return type;
	}
	public List<Data> getListData() {
		return listData;
	}
	public void setListData(List<Data> listData) {
		this.listData = listData;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	
	
	
}
