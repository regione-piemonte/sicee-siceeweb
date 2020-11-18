/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceeweb.business.dao.dao;

import it.csi.sicee.siceeweb.business.dao.dto.SiceeDSistemaRacc;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeDSistemaRaccPk;
import it.csi.sicee.siceeweb.business.dao.exceptions.SiceeDSistemaRaccDaoException;

import java.util.List;

// TODO: Auto-generated Javadoc
/**
 * The Interface SiceeDSistemaRaccDao.
 */
public interface SiceeDSistemaRaccDao
{
	
	/**
	 * Method 'insert'.
	 *
	 * @param dto the dto
	 * @return SiceeDSistemaRaccPk
	 */
	public SiceeDSistemaRaccPk insert(SiceeDSistemaRacc dto);

	/**
	 * Updates a single row in the SICEE_D_SISTEMA_RACC table.
	 *
	 * @param pk the pk
	 * @param dto the dto
	 * @throws SiceeDSistemaRaccDaoException the sicee d sistema racc dao exception
	 */
	public void update(SiceeDSistemaRaccPk pk, SiceeDSistemaRacc dto) throws SiceeDSistemaRaccDaoException;

	/**
	 * Deletes a single row in the SICEE_D_SISTEMA_RACC table.
	 *
	 * @param pk the pk
	 * @throws SiceeDSistemaRaccDaoException the sicee d sistema racc dao exception
	 */
	public void delete(SiceeDSistemaRaccPk pk) throws SiceeDSistemaRaccDaoException;

	/**
	 * Returns all rows from the SICEE_D_SISTEMA_RACC table that match the criteria 'SISTEMA = :sistema'.
	 *
	 * @param sistema the sistema
	 * @return the sicee d sistema racc
	 * @throws SiceeDSistemaRaccDaoException the sicee d sistema racc dao exception
	 */
	public SiceeDSistemaRacc findByPrimaryKey(String sistema) throws SiceeDSistemaRaccDaoException;

	/**
	 * Returns all rows from the SICEE_D_SISTEMA_RACC table that match the criteria ''.
	 *
	 * @return the list
	 * @throws SiceeDSistemaRaccDaoException the sicee d sistema racc dao exception
	 */
	public List<SiceeDSistemaRacc> findAll() throws SiceeDSistemaRaccDaoException;

	/**
	 * Returns all rows from the SICEE_D_SISTEMA_RACC table that match the criteria 'SISTEMA = :sistema'.
	 *
	 * @param sistema the sistema
	 * @return the list
	 * @throws SiceeDSistemaRaccDaoException the sicee d sistema racc dao exception
	 */
	public List<SiceeDSistemaRacc> findWhereSistemaEquals(String sistema) throws SiceeDSistemaRaccDaoException;

	/**
	 * Returns the rows from the SICEE_D_SISTEMA_RACC table that matches the specified primary-key value.
	 *
	 * @param pk the pk
	 * @return the sicee d sistema racc
	 * @throws SiceeDSistemaRaccDaoException the sicee d sistema racc dao exception
	 */
	public SiceeDSistemaRacc findByPrimaryKey(SiceeDSistemaRaccPk pk) throws SiceeDSistemaRaccDaoException;

}
