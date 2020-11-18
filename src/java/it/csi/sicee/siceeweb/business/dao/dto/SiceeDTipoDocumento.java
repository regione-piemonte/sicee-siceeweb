/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceeweb.business.dao.dto;

import java.io.Serializable;

public class SiceeDTipoDocumento implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 9103960230179449642L;

	/** 
	 * This attribute maps to the column ID_TIPO_DOC in the SICEE_D_TIPO_DOCUMENTO table.
	 */
	protected Integer idTipoDoc;

	/** 
	 * This attribute maps to the column DS_TIPO_DOC in the SICEE_D_TIPO_DOCUMENTO table.
	 */
	protected String dsTipoDoc;

	/**
	 * Method 'SiceeDTipoDocumento'
	 * 
	 */
	public SiceeDTipoDocumento()
	{
	}

	/**
	 * Method 'getIdTipoDoc'
	 * 
	 * @return Integer
	 */
	public Integer getIdTipoDoc()
	{
		return this.idTipoDoc;
	}

	/**
	 * Method 'setIdTipoDoc'
	 * 
	 * @param idTipoDoc
	 */
	public void setIdTipoDoc(Integer idTipoDoc)
	{
		this.idTipoDoc = idTipoDoc;
	}

	/**
	 * Method 'getDsTipoDoc'
	 * 
	 * @return String
	 */
	public String getDsTipoDoc()
	{
		return this.dsTipoDoc;
	}

	/**
	 * Method 'setDsTipoDoc'
	 * 
	 * @param dsTipoDoc
	 */
	public void setDsTipoDoc(String dsTipoDoc)
	{
		this.dsTipoDoc = dsTipoDoc;
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
		
		if (!(_other instanceof SiceeDTipoDocumento)) {
			return false;
		}
		
		final SiceeDTipoDocumento _cast = (SiceeDTipoDocumento) _other;
		if (this.idTipoDoc == null ? _cast.idTipoDoc != this.idTipoDoc : !this.idTipoDoc.equals( _cast.idTipoDoc )) {
			return false;
		}
		
		if (this.dsTipoDoc == null ? _cast.dsTipoDoc != this.dsTipoDoc : !this.dsTipoDoc.equals( _cast.dsTipoDoc )) {
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
		
		if (this.dsTipoDoc != null) {
			_hashCode = 29 * _hashCode + this.dsTipoDoc.hashCode();
		}
		
		return _hashCode;
	}

	/**
	 * Method 'createPk'
	 * 
	 * @return SiceeDTipoDocumentoPk
	 */
	public SiceeDTipoDocumentoPk createPk()
	{
		return new SiceeDTipoDocumentoPk(this.idTipoDoc);
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
		ret.append( "it.csi.sicee.siceeweb.business.dao.dto.SiceeDTipoDocumento: " );
		ret.append( "idTipoDoc=" + this.idTipoDoc );
		ret.append( ", dsTipoDoc=" + this.dsTipoDoc );
		return ret.toString();
	}

}
