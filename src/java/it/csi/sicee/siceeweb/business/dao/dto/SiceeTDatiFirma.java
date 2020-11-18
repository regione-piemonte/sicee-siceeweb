/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceeweb.business.dao.dto;

import java.io.Serializable;
import java.util.Date;

public class SiceeTDatiFirma implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 8771438860055597995L;

	/** 
	 * This attribute maps to the column ID_DATI_FIRMA in the SICEE_T_DATI_FIRMA table.
	 */
	protected Integer idDatiFirma;

	/** 
	 * This attribute maps to the column ANNO in the SICEE_T_DATI_FIRMA table.
	 */
	protected String anno;

	/** 
	 * This attribute maps to the column ID_CERTIFICATORE in the SICEE_T_DATI_FIRMA table.
	 */
	protected String idCertificatore;

	/** 
	 * This attribute maps to the column PROGR_CERTIFICATO in the SICEE_T_DATI_FIRMA table.
	 */
	protected String progrCertificato;

	/** 
	 * This attribute maps to the column FK_STATO_FILE in the SICEE_T_DATI_FIRMA table.
	 */
	protected Integer fkStatoFile;

	/** 
	 * This attribute maps to the column ERROR_CODE in the SICEE_T_DATI_FIRMA table.
	 */
	protected Integer errorCode;

	/** 
	 * This attribute maps to the column SURNAME in the SICEE_T_DATI_FIRMA table.
	 */
	protected String surname;

	/** 
	 * This attribute maps to the column GIVEN_NAME in the SICEE_T_DATI_FIRMA table.
	 */
	protected String givenName;

	/** 
	 * This attribute maps to the column SERIAL_NUMBER in the SICEE_T_DATI_FIRMA table.
	 */
	protected String serialNumber;

	/** 
	 * This attribute maps to the column CA in the SICEE_T_DATI_FIRMA table.
	 */
	protected String ca;

	/** 
	 * This attribute maps to the column CODICE_FISCALE in the SICEE_T_DATI_FIRMA table.
	 */
	protected String codiceFiscale;

	/** 
	 * This attribute maps to the column DT_FIRMA in the SICEE_T_DATI_FIRMA table.
	 */
	protected Date dtFirma;

	/** 
	 * This attribute maps to the column DT_VERIFICA in the SICEE_T_DATI_FIRMA table.
	 */
	protected Date dtVerifica;

	/** 
	 * This attribute maps to the column DT_INIZIO_VAL_CERT in the SICEE_T_DATI_FIRMA table.
	 */
	protected Date dtInizioValCert;

	/** 
	 * This attribute maps to the column DT_FINE_VAL_CERT in the SICEE_T_DATI_FIRMA table.
	 */
	protected Date dtFineValCert;

	/** 
	 * This attribute maps to the column PROGR_VERIFY_REPORT in the SICEE_T_DATI_FIRMA table.
	 */
	protected Integer progrVerifyReport;

	/**
	 * Method 'SiceeTDatiFirma'
	 * 
	 */
	public SiceeTDatiFirma()
	{
	}

	/**
	 * Method 'getIdDatiFirma'
	 * 
	 * @return Integer
	 */
	public Integer getIdDatiFirma()
	{
		return this.idDatiFirma;
	}

	/**
	 * Method 'setIdDatiFirma'
	 * 
	 * @param idDatiFirma
	 */
	public void setIdDatiFirma(Integer idDatiFirma)
	{
		this.idDatiFirma = idDatiFirma;
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
	 * Method 'getFkStatoFile'
	 * 
	 * @return Integer
	 */
	public Integer getFkStatoFile()
	{
		return this.fkStatoFile;
	}

	/**
	 * Method 'setFkStatoFile'
	 * 
	 * @param fkStatoFile
	 */
	public void setFkStatoFile(Integer fkStatoFile)
	{
		this.fkStatoFile = fkStatoFile;
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
	 * Method 'getCa'
	 * 
	 * @return String
	 */
	public String getCa()
	{
		return this.ca;
	}

	/**
	 * Method 'setCa'
	 * 
	 * @param ca
	 */
	public void setCa(String ca)
	{
		this.ca = ca;
	}

	/**
	 * Method 'getCodiceFiscale'
	 * 
	 * @return String
	 */
	public String getCodiceFiscale()
	{
		return this.codiceFiscale;
	}

	/**
	 * Method 'setCodiceFiscale'
	 * 
	 * @param codiceFiscale
	 */
	public void setCodiceFiscale(String codiceFiscale)
	{
		this.codiceFiscale = codiceFiscale;
	}

	/**
	 * Method 'getDtFirma'
	 * 
	 * @return Date
	 */
	public Date getDtFirma()
	{
		return this.dtFirma;
	}

	/**
	 * Method 'setDtFirma'
	 * 
	 * @param dtFirma
	 */
	public void setDtFirma(Date dtFirma)
	{
		this.dtFirma = dtFirma;
	}

	/**
	 * Method 'getDtVerifica'
	 * 
	 * @return Date
	 */
	public Date getDtVerifica()
	{
		return this.dtVerifica;
	}

	/**
	 * Method 'setDtVerifica'
	 * 
	 * @param dtVerifica
	 */
	public void setDtVerifica(Date dtVerifica)
	{
		this.dtVerifica = dtVerifica;
	}

	/**
	 * Method 'getDtInizioValCert'
	 * 
	 * @return Date
	 */
	public Date getDtInizioValCert()
	{
		return this.dtInizioValCert;
	}

	/**
	 * Method 'setDtInizioValCert'
	 * 
	 * @param dtInizioValCert
	 */
	public void setDtInizioValCert(Date dtInizioValCert)
	{
		this.dtInizioValCert = dtInizioValCert;
	}

	/**
	 * Method 'getDtFineValCert'
	 * 
	 * @return Date
	 */
	public Date getDtFineValCert()
	{
		return this.dtFineValCert;
	}

	/**
	 * Method 'setDtFineValCert'
	 * 
	 * @param dtFineValCert
	 */
	public void setDtFineValCert(Date dtFineValCert)
	{
		this.dtFineValCert = dtFineValCert;
	}

	/**
	 * Method 'getProgrVerifyReport'
	 * 
	 * @return Integer
	 */
	public Integer getProgrVerifyReport()
	{
		return this.progrVerifyReport;
	}

	/**
	 * Method 'setProgrVerifyReport'
	 * 
	 * @param progrVerifyReport
	 */
	public void setProgrVerifyReport(Integer progrVerifyReport)
	{
		this.progrVerifyReport = progrVerifyReport;
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
		
		if (!(_other instanceof SiceeTDatiFirma)) {
			return false;
		}
		
		final SiceeTDatiFirma _cast = (SiceeTDatiFirma) _other;
		if (this.idDatiFirma == null ? _cast.idDatiFirma != this.idDatiFirma : !this.idDatiFirma.equals( _cast.idDatiFirma )) {
			return false;
		}
		
		if (this.anno == null ? _cast.anno != this.anno : !this.anno.equals( _cast.anno )) {
			return false;
		}
		
		if (this.idCertificatore == null ? _cast.idCertificatore != this.idCertificatore : !this.idCertificatore.equals( _cast.idCertificatore )) {
			return false;
		}
		
		if (this.progrCertificato == null ? _cast.progrCertificato != this.progrCertificato : !this.progrCertificato.equals( _cast.progrCertificato )) {
			return false;
		}
		
		if (this.fkStatoFile == null ? _cast.fkStatoFile != this.fkStatoFile : !this.fkStatoFile.equals( _cast.fkStatoFile )) {
			return false;
		}
		
		if (this.errorCode == null ? _cast.errorCode != this.errorCode : !this.errorCode.equals( _cast.errorCode )) {
			return false;
		}
		
		if (this.surname == null ? _cast.surname != this.surname : !this.surname.equals( _cast.surname )) {
			return false;
		}
		
		if (this.givenName == null ? _cast.givenName != this.givenName : !this.givenName.equals( _cast.givenName )) {
			return false;
		}
		
		if (this.serialNumber == null ? _cast.serialNumber != this.serialNumber : !this.serialNumber.equals( _cast.serialNumber )) {
			return false;
		}
		
		if (this.ca == null ? _cast.ca != this.ca : !this.ca.equals( _cast.ca )) {
			return false;
		}
		
		if (this.codiceFiscale == null ? _cast.codiceFiscale != this.codiceFiscale : !this.codiceFiscale.equals( _cast.codiceFiscale )) {
			return false;
		}
		
		if (this.dtFirma == null ? _cast.dtFirma != this.dtFirma : !this.dtFirma.equals( _cast.dtFirma )) {
			return false;
		}
		
		if (this.dtVerifica == null ? _cast.dtVerifica != this.dtVerifica : !this.dtVerifica.equals( _cast.dtVerifica )) {
			return false;
		}
		
		if (this.dtInizioValCert == null ? _cast.dtInizioValCert != this.dtInizioValCert : !this.dtInizioValCert.equals( _cast.dtInizioValCert )) {
			return false;
		}
		
		if (this.dtFineValCert == null ? _cast.dtFineValCert != this.dtFineValCert : !this.dtFineValCert.equals( _cast.dtFineValCert )) {
			return false;
		}
		
		if (this.progrVerifyReport == null ? _cast.progrVerifyReport != this.progrVerifyReport : !this.progrVerifyReport.equals( _cast.progrVerifyReport )) {
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
		
		if (this.anno != null) {
			_hashCode = 29 * _hashCode + this.anno.hashCode();
		}
		
		if (this.idCertificatore != null) {
			_hashCode = 29 * _hashCode + this.idCertificatore.hashCode();
		}
		
		if (this.progrCertificato != null) {
			_hashCode = 29 * _hashCode + this.progrCertificato.hashCode();
		}
		
		if (this.fkStatoFile != null) {
			_hashCode = 29 * _hashCode + this.fkStatoFile.hashCode();
		}
		
		if (this.errorCode != null) {
			_hashCode = 29 * _hashCode + this.errorCode.hashCode();
		}
		
		if (this.surname != null) {
			_hashCode = 29 * _hashCode + this.surname.hashCode();
		}
		
		if (this.givenName != null) {
			_hashCode = 29 * _hashCode + this.givenName.hashCode();
		}
		
		if (this.serialNumber != null) {
			_hashCode = 29 * _hashCode + this.serialNumber.hashCode();
		}
		
		if (this.ca != null) {
			_hashCode = 29 * _hashCode + this.ca.hashCode();
		}
		
		if (this.codiceFiscale != null) {
			_hashCode = 29 * _hashCode + this.codiceFiscale.hashCode();
		}
		
		if (this.dtFirma != null) {
			_hashCode = 29 * _hashCode + this.dtFirma.hashCode();
		}
		
		if (this.dtVerifica != null) {
			_hashCode = 29 * _hashCode + this.dtVerifica.hashCode();
		}
		
		if (this.dtInizioValCert != null) {
			_hashCode = 29 * _hashCode + this.dtInizioValCert.hashCode();
		}
		
		if (this.dtFineValCert != null) {
			_hashCode = 29 * _hashCode + this.dtFineValCert.hashCode();
		}
		
		if (this.progrVerifyReport != null) {
			_hashCode = 29 * _hashCode + this.progrVerifyReport.hashCode();
		}
		
		return _hashCode;
	}

	/**
	 * Method 'createPk'
	 * 
	 * @return SiceeTDatiFirmaPk
	 */
	public SiceeTDatiFirmaPk createPk()
	{
		return new SiceeTDatiFirmaPk(this.idDatiFirma);
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
		ret.append( "it.csi.sicee.siceeweb.business.dao.dto.SiceeTDatiFirma: " );
		ret.append( "idDatiFirma=" + this.idDatiFirma );
		ret.append( ", anno=" + this.anno );
		ret.append( ", idCertificatore=" + this.idCertificatore );
		ret.append( ", progrCertificato=" + this.progrCertificato );
		ret.append( ", fkStatoFile=" + this.fkStatoFile );
		ret.append( ", errorCode=" + this.errorCode );
		ret.append( ", surname=" + this.surname );
		ret.append( ", givenName=" + this.givenName );
		ret.append( ", serialNumber=" + this.serialNumber );
		ret.append( ", ca=" + this.ca );
		ret.append( ", codiceFiscale=" + this.codiceFiscale );
		ret.append( ", dtFirma=" + this.dtFirma );
		ret.append( ", dtVerifica=" + this.dtVerifica );
		ret.append( ", dtInizioValCert=" + this.dtInizioValCert );
		ret.append( ", dtFineValCert=" + this.dtFineValCert );
		ret.append( ", progrVerifyReport=" + this.progrVerifyReport );
		return ret.toString();
	}

}
