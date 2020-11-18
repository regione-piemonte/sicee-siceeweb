/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceeweb.business.dao.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/** 
 * This class represents the primary key of the SICEE_D_SERV_ENER_2015 table.
 */
public class SiceeDServEner2015Pk implements Serializable
{
	protected Integer idServEner;

	/** 
	 * Sets the value of idServEner
	 */
	public void setIdServEner(Integer idServEner)
	{
		this.idServEner = idServEner;
	}

	/** 
	 * Gets the value of idServEner
	 */
	public Integer getIdServEner()
	{
		return idServEner;
	}

	/**
	 * Method 'SiceeDServEner2015Pk'
	 * 
	 */
	public SiceeDServEner2015Pk()
	{
	}

	/**
	 * Method 'SiceeDServEner2015Pk'
	 * 
	 * @param idServEner
	 */
	public SiceeDServEner2015Pk(final Integer idServEner)
	{
		this.idServEner = idServEner;
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
		
		if (!(_other instanceof SiceeDServEner2015Pk)) {
			return false;
		}
		
		final SiceeDServEner2015Pk _cast = (SiceeDServEner2015Pk) _other;
		if (idServEner == null ? _cast.idServEner != idServEner : !idServEner.equals( _cast.idServEner )) {
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
		if (idServEner != null) {
			_hashCode = 29 * _hashCode + idServEner.hashCode();
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
		ret.append( "it.csi.sicee.siceeweb.business.dao.dto.SiceeDServEner2015Pk: " );
		ret.append( "idServEner=" + idServEner );
		return ret.toString();
	}

}
