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

public class SiceeTDatiXmlEdRif2015 implements Serializable
{
	/** 
	 * This attribute maps to the column ID_CERTIFICATORE in the SICEE_T_DATI_XML_ED_RIF_2015 table.
	 */
	protected String idCertificatore;

	/** 
	 * This attribute maps to the column PROGR_CERTIFICATO in the SICEE_T_DATI_XML_ED_RIF_2015 table.
	 */
	protected String progrCertificato;

	/** 
	 * This attribute maps to the column ANNO in the SICEE_T_DATI_XML_ED_RIF_2015 table.
	 */
	protected String anno;

	/** 
	 * This attribute maps to the column QH in the SICEE_T_DATI_XML_ED_RIF_2015 table.
	 */
	protected Double qh;

	/** 
	 * This attribute maps to the column QC in the SICEE_T_DATI_XML_ED_RIF_2015 table.
	 */
	protected Double qc;

	/** 
	 * This attribute maps to the column EPHND in the SICEE_T_DATI_XML_ED_RIF_2015 table.
	 */
	protected Double ephnd;

	/** 
	 * This attribute maps to the column EPCND in the SICEE_T_DATI_XML_ED_RIF_2015 table.
	 */
	protected Double epcnd;

	/** 
	 * This attribute maps to the column EPH in the SICEE_T_DATI_XML_ED_RIF_2015 table.
	 */
	protected Double eph;

	/** 
	 * This attribute maps to the column EPC in the SICEE_T_DATI_XML_ED_RIF_2015 table.
	 */
	protected Double epc;

	/** 
	 * This attribute maps to the column EPW in the SICEE_T_DATI_XML_ED_RIF_2015 table.
	 */
	protected Double epw;

	/** 
	 * This attribute maps to the column EPV in the SICEE_T_DATI_XML_ED_RIF_2015 table.
	 */
	protected Double epv;

	/** 
	 * This attribute maps to the column EPL in the SICEE_T_DATI_XML_ED_RIF_2015 table.
	 */
	protected Double epl;

	/** 
	 * This attribute maps to the column EPGLNR in the SICEE_T_DATI_XML_ED_RIF_2015 table.
	 */
	protected Double epglnr;

	/** 
	 * This attribute maps to the column EPGLR in the SICEE_T_DATI_XML_ED_RIF_2015 table.
	 */
	protected Double epglr;

	/** 
	 * This attribute maps to the column EPGLTOT in the SICEE_T_DATI_XML_ED_RIF_2015 table.
	 */
	protected Double epgltot;

	/** 
	 * This attribute maps to the column ETAH in the SICEE_T_DATI_XML_ED_RIF_2015 table.
	 */
	protected Double etah;

	/** 
	 * This attribute maps to the column ETAC in the SICEE_T_DATI_XML_ED_RIF_2015 table.
	 */
	protected Double etac;

	/** 
	 * This attribute maps to the column ETAW in the SICEE_T_DATI_XML_ED_RIF_2015 table.
	 */
	protected Double etaw;

	/**
	 * Method 'SiceeTDatiXmlEdRif2015'
	 * 
	 */
	public SiceeTDatiXmlEdRif2015()
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
	 * Method 'getQh'
	 * 
	 * @return Double
	 */
	public Double getQh()
	{
		return qh;
	}

	/**
	 * Method 'setQh'
	 * 
	 * @param qh
	 */
	public void setQh(Double qh)
	{
		this.qh = qh;
	}

	/**
	 * Method 'getQc'
	 * 
	 * @return Double
	 */
	public Double getQc()
	{
		return qc;
	}

	/**
	 * Method 'setQc'
	 * 
	 * @param qc
	 */
	public void setQc(Double qc)
	{
		this.qc = qc;
	}

	/**
	 * Method 'getEphnd'
	 * 
	 * @return Double
	 */
	public Double getEphnd()
	{
		return ephnd;
	}

	/**
	 * Method 'setEphnd'
	 * 
	 * @param ephnd
	 */
	public void setEphnd(Double ephnd)
	{
		this.ephnd = ephnd;
	}

	/**
	 * Method 'getEpcnd'
	 * 
	 * @return Double
	 */
	public Double getEpcnd()
	{
		return epcnd;
	}

	/**
	 * Method 'setEpcnd'
	 * 
	 * @param epcnd
	 */
	public void setEpcnd(Double epcnd)
	{
		this.epcnd = epcnd;
	}

	/**
	 * Method 'getEph'
	 * 
	 * @return Double
	 */
	public Double getEph()
	{
		return eph;
	}

