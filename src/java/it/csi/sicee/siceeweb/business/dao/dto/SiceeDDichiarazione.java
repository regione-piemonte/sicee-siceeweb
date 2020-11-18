/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceeweb.business.dao.dto;

import java.io.Serializable;

public class SiceeDDichiarazione implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 3569439974383142099L;

	/** 
	 * This attribute maps to the column ID_DICHIARAZIONE in the SICEE_D_DICHIARAZIONE table.
	 */
	protected Integer idDichiarazione;

	/** 
	 * This attribute maps to the column DESCR in the SICEE_D_DICHIARAZIONE table.
	 */
	protected String descr;

	/**
	 * Method 'SiceeDDichiarazione'
	 * 
	 */
	public SiceeDDichiarazione()
	{
	}

	/**
	 * Method 'getIdDichiarazione'
	 * 
	 * @return Integer
	 */
	public Integer getIdDichiarazione()
	{
		return this.idDichiarazione;
	}

	/**
	 * Method 'setIdDichiarazione'
	 * 
	 * @param idDichiarazione
	 */
	public void setIdDichiarazione(Integer idDichiarazione)
	{
		this.idDichiarazione = idDichiarazione;
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
		
		if (!(_other instanceof SiceeDDichiarazione)) {
			return false;
		}
		
		final SiceeDDichiarazione _cast = (SiceeDDichiarazione) _other;
		if (this.idDichiarazione == null ? _cast.idDichiarazione != this.idDichiarazione : !this.idDichiarazione.equals( _cast.idDichiarazione )) {
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
		if (this.idDichiarazione != null) {
			_hashCode = 29 * _hashCode + this.idDichiarazione.hashCode();
		}
		
		if (this.descr != null) {
			_hashCode = 29 * _hashCode + this.descr.hashCode();
		}
		
		return _hashCode;
	}

	/**
	 * Method 'createPk'
	 * 
	 * @return SiceeDDichiarazionePk
	 */
	public SiceeDDichiarazionePk createPk()
	{
		return new SiceeDDichiarazionePk(this.idDichiarazione);
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
		ret.append( "it.csi.sicee.siceeweb.business.dao.dto.SiceeDDichiarazione: " );
		ret.append( "idDichiarazione=" + this.idDichiarazione );
		ret.append( ", descr=" + this.descr );
		return ret.toString();
	}

}
