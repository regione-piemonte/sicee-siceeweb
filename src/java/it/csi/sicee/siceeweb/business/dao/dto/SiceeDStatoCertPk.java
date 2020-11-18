/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceeweb.business.dao.dto;

import java.io.Serializable;

/** 
 * This class represents the primary key of the SICEE_D_STATO_CERT table.
 */
public class SiceeDStatoCertPk implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -6535023778706356706L;
	protected Integer idStato;

	/** 
	 * Sets the value of idStato
	 */
	public void setIdStato(Integer idStato)
	{
		this.idStato = idStato;
	}

	/** 
	 * Gets the value of idStato
	 */
	public Integer getIdStato()
	{
		return this.idStato;
	}

	/**
	 * Method 'SiceeDStatoCertPk'
	 * 
	 */
	public SiceeDStatoCertPk()
	{
	}

	/**
	 * Method 'SiceeDStatoCertPk'
	 * 
	 * @param idStato
	 */
	public SiceeDStatoCertPk(final Integer idStato)
	{
		this.idStato = idStato;
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
		
		if (!(_other instanceof SiceeDStatoCertPk)) {
			return false;
		}
		
		final SiceeDStatoCertPk _cast = (SiceeDStatoCertPk) _other;
		if (this.idStato == null ? _cast.idStato != this.idStato : !this.idStato.equals( _cast.idStato )) {
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
		if (this.idStato != null) {
			_hashCode = 29 * _hashCode + this.idStato.hashCode();
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
		ret.append( "it.csi.sicee.siceeweb.business.dao.dto.SiceeDStatoCertPk: " );
		ret.append( "idStato=" + this.idStato );
		return ret.toString();
	}

}