	/**
	 * Method 'setEph'
	 * 
	 * @param eph
	 */
	public void setEph(Double eph)
	{
		this.eph = eph;
	}

	/**
	 * Method 'getEpc'
	 * 
	 * @return Double
	 */
	public Double getEpc()
	{
		return epc;
	}

	/**
	 * Method 'setEpc'
	 * 
	 * @param epc
	 */
	public void setEpc(Double epc)
	{
		this.epc = epc;
	}

	/**
	 * Method 'getEpw'
	 * 
	 * @return Double
	 */
	public Double getEpw()
	{
		return epw;
	}

	/**
	 * Method 'setEpw'
	 * 
	 * @param epw
	 */
	public void setEpw(Double epw)
	{
		this.epw = epw;
	}

	/**
	 * Method 'getEpv'
	 * 
	 * @return Double
	 */
	public Double getEpv()
	{
		return epv;
	}

	/**
	 * Method 'setEpv'
	 * 
	 * @param epv
	 */
	public void setEpv(Double epv)
	{
		this.epv = epv;
	}

	/**
	 * Method 'getEpl'
	 * 
	 * @return Double
	 */
	public Double getEpl()
	{
		return epl;
	}

	/**
	 * Method 'setEpl'
	 * 
	 * @param epl
	 */
	public void setEpl(Double epl)
	{
		this.epl = epl;
	}

	/**
	 * Method 'getEpglnr'
	 * 
	 * @return Double
	 */
	public Double getEpglnr()
	{
		return epglnr;
	}

	/**
	 * Method 'setEpglnr'
	 * 
	 * @param epglnr
	 */
	public void setEpglnr(Double epglnr)
	{
		this.epglnr = epglnr;
	}

	/**
	 * Method 'getEpglr'
	 * 
	 * @return Double
	 */
	public Double getEpglr()
	{
		return epglr;
	}

	/**
	 * Method 'setEpglr'
	 * 
	 * @param epglr
	 */
	public void setEpglr(Double epglr)
	{
		this.epglr = epglr;
	}

	/**
	 * Method 'getEpgltot'
	 * 
	 * @return Double
	 */
	public Double getEpgltot()
	{
		return epgltot;
	}

	/**
	 * Method 'setEpgltot'
	 * 
	 * @param epgltot
	 */
	public void setEpgltot(Double epgltot)
	{
		this.epgltot = epgltot;
	}

	/**
	 * Method 'getEtah'
	 * 
	 * @return Double
	 */
	public Double getEtah()
	{
		return etah;
	}

	/**
	 * Method 'setEtah'
	 * 
	 * @param etah
	 */
	public void setEtah(Double etah)
	{
		this.etah = etah;
	}

	/**
	 * Method 'getEtac'
	 * 
	 * @return Double
	 */
	public Double getEtac()
	{
		return etac;
	}

	/**
	 * Method 'setEtac'
	 * 
	 * @param etac
	 */
	public void setEtac(Double etac)
	{
		this.etac = etac;
	}

	/**
	 * Method 'getEtaw'
	 * 
	 * @return Double
	 */
	public Double getEtaw()
	{
		return etaw;
	}

