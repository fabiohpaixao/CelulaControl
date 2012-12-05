package br.com.videira.model;

import java.sql.Date;

public class Frequencia {
	
	private Integer id;
	private Integer membroID;
	private String evento;
	private Date data;
	private Integer presente;
	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * @return the membroID
	 */
	public Integer getMembroID() {
		return membroID;
	}
	/**
	 * @param membroID the membroID to set
	 */
	public void setMembroID(Integer membroID) {
		this.membroID = membroID;
	}
	/**
	 * @return the evento
	 */
	public String getEvento() {
		return evento;
	}
	/**
	 * @param evento the evento to set
	 */
	public void setEvento(String evento) {
		this.evento = evento;
	}
	/**
	 * @return the data
	 */
	public Date getData() {
		return data;
	}
	/**
	 * @param data the data to set
	 */
	public void setData(Date data) {
		this.data = data;
	}
	/**
	 * @return the presente
	 */
	public Integer getPresente() {
		return presente;
	}
	/**
	 * @param presente the presente to set
	 */
	public void setPresente(Integer presente) {
		this.presente = presente;
	}
	
	

}
