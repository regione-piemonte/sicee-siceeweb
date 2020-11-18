/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceeweb.business.dao.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/** 
 * This class represents the primary key of the SICEE_D_TIPO_IMPIANTO_2015 table.
 */
public class SiceeDTipoImpianto2015Pk implements Serializable
{
	protected Integer idTipoImpianto;

	/** 
	 * Sets the value of idTipoImpianto
	 */
	public void setIdTipoImpianto(Integer idTipoImpianto)
	{
		this.idTipoImpianto = idTipoImpianto;
	}

	/** 
	 * Gets the value of idTipoImpianto
	 */
	public Integer getIdTipoImpianto()
	{
		return idTipoImpianto;
	}

	/**
	 * Method 'SiceeDTipoImpianto2015Pk'
	 * 
	 */
	public SiceeDTipoImpianto2015Pk()
	{
	}

	/**
	 * Method 'SiceeDTipoImpianto2015Pk'
	 * 
	 * @param idTipoImpianto
	 */
	public SiceeDTipoImpianto2015Pk(final Integer idTipoImpianto)
	{
		this.idTipoImpianto = idTipoImpianto;
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
		
		if (!(_other instanceof SiceeDTipoImpianto2015Pk)) {
			return false;
		}
		
		final SiceeDTipoImpianto2015Pk _cast = (SiceeDTipoImpianto2015Pk) _other;
		if (idTipoImpianto == null ? _cast.idTipoImpianto != idTipoImpianto : !idTipoImpianto.equals( _cast.idTipoImpianto )) {
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
		if (idTipoImpianto != null) {
			_hashCode = 29 * _hashCode + idTipoImpianto.hashCode();
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
		ret.append( "it.csi.sicee.siceeweb.business.dao.dto.SiceeDTipoImpianto2015Pk: " );
		ret.append( "idTipoImpianto=" + idTipoImpianto );
		return ret.toString();
	}

}
