/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceeweb.business.dao.dto;

import it.csi.sicee.siceeweb.business.dao.dao.*;
import it.csi.sicee.siceeweb.business.dao.factory.*;
import it.csi.sicee.siceeweb.business.dao.exceptions.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.*;
import java.util.Date;

public class SiceeLHashXmlImport implements Serializable
{

	private static final long serialVersionUID = 4651002746418606666L;

	/** 
	 * This attribute maps to the column ID_CERTIFICATORE in the SICEE_L_HASH_XML_IMPORT table.
	 */
	protected String idCertificatore;

	/** 
	 * This attribute maps to the column PROGR_CERTIFICATO in the SICEE_L_HASH_XML_IMPORT table.
	 */
	protected String progrCertificato;

	/** 
	 * This attribute maps to the column ANNO in the SICEE_L_HASH_XML_IMPORT table.
	 */
	protected String anno;

	/** 
	 * This attribute maps to the column HASH_FILE in the SICEE_L_HASH_XML_IMPORT table.
	 */
	protected String hashFile;

	/** 
	 * This attribute maps to the column HASH_MATCH in the SICEE_L_HASH_XML_IMPORT table.
	 */
	protected String hashMatch;

	/** 
	 * This attribute maps to the column DATA_IMPORT in the SICEE_L_HASH_XML_IMPORT table.
	 */
	protected Date dataImport;

	/**
	 * Method 'SiceeTFoto2015'
	 * 
	 */
	public SiceeLHashXmlImport()
	{
	}

	/**
	 * Method 'getIdCertificatore'
	 * 
	 * @return String
	 */
	public String getIdCertificatore()
	{
		return idCertificatore;
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
		return progrCertificato;
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
		return anno;
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
	 * Method 'getHashFile'
	 * 
	 * @return String
	 */
	public String getHashFile()
	{
		return hashFile;
	}

	/**
	 * Method 'setHashFile'
	 * 
	 * @param hashFile
	 */
	public void setHashFile(String hashFile)
	{
		this.hashFile = hashFile;
	}

	/**
	 * Method 'getHashMatch'
	 * 
	 * @return String
	 */
	public String getHashMatch()
	{
		return hashMatch;
	}

	/**
	 * Method 'setHashMatch'
	 * 
	 * @param hashMatch
	 */
	public void setHashMatch(String hashMatch)
	{
		this.hashMatch = hashMatch;
	}

	/**
	 * Method 'getDataImport'
	 * 
	 * @return Date
	 */
	public Date getDataImport()
	{
		return dataImport;
	}

	/**
	 * Method 'setDataImport'
	 * 
	 * @param dataImport
	 */
	public void setDataImport(Date dataImport)
	{
		this.dataImport = dataImport;
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
		
		if (!(_other instanceof SiceeLHashXmlImport)) {
			return false;
		}
		
		final SiceeLHashXmlImport _cast = (SiceeLHashXmlImport) _other;

		if (idCertificatore == null ? _cast.idCertificatore != idCertificatore : !idCertificatore.equals( _cast.idCertificatore )) {
			return false;
		}
		
		if (progrCertificato == null ? _cast.progrCertificato != progrCertificato : !progrCertificato.equals( _cast.progrCertificato )) {
			return false;
		}
		
		if (anno == null ? _cast.anno != anno : !anno.equals( _cast.anno )) {
			return false;
		}
		
		if (hashFile == null ? _cast.hashFile != hashFile : !hashFile.equals( _cast.hashFile )) {
			return false;
		}
		
		if (hashMatch == null ? _cast.hashMatch != hashMatch : !hashMatch.equals( _cast.hashMatch )) {
			return false;
		}
		
		if (dataImport == null ? _cast.dataImport != dataImport : !dataImport.equals( _cast.dataImport )) {
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
		if (idCertificatore != null) {
			_hashCode = 29 * _hashCode + idCertificatore.hashCode();
		}
		
		if (progrCertificato != null) {
			_hashCode = 29 * _hashCode + progrCertificato.hashCode();
		}
		
		if (anno != null) {
			_hashCode = 29 * _hashCode + anno.hashCode();
		}
		
		if (hashFile != null) {
			_hashCode = 29 * _hashCode + hashFile.hashCode();
		}
		
		if (hashMatch != null) {
			_hashCode = 29 * _hashCode + hashMatch.hashCode();
		}
		
		if (dataImport != null) {
			_hashCode = 29 * _hashCode + dataImport.hashCode();
		}
		
		return _hashCode;
	}

	/**
	 * Method 'createPk'
	 * 
	 * @return SiceeLHashXmlImportPk
	 */
	public SiceeLHashXmlImportPk createPk()
	{
		return new SiceeLHashXmlImportPk(dataImport, idCertificatore, progrCertificato, anno);
	}
	
	/**
	 * Method 'toString'
	 * 
	 * @return String
	 */
	public String toString()
	{
		StringBuffer ret = new StringBuffer();
		ret.append( "it.csi.sicee.siceeweb.business.dao.dto.SiceeLHashXmlImport: " );
		ret.append( "idCertificatore=" + idCertificatore );
		ret.append( ", progrCertificato=" + progrCertificato );
		ret.append( ", anno=" + anno );
		ret.append( ", identificFoto=" + hashFile );
		ret.append( ", nomeFoto=" + hashMatch );
		ret.append( ", dtFoto=" + dataImport );
		return ret.toString();
	}

}
