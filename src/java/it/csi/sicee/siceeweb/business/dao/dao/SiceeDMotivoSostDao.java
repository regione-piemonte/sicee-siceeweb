/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceeweb.business.dao.dao;

import it.csi.sicee.siceeweb.business.dao.dao.SiceeDMotivoSostDao;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeDMotivoSost;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeDMotivoSostPk;
import it.csi.sicee.siceeweb.business.dao.exceptions.SiceeDMotivoSostDaoException;
import java.util.List;

// TODO: Auto-generated Javadoc
/**
 * The Interface SiceeDMotivoSostDao.
 */
public interface SiceeDMotivoSostDao
{
	
	/**
	 * Method 'insert'.
	 *
	 * @param dto the dto
	 * @return SiceeDMotivoSostPk
	 */
	public SiceeDMotivoSostPk insert(SiceeDMotivoSost dto);

	/**
	 * Updates a single row in the SICEE_D_MOTIVO_SOST table.
	 *
	 * @param pk the pk
	 * @param dto the dto
	 * @throws SiceeDMotivoSostDaoException the sicee d motivo sost dao exception
	 */
	public void update(SiceeDMotivoSostPk pk, SiceeDMotivoSost dto) throws SiceeDMotivoSostDaoException;

	/**
	 * Deletes a single row in the SICEE_D_MOTIVO_SOST table.
	 *
	 * @param pk the pk
	 * @throws SiceeDMotivoSostDaoException the sicee d motivo sost dao exception
	 */
	public void delete(SiceeDMotivoSostPk pk) throws SiceeDMotivoSostDaoException;

	/**
	 * Returns all rows from the SICEE_D_MOTIVO_SOST table that match the criteria 'ID_MOTIVO_SOST = :idMotivoSost'.
	 *
	 * @param idMotivoSost the id motivo sost
	 * @return the sicee d motivo sost
	 * @throws SiceeDMotivoSostDaoException the sicee d motivo sost dao exception
	 */
	public SiceeDMotivoSost findByPrimaryKey(Integer idMotivoSost) throws SiceeDMotivoSostDaoException;

	/**
	 * Returns all rows from the SICEE_D_MOTIVO_SOST table that match the criteria ''.
	 *
	 * @return the list
	 * @throws SiceeDMotivoSostDaoException the sicee d motivo sost dao exception
	 */
	public List<SiceeDMotivoSost> findAll() throws SiceeDMotivoSostDaoException;

	/**
	 * Returns all rows from the SICEE_D_MOTIVO_SOST table that match the criteria 'ID_MOTIVO_SOST = :idMotivoSost'.
	 *
	 * @param idMotivoSost the id motivo sost
	 * @return the list
	 * @throws SiceeDMotivoSostDaoException the sicee d motivo sost dao exception
	 */
	public List<SiceeDMotivoSost> findWhereIdMotivoSostEquals(Integer idMotivoSost) throws SiceeDMotivoSostDaoException;

	/**
	 * Returns all rows from the SICEE_D_MOTIVO_SOST table that match the criteria 'DESCR = :descr'.
	 *
	 * @param descr the descr
	 * @return the list
	 * @throws SiceeDMotivoSostDaoException the sicee d motivo sost dao exception
	 */
	public List<SiceeDMotivoSost> findWhereDescrEquals(String descr) throws SiceeDMotivoSostDaoException;

	/**
	 * Returns all rows from the SICEE_D_MOTIVO_SOST table that match the criteria 'MIN = :min'.
	 *
	 * @param min the min
	 * @return the list
	 * @throws SiceeDMotivoSostDaoException the sicee d motivo sost dao exception
	 */
	public List<SiceeDMotivoSost> findWhereMinEquals(Integer min) throws SiceeDMotivoSostDaoException;

	/**
	 * Returns all rows from the SICEE_D_MOTIVO_SOST table that match the criteria 'MAX = :max'.
	 *
	 * @param max the max
	 * @return the list
	 * @throws SiceeDMotivoSostDaoException the sicee d motivo sost dao exception
	 */
	public List<SiceeDMotivoSost> findWhereMaxEquals(Integer max) throws SiceeDMotivoSostDaoException;

	/**
	 * Returns all rows from the SICEE_D_MOTIVO_SOST table that match the criteria 'FLG_VISIBILE_COMBO = 'S''.
	 *
	 * @return the list
	 * @throws SiceeDMotivoSostDaoException the sicee d motivo sost dao exception
	 */
	public List<SiceeDMotivoSost> findWhereFlagComboEqualsS() throws SiceeDMotivoSostDaoException;

	/**
	 * Returns the rows from the SICEE_D_MOTIVO_SOST table that matches the specified primary-key value.
	 *
	 * @param pk the pk
	 * @return the sicee d motivo sost
	 * @throws SiceeDMotivoSostDaoException the sicee d motivo sost dao exception
	 */
	public SiceeDMotivoSost findByPrimaryKey(SiceeDMotivoSostPk pk) throws SiceeDMotivoSostDaoException;

}
