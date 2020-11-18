/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceeweb.business.dao.dao;

import it.csi.sicee.siceeweb.business.dao.dao.SiceeTTransazioneRegistrazDao;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeTTransazioneRegistraz;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeTTransazioneRegistrazPk;
import it.csi.sicee.siceeweb.business.dao.exceptions.SiceeTTransazioneRegistrazDaoException;
import java.util.Date;
import java.util.List;

// TODO: Auto-generated Javadoc
/**
 * The Interface SiceeTTransazioneRegistrazDao.
 */
public interface SiceeTTransazioneRegistrazDao
{
	
	/**
	 * Method 'insert'.
	 *
	 * @param dto the dto
	 * @return SiceeTTransazioneRegistrazPk
	 */
	public SiceeTTransazioneRegistrazPk insert(SiceeTTransazioneRegistraz dto);

	/**
	 * Updates a single row in the SICEE_T_TRANSAZIONE_REGISTRAZ table.
	 *
	 * @param pk the pk
	 * @param dto the dto
	 * @throws SiceeTTransazioneRegistrazDaoException the sicee t transazione registraz dao exception
	 */
	public void update(SiceeTTransazioneRegistrazPk pk, SiceeTTransazioneRegistraz dto) throws SiceeTTransazioneRegistrazDaoException;

	/**
	 * Deletes a single row in the SICEE_T_TRANSAZIONE_REGISTRAZ table.
	 *
	 * @param pk the pk
	 * @throws SiceeTTransazioneRegistrazDaoException the sicee t transazione registraz dao exception
	 */
	public void delete(SiceeTTransazioneRegistrazPk pk) throws SiceeTTransazioneRegistrazDaoException;

	/**
	 * Returns all rows from the SICEE_T_TRANSAZIONE_REGISTRAZ table that match the criteria 'ID_TRANSAZIONE_REG = :idTransazioneReg'.
	 *
	 * @param idTransazioneReg the id transazione reg
	 * @return the sicee t transazione registraz
	 * @throws SiceeTTransazioneRegistrazDaoException the sicee t transazione registraz dao exception
	 */
	public SiceeTTransazioneRegistraz findByPrimaryKey(long idTransazioneReg) throws SiceeTTransazioneRegistrazDaoException;

	/**
	 * Returns all rows from the SICEE_T_TRANSAZIONE_REGISTRAZ table that match the criteria 'ID_CERTIFICATORE = :idCertificatore'.
	 *
	 * @param idCertificatore the id certificatore
	 * @return the list
	 * @throws SiceeTTransazioneRegistrazDaoException the sicee t transazione registraz dao exception
	 */
	public List<SiceeTTransazioneRegistraz> findWhereIdCertificatoreEquals(String idCertificatore) throws SiceeTTransazioneRegistrazDaoException;

	/**
	 * Returns all rows from the SICEE_T_TRANSAZIONE_REGISTRAZ table that match the criteria ''.
	 *
	 * @return the list
	 * @throws SiceeTTransazioneRegistrazDaoException the sicee t transazione registraz dao exception
	 */
	public List<SiceeTTransazioneRegistraz> findAll() throws SiceeTTransazioneRegistrazDaoException;

	/**
	 * Returns all rows from the SICEE_T_TRANSAZIONE_REGISTRAZ table that match the criteria 'FK_CERTIFICATORE = :fkCertificatore'.
	 *
	 * @param fkCertificatore the fk certificatore
	 * @return the list
	 * @throws SiceeTTransazioneRegistrazDaoException the sicee t transazione registraz dao exception
	 */
	public List<SiceeTTransazioneRegistraz> findBySiceeTCertificatore(String fkCertificatore) throws SiceeTTransazioneRegistrazDaoException;

	/**
	 * Returns all rows from the SICEE_T_TRANSAZIONE_REGISTRAZ table that match the criteria 'ID_TRANSAZIONE_REG = :idTransazioneReg'.
	 *
	 * @param idTransazioneReg the id transazione reg
	 * @return the list
	 * @throws SiceeTTransazioneRegistrazDaoException the sicee t transazione registraz dao exception
	 */
	public List<SiceeTTransazioneRegistraz> findWhereIdTransazioneRegEquals(long idTransazioneReg) throws SiceeTTransazioneRegistrazDaoException;

	/**
	 * Returns all rows from the SICEE_T_TRANSAZIONE_REGISTRAZ table that match the criteria 'FK_CERTIFICATORE = :fkCertificatore'.
	 *
	 * @param fkCertificatore the fk certificatore
	 * @return the list
	 * @throws SiceeTTransazioneRegistrazDaoException the sicee t transazione registraz dao exception
	 */
	public List<SiceeTTransazioneRegistraz> findWhereFkCertificatoreEquals(String fkCertificatore) throws SiceeTTransazioneRegistrazDaoException;

	/**
	 * Returns all rows from the SICEE_T_TRANSAZIONE_REGISTRAZ table that match the criteria 'FK_TIPO_PAGAMENTO = :fkTipoPagamento'.
	 *
	 * @param fkTipoPagamento the fk tipo pagamento
	 * @return the list
	 * @throws SiceeTTransazioneRegistrazDaoException the sicee t transazione registraz dao exception
	 */
	public List<SiceeTTransazioneRegistraz> findWhereFkTipoPagamentoEquals(Integer fkTipoPagamento) throws SiceeTTransazioneRegistrazDaoException;

