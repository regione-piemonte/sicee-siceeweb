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

public class SiceeTDatiGenerali implements Serializable
{
	/** 
	 * This attribute maps to the column ID_CERTIFICATORE in the SICEE_T_DATI_GENERALI table.
	 */
	protected String idCertificatore;

	/** 
	 * This attribute maps to the column PROGR_CERTIFICATO in the SICEE_T_DATI_GENERALI table.
	 */
	protected String progrCertificato;

	/** 
	 * This attribute maps to the column ANNO in the SICEE_T_DATI_GENERALI table.
	 */
	protected String anno;

	/** 
	 * This attribute maps to the column DESC_TIPO_EDIFICIO in the SICEE_T_DATI_GENERALI table.
	 */
	protected String descTipoEdificio;

	/** 
	 * This attribute maps to the column FK_DEST_USO in the SICEE_T_DATI_GENERALI table.
	 */
	protected Integer fkDestUso;

	/** 
	 * This attribute maps to the column ANNO_COSTRUZIONE in the SICEE_T_DATI_GENERALI table.
	 */
	protected Integer annoCostruzione;

	/** 
	 * This attribute maps to the column ANNO_ULT_RIST in the SICEE_T_DATI_GENERALI table.
	 */
	protected Integer annoUltRist;

	/** 
	 * This attribute maps to the column VOL_LORDO_RISCALDATO in the SICEE_T_DATI_GENERALI table.
	 */
	protected Double volLordoRiscaldato;

	/** 
	 * This attribute maps to the column SUP_DISPERDENTE_TOT in the SICEE_T_DATI_GENERALI table.
	 */
	protected Double supDisperdenteTot;

	/** 
	 * This attribute maps to the column FATTORE_FORMA in the SICEE_T_DATI_GENERALI table.
	 */
	protected Double fattoreForma;

	/** 
	 * This attribute maps to the column TRASM_OPACHE in the SICEE_T_DATI_GENERALI table.
	 */
	protected Double trasmOpache;

	/** 
	 * This attribute maps to the column TRASM_TRASP in the SICEE_T_DATI_GENERALI table.
	 */
	protected Double trasmTrasp;

	/** 
	 * This attribute maps to the column ZONA_CLIMATICA in the SICEE_T_DATI_GENERALI table.
	 */
	protected String zonaClimatica;

	/** 
	 * This attribute maps to the column GRADI_GIORNO in the SICEE_T_DATI_GENERALI table.
	 */
	protected Integer gradiGiorno;

	/** 
	 * This attribute maps to the column SU in the SICEE_T_DATI_GENERALI table.
	 */
	protected Double su;

	/** 
	 * This attribute maps to the column EMISSIONI_SERRA in the SICEE_T_DATI_GENERALI table.
	 */
	protected Double emissioniSerra;

	/** 
	 * This attribute maps to the column ETTARI_BOSCO in the SICEE_T_DATI_GENERALI table.
	 */
	protected Double ettariBosco;

	/** 
	 * This attribute maps to the column FLG_USO_PUBBLICO in the SICEE_T_DATI_GENERALI table.
	 */
	protected String flagUsoPubblico;

	/** 
	 * This attribute maps to the column FK_CARATT_EDIFICIO in the SICEE_T_DATI_GENERALI table.
	 */
	protected Integer fkCarattEdificio;

	/** 
	 * This attribute maps to the column NR_UM in the SICEE_T_DATI_GENERALI table.
	 */
	protected Integer nrUm;

	/** 
	 * This attribute maps to the column SUP_RISCALDATA in the SICEE_T_DATI_GENERALI table.
	 */
	protected Double supRiscaldata;

	/** 
	 * This attribute maps to the column SUP_RAFFRESCATA in the SICEE_T_DATI_GENERALI table.
	 */
	protected Double supRaffrescata;

	/** 
	 * This attribute maps to the column SUP_DISPERDENTE in the SICEE_T_DATI_GENERALI table.
	 */
	protected Double supDisperdente;

	/** 
	 * This attribute maps to the column VOL_LORDO_RAFFRESCATO in the SICEE_T_DATI_GENERALI table.
	 */
	protected Double volLordoRaffrescato;

	/** 
	 * This attribute maps to the column FK_OGGETTO_APE in the SICEE_T_DATI_GENERALI table.
	 */
	protected Integer fkOggettoApe;

