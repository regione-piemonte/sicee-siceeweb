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

public class SiceeTCertificatore implements Serializable
{
	/** 
	 * This attribute maps to the column ID_CERTIFICATORE in the SICEE_T_CERTIFICATORE table.
	 */
	protected String idCertificatore;

	/** 
	 * This attribute maps to the column FK_AZIENDA in the SICEE_T_CERTIFICATORE table.
	 */
	protected long fkAzienda;

	/** 
	 * This attribute represents whether the primitive attribute fkAzienda is null.
	 */
	protected boolean fkAziendaNull = true;

	/** 
	 * This attribute maps to the column FK_TITOLO in the SICEE_T_CERTIFICATORE table.
	 */
	protected String fkTitolo;

	/** 
	 * This attribute maps to the column NOME in the SICEE_T_CERTIFICATORE table.
	 */
	protected String nome;

	/** 
	 * This attribute maps to the column COGNOME in the SICEE_T_CERTIFICATORE table.
	 */
	protected String cognome;

	/** 
	 * This attribute maps to the column CODICE_FISCALE in the SICEE_T_CERTIFICATORE table.
	 */
	protected String codiceFiscale;

	/** 
	 * This attribute maps to the column ID_COMUNE_NASCITA in the SICEE_T_CERTIFICATORE table.
	 */
	protected String idComuneNascita;

	/** 
	 * This attribute maps to the column DESC_COMUNE_NASCITA in the SICEE_T_CERTIFICATORE table.
	 */
	protected String descComuneNascita;

	/** 
	 * This attribute maps to the column DT_NASCITA in the SICEE_T_CERTIFICATORE table.
	 */
	protected Date dtNascita;

	/** 
	 * This attribute maps to the column ID_PROV_NASCITA in the SICEE_T_CERTIFICATORE table.
	 */
	protected String idProvNascita;

	/** 
	 * This attribute maps to the column ID_INDIRIZZO in the SICEE_T_CERTIFICATORE table.
	 */
	protected Integer idIndirizzo;

	/** 
	 * This attribute maps to the column DESC_PROV_NASCITA in the SICEE_T_CERTIFICATORE table.
	 */
	protected String descProvNascita;

	/** 
	 * This attribute maps to the column ID_REGIONE_NASCITA in the SICEE_T_CERTIFICATORE table.
	 */
	protected String idRegioneNascita;

	/** 
	 * This attribute maps to the column DESC_INDIRIZZO in the SICEE_T_CERTIFICATORE table.
	 */
	protected String descIndirizzo;

	/** 
	 * This attribute maps to the column CAP in the SICEE_T_CERTIFICATORE table.
	 */
	protected String cap;

	/** 
	 * This attribute maps to the column DESC_REGIONE_NASCITA in the SICEE_T_CERTIFICATORE table.
	 */
	protected String descRegioneNascita;

	/** 
	 * This attribute maps to the column ID_COMUNE_RESIDENZA in the SICEE_T_CERTIFICATORE table.
	 */
	protected String idComuneResidenza;

	/** 
	 * This attribute maps to the column NUM_CIVICO_RESIDENZA in the SICEE_T_CERTIFICATORE table.
	 */
	protected String numCivicoResidenza;

	/** 
	 * This attribute maps to the column DESC_COMUNE_RESIDENZA in the SICEE_T_CERTIFICATORE table.
	 */
	protected String descComuneResidenza;

	/** 
	 * This attribute maps to the column FLG_EDIFICI in the SICEE_T_CERTIFICATORE table.
	 */
	protected String flgEdifici;

	/** 
	 * This attribute maps to the column FLG_IMPIANTI in the SICEE_T_CERTIFICATORE table.
	 */
	protected String flgImpianti;

	/** 
	 * This attribute maps to the column FLG_VERIFICATO in the SICEE_T_CERTIFICATORE table.
	 */
	protected String flgVerificato;

	/** 
	 * This attribute maps to the column FLG_PAGAMENTO in the SICEE_T_CERTIFICATORE table.
	 */
	protected String flgPagamento;

	/** 
	 * This attribute maps to the column NOTE in the SICEE_T_CERTIFICATORE table.
	 */
	protected String note;

	/** 
	 * This attribute maps to the column ID_PROV_RESIDENZA in the SICEE_T_CERTIFICATORE table.
	 */
	protected String idProvResidenza;

	/** 
	 * This attribute maps to the column DT_ISCR_ELENCO in the SICEE_T_CERTIFICATORE table.
	 */
	protected Date dtIscrElenco;

	/** 
	 * This attribute maps to the column DESC_PROV_RESIDENZA in the SICEE_T_CERTIFICATORE table.
	 */
	protected String descProvResidenza;

	/** 
	 * This attribute maps to the column DT_SCADENZA_ELENCO in the SICEE_T_CERTIFICATORE table.
	 */
	protected Date dtScadenzaElenco;

	/** 
	 * This attribute maps to the column ID_REGIONE_RESIDENZA in the SICEE_T_CERTIFICATORE table.
	 */
	protected String idRegioneResidenza;

	/** 
	 * This attribute maps to the column NUM_TOT_ACE in the SICEE_T_CERTIFICATORE table.
	 */
	protected long numTotAce;

	/** 
	 * This attribute represents whether the primitive attribute numTotAce is null.
	 */
	protected boolean numTotAceNull = true;

	/** 
	 * This attribute maps to the column DESC_REGIONE_RESIDENZA in the SICEE_T_CERTIFICATORE table.
	 */
	protected String descRegioneResidenza;

	/** 
	 * This attribute maps to the column ORDINE in the SICEE_T_CERTIFICATORE table.
	 */
	protected String ordine;

	/** 
	 * This attribute maps to the column DESC_PROV_ORDINE in the SICEE_T_CERTIFICATORE table.
	 */
	protected String descProvOrdine;

	/** 
	 * This attribute maps to the column NUM_ISCR_ALBO in the SICEE_T_CERTIFICATORE table.
	 */
	protected String numIscrAlbo;

	/** 
	 * This attribute maps to the column ID_PROV_ORDINE in the SICEE_T_CERTIFICATORE table.
	 */
	protected String idProvOrdine;

	/** 
	 * This attribute maps to the column SETTORE in the SICEE_T_CERTIFICATORE table.
	 */
	protected String settore;

	/** 
	 * This attribute maps to the column SEZIONE in the SICEE_T_CERTIFICATORE table.
	 */
	protected String sezione;

	/** 
	 * This attribute maps to the column TELEFONO in the SICEE_T_CERTIFICATORE table.
	 */
	protected String telefono;

	/** 
	 * This attribute maps to the column DATA_ISCR_ALBO in the SICEE_T_CERTIFICATORE table.
	 */
	protected Date dataIscrAlbo;

	/** 
	 * This attribute maps to the column FAX in the SICEE_T_CERTIFICATORE table.
	 */
	protected String fax;

	/** 
	 * This attribute maps to the column CELL in the SICEE_T_CERTIFICATORE table.
	 */
	protected String cell;

	/** 
	 * This attribute maps to the column EMAIL in the SICEE_T_CERTIFICATORE table.
	 */
	protected String email;

	/** 
	 * This attribute maps to the column NUM_CERTIFICATORE in the SICEE_T_CERTIFICATORE table.
	 */
	protected String numCertificatore;

	/** 
	 * This attribute maps to the column STATO_ESTERO in the SICEE_T_CERTIFICATORE table.
	 */
	protected String statoEstero;

	/** 
	 * This attribute maps to the column FLG_CONSENSO_TEL in the SICEE_T_CERTIFICATORE table.
	 */
	protected String flgConsensoTel;

