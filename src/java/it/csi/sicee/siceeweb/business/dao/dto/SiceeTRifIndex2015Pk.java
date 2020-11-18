/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceeweb.business.dao.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/** 
 * This class represents the primary key of the SICEE_T_RIF_INDEX_2015 table.
 */
public class SiceeTRifIndex2015Pk implements Serializable
{
	protected long idRifIndex;

	/** 
	 * This attribute represents whether the primitive attribute idRifIndex is null.
	 */
	protected boolean idRifIndexNull;

	/** 
	 * Sets the value of idRifIndex
	 */
	public void setIdRifIndex(long idRifIndex)
	{
		this.idRifIndex = idRifIndex;
	}

	/** 
	 * Gets the value of idRifIndex
	 */
	public long getIdRifIndex()
	{
		return idRifIndex;
	}

	/**
	 * Method 'SiceeTRifIndex2015Pk'
	 * 
	 */
	public SiceeTRifIndex2015Pk()
	{
	}

	/**
	 * Method 'SiceeTRifIndex2015Pk'
	 * 
	 * @param idRifIndex
	 */
	public SiceeTRifIndex2015Pk(final long idRifIndex)
	{
		this.idRifIndex = idRifIndex;
	}

	/** 
	 * Sets the value of idRifIndexNull
	 */
	public void setIdRifIndexNull(boolean idRifIndexNull)
	{
		this.idRifIndexNull = idRifIndexNull;
	}

	/** 
	 * Gets the value of idRifIndexNull
	 */
	public boolean isIdRifIndexNull()
	{
		return idRifIndexNull;
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
		
		if (!(_other instanceof SiceeTRifIndex2015Pk)) {
			return false;
		}
		
		final SiceeTRifIndex2015Pk _cast = (SiceeTRifIndex2015Pk) _other;
		if (idRifIndex != _cast.idRifIndex) {
			return false;
		}
		
		if (idRifIndexNull != _cast.idRifIndexNull) {
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
		_hashCode = 29 * _hashCode + (int) (idRifIndex ^ (idRifIndex >>> 32));
		_hashCode = 29 * _hashCode + (idRifIndexNull ? 1 : 0);
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
		ret.append( "it.csi.sicee.siceeweb.business.dao.dto.SiceeTRifIndex2015Pk: " );
		ret.append( "idRifIndex=" + idRifIndex );
		return ret.toString();
	}

}
