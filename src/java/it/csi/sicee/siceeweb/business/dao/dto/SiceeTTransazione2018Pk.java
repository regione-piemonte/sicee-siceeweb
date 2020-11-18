/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceeweb.business.dao.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/** 
 * This class represents the primary key of the SICEE_T_TRANSAZIONE_2018 table.
 */
public class SiceeTTransazione2018Pk implements Serializable
{
	protected long idTransazione2018;

	/** 
	 * This attribute represents whether the primitive attribute idTransazione2018 is null.
	 */
	protected boolean idTransazione2018Null;

	/** 
	 * Sets the value of idTransazione2018
	 */
	public void setIdTransazione2018(long idTransazione2018)
	{
		this.idTransazione2018 = idTransazione2018;
	}

	/** 
	 * Gets the value of idTransazione2018
	 */
	public long getIdTransazione2018()
	{
		return idTransazione2018;
	}

	/**
	 * Method 'SiceeTTransazione2018Pk'
	 * 
	 */
	public SiceeTTransazione2018Pk()
	{
	}

	/**
	 * Method 'SiceeTTransazione2018Pk'
	 * 
	 * @param idTransazione2018
	 */
	public SiceeTTransazione2018Pk(final Integer idTransazione2018)
	{
		this.idTransazione2018 = idTransazione2018;
	}

	/** 
	 * Sets the value of idTransazione2018Null
	 */
	public void setIdTransazione2018Null(boolean idTransazione2018Null)
	{
		this.idTransazione2018Null = idTransazione2018Null;
	}

	/** 
	 * Gets the value of idTransazione2018Null
	 */
	public boolean isIdTransazione2018Null()
	{
		return idTransazione2018Null;
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
		
		if (!(_other instanceof SiceeTTransazione2018Pk)) {
			return false;
		}
		
		final SiceeTTransazione2018Pk _cast = (SiceeTTransazione2018Pk) _other;
		if (idTransazione2018 != _cast.idTransazione2018) {
			return false;
		}
		
		if (idTransazione2018Null != _cast.idTransazione2018Null) {
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
		_hashCode = 29 * _hashCode + (int) (idTransazione2018 ^ (idTransazione2018 >>> 32));
		_hashCode = 29 * _hashCode + (idTransazione2018Null ? 1 : 0);
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
		ret.append( "it.csi.sicee.siceeweb.business.dao.dto.SiceeTTransazione2018Pk: " );
		ret.append( "idTransazione2018=" + idTransazione2018 );
		return ret.toString();
	}

}
