/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceeweb.business.dao.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/** 
 * This class represents the primary key of the SICEE_D_OGGETTO_APE_2015 table.
 */
public class SiceeDOggettoApe2015Pk implements Serializable
{
	protected long idOggettoApe;

	/** 
	 * This attribute represents whether the primitive attribute idOggettoApe is null.
	 */
	protected boolean idOggettoApeNull;

	/** 
	 * Sets the value of idOggettoApe
	 */
	public void setIdOggettoApe(long idOggettoApe)
	{
		this.idOggettoApe = idOggettoApe;
	}

	/** 
	 * Gets the value of idOggettoApe
	 */
	public long getIdOggettoApe()
	{
		return idOggettoApe;
	}

	/**
	 * Method 'SiceeDOggettoApe2015Pk'
	 * 
	 */
	public SiceeDOggettoApe2015Pk()
	{
	}

	/**
	 * Method 'SiceeDOggettoApe2015Pk'
	 * 
	 * @param idOggettoApe
	 */
	public SiceeDOggettoApe2015Pk(final long idOggettoApe)
	{
		this.idOggettoApe = idOggettoApe;
	}

	/** 
	 * Sets the value of idOggettoApeNull
	 */
	public void setIdOggettoApeNull(boolean idOggettoApeNull)
	{
		this.idOggettoApeNull = idOggettoApeNull;
	}

	/** 
	 * Gets the value of idOggettoApeNull
	 */
	public boolean isIdOggettoApeNull()
	{
		return idOggettoApeNull;
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
		
		if (!(_other instanceof SiceeDOggettoApe2015Pk)) {
			return false;
		}
		
		final SiceeDOggettoApe2015Pk _cast = (SiceeDOggettoApe2015Pk) _other;
		if (idOggettoApe != _cast.idOggettoApe) {
			return false;
		}
		
		if (idOggettoApeNull != _cast.idOggettoApeNull) {
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
		_hashCode = 29 * _hashCode + (int) (idOggettoApe ^ (idOggettoApe >>> 32));
		_hashCode = 29 * _hashCode + (idOggettoApeNull ? 1 : 0);
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
		ret.append( "it.csi.sicee.siceeweb.business.dao.dto.SiceeDOggettoApe2015Pk: " );
		ret.append( "idOggettoApe=" + idOggettoApe );
		return ret.toString();
	}

}
