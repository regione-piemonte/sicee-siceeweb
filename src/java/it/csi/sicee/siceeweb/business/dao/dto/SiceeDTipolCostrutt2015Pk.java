/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceeweb.business.dao.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/** 
 * This class represents the primary key of the SICEE_D_TIPOL_COSTRUTT_2015 table.
 */
public class SiceeDTipolCostrutt2015Pk implements Serializable
{
	protected Integer idTipolCostrutt;

	/** 
	 * Sets the value of idTipolCostrutt
	 */
	public void setIdTipolCostrutt(Integer idTipolCostrutt)
	{
		this.idTipolCostrutt = idTipolCostrutt;
	}

	/** 
	 * Gets the value of idTipolCostrutt
	 */
	public Integer getIdTipolCostrutt()
	{
		return idTipolCostrutt;
	}

	/**
	 * Method 'SiceeDTipolCostrutt2015Pk'
	 * 
	 */
	public SiceeDTipolCostrutt2015Pk()
	{
	}

	/**
	 * Method 'SiceeDTipolCostrutt2015Pk'
	 * 
	 * @param idTipolCostrutt
	 */
	public SiceeDTipolCostrutt2015Pk(final Integer idTipolCostrutt)
	{
		this.idTipolCostrutt = idTipolCostrutt;
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
		
		if (!(_other instanceof SiceeDTipolCostrutt2015Pk)) {
			return false;
		}
		
		final SiceeDTipolCostrutt2015Pk _cast = (SiceeDTipolCostrutt2015Pk) _other;
		if (idTipolCostrutt == null ? _cast.idTipolCostrutt != idTipolCostrutt : !idTipolCostrutt.equals( _cast.idTipolCostrutt )) {
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
		if (idTipolCostrutt != null) {
			_hashCode = 29 * _hashCode + idTipolCostrutt.hashCode();
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
		ret.append( "it.csi.sicee.siceeweb.business.dao.dto.SiceeDTipolCostrutt2015Pk: " );
		ret.append( "idTipolCostrutt=" + idTipolCostrutt );
		return ret.toString();
	}

}
