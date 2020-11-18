/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceeweb.business.dao.dto;

import it.csi.sicee.siceeweb.business.dao.dao.*;
import it.csi.sicee.siceeweb.business.dao.exceptions.*;
import java.io.Serializable;
import java.util.*;
import java.util.Date;

public class SiceeTActa implements Serializable
{
	/** 
	 * This attribute maps to the column ID_CERTIFICATORE in the SICEE_T_ACTA table.
	 */
	protected String idCertificatore;

	/** 
	 * This attribute maps to the column PROGR_CERTIFICATO in the SICEE_T_ACTA table.
	 */
	protected String progrCertificato;

	/** 
	 * This attribute maps to the column ANNO in the SICEE_T_ACTA table.
	 */
	protected String anno;

	/** 
	 * This attribute maps to the column VOLUME in the SICEE_T_ACTA table.
	 */
	protected String volume;

	/** 
	 * This attribute maps to the column ID_DOC_ACTA in the SICEE_T_ACTA table.
	 */
	protected String idDocActa;

	/** 
	 * This attribute maps to the column ID_CLASSIFICAZIONE_ACTA in the SICEE_T_ACTA table.
	 */
	protected String idClassificazioneActa;

	/** 
	 * This attribute maps to the column TIPO_DOCUMENTO_ACTA in the SICEE_T_ACTA table.
	 */
	protected String tipoDocumentoActa;

	/** 
	 * This attribute maps to the column FAILED_STEP_ACTA in the SICEE_T_ACTA table.
	 */
	protected String failedStepActa;

	/** 
	 * This attribute maps to the column TIMESTAMP_ARCHIVIAZIONE in the SICEE_T_ACTA table.
	 */
	protected Date timestampArchiviazione;

	/** 
	 * This attribute maps to the column NUMERO_PROTOCOLLO in the SICEE_T_ACTA table.
	 */
	protected String numeroProtocollo;

	/** 
	 * This attribute maps to the column MAIL_INVIATA in the SICEE_T_ACTA table.
	 */
	protected String mailInviata;

	/** 
	 * This attribute maps to the column TIMESTAMP_PROTOCOLLO in the SICEE_T_ACTA table.
	 */
	protected Date timestampProtocollo;

	/**
	 * Method 'SiceeTActa'
	 * 
	 */
	public SiceeTActa()
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
	 * Method 'getVolume'
	 * 
	 * @return String
	 */
	public String getVolume()
	{
		return volume;
	}

	/**
	 * Method 'setVolume'
	 * 
	 * @param volume
	 */
	public void setVolume(String volume)
	{
		this.volume = volume;
	}

	/**
	 * Method 'getIdDocActa'
	 * 
	 * @return String
	 */
	public String getIdDocActa()
	{
		return idDocActa;
	}

	/**
	 * Method 'setIdDocActa'
	 * 
	 * @param idDocActa
	 */
	public void setIdDocActa(String idDocActa)
	{
		this.idDocActa = idDocActa;
	}

	/**
	 * Method 'getIdClassificazioneActa'
	 * 
	 * @return String
	 */
	public String getIdClassificazioneActa()
	{
		return idClassificazioneActa;
	}

	/**
	 * Method 'setIdClassificazioneActa'
	 * 
	 * @param idClassificazioneActa
	 */
	public void setIdClassificazioneActa(String idClassificazioneActa)
	{
		this.idClassificazioneActa = idClassificazioneActa;
	}

	/**
	 * Method 'getTipoDocumentoActa'
	 * 
	 * @return String
	 */
	public String getTipoDocumentoActa()
	{
		return tipoDocumentoActa;
	}

	/**
	 * Method 'setTipoDocumentoActa'
	 * 
	 * @param tipoDocumentoActa
	 */
	public void setTipoDocumentoActa(String tipoDocumentoActa)
	{
		this.tipoDocumentoActa = tipoDocumentoActa;
	}

	/**
	 * Method 'getFailedStepActa'
	 * 
	 * @return String
	 */
	public String getFailedStepActa()
	{
		return failedStepActa;
	}

	/**
	 * Method 'setFailedStepActa'
	 * 
	 * @param failedStepActa
	 */
	public void setFailedStepActa(String failedStepActa)
	{
		this.failedStepActa = failedStepActa;
	}

	/**
	 * Method 'getTimestampArchiviazione'
	 * 
	 * @return Date
	 */
	public Date getTimestampArchiviazione()
	{
		return timestampArchiviazione;
	}

	/**
	 * Method 'setTimestampArchiviazione'
	 * 
	 * @param timestampArchiviazione
	 */
	public void setTimestampArchiviazione(Date timestampArchiviazione)
	{
		this.timestampArchiviazione = timestampArchiviazione;
	}

	/**
	 * Method 'getNumeroProtocollo'
	 * 
	 * @return String
	 */
	public String getNumeroProtocollo()
	{
		return numeroProtocollo;
	}

	/**
	 * Method 'setNumeroProtocollo'
	 * 
	 * @param numeroProtocollo
	 */
	public void setNumeroProtocollo(String numeroProtocollo)
	{
		this.numeroProtocollo = numeroProtocollo;
	}

	/**
	 * Method 'getMailInviata'
	 * 
	 * @return String
	 */
	public String getMailInviata()
	{
		return mailInviata;
	}

