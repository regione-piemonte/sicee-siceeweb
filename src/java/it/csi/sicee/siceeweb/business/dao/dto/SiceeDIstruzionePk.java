/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceeweb.business.dao.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/** 
 * This class represents the primary key of the SICEE_D_ISTRUZIONE table.
 */
public class SiceeDIstruzionePk implements Serializable
{
	protected Integer idIstruzione;

	/** 
	 * Sets the value of idIstruzione
	 */
	public void setIdIstruzione(Integer idIstruzione)
	{
		this.idIstruzione = idIstruzione;
	}

	/** 
	 * Gets the value of idIstruzione
	 */
	public Integer getIdIstruzione()
	{
		return idIstruzione;
	}

	/**
	 * Method 'SiceeDIstruzionePk'
	 * 
	 */
	public SiceeDIstruzionePk()
	{
	}

	/**
	 * Method 'SiceeDIstruzionePk'
	 * 
	 * @param idIstruzione
	 */
	public SiceeDIstruzionePk(final Integer idIstruzione)
	{
		this.idIstruzione = idIstruzione;
	}

	/**
	 * Method 'equals'
	 * 
	 * @param _other
	 * @return boolean
	 */
	public boolean equals(Object _other)
	{
		if (_other == null) {
			return false;
		}
		
		if (_other == this) {
			return true;
		}
		
		if (!(_other instanceof SiceeDIstruzionePk)) {
			return false;
		}
		
		final SiceeDIstruzionePk _cast = (SiceeDIstruzionePk) _other;
		if (idIstruzione == null ? _cast.idIstruzione != idIstruzione : !idIstruzione.equals( _cast.idIstruzione )) {
			return false;
		}
		
		return true;
	}

	/**
	 * Method 'hashCode'
	 * 
	 * @return int
	 */
	public int hashCode()
	{
		int _hashCode = 0;
		if (idIstruzione != null) {
			_hashCode = 29 * _hashCode + idIstruzione.hashCode();
		}
		
		return _hashCode;
	}

	/**
	 * Method 'toString'
	 * 
	 * @return String
	 */
	public String toString()
	{
		StringBuffer ret = new StringBuffer();
		ret.append( "it.csi.sicee.siceeweb.business.dao.dto.SiceeDIstruzionePk: " );
		ret.append( "idIstruzione=" + idIstruzione );
		return ret.toString();
	}

}
