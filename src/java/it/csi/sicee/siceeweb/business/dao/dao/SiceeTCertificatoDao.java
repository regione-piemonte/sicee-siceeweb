/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceeweb.business.dao.dao;

import it.csi.sicee.siceeweb.business.dao.dao.SiceeTCertificatoDao;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeTCertificato;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeTCertificatoPk;
import it.csi.sicee.siceeweb.business.dao.exceptions.SiceeTCertificatoDaoException;

import java.util.Date;
import java.util.List;

public interface SiceeTCertificatoDao
{
	/**
	 * Method 'insert'
	 * 
	 * @param dto
	 * @return SiceeTCertificatoPk
	 */
	public SiceeTCertificatoPk insert(SiceeTCertificato dto);

	/** 
	 * Updates a single row in the SICEE_T_CERTIFICATO table.
	 *
	 * @param pk the pk
	 * @param dto the dto
	 * @throws SiceeTCertificatoDaoException the sicee t certificato dao exception
	 */
	public void update(SiceeTCertificatoPk pk, SiceeTCertificato dto) throws SiceeTCertificatoDaoException;

	/** 
	 * Deletes a single row in the SICEE_T_CERTIFICATO table.
	 *
	 * @param pk the pk
	 * @throws SiceeTCertificatoDaoException the sicee t certificato dao exception
	 */
	public void delete(SiceeTCertificatoPk pk) throws SiceeTCertificatoDaoException;

	/** 
	 * Returns all rows from the SICEE_T_CERTIFICATO table that match the criteria 'ID_CERTIFICATORE = :idCertificatore AND PROGR_CERTIFICATO = :progrCertificato AND ANNO = :anno'.
	 *
	 * @param idCertificatore the id certificatore
	 * @param progrCertificato the progr certificato
	 * @param anno the anno
	 * @return the sicee t certificato
	 * @throws SiceeTCertificatoDaoException the sicee t certificato dao exception
	 */
	public SiceeTCertificato findByPrimaryKey(String idCertificatore, String progrCertificato, String anno) throws SiceeTCertificatoDaoException;

	/** 
	 * Returns all rows from the SICEE_T_CERTIFICATO table that match the criteria 'FK_STATO = :1'.
	 * QUESTO METODO E' PER  RIPORTARE A NUOVO GLI APE IN STATO BOZZA - è un trattamento dati 
	 */
	public List<SiceeTCertificato> findRiportareANuovo() throws SiceeTCertificatoDaoException;
	
/**
	 * Returns all rows from the SICEE_T_CERTIFICATO table that match the criteria 'FOTO = :foto'.
	 *
	 * @param foto the foto
	 * @return the list
	 * @throws SiceeTCertificatoDaoException the sicee t certificato dao exception
	 */
	public List<SiceeTCertificato> findWhereFotoEquals(byte[] foto) throws SiceeTCertificatoDaoException;

	/**
	 * Returns all rows from the SICEE_T_CERTIFICATO table that match the criteria 'ACE_FIRMATO = :aceFirmato'.
	 *
	 * @param aceFirmato the ace firmato
	 * @return the list
	 * @throws SiceeTCertificatoDaoException the sicee t certificato dao exception
	 */
	public List<SiceeTCertificato> findWhereAceFirmatoEquals(byte[] aceFirmato) throws SiceeTCertificatoDaoException;

	/**
	 * Returns all rows from the SICEE_T_CERTIFICATO table that match the criteria ''.
	 *
	 * @return the list
	 * @throws SiceeTCertificatoDaoException the sicee t certificato dao exception
	 */
/**
	 * Returns all rows from the SICEE_T_CERTIFICATO table that match the criteria 'FK_STATO = :fkStato'.
	 *
	 * @param fkStato the fk stato
	 * @return the list
	 * @throws SiceeTCertificatoDaoException the sicee t certificato dao exception
	 */
	public List<SiceeTCertificato> findBySiceeDStatoCert(Integer fkStato) throws SiceeTCertificatoDaoException;


	/** 
	 * Returns all rows from the SICEE_T_CERTIFICATO table that match the criteria 'CIRCO = :circo'.
	 */
	public List<SiceeTCertificato> findWhereCircoEquals(Integer circo) throws SiceeTCertificatoDaoException;

