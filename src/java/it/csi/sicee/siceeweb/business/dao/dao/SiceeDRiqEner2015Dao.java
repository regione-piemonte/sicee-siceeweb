/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceeweb.business.dao.dao;

import it.csi.sicee.siceeweb.business.dao.dao.SiceeDRiqEner2015Dao;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeDRiqEner2015;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeDRiqEner2015Pk;
import it.csi.sicee.siceeweb.business.dao.exceptions.SiceeDRiqEner2015DaoException;

import java.util.List;

public interface SiceeDRiqEner2015Dao
{
	/**
	 * Method 'insert'
	 * 
	 * @param dto
	 * @return SiceeDRiqEner2015Pk
	 */
	public SiceeDRiqEner2015Pk insert(SiceeDRiqEner2015 dto);

	/** 
	 * Updates a single row in the SICEE_D_RIQ_ENER_2015 table.
	 */
	public void update(SiceeDRiqEner2015Pk pk, SiceeDRiqEner2015 dto) throws SiceeDRiqEner2015DaoException;

	/** 
	 * Deletes a single row in the SICEE_D_RIQ_ENER_2015 table.
	 */
	public void delete(SiceeDRiqEner2015Pk pk) throws SiceeDRiqEner2015DaoException;

	/** 
	 * Returns all rows from the SICEE_D_RIQ_ENER_2015 table that match the criteria 'CODICE_REN = :codiceRen'.
	 */
	public SiceeDRiqEner2015 findByPrimaryKey(String codiceRen) throws SiceeDRiqEner2015DaoException;

	/** 
	 * Returns all rows from the SICEE_D_RIQ_ENER_2015 table that match the criteria ''.
	 */
	public List<SiceeDRiqEner2015> findAll() throws SiceeDRiqEner2015DaoException;

	/** 
	 * Returns all rows from the SICEE_D_RIQ_ENER_2015 table that match the criteria 'CODICE_REN = :codiceRen'.
	 */
	public List<SiceeDRiqEner2015> findWhereCodiceRenEquals(String codiceRen) throws SiceeDRiqEner2015DaoException;

	/** 
	 * Returns all rows from the SICEE_D_RIQ_ENER_2015 table that match the criteria 'DESCR = :descr'.
	 */
	public List<SiceeDRiqEner2015> findWhereDescrEquals(String descr) throws SiceeDRiqEner2015DaoException;

	/** 
	 * Returns the rows from the SICEE_D_RIQ_ENER_2015 table that matches the specified primary-key value.
	 */
	public SiceeDRiqEner2015 findByPrimaryKey(SiceeDRiqEner2015Pk pk) throws SiceeDRiqEner2015DaoException;

	/** 
	 * Returns all rows from the SICEE_D_RIQ_ENER_2015 table that match the criteria 'ID = :id'.
	 */
	
	public List<SiceeDRiqEner2015> findWhereIdXmlEquals(Integer idXml) throws SiceeDRiqEner2015DaoException;
	
}
