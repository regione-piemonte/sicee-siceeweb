/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceeweb.business.dao.dao;

import it.csi.sicee.siceeweb.business.dao.dao.SiceeTTransazioneAceDao;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeTTransazioneAce;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeTTransazioneAcePk;
import it.csi.sicee.siceeweb.business.dao.exceptions.SiceeTTransazioneAceDaoException;
import java.util.Date;
import java.util.List;

// TODO: Auto-generated Javadoc
/**
 * The Interface SiceeTTransazioneAceDao.
 */
public interface SiceeTTransazioneAceDao
{
	
	/**
	 * Method 'insert'.
	 *
	 * @param dto the dto
	 * @return SiceeTTransazioneAcePk
	 */
	public SiceeTTransazioneAcePk insert(SiceeTTransazioneAce dto);

	/**
	 * Updates a single row in the SICEE_T_TRANSAZIONE_ACE table.
	 *
	 * @param pk the pk
	 * @param dto the dto
	 * @throws SiceeTTransazioneAceDaoException the sicee t transazione ace dao exception
	 */
	public void update(SiceeTTransazioneAcePk pk, SiceeTTransazioneAce dto) throws SiceeTTransazioneAceDaoException;

	/**
	 * Deletes a single row in the SICEE_T_TRANSAZIONE_ACE table.
	 *
	 * @param pk the pk
	 * @throws SiceeTTransazioneAceDaoException the sicee t transazione ace dao exception
	 */
	public void delete(SiceeTTransazioneAcePk pk) throws SiceeTTransazioneAceDaoException;

	/**
	 * Returns all rows from the SICEE_T_TRANSAZIONE_ACE table that match the criteria 'ID_TRANSAZIONE_ACE = :idTransazioneAce'.
	 *
	 * @param idTransazioneAce the id transazione ace
	 * @return the sicee t transazione ace
	 * @throws SiceeTTransazioneAceDaoException the sicee t transazione ace dao exception
	 */
	public SiceeTTransazioneAce findByPrimaryKey(long idTransazioneAce) throws SiceeTTransazioneAceDaoException;

	/**
	 * Returns all rows from the SICEE_T_TRANSAZIONE_ACE table that match the criteria 'ID_CERTIFICATORE = :idCertificatore'.
	 *
	 * @param idCertificatore the id certificatore
	 * @return the list
	 * @throws SiceeTTransazioneAceDaoException the sicee t transazione ace dao exception
	 */
	public List<SiceeTTransazioneAce> findWhereIdCertificatoreEquals(String idCertificatore) throws SiceeTTransazioneAceDaoException;

	/**
	 * Returns all rows from the SICEE_T_TRANSAZIONE_ACE table that match the criteria ''.
	 *
	 * @return the list
	 * @throws SiceeTTransazioneAceDaoException the sicee t transazione ace dao exception
	 */
	public List<SiceeTTransazioneAce> findAll() throws SiceeTTransazioneAceDaoException;

	/**
	 * Returns all rows from the SICEE_T_TRANSAZIONE_ACE table that match the criteria 'FK_CERTIFICATORE = :fkCertificatore'.
	 *
	 * @param fkCertificatore the fk certificatore
	 * @return the list
	 * @throws SiceeTTransazioneAceDaoException the sicee t transazione ace dao exception
	 */
	public List<SiceeTTransazioneAce> findBySiceeTCertificatore(String fkCertificatore) throws SiceeTTransazioneAceDaoException;

	/**
	 * Returns all rows from the SICEE_T_TRANSAZIONE_ACE table that match the criteria 'ID_TRANSAZIONE_ACE = :idTransazioneAce'.
	 *
	 * @param idTransazioneAce the id transazione ace
	 * @return the list
	 * @throws SiceeTTransazioneAceDaoException the sicee t transazione ace dao exception
	 */
	public List<SiceeTTransazioneAce> findWhereIdTransazioneAceEquals(long idTransazioneAce) throws SiceeTTransazioneAceDaoException;

	/**
	 * Returns all rows from the SICEE_T_TRANSAZIONE_ACE table that match the criteria 'FK_TIPO_PAGAMENTO = :fkTipoPagamento'.
	 *
	 * @param fkTipoPagamento the fk tipo pagamento
	 * @return the list
	 * @throws SiceeTTransazioneAceDaoException the sicee t transazione ace dao exception
	 */
	public List<SiceeTTransazioneAce> findWhereFkTipoPagamentoEquals(Integer fkTipoPagamento) throws SiceeTTransazioneAceDaoException;

	/**
	 * Returns all rows from the SICEE_T_TRANSAZIONE_ACE table that match the criteria 'NUM_TRANSAZIONE = :numTransazione'.
	 *
	 * @param numTransazione the num transazione
	 * @return the list
	 * @throws SiceeTTransazioneAceDaoException the sicee t transazione ace dao exception
	 */
	public List<SiceeTTransazioneAce> findWhereNumTransazioneEquals(String numTransazione) throws SiceeTTransazioneAceDaoException;

