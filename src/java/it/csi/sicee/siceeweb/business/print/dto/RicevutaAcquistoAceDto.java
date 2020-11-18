/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
/*
 * 
 */
package it.csi.sicee.siceeweb.business.print.dto;

import java.io.Serializable;

// TODO: Auto-generated Javadoc
/**
 * The Class RicevutaAcquistoAceDto.
 */
public class RicevutaAcquistoAceDto extends GenericDto implements Serializable{
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The data acquisto. */
	public static String DATA_ACQUISTO = "data_acquisto";
	
	/** The nome. */
	public static String NOME = "nome";
	
	/** The matricola. */
	public static String MATRICOLA = "matricola";
	
	/** The firma. */
	public static String FIRMA = "firma";
	
	public static String SEDE = "sede";
	
	private String[] sede;
	
	public String[] getSede() {
		return sede;
	}

	public void setSede(String[] sede) {
		this.sede = sede;
	}
	
	
	/** The data acquisto. */
	private String dataAcquisto;
	
	/** The nome. */
	private String nome;
	
	/** The matricola. */
	private String matricola;
	
	/** The codici ace. */
	private String[] codiciAce;
	
	/** The firma. */
	private String firma;
	
	private Double valore;
	

	public Double getValore() {
		return valore;
	}

	public void setValore(Double valore) {
		this.valore = valore;
	}

	/**
	 * Gets the data acquisto.
	 *
	 * @return the data acquisto
	 */
	public String getDataAcquisto() {
		return dataAcquisto;
	}
	
	/**
	 * Sets the data acquisto.
	 *
	 * @param dataAcquisto the new data acquisto
	 */
	public void setDataAcquisto(String dataAcquisto) {
		this.dataAcquisto = dataAcquisto;
	}
	
	/**
	 * Gets the nome.
	 *
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}
	
	/**
	 * Sets the nome.
	 *
	 * @param nome the new nome
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	/**
	 * Gets the matricola.
	 *
	 * @return the matricola
	 */
	public String getMatricola() {
		return matricola;
	}
	
	/**
	 * Sets the matricola.
	 *
	 * @param matricola the new matricola
	 */
	public void setMatricola(String matricola) {
		this.matricola = matricola;
	}
	
	/**
	 * Gets the codici ace.
	 *
	 * @return the codici ace
	 */
	public String[] getCodiciAce() {
		return codiciAce;
	}
	
	/**
	 * Sets the codici ace.
	 *
	 * @param codiciAce the new codici ace
	 */
	public void setCodiciAce(String[] codiciAce) {
		this.codiciAce = codiciAce;
	}
	
	/**
	 * Sets the firma.
	 *
	 * @param firma the new firma
	 */
	public void setFirma(String firma) {
		this.firma = firma;
	}
	
	/**
	 * Gets the firma.
	 *
	 * @return the firma
	 */
	public String getFirma() {
		return firma;
	}
}
