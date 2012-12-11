package br.com.videira.model.dto;

public class MembroFuncaoDTO {
	
	private int funcaoID;
	private int membroID;
	/**
	 * @return the celulaID
	 */
	public int getFuncaoID() {
		return funcaoID;
	}
	/**
	 * @param celulaID the celulaID to set
	 */
	public void setFuncaoID(int funcaoID) {
		this.funcaoID = funcaoID;
	}
	/**
	 * @return the liderTreineeID
	 */
	public int getMembroID() {
		return membroID;
	}
	/**
	 * @param liderTreineeID the liderTreineeID to set
	 */
	public void setMembroID(int membroID) {
		this.membroID = membroID;
	}

}
