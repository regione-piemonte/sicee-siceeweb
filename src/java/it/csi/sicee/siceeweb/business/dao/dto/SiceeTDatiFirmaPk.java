/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceeweb.business.dao.dto;

import java.io.Serializable;

/** 
 * This class represents the primary key of the SICEE_T_DATI_FIRMA table.
 */
public class SiceeTDatiFirmaPk implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -5968853688989369166L;
	protected Integer idDatiFirma;

	/** 
	 * Sets the value of idDatiFirma
	 */
	public void setIdDatiFirma(Integer idDatiFirma)
	{
		this.idDatiFirma = idDatiFirma;
	}

	/** 
	 * Gets the value of idDatiFirma
	 */
	public Integer getIdDatiFirma()
	{
		return this.idDatiFirma;
	}

	/**
	 * Method 'SiceeTDatiFirmaPk'
	 * 
	 */
	public SiceeTDatiFirmaPk()
	{
	}

	/**
	 * Method 'SiceeTDatiFirmaPk'
	 * 
	 * @param idDatiFirma
	 */
	public SiceeTDatiFirmaPk(final Integer idDatiFirma)
	{
		this.idDatiFirma = idDatiFirma;
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
		
		if (!(_other instanceof SiceeTDatiFirmaPk)) {
			return false;
		}
		
		final SiceeTDatiFirmaPk _cast = (SiceeTDatiFirmaPk) _other;
		if (this.idDatiFirma == null ? _cast.idDatiFirma != this.idDatiFirma : !this.idDatiFirma.equals( _cast.idDatiFirma )) {
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
		if (this.idDatiFirma != null) {
			_hashCode = 29 * _hashCode + this.idDatiFirma.hashCode();
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
		ret.append( "it.csi.sicee.siceeweb.business.dao.dto.SiceeTDatiFirmaPk: " );
		ret.append( "idDatiFirma=" + this.idDatiFirma );
		return ret.toString();
	}

}
