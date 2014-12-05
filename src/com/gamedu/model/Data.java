package com.gamedu.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Data {
	private String objeto;
	private String acao;
	
	
			
	public Data() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Data(String acerto, String erro) {
		super();
		this.objeto = acerto;
		this.acao = erro;
	}
	
	public String getAcerto() {
		return objeto;
	}
	public void setAcerto(String acerto) {
		this.objeto = acerto;
	}
	public String getErro() {
		return acao;
	}
	public void setErro(String erro) {
		this.acao = erro;
	}
	
	
}
