/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceeweb.business.dao.dao;

import it.csi.sicee.siceeweb.business.dao.dto.SiceeDStatoCert;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeDStatoCertPk;
import it.csi.sicee.siceeweb.business.dao.exceptions.SiceeDStatoCertDaoException;

import java.util.List;

// TODO: Auto-generated Javadoc
/**
 * The Interface SiceeDStatoCertDao.
 */
public interface SiceeDStatoCertDao
{
	
	/**
	 * Method 'insert'.
	 *
	 * @param dto the dto
	 * @return SiceeDStatoCertPk
	 */
	public SiceeDStatoCertPk insert(SiceeDStatoCert dto);

	/**
	 * Updates a single row in the SICEE_D_STATO_CERT table.
	 *
	 * @param pk the pk
	 * @param dto the dto
	 * @throws SiceeDStatoCertDaoException the sicee d stato cert dao exception
	 */
	public void update(SiceeDStatoCertPk pk, SiceeDStatoCert dto) throws SiceeDStatoCertDaoException;

	/**
	 * Deletes a single row in the SICEE_D_STATO_CERT table.
	 *
	 * @param pk the pk
	 * @throws SiceeDStatoCertDaoException the sicee d stato cert dao exception
	 */
	public void delete(SiceeDStatoCertPk pk) throws SiceeDStatoCertDaoException;

	/**
	 * Returns all rows from the SICEE_D_STATO_CERT table that match the criteria 'ID_STATO = :idStato'.
	 *
	 * @param idStato the id stato
	 * @return the sicee d stato cert
	 * @throws SiceeDStatoCertDaoException the sicee d stato cert dao exception
	 */
	public SiceeDStatoCert findByPrimaryKey(Integer idStato) throws SiceeDStatoCertDaoException;

	/**
	 * Returns all rows from the SICEE_D_STATO_CERT table that match the criteria ''.
	 *
	 * @return the list
	 * @throws SiceeDStatoCertDaoException the sicee d stato cert dao exception
	 */
	public List<SiceeDStatoCert> findAll() throws SiceeDStatoCertDaoException;

	/**
	 * Returns all rows from the SICEE_D_STATO_CERT table that match the criteria 'ID_STATO = :idStato'.
	 *
	 * @param idStato the id stato
	 * @return the list
	 * @throws SiceeDStatoCertDaoException the sicee d stato cert dao exception
	 */
	public List<SiceeDStatoCert> findWhereIdStatoEquals(Integer idStato) throws SiceeDStatoCertDaoException;

	/**
	 * Returns all rows from the SICEE_D_STATO_CERT table that match the criteria 'DESCR = :descr'.
	 *
	 * @param descr the descr
	 * @return the list
	 * @throws SiceeDStatoCertDaoException the sicee d stato cert dao exception
	 */
	public List<SiceeDStatoCert> findWhereDescrEquals(String descr) throws SiceeDStatoCertDaoException;

	/**
	 * Returns the rows from the SICEE_D_STATO_CERT table that matches the specified primary-key value.
	 *
	 * @param pk the pk
	 * @return the sicee d stato cert
	 * @throws SiceeDStatoCertDaoException the sicee d stato cert dao exception
	 */
	public SiceeDStatoCert findByPrimaryKey(SiceeDStatoCertPk pk) throws SiceeDStatoCertDaoException;

}
