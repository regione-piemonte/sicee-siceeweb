/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceeweb.business.dao.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/** 
 * This class represents the primary key of the SICEE_D_TIPOL_EDILIZIA_2015 table.
 */
public class SiceeDTipolEdilizia2015Pk implements Serializable
{
	protected Integer idTipolEdilizia;

	/** 
	 * Sets the value of idTipolEdilizia
	 */
	public void setIdTipolEdilizia(Integer idTipolEdilizia)
	{
		this.idTipolEdilizia = idTipolEdilizia;
	}

	/** 
	 * Gets the value of idTipolEdilizia
	 */
	public Integer getIdTipolEdilizia()
	{
		return idTipolEdilizia;
	}

	/**
	 * Method 'SiceeDTipolEdilizia2015Pk'
	 * 
	 */
	public SiceeDTipolEdilizia2015Pk()
	{
	}

	/**
	 * Method 'SiceeDTipolEdilizia2015Pk'
	 * 
	 * @param idTipolEdilizia
	 */
	public SiceeDTipolEdilizia2015Pk(final Integer idTipolEdilizia)
	{
		this.idTipolEdilizia = idTipolEdilizia;
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
		
		if (!(_other instanceof SiceeDTipolEdilizia2015Pk)) {
			return false;
		}
		
		final SiceeDTipolEdilizia2015Pk _cast = (SiceeDTipolEdilizia2015Pk) _other;
		if (idTipolEdilizia == null ? _cast.idTipolEdilizia != idTipolEdilizia : !idTipolEdilizia.equals( _cast.idTipolEdilizia )) {
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
		if (idTipolEdilizia != null) {
			_hashCode = 29 * _hashCode + idTipolEdilizia.hashCode();
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
		ret.append( "it.csi.sicee.siceeweb.business.dao.dto.SiceeDTipolEdilizia2015Pk: " );
		ret.append( "idTipolEdilizia=" + idTipolEdilizia );
		return ret.toString();
	}

}
