/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceeweb.business.dao.dto;

import java.io.Serializable;

/** 
 * This class represents the primary key of the SICEE_T_ESAMI table.
 */
public class SiceeTEsamiPk implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -8368009937459870795L;
	protected String codiceFiscale;

	/** 
	 * Sets the value of codiceFiscale
	 */
	public void setCodiceFiscale(String codiceFiscale)
	{
		this.codiceFiscale = codiceFiscale;
	}

	/** 
	 * Gets the value of codiceFiscale
	 */
	public String getCodiceFiscale()
	{
		return this.codiceFiscale;
	}

	/**
	 * Method 'SiceeTEsamiPk'
	 * 
	 */
	public SiceeTEsamiPk()
	{
	}

	/**
	 * Method 'SiceeTEsamiPk'
	 * 
	 * @param codiceFiscale
	 */
	public SiceeTEsamiPk(final String codiceFiscale)
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
		
		if (!(_other instanceof SiceeTEsamiPk)) {
			return false;
		}
		
		final SiceeTEsamiPk _cast = (SiceeTEsamiPk) _other;
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
	 * Method 'toString'
	 * 
	 * @return String
	 */
	@Override
	public String toString()
	{
		StringBuffer ret = new StringBuffer();
		ret.append( "it.csi.sicee.siceeweb.business.dao.dto.SiceeTEsamiPk: " );
		ret.append( "codiceFiscale=" + this.codiceFiscale );
		return ret.toString();
	}

}