	/** 
	 * This attribute represents whether the primitive attribute fkOggettoApe is null.
	 */
	protected boolean fkOggettoApeNull = true;

	/** 
	 * This attribute maps to the column FK_DEST_USO_2015 in the SICEE_T_DATI_GENERALI table.
	 */
	protected Integer fkDestUso2015;

	/** 
	 * This attribute maps to the column FK_TIPO_RISTRUTTURAZ in the SICEE_T_DATI_GENERALI table.
	 */
	protected Integer fkTipoRistrutturaz;

	/** 
	 * This attribute maps to the column FK_TIPOL_EDILIZIA in the SICEE_T_DATI_GENERALI table.
	 */
	protected Integer fkTipolEdilizia;

	/** 
	 * This attribute maps to the column FK_TIPOL_COSTRUTTIVA in the SICEE_T_DATI_GENERALI table.
	 */
	protected Integer fkTipolCostruttiva;

	/** 
	 * This attribute maps to the column FK_PROPRIETA_EDI in the SICEE_T_DATI_GENERALI table.
	 */
	protected Integer fkProprietaEdi;

	/** 
	 * This attribute maps to the column CODICE_EDIFICIO_SCOLASTICO in the SICEE_T_DATI_GENERALI table.
	 */
	protected String codiceEdificioScolastico;
	
	
	
	/**
	 * Method 'SiceeTDatiGenerali'
	 * 
	 */
	public SiceeTDatiGenerali()
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
	 * Method 'getDescTipoEdificio'
	 * 
	 * @return String
	 */
	public String getDescTipoEdificio()
	{
		return descTipoEdificio;
	}

	/**
	 * Method 'setDescTipoEdificio'
	 * 
	 * @param descTipoEdificio
	 */
	public void setDescTipoEdificio(String descTipoEdificio)
	{
		this.descTipoEdificio = descTipoEdificio;
	}

	/**
	 * Method 'getFkDestUso'
	 * 
	 * @return Integer
	 */
	public Integer getFkDestUso()
	{
		return fkDestUso;
	}

	/**
	 * Method 'setFkDestUso'
	 * 
	 * @param fkDestUso
	 */
	public void setFkDestUso(Integer fkDestUso)
	{
		this.fkDestUso = fkDestUso;
	}

	/**
	 * Method 'getAnnoCostruzione'
	 * 
	 * @return Integer
	 */
	public Integer getAnnoCostruzione()
	{
		return annoCostruzione;
	}

	/**
	 * Method 'setAnnoCostruzione'
	 * 
	 * @param annoCostruzione
	 */
	public void setAnnoCostruzione(Integer annoCostruzione)
	{
		this.annoCostruzione = annoCostruzione;
	}

	/**
	 * Method 'getAnnoUltRist'
	 * 
	 * @return Integer
	 */
	public Integer getAnnoUltRist()
	{
		return annoUltRist;
	}

	/**
	 * Method 'setAnnoUltRist'
	 * 
	 * @param annoUltRist
	 */
	public void setAnnoUltRist(Integer annoUltRist)
	{
		this.annoUltRist = annoUltRist;
	}

	/**
	 * Method 'getVolLordoRiscaldato'
	 * 
	 * @return Double
	 */
	public Double getVolLordoRiscaldato()
	{
		return volLordoRiscaldato;
	}

	/**
	 * Method 'setVolLordoRiscaldato'
	 * 
	 * @param volLordoRiscaldato
	 */
	public void setVolLordoRiscaldato(Double volLordoRiscaldato)
	{
		this.volLordoRiscaldato = volLordoRiscaldato;
	}

	/**
	 * Method 'getSupDisperdenteTot'
	 * 
	 * @return Double
	 */
	public Double getSupDisperdenteTot()
	{
		return supDisperdenteTot;
	}

	/**
	 * Method 'setSupDisperdenteTot'
	 * 
	 * @param supDisperdenteTot
	 */
	public void setSupDisperdenteTot(Double supDisperdenteTot)
	{
		this.supDisperdenteTot = supDisperdenteTot;
	}

	/**
	 * Method 'getFattoreForma'
	 * 
	 * @return Double
	 */
	public Double getFattoreForma()
	{
		return fattoreForma;
	}

	/**
	 * Method 'setFattoreForma'
	 * 
	 * @param fattoreForma
	 */
	public void setFattoreForma(Double fattoreForma)
	{
		this.fattoreForma = fattoreForma;
	}

