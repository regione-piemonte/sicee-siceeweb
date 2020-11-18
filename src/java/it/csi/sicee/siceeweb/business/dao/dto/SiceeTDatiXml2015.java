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

public class SiceeTDatiXml2015 implements Serializable
{
	/** 
	 * This attribute maps to the column ID_CERTIFICATORE in the SICEE_T_DATI_XML_2015 table.
	 */
	protected String idCertificatore;

	/** 
	 * This attribute maps to the column PROGR_CERTIFICATO in the SICEE_T_DATI_XML_2015 table.
	 */
	protected String progrCertificato;

	/** 
	 * This attribute maps to the column ANNO in the SICEE_T_DATI_XML_2015 table.
	 */
	protected String anno;

	/** 
	 * This attribute maps to the column FK_TIPO_VENTILAZIONE in the SICEE_T_DATI_XML_2015 table.
	 */
	protected Integer fkTipoVentilazione;

	/** 
	 * This attribute maps to the column DT_TITOLO_ABILITATIVO in the SICEE_T_DATI_XML_2015 table.
	 */
	protected Date dtTitoloAbilitativo;

	/** 
	 * This attribute maps to the column FLG_SISTEMA_CONTABILIZZAZIONE in the SICEE_T_DATI_XML_2015 table.
	 */
	protected String flgSistemaContabilizzazione;

	/** 
	 * This attribute maps to the column HT in the SICEE_T_DATI_XML_2015 table.
	 */
	protected Double ht;

	/** 
	 * This attribute maps to the column SUP_DISP_TOT_OPACA in the SICEE_T_DATI_XML_2015 table.
	 */
	protected Double supDispTotOpaca;

	/** 
	 * This attribute maps to the column SUP_DISP_TOT_TRASP in the SICEE_T_DATI_XML_2015 table.
	 */
	protected Double supDispTotTrasp;

	/** 
	 * This attribute maps to the column TRASMITTANZA_MED_SUP_OPACHE in the SICEE_T_DATI_XML_2015 table.
	 */
	protected Double trasmittanzaMedSupOpache;

	/** 
	 * This attribute maps to the column TRASMITTANZA_MED_SUP_TRASP in the SICEE_T_DATI_XML_2015 table.
	 */
	protected Double trasmittanzaMedSupTrasp;

	/** 
	 * This attribute maps to the column PORTATA_VENTILAZIONE_TOT in the SICEE_T_DATI_XML_2015 table.
	 */
	protected Double portataVentilazioneTot;

	/** 
	 * This attribute maps to the column EFFICIENZA_RECUPERO_MEDIO in the SICEE_T_DATI_XML_2015 table.
	 */
	protected Double efficienzaRecuperoMedio;

	/** 
	 * This attribute maps to the column GRADI_GIORNO in the SICEE_T_DATI_XML_2015 table.
	 */
	protected Integer gradiGiorno;
	
	/** 
	 * This attribute maps to the column DT_SOPRALLUOGO in the SICEE_T_DATI_XML_2015 table.
	 */
	protected Date dtSopralluogo;
	
	/** 
	 * This attribute maps to the column SW_UTILIZZATO in the SICEE_T_DATI_XML_2015 table.
	 */
	protected String swUtilizzato;

	
	/** 
	 * This attribute maps to the column NUM_CERTIF_SW in the SICEE_T_DATI_XML_2015 table.
	 */
	protected Integer numCertifSw;

	
	/**
	 * Method 'SiceeTDatiXml2015'
	 * 
	 */
	public SiceeTDatiXml2015()
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
	 * Method 'getFkTipoVentilazione'
	 * 
	 * @return Integer
	 */
	public Integer getFkTipoVentilazione()
	{
		return fkTipoVentilazione;
	}

	/**
	 * Method 'setFkTipoVentilazione'
	 * 
	 * @param fkTipoVentilazione
	 */
	public void setFkTipoVentilazione(Integer fkTipoVentilazione)
	{
		this.fkTipoVentilazione = fkTipoVentilazione;
	}

	/**
	 * Method 'getDtTitoloAbilitativo'
	 * 
	 * @return Date
	 */
	public Date getDtTitoloAbilitativo()
	{
		return dtTitoloAbilitativo;
	}

