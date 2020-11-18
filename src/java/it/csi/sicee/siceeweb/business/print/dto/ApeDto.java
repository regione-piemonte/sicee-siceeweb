/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceeweb.business.print.dto;

import java.io.Serializable;
import java.util.Date;

public class ApeDto implements Serializable{
	
	// certificato
	protected Integer fkStato;
	protected String anno;
	protected String idCertificatoreCertificato;
	protected String progrCertificato;
	protected Date dtScadenza;
	protected String descRegione;
	protected String descComune;
	protected String descIndirizzoCertificato;
	protected String numCivico;
	protected Integer piano;
	protected String interno;
	protected double coordN;
	protected double coordE;
	protected Date dtInizio;
	protected String codiceComuneCatastale;
	protected String foglio;
	protected String sezione;
	protected String particella;
	protected String subalterno;
	protected String descDichIndipendenza;
	
	protected boolean isBozzaDaXml;

	// certificatore
	protected String numCertificatore;
	protected String cognomeRagSociale;
	protected String cognome;
	protected String nome;
	protected String dTitolo;
	protected String iscrittoOrdine;
	protected String descIndirizzoCertificatore;
	protected String numCivicoResidenza;
	protected String descComuneResidenza;
	protected String descProvResidenza;
	protected String email;
	protected String telefono;

	// dati generali
	protected Integer annoCostruzione;
	protected String zonaClimatica;
	protected String oggetto;

	// altre info
	protected String motivazione;
	protected String descrizioneAltraMotivazione;
	protected String flagServizioEnergia;

	// certificato
	public Integer getFkStato() {
		return fkStato;
	}
	public void setFkStato(Integer fkStato) {
		this.fkStato = fkStato;
	}

	public String getAnno() {
		return anno;
	}
	public void setAnno(String anno) {
		this.anno = anno;
	}

	public String getIdCertificatoreCertificato() {
		return idCertificatoreCertificato;
	}
	public void setIdCertificatoreCertificato(String idCertificatoreCertificato) {
		this.idCertificatoreCertificato = idCertificatoreCertificato;
	}

	public String getProgrCertificato() {
		return progrCertificato;
	}
	public void setProgrCertificato(String progrCertificato) {
		this.progrCertificato = progrCertificato;
	}

	public Date getDtScadenza() {
		return dtScadenza;
	}
	public void setDtScadenza(Date dtScadenza) {
		this.dtScadenza = dtScadenza;
	}

	public String getDescRegione() {
		return descRegione;
	}
	public void setDescRegione(String descRegione) {
		this.descRegione = descRegione;
	}

	public String getDescComune() {
		return descComune;
	}
	public void setDescComune(String descComune) {
		this.descComune = descComune;
	}

	public String getDescIndirizzoCertificato() {
		return descIndirizzoCertificato;
	}
	public void setDescIndirizzoCertificato(String descIndirizzoCertificato) {
		this.descIndirizzoCertificato = descIndirizzoCertificato;
	}

	public String getNumCivico() {
		return numCivico;
	}
	public void setNumCivico(String numCivico) {
		this.numCivico = numCivico;
	}

	public Integer getPiano() {
		return piano;
	}
	public void setPiano(Integer piano) {
		this.piano = piano;
	}

	public String getInterno() {
		return interno;
	}
	public void setInterno(String interno) {
		this.interno = interno;
	}

	public double getCoordN() {
		return coordN;
	}
	public void setCoordN(double coordN) {
		this.coordN = coordN;
	}
	public double getCoordE() {
		return coordE;
	}
	public void setCoordE(double coordE) {
		this.coordE = coordE;
	}
	
	
	public Date getDtInizio() {
		return dtInizio;
	}
	public void setDtInizio(Date dtInizio) {
		this.dtInizio = dtInizio;
	}

	public String getCodiceComuneCatastale() {
		return codiceComuneCatastale;
	}
	public void setCodiceComuneCatastale(String codiceComuneCatastale) {
		this.codiceComuneCatastale = codiceComuneCatastale;
	}