	/** 
	 * This attribute maps to the column FLG_CONSENSO_EMAIL in the SICEE_T_CERTIFICATORE table.
	 */
	protected String flgConsensoEmail;

	/** 
	 * This attribute maps to the column FLG_CONSENSO_CELL in the SICEE_T_CERTIFICATORE table.
	 */
	protected String flgConsensoCell;

	/** 
	 * This attribute maps to the column EMAIL_PEC in the SICEE_T_CERTIFICATORE table.
	 */
	protected String emailPec;

	/** 
	 * This attribute maps to the column FLG_NEWSLETTER in the SICEE_T_CERTIFICATORE table.
	 */
	protected String flgNewsletter;

	/** 
	 * This attribute maps to the column FLG_ESAME_SOSTENUTO in the SICEE_T_CERTIFICATORE table.
	 */
	protected String flgEsameSostenuto;

	/** 
	 * This attribute maps to the column SITO_WEB in the SICEE_T_CERTIFICATORE table.
	 */
	protected String sitoWeb;

	/** 
	 * This attribute maps to the column FLG_CANC_ELENCO in the SICEE_T_CERTIFICATORE table.
	 */
	protected String flgCancElenco;

	/** 
	 * This attribute maps to the column FK_ISTRUZIONE in the SICEE_T_CERTIFICATORE table.
	 */
	protected Integer fkIstruzione;

	/** 
	 * This attribute maps to the column FLG_AGG_DATI in the SICEE_T_CERTIFICATORE table.
	 */
	protected String flgAggDati;

	/** 
	 * This attribute maps to the column FLG_AGG_EMAIL in the SICEE_T_CERTIFICATORE table.
	 */
	protected String flgAggEmail;

	/** 
	 * This attribute maps to the column DT_AGG_DATI in the SICEE_T_CERTIFICATORE table.
	 */
	protected Date dtAggDati;

	/** 
	 * This attribute maps to the column DT_AGG_EMAIL in the SICEE_T_CERTIFICATORE table.
	 */
	protected Date dtAggEmail;

	/** 
	 * This attribute maps to the column ISCRITTO_ORDINE in the SICEE_T_CERTIFICATORE table.
	 */
	protected String iscrittoOrdine;

	/** 
	 * This attribute maps to the column COMPETENZE_NAZIONALI in the SICEE_T_CERTIFICATORE table.
	 */
	protected String competenzeNazionali;

	/** 
	 * This attribute maps to the column ACCETTAZIONE_TECNICO in the SICEE_T_CERTIFICATORE table.
	 */
	protected String accettazioneTecnico;

	/** 
	 * This attribute maps to the column DT_EMAIL_VERIFICA in the SICEE_T_CERTIFICATORE table.
	 */
	protected Date dtEmailVerifica;

	/** 
	 * This attribute maps to the column STATO_RES_ESTERO in the SICEE_T_CERTIFICATORE table.
	 */
	protected String statoResEstero;

	/** 
	 * This attribute maps to the column CITTA_ESTERA in the SICEE_T_CERTIFICATORE table.
	 */
	protected String cittaEstera;

	/** 
	 * This attribute maps to the column VIA_ESTERA in the SICEE_T_CERTIFICATORE table.
	 */
	protected String viaEstera;

	/** 
	 * This attribute maps to the column CIVICO_ESTERO in the SICEE_T_CERTIFICATORE table.
	 */
	protected String civicoEstero;

	/** 
	 * This attribute maps to the column CAP_ESTERO in the SICEE_T_CERTIFICATORE table.
	 */
	protected String capEstero;

	/** 
	 * This attribute maps to the column FLG_RESIDENZA_ITALIA in the SICEE_T_CERTIFICATORE table.
	 */
	protected String flgResidenzaItalia;

	/** 
	 * This attribute maps to the column FK_BLOCCO_CERTIFICATORE in the SICEE_T_CERTIFICATORE table.
	 */
	protected Integer fkBloccoCertificatore;

	/**
	 * Method 'SiceeTCertificatore'
	 * 
	 */
	public SiceeTCertificatore()
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
	 * Method 'getFkAzienda'
	 * 
	 * @return long
	 */
	public long getFkAzienda()
	{
		return fkAzienda;
	}

	/**
	 * Method 'setFkAzienda'
	 * 
	 * @param fkAzienda
	 */
	public void setFkAzienda(long fkAzienda)
	{
		this.fkAzienda = fkAzienda;
		this.fkAziendaNull = false;
	}

	/**
	 * Method 'setFkAziendaNull'
	 * 
	 * @param value
	 */
	public void setFkAziendaNull(boolean value)
	{
		this.fkAziendaNull = value;
	}

	/**
	 * Method 'isFkAziendaNull'
	 * 
	 * @return boolean
	 */
	public boolean isFkAziendaNull()
	{
		return fkAziendaNull;
	}

	/**
	 * Method 'getFkTitolo'
	 * 
	 * @return String
	 */
	public String getFkTitolo()
	{
		return fkTitolo;
	}

	/**
	 * Method 'setFkTitolo'
	 * 
	 * @param fkTitolo
	 */
	public void setFkTitolo(String fkTitolo)
	{
		this.fkTitolo = fkTitolo;
	}

	/**
	 * Method 'getNome'
	 * 
	 * @return String
	 */
	public String getNome()
	{
		return nome;
	}

	/**
	 * Method 'setNome'
	 * 
	 * @param nome
	 */
	public void setNome(String nome)
	{
		this.nome = nome;
	}

	/**
	 * Method 'getCognome'
	 * 
	 * @return String
	 */
	public String getCognome()
	{
		return cognome;
	}

	/**
	 * Method 'setCognome'
	 * 
	 * @param cognome
	 */
	public void setCognome(String cognome)
	{
		this.cognome = cognome;
	}

	/**
	 * Method 'getCodiceFiscale'
	 * 
	 * @return String
	 */
	public String getCodiceFiscale()
	{
		return codiceFiscale;
	}

	/**
	 * Method 'setCodiceFiscale'
	 * 
	 * @param codiceFiscale
	 */
	public void setCodiceFiscale(String codiceFiscale)
	{
		this.codiceFiscale = codiceFiscale;
	}

	/**
	 * Method 'getIdComuneNascita'
	 * 
	 * @return String
	 */
	public String getIdComuneNascita()
	{
		return idComuneNascita;
	}

	/**
	 * Method 'setIdComuneNascita'
	 * 
	 * @param idComuneNascita
	 */
	public void setIdComuneNascita(String idComuneNascita)
	{
		this.idComuneNascita = idComuneNascita;
	}

	/**
	 * Method 'getDescComuneNascita'
	 * 
	 * @return String
	 */
	public String getDescComuneNascita()
	{
		return descComuneNascita;
	}

	/**
	 * Method 'setDescComuneNascita'
	 * 
	 * @param descComuneNascita
	 */
	public void setDescComuneNascita(String descComuneNascita)
	{
		this.descComuneNascita = descComuneNascita;
	}

	/**
	 * Method 'getDtNascita'
	 * 
	 * @return Date
	 */
	public Date getDtNascita()
	{
		return dtNascita;
	}

	/**
	 * Method 'setDtNascita'
	 * 
	 * @param dtNascita
	 */
	public void setDtNascita(Date dtNascita)
	{
		this.dtNascita = dtNascita;
	}

	/**
	 * Method 'getIdProvNascita'
	 * 
	 * @return String
	 */
	public String getIdProvNascita()
	{
		return idProvNascita;
	}

