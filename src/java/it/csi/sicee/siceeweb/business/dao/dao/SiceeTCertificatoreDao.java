/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceeweb.business.dao.dao;

import it.csi.sicee.siceeweb.business.dao.dao.SiceeTCertificatoreDao;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeTCertificatore;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeTCertificatorePk;
import it.csi.sicee.siceeweb.business.dao.exceptions.SiceeTCertificatoreDaoException;

import java.util.Date;
import java.util.List;

public interface SiceeTCertificatoreDao
{
	/**
	 * Method 'insert'
	 * 
	 * @param dto
	 * @return SiceeTCertificatorePk
	 */
	public SiceeTCertificatorePk insert(SiceeTCertificatore dto);

	/** 
	 * Updates a single row in the SICEE_T_CERTIFICATORE table.
	 */
	public void update(SiceeTCertificatorePk pk, SiceeTCertificatore dto) throws SiceeTCertificatoreDaoException;

	/** 
	 * Deletes a single row in the SICEE_T_CERTIFICATORE table.
	 */
	public void delete(SiceeTCertificatorePk pk) throws SiceeTCertificatoreDaoException;

	/** 
	 * Returns all rows from the SICEE_T_CERTIFICATORE table that match the criteria 'ID_CERTIFICATORE = :idCertificatore'.
	 */
	public SiceeTCertificatore findByPrimaryKey(String idCertificatore) throws SiceeTCertificatoreDaoException;

	/** 
	 * Returns all rows from the SICEE_T_CERTIFICATORE table that match the criteria ''.
	 */
	public List<SiceeTCertificatore> findAll() throws SiceeTCertificatoreDaoException;

	/** 
	 * Returns all rows from the SICEE_T_CERTIFICATORE table that match the criteria 'CODICE_FISCALE LIKE :codiceFiscale%'.
	 */
	
	public List<SiceeTCertificatore> findByCf(String codiceFiscale) throws SiceeTCertificatoreDaoException;

	/** 
	 * Returns all rows from the SICEE_T_CERTIFICATORE table that match the criteria 'FK_ISTRUZIONE = :fkIstruzione'.
	 */
	public List<SiceeTCertificatore> findBySiceeDIstruzione(Integer fkIstruzione) throws SiceeTCertificatoreDaoException;

	/** 
	 * Returns all rows from the SICEE_T_CERTIFICATORE table that match the criteria 'FK_TITOLO = :fkTitolo'.
	 */
	public List<SiceeTCertificatore> findBySiceeDTitolo(String fkTitolo) throws SiceeTCertificatoreDaoException;

	/** 
	 * Returns all rows from the SICEE_T_CERTIFICATORE table that match the criteria 'FK_AZIENDA = :fkAzienda'.
	 */
	public List<SiceeTCertificatore> findBySiceeTAzienda(long fkAzienda) throws SiceeTCertificatoreDaoException;

	/** 
	 * Returns all rows from the SICEE_T_CERTIFICATORE table that match the criteria 'ID_CERTIFICATORE = :idCertificatore'.
	 */
	public List<SiceeTCertificatore> findWhereIdCertificatoreEquals(String idCertificatore) throws SiceeTCertificatoreDaoException;

	/** 
	 * Returns all rows from the SICEE_T_CERTIFICATORE table that match the criteria 'FK_AZIENDA = :fkAzienda'.
	 */
	public List<SiceeTCertificatore> findWhereFkAziendaEquals(long fkAzienda) throws SiceeTCertificatoreDaoException;

	/** 
	 * Returns all rows from the SICEE_T_CERTIFICATORE table that match the criteria 'FK_TITOLO = :fkTitolo'.
	 */
	public List<SiceeTCertificatore> findWhereFkTitoloEquals(String fkTitolo) throws SiceeTCertificatoreDaoException;

	/** 
	 * Returns all rows from the SICEE_T_CERTIFICATORE table that match the criteria 'NOME = :nome'.
	 */
	public List<SiceeTCertificatore> findWhereNomeEquals(String nome) throws SiceeTCertificatoreDaoException;

	/** 
	 * Returns all rows from the SICEE_T_CERTIFICATORE table that match the criteria 'COGNOME = :cognome'.
	 */
	public List<SiceeTCertificatore> findWhereCognomeEquals(String cognome) throws SiceeTCertificatoreDaoException;