	/**
	 * Method 'setDtTitoloAbilitativo'
	 * 
	 * @param dtTitoloAbilitativo
	 */
	public void setDtTitoloAbilitativo(Date dtTitoloAbilitativo)
	{
		this.dtTitoloAbilitativo = dtTitoloAbilitativo;
	}

	/**
	 * Method 'getFlgSistemaContabilizzazione'
	 * 
	 * @return String
	 */
	public String getFlgSistemaContabilizzazione()
	{
		return flgSistemaContabilizzazione;
	}

	/**
	 * Method 'setFlgSistemaContabilizzazione'
	 * 
	 * @param flgSistemaContabilizzazione
	 */
	public void setFlgSistemaContabilizzazione(String flgSistemaContabilizzazione)
	{
		this.flgSistemaContabilizzazione = flgSistemaContabilizzazione;
	}

	/**
	 * Method 'getHt'
	 * 
	 * @return Double
	 */
	public Double getHt()
	{
		return ht;
	}

	/**
	 * Method 'setHt'
	 * 
	 * @param ht
	 */
	public void setHt(Double ht)
	{
		this.ht = ht;
	}

	/**
	 * Method 'getSupDispTotOpaca'
	 * 
	 * @return Double
	 */
	public Double getSupDispTotOpaca()
	{
		return supDispTotOpaca;
	}

	/**
	 * Method 'setSupDispTotOpaca'
	 * 
	 * @param supDispTotOpaca
	 */
	public void setSupDispTotOpaca(Double supDispTotOpaca)
	{
		this.supDispTotOpaca = supDispTotOpaca;
	}

	/**
	 * Method 'getSupDispTotTrasp'
	 * 
	 * @return Double
	 */
	public Double getSupDispTotTrasp()
	{
		return supDispTotTrasp;
	}

	/**
	 * Method 'setSupDispTotTrasp'
	 * 
	 * @param supDispTotTrasp
	 */
	public void setSupDispTotTrasp(Double supDispTotTrasp)
	{
		this.supDispTotTrasp = supDispTotTrasp;
	}

	/**
	 * Method 'getTrasmittanzaMedSupOpache'
	 * 
	 * @return Double
	 */
	public Double getTrasmittanzaMedSupOpache()
	{
		return trasmittanzaMedSupOpache;
	}

	/**
	 * Method 'setTrasmittanzaMedSupOpache'
	 * 
	 * @param trasmittanzaMedSupOpache
	 */
	public void setTrasmittanzaMedSupOpache(Double trasmittanzaMedSupOpache)
	{
		this.trasmittanzaMedSupOpache = trasmittanzaMedSupOpache;
	}

	/**
	 * Method 'getTrasmittanzaMedSupTrasp'
	 * 
	 * @return Double
	 */
	public Double getTrasmittanzaMedSupTrasp()
	{
		return trasmittanzaMedSupTrasp;
	}

	/**
	 * Method 'setTrasmittanzaMedSupTrasp'
	 * 
	 * @param trasmittanzaMedSupTrasp
	 */
	public void setTrasmittanzaMedSupTrasp(Double trasmittanzaMedSupTrasp)
	{
		this.trasmittanzaMedSupTrasp = trasmittanzaMedSupTrasp;
	}

	/**
	 * Method 'getPortataVentilazioneTot'
	 * 
	 * @return Double
	 */
	public Double getPortataVentilazioneTot()
	{
		return portataVentilazioneTot;
	}

	/**
	 * Method 'setPortataVentilazioneTot'
	 * 
	 * @param portataVentilazioneTot
	 */
	public void setPortataVentilazioneTot(Double portataVentilazioneTot)
	{
		this.portataVentilazioneTot = portataVentilazioneTot;
	}

	/**
	 * Method 'getEfficienzaRecuperoMedio'
	 * 
	 * @return Double
	 */
	public Double getEfficienzaRecuperoMedio()
	{
		return efficienzaRecuperoMedio;
	}

	/**
	 * Method 'setEfficienzaRecuperoMedio'
	 * 
	 * @param efficienzaRecuperoMedio
	 */
	public void setEfficienzaRecuperoMedio(Double efficienzaRecuperoMedio)
	{
		this.efficienzaRecuperoMedio = efficienzaRecuperoMedio;
	}

	
	
	/**
	 * @return the gradiGiorno
	 */
	public Integer getGradiGiorno() {
		return gradiGiorno;
	}

