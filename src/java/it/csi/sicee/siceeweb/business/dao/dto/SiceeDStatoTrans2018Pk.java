/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceeweb.business.dao.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/** 
 * This class represents the primary key of the SICEE_D_STATO_TRANS_2018 table.
 */
public class SiceeDStatoTrans2018Pk implements Serializable
{
	protected Integer idStatoTrans2018;

	/** 
	 * Sets the value of idStatoTrans2018
	 */
	public void setIdStatoTrans2018(Integer idStatoTrans2018)
	{
		this.idStatoTrans2018 = idStatoTrans2018;
	}

	/** 
	 * Gets the value of idStatoTrans2018
	 */
	public Integer getIdStatoTrans2018()
	{
		return idStatoTrans2018;
	}

	/**
	 * Method 'SiceeDStatoTrans2018Pk'
	 * 
	 */
	public SiceeDStatoTrans2018Pk()
	{
	}

	/**
	 * Method 'SiceeDStatoTrans2018Pk'
	 * 
	 * @param idStatoTrans2018
	 */
	public SiceeDStatoTrans2018Pk(final Integer idStatoTrans2018)
	{
		this.idStatoTrans2018 = idStatoTrans2018;
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
		
		if (!(_other instanceof SiceeDStatoTrans2018Pk)) {
			return false;
		}
		
		final SiceeDStatoTrans2018Pk _cast = (SiceeDStatoTrans2018Pk) _other;
		if (idStatoTrans2018 == null ? _cast.idStatoTrans2018 != idStatoTrans2018 : !idStatoTrans2018.equals( _cast.idStatoTrans2018 )) {
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
		if (idStatoTrans2018 != null) {
			_hashCode = 29 * _hashCode + idStatoTrans2018.hashCode();
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
		ret.append( "it.csi.sicee.siceeweb.business.dao.dto.SiceeDStatoTrans2018Pk: " );
		ret.append( "idStatoTrans2018=" + idStatoTrans2018 );
		return ret.toString();
	}

}
