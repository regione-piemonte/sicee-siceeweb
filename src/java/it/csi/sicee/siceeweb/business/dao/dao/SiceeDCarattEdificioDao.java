/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceeweb.business.dao.dao;

import it.csi.sicee.siceeweb.business.dao.dao.SiceeDCarattEdificioDao;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeDCarattEdificio;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeDCarattEdificioPk;
import it.csi.sicee.siceeweb.business.dao.exceptions.SiceeDCarattEdificioDaoException;
import java.util.List;

// TODO: Auto-generated Javadoc
/**
 * The Interface SiceeDCarattEdificioDao.
 */
public interface SiceeDCarattEdificioDao
{
	
	/**
	 * Method 'insert'.
	 *
	 * @param dto the dto
	 * @return SiceeDCarattEdificioPk
	 */
	public SiceeDCarattEdificioPk insert(SiceeDCarattEdificio dto);

	/**
	 * Updates a single row in the SICEE_D_CARATT_EDIFICIO table.
	 *
	 * @param pk the pk
	 * @param dto the dto
	 * @throws SiceeDCarattEdificioDaoException the sicee d caratt edificio dao exception
	 */
	public void update(SiceeDCarattEdificioPk pk, SiceeDCarattEdificio dto) throws SiceeDCarattEdificioDaoException;

	/**
	 * Deletes a single row in the SICEE_D_CARATT_EDIFICIO table.
	 *
	 * @param pk the pk
	 * @throws SiceeDCarattEdificioDaoException the sicee d caratt edificio dao exception
	 */
	public void delete(SiceeDCarattEdificioPk pk) throws SiceeDCarattEdificioDaoException;

	/**
	 * Returns all rows from the SICEE_D_CARATT_EDIFICIO table that match the criteria 'ID_CARATT_EDIFICIO = :idCarattEdificio'.
	 *
	 * @param idCarattEdificio the id caratt edificio
	 * @return the sicee d caratt edificio
	 * @throws SiceeDCarattEdificioDaoException the sicee d caratt edificio dao exception
	 */
	public SiceeDCarattEdificio findByPrimaryKey(Integer idCarattEdificio) throws SiceeDCarattEdificioDaoException;

	/**
	 * Returns all rows from the SICEE_D_CARATT_EDIFICIO table that match the criteria ''.
	 *
	 * @return the list
	 * @throws SiceeDCarattEdificioDaoException the sicee d caratt edificio dao exception
	 */
	public List<SiceeDCarattEdificio> findAll() throws SiceeDCarattEdificioDaoException;

	/**
	 * Returns all rows from the SICEE_D_CARATT_EDIFICIO table that match the criteria 'FK_TIPO_EDIFICIO = :fkTipoEdificio'.
	 *
	 * @param fkTipoEdificio the fk tipo edificio
	 * @return the list
	 * @throws SiceeDCarattEdificioDaoException the sicee d caratt edificio dao exception
	 */
	public List<SiceeDCarattEdificio> findBySiceeDTipoEdificio(Integer fkTipoEdificio) throws SiceeDCarattEdificioDaoException;

	/**
	 * Returns all rows from the SICEE_D_CARATT_EDIFICIO table that match the criteria 'ID_CARATT_EDIFICIO = :idCarattEdificio'.
	 *
	 * @param idCarattEdificio the id caratt edificio
	 * @return the list
	 * @throws SiceeDCarattEdificioDaoException the sicee d caratt edificio dao exception
	 */
	public List<SiceeDCarattEdificio> findWhereIdCarattEdificioEquals(Integer idCarattEdificio) throws SiceeDCarattEdificioDaoException;

	/**
	 * Returns all rows from the SICEE_D_CARATT_EDIFICIO table that match the criteria 'DESCR = :descr'.
	 *
	 * @param descr the descr
	 * @return the list
	 * @throws SiceeDCarattEdificioDaoException the sicee d caratt edificio dao exception
	 */
	public List<SiceeDCarattEdificio> findWhereDescrEquals(String descr) throws SiceeDCarattEdificioDaoException;

	/**
	 * Returns all rows from the SICEE_D_CARATT_EDIFICIO table that match the criteria 'FK_TIPO_EDIFICIO = :fkTipoEdificio'.
	 *
	 * @param fkTipoEdificio the fk tipo edificio
	 * @return the list
	 * @throws SiceeDCarattEdificioDaoException the sicee d caratt edificio dao exception
	 */
	public List<SiceeDCarattEdificio> findWhereFkTipoEdificioEquals(Integer fkTipoEdificio) throws SiceeDCarattEdificioDaoException;

	/**
	 * Returns the rows from the SICEE_D_CARATT_EDIFICIO table that matches the specified primary-key value.
	 *
	 * @param pk the pk
	 * @return the sicee d caratt edificio
	 * @throws SiceeDCarattEdificioDaoException the sicee d caratt edificio dao exception
	 */
	public SiceeDCarattEdificio findByPrimaryKey(SiceeDCarattEdificioPk pk) throws SiceeDCarattEdificioDaoException;

}