	/** 
	 * Returns all rows from the SICEE_T_CERTIFICATO table that match the criteria 'FLG_CONDOMINIO = :flgCondominio'.
	 */
	public List<SiceeTCertificato> findWhereFlgCondominioEquals(String flgCondominio) throws SiceeTCertificatoDaoException;

	/** 
	 * Returns all rows from the SICEE_T_CERTIFICATO table that match the criteria 'FK_MOTIVO_SOST = :fkMotivoSost'.
	 */
	public List<SiceeTCertificato> findBySiceeDMotivoSost(Integer fkMotivoSost) throws SiceeTCertificatoDaoException;

	/**
	 * Returns all rows from the SICEE_T_CERTIFICATO table that match the criteria 'ID_CERTIFICATORE = :idCertificatore'.
	 *
	 * @param idCertificatore the id certificatore
	 * @return the list
	 * @throws SiceeTCertificatoDaoException the sicee t certificato dao exception
	 */
	public List<SiceeTCertificato> findBySiceeTCertificatore(String idCertificatore) throws SiceeTCertificatoDaoException;


	/**
	 * Returns all rows from the SICEE_T_CERTIFICATO table that match the criteria 'FK_TRANSAZIONE_ACE = :fkTransazioneAce'.
	 *
	 * @param fkTransazioneAce the fk transazione ace
	 * @return the list
	 * @throws SiceeTCertificatoDaoException the sicee t certificato dao exception
	 */
	public List<SiceeTCertificato> findBySiceeTTransazioneAce(long fkTransazioneAce) throws SiceeTCertificatoDaoException;


	/** 
	 * Returns all rows from the SICEE_T_CERTIFICATO table that match the criteria 'dt_upload >= SICEE_T_PARAMETRI.data_upload_inizio_batch
and dt_upload < SICEE_T_PARAMETRI.data_upload_fine_batch
and fk_stato = :fkStato
and identific_pdf is not null
and id_certificatore||' '||progr_certificato||' '||anno 
not in (select id_certificatore||' '||progr_certificato||' '||anno 
from SICEE_T_VERIFY_REPORT)'.
	 */
	public List<SiceeTCertificato> findWhereDataInRange(Integer fkStato) throws SiceeTCertificatoDaoException;

	/** 
	 * Returns all rows from the SICEE_T_CERTIFICATO table that match the criteria ''.
	 */
	public List<SiceeTCertificato> findAll() throws SiceeTCertificatoDaoException;

	/** 
	 * Returns all rows from the SICEE_T_CERTIFICATO table that match the criteria 'ID_CERTIFICATORE = :idCertificatore'.
	 *
	 * @param idCertificatore the id certificatore
	 * @return the list
	 * @throws SiceeTCertificatoDaoException the sicee t certificato dao exception
	 */
	public List<SiceeTCertificato> findWhereIdCertificatoreEquals(String idCertificatore) throws SiceeTCertificatoDaoException;

	/** 
	 * Returns all rows from the SICEE_T_CERTIFICATO table that match the criteria 'PROGR_CERTIFICATO = :progrCertificato'.
	 *
	 * @param progrCertificato the progr certificato
	 * @return the list
	 * @throws SiceeTCertificatoDaoException the sicee t certificato dao exception
	 */
	public List<SiceeTCertificato> findWhereProgrCertificatoEquals(String progrCertificato) throws SiceeTCertificatoDaoException;

	/** 
	 * Returns all rows from the SICEE_T_CERTIFICATO table that match the criteria 'ANNO = :anno'.
	 *
	 * @param anno the anno
	 * @return the list
	 * @throws SiceeTCertificatoDaoException the sicee t certificato dao exception
	 */
	public List<SiceeTCertificato> findWhereAnnoEquals(String anno) throws SiceeTCertificatoDaoException;

	/** 
	 * Returns all rows from the SICEE_T_CERTIFICATO table that match the criteria 'DT_SCADENZA = :dtScadenza'.
	 *
	 * @param dtScadenza the dt scadenza
	 * @return the list
	 * @throws SiceeTCertificatoDaoException the sicee t certificato dao exception
	 */
	public List<SiceeTCertificato> findWhereDtScadenzaEquals(Date dtScadenza) throws SiceeTCertificatoDaoException;