	/** 
	 * Returns all rows from the SICEE_T_CERTIFICATORE table that match the criteria 'CODICE_FISCALE = :codiceFiscale'.
	 */
	public List<SiceeTCertificatore> findWhereCodiceFiscaleEquals(String codiceFiscale) throws SiceeTCertificatoreDaoException;

	/** 
	 * Returns all rows from the SICEE_T_CERTIFICATORE table that match the criteria 'ID_COMUNE_NASCITA = :idComuneNascita'.
	 */
	public List<SiceeTCertificatore> findWhereIdComuneNascitaEquals(String idComuneNascita) throws SiceeTCertificatoreDaoException;

	/** 
	 * Returns all rows from the SICEE_T_CERTIFICATORE table that match the criteria 'DESC_COMUNE_NASCITA = :descComuneNascita'.
	 */
	public List<SiceeTCertificatore> findWhereDescComuneNascitaEquals(String descComuneNascita) throws SiceeTCertificatoreDaoException;

	/** 
	 * Returns all rows from the SICEE_T_CERTIFICATORE table that match the criteria 'DT_NASCITA = :dtNascita'.
	 */
	public List<SiceeTCertificatore> findWhereDtNascitaEquals(Date dtNascita) throws SiceeTCertificatoreDaoException;

	/** 
	 * Returns all rows from the SICEE_T_CERTIFICATORE table that match the criteria 'ID_PROV_NASCITA = :idProvNascita'.
	 */
	public List<SiceeTCertificatore> findWhereIdProvNascitaEquals(String idProvNascita) throws SiceeTCertificatoreDaoException;

	/** 
	 * Returns all rows from the SICEE_T_CERTIFICATORE table that match the criteria 'ID_INDIRIZZO = :idIndirizzo'.
	 */
	public List<SiceeTCertificatore> findWhereIdIndirizzoEquals(Integer idIndirizzo) throws SiceeTCertificatoreDaoException;

	/** 
	 * Returns all rows from the SICEE_T_CERTIFICATORE table that match the criteria 'DESC_PROV_NASCITA = :descProvNascita'.
	 */
	public List<SiceeTCertificatore> findWhereDescProvNascitaEquals(String descProvNascita) throws SiceeTCertificatoreDaoException;

	/** 
	 * Returns all rows from the SICEE_T_CERTIFICATORE table that match the criteria 'ID_REGIONE_NASCITA = :idRegioneNascita'.
	 */
	public List<SiceeTCertificatore> findWhereIdRegioneNascitaEquals(String idRegioneNascita) throws SiceeTCertificatoreDaoException;

	/** 
	 * Returns all rows from the SICEE_T_CERTIFICATORE table that match the criteria 'DESC_INDIRIZZO = :descIndirizzo'.
	 */
	public List<SiceeTCertificatore> findWhereDescIndirizzoEquals(String descIndirizzo) throws SiceeTCertificatoreDaoException;

	/** 
	 * Returns all rows from the SICEE_T_CERTIFICATORE table that match the criteria 'CAP = :cap'.
	 */
	public List<SiceeTCertificatore> findWhereCapEquals(String cap) throws SiceeTCertificatoreDaoException;

	/** 
	 * Returns all rows from the SICEE_T_CERTIFICATORE table that match the criteria 'DESC_REGIONE_NASCITA = :descRegioneNascita'.
	 */
	public List<SiceeTCertificatore> findWhereDescRegioneNascitaEquals(String descRegioneNascita) throws SiceeTCertificatoreDaoException;

	/** 
	 * Returns all rows from the SICEE_T_CERTIFICATORE table that match the criteria 'ID_COMUNE_RESIDENZA = :idComuneResidenza'.
	 */
	public List<SiceeTCertificatore> findWhereIdComuneResidenzaEquals(String idComuneResidenza) throws SiceeTCertificatoreDaoException;

	/** 
	 * Returns all rows from the SICEE_T_CERTIFICATORE table that match the criteria 'NUM_CIVICO_RESIDENZA = :numCivicoResidenza'.
	 */
	public List<SiceeTCertificatore> findWhereNumCivicoResidenzaEquals(String numCivicoResidenza) throws SiceeTCertificatoreDaoException;

	/** 
	 * Returns all rows from the SICEE_T_CERTIFICATORE table that match the criteria 'DESC_COMUNE_RESIDENZA = :descComuneResidenza'.
	 */
	public List<SiceeTCertificatore> findWhereDescComuneResidenzaEquals(String descComuneResidenza) throws SiceeTCertificatoreDaoException;

