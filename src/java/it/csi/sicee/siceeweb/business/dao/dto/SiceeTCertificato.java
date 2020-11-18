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

public class SiceeTCertificato implements Serializable
{
	/** 
	 * This attribute maps to the column ID_CERTIFICATORE in the SICEE_T_CERTIFICATO table.
	 */
	protected String idCertificatore;

	/** 
	 * This attribute maps to the column PROGR_CERTIFICATO in the SICEE_T_CERTIFICATO table.
	 */
	protected String progrCertificato;

	/** 
	 * This attribute maps to the column ANNO in the SICEE_T_CERTIFICATO table.
	 */
	protected String anno;

	/** 
	 * This attribute maps to the column DT_SCADENZA in the SICEE_T_CERTIFICATO table.
	 */
	protected Date dtScadenza;

	/** 
	 * This attribute maps to the column FK_TRANSAZIONE_ACE in the SICEE_T_CERTIFICATO table.
	 */
	protected long fkTransazioneAce;

	/** 
	 * This attribute maps to the column DT_ACQUISTO in the SICEE_T_CERTIFICATO table.
	 */
	protected Date dtAcquisto;

	/** 
	 * This attribute maps to the column FK_STATO in the SICEE_T_CERTIFICATO table.
	 */
	protected Integer fkStato;

	/** 
	 * This attribute maps to the column FK_DICHIARAZIONE in the SICEE_T_CERTIFICATO table.
	 */
	protected Integer fkDichiarazione;

	/** 
	 * This attribute maps to the column FLG_DICHIARAZIONE in the SICEE_T_CERTIFICATO table.
	 */
	protected String flgDichiarazione;

	/** 
	 * This attribute maps to the column ID_INDIRIZZO in the SICEE_T_CERTIFICATO table.
	 */
	protected Integer idIndirizzo;

	/** 
	 * This attribute maps to the column DESC_INDIRIZZO in the SICEE_T_CERTIFICATO table.
	 */
	protected String descIndirizzo;

	/** 
	 * This attribute maps to the column DT_INIZIO in the SICEE_T_CERTIFICATO table.
	 */
	protected Date dtInizio;

	/** 
	 * This attribute maps to the column CAP in the SICEE_T_CERTIFICATO table.
	 */
	protected String cap;

	/** 
	 * This attribute maps to the column ID_COMUNE in the SICEE_T_CERTIFICATO table.
	 */
	protected String idComune;

	/** 
	 * This attribute maps to the column DESC_COMUNE in the SICEE_T_CERTIFICATO table.
	 */
	protected String descComune;

	/** 
	 * This attribute maps to the column SEZIONE in the SICEE_T_CERTIFICATO table.
	 */
	protected String sezione;

	/** 
	 * This attribute maps to the column ID_PROV in the SICEE_T_CERTIFICATO table.
	 */
	protected String idProv;

	/** 
	 * This attribute maps to the column FOGLIO in the SICEE_T_CERTIFICATO table.
	 */
	protected String foglio;

	/** 
	 * This attribute maps to the column DESC_PROV in the SICEE_T_CERTIFICATO table.
	 */
	protected String descProv;

	/** 
	 * This attribute maps to the column ID_REGIONE in the SICEE_T_CERTIFICATO table.
	 */
	protected String idRegione;

	/** 
	 * This attribute maps to the column PARTICELLA in the SICEE_T_CERTIFICATO table.
	 */
	protected String particella;

	/** 
	 * This attribute maps to the column SUBALTERNO in the SICEE_T_CERTIFICATO table.
	 */
	protected String subalterno;

	/** 
	 * This attribute maps to the column DESC_REGIONE in the SICEE_T_CERTIFICATO table.
	 */
	protected String descRegione;

	/** 
	 * This attribute maps to the column PIANO in the SICEE_T_CERTIFICATO table.
	 */
	protected Integer piano;

	/** 
	 * This attribute maps to the column NUM_PIANI_COMPLESSIVI in the SICEE_T_CERTIFICATO table.
	 */
	protected Integer numPianiComplessivi;

	/** 
	 * This attribute maps to the column NUM_APPARTAMENTI in the SICEE_T_CERTIFICATO table.
	 */
	protected Integer numAppartamenti;

	/** 
	 * This attribute maps to the column SCALA in the SICEE_T_CERTIFICATO table.
	 */
	protected String scala;

	/** 
	 * This attribute maps to the column INTERNO in the SICEE_T_CERTIFICATO table.
	 */
	protected String interno;

	/** 
	 * This attribute maps to the column NOTE in the SICEE_T_CERTIFICATO table.
	 */
	protected String note;

	/** 
	 * This attribute maps to the column FLG_STAMPA_DEF in the SICEE_T_CERTIFICATO table.
	 */
	protected String flgStampaDef;

	/** 
	 * This attribute maps to the column NOME_ACE_FIRMATO in the SICEE_T_CERTIFICATO table.
	 */
	protected String nomeAceFirmato;

	/** 
	 * This attribute maps to the column NOME_COCERTIFICATORE in the SICEE_T_CERTIFICATO table.
	 */
	protected String nomeCocertificatore;

	/** 
	 * This attribute maps to the column COGNOME_COCERTIFICATORE in the SICEE_T_CERTIFICATO table.
	 */
	protected String cognomeCocertificatore;

	/** 
	 * This attribute maps to the column NUM_COCERTIFICATORE in the SICEE_T_CERTIFICATO table.
	 */
	protected String numCocertificatore;

