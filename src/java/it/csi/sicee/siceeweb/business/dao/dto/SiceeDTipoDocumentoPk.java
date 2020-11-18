/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceeweb.business.dao.dto;

import java.io.Serializable;

/** 
 * This class represents the primary key of the SICEE_D_TIPO_DOCUMENTO table.
 */
public class SiceeDTipoDocumentoPk implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -8493803996234590325L;
	protected Integer idTipoDoc;

	/** 
	 * Sets the value of idTipoDoc
	 */
	public void setIdTipoDoc(Integer idTipoDoc)
	{
		this.idTipoDoc = idTipoDoc;
	}

	/** 
	 * Gets the value of idTipoDoc
	 */
	public Integer getIdTipoDoc()
	{
		return this.idTipoDoc;
	}

	/**
	 * Method 'SiceeDTipoDocumentoPk'
	 * 
	 */
	public SiceeDTipoDocumentoPk()
	{
	}

	/**
	 * Method 'SiceeDTipoDocumentoPk'
	 * 
	 * @param idTipoDoc
	 */
	public SiceeDTipoDocumentoPk(final Integer idTipoDoc)
	{
		this.idTipoDoc = idTipoDoc;
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
		
		if (!(_other instanceof SiceeDTipoDocumentoPk)) {
			return false;
		}
		
		final SiceeDTipoDocumentoPk _cast = (SiceeDTipoDocumentoPk) _other;
		if (this.idTipoDoc == null ? _cast.idTipoDoc != this.idTipoDoc : !this.idTipoDoc.equals( _cast.idTipoDoc )) {
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
		if (this.idTipoDoc != null) {
			_hashCode = 29 * _hashCode + this.idTipoDoc.hashCode();
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
		ret.append( "it.csi.sicee.siceeweb.business.dao.dto.SiceeDTipoDocumentoPk: " );
		ret.append( "idTipoDoc=" + this.idTipoDoc );
		return ret.toString();
	}

}
