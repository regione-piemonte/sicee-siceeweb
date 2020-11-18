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

public class SiceeTDatiXmlEdReale2015 implements Serializable
{
	/** 
	 * This attribute maps to the column ID_CERTIFICATORE in the SICEE_T_DATI_XML_ED_REALE_2015 table.
	 */
	protected String idCertificatore;

	/** 
	 * This attribute maps to the column PROGR_CERTIFICATO in the SICEE_T_DATI_XML_ED_REALE_2015 table.
	 */
	protected String progrCertificato;

	/** 
	 * This attribute maps to the column ANNO in the SICEE_T_DATI_XML_ED_REALE_2015 table.
	 */
	protected String anno;

	/** 
	 * This attribute maps to the column FABB_RISC_INVOLUCRO_EXTRA_FLUS in the SICEE_T_DATI_XML_ED_REALE_2015 table.
	 */
	protected Double fabbRiscInvolucroExtraFlus;

	/** 
	 * This attribute maps to the column FABB_RISC_INVOLUCRO_TRASMISSIO in the SICEE_T_DATI_XML_ED_REALE_2015 table.
	 */
	protected Double fabbRiscInvolucroTrasmissio;

	/** 
	 * This attribute maps to the column FABB_RISC_INVOLUCRO_VENTILAZIO in the SICEE_T_DATI_XML_ED_REALE_2015 table.
	 */
	protected Double fabbRiscInvolucroVentilazio;

	/** 
	 * This attribute maps to the column FABB_RISC_INVOLUCRO_APPORTI_SO in the SICEE_T_DATI_XML_ED_REALE_2015 table.
	 */
	protected Double fabbRiscInvolucroApportiSo;

	/** 
	 * This attribute maps to the column FABB_RISC_INVOLUCRO_APPORTI_IN in the SICEE_T_DATI_XML_ED_REALE_2015 table.
	 */
	protected Double fabbRiscInvolucroApportiIn;

	/** 
	 * This attribute maps to the column FABB_RISC_INVOLUCRO_APPORTI_LA in the SICEE_T_DATI_XML_ED_REALE_2015 table.
	 */
	protected Double fabbRiscInvolucroApportiLa;

	/** 
	 * This attribute maps to the column FABB_RISC_INVOLUCRO_QHND in the SICEE_T_DATI_XML_ED_REALE_2015 table.
	 */
	protected Double fabbRiscInvolucroQhnd;

	/** 
	 * This attribute maps to the column FABB_RISC_INVOLUCRO_QLR in the SICEE_T_DATI_XML_ED_REALE_2015 table.
	 */
	protected Double fabbRiscInvolucroQlr;

	/** 
	 * This attribute maps to the column FABB_RISC_INVOLUCRO_QHIMP in the SICEE_T_DATI_XML_ED_REALE_2015 table.
	 */
	protected Double fabbRiscInvolucroQhimp;

	/** 
	 * This attribute maps to the column FABB_RISC_IMPIANTO_ETAR in the SICEE_T_DATI_XML_ED_REALE_2015 table.
	 */
	protected Double fabbRiscImpiantoEtar;

	/** 
	 * This attribute maps to the column FABB_RISC_IMPIANTO_ETAD in the SICEE_T_DATI_XML_ED_REALE_2015 table.
	 */
	protected Double fabbRiscImpiantoEtad;

	/** 
	 * This attribute maps to the column FABB_RISC_IMPIANTO_ETAE in the SICEE_T_DATI_XML_ED_REALE_2015 table.
	 */
	protected Double fabbRiscImpiantoEtae;

	/** 
	 * This attribute maps to the column FABB_RISC_IMPIANTO_ETAG in the SICEE_T_DATI_XML_ED_REALE_2015 table.
	 */
	protected Double fabbRiscImpiantoEtag;

	/**
	 * Method 'SiceeTDatiXmlEdReale2015'
	 * 
	 */
	public SiceeTDatiXmlEdReale2015()
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
	 * Method 'getFabbRiscInvolucroExtraFlus'
	 * 
	 * @return Double
	 */
	public Double getFabbRiscInvolucroExtraFlus()
	{
		return fabbRiscInvolucroExtraFlus;
	}

