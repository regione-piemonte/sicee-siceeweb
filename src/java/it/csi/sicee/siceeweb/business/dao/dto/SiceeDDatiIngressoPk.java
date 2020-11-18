/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceeweb.business.dao.dto;

import java.io.Serializable;

/** 
 * This class represents the primary key of the SICEE_D_DATI_INGRESSO table.
 */
public class SiceeDDatiIngressoPk implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 7117105931071531560L;
	protected Integer idDati;

	/** 
	 * Sets the value of idDati
	 */
	public void setIdDati(Integer idDati)
	{
		this.idDati = idDati;
	}

	/** 
	 * Gets the value of idDati
	 */
	public Integer getIdDati()
	{
		return this.idDati;
	}

	/**
	 * Method 'SiceeDDatiIngressoPk'
	 * 
	 */
	public SiceeDDatiIngressoPk()
	{
	}

	/**
	 * Method 'SiceeDDatiIngressoPk'
	 * 
	 * @param idDati
	 */
	public SiceeDDatiIngressoPk(final Integer idDati)
	{
		this.idDati = idDati;
	}

	/**
	 * Method 'equals'
	 * 
	 * @param _other
	 * @return boolean
	 */
	@Override
	public boolean equals(Object _other)
	{
		if (_other == null) {
			return false;
		}
		
		if (_other == this) {
			return true;
		}
		
		if (!(_other instanceof SiceeDDatiIngressoPk)) {
			return false;
		}
		
		final SiceeDDatiIngressoPk _cast = (SiceeDDatiIngressoPk) _other;
		if (this.idDati == null ? _cast.idDati != this.idDati : !this.idDati.equals( _cast.idDati )) {
			return false;
		}
		
		return true;
	}

	/**
	 * Method 'hashCode'
	 * 
	 * @return int
	 */
	@Override
	public int hashCode()
	{
		int _hashCode = 0;
		if (this.idDati != null) {
			_hashCode = 29 * _hashCode + this.idDati.hashCode();
		}
		
		return _hashCode;
	}

	/**
	 * Method 'toString'
	 * 
	 * @return String
	 */
	@Override
	public String toString()
	{
		StringBuffer ret = new StringBuffer();
		ret.append( "it.csi.sicee.siceeweb.business.dao.dto.SiceeDDatiIngressoPk: " );
		ret.append( "idDati=" + this.idDati );
		return ret.toString();
	}

}