	/**
	 * Method 'getTrasmOpache'
	 * 
	 * @return Double
	 */
	public Double getTrasmOpache()
	{
		return trasmOpache;
	}

	/**
	 * Method 'setTrasmOpache'
	 * 
	 * @param trasmOpache
	 */
	public void setTrasmOpache(Double trasmOpache)
	{
		this.trasmOpache = trasmOpache;
	}

	/**
	 * Method 'getTrasmTrasp'
	 * 
	 * @return Double
	 */
	public Double getTrasmTrasp()
	{
		return trasmTrasp;
	}

	/**
	 * Method 'setTrasmTrasp'
	 * 
	 * @param trasmTrasp
	 */
	public void setTrasmTrasp(Double trasmTrasp)
	{
		this.trasmTrasp = trasmTrasp;
	}

	/**
	 * Method 'getZonaClimatica'
	 * 
	 * @return String
	 */
	public String getZonaClimatica()
	{
		return zonaClimatica;
	}

	/**
	 * Method 'setZonaClimatica'
	 * 
	 * @param zonaClimatica
	 */
	public void setZonaClimatica(String zonaClimatica)
	{
		this.zonaClimatica = zonaClimatica;
	}

	/**
	 * Method 'getGradiGiorno'
	 * 
	 * @return Integer
	 */
	public Integer getGradiGiorno()
	{
		return gradiGiorno;
	}

	/**
	 * Method 'setGradiGiorno'
	 * 
	 * @param gradiGiorno
	 */
	public void setGradiGiorno(Integer gradiGiorno)
	{
		this.gradiGiorno = gradiGiorno;
	}

	/**
	 * Method 'getSu'
	 * 
	 * @return Double
	 */
	public Double getSu()
	{
		return su;
	}

	/**
	 * Method 'setSu'
	 * 
	 * @param su
	 */
	public void setSu(Double su)
	{
		this.su = su;
	}

	/**
	 * Method 'getEmissioniSerra'
	 * 
	 * @return Double
	 */
	public Double getEmissioniSerra()
	{
		return emissioniSerra;
	}

	/**
	 * Method 'setEmissioniSerra'
	 * 
	 * @param emissioniSerra
	 */
	public void setEmissioniSerra(Double emissioniSerra)
	{
		this.emissioniSerra = emissioniSerra;
	}

	/**
	 * Method 'getEttariBosco'
	 * 
	 * @return Double
	 */
	public Double getEttariBosco()
	{
		return ettariBosco;
	}

	/**
	 * Method 'setEttariBosco'
	 * 
	 * @param ettariBosco
	 */
	public void setEttariBosco(Double ettariBosco)
	{
		this.ettariBosco = ettariBosco;
	}

	/**
	 * Method 'getFlagUsoPubblico'
	 * 
	 * @return String
	 */
	public String getFlagUsoPubblico()
	{
		return flagUsoPubblico;
	}

	/**
	 * Method 'setFlagUsoPubblico'
	 * 
	 * @param flagUsoPubblico
	 */
	public void setFlagUsoPubblico(String flagUsoPubblico)
	{
		this.flagUsoPubblico = flagUsoPubblico;
	}

	/**
	 * Method 'getFkCarattEdificio'
	 * 
	 * @return Integer
	 */
	public Integer getFkCarattEdificio()
	{
		return fkCarattEdificio;
	}

	/**
	 * Method 'setFkCarattEdificio'
	 * 
	 * @param fkCarattEdificio
	 */
	public void setFkCarattEdificio(Integer fkCarattEdificio)
	{
		this.fkCarattEdificio = fkCarattEdificio;
	}

	/**
	 * Method 'getNrUm'
	 * 
	 * @return Integer
	 */
	public Integer getNrUm()
	{
		return nrUm;
	}

	/**
	 * Method 'setNrUm'
	 * 
	 * @param nrUm
	 */
	public void setNrUm(Integer nrUm)
	{
		this.nrUm = nrUm;
	}

	/**
	 * Method 'getSupRiscaldata'
	 * 
	 * @return Double
	 */
	public Double getSupRiscaldata()
	{
		return supRiscaldata;
	}

	/**
	 * Method 'setSupRiscaldata'
	 * 
	 * @param supRiscaldata
	 */
	public void setSupRiscaldata(Double supRiscaldata)
	{
		this.supRiscaldata = supRiscaldata;
	}

