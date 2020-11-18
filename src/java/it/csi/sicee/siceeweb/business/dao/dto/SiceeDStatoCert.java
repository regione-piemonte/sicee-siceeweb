/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceeweb.business.dao.dto;

import java.io.Serializable;

public class SiceeDStatoCert implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 4041907664589291805L;

	/** 
	 * This attribute maps to the column ID_STATO in the SICEE_D_STATO_CERT table.
	 */
	protected Integer idStato;

	/** 
	 * This attribute maps to the column DESCR in the SICEE_D_STATO_CERT table.
	 */
	protected String descr;

	/**
	 * Method 'SiceeDStatoCert'
	 * 
	 */
	public SiceeDStatoCert()
	{
	}

	/**
	 * Method 'getIdStato'
	 * 
	 * @return Integer
	 */
	public Integer getIdStato()
	{
		return this.idStato;
	}

	/**
	 * Method 'setIdStato'
	 * 
	 * @param idStato
	 */
	public void setIdStato(Integer idStato)
	{
		this.idStato = idStato;
	}

	/**
	 * Method 'getDescr'
	 * 
	 * @return String
	 */
	public String getDescr()
	{
		return this.descr;
	}

	/**
	 * Method 'setDescr'
	 * 
	 * @param descr
	 */
	public void setDescr(String descr)
	{
		this.descr = descr;
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
		
		if (!(_other instanceof SiceeDStatoCert)) {
			return false;
		}
		
		final SiceeDStatoCert _cast = (SiceeDStatoCert) _other;
		if (this.idStato == null ? _cast.idStato != this.idStato : !this.idStato.equals( _cast.idStato )) {
			return false;
		}
		
		if (this.descr == null ? _cast.descr != this.descr : !this.descr.equals( _cast.descr )) {
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
		
		if (this.descr != null) {
			_hashCode = 29 * _hashCode + this.descr.hashCode();
		}
		
		return _hashCode;
	}

	/**
	 * Method 'createPk'
	 * 
	 * @return SiceeDStatoCertPk
	 */
	public SiceeDStatoCertPk createPk()
	{
		return new SiceeDStatoCertPk(this.idStato);
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
		ret.append( "it.csi.sicee.siceeweb.business.dao.dto.SiceeDStatoCert: " );
		ret.append( "idStato=" + this.idStato );
		ret.append( ", descr=" + this.descr );
		return ret.toString();
	}

}