	/**
	 * Method 'setFabbRiscInvolucroExtraFlus'
	 * 
	 * @param fabbRiscInvolucroExtraFlus
	 */
	public void setFabbRiscInvolucroExtraFlus(Double fabbRiscInvolucroExtraFlus)
	{
		this.fabbRiscInvolucroExtraFlus = fabbRiscInvolucroExtraFlus;
	}

	/**
	 * Method 'getFabbRiscInvolucroTrasmissio'
	 * 
	 * @return Double
	 */
	public Double getFabbRiscInvolucroTrasmissio()
	{
		return fabbRiscInvolucroTrasmissio;
	}

	/**
	 * Method 'setFabbRiscInvolucroTrasmissio'
	 * 
	 * @param fabbRiscInvolucroTrasmissio
	 */
	public void setFabbRiscInvolucroTrasmissio(Double fabbRiscInvolucroTrasmissio)
	{
		this.fabbRiscInvolucroTrasmissio = fabbRiscInvolucroTrasmissio;
	}

	/**
	 * Method 'getFabbRiscInvolucroVentilazio'
	 * 
	 * @return Double
	 */
	public Double getFabbRiscInvolucroVentilazio()
	{
		return fabbRiscInvolucroVentilazio;
	}

	/**
	 * Method 'setFabbRiscInvolucroVentilazio'
	 * 
	 * @param fabbRiscInvolucroVentilazio
	 */
	public void setFabbRiscInvolucroVentilazio(Double fabbRiscInvolucroVentilazio)
	{
		this.fabbRiscInvolucroVentilazio = fabbRiscInvolucroVentilazio;
	}

	/**
	 * Method 'getFabbRiscInvolucroApportiSo'
	 * 
	 * @return Double
	 */
	public Double getFabbRiscInvolucroApportiSo()
	{
		return fabbRiscInvolucroApportiSo;
	}

	/**
	 * Method 'setFabbRiscInvolucroApportiSo'
	 * 
	 * @param fabbRiscInvolucroApportiSo
	 */
	public void setFabbRiscInvolucroApportiSo(Double fabbRiscInvolucroApportiSo)
	{
		this.fabbRiscInvolucroApportiSo = fabbRiscInvolucroApportiSo;
	}

	/**
	 * Method 'getFabbRiscInvolucroApportiIn'
	 * 
	 * @return Double
	 */
	public Double getFabbRiscInvolucroApportiIn()
	{
		return fabbRiscInvolucroApportiIn;
	}

	/**
	 * Method 'setFabbRiscInvolucroApportiIn'
	 * 
	 * @param fabbRiscInvolucroApportiIn
	 */
	public void setFabbRiscInvolucroApportiIn(Double fabbRiscInvolucroApportiIn)
	{
		this.fabbRiscInvolucroApportiIn = fabbRiscInvolucroApportiIn;
	}

	/**
	 * Method 'getFabbRiscInvolucroApportiLa'
	 * 
	 * @return Double
	 */
	public Double getFabbRiscInvolucroApportiLa()
	{
		return fabbRiscInvolucroApportiLa;
	}

	/**
	 * Method 'setFabbRiscInvolucroApportiLa'
	 * 
	 * @param fabbRiscInvolucroApportiLa
	 */
	public void setFabbRiscInvolucroApportiLa(Double fabbRiscInvolucroApportiLa)
	{
		this.fabbRiscInvolucroApportiLa = fabbRiscInvolucroApportiLa;
	}

	/**
	 * Method 'getFabbRiscInvolucroQhnd'
	 * 
	 * @return Double
	 */
	public Double getFabbRiscInvolucroQhnd()
	{
		return fabbRiscInvolucroQhnd;
	}

	/**
	 * Method 'setFabbRiscInvolucroQhnd'
	 * 
	 * @param fabbRiscInvolucroQhnd
	 */
	public void setFabbRiscInvolucroQhnd(Double fabbRiscInvolucroQhnd)
	{
		this.fabbRiscInvolucroQhnd = fabbRiscInvolucroQhnd;
	}

