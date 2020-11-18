/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceeweb.business.dao.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/** 
 * This class represents the primary key of the SICEE_D_UNITA_MISURA_2015 table.
 */
public class SiceeDUnitaMisura2015Pk implements Serializable
{
	protected Integer idUnitaMisura;

	/** 
	 * Sets the value of idUnitaMisura
	 */
	public void setIdUnitaMisura(Integer idUnitaMisura)
	{
		this.idUnitaMisura = idUnitaMisura;
	}

	/** 
	 * Gets the value of idUnitaMisura
	 */
	public Integer getIdUnitaMisura()
	{
		return idUnitaMisura;
	}

	/**
	 * Method 'SiceeDUnitaMisura2015Pk'
	 * 
	 */
	public SiceeDUnitaMisura2015Pk()
	{
	}

	/**
	 * Method 'SiceeDUnitaMisura2015Pk'
	 * 
	 * @param idUnitaMisura
	 */
	public SiceeDUnitaMisura2015Pk(final Integer idUnitaMisura)
	{
		this.idUnitaMisura = idUnitaMisura;
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
		
		if (!(_other instanceof SiceeDUnitaMisura2015Pk)) {
			return false;
		}
		
		final SiceeDUnitaMisura2015Pk _cast = (SiceeDUnitaMisura2015Pk) _other;
		if (idUnitaMisura == null ? _cast.idUnitaMisura != idUnitaMisura : !idUnitaMisura.equals( _cast.idUnitaMisura )) {
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
		if (idUnitaMisura != null) {
			_hashCode = 29 * _hashCode + idUnitaMisura.hashCode();
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
		ret.append( "it.csi.sicee.siceeweb.business.dao.dto.SiceeDUnitaMisura2015Pk: " );
		ret.append( "idUnitaMisura=" + idUnitaMisura );
		return ret.toString();
	}

}