	/**
	 * Method 'setIdProvNascita'
	 * 
	 * @param idProvNascita
	 */
	public void setIdProvNascita(String idProvNascita)
	{
		this.idProvNascita = idProvNascita;
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
	 * Method 'getDescProvNascita'
	 * 
	 * @return String
	 */
	public String getDescProvNascita()
	{
		return descProvNascita;
	}

	/**
	 * Method 'setDescProvNascita'
	 * 
	 * @param descProvNascita
	 */
	public void setDescProvNascita(String descProvNascita)
	{
		this.descProvNascita = descProvNascita;
	}

	/**
	 * Method 'getIdRegioneNascita'
	 * 
	 * @return String
	 */
	public String getIdRegioneNascita()
	{
		return idRegioneNascita;
	}

	/**
	 * Method 'setIdRegioneNascita'
	 * 
	 * @param idRegioneNascita
	 */
	public void setIdRegioneNascita(String idRegioneNascita)
	{
		this.idRegioneNascita = idRegioneNascita;
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
	 * Method 'getDescRegioneNascita'
	 * 
	 * @return String
	 */
	public String getDescRegioneNascita()
	{
		return descRegioneNascita;
	}

	/**
	 * Method 'setDescRegioneNascita'
	 * 
	 * @param descRegioneNascita
	 */
	public void setDescRegioneNascita(String descRegioneNascita)
	{
		this.descRegioneNascita = descRegioneNascita;
	}

	/**
	 * Method 'getIdComuneResidenza'
	 * 
	 * @return String
	 */
	public String getIdComuneResidenza()
	{
		return idComuneResidenza;
	}

	/**
	 * Method 'setIdComuneResidenza'
	 * 
	 * @param idComuneResidenza
	 */
	public void setIdComuneResidenza(String idComuneResidenza)
	{
		this.idComuneResidenza = idComuneResidenza;
	}

	/**
	 * Method 'getNumCivicoResidenza'
	 * 
	 * @return String
	 */
	public String getNumCivicoResidenza()
	{
		return numCivicoResidenza;
	}

	/**
	 * Method 'setNumCivicoResidenza'
	 * 
	 * @param numCivicoResidenza
	 */
	public void setNumCivicoResidenza(String numCivicoResidenza)
	{
		this.numCivicoResidenza = numCivicoResidenza;
	}

	/**
	 * Method 'getDescComuneResidenza'
	 * 
	 * @return String
	 */
	public String getDescComuneResidenza()
	{
		return descComuneResidenza;
	}

	/**
	 * Method 'setDescComuneResidenza'
	 * 
	 * @param descComuneResidenza
	 */
	public void setDescComuneResidenza(String descComuneResidenza)
	{
		this.descComuneResidenza = descComuneResidenza;
	}

	/**
	 * Method 'getFlgEdifici'
	 * 
	 * @return String
	 */
	public String getFlgEdifici()
	{
		return flgEdifici;
	}

	/**
	 * Method 'setFlgEdifici'
	 * 
	 * @param flgEdifici
	 */
	public void setFlgEdifici(String flgEdifici)
	{
		this.flgEdifici = flgEdifici;
	}

	/**
	 * Method 'getFlgImpianti'
	 * 
	 * @return String
	 */
	public String getFlgImpianti()
	{
		return flgImpianti;
	}

	/**
	 * Method 'setFlgImpianti'
	 * 
	 * @param flgImpianti
	 */
	public void setFlgImpianti(String flgImpianti)
	{
		this.flgImpianti = flgImpianti;
	}

	/**
	 * Method 'getFlgVerificato'
	 * 
	 * @return String
	 */
	public String getFlgVerificato()
	{
		return flgVerificato;
	}

	/**
	 * Method 'setFlgVerificato'
	 * 
	 * @param flgVerificato
	 */
	public void setFlgVerificato(String flgVerificato)
	{
		this.flgVerificato = flgVerificato;
	}

	/**
	 * Method 'getFlgPagamento'
	 * 
	 * @return String
	 */
	public String getFlgPagamento()
	{
		return flgPagamento;
	}

	/**
	 * Method 'setFlgPagamento'
	 * 
	 * @param flgPagamento
	 */
	public void setFlgPagamento(String flgPagamento)
	{
		this.flgPagamento = flgPagamento;
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
	 * Method 'getIdProvResidenza'
	 * 
	 * @return String
	 */
	public String getIdProvResidenza()
	{
		return idProvResidenza;
	}

	/**
	 * Method 'setIdProvResidenza'
	 * 
	 * @param idProvResidenza
	 */
	public void setIdProvResidenza(String idProvResidenza)
	{
		this.idProvResidenza = idProvResidenza;
	}

	/**
	 * Method 'getDtIscrElenco'
	 * 
	 * @return Date
	 */
	public Date getDtIscrElenco()
	{
		return dtIscrElenco;
	}

	/**
	 * Method 'setDtIscrElenco'
	 * 
	 * @param dtIscrElenco
	 */
	public void setDtIscrElenco(Date dtIscrElenco)
	{
		this.dtIscrElenco = dtIscrElenco;
	}

	/**
	 * Method 'getDescProvResidenza'
	 * 
	 * @return String
	 */
	public String getDescProvResidenza()
	{
		return descProvResidenza;
	}

	/**
	 * Method 'setDescProvResidenza'
	 * 
	 * @param descProvResidenza
	 */
	public void setDescProvResidenza(String descProvResidenza)
	{
		this.descProvResidenza = descProvResidenza;
	}

	/**
	 * Method 'getDtScadenzaElenco'
	 * 
	 * @return Date
	 */
	public Date getDtScadenzaElenco()
	{
		return dtScadenzaElenco;
	}

	/**
	 * Method 'setDtScadenzaElenco'
	 * 
	 * @param dtScadenzaElenco
	 */
	public void setDtScadenzaElenco(Date dtScadenzaElenco)
	{
		this.dtScadenzaElenco = dtScadenzaElenco;
	}

	/**
	 * Method 'getIdRegioneResidenza'
	 * 
	 * @return String
	 */
	public String getIdRegioneResidenza()
	{
		return idRegioneResidenza;
	}

	/**
	 * Method 'setIdRegioneResidenza'
	 * 
	 * @param idRegioneResidenza
	 */
	public void setIdRegioneResidenza(String idRegioneResidenza)
	{
		this.idRegioneResidenza = idRegioneResidenza;
	}

	/**
	 * Method 'getNumTotAce'
	 * 
	 * @return long
	 */
	public long getNumTotAce()
	{
		return numTotAce;
	}

	/**
	 * Method 'setNumTotAce'
	 * 
	 * @param numTotAce
	 */
	public void setNumTotAce(long numTotAce)
	{
		this.numTotAce = numTotAce;
		this.numTotAceNull = false;
	}

	/**
	 * Method 'setNumTotAceNull'
	 * 
	 * @param value
	 */
	public void setNumTotAceNull(boolean value)
	{
		this.numTotAceNull = value;
	}

	/**
	 * Method 'isNumTotAceNull'
	 * 
	 * @return boolean
	 */
	public boolean isNumTotAceNull()
	{
		return numTotAceNull;
	}

	/**
	 * Method 'getDescRegioneResidenza'
	 * 
	 * @return String
	 */
	public String getDescRegioneResidenza()
	{
		return descRegioneResidenza;
	}

	/**
	 * Method 'setDescRegioneResidenza'
	 * 
	 * @param descRegioneResidenza
	 */
	public void setDescRegioneResidenza(String descRegioneResidenza)
	{
		this.descRegioneResidenza = descRegioneResidenza;
	}

	/**
	 * Method 'getOrdine'
	 * 
	 * @return String
	 */
	public String getOrdine()
	{
		return ordine;
	}

	/**
	 * Method 'setOrdine'
	 * 
	 * @param ordine
	 */
	public void setOrdine(String ordine)
	{
		this.ordine = ordine;
	}

	/**
	 * Method 'getDescProvOrdine'
	 * 
	 * @return String
	 */
	public String getDescProvOrdine()
	{
		return descProvOrdine;
	}

	/**
	 * Method 'setDescProvOrdine'
	 * 
	 * @param descProvOrdine
	 */
	public void setDescProvOrdine(String descProvOrdine)
	{
		this.descProvOrdine = descProvOrdine;
	}

	/**
	 * Method 'getNumIscrAlbo'
	 * 
	 * @return String
	 */
	public String getNumIscrAlbo()
	{
		return numIscrAlbo;
	}

	/**
	 * Method 'setNumIscrAlbo'
	 * 
	 * @param numIscrAlbo
	 */
	public void setNumIscrAlbo(String numIscrAlbo)
	{
		this.numIscrAlbo = numIscrAlbo;
	}

	/**
	 * Method 'getIdProvOrdine'
	 * 
	 * @return String
	 */
	public String getIdProvOrdine()
	{
		return idProvOrdine;
	}

	/**
	 * Method 'setIdProvOrdine'
	 * 
	 * @param idProvOrdine
	 */
	public void setIdProvOrdine(String idProvOrdine)
	{
		this.idProvOrdine = idProvOrdine;
	}

	/**
	 * Method 'getSettore'
	 * 
	 * @return String
	 */
	public String getSettore()
	{
		return settore;
	}

	/**
	 * Method 'setSettore'
	 * 
	 * @param settore
	 */
	public void setSettore(String settore)
	{
		this.settore = settore;
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
	 * Method 'getTelefono'
	 * 
	 * @return String
	 */
	public String getTelefono()
	{
		return telefono;
	}

	/**
	 * Method 'setTelefono'
	 * 
	 * @param telefono
	 */
	public void setTelefono(String telefono)
	{
		this.telefono = telefono;
	}

	/**
	 * Method 'getDataIscrAlbo'
	 * 
	 * @return Date
	 */
	public Date getDataIscrAlbo()
	{
		return dataIscrAlbo;
	}

	/**
	 * Method 'setDataIscrAlbo'
	 * 
	 * @param dataIscrAlbo
	 */
	public void setDataIscrAlbo(Date dataIscrAlbo)
	{
		this.dataIscrAlbo = dataIscrAlbo;
	}

	/**
	 * Method 'getFax'
	 * 
	 * @return String
	 */
	public String getFax()
	{
		return fax;
	}

	/**
	 * Method 'setFax'
	 * 
	 * @param fax
	 */
	public void setFax(String fax)
	{
		this.fax = fax;
	}

	/**
	 * Method 'getCell'
	 * 
	 * @return String
	 */
	public String getCell()
	{
		return cell;
	}

	/**
	 * Method 'setCell'
	 * 
	 * @param cell
	 */
	public void setCell(String cell)
	{
		this.cell = cell;
	}

	/**
	 * Method 'getEmail'
	 * 
	 * @return String
	 */
	public String getEmail()
	{
		return email;
	}

	/**
	 * Method 'setEmail'
	 * 
	 * @param email
	 */
	public void setEmail(String email)
	{
		this.email = email;
	}

	/**
	 * Method 'getNumCertificatore'
	 * 
	 * @return String
	 */
	public String getNumCertificatore()
	{
		return numCertificatore;
	}

	/**
	 * Method 'setNumCertificatore'
	 * 
	 * @param numCertificatore
	 */
	public void setNumCertificatore(String numCertificatore)
	{
		this.numCertificatore = numCertificatore;
	}

	/**
	 * Method 'getStatoEstero'
	 * 
	 * @return String
	 */
	public String getStatoEstero()
	{
		return statoEstero;
	}

	/**
	 * Method 'setStatoEstero'
	 * 
	 * @param statoEstero
	 */
	public void setStatoEstero(String statoEstero)
	{
		this.statoEstero = statoEstero;
	}

	/**
	 * Method 'getFlgConsensoTel'
	 * 
	 * @return String
	 */
	public String getFlgConsensoTel()
	{
		return flgConsensoTel;
	}

	/**
	 * Method 'setFlgConsensoTel'
	 * 
	 * @param flgConsensoTel
	 */
	public void setFlgConsensoTel(String flgConsensoTel)
	{
		this.flgConsensoTel = flgConsensoTel;
	}

	/**
	 * Method 'getFlgConsensoEmail'
	 * 
	 * @return String
	 */
	public String getFlgConsensoEmail()
	{
		return flgConsensoEmail;
	}

	/**
	 * Method 'setFlgConsensoEmail'
	 * 
	 * @param flgConsensoEmail
	 */
	public void setFlgConsensoEmail(String flgConsensoEmail)
	{
		this.flgConsensoEmail = flgConsensoEmail;
	}

	/**
	 * Method 'getFlgConsensoCell'
	 * 
	 * @return String
	 */
	public String getFlgConsensoCell()
	{
		return flgConsensoCell;
	}

	/**
	 * Method 'setFlgConsensoCell'
	 * 
	 * @param flgConsensoCell
	 */
	public void setFlgConsensoCell(String flgConsensoCell)
	{
		this.flgConsensoCell = flgConsensoCell;
	}

	/**
	 * Method 'getEmailPec'
	 * 
	 * @return String
	 */
	public String getEmailPec()
	{
		return emailPec;
	}

	/**
	 * Method 'setEmailPec'
	 * 
	 * @param emailPec
	 */
	public void setEmailPec(String emailPec)
	{
		this.emailPec = emailPec;
	}

	/**
	 * Method 'getFlgNewsletter'
	 * 
	 * @return String
	 */
	public String getFlgNewsletter()
	{
		return flgNewsletter;
	}

	/**
	 * Method 'setFlgNewsletter'
	 * 
	 * @param flgNewsletter
	 */
	public void setFlgNewsletter(String flgNewsletter)
	{
		this.flgNewsletter = flgNewsletter;
	}

	/**
	 * Method 'getFlgEsameSostenuto'
	 * 
	 * @return String
	 */
	public String getFlgEsameSostenuto()
	{
		return flgEsameSostenuto;
	}

	/**
	 * Method 'setFlgEsameSostenuto'
	 * 
	 * @param flgEsameSostenuto
	 */
	public void setFlgEsameSostenuto(String flgEsameSostenuto)
	{
		this.flgEsameSostenuto = flgEsameSostenuto;
	}

	/**
	 * Method 'getSitoWeb'
	 * 
	 * @return String
	 */
	public String getSitoWeb()
	{
		return sitoWeb;
	}

	/**
	 * Method 'setSitoWeb'
	 * 
	 * @param sitoWeb
	 */
	public void setSitoWeb(String sitoWeb)
	{
		this.sitoWeb = sitoWeb;
	}

	/**
	 * Method 'getFlgCancElenco'
	 * 
	 * @return String
	 */
	public String getFlgCancElenco()
	{
		return flgCancElenco;
	}

	/**
	 * Method 'setFlgCancElenco'
	 * 
	 * @param flgCancElenco
	 */
	public void setFlgCancElenco(String flgCancElenco)
	{
		this.flgCancElenco = flgCancElenco;
	}

	/**
	 * Method 'getFkIstruzione'
	 * 
	 * @return Integer
	 */
	public Integer getFkIstruzione()
	{
		return fkIstruzione;
	}

	/**
	 * Method 'setFkIstruzione'
	 * 
	 * @param fkIstruzione
	 */
	public void setFkIstruzione(Integer fkIstruzione)
	{
		this.fkIstruzione = fkIstruzione;
	}

	/**
	 * Method 'getFlgAggDati'
	 * 
	 * @return String
	 */
	public String getFlgAggDati()
	{
		return flgAggDati;
	}

	/**
	 * Method 'setFlgAggDati'
	 * 
	 * @param flgAggDati
	 */
	public void setFlgAggDati(String flgAggDati)
	{
		this.flgAggDati = flgAggDati;
	}

	/**
	 * Method 'getFlgAggEmail'
	 * 
	 * @return String
	 */
	public String getFlgAggEmail()
	{
		return flgAggEmail;
	}

	/**
	 * Method 'setFlgAggEmail'
	 * 
	 * @param flgAggEmail
	 */
	public void setFlgAggEmail(String flgAggEmail)
	{
		this.flgAggEmail = flgAggEmail;
	}

	/**
	 * Method 'getDtAggDati'
	 * 
	 * @return Date
	 */
	public Date getDtAggDati()
	{
		return dtAggDati;
	}

	/**
	 * Method 'setDtAggDati'
	 * 
	 * @param dtAggDati
	 */
	public void setDtAggDati(Date dtAggDati)
	{
		this.dtAggDati = dtAggDati;
	}

	/**
	 * Method 'getDtAggEmail'
	 * 
	 * @return Date
	 */
	public Date getDtAggEmail()
	{
		return dtAggEmail;
	}

	/**
	 * Method 'setDtAggEmail'
	 * 
	 * @param dtAggEmail
	 */
	public void setDtAggEmail(Date dtAggEmail)
	{
		this.dtAggEmail = dtAggEmail;
	}

	/**
	 * Method 'getIscrittoOrdine'
	 * 
	 * @return String
	 */
	public String getIscrittoOrdine()
	{
		return iscrittoOrdine;
	}

	/**
	 * Method 'setIscrittoOrdine'
	 * 
	 * @param iscrittoOrdine
	 */
	public void setIscrittoOrdine(String iscrittoOrdine)
	{
		this.iscrittoOrdine = iscrittoOrdine;
	}

	/**
	 * Method 'getCompetenzeNazionali'
	 * 
	 * @return String
	 */
	public String getCompetenzeNazionali()
	{
		return competenzeNazionali;
	}

	/**
	 * Method 'setCompetenzeNazionali'
	 * 
	 * @param competenzeNazionali
	 */
	public void setCompetenzeNazionali(String competenzeNazionali)
	{
		this.competenzeNazionali = competenzeNazionali;
	}

	/**
	 * Method 'getAccettazioneTecnico'
	 * 
	 * @return String
	 */
	public String getAccettazioneTecnico()
	{
		return accettazioneTecnico;
	}

	/**
	 * Method 'setAccettazioneTecnico'
	 * 
	 * @param accettazioneTecnico
	 */
	public void setAccettazioneTecnico(String accettazioneTecnico)
	{
		this.accettazioneTecnico = accettazioneTecnico;
	}

	/**
	 * Method 'getDtEmailVerifica'
	 * 
	 * @return Date
	 */
	public Date getDtEmailVerifica()
	{
		return dtEmailVerifica;
	}

	/**
	 * Method 'setDtEmailVerifica'
	 * 
	 * @param dtEmailVerifica
	 */
	public void setDtEmailVerifica(Date dtEmailVerifica)
	{
		this.dtEmailVerifica = dtEmailVerifica;
	}

	/**
	 * Method 'getStatoResEstero'
	 * 
	 * @return String
	 */
	public String getStatoResEstero()
	{
		return statoResEstero;
	}

	/**
	 * Method 'setStatoResEstero'
	 * 
	 * @param statoResEstero
	 */
	public void setStatoResEstero(String statoResEstero)
	{
		this.statoResEstero = statoResEstero;
	}

	/**
	 * Method 'getCittaEstera'
	 * 
	 * @return String
	 */
	public String getCittaEstera()
	{
		return cittaEstera;
	}

	/**
	 * Method 'setCittaEstera'
	 * 
	 * @param cittaEstera
	 */
	public void setCittaEstera(String cittaEstera)
	{
		this.cittaEstera = cittaEstera;
	}

	/**
	 * Method 'getViaEstera'
	 * 
	 * @return String
	 */
	public String getViaEstera()
	{
		return viaEstera;
	}

	/**
	 * Method 'setViaEstera'
	 * 
	 * @param viaEstera
	 */
	public void setViaEstera(String viaEstera)
	{
		this.viaEstera = viaEstera;
	}

	/**
	 * Method 'getCivicoEstero'
	 * 
	 * @return String
	 */
	public String getCivicoEstero()
	{
		return civicoEstero;
	}

	/**
	 * Method 'setCivicoEstero'
	 * 
	 * @param civicoEstero
	 */
	public void setCivicoEstero(String civicoEstero)
	{
		this.civicoEstero = civicoEstero;
	}

	/**
	 * Method 'getCapEstero'
	 * 
	 * @return String
	 */
	public String getCapEstero()
	{
		return capEstero;
	}

	/**
	 * Method 'setCapEstero'
	 * 
	 * @param capEstero
	 */
	public void setCapEstero(String capEstero)
	{
		this.capEstero = capEstero;
	}

	/**
	 * Method 'getFlgResidenzaItalia'
	 * 
	 * @return String
	 */
	public String getFlgResidenzaItalia()
	{
		return flgResidenzaItalia;
	}

	/**
	 * Method 'setFlgResidenzaItalia'
	 * 
	 * @param flgResidenzaItalia
	 */
	public void setFlgResidenzaItalia(String flgResidenzaItalia)
	{
		this.flgResidenzaItalia = flgResidenzaItalia;
	}

	/**
	 * Method 'getFkBloccoCertificatore'
	 * 
	 * @return Integer
	 */
	public Integer getFkBloccoCertificatore()
	{
		return fkBloccoCertificatore;
	}

	/**
	 * Method 'setFkStatoCertificatore'
	 * 
	 * @param fkStatoCertificatore
	 */
	public void setFkBloccoCertificatore(Integer fkBloccoCertificatore)
	{
		this.fkBloccoCertificatore = fkBloccoCertificatore;
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
		
		if (!(_other instanceof SiceeTCertificatore)) {
			return false;
		}
		
		final SiceeTCertificatore _cast = (SiceeTCertificatore) _other;
		if (idCertificatore == null ? _cast.idCertificatore != idCertificatore : !idCertificatore.equals( _cast.idCertificatore )) {
			return false;
		}
		
		if (fkAzienda != _cast.fkAzienda) {
			return false;
		}
		
		if (fkAziendaNull != _cast.fkAziendaNull) {
			return false;
		}
		
		if (fkTitolo == null ? _cast.fkTitolo != fkTitolo : !fkTitolo.equals( _cast.fkTitolo )) {
			return false;
		}
		
		if (nome == null ? _cast.nome != nome : !nome.equals( _cast.nome )) {
			return false;
		}
		
		if (cognome == null ? _cast.cognome != cognome : !cognome.equals( _cast.cognome )) {
			return false;
		}
		
		if (codiceFiscale == null ? _cast.codiceFiscale != codiceFiscale : !codiceFiscale.equals( _cast.codiceFiscale )) {
			return false;
		}
		
		if (idComuneNascita == null ? _cast.idComuneNascita != idComuneNascita : !idComuneNascita.equals( _cast.idComuneNascita )) {
			return false;
		}
		
		if (descComuneNascita == null ? _cast.descComuneNascita != descComuneNascita : !descComuneNascita.equals( _cast.descComuneNascita )) {
			return false;
		}
		
		if (dtNascita == null ? _cast.dtNascita != dtNascita : !dtNascita.equals( _cast.dtNascita )) {
			return false;
		}
		
		if (idProvNascita == null ? _cast.idProvNascita != idProvNascita : !idProvNascita.equals( _cast.idProvNascita )) {
			return false;
		}
		
		if (idIndirizzo == null ? _cast.idIndirizzo != idIndirizzo : !idIndirizzo.equals( _cast.idIndirizzo )) {
			return false;
		}
		
		if (descProvNascita == null ? _cast.descProvNascita != descProvNascita : !descProvNascita.equals( _cast.descProvNascita )) {
			return false;
		}
		
		if (idRegioneNascita == null ? _cast.idRegioneNascita != idRegioneNascita : !idRegioneNascita.equals( _cast.idRegioneNascita )) {
			return false;
		}
		
		if (descIndirizzo == null ? _cast.descIndirizzo != descIndirizzo : !descIndirizzo.equals( _cast.descIndirizzo )) {
			return false;
		}
		
		if (cap == null ? _cast.cap != cap : !cap.equals( _cast.cap )) {
			return false;
		}
		
		if (descRegioneNascita == null ? _cast.descRegioneNascita != descRegioneNascita : !descRegioneNascita.equals( _cast.descRegioneNascita )) {
			return false;
		}
		
		if (idComuneResidenza == null ? _cast.idComuneResidenza != idComuneResidenza : !idComuneResidenza.equals( _cast.idComuneResidenza )) {
			return false;
		}
		
		if (numCivicoResidenza == null ? _cast.numCivicoResidenza != numCivicoResidenza : !numCivicoResidenza.equals( _cast.numCivicoResidenza )) {
			return false;
		}
		
		if (descComuneResidenza == null ? _cast.descComuneResidenza != descComuneResidenza : !descComuneResidenza.equals( _cast.descComuneResidenza )) {
			return false;
		}
		
		if (flgEdifici == null ? _cast.flgEdifici != flgEdifici : !flgEdifici.equals( _cast.flgEdifici )) {
			return false;
		}
		
		if (flgImpianti == null ? _cast.flgImpianti != flgImpianti : !flgImpianti.equals( _cast.flgImpianti )) {
			return false;
		}
		
		if (flgVerificato == null ? _cast.flgVerificato != flgVerificato : !flgVerificato.equals( _cast.flgVerificato )) {
			return false;
		}
		
		if (flgPagamento == null ? _cast.flgPagamento != flgPagamento : !flgPagamento.equals( _cast.flgPagamento )) {
			return false;
		}
		
		if (note == null ? _cast.note != note : !note.equals( _cast.note )) {
			return false;
		}
		
		if (idProvResidenza == null ? _cast.idProvResidenza != idProvResidenza : !idProvResidenza.equals( _cast.idProvResidenza )) {
			return false;
		}
		
		if (dtIscrElenco == null ? _cast.dtIscrElenco != dtIscrElenco : !dtIscrElenco.equals( _cast.dtIscrElenco )) {
			return false;
		}
		
		if (descProvResidenza == null ? _cast.descProvResidenza != descProvResidenza : !descProvResidenza.equals( _cast.descProvResidenza )) {
			return false;
		}
		
		if (dtScadenzaElenco == null ? _cast.dtScadenzaElenco != dtScadenzaElenco : !dtScadenzaElenco.equals( _cast.dtScadenzaElenco )) {
			return false;
		}
		
		if (idRegioneResidenza == null ? _cast.idRegioneResidenza != idRegioneResidenza : !idRegioneResidenza.equals( _cast.idRegioneResidenza )) {
			return false;
		}
		
		if (numTotAce != _cast.numTotAce) {
			return false;
		}
		
		if (numTotAceNull != _cast.numTotAceNull) {
			return false;
		}
		
		if (descRegioneResidenza == null ? _cast.descRegioneResidenza != descRegioneResidenza : !descRegioneResidenza.equals( _cast.descRegioneResidenza )) {
			return false;
		}
		
		if (ordine == null ? _cast.ordine != ordine : !ordine.equals( _cast.ordine )) {
			return false;
		}
		
		if (descProvOrdine == null ? _cast.descProvOrdine != descProvOrdine : !descProvOrdine.equals( _cast.descProvOrdine )) {
			return false;
		}
		
		if (numIscrAlbo == null ? _cast.numIscrAlbo != numIscrAlbo : !numIscrAlbo.equals( _cast.numIscrAlbo )) {
			return false;
		}
		
		if (idProvOrdine == null ? _cast.idProvOrdine != idProvOrdine : !idProvOrdine.equals( _cast.idProvOrdine )) {
			return false;
		}
		
		if (settore == null ? _cast.settore != settore : !settore.equals( _cast.settore )) {
			return false;
		}
		
		if (sezione == null ? _cast.sezione != sezione : !sezione.equals( _cast.sezione )) {
			return false;
		}
		
		if (telefono == null ? _cast.telefono != telefono : !telefono.equals( _cast.telefono )) {
			return false;
		}
		
		if (dataIscrAlbo == null ? _cast.dataIscrAlbo != dataIscrAlbo : !dataIscrAlbo.equals( _cast.dataIscrAlbo )) {
			return false;
		}
		
		if (fax == null ? _cast.fax != fax : !fax.equals( _cast.fax )) {
			return false;
		}
		
		if (cell == null ? _cast.cell != cell : !cell.equals( _cast.cell )) {
			return false;
		}
		
		if (email == null ? _cast.email != email : !email.equals( _cast.email )) {
			return false;
		}
		
		if (numCertificatore == null ? _cast.numCertificatore != numCertificatore : !numCertificatore.equals( _cast.numCertificatore )) {
			return false;
		}
		
		if (statoEstero == null ? _cast.statoEstero != statoEstero : !statoEstero.equals( _cast.statoEstero )) {
			return false;
		}
		
		if (flgConsensoTel == null ? _cast.flgConsensoTel != flgConsensoTel : !flgConsensoTel.equals( _cast.flgConsensoTel )) {
			return false;
		}
		
		if (flgConsensoEmail == null ? _cast.flgConsensoEmail != flgConsensoEmail : !flgConsensoEmail.equals( _cast.flgConsensoEmail )) {
			return false;
		}
		
		if (flgConsensoCell == null ? _cast.flgConsensoCell != flgConsensoCell : !flgConsensoCell.equals( _cast.flgConsensoCell )) {
			return false;
		}
		
		if (emailPec == null ? _cast.emailPec != emailPec : !emailPec.equals( _cast.emailPec )) {
			return false;
		}
		
		if (flgNewsletter == null ? _cast.flgNewsletter != flgNewsletter : !flgNewsletter.equals( _cast.flgNewsletter )) {
			return false;
		}
		
		if (flgEsameSostenuto == null ? _cast.flgEsameSostenuto != flgEsameSostenuto : !flgEsameSostenuto.equals( _cast.flgEsameSostenuto )) {
			return false;
		}
		
		if (sitoWeb == null ? _cast.sitoWeb != sitoWeb : !sitoWeb.equals( _cast.sitoWeb )) {
			return false;
		}
		
		if (flgCancElenco == null ? _cast.flgCancElenco != flgCancElenco : !flgCancElenco.equals( _cast.flgCancElenco )) {
			return false;
		}
		
		if (fkIstruzione == null ? _cast.fkIstruzione != fkIstruzione : !fkIstruzione.equals( _cast.fkIstruzione )) {
			return false;
		}
		
		if (flgAggDati == null ? _cast.flgAggDati != flgAggDati : !flgAggDati.equals( _cast.flgAggDati )) {
			return false;
		}
		
		if (flgAggEmail == null ? _cast.flgAggEmail != flgAggEmail : !flgAggEmail.equals( _cast.flgAggEmail )) {
			return false;
		}
		
		if (dtAggDati == null ? _cast.dtAggDati != dtAggDati : !dtAggDati.equals( _cast.dtAggDati )) {
			return false;
		}
		
		if (dtAggEmail == null ? _cast.dtAggEmail != dtAggEmail : !dtAggEmail.equals( _cast.dtAggEmail )) {
			return false;
		}
		
		if (iscrittoOrdine == null ? _cast.iscrittoOrdine != iscrittoOrdine : !iscrittoOrdine.equals( _cast.iscrittoOrdine )) {
			return false;
		}
		
		if (competenzeNazionali == null ? _cast.competenzeNazionali != competenzeNazionali : !competenzeNazionali.equals( _cast.competenzeNazionali )) {
			return false;
		}
		
		if (accettazioneTecnico == null ? _cast.accettazioneTecnico != accettazioneTecnico : !accettazioneTecnico.equals( _cast.accettazioneTecnico )) {
			return false;
		}
		
		if (dtEmailVerifica == null ? _cast.dtEmailVerifica != dtEmailVerifica : !dtEmailVerifica.equals( _cast.dtEmailVerifica )) {
			return false;
		}
		
		if (statoResEstero == null ? _cast.statoResEstero != statoResEstero : !statoResEstero.equals( _cast.statoResEstero )) {
			return false;
		}

		if (cittaEstera == null ? _cast.cittaEstera != cittaEstera : !cittaEstera.equals( _cast.cittaEstera )) {
			return false;
		}

		if (viaEstera == null ? _cast.viaEstera != viaEstera : !viaEstera.equals( _cast.viaEstera )) {
			return false;
		}

		if (civicoEstero == null ? _cast.civicoEstero != civicoEstero : !civicoEstero.equals( _cast.civicoEstero )) {
			return false;
		}

		if (capEstero == null ? _cast.capEstero != capEstero : !capEstero.equals( _cast.capEstero )) {
			return false;
		}

		if (flgResidenzaItalia == null ? _cast.flgResidenzaItalia != flgResidenzaItalia : !flgResidenzaItalia.equals( _cast.flgResidenzaItalia )) {
			return false;
		}

		if (fkBloccoCertificatore == null ? _cast.fkBloccoCertificatore != fkBloccoCertificatore : !fkBloccoCertificatore.equals( _cast.fkBloccoCertificatore )) {
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
		
		_hashCode = 29 * _hashCode + (int) (fkAzienda ^ (fkAzienda >>> 32));
		_hashCode = 29 * _hashCode + (fkAziendaNull ? 1 : 0);
		if (fkTitolo != null) {
			_hashCode = 29 * _hashCode + fkTitolo.hashCode();
		}
		
		if (nome != null) {
			_hashCode = 29 * _hashCode + nome.hashCode();
		}
		
		if (cognome != null) {
			_hashCode = 29 * _hashCode + cognome.hashCode();
		}
		
		if (codiceFiscale != null) {
			_hashCode = 29 * _hashCode + codiceFiscale.hashCode();
		}
		
		if (idComuneNascita != null) {
			_hashCode = 29 * _hashCode + idComuneNascita.hashCode();
		}
		
		if (descComuneNascita != null) {
			_hashCode = 29 * _hashCode + descComuneNascita.hashCode();
		}
		
		if (dtNascita != null) {
			_hashCode = 29 * _hashCode + dtNascita.hashCode();
		}
		
		if (idProvNascita != null) {
			_hashCode = 29 * _hashCode + idProvNascita.hashCode();
		}
		
		if (idIndirizzo != null) {
			_hashCode = 29 * _hashCode + idIndirizzo.hashCode();
		}
		
		if (descProvNascita != null) {
			_hashCode = 29 * _hashCode + descProvNascita.hashCode();
		}
		
		if (idRegioneNascita != null) {
			_hashCode = 29 * _hashCode + idRegioneNascita.hashCode();
		}
		
		if (descIndirizzo != null) {
			_hashCode = 29 * _hashCode + descIndirizzo.hashCode();
		}
		
		if (cap != null) {
			_hashCode = 29 * _hashCode + cap.hashCode();
		}
		
		if (descRegioneNascita != null) {
			_hashCode = 29 * _hashCode + descRegioneNascita.hashCode();
		}
		
		if (idComuneResidenza != null) {
			_hashCode = 29 * _hashCode + idComuneResidenza.hashCode();
		}
		
		if (numCivicoResidenza != null) {
			_hashCode = 29 * _hashCode + numCivicoResidenza.hashCode();
		}
		
		if (descComuneResidenza != null) {
			_hashCode = 29 * _hashCode + descComuneResidenza.hashCode();
		}
		
		if (flgEdifici != null) {
			_hashCode = 29 * _hashCode + flgEdifici.hashCode();
		}
		
		if (flgImpianti != null) {
			_hashCode = 29 * _hashCode + flgImpianti.hashCode();
		}
		
		if (flgVerificato != null) {
			_hashCode = 29 * _hashCode + flgVerificato.hashCode();
		}
		
		if (flgPagamento != null) {
			_hashCode = 29 * _hashCode + flgPagamento.hashCode();
		}
		
		if (note != null) {
			_hashCode = 29 * _hashCode + note.hashCode();
		}
		
		if (idProvResidenza != null) {
			_hashCode = 29 * _hashCode + idProvResidenza.hashCode();
		}
		
		if (dtIscrElenco != null) {
			_hashCode = 29 * _hashCode + dtIscrElenco.hashCode();
		}
		
		if (descProvResidenza != null) {
			_hashCode = 29 * _hashCode + descProvResidenza.hashCode();
		}
		
		if (dtScadenzaElenco != null) {
			_hashCode = 29 * _hashCode + dtScadenzaElenco.hashCode();
		}
		
		if (idRegioneResidenza != null) {
			_hashCode = 29 * _hashCode + idRegioneResidenza.hashCode();
		}
		
		_hashCode = 29 * _hashCode + (int) (numTotAce ^ (numTotAce >>> 32));
		_hashCode = 29 * _hashCode + (numTotAceNull ? 1 : 0);
		if (descRegioneResidenza != null) {
			_hashCode = 29 * _hashCode + descRegioneResidenza.hashCode();
		}
		
		if (ordine != null) {
			_hashCode = 29 * _hashCode + ordine.hashCode();
		}
		
		if (descProvOrdine != null) {
			_hashCode = 29 * _hashCode + descProvOrdine.hashCode();
		}
		
		if (numIscrAlbo != null) {
			_hashCode = 29 * _hashCode + numIscrAlbo.hashCode();
		}
		
		if (idProvOrdine != null) {
			_hashCode = 29 * _hashCode + idProvOrdine.hashCode();
		}
		
		if (settore != null) {
			_hashCode = 29 * _hashCode + settore.hashCode();
		}
		
		if (sezione != null) {
			_hashCode = 29 * _hashCode + sezione.hashCode();
		}
		
		if (telefono != null) {
			_hashCode = 29 * _hashCode + telefono.hashCode();
		}
		
		if (dataIscrAlbo != null) {
			_hashCode = 29 * _hashCode + dataIscrAlbo.hashCode();
		}
		
		if (fax != null) {
			_hashCode = 29 * _hashCode + fax.hashCode();
		}
		
		if (cell != null) {
			_hashCode = 29 * _hashCode + cell.hashCode();
		}
		
		if (email != null) {
			_hashCode = 29 * _hashCode + email.hashCode();
		}
		
		if (numCertificatore != null) {
			_hashCode = 29 * _hashCode + numCertificatore.hashCode();
		}
		
		if (statoEstero != null) {
			_hashCode = 29 * _hashCode + statoEstero.hashCode();
		}
		
		if (flgConsensoTel != null) {
			_hashCode = 29 * _hashCode + flgConsensoTel.hashCode();
		}
		
		if (flgConsensoEmail != null) {
			_hashCode = 29 * _hashCode + flgConsensoEmail.hashCode();
		}
		
		if (flgConsensoCell != null) {
			_hashCode = 29 * _hashCode + flgConsensoCell.hashCode();
		}
		
		if (emailPec != null) {
			_hashCode = 29 * _hashCode + emailPec.hashCode();
		}
		
		if (flgNewsletter != null) {
			_hashCode = 29 * _hashCode + flgNewsletter.hashCode();
		}
		
		if (flgEsameSostenuto != null) {
			_hashCode = 29 * _hashCode + flgEsameSostenuto.hashCode();
		}
		
		if (sitoWeb != null) {
			_hashCode = 29 * _hashCode + sitoWeb.hashCode();
		}
		
		if (flgCancElenco != null) {
			_hashCode = 29 * _hashCode + flgCancElenco.hashCode();
		}
		
		if (fkIstruzione != null) {
			_hashCode = 29 * _hashCode + fkIstruzione.hashCode();
		}
		
		if (flgAggDati != null) {
			_hashCode = 29 * _hashCode + flgAggDati.hashCode();
		}
		
		if (flgAggEmail != null) {
			_hashCode = 29 * _hashCode + flgAggEmail.hashCode();
		}
		
		if (dtAggDati != null) {
			_hashCode = 29 * _hashCode + dtAggDati.hashCode();
		}
		
		if (dtAggEmail != null) {
			_hashCode = 29 * _hashCode + dtAggEmail.hashCode();
		}
		
		if (iscrittoOrdine != null) {
			_hashCode = 29 * _hashCode + iscrittoOrdine.hashCode();
		}
		
		if (competenzeNazionali != null) {
			_hashCode = 29 * _hashCode + competenzeNazionali.hashCode();
		}
		
		if (accettazioneTecnico != null) {
			_hashCode = 29 * _hashCode + accettazioneTecnico.hashCode();
		}
		
		if (dtEmailVerifica != null) {
			_hashCode = 29 * _hashCode + dtEmailVerifica.hashCode();
		}
		
		if (statoResEstero != null) {
			_hashCode = 29 * _hashCode + statoResEstero.hashCode();
		}

		if (cittaEstera != null) {
			_hashCode = 29 * _hashCode + cittaEstera.hashCode();
		}

		if (viaEstera != null) {
			_hashCode = 29 * _hashCode + viaEstera.hashCode();
		}

		if (civicoEstero != null) {
			_hashCode = 29 * _hashCode + civicoEstero.hashCode();
		}

		if (capEstero != null) {
			_hashCode = 29 * _hashCode + capEstero.hashCode();
		}

		if (flgResidenzaItalia != null) {
			_hashCode = 29 * _hashCode + flgResidenzaItalia.hashCode();
		}

		if (fkBloccoCertificatore != null) {
			_hashCode = 29 * _hashCode + fkBloccoCertificatore.hashCode();
		}

		return _hashCode;
	}

	/**
	 * Method 'createPk'
	 * 
	 * @return SiceeTCertificatorePk
	 */
	public SiceeTCertificatorePk createPk()
	{
		return new SiceeTCertificatorePk(idCertificatore);
	}

	/**
	 * Method 'toString'
	 * 
	 * @return String
	 */
	public String toString()
	{
		StringBuffer ret = new StringBuffer();
		ret.append( "it.csi.sicee.siceeweb.business.dao.dto.SiceeTCertificatore: " );
		ret.append( "idCertificatore=" + idCertificatore );
		ret.append( ", fkAzienda=" + fkAzienda );
		ret.append( ", fkTitolo=" + fkTitolo );
		ret.append( ", nome=" + nome );
		ret.append( ", cognome=" + cognome );
		ret.append( ", codiceFiscale=" + codiceFiscale );
		ret.append( ", idComuneNascita=" + idComuneNascita );
		ret.append( ", descComuneNascita=" + descComuneNascita );
		ret.append( ", dtNascita=" + dtNascita );
		ret.append( ", idProvNascita=" + idProvNascita );
		ret.append( ", idIndirizzo=" + idIndirizzo );
		ret.append( ", descProvNascita=" + descProvNascita );
		ret.append( ", idRegioneNascita=" + idRegioneNascita );
		ret.append( ", descIndirizzo=" + descIndirizzo );
		ret.append( ", cap=" + cap );
		ret.append( ", descRegioneNascita=" + descRegioneNascita );
		ret.append( ", idComuneResidenza=" + idComuneResidenza );
		ret.append( ", numCivicoResidenza=" + numCivicoResidenza );
		ret.append( ", descComuneResidenza=" + descComuneResidenza );
		ret.append( ", flgEdifici=" + flgEdifici );
		ret.append( ", flgImpianti=" + flgImpianti );
		ret.append( ", flgVerificato=" + flgVerificato );
		ret.append( ", flgPagamento=" + flgPagamento );
		ret.append( ", note=" + note );
		ret.append( ", idProvResidenza=" + idProvResidenza );
		ret.append( ", dtIscrElenco=" + dtIscrElenco );
		ret.append( ", descProvResidenza=" + descProvResidenza );
		ret.append( ", dtScadenzaElenco=" + dtScadenzaElenco );
		ret.append( ", idRegioneResidenza=" + idRegioneResidenza );
		ret.append( ", numTotAce=" + numTotAce );
		ret.append( ", descRegioneResidenza=" + descRegioneResidenza );
		ret.append( ", ordine=" + ordine );
		ret.append( ", descProvOrdine=" + descProvOrdine );
		ret.append( ", numIscrAlbo=" + numIscrAlbo );
		ret.append( ", idProvOrdine=" + idProvOrdine );
		ret.append( ", settore=" + settore );
		ret.append( ", sezione=" + sezione );
		ret.append( ", telefono=" + telefono );
		ret.append( ", dataIscrAlbo=" + dataIscrAlbo );
		ret.append( ", fax=" + fax );
		ret.append( ", cell=" + cell );
		ret.append( ", email=" + email );
		ret.append( ", numCertificatore=" + numCertificatore );
		ret.append( ", statoEstero=" + statoEstero );
		ret.append( ", flgConsensoTel=" + flgConsensoTel );
		ret.append( ", flgConsensoEmail=" + flgConsensoEmail );
		ret.append( ", flgConsensoCell=" + flgConsensoCell );
		ret.append( ", emailPec=" + emailPec );
		ret.append( ", flgNewsletter=" + flgNewsletter );
		ret.append( ", flgEsameSostenuto=" + flgEsameSostenuto );
		ret.append( ", sitoWeb=" + sitoWeb );
		ret.append( ", flgCancElenco=" + flgCancElenco );
		ret.append( ", fkIstruzione=" + fkIstruzione );
		ret.append( ", flgAggDati=" + flgAggDati );
		ret.append( ", flgAggEmail=" + flgAggEmail );
		ret.append( ", dtAggDati=" + dtAggDati );
		ret.append( ", dtAggEmail=" + dtAggEmail );
		ret.append( ", iscrittoOrdine=" + iscrittoOrdine );
		ret.append( ", competenzeNazionali=" + competenzeNazionali );
		ret.append( ", accettazioneTecnico=" + accettazioneTecnico );
		ret.append( ", dtEmailVerifica=" + dtEmailVerifica );
		ret.append( ", statoResEstero=" + statoResEstero );
		ret.append( ", cittaEstera=" + cittaEstera );
		ret.append( ", viaEstera=" + viaEstera );
		ret.append( ", civicoEstero=" + civicoEstero );
		ret.append( ", capEstero=" + capEstero );
		ret.append( ", flgResidenzaItalia=" + flgResidenzaItalia );
		ret.append( ", fkBloccoCertificatore=" + fkBloccoCertificatore );
		
		return ret.toString();
	}

}
