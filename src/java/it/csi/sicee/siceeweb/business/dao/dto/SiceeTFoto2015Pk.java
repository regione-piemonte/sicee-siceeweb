/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceeweb.business.dao.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/** 
 * This class represents the primary key of the SICEE_T_FOTO_2015 table.
 */
public class SiceeTFoto2015Pk implements Serializable
{
	protected long idFoto;

	/** 
	 * This attribute represents whether the primitive attribute idFoto is null.
	 */
	protected boolean idFotoNull;

	/** 
	 * Sets the value of idFoto
	 */
	public void setIdFoto(long idFoto)
	{
		this.idFoto = idFoto;
	}

	/** 
	 * Gets the value of idFoto
	 */
	public long getIdFoto()
	{
		return idFoto;
	}

	/**
	 * Method 'SiceeTFoto2015Pk'
	 * 
	 */
	public SiceeTFoto2015Pk()
	{
	}

	/**
	 * Method 'SiceeTFoto2015Pk'
	 * 
	 * @param idFoto
	 */
	public SiceeTFoto2015Pk(final long idFoto)
	{
		this.idFoto = idFoto;
	}

	/** 
	 * Sets the value of idFotoNull
	 */
	public void setIdFotoNull(boolean idFotoNull)
	{
		this.idFotoNull = idFotoNull;
	}

	/** 
	 * Gets the value of idFotoNull
	 */
	public boolean isIdFotoNull()
	{
		return idFotoNull;
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
		
		if (!(_other instanceof SiceeTFoto2015Pk)) {
			return false;
		}
		
		final SiceeTFoto2015Pk _cast = (SiceeTFoto2015Pk) _other;
		if (idFoto != _cast.idFoto) {
			return false;
		}
		
		if (idFotoNull != _cast.idFotoNull) {
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
		_hashCode = 29 * _hashCode + (int) (idFoto ^ (idFoto >>> 32));
		_hashCode = 29 * _hashCode + (idFotoNull ? 1 : 0);
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
		ret.append( "it.csi.sicee.siceeweb.business.dao.dto.SiceeTFoto2015Pk: " );
		ret.append( "idFoto=" + idFoto );
		return ret.toString();
	}

}
