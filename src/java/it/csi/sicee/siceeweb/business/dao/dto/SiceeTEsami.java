/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceeweb.business.dao.dto;

import java.io.Serializable;

public class SiceeTEsami implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -3715343238119536274L;
	/** 
	 * This attribute maps to the column CODICE_FISCALE in the SICEE_T_ESAMI table.
	 */
	protected String codiceFiscale;

	/**
	 * Method 'SiceeTEsami'
	 * 
	 */
	public SiceeTEsami()
	{
	}

	/**
	 * Method 'getCodiceFiscale'
	 * 
	 * @return String
	 */
	public String getCodiceFiscale()
	{
		return this.codiceFiscale;
	}

	/**
	 * Method 'setCodiceFiscale'
	 * 
	 * @param codiceFiscale
	 */
	public void setCodiceFiscale(String codiceFiscale)
	{
		this.codiceFiscale = codiceFiscale;
	}

	/**
	 * Method 'equals'
	 * 
	 * @param _other
	 * @return boolean
	 */
	@Override
	public boolean equals(Object _other)
	{
		if (_other == null) {
			return false;
		}
		
		if (_other == this) {
			return true;
		}
		
		if (!(_other instanceof SiceeTEsami)) {
			return false;
		}
		
		final SiceeTEsami _cast = (SiceeTEsami) _other;
		if (this.codiceFiscale == null ? _cast.codiceFiscale != this.codiceFiscale : !this.codiceFiscale.equals( _cast.codiceFiscale )) {
			return false;
		}
		
		return true;
	}

	/**
	 * Method 'hashCode'
	 * 
	 * @return int
	 */
	@Override
	public int hashCode()
	{
		int _hashCode = 0;
		if (this.codiceFiscale != null) {
			_hashCode = 29 * _hashCode + this.codiceFiscale.hashCode();
		}
		
		return _hashCode;
	}

	/**
	 * Method 'createPk'
	 * 
	 * @return SiceeTEsamiPk
	 */
	public SiceeTEsamiPk createPk()
	{
		return new SiceeTEsamiPk(this.codiceFiscale);
	}

	/**
	 * Method 'toString'
	 * 
	 * @return String
	 */
	@Override
	public String toString()
	{
		StringBuffer ret = new StringBuffer();
		ret.append( "it.csi.sicee.siceeweb.business.dao.dto.SiceeTEsami: " );
		ret.append( "codiceFiscale=" + this.codiceFiscale );
		return ret.toString();
	}

}
