/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceeweb.business.dao.dto;

import it.csi.sicee.siceeweb.business.dao.dao.*;
import it.csi.sicee.siceeweb.business.dao.factory.*;
import it.csi.sicee.siceeweb.business.dao.exceptions.*;
import java.io.Serializable;
import java.util.*;
import java.util.Date;

public class SiceeTImportDati2015 implements Serializable
{
	/** 
	 * This attribute maps to the column ID_CERTIFICATORE in the SICEE_T_IMPORT_DATI_2015 table.
	 */
	protected String idCertificatore;

	/** 
	 * This attribute maps to the column PROGR_CERTIFICATO in the SICEE_T_IMPORT_DATI_2015 table.
	 */
	protected String progrCertificato;

	/** 
	 * This attribute maps to the column ANNO in the SICEE_T_IMPORT_DATI_2015 table.
	 */
	protected String anno;

	/** 
	 * This attribute maps to the column NOME_XML in the SICEE_T_IMPORT_DATI_2015 table.
	 */
	protected String nomeXml;

	/** 
	 * This attribute maps to the column UID_INDEX in the SICEE_T_IMPORT_DATI_2015 table.
	 */
	protected String uidIndex;

	/** 
	 * This attribute maps to the column DT_CARICAMENTO in the SICEE_T_IMPORT_DATI_2015 table.
	 */
	protected Date dtCaricamento;

	/**
	 * Method 'SiceeTImportDati2015'
	 * 
	 */
	public SiceeTImportDati2015()
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
	 * Method 'getNomeXml'
	 * 
	 * @return String
	 */
	public String getNomeXml()
	{
		return nomeXml;
	}

	/**
	 * Method 'setNomeXml'
	 * 
	 * @param nomeXml
	 */
	public void setNomeXml(String nomeXml)
	{
		this.nomeXml = nomeXml;
	}

	/**
	 * Method 'getUidIndex'
	 * 
	 * @return String
	 */
	public String getUidIndex()
	{
		return uidIndex;
	}

	/**
	 * Method 'setUidIndex'
	 * 
	 * @param uidIndex
	 */
	public void setUidIndex(String uidIndex)
	{
		this.uidIndex = uidIndex;
	}

	/**
	 * Method 'getDtCaricamento'
	 * 
	 * @return Date
	 */
	public Date getDtCaricamento()
	{
		return dtCaricamento;
	}

	/**
	 * Method 'setDtCaricamento'
	 * 
	 * @param dtCaricamento
	 */
	public void setDtCaricamento(Date dtCaricamento)
	{
		this.dtCaricamento = dtCaricamento;
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
		
		if (!(_other instanceof SiceeTImportDati2015)) {
			return false;
		}
		
		final SiceeTImportDati2015 _cast = (SiceeTImportDati2015) _other;
		if (idCertificatore == null ? _cast.idCertificatore != idCertificatore : !idCertificatore.equals( _cast.idCertificatore )) {
			return false;
		}
		
		if (progrCertificato == null ? _cast.progrCertificato != progrCertificato : !progrCertificato.equals( _cast.progrCertificato )) {
			return false;
		}
		
		if (anno == null ? _cast.anno != anno : !anno.equals( _cast.anno )) {
			return false;
		}
		
		if (nomeXml == null ? _cast.nomeXml != nomeXml : !nomeXml.equals( _cast.nomeXml )) {
			return false;
		}
		
		if (uidIndex == null ? _cast.uidIndex != uidIndex : !uidIndex.equals( _cast.uidIndex )) {
			return false;
		}
		
		if (dtCaricamento == null ? _cast.dtCaricamento != dtCaricamento : !dtCaricamento.equals( _cast.dtCaricamento )) {
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
		
		if (nomeXml != null) {
			_hashCode = 29 * _hashCode + nomeXml.hashCode();
		}
		
		if (uidIndex != null) {
			_hashCode = 29 * _hashCode + uidIndex.hashCode();
		}
		
		if (dtCaricamento != null) {
			_hashCode = 29 * _hashCode + dtCaricamento.hashCode();
		}
		
		return _hashCode;
	}

	/**
	 * Method 'createPk'
	 * 
	 * @return SiceeTImportDati2015Pk
	 */
	public SiceeTImportDati2015Pk createPk()
	{
		return new SiceeTImportDati2015Pk(idCertificatore, progrCertificato, anno);
	}

	/**
	 * Method 'toString'
	 * 
	 * @return String
	 */
	public String toString()
	{
		StringBuffer ret = new StringBuffer();
		ret.append( "it.csi.sicee.siceeweb.business.dao.dto.SiceeTImportDati2015: " );
		ret.append( "idCertificatore=" + idCertificatore );
		ret.append( ", progrCertificato=" + progrCertificato );
		ret.append( ", anno=" + anno );
		ret.append( ", nomeXml=" + nomeXml );
		ret.append( ", uidIndex=" + uidIndex );
		ret.append( ", dtCaricamento=" + dtCaricamento );
		return ret.toString();
	}

}