	/** 
	 * This attribute maps to the column COD_FISC_COCERTIFICATORE in the SICEE_T_CERTIFICATO table.
	 */
	protected String codFiscCocertificatore;

	/** 
	 * This attribute maps to the column NUM_CIVICO in the SICEE_T_CERTIFICATO table.
	 */
	protected String numCivico;

	/** 
	 * This attribute maps to the column IDENTIFIC_PDF in the SICEE_T_CERTIFICATO table.
	 */
	protected String identificPdf;

	/** 
	 * This attribute maps to the column IDENTIFIC_FOTO in the SICEE_T_CERTIFICATO table.
	 */
	protected String identificFoto;

	/** 
	 * This attribute maps to the column LUOGO_DICHIARAZIONE in the SICEE_T_CERTIFICATO table.
	 */
	protected String luogoDichiarazione;

	/** 
	 * This attribute maps to the column NOME_FOTO in the SICEE_T_CERTIFICATO table.
	 */
	protected String nomeFoto;

	/** 
	 * This attribute maps to the column NOME_PDF in the SICEE_T_CERTIFICATO table.
	 */
	protected String nomePdf;

	/** 
	 * This attribute maps to the column DT_UPLOAD in the SICEE_T_CERTIFICATO table.
	 */
	protected Date dtUpload;

	/** 
	 * This attribute maps to the column FLG_EDIFICIO_PERFORMANTE in the SICEE_T_CERTIFICATO table.
	 */
	protected String flgEdificioPerformante;

	/** 
	 * This attribute maps to the column FLG_SIGMATER in the SICEE_T_CERTIFICATO table.
	 */
	protected String flgSigmater;

	/** 
	 * This attribute maps to the column FK_MOTIVO_SOST in the SICEE_T_CERTIFICATO table.
	 */
	protected Integer fkMotivoSost;

	/** 
	 * This attribute maps to the column DT_SOSTITUZIONE in the SICEE_T_CERTIFICATO table.
	 */
	protected Date dtSostituzione;

	/** 
	 * This attribute maps to the column NOTE_SOSTITUZIONE in the SICEE_T_CERTIFICATO table.
	 */
	protected String noteSostituzione;

	/** 
	 * This attribute maps to the column DT_FOTO in the SICEE_T_CERTIFICATO table.
	 */
	protected Date dtFoto;

	/** 
	 * This attribute maps to the column FLG_OLD in the SICEE_T_CERTIFICATO table.
	 */
	protected String flgOld;

	/** 
	 * This attribute maps to the column COORD_N in the SICEE_T_CERTIFICATO table.
	 */
	protected double coordN;

	/** 
	 * This attribute represents whether the primitive attribute coordN is null.
	 */
	protected boolean coordNNull = true;

	/** 
	 * This attribute maps to the column COORD_E in the SICEE_T_CERTIFICATO table.
	 */
	protected double coordE;

	/** 
	 * This attribute represents whether the primitive attribute coordE is null.
	 */
	protected boolean coordENull = true;

	/** 
	 * This attribute maps to the column FLG_NO_RACCOMAND in the SICEE_T_CERTIFICATO table.
	 */
	protected String flgNoRaccomand;

	/** 
	 * This attribute maps to the column RIF_CATASTO in the SICEE_T_CERTIFICATO table.
	 */
	protected String rifCatasto;

	/** 
	 * This attribute maps to the column CODICE_COMUNE_CATASTALE in the SICEE_T_CERTIFICATO table.
	 */
	protected String codiceComuneCatastale;

	/** 
	 * This attribute maps to the column FK_SCADENZA_CERT in the SICEE_T_CERTIFICATO table.
	 */
	protected Integer fkScadenzaCert;
	
	/** 
	 * This attribute maps to the column NUM_PIANI_FT_RISC in the SICEE_T_CERTIFICATO table.
	 */
	protected Integer numPianiFTRisc;

	/** 
	 * This attribute maps to the column CF_UTENTE_SOSTITUZIONE in the SICEE_T_CERTIFICATO table.
	 */
	protected String cfUtenteSostituzione;
	
	/**
	 * Method 'SiceeTCertificato'
	 * 
	 */
	public SiceeTCertificato()
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
	 * Method 'getFkTransazioneAce'
	 * 
	 * @return long
	 */
	public long getFkTransazioneAce()
	{
		return fkTransazioneAce;
	}

	/**
	 * Method 'setFkTransazioneAce'
	 * 
	 * @param fkTransazioneAce
	 */
	public void setFkTransazioneAce(long fkTransazioneAce)
	{
		this.fkTransazioneAce = fkTransazioneAce;
	}

	/**
	 * Method 'getDtAcquisto'
	 * 
	 * @return Date
	 */
	public Date getDtAcquisto()
	{
		return dtAcquisto;
	}

