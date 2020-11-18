/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceeweb.business.dao.dto;

import java.io.Serializable;

/** 
 * This class represents the primary key of the SICEE_R_DEST_CLASSE table.
 */
public class SiceeRDestClassePk implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -7200299311650414629L;

	protected Integer idClasse;

	protected Integer idDestUso;

	/** 
	 * Sets the value of idClasse
	 */
	public void setIdClasse(Integer idClasse)
	{
		this.idClasse = idClasse;
	}

	/** 
	 * Gets the value of idClasse
	 */
	public Integer getIdClasse()
	{
		return this.idClasse;
	}

	/** 
	 * Sets the value of idDestUso
	 */
	public void setIdDestUso(Integer idDestUso)
	{
		this.idDestUso = idDestUso;
	}

	/** 
	 * Gets the value of idDestUso
	 */
	public Integer getIdDestUso()
	{
		return this.idDestUso;
	}

	/**
	 * Method 'SiceeRDestClassePk'
	 * 
	 */
	public SiceeRDestClassePk()
	{
	}

	/**
	 * Method 'SiceeRDestClassePk'
	 * 
	 * @param idClasse
	 * @param idDestUso
	 */
	public SiceeRDestClassePk(final Integer idClasse, final Integer idDestUso)
	{
		this.idClasse = idClasse;
		this.idDestUso = idDestUso;
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
		
		if (!(_other instanceof SiceeRDestClassePk)) {
			return false;
		}
		
		final SiceeRDestClassePk _cast = (SiceeRDestClassePk) _other;
		if (this.idClasse == null ? _cast.idClasse != this.idClasse : !this.idClasse.equals( _cast.idClasse )) {
			return false;
		}
		
		if (this.idDestUso == null ? _cast.idDestUso != this.idDestUso : !this.idDestUso.equals( _cast.idDestUso )) {
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
		if (this.idClasse != null) {
			_hashCode = 29 * _hashCode + this.idClasse.hashCode();
		}
		
		if (this.idDestUso != null) {
			_hashCode = 29 * _hashCode + this.idDestUso.hashCode();
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
		ret.append( "it.csi.sicee.siceeweb.business.dao.dto.SiceeRDestClassePk: " );
		ret.append( "idClasse=" + this.idClasse );
		ret.append( ", idDestUso=" + this.idDestUso );
		return ret.toString();
	}

}
