/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
/*
 * 
 */
package it.csi.sicee.siceeweb.business.print.dto;

// TODO: Auto-generated Javadoc
/**
 * The Class GenericDto.
 */
public abstract class GenericDto {
	
	/** The logo. */
	private byte[] logo;
	
	/** The data odierna. */
	private String dataOdierna;
	
	/**
	 * Gets the data odierna.
	 *
	 * @return the data odierna
	 */
	public String getDataOdierna() {
		return dataOdierna;
	}

	/**
	 * Sets the data odierna.
	 *
	 * @param dataOdierna the new data odierna
	 */
	public void setDataOdierna(String dataOdierna) {
		this.dataOdierna = dataOdierna;
	}

	/**
	 * Gets the logo.
	 *
	 * @return the logo
	 */
	public byte[] getLogo() {
		return logo;
	}

	/**
	 * Sets the logo.
	 *
	 * @param logo the new logo
	 */
	public void setLogo(byte[] logo) {
		this.logo = logo;
	}

}