	public String getFoglio() {
		return foglio;
	}
	public void setFoglio(String foglio) {
		this.foglio = foglio;
	}

	public String getSezione() {
		return sezione;
	}
	public void setSezione(String sezione) {
		this.sezione = sezione;
	}

	public String getParticella() {
		return particella;
	}
	public void setParticella(String particella) {
		this.particella = particella;
	}

	public String getSubalterno() {
		return subalterno;
	}
	public void setSubalterno(String subalterno) {
		this.subalterno = subalterno;
	}
	
	public String getDescDichIndipendenza() {
		return descDichIndipendenza;
	}
	public void setDescDichIndipendenza(String descDichIndipendenza) {
		this.descDichIndipendenza = descDichIndipendenza;
	}
	public boolean getIsBozzaDaXml() {
		return isBozzaDaXml;
	}
	public void setIsBozzaDaXml(boolean isBozzaDaXml) {
		this.isBozzaDaXml = isBozzaDaXml;
	}

	// certificatore
	public String getNumCertificatore() {
		return numCertificatore;
	}
	public void setNumCertificatore(String numCertificatore) {
		this.numCertificatore = numCertificatore;
	}

	public String getCognome() {
		return cognome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getCognomeRagSociale() {
		return cognomeRagSociale;
	}
	public void setCognomeRagSociale(String cognomeRagSociale) {
		this.cognomeRagSociale = cognomeRagSociale;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getIscrittoOrdine() {
		return iscrittoOrdine;
	}
	public void setIscrittoOrdine(String iscrittoOrdine) {
		this.iscrittoOrdine = iscrittoOrdine;
	}

	public String getDTitolo() {
		return dTitolo;
	}
	public void setDTitolo(String dTitolo) {
		this.dTitolo = dTitolo;
	}

	public String getDescIndirizzoCertificatore() {
		return descIndirizzoCertificatore;
	}
	public void setDescIndirizzoCertificatore(String descIndirizzoCertificatore) {
		this.descIndirizzoCertificatore = descIndirizzoCertificatore;
	}

	public String getNumCivicoResidenza() {
		return numCivicoResidenza;
	}
	public void setNumCivicoResidenza(String numCivicoResidenza) {
		this.numCivicoResidenza = numCivicoResidenza;
	}

	public String getDescComuneResidenza() {
		return descComuneResidenza;
	}
	public void setDescComuneResidenza(String descComuneResidenza) {
		this.descComuneResidenza = descComuneResidenza;
	}

	public String getDescProvResidenza() {
		return descProvResidenza;
	}
	public void setDescProvResidenza(String descProvResidenza) {
		this.descProvResidenza = descProvResidenza;
	}

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	// dati generali
	public Integer getAnnoCostruzione() {
		return annoCostruzione;
	}
	public void setAnnoCostruzione(Integer annoCostruzione) {
		this.annoCostruzione = annoCostruzione;
	}

	public String getZonaClimatica() {
		return zonaClimatica;
	}
	public void setZonaClimatica(String zonaClimatica) {
		this.zonaClimatica = zonaClimatica;
	}

	public String getOggetto() {
		return oggetto;
	}
	public void setOggetto(String oggetto) {
		this.oggetto = oggetto;
	}

	public String getMotivazione() {
		return motivazione;
	}
	public void setMotivazione(String motivazione) {
		this.motivazione = motivazione;
	}

	public String getDescrizioneAltraMotivazione() {
		return descrizioneAltraMotivazione;
	}
	public void setDescrizioneAltraMotivazione(String descrizioneAltraMotivazione) {
		this.descrizioneAltraMotivazione = descrizioneAltraMotivazione;
	}

	public String getFlagServizioEnergia() {
		return flagServizioEnergia;
	}
	public void setFlagServizioEnergia(String flagServizioEnergia) {
		this.flagServizioEnergia = flagServizioEnergia;
	}
	
}
