/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceeweb.business.dao.dao;

import it.csi.sicee.siceeweb.business.dao.dto.SiceeDDatiIngresso;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeDDatiIngressoPk;
import it.csi.sicee.siceeweb.business.dao.exceptions.SiceeDDatiIngressoDaoException;

import java.util.List;

// TODO: Auto-generated Javadoc
/**
 * The Interface SiceeDDatiIngressoDao.
 */
public interface SiceeDDatiIngressoDao
{
	
	/**
	 * Method 'insert'.
	 *
	 * @param dto the dto
	 * @return SiceeDDatiIngressoPk
	 */
	public SiceeDDatiIngressoPk insert(SiceeDDatiIngresso dto);

	/**
	 * Updates a single row in the SICEE_D_DATI_INGRESSO table.
	 *
	 * @param pk the pk
	 * @param dto the dto
	 * @throws SiceeDDatiIngressoDaoException the sicee d dati ingresso dao exception
	 */
	public void update(SiceeDDatiIngressoPk pk, SiceeDDatiIngresso dto) throws SiceeDDatiIngressoDaoException;

	/**
	 * Deletes a single row in the SICEE_D_DATI_INGRESSO table.
	 *
	 * @param pk the pk
	 * @throws SiceeDDatiIngressoDaoException the sicee d dati ingresso dao exception
	 */
	public void delete(SiceeDDatiIngressoPk pk) throws SiceeDDatiIngressoDaoException;

	/**
	 * Returns all rows from the SICEE_D_DATI_INGRESSO table that match the criteria 'ID_DATI = :idDati'.
	 *
	 * @param idDati the id dati
	 * @return the sicee d dati ingresso
	 * @throws SiceeDDatiIngressoDaoException the sicee d dati ingresso dao exception
	 */
	public SiceeDDatiIngresso findByPrimaryKey(Integer idDati) throws SiceeDDatiIngressoDaoException;

	/**
	 * Returns all rows from the SICEE_D_DATI_INGRESSO table that match the criteria ''.
	 *
	 * @return the list
	 * @throws SiceeDDatiIngressoDaoException the sicee d dati ingresso dao exception
	 */
	public List<SiceeDDatiIngresso> findAll() throws SiceeDDatiIngressoDaoException;

	/**
	 * Returns all rows from the SICEE_D_DATI_INGRESSO table that match the criteria 'ID_DATI = :idDati'.
	 *
	 * @param idDati the id dati
	 * @return the list
	 * @throws SiceeDDatiIngressoDaoException the sicee d dati ingresso dao exception
	 */
	public List<SiceeDDatiIngresso> findWhereIdDatiEquals(Integer idDati) throws SiceeDDatiIngressoDaoException;

	/**
	 * Returns all rows from the SICEE_D_DATI_INGRESSO table that match the criteria 'DESCR = :descr'.
	 *
	 * @param descr the descr
	 * @return the list
	 * @throws SiceeDDatiIngressoDaoException the sicee d dati ingresso dao exception
	 */
	public List<SiceeDDatiIngresso> findWhereDescrEquals(String descr) throws SiceeDDatiIngressoDaoException;

	/**
	 * Returns the rows from the SICEE_D_DATI_INGRESSO table that matches the specified primary-key value.
	 *
	 * @param pk the pk
	 * @return the sicee d dati ingresso
	 * @throws SiceeDDatiIngressoDaoException the sicee d dati ingresso dao exception
	 */
	public SiceeDDatiIngresso findByPrimaryKey(SiceeDDatiIngressoPk pk) throws SiceeDDatiIngressoDaoException;

}
