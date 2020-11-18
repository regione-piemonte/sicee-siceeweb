/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceeweb.business.dao.dto;

import java.io.Serializable;

public class SiceeDDatiIngresso implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -4838797039927037333L;

	/** 
	 * This attribute maps to the column ID_DATI in the SICEE_D_DATI_INGRESSO table.
	 */
	protected Integer idDati;

	/** 
	 * This attribute maps to the column DESCR in the SICEE_D_DATI_INGRESSO table.
	 */
	protected String descr;

	/**
	 * Method 'SiceeDDatiIngresso'
	 * 
	 */
	public SiceeDDatiIngresso()
	{
	}

	/**
	 * Method 'getIdDati'
	 * 
	 * @return Integer
	 */
	public Integer getIdDati()
	{
		return this.idDati;
	}

	/**
	 * Method 'setIdDati'
	 * 
	 * @param idDati
	 */
	public void setIdDati(Integer idDati)
	{
		this.idDati = idDati;
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
		
		if (!(_other instanceof SiceeDDatiIngresso)) {
			return false;
		}
		
		final SiceeDDatiIngresso _cast = (SiceeDDatiIngresso) _other;
		if (this.idDati == null ? _cast.idDati != this.idDati : !this.idDati.equals( _cast.idDati )) {
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
		if (this.idDati != null) {
			_hashCode = 29 * _hashCode + this.idDati.hashCode();
		}
		
		if (this.descr != null) {
			_hashCode = 29 * _hashCode + this.descr.hashCode();
		}
		
		return _hashCode;
	}

	/**
	 * Method 'createPk'
	 * 
	 * @return SiceeDDatiIngressoPk
	 */
	public SiceeDDatiIngressoPk createPk()
	{
		return new SiceeDDatiIngressoPk(this.idDati);
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
		ret.append( "it.csi.sicee.siceeweb.business.dao.dto.SiceeDDatiIngresso: " );
		ret.append( "idDati=" + this.idDati );
		ret.append( ", descr=" + this.descr );
		return ret.toString();
	}

}
