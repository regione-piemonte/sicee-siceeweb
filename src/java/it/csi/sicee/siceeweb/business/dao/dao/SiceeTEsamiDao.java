/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceeweb.business.dao.dao;

import it.csi.sicee.siceeweb.business.dao.dao.SiceeTEsamiDao;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeTEsami;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeTEsamiPk;
import it.csi.sicee.siceeweb.business.dao.exceptions.SiceeTEsamiDaoException;
import java.util.List;

// TODO: Auto-generated Javadoc
/**
 * The Interface SiceeTEsamiDao.
 */
public interface SiceeTEsamiDao
{
	
	/**
	 * Method 'insert'.
	 *
	 * @param dto the dto
	 * @return SiceeTEsamiPk
	 */
	public SiceeTEsamiPk insert(SiceeTEsami dto);

	/**
	 * Updates a single row in the SICEE_T_ESAMI table.
	 *
	 * @param pk the pk
	 * @param dto the dto
	 * @throws SiceeTEsamiDaoException the sicee t esami dao exception
	 */
	public void update(SiceeTEsamiPk pk, SiceeTEsami dto) throws SiceeTEsamiDaoException;

	/**
	 * Deletes a single row in the SICEE_T_ESAMI table.
	 *
	 * @param pk the pk
	 * @throws SiceeTEsamiDaoException the sicee t esami dao exception
	 */
	public void delete(SiceeTEsamiPk pk) throws SiceeTEsamiDaoException;

	/**
	 * Returns all rows from the SICEE_T_ESAMI table that match the criteria 'CODICE_FISCALE = :codiceFiscale'.
	 *
	 * @param codiceFiscale the codice fiscale
	 * @return the sicee t esami
	 * @throws SiceeTEsamiDaoException the sicee t esami dao exception
	 */
	public SiceeTEsami findByPrimaryKey(String codiceFiscale) throws SiceeTEsamiDaoException;

	/**
	 * Returns all rows from the SICEE_T_ESAMI table that match the criteria ''.
	 *
	 * @return the list
	 * @throws SiceeTEsamiDaoException the sicee t esami dao exception
	 */
	public List<SiceeTEsami> findAll() throws SiceeTEsamiDaoException;

	/**
	 * Returns all rows from the SICEE_T_ESAMI table that match the criteria 'CODICE_FISCALE = :codiceFiscale'.
	 *
	 * @param codiceFiscale the codice fiscale
	 * @return the list
	 * @throws SiceeTEsamiDaoException the sicee t esami dao exception
	 */
	public List<SiceeTEsami> findWhereCodiceFiscaleEquals(String codiceFiscale) throws SiceeTEsamiDaoException;

	/**
	 * Returns the rows from the SICEE_T_ESAMI table that matches the specified primary-key value.
	 *
	 * @param pk the pk
	 * @return the sicee t esami
	 * @throws SiceeTEsamiDaoException the sicee t esami dao exception
	 */
	public SiceeTEsami findByPrimaryKey(SiceeTEsamiPk pk) throws SiceeTEsamiDaoException;

}
