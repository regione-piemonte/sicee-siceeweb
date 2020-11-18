/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceeweb.business.dao.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/** 
 * This class represents the primary key of the SICEE_D_TIPO_FOTO_2015 table.
 */
public class SiceeDTipoFoto2015Pk implements Serializable
{
	protected long idTipoFoto;

	/** 
	 * This attribute represents whether the primitive attribute idTipoFoto is null.
	 */
	protected boolean idTipoFotoNull;

	/** 
	 * Sets the value of idTipoFoto
	 */
	public void setIdTipoFoto(long idTipoFoto)
	{
		this.idTipoFoto = idTipoFoto;
	}

	/** 
	 * Gets the value of idTipoFoto
	 */
	public long getIdTipoFoto()
	{
		return idTipoFoto;
	}

	/**
	 * Method 'SiceeDTipoFoto2015Pk'
	 * 
	 */
	public SiceeDTipoFoto2015Pk()
	{
	}

	/**
	 * Method 'SiceeDTipoFoto2015Pk'
	 * 
	 * @param idTipoFoto
	 */
	public SiceeDTipoFoto2015Pk(final long idTipoFoto)
	{
		this.idTipoFoto = idTipoFoto;
	}

	/** 
	 * Sets the value of idTipoFotoNull
	 */
	public void setIdTipoFotoNull(boolean idTipoFotoNull)
	{
		this.idTipoFotoNull = idTipoFotoNull;
	}

	/** 
	 * Gets the value of idTipoFotoNull
	 */
	public boolean isIdTipoFotoNull()
	{
		return idTipoFotoNull;
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
		
		if (!(_other instanceof SiceeDTipoFoto2015Pk)) {
			return false;
		}
		
		final SiceeDTipoFoto2015Pk _cast = (SiceeDTipoFoto2015Pk) _other;
		if (idTipoFoto != _cast.idTipoFoto) {
			return false;
		}
		
		if (idTipoFotoNull != _cast.idTipoFotoNull) {
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
		_hashCode = 29 * _hashCode + (int) (idTipoFoto ^ (idTipoFoto >>> 32));
		_hashCode = 29 * _hashCode + (idTipoFotoNull ? 1 : 0);
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
		ret.append( "it.csi.sicee.siceeweb.business.dao.dto.SiceeDTipoFoto2015Pk: " );
		ret.append( "idTipoFoto=" + idTipoFoto );
		return ret.toString();
	}

}
