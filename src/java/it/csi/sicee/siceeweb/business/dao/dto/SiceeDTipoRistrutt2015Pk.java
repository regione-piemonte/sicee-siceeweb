/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceeweb.business.dao.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/** 
 * This class represents the primary key of the SICEE_D_TIPO_RISTRUTT_2015 table.
 */
public class SiceeDTipoRistrutt2015Pk implements Serializable
{
	protected Integer idTipoRistrutturaz;

	/** 
	 * Sets the value of idTipoRistrutturaz
	 */
	public void setIdTipoRistrutturaz(Integer idTipoRistrutturaz)
	{
		this.idTipoRistrutturaz = idTipoRistrutturaz;
	}

	/** 
	 * Gets the value of idTipoRistrutturaz
	 */
	public Integer getIdTipoRistrutturaz()
	{
		return idTipoRistrutturaz;
	}

	/**
	 * Method 'SiceeDTipoRistrutt2015Pk'
	 * 
	 */
	public SiceeDTipoRistrutt2015Pk()
	{
	}

	/**
	 * Method 'SiceeDTipoRistrutt2015Pk'
	 * 
	 * @param idTipoRistrutturaz
	 */
	public SiceeDTipoRistrutt2015Pk(final Integer idTipoRistrutturaz)
	{
		this.idTipoRistrutturaz = idTipoRistrutturaz;
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
		
		if (!(_other instanceof SiceeDTipoRistrutt2015Pk)) {
			return false;
		}
		
		final SiceeDTipoRistrutt2015Pk _cast = (SiceeDTipoRistrutt2015Pk) _other;
		if (idTipoRistrutturaz == null ? _cast.idTipoRistrutturaz != idTipoRistrutturaz : !idTipoRistrutturaz.equals( _cast.idTipoRistrutturaz )) {
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
		if (idTipoRistrutturaz != null) {
			_hashCode = 29 * _hashCode + idTipoRistrutturaz.hashCode();
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
		ret.append( "it.csi.sicee.siceeweb.business.dao.dto.SiceeDTipoRistrutt2015Pk: " );
		ret.append( "idTipoRistrutturaz=" + idTipoRistrutturaz );
		return ret.toString();
	}

}