	/**
	 * Returns all rows from the SICEE_T_TRANSAZIONE_REGISTRAZ table that match the criteria 'DATA_TRANSAZIONE = :dataTransazione'.
	 *
	 * @param dataTransazione the data transazione
	 * @return the list
	 * @throws SiceeTTransazioneRegistrazDaoException the sicee t transazione registraz dao exception
	 */
	public List<SiceeTTransazioneRegistraz> findWhereDataTransazioneEquals(Date dataTransazione) throws SiceeTTransazioneRegistrazDaoException;

	/**
	 * Returns all rows from the SICEE_T_TRANSAZIONE_REGISTRAZ table that match the criteria 'NUM_TRANSAZIONE = :numTransazione'.
	 *
	 * @param numTransazione the num transazione
	 * @return the list
	 * @throws SiceeTTransazioneRegistrazDaoException the sicee t transazione registraz dao exception
	 */
	public List<SiceeTTransazioneRegistraz> findWhereNumTransazioneEquals(String numTransazione) throws SiceeTTransazioneRegistrazDaoException;

	/**
	 * Returns all rows from the SICEE_T_TRANSAZIONE_REGISTRAZ table that match the criteria 'FLG_VERIFICATO = :flgVerificato'.
	 *
	 * @param flgVerificato the flg verificato
	 * @return the list
	 * @throws SiceeTTransazioneRegistrazDaoException the sicee t transazione registraz dao exception
	 */
	public List<SiceeTTransazioneRegistraz> findWhereFlgVerificatoEquals(String flgVerificato) throws SiceeTTransazioneRegistrazDaoException;

	/**
	 * Returns all rows from the SICEE_T_TRANSAZIONE_REGISTRAZ table that match the criteria 'ESEGUITO_NOME = :eseguitoNome'.
	 *
	 * @param eseguitoNome the eseguito nome
	 * @return the list
	 * @throws SiceeTTransazioneRegistrazDaoException the sicee t transazione registraz dao exception
	 */
	public List<SiceeTTransazioneRegistraz> findWhereEseguitoNomeEquals(String eseguitoNome) throws SiceeTTransazioneRegistrazDaoException;

	/**
	 * Returns all rows from the SICEE_T_TRANSAZIONE_REGISTRAZ table that match the criteria 'ESEGUITO_COGNOME = :eseguitoCognome'.
	 *
	 * @param eseguitoCognome the eseguito cognome
	 * @return the list
	 * @throws SiceeTTransazioneRegistrazDaoException the sicee t transazione registraz dao exception
	 */
	public List<SiceeTTransazioneRegistraz> findWhereEseguitoCognomeEquals(String eseguitoCognome) throws SiceeTTransazioneRegistrazDaoException;

	/**
	 * Returns all rows from the SICEE_T_TRANSAZIONE_REGISTRAZ table that match the criteria 'ANNO = :anno'.
	 *
	 * @param anno the anno
	 * @return the list
	 * @throws SiceeTTransazioneRegistrazDaoException the sicee t transazione registraz dao exception
	 */
	public List<SiceeTTransazioneRegistraz> findWhereAnnoEquals(String anno) throws SiceeTTransazioneRegistrazDaoException;

	/**
	 * Returns all rows from the SICEE_T_TRANSAZIONE_REGISTRAZ table that match the criteria 'QUANTITA = :quantita'.
	 *
	 * @param quantita the quantita
	 * @return the list
	 * @throws SiceeTTransazioneRegistrazDaoException the sicee t transazione registraz dao exception
	 */
	public List<SiceeTTransazioneRegistraz> findWhereQuantitaEquals(Integer quantita) throws SiceeTTransazioneRegistrazDaoException;

	/**
	 * Returns all rows from the SICEE_T_TRANSAZIONE_REGISTRAZ table that match the criteria 'ID_CERTIFICATORE = :idCertificatore AND FLG_VERIFICATO = 'E''.
	 *
	 * @param fkCertificatore the fk certificatore
	 * @return the list
	 * @throws SiceeTTransazioneRegistrazDaoException the sicee t transazione registraz dao exception
	 */
	public List<SiceeTTransazioneRegistraz> findBySiceeTCertificatoreAndFlgVerificatoEquals(String fkCertificatore) throws SiceeTTransazioneRegistrazDaoException;

	/**
	 * Find by sicee t certificatore and flg verificato equals.
	 *
	 * @param fkCertificatore the fk certificatore
	 * @param flgVerificato the flg verificato
	 * @return the list
	 * @throws SiceeTTransazioneRegistrazDaoException the sicee t transazione registraz dao exception
	 */
	public List<SiceeTTransazioneRegistraz> findBySiceeTCertificatoreAndFlgVerificatoEquals(String fkCertificatore, String... flgVerificato) throws SiceeTTransazioneRegistrazDaoException;
	
	/**
	 * Returns the rows from the SICEE_T_TRANSAZIONE_REGISTRAZ table that matches the specified primary-key value.
	 *
	 * @param pk the pk
	 * @return the sicee t transazione registraz
	 * @throws SiceeTTransazioneRegistrazDaoException the sicee t transazione registraz dao exception
	 */
	public SiceeTTransazioneRegistraz findByPrimaryKey(SiceeTTransazioneRegistrazPk pk) throws SiceeTTransazioneRegistrazDaoException;

}
