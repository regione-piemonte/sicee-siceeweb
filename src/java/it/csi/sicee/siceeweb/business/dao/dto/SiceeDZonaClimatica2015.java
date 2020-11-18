/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceeweb.business.dao.dto;

import it.csi.sicee.siceeweb.business.dao.dao.*;
import it.csi.sicee.siceeweb.business.dao.factory.*;
import it.csi.sicee.siceeweb.business.dao.exceptions.*;
import java.io.Serializable;
import java.util.*;

public class SiceeDZonaClimatica2015 implements Serializable
{
	/** 
	 * This attribute maps to the column COD_ZONA in the SICEE_D_ZONA_CLIMATICA_2015 table.
	 */
	protected String codZona;

	/**
	 * Method 'SiceeDZonaClimatica2015'
	 * 
	 */
	public SiceeDZonaClimatica2015()
	{
	}

	/**
	 * Method 'getCodZona'
	 * 
	 * @return String
	 */
	public String getCodZona()
	{
		return codZona;
	}

	/**
	 * Method 'setCodZona'
	 * 
	 * @param codZona
	 */
	public void setCodZona(String codZona)
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
		
		if (!(_other instanceof SiceeDZonaClimatica2015)) {
			return false;
		}
		
		final SiceeDZonaClimatica2015 _cast = (SiceeDZonaClimatica2015) _other;
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
	 * Method 'createPk'
	 * 
	 * @return SiceeDZonaClimatica2015Pk
	 */
	public SiceeDZonaClimatica2015Pk createPk()
	{
		return new SiceeDZonaClimatica2015Pk(codZona);
	}

	/**
	 * Method 'toString'
	 * 
	 * @return String
	 */
	public String toString()
	{
		StringBuffer ret = new StringBuffer();
		ret.append( "it.csi.sicee.siceeweb.business.dao.dto.SiceeDZonaClimatica2015: " );
		ret.append( "codZona=" + codZona );
		return ret.toString();
	}

}
