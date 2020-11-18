/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceeweb.business.dao.dao;

import it.csi.sicee.siceeweb.business.dao.dto.SiceeDNormativa;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeDNormativaPk;
import it.csi.sicee.siceeweb.business.dao.exceptions.SiceeDNormativaDaoException;

import java.util.Date;
import java.util.List;

// TODO: Auto-generated Javadoc
/**
 * The Interface SiceeDNormativaDao.
 */
public interface SiceeDNormativaDao
{
	
	/**
	 * Method 'insert'.
	 *
	 * @param dto the dto
	 * @return SiceeDNormativaPk
	 */
	public SiceeDNormativaPk insert(SiceeDNormativa dto);

	/**
	 * Updates a single row in the SICEE_D_NORMATIVA table.
	 *
	 * @param pk the pk
	 * @param dto the dto
	 * @throws SiceeDNormativaDaoException the sicee d normativa dao exception
	 */
	public void update(SiceeDNormativaPk pk, SiceeDNormativa dto) throws SiceeDNormativaDaoException;

	/**
	 * Deletes a single row in the SICEE_D_NORMATIVA table.
	 *
	 * @param pk the pk
	 * @throws SiceeDNormativaDaoException the sicee d normativa dao exception
	 */
	public void delete(SiceeDNormativaPk pk) throws SiceeDNormativaDaoException;

	/**
	 * Returns all rows from the SICEE_D_NORMATIVA table that match the criteria 'ID_NORMA = :idNorma'.
	 *
	 * @param idNorma the id norma
	 * @return the sicee d normativa
	 * @throws SiceeDNormativaDaoException the sicee d normativa dao exception
	 */
	public SiceeDNormativa findByPrimaryKey(Integer idNorma) throws SiceeDNormativaDaoException;

	/**
	 * Returns all rows from the SICEE_D_NORMATIVA table that match the criteria ':date BETWEEN DT_INIZIO AND DT_FINE'.
	 *
	 * @param date the date
	 * @return the sicee d normativa
	 * @throws SiceeDNormativaDaoException the sicee d normativa dao exception
	 */
	public SiceeDNormativa findWhereDtInizioBetweenDtFine(Date date) throws SiceeDNormativaDaoException;

	/**
	 * Returns all rows from the SICEE_D_NORMATIVA table that match the criteria ''.
	 *
	 * @return the list
	 * @throws SiceeDNormativaDaoException the sicee d normativa dao exception
	 */
	public List<SiceeDNormativa> findAll() throws SiceeDNormativaDaoException;

	/**
	 * Returns all rows from the SICEE_D_NORMATIVA table that match the criteria 'ID_NORMA = :idNorma'.
	 *
	 * @param idNorma the id norma
	 * @return the list
	 * @throws SiceeDNormativaDaoException the sicee d normativa dao exception
	 */
	public List<SiceeDNormativa> findWhereIdNormaEquals(Integer idNorma) throws SiceeDNormativaDaoException;

	/**
	 * Returns all rows from the SICEE_D_NORMATIVA table that match the criteria 'DESCR = :descr'.
	 *
	 * @param descr the descr
	 * @return the list
	 * @throws SiceeDNormativaDaoException the sicee d normativa dao exception
	 */
	public List<SiceeDNormativa> findWhereDescrEquals(String descr) throws SiceeDNormativaDaoException;

	/**
	 * Returns all rows from the SICEE_D_NORMATIVA table that match the criteria 'DT_INIZIO = :dtInizio'.
	 *
	 * @param dtInizio the dt inizio
	 * @return the list
	 * @throws SiceeDNormativaDaoException the sicee d normativa dao exception
	 */
	public List<SiceeDNormativa> findWhereDtInizioEquals(Date dtInizio) throws SiceeDNormativaDaoException;

	/**
	 * Returns all rows from the SICEE_D_NORMATIVA table that match the criteria 'DT_FINE = :dtFine'.
	 *
	 * @param dtFine the dt fine
	 * @return the list
	 * @throws SiceeDNormativaDaoException the sicee d normativa dao exception
	 */
	public List<SiceeDNormativa> findWhereDtFineEquals(Date dtFine) throws SiceeDNormativaDaoException;

	/**
	 * Returns the rows from the SICEE_D_NORMATIVA table that matches the specified primary-key value.
	 *
	 * @param pk the pk
	 * @return the sicee d normativa
	 * @throws SiceeDNormativaDaoException the sicee d normativa dao exception
	 */
	public SiceeDNormativa findByPrimaryKey(SiceeDNormativaPk pk) throws SiceeDNormativaDaoException;

}
