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

	public String getCliente() {
		return cliente;
	}


	public void setCliente(String cliente) {
		this.cliente = cliente;
	}


	public String getEstabelecimento() {
		return estabelecimento;
	}


	public void setEstabelecimento(String estabelecimento) {
		this.estabelecimento = estabelecimento;
	}

	@Override
	public String toString() {
		return "Cliente: " + getCliente() + " Estabelecimento: " + getEstabelecimento();
	}

}

