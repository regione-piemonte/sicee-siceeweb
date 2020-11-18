/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceeweb.business.dao.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/** 
 * This class represents the primary key of the SICEE_T_RACCOMAND_2015 table.
 */
public class SiceeTRaccomand2015Pk implements Serializable
{
	protected long idRaccomandazione;

	/** 
	 * This attribute represents whether the primitive attribute idRaccomandazione is null.
	 */
	protected boolean idRaccomandazioneNull;

	/** 
	 * Sets the value of idRaccomandazione
	 */
	public void setIdRaccomandazione(long idRaccomandazione)
	{
		this.idRaccomandazione = idRaccomandazione;
	}

	/** 
	 * Gets the value of idRaccomandazione
	 */
	public long getIdRaccomandazione()
	{
		return idRaccomandazione;
	}

	/**
	 * Method 'SiceeTRaccomand2015Pk'
	 * 
	 */
	public SiceeTRaccomand2015Pk()
	{
	}

	/**
	 * Method 'SiceeTRaccomand2015Pk'
	 * 
	 * @param idRaccomandazione
	 */
	public SiceeTRaccomand2015Pk(final long idRaccomandazione)
	{
		this.idRaccomandazione = idRaccomandazione;
	}

	/** 
	 * Sets the value of idRaccomandazioneNull
	 */
	public void setIdRaccomandazioneNull(boolean idRaccomandazioneNull)
	{
		this.idRaccomandazioneNull = idRaccomandazioneNull;
	}

	/** 
	 * Gets the value of idRaccomandazioneNull
	 */
	public boolean isIdRaccomandazioneNull()
	{
		return idRaccomandazioneNull;
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
		
		if (!(_other instanceof SiceeTRaccomand2015Pk)) {
			return false;
		}
		
		final SiceeTRaccomand2015Pk _cast = (SiceeTRaccomand2015Pk) _other;
		if (idRaccomandazione != _cast.idRaccomandazione) {
			return false;
		}
		
		if (idRaccomandazioneNull != _cast.idRaccomandazioneNull) {
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
		_hashCode = 29 * _hashCode + (int) (idRaccomandazione ^ (idRaccomandazione >>> 32));
		_hashCode = 29 * _hashCode + (idRaccomandazioneNull ? 1 : 0);
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
		ret.append( "it.csi.sicee.siceeweb.business.dao.dto.SiceeTRaccomand2015Pk: " );
		ret.append( "idRaccomandazione=" + idRaccomandazione );
		return ret.toString();
	}

}
