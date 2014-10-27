package com.gamedu.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Data {
	private String objeto;
	private String valor;
	
	
			
	public Data() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Data(String acerto, String erro) {
		super();
		this.objeto = acerto;
		this.valor = erro;
	}
	
	public String getAcerto() {
		return objeto;
	}
	public void setAcerto(String acerto) {
		this.objeto = acerto;
	}
	public String getErro() {
		return valor;
	}
	public void setErro(String erro) {
		this.valor = erro;
	}
	
	
}
