/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceeweb.business.dao.dto;

import java.io.Serializable;
import java.util.Date;

public class SiceeTFirmaMarca implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -4610112911189889019L;

	/** 
	 * This attribute maps to the column ID_FIRMA_MARCA in the SICEE_T_FIRMA_MARCA table.
	 */
	protected Long idFirmaMarca;

	/** 
	 * This attribute maps to the column ID_CERTIFICATORE in the SICEE_T_FIRMA_MARCA table.
	 */
	protected String idCertificatore;

	/** 
	 * This attribute maps to the column PROGR_CERTIFICATO in the SICEE_T_FIRMA_MARCA table.
	 */
	protected String progrCertificato;

	/** 
	 * This attribute maps to the column ANNO in the SICEE_T_FIRMA_MARCA table.
	 */
	protected String anno;

	/** 
	 * This attribute maps to the column PROGR_SIGNANDCERT in the SICEE_T_FIRMA_MARCA table.
	 */
	protected Integer progrSignandcert;

	/** 
	 * This attribute maps to the column CERTIFICATE_TYPE in the SICEE_T_FIRMA_MARCA table.
	 */
	protected Integer certificateType;

	/** 
	 * This attribute maps to the column COMPLIANCE in the SICEE_T_FIRMA_MARCA table.
	 */
	protected String compliance;

	/** 
	 * This attribute maps to the column DATE_TIME_SIGNATURE in the SICEE_T_FIRMA_MARCA table.
	 */
	protected Date dateTimeSignature;

	/** 
	 * This attribute maps to the column DIGEST_ALGORITHM in the SICEE_T_FIRMA_MARCA table.
	 */
	protected String digestAlgorithm;

	/** 
	 * This attribute maps to the column ERROR_CODE_FIRMA in the SICEE_T_FIRMA_MARCA table.
	 */
	protected Integer errorCodeFirma;

	/** 
	 * This attribute maps to the column GIVEN_NAME in the SICEE_T_FIRMA_MARCA table.
	 */
	protected String givenName;

	/** 
	 * This attribute maps to the column SURNAME in the SICEE_T_FIRMA_MARCA table.
	 */
	protected String surname;

	/** 
	 * This attribute maps to the column TAX_CODE in the SICEE_T_FIRMA_MARCA table.
	 */
	protected String taxCode;

	/** 
	 * This attribute maps to the column REVOCATION_DATE in the SICEE_T_FIRMA_MARCA table.
	 */
	protected Date revocationDate;

	/** 
	 * This attribute maps to the column CERTIFICATION_AUTHORITY in the SICEE_T_FIRMA_MARCA table.
	 */
	protected String certificationAuthority;

	/** 
	 * This attribute maps to the column ERROR_CODE_CERTIFICATO in the SICEE_T_FIRMA_MARCA table.
	 */
	protected Integer errorCodeCertificato;

	/** 
	 * This attribute maps to the column SERIAL_NUMBER in the SICEE_T_FIRMA_MARCA table.
	 */
	protected String serialNumber;

	/** 
	 * This attribute maps to the column VALID_FROM in the SICEE_T_FIRMA_MARCA table.
	 */
	protected Date validFrom;

	/** 
	 * This attribute maps to the column VALID_TO in the SICEE_T_FIRMA_MARCA table.
	 */
	protected Date validTo;

	/**
	 * Method 'SiceeTFirmaMarca'
	 * 
	 */
	public SiceeTFirmaMarca()
	{
	}

	/**
	 * Method 'getIdFirmaMarca'
	 * 
	 * @return Long
	 */
	public Long getIdFirmaMarca()
	{
		return this.idFirmaMarca;
	}

	/**
	 * Method 'setIdFirmaMarca'
	 * 
	 * @param idFirmaMarca
	 */
	public void setIdFirmaMarca(Long idFirmaMarca)
	{
		this.idFirmaMarca = idFirmaMarca;
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
	 * Method 'getCertificateType'
	 * 
	 * @return Integer
	 */
	public Integer getCertificateType()
	{
		return this.certificateType;
	}

	/**
	 * Method 'setCertificateType'
	 * 
	 * @param certificateType
	 */
	public void setCertificateType(Integer certificateType)
	{
		this.certificateType = certificateType;
	}

	/**
	 * Method 'getCompliance'
	 * 
	 * @return String
	 */
	public String getCompliance()
	{
		return this.compliance;
	}

	/**
	 * Method 'setCompliance'
	 * 
	 * @param compliance
	 */
	public void setCompliance(String compliance)
	{
		this.compliance = compliance;
	}

	/**
	 * Method 'getDateTimeSignature'
	 * 
	 * @return Date
	 */
	public Date getDateTimeSignature()
	{
		return this.dateTimeSignature;
	}

	/**
	 * Method 'setDateTimeSignature'
	 * 
	 * @param dateTimeSignature
	 */
	public void setDateTimeSignature(Date dateTimeSignature)
	{
		this.dateTimeSignature = dateTimeSignature;
	}

	/**
	 * Method 'getDigestAlgorithm'
	 * 
	 * @return String
	 */
	public String getDigestAlgorithm()
	{
		return this.digestAlgorithm;
	}

	/**
	 * Method 'setDigestAlgorithm'
	 * 
	 * @param digestAlgorithm
	 */
	public void setDigestAlgorithm(String digestAlgorithm)
	{
		this.digestAlgorithm = digestAlgorithm;
	}

	/**
	 * Method 'getErrorCodeFirma'
	 * 
	 * @return Integer
	 */
	public Integer getErrorCodeFirma()
	{
		return this.errorCodeFirma;
	}

	/**
	 * Method 'setErrorCodeFirma'
	 * 
	 * @param errorCodeFirma
	 */
	public void setErrorCodeFirma(Integer errorCodeFirma)
	{
		this.errorCodeFirma = errorCodeFirma;
	}

	/**
	 * Method 'getGivenName'
	 * 
	 * @return String
	 */
	public String getGivenName()
	{
		return this.givenName;
	}

	/**
	 * Method 'setGivenName'
	 * 
	 * @param givenName
	 */
	public void setGivenName(String givenName)
	{
		this.givenName = givenName;
	}

	/**
	 * Method 'getSurname'
	 * 
	 * @return String
	 */
	public String getSurname()
	{
		return this.surname;
	}

	/**
	 * Method 'setSurname'
	 * 
	 * @param surname
	 */
	public void setSurname(String surname)
	{
		this.surname = surname;
	}

	/**
	 * Method 'getTaxCode'
	 * 
	 * @return String
	 */
	public String getTaxCode()
	{
		return this.taxCode;
	}

	/**
	 * Method 'setTaxCode'
	 * 
	 * @param taxCode
	 */
	public void setTaxCode(String taxCode)
	{
		this.taxCode = taxCode;
	}

	/**
	 * Method 'getRevocationDate'
	 * 
	 * @return Date
	 */
	public Date getRevocationDate()
	{
		return this.revocationDate;
	}

	/**
	 * Method 'setRevocationDate'
	 * 
	 * @param revocationDate
	 */
	public void setRevocationDate(Date revocationDate)
	{
		this.revocationDate = revocationDate;
	}

	/**
	 * Method 'getCertificationAuthority'
	 * 
	 * @return String
	 */
	public String getCertificationAuthority()
	{
		return this.certificationAuthority;
	}

	/**
	 * Method 'setCertificationAuthority'
	 * 
	 * @param certificationAuthority
	 */
	public void setCertificationAuthority(String certificationAuthority)
	{
		this.certificationAuthority = certificationAuthority;
	}

	/**
	 * Method 'getErrorCodeCertificato'
	 * 
	 * @return Integer
	 */
	public Integer getErrorCodeCertificato()
	{
		return this.errorCodeCertificato;
	}

	/**
	 * Method 'setErrorCodeCertificato'
	 * 
	 * @param errorCodeCertificato
	 */
	public void setErrorCodeCertificato(Integer errorCodeCertificato)
	{
		this.errorCodeCertificato = errorCodeCertificato;
	}

	/**
	 * Method 'getSerialNumber'
	 * 
	 * @return String
	 */
	public String getSerialNumber()
	{
		return this.serialNumber;
	}

	/**
	 * Method 'setSerialNumber'
	 * 
	 * @param serialNumber
	 */
	public void setSerialNumber(String serialNumber)
	{
		this.serialNumber = serialNumber;
	}

	/**
	 * Method 'getValidFrom'
	 * 
	 * @return Date
	 */
	public Date getValidFrom()
	{
		return this.validFrom;
	}

	/**
	 * Method 'setValidFrom'
	 * 
	 * @param validFrom
	 */
	public void setValidFrom(Date validFrom)
	{
		this.validFrom = validFrom;
	}

	/**
	 * Method 'getValidTo'
	 * 
	 * @return Date
	 */
	public Date getValidTo()
	{
		return this.validTo;
	}

	/**
	 * Method 'setValidTo'
	 * 
	 * @param validTo
	 */
	public void setValidTo(Date validTo)
	{
		this.validTo = validTo;
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
		
		if (!(_other instanceof SiceeTFirmaMarca)) {
			return false;
		}
		
		final SiceeTFirmaMarca _cast = (SiceeTFirmaMarca) _other;
		if (this.idFirmaMarca == null ? _cast.idFirmaMarca != this.idFirmaMarca : !this.idFirmaMarca.equals( _cast.idFirmaMarca )) {
			return false;
		}
		
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
		
		if (this.certificateType == null ? _cast.certificateType != this.certificateType : !this.certificateType.equals( _cast.certificateType )) {
			return false;
		}
		
		if (this.compliance == null ? _cast.compliance != this.compliance : !this.compliance.equals( _cast.compliance )) {
			return false;
		}
		
		if (this.dateTimeSignature == null ? _cast.dateTimeSignature != this.dateTimeSignature : !this.dateTimeSignature.equals( _cast.dateTimeSignature )) {
			return false;
		}
		
		if (this.digestAlgorithm == null ? _cast.digestAlgorithm != this.digestAlgorithm : !this.digestAlgorithm.equals( _cast.digestAlgorithm )) {
			return false;
		}
		
		if (this.errorCodeFirma == null ? _cast.errorCodeFirma != this.errorCodeFirma : !this.errorCodeFirma.equals( _cast.errorCodeFirma )) {
			return false;
		}
		
		if (this.givenName == null ? _cast.givenName != this.givenName : !this.givenName.equals( _cast.givenName )) {
			return false;
		}
		
		if (this.surname == null ? _cast.surname != this.surname : !this.surname.equals( _cast.surname )) {
			return false;
		}
		
		if (this.taxCode == null ? _cast.taxCode != this.taxCode : !this.taxCode.equals( _cast.taxCode )) {
			return false;
		}
		
		if (this.revocationDate == null ? _cast.revocationDate != this.revocationDate : !this.revocationDate.equals( _cast.revocationDate )) {
			return false;
		}
		
		if (this.certificationAuthority == null ? _cast.certificationAuthority != this.certificationAuthority : !this.certificationAuthority.equals( _cast.certificationAuthority )) {
			return false;
		}
		
		if (this.errorCodeCertificato == null ? _cast.errorCodeCertificato != this.errorCodeCertificato : !this.errorCodeCertificato.equals( _cast.errorCodeCertificato )) {
			return false;
		}
		
		if (this.serialNumber == null ? _cast.serialNumber != this.serialNumber : !this.serialNumber.equals( _cast.serialNumber )) {
			return false;
		}
		
		if (this.validFrom == null ? _cast.validFrom != this.validFrom : !this.validFrom.equals( _cast.validFrom )) {
			return false;
		}
		
		if (this.validTo == null ? _cast.validTo != this.validTo : !this.validTo.equals( _cast.validTo )) {
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
		if (this.idFirmaMarca != null) {
			_hashCode = 29 * _hashCode + this.idFirmaMarca.hashCode();
		}
		
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
		
		if (this.certificateType != null) {
			_hashCode = 29 * _hashCode + this.certificateType.hashCode();
		}
		
		if (this.compliance != null) {
			_hashCode = 29 * _hashCode + this.compliance.hashCode();
		}
		
		if (this.dateTimeSignature != null) {
			_hashCode = 29 * _hashCode + this.dateTimeSignature.hashCode();
		}
		
		if (this.digestAlgorithm != null) {
			_hashCode = 29 * _hashCode + this.digestAlgorithm.hashCode();
		}
		
		if (this.errorCodeFirma != null) {
			_hashCode = 29 * _hashCode + this.errorCodeFirma.hashCode();
		}
		
		if (this.givenName != null) {
			_hashCode = 29 * _hashCode + this.givenName.hashCode();
		}
		
		if (this.surname != null) {
			_hashCode = 29 * _hashCode + this.surname.hashCode();
		}
		
		if (this.taxCode != null) {
			_hashCode = 29 * _hashCode + this.taxCode.hashCode();
		}
		
		if (this.revocationDate != null) {
			_hashCode = 29 * _hashCode + this.revocationDate.hashCode();
		}
		
		if (this.certificationAuthority != null) {
			_hashCode = 29 * _hashCode + this.certificationAuthority.hashCode();
		}
		
		if (this.errorCodeCertificato != null) {
			_hashCode = 29 * _hashCode + this.errorCodeCertificato.hashCode();
		}
		
		if (this.serialNumber != null) {
			_hashCode = 29 * _hashCode + this.serialNumber.hashCode();
		}
		
		if (this.validFrom != null) {
			_hashCode = 29 * _hashCode + this.validFrom.hashCode();
		}
		
		if (this.validTo != null) {
			_hashCode = 29 * _hashCode + this.validTo.hashCode();
		}
		
		return _hashCode;
	}

	/**
	 * Method 'createPk'
	 * 
	 * @return SiceeTFirmaMarcaPk
	 */
	public SiceeTFirmaMarcaPk createPk()
	{
		return new SiceeTFirmaMarcaPk(this.idFirmaMarca);
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
		ret.append( "it.csi.sicee.siceeweb.business.dao.dto.SiceeTFirmaMarca: " );
		ret.append( "idFirmaMarca=" + this.idFirmaMarca );
		ret.append( ", idCertificatore=" + this.idCertificatore );
		ret.append( ", progrCertificato=" + this.progrCertificato );
		ret.append( ", anno=" + this.anno );
		ret.append( ", progrSignandcert=" + this.progrSignandcert );
		ret.append( ", certificateType=" + this.certificateType );
		ret.append( ", compliance=" + this.compliance );
		ret.append( ", dateTimeSignature=" + this.dateTimeSignature );
		ret.append( ", digestAlgorithm=" + this.digestAlgorithm );
		ret.append( ", errorCodeFirma=" + this.errorCodeFirma );
		ret.append( ", givenName=" + this.givenName );
		ret.append( ", surname=" + this.surname );
		ret.append( ", taxCode=" + this.taxCode );
		ret.append( ", revocationDate=" + this.revocationDate );
		ret.append( ", certificationAuthority=" + this.certificationAuthority );
		ret.append( ", errorCodeCertificato=" + this.errorCodeCertificato );
		ret.append( ", serialNumber=" + this.serialNumber );
		ret.append( ", validFrom=" + this.validFrom );
		ret.append( ", validTo=" + this.validTo );
		return ret.toString();
	}

}
