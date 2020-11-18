/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceeweb.business.dao.dao;

import it.csi.sicee.siceeweb.business.dao.dto.SiceeRDestClasse;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeRDestClassePk;
import it.csi.sicee.siceeweb.business.dao.exceptions.SiceeRDestClasseDaoException;

import java.util.List;

// TODO: Auto-generated Javadoc
/**
 * The Interface SiceeRDestClasseDao.
 */
public interface SiceeRDestClasseDao
{
	
	/**
	 * Method 'insert'.
	 *
	 * @param dto the dto
	 * @return SiceeRDestClassePk
	 */
	public SiceeRDestClassePk insert(SiceeRDestClasse dto);

	/**
	 * Updates a single row in the SICEE_R_DEST_CLASSE table.
	 *
	 * @param pk the pk
	 * @param dto the dto
	 * @throws SiceeRDestClasseDaoException the sicee r dest classe dao exception
	 */
	public void update(SiceeRDestClassePk pk, SiceeRDestClasse dto) throws SiceeRDestClasseDaoException;

	/**
	 * Deletes a single row in the SICEE_R_DEST_CLASSE table.
	 *
	 * @param pk the pk
	 * @throws SiceeRDestClasseDaoException the sicee r dest classe dao exception
	 */
	public void delete(SiceeRDestClassePk pk) throws SiceeRDestClasseDaoException;

	/**
	 * Returns all rows from the SICEE_R_DEST_CLASSE table that match the criteria 'ID_CLASSE = :idClasse AND ID_DEST_USO = :idDestUso'.
	 *
	 * @param idClasse the id classe
	 * @param idDestUso the id dest uso
	 * @return the sicee r dest classe
	 * @throws SiceeRDestClasseDaoException the sicee r dest classe dao exception
	 */
	public SiceeRDestClasse findByPrimaryKey(Integer idClasse, Integer idDestUso) throws SiceeRDestClasseDaoException;

	/**
	 * Returns all rows from the SICEE_R_DEST_CLASSE table that match the criteria ''.
	 *
	 * @return the list
	 * @throws SiceeRDestClasseDaoException the sicee r dest classe dao exception
	 */
	public List<SiceeRDestClasse> findAll() throws SiceeRDestClasseDaoException;

	/**
	 * Returns all rows from the SICEE_R_DEST_CLASSE table that match the criteria 'ID_CLASSE = :idClasse'.
	 *
	 * @param idClasse the id classe
	 * @return the list
	 * @throws SiceeRDestClasseDaoException the sicee r dest classe dao exception
	 */
	public List<SiceeRDestClasse> findWhereIdClasseEquals(Integer idClasse) throws SiceeRDestClasseDaoException;

	/**
	 * Returns all rows from the SICEE_R_DEST_CLASSE table that match the criteria 'ID_DEST_USO = :idDestUso'.
	 *
	 * @param idDestUso the id dest uso
	 * @return the list
	 * @throws SiceeRDestClasseDaoException the sicee r dest classe dao exception
	 */
	public List<SiceeRDestClasse> findWhereIdDestUsoEquals(Integer idDestUso) throws SiceeRDestClasseDaoException;

	/**
	 * Returns all rows from the SICEE_R_DEST_CLASSE table that match the criteria 'MIN = :min'.
	 *
	 * @param min the min
	 * @return the list
	 * @throws SiceeRDestClasseDaoException the sicee r dest classe dao exception
	 */
	public List<SiceeRDestClasse> findWhereMinEquals(Integer min) throws SiceeRDestClasseDaoException;

	/**
	 * Returns all rows from the SICEE_R_DEST_CLASSE table that match the criteria 'MAX = :max'.
	 *
	 * @param max the max
	 * @return the list
	 * @throws SiceeRDestClasseDaoException the sicee r dest classe dao exception
	 */
	public List<SiceeRDestClasse> findWhereMaxEquals(Integer max) throws SiceeRDestClasseDaoException;

	/**
	 * Returns the rows from the SICEE_R_DEST_CLASSE table that matches the specified primary-key value.
	 *
	 * @param pk the pk
	 * @return the sicee r dest classe
	 * @throws SiceeRDestClasseDaoException the sicee r dest classe dao exception
	 */
	public SiceeRDestClasse findByPrimaryKey(SiceeRDestClassePk pk) throws SiceeRDestClasseDaoException;

}
