/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceeweb.business.dao.dto;

import java.io.Serializable;

/** 
 * This class represents the primary key of the SICEE_D_CLASSE_ENERGETICA table.
 */
public class SiceeDClasseEnergeticaPk implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 7990934939380011844L;
	protected Integer idClasse;

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
	 * Method 'SiceeDClasseEnergeticaPk'
	 * 
	 */
	public SiceeDClasseEnergeticaPk()
	{
	}

	/**
	 * Method 'SiceeDClasseEnergeticaPk'
	 * 
	 * @param idClasse
	 */
	public SiceeDClasseEnergeticaPk(final Integer idClasse)
	{
		this.idClasse = idClasse;
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
		
		if (!(_other instanceof SiceeDClasseEnergeticaPk)) {
			return false;
		}
		
		final SiceeDClasseEnergeticaPk _cast = (SiceeDClasseEnergeticaPk) _other;
		if (this.idClasse == null ? _cast.idClasse != this.idClasse : !this.idClasse.equals( _cast.idClasse )) {
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
		ret.append( "it.csi.sicee.siceeweb.business.dao.dto.SiceeDClasseEnergeticaPk: " );
		ret.append( "idClasse=" + this.idClasse );
		return ret.toString();
	}

}