	/**
	 * Returns all rows from the SICEE_T_TRANSAZIONE_ACE table that match the criteria 'DATA_TRANSAZIONE = :dataTransazione'.
	 *
	 * @param dataTransazione the data transazione
	 * @return the list
	 * @throws SiceeTTransazioneAceDaoException the sicee t transazione ace dao exception
	 */
	public List<SiceeTTransazioneAce> findWhereDataTransazioneEquals(Date dataTransazione) throws SiceeTTransazioneAceDaoException;

	/**
	 * Returns all rows from the SICEE_T_TRANSAZIONE_ACE table that match the criteria 'FLG_VERIFICATO = :flgVerificato'.
	 *
	 * @param flgVerificato the flg verificato
	 * @return the list
	 * @throws SiceeTTransazioneAceDaoException the sicee t transazione ace dao exception
	 */
	public List<SiceeTTransazioneAce> findWhereFlgVerificatoEquals(String flgVerificato) throws SiceeTTransazioneAceDaoException;

	/**
	 * Returns all rows from the SICEE_T_TRANSAZIONE_ACE table that match the criteria 'ESEGUITO_NOME = :eseguitoNome'.
	 *
	 * @param eseguitoNome the eseguito nome
	 * @return the list
	 * @throws SiceeTTransazioneAceDaoException the sicee t transazione ace dao exception
	 */
	public List<SiceeTTransazioneAce> findWhereEseguitoNomeEquals(String eseguitoNome) throws SiceeTTransazioneAceDaoException;

	/**
	 * Returns all rows from the SICEE_T_TRANSAZIONE_ACE table that match the criteria 'ESEGUITO_COGNOME = :eseguitoCognome'.
	 *
	 * @param eseguitoCognome the eseguito cognome
	 * @return the list
	 * @throws SiceeTTransazioneAceDaoException the sicee t transazione ace dao exception
	 */
	public List<SiceeTTransazioneAce> findWhereEseguitoCognomeEquals(String eseguitoCognome) throws SiceeTTransazioneAceDaoException;

	/**
	 * Returns all rows from the SICEE_T_TRANSAZIONE_ACE table that match the criteria 'FK_CERTIFICATORE = :fkCertificatore'.
	 *
	 * @param fkCertificatore the fk certificatore
	 * @return the list
	 * @throws SiceeTTransazioneAceDaoException the sicee t transazione ace dao exception
	 */
	public List<SiceeTTransazioneAce> findWhereFkCertificatoreEquals(String fkCertificatore) throws SiceeTTransazioneAceDaoException;

	/**
	 * Returns all rows from the SICEE_T_TRANSAZIONE_ACE table that match the criteria 'ANNO = :anno'.
	 *
	 * @param anno the anno
	 * @return the list
	 * @throws SiceeTTransazioneAceDaoException the sicee t transazione ace dao exception
	 */
	public List<SiceeTTransazioneAce> findWhereAnnoEquals(String anno) throws SiceeTTransazioneAceDaoException;

	/**
	 * Returns all rows from the SICEE_T_TRANSAZIONE_ACE table that match the criteria 'QUANTITA = :quantita'.
	 *
	 * @param quantita the quantita
	 * @return the list
	 * @throws SiceeTTransazioneAceDaoException the sicee t transazione ace dao exception
	 */
	public List<SiceeTTransazioneAce> findWhereQuantitaEquals(Integer quantita) throws SiceeTTransazioneAceDaoException;

	/**
	 * Returns all rows from the SICEE_T_TRANSAZIONE_ACE table that match the criteria 'ID_CERTIFICATORE = :idCertificatore AND FLG_VERIFICATO = 'E''.
	 *
	 * @param fkCertificatore the fk certificatore
	 * @return the list
	 * @throws SiceeTTransazioneAceDaoException the sicee t transazione ace dao exception
	 */
	public List<SiceeTTransazioneAce> findBySiceeTCertificatoreAndFlgVerificatoEquals(String fkCertificatore) throws SiceeTTransazioneAceDaoException;

	/**
	 * Find by sicee t certificatore and flg verificato equals.
	 *
	 * @param fkCertificatore the fk certificatore
	 * @param flgVerificato the flg verificato
	 * @return the list
	 * @throws SiceeTTransazioneAceDaoException the sicee t transazione ace dao exception
	 */
	public List<SiceeTTransazioneAce> findBySiceeTCertificatoreAndFlgVerificatoEquals(String fkCertificatore, String... flgVerificato) throws SiceeTTransazioneAceDaoException;
	
	/**
	 * Returns the rows from the SICEE_T_TRANSAZIONE_ACE table that matches the specified primary-key value.
	 *
	 * @param pk the pk
	 * @return the sicee t transazione ace
	 * @throws SiceeTTransazioneAceDaoException the sicee t transazione ace dao exception
	 */
	public SiceeTTransazioneAce findByPrimaryKey(SiceeTTransazioneAcePk pk) throws SiceeTTransazioneAceDaoException;

}
