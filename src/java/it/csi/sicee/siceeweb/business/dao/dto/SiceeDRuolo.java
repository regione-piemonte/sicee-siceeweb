/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceeweb.business.dao.dto;

import java.io.Serializable;

public class SiceeDRuolo implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -5088139268742939273L;

	/** 
	 * This attribute maps to the column ID_TIPO_RUOLO in the SICEE_D_RUOLO table.
	 */
	protected Integer idTipoRuolo;

	/** 
	 * This attribute maps to the column DESCR in the SICEE_D_RUOLO table.
	 */
	protected String descr;

	/**
	 * Method 'SiceeDRuolo'
	 * 
	 */
	public SiceeDRuolo()
	{
	}

	/**
	 * Method 'getIdTipoRuolo'
	 * 
	 * @return Integer
	 */
	public Integer getIdTipoRuolo()
	{
		return this.idTipoRuolo;
	}

	/**
	 * Method 'setIdTipoRuolo'
	 * 
	 * @param idTipoRuolo
	 */
	public void setIdTipoRuolo(Integer idTipoRuolo)
	{
		this.idTipoRuolo = idTipoRuolo;
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
		
		if (!(_other instanceof SiceeDRuolo)) {
			return false;
		}
		
		final SiceeDRuolo _cast = (SiceeDRuolo) _other;
		if (this.idTipoRuolo == null ? _cast.idTipoRuolo != this.idTipoRuolo : !this.idTipoRuolo.equals( _cast.idTipoRuolo )) {
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
		if (this.idTipoRuolo != null) {
			_hashCode = 29 * _hashCode + this.idTipoRuolo.hashCode();
		}
		
		if (this.descr != null) {
			_hashCode = 29 * _hashCode + this.descr.hashCode();
		}
		
		return _hashCode;
	}

	/**
	 * Method 'createPk'
	 * 
	 * @return SiceeDRuoloPk
	 */
	public SiceeDRuoloPk createPk()
	{
		return new SiceeDRuoloPk(this.idTipoRuolo);
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
		ret.append( "it.csi.sicee.siceeweb.business.dao.dto.SiceeDRuolo: " );
		ret.append( "idTipoRuolo=" + this.idTipoRuolo );
		ret.append( ", descr=" + this.descr );
		return ret.toString();
	}

}