	/**
	 * Method 'setDtAcquisto'
	 * 
	 * @param dtAcquisto
	 */
	public void setDtAcquisto(Date dtAcquisto)
	{
		this.dtAcquisto = dtAcquisto;
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
	 * Method 'getFkDichiarazione'
	 * 
	 * @return Integer
	 */
	public Integer getFkDichiarazione()
	{
		return fkDichiarazione;
	}

	/**
	 * Method 'setFkDichiarazione'
	 * 
	 * @param fkDichiarazione
	 */
	public void setFkDichiarazione(Integer fkDichiarazione)
	{
		this.fkDichiarazione = fkDichiarazione;
	}

	/**
	 * Method 'getFlgDichiarazione'
	 * 
	 * @return String
	 */
	public String getFlgDichiarazione()
	{
		return flgDichiarazione;
	}

	/**
	 * Method 'setFlgDichiarazione'
	 * 
	 * @param flgDichiarazione
	 */
	public void setFlgDichiarazione(String flgDichiarazione)
	{
		this.flgDichiarazione = flgDichiarazione;
	}

	/**
	 * Method 'getIdIndirizzo'
	 * 
	 * @return Integer
	 */
	public Integer getIdIndirizzo()
	{
		return idIndirizzo;
	}

	/**
	 * Method 'setIdIndirizzo'
	 * 
	 * @param idIndirizzo
	 */
	public void setIdIndirizzo(Integer idIndirizzo)
	{
		this.idIndirizzo = idIndirizzo;
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
	 * Method 'getCap'
	 * 
	 * @return String
	 */
	public String getCap()
	{
		return cap;
	}

	/**
	 * Method 'setCap'
	 * 
	 * @param cap
	 */
	public void setCap(String cap)
	{
		this.cap = cap;
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
	 * Method 'getIdRegione'
	 * 
	 * @return String
	 */
	public String getIdRegione()
	{
		return idRegione;
	}

	/**
	 * Method 'setIdRegione'
	 * 
	 * @param idRegione
	 */
	public void setIdRegione(String idRegione)
	{
		this.idRegione = idRegione;
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
	 * Method 'getDescRegione'
	 * 
	 * @return String
	 */
	public String getDescRegione()
	{
		return descRegione;
	}

	/**
	 * Method 'setDescRegione'
	 * 
	 * @param descRegione
	 */
	public void setDescRegione(String descRegione)
	{
		this.descRegione = descRegione;
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
	 * Method 'getScala'
	 * 
	 * @return String
	 */
	public String getScala()
	{
		return scala;
	}

	/**
	 * Method 'setScala'
	 * 
	 * @param scala
	 */
	public void setScala(String scala)
	{
		this.scala = scala;
	}

	/**
	 * Method 'getInterno'
	 * 
	 * @return String
	 */
	public String getInterno()
	{
		return interno;
	}

	/**
	 * Method 'setInterno'
	 * 
	 * @param interno
	 */
	public void setInterno(String interno)
	{
		this.interno = interno;
	}

	/**
	 * Method 'getNote'
	 * 
	 * @return String
	 */
	public String getNote()
	{
		return note;
	}

	/**
	 * Method 'setNote'
	 * 
	 * @param note
	 */
	public void setNote(String note)
	{
		this.note = note;
	}

	/**
	 * Method 'getFlgStampaDef'
	 * 
	 * @return String
	 */
	public String getFlgStampaDef()
	{
		return flgStampaDef;
	}

	/**
	 * Method 'setFlgStampaDef'
	 * 
	 * @param flgStampaDef
	 */
	public void setFlgStampaDef(String flgStampaDef)
	{
		this.flgStampaDef = flgStampaDef;
	}

	/**
	 * Method 'getNomeAceFirmato'
	 * 
	 * @return String
	 */
	public String getNomeAceFirmato()
	{
		return nomeAceFirmato;
	}

	/**
	 * Method 'setNomeAceFirmato'
	 * 
	 * @param nomeAceFirmato
	 */
	public void setNomeAceFirmato(String nomeAceFirmato)
	{
		this.nomeAceFirmato = nomeAceFirmato;
	}

	/**
	 * Method 'getNomeCocertificatore'
	 * 
	 * @return String
	 */
	public String getNomeCocertificatore()
	{
		return nomeCocertificatore;
	}

	/**
	 * Method 'setNomeCocertificatore'
	 * 
	 * @param nomeCocertificatore
	 */
	public void setNomeCocertificatore(String nomeCocertificatore)
	{
		this.nomeCocertificatore = nomeCocertificatore;
	}

	/**
	 * Method 'getCognomeCocertificatore'
	 * 
	 * @return String
	 */
	public String getCognomeCocertificatore()
	{
		return cognomeCocertificatore;
	}

	/**
	 * Method 'setCognomeCocertificatore'
	 * 
	 * @param cognomeCocertificatore
	 */
	public void setCognomeCocertificatore(String cognomeCocertificatore)
	{
		this.cognomeCocertificatore = cognomeCocertificatore;
	}

	/**
	 * Method 'getNumCocertificatore'
	 * 
	 * @return String
	 */
	public String getNumCocertificatore()
	{
		return numCocertificatore;
	}

	/**
	 * Method 'setNumCocertificatore'
	 * 
	 * @param numCocertificatore
	 */
	public void setNumCocertificatore(String numCocertificatore)
	{
		this.numCocertificatore = numCocertificatore;
	}

	/**
	 * Method 'getCodFiscCocertificatore'
	 * 
	 * @return String
	 */
	public String getCodFiscCocertificatore()
	{
		return codFiscCocertificatore;
	}

	/**
	 * Method 'setCodFiscCocertificatore'
	 * 
	 * @param codFiscCocertificatore
	 */
	public void setCodFiscCocertificatore(String codFiscCocertificatore)
	{
		this.codFiscCocertificatore = codFiscCocertificatore;
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
	 * Method 'getIdentificPdf'
	 * 
	 * @return String
	 */
	public String getIdentificPdf()
	{
		return identificPdf;
	}

	/**
	 * Method 'setIdentificPdf'
	 * 
	 * @param identificPdf
	 */
	public void setIdentificPdf(String identificPdf)
	{
		this.identificPdf = identificPdf;
	}

	/**
	 * Method 'getIdentificFoto'
	 * 
	 * @return String
	 */
	public String getIdentificFoto()
	{
		return identificFoto;
	}

	/**
	 * Method 'setIdentificFoto'
	 * 
	 * @param identificFoto
	 */
	public void setIdentificFoto(String identificFoto)
	{
		this.identificFoto = identificFoto;
	}

	/**
	 * Method 'getLuogoDichiarazione'
	 * 
	 * @return String
	 */
	public String getLuogoDichiarazione()
	{
		return luogoDichiarazione;
	}

	/**
	 * Method 'setLuogoDichiarazione'
	 * 
	 * @param luogoDichiarazione
	 */
	public void setLuogoDichiarazione(String luogoDichiarazione)
	{
		this.luogoDichiarazione = luogoDichiarazione;
	}

	/**
	 * Method 'getNomeFoto'
	 * 
	 * @return String
	 */
	public String getNomeFoto()
	{
		return nomeFoto;
	}

	/**
	 * Method 'setNomeFoto'
	 * 
	 * @param nomeFoto
	 */
	public void setNomeFoto(String nomeFoto)
	{
		this.nomeFoto = nomeFoto;
	}

	/**
	 * Method 'getNomePdf'
	 * 
	 * @return String
	 */
	public String getNomePdf()
	{
		return nomePdf;
	}

	/**
	 * Method 'setNomePdf'
	 * 
	 * @param nomePdf
	 */
	public void setNomePdf(String nomePdf)
	{
		this.nomePdf = nomePdf;
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
	 * Method 'getFlgEdificioPerformante'
	 * 
	 * @return String
	 */
	public String getFlgEdificioPerformante()
	{
		return flgEdificioPerformante;
	}

	/**
	 * Method 'setFlgEdificioPerformante'
	 * 
	 * @param flgEdificioPerformante
	 */
	public void setFlgEdificioPerformante(String flgEdificioPerformante)
	{
		this.flgEdificioPerformante = flgEdificioPerformante;
	}

	/**
	 * Method 'getFlgSigmater'
	 * 
	 * @return String
	 */
	public String getFlgSigmater()
	{
		return flgSigmater;
	}

	/**
	 * Method 'setFlgSigmater'
	 * 
	 * @param flgSigmater
	 */
	public void setFlgSigmater(String flgSigmater)
	{
		this.flgSigmater = flgSigmater;
	}

	/**
	 * Method 'getFkMotivoSost'
	 * 
	 * @return Integer
	 */
	public Integer getFkMotivoSost()
	{
		return fkMotivoSost;
	}

	/**
	 * Method 'setFkMotivoSost'
	 * 
	 * @param fkMotivoSost
	 */
	public void setFkMotivoSost(Integer fkMotivoSost)
	{
		this.fkMotivoSost = fkMotivoSost;
	}

	/**
	 * Method 'getDtSostituzione'
	 * 
	 * @return Date
	 */
	public Date getDtSostituzione()
	{
		return dtSostituzione;
	}

	/**
	 * Method 'setDtSostituzione'
	 * 
	 * @param dtSostituzione
	 */
	public void setDtSostituzione(Date dtSostituzione)
	{
		this.dtSostituzione = dtSostituzione;
	}

	/**
	 * Method 'getNoteSostituzione'
	 * 
	 * @return String
	 */
	public String getNoteSostituzione()
	{
		return noteSostituzione;
	}

	/**
	 * Method 'setNoteSostituzione'
	 * 
	 * @param noteSostituzione
	 */
	public void setNoteSostituzione(String noteSostituzione)
	{
		this.noteSostituzione = noteSostituzione;
	}

	/**
	 * Method 'getDtFoto'
	 * 
	 * @return Date
	 */
	public Date getDtFoto()
	{
		return dtFoto;
	}

	/**
	 * Method 'setDtFoto'
	 * 
	 * @param dtFoto
	 */
	public void setDtFoto(Date dtFoto)
	{
		this.dtFoto = dtFoto;
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
	 * Method 'getCoordN'
	 * 
	 * @return double
	 */
	public double getCoordN()
	{
		return coordN;
	}

	/**
	 * Method 'setCoordN'
	 * 
	 * @param coordN
	 */
	public void setCoordN(double coordN)
	{
		this.coordN = coordN;
		this.coordNNull = false;
	}

	/**
	 * Method 'setCoordNNull'
	 * 
	 * @param value
	 */
	public void setCoordNNull(boolean value)
	{
		this.coordNNull = value;
	}

	/**
	 * Method 'isCoordNNull'
	 * 
	 * @return boolean
	 */
	public boolean isCoordNNull()
	{
		return coordNNull;
	}

	/**
	 * Method 'getCoordE'
	 * 
	 * @return double
	 */
	public double getCoordE()
	{
		return coordE;
	}

	/**
	 * Method 'setCoordE'
	 * 
	 * @param coordE
	 */
	public void setCoordE(double coordE)
	{
		this.coordE = coordE;
		this.coordENull = false;
	}

	/**
	 * Method 'setCoordENull'
	 * 
	 * @param value
	 */
	public void setCoordENull(boolean value)
	{
		this.coordENull = value;
	}

	/**
	 * Method 'isCoordENull'
	 * 
	 * @return boolean
	 */
	public boolean isCoordENull()
	{
		return coordENull;
	}

	/**
	 * Method 'getFlgNoRaccomand'
	 * 
	 * @return String
	 */
	public String getFlgNoRaccomand()
	{
		return flgNoRaccomand;
	}

	/**
	 * Method 'setFlgNoRaccomand'
	 * 
	 * @param flgNoRaccomand
	 */
	public void setFlgNoRaccomand(String flgNoRaccomand)
	{
		this.flgNoRaccomand = flgNoRaccomand;
	}

	/**
	 * Method 'getRifCatasto'
	 * 
	 * @return String
	 */
	public String getRifCatasto()
	{
		return rifCatasto;
	}

	/**
	 * Method 'setRifCatasto'
	 * 
	 * @param rifCatasto
	 */
	public void setRifCatasto(String rifCatasto)
	{
		this.rifCatasto = rifCatasto;
	}

	/**
	 * Method 'getCodiceComuneCatastale'
	 * 
	 * @return String
	 */
	public String getCodiceComuneCatastale()
	{
		return codiceComuneCatastale;
	}

	/**
	 * Method 'setCodiceComuneCatastale'
	 * 
	 * @param codiceComuneCatastale
	 */
	public void setCodiceComuneCatastale(String codiceComuneCatastale)
	{
		this.codiceComuneCatastale = codiceComuneCatastale;
	}

	/**
	 * Method 'getFkScadenzaCert'
	 * 
	 * @return Integer
	 */
	public Integer getFkScadenzaCert()
	{
		return fkScadenzaCert;
	}

	/**
	 * Method 'setFkScadenzaCert'
	 * 
	 * @param fkScadenzaCert
	 */
	public void setFkScadenzaCert(Integer fkScadenzaCert)
	{
		this.fkScadenzaCert = fkScadenzaCert;
	}

	/**
	 * Method 'getNumPianiFTRisc'
	 * 
	 * @return Integer
	 */
	public Integer getNumPianiFTRisc()
	{
		return numPianiFTRisc;
	}

	/**
	 * Method 'setNumPianiFTRisc'
	 * 
	 * @param numPianiFTRisc
	 */
	public void setNumPianiFTRisc(Integer numPianiFTRisc)
	{
		this.numPianiFTRisc = numPianiFTRisc;
	}

	/**
	 * Method 'getCfUtenteSostituzione'
	 * 
	 * @return String
	 */
	public String getCfUtenteSostituzione()
	{
		return cfUtenteSostituzione;
	}

	/**
	 * Method 'setCfUtenteSostituzione'
	 * 
	 * @param cfUtenteSostituzione
	 */
	public void setCfUtenteSostituzione(String cfUtenteSostituzione)
	{
		this.cfUtenteSostituzione = cfUtenteSostituzione;
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
		
		if (!(_other instanceof SiceeTCertificato)) {
			return false;
		}
		
		final SiceeTCertificato _cast = (SiceeTCertificato) _other;
		if (idCertificatore == null ? _cast.idCertificatore != idCertificatore : !idCertificatore.equals( _cast.idCertificatore )) {
			return false;
		}
		
		if (progrCertificato == null ? _cast.progrCertificato != progrCertificato : !progrCertificato.equals( _cast.progrCertificato )) {
			return false;
		}
		
		if (anno == null ? _cast.anno != anno : !anno.equals( _cast.anno )) {
			return false;
		}
		
		if (dtScadenza == null ? _cast.dtScadenza != dtScadenza : !dtScadenza.equals( _cast.dtScadenza )) {
			return false;
		}
		
		if (fkTransazioneAce != _cast.fkTransazioneAce) {
			return false;
		}
		
		if (dtAcquisto == null ? _cast.dtAcquisto != dtAcquisto : !dtAcquisto.equals( _cast.dtAcquisto )) {
			return false;
		}
		
		if (fkStato == null ? _cast.fkStato != fkStato : !fkStato.equals( _cast.fkStato )) {
			return false;
		}
		
		if (fkDichiarazione == null ? _cast.fkDichiarazione != fkDichiarazione : !fkDichiarazione.equals( _cast.fkDichiarazione )) {
			return false;
		}
		
		if (flgDichiarazione == null ? _cast.flgDichiarazione != flgDichiarazione : !flgDichiarazione.equals( _cast.flgDichiarazione )) {
			return false;
		}
		
		if (idIndirizzo == null ? _cast.idIndirizzo != idIndirizzo : !idIndirizzo.equals( _cast.idIndirizzo )) {
			return false;
		}
		
		if (descIndirizzo == null ? _cast.descIndirizzo != descIndirizzo : !descIndirizzo.equals( _cast.descIndirizzo )) {
			return false;
		}
		
		if (dtInizio == null ? _cast.dtInizio != dtInizio : !dtInizio.equals( _cast.dtInizio )) {
			return false;
		}
		
		if (cap == null ? _cast.cap != cap : !cap.equals( _cast.cap )) {
			return false;
		}
		
		if (idComune == null ? _cast.idComune != idComune : !idComune.equals( _cast.idComune )) {
			return false;
		}
		
		if (descComune == null ? _cast.descComune != descComune : !descComune.equals( _cast.descComune )) {
			return false;
		}
		
		if (sezione == null ? _cast.sezione != sezione : !sezione.equals( _cast.sezione )) {
			return false;
		}
		
		if (idProv == null ? _cast.idProv != idProv : !idProv.equals( _cast.idProv )) {
			return false;
		}
		
		if (foglio == null ? _cast.foglio != foglio : !foglio.equals( _cast.foglio )) {
			return false;
		}
		
		if (descProv == null ? _cast.descProv != descProv : !descProv.equals( _cast.descProv )) {
			return false;
		}
		
		if (idRegione == null ? _cast.idRegione != idRegione : !idRegione.equals( _cast.idRegione )) {
			return false;
		}
		
		if (particella == null ? _cast.particella != particella : !particella.equals( _cast.particella )) {
			return false;
		}
		
		if (subalterno == null ? _cast.subalterno != subalterno : !subalterno.equals( _cast.subalterno )) {
			return false;
		}
		
		if (descRegione == null ? _cast.descRegione != descRegione : !descRegione.equals( _cast.descRegione )) {
			return false;
		}
		
		if (piano == null ? _cast.piano != piano : !piano.equals( _cast.piano )) {
			return false;
		}
		
		if (numPianiComplessivi == null ? _cast.numPianiComplessivi != numPianiComplessivi : !numPianiComplessivi.equals( _cast.numPianiComplessivi )) {
			return false;
		}
		
		if (numAppartamenti == null ? _cast.numAppartamenti != numAppartamenti : !numAppartamenti.equals( _cast.numAppartamenti )) {
			return false;
		}
		
		if (scala == null ? _cast.scala != scala : !scala.equals( _cast.scala )) {
			return false;
		}
		
		if (interno == null ? _cast.interno != interno : !interno.equals( _cast.interno )) {
			return false;
		}
		
		if (note == null ? _cast.note != note : !note.equals( _cast.note )) {
			return false;
		}
		
		if (flgStampaDef == null ? _cast.flgStampaDef != flgStampaDef : !flgStampaDef.equals( _cast.flgStampaDef )) {
			return false;
		}
		
		if (nomeAceFirmato == null ? _cast.nomeAceFirmato != nomeAceFirmato : !nomeAceFirmato.equals( _cast.nomeAceFirmato )) {
			return false;
		}
		
		if (nomeCocertificatore == null ? _cast.nomeCocertificatore != nomeCocertificatore : !nomeCocertificatore.equals( _cast.nomeCocertificatore )) {
			return false;
		}
		
		if (cognomeCocertificatore == null ? _cast.cognomeCocertificatore != cognomeCocertificatore : !cognomeCocertificatore.equals( _cast.cognomeCocertificatore )) {
			return false;
		}
		
		if (numCocertificatore == null ? _cast.numCocertificatore != numCocertificatore : !numCocertificatore.equals( _cast.numCocertificatore )) {
			return false;
		}
		
		if (numCivico == null ? _cast.numCivico != numCivico : !numCivico.equals( _cast.numCivico )) {
			return false;
		}
		
		if (identificPdf == null ? _cast.identificPdf != identificPdf : !identificPdf.equals( _cast.identificPdf )) {
			return false;
		}
		
		if (identificFoto == null ? _cast.identificFoto != identificFoto : !identificFoto.equals( _cast.identificFoto )) {
			return false;
		}
		
		if (luogoDichiarazione == null ? _cast.luogoDichiarazione != luogoDichiarazione : !luogoDichiarazione.equals( _cast.luogoDichiarazione )) {
			return false;
		}
		
		if (nomeFoto == null ? _cast.nomeFoto != nomeFoto : !nomeFoto.equals( _cast.nomeFoto )) {
			return false;
		}
		
		if (nomePdf == null ? _cast.nomePdf != nomePdf : !nomePdf.equals( _cast.nomePdf )) {
			return false;
		}
		
		if (dtUpload == null ? _cast.dtUpload != dtUpload : !dtUpload.equals( _cast.dtUpload )) {
			return false;
		}
		
		if (flgEdificioPerformante == null ? _cast.flgEdificioPerformante != flgEdificioPerformante : !flgEdificioPerformante.equals( _cast.flgEdificioPerformante )) {
			return false;
		}
		
		if (flgSigmater == null ? _cast.flgSigmater != flgSigmater : !flgSigmater.equals( _cast.flgSigmater )) {
			return false;
		}
		
		if (fkMotivoSost == null ? _cast.fkMotivoSost != fkMotivoSost : !fkMotivoSost.equals( _cast.fkMotivoSost )) {
			return false;
		}
		
		if (dtSostituzione == null ? _cast.dtSostituzione != dtSostituzione : !dtSostituzione.equals( _cast.dtSostituzione )) {
			return false;
		}
		
		if (noteSostituzione == null ? _cast.noteSostituzione != noteSostituzione : !noteSostituzione.equals( _cast.noteSostituzione )) {
			return false;
		}
		
		if (dtFoto == null ? _cast.dtFoto != dtFoto : !dtFoto.equals( _cast.dtFoto )) {
			return false;
		}
		
		if (flgOld == null ? _cast.flgOld != flgOld : !flgOld.equals( _cast.flgOld )) {
			return false;
		}
		
		if (coordN != _cast.coordN) {
			return false;
		}
		
		if (coordNNull != _cast.coordNNull) {
			return false;
		}
		
		if (coordE != _cast.coordE) {
			return false;
		}
		
		if (coordENull != _cast.coordENull) {
			return false;
		}
		
		if (flgNoRaccomand == null ? _cast.flgNoRaccomand != flgNoRaccomand : !flgNoRaccomand.equals( _cast.flgNoRaccomand )) {
			return false;
		}
		
		if (rifCatasto == null ? _cast.rifCatasto != rifCatasto : !rifCatasto.equals( _cast.rifCatasto )) {
			return false;
		}
		
		if (codiceComuneCatastale == null ? _cast.codiceComuneCatastale != codiceComuneCatastale : !codiceComuneCatastale.equals( _cast.codiceComuneCatastale )) {
			return false;
		}
		
		if (numPianiFTRisc == null ? _cast.numPianiFTRisc != numPianiFTRisc : !numPianiFTRisc.equals( _cast.numPianiFTRisc )) {
			return false;
		}

		if (cfUtenteSostituzione == null ? _cast.cfUtenteSostituzione != cfUtenteSostituzione : !cfUtenteSostituzione.equals( _cast.cfUtenteSostituzione )) {
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
		
		if (dtScadenza != null) {
			_hashCode = 29 * _hashCode + dtScadenza.hashCode();
		}
		
		_hashCode = 29 * _hashCode + (int) (fkTransazioneAce ^ (fkTransazioneAce >>> 32));
		if (dtAcquisto != null) {
			_hashCode = 29 * _hashCode + dtAcquisto.hashCode();
		}
		
		if (fkStato != null) {
			_hashCode = 29 * _hashCode + fkStato.hashCode();
		}
		
		if (fkDichiarazione != null) {
			_hashCode = 29 * _hashCode + fkDichiarazione.hashCode();
		}
		
		if (flgDichiarazione != null) {
			_hashCode = 29 * _hashCode + flgDichiarazione.hashCode();
		}
		
		if (idIndirizzo != null) {
			_hashCode = 29 * _hashCode + idIndirizzo.hashCode();
		}
		
		if (descIndirizzo != null) {
			_hashCode = 29 * _hashCode + descIndirizzo.hashCode();
		}
		
		if (dtInizio != null) {
			_hashCode = 29 * _hashCode + dtInizio.hashCode();
		}
		
		if (cap != null) {
			_hashCode = 29 * _hashCode + cap.hashCode();
		}
		
		if (idComune != null) {
			_hashCode = 29 * _hashCode + idComune.hashCode();
		}
		
		if (descComune != null) {
			_hashCode = 29 * _hashCode + descComune.hashCode();
		}
		
		if (sezione != null) {
			_hashCode = 29 * _hashCode + sezione.hashCode();
		}
		
		if (idProv != null) {
			_hashCode = 29 * _hashCode + idProv.hashCode();
		}
		
		if (foglio != null) {
			_hashCode = 29 * _hashCode + foglio.hashCode();
		}
		
		if (descProv != null) {
			_hashCode = 29 * _hashCode + descProv.hashCode();
		}
		
		if (idRegione != null) {
			_hashCode = 29 * _hashCode + idRegione.hashCode();
		}
		
		if (particella != null) {
			_hashCode = 29 * _hashCode + particella.hashCode();
		}
		
		if (subalterno != null) {
			_hashCode = 29 * _hashCode + subalterno.hashCode();
		}
		
		if (descRegione != null) {
			_hashCode = 29 * _hashCode + descRegione.hashCode();
		}
		
		if (piano != null) {
			_hashCode = 29 * _hashCode + piano.hashCode();
		}
		
		if (numPianiComplessivi != null) {
			_hashCode = 29 * _hashCode + numPianiComplessivi.hashCode();
		}
		
		if (numAppartamenti != null) {
			_hashCode = 29 * _hashCode + numAppartamenti.hashCode();
		}
		
		if (scala != null) {
			_hashCode = 29 * _hashCode + scala.hashCode();
		}
		
		if (interno != null) {
			_hashCode = 29 * _hashCode + interno.hashCode();
		}
		
		if (note != null) {
			_hashCode = 29 * _hashCode + note.hashCode();
		}
		
		if (flgStampaDef != null) {
			_hashCode = 29 * _hashCode + flgStampaDef.hashCode();
		}
		
		if (nomeAceFirmato != null) {
			_hashCode = 29 * _hashCode + nomeAceFirmato.hashCode();
		}
		
		if (nomeCocertificatore != null) {
			_hashCode = 29 * _hashCode + nomeCocertificatore.hashCode();
		}
		
		if (cognomeCocertificatore != null) {
			_hashCode = 29 * _hashCode + cognomeCocertificatore.hashCode();
		}
		
		if (numCocertificatore != null) {
			_hashCode = 29 * _hashCode + numCocertificatore.hashCode();
		}
		
		if (numCivico != null) {
			_hashCode = 29 * _hashCode + numCivico.hashCode();
		}
		
		if (identificPdf != null) {
			_hashCode = 29 * _hashCode + identificPdf.hashCode();
		}
		
		if (identificFoto != null) {
			_hashCode = 29 * _hashCode + identificFoto.hashCode();
		}
		
		if (luogoDichiarazione != null) {
			_hashCode = 29 * _hashCode + luogoDichiarazione.hashCode();
		}
		
		if (nomeFoto != null) {
			_hashCode = 29 * _hashCode + nomeFoto.hashCode();
		}
		
		if (nomePdf != null) {
			_hashCode = 29 * _hashCode + nomePdf.hashCode();
		}
		
		if (dtUpload != null) {
			_hashCode = 29 * _hashCode + dtUpload.hashCode();
		}
		
		if (flgEdificioPerformante != null) {
			_hashCode = 29 * _hashCode + flgEdificioPerformante.hashCode();
		}
		
		if (flgSigmater != null) {
			_hashCode = 29 * _hashCode + flgSigmater.hashCode();
		}
		
		if (fkMotivoSost != null) {
			_hashCode = 29 * _hashCode + fkMotivoSost.hashCode();
		}
		
		if (dtSostituzione != null) {
			_hashCode = 29 * _hashCode + dtSostituzione.hashCode();
		}
		
		if (noteSostituzione != null) {
			_hashCode = 29 * _hashCode + noteSostituzione.hashCode();
		}
		
		if (dtFoto != null) {
			_hashCode = 29 * _hashCode + dtFoto.hashCode();
		}
		
		if (flgOld != null) {
			_hashCode = 29 * _hashCode + flgOld.hashCode();
		}
		
		long temp_coordN = Double.doubleToLongBits(coordN);
		_hashCode = 29 * _hashCode + (int) (temp_coordN ^ (temp_coordN >>> 32));
		_hashCode = 29 * _hashCode + (coordNNull ? 1 : 0);
		long temp_coordE = Double.doubleToLongBits(coordE);
		_hashCode = 29 * _hashCode + (int) (temp_coordE ^ (temp_coordE >>> 32));
		_hashCode = 29 * _hashCode + (coordENull ? 1 : 0);
		if (flgNoRaccomand != null) {
			_hashCode = 29 * _hashCode + flgNoRaccomand.hashCode();
		}
		
		if (rifCatasto != null) {
			_hashCode = 29 * _hashCode + rifCatasto.hashCode();
		}
		
		if (codiceComuneCatastale != null) {
			_hashCode = 29 * _hashCode + codiceComuneCatastale.hashCode();
		}
		
		if (numPianiFTRisc != null) {
			_hashCode = 29 * _hashCode + numPianiFTRisc.hashCode();
		}

		if (cfUtenteSostituzione != null) {
			_hashCode = 29 * _hashCode + cfUtenteSostituzione.hashCode();
		}
		
		return _hashCode;
	}

	/**
	 * Method 'createPk'
	 * 
	 * @return SiceeTCertificatoPk
	 */
	public SiceeTCertificatoPk createPk()
	{
		return new SiceeTCertificatoPk(idCertificatore, progrCertificato, anno);
	}

	/**
	 * Method 'toString'
	 * 
	 * @return String
	 */
	public String toString()
	{
		StringBuffer ret = new StringBuffer();
		ret.append( "it.csi.sicee.siceeweb.business.dao.dto.SiceeTCertificato: " );
		ret.append( "idCertificatore=" + idCertificatore );
		ret.append( ", progrCertificato=" + progrCertificato );
		ret.append( ", anno=" + anno );
		ret.append( ", dtScadenza=" + dtScadenza );
		ret.append( ", fkTransazioneAce=" + fkTransazioneAce );
		ret.append( ", dtAcquisto=" + dtAcquisto );
		ret.append( ", fkStato=" + fkStato );
		ret.append( ", fkDichiarazione=" + fkDichiarazione );
		ret.append( ", flgDichiarazione=" + flgDichiarazione );
		ret.append( ", idIndirizzo=" + idIndirizzo );
		ret.append( ", descIndirizzo=" + descIndirizzo );
		ret.append( ", dtInizio=" + dtInizio );
		ret.append( ", cap=" + cap );
		ret.append( ", idComune=" + idComune );
		ret.append( ", descComune=" + descComune );
		ret.append( ", sezione=" + sezione );
		ret.append( ", idProv=" + idProv );
		ret.append( ", foglio=" + foglio );
		ret.append( ", descProv=" + descProv );
		ret.append( ", idRegione=" + idRegione );
		ret.append( ", particella=" + particella );
		ret.append( ", subalterno=" + subalterno );
		ret.append( ", descRegione=" + descRegione );
		ret.append( ", piano=" + piano );
		ret.append( ", numPianiComplessivi=" + numPianiComplessivi );
		ret.append( ", numAppartamenti=" + numAppartamenti );
		ret.append( ", scala=" + scala );
		ret.append( ", interno=" + interno );
		ret.append( ", note=" + note );
		ret.append( ", flgStampaDef=" + flgStampaDef );
		ret.append( ", nomeAceFirmato=" + nomeAceFirmato );
		ret.append( ", nomeCocertificatore=" + nomeCocertificatore );
		ret.append( ", cognomeCocertificatore=" + cognomeCocertificatore );
		ret.append( ", numCocertificatore=" + numCocertificatore );
		ret.append( ", numCivico=" + numCivico );
		ret.append( ", identificPdf=" + identificPdf );
		ret.append( ", identificFoto=" + identificFoto );
		ret.append( ", luogoDichiarazione=" + luogoDichiarazione );
		ret.append( ", nomeFoto=" + nomeFoto );
		ret.append( ", nomePdf=" + nomePdf );
		ret.append( ", dtUpload=" + dtUpload );
		ret.append( ", flgEdificioPerformante=" + flgEdificioPerformante );
		ret.append( ", flgSigmater=" + flgSigmater );
		ret.append( ", fkMotivoSost=" + fkMotivoSost );
		ret.append( ", dtSostituzione=" + dtSostituzione );
		ret.append( ", noteSostituzione=" + noteSostituzione );
		ret.append( ", dtFoto=" + dtFoto );
		ret.append( ", flgOld=" + flgOld );
		ret.append( ", coordN=" + coordN );
		ret.append( ", coordE=" + coordE );
		ret.append( ", flgNoRaccomand=" + flgNoRaccomand );
		ret.append( ", rifCatasto=" + rifCatasto );
		ret.append( ", codiceComuneCatastale=" + codiceComuneCatastale );
		ret.append( ", numPianiFTRisc=" + numPianiFTRisc );
		ret.append( ", cfUtenteSostituzione=" + cfUtenteSostituzione );
		return ret.toString();
	}

}