	/**
	 * Method 'getSupRaffrescata'
	 * 
	 * @return Double
	 */
	public Double getSupRaffrescata()
	{
		return supRaffrescata;
	}

	/**
	 * Method 'setSupRaffrescata'
	 * 
	 * @param supRaffrescata
	 */
	public void setSupRaffrescata(Double supRaffrescata)
	{
		this.supRaffrescata = supRaffrescata;
	}

	/**
	 * Method 'getSupDisperdente'
	 * 
	 * @return Double
	 */
	public Double getSupDisperdente()
	{
		return supDisperdente;
	}

	/**
	 * Method 'setSupDisperdente'
	 * 
	 * @param supDisperdente
	 */
	public void setSupDisperdente(Double supDisperdente)
	{
		this.supDisperdente = supDisperdente;
	}

	/**
	 * Method 'getVolLordoRaffrescato'
	 * 
	 * @return Double
	 */
	public Double getVolLordoRaffrescato()
	{
		return volLordoRaffrescato;
	}

	/**
	 * Method 'setVolLordoRaffrescato'
	 * 
	 * @param volLordoRaffrescato
	 */
	public void setVolLordoRaffrescato(Double volLordoRaffrescato)
	{
		this.volLordoRaffrescato = volLordoRaffrescato;
	}

	/**
	 * Method 'getFkOggettoApe'
	 * 
	 * @return long
	 */
	public Integer getFkOggettoApe()
	{
		return fkOggettoApe;
	}

	/**
	 * Method 'setFkOggettoApe'
	 * 
	 * @param fkOggettoApe
	 */
	public void setFkOggettoApe(Integer fkOggettoApe)
	{
		this.fkOggettoApe = fkOggettoApe;
		this.fkOggettoApeNull = false;
	}

	/**
	 * Method 'setFkOggettoApeNull'
	 * 
	 * @param value
	 */
	public void setFkOggettoApeNull(boolean value)
	{
		this.fkOggettoApeNull = value;
	}

	/**
	 * Method 'isFkOggettoApeNull'
	 * 
	 * @return boolean
	 */
	public boolean isFkOggettoApeNull()
	{
		return fkOggettoApeNull;
	}

	/**
	 * Method 'getFkDestUso2015'
	 * 
	 * @return Integer
	 */
	public Integer getFkDestUso2015()
	{
		return fkDestUso2015;
	}

	/**
	 * Method 'setFkDestUso2015'
	 * 
	 * @param fkDestUso2015
	 */
	public void setFkDestUso2015(Integer fkDestUso2015)
	{
		this.fkDestUso2015 = fkDestUso2015;
	}

	/**
	 * Method 'getFkTipoRistrutturaz'
	 * 
	 * @return Integer
	 */
	public Integer getFkTipoRistrutturaz()
	{
		return fkTipoRistrutturaz;
	}

	/**
	 * Method 'setFkTipoRistrutturaz'
	 * 
	 * @param fkTipoRistrutturaz
	 */
	public void setFkTipoRistrutturaz(Integer fkTipoRistrutturaz)
	{
		this.fkTipoRistrutturaz = fkTipoRistrutturaz;
	}

	/**
	 * Method 'getFkTipolEdilizia'
	 * 
	 * @return Integer
	 */
	public Integer getFkTipolEdilizia()
	{
		return fkTipolEdilizia;
	}

	/**
	 * Method 'setFkTipolEdilizia'
	 * 
	 * @param fkTipolEdilizia
	 */
	public void setFkTipolEdilizia(Integer fkTipolEdilizia)
	{
		this.fkTipolEdilizia = fkTipolEdilizia;
	}

	/**
	 * Method 'getFkTipolCostruttiva'
	 * 
	 * @return Integer
	 */
	public Integer getFkTipolCostruttiva()
	{
		return fkTipolCostruttiva;
	}

	/**
	 * Method 'setFkTipolCostruttiva'
	 * 
	 * @param fkTipolCostruttiva
	 */
	public void setFkTipolCostruttiva(Integer fkTipolCostruttiva)
	{
		this.fkTipolCostruttiva = fkTipolCostruttiva;
	}

	/**
	 * Method 'getFkProprietaEdi'
	 * 
	 * @return Integer
	 */
	public Integer getFkProprietaEdi()
	{
		return fkProprietaEdi;
	}

