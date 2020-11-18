/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceeweb.business.dao.dto;

import java.io.Serializable;

/** 
 * This class represents the primary key of the SICEE_T_VERIFY_REPORT table.
 */
public class SiceeTVerifyReportPk implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 4609031094046913023L;

	protected String idCertificatore;

	protected String progrCertificato;

	protected String anno;

	protected Integer progrVerifyReport;

	/** 
	 * Sets the value of idCertificatore
	 */
	public void setIdCertificatore(String idCertificatore)
	{
		this.idCertificatore = idCertificatore;
	}

	/** 
	 * Gets the value of idCertificatore
	 */
	public String getIdCertificatore()
	{
		return this.idCertificatore;
	}

	/** 
	 * Sets the value of progrCertificato
	 */
	public void setProgrCertificato(String progrCertificato)
	{
		this.progrCertificato = progrCertificato;
	}

	/** 
	 * Gets the value of progrCertificato
	 */
	public String getProgrCertificato()
	{
		return this.progrCertificato;
	}

	/** 
	 * Sets the value of anno
	 */
	public void setAnno(String anno)
	{
		this.anno = anno;
	}

	/** 
	 * Gets the value of anno
	 */
	public String getAnno()
	{
		return this.anno;
	}

	/** 
	 * Sets the value of progrVerifyReport
	 */
	public void setProgrVerifyReport(Integer progrVerifyReport)
	{
		this.progrVerifyReport = progrVerifyReport;
	}

	/** 
	 * Gets the value of progrVerifyReport
	 */
	public Integer getProgrVerifyReport()
	{
		return this.progrVerifyReport;
	}

	/**
	 * Method 'SiceeTVerifyReportPk'
	 * 
	 */
	public SiceeTVerifyReportPk()
	{
	}

	/**
	 * Method 'SiceeTVerifyReportPk'
	 * 
	 * @param idCertificatore
	 * @param progrCertificato
	 * @param anno
	 * @param progrVerifyReport
	 */
	public SiceeTVerifyReportPk(final String idCertificatore, final String progrCertificato, final String anno, final Integer progrVerifyReport)
	{
		this.idCertificatore = idCertificatore;
		this.progrCertificato = progrCertificato;
		this.anno = anno;
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
		
		if (!(_other instanceof SiceeTVerifyReportPk)) {
			return false;
		}
		
		final SiceeTVerifyReportPk _cast = (SiceeTVerifyReportPk) _other;
		if (this.idCertificatore == null ? _cast.idCertificatore != this.idCertificatore : !this.idCertificatore.equals( _cast.idCertificatore )) {
			return false;
		}
		
		if (this.progrCertificato == null ? _cast.progrCertificato != this.progrCertificato : !this.progrCertificato.equals( _cast.progrCertificato )) {
			return false;
		}
		
		if (this.anno == null ? _cast.anno != this.anno : !this.anno.equals( _cast.anno )) {
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
		if (this.idCertificatore != null) {
			_hashCode = 29 * _hashCode + this.idCertificatore.hashCode();
		}
		
		if (this.progrCertificato != null) {
			_hashCode = 29 * _hashCode + this.progrCertificato.hashCode();
		}
		
		if (this.anno != null) {
			_hashCode = 29 * _hashCode + this.anno.hashCode();
		}
		
		if (this.progrVerifyReport != null) {
			_hashCode = 29 * _hashCode + this.progrVerifyReport.hashCode();
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
		ret.append( "it.csi.sicee.siceeweb.business.dao.dto.SiceeTVerifyReportPk: " );
		ret.append( "idCertificatore=" + this.idCertificatore );
		ret.append( ", progrCertificato=" + this.progrCertificato );
		ret.append( ", anno=" + this.anno );
		ret.append( ", progrVerifyReport=" + this.progrVerifyReport );
		return ret.toString();
	}

}
