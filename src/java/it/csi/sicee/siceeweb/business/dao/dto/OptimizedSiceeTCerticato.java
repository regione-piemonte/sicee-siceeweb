/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceeweb.business.dao.dto;

import java.io.Serializable;

public class OptimizedSiceeTCerticato implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -9087061665468205280L;

	protected java.lang.String idCertificatore;

	protected java.lang.String progrCertificato;

	protected java.lang.String anno;

	protected java.util.Date dtScadenza;

	protected long fkTransazioneAce;

	/** 
	 * This attribute represents whether the primitive attribute fkTransazioneAce is null.
	 */
	protected boolean fkTransazioneAceNull = true;

	protected java.util.Date dtAcquisto;

	protected java.lang.Integer fkStato;

	protected java.lang.Integer fkDichiarazione;

	protected java.lang.String flgDichiarazione;

	protected java.lang.Integer idIndirizzo;

	protected java.lang.String descIndirizzo;

	protected java.util.Date dtInizio;

	protected java.lang.String cap;

	protected java.lang.String idComune;

	protected java.lang.String descComune;

	protected java.lang.String sezione;

	protected java.lang.String idProv;

	protected java.lang.String foglio;

	protected java.lang.String descProv;

	protected java.lang.String idRegione;

	protected java.lang.String particella;

	protected java.lang.String subalterno;

	protected java.lang.String descRegione;

	protected java.lang.Integer piano;

	protected java.lang.Integer numPianiComplessivi;

	protected java.lang.Integer numAppartamenti;

	protected java.lang.String scala;

	protected java.lang.String interno;

	protected java.lang.String note;

	protected java.lang.String flgStampaDef;

	protected java.lang.String nomeAceFirmato;

	protected java.lang.String nomeCocertificatore;

	protected java.lang.String cognomeCocertificatore;

	protected java.lang.String numCocertificatore;

	protected java.lang.String numCivico;

	protected java.lang.String identificPdf;

	protected java.lang.String identificFoto;

	protected java.lang.String luogoDichiarazione;

	protected java.lang.String nomeFoto;

	protected java.lang.String nomePdf;

	protected java.util.Date dtUpload;

	protected java.lang.String descStato;
	
	protected java.lang.String numCertificatore;

	public java.lang.String getNumCertificatore() {
		return this.numCertificatore;
	}

	public void setNumCertificatore(java.lang.String numCertificatore) {
		this.numCertificatore = numCertificatore;
	}

	/**
	 * Method 'OptimizedSiceeTCerticato'
	 * 
	 */
	public OptimizedSiceeTCerticato()
	{
	}

	/**
	 * Method 'getIdCertificatore'
	 * 
	 * @return java.lang.String
	 */
	public java.lang.String getIdCertificatore()
	{
		return this.idCertificatore;
	}

	/**
	 * Method 'setIdCertificatore'
	 * 
	 * @param idCertificatore
	 */
	public void setIdCertificatore(java.lang.String idCertificatore)
	{
		this.idCertificatore = idCertificatore;
	}

	/**
	 * Method 'getProgrCertificato'
	 * 
	 * @return java.lang.String
	 */
	public java.lang.String getProgrCertificato()
	{
		return this.progrCertificato;
	}

	/**
	 * Method 'setProgrCertificato'
	 * 
	 * @param progrCertificato
	 */
	public void setProgrCertificato(java.lang.String progrCertificato)
	{
		this.progrCertificato = progrCertificato;
	}

	/**
	 * Method 'getAnno'
	 * 
	 * @return java.lang.String
	 */
	public java.lang.String getAnno()
	{
		return this.anno;
	}

	/**
	 * Method 'setAnno'
	 * 
	 * @param anno
	 */
	public void setAnno(java.lang.String anno)
	{
		this.anno = anno;
	}

	/**
	 * Method 'getDtScadenza'
	 * 
	 * @return java.util.Date
	 */
	public java.util.Date getDtScadenza()
	{
		return this.dtScadenza;
	}

	/**
	 * Method 'setDtScadenza'
	 * 
	 * @param dtScadenza
	 */
	public void setDtScadenza(java.util.Date dtScadenza)
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
		return this.fkTransazioneAce;
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
	 * Sets the value of fkTransazioneAceNull
	 */
	public void setFkTransazioneAceNull(boolean fkTransazioneAceNull)
	{
		this.fkTransazioneAceNull = fkTransazioneAceNull;
	}

	/** 
	 * Gets the value of fkTransazioneAceNull
	 */
	public boolean isFkTransazioneAceNull()
	{
		return this.fkTransazioneAceNull;
	}

	/**
	 * Method 'getDtAcquisto'
	 * 
	 * @return java.util.Date
	 */
	public java.util.Date getDtAcquisto()
	{
		return this.dtAcquisto;
	}

	/**
	 * Method 'setDtAcquisto'
	 * 
	 * @param dtAcquisto
	 */
	public void setDtAcquisto(java.util.Date dtAcquisto)
	{
		this.dtAcquisto = dtAcquisto;
	}

	/**
	 * Method 'getFkStato'
	 * 
	 * @return java.lang.Integer
	 */
	public java.lang.Integer getFkStato()
	{
		return this.fkStato;
	}

	/**
	 * Method 'setFkStato'
	 * 
	 * @param fkStato
	 */
	public void setFkStato(java.lang.Integer fkStato)
	{
		this.fkStato = fkStato;
	}

	/**
	 * Method 'getFkDichiarazione'
	 * 
	 * @return java.lang.Integer
	 */
	public java.lang.Integer getFkDichiarazione()
	{
		return this.fkDichiarazione;
	}

	/**
	 * Method 'setFkDichiarazione'
	 * 
	 * @param fkDichiarazione
	 */
	public void setFkDichiarazione(java.lang.Integer fkDichiarazione)
	{
		this.fkDichiarazione = fkDichiarazione;
	}

	/**
	 * Method 'getFlgDichiarazione'
	 * 
	 * @return java.lang.String
	 */
	public java.lang.String getFlgDichiarazione()
	{
		return this.flgDichiarazione;
	}

	/**
	 * Method 'setFlgDichiarazione'
	 * 
	 * @param flgDichiarazione
	 */
	public void setFlgDichiarazione(java.lang.String flgDichiarazione)
	{
		this.flgDichiarazione = flgDichiarazione;
	}

	/**
	 * Method 'getIdIndirizzo'
	 * 
	 * @return java.lang.Integer
	 */
	public java.lang.Integer getIdIndirizzo()
	{
		return this.idIndirizzo;
	}

	/**
	 * Method 'setIdIndirizzo'
	 * 
	 * @param idIndirizzo
	 */
	public void setIdIndirizzo(java.lang.Integer idIndirizzo)
	{
		this.idIndirizzo = idIndirizzo;
	}

	/**
	 * Method 'getDescIndirizzo'
	 * 
	 * @return java.lang.String
	 */
	public java.lang.String getDescIndirizzo()
	{
		return this.descIndirizzo;
	}

	/**
	 * Method 'setDescIndirizzo'
	 * 
	 * @param descIndirizzo
	 */
	public void setDescIndirizzo(java.lang.String descIndirizzo)
	{
		this.descIndirizzo = descIndirizzo;
	}

	/**
	 * Method 'getDtInizio'
	 * 
	 * @return java.util.Date
	 */
	public java.util.Date getDtInizio()
	{
		return this.dtInizio;
	}

	/**
	 * Method 'setDtInizio'
	 * 
	 * @param dtInizio
	 */
	public void setDtInizio(java.util.Date dtInizio)
	{
		this.dtInizio = dtInizio;
	}

	/**
	 * Method 'getCap'
	 * 
	 * @return java.lang.String
	 */
	public java.lang.String getCap()
	{
		return this.cap;
	}

	/**
	 * Method 'setCap'
	 * 
	 * @param cap
	 */
	public void setCap(java.lang.String cap)
	{
		this.cap = cap;
	}

	/**
	 * Method 'getIdComune'
	 * 
	 * @return java.lang.String
	 */
	public java.lang.String getIdComune()
	{
		return this.idComune;
	}

	/**
	 * Method 'setIdComune'
	 * 
	 * @param idComune
	 */
	public void setIdComune(java.lang.String idComune)
	{
		this.idComune = idComune;
	}

	/**
	 * Method 'getDescComune'
	 * 
	 * @return java.lang.String
	 */
	public java.lang.String getDescComune()
	{
		return this.descComune;
	}

	/**
	 * Method 'setDescComune'
	 * 
	 * @param descComune
	 */
	public void setDescComune(java.lang.String descComune)
	{
		this.descComune = descComune;
	}

	/**
	 * Method 'getSezione'
	 * 
	 * @return java.lang.String
	 */
	public java.lang.String getSezione()
	{
		return this.sezione;
	}

	/**
	 * Method 'setSezione'
	 * 
	 * @param sezione
	 */
	public void setSezione(java.lang.String sezione)
	{
		this.sezione = sezione;
	}

	/**
	 * Method 'getIdProv'
	 * 
	 * @return java.lang.String
	 */
	public java.lang.String getIdProv()
	{
		return this.idProv;
	}

	/**
	 * Method 'setIdProv'
	 * 
	 * @param idProv
	 */
	public void setIdProv(java.lang.String idProv)
	{
		this.idProv = idProv;
	}

	/**
	 * Method 'getFoglio'
	 * 
	 * @return java.lang.String
	 */
	public java.lang.String getFoglio()
	{
		return this.foglio;
	}

	/**
	 * Method 'setFoglio'
	 * 
	 * @param foglio
	 */
	public void setFoglio(java.lang.String foglio)
	{
		this.foglio = foglio;
	}

	/**
	 * Method 'getDescProv'
	 * 
	 * @return java.lang.String
	 */
	public java.lang.String getDescProv()
	{
		return this.descProv;
	}

	/**
	 * Method 'setDescProv'
	 * 
	 * @param descProv
	 */
	public void setDescProv(java.lang.String descProv)
	{
		this.descProv = descProv;
	}

	/**
	 * Method 'getIdRegione'
	 * 
	 * @return java.lang.String
	 */
	public java.lang.String getIdRegione()
	{
		return this.idRegione;
	}

	/**
	 * Method 'setIdRegione'
	 * 
	 * @param idRegione
	 */
	public void setIdRegione(java.lang.String idRegione)
	{
		this.idRegione = idRegione;
	}

	/**
	 * Method 'getParticella'
	 * 
	 * @return java.lang.String
	 */
	public java.lang.String getParticella()
	{
		return this.particella;
	}

	/**
	 * Method 'setParticella'
	 * 
	 * @param particella
	 */
	public void setParticella(java.lang.String particella)
	{
		this.particella = particella;
	}

	/**
	 * Method 'getSubalterno'
	 * 
	 * @return java.lang.String
	 */
	public java.lang.String getSubalterno()
	{
		return this.subalterno;
	}

	/**
	 * Method 'setSubalterno'
	 * 
	 * @param subalterno
	 */
	public void setSubalterno(java.lang.String subalterno)
	{
		this.subalterno = subalterno;
	}

	/**
	 * Method 'getDescRegione'
	 * 
	 * @return java.lang.String
	 */
	public java.lang.String getDescRegione()
	{
		return this.descRegione;
	}

	/**
	 * Method 'setDescRegione'
	 * 
	 * @param descRegione
	 */
	public void setDescRegione(java.lang.String descRegione)
	{
		this.descRegione = descRegione;
	}

	/**
	 * Method 'getPiano'
	 * 
	 * @return java.lang.Integer
	 */
	public java.lang.Integer getPiano()
	{
		return this.piano;
	}

	/**
	 * Method 'setPiano'
	 * 
	 * @param piano
	 */
	public void setPiano(java.lang.Integer piano)
	{
		this.piano = piano;
	}

	/**
	 * Method 'getNumPianiComplessivi'
	 * 
	 * @return java.lang.Integer
	 */
	public java.lang.Integer getNumPianiComplessivi()
	{
		return this.numPianiComplessivi;
	}

	/**
	 * Method 'setNumPianiComplessivi'
	 * 
	 * @param numPianiComplessivi
	 */
	public void setNumPianiComplessivi(java.lang.Integer numPianiComplessivi)
	{
		this.numPianiComplessivi = numPianiComplessivi;
	}

	/**
	 * Method 'getNumAppartamenti'
	 * 
	 * @return java.lang.Integer
	 */
	public java.lang.Integer getNumAppartamenti()
	{
		return this.numAppartamenti;
	}

	/**
	 * Method 'setNumAppartamenti'
	 * 
	 * @param numAppartamenti
	 */
	public void setNumAppartamenti(java.lang.Integer numAppartamenti)
	{
		this.numAppartamenti = numAppartamenti;
	}

	/**
	 * Method 'getScala'
	 * 
	 * @return java.lang.String
	 */
	public java.lang.String getScala()
	{
		return this.scala;
	}

	/**
	 * Method 'setScala'
	 * 
	 * @param scala
	 */
	public void setScala(java.lang.String scala)
	{
		this.scala = scala;
	}

	/**
	 * Method 'getInterno'
	 * 
	 * @return java.lang.String
	 */
	public java.lang.String getInterno()
	{
		return this.interno;
	}

	/**
	 * Method 'setInterno'
	 * 
	 * @param interno
	 */
	public void setInterno(java.lang.String interno)
	{
		this.interno = interno;
	}

	/**
	 * Method 'getNote'
	 * 
	 * @return java.lang.String
	 */
	public java.lang.String getNote()
	{
		return this.note;
	}

	/**
	 * Method 'setNote'
	 * 
	 * @param note
	 */
	public void setNote(java.lang.String note)
	{
		this.note = note;
	}

	/**
	 * Method 'getFlgStampaDef'
	 * 
	 * @return java.lang.String
	 */
	public java.lang.String getFlgStampaDef()
	{
		return this.flgStampaDef;
	}

	/**
	 * Method 'setFlgStampaDef'
	 * 
	 * @param flgStampaDef
	 */
	public void setFlgStampaDef(java.lang.String flgStampaDef)
	{
		this.flgStampaDef = flgStampaDef;
	}

	/**
	 * Method 'getNomeAceFirmato'
	 * 
	 * @return java.lang.String
	 */
	public java.lang.String getNomeAceFirmato()
	{
		return this.nomeAceFirmato;
	}

	/**
	 * Method 'setNomeAceFirmato'
	 * 
	 * @param nomeAceFirmato
	 */
	public void setNomeAceFirmato(java.lang.String nomeAceFirmato)
	{
		this.nomeAceFirmato = nomeAceFirmato;
	}

	/**
	 * Method 'getNomeCocertificatore'
	 * 
	 * @return java.lang.String
	 */
	public java.lang.String getNomeCocertificatore()
	{
		return this.nomeCocertificatore;
	}

	/**
	 * Method 'setNomeCocertificatore'
	 * 
	 * @param nomeCocertificatore
	 */
	public void setNomeCocertificatore(java.lang.String nomeCocertificatore)
	{
		this.nomeCocertificatore = nomeCocertificatore;
	}

	/**
	 * Method 'getCognomeCocertificatore'
	 * 
	 * @return java.lang.String
	 */
	public java.lang.String getCognomeCocertificatore()
	{
		return this.cognomeCocertificatore;
	}

	/**
	 * Method 'setCognomeCocertificatore'
	 * 
	 * @param cognomeCocertificatore
	 */
	public void setCognomeCocertificatore(java.lang.String cognomeCocertificatore)
	{
		this.cognomeCocertificatore = cognomeCocertificatore;
	}

	/**
	 * Method 'getNumCocertificatore'
	 * 
	 * @return java.lang.String
	 */
	public java.lang.String getNumCocertificatore()
	{
		return this.numCocertificatore;
	}

	/**
	 * Method 'setNumCocertificatore'
	 * 
	 * @param numCocertificatore
	 */
	public void setNumCocertificatore(java.lang.String numCocertificatore)
	{
		this.numCocertificatore = numCocertificatore;
	}

	/**
	 * Method 'getNumCivico'
	 * 
	 * @return java.lang.String
	 */
	public java.lang.String getNumCivico()
	{
		return this.numCivico;
	}

	/**
	 * Method 'setNumCivico'
	 * 
	 * @param numCivico
	 */
	public void setNumCivico(java.lang.String numCivico)
	{
		this.numCivico = numCivico;
	}

	/**
	 * Method 'getIdentificPdf'
	 * 
	 * @return java.lang.String
	 */
	public java.lang.String getIdentificPdf()
	{
		return this.identificPdf;
	}

	/**
	 * Method 'setIdentificPdf'
	 * 
	 * @param identificPdf
	 */
	public void setIdentificPdf(java.lang.String identificPdf)
	{
		this.identificPdf = identificPdf;
	}

	/**
	 * Method 'getIdentificFoto'
	 * 
	 * @return java.lang.String
	 */
	public java.lang.String getIdentificFoto()
	{
		return this.identificFoto;
	}

	/**
	 * Method 'setIdentificFoto'
	 * 
	 * @param identificFoto
	 */
	public void setIdentificFoto(java.lang.String identificFoto)
	{
		this.identificFoto = identificFoto;
	}

	/**
	 * Method 'getLuogoDichiarazione'
	 * 
	 * @return java.lang.String
	 */
	public java.lang.String getLuogoDichiarazione()
	{
		return this.luogoDichiarazione;
	}

	/**
	 * Method 'setLuogoDichiarazione'
	 * 
	 * @param luogoDichiarazione
	 */
	public void setLuogoDichiarazione(java.lang.String luogoDichiarazione)
	{
		this.luogoDichiarazione = luogoDichiarazione;
	}

	/**
	 * Method 'getNomeFoto'
	 * 
	 * @return java.lang.String
	 */
	public java.lang.String getNomeFoto()
	{
		return this.nomeFoto;
	}

	/**
	 * Method 'setNomeFoto'
	 * 
	 * @param nomeFoto
	 */
	public void setNomeFoto(java.lang.String nomeFoto)
	{
		this.nomeFoto = nomeFoto;
	}

	/**
	 * Method 'getNomePdf'
	 * 
	 * @return java.lang.String
	 */
	public java.lang.String getNomePdf()
	{
		return this.nomePdf;
	}

	/**
	 * Method 'setNomePdf'
	 * 
	 * @param nomePdf
	 */
	public void setNomePdf(java.lang.String nomePdf)
	{
		this.nomePdf = nomePdf;
	}

	/**
	 * Method 'getDtUpload'
	 * 
	 * @return java.util.Date
	 */
	public java.util.Date getDtUpload()
	{
		return this.dtUpload;
	}

	/**
	 * Method 'setDtUpload'
	 * 
	 * @param dtUpload
	 */
	public void setDtUpload(java.util.Date dtUpload)
	{
		this.dtUpload = dtUpload;
	}

	/**
	 * Method 'getDescStato'
	 * 
	 * @return java.lang.String
	 */
	public java.lang.String getDescStato()
	{
		return this.descStato;
	}

	/**
	 * Method 'setDescStato'
	 * 
	 * @param descStato
	 */
	public void setDescStato(java.lang.String descStato)
	{
		this.descStato = descStato;
	}

	/**
	 * Method 'toString'
	 * 
	 * @return String
	 */
	@Override
	public String toString()
	{
		StringBuffer ret = new StringBuffer();
		ret.append( "it.csi.sicee.siceeweb.business.dao.dto.OptimizedSiceeTCerticato: " );
		ret.append( "idCertificatore=" + this.idCertificatore );
		ret.append( ", progrCertificato=" + this.progrCertificato );
		ret.append( ", anno=" + this.anno );
		ret.append( ", dtScadenza=" + this.dtScadenza );
		ret.append( ", fkTransazioneAce=" + this.fkTransazioneAce );
		ret.append( ", dtAcquisto=" + this.dtAcquisto );
		ret.append( ", fkStato=" + this.fkStato );
		ret.append( ", fkDichiarazione=" + this.fkDichiarazione );
		ret.append( ", flgDichiarazione=" + this.flgDichiarazione );
		ret.append( ", idIndirizzo=" + this.idIndirizzo );
		ret.append( ", descIndirizzo=" + this.descIndirizzo );
		ret.append( ", dtInizio=" + this.dtInizio );
		ret.append( ", cap=" + this.cap );
		ret.append( ", idComune=" + this.idComune );
		ret.append( ", descComune=" + this.descComune );
		ret.append( ", sezione=" + this.sezione );
		ret.append( ", idProv=" + this.idProv );
		ret.append( ", foglio=" + this.foglio );
		ret.append( ", descProv=" + this.descProv );
		ret.append( ", idRegione=" + this.idRegione );
		ret.append( ", particella=" + this.particella );
		ret.append( ", subalterno=" + this.subalterno );
		ret.append( ", descRegione=" + this.descRegione );
		ret.append( ", piano=" + this.piano );
		ret.append( ", numPianiComplessivi=" + this.numPianiComplessivi );
		ret.append( ", numAppartamenti=" + this.numAppartamenti );
		ret.append( ", scala=" + this.scala );
		ret.append( ", interno=" + this.interno );
		ret.append( ", note=" + this.note );
		ret.append( ", flgStampaDef=" + this.flgStampaDef );
		ret.append( ", nomeAceFirmato=" + this.nomeAceFirmato );
		ret.append( ", nomeCocertificatore=" + this.nomeCocertificatore );
		ret.append( ", cognomeCocertificatore=" + this.cognomeCocertificatore );
		ret.append( ", numCocertificatore=" + this.numCocertificatore );
		ret.append( ", numCivico=" + this.numCivico );
		ret.append( ", identificPdf=" + this.identificPdf );
		ret.append( ", identificFoto=" + this.identificFoto );
		ret.append( ", luogoDichiarazione=" + this.luogoDichiarazione );
		ret.append( ", nomeFoto=" + this.nomeFoto );
		ret.append( ", nomePdf=" + this.nomePdf );
		ret.append( ", dtUpload=" + this.dtUpload );
		ret.append( ", descStato=" + this.descStato );
		return ret.toString();
	}

}
