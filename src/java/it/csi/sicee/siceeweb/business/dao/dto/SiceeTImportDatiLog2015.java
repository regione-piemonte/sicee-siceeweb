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

public class SiceeTImportDatiLog2015 implements Serializable
{
	/** 
	 * This attribute maps to the column ID_CERTIFICATORE in the SICEE_T_IMPORT_DATI_LOG_2015 table.
	 */
	protected String idCertificatore;

	/** 
	 * This attribute maps to the column PROGR_CERTIFICATO in the SICEE_T_IMPORT_DATI_LOG_2015 table.
	 */
	protected String progrCertificato;

	/** 
	 * This attribute maps to the column ANNO in the SICEE_T_IMPORT_DATI_LOG_2015 table.
	 */
	protected String anno;

	/** 
	 * This attribute maps to the column TIMESTAMP in the SICEE_T_IMPORT_DATI_LOG_2015 table.
	 */
	protected Date timestamp;

	/** 
	 * This attribute maps to the column PASSO_VALIDAZIONE in the SICEE_T_IMPORT_DATI_LOG_2015 table.
	 */
	protected Integer passoValidazione;

	/** 
	 * This attribute represents whether the primitive attribute passoValidazione is null.
	 */
	protected boolean passoValidazioneNull = true;

	/** 
	 * This attribute maps to the column MESSAGGIO_ERRORE in the SICEE_T_IMPORT_DATI_LOG_2015 table.
	 */
	protected String messaggioErrore;

	/**
	 * Method 'SiceeTImportDatiLog2015'
	 * 
	 */
	public SiceeTImportDatiLog2015()
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
	 * Method 'getTimestamp'
	 * 
	 * @return Date
	 */
	public Date getTimestamp()
	{
		return timestamp;
	}

	/**
	 * Method 'setTimestamp'
	 * 
	 * @param timestamp
	 */
	public void setTimestamp(Date timestamp)
	{
		this.timestamp = timestamp;
	}

	/**
	 * Method 'getPassoValidazione'
	 * 
	 * @return long
	 */
	public long getPassoValidazione()
	{
		return passoValidazione;
	}

	/**
	 * Method 'setPassoValidazione'
	 * 
	 * @param passoValidazione
	 */
	public void setPassoValidazione(Integer passoValidazione)
	{
		this.passoValidazione = passoValidazione;
		this.passoValidazioneNull = false;
	}

	/**
	 * Method 'setPassoValidazioneNull'
	 * 
	 * @param value
	 */
	public void setPassoValidazioneNull(boolean value)
	{
		this.passoValidazioneNull = value;
	}

	/**
	 * Method 'isPassoValidazioneNull'
	 * 
	 * @return boolean
	 */
	public boolean isPassoValidazioneNull()
	{
		return passoValidazioneNull;
	}

	/**
	 * Method 'getMessaggioErrore'
	 * 
	 * @return String
	 */
	public String getMessaggioErrore()
	{
		return messaggioErrore;
	}

	/**
	 * Method 'setMessaggioErrore'
	 * 
	 * @param messaggioErrore
	 */
	public void setMessaggioErrore(String messaggioErrore)
	{
		this.messaggioErrore = messaggioErrore;
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
		
		if (!(_other instanceof SiceeTImportDatiLog2015)) {
			return false;
		}
		
		final SiceeTImportDatiLog2015 _cast = (SiceeTImportDatiLog2015) _other;
		if (idCertificatore == null ? _cast.idCertificatore != idCertificatore : !idCertificatore.equals( _cast.idCertificatore )) {
			return false;
		}
		
		if (progrCertificato == null ? _cast.progrCertificato != progrCertificato : !progrCertificato.equals( _cast.progrCertificato )) {
			return false;
		}
		
		if (anno == null ? _cast.anno != anno : !anno.equals( _cast.anno )) {
			return false;
		}
		
		if (timestamp == null ? _cast.timestamp != timestamp : !timestamp.equals( _cast.timestamp )) {
			return false;
		}
		
		if (passoValidazione != _cast.passoValidazione) {
			return false;
		}
		
		if (passoValidazioneNull != _cast.passoValidazioneNull) {
			return false;
		}
		
		if (messaggioErrore == null ? _cast.messaggioErrore != messaggioErrore : !messaggioErrore.equals( _cast.messaggioErrore )) {
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
		
		if (timestamp != null) {
			_hashCode = 29 * _hashCode + timestamp.hashCode();
		}
		
		_hashCode = 29 * _hashCode + (int) (passoValidazione ^ (passoValidazione >>> 32));
		_hashCode = 29 * _hashCode + (passoValidazioneNull ? 1 : 0);
		if (messaggioErrore != null) {
			_hashCode = 29 * _hashCode + messaggioErrore.hashCode();
		}
		
		return _hashCode;
	}

	/**
	 * Method 'createPk'
	 * 
	 * @return SiceeTImportDatiLog2015Pk
	 */
	public SiceeTImportDatiLog2015Pk createPk()
	{
		return new SiceeTImportDatiLog2015Pk(idCertificatore, progrCertificato, anno, timestamp);
	}

	/**
	 * Method 'toString'
	 * 
	 * @return String
	 */
	public String toString()
	{
		StringBuffer ret = new StringBuffer();
		ret.append( "it.csi.sicee.siceeweb.business.dao.dto.SiceeTImportDatiLog2015: " );
		ret.append( "idCertificatore=" + idCertificatore );
		ret.append( ", progrCertificato=" + progrCertificato );
		ret.append( ", anno=" + anno );
		ret.append( ", timestamp=" + timestamp );
		ret.append( ", passoValidazione=" + passoValidazione );
		ret.append( ", messaggioErrore=" + messaggioErrore );
		return ret.toString();
	}

}
