package com.gamedu.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Aula {
	private Date timeStamp;
	private int aulaId;
	private int gameId;
	private List<Person> alunosList;
	
	public Aula() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Aula(int aulaId, int gameId, Date timeStamp, List<Person> alunosList) {
		super();
		this.timeStamp = timeStamp;
		this.aulaId = aulaId;
		this.gameId = gameId;
		this.alunosList = alunosList;
	}
	
	public Date getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(Date timeStamp) {
		this.timeStamp = timeStamp;
	}
	public int getAulaId() {
		return aulaId;
	}
	public void setAulaId(int aulaId) {
		this.aulaId = aulaId;
	}
	public int getGameId() {
		return gameId;
	}
	public void setGameId(int gameId) {
		this.gameId = gameId;
	}
	public List<Person> getAlunosList() {
		return alunosList;
	}
	public void setAlunosList(List<Person> alunosList) {
		this.alunosList = alunosList;
	} 
	
	
	


	
	
	
	
	
	
	
}