	/** 
	 * Returns all rows from the SICEE_T_CERTIFICATO table that match the criteria 'FK_TRANSAZIONE_ACE = :fkTransazioneAce'.
	 *
	 * @param fkTransazioneAce the fk transazione ace
	 * @return the list
	 * @throws SiceeTCertificatoDaoException the sicee t certificato dao exception
	 */
	public List<SiceeTCertificato> findWhereFkTransazioneAceEquals(long fkTransazioneAce) throws SiceeTCertificatoDaoException;

	/** 
	 * Returns all rows from the SICEE_T_CERTIFICATO table that match the criteria 'DT_ACQUISTO = :dtAcquisto'.
	 *
	 * @param dtAcquisto the dt acquisto
	 * @return the list
	 * @throws SiceeTCertificatoDaoException the sicee t certificato dao exception
	 */
	public List<SiceeTCertificato> findWhereDtAcquistoEquals(Date dtAcquisto) throws SiceeTCertificatoDaoException;

	/** 
	 * Returns all rows from the SICEE_T_CERTIFICATO table that match the criteria 'FK_STATO = :fkStato'.
	 *
	 * @param fkStato the fk stato
	 * @return the list
	 * @throws SiceeTCertificatoDaoException the sicee t certificato dao exception
	 */
	public List<SiceeTCertificato> findWhereFkStatoEquals(Integer fkStato) throws SiceeTCertificatoDaoException;

	/** 
	 * Returns all rows from the SICEE_T_CERTIFICATO table that match the criteria 'FK_DICHIARAZIONE = :fkDichiarazione'.
	 *
	 * @param fkDichiarazione the fk dichiarazione
	 * @return the list
	 * @throws SiceeTCertificatoDaoException the sicee t certificato dao exception
	 */
	public List<SiceeTCertificato> findWhereFkDichiarazioneEquals(Integer fkDichiarazione) throws SiceeTCertificatoDaoException;

	/** 
	 * Returns all rows from the SICEE_T_CERTIFICATO table that match the criteria 'FLG_DICHIARAZIONE = :flgDichiarazione'.
	 *
	 * @param flgDichiarazione the flg dichiarazione
	 * @return the list
	 * @throws SiceeTCertificatoDaoException the sicee t certificato dao exception
	 */
	public List<SiceeTCertificato> findWhereFlgDichiarazioneEquals(String flgDichiarazione) throws SiceeTCertificatoDaoException;

	/** 
	 * Returns all rows from the SICEE_T_CERTIFICATO table that match the criteria 'ID_INDIRIZZO = :idIndirizzo'.
	 *
	 * @param idIndirizzo the id indirizzo
	 * @return the list
	 * @throws SiceeTCertificatoDaoException the sicee t certificato dao exception
	 */
	public List<SiceeTCertificato> findWhereIdIndirizzoEquals(Integer idIndirizzo) throws SiceeTCertificatoDaoException;

	/** 
	 * Returns all rows from the SICEE_T_CERTIFICATO table that match the criteria 'DESC_INDIRIZZO = :descIndirizzo'.
	 *
	 * @param descIndirizzo the desc indirizzo
	 * @return the list
	 * @throws SiceeTCertificatoDaoException the sicee t certificato dao exception
	 */
	public List<SiceeTCertificato> findWhereDescIndirizzoEquals(String descIndirizzo) throws SiceeTCertificatoDaoException;

	/** 
	 * Returns all rows from the SICEE_T_CERTIFICATO table that match the criteria 'DT_INIZIO = :dtInizio'.
	 *
	 * @param dtInizio the dt inizio
	 * @return the list
	 * @throws SiceeTCertificatoDaoException the sicee t certificato dao exception
	 */
	public List<SiceeTCertificato> findWhereDtInizioEquals(Date dtInizio) throws SiceeTCertificatoDaoException;

	/** 
	 * Returns all rows from the SICEE_T_CERTIFICATO table that match the criteria 'CAP = :cap'.
	 *
	 * @param cap the cap
	 * @return the list
	 * @throws SiceeTCertificatoDaoException the sicee t certificato dao exception
	 */
	public List<SiceeTCertificato> findWhereCapEquals(String cap) throws SiceeTCertificatoDaoException;

	/** 
	 * Returns all rows from the SICEE_T_CERTIFICATO table that match the criteria 'ID_COMUNE = :idComune'.
	 *
	 * @param idComune the id comune
	 * @return the list
	 * @throws SiceeTCertificatoDaoException the sicee t certificato dao exception
	 */
	public List<SiceeTCertificato> findWhereIdComuneEquals(String idComune) throws SiceeTCertificatoDaoException;