	/** 
	 * Returns all rows from the SICEE_T_CERTIFICATORE table that match the criteria 'FLG_EDIFICI = :flgEdifici'.
	 */
	public List<SiceeTCertificatore> findWhereFlgEdificiEquals(String flgEdifici) throws SiceeTCertificatoreDaoException;

	/** 
	 * Returns all rows from the SICEE_T_CERTIFICATORE table that match the criteria 'FLG_IMPIANTI = :flgImpianti'.
	 */
	public List<SiceeTCertificatore> findWhereFlgImpiantiEquals(String flgImpianti) throws SiceeTCertificatoreDaoException;

	/** 
	 * Returns all rows from the SICEE_T_CERTIFICATORE table that match the criteria 'FLG_VERIFICATO = :flgVerificato'.
	 */
	public List<SiceeTCertificatore> findWhereFlgVerificatoEquals(String flgVerificato) throws SiceeTCertificatoreDaoException;

	/** 
	 * Returns all rows from the SICEE_T_CERTIFICATORE table that match the criteria 'FLG_PAGAMENTO = :flgPagamento'.
	 */
	public List<SiceeTCertificatore> findWhereFlgPagamentoEquals(String flgPagamento) throws SiceeTCertificatoreDaoException;

	/** 
	 * Returns all rows from the SICEE_T_CERTIFICATORE table that match the criteria 'NOTE = :note'.
	 */
	public List<SiceeTCertificatore> findWhereNoteEquals(String note) throws SiceeTCertificatoreDaoException;

	/** 
	 * Returns all rows from the SICEE_T_CERTIFICATORE table that match the criteria 'ID_PROV_RESIDENZA = :idProvResidenza'.
	 */
	public List<SiceeTCertificatore> findWhereIdProvResidenzaEquals(String idProvResidenza) throws SiceeTCertificatoreDaoException;

	/** 
	 * Returns all rows from the SICEE_T_CERTIFICATORE table that match the criteria 'DT_ISCR_ELENCO = :dtIscrElenco'.
	 */
	public List<SiceeTCertificatore> findWhereDtIscrElencoEquals(Date dtIscrElenco) throws SiceeTCertificatoreDaoException;

	/** 
	 * Returns all rows from the SICEE_T_CERTIFICATORE table that match the criteria 'DESC_PROV_RESIDENZA = :descProvResidenza'.
	 */
	public List<SiceeTCertificatore> findWhereDescProvResidenzaEquals(String descProvResidenza) throws SiceeTCertificatoreDaoException;

	/** 
	 * Returns all rows from the SICEE_T_CERTIFICATORE table that match the criteria 'DT_SCADENZA_ELENCO = :dtScadenzaElenco'.
	 */
	public List<SiceeTCertificatore> findWhereDtScadenzaElencoEquals(Date dtScadenzaElenco) throws SiceeTCertificatoreDaoException;

	/** 
	 * Returns all rows from the SICEE_T_CERTIFICATORE table that match the criteria 'ID_REGIONE_RESIDENZA = :idRegioneResidenza'.
	 */
	public List<SiceeTCertificatore> findWhereIdRegioneResidenzaEquals(String idRegioneResidenza) throws SiceeTCertificatoreDaoException;

	/** 
	 * Returns all rows from the SICEE_T_CERTIFICATORE table that match the criteria 'NUM_TOT_ACE = :numTotAce'.
	 */
	public List<SiceeTCertificatore> findWhereNumTotAceEquals(long numTotAce) throws SiceeTCertificatoreDaoException;

	/** 
	 * Returns all rows from the SICEE_T_CERTIFICATORE table that match the criteria 'DESC_REGIONE_RESIDENZA = :descRegioneResidenza'.
	 */
	public List<SiceeTCertificatore> findWhereDescRegioneResidenzaEquals(String descRegioneResidenza) throws SiceeTCertificatoreDaoException;

	/** 
	 * Returns all rows from the SICEE_T_CERTIFICATORE table that match the criteria 'ORDINE = :ordine'.
	 */
	public List<SiceeTCertificatore> findWhereOrdineEquals(String ordine) throws SiceeTCertificatoreDaoException;

	/** 
	 * Returns all rows from the SICEE_T_CERTIFICATORE table that match the criteria 'DESC_PROV_ORDINE = :descProvOrdine'.
	 */
	public List<SiceeTCertificatore> findWhereDescProvOrdineEquals(String descProvOrdine) throws SiceeTCertificatoreDaoException;

