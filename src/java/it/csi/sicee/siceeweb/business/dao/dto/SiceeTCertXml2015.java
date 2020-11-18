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

public class SiceeTCertXml2015 implements Serializable
{
	/** 
	 * This attribute maps to the column ID_CERTIFICATORE in the SICEE_T_CERT_XML_2015 table.
	 */
	protected String idCertificatore;

	/** 
	 * This attribute maps to the column PROGR_CERTIFICATO in the SICEE_T_CERT_XML_2015 table.
	 */
	protected String progrCertificato;

	/** 
	 * This attribute maps to the column ANNO in the SICEE_T_CERT_XML_2015 table.
	 */
	protected String anno;

	/** 
	 * This attribute maps to the column XML_ALLEGATO in the SICEE_T_CERT_XML_2015 table.
	 */
	protected String xmlAllegato;

	/** 
	 * This attribute maps to the column FLG_CONTROLLO_BOZZA in the SICEE_T_CERT_XML_2015 table.
	 */
	protected String flgControlloBozza;

	/**
	 * Method 'SiceeTCertXml2015'
	 * 
	 */
	public SiceeTCertXml2015()
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
	 * Method 'getXmlAllegato'
	 * 
	 * @return String
	 */
	public String getXmlAllegato()
	{
		return xmlAllegato;
	}

	/**
	 * Method 'setXmlAllegato'
	 * 
	 * @param xmlAllegato
	 */
	public void setXmlAllegato(String xmlAllegato)
	{
		this.xmlAllegato = xmlAllegato;
	}

	/**
	 * Method 'getFlgControlloBozza'
	 * 
	 * @return String
	 */
	public String getFlgControlloBozza()
	{
		return flgControlloBozza;
	}

	/**
	 * Method 'setFlgControlloBozza'
	 * 
	 * @param flgControlloBozza
	 */
	public void setFlgControlloBozza(String flgControlloBozza)
	{
		this.flgControlloBozza = flgControlloBozza;
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
		
		if (!(_other instanceof SiceeTCertXml2015)) {
			return false;
		}
		
		final SiceeTCertXml2015 _cast = (SiceeTCertXml2015) _other;
		if (idCertificatore == null ? _cast.idCertificatore != idCertificatore : !idCertificatore.equals( _cast.idCertificatore )) {
			return false;
		}
		
		if (progrCertificato == null ? _cast.progrCertificato != progrCertificato : !progrCertificato.equals( _cast.progrCertificato )) {
			return false;
		}
		
		if (anno == null ? _cast.anno != anno : !anno.equals( _cast.anno )) {
			return false;
		}
		
		if (xmlAllegato == null ? _cast.xmlAllegato != xmlAllegato : !xmlAllegato.equals( _cast.xmlAllegato )) {
			return false;
		}
		
		if (flgControlloBozza == null ? _cast.flgControlloBozza != flgControlloBozza : !flgControlloBozza.equals( _cast.flgControlloBozza )) {
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
		
		if (xmlAllegato != null) {
			_hashCode = 29 * _hashCode + xmlAllegato.hashCode();
		}
		
		if (flgControlloBozza != null) {
			_hashCode = 29 * _hashCode + flgControlloBozza.hashCode();
		}
		
		return _hashCode;
	}

	/**
	 * Method 'createPk'
	 * 
	 * @return SiceeTCertXml2015Pk
	 */
	public SiceeTCertXml2015Pk createPk()
	{
		return new SiceeTCertXml2015Pk(idCertificatore, progrCertificato, anno);
	}

	/**
	 * Method 'toString'
	 * 
	 * @return String
	 */
	public String toString()
	{
		StringBuffer ret = new StringBuffer();
		ret.append( "it.csi.sicee.siceeweb.business.dao.dto.SiceeTCertXml2015: " );
		ret.append( "idCertificatore=" + idCertificatore );
		ret.append( ", progrCertificato=" + progrCertificato );
		ret.append( ", anno=" + anno );
		ret.append( ", xmlAllegato=" + xmlAllegato );
		ret.append( ", flgControlloBozza=" + flgControlloBozza );
		return ret.toString();
	}

}