	/** 
	 * Returns all rows from the SICEE_T_CERTIFICATO table that match the criteria 'DESC_COMUNE = :descComune'.
	 *
	 * @param descComune the desc comune
	 * @return the list
	 * @throws SiceeTCertificatoDaoException the sicee t certificato dao exception
	 */
	public List<SiceeTCertificato> findWhereDescComuneEquals(String descComune) throws SiceeTCertificatoDaoException;

	/** 
	 * Returns all rows from the SICEE_T_CERTIFICATO table that match the criteria 'SEZIONE = :sezione'.
	 *
	 * @param sezione the sezione
	 * @return the list
	 * @throws SiceeTCertificatoDaoException the sicee t certificato dao exception
	 */
	public List<SiceeTCertificato> findWhereSezioneEquals(String sezione) throws SiceeTCertificatoDaoException;

	/** 
	 * Returns all rows from the SICEE_T_CERTIFICATO table that match the criteria 'ID_PROV = :idProv'.
	 *
	 * @param idProv the id prov
	 * @return the list
	 * @throws SiceeTCertificatoDaoException the sicee t certificato dao exception
	 */
	public List<SiceeTCertificato> findWhereIdProvEquals(String idProv) throws SiceeTCertificatoDaoException;

	/** 
	 * Returns all rows from the SICEE_T_CERTIFICATO table that match the criteria 'FOGLIO = :foglio'.
	 *
	 * @param foglio the foglio
	 * @return the list
	 * @throws SiceeTCertificatoDaoException the sicee t certificato dao exception
	 */
	public List<SiceeTCertificato> findWhereFoglioEquals(String foglio) throws SiceeTCertificatoDaoException;

	/** 
	 * Returns all rows from the SICEE_T_CERTIFICATO table that match the criteria 'DESC_PROV = :descProv'.
	 *
	 * @param descProv the desc prov
	 * @return the list
	 * @throws SiceeTCertificatoDaoException the sicee t certificato dao exception
	 */
	public List<SiceeTCertificato> findWhereDescProvEquals(String descProv) throws SiceeTCertificatoDaoException;

	/** 
	 * Returns all rows from the SICEE_T_CERTIFICATO table that match the criteria 'ID_REGIONE = :idRegione'.
	 *
	 * @param idRegione the id regione
	 * @return the list
	 * @throws SiceeTCertificatoDaoException the sicee t certificato dao exception
	 */
	public List<SiceeTCertificato> findWhereIdRegioneEquals(String idRegione) throws SiceeTCertificatoDaoException;

	/** 
	 * Returns all rows from the SICEE_T_CERTIFICATO table that match the criteria 'PARTICELLA = :particella'.
	 *
	 * @param particella the particella
	 * @return the list
	 * @throws SiceeTCertificatoDaoException the sicee t certificato dao exception
	 */
	public List<SiceeTCertificato> findWhereParticellaEquals(String particella) throws SiceeTCertificatoDaoException;

	/** 
	 * Returns all rows from the SICEE_T_CERTIFICATO table that match the criteria 'SUBALTERNO = :subalterno'.
	 *
	 * @param subalterno the subalterno
	 * @return the list
	 * @throws SiceeTCertificatoDaoException the sicee t certificato dao exception
	 */
	public List<SiceeTCertificato> findWhereSubalternoEquals(String subalterno) throws SiceeTCertificatoDaoException;

	/** 
	 * Returns all rows from the SICEE_T_CERTIFICATO table that match the criteria 'DESC_REGIONE = :descRegione'.
	 *
	 * @param descRegione the desc regione
	 * @return the list
	 * @throws SiceeTCertificatoDaoException the sicee t certificato dao exception
	 */
	public List<SiceeTCertificato> findWhereDescRegioneEquals(String descRegione) throws SiceeTCertificatoDaoException;

	/** 
	 * Returns all rows from the SICEE_T_CERTIFICATO table that match the criteria 'PIANO = :piano'.
	 *
	 * @param piano the piano
	 * @return the list
	 * @throws SiceeTCertificatoDaoException the sicee t certificato dao exception
	 */
	public List<SiceeTCertificato> findWherePianoEquals(Integer piano) throws SiceeTCertificatoDaoException;

