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

public class SiceeTExportBo implements Serializable
{
	/** 
	 * This attribute maps to the column ID_CERTIFICATORE in the SICEE_T_EXPORT_BO table.
	 */
	protected String idCertificatore;

	/** 
	 * This attribute maps to the column PROGR_CERTIFICATO in the SICEE_T_EXPORT_BO table.
	 */
	protected String progrCertificato;

	/** 
	 * This attribute maps to the column ANNO in the SICEE_T_EXPORT_BO table.
	 */
	protected String anno;

	/** 
	 * This attribute maps to the column DT_INIZIO in the SICEE_T_EXPORT_BO table.
	 */
	protected Date dtInizio;

	/** 
	 * This attribute maps to the column DT_UPLOAD in the SICEE_T_EXPORT_BO table.
	 */
	protected Date dtUpload;

	/** 
	 * This attribute maps to the column DT_SCADENZA in the SICEE_T_EXPORT_BO table.
	 */
	protected Date dtScadenza;

	/** 
	 * This attribute maps to the column DESC_PROV in the SICEE_T_EXPORT_BO table.
	 */
	protected String descProv;

	/** 
	 * This attribute maps to the column DESC_COMUNE in the SICEE_T_EXPORT_BO table.
	 */
	protected String descComune;

	/** 
	 * This attribute maps to the column GRADI_GIORNO in the SICEE_T_EXPORT_BO table.
	 */
	protected Integer gradiGiorno;

	/** 
	 * This attribute maps to the column PIANO in the SICEE_T_EXPORT_BO table.
	 */
	protected Integer piano;

	/** 
	 * This attribute maps to the column NUM_PIANI_COMPLESSIVI in the SICEE_T_EXPORT_BO table.
	 */
	protected Integer numPianiComplessivi;

	/** 
	 * This attribute maps to the column FK_STATO in the SICEE_T_EXPORT_BO table.
	 */
	protected Integer fkStato;

	/** 
	 * This attribute maps to the column FK_DEST_USO in the SICEE_T_EXPORT_BO table.
	 */
	protected Integer fkDestUso;

	/** 
	 * This attribute maps to the column DESC_TIPO_EDIFICIO in the SICEE_T_EXPORT_BO table.
	 */
	protected String descTipoEdificio;

	/** 
	 * This attribute maps to the column FK_CLASSE in the SICEE_T_EXPORT_BO table.
	 */
	protected Integer fkClasse;

	/** 
	 * This attribute maps to the column ANNO_COSTRUZIONE in the SICEE_T_EXPORT_BO table.
	 */
	protected Integer annoCostruzione;

	/** 
	 * This attribute maps to the column ANNO_ULT_RIST in the SICEE_T_EXPORT_BO table.
	 */
	protected Integer annoUltRist;

	/** 
	 * This attribute maps to the column VOL_LORDO_RISCALDATO in the SICEE_T_EXPORT_BO table.
	 */
	protected Double volLordoRiscaldato;

	/** 
	 * This attribute maps to the column SUP_DISPERDENTE_TOT in the SICEE_T_EXPORT_BO table.
	 */
	protected Double supDisperdenteTot;

	/** 
	 * This attribute maps to the column SU in the SICEE_T_EXPORT_BO table.
	 */
	protected Double su;

	/** 
	 * This attribute maps to the column TRASM_OPACHE in the SICEE_T_EXPORT_BO table.
	 */
	protected Double trasmOpache;

	/** 
	 * This attribute maps to the column TRASM_TRASP in the SICEE_T_EXPORT_BO table.
	 */
	protected Double trasmTrasp;

	/** 
	 * This attribute maps to the column FATTORE_FORMA in the SICEE_T_EXPORT_BO table.
	 */
	protected Double fattoreForma;

	/** 
	 * This attribute maps to the column V_SU in the SICEE_T_EXPORT_BO table.
	 */
	protected Double vSu;

	/** 
	 * This attribute maps to the column IND_RISC_EPITO in the SICEE_T_EXPORT_BO table.
	 */
	protected Double indRiscEpito;

	/** 
	 * This attribute maps to the column FLG_FABB_MAX_INDICE in the SICEE_T_EXPORT_BO table.
	 */
	protected String flgFabbMaxIndice;

	/** 
	 * This attribute maps to the column VALORE_PREST_PDC in the SICEE_T_EXPORT_BO table.
	 */
	protected Double valorePrestPdc;

	/** 
	 * This attribute maps to the column REND_ACS_ETAGACS in the SICEE_T_EXPORT_BO table.
	 */
	protected Double rendAcsEtagacs;

	/** 
	 * This attribute maps to the column DOM_ACS_QHW in the SICEE_T_EXPORT_BO table.
	 */
	protected Double domAcsQhw;

	/** 
	 * This attribute maps to the column EN_ACS_RINNO in the SICEE_T_EXPORT_BO table.
	 */
	protected Double enAcsRinno;

	/** 
	 * This attribute maps to the column REND_IMP_ETAG in the SICEE_T_EXPORT_BO table.
	 */
	protected Double rendImpEtag;

	/** 
	 * This attribute maps to the column DOM_ACS_QHW_SU in the SICEE_T_EXPORT_BO table.
	 */
	protected Double domAcsQhwSu;

	/** 
	 * This attribute maps to the column IND_GLOB_EPLORDO in the SICEE_T_EXPORT_BO table.
	 */
	protected Double indGlobEplordo;

	/** 
	 * This attribute maps to the column DOM_ACS_QHWTO in the SICEE_T_EXPORT_BO table.
	 */
	protected Double domAcsQhwto;

	/** 
	 * This attribute maps to the column FLG_FABB_ACS in the SICEE_T_EXPORT_BO table.
	 */
	protected String flgFabbAcs;

	/** 
	 * This attribute maps to the column FK_MOTIVO in the SICEE_T_EXPORT_BO table.
	 */
	protected Integer fkMotivo;

	/** 
	 * This attribute maps to the column METODOLOGIA_CALCOLO in the SICEE_T_EXPORT_BO table.
	 */
	protected String metodologiaCalcolo;

	/** 
	 * This attribute maps to the column SW_UTILIZZATO in the SICEE_T_EXPORT_BO table.
	 */
	protected String swUtilizzato;

	/** 
	 * This attribute maps to the column DESC_INDIRIZZO in the SICEE_T_EXPORT_BO table.
	 */
	protected String descIndirizzo;

	/** 
	 * This attribute maps to the column NUM_CIVICO in the SICEE_T_EXPORT_BO table.
	 */
	protected String numCivico;

	/** 
	 * This attribute maps to the column SEZIONE in the SICEE_T_EXPORT_BO table.
	 */
	protected String sezione;

	/** 
	 * This attribute maps to the column FOGLIO in the SICEE_T_EXPORT_BO table.
	 */
	protected String foglio;

	/** 
	 * This attribute maps to the column PARTICELLA in the SICEE_T_EXPORT_BO table.
	 */
	protected String particella;

	/** 
	 * This attribute maps to the column SUBALTERNO in the SICEE_T_EXPORT_BO table.
	 */
	protected String subalterno;

	/** 
	 * This attribute maps to the column ID_PROV in the SICEE_T_EXPORT_BO table.
	 */
	protected String idProv;

	/** 
	 * This attribute maps to the column ID_COMUNE in the SICEE_T_EXPORT_BO table.
	 */
	protected String idComune;

	/** 
	 * This attribute maps to the column FK_TIPO_IMPIANTO in the SICEE_T_EXPORT_BO table.
	 */
	protected Integer fkTipoImpianto;

	/** 
	 * This attribute maps to the column FK_COMBUSTIBILE_RISC in the SICEE_T_EXPORT_BO table.
	 */
	protected Integer fkCombustibileRisc;

	/** 
	 * This attribute maps to the column FK_COMBUSTIBILE_ACS in the SICEE_T_EXPORT_BO table.
	 */
	protected Integer fkCombustibileAcs;

	/** 
	 * This attribute maps to the column FK_CLASSE_192_05 in the SICEE_T_EXPORT_BO table.
	 */
	protected Integer fkClasse19205;

	/** 
	 * This attribute maps to the column DOM_RISC_QH in the SICEE_T_EXPORT_BO table.
	 */
	protected Double domRiscQh;

