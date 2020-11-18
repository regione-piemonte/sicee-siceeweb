/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceeweb.business.dao.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/** 
 * This class represents the primary key of the SICEE_D_RUOLO_CERT_2015 table.
 */
public class SiceeDRuoloCert2015Pk implements Serializable
{
	protected long idRuoloCert;

	/** 
	 * This attribute represents whether the primitive attribute idRuoloCert is null.
	 */
	protected boolean idRuoloCertNull;

	/** 
	 * Sets the value of idRuoloCert
	 */
	public void setIdRuoloCert(long idRuoloCert)
	{
		this.idRuoloCert = idRuoloCert;
	}

	/** 
	 * Gets the value of idRuoloCert
	 */
	public long getIdRuoloCert()
	{
		return idRuoloCert;
	}

	/**
	 * Method 'SiceeDRuoloCert2015Pk'
	 * 
	 */
	public SiceeDRuoloCert2015Pk()
	{
	}

	/**
	 * Method 'SiceeDRuoloCert2015Pk'
	 * 
	 * @param idRuoloCert
	 */
	public SiceeDRuoloCert2015Pk(final long idRuoloCert)
	{
		this.idRuoloCert = idRuoloCert;
	}

	/** 
	 * Sets the value of idRuoloCertNull
	 */
	public void setIdRuoloCertNull(boolean idRuoloCertNull)
	{
		this.idRuoloCertNull = idRuoloCertNull;
	}

	/** 
	 * Gets the value of idRuoloCertNull
	 */
	public boolean isIdRuoloCertNull()
	{
		return idRuoloCertNull;
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
		
		if (!(_other instanceof SiceeDRuoloCert2015Pk)) {
			return false;
		}
		
		final SiceeDRuoloCert2015Pk _cast = (SiceeDRuoloCert2015Pk) _other;
		if (idRuoloCert != _cast.idRuoloCert) {
			return false;
		}
		
		if (idRuoloCertNull != _cast.idRuoloCertNull) {
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
		_hashCode = 29 * _hashCode + (int) (idRuoloCert ^ (idRuoloCert >>> 32));
		_hashCode = 29 * _hashCode + (idRuoloCertNull ? 1 : 0);
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
		ret.append( "it.csi.sicee.siceeweb.business.dao.dto.SiceeDRuoloCert2015Pk: " );
		ret.append( "idRuoloCert=" + idRuoloCert );
		return ret.toString();
	}

}
