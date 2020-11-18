/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceeweb.business.dao.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/** 
 * This class represents the primary key of the SICEE_D_DEST_USO_2015 table.
 */
public class SiceeDDestUso2015Pk implements Serializable
{
	protected Integer idDestUso2015;

	/** 
	 * Sets the value of idDestUso2015
	 */
	public void setIdDestUso2015(Integer idDestUso2015)
	{
		this.idDestUso2015 = idDestUso2015;
	}

	/** 
	 * Gets the value of idDestUso2015
	 */
	public Integer getIdDestUso2015()
	{
		return idDestUso2015;
	}

	/**
	 * Method 'SiceeDDestUso2015Pk'
	 * 
	 */
	public SiceeDDestUso2015Pk()
	{
	}

	/**
	 * Method 'SiceeDDestUso2015Pk'
	 * 
	 * @param idDestUso2015
	 */
	public SiceeDDestUso2015Pk(final Integer idDestUso2015)
	{
		this.idDestUso2015 = idDestUso2015;
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
		
		if (!(_other instanceof SiceeDDestUso2015Pk)) {
			return false;
		}
		
		final SiceeDDestUso2015Pk _cast = (SiceeDDestUso2015Pk) _other;
		if (idDestUso2015 == null ? _cast.idDestUso2015 != idDestUso2015 : !idDestUso2015.equals( _cast.idDestUso2015 )) {
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
		if (idDestUso2015 != null) {
			_hashCode = 29 * _hashCode + idDestUso2015.hashCode();
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
		ret.append( "it.csi.sicee.siceeweb.business.dao.dto.SiceeDDestUso2015Pk: " );
		ret.append( "idDestUso2015=" + idDestUso2015 );
		return ret.toString();
	}

}