	/**
	 * Method 'getFabbRiscInvolucroQlr'
	 * 
	 * @return Double
	 */
	public Double getFabbRiscInvolucroQlr()
	{
		return fabbRiscInvolucroQlr;
	}

	/**
	 * Method 'setFabbRiscInvolucroQlr'
	 * 
	 * @param fabbRiscInvolucroQlr
	 */
	public void setFabbRiscInvolucroQlr(Double fabbRiscInvolucroQlr)
	{
		this.fabbRiscInvolucroQlr = fabbRiscInvolucroQlr;
	}

	/**
	 * Method 'getFabbRiscInvolucroQhimp'
	 * 
	 * @return Double
	 */
	public Double getFabbRiscInvolucroQhimp()
	{
		return fabbRiscInvolucroQhimp;
	}

	/**
	 * Method 'setFabbRiscInvolucroQhimp'
	 * 
	 * @param fabbRiscInvolucroQhimp
	 */
	public void setFabbRiscInvolucroQhimp(Double fabbRiscInvolucroQhimp)
	{
		this.fabbRiscInvolucroQhimp = fabbRiscInvolucroQhimp;
	}

	/**
	 * Method 'getFabbRiscImpiantoEtar'
	 * 
	 * @return Double
	 */
	public Double getFabbRiscImpiantoEtar()
	{
		return fabbRiscImpiantoEtar;
	}

	/**
	 * Method 'setFabbRiscImpiantoEtar'
	 * 
	 * @param fabbRiscImpiantoEtar
	 */
	public void setFabbRiscImpiantoEtar(Double fabbRiscImpiantoEtar)
	{
		this.fabbRiscImpiantoEtar = fabbRiscImpiantoEtar;
	}

	/**
	 * Method 'getFabbRiscImpiantoEtad'
	 * 
	 * @return Double
	 */
	public Double getFabbRiscImpiantoEtad()
	{
		return fabbRiscImpiantoEtad;
	}

	/**
	 * Method 'setFabbRiscImpiantoEtad'
	 * 
	 * @param fabbRiscImpiantoEtad
	 */
	public void setFabbRiscImpiantoEtad(Double fabbRiscImpiantoEtad)
	{
		this.fabbRiscImpiantoEtad = fabbRiscImpiantoEtad;
	}

	/**
	 * Method 'getFabbRiscImpiantoEtae'
	 * 
	 * @return Double
	 */
	public Double getFabbRiscImpiantoEtae()
	{
		return fabbRiscImpiantoEtae;
	}

	/**
	 * Method 'setFabbRiscImpiantoEtae'
	 * 
	 * @param fabbRiscImpiantoEtae
	 */
	public void setFabbRiscImpiantoEtae(Double fabbRiscImpiantoEtae)
	{
		this.fabbRiscImpiantoEtae = fabbRiscImpiantoEtae;
	}

	/**
	 * Method 'getFabbRiscImpiantoEtag'
	 * 
	 * @return Double
	 */
	public Double getFabbRiscImpiantoEtag()
	{
		return fabbRiscImpiantoEtag;
	}

