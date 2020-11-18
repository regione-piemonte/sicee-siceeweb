/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceeweb.business.dao.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/** 
 * This class represents the primary key of the SICEE_D_STATO_TRANS_MDP_2018 table.
 */
public class SiceeDStatoTransMdp2018Pk implements Serializable
{
	protected Integer idStatoTransMdp2018;

	/** 
	 * Sets the value of idStatoTransMdp2018
	 */
	public void setIdStatoTransMdp2018(Integer idStatoTransMdp2018)
	{
		this.idStatoTransMdp2018 = idStatoTransMdp2018;
	}

	/** 
	 * Gets the value of idStatoTransMdp2018
	 */
	public Integer getIdStatoTransMdp2018()
	{
		return idStatoTransMdp2018;
	}

	/**
	 * Method 'SiceeDStatoTransMdp2018Pk'
	 * 
	 */
	public SiceeDStatoTransMdp2018Pk()
	{
	}

	/**
	 * Method 'SiceeDStatoTransMdp2018Pk'
	 * 
	 * @param idStatoTransMdp2018
	 */
	public SiceeDStatoTransMdp2018Pk(final Integer idStatoTransMdp2018)
	{
		this.idStatoTransMdp2018 = idStatoTransMdp2018;
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
		
		if (!(_other instanceof SiceeDStatoTransMdp2018Pk)) {
			return false;
		}
		
		final SiceeDStatoTransMdp2018Pk _cast = (SiceeDStatoTransMdp2018Pk) _other;
		if (idStatoTransMdp2018 == null ? _cast.idStatoTransMdp2018 != idStatoTransMdp2018 : !idStatoTransMdp2018.equals( _cast.idStatoTransMdp2018 )) {
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
		if (idStatoTransMdp2018 != null) {
			_hashCode = 29 * _hashCode + idStatoTransMdp2018.hashCode();
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
		ret.append( "it.csi.sicee.siceeweb.business.dao.dto.SiceeDStatoTransMdp2018Pk: " );
		ret.append( "idStatoTransMdp2018=" + idStatoTransMdp2018 );
		return ret.toString();
	}

}
