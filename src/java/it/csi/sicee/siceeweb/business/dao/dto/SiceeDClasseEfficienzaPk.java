/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceeweb.business.dao.dto;

import java.io.Serializable;

/** 
 * This class represents the primary key of the SICEE_D_CLASSE_EFFICIENZA table.
 */
public class SiceeDClasseEfficienzaPk implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 2042564760049273076L;
	protected Integer idClasseEff;

	/** 
	 * Sets the value of idClasseEff
	 */
	public void setIdClasseEff(Integer idClasseEff)
	{
		this.idClasseEff = idClasseEff;
	}

	/** 
	 * Gets the value of idClasseEff
	 */
	public Integer getIdClasseEff()
	{
		return this.idClasseEff;
	}

	/**
	 * Method 'SiceeDClasseEfficienzaPk'
	 * 
	 */
	public SiceeDClasseEfficienzaPk()
	{
	}

	/**
	 * Method 'SiceeDClasseEfficienzaPk'
	 * 
	 * @param idClasseEff
	 */
	public SiceeDClasseEfficienzaPk(final Integer idClasseEff)
	{
		this.idClasseEff = idClasseEff;
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
		
		if (!(_other instanceof SiceeDClasseEfficienzaPk)) {
			return false;
		}
		
		final SiceeDClasseEfficienzaPk _cast = (SiceeDClasseEfficienzaPk) _other;
		if (this.idClasseEff == null ? _cast.idClasseEff != this.idClasseEff : !this.idClasseEff.equals( _cast.idClasseEff )) {
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
		if (this.idClasseEff != null) {
			_hashCode = 29 * _hashCode + this.idClasseEff.hashCode();
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
		ret.append( "it.csi.sicee.siceeweb.business.dao.dto.SiceeDClasseEfficienzaPk: " );
		ret.append( "idClasseEff=" + this.idClasseEff );
		return ret.toString();
	}

}