	/** 
	 * Returns all rows from the SICEE_T_CERTIFICATORE table that match the criteria 'NUM_ISCR_ALBO = :numIscrAlbo'.
	 */
	public List<SiceeTCertificatore> findWhereNumIscrAlboEquals(String numIscrAlbo) throws SiceeTCertificatoreDaoException;

	/** 
	 * Returns all rows from the SICEE_T_CERTIFICATORE table that match the criteria 'ID_PROV_ORDINE = :idProvOrdine'.
	 */
	public List<SiceeTCertificatore> findWhereIdProvOrdineEquals(String idProvOrdine) throws SiceeTCertificatoreDaoException;

	/** 
	 * Returns all rows from the SICEE_T_CERTIFICATORE table that match the criteria 'SETTORE = :settore'.
	 */
	public List<SiceeTCertificatore> findWhereSettoreEquals(String settore) throws SiceeTCertificatoreDaoException;

	/** 
	 * Returns all rows from the SICEE_T_CERTIFICATORE table that match the criteria 'SEZIONE = :sezione'.
	 */
	public List<SiceeTCertificatore> findWhereSezioneEquals(String sezione) throws SiceeTCertificatoreDaoException;

	/** 
	 * Returns all rows from the SICEE_T_CERTIFICATORE table that match the criteria 'TELEFONO = :telefono'.
	 */
	public List<SiceeTCertificatore> findWhereTelefonoEquals(String telefono) throws SiceeTCertificatoreDaoException;

	/** 
	 * Returns all rows from the SICEE_T_CERTIFICATORE table that match the criteria 'DATA_ISCR_ALBO = :dataIscrAlbo'.
	 */
	public List<SiceeTCertificatore> findWhereDataIscrAlboEquals(Date dataIscrAlbo) throws SiceeTCertificatoreDaoException;

	/** 
	 * Returns all rows from the SICEE_T_CERTIFICATORE table that match the criteria 'FAX = :fax'.
	 */
	public List<SiceeTCertificatore> findWhereFaxEquals(String fax) throws SiceeTCertificatoreDaoException;

	/** 
	 * Returns all rows from the SICEE_T_CERTIFICATORE table that match the criteria 'CELL = :cell'.
	 */
	public List<SiceeTCertificatore> findWhereCellEquals(String cell) throws SiceeTCertificatoreDaoException;

	/** 
	 * Returns all rows from the SICEE_T_CERTIFICATORE table that match the criteria 'EMAIL = :email'.
	 */
	public List<SiceeTCertificatore> findWhereEmailEquals(String email) throws SiceeTCertificatoreDaoException;

	/** 
	 * Returns all rows from the SICEE_T_CERTIFICATORE table that match the criteria 'NUM_CERTIFICATORE = :numCertificatore'.
	 */
	public SiceeTCertificatore findWhereNumCertificatoreEquals(String numCertificatore) throws SiceeTCertificatoreDaoException;

	/** 
	 * Returns all rows from the SICEE_T_CERTIFICATORE table that match the criteria 'STATO_ESTERO = :statoEstero'.
	 */
	public List<SiceeTCertificatore> findWhereStatoEsteroEquals(String statoEstero) throws SiceeTCertificatoreDaoException;

	/** 
	 * Returns all rows from the SICEE_T_CERTIFICATORE table that match the criteria 'FLG_CONSENSO_TEL = :flgConsensoTel'.
	 */
	public List<SiceeTCertificatore> findWhereFlgConsensoTelEquals(String flgConsensoTel) throws SiceeTCertificatoreDaoException;

	/** 
	 * Returns all rows from the SICEE_T_CERTIFICATORE table that match the criteria 'FLG_CONSENSO_EMAIL = :flgConsensoEmail'.
	 */
	public List<SiceeTCertificatore> findWhereFlgConsensoEmailEquals(String flgConsensoEmail) throws SiceeTCertificatoreDaoException;

	/** 
	 * Returns all rows from the SICEE_T_CERTIFICATORE table that match the criteria 'FLG_CONSENSO_CELL = :flgConsensoCell'.
	 */
	public List<SiceeTCertificatore> findWhereFlgConsensoCellEquals(String flgConsensoCell) throws SiceeTCertificatoreDaoException;

	/** 
	 * Returns all rows from the SICEE_T_CERTIFICATORE table that match the criteria 'EMAIL_PEC = :emailPec'.
	 */
	public List<SiceeTCertificatore> findWhereEmailPecEquals(String emailPec) throws SiceeTCertificatoreDaoException;

