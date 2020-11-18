/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceeweb.business.dao.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/** 
 * This class represents the primary key of the SICEE_D_PROPRIETA_EDIF_2015 table.
 */
public class SiceeDProprietaEdif2015Pk implements Serializable
{
	protected Integer idProprietaEdi;

	/** 
	 * Sets the value of idProprietaEdi
	 */
	public void setIdProprietaEdi(Integer idProprietaEdi)
	{
		this.idProprietaEdi = idProprietaEdi;
	}

	/** 
	 * Gets the value of idProprietaEdi
	 */
	public Integer getIdProprietaEdi()
	{
		return idProprietaEdi;
	}

	/**
	 * Method 'SiceeDProprietaEdif2015Pk'
	 * 
	 */
	public SiceeDProprietaEdif2015Pk()
	{
	}

	/**
	 * Method 'SiceeDProprietaEdif2015Pk'
	 * 
	 * @param idProprietaEdi
	 */
	public SiceeDProprietaEdif2015Pk(final Integer idProprietaEdi)
	{
		this.idProprietaEdi = idProprietaEdi;
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
		
		if (!(_other instanceof SiceeDProprietaEdif2015Pk)) {
			return false;
		}
		
		final SiceeDProprietaEdif2015Pk _cast = (SiceeDProprietaEdif2015Pk) _other;
		if (idProprietaEdi == null ? _cast.idProprietaEdi != idProprietaEdi : !idProprietaEdi.equals( _cast.idProprietaEdi )) {
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
		if (idProprietaEdi != null) {
			_hashCode = 29 * _hashCode + idProprietaEdi.hashCode();
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
		ret.append( "it.csi.sicee.siceeweb.business.dao.dto.SiceeDProprietaEdif2015Pk: " );
		ret.append( "idProprietaEdi=" + idProprietaEdi );
		return ret.toString();
	}

}
