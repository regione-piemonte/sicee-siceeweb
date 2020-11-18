/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceeweb.business.dao.dao;

import it.csi.sicee.siceeweb.business.dao.dao.SiceeTAziendaDao;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeTAzienda;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeTAziendaPk;
import it.csi.sicee.siceeweb.business.dao.exceptions.SiceeTAziendaDaoException;
import java.util.List;

// TODO: Auto-generated Javadoc
/**
 * The Interface SiceeTAziendaDao.
 */
public interface SiceeTAziendaDao
{
	
	/**
	 * Method 'insert'.
	 *
	 * @param dto the dto
	 * @return SiceeTAziendaPk
	 */
	public SiceeTAziendaPk insert(SiceeTAzienda dto);

	/**
	 * Updates a single row in the SICEE_T_AZIENDA table.
	 *
	 * @param pk the pk
	 * @param dto the dto
	 * @throws SiceeTAziendaDaoException the sicee t azienda dao exception
	 */
	public void update(SiceeTAziendaPk pk, SiceeTAzienda dto) throws SiceeTAziendaDaoException;

	/**
	 * Deletes a single row in the SICEE_T_AZIENDA table.
	 *
	 * @param pk the pk
	 * @throws SiceeTAziendaDaoException the sicee t azienda dao exception
	 */
	public void delete(SiceeTAziendaPk pk) throws SiceeTAziendaDaoException;

	/**
	 * Returns all rows from the SICEE_T_AZIENDA table that match the criteria 'ID_AZIENDA = :idAzienda'.
	 *
	 * @param idAzienda the id azienda
	 * @return the sicee t azienda
	 * @throws SiceeTAziendaDaoException the sicee t azienda dao exception
	 */
	public SiceeTAzienda findByPrimaryKey(long idAzienda) throws SiceeTAziendaDaoException;

	/**
	 * Returns all rows from the SICEE_T_AZIENDA table that match the criteria ''.
	 *
	 * @return the list
	 * @throws SiceeTAziendaDaoException the sicee t azienda dao exception
	 */
	public List<SiceeTAzienda> findAll() throws SiceeTAziendaDaoException;

	/**
	 * Returns all rows from the SICEE_T_AZIENDA table that match the criteria 'ID_AZIENDA = :idAzienda'.
	 *
	 * @param idAzienda the id azienda
	 * @return the list
	 * @throws SiceeTAziendaDaoException the sicee t azienda dao exception
	 */
	public List<SiceeTAzienda> findWhereIdAziendaEquals(long idAzienda) throws SiceeTAziendaDaoException;

	/**
	 * Returns all rows from the SICEE_T_AZIENDA table that match the criteria 'DENOMINAZIONE = :denominazione'.
	 *
	 * @param denominazione the denominazione
	 * @return the list
	 * @throws SiceeTAziendaDaoException the sicee t azienda dao exception
	 */
	public List<SiceeTAzienda> findWhereDenominazioneEquals(String denominazione) throws SiceeTAziendaDaoException;

	/**
	 * Returns all rows from the SICEE_T_AZIENDA table that match the criteria 'ID_INDIRIZZO = :idIndirizzo'.
	 *
	 * @param idIndirizzo the id indirizzo
	 * @return the list
	 * @throws SiceeTAziendaDaoException the sicee t azienda dao exception
	 */
	public List<SiceeTAzienda> findWhereIdIndirizzoEquals(Integer idIndirizzo) throws SiceeTAziendaDaoException;

	/**
	 * Returns all rows from the SICEE_T_AZIENDA table that match the criteria 'DESC_INDIRIZZO = :descIndirizzo'.
	 *
	 * @param descIndirizzo the desc indirizzo
	 * @return the list
	 * @throws SiceeTAziendaDaoException the sicee t azienda dao exception
	 */
	public List<SiceeTAzienda> findWhereDescIndirizzoEquals(String descIndirizzo) throws SiceeTAziendaDaoException;

