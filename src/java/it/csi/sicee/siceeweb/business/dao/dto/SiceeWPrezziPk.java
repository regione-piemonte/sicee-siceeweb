/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceeweb.business.dao.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/** 
 * This class represents the primary key of the SICEE_W_PREZZI table.
 */
public class SiceeWPrezziPk implements Serializable
{
	protected Integer idPrezzi;

	/** 
	 * Sets the value of idPrezzi
	 */
	public void setIdPrezzi(Integer idPrezzi)
	{
		this.idPrezzi = idPrezzi;
	}

	/** 
	 * Gets the value of idPrezzi
	 */
	public Integer getIdPrezzi()
	{
		return idPrezzi;
	}

	/**
	 * Method 'SiceeWPrezziPk'
	 * 
	 */
	public SiceeWPrezziPk()
	{
	}

	/**
	 * Method 'SiceeWPrezziPk'
	 * 
	 * @param idPrezzi
	 */
	public SiceeWPrezziPk(final Integer idPrezzi)
	{
		this.idPrezzi = idPrezzi;
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
		
		if (!(_other instanceof SiceeWPrezziPk)) {
			return false;
		}
		
		final SiceeWPrezziPk _cast = (SiceeWPrezziPk) _other;
		if (idPrezzi == null ? _cast.idPrezzi != idPrezzi : !idPrezzi.equals( _cast.idPrezzi )) {
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
		if (idPrezzi != null) {
			_hashCode = 29 * _hashCode + idPrezzi.hashCode();
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
		ret.append( "it.csi.sicee.siceeweb.business.dao.dto.SiceeWPrezziPk: " );
		ret.append( "idPrezzi=" + idPrezzi );
		return ret.toString();
	}

}
