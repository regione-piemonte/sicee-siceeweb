/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceeweb.business.dao.dao;

import it.csi.sicee.siceeweb.business.dao.dto.SiceeDRuolo;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeDRuoloPk;
import it.csi.sicee.siceeweb.business.dao.exceptions.SiceeDRuoloDaoException;

import java.util.List;

// TODO: Auto-generated Javadoc
/**
 * The Interface SiceeDRuoloDao.
 */
public interface SiceeDRuoloDao
{
	
	/**
	 * Method 'insert'.
	 *
	 * @param dto the dto
	 * @return SiceeDRuoloPk
	 */
	public SiceeDRuoloPk insert(SiceeDRuolo dto);

	/**
	 * Updates a single row in the SICEE_D_RUOLO table.
	 *
	 * @param pk the pk
	 * @param dto the dto
	 * @throws SiceeDRuoloDaoException the sicee d ruolo dao exception
	 */
	public void update(SiceeDRuoloPk pk, SiceeDRuolo dto) throws SiceeDRuoloDaoException;

	/**
	 * Deletes a single row in the SICEE_D_RUOLO table.
	 *
	 * @param pk the pk
	 * @throws SiceeDRuoloDaoException the sicee d ruolo dao exception
	 */
	public void delete(SiceeDRuoloPk pk) throws SiceeDRuoloDaoException;

	/**
	 * Returns all rows from the SICEE_D_RUOLO table that match the criteria 'ID_TIPO_RUOLO = :idTipoRuolo'.
	 *
	 * @param idTipoRuolo the id tipo ruolo
	 * @return the sicee d ruolo
	 * @throws SiceeDRuoloDaoException the sicee d ruolo dao exception
	 */
	public SiceeDRuolo findByPrimaryKey(Integer idTipoRuolo) throws SiceeDRuoloDaoException;

	/**
	 * Returns all rows from the SICEE_D_RUOLO table that match the criteria ''.
	 *
	 * @return the list
	 * @throws SiceeDRuoloDaoException the sicee d ruolo dao exception
	 */
	public List<SiceeDRuolo> findAll() throws SiceeDRuoloDaoException;

	/**
	 * Returns all rows from the SICEE_D_RUOLO table that match the criteria 'ID_TIPO_RUOLO = :idTipoRuolo'.
	 *
	 * @param idTipoRuolo the id tipo ruolo
	 * @return the list
	 * @throws SiceeDRuoloDaoException the sicee d ruolo dao exception
	 */
	public List<SiceeDRuolo> findWhereIdTipoRuoloEquals(Integer idTipoRuolo) throws SiceeDRuoloDaoException;

	/**
	 * Returns all rows from the SICEE_D_RUOLO table that match the criteria 'DESCR = :descr'.
	 *
	 * @param descr the descr
	 * @return the list
	 * @throws SiceeDRuoloDaoException the sicee d ruolo dao exception
	 */
	public List<SiceeDRuolo> findWhereDescrEquals(String descr) throws SiceeDRuoloDaoException;

	/**
	 * Returns the rows from the SICEE_D_RUOLO table that matches the specified primary-key value.
	 *
	 * @param pk the pk
	 * @return the sicee d ruolo
	 * @throws SiceeDRuoloDaoException the sicee d ruolo dao exception
	 */
	public SiceeDRuolo findByPrimaryKey(SiceeDRuoloPk pk) throws SiceeDRuoloDaoException;

}
