/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceeweb.business.dao.dto;

import java.io.Serializable;

/** 
 * This class represents the primary key of the SICEE_T_DOCUMENTO table.
 */
public class SiceeTDocumentoPk implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 992728634995443689L;
	protected Integer idDocumento;

	/** 
	 * Sets the value of idDocumento
	 */
	public void setIdDocumento(Integer idDocumento)
	{
		this.idDocumento = idDocumento;
	}

	/** 
	 * Gets the value of idDocumento
	 */
	public Integer getIdDocumento()
	{
		return this.idDocumento;
	}

	/**
	 * Method 'SiceeTDocumentoPk'
	 * 
	 */
	public SiceeTDocumentoPk()
	{
	}

	/**
	 * Method 'SiceeTDocumentoPk'
	 * 
	 * @param idDocumento
	 */
	public SiceeTDocumentoPk(final Integer idDocumento)
	{
		this.idDocumento = idDocumento;
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
		
		if (!(_other instanceof SiceeTDocumentoPk)) {
			return false;
		}
		
		final SiceeTDocumentoPk _cast = (SiceeTDocumentoPk) _other;
		if (this.idDocumento == null ? _cast.idDocumento != this.idDocumento : !this.idDocumento.equals( _cast.idDocumento )) {
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
		if (this.idDocumento != null) {
			_hashCode = 29 * _hashCode + this.idDocumento.hashCode();
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
		ret.append( "it.csi.sicee.siceeweb.business.dao.dto.SiceeTDocumentoPk: " );
		ret.append( "idDocumento=" + this.idDocumento );
		return ret.toString();
	}

}
