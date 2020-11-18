/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceeweb.business.dao.dao;

import it.csi.sicee.siceeweb.business.dao.dto.SiceeDDichiarazione;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeDDichiarazionePk;
import it.csi.sicee.siceeweb.business.dao.exceptions.SiceeDDichiarazioneDaoException;

import java.util.List;

// TODO: Auto-generated Javadoc
/**
 * The Interface SiceeDDichiarazioneDao.
 */
public interface SiceeDDichiarazioneDao
{
	
	/**
	 * Method 'insert'.
	 *
	 * @param dto the dto
	 * @return SiceeDDichiarazionePk
	 */
	public SiceeDDichiarazionePk insert(SiceeDDichiarazione dto);

	/**
	 * Updates a single row in the SICEE_D_DICHIARAZIONE table.
	 *
	 * @param pk the pk
	 * @param dto the dto
	 * @throws SiceeDDichiarazioneDaoException the sicee d dichiarazione dao exception
	 */
	public void update(SiceeDDichiarazionePk pk, SiceeDDichiarazione dto) throws SiceeDDichiarazioneDaoException;

	/**
	 * Deletes a single row in the SICEE_D_DICHIARAZIONE table.
	 *
	 * @param pk the pk
	 * @throws SiceeDDichiarazioneDaoException the sicee d dichiarazione dao exception
	 */
	public void delete(SiceeDDichiarazionePk pk) throws SiceeDDichiarazioneDaoException;

	/**
	 * Returns all rows from the SICEE_D_DICHIARAZIONE table that match the criteria 'ID_DICHIARAZIONE = :idDichiarazione'.
	 *
	 * @param idDichiarazione the id dichiarazione
	 * @return the sicee d dichiarazione
	 * @throws SiceeDDichiarazioneDaoException the sicee d dichiarazione dao exception
	 */
	public SiceeDDichiarazione findByPrimaryKey(Integer idDichiarazione) throws SiceeDDichiarazioneDaoException;

	/**
	 * Returns all rows from the SICEE_D_DICHIARAZIONE table that match the criteria ''.
	 *
	 * @return the list
	 * @throws SiceeDDichiarazioneDaoException the sicee d dichiarazione dao exception
	 */
	public List<SiceeDDichiarazione> findAll() throws SiceeDDichiarazioneDaoException;

	public List<SiceeDDichiarazione> findWhereIdDichiarazioneNew() throws SiceeDDichiarazioneDaoException;
	
	/**
	 * Returns all rows from the SICEE_D_DICHIARAZIONE table that match the criteria 'ID_DICHIARAZIONE = :idDichiarazione'.
	 *
	 * @param idDichiarazione the id dichiarazione
	 * @return the list
	 * @throws SiceeDDichiarazioneDaoException the sicee d dichiarazione dao exception
	 */
	public List<SiceeDDichiarazione> findWhereIdDichiarazioneEquals(Integer idDichiarazione) throws SiceeDDichiarazioneDaoException;

	/**
	 * Returns all rows from the SICEE_D_DICHIARAZIONE table that match the criteria 'DESCR = :descr'.
	 *
	 * @param descr the descr
	 * @return the list
	 * @throws SiceeDDichiarazioneDaoException the sicee d dichiarazione dao exception
	 */
	public List<SiceeDDichiarazione> findWhereDescrEquals(String descr) throws SiceeDDichiarazioneDaoException;

	/**
	 * Returns the rows from the SICEE_D_DICHIARAZIONE table that matches the specified primary-key value.
	 *
	 * @param pk the pk
	 * @return the sicee d dichiarazione
	 * @throws SiceeDDichiarazioneDaoException the sicee d dichiarazione dao exception
	 */
	public SiceeDDichiarazione findByPrimaryKey(SiceeDDichiarazionePk pk) throws SiceeDDichiarazioneDaoException;

}
