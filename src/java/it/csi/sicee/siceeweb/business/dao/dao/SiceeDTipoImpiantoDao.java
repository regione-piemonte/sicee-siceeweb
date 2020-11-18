/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceeweb.business.dao.dao;

import it.csi.sicee.siceeweb.business.dao.dto.SiceeDTipoImpianto;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeDTipoImpiantoPk;
import it.csi.sicee.siceeweb.business.dao.exceptions.SiceeDTipoImpiantoDaoException;

import java.util.List;

// TODO: Auto-generated Javadoc
/**
 * The Interface SiceeDTipoImpiantoDao.
 */
public interface SiceeDTipoImpiantoDao
{
	
	/**
	 * Method 'insert'.
	 *
	 * @param dto the dto
	 * @return SiceeDTipoImpiantoPk
	 */
	public SiceeDTipoImpiantoPk insert(SiceeDTipoImpianto dto);

	/**
	 * Updates a single row in the SICEE_D_TIPO_IMPIANTO table.
	 *
	 * @param pk the pk
	 * @param dto the dto
	 * @throws SiceeDTipoImpiantoDaoException the sicee d tipo impianto dao exception
	 */
	public void update(SiceeDTipoImpiantoPk pk, SiceeDTipoImpianto dto) throws SiceeDTipoImpiantoDaoException;

	/**
	 * Deletes a single row in the SICEE_D_TIPO_IMPIANTO table.
	 *
	 * @param pk the pk
	 * @throws SiceeDTipoImpiantoDaoException the sicee d tipo impianto dao exception
	 */
	public void delete(SiceeDTipoImpiantoPk pk) throws SiceeDTipoImpiantoDaoException;

	/**
	 * Returns all rows from the SICEE_D_TIPO_IMPIANTO table that match the criteria 'ID_TIPO_IMPIANTO = :idTipoImpianto'.
	 *
	 * @param idTipoImpianto the id tipo impianto
	 * @return the sicee d tipo impianto
	 * @throws SiceeDTipoImpiantoDaoException the sicee d tipo impianto dao exception
	 */
	public SiceeDTipoImpianto findByPrimaryKey(Integer idTipoImpianto) throws SiceeDTipoImpiantoDaoException;

	/**
	 * Returns all rows from the SICEE_D_TIPO_IMPIANTO table that match the criteria ''.
	 *
	 * @return the list
	 * @throws SiceeDTipoImpiantoDaoException the sicee d tipo impianto dao exception
	 */
	public List<SiceeDTipoImpianto> findAll() throws SiceeDTipoImpiantoDaoException;

	/**
	 * Returns all rows from the SICEE_D_TIPO_IMPIANTO table that match the criteria 'ID_TIPO_IMPIANTO = :idTipoImpianto'.
	 *
	 * @param idTipoImpianto the id tipo impianto
	 * @return the list
	 * @throws SiceeDTipoImpiantoDaoException the sicee d tipo impianto dao exception
	 */
	public List<SiceeDTipoImpianto> findWhereIdTipoImpiantoEquals(Integer idTipoImpianto) throws SiceeDTipoImpiantoDaoException;

	/**
	 * Returns all rows from the SICEE_D_TIPO_IMPIANTO table that match the criteria 'DESCR = :descr'.
	 *
	 * @param descr the descr
	 * @return the list
	 * @throws SiceeDTipoImpiantoDaoException the sicee d tipo impianto dao exception
	 */
	public List<SiceeDTipoImpianto> findWhereDescrEquals(String descr) throws SiceeDTipoImpiantoDaoException;

	/**
	 * Returns the rows from the SICEE_D_TIPO_IMPIANTO table that matches the specified primary-key value.
	 *
	 * @param pk the pk
	 * @return the sicee d tipo impianto
	 * @throws SiceeDTipoImpiantoDaoException the sicee d tipo impianto dao exception
	 */
	public SiceeDTipoImpianto findByPrimaryKey(SiceeDTipoImpiantoPk pk) throws SiceeDTipoImpiantoDaoException;

}
