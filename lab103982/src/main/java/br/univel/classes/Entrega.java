package br.univel.classes;


import java.io.Serializable;

public class Entrega implements Serializable {

	
	private static final long serialVersionUID = 8634568426273358268L;
	/**
	 *
	 */
	

	private String cliente;
	private String estabelecimento;

	public Entrega() {

	}


	public String getComprador() {
		return cliente;
	}
	public void setComprador(String comprador) {
		this.cliente = comprador;
	}

	public String getLocal() {
		return estabelecimento;
	}
	public void setLocal(String local) {
		this.estabelecimento = local;
	}



}

