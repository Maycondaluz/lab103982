package br.univel.classes;


import java.io.Serializable;
import java.util.List;


public class Venda implements Serializable {


	/**
	 *
	 */
	private static final long serialVersionUID = -6460384875040593227L;

	private List<String> item;
    private int volume;

	public List<String> getItem() {
		return item;
	}
	public void setItem(List<String> item) {
		this.item = item;
	}
	public int getVolume() {
		return volume;
	}
	public void setVolume(int volume) {
		this.volume = volume;
	}

	@Override
	public String toString() {
		return "Item: " + getItem() + " Volume: " + getVolume();
	}





}
