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

public class SiceeTRifIndex2015 implements Serializable
{
	/** 
	 * This attribute maps to the column ID_CERTIFICATORE in the SICEE_T_RIF_INDEX_2015 table.
	 */
	protected String idCertificatore;

	/** 
	 * This attribute maps to the column PROGR_CERTIFICATO in the SICEE_T_RIF_INDEX_2015 table.
	 */
	protected String progrCertificato;

	/** 
	 * This attribute maps to the column ANNO in the SICEE_T_RIF_INDEX_2015 table.
	 */
	protected String anno;

	/** 
	 * This attribute maps to the column FK_TIPO_DOC in the SICEE_T_RIF_INDEX_2015 table.
	 */
	protected Integer fkTipoDoc;

	/** 
	 * This attribute maps to the column NOME_FILE in the SICEE_T_RIF_INDEX_2015 table.
	 */
	protected String nomeFile;

	/** 
	 * This attribute maps to the column UID_INDEX in the SICEE_T_RIF_INDEX_2015 table.
	 */
	protected String uidIndex;

	/** 
	 * This attribute maps to the column HASH in the SICEE_T_RIF_INDEX_2015 table.
	 */
	protected String hash;

	/** 
	 * This attribute maps to the column ID_RIF_INDEX in the SICEE_T_RIF_INDEX_2015 table.
	 */
	protected long idRifIndex;

	/** 
	 * This attribute maps to the column DT_CARICAMENTO in the SICEE_T_RIF_INDEX_2015 table.
	 */
	protected Date dtCaricamento;
	
	/**
	 * Method 'SiceeTRifIndex2015'
	 * 
	 */
	public SiceeTRifIndex2015()
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
	 * Method 'getFkTipoDoc'
	 * 
	 * @return Integer
	 */
	public Integer getFkTipoDoc()
	{
		return fkTipoDoc;
	}

	/**
	 * Method 'setFkTipoDoc'
	 * 
	 * @param fkTipoDoc
	 */
	public void setFkTipoDoc(Integer fkTipoDoc)
	{
		this.fkTipoDoc = fkTipoDoc;
	}

	/**
	 * Method 'getNomeFile'
	 * 
	 * @return String
	 */
	public String getNomeFile()
	{
		return nomeFile;
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
	 * Method 'getHash'
	 * 
	 * @return String
	 */
	public String getHash()
	{
		return hash;
	}

	/**
	 * Method 'setHash'
	 * 
	 * @param hash
	 */
	public void setHash(String hash)
	{
		this.hash = hash;
	}

	/**
	 * Method 'getIdRifIndex'
	 * 
	 * @return long
	 */
	public long getIdRifIndex()
	{
		return idRifIndex;
	}

	/**
	 * Method 'setIdRifIndex'
	 * 
	 * @param idRifIndex
	 */
	public void setIdRifIndex(long idRifIndex)
	{
		this.idRifIndex = idRifIndex;
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
		
		if (!(_other instanceof SiceeTRifIndex2015)) {
			return false;
		}
		
		final SiceeTRifIndex2015 _cast = (SiceeTRifIndex2015) _other;
		if (idCertificatore == null ? _cast.idCertificatore != idCertificatore : !idCertificatore.equals( _cast.idCertificatore )) {
			return false;
		}
		
		if (progrCertificato == null ? _cast.progrCertificato != progrCertificato : !progrCertificato.equals( _cast.progrCertificato )) {
			return false;
		}
		
		if (anno == null ? _cast.anno != anno : !anno.equals( _cast.anno )) {
			return false;
		}
		
		if (fkTipoDoc == null ? _cast.fkTipoDoc != fkTipoDoc : !fkTipoDoc.equals( _cast.fkTipoDoc )) {
			return false;
		}
		
		if (nomeFile == null ? _cast.nomeFile != nomeFile : !nomeFile.equals( _cast.nomeFile )) {
			return false;
		}
		
		if (uidIndex == null ? _cast.uidIndex != uidIndex : !uidIndex.equals( _cast.uidIndex )) {
			return false;
		}
		
		if (dtCaricamento == null ? _cast.dtCaricamento != dtCaricamento : !dtCaricamento.equals( _cast.dtCaricamento )) {
			return false;
		}
		
		if (hash == null ? _cast.hash != hash : !hash.equals( _cast.hash )) {
			return false;
		}
		
		if (idRifIndex != _cast.idRifIndex) {
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
		
		if (fkTipoDoc != null) {
			_hashCode = 29 * _hashCode + fkTipoDoc.hashCode();
		}
		
		if (nomeFile != null) {
			_hashCode = 29 * _hashCode + nomeFile.hashCode();
		}
		
		if (uidIndex != null) {
			_hashCode = 29 * _hashCode + uidIndex.hashCode();
		}
		
		if (dtCaricamento != null) {
			_hashCode = 29 * _hashCode + dtCaricamento.hashCode();
		}
		
		if (hash != null) {
			_hashCode = 29 * _hashCode + hash.hashCode();
		}
		
		_hashCode = 29 * _hashCode + (int) (idRifIndex ^ (idRifIndex >>> 32));
		return _hashCode;
	}

	/**
	 * Method 'createPk'
	 * 
	 * @return SiceeTRifIndex2015Pk
	 */
	public SiceeTRifIndex2015Pk createPk()
	{
		return new SiceeTRifIndex2015Pk(idRifIndex);
	}

	/**
	 * Method 'toString'
	 * 
	 * @return String
	 */
	public String toString()
	{
		StringBuffer ret = new StringBuffer();
		ret.append( "it.csi.sicee.siceeweb.business.dao.dto.SiceeTRifIndex2015: " );
		ret.append( "idCertificatore=" + idCertificatore );
		ret.append( ", progrCertificato=" + progrCertificato );
		ret.append( ", anno=" + anno );
		ret.append( ", fkTipoDoc=" + fkTipoDoc );
		ret.append( ", nomeFile=" + nomeFile );
		ret.append( ", uidIndex=" + uidIndex );
		ret.append( ", hash=" + hash );
		ret.append( ", idRifIndex=" + idRifIndex );
		ret.append( ", dtCaricamento=" + dtCaricamento );
		return ret.toString();
	}

}
