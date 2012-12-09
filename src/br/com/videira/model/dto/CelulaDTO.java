package br.com.videira.model.dto;

import java.sql.Date;


public class CelulaDTO{
	
	private Integer id;
	private String titulo;
	private Date dataInicio;
	private Date dataMultiplicacao;
	private int pastorID;
	private int discipuladorID;
	private int liderID;
	private int anfitriaoID;
	private String diaCelula;
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
	 * @return the titulo
	 */
	public String getTitulo() {
		return titulo;
	}
	/**
	 * @param titulo the titulo to set
	 */
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	/**
	 * @return the dataInicio
	 */
	public Date getDataInicio() {
		return dataInicio;
	}
	/**
	 * @param dataInicio the dataInicio to set
	 */
	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}
	/**
	 * @return the dataMultiplicacao
	 */
	public Date getDataMultiplicacao() {
		return dataMultiplicacao;
	}
	/**
	 * @param dataMultiplicacao the dataMultiplicacao to set
	 */
	public void setDataMultiplicacao(Date dataMultiplicacao) {
		this.dataMultiplicacao = dataMultiplicacao;
	}
	/**
	 * @return the pastorID
	 */
	public int getPastorID() {
		return pastorID;
	}
	/**
	 * @param pastorID the pastorID to set
	 */
	public void setPastorID(int pastorID) {
		this.pastorID = pastorID;
	}
	/**
	 * @return the discipuladorID
	 */
	public int getDiscipuladorID() {
		return discipuladorID;
	}
	/**
	 * @param discipuladorID the discipuladorID to set
	 */
	public void setDiscipuladorID(int discipuladorID) {
		this.discipuladorID = discipuladorID;
	}
	/**
	 * @return the liderID
	 */
	public int getLiderID() {
		return liderID;
	}
	/**
	 * @param liderID the liderID to set
	 */
	public void setLiderID(int liderID) {
		this.liderID = liderID;
	}
	/**
	 * @return the anfitriaoID
	 */
	public int getAnfitriaoID() {
		return anfitriaoID;
	}
	/**
	 * @param anfitriaoID the anfitriaoID to set
	 */
	public void setAnfitriaoID(int anfitriaoID) {
		this.anfitriaoID = anfitriaoID;
	}
	/**
	 * @return the diaCelula
	 */
	public String getDiaCelula() {
		return diaCelula;
	}
	/**
	 * @param diaCelula the diaCelula to set
	 */
	public void setDiaCelula(String diaCelula) {
		this.diaCelula = diaCelula;
	}

	
}
