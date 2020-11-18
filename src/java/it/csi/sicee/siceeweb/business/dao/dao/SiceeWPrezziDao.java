/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceeweb.business.dao.dao;

import it.csi.sicee.siceeweb.business.dao.dto.SiceeWPrezzi;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeWPrezziPk;
import it.csi.sicee.siceeweb.business.dao.exceptions.SiceeWPrezziDaoException;

import java.util.Date;
import java.util.List;

// TODO: Auto-generated Javadoc
/**
 * The Interface SiceeWPrezziDao.
 */
public interface SiceeWPrezziDao
{
	
	/**
	 * Method 'insert'.
	 *
	 * @param dto the dto
	 * @return SiceeWPrezziPk
	 */
	public SiceeWPrezziPk insert(SiceeWPrezzi dto);

	/**
	 * Updates a single row in the SICEE_W_PREZZI table.
	 *
	 * @param pk the pk
	 * @param dto the dto
	 * @throws SiceeWPrezziDaoException the sicee w prezzi dao exception
	 */
	public void update(SiceeWPrezziPk pk, SiceeWPrezzi dto) throws SiceeWPrezziDaoException;

	/**
	 * Deletes a single row in the SICEE_W_PREZZI table.
	 *
	 * @param pk the pk
	 * @throws SiceeWPrezziDaoException the sicee w prezzi dao exception
	 */
	public void delete(SiceeWPrezziPk pk) throws SiceeWPrezziDaoException;

	/**
	 * Returns all rows from the SICEE_W_PREZZI table that match the criteria 'ID_PREZZI = :idPrezzi'.
	 *
	 * @param idPrezzi the idPrezzi
	 * @return the sicee w prezzi
	 * @throws SiceeWPrezziDaoException the sicee w prezzi dao exception
	 */
	public SiceeWPrezzi findByPrimaryKey(Integer idPrezzi) throws SiceeWPrezziDaoException;

	/** 
	 * Returns all rows from the SICEE_W_PREZZI table that match the criteria 'DESCRIZIONE = :descrizione
		AND SYSDATE BETWEEN DT_INIZIO AND COALESCE(DT_FINE,SYSDATE)'.
	 */
	public SiceeWPrezzi findWhereDescrizioneValidaEquals(String descrizione) throws SiceeWPrezziDaoException;
	
	/** 
	 * Returns all rows from the SICEE_W_PREZZI table that match the criteria 'DESCRIZIONE = :descrizione
	AND :dataTransazione BETWEEN DT_INIZIO AND COALESCE(DT_FINE,SYSDATE)'.
	 */
	public SiceeWPrezzi findWhereDescrizioneValidaAllaDataEquals(String descrizione, Date dataTransazione) throws SiceeWPrezziDaoException;

	
	/**
	 * Returns all rows from the SICEE_W_PREZZI table that match the criteria 'PREZZO_REGISTRAZIONE = :prezzoRegistrazione'.
	 *
	 * @param prezzoRegistrazione the prezzo registrazione
	 * @return the list
	 * @throws SiceeWPrezziDaoException the sicee w prezzi dao exception
	 */
	//public List<SiceeWPrezzi> findWherePrezzoRegistrazioneEquals(Float prezzoRegistrazione) throws SiceeWPrezziDaoException;

	/**
	 * Returns all rows from the SICEE_W_PREZZI table that match the criteria 'PREZZO_ACE = :prezzoAce'.
	 *
	 * @param prezzoAce the prezzo ace
	 * @return the list
	 * @throws SiceeWPrezziDaoException the sicee w prezzi dao exception
	 */
	//public List<SiceeWPrezzi> findWherePrezzoAceEquals(Float prezzoAce) throws SiceeWPrezziDaoException;

	/**
	 * Returns all rows from the SICEE_W_PREZZI table that match the criteria ''.
	 *
	 * @return the list
	 * @throws SiceeWPrezziDaoException the sicee w prezzi dao exception
	 */
	public List<SiceeWPrezzi> findAll() throws SiceeWPrezziDaoException;

	/**
	 * Returns all rows from the SICEE_W_PREZZI table that match the criteria 'DESCRIZIONE = :descrizione'.
	 *
	 * @param descrizione the descrizione
	 * @return the list
	 * @throws SiceeWPrezziDaoException the sicee w prezzi dao exception
	 */
	public List<SiceeWPrezzi> findWhereDescrizioneEquals(String descrizione) throws SiceeWPrezziDaoException;

	/**
	 * Returns all rows from the SICEE_W_PREZZI table that match the criteria 'VALUTA = :valuta'.
	 *
	 * @param valuta the valuta
	 * @return the list
	 * @throws SiceeWPrezziDaoException the sicee w prezzi dao exception
	 */
	public List<SiceeWPrezzi> findWhereValutaEquals(Float valuta) throws SiceeWPrezziDaoException;

	/** 
	 * Returns all rows from the SICEE_W_PREZZI table that match the criteria 'ID_PREZZI = :idPrezzi'.
	 */
	public List<SiceeWPrezzi> findWhereIdPrezziEquals(Integer idPrezzi) throws SiceeWPrezziDaoException;

	/** 
	 * Returns all rows from the SICEE_W_PREZZI table that match the criteria 'DT_INIZIO = :dtInizio'.
	 */
	public List<SiceeWPrezzi> findWhereDtInizioEquals(Date dtInizio) throws SiceeWPrezziDaoException;

	/** 
	 * Returns all rows from the SICEE_W_PREZZI table that match the criteria 'DT_FINE = :dtFine'.
	 */
	public List<SiceeWPrezzi> findWhereDtFineEquals(Date dtFine) throws SiceeWPrezziDaoException;
	
	/**
	 * Returns the rows from the SICEE_W_PREZZI table that matches the specified primary-key value.
	 *
	 * @param pk the pk
	 * @return the sicee w prezzi
	 * @throws SiceeWPrezziDaoException the sicee w prezzi dao exception
	 */
	public SiceeWPrezzi findByPrimaryKey(SiceeWPrezziPk pk) throws SiceeWPrezziDaoException;

}
