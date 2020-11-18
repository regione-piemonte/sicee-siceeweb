/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceeweb.business.dao.dao;

import it.csi.sicee.siceeweb.business.dao.dto.SiceeWCertificatore;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeWCertificatorePk;
import it.csi.sicee.siceeweb.business.dao.exceptions.SiceeWCertificatoreDaoException;

import java.util.List;

// TODO: Auto-generated Javadoc
/**
 * The Interface SiceeWCertificatoreDao.
 */
public interface SiceeWCertificatoreDao
{
	
	/**
	 * Method 'insert'.
	 *
	 * @param dto the dto
	 * @return SiceeWCertificatorePk
	 */
	public SiceeWCertificatorePk insert(SiceeWCertificatore dto);

	/**
	 * Updates a single row in the SICEE_W_CERTIFICATORE table.
	 *
	 * @param pk the pk
	 * @param dto the dto
	 * @throws SiceeWCertificatoreDaoException the sicee w certificatore dao exception
	 */
	public void update(SiceeWCertificatorePk pk, SiceeWCertificatore dto) throws SiceeWCertificatoreDaoException;

	/**
	 * Deletes a single row in the SICEE_W_CERTIFICATORE table.
	 *
	 * @param pk the pk
	 * @throws SiceeWCertificatoreDaoException the sicee w certificatore dao exception
	 */
	public void delete(SiceeWCertificatorePk pk) throws SiceeWCertificatoreDaoException;

	/**
	 * Returns all rows from the SICEE_W_CERTIFICATORE table that match the criteria 'ID_CERTIFICATORE = :idCertificatore AND ANNO = :anno'.
	 *
	 * @param idCertificatore the id certificatore
	 * @param anno the anno
	 * @return the sicee w certificatore
	 * @throws SiceeWCertificatoreDaoException the sicee w certificatore dao exception
	 */
	public SiceeWCertificatore findByPrimaryKey(Integer idCertificatore, String anno) throws SiceeWCertificatoreDaoException;

	/**
	 * Returns all rows from the SICEE_W_CERTIFICATORE table that match the criteria ''.
	 *
	 * @return the list
	 * @throws SiceeWCertificatoreDaoException the sicee w certificatore dao exception
	 */
	public List<SiceeWCertificatore> findAll() throws SiceeWCertificatoreDaoException;

	/**
	 * Returns all rows from the SICEE_W_CERTIFICATORE table that match the criteria 'ID_CERTIFICATORE = :idCertificatore'.
	 *
	 * @param idCertificatore the id certificatore
	 * @return the list
	 * @throws SiceeWCertificatoreDaoException the sicee w certificatore dao exception
	 */
	public List<SiceeWCertificatore> findWhereIdCertificatoreEquals(Integer idCertificatore) throws SiceeWCertificatoreDaoException;

	/**
	 * Returns all rows from the SICEE_W_CERTIFICATORE table that match the criteria 'PROGR_CERTIFICATO = :progrCertificato'.
	 *
	 * @param progrCertificato the progr certificato
	 * @return the list
	 * @throws SiceeWCertificatoreDaoException the sicee w certificatore dao exception
	 */
	public List<SiceeWCertificatore> findWhereProgrCertificatoEquals(Integer progrCertificato) throws SiceeWCertificatoreDaoException;

	/**
	 * Returns all rows from the SICEE_W_CERTIFICATORE table that match the criteria 'ANNO = :anno'.
	 *
	 * @param anno the anno
	 * @return the list
	 * @throws SiceeWCertificatoreDaoException the sicee w certificatore dao exception
	 */
	public List<SiceeWCertificatore> findWhereAnnoEquals(String anno) throws SiceeWCertificatoreDaoException;

	/**
	 * Returns the rows from the SICEE_W_CERTIFICATORE table that matches the specified primary-key value.
	 *
	 * @param pk the pk
	 * @return the sicee w certificatore
	 * @throws SiceeWCertificatoreDaoException the sicee w certificatore dao exception
	 */
	public SiceeWCertificatore findByPrimaryKey(SiceeWCertificatorePk pk) throws SiceeWCertificatoreDaoException;

}
