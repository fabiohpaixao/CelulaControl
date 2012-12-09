package br.com.videira.model.dto;

import java.sql.Date;

public class MembroDTO {
	
	private int id;
	private String nome;
	private String telefoneRes;
	private String telefoneCel1;
	private String telefoneCel2;
	private String telefoneCom;
	private String email;
	private Date dataNascimento;
	private Integer funcaoID;
	private Integer encontro;
	private Integer cursao;
	private Integer batismo;
	private Integer ctl;
	private Integer consolidacao;
	private Integer consolidadorID;
	private Date dataSaida;
	private String motivoSaida;
	private String cep;
	private String rua;
	private String bairro;
	private String cidade;
	private String estado;
	private Integer numero;
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}
	/**
	 * @param nome the nome to set
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}
	/**
	 * @return the telefoneRes
	 */
	public String getTelefoneRes() {
		return telefoneRes;
	}
	/**
	 * @param telefoneRes the telefoneRes to set
	 */
	public void setTelefoneRes(String telefoneRes) {
		this.telefoneRes = telefoneRes;
	}
	/**
	 * @return the telefoneCel1
	 */
	public String getTelefoneCel1() {
		return telefoneCel1;
	}
	/**
	 * @param telefoneCel1 the telefoneCel1 to set
	 */
	public void setTelefoneCel1(String telefoneCel1) {
		this.telefoneCel1 = telefoneCel1;
	}
	/**
	 * @return the telefoneCel2
	 */
	public String getTelefoneCel2() {
		return telefoneCel2;
	}
	/**
	 * @param telefoneCel2 the telefoneCel2 to set
	 */
	public void setTelefoneCel2(String telefoneCel2) {
		this.telefoneCel2 = telefoneCel2;
	}
	/**
	 * @return the telefoneCom
	 */
	public String getTelefoneCom() {
		return telefoneCom;
	}
	/**
	 * @param telefoneCom the telefoneCom to set
	 */
	public void setTelefoneCom(String telefoneCom) {
		this.telefoneCom = telefoneCom;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @return the dataNascimento
	 */
	public Date getDataNascimento() {
		return dataNascimento;
	}
	/**
	 * @param dataNascimento the dataNascimento to set
	 */
	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	/**
	 * @return the funcaoID
	 */
	public int getFuncaoID() {
		return funcaoID;
	}
	/**
	 * @param funcaoID the funcaoID to set
	 */
	public void setFuncaoID(int funcaoID) {
		this.funcaoID = funcaoID;
	}
	/**
	 * @return the encontro
	 */
	public int getEncontro() {
		return encontro;
	}
	/**
	 * @param encontro the encontro to set
	 */
	public void setEncontro(int encontro) {
		this.encontro = encontro;
	}
	/**
	 * @return the cursao
	 */
	public int getCursao() {
		return cursao;
	}
	/**
	 * @param cursao the cursao to set
	 */
	public void setCursao(int cursao) {
		this.cursao = cursao;
	}
	/**
	 * @return the batismo
	 */
	public int getBatismo() {
		return batismo;
	}
	/**
	 * @param batismo the batismo to set
	 */
	public void setBatismo(int batismo) {
		this.batismo = batismo;
	}
	/**
	 * @return the ctl
	 */
	public int getCtl() {
		return ctl;
	}
	/**
	 * @param ctl the ctl to set
	 */
	public void setCtl(int ctl) {
		this.ctl = ctl;
	}
	/**
	 * @return the consolidacao
	 */
	public int getConsolidacao() {
		return consolidacao;
	}
	/**
	 * @param consolidacao the consolidacao to set
	 */
	public void setConsolidacao(int consolidacao) {
		this.consolidacao = consolidacao;
	}
	/**
	 * @return the consolidadorID
	 */
	public int getConsolidadorID() {
		return consolidadorID;
	}
	/**
	 * @param consolidadorID the consolidadorID to set
	 */
	public void setConsolidadorID(int consolidadorID) {
		this.consolidadorID = consolidadorID;
	}
	/**
	 * @return the dataSaida
	 */
	public Date getDataSaida() {
		return dataSaida;
	}
	/**
	 * @param dataSaida the dataSaida to set
	 */
	public void setDataSaida(Date dataSaida) {
		this.dataSaida = dataSaida;
	}
	/**
	 * @return the motivoSaida
	 */
	public String getMotivoSaida() {
		return motivoSaida;
	}
	/**
	 * @param motivoSaida the motivoSaida to set
	 */
	public void setMotivoSaida(String motivoSaida) {
		this.motivoSaida = motivoSaida;
	}
	/**
	 * @return the cep
	 */
	public String getCep() {
		return cep;
	}
	/**
	 * @param cep the cep to set
	 */
	public void setCep(String cep) {
		this.cep = cep;
	}
	/**
	 * @return the rua
	 */
	public String getRua() {
		return rua;
	}
	/**
	 * @param rua the rua to set
	 */
	public void setRua(String rua) {
		this.rua = rua;
	}
	/**
	 * @return the bairro
	 */
	public String getBairro() {
		return bairro;
	}
	/**
	 * @param bairro the bairro to set
	 */
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	/**
	 * @return the cidade
	 */
	public String getCidade() {
		return cidade;
	}
	/**
	 * @param cidade the cidade to set
	 */
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	/**
	 * @return the estado
	 */
	public String getEstado() {
		return estado;
	}
	/**
	 * @param estado the estado to set
	 */
	public void setEstado(String estado) {
		this.estado = estado;
	}
	/**
	 * @return the numero
	 */
	public Integer getNumero() {
		return numero;
	}
	/**
	 * @param numero the numero to set
	 */
	public void setNumero(Integer numero) {
		this.numero = numero;
	}
	/**
	 * @param funcaoID the funcaoID to set
	 */
	public void setFuncaoID(Integer funcaoID) {
		this.funcaoID = funcaoID;
	}
	/**
	 * @param encontro the encontro to set
	 */
	public void setEncontro(Integer encontro) {
		this.encontro = encontro;
	}
	/**
	 * @param cursao the cursao to set
	 */
	public void setCursao(Integer cursao) {
		this.cursao = cursao;
	}
	/**
	 * @param batismo the batismo to set
	 */
	public void setBatismo(Integer batismo) {
		this.batismo = batismo;
	}
	/**
	 * @param ctl the ctl to set
	 */
	public void setCtl(Integer ctl) {
		this.ctl = ctl;
	}
	/**
	 * @param consolidacao the consolidacao to set
	 */
	public void setConsolidacao(Integer consolidacao) {
		this.consolidacao = consolidacao;
	}
	/**
	 * @param consolidadorID the consolidadorID to set
	 */
	public void setConsolidadorID(Integer consolidadorID) {
		this.consolidadorID = consolidadorID;
	}
	
	

}