	/**
	 * @param gradiGiorno the gradiGiorno to set
	 */
	public void setGradiGiorno(Integer gradiGiorno) {
		this.gradiGiorno = gradiGiorno;
	}

	/**
	 * @return the dtSopralluogo
	 */
	public Date getDtSopralluogo() {
		return dtSopralluogo;
	}

	/**
	 * @param dtSopralluogo the dtSopralluogo to set
	 */
	public void setDtSopralluogo(Date dtSopralluogo) {
		this.dtSopralluogo = dtSopralluogo;
	}

	/**
	 * @return the swUtilizzato
	 */
	public String getSwUtilizzato() {
		return swUtilizzato;
	}

	/**
	 * @param swUtilizzato the swUtilizzato to set
	 */
	public void setSwUtilizzato(String swUtilizzato) {
		this.swUtilizzato = swUtilizzato;
	}

	/**
	 * @return the numCertifSw
	 */
	public Integer getNumCertifSw() {
		return numCertifSw;
	}

	/**
	 * @param numCertifSw the numCertifSw to set
	 */
	public void setNumCertifSw(Integer numCertifSw) {
		this.numCertifSw = numCertifSw;
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
		
		if (!(_other instanceof SiceeTDatiXml2015)) {
			return false;
		}
		
		final SiceeTDatiXml2015 _cast = (SiceeTDatiXml2015) _other;
		if (idCertificatore == null ? _cast.idCertificatore != idCertificatore : !idCertificatore.equals( _cast.idCertificatore )) {
			return false;
		}
		
		if (progrCertificato == null ? _cast.progrCertificato != progrCertificato : !progrCertificato.equals( _cast.progrCertificato )) {
			return false;
		}
		
		if (anno == null ? _cast.anno != anno : !anno.equals( _cast.anno )) {
			return false;
		}
		
		if (fkTipoVentilazione == null ? _cast.fkTipoVentilazione != fkTipoVentilazione : !fkTipoVentilazione.equals( _cast.fkTipoVentilazione )) {
			return false;
		}
		
		if (dtTitoloAbilitativo == null ? _cast.dtTitoloAbilitativo != dtTitoloAbilitativo : !dtTitoloAbilitativo.equals( _cast.dtTitoloAbilitativo )) {
			return false;
		}
		
		if (flgSistemaContabilizzazione == null ? _cast.flgSistemaContabilizzazione != flgSistemaContabilizzazione : !flgSistemaContabilizzazione.equals( _cast.flgSistemaContabilizzazione )) {
			return false;
		}
		
		if (ht == null ? _cast.ht != ht : !ht.equals( _cast.ht )) {
			return false;
		}
		
		if (supDispTotOpaca == null ? _cast.supDispTotOpaca != supDispTotOpaca : !supDispTotOpaca.equals( _cast.supDispTotOpaca )) {
			return false;
		}
		
		if (supDispTotTrasp == null ? _cast.supDispTotTrasp != supDispTotTrasp : !supDispTotTrasp.equals( _cast.supDispTotTrasp )) {
			return false;
		}
		
		if (trasmittanzaMedSupOpache == null ? _cast.trasmittanzaMedSupOpache != trasmittanzaMedSupOpache : !trasmittanzaMedSupOpache.equals( _cast.trasmittanzaMedSupOpache )) {
			return false;
		}
		
		if (trasmittanzaMedSupTrasp == null ? _cast.trasmittanzaMedSupTrasp != trasmittanzaMedSupTrasp : !trasmittanzaMedSupTrasp.equals( _cast.trasmittanzaMedSupTrasp )) {
			return false;
		}
		
		if (portataVentilazioneTot == null ? _cast.portataVentilazioneTot != portataVentilazioneTot : !portataVentilazioneTot.equals( _cast.portataVentilazioneTot )) {
			return false;
		}
		
		if (efficienzaRecuperoMedio == null ? _cast.efficienzaRecuperoMedio != efficienzaRecuperoMedio : !efficienzaRecuperoMedio.equals( _cast.efficienzaRecuperoMedio )) {
			return false;
		}
		
		if (gradiGiorno == null ? _cast.gradiGiorno != gradiGiorno : !gradiGiorno.equals( _cast.gradiGiorno )) {
			return false;
		}
		
		if (dtSopralluogo == null ? _cast.dtSopralluogo != dtSopralluogo : !dtSopralluogo.equals( _cast.dtSopralluogo )) {
			return false;
		}
		
		if (swUtilizzato == null ? _cast.swUtilizzato != swUtilizzato : !swUtilizzato.equals( _cast.swUtilizzato )) {
			return false;
		}
		
		if (numCertifSw == null ? _cast.numCertifSw != numCertifSw : !numCertifSw.equals( _cast.numCertifSw )) {
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
		
		if (fkTipoVentilazione != null) {
			_hashCode = 29 * _hashCode + fkTipoVentilazione.hashCode();
		}
		
		if (dtTitoloAbilitativo != null) {
			_hashCode = 29 * _hashCode + dtTitoloAbilitativo.hashCode();
		}
		
		if (flgSistemaContabilizzazione != null) {
			_hashCode = 29 * _hashCode + flgSistemaContabilizzazione.hashCode();
		}
		
		if (ht != null) {
			_hashCode = 29 * _hashCode + ht.hashCode();
		}
		
		if (supDispTotOpaca != null) {
			_hashCode = 29 * _hashCode + supDispTotOpaca.hashCode();
		}
		
		if (supDispTotTrasp != null) {
			_hashCode = 29 * _hashCode + supDispTotTrasp.hashCode();
		}
		
		if (trasmittanzaMedSupOpache != null) {
			_hashCode = 29 * _hashCode + trasmittanzaMedSupOpache.hashCode();
		}
		
		if (trasmittanzaMedSupTrasp != null) {
			_hashCode = 29 * _hashCode + trasmittanzaMedSupTrasp.hashCode();
		}
		
		if (portataVentilazioneTot != null) {
			_hashCode = 29 * _hashCode + portataVentilazioneTot.hashCode();
		}
		
		if (efficienzaRecuperoMedio != null) {
			_hashCode = 29 * _hashCode + efficienzaRecuperoMedio.hashCode();
		}
		
		if (gradiGiorno != null) {
			_hashCode = 29 * _hashCode + gradiGiorno.hashCode();
		}
		
		if (dtSopralluogo != null) {
			_hashCode = 29 * _hashCode + dtSopralluogo.hashCode();
		}
		
		if (swUtilizzato != null) {
			_hashCode = 29 * _hashCode + swUtilizzato.hashCode();
		}
		
		if (numCertifSw != null) {
			_hashCode = 29 * _hashCode + numCertifSw.hashCode();
		}
		
		return _hashCode;
	}

	/**
	 * Method 'createPk'
	 * 
	 * @return SiceeTDatiXml2015Pk
	 */
	public SiceeTDatiXml2015Pk createPk()
	{
		return new SiceeTDatiXml2015Pk(idCertificatore, progrCertificato, anno);
	}

	/**
	 * Method 'toString'
	 * 
	 * @return String
	 */
	public String toString()
	{
		StringBuffer ret = new StringBuffer();
		ret.append( "it.csi.sicee.siceeweb.business.dao.dto.SiceeTDatiXml2015: " );
		ret.append( "idCertificatore=" + idCertificatore );
		ret.append( ", progrCertificato=" + progrCertificato );
		ret.append( ", anno=" + anno );
		ret.append( ", fkTipoVentilazione=" + fkTipoVentilazione );
		ret.append( ", dtTitoloAbilitativo=" + dtTitoloAbilitativo );
		ret.append( ", flgSistemaContabilizzazione=" + flgSistemaContabilizzazione );
		ret.append( ", ht=" + ht );
		ret.append( ", supDispTotOpaca=" + supDispTotOpaca );
		ret.append( ", supDispTotTrasp=" + supDispTotTrasp );
		ret.append( ", trasmittanzaMedSupOpache=" + trasmittanzaMedSupOpache );
		ret.append( ", trasmittanzaMedSupTrasp=" + trasmittanzaMedSupTrasp );
		ret.append( ", portataVentilazioneTot=" + portataVentilazioneTot );
		ret.append( ", efficienzaRecuperoMedio=" + efficienzaRecuperoMedio );

		ret.append( ", gradiGiorno=" + gradiGiorno );
		ret.append( ", dtSopralluogo=" + dtSopralluogo );
		ret.append( ", swUtilizzato=" + swUtilizzato );
		ret.append( ", numCertifSw=" + numCertifSw );
		
		return ret.toString();
	}

}
