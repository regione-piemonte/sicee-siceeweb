/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceeweb.business.dao.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/** 
 * This class represents the primary key of the SICEE_D_TIPO_OP_2018 table.
 */
public class SiceeDTipoOp2018Pk implements Serializable
{
	protected Integer idTipoOp2018;

	/** 
	 * Sets the value of idTipoOp2018
	 */
	public void setIdTipoOp2018(Integer idTipoOp2018)
	{
		this.idTipoOp2018 = idTipoOp2018;
	}

	/** 
	 * Gets the value of idTipoOp2018
	 */
	public Integer getIdTipoOp2018()
	{
		return idTipoOp2018;
	}

	/**
	 * Method 'SiceeDTipoOp2018Pk'
	 * 
	 */
	public SiceeDTipoOp2018Pk()
	{
	}

	/**
	 * Method 'SiceeDTipoOp2018Pk'
	 * 
	 * @param idTipoOp2018
	 */
	public SiceeDTipoOp2018Pk(final Integer idTipoOp2018)
	{
		this.idTipoOp2018 = idTipoOp2018;
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
		
		if (!(_other instanceof SiceeDTipoOp2018Pk)) {
			return false;
		}
		
		final SiceeDTipoOp2018Pk _cast = (SiceeDTipoOp2018Pk) _other;
		if (idTipoOp2018 == null ? _cast.idTipoOp2018 != idTipoOp2018 : !idTipoOp2018.equals( _cast.idTipoOp2018 )) {
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
		if (idTipoOp2018 != null) {
			_hashCode = 29 * _hashCode + idTipoOp2018.hashCode();
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
		ret.append( "it.csi.sicee.siceeweb.business.dao.dto.SiceeDTipoOp2018Pk: " );
		ret.append( "idTipoOp2018=" + idTipoOp2018 );
		return ret.toString();
	}

}
