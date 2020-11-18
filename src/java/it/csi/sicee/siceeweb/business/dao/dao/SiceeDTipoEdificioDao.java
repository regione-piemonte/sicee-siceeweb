/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceeweb.business.dao.dao;

import it.csi.sicee.siceeweb.business.dao.dao.SiceeDTipoEdificioDao;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeDTipoEdificio;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeDTipoEdificioPk;
import it.csi.sicee.siceeweb.business.dao.exceptions.SiceeDTipoEdificioDaoException;
import java.util.List;

// TODO: Auto-generated Javadoc
/**
 * The Interface SiceeDTipoEdificioDao.
 */
public interface SiceeDTipoEdificioDao
{
	
	/**
	 * Method 'insert'.
	 *
	 * @param dto the dto
	 * @return SiceeDTipoEdificioPk
	 */
	public SiceeDTipoEdificioPk insert(SiceeDTipoEdificio dto);

	/**
	 * Updates a single row in the SICEE_D_TIPO_EDIFICIO table.
	 *
	 * @param pk the pk
	 * @param dto the dto
	 * @throws SiceeDTipoEdificioDaoException the sicee d tipo edificio dao exception
	 */
	public void update(SiceeDTipoEdificioPk pk, SiceeDTipoEdificio dto) throws SiceeDTipoEdificioDaoException;

	/**
	 * Deletes a single row in the SICEE_D_TIPO_EDIFICIO table.
	 *
	 * @param pk the pk
	 * @throws SiceeDTipoEdificioDaoException the sicee d tipo edificio dao exception
	 */
	public void delete(SiceeDTipoEdificioPk pk) throws SiceeDTipoEdificioDaoException;

	/**
	 * Returns all rows from the SICEE_D_TIPO_EDIFICIO table that match the criteria 'ID_TIPO_EDIFICIO = :idTipoEdificio'.
	 *
	 * @param idTipoEdificio the id tipo edificio
	 * @return the sicee d tipo edificio
	 * @throws SiceeDTipoEdificioDaoException the sicee d tipo edificio dao exception
	 */
	public SiceeDTipoEdificio findByPrimaryKey(Integer idTipoEdificio) throws SiceeDTipoEdificioDaoException;

	/**
	 * Returns all rows from the SICEE_D_TIPO_EDIFICIO table that match the criteria ''.
	 *
	 * @return the list
	 * @throws SiceeDTipoEdificioDaoException the sicee d tipo edificio dao exception
	 */
	public List<SiceeDTipoEdificio> findAll() throws SiceeDTipoEdificioDaoException;

	/**
	 * Returns all rows from the SICEE_D_TIPO_EDIFICIO table that match the criteria 'ID_TIPO_EDIFICIO = :idTipoEdificio'.
	 *
	 * @param idTipoEdificio the id tipo edificio
	 * @return the list
	 * @throws SiceeDTipoEdificioDaoException the sicee d tipo edificio dao exception
	 */
	public List<SiceeDTipoEdificio> findWhereIdTipoEdificioEquals(Integer idTipoEdificio) throws SiceeDTipoEdificioDaoException;

	/**
	 * Returns all rows from the SICEE_D_TIPO_EDIFICIO table that match the criteria 'FK_TIPO_IMPIANTO = :fkTipoImpianto'.
	 *
	 * @param fkTipoImpianto the fk tipo impianto
	 * @return the list
	 * @throws SiceeDTipoEdificioDaoException the sicee d tipo edificio dao exception
	 */
	public List<SiceeDTipoEdificio> findWhereFkTipoImpiantoEquals(Integer fkTipoImpianto) throws SiceeDTipoEdificioDaoException;

	/**
	 * Returns all rows from the SICEE_D_TIPO_EDIFICIO table that match the criteria 'DESCR = :descr'.
	 *
	 * @param descr the descr
	 * @return the list
	 * @throws SiceeDTipoEdificioDaoException the sicee d tipo edificio dao exception
	 */
	public List<SiceeDTipoEdificio> findWhereDescrEquals(String descr) throws SiceeDTipoEdificioDaoException;

	/**
	 * Returns the rows from the SICEE_D_TIPO_EDIFICIO table that matches the specified primary-key value.
	 *
	 * @param pk the pk
	 * @return the sicee d tipo edificio
	 * @throws SiceeDTipoEdificioDaoException the sicee d tipo edificio dao exception
	 */
	public SiceeDTipoEdificio findByPrimaryKey(SiceeDTipoEdificioPk pk) throws SiceeDTipoEdificioDaoException;

}