	/**
	 * Method 'setFkProprietaEdi'
	 * 
	 * @param fkProprietaEdi
	 */
	public void setFkProprietaEdi(Integer fkProprietaEdi)
	{
		this.fkProprietaEdi = fkProprietaEdi;
	}

	
	
	
	/**
	 * Method 'getCodiceEdificioScolastico'
	 * 
	 * @return String
	 */
	public String getCodiceEdificioScolastico()
	{
		return codiceEdificioScolastico;
	}

	/**
	 * Method 'setCodiceEdificioScolastico'
	 * 
	 * @param codiceEdificioScolastico
	 */
	public void setCodiceEdificioScolastico(String codiceEdificioScolastico)
	{
		this.codiceEdificioScolastico = codiceEdificioScolastico;
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
		
		if (!(_other instanceof SiceeTDatiGenerali)) {
			return false;
		}
		
		final SiceeTDatiGenerali _cast = (SiceeTDatiGenerali) _other;
		if (idCertificatore == null ? _cast.idCertificatore != idCertificatore : !idCertificatore.equals( _cast.idCertificatore )) {
			return false;
		}
		
		if (progrCertificato == null ? _cast.progrCertificato != progrCertificato : !progrCertificato.equals( _cast.progrCertificato )) {
			return false;
		}
		
		if (anno == null ? _cast.anno != anno : !anno.equals( _cast.anno )) {
			return false;
		}
		
		if (descTipoEdificio == null ? _cast.descTipoEdificio != descTipoEdificio : !descTipoEdificio.equals( _cast.descTipoEdificio )) {
			return false;
		}
		
		if (fkDestUso == null ? _cast.fkDestUso != fkDestUso : !fkDestUso.equals( _cast.fkDestUso )) {
			return false;
		}
		
		if (annoCostruzione == null ? _cast.annoCostruzione != annoCostruzione : !annoCostruzione.equals( _cast.annoCostruzione )) {
			return false;
		}
		
		if (annoUltRist == null ? _cast.annoUltRist != annoUltRist : !annoUltRist.equals( _cast.annoUltRist )) {
			return false;
		}
		
		if (volLordoRiscaldato == null ? _cast.volLordoRiscaldato != volLordoRiscaldato : !volLordoRiscaldato.equals( _cast.volLordoRiscaldato )) {
			return false;
		}
		
		if (supDisperdenteTot == null ? _cast.supDisperdenteTot != supDisperdenteTot : !supDisperdenteTot.equals( _cast.supDisperdenteTot )) {
			return false;
		}
		
		if (fattoreForma == null ? _cast.fattoreForma != fattoreForma : !fattoreForma.equals( _cast.fattoreForma )) {
			return false;
		}
		
		if (trasmOpache == null ? _cast.trasmOpache != trasmOpache : !trasmOpache.equals( _cast.trasmOpache )) {
			return false;
		}
		
		if (trasmTrasp == null ? _cast.trasmTrasp != trasmTrasp : !trasmTrasp.equals( _cast.trasmTrasp )) {
			return false;
		}
		
		if (zonaClimatica == null ? _cast.zonaClimatica != zonaClimatica : !zonaClimatica.equals( _cast.zonaClimatica )) {
			return false;
		}
		
		if (gradiGiorno == null ? _cast.gradiGiorno != gradiGiorno : !gradiGiorno.equals( _cast.gradiGiorno )) {
			return false;
		}
		
		if (su == null ? _cast.su != su : !su.equals( _cast.su )) {
			return false;
		}
		
		if (emissioniSerra == null ? _cast.emissioniSerra != emissioniSerra : !emissioniSerra.equals( _cast.emissioniSerra )) {
			return false;
		}
		
		if (ettariBosco == null ? _cast.ettariBosco != ettariBosco : !ettariBosco.equals( _cast.ettariBosco )) {
			return false;
		}
		
		if (flagUsoPubblico == null ? _cast.flagUsoPubblico != flagUsoPubblico : !flagUsoPubblico.equals( _cast.flagUsoPubblico )) {
			return false;
		}
		
		if (fkCarattEdificio == null ? _cast.fkCarattEdificio != fkCarattEdificio : !fkCarattEdificio.equals( _cast.fkCarattEdificio )) {
			return false;
		}
		
		if (nrUm == null ? _cast.nrUm != nrUm : !nrUm.equals( _cast.nrUm )) {
			return false;
		}
		
		if (supRiscaldata == null ? _cast.supRiscaldata != supRiscaldata : !supRiscaldata.equals( _cast.supRiscaldata )) {
			return false;
		}
		
		if (supRaffrescata == null ? _cast.supRaffrescata != supRaffrescata : !supRaffrescata.equals( _cast.supRaffrescata )) {
			return false;
		}
		
		if (supDisperdente == null ? _cast.supDisperdente != supDisperdente : !supDisperdente.equals( _cast.supDisperdente )) {
			return false;
		}
		
		if (volLordoRaffrescato == null ? _cast.volLordoRaffrescato != volLordoRaffrescato : !volLordoRaffrescato.equals( _cast.volLordoRaffrescato )) {
			return false;
		}
		
		if (fkOggettoApe != _cast.fkOggettoApe) {
			return false;
		}
		
		if (fkOggettoApeNull != _cast.fkOggettoApeNull) {
			return false;
		}
		
		if (fkDestUso2015 == null ? _cast.fkDestUso2015 != fkDestUso2015 : !fkDestUso2015.equals( _cast.fkDestUso2015 )) {
			return false;
		}

		if (fkTipoRistrutturaz == null ? _cast.fkTipoRistrutturaz != fkTipoRistrutturaz : !fkTipoRistrutturaz.equals( _cast.fkTipoRistrutturaz )) {
			return false;
		}

		if (fkTipolEdilizia == null ? _cast.fkTipolEdilizia != fkTipolEdilizia : !fkTipolEdilizia.equals( _cast.fkTipolEdilizia )) {
			return false;
		}

		if (fkTipolCostruttiva == null ? _cast.fkTipolCostruttiva != fkTipolCostruttiva : !fkTipolCostruttiva.equals( _cast.fkTipolCostruttiva )) {
			return false;
		}

		if (fkProprietaEdi == null ? _cast.fkProprietaEdi != fkProprietaEdi : !fkProprietaEdi.equals( _cast.fkProprietaEdi )) {
			return false;
		}
		
		if (codiceEdificioScolastico == null ? _cast.codiceEdificioScolastico != codiceEdificioScolastico : !codiceEdificioScolastico.equals( _cast.codiceEdificioScolastico )) {
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
		
		if (descTipoEdificio != null) {
			_hashCode = 29 * _hashCode + descTipoEdificio.hashCode();
		}
		
		if (fkDestUso != null) {
			_hashCode = 29 * _hashCode + fkDestUso.hashCode();
		}
		
		if (annoCostruzione != null) {
			_hashCode = 29 * _hashCode + annoCostruzione.hashCode();
		}
		
		if (annoUltRist != null) {
			_hashCode = 29 * _hashCode + annoUltRist.hashCode();
		}
		
		if (volLordoRiscaldato != null) {
			_hashCode = 29 * _hashCode + volLordoRiscaldato.hashCode();
		}
		
		if (supDisperdenteTot != null) {
			_hashCode = 29 * _hashCode + supDisperdenteTot.hashCode();
		}
		
		if (fattoreForma != null) {
			_hashCode = 29 * _hashCode + fattoreForma.hashCode();
		}
		
		if (trasmOpache != null) {
			_hashCode = 29 * _hashCode + trasmOpache.hashCode();
		}
		
		if (trasmTrasp != null) {
			_hashCode = 29 * _hashCode + trasmTrasp.hashCode();
		}
		
		if (zonaClimatica != null) {
			_hashCode = 29 * _hashCode + zonaClimatica.hashCode();
		}
		
		if (gradiGiorno != null) {
			_hashCode = 29 * _hashCode + gradiGiorno.hashCode();
		}
		
		if (su != null) {
			_hashCode = 29 * _hashCode + su.hashCode();
		}
		
		if (emissioniSerra != null) {
			_hashCode = 29 * _hashCode + emissioniSerra.hashCode();
		}
		
		if (ettariBosco != null) {
			_hashCode = 29 * _hashCode + ettariBosco.hashCode();
		}
		
		if (flagUsoPubblico != null) {
			_hashCode = 29 * _hashCode + flagUsoPubblico.hashCode();
		}
		
		if (fkCarattEdificio != null) {
			_hashCode = 29 * _hashCode + fkCarattEdificio.hashCode();
		}
		
		if (nrUm != null) {
			_hashCode = 29 * _hashCode + nrUm.hashCode();
		}
		
		if (supRiscaldata != null) {
			_hashCode = 29 * _hashCode + supRiscaldata.hashCode();
		}
		
		if (supRaffrescata != null) {
			_hashCode = 29 * _hashCode + supRaffrescata.hashCode();
		}
		
		if (supDisperdente != null) {
			_hashCode = 29 * _hashCode + supDisperdente.hashCode();
		}
		
		if (volLordoRaffrescato != null) {
			_hashCode = 29 * _hashCode + volLordoRaffrescato.hashCode();
		}
		
		_hashCode = 29 * _hashCode + (int) (fkOggettoApe ^ (fkOggettoApe >>> 32));
		_hashCode = 29 * _hashCode + (fkOggettoApeNull ? 1 : 0);

		if (fkDestUso2015 != null) {
			_hashCode = 29 * _hashCode + fkDestUso2015.hashCode();
		}

		if (fkTipoRistrutturaz != null) {
			_hashCode = 29 * _hashCode + fkTipoRistrutturaz.hashCode();
		}

		if (fkTipolEdilizia != null) {
			_hashCode = 29 * _hashCode + fkTipolEdilizia.hashCode();
		}

		if (fkTipolCostruttiva != null) {
			_hashCode = 29 * _hashCode + fkTipolCostruttiva.hashCode();
		}

		if (fkProprietaEdi != null) {
			_hashCode = 29 * _hashCode + fkProprietaEdi.hashCode();
		}
		
		if (codiceEdificioScolastico != null) {
			_hashCode = 29 * _hashCode + codiceEdificioScolastico.hashCode();
		}
		
		return _hashCode;
	}

	/**
	 * Method 'createPk'
	 * 
	 * @return SiceeTDatiGeneraliPk
	 */
	public SiceeTDatiGeneraliPk createPk()
	{
		return new SiceeTDatiGeneraliPk(idCertificatore, progrCertificato, anno);
	}

	/**
	 * Method 'toString'
	 * 
	 * @return String
	 */
	public String toString()
	{
		StringBuffer ret = new StringBuffer();
		ret.append( "it.csi.sicee.siceeweb.business.dao.dto.SiceeTDatiGenerali: " );
		ret.append( "idCertificatore=" + idCertificatore );
		ret.append( ", progrCertificato=" + progrCertificato );
		ret.append( ", anno=" + anno );
		ret.append( ", descTipoEdificio=" + descTipoEdificio );
		ret.append( ", fkDestUso=" + fkDestUso );
		ret.append( ", annoCostruzione=" + annoCostruzione );
		ret.append( ", annoUltRist=" + annoUltRist );
		ret.append( ", volLordoRiscaldato=" + volLordoRiscaldato );
		ret.append( ", supDisperdenteTot=" + supDisperdenteTot );
		ret.append( ", fattoreForma=" + fattoreForma );
		ret.append( ", trasmOpache=" + trasmOpache );
		ret.append( ", trasmTrasp=" + trasmTrasp );
		ret.append( ", zonaClimatica=" + zonaClimatica );
		ret.append( ", gradiGiorno=" + gradiGiorno );
		ret.append( ", su=" + su );
		ret.append( ", emissioniSerra=" + emissioniSerra );
		ret.append( ", ettariBosco=" + ettariBosco );
		ret.append( ", flagUsoPubblico=" + flagUsoPubblico );
		ret.append( ", fkCarattEdificio=" + fkCarattEdificio );
		ret.append( ", nrUm=" + nrUm );
		ret.append( ", supRiscaldata=" + supRiscaldata );
		ret.append( ", supRaffrescata=" + supRaffrescata );
		ret.append( ", supDisperdente=" + supDisperdente );
		ret.append( ", volLordoRaffrescato=" + volLordoRaffrescato );
		ret.append( ", fkOggettoApe=" + fkOggettoApe );
		ret.append( ", fkDestUso2015=" + fkDestUso2015 );
		ret.append( ", fkTipoRistrutturaz=" + fkTipoRistrutturaz );
		ret.append( ", fkTipolEdilizia=" + fkTipolEdilizia );
		ret.append( ", fkTipolCostruttiva=" + fkTipolCostruttiva );
		ret.append( ", fkProprietaEdi=" + fkProprietaEdi );
		ret.append( ", codiceEdificioScolastico=" + codiceEdificioScolastico );
		
		return ret.toString();
	}

}
