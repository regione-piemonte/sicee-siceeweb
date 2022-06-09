/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceeweb.business.dao.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

/** 
 * This class represents the primary key of the SICEE_L_HASH_XML_IMPORT table.
 */
public class SiceeLHashXmlImportPk implements Serializable
{
	protected Date dataImport;

	protected String idCertificatore;

	protected String progrCertificato;

	protected String anno;

	public Date getDataImport() {
		return dataImport;
	}

	public void getDataImport(Timestamp dataImport) {
		this.dataImport = dataImport;
	}
	
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
		return idCertificatore;
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
		return progrCertificato;
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
		return anno;
	}

	/**
	 * Method 'SiceeTActaPk'
	 * 
	 */
	public SiceeLHashXmlImportPk()
	{
	}

	/**
	 * Method 'SiceeTActaPk'
	 * 
	 * @param idCertificatore
	 * @param progrCertificato
	 * @param anno
	 */
	public SiceeLHashXmlImportPk(final Date dataImport, final String idCertificatore, final String progrCertificato, final String anno)
	{
		this.dataImport = dataImport;
		this.idCertificatore = idCertificatore;
		this.progrCertificato = progrCertificato;
		this.anno = anno;
	}

	/**
	 * Method 'equals'
	 * 
	 * @param _other
	 * @return boolean
	 */
	public boolean equals(Object _other)
	{
		if (_other == null) {
			return false;
		}
		
		if (_other == this) {
			return true;
		}
		
		if (!(_other instanceof SiceeLHashXmlImportPk)) {
			return false;
		}
		
		final SiceeLHashXmlImportPk _cast = (SiceeLHashXmlImportPk) _other;
		if (dataImport == null ? _cast.dataImport != dataImport : !dataImport.equals( _cast.dataImport )) {
			return false;
		}
		if (idCertificatore == null ? _cast.idCertificatore != idCertificatore : !idCertificatore.equals( _cast.idCertificatore )) {
			return false;
		}
		
		if (progrCertificato == null ? _cast.progrCertificato != progrCertificato : !progrCertificato.equals( _cast.progrCertificato )) {
			return false;
		}
		
		if (anno == null ? _cast.anno != anno : !anno.equals( _cast.anno )) {
			return false;
		}
		
		return true;
	}

	/**
	 * Method 'hashCode'
	 * 
	 * @return int
	 */
	public int hashCode()
	{
		int _hashCode = 0;
		if (dataImport != null) {
			_hashCode = 29 * _hashCode + dataImport.hashCode();
		}
		if (idCertificatore != null) {
			_hashCode = 29 * _hashCode + idCertificatore.hashCode();
		}
		
		if (progrCertificato != null) {
			_hashCode = 29 * _hashCode + progrCertificato.hashCode();
		}
		
		if (anno != null) {
			_hashCode = 29 * _hashCode + anno.hashCode();
		}
		
		return _hashCode;
	}

	/**
	 * Method 'toString'
	 * 
	 * @return String
	 */
	public String toString()
	{
		StringBuffer ret = new StringBuffer();
		ret.append( "it.csi.sicee.siceeweb.business.dao.dto.SiceeLHashXmlImportPk: " );
		ret.append( "dataImport=" + dataImport );
		ret.append( ", idCertificatore=" + idCertificatore );
		ret.append( ", progrCertificato=" + progrCertificato );
		ret.append( ", anno=" + anno );
		return ret.toString();
	}

}