	/** 
	 * Returns all rows from the SICEE_T_CERTIFICATO table that match the criteria 'NUM_PIANI_COMPLESSIVI = :numPianiComplessivi'.
	 *
	 * @param numPianiComplessivi the num piani complessivi
	 * @return the list
	 * @throws SiceeTCertificatoDaoException the sicee t certificato dao exception
	 */
	public List<SiceeTCertificato> findWhereNumPianiComplessiviEquals(Integer numPianiComplessivi) throws SiceeTCertificatoDaoException;

	/** 
	 * Returns all rows from the SICEE_T_CERTIFICATO table that match the criteria 'NUM_APPARTAMENTI = :numAppartamenti'.
	 *
	 * @param numAppartamenti the num appartamenti
	 * @return the list
	 * @throws SiceeTCertificatoDaoException the sicee t certificato dao exception
	 */
	public List<SiceeTCertificato> findWhereNumAppartamentiEquals(Integer numAppartamenti) throws SiceeTCertificatoDaoException;

	/** 
	 * Returns all rows from the SICEE_T_CERTIFICATO table that match the criteria 'SCALA = :scala'.
	 *
	 * @param scala the scala
	 * @return the list
	 * @throws SiceeTCertificatoDaoException the sicee t certificato dao exception
	 */
	public List<SiceeTCertificato> findWhereScalaEquals(String scala) throws SiceeTCertificatoDaoException;

	/** 
	 * Returns all rows from the SICEE_T_CERTIFICATO table that match the criteria 'INTERNO = :interno'.
	 *
	 * @param interno the interno
	 * @return the list
	 * @throws SiceeTCertificatoDaoException the sicee t certificato dao exception
	 */
	public List<SiceeTCertificato> findWhereInternoEquals(String interno) throws SiceeTCertificatoDaoException;

	/** 
	 * Returns all rows from the SICEE_T_CERTIFICATO table that match the criteria 'NOTE = :note'.
	 *
	 * @param note the note
	 * @return the list
	 * @throws SiceeTCertificatoDaoException the sicee t certificato dao exception
	 */
	public List<SiceeTCertificato> findWhereNoteEquals(String note) throws SiceeTCertificatoDaoException;

	/** 
	 * Returns all rows from the SICEE_T_CERTIFICATO table that match the criteria 'FLG_STAMPA_DEF = :flgStampaDef'.
	 *
	 * @param flgStampaDef the flg stampa def
	 * @return the list
	 * @throws SiceeTCertificatoDaoException the sicee t certificato dao exception
	 */
	public List<SiceeTCertificato> findWhereFlgStampaDefEquals(String flgStampaDef) throws SiceeTCertificatoDaoException;

	/** 
	 * Returns all rows from the SICEE_T_CERTIFICATO table that match the criteria 'NOME_ACE_FIRMATO = :nomeAceFirmato'.
	 *
	 * @param nomeAceFirmato the nome ace firmato
	 * @return the list
	 * @throws SiceeTCertificatoDaoException the sicee t certificato dao exception
	 */
	public List<SiceeTCertificato> findWhereNomeAceFirmatoEquals(String nomeAceFirmato) throws SiceeTCertificatoDaoException;

	/** 
	 * Returns all rows from the SICEE_T_CERTIFICATO table that match the criteria 'NOME_COCERTIFICATORE = :nomeCocertificatore'.
	 *
	 * @param nomeCocertificatore the nome cocertificatore
	 * @return the list
	 * @throws SiceeTCertificatoDaoException the sicee t certificato dao exception
	 */
	public List<SiceeTCertificato> findWhereNomeCocertificatoreEquals(String nomeCocertificatore) throws SiceeTCertificatoDaoException;

	/** 
	 * Returns all rows from the SICEE_T_CERTIFICATO table that match the criteria 'COGNOME_COCERTIFICATORE = :cognomeCocertificatore'.
	 *
	 * @param cognomeCocertificatore the cognome cocertificatore
	 * @return the list
	 * @throws SiceeTCertificatoDaoException the sicee t certificato dao exception
	 */
	public List<SiceeTCertificato> findWhereCognomeCocertificatoreEquals(String cognomeCocertificatore) throws SiceeTCertificatoDaoException;

