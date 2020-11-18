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
 * The Class DatiCatastaliDto.
 */
public class DatiCatastaliDto implements Serializable {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The comune. */
	private String comune;
	
	/** The provincia. */
	private String provincia;
	
	/** The indirizzo. */
	private String indirizzo;
	
	/** The civico. */
	private String civico;
	
	/** The sezione. */
	private String sezione;
	
	/** The foglio. */
	private String foglio;
	
	/** The particella. */
	private String particella;
	
	/** The subalterno. */
	private String subalterno;
	
	/**
	 * Gets the comune.
	 *
	 * @return the comune
	 */
	public String getComune() {
		return comune;
	}
	
	/**
	 * Sets the comune.
	 *
	 * @param comune the new comune
	 */
	public void setComune(String comune) {
		this.comune = comune;
	}
	
	/**
	 * Gets the provincia.
	 *
	 * @return the provincia
	 */
	public String getProvincia() {
		return provincia;
	}
	
	/**
	 * Sets the provincia.
	 *
	 * @param provincia the new provincia
	 */
	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}
	
	/**
	 * Gets the indirizzo.
	 *
	 * @return the indirizzo
	 */
	public String getIndirizzo() {
		return indirizzo;
	}
	
	/**
	 * Sets the indirizzo.
	 *
	 * @param indirizzo the new indirizzo
	 */
	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}
	
	/**
	 * Gets the civico.
	 *
	 * @return the civico
	 */
	public String getCivico() {
		return civico;
	}
	
	/**
	 * Sets the civico.
	 *
	 * @param civico the new civico
	 */
	public void setCivico(String civico) {
		this.civico = civico;
	}
	
	/**
	 * Gets the sezione.
	 *
	 * @return the sezione
	 */
	public String getSezione() {
		return sezione;
	}
	
	/**
	 * Sets the sezione.
	 *
	 * @param sezione the new sezione
	 */
	public void setSezione(String sezione) {
		this.sezione = sezione;
	}
	
	/**
	 * Gets the foglio.
	 *
	 * @return the foglio
	 */
	public String getFoglio() {
		return foglio;
	}
	
	/**
	 * Sets the foglio.
	 *
	 * @param foglio the new foglio
	 */
	public void setFoglio(String foglio) {
		this.foglio = foglio;
	}
	
	/**
	 * Gets the particella.
	 *
	 * @return the particella
	 */
	public String getParticella() {
		return particella;
	}
	
	/**
	 * Sets the particella.
	 *
	 * @param particella the new particella
	 */
	public void setParticella(String particella) {
		this.particella = particella;
	}
	
	/**
	 * Gets the subalterno.
	 *
	 * @return the subalterno
	 */
	public String getSubalterno() {
		return subalterno;
	}
	
	/**
	 * Sets the subalterno.
	 *
	 * @param subalterno the new subalterno
	 */
	public void setSubalterno(String subalterno) {
		this.subalterno = subalterno;
	}
	
}
