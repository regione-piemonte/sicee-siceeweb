/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceeweb.business.dao.dto;

import java.io.Serializable;

public class SiceeTVerifyReport implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1081957740969781377L;

	/** 
	 * This attribute maps to the column PROGR_VERIFY_REPORT in the SICEE_T_VERIFY_REPORT table.
	 */
	protected Integer progrVerifyReport;

	/** 
	 * This attribute maps to the column ID_CERTIFICATORE in the SICEE_T_VERIFY_REPORT table.
	 */
	protected String idCertificatore;

	/** 
	 * This attribute maps to the column PROGR_CERTIFICATO in the SICEE_T_VERIFY_REPORT table.
	 */
	protected String progrCertificato;

	/** 
	 * This attribute maps to the column ANNO in the SICEE_T_VERIFY_REPORT table.
	 */
	protected String anno;

	/** 
	 * This attribute maps to the column PARAMETRI_INPUT in the SICEE_T_VERIFY_REPORT table.
	 */
	protected Integer parametriInput;

	/** 
	 * This attribute maps to the column FORMATO_FIRMA in the SICEE_T_VERIFY_REPORT table.
	 */
	protected Integer formatoFirma;

	/** 
	 * This attribute maps to the column TIPO_FIRMA in the SICEE_T_VERIFY_REPORT table.
	 */
	protected Integer tipoFirma;

	/** 
	 * This attribute maps to the column NUM_CERTIFICATI_FIRMA in the SICEE_T_VERIFY_REPORT table.
	 */
	protected Integer numCertificatiFirma;

	/** 
	 * This attribute maps to the column NUM_MARCHE in the SICEE_T_VERIFY_REPORT table.
	 */
	protected Integer numMarche;

	/**
	 * Method 'SiceeTVerifyReport'
	 * 
	 */
	public SiceeTVerifyReport()
	{
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
	 * Method 'getParametriInput'
	 * 
	 * @return Integer
	 */
	public Integer getParametriInput()
	{
		return this.parametriInput;
	}

	/**
	 * Method 'setParametriInput'
	 * 
	 * @param parametriInput
	 */
	public void setParametriInput(Integer parametriInput)
	{
		this.parametriInput = parametriInput;
	}

	/**
	 * Method 'getFormatoFirma'
	 * 
	 * @return Integer
	 */
	public Integer getFormatoFirma()
	{
		return this.formatoFirma;
	}

	/**
	 * Method 'setFormatoFirma'
	 * 
	 * @param formatoFirma
	 */
	public void setFormatoFirma(Integer formatoFirma)
	{
		this.formatoFirma = formatoFirma;
	}

	/**
	 * Method 'getTipoFirma'
	 * 
	 * @return Integer
	 */
	public Integer getTipoFirma()
	{
		return this.tipoFirma;
	}

	/**
	 * Method 'setTipoFirma'
	 * 
	 * @param tipoFirma
	 */
	public void setTipoFirma(Integer tipoFirma)
	{
		this.tipoFirma = tipoFirma;
	}

	/**
	 * Method 'getNumCertificatiFirma'
	 * 
	 * @return Integer
	 */
	public Integer getNumCertificatiFirma()
	{
		return this.numCertificatiFirma;
	}

	/**
	 * Method 'setNumCertificatiFirma'
	 * 
	 * @param numCertificatiFirma
	 */
	public void setNumCertificatiFirma(Integer numCertificatiFirma)
	{
		this.numCertificatiFirma = numCertificatiFirma;
	}

	/**
	 * Method 'getNumMarche'
	 * 
	 * @return Integer
	 */
	public Integer getNumMarche()
	{
		return this.numMarche;
	}

	/**
	 * Method 'setNumMarche'
	 * 
	 * @param numMarche
	 */
	public void setNumMarche(Integer numMarche)
	{
		this.numMarche = numMarche;
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
		
		if (!(_other instanceof SiceeTVerifyReport)) {
			return false;
		}
		
		final SiceeTVerifyReport _cast = (SiceeTVerifyReport) _other;
		if (this.progrVerifyReport == null ? _cast.progrVerifyReport != this.progrVerifyReport : !this.progrVerifyReport.equals( _cast.progrVerifyReport )) {
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
		
		if (this.parametriInput == null ? _cast.parametriInput != this.parametriInput : !this.parametriInput.equals( _cast.parametriInput )) {
			return false;
		}
		
		if (this.formatoFirma == null ? _cast.formatoFirma != this.formatoFirma : !this.formatoFirma.equals( _cast.formatoFirma )) {
			return false;
		}
		
		if (this.tipoFirma == null ? _cast.tipoFirma != this.tipoFirma : !this.tipoFirma.equals( _cast.tipoFirma )) {
			return false;
		}
		
		if (this.numCertificatiFirma == null ? _cast.numCertificatiFirma != this.numCertificatiFirma : !this.numCertificatiFirma.equals( _cast.numCertificatiFirma )) {
			return false;
		}
		
		if (this.numMarche == null ? _cast.numMarche != this.numMarche : !this.numMarche.equals( _cast.numMarche )) {
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
		if (this.progrVerifyReport != null) {
			_hashCode = 29 * _hashCode + this.progrVerifyReport.hashCode();
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
		
		if (this.parametriInput != null) {
			_hashCode = 29 * _hashCode + this.parametriInput.hashCode();
		}
		
		if (this.formatoFirma != null) {
			_hashCode = 29 * _hashCode + this.formatoFirma.hashCode();
		}
		
		if (this.tipoFirma != null) {
			_hashCode = 29 * _hashCode + this.tipoFirma.hashCode();
		}
		
		if (this.numCertificatiFirma != null) {
			_hashCode = 29 * _hashCode + this.numCertificatiFirma.hashCode();
		}
		
		if (this.numMarche != null) {
			_hashCode = 29 * _hashCode + this.numMarche.hashCode();
		}
		
		return _hashCode;
	}

	/**
	 * Method 'createPk'
	 * 
	 * @return SiceeTVerifyReportPk
	 */
	public SiceeTVerifyReportPk createPk()
	{
		return new SiceeTVerifyReportPk(this.idCertificatore, this.progrCertificato, this.anno, this.progrVerifyReport);
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
		ret.append( "it.csi.sicee.siceeweb.business.dao.dto.SiceeTVerifyReport: " );
		ret.append( "progrVerifyReport=" + this.progrVerifyReport );
		ret.append( ", idCertificatore=" + this.idCertificatore );
		ret.append( ", progrCertificato=" + this.progrCertificato );
		ret.append( ", anno=" + this.anno );
		ret.append( ", parametriInput=" + this.parametriInput );
		ret.append( ", formatoFirma=" + this.formatoFirma );
		ret.append( ", tipoFirma=" + this.tipoFirma );
		ret.append( ", numCertificatiFirma=" + this.numCertificatiFirma );
		ret.append( ", numMarche=" + this.numMarche );
		return ret.toString();
	}

}