	/** 
	 * Returns all rows from the SICEE_T_CERTIFICATORE table that match the criteria 'FLG_NEWSLETTER = :flgNewsletter'.
	 */
	public List<SiceeTCertificatore> findWhereFlgNewsletterEquals(String flgNewsletter) throws SiceeTCertificatoreDaoException;

	/** 
	 * Returns all rows from the SICEE_T_CERTIFICATORE table that match the criteria 'FLG_ESAME_SOSTENUTO = :flgEsameSostenuto'.
	 */
	public List<SiceeTCertificatore> findWhereFlgEsameSostenutoEquals(String flgEsameSostenuto) throws SiceeTCertificatoreDaoException;

	/** 
	 * Returns all rows from the SICEE_T_CERTIFICATORE table that match the criteria 'SITO_WEB = :sitoWeb'.
	 */
	public List<SiceeTCertificatore> findWhereSitoWebEquals(String sitoWeb) throws SiceeTCertificatoreDaoException;

	/** 
	 * Returns all rows from the SICEE_T_CERTIFICATORE table that match the criteria 'FLG_CANC_ELENCO = :flgCancElenco'.
	 */
	public List<SiceeTCertificatore> findWhereFlgCancElencoEquals(String flgCancElenco) throws SiceeTCertificatoreDaoException;

	/** 
	 * Returns all rows from the SICEE_T_CERTIFICATORE table that match the criteria 'FK_ISTRUZIONE = :fkIstruzione'.
	 */
	public List<SiceeTCertificatore> findWhereFkIstruzioneEquals(Integer fkIstruzione) throws SiceeTCertificatoreDaoException;

	/** 
	 * Returns all rows from the SICEE_T_CERTIFICATORE table that match the criteria 'FLG_AGG_DATI = :flgAggDati'.
	 */
	public List<SiceeTCertificatore> findWhereFlgAggDatiEquals(String flgAggDati) throws SiceeTCertificatoreDaoException;

	/** 
	 * Returns all rows from the SICEE_T_CERTIFICATORE table that match the criteria 'FLG_AGG_EMAIL = :flgAggEmail'.
	 */
	public List<SiceeTCertificatore> findWhereFlgAggEmailEquals(String flgAggEmail) throws SiceeTCertificatoreDaoException;

	/** 
	 * Returns all rows from the SICEE_T_CERTIFICATORE table that match the criteria 'DT_AGG_DATI = :dtAggDati'.
	 */
	public List<SiceeTCertificatore> findWhereDtAggDatiEquals(Date dtAggDati) throws SiceeTCertificatoreDaoException;

	/** 
	 * Returns all rows from the SICEE_T_CERTIFICATORE table that match the criteria 'DT_AGG_EMAIL = :dtAggEmail'.
	 */
	public List<SiceeTCertificatore> findWhereDtAggEmailEquals(Date dtAggEmail) throws SiceeTCertificatoreDaoException;

	/** 
	 * Returns all rows from the SICEE_T_CERTIFICATORE table that match the criteria 'ISCRITTO_ORDINE = :iscrittoOrdine'.
	 */
	public List<SiceeTCertificatore> findWhereIscrittoOrdineEquals(String iscrittoOrdine) throws SiceeTCertificatoreDaoException;

	/** 
	 * Returns all rows from the SICEE_T_CERTIFICATORE table that match the criteria 'COMPETENZE_NAZIONALI = :competenzeNazionali'.
	 */
	public List<SiceeTCertificatore> findWhereCompetenzeNazionaliEquals(String competenzeNazionali) throws SiceeTCertificatoreDaoException;

	/** 
	 * Returns all rows from the SICEE_T_CERTIFICATORE table that match the criteria 'ACCETTAZIONE_TECNICO = :accettazioneTecnico'.
	 */
	public List<SiceeTCertificatore> findWhereAccettazioneTecnicoEquals(String accettazioneTecnico) throws SiceeTCertificatoreDaoException;

	/** 
	 * Returns all rows from the SICEE_T_CERTIFICATORE table that match the criteria 'DT_EMAIL_VERIFICA = :dtEmailVerifica'.
	 */
	public List<SiceeTCertificatore> findWhereDtEmailVerificaEquals(Date dtEmailVerifica) throws SiceeTCertificatoreDaoException;

	/** 
	 * Returns the rows from the SICEE_T_CERTIFICATORE table that matches the specified primary-key value.
	 */
	public SiceeTCertificatore findByPrimaryKey(SiceeTCertificatorePk pk) throws SiceeTCertificatoreDaoException;

}
