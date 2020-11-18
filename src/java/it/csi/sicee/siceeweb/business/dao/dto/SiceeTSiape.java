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

public class SiceeTSiape implements Serializable
{
	/** 
	 * This attribute maps to the column ID_CERTIFICATORE in the SICEE_T_SIAPE table.
	 */
	protected String idCertificatore;

	/** 
	 * This attribute maps to the column PROGR_CERTIFICATO in the SICEE_T_SIAPE table.
	 */
	protected String progrCertificato;

	/** 
	 * This attribute maps to the column ANNO in the SICEE_T_SIAPE table.
	 */
	protected String anno;

	/** 
	 * This attribute maps to the column ID_TIPO_AZIONE in the SICEE_T_SIAPE table.
	 */
	protected Long idTipoAzione;

	/** 
	 * This attribute maps to the column FLG_DA_ELABORARE in the SICEE_T_CERTIFICATORE table.
	 */
	protected String flgDaElaborare;

	/**
	 * Method 'SiceeTSiape'
	 * 
	 */
	public SiceeTSiape()
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
	 * Method 'getIdTipoAzione'
	 * 
	 * @return Long
	 */
	public Long getIdTipoAzione()
	{
		return idTipoAzione;
	}

	/**
	 * Method 'setIdTipoAzione'
	 * 
	 * @param idTipoAzione
	 */
	public void setIdTipoAzione(Long idTipoAzione)
	{
		this.idTipoAzione = idTipoAzione;
	}

	
	
	/**
	 * @return the flgDaElaborare
	 */
	public String getFlgDaElaborare() {
		return flgDaElaborare;
	}

	/**
	 * @param flgDaElaborare the flgDaElaborare to set
	 */
	public void setFlgDaElaborare(String flgDaElaborare) {
		this.flgDaElaborare = flgDaElaborare;
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
		
		if (!(_other instanceof SiceeTSiape)) {
			return false;
		}
		
		final SiceeTSiape _cast = (SiceeTSiape) _other;
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
		
		if (flgDaElaborare != _cast.flgDaElaborare) {
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

		_hashCode = 29 * _hashCode + flgDaElaborare.hashCode();

		return _hashCode;
	}

	/**
	 * Method 'createPk'
	 * 
	 * @return SiceeTSiapePk
	 */
	public SiceeTSiapePk createPk()
	{
		return new SiceeTSiapePk(idCertificatore, progrCertificato, anno, idTipoAzione);
	}

	/**
	 * Method 'toString'
	 * 
	 * @return String
	 */
	public String toString()
	{
		StringBuffer ret = new StringBuffer();
		ret.append( "it.csi.sicee.siceeweb.business.dao.dto.SiceeTSiape: " );
		ret.append( "idCertificatore=" + idCertificatore );
		ret.append( ", progrCertificato=" + progrCertificato );
		ret.append( ", anno=" + anno );
		ret.append( ", idTipoAzione=" + idTipoAzione );
		ret.append( ", flgDaElaborare=" + flgDaElaborare );
		return ret.toString();
	}

}