	/** 
	 * This attribute maps to the column IND_RISC_EPI in the SICEE_T_EXPORT_BO table.
	 */
	protected Double indRiscEpi;

	/** 
	 * This attribute maps to the column FABB_ACS in the SICEE_T_EXPORT_BO table.
	 */
	protected Double fabbAcs;

	/** 
	 * This attribute maps to the column IND_GLOB_EPLORDO_TO in the SICEE_T_EXPORT_BO table.
	 */
	protected Double indGlobEplordoTo;

	/** 
	 * This attribute maps to the column PRESTAZIONE_ENE in the SICEE_T_EXPORT_BO table.
	 */
	protected Double prestazioneEne;

	/** 
	 * This attribute maps to the column NUM_APPARTAMENTI in the SICEE_T_EXPORT_BO table.
	 */
	protected Integer numAppartamenti;

	/** 
	 * This attribute maps to the column UI_SERVITE in the SICEE_T_EXPORT_BO table.
	 */
	protected String uiServite;

	/** 
	 * This attribute maps to the column POT_RISCALDAMENTO in the SICEE_T_EXPORT_BO table.
	 */
	protected Double potRiscaldamento;

	/** 
	 * This attribute maps to the column FK_CLASSE_EFF_RISC in the SICEE_T_EXPORT_BO table.
	 */
	protected Integer fkClasseEffRisc;

	/** 
	 * This attribute maps to the column GEN_ANNO_RISC in the SICEE_T_EXPORT_BO table.
	 */
	protected Integer genAnnoRisc;

	/** 
	 * This attribute maps to the column FLG_CONT_RIP in the SICEE_T_EXPORT_BO table.
	 */
	protected String flgContRip;

	/** 
	 * This attribute maps to the column REND_GENER in the SICEE_T_EXPORT_BO table.
	 */
	protected Double rendGener;

	/** 
	 * This attribute maps to the column REND_REGOL in the SICEE_T_EXPORT_BO table.
	 */
	protected Double rendRegol;

	/** 
	 * This attribute maps to the column REND_EMISS in the SICEE_T_EXPORT_BO table.
	 */
	protected Double rendEmiss;

	/** 
	 * This attribute maps to the column REND_DISTRIB in the SICEE_T_EXPORT_BO table.
	 */
	protected Double rendDistrib;

	/** 
	 * This attribute maps to the column DOM_RISC_QHTO in the SICEE_T_EXPORT_BO table.
	 */
	protected Double domRiscQhto;

	/** 
	 * This attribute maps to the column FK_CARATT_EDIFICIO in the SICEE_T_EXPORT_BO table.
	 */
	protected Integer fkCarattEdificio;

	/** 
	 * This attribute maps to the column FLG_OLD in the SICEE_T_EXPORT_BO table.
	 */
	protected String flgOld;

	/** 
	 * This attribute maps to the column FLG_EDIF_E0 in the SICEE_T_EXPORT_BO table.
	 */
	protected String flgEdifE0;

	/** 
	 * This attribute maps to the column EPGL_NREN_GLOBALE in the SICEE_T_EXPORT_BO table.
	 */
	protected Double epglNrenGlobale;

	/** 
	 * This attribute maps to the column EPGL_REN_GLOBALE in the SICEE_T_EXPORT_BO table.
	 */
	protected Double epglRenGlobale;

	/** 
	 * This attribute maps to the column EMISSIONI_CO2 in the SICEE_T_EXPORT_BO table.
	 */
	protected Double emissioniCo2;

	/** 
	 * This attribute maps to the column SUP_RAFFRESCATA in the SICEE_T_EXPORT_BO table.
	 */
	protected Double supRaffrescata;

	/** 
	 * This attribute maps to the column SUP_RISCALDATA in the SICEE_T_EXPORT_BO table.
	 */
	protected Double supRiscaldata;

	/** 
	 * This attribute maps to the column VOL_LORDO_RAFFRESCATO in the SICEE_T_EXPORT_BO table.
	 */
	protected Double volLordoRaffrescato;

	/** 
	 * This attribute maps to the column EPH in the SICEE_T_EXPORT_BO table.
	 */
	protected Double eph;

	/** 
	 * This attribute maps to the column ASOL_ASUP in the SICEE_T_EXPORT_BO table.
	 */
	protected Double asolAsup;

	/** 
	 * This attribute maps to the column YIE in the SICEE_T_EXPORT_BO table.
	 */
	protected Double yie;

	/** 
	 * This attribute maps to the column V_SU_RAFF in the SICEE_T_EXPORT_BO table.
	 */
	protected Double vSuRaff;

	/** 
	 * This attribute maps to the column V_SU_RISC in the SICEE_T_EXPORT_BO table.
	 */
	protected Double vSuRisc;

	/** 
	 * This attribute maps to the column S_V_RAFF in the SICEE_T_EXPORT_BO table.
	 */
	protected Double sVRaff;

	/** 
	 * This attribute maps to the column S_V_RISC in the SICEE_T_EXPORT_BO table.
	 */
	protected Double sVRisc;

	/**
	 * Method 'SiceeTExportBo'
	 * 
	 */
	public SiceeTExportBo()
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
	 * Method 'getDtInizio'
	 * 
	 * @return Date
	 */
	public Date getDtInizio()
	{
		return dtInizio;
	}

	/**
	 * Method 'setDtInizio'
	 * 
	 * @param dtInizio
	 */
	public void setDtInizio(Date dtInizio)
	{
		this.dtInizio = dtInizio;
	}

	/**
	 * Method 'getDtUpload'
	 * 
	 * @return Date
	 */
	public Date getDtUpload()
	{
		return dtUpload;
	}

	/**
	 * Method 'setDtUpload'
	 * 
	 * @param dtUpload
	 */
	public void setDtUpload(Date dtUpload)
	{
		this.dtUpload = dtUpload;
	}
	
	/**
	 * Method 'getDtScadenza'
	 * 
	 * @return Date
	 */
	public Date getDtScadenza()
	{
		return dtScadenza;
	}

	/**
	 * Method 'setDtScadenza'
	 * 
	 * @param dtScadenza
	 */
	public void setDtScadenza(Date dtScadenza)
	{
		this.dtScadenza = dtScadenza;
	}

	/**
	 * Method 'getDescProv'
	 * 
	 * @return String
	 */
	public String getDescProv()
	{
		return descProv;
	}

	/**
	 * Method 'setDescProv'
	 * 
	 * @param descProv
	 */
	public void setDescProv(String descProv)
	{
		this.descProv = descProv;
	}

	/**
	 * Method 'getDescComune'
	 * 
	 * @return String
	 */
	public String getDescComune()
	{
		return descComune;
	}