	/**
	 * Method 'setFabbRiscImpiantoEtag'
	 * 
	 * @param fabbRiscImpiantoEtag
	 */
	public void setFabbRiscImpiantoEtag(Double fabbRiscImpiantoEtag)
	{
		this.fabbRiscImpiantoEtag = fabbRiscImpiantoEtag;
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
		
		if (!(_other instanceof SiceeTDatiXmlEdReale2015)) {
			return false;
		}
		
		final SiceeTDatiXmlEdReale2015 _cast = (SiceeTDatiXmlEdReale2015) _other;
		if (idCertificatore == null ? _cast.idCertificatore != idCertificatore : !idCertificatore.equals( _cast.idCertificatore )) {
			return false;
		}
		
		if (progrCertificato == null ? _cast.progrCertificato != progrCertificato : !progrCertificato.equals( _cast.progrCertificato )) {
			return false;
		}
		
		if (anno == null ? _cast.anno != anno : !anno.equals( _cast.anno )) {
			return false;
		}
		
		if (fabbRiscInvolucroExtraFlus == null ? _cast.fabbRiscInvolucroExtraFlus != fabbRiscInvolucroExtraFlus : !fabbRiscInvolucroExtraFlus.equals( _cast.fabbRiscInvolucroExtraFlus )) {
			return false;
		}
		
		if (fabbRiscInvolucroTrasmissio == null ? _cast.fabbRiscInvolucroTrasmissio != fabbRiscInvolucroTrasmissio : !fabbRiscInvolucroTrasmissio.equals( _cast.fabbRiscInvolucroTrasmissio )) {
			return false;
		}
		
		if (fabbRiscInvolucroVentilazio == null ? _cast.fabbRiscInvolucroVentilazio != fabbRiscInvolucroVentilazio : !fabbRiscInvolucroVentilazio.equals( _cast.fabbRiscInvolucroVentilazio )) {
			return false;
		}
		
		if (fabbRiscInvolucroApportiSo == null ? _cast.fabbRiscInvolucroApportiSo != fabbRiscInvolucroApportiSo : !fabbRiscInvolucroApportiSo.equals( _cast.fabbRiscInvolucroApportiSo )) {
			return false;
		}
		
		if (fabbRiscInvolucroApportiIn == null ? _cast.fabbRiscInvolucroApportiIn != fabbRiscInvolucroApportiIn : !fabbRiscInvolucroApportiIn.equals( _cast.fabbRiscInvolucroApportiIn )) {
			return false;
		}
		
		if (fabbRiscInvolucroApportiLa == null ? _cast.fabbRiscInvolucroApportiLa != fabbRiscInvolucroApportiLa : !fabbRiscInvolucroApportiLa.equals( _cast.fabbRiscInvolucroApportiLa )) {
			return false;
		}
		
		if (fabbRiscInvolucroQhnd == null ? _cast.fabbRiscInvolucroQhnd != fabbRiscInvolucroQhnd : !fabbRiscInvolucroQhnd.equals( _cast.fabbRiscInvolucroQhnd )) {
			return false;
		}
		
		if (fabbRiscInvolucroQlr == null ? _cast.fabbRiscInvolucroQlr != fabbRiscInvolucroQlr : !fabbRiscInvolucroQlr.equals( _cast.fabbRiscInvolucroQlr )) {
			return false;
		}
		
		if (fabbRiscInvolucroQhimp == null ? _cast.fabbRiscInvolucroQhimp != fabbRiscInvolucroQhimp : !fabbRiscInvolucroQhimp.equals( _cast.fabbRiscInvolucroQhimp )) {
			return false;
		}
		
		if (fabbRiscImpiantoEtar == null ? _cast.fabbRiscImpiantoEtar != fabbRiscImpiantoEtar : !fabbRiscImpiantoEtar.equals( _cast.fabbRiscImpiantoEtar )) {
			return false;
		}
		
		if (fabbRiscImpiantoEtad == null ? _cast.fabbRiscImpiantoEtad != fabbRiscImpiantoEtad : !fabbRiscImpiantoEtad.equals( _cast.fabbRiscImpiantoEtad )) {
			return false;
		}
		
		if (fabbRiscImpiantoEtae == null ? _cast.fabbRiscImpiantoEtae != fabbRiscImpiantoEtae : !fabbRiscImpiantoEtae.equals( _cast.fabbRiscImpiantoEtae )) {
			return false;
		}
		
		if (fabbRiscImpiantoEtag == null ? _cast.fabbRiscImpiantoEtag != fabbRiscImpiantoEtag : !fabbRiscImpiantoEtag.equals( _cast.fabbRiscImpiantoEtag )) {
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
		
		if (fabbRiscInvolucroExtraFlus != null) {
			_hashCode = 29 * _hashCode + fabbRiscInvolucroExtraFlus.hashCode();
		}
		
		if (fabbRiscInvolucroTrasmissio != null) {
			_hashCode = 29 * _hashCode + fabbRiscInvolucroTrasmissio.hashCode();
		}
		
		if (fabbRiscInvolucroVentilazio != null) {
			_hashCode = 29 * _hashCode + fabbRiscInvolucroVentilazio.hashCode();
		}
		
		if (fabbRiscInvolucroApportiSo != null) {
			_hashCode = 29 * _hashCode + fabbRiscInvolucroApportiSo.hashCode();
		}
		
		if (fabbRiscInvolucroApportiIn != null) {
			_hashCode = 29 * _hashCode + fabbRiscInvolucroApportiIn.hashCode();
		}
		
		if (fabbRiscInvolucroApportiLa != null) {
			_hashCode = 29 * _hashCode + fabbRiscInvolucroApportiLa.hashCode();
		}
		
		if (fabbRiscInvolucroQhnd != null) {
			_hashCode = 29 * _hashCode + fabbRiscInvolucroQhnd.hashCode();
		}
		
		if (fabbRiscInvolucroQlr != null) {
			_hashCode = 29 * _hashCode + fabbRiscInvolucroQlr.hashCode();
		}
		
		if (fabbRiscInvolucroQhimp != null) {
			_hashCode = 29 * _hashCode + fabbRiscInvolucroQhimp.hashCode();
		}
		
		if (fabbRiscImpiantoEtar != null) {
			_hashCode = 29 * _hashCode + fabbRiscImpiantoEtar.hashCode();
		}
		
		if (fabbRiscImpiantoEtad != null) {
			_hashCode = 29 * _hashCode + fabbRiscImpiantoEtad.hashCode();
		}
		
		if (fabbRiscImpiantoEtae != null) {
			_hashCode = 29 * _hashCode + fabbRiscImpiantoEtae.hashCode();
		}
		
		if (fabbRiscImpiantoEtag != null) {
			_hashCode = 29 * _hashCode + fabbRiscImpiantoEtag.hashCode();
		}
		
		return _hashCode;
	}

	/**
	 * Method 'createPk'
	 * 
	 * @return SiceeTDatiXmlEdReale2015Pk
	 */
	public SiceeTDatiXmlEdReale2015Pk createPk()
	{
		return new SiceeTDatiXmlEdReale2015Pk(idCertificatore, progrCertificato, anno);
	}

	/**
	 * Method 'toString'
	 * 
	 * @return String
	 */
	public String toString()
	{
		StringBuffer ret = new StringBuffer();
		ret.append( "it.csi.sicee.siceeweb.business.dao.dto.SiceeTDatiXmlEdReale2015: " );
		ret.append( "idCertificatore=" + idCertificatore );
		ret.append( ", progrCertificato=" + progrCertificato );
		ret.append( ", anno=" + anno );
		ret.append( ", fabbRiscInvolucroExtraFlus=" + fabbRiscInvolucroExtraFlus );
		ret.append( ", fabbRiscInvolucroTrasmissio=" + fabbRiscInvolucroTrasmissio );
		ret.append( ", fabbRiscInvolucroVentilazio=" + fabbRiscInvolucroVentilazio );
		ret.append( ", fabbRiscInvolucroApportiSo=" + fabbRiscInvolucroApportiSo );
		ret.append( ", fabbRiscInvolucroApportiIn=" + fabbRiscInvolucroApportiIn );
		ret.append( ", fabbRiscInvolucroApportiLa=" + fabbRiscInvolucroApportiLa );
		ret.append( ", fabbRiscInvolucroQhnd=" + fabbRiscInvolucroQhnd );
		ret.append( ", fabbRiscInvolucroQlr=" + fabbRiscInvolucroQlr );
		ret.append( ", fabbRiscInvolucroQhimp=" + fabbRiscInvolucroQhimp );
		ret.append( ", fabbRiscImpiantoEtar=" + fabbRiscImpiantoEtar );
		ret.append( ", fabbRiscImpiantoEtad=" + fabbRiscImpiantoEtad );
		ret.append( ", fabbRiscImpiantoEtae=" + fabbRiscImpiantoEtae );
		ret.append( ", fabbRiscImpiantoEtag=" + fabbRiscImpiantoEtag );
		return ret.toString();
	}

}
