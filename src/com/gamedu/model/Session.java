package com.gamedu.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Session {
	private Date timeStamp;
	private int userId;
	private int gameId;
	private int sessionid;
	private int type;
	private int aulaId;
	private List<String> fixedNumbers; 
	private List<String> missingNumbers;	
	
	public Session() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Session(int sessionid, int aulaId, int gameId, int userId,   int type) {
		super();
		this.timeStamp = new Date();
		this.userId = userId;
		this.gameId = gameId;
		this.sessionid = sessionid;
		this.type = type;
		this.aulaId = aulaId;
		this.fixedNumbers = new ArrayList<String>();
		this.missingNumbers = new ArrayList<String>();
		
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

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public List<String> getFixedNumbers() {
		return fixedNumbers;
	}

	public void setFixedNumbers(List<String> fixedNumbers) {
		this.fixedNumbers = fixedNumbers;
	}

	public List<String> getMissingNumbers() {
		return missingNumbers;
	}

	public void setMissingNumbers(List<String> missingNumbers) {
		this.missingNumbers = missingNumbers;
	}

	public int getAulaId() {
		return aulaId;
	}

	public void setAulaId(int aulaId) {
		this.aulaId = aulaId;
	}
	
	
	
	
	
	
}