	/** 
	 * Returns all rows from the SICEE_T_CERTIFICATO table that match the criteria 'NUM_COCERTIFICATORE = :numCocertificatore'.
	 *
	 * @param numCocertificatore the num cocertificatore
	 * @return the list
	 * @throws SiceeTCertificatoDaoException the sicee t certificato dao exception
	 */
	public List<SiceeTCertificato> findWhereNumCocertificatoreEquals(String numCocertificatore) throws SiceeTCertificatoDaoException;

	/** 
	 * Returns all rows from the SICEE_T_CERTIFICATO table that match the criteria 'NUM_CIVICO = :numCivico'.
	 *
	 * @param numCivico the num civico
	 * @return the list
	 * @throws SiceeTCertificatoDaoException the sicee t certificato dao exception
	 */
	public List<SiceeTCertificato> findWhereNumCivicoEquals(String numCivico) throws SiceeTCertificatoDaoException;

	/** 
	 * Returns all rows from the SICEE_T_CERTIFICATO table that match the criteria 'IDENTIFIC_PDF = :identificPdf'.
	 *
	 * @param identificPdf the identific pdf
	 * @return the list
	 * @throws SiceeTCertificatoDaoException the sicee t certificato dao exception
	 */
	public List<SiceeTCertificato> findWhereIdentificPdfEquals(String identificPdf) throws SiceeTCertificatoDaoException;

	/** 
	 * Returns all rows from the SICEE_T_CERTIFICATO table that match the criteria 'IDENTIFIC_FOTO = :identificFoto'.
	 *
	 * @param identificFoto the identific foto
	 * @return the list
	 * @throws SiceeTCertificatoDaoException the sicee t certificato dao exception
	 */
	public List<SiceeTCertificato> findWhereIdentificFotoEquals(String identificFoto) throws SiceeTCertificatoDaoException;

	/** 
	 * Returns all rows from the SICEE_T_CERTIFICATO table that match the criteria 'LUOGO_DICHIARAZIONE = :luogoDichiarazione'.
	 *
	 * @param luogoDichiarazione the luogo dichiarazione
	 * @return the list
	 * @throws SiceeTCertificatoDaoException the sicee t certificato dao exception
	 */
	public List<SiceeTCertificato> findWhereLuogoDichiarazioneEquals(String luogoDichiarazione) throws SiceeTCertificatoDaoException;

	/** 
	 * Returns all rows from the SICEE_T_CERTIFICATO table that match the criteria 'NOME_FOTO = :nomeFoto'.
	 *
	 * @param nomeFoto the nome foto
	 * @return the list
	 * @throws SiceeTCertificatoDaoException the sicee t certificato dao exception
	 */
	public List<SiceeTCertificato> findWhereNomeFotoEquals(String nomeFoto) throws SiceeTCertificatoDaoException;

	/** 
	 * Returns all rows from the SICEE_T_CERTIFICATO table that match the criteria 'NOME_PDF = :nomePdf'.
	 *
	 * @param nomePdf the nome pdf
	 * @return the list
	 * @throws SiceeTCertificatoDaoException the sicee t certificato dao exception
	 */
	public List<SiceeTCertificato> findWhereNomePdfEquals(String nomePdf) throws SiceeTCertificatoDaoException;

	/** 
	 * Returns all rows from the SICEE_T_CERTIFICATO table that match the criteria 'DT_UPLOAD = :dtUpload'.
	 *
	 * @param dtUpload the dt upload
	 * @return the list
	 * @throws SiceeTCertificatoDaoException the sicee t certificato dao exception
	 */
	public List<SiceeTCertificato> findWhereDtUploadEquals(Date dtUpload) throws SiceeTCertificatoDaoException;

	/** 
	 * Returns all rows from the SICEE_T_CERTIFICATO table that match the criteria 'FLG_EDIFICIO_PERFORMANTE = :flgEdificioPerformante'.
	 *
	 * @param flgEdificioPerformante the flg edificio performante
	 * @return the list
	 * @throws SiceeTCertificatoDaoException the sicee t certificato dao exception
	 */
	public List<SiceeTCertificato> findWhereFlgEdificioPerformanteEquals(String flgEdificioPerformante) throws SiceeTCertificatoDaoException;

	/** 
	 * Returns all rows from the SICEE_T_CERTIFICATO table that match the criteria 'FLG_SIGMATER = :flgSigmater'.
	 *
	 * @param flgSigmater the flg sigmater
	 * @return the list
	 * @throws SiceeTCertificatoDaoException the sicee t certificato dao exception
	 */
	public List<SiceeTCertificato> findWhereFlgSigmaterEquals(String flgSigmater) throws SiceeTCertificatoDaoException;