	/**
	 * Returns all rows from the SICEE_T_AZIENDA table that match the criteria 'CAP = :cap'.
	 *
	 * @param cap the cap
	 * @return the list
	 * @throws SiceeTAziendaDaoException the sicee t azienda dao exception
	 */
	public List<SiceeTAzienda> findWhereCapEquals(String cap) throws SiceeTAziendaDaoException;

	/**
	 * Returns all rows from the SICEE_T_AZIENDA table that match the criteria 'ID_COMUNE = :idComune'.
	 *
	 * @param idComune the id comune
	 * @return the list
	 * @throws SiceeTAziendaDaoException the sicee t azienda dao exception
	 */
	public List<SiceeTAzienda> findWhereIdComuneEquals(String idComune) throws SiceeTAziendaDaoException;

	/**
	 * Returns all rows from the SICEE_T_AZIENDA table that match the criteria 'DESC_COMUNE = :descComune'.
	 *
	 * @param descComune the desc comune
	 * @return the list
	 * @throws SiceeTAziendaDaoException the sicee t azienda dao exception
	 */
	public List<SiceeTAzienda> findWhereDescComuneEquals(String descComune) throws SiceeTAziendaDaoException;

	/**
	 * Returns all rows from the SICEE_T_AZIENDA table that match the criteria 'P_IVA = :pIva'.
	 *
	 * @param pIva the iva
	 * @return the list
	 * @throws SiceeTAziendaDaoException the sicee t azienda dao exception
	 */
	public List<SiceeTAzienda> findWherePIvaEquals(String pIva) throws SiceeTAziendaDaoException;

	/**
	 * Returns all rows from the SICEE_T_AZIENDA table that match the criteria 'ID_PROV = :idProv'.
	 *
	 * @param idProv the id prov
	 * @return the list
	 * @throws SiceeTAziendaDaoException the sicee t azienda dao exception
	 */
	public List<SiceeTAzienda> findWhereIdProvEquals(String idProv) throws SiceeTAziendaDaoException;

	/**
	 * Returns all rows from the SICEE_T_AZIENDA table that match the criteria 'DESC_PROV = :descProv'.
	 *
	 * @param descProv the desc prov
	 * @return the list
	 * @throws SiceeTAziendaDaoException the sicee t azienda dao exception
	 */
	public List<SiceeTAzienda> findWhereDescProvEquals(String descProv) throws SiceeTAziendaDaoException;

	/**
	 * Returns all rows from the SICEE_T_AZIENDA table that match the criteria 'ID_REGIONE = :idRegione'.
	 *
	 * @param idRegione the id regione
	 * @return the list
	 * @throws SiceeTAziendaDaoException the sicee t azienda dao exception
	 */
	public List<SiceeTAzienda> findWhereIdRegioneEquals(String idRegione) throws SiceeTAziendaDaoException;

	/**
	 * Returns all rows from the SICEE_T_AZIENDA table that match the criteria 'DESC_REGIONE = :descRegione'.
	 *
	 * @param descRegione the desc regione
	 * @return the list
	 * @throws SiceeTAziendaDaoException the sicee t azienda dao exception
	 */
	public List<SiceeTAzienda> findWhereDescRegioneEquals(String descRegione) throws SiceeTAziendaDaoException;

	/**
	 * Returns all rows from the SICEE_T_AZIENDA table that match the criteria 'NUM_CIVICO = :numCivico'.
	 *
	 * @param numCivico the num civico
	 * @return the list
	 * @throws SiceeTAziendaDaoException the sicee t azienda dao exception
	 */
	public List<SiceeTAzienda> findWhereNumCivicoEquals(String numCivico) throws SiceeTAziendaDaoException;

	/**
	 * Returns the rows from the SICEE_T_AZIENDA table that matches the specified primary-key value.
	 *
	 * @param pk the pk
	 * @return the sicee t azienda
	 * @throws SiceeTAziendaDaoException the sicee t azienda dao exception
	 */
	public SiceeTAzienda findByPrimaryKey(SiceeTAziendaPk pk) throws SiceeTAziendaDaoException;

}
