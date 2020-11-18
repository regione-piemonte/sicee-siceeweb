/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceeweb.business.dao.dao;

import it.csi.sicee.siceeweb.business.dao.dao.SiceeDServEner2015Dao;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeDServEner2015;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeDServEner2015Pk;
import it.csi.sicee.siceeweb.business.dao.exceptions.SiceeDServEner2015DaoException;
import java.util.List;

public interface SiceeDServEner2015Dao
{
	/**
	 * Method 'insert'
	 * 
	 * @param dto
	 * @return SiceeDServEner2015Pk
	 */
	public SiceeDServEner2015Pk insert(SiceeDServEner2015 dto);

	/** 
	 * Updates a single row in the SICEE_D_SERV_ENER_2015 table.
	 */
	public void update(SiceeDServEner2015Pk pk, SiceeDServEner2015 dto) throws SiceeDServEner2015DaoException;

	/** 
	 * Deletes a single row in the SICEE_D_SERV_ENER_2015 table.
	 */
	public void delete(SiceeDServEner2015Pk pk) throws SiceeDServEner2015DaoException;

	/** 
	 * Returns all rows from the SICEE_D_SERV_ENER_2015 table that match the criteria 'ID_SERV_ENER = :idServEner'.
	 */
	public SiceeDServEner2015 findByPrimaryKey(Integer idServEner) throws SiceeDServEner2015DaoException;

	/** 
	 * Returns all rows from the SICEE_D_SERV_ENER_2015 table that match the criteria ''.
	 */
	public List<SiceeDServEner2015> findAll() throws SiceeDServEner2015DaoException;

	/** 
	 * Returns all rows from the SICEE_D_SERV_ENER_2015 table that match the criteria 'ID_SERV_ENER = :idServEner'.
	 */
	public List<SiceeDServEner2015> findWhereIdServEnerEquals(Integer idServEner) throws SiceeDServEner2015DaoException;

	/** 
	 * Returns all rows from the SICEE_D_SERV_ENER_2015 table that match the criteria 'DESCR = :descr'.
	 */
	public List<SiceeDServEner2015> findWhereDescrEquals(String descr) throws SiceeDServEner2015DaoException;

	/** 
	 * Returns all rows from the SICEE_D_SERV_ENER_2015 table that match the criteria 'FLG_ATTIVO = :flgAttivo'.
	 */
	public List<SiceeDServEner2015> findWhereFlgAttivoEquals(Integer flgAttivo) throws SiceeDServEner2015DaoException;

	/** 
	 * Returns the rows from the SICEE_D_SERV_ENER_2015 table that matches the specified primary-key value.
	 */
	public SiceeDServEner2015 findByPrimaryKey(SiceeDServEner2015Pk pk) throws SiceeDServEner2015DaoException;

}
