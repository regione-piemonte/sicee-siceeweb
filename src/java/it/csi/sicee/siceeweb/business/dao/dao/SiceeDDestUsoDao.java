/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceeweb.business.dao.dao;

import it.csi.sicee.siceeweb.business.dao.dao.SiceeDDestUsoDao;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeDDestUso;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeDDestUsoPk;
import it.csi.sicee.siceeweb.business.dao.exceptions.SiceeDDestUsoDaoException;
import java.util.List;

// TODO: Auto-generated Javadoc
/**
 * The Interface SiceeDDestUsoDao.
 */
public interface SiceeDDestUsoDao
{
	
	/**
	 * Method 'insert'.
	 *
	 * @param dto the dto
	 * @return SiceeDDestUsoPk
	 */
	public SiceeDDestUsoPk insert(SiceeDDestUso dto);

	/**
	 * Updates a single row in the SICEE_D_DEST_USO table.
	 *
	 * @param pk the pk
	 * @param dto the dto
	 * @throws SiceeDDestUsoDaoException the sicee d dest uso dao exception
	 */
	public void update(SiceeDDestUsoPk pk, SiceeDDestUso dto) throws SiceeDDestUsoDaoException;

	/**
	 * Deletes a single row in the SICEE_D_DEST_USO table.
	 *
	 * @param pk the pk
	 * @throws SiceeDDestUsoDaoException the sicee d dest uso dao exception
	 */
	public void delete(SiceeDDestUsoPk pk) throws SiceeDDestUsoDaoException;

	/**
	 * Returns all rows from the SICEE_D_DEST_USO table that match the criteria 'ID_DEST_USO = :idDestUso'.
	 *
	 * @param idDestUso the id dest uso
	 * @return the sicee d dest uso
	 * @throws SiceeDDestUsoDaoException the sicee d dest uso dao exception
	 */
	public SiceeDDestUso findByPrimaryKey(Integer idDestUso) throws SiceeDDestUsoDaoException;

	/**
	 * Returns all rows from the SICEE_D_DEST_USO table that match the criteria 'FLG_VISIBILE_COMBO = 'S''.
	 *
	 * @return the list
	 * @throws SiceeDDestUsoDaoException the sicee d dest uso dao exception
	 */
	public List<SiceeDDestUso> findAll() throws SiceeDDestUsoDaoException;

	/**
	 * Returns all rows from the SICEE_D_DEST_USO table that match the criteria 'ID_DEST_USO = :idDestUso'.
	 *
	 * @param idDestUso the id dest uso
	 * @return the list
	 * @throws SiceeDDestUsoDaoException the sicee d dest uso dao exception
	 */
	public List<SiceeDDestUso> findWhereIdDestUsoEquals(Integer idDestUso) throws SiceeDDestUsoDaoException;

	/**
	 * Returns all rows from the SICEE_D_DEST_USO table that match the criteria 'SIGLA = :sigla'.
	 *
	 * @param sigla the sigla
	 * @return the list
	 * @throws SiceeDDestUsoDaoException the sicee d dest uso dao exception
	 */
	public List<SiceeDDestUso> findWhereSiglaEquals(String sigla) throws SiceeDDestUsoDaoException;

	/**
	 * Returns all rows from the SICEE_D_DEST_USO table that match the criteria 'DESCR = :descr'.
	 *
	 * @param descr the descr
	 * @return the list
	 * @throws SiceeDDestUsoDaoException the sicee d dest uso dao exception
	 */
	public List<SiceeDDestUso> findWhereDescrEquals(String descr) throws SiceeDDestUsoDaoException;

	/**
	 * Returns all rows from the SICEE_D_DEST_USO table that match the criteria 'FLG_EDIFICIO = :flgEdificio'.
	 *
	 * @param flgEdificio the flg edificio
	 * @return the list
	 * @throws SiceeDDestUsoDaoException the sicee d dest uso dao exception
	 */
	public List<SiceeDDestUso> findWhereFlgEdificioEquals(String flgEdificio) throws SiceeDDestUsoDaoException;

	/**
	 * Returns the rows from the SICEE_D_DEST_USO table that matches the specified primary-key value.
	 *
	 * @param pk the pk
	 * @return the sicee d dest uso
	 * @throws SiceeDDestUsoDaoException the sicee d dest uso dao exception
	 */
	public SiceeDDestUso findByPrimaryKey(SiceeDDestUsoPk pk) throws SiceeDDestUsoDaoException;

}
