/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceeweb.business.dao.dao;

import it.csi.sicee.siceeweb.business.dao.dto.SiceeTRaccomandazioni;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeTRaccomandazioniPk;
import it.csi.sicee.siceeweb.business.dao.exceptions.SiceeTRaccomandazioniDaoException;

import java.util.List;

// TODO: Auto-generated Javadoc
/**
 * The Interface SiceeTRaccomandazioniDao.
 */
public interface SiceeTRaccomandazioniDao
{
	
	/**
	 * Method 'insert'.
	 *
	 * @param dto the dto
	 * @return SiceeTRaccomandazioniPk
	 */
	public SiceeTRaccomandazioniPk insert(SiceeTRaccomandazioni dto);

	/**
	 * Updates a single row in the SICEE_T_RACCOMANDAZIONI table.
	 *
	 * @param pk the pk
	 * @param dto the dto
	 * @throws SiceeTRaccomandazioniDaoException the sicee t raccomandazioni dao exception
	 */
	public void update(SiceeTRaccomandazioniPk pk, SiceeTRaccomandazioni dto) throws SiceeTRaccomandazioniDaoException;

	/**
	 * Deletes a single row in the SICEE_T_RACCOMANDAZIONI table.
	 *
	 * @param pk the pk
	 * @throws SiceeTRaccomandazioniDaoException the sicee t raccomandazioni dao exception
	 */
	public void delete(SiceeTRaccomandazioniPk pk) throws SiceeTRaccomandazioniDaoException;

	/**
	 * Returns all rows from the SICEE_T_RACCOMANDAZIONI table that match the criteria 'ID_CERTIFICATORE = :idCertificatore AND PROGR_CERTIFICATO = :progrCertificato AND ANNO = :anno AND PRIORITA = :priorita AND SISTEMA = :sistema AND INTERVENTO = :intervento'.
	 *
	 * @param idCertificatore the id certificatore
	 * @param progrCertificato the progr certificato
	 * @param anno the anno
	 * @param priorita the priorita
	 * @param sistema the sistema
	 * @param intervento the intervento
	 * @return the sicee t raccomandazioni
	 * @throws SiceeTRaccomandazioniDaoException the sicee t raccomandazioni dao exception
	 */
	public SiceeTRaccomandazioni findByPrimaryKey(String idCertificatore, String progrCertificato, String anno, String priorita, String sistema, String intervento) throws SiceeTRaccomandazioniDaoException;

	/**
	 * Returns all rows from the SICEE_T_RACCOMANDAZIONI table that match the criteria ''.
	 *
	 * @return the list
	 * @throws SiceeTRaccomandazioniDaoException the sicee t raccomandazioni dao exception
	 */
	public List<SiceeTRaccomandazioni> findAll() throws SiceeTRaccomandazioniDaoException;

	/**
	 * Returns all rows from the SICEE_T_RACCOMANDAZIONI table that match the criteria 'ID_CERTIFICATORE = :idCertificatore AND PROGR_CERTIFICATO = :progrCertificato AND ANNO = :anno'.
	 *
	 * @param idCertificatore the id certificatore
	 * @param progrCertificato the progr certificato
	 * @param anno the anno
	 * @return the list
	 * @throws SiceeTRaccomandazioniDaoException the sicee t raccomandazioni dao exception
	 */
	public List<SiceeTRaccomandazioni> findBySiceeTCertificato(String idCertificatore, String progrCertificato, String anno) throws SiceeTRaccomandazioniDaoException;

	/**
	 * Returns all rows from the SICEE_T_RACCOMANDAZIONI table that match the criteria 'ID_CERTIFICATORE = :idCertificatore'.
	 *
	 * @param idCertificatore the id certificatore
	 * @return the list
	 * @throws SiceeTRaccomandazioniDaoException the sicee t raccomandazioni dao exception
	 */
	public List<SiceeTRaccomandazioni> findWhereIdCertificatoreEquals(String idCertificatore) throws SiceeTRaccomandazioniDaoException;

	/**
	 * Returns all rows from the SICEE_T_RACCOMANDAZIONI table that match the criteria 'PROGR_CERTIFICATO = :progrCertificato'.
	 *
	 * @param progrCertificato the progr certificato
	 * @return the list
	 * @throws SiceeTRaccomandazioniDaoException the sicee t raccomandazioni dao exception
	 */
	public List<SiceeTRaccomandazioni> findWhereProgrCertificatoEquals(String progrCertificato) throws SiceeTRaccomandazioniDaoException;

	/**
	 * Returns all rows from the SICEE_T_RACCOMANDAZIONI table that match the criteria 'ANNO = :anno'.
	 *
	 * @param anno the anno
	 * @return the list
	 * @throws SiceeTRaccomandazioniDaoException the sicee t raccomandazioni dao exception
	 */
	public List<SiceeTRaccomandazioni> findWhereAnnoEquals(String anno) throws SiceeTRaccomandazioniDaoException;

	/**
	 * Returns all rows from the SICEE_T_RACCOMANDAZIONI table that match the criteria 'PRIORITA = :priorita'.
	 *
	 * @param priorita the priorita
	 * @return the list
	 * @throws SiceeTRaccomandazioniDaoException the sicee t raccomandazioni dao exception
	 */
	public List<SiceeTRaccomandazioni> findWherePrioritaEquals(String priorita) throws SiceeTRaccomandazioniDaoException;

	/**
	 * Returns all rows from the SICEE_T_RACCOMANDAZIONI table that match the criteria 'SISTEMA = :sistema'.
	 *
	 * @param sistema the sistema
	 * @return the list
	 * @throws SiceeTRaccomandazioniDaoException the sicee t raccomandazioni dao exception
	 */
	public List<SiceeTRaccomandazioni> findWhereSistemaEquals(String sistema) throws SiceeTRaccomandazioniDaoException;

	/**
	 * Returns all rows from the SICEE_T_RACCOMANDAZIONI table that match the criteria 'INTERVENTO = :intervento'.
	 *
	 * @param intervento the intervento
	 * @return the list
	 * @throws SiceeTRaccomandazioniDaoException the sicee t raccomandazioni dao exception
	 */
	public List<SiceeTRaccomandazioni> findWhereInterventoEquals(String intervento) throws SiceeTRaccomandazioniDaoException;

	/**
	 * Returns all rows from the SICEE_T_RACCOMANDAZIONI table that match the criteria 'TEMPO_RITORNO = :tempoRitorno'.
	 *
	 * @param tempoRitorno the tempo ritorno
	 * @return the list
	 * @throws SiceeTRaccomandazioniDaoException the sicee t raccomandazioni dao exception
	 */
	public List<SiceeTRaccomandazioni> findWhereTempoRitornoEquals(String tempoRitorno) throws SiceeTRaccomandazioniDaoException;

	/**
	 * Returns the rows from the SICEE_T_RACCOMANDAZIONI table that matches the specified primary-key value.
	 *
	 * @param pk the pk
	 * @return the sicee t raccomandazioni
	 * @throws SiceeTRaccomandazioniDaoException the sicee t raccomandazioni dao exception
	 */
	public SiceeTRaccomandazioni findByPrimaryKey(SiceeTRaccomandazioniPk pk) throws SiceeTRaccomandazioniDaoException;

}
