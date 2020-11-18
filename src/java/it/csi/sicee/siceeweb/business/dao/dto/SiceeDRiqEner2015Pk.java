/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceeweb.business.dao.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/** 
 * This class represents the primary key of the SICEE_D_RIQ_ENER_2015 table.
 */
public class SiceeDRiqEner2015Pk implements Serializable
{
	protected String codiceRen;

	/** 
	 * Sets the value of codiceRen
	 */
	public void setCodiceRen(String codiceRen)
	{
		this.codiceRen = codiceRen;
	}

	/** 
	 * Gets the value of codiceRen
	 */
	public String getCodiceRen()
	{
		return codiceRen;
	}

	/**
	 * Method 'SiceeDRiqEner2015Pk'
	 * 
	 */
	public SiceeDRiqEner2015Pk()
	{
	}

	/**
	 * Method 'SiceeDRiqEner2015Pk'
	 * 
	 * @param codiceRen
	 */
	public SiceeDRiqEner2015Pk(final String codiceRen)
	{
		this.codiceRen = codiceRen;
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
		
		if (!(_other instanceof SiceeDRiqEner2015Pk)) {
			return false;
		}
		
		final SiceeDRiqEner2015Pk _cast = (SiceeDRiqEner2015Pk) _other;
		if (codiceRen == null ? _cast.codiceRen != codiceRen : !codiceRen.equals( _cast.codiceRen )) {
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
		if (codiceRen != null) {
			_hashCode = 29 * _hashCode + codiceRen.hashCode();
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
		ret.append( "it.csi.sicee.siceeweb.business.dao.dto.SiceeDRiqEner2015Pk: " );
		ret.append( "codiceRen=" + codiceRen );
		return ret.toString();
	}

}
