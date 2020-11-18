/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceeweb.business.dao.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/** 
 * This class represents the primary key of the SICEE_D_TIPO_ISTRUZIONE table.
 */
public class SiceeDTipoIstruzionePk implements Serializable
{
	protected Integer idTipoIstruzione;

	/** 
	 * Sets the value of idTipoIstruzione
	 */
	public void setIdTipoIstruzione(Integer idTipoIstruzione)
	{
		this.idTipoIstruzione = idTipoIstruzione;
	}

	/** 
	 * Gets the value of idTipoIstruzione
	 */
	public Integer getIdTipoIstruzione()
	{
		return idTipoIstruzione;
	}

	/**
	 * Method 'SiceeDTipoIstruzionePk'
	 * 
	 */
	public SiceeDTipoIstruzionePk()
	{
	}

	/**
	 * Method 'SiceeDTipoIstruzionePk'
	 * 
	 * @param idTipoIstruzione
	 */
	public SiceeDTipoIstruzionePk(final Integer idTipoIstruzione)
	{
		this.idTipoIstruzione = idTipoIstruzione;
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
		
		if (!(_other instanceof SiceeDTipoIstruzionePk)) {
			return false;
		}
		
		final SiceeDTipoIstruzionePk _cast = (SiceeDTipoIstruzionePk) _other;
		if (idTipoIstruzione == null ? _cast.idTipoIstruzione != idTipoIstruzione : !idTipoIstruzione.equals( _cast.idTipoIstruzione )) {
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
		if (idTipoIstruzione != null) {
			_hashCode = 29 * _hashCode + idTipoIstruzione.hashCode();
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
		ret.append( "it.csi.sicee.siceeweb.business.dao.dto.SiceeDTipoIstruzionePk: " );
		ret.append( "idTipoIstruzione=" + idTipoIstruzione );
		return ret.toString();
	}

}