	/**
	 * Method 'setEtaw'
	 * 
	 * @param etaw
	 */
	public void setEtaw(Double etaw)
	{
		this.etaw = etaw;
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
		
		if (!(_other instanceof SiceeTDatiXmlEdRif2015)) {
			return false;
		}
		
		final SiceeTDatiXmlEdRif2015 _cast = (SiceeTDatiXmlEdRif2015) _other;
		if (idCertificatore == null ? _cast.idCertificatore != idCertificatore : !idCertificatore.equals( _cast.idCertificatore )) {
			return false;
		}
		
		if (progrCertificato == null ? _cast.progrCertificato != progrCertificato : !progrCertificato.equals( _cast.progrCertificato )) {
			return false;
		}
		
		if (anno == null ? _cast.anno != anno : !anno.equals( _cast.anno )) {
			return false;
		}
		
		if (qh == null ? _cast.qh != qh : !qh.equals( _cast.qh )) {
			return false;
		}
		
		if (qc == null ? _cast.qc != qc : !qc.equals( _cast.qc )) {
			return false;
		}
		
		if (ephnd == null ? _cast.ephnd != ephnd : !ephnd.equals( _cast.ephnd )) {
			return false;
		}
		
		if (epcnd == null ? _cast.epcnd != epcnd : !epcnd.equals( _cast.epcnd )) {
			return false;
		}
		
		if (eph == null ? _cast.eph != eph : !eph.equals( _cast.eph )) {
			return false;
		}
		
		if (epc == null ? _cast.epc != epc : !epc.equals( _cast.epc )) {
			return false;
		}
		
		if (epw == null ? _cast.epw != epw : !epw.equals( _cast.epw )) {
			return false;
		}
		
		if (epv == null ? _cast.epv != epv : !epv.equals( _cast.epv )) {
			return false;
		}
		
		if (epl == null ? _cast.epl != epl : !epl.equals( _cast.epl )) {
			return false;
		}
		
		if (epglnr == null ? _cast.epglnr != epglnr : !epglnr.equals( _cast.epglnr )) {
			return false;
		}
		
		if (epglr == null ? _cast.epglr != epglr : !epglr.equals( _cast.epglr )) {
			return false;
		}
		
		if (epgltot == null ? _cast.epgltot != epgltot : !epgltot.equals( _cast.epgltot )) {
			return false;
		}
		
		if (etah == null ? _cast.etah != etah : !etah.equals( _cast.etah )) {
			return false;
		}
		
		if (etac == null ? _cast.etac != etac : !etac.equals( _cast.etac )) {
			return false;
		}
		
		if (etaw == null ? _cast.etaw != etaw : !etaw.equals( _cast.etaw )) {
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
		
		if (qh != null) {
			_hashCode = 29 * _hashCode + qh.hashCode();
		}
		
		if (qc != null) {
			_hashCode = 29 * _hashCode + qc.hashCode();
		}
		
		if (ephnd != null) {
			_hashCode = 29 * _hashCode + ephnd.hashCode();
		}
		
		if (epcnd != null) {
			_hashCode = 29 * _hashCode + epcnd.hashCode();
		}
		
		if (eph != null) {
			_hashCode = 29 * _hashCode + eph.hashCode();
		}
		
		if (epc != null) {
			_hashCode = 29 * _hashCode + epc.hashCode();
		}
		
		if (epw != null) {
			_hashCode = 29 * _hashCode + epw.hashCode();
		}
		
		if (epv != null) {
			_hashCode = 29 * _hashCode + epv.hashCode();
		}
		
		if (epl != null) {
			_hashCode = 29 * _hashCode + epl.hashCode();
		}
		
		if (epglnr != null) {
			_hashCode = 29 * _hashCode + epglnr.hashCode();
		}
		
		if (epglr != null) {
			_hashCode = 29 * _hashCode + epglr.hashCode();
		}
		
		if (epgltot != null) {
			_hashCode = 29 * _hashCode + epgltot.hashCode();
		}
		
		if (etah != null) {
			_hashCode = 29 * _hashCode + etah.hashCode();
		}
		
		if (etac != null) {
			_hashCode = 29 * _hashCode + etac.hashCode();
		}
		
		if (etaw != null) {
			_hashCode = 29 * _hashCode + etaw.hashCode();
		}
		
		return _hashCode;
	}

	/**
	 * Method 'createPk'
	 * 
	 * @return SiceeTDatiXmlEdRif2015Pk
	 */
	public SiceeTDatiXmlEdRif2015Pk createPk()
	{
		return new SiceeTDatiXmlEdRif2015Pk(idCertificatore, progrCertificato, anno);
	}

	/**
	 * Method 'toString'
	 * 
	 * @return String
	 */
	public String toString()
	{
		StringBuffer ret = new StringBuffer();
		ret.append( "it.csi.sicee.siceeweb.business.dao.dto.SiceeTDatiXmlEdRif2015: " );
		ret.append( "idCertificatore=" + idCertificatore );
		ret.append( ", progrCertificato=" + progrCertificato );
		ret.append( ", anno=" + anno );
		ret.append( ", qh=" + qh );
		ret.append( ", qc=" + qc );
		ret.append( ", ephnd=" + ephnd );
		ret.append( ", epcnd=" + epcnd );
		ret.append( ", eph=" + eph );
		ret.append( ", epc=" + epc );
		ret.append( ", epw=" + epw );
		ret.append( ", epv=" + epv );
		ret.append( ", epl=" + epl );
		ret.append( ", epglnr=" + epglnr );
		ret.append( ", epglr=" + epglr );
		ret.append( ", epgltot=" + epgltot );
		ret.append( ", etah=" + etah );
		ret.append( ", etac=" + etac );
		ret.append( ", etaw=" + etaw );
		return ret.toString();
	}

}
