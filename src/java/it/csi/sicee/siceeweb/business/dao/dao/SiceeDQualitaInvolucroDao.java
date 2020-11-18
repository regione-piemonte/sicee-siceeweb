/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceeweb.business.dao.dao;

import it.csi.sicee.siceeweb.business.dao.dto.SiceeDQualitaInvolucro;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeDQualitaInvolucroPk;
import it.csi.sicee.siceeweb.business.dao.exceptions.SiceeDQualitaInvolucroDaoException;

import java.util.List;

// TODO: Auto-generated Javadoc
/**
 * The Interface SiceeDQualitaInvolucroDao.
 */
public interface SiceeDQualitaInvolucroDao
{
	
	/**
	 * Method 'insert'.
	 *
	 * @param dto the dto
	 * @return SiceeDQualitaInvolucroPk
	 */
	public SiceeDQualitaInvolucroPk insert(SiceeDQualitaInvolucro dto);

	/**
	 * Updates a single row in the SICEE_D_QUALITA_INVOLUCRO table.
	 *
	 * @param pk the pk
	 * @param dto the dto
	 * @throws SiceeDQualitaInvolucroDaoException the sicee d qualita involucro dao exception
	 */
	public void update(SiceeDQualitaInvolucroPk pk, SiceeDQualitaInvolucro dto) throws SiceeDQualitaInvolucroDaoException;

	/**
	 * Deletes a single row in the SICEE_D_QUALITA_INVOLUCRO table.
	 *
	 * @param pk the pk
	 * @throws SiceeDQualitaInvolucroDaoException the sicee d qualita involucro dao exception
	 */
	public void delete(SiceeDQualitaInvolucroPk pk) throws SiceeDQualitaInvolucroDaoException;

	/**
	 * Returns all rows from the SICEE_D_QUALITA_INVOLUCRO table that match the criteria 'ID_QUALITA = :idQualita'.
	 *
	 * @param idQualita the id qualita
	 * @return the sicee d qualita involucro
	 * @throws SiceeDQualitaInvolucroDaoException the sicee d qualita involucro dao exception
	 */
	public SiceeDQualitaInvolucro findByPrimaryKey(Integer idQualita) throws SiceeDQualitaInvolucroDaoException;

	/**
	 * Returns all rows from the SICEE_D_QUALITA_INVOLUCRO table that match the criteria ''.
	 *
	 * @return the list
	 * @throws SiceeDQualitaInvolucroDaoException the sicee d qualita involucro dao exception
	 */
	public List<SiceeDQualitaInvolucro> findAll() throws SiceeDQualitaInvolucroDaoException;

	/**
	 * Returns all rows from the SICEE_D_QUALITA_INVOLUCRO table that match the criteria 'ID_QUALITA = :idQualita'.
	 *
	 * @param idQualita the id qualita
	 * @return the list
	 * @throws SiceeDQualitaInvolucroDaoException the sicee d qualita involucro dao exception
	 */
	public List<SiceeDQualitaInvolucro> findWhereIdQualitaEquals(Integer idQualita) throws SiceeDQualitaInvolucroDaoException;

	/**
	 * Returns all rows from the SICEE_D_QUALITA_INVOLUCRO table that match the criteria 'DESCR = :descr'.
	 *
	 * @param descr the descr
	 * @return the list
	 * @throws SiceeDQualitaInvolucroDaoException the sicee d qualita involucro dao exception
	 */
	public List<SiceeDQualitaInvolucro> findWhereDescrEquals(String descr) throws SiceeDQualitaInvolucroDaoException;

	/**
	 * Returns the rows from the SICEE_D_QUALITA_INVOLUCRO table that matches the specified primary-key value.
	 *
	 * @param pk the pk
	 * @return the sicee d qualita involucro
	 * @throws SiceeDQualitaInvolucroDaoException the sicee d qualita involucro dao exception
	 */
	public SiceeDQualitaInvolucro findByPrimaryKey(SiceeDQualitaInvolucroPk pk) throws SiceeDQualitaInvolucroDaoException;

}
