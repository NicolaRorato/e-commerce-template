package com.nic.businesscomponent.beans;

public class Questionario {
	private long id;
	private String corso;
	private int stelle;
	private String cuoco;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getCorso() {
		return corso;
	}
	public void setCorso(String corso) {
		this.corso = corso;
	}
	public int getStelle() {
		return stelle;
	}
	public void setStelle(int stelle) {
		this.stelle = stelle;
	}
	public String getCuoco() {
		return cuoco;
	}
	public void setCuoco(String cuoco) {
		this.cuoco = cuoco;
	}
	
}