	/**
	 * Method 'setMailInviata'
	 * 
	 * @param mailInviata
	 */
	public void setMailInviata(String mailInviata)
	{
		this.mailInviata = mailInviata;
	}

	/**
	 * Method 'getTimestampProtocollo'
	 * 
	 * @return Date
	 */
	public Date getTimestampProtocollo()
	{
		return timestampProtocollo;
	}

	/**
	 * Method 'setTimestampProtocollo'
	 * 
	 * @param timestampProtocollo
	 */
	public void setTimestampProtocollo(Date timestampProtocollo)
	{
		this.timestampProtocollo = timestampProtocollo;
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
		
		if (!(_other instanceof SiceeTActa)) {
			return false;
		}
		
		final SiceeTActa _cast = (SiceeTActa) _other;
		if (idCertificatore == null ? _cast.idCertificatore != idCertificatore : !idCertificatore.equals( _cast.idCertificatore )) {
			return false;
		}
		
		if (progrCertificato == null ? _cast.progrCertificato != progrCertificato : !progrCertificato.equals( _cast.progrCertificato )) {
			return false;
		}
		
		if (anno == null ? _cast.anno != anno : !anno.equals( _cast.anno )) {
			return false;
		}
		
		if (volume == null ? _cast.volume != volume : !volume.equals( _cast.volume )) {
			return false;
		}
		
		if (idDocActa == null ? _cast.idDocActa != idDocActa : !idDocActa.equals( _cast.idDocActa )) {
			return false;
		}
		
		if (idClassificazioneActa == null ? _cast.idClassificazioneActa != idClassificazioneActa : !idClassificazioneActa.equals( _cast.idClassificazioneActa )) {
			return false;
		}
		
		if (tipoDocumentoActa == null ? _cast.tipoDocumentoActa != tipoDocumentoActa : !tipoDocumentoActa.equals( _cast.tipoDocumentoActa )) {
			return false;
		}
		
		if (failedStepActa == null ? _cast.failedStepActa != failedStepActa : !failedStepActa.equals( _cast.failedStepActa )) {
			return false;
		}
		
		if (timestampArchiviazione == null ? _cast.timestampArchiviazione != timestampArchiviazione : !timestampArchiviazione.equals( _cast.timestampArchiviazione )) {
			return false;
		}
		
		if (numeroProtocollo == null ? _cast.numeroProtocollo != numeroProtocollo : !numeroProtocollo.equals( _cast.numeroProtocollo )) {
			return false;
		}
		
		if (mailInviata == null ? _cast.mailInviata != mailInviata : !mailInviata.equals( _cast.mailInviata )) {
			return false;
		}
		
		if (timestampProtocollo == null ? _cast.timestampProtocollo != timestampProtocollo : !timestampProtocollo.equals( _cast.timestampProtocollo )) {
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
		
		if (volume != null) {
			_hashCode = 29 * _hashCode + volume.hashCode();
		}
		
		if (idDocActa != null) {
			_hashCode = 29 * _hashCode + idDocActa.hashCode();
		}
		
		if (idClassificazioneActa != null) {
			_hashCode = 29 * _hashCode + idClassificazioneActa.hashCode();
		}
		
		if (tipoDocumentoActa != null) {
			_hashCode = 29 * _hashCode + tipoDocumentoActa.hashCode();
		}
		
		if (failedStepActa != null) {
			_hashCode = 29 * _hashCode + failedStepActa.hashCode();
		}
		
		if (timestampArchiviazione != null) {
			_hashCode = 29 * _hashCode + timestampArchiviazione.hashCode();
		}
		
		if (numeroProtocollo != null) {
			_hashCode = 29 * _hashCode + numeroProtocollo.hashCode();
		}
		
		if (mailInviata != null) {
			_hashCode = 29 * _hashCode + mailInviata.hashCode();
		}
		
		if (timestampProtocollo != null) {
			_hashCode = 29 * _hashCode + timestampProtocollo.hashCode();
		}
		
		return _hashCode;
	}

	/**
	 * Method 'createPk'
	 * 
	 * @return SiceeTActaPk
	 */
	public SiceeTActaPk createPk()
	{
		return new SiceeTActaPk(idCertificatore, progrCertificato, anno);
	}

	/**
	 * Method 'toString'
	 * 
	 * @return String
	 */
	public String toString()
	{
		StringBuffer ret = new StringBuffer();
		ret.append( "it.csi.sicee.siceeweb.business.dao.dto.SiceeTActa: " );
		ret.append( "idCertificatore=" + idCertificatore );
		ret.append( ", progrCertificato=" + progrCertificato );
		ret.append( ", anno=" + anno );
		ret.append( ", volume=" + volume );
		ret.append( ", idDocActa=" + idDocActa );
		ret.append( ", idClassificazioneActa=" + idClassificazioneActa );
		ret.append( ", tipoDocumentoActa=" + tipoDocumentoActa );
		ret.append( ", failedStepActa=" + failedStepActa );
		ret.append( ", timestampArchiviazione=" + timestampArchiviazione );
		ret.append( ", numeroProtocollo=" + numeroProtocollo );
		ret.append( ", mailInviata=" + mailInviata );
		ret.append( ", timestampProtocollo=" + timestampProtocollo );
		return ret.toString();
	}

}
