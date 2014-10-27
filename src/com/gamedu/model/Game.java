package com.gamedu.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Game {
	private String nome;
	private int gameId;
		
	public Game() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Game(String nome, int gameId) {
		super();
		this.nome = nome;
		this.gameId = gameId;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getId() {
		return gameId;
	}
	public void setId(int id) {
		this.gameId = id;
	}
	
	

}
