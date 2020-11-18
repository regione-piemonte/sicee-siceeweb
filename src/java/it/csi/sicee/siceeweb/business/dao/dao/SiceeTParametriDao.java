/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceeweb.business.dao.dao;

import it.csi.sicee.siceeweb.business.dao.dao.SiceeTParametriDao;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeTParametri;
import it.csi.sicee.siceeweb.business.dao.exceptions.SiceeTParametriDaoException;
import java.util.List;

// TODO: Auto-generated Javadoc
/**
 * The Interface SiceeTParametriDao.
 */
public interface SiceeTParametriDao
{
	
	/**
	 * Method 'insert'.
	 *
	 * @param dto the dto
	 */
	public void insert(SiceeTParametri dto);

	/**
	 * Returns all rows from the SICEE_T_PARAMETRI table that match the criteria ''.
	 *
	 * @return the list
	 * @throws SiceeTParametriDaoException the sicee t parametri dao exception
	 */
	public List<SiceeTParametri> findAll() throws SiceeTParametriDaoException;

	/**
	 * Returns all rows from the SICEE_T_PARAMETRI table that match the criteria 'CODICE = :codice'.
	 *
	 * @param codice the codice
	 * @return the sicee t parametri
	 * @throws SiceeTParametriDaoException the sicee t parametri dao exception
	 */
	public SiceeTParametri findWhereCodiceEquals(String codice) throws SiceeTParametriDaoException;

	/**
	 * Returns all rows from the SICEE_T_PARAMETRI table that match the criteria 'VALORE = :valore'.
	 *
	 * @param valore the valore
	 * @return the list
	 * @throws SiceeTParametriDaoException the sicee t parametri dao exception
	 */
	public List<SiceeTParametri> findWhereValoreEquals(String valore) throws SiceeTParametriDaoException;

}
