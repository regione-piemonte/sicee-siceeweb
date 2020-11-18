/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceeweb.business.dao.dto;

import java.io.Serializable;
import java.util.Date;

public class SiceeTDocumento implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -4991308590750736052L;

	/** 
	 * This attribute maps to the column ID_DOCUMENTO in the SICEE_T_DOCUMENTO table.
	 */
	protected Integer idDocumento;

	/** 
	 * This attribute maps to the column ID_CERTIFICATORE in the SICEE_T_DOCUMENTO table.
	 */
	protected String idCertificatore;

	/** 
	 * This attribute maps to the column ID_TIPO_DOC in the SICEE_T_DOCUMENTO table.
	 */
	protected Integer idTipoDoc;

	/** 
	 * This attribute maps to the column IDENTIFIC_DOC in the SICEE_T_DOCUMENTO table.
	 */
	protected String identificDoc;

	/** 
	 * This attribute maps to the column DT_UPLOAD in the SICEE_T_DOCUMENTO table.
	 */
	protected Date dtUpload;

	/** 
	 * This attribute maps to the column NOME_FILE in the SICEE_T_DOCUMENTO table.
	 */
	protected String nomeFile;

	/** 
	 * This attribute maps to the column FK_CORSO in the SICEE_T_DOCUMENTO table.
	 */
	protected Integer fkCorso;

	/**
	 * Method 'SiceeTDocumento'
	 * 
	 */
	public SiceeTDocumento()
	{
	}

	/**
	 * Method 'getIdDocumento'
	 * 
	 * @return Integer
	 */
	public Integer getIdDocumento()
	{
		return this.idDocumento;
	}

	/**
	 * Method 'setIdDocumento'
	 * 
	 * @param idDocumento
	 */
	public void setIdDocumento(Integer idDocumento)
	{
		this.idDocumento = idDocumento;
	}

	/**
	 * Method 'getIdCertificatore'
	 * 
	 * @return String
	 */
	public String getIdCertificatore()
	{
		return this.idCertificatore;
	}

	/**
	 * Method 'setIdCertificatore'
	 * 
	 * @param idCertificatore
	 */
	public void setIdCertificatore(String idCertificatore)
	{
		this.idCertificatore = idCertificatore;
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
	 * Method 'getIdentificDoc'
	 * 
	 * @return String
	 */
	public String getIdentificDoc()
	{
		return this.identificDoc;
	}

	/**
	 * Method 'setIdentificDoc'
	 * 
	 * @param identificDoc
	 */
	public void setIdentificDoc(String identificDoc)
	{
		this.identificDoc = identificDoc;
	}

	/**
	 * Method 'getDtUpload'
	 * 
	 * @return Date
	 */
	public Date getDtUpload()
	{
		return this.dtUpload;
	}

	/**
	 * Method 'setDtUpload'
	 * 
	 * @param dtUpload
	 */
	public void setDtUpload(Date dtUpload)
	{
		this.dtUpload = dtUpload;
	}

	/**
	 * Method 'getNomeFile'
	 * 
	 * @return String
	 */
	public String getNomeFile()
	{
		return this.nomeFile;
	}

	/**
	 * Method 'setNomeFile'
	 * 
	 * @param nomeFile
	 */
	public void setNomeFile(String nomeFile)
	{
		this.nomeFile = nomeFile;
	}

	/**
	 * Method 'getFkCorso'
	 * 
	 * @return Integer
	 */
	public Integer getFkCorso()
	{
		return this.fkCorso;
	}

	/**
	 * Method 'setFkCorso'
	 * 
	 * @param fkCorso
	 */
	public void setFkCorso(Integer fkCorso)
	{
		this.fkCorso = fkCorso;
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
		
		if (!(_other instanceof SiceeTDocumento)) {
			return false;
		}
		
		final SiceeTDocumento _cast = (SiceeTDocumento) _other;
		if (this.idDocumento == null ? _cast.idDocumento != this.idDocumento : !this.idDocumento.equals( _cast.idDocumento )) {
			return false;
		}
		
		if (this.idCertificatore == null ? _cast.idCertificatore != this.idCertificatore : !this.idCertificatore.equals( _cast.idCertificatore )) {
			return false;
		}
		
		if (this.idTipoDoc == null ? _cast.idTipoDoc != this.idTipoDoc : !this.idTipoDoc.equals( _cast.idTipoDoc )) {
			return false;
		}
		
		if (this.identificDoc == null ? _cast.identificDoc != this.identificDoc : !this.identificDoc.equals( _cast.identificDoc )) {
			return false;
		}
		
		if (this.dtUpload == null ? _cast.dtUpload != this.dtUpload : !this.dtUpload.equals( _cast.dtUpload )) {
			return false;
		}
		
		if (this.nomeFile == null ? _cast.nomeFile != this.nomeFile : !this.nomeFile.equals( _cast.nomeFile )) {
			return false;
		}
		
		if (this.fkCorso == null ? _cast.fkCorso != this.fkCorso : !this.fkCorso.equals( _cast.fkCorso )) {
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
		
		if (this.idCertificatore != null) {
			_hashCode = 29 * _hashCode + this.idCertificatore.hashCode();
		}
		
		if (this.idTipoDoc != null) {
			_hashCode = 29 * _hashCode + this.idTipoDoc.hashCode();
		}
		
		if (this.identificDoc != null) {
			_hashCode = 29 * _hashCode + this.identificDoc.hashCode();
		}
		
		if (this.dtUpload != null) {
			_hashCode = 29 * _hashCode + this.dtUpload.hashCode();
		}
		
		if (this.nomeFile != null) {
			_hashCode = 29 * _hashCode + this.nomeFile.hashCode();
		}
		
		if (this.fkCorso != null) {
			_hashCode = 29 * _hashCode + this.fkCorso.hashCode();
		}
		
		return _hashCode;
	}

	/**
	 * Method 'createPk'
	 * 
	 * @return SiceeTDocumentoPk
	 */
	public SiceeTDocumentoPk createPk()
	{
		return new SiceeTDocumentoPk(this.idDocumento);
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
		ret.append( "it.csi.sicee.siceeweb.business.dao.dto.SiceeTDocumento: " );
		ret.append( "idDocumento=" + this.idDocumento );
		ret.append( ", idCertificatore=" + this.idCertificatore );
		ret.append( ", idTipoDoc=" + this.idTipoDoc );
		ret.append( ", identificDoc=" + this.identificDoc );
		ret.append( ", dtUpload=" + this.dtUpload );
		ret.append( ", nomeFile=" + this.nomeFile );
		return ret.toString();
	}

}
