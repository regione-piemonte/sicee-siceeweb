/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceeweb.business.dao.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/** 
 * This class represents the primary key of the SICEE_T_QTA_CONSUMI_2015 table.
 */
public class SiceeTQtaConsumi2015Pk implements Serializable
{
	protected long idQtaConsumi;

	/** 
	 * This attribute represents whether the primitive attribute idQtaConsumi is null.
	 */
	protected boolean idQtaConsumiNull;

	/** 
	 * Sets the value of idQtaConsumi
	 */
	public void setIdQtaConsumi(long idQtaConsumi)
	{
		this.idQtaConsumi = idQtaConsumi;
	}

	/** 
	 * Gets the value of idQtaConsumi
	 */
	public long getIdQtaConsumi()
	{
		return idQtaConsumi;
	}

	/**
	 * Method 'SiceeTQtaConsumi2015Pk'
	 * 
	 */
	public SiceeTQtaConsumi2015Pk()
	{
	}

	/**
	 * Method 'SiceeTQtaConsumi2015Pk'
	 * 
	 * @param idQtaConsumi
	 */
	public SiceeTQtaConsumi2015Pk(final long idQtaConsumi)
	{
		this.idQtaConsumi = idQtaConsumi;
	}

	/** 
	 * Sets the value of idQtaConsumiNull
	 */
	public void setIdQtaConsumiNull(boolean idQtaConsumiNull)
	{
		this.idQtaConsumiNull = idQtaConsumiNull;
	}

	/** 
	 * Gets the value of idQtaConsumiNull
	 */
	public boolean isIdQtaConsumiNull()
	{
		return idQtaConsumiNull;
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
		
		if (!(_other instanceof SiceeTQtaConsumi2015Pk)) {
			return false;
		}
		
		final SiceeTQtaConsumi2015Pk _cast = (SiceeTQtaConsumi2015Pk) _other;
		if (idQtaConsumi != _cast.idQtaConsumi) {
			return false;
		}
		
		if (idQtaConsumiNull != _cast.idQtaConsumiNull) {
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
		_hashCode = 29 * _hashCode + (int) (idQtaConsumi ^ (idQtaConsumi >>> 32));
		_hashCode = 29 * _hashCode + (idQtaConsumiNull ? 1 : 0);
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
		ret.append( "it.csi.sicee.siceeweb.business.dao.dto.SiceeTQtaConsumi2015Pk: " );
		ret.append( "idQtaConsumi=" + idQtaConsumi );
		return ret.toString();
	}

}