	/**
	 * Method 'setDescComune'
	 * 
	 * @param descComune
	 */
	public void setDescComune(String descComune)
	{
		this.descComune = descComune;
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
	 * Method 'getPiano'
	 * 
	 * @return Integer
	 */
	public Integer getPiano()
	{
		return piano;
	}

	/**
	 * Method 'setPiano'
	 * 
	 * @param piano
	 */
	public void setPiano(Integer piano)
	{
		this.piano = piano;
	}

	/**
	 * Method 'getNumPianiComplessivi'
	 * 
	 * @return Integer
	 */
	public Integer getNumPianiComplessivi()
	{
		return numPianiComplessivi;
	}

	/**
	 * Method 'setNumPianiComplessivi'
	 * 
	 * @param numPianiComplessivi
	 */
	public void setNumPianiComplessivi(Integer numPianiComplessivi)
	{
		this.numPianiComplessivi = numPianiComplessivi;
	}

	/**
	 * Method 'getFkStato'
	 * 
	 * @return Integer
	 */
	public Integer getFkStato()
	{
		return fkStato;
	}

	/**
	 * Method 'setFkStato'
	 * 
	 * @param fkStato
	 */
	public void setFkStato(Integer fkStato)
	{
		this.fkStato = fkStato;
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
	 * Method 'getFkClasse'
	 * 
	 * @return Integer
	 */
	public Integer getFkClasse()
	{
		return fkClasse;
	}

	/**
	 * Method 'setFkClasse'
	 * 
	 * @param fkClasse
	 */
	public void setFkClasse(Integer fkClasse)
	{
		this.fkClasse = fkClasse;
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
	 * Method 'getVSu'
	 * 
	 * @return Double
	 */
	public Double getVSu()
	{
		return vSu;
	}

	/**
	 * Method 'setVSu'
	 * 
	 * @param vSu
	 */
	public void setVSu(Double vSu)
	{
		this.vSu = vSu;
	}

	/**
	 * Method 'getIndRiscEpito'
	 * 
	 * @return Double
	 */
	public Double getIndRiscEpito()
	{
		return indRiscEpito;
	}

	/**
	 * Method 'setIndRiscEpito'
	 * 
	 * @param indRiscEpito
	 */
	public void setIndRiscEpito(Double indRiscEpito)
	{
		this.indRiscEpito = indRiscEpito;
	}

	/**
	 * Method 'getFlgFabbMaxIndice'
	 * 
	 * @return String
	 */
	public String getFlgFabbMaxIndice()
	{
		return flgFabbMaxIndice;
	}

	/**
	 * Method 'setFlgFabbMaxIndice'
	 * 
	 * @param flgFabbMaxIndice
	 */
	public void setFlgFabbMaxIndice(String flgFabbMaxIndice)
	{
		this.flgFabbMaxIndice = flgFabbMaxIndice;
	}

	/**
	 * Method 'getValorePrestPdc'
	 * 
	 * @return Double
	 */
	public Double getValorePrestPdc()
	{
		return valorePrestPdc;
	}

	/**
	 * Method 'setValorePrestPdc'
	 * 
	 * @param valorePrestPdc
	 */
	public void setValorePrestPdc(Double valorePrestPdc)
	{
		this.valorePrestPdc = valorePrestPdc;
	}

	/**
	 * Method 'getRendAcsEtagacs'
	 * 
	 * @return Double
	 */
	public Double getRendAcsEtagacs()
	{
		return rendAcsEtagacs;
	}

	/**
	 * Method 'setRendAcsEtagacs'
	 * 
	 * @param rendAcsEtagacs
	 */
	public void setRendAcsEtagacs(Double rendAcsEtagacs)
	{
		this.rendAcsEtagacs = rendAcsEtagacs;
	}

	/**
	 * Method 'getDomAcsQhw'
	 * 
	 * @return Double
	 */
	public Double getDomAcsQhw()
	{
		return domAcsQhw;
	}

	/**
	 * Method 'setDomAcsQhw'
	 * 
	 * @param domAcsQhw
	 */
	public void setDomAcsQhw(Double domAcsQhw)
	{
		this.domAcsQhw = domAcsQhw;
	}

	/**
	 * Method 'getEnAcsRinno'
	 * 
	 * @return Double
	 */
	public Double getEnAcsRinno()
	{
		return enAcsRinno;
	}

	/**
	 * Method 'setEnAcsRinno'
	 * 
	 * @param enAcsRinno
	 */
	public void setEnAcsRinno(Double enAcsRinno)
	{
		this.enAcsRinno = enAcsRinno;
	}

	/**
	 * Method 'getRendImpEtag'
	 * 
	 * @return Double
	 */
	public Double getRendImpEtag()
	{
		return rendImpEtag;
	}

	/**
	 * Method 'setRendImpEtag'
	 * 
	 * @param rendImpEtag
	 */
	public void setRendImpEtag(Double rendImpEtag)
	{
		this.rendImpEtag = rendImpEtag;
	}

	/**
	 * Method 'getDomAcsQhwSu'
	 * 
	 * @return Double
	 */
	public Double getDomAcsQhwSu()
	{
		return domAcsQhwSu;
	}

	/**
	 * Method 'setDomAcsQhwSu'
	 * 
	 * @param domAcsQhwSu
	 */
	public void setDomAcsQhwSu(Double domAcsQhwSu)
	{
		this.domAcsQhwSu = domAcsQhwSu;
	}

	/**
	 * Method 'getIndGlobEplordo'
	 * 
	 * @return Double
	 */
	public Double getIndGlobEplordo()
	{
		return indGlobEplordo;
	}

	/**
	 * Method 'setIndGlobEplordo'
	 * 
	 * @param indGlobEplordo
	 */
	public void setIndGlobEplordo(Double indGlobEplordo)
	{
		this.indGlobEplordo = indGlobEplordo;
	}

	/**
	 * Method 'getDomAcsQhwto'
	 * 
	 * @return Double
	 */
	public Double getDomAcsQhwto()
	{
		return domAcsQhwto;
	}

	/**
	 * Method 'setDomAcsQhwto'
	 * 
	 * @param domAcsQhwto
	 */
	public void setDomAcsQhwto(Double domAcsQhwto)
	{
		this.domAcsQhwto = domAcsQhwto;
	}

	/**
	 * Method 'getFlgFabbAcs'
	 * 
	 * @return String
	 */
	public String getFlgFabbAcs()
	{
		return flgFabbAcs;
	}

	/**
	 * Method 'setFlgFabbAcs'
	 * 
	 * @param flgFabbAcs
	 */
	public void setFlgFabbAcs(String flgFabbAcs)
	{
		this.flgFabbAcs = flgFabbAcs;
	}

	/**
	 * Method 'getFkMotivo'
	 * 
	 * @return Integer
	 */
	public Integer getFkMotivo()
	{
		return fkMotivo;
	}

	/**
	 * Method 'setFkMotivo'
	 * 
	 * @param fkMotivo
	 */
	public void setFkMotivo(Integer fkMotivo)
	{
		this.fkMotivo = fkMotivo;
	}

	/**
	 * Method 'getMetodologiaCalcolo'
	 * 
	 * @return String
	 */
	public String getMetodologiaCalcolo()
	{
		return metodologiaCalcolo;
	}

	/**
	 * Method 'setMetodologiaCalcolo'
	 * 
	 * @param metodologiaCalcolo
	 */
	public void setMetodologiaCalcolo(String metodologiaCalcolo)
	{
		this.metodologiaCalcolo = metodologiaCalcolo;
	}

	/**
	 * Method 'getSwUtilizzato'
	 * 
	 * @return String
	 */
	public String getSwUtilizzato()
	{
		return swUtilizzato;
	}

	/**
	 * Method 'setSwUtilizzato'
	 * 
	 * @param swUtilizzato
	 */
	public void setSwUtilizzato(String swUtilizzato)
	{
		this.swUtilizzato = swUtilizzato;
	}

	/**
	 * Method 'getDescIndirizzo'
	 * 
	 * @return String
	 */
	public String getDescIndirizzo()
	{
		return descIndirizzo;
	}

	/**
	 * Method 'setDescIndirizzo'
	 * 
	 * @param descIndirizzo
	 */
	public void setDescIndirizzo(String descIndirizzo)
	{
		this.descIndirizzo = descIndirizzo;
	}

	/**
	 * Method 'getNumCivico'
	 * 
	 * @return String
	 */
	public String getNumCivico()
	{
		return numCivico;
	}

	/**
	 * Method 'setNumCivico'
	 * 
	 * @param numCivico
	 */
	public void setNumCivico(String numCivico)
	{
		this.numCivico = numCivico;
	}

	/**
	 * Method 'getSezione'
	 * 
	 * @return String
	 */
	public String getSezione()
	{
		return sezione;
	}

	/**
	 * Method 'setSezione'
	 * 
	 * @param sezione
	 */
	public void setSezione(String sezione)
	{
		this.sezione = sezione;
	}

	/**
	 * Method 'getFoglio'
	 * 
	 * @return String
	 */
	public String getFoglio()
	{
		return foglio;
	}

	/**
	 * Method 'setFoglio'
	 * 
	 * @param foglio
	 */
	public void setFoglio(String foglio)
	{
		this.foglio = foglio;
	}

	/**
	 * Method 'getParticella'
	 * 
	 * @return String
	 */
	public String getParticella()
	{
		return particella;
	}

	/**
	 * Method 'setParticella'
	 * 
	 * @param particella
	 */
	public void setParticella(String particella)
	{
		this.particella = particella;
	}

	/**
	 * Method 'getSubalterno'
	 * 
	 * @return String
	 */
	public String getSubalterno()
	{
		return subalterno;
	}

	/**
	 * Method 'setSubalterno'
	 * 
	 * @param subalterno
	 */
	public void setSubalterno(String subalterno)
	{
		this.subalterno = subalterno;
	}

	/**
	 * Method 'getIdProv'
	 * 
	 * @return String
	 */
	public String getIdProv()
	{
		return idProv;
	}

	/**
	 * Method 'setIdProv'
	 * 
	 * @param idProv
	 */
	public void setIdProv(String idProv)
	{
		this.idProv = idProv;
	}

	/**
	 * Method 'getIdComune'
	 * 
	 * @return String
	 */
	public String getIdComune()
	{
		return idComune;
	}

	/**
	 * Method 'setIdComune'
	 * 
	 * @param idComune
	 */
	public void setIdComune(String idComune)
	{
		this.idComune = idComune;
	}

	/**
	 * Method 'getFkTipoImpianto'
	 * 
	 * @return Integer
	 */
	public Integer getFkTipoImpianto()
	{
		return fkTipoImpianto;
	}

	/**
	 * Method 'setFkTipoImpianto'
	 * 
	 * @param fkTipoImpianto
	 */
	public void setFkTipoImpianto(Integer fkTipoImpianto)
	{
		this.fkTipoImpianto = fkTipoImpianto;
	}

	/**
	 * Method 'getFkCombustibileRisc'
	 * 
	 * @return Integer
	 */
	public Integer getFkCombustibileRisc()
	{
		return fkCombustibileRisc;
	}

	/**
	 * Method 'setFkCombustibileRisc'
	 * 
	 * @param fkCombustibileRisc
	 */
	public void setFkCombustibileRisc(Integer fkCombustibileRisc)
	{
		this.fkCombustibileRisc = fkCombustibileRisc;
	}

	/**
	 * Method 'getFkCombustibileAcs'
	 * 
	 * @return Integer
	 */
	public Integer getFkCombustibileAcs()
	{
		return fkCombustibileAcs;
	}

	/**
	 * Method 'setFkCombustibileAcs'
	 * 
	 * @param fkCombustibileAcs
	 */
	public void setFkCombustibileAcs(Integer fkCombustibileAcs)
	{
		this.fkCombustibileAcs = fkCombustibileAcs;
	}

	/**
	 * Method 'getFkClasse19205'
	 * 
	 * @return Integer
	 */
	public Integer getFkClasse19205()
	{
		return fkClasse19205;
	}

	/**
	 * Method 'setFkClasse19205'
	 * 
	 * @param fkClasse19205
	 */
	public void setFkClasse19205(Integer fkClasse19205)
	{
		this.fkClasse19205 = fkClasse19205;
	}

	/**
	 * Method 'getDomRiscQh'
	 * 
	 * @return Double
	 */
	public Double getDomRiscQh()
	{
		return domRiscQh;
	}

	/**
	 * Method 'setDomRiscQh'
	 * 
	 * @param domRiscQh
	 */
	public void setDomRiscQh(Double domRiscQh)
	{
		this.domRiscQh = domRiscQh;
	}

	/**
	 * Method 'getIndRiscEpi'
	 * 
	 * @return Double
	 */
	public Double getIndRiscEpi()
	{
		return indRiscEpi;
	}

	/**
	 * Method 'setIndRiscEpi'
	 * 
	 * @param indRiscEpi
	 */
	public void setIndRiscEpi(Double indRiscEpi)
	{
		this.indRiscEpi = indRiscEpi;
	}

	/**
	 * Method 'getFabbAcs'
	 * 
	 * @return Double
	 */
	public Double getFabbAcs()
	{
		return fabbAcs;
	}

	/**
	 * Method 'setFabbAcs'
	 * 
	 * @param fabbAcs
	 */
	public void setFabbAcs(Double fabbAcs)
	{
		this.fabbAcs = fabbAcs;
	}

	/**
	 * Method 'getIndGlobEplordoTo'
	 * 
	 * @return Double
	 */
	public Double getIndGlobEplordoTo()
	{
		return indGlobEplordoTo;
	}

	/**
	 * Method 'setIndGlobEplordoTo'
	 * 
	 * @param indGlobEplordoTo
	 */
	public void setIndGlobEplordoTo(Double indGlobEplordoTo)
	{
		this.indGlobEplordoTo = indGlobEplordoTo;
	}

	/**
	 * Method 'getPrestazioneEne'
	 * 
	 * @return Double
	 */
	public Double getPrestazioneEne()
	{
		return prestazioneEne;
	}

	/**
	 * Method 'setPrestazioneEne'
	 * 
	 * @param prestazioneEne
	 */
	public void setPrestazioneEne(Double prestazioneEne)
	{
		this.prestazioneEne = prestazioneEne;
	}

	/**
	 * Method 'getNumAppartamenti'
	 * 
	 * @return Integer
	 */
	public Integer getNumAppartamenti()
	{
		return numAppartamenti;
	}

	/**
	 * Method 'setNumAppartamenti'
	 * 
	 * @param numAppartamenti
	 */
	public void setNumAppartamenti(Integer numAppartamenti)
	{
		this.numAppartamenti = numAppartamenti;
	}

	/**
	 * Method 'getUiServite'
	 * 
	 * @return String
	 */
	public String getUiServite()
	{
		return uiServite;
	}

	/**
	 * Method 'setUiServite'
	 * 
	 * @param uiServite
	 */
	public void setUiServite(String uiServite)
	{
		this.uiServite = uiServite;
	}

	/**
	 * Method 'getPotRiscaldamento'
	 * 
	 * @return Double
	 */
	public Double getPotRiscaldamento()
	{
		return potRiscaldamento;
	}

	/**
	 * Method 'setPotRiscaldamento'
	 * 
	 * @param potRiscaldamento
	 */
	public void setPotRiscaldamento(Double potRiscaldamento)
	{
		this.potRiscaldamento = potRiscaldamento;
	}

	/**
	 * Method 'getFkClasseEffRisc'
	 * 
	 * @return Integer
	 */
	public Integer getFkClasseEffRisc()
	{
		return fkClasseEffRisc;
	}

	/**
	 * Method 'setFkClasseEffRisc'
	 * 
	 * @param fkClasseEffRisc
	 */
	public void setFkClasseEffRisc(Integer fkClasseEffRisc)
	{
		this.fkClasseEffRisc = fkClasseEffRisc;
	}

	/**
	 * Method 'getGenAnnoRisc'
	 * 
	 * @return Integer
	 */
	public Integer getGenAnnoRisc()
	{
		return genAnnoRisc;
	}

	/**
	 * Method 'setGenAnnoRisc'
	 * 
	 * @param genAnnoRisc
	 */
	public void setGenAnnoRisc(Integer genAnnoRisc)
	{
		this.genAnnoRisc = genAnnoRisc;
	}

	/**
	 * Method 'getFlgContRip'
	 * 
	 * @return String
	 */
	public String getFlgContRip()
	{
		return flgContRip;
	}

	/**
	 * Method 'setFlgContRip'
	 * 
	 * @param flgContRip
	 */
	public void setFlgContRip(String flgContRip)
	{
		this.flgContRip = flgContRip;
	}

	/**
	 * Method 'getRendGener'
	 * 
	 * @return Double
	 */
	public Double getRendGener()
	{
		return rendGener;
	}

	/**
	 * Method 'setRendGener'
	 * 
	 * @param rendGener
	 */
	public void setRendGener(Double rendGener)
	{
		this.rendGener = rendGener;
	}

	/**
	 * Method 'getRendRegol'
	 * 
	 * @return Double
	 */
	public Double getRendRegol()
	{
		return rendRegol;
	}

	/**
	 * Method 'setRendRegol'
	 * 
	 * @param rendRegol
	 */
	public void setRendRegol(Double rendRegol)
	{
		this.rendRegol = rendRegol;
	}

	/**
	 * Method 'getRendEmiss'
	 * 
	 * @return Double
	 */
	public Double getRendEmiss()
	{
		return rendEmiss;
	}

	/**
	 * Method 'setRendEmiss'
	 * 
	 * @param rendEmiss
	 */
	public void setRendEmiss(Double rendEmiss)
	{
		this.rendEmiss = rendEmiss;
	}

	/**
	 * Method 'getRendDistrib'
	 * 
	 * @return Double
	 */
	public Double getRendDistrib()
	{
		return rendDistrib;
	}

	/**
	 * Method 'setRendDistrib'
	 * 
	 * @param rendDistrib
	 */
	public void setRendDistrib(Double rendDistrib)
	{
		this.rendDistrib = rendDistrib;
	}

	/**
	 * Method 'getDomRiscQhto'
	 * 
	 * @return Double
	 */
	public Double getDomRiscQhto()
	{
		return domRiscQhto;
	}

	/**
	 * Method 'setDomRiscQhto'
	 * 
	 * @param domRiscQhto
	 */
	public void setDomRiscQhto(Double domRiscQhto)
	{
		this.domRiscQhto = domRiscQhto;
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
	 * Method 'getFlgOld'
	 * 
	 * @return String
	 */
	public String getFlgOld()
	{
		return flgOld;
	}

	/**
	 * Method 'setFlgOld'
	 * 
	 * @param flgOld
	 */
	public void setFlgOld(String flgOld)
	{
		this.flgOld = flgOld;
	}

	/**
	 * Method 'getFlgEdifE0'
	 * 
	 * @return String
	 */
	public String getFlgEdifE0()
	{
		return flgEdifE0;
	}

	/**
	 * Method 'setFlgEdifE0'
	 * 
	 * @param flgEdifE0
	 */
	public void setFlgEdifE0(String flgEdifE0)
	{
		this.flgEdifE0 = flgEdifE0;
	}

	/**
	 * Method 'getEpglNrenGlobale'
	 * 
	 * @return Double
	 */
	public Double getEpglNrenGlobale()
	{
		return epglNrenGlobale;
	}

	/**
	 * Method 'setEpglNrenGlobale'
	 * 
	 * @param epglNrenGlobale
	 */
	public void setEpglNrenGlobale(Double epglNrenGlobale)
	{
		this.epglNrenGlobale = epglNrenGlobale;
	}

	/**
	 * Method 'getEpglRenGlobale'
	 * 
	 * @return Double
	 */
	public Double getEpglRenGlobale()
	{
		return epglRenGlobale;
	}

	/**
	 * Method 'setEpglRenGlobale'
	 * 
	 * @param epglRenGlobale
	 */
	public void setEpglRenGlobale(Double epglRenGlobale)
	{
		this.epglRenGlobale = epglRenGlobale;
	}

	/**
	 * Method 'getEmissioniCo2'
	 * 
	 * @return Double
	 */
	public Double getEmissioniCo2()
	{
		return emissioniCo2;
	}

	/**
	 * Method 'setEmissioniCo2'
	 * 
	 * @param emissioniCo2
	 */
	public void setEmissioniCo2(Double emissioniCo2)
	{
		this.emissioniCo2 = emissioniCo2;
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
	 * Method 'getAsolAsup'
	 * 
	 * @return Double
	 */
	public Double getAsolAsup()
	{
		return asolAsup;
	}

	/**
	 * Method 'setAsolAsup'
	 * 
	 * @param asolAsup
	 */
	public void setAsolAsup(Double asolAsup)
	{
		this.asolAsup = asolAsup;
	}

	/**
	 * Method 'getYie'
	 * 
	 * @return Double
	 */
	public Double getYie()
	{
		return yie;
	}

	/**
	 * Method 'setYie'
	 * 
	 * @param yie
	 */
	public void setYie(Double yie)
	{
		this.yie = yie;
	}

	/**
	 * Method 'getVSuRaff'
	 * 
	 * @return Double
	 */
	public Double getVSuRaff()
	{
		return vSuRaff;
	}

	/**
	 * Method 'setVSuRaff'
	 * 
	 * @param vSuRaff
	 */
	public void setVSuRaff(Double vSuRaff)
	{
		this.vSuRaff = vSuRaff;
	}

	/**
	 * Method 'getVSuRisc'
	 * 
	 * @return Double
	 */
	public Double getVSuRisc()
	{
		return vSuRisc;
	}

	/**
	 * Method 'setVSuRisc'
	 * 
	 * @param vSuRisc
	 */
	public void setVSuRisc(Double vSuRisc)
	{
		this.vSuRisc = vSuRisc;
	}

	/**
	 * Method 'getSVRaff'
	 * 
	 * @return Double
	 */
	public Double getSVRaff()
	{
		return sVRaff;
	}

	/**
	 * Method 'setSVRaff'
	 * 
	 * @param sVRaff
	 */
	public void setSVRaff(Double sVRaff)
	{
		this.sVRaff = sVRaff;
	}

	/**
	 * Method 'getSVRisc'
	 * 
	 * @return Double
	 */
	public Double getSVRisc()
	{
		return sVRisc;
	}

	/**
	 * Method 'setSVRisc'
	 * 
	 * @param sVRisc
	 */
	public void setSVRisc(Double sVRisc)
	{
		this.sVRisc = sVRisc;
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
		
		if (!(_other instanceof SiceeTExportBo)) {
			return false;
		}
		
		final SiceeTExportBo _cast = (SiceeTExportBo) _other;
		if (idCertificatore == null ? _cast.idCertificatore != idCertificatore : !idCertificatore.equals( _cast.idCertificatore )) {
			return false;
		}
		
		if (progrCertificato == null ? _cast.progrCertificato != progrCertificato : !progrCertificato.equals( _cast.progrCertificato )) {
			return false;
		}
		
		if (anno == null ? _cast.anno != anno : !anno.equals( _cast.anno )) {
			return false;
		}
		
		if (dtInizio == null ? _cast.dtInizio != dtInizio : !dtInizio.equals( _cast.dtInizio )) {
			return false;
		}
		
		if (dtUpload == null ? _cast.dtUpload != dtUpload : !dtUpload.equals( _cast.dtUpload )) {
			return false;
		}
		
		if (descProv == null ? _cast.descProv != descProv : !descProv.equals( _cast.descProv )) {
			return false;
		}
		
		if (descComune == null ? _cast.descComune != descComune : !descComune.equals( _cast.descComune )) {
			return false;
		}
		
		if (gradiGiorno == null ? _cast.gradiGiorno != gradiGiorno : !gradiGiorno.equals( _cast.gradiGiorno )) {
			return false;
		}
		
		if (piano == null ? _cast.piano != piano : !piano.equals( _cast.piano )) {
			return false;
		}
		
		if (numPianiComplessivi == null ? _cast.numPianiComplessivi != numPianiComplessivi : !numPianiComplessivi.equals( _cast.numPianiComplessivi )) {
			return false;
		}
		
		if (fkStato == null ? _cast.fkStato != fkStato : !fkStato.equals( _cast.fkStato )) {
			return false;
		}
		
		if (fkDestUso == null ? _cast.fkDestUso != fkDestUso : !fkDestUso.equals( _cast.fkDestUso )) {
			return false;
		}
		
		if (descTipoEdificio == null ? _cast.descTipoEdificio != descTipoEdificio : !descTipoEdificio.equals( _cast.descTipoEdificio )) {
			return false;
		}
		
		if (fkClasse == null ? _cast.fkClasse != fkClasse : !fkClasse.equals( _cast.fkClasse )) {
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
		
		if (su == null ? _cast.su != su : !su.equals( _cast.su )) {
			return false;
		}
		
		if (trasmOpache == null ? _cast.trasmOpache != trasmOpache : !trasmOpache.equals( _cast.trasmOpache )) {
			return false;
		}
		
		if (trasmTrasp == null ? _cast.trasmTrasp != trasmTrasp : !trasmTrasp.equals( _cast.trasmTrasp )) {
			return false;
		}
		
		if (fattoreForma == null ? _cast.fattoreForma != fattoreForma : !fattoreForma.equals( _cast.fattoreForma )) {
			return false;
		}
		
		if (vSu == null ? _cast.vSu != vSu : !vSu.equals( _cast.vSu )) {
			return false;
		}
		
		if (indRiscEpito == null ? _cast.indRiscEpito != indRiscEpito : !indRiscEpito.equals( _cast.indRiscEpito )) {
			return false;
		}
		
		if (flgFabbMaxIndice == null ? _cast.flgFabbMaxIndice != flgFabbMaxIndice : !flgFabbMaxIndice.equals( _cast.flgFabbMaxIndice )) {
			return false;
		}
		
		if (valorePrestPdc == null ? _cast.valorePrestPdc != valorePrestPdc : !valorePrestPdc.equals( _cast.valorePrestPdc )) {
			return false;
		}
		
		if (rendAcsEtagacs == null ? _cast.rendAcsEtagacs != rendAcsEtagacs : !rendAcsEtagacs.equals( _cast.rendAcsEtagacs )) {
			return false;
		}
		
		if (domAcsQhw == null ? _cast.domAcsQhw != domAcsQhw : !domAcsQhw.equals( _cast.domAcsQhw )) {
			return false;
		}
		
		if (enAcsRinno == null ? _cast.enAcsRinno != enAcsRinno : !enAcsRinno.equals( _cast.enAcsRinno )) {
			return false;
		}
		
		if (rendImpEtag == null ? _cast.rendImpEtag != rendImpEtag : !rendImpEtag.equals( _cast.rendImpEtag )) {
			return false;
		}
		
		if (domAcsQhwSu == null ? _cast.domAcsQhwSu != domAcsQhwSu : !domAcsQhwSu.equals( _cast.domAcsQhwSu )) {
			return false;
		}
		
		if (indGlobEplordo == null ? _cast.indGlobEplordo != indGlobEplordo : !indGlobEplordo.equals( _cast.indGlobEplordo )) {
			return false;
		}
		
		if (domAcsQhwto == null ? _cast.domAcsQhwto != domAcsQhwto : !domAcsQhwto.equals( _cast.domAcsQhwto )) {
			return false;
		}
		
		if (flgFabbAcs == null ? _cast.flgFabbAcs != flgFabbAcs : !flgFabbAcs.equals( _cast.flgFabbAcs )) {
			return false;
		}
		
		if (fkMotivo == null ? _cast.fkMotivo != fkMotivo : !fkMotivo.equals( _cast.fkMotivo )) {
			return false;
		}
		
		if (metodologiaCalcolo == null ? _cast.metodologiaCalcolo != metodologiaCalcolo : !metodologiaCalcolo.equals( _cast.metodologiaCalcolo )) {
			return false;
		}
		
		if (swUtilizzato == null ? _cast.swUtilizzato != swUtilizzato : !swUtilizzato.equals( _cast.swUtilizzato )) {
			return false;
		}
		
		if (descIndirizzo == null ? _cast.descIndirizzo != descIndirizzo : !descIndirizzo.equals( _cast.descIndirizzo )) {
			return false;
		}
		
		if (numCivico == null ? _cast.numCivico != numCivico : !numCivico.equals( _cast.numCivico )) {
			return false;
		}
		
		if (sezione == null ? _cast.sezione != sezione : !sezione.equals( _cast.sezione )) {
			return false;
		}
		
		if (foglio == null ? _cast.foglio != foglio : !foglio.equals( _cast.foglio )) {
			return false;
		}
		
		if (particella == null ? _cast.particella != particella : !particella.equals( _cast.particella )) {
			return false;
		}
		
		if (subalterno == null ? _cast.subalterno != subalterno : !subalterno.equals( _cast.subalterno )) {
			return false;
		}
		
		if (idProv == null ? _cast.idProv != idProv : !idProv.equals( _cast.idProv )) {
			return false;
		}
		
		if (idComune == null ? _cast.idComune != idComune : !idComune.equals( _cast.idComune )) {
			return false;
		}
		
		if (fkTipoImpianto == null ? _cast.fkTipoImpianto != fkTipoImpianto : !fkTipoImpianto.equals( _cast.fkTipoImpianto )) {
			return false;
		}
		
		if (fkCombustibileRisc == null ? _cast.fkCombustibileRisc != fkCombustibileRisc : !fkCombustibileRisc.equals( _cast.fkCombustibileRisc )) {
			return false;
		}
		
		if (fkCombustibileAcs == null ? _cast.fkCombustibileAcs != fkCombustibileAcs : !fkCombustibileAcs.equals( _cast.fkCombustibileAcs )) {
			return false;
		}
		
		if (fkClasse19205 == null ? _cast.fkClasse19205 != fkClasse19205 : !fkClasse19205.equals( _cast.fkClasse19205 )) {
			return false;
		}
		
		if (domRiscQh == null ? _cast.domRiscQh != domRiscQh : !domRiscQh.equals( _cast.domRiscQh )) {
			return false;
		}
		
		if (indRiscEpi == null ? _cast.indRiscEpi != indRiscEpi : !indRiscEpi.equals( _cast.indRiscEpi )) {
			return false;
		}
		
		if (fabbAcs == null ? _cast.fabbAcs != fabbAcs : !fabbAcs.equals( _cast.fabbAcs )) {
			return false;
		}
		
		if (indGlobEplordoTo == null ? _cast.indGlobEplordoTo != indGlobEplordoTo : !indGlobEplordoTo.equals( _cast.indGlobEplordoTo )) {
			return false;
		}
		
		if (prestazioneEne == null ? _cast.prestazioneEne != prestazioneEne : !prestazioneEne.equals( _cast.prestazioneEne )) {
			return false;
		}
		
		if (numAppartamenti == null ? _cast.numAppartamenti != numAppartamenti : !numAppartamenti.equals( _cast.numAppartamenti )) {
			return false;
		}
		
		if (uiServite == null ? _cast.uiServite != uiServite : !uiServite.equals( _cast.uiServite )) {
			return false;
		}
		
		if (potRiscaldamento == null ? _cast.potRiscaldamento != potRiscaldamento : !potRiscaldamento.equals( _cast.potRiscaldamento )) {
			return false;
		}
		
		if (fkClasseEffRisc == null ? _cast.fkClasseEffRisc != fkClasseEffRisc : !fkClasseEffRisc.equals( _cast.fkClasseEffRisc )) {
			return false;
		}
		
		if (genAnnoRisc == null ? _cast.genAnnoRisc != genAnnoRisc : !genAnnoRisc.equals( _cast.genAnnoRisc )) {
			return false;
		}
		
		if (flgContRip == null ? _cast.flgContRip != flgContRip : !flgContRip.equals( _cast.flgContRip )) {
			return false;
		}
		
		if (rendGener == null ? _cast.rendGener != rendGener : !rendGener.equals( _cast.rendGener )) {
			return false;
		}
		
		if (rendRegol == null ? _cast.rendRegol != rendRegol : !rendRegol.equals( _cast.rendRegol )) {
			return false;
		}
		
		if (rendEmiss == null ? _cast.rendEmiss != rendEmiss : !rendEmiss.equals( _cast.rendEmiss )) {
			return false;
		}
		
		if (rendDistrib == null ? _cast.rendDistrib != rendDistrib : !rendDistrib.equals( _cast.rendDistrib )) {
			return false;
		}
		
		if (domRiscQhto == null ? _cast.domRiscQhto != domRiscQhto : !domRiscQhto.equals( _cast.domRiscQhto )) {
			return false;
		}
		
		if (fkCarattEdificio == null ? _cast.fkCarattEdificio != fkCarattEdificio : !fkCarattEdificio.equals( _cast.fkCarattEdificio )) {
			return false;
		}
		
		if (flgOld == null ? _cast.flgOld != flgOld : !flgOld.equals( _cast.flgOld )) {
			return false;
		}
		
		if (flgEdifE0 == null ? _cast.flgEdifE0 != flgEdifE0 : !flgEdifE0.equals( _cast.flgEdifE0 )) {
			return false;
		}
		
		if (epglNrenGlobale == null ? _cast.epglNrenGlobale != epglNrenGlobale : !epglNrenGlobale.equals( _cast.epglNrenGlobale )) {
			return false;
		}
		
		if (epglRenGlobale == null ? _cast.epglRenGlobale != epglRenGlobale : !epglRenGlobale.equals( _cast.epglRenGlobale )) {
			return false;
		}
		
		if (emissioniCo2 == null ? _cast.emissioniCo2 != emissioniCo2 : !emissioniCo2.equals( _cast.emissioniCo2 )) {
			return false;
		}
		
		if (supRaffrescata == null ? _cast.supRaffrescata != supRaffrescata : !supRaffrescata.equals( _cast.supRaffrescata )) {
			return false;
		}
		
		if (supRiscaldata == null ? _cast.supRiscaldata != supRiscaldata : !supRiscaldata.equals( _cast.supRiscaldata )) {
			return false;
		}
		
		if (volLordoRaffrescato == null ? _cast.volLordoRaffrescato != volLordoRaffrescato : !volLordoRaffrescato.equals( _cast.volLordoRaffrescato )) {
			return false;
		}
		
		if (eph == null ? _cast.eph != eph : !eph.equals( _cast.eph )) {
			return false;
		}
		
		if (asolAsup == null ? _cast.asolAsup != asolAsup : !asolAsup.equals( _cast.asolAsup )) {
			return false;
		}
		
		if (yie == null ? _cast.yie != yie : !yie.equals( _cast.yie )) {
			return false;
		}
		
		if (vSuRaff == null ? _cast.vSuRaff != vSuRaff : !vSuRaff.equals( _cast.vSuRaff )) {
			return false;
		}
		
		if (vSuRisc == null ? _cast.vSuRisc != vSuRisc : !vSuRisc.equals( _cast.vSuRisc )) {
			return false;
		}
		
		if (sVRaff == null ? _cast.sVRaff != sVRaff : !sVRaff.equals( _cast.sVRaff )) {
			return false;
		}
		
		if (sVRisc == null ? _cast.sVRisc != sVRisc : !sVRisc.equals( _cast.sVRisc )) {
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
		
		if (dtInizio != null) {
			_hashCode = 29 * _hashCode + dtInizio.hashCode();
		}
		
		if (dtUpload != null) {
			_hashCode = 29 * _hashCode + dtUpload.hashCode();
		}
		
		if (descProv != null) {
			_hashCode = 29 * _hashCode + descProv.hashCode();
		}
		
		if (descComune != null) {
			_hashCode = 29 * _hashCode + descComune.hashCode();
		}
		
		if (gradiGiorno != null) {
			_hashCode = 29 * _hashCode + gradiGiorno.hashCode();
		}
		
		if (piano != null) {
			_hashCode = 29 * _hashCode + piano.hashCode();
		}
		
		if (numPianiComplessivi != null) {
			_hashCode = 29 * _hashCode + numPianiComplessivi.hashCode();
		}
		
		if (fkStato != null) {
			_hashCode = 29 * _hashCode + fkStato.hashCode();
		}
		
		if (fkDestUso != null) {
			_hashCode = 29 * _hashCode + fkDestUso.hashCode();
		}
		
		if (descTipoEdificio != null) {
			_hashCode = 29 * _hashCode + descTipoEdificio.hashCode();
		}
		
		if (fkClasse != null) {
			_hashCode = 29 * _hashCode + fkClasse.hashCode();
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
		
		if (su != null) {
			_hashCode = 29 * _hashCode + su.hashCode();
		}
		
		if (trasmOpache != null) {
			_hashCode = 29 * _hashCode + trasmOpache.hashCode();
		}
		
		if (trasmTrasp != null) {
			_hashCode = 29 * _hashCode + trasmTrasp.hashCode();
		}
		
		if (fattoreForma != null) {
			_hashCode = 29 * _hashCode + fattoreForma.hashCode();
		}
		
		if (vSu != null) {
			_hashCode = 29 * _hashCode + vSu.hashCode();
		}
		
		if (indRiscEpito != null) {
			_hashCode = 29 * _hashCode + indRiscEpito.hashCode();
		}
		
		if (flgFabbMaxIndice != null) {
			_hashCode = 29 * _hashCode + flgFabbMaxIndice.hashCode();
		}
		
		if (valorePrestPdc != null) {
			_hashCode = 29 * _hashCode + valorePrestPdc.hashCode();
		}
		
		if (rendAcsEtagacs != null) {
			_hashCode = 29 * _hashCode + rendAcsEtagacs.hashCode();
		}
		
		if (domAcsQhw != null) {
			_hashCode = 29 * _hashCode + domAcsQhw.hashCode();
		}
		
		if (enAcsRinno != null) {
			_hashCode = 29 * _hashCode + enAcsRinno.hashCode();
		}
		
		if (rendImpEtag != null) {
			_hashCode = 29 * _hashCode + rendImpEtag.hashCode();
		}
		
		if (domAcsQhwSu != null) {
			_hashCode = 29 * _hashCode + domAcsQhwSu.hashCode();
		}
		
		if (indGlobEplordo != null) {
			_hashCode = 29 * _hashCode + indGlobEplordo.hashCode();
		}
		
		if (domAcsQhwto != null) {
			_hashCode = 29 * _hashCode + domAcsQhwto.hashCode();
		}
		
		if (flgFabbAcs != null) {
			_hashCode = 29 * _hashCode + flgFabbAcs.hashCode();
		}
		
		if (fkMotivo != null) {
			_hashCode = 29 * _hashCode + fkMotivo.hashCode();
		}
		
		if (metodologiaCalcolo != null) {
			_hashCode = 29 * _hashCode + metodologiaCalcolo.hashCode();
		}
		
		if (swUtilizzato != null) {
			_hashCode = 29 * _hashCode + swUtilizzato.hashCode();
		}
		
		if (descIndirizzo != null) {
			_hashCode = 29 * _hashCode + descIndirizzo.hashCode();
		}
		
		if (numCivico != null) {
			_hashCode = 29 * _hashCode + numCivico.hashCode();
		}
		
		if (sezione != null) {
			_hashCode = 29 * _hashCode + sezione.hashCode();
		}
		
		if (foglio != null) {
			_hashCode = 29 * _hashCode + foglio.hashCode();
		}
		
		if (particella != null) {
			_hashCode = 29 * _hashCode + particella.hashCode();
		}
		
		if (subalterno != null) {
			_hashCode = 29 * _hashCode + subalterno.hashCode();
		}
		
		if (idProv != null) {
			_hashCode = 29 * _hashCode + idProv.hashCode();
		}
		
		if (idComune != null) {
			_hashCode = 29 * _hashCode + idComune.hashCode();
		}
		
		if (fkTipoImpianto != null) {
			_hashCode = 29 * _hashCode + fkTipoImpianto.hashCode();
		}
		
		if (fkCombustibileRisc != null) {
			_hashCode = 29 * _hashCode + fkCombustibileRisc.hashCode();
		}
		
		if (fkCombustibileAcs != null) {
			_hashCode = 29 * _hashCode + fkCombustibileAcs.hashCode();
		}
		
		if (fkClasse19205 != null) {
			_hashCode = 29 * _hashCode + fkClasse19205.hashCode();
		}
		
		if (domRiscQh != null) {
			_hashCode = 29 * _hashCode + domRiscQh.hashCode();
		}
		
		if (indRiscEpi != null) {
			_hashCode = 29 * _hashCode + indRiscEpi.hashCode();
		}
		
		if (fabbAcs != null) {
			_hashCode = 29 * _hashCode + fabbAcs.hashCode();
		}
		
		if (indGlobEplordoTo != null) {
			_hashCode = 29 * _hashCode + indGlobEplordoTo.hashCode();
		}
		
		if (prestazioneEne != null) {
			_hashCode = 29 * _hashCode + prestazioneEne.hashCode();
		}
		
		if (numAppartamenti != null) {
			_hashCode = 29 * _hashCode + numAppartamenti.hashCode();
		}
		
		if (uiServite != null) {
			_hashCode = 29 * _hashCode + uiServite.hashCode();
		}
		
		if (potRiscaldamento != null) {
			_hashCode = 29 * _hashCode + potRiscaldamento.hashCode();
		}
		
		if (fkClasseEffRisc != null) {
			_hashCode = 29 * _hashCode + fkClasseEffRisc.hashCode();
		}
		
		if (genAnnoRisc != null) {
			_hashCode = 29 * _hashCode + genAnnoRisc.hashCode();
		}
		
		if (flgContRip != null) {
			_hashCode = 29 * _hashCode + flgContRip.hashCode();
		}
		
		if (rendGener != null) {
			_hashCode = 29 * _hashCode + rendGener.hashCode();
		}
		
		if (rendRegol != null) {
			_hashCode = 29 * _hashCode + rendRegol.hashCode();
		}
		
		if (rendEmiss != null) {
			_hashCode = 29 * _hashCode + rendEmiss.hashCode();
		}
		
		if (rendDistrib != null) {
			_hashCode = 29 * _hashCode + rendDistrib.hashCode();
		}
		
		if (domRiscQhto != null) {
			_hashCode = 29 * _hashCode + domRiscQhto.hashCode();
		}
		
		if (fkCarattEdificio != null) {
			_hashCode = 29 * _hashCode + fkCarattEdificio.hashCode();
		}
		
		if (flgOld != null) {
			_hashCode = 29 * _hashCode + flgOld.hashCode();
		}
		
		if (flgEdifE0 != null) {
			_hashCode = 29 * _hashCode + flgEdifE0.hashCode();
		}
		
		if (epglNrenGlobale != null) {
			_hashCode = 29 * _hashCode + epglNrenGlobale.hashCode();
		}
		
		if (epglRenGlobale != null) {
			_hashCode = 29 * _hashCode + epglRenGlobale.hashCode();
		}
		
		if (emissioniCo2 != null) {
			_hashCode = 29 * _hashCode + emissioniCo2.hashCode();
		}
		
		if (supRaffrescata != null) {
			_hashCode = 29 * _hashCode + supRaffrescata.hashCode();
		}
		
		if (supRiscaldata != null) {
			_hashCode = 29 * _hashCode + supRiscaldata.hashCode();
		}
		
		if (volLordoRaffrescato != null) {
			_hashCode = 29 * _hashCode + volLordoRaffrescato.hashCode();
		}
		
		if (eph != null) {
			_hashCode = 29 * _hashCode + eph.hashCode();
		}
		
		if (asolAsup != null) {
			_hashCode = 29 * _hashCode + asolAsup.hashCode();
		}
		
		if (yie != null) {
			_hashCode = 29 * _hashCode + yie.hashCode();
		}
		
		if (vSuRaff != null) {
			_hashCode = 29 * _hashCode + vSuRaff.hashCode();
		}
		
		if (vSuRisc != null) {
			_hashCode = 29 * _hashCode + vSuRisc.hashCode();
		}
		
		if (sVRaff != null) {
			_hashCode = 29 * _hashCode + sVRaff.hashCode();
		}
		
		if (sVRisc != null) {
			_hashCode = 29 * _hashCode + sVRisc.hashCode();
		}
		
		return _hashCode;
	}

	/**
	 * Method 'createPk'
	 * 
	 * @return SiceeTExportBoPk
	 */
	public SiceeTExportBoPk createPk()
	{
		return new SiceeTExportBoPk(anno, idCertificatore, progrCertificato);
	}

	/**
	 * Method 'toString'
	 * 
	 * @return String
	 */
	public String toString()
	{
		StringBuffer ret = new StringBuffer();
		ret.append( "it.csi.sicee.siceeweb.business.dao.dto.SiceeTExportBo: " );
		ret.append( "idCertificatore=" + idCertificatore );
		ret.append( ", progrCertificato=" + progrCertificato );
		ret.append( ", anno=" + anno );
		ret.append( ", dtInizio=" + dtInizio );
		ret.append( ", dtUpload=" + dtUpload );
		ret.append( ", descProv=" + descProv );
		ret.append( ", descComune=" + descComune );
		ret.append( ", gradiGiorno=" + gradiGiorno );
		ret.append( ", piano=" + piano );
		ret.append( ", numPianiComplessivi=" + numPianiComplessivi );
		ret.append( ", fkStato=" + fkStato );
		ret.append( ", fkDestUso=" + fkDestUso );
		ret.append( ", descTipoEdificio=" + descTipoEdificio );
		ret.append( ", fkClasse=" + fkClasse );
		ret.append( ", annoCostruzione=" + annoCostruzione );
		ret.append( ", annoUltRist=" + annoUltRist );
		ret.append( ", volLordoRiscaldato=" + volLordoRiscaldato );
		ret.append( ", supDisperdenteTot=" + supDisperdenteTot );
		ret.append( ", su=" + su );
		ret.append( ", trasmOpache=" + trasmOpache );
		ret.append( ", trasmTrasp=" + trasmTrasp );
		ret.append( ", fattoreForma=" + fattoreForma );
		ret.append( ", vSu=" + vSu );
		ret.append( ", indRiscEpito=" + indRiscEpito );
		ret.append( ", flgFabbMaxIndice=" + flgFabbMaxIndice );
		ret.append( ", valorePrestPdc=" + valorePrestPdc );
		ret.append( ", rendAcsEtagacs=" + rendAcsEtagacs );
		ret.append( ", domAcsQhw=" + domAcsQhw );
		ret.append( ", enAcsRinno=" + enAcsRinno );
		ret.append( ", rendImpEtag=" + rendImpEtag );
		ret.append( ", domAcsQhwSu=" + domAcsQhwSu );
		ret.append( ", indGlobEplordo=" + indGlobEplordo );
		ret.append( ", domAcsQhwto=" + domAcsQhwto );
		ret.append( ", flgFabbAcs=" + flgFabbAcs );
		ret.append( ", fkMotivo=" + fkMotivo );
		ret.append( ", metodologiaCalcolo=" + metodologiaCalcolo );
		ret.append( ", swUtilizzato=" + swUtilizzato );
		ret.append( ", descIndirizzo=" + descIndirizzo );
		ret.append( ", numCivico=" + numCivico );
		ret.append( ", sezione=" + sezione );
		ret.append( ", foglio=" + foglio );
		ret.append( ", particella=" + particella );
		ret.append( ", subalterno=" + subalterno );
		ret.append( ", idProv=" + idProv );
		ret.append( ", idComune=" + idComune );
		ret.append( ", fkTipoImpianto=" + fkTipoImpianto );
		ret.append( ", fkCombustibileRisc=" + fkCombustibileRisc );
		ret.append( ", fkCombustibileAcs=" + fkCombustibileAcs );
		ret.append( ", fkClasse19205=" + fkClasse19205 );
		ret.append( ", domRiscQh=" + domRiscQh );
		ret.append( ", indRiscEpi=" + indRiscEpi );
		ret.append( ", fabbAcs=" + fabbAcs );
		ret.append( ", indGlobEplordoTo=" + indGlobEplordoTo );
		ret.append( ", prestazioneEne=" + prestazioneEne );
		ret.append( ", numAppartamenti=" + numAppartamenti );
		ret.append( ", uiServite=" + uiServite );
		ret.append( ", potRiscaldamento=" + potRiscaldamento );
		ret.append( ", fkClasseEffRisc=" + fkClasseEffRisc );
		ret.append( ", genAnnoRisc=" + genAnnoRisc );
		ret.append( ", flgContRip=" + flgContRip );
		ret.append( ", rendGener=" + rendGener );
		ret.append( ", rendRegol=" + rendRegol );
		ret.append( ", rendEmiss=" + rendEmiss );
		ret.append( ", rendDistrib=" + rendDistrib );
		ret.append( ", domRiscQhto=" + domRiscQhto );
		ret.append( ", fkCarattEdificio=" + fkCarattEdificio );
		ret.append( ", flgOld=" + flgOld );
		ret.append( ", flgEdifE0=" + flgEdifE0 );
		ret.append( ", epglNrenGlobale=" + epglNrenGlobale );
		ret.append( ", epglRenGlobale=" + epglRenGlobale );
		ret.append( ", emissioniCo2=" + emissioniCo2 );
		ret.append( ", supRaffrescata=" + supRaffrescata );
		ret.append( ", supRiscaldata=" + supRiscaldata );
		ret.append( ", volLordoRaffrescato=" + volLordoRaffrescato );
		ret.append( ", eph=" + eph );
		ret.append( ", asolAsup=" + asolAsup );
		ret.append( ", yie=" + yie );
		ret.append( ", vSuRaff=" + vSuRaff );
		ret.append( ", vSuRisc=" + vSuRisc );
		ret.append( ", sVRaff=" + sVRaff );
		ret.append( ", sVRisc=" + sVRisc );
		return ret.toString();
	}

}
