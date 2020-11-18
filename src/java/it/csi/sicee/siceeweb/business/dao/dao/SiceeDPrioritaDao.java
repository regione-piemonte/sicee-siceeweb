/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceeweb.business.dao.dao;

import it.csi.sicee.siceeweb.business.dao.dao.SiceeDPrioritaDao;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeDPriorita;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeDPrioritaPk;
import it.csi.sicee.siceeweb.business.dao.exceptions.SiceeDPrioritaDaoException;
import java.util.List;

// TODO: Auto-generated Javadoc
/**
 * The Interface SiceeDPrioritaDao.
 */
public interface SiceeDPrioritaDao
{
	
	/**
	 * Method 'insert'.
	 *
	 * @param dto the dto
	 * @return SiceeDPrioritaPk
	 */
	public SiceeDPrioritaPk insert(SiceeDPriorita dto);

	/**
	 * Updates a single row in the SICEE_D_PRIORITA table.
	 *
	 * @param pk the pk
	 * @param dto the dto
	 * @throws SiceeDPrioritaDaoException the sicee d priorita dao exception
	 */
	public void update(SiceeDPrioritaPk pk, SiceeDPriorita dto) throws SiceeDPrioritaDaoException;

	/**
	 * Deletes a single row in the SICEE_D_PRIORITA table.
	 *
	 * @param pk the pk
	 * @throws SiceeDPrioritaDaoException the sicee d priorita dao exception
	 */
	public void delete(SiceeDPrioritaPk pk) throws SiceeDPrioritaDaoException;

	/**
	 * Returns all rows from the SICEE_D_PRIORITA table that match the criteria 'PRIORITA = :priorita'.
	 *
	 * @param priorita the priorita
	 * @return the sicee d priorita
	 * @throws SiceeDPrioritaDaoException the sicee d priorita dao exception
	 */
	public SiceeDPriorita findByPrimaryKey(String priorita) throws SiceeDPrioritaDaoException;

	/**
	 * Returns all rows from the SICEE_D_PRIORITA table that match the criteria ''.
	 *
	 * @return the list
	 * @throws SiceeDPrioritaDaoException the sicee d priorita dao exception
	 */
	public List<SiceeDPriorita> findAll() throws SiceeDPrioritaDaoException;

	/**
	 * Returns all rows from the SICEE_D_PRIORITA table that match the criteria 'PRIORITA = :priorita'.
	 *
	 * @param priorita the priorita
	 * @return the list
	 * @throws SiceeDPrioritaDaoException the sicee d priorita dao exception
	 */
	public List<SiceeDPriorita> findWherePrioritaEquals(String priorita) throws SiceeDPrioritaDaoException;

	/**
	 * Returns the rows from the SICEE_D_PRIORITA table that matches the specified primary-key value.
	 *
	 * @param pk the pk
	 * @return the sicee d priorita
	 * @throws SiceeDPrioritaDaoException the sicee d priorita dao exception
	 */
	public SiceeDPriorita findByPrimaryKey(SiceeDPrioritaPk pk) throws SiceeDPrioritaDaoException;

}
