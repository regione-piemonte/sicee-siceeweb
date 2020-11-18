/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceeweb.business.dao.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/** 
 * This class represents the primary key of the SICEE_T_SIAPE table.
 */
public class SiceeTSiapePk implements Serializable
{
	protected String idCertificatore;

	protected String progrCertificato;

	protected String anno;

	protected long idTipoAzione;

	/** 
	 * This attribute represents whether the primitive attribute idTipoAzione is null.
	 */
	protected boolean idTipoAzioneNull;

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
	 * Sets the value of idTipoAzione
	 */
	public void setIdTipoAzione(long idTipoAzione)
	{
		this.idTipoAzione = idTipoAzione;
	}

	/** 
	 * Gets the value of idTipoAzione
	 */
	public long getIdTipoAzione()
	{
		return idTipoAzione;
	}

	/**
	 * Method 'SiceeTSiapePk'
	 * 
	 */
	public SiceeTSiapePk()
	{
	}

	/**
	 * Method 'SiceeTSiapePk'
	 * 
	 * @param idCertificatore
	 * @param progrCertificato
	 * @param anno
	 * @param idTipoAzione
	 */
	public SiceeTSiapePk(final String idCertificatore, final String progrCertificato, final String anno, final long idTipoAzione)
	{
		this.idCertificatore = idCertificatore;
		this.progrCertificato = progrCertificato;
		this.anno = anno;
		this.idTipoAzione = idTipoAzione;
	}

	/** 
	 * Sets the value of idTipoAzioneNull
	 */
	public void setIdTipoAzioneNull(boolean idTipoAzioneNull)
	{
		this.idTipoAzioneNull = idTipoAzioneNull;
	}

	/** 
	 * Gets the value of idTipoAzioneNull
	 */
	public boolean isIdTipoAzioneNull()
	{
		return idTipoAzioneNull;
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
		
		if (!(_other instanceof SiceeTSiapePk)) {
			return false;
		}
		
		final SiceeTSiapePk _cast = (SiceeTSiapePk) _other;
		if (idCertificatore == null ? _cast.idCertificatore != idCertificatore : !idCertificatore.equals( _cast.idCertificatore )) {
			return false;
		}
		
		if (progrCertificato == null ? _cast.progrCertificato != progrCertificato : !progrCertificato.equals( _cast.progrCertificato )) {
			return false;
		}
		
		if (anno == null ? _cast.anno != anno : !anno.equals( _cast.anno )) {
			return false;
		}
		
		if (idTipoAzione != _cast.idTipoAzione) {
			return false;
		}
		
		if (idTipoAzioneNull != _cast.idTipoAzioneNull) {
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
		
		_hashCode = 29 * _hashCode + (int) (idTipoAzione ^ (idTipoAzione >>> 32));
		_hashCode = 29 * _hashCode + (idTipoAzioneNull ? 1 : 0);
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
		ret.append( "it.csi.sicee.siceeweb.business.dao.dto.SiceeTSiapePk: " );
		ret.append( "idCertificatore=" + idCertificatore );
		ret.append( ", progrCertificato=" + progrCertificato );
		ret.append( ", anno=" + anno );
		ret.append( ", idTipoAzione=" + idTipoAzione );
		return ret.toString();
	}

}
