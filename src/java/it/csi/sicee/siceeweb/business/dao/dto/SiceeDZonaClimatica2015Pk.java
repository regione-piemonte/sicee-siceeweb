/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceeweb.business.dao.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/** 
 * This class represents the primary key of the SICEE_D_ZONA_CLIMATICA_2015 table.
 */
public class SiceeDZonaClimatica2015Pk implements Serializable
{
	protected String codZona;

	/** 
	 * Sets the value of codZona
	 */
	public void setCodZona(String codZona)
	{
		this.codZona = codZona;
	}

	/** 
	 * Gets the value of codZona
	 */
	public String getCodZona()
	{
		return codZona;
	}

	/**
	 * Method 'SiceeDZonaClimatica2015Pk'
	 * 
	 */
	public SiceeDZonaClimatica2015Pk()
	{
	}

	/**
	 * Method 'SiceeDZonaClimatica2015Pk'
	 * 
	 * @param codZona
	 */
	public SiceeDZonaClimatica2015Pk(final String codZona)
	{
		this.codZona = codZona;
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
		
		if (!(_other instanceof SiceeDZonaClimatica2015Pk)) {
			return false;
		}
		
		final SiceeDZonaClimatica2015Pk _cast = (SiceeDZonaClimatica2015Pk) _other;
		if (codZona == null ? _cast.codZona != codZona : !codZona.equals( _cast.codZona )) {
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
		if (codZona != null) {
			_hashCode = 29 * _hashCode + codZona.hashCode();
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
		ret.append( "it.csi.sicee.siceeweb.business.dao.dto.SiceeDZonaClimatica2015Pk: " );
		ret.append( "codZona=" + codZona );
		return ret.toString();
	}

}
