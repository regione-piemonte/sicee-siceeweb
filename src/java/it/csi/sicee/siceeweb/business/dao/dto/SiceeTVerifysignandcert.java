/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceeweb.business.dao.dto;

import java.io.Serializable;
import java.util.Date;

public class SiceeTVerifysignandcert implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 8042963004528559124L;

	/** 
	 * This attribute maps to the column ID_CERTIFICATORE in the SICEE_T_VERIFYSIGNANDCERT table.
	 */
	protected String idCertificatore;

	/** 
	 * This attribute maps to the column PROGR_CERTIFICATO in the SICEE_T_VERIFYSIGNANDCERT table.
	 */
	protected String progrCertificato;

	/** 
	 * This attribute maps to the column ANNO in the SICEE_T_VERIFYSIGNANDCERT table.
	 */
	protected String anno;

	/** 
	 * This attribute maps to the column PROGR_SIGNANDCERT in the SICEE_T_VERIFYSIGNANDCERT table.
	 */
	protected Integer progrSignandcert;

	/** 
	 * This attribute maps to the column ERROR_CODE in the SICEE_T_VERIFYSIGNANDCERT table.
	 */
	protected Integer errorCode;

	/** 
	 * This attribute maps to the column TOT_NUM_SIGNATURE in the SICEE_T_VERIFYSIGNANDCERT table.
	 */
	protected Integer totNumSignature;

	/** 
	 * This attribute maps to the column TOT_NUM_TIMESTAMP in the SICEE_T_VERIFYSIGNANDCERT table.
	 */
	protected Integer totNumTimestamp;

	/** 
	 * This attribute maps to the column VERIFICATION_DATE in the SICEE_T_VERIFYSIGNANDCERT table.
	 */
	protected Date verificationDate;

	/** 
	 * This attribute maps to the column DELIBERATION_COMPLIANT in the SICEE_T_VERIFYSIGNANDCERT table.
	 */
	protected String deliberationCompliant;

	/** 
	 * This attribute maps to the column FILE_TYPE in the SICEE_T_VERIFYSIGNANDCERT table.
	 */
	protected Integer fileType;

	/** 
	 * This attribute maps to the column SIGNATURE_TYPE in the SICEE_T_VERIFYSIGNANDCERT table.
	 */
	protected Integer signatureType;

	/** 
	 * This attribute maps to the column SIGNATURE_FORMAT in the SICEE_T_VERIFYSIGNANDCERT table.
	 */
	protected Integer signatureFormat;

	/**
	 * Method 'SiceeTVerifysignandcert'
	 * 
	 */
	public SiceeTVerifysignandcert()
	{
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
	 * Method 'getProgrCertificato'
	 * 
	 * @return String
	 */
	public String getProgrCertificato()
	{
		return this.progrCertificato;
	}

	/**
	 * Method 'setProgrCertificato'
	 * 
	 * @param progrCertificato
	 */
	public void setProgrCertificato(String progrCertificato)
	{
		this.progrCertificato = progrCertificato;
	}

	/**
	 * Method 'getAnno'
	 * 
	 * @return String
	 */
	public String getAnno()
	{
		return this.anno;
	}

	/**
	 * Method 'setAnno'
	 * 
	 * @param anno
	 */
	public void setAnno(String anno)
	{
		this.anno = anno;
	}

	/**
	 * Method 'getProgrSignandcert'
	 * 
	 * @return Integer
	 */
	public Integer getProgrSignandcert()
	{
		return this.progrSignandcert;
	}

	/**
	 * Method 'setProgrSignandcert'
	 * 
	 * @param progrSignandcert
	 */
	public void setProgrSignandcert(Integer progrSignandcert)
	{
		this.progrSignandcert = progrSignandcert;
	}

	/**
	 * Method 'getErrorCode'
	 * 
	 * @return Integer
	 */
	public Integer getErrorCode()
	{
		return this.errorCode;
	}

	/**
	 * Method 'setErrorCode'
	 * 
	 * @param errorCode
	 */
	public void setErrorCode(Integer errorCode)
	{
		this.errorCode = errorCode;
	}

	/**
	 * Method 'getTotNumSignature'
	 * 
	 * @return Integer
	 */
	public Integer getTotNumSignature()
	{
		return this.totNumSignature;
	}

	/**
	 * Method 'setTotNumSignature'
	 * 
	 * @param totNumSignature
	 */
	public void setTotNumSignature(Integer totNumSignature)
	{
		this.totNumSignature = totNumSignature;
	}

	/**
	 * Method 'getTotNumTimestamp'
	 * 
	 * @return Integer
	 */
	public Integer getTotNumTimestamp()
	{
		return this.totNumTimestamp;
	}

	/**
	 * Method 'setTotNumTimestamp'
	 * 
	 * @param totNumTimestamp
	 */
	public void setTotNumTimestamp(Integer totNumTimestamp)
	{
		this.totNumTimestamp = totNumTimestamp;
	}

	/**
	 * Method 'getVerificationDate'
	 * 
	 * @return Date
	 */
	public Date getVerificationDate()
	{
		return this.verificationDate;
	}

	/**
	 * Method 'setVerificationDate'
	 * 
	 * @param verificationDate
	 */
	public void setVerificationDate(Date verificationDate)
	{
		this.verificationDate = verificationDate;
	}

	/**
	 * Method 'getDeliberationCompliant'
	 * 
	 * @return String
	 */
	public String getDeliberationCompliant()
	{
		return this.deliberationCompliant;
	}

	/**
	 * Method 'setDeliberationCompliant'
	 * 
	 * @param deliberationCompliant
	 */
	public void setDeliberationCompliant(String deliberationCompliant)
	{
		this.deliberationCompliant = deliberationCompliant;
	}

	/**
	 * Method 'getFileType'
	 * 
	 * @return Integer
	 */
	public Integer getFileType()
	{
		return this.fileType;
	}

	/**
	 * Method 'setFileType'
	 * 
	 * @param fileType
	 */
	public void setFileType(Integer fileType)
	{
		this.fileType = fileType;
	}

	/**
	 * Method 'getSignatureType'
	 * 
	 * @return Integer
	 */
	public Integer getSignatureType()
	{
		return this.signatureType;
	}

	/**
	 * Method 'setSignatureType'
	 * 
	 * @param signatureType
	 */
	public void setSignatureType(Integer signatureType)
	{
		this.signatureType = signatureType;
	}

	/**
	 * Method 'getSignatureFormat'
	 * 
	 * @return Integer
	 */
	public Integer getSignatureFormat()
	{
		return this.signatureFormat;
	}

	/**
	 * Method 'setSignatureFormat'
	 * 
	 * @param signatureFormat
	 */
	public void setSignatureFormat(Integer signatureFormat)
	{
		this.signatureFormat = signatureFormat;
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
		
		if (!(_other instanceof SiceeTVerifysignandcert)) {
			return false;
		}
		
		final SiceeTVerifysignandcert _cast = (SiceeTVerifysignandcert) _other;
		if (this.idCertificatore == null ? _cast.idCertificatore != this.idCertificatore : !this.idCertificatore.equals( _cast.idCertificatore )) {
			return false;
		}
		
		if (this.progrCertificato == null ? _cast.progrCertificato != this.progrCertificato : !this.progrCertificato.equals( _cast.progrCertificato )) {
			return false;
		}
		
		if (this.anno == null ? _cast.anno != this.anno : !this.anno.equals( _cast.anno )) {
			return false;
		}
		
		if (this.progrSignandcert == null ? _cast.progrSignandcert != this.progrSignandcert : !this.progrSignandcert.equals( _cast.progrSignandcert )) {
			return false;
		}
		
		if (this.errorCode == null ? _cast.errorCode != this.errorCode : !this.errorCode.equals( _cast.errorCode )) {
			return false;
		}
		
		if (this.totNumSignature == null ? _cast.totNumSignature != this.totNumSignature : !this.totNumSignature.equals( _cast.totNumSignature )) {
			return false;
		}
		
		if (this.totNumTimestamp == null ? _cast.totNumTimestamp != this.totNumTimestamp : !this.totNumTimestamp.equals( _cast.totNumTimestamp )) {
			return false;
		}
		
		if (this.verificationDate == null ? _cast.verificationDate != this.verificationDate : !this.verificationDate.equals( _cast.verificationDate )) {
			return false;
		}
		
		if (this.deliberationCompliant == null ? _cast.deliberationCompliant != this.deliberationCompliant : !this.deliberationCompliant.equals( _cast.deliberationCompliant )) {
			return false;
		}
		
		if (this.fileType == null ? _cast.fileType != this.fileType : !this.fileType.equals( _cast.fileType )) {
			return false;
		}
		
		if (this.signatureType == null ? _cast.signatureType != this.signatureType : !this.signatureType.equals( _cast.signatureType )) {
			return false;
		}
		
		if (this.signatureFormat == null ? _cast.signatureFormat != this.signatureFormat : !this.signatureFormat.equals( _cast.signatureFormat )) {
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
		if (this.idCertificatore != null) {
			_hashCode = 29 * _hashCode + this.idCertificatore.hashCode();
		}
		
		if (this.progrCertificato != null) {
			_hashCode = 29 * _hashCode + this.progrCertificato.hashCode();
		}
		
		if (this.anno != null) {
			_hashCode = 29 * _hashCode + this.anno.hashCode();
		}
		
		if (this.progrSignandcert != null) {
			_hashCode = 29 * _hashCode + this.progrSignandcert.hashCode();
		}
		
		if (this.errorCode != null) {
			_hashCode = 29 * _hashCode + this.errorCode.hashCode();
		}
		
		if (this.totNumSignature != null) {
			_hashCode = 29 * _hashCode + this.totNumSignature.hashCode();
		}
		
		if (this.totNumTimestamp != null) {
			_hashCode = 29 * _hashCode + this.totNumTimestamp.hashCode();
		}
		
		if (this.verificationDate != null) {
			_hashCode = 29 * _hashCode + this.verificationDate.hashCode();
		}
		
		if (this.deliberationCompliant != null) {
			_hashCode = 29 * _hashCode + this.deliberationCompliant.hashCode();
		}
		
		if (this.fileType != null) {
			_hashCode = 29 * _hashCode + this.fileType.hashCode();
		}
		
		if (this.signatureType != null) {
			_hashCode = 29 * _hashCode + this.signatureType.hashCode();
		}
		
		if (this.signatureFormat != null) {
			_hashCode = 29 * _hashCode + this.signatureFormat.hashCode();
		}
		
		return _hashCode;
	}

	/**
	 * Method 'createPk'
	 * 
	 * @return SiceeTVerifysignandcertPk
	 */
	public SiceeTVerifysignandcertPk createPk()
	{
		return new SiceeTVerifysignandcertPk(this.idCertificatore, this.progrCertificato, this.anno, this.progrSignandcert);
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
		ret.append( "it.csi.sicee.siceeweb.business.dao.dto.SiceeTVerifysignandcert: " );
		ret.append( "idCertificatore=" + this.idCertificatore );
		ret.append( ", progrCertificato=" + this.progrCertificato );
		ret.append( ", anno=" + this.anno );
		ret.append( ", progrSignandcert=" + this.progrSignandcert );
		ret.append( ", errorCode=" + this.errorCode );
		ret.append( ", totNumSignature=" + this.totNumSignature );
		ret.append( ", totNumTimestamp=" + this.totNumTimestamp );
		ret.append( ", verificationDate=" + this.verificationDate );
		ret.append( ", deliberationCompliant=" + this.deliberationCompliant );
		ret.append( ", fileType=" + this.fileType );
		ret.append( ", signatureType=" + this.signatureType );
		ret.append( ", signatureFormat=" + this.signatureFormat );
		return ret.toString();
	}

}