	/** 
	 * Returns all rows from the SICEE_T_CERTIFICATO table that match the criteria 'FK_MOTIVO_SOST = :fkMotivoSost'.
	 *
	 * @param fkMotivoSost the fk motivo sost
	 * @return the list
	 * @throws SiceeTCertificatoDaoException the sicee t certificato dao exception
	 */
	public List<SiceeTCertificato> findWhereFkMotivoSostEquals(Integer fkMotivoSost) throws SiceeTCertificatoDaoException;

	/** 
	 * Returns all rows from the SICEE_T_CERTIFICATO table that match the criteria 'DT_SOSTITUZIONE = :dtSostituzione'.
	 *
	 * @param dtSostituzione the dt sostituzione
	 * @return the list
	 * @throws SiceeTCertificatoDaoException the sicee t certificato dao exception
	 */
	public List<SiceeTCertificato> findWhereDtSostituzioneEquals(Date dtSostituzione) throws SiceeTCertificatoDaoException;

	/** 
	 * Returns all rows from the SICEE_T_CERTIFICATO table that match the criteria 'NOTE_SOSTITUZIONE = :noteSostituzione'.
	 *
	 * @param noteSostituzione the note sostituzione
	 * @return the list
	 * @throws SiceeTCertificatoDaoException the sicee t certificato dao exception
	 */
	public List<SiceeTCertificato> findWhereNoteSostituzioneEquals(String noteSostituzione) throws SiceeTCertificatoDaoException;

	/** 
	 * Returns all rows from the SICEE_T_CERTIFICATO table that match the criteria 'DT_FOTO = :dtFoto'.
	 *
	 * @param dtFoto the dt foto
	 * @return the list
	 * @throws SiceeTCertificatoDaoException the sicee t certificato dao exception
	 */
	public List<SiceeTCertificato> findWhereDtFotoEquals(Date dtFoto) throws SiceeTCertificatoDaoException;

	/** 
	 * Returns all rows from the SICEE_T_CERTIFICATO table that match the criteria 'FLG_OLD = :flgOld'.
	 */
	public List<SiceeTCertificato> findWhereFlgOldEquals(String flgOld) throws SiceeTCertificatoDaoException;

	/** 
	 * Returns all rows from the SICEE_T_CERTIFICATO table that match the criteria 'COORD_N = :coordN'.
	 */
	public List<SiceeTCertificato> findWhereCoordNEquals(long coordN) throws SiceeTCertificatoDaoException;

	/** 
	 * Returns all rows from the SICEE_T_CERTIFICATO table that match the criteria 'COORD_E = :coordE'.
	 */
	public List<SiceeTCertificato> findWhereCoordEEquals(long coordE) throws SiceeTCertificatoDaoException;

	/** 
	 * Returns all rows from the SICEE_T_CERTIFICATO table that match the criteria 'FLG_NO_RACCOMAND = :flgNoRaccomand'.
	 */
	public List<SiceeTCertificato> findWhereFlgNoRaccomandEquals(String flgNoRaccomand) throws SiceeTCertificatoDaoException;

	/** 
	 * Returns all rows from the SICEE_T_CERTIFICATO table that match the criteria 'RIF_CATASTO = :rifCatasto'.
	 */
	
	public List<SiceeTCertificato> findWhereRifCatastoEquals(String rifCatasto) throws SiceeTCertificatoDaoException;

	/** 
	 * Returns all rows from the SICEE_T_CERTIFICATO table that match the criteria 'CODICE_COMUNE_CATASTALE = :codiceComuneCatastale'.
	 */
	
	public List<SiceeTCertificato> findWhereCodiceComuneCatastaleEquals(String codiceComuneCatastale) throws SiceeTCertificatoDaoException;

	/** 
	 * Returns the rows from the SICEE_T_CERTIFICATO table that matches the specified primary-key value.
	 *
	 * @param pk the pk
	 * @return the sicee t certificato
	 * @throws SiceeTCertificatoDaoException the sicee t certificato dao exception
	 */
	public SiceeTCertificato findByPrimaryKey(SiceeTCertificatoPk pk) throws SiceeTCertificatoDaoException;

}
