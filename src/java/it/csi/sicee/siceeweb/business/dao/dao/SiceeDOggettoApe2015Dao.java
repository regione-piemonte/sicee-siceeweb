/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceeweb.business.dao.dao;

import it.csi.sicee.siceeweb.business.dao.dao.SiceeDOggettoApe2015Dao;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeDOggettoApe2015;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeDOggettoApe2015Pk;
import it.csi.sicee.siceeweb.business.dao.exceptions.SiceeDOggettoApe2015DaoException;
import java.util.List;

public interface SiceeDOggettoApe2015Dao
{
	/**
	 * Method 'insert'
	 * 
	 * @param dto
	 * @return SiceeDOggettoApe2015Pk
	 */
	public SiceeDOggettoApe2015Pk insert(SiceeDOggettoApe2015 dto);

	/** 
	 * Updates a single row in the SICEE_D_OGGETTO_APE_2015 table.
	 */
	public void update(SiceeDOggettoApe2015Pk pk, SiceeDOggettoApe2015 dto) throws SiceeDOggettoApe2015DaoException;

	/** 
	 * Deletes a single row in the SICEE_D_OGGETTO_APE_2015 table.
	 */
	public void delete(SiceeDOggettoApe2015Pk pk) throws SiceeDOggettoApe2015DaoException;

	/** 
	 * Returns all rows from the SICEE_D_OGGETTO_APE_2015 table that match the criteria 'ID_OGGETTO_APE = :idOggettoApe'.
	 */
	public SiceeDOggettoApe2015 findByPrimaryKey(long idOggettoApe) throws SiceeDOggettoApe2015DaoException;

	/** 
	 * Returns all rows from the SICEE_D_OGGETTO_APE_2015 table that match the criteria ''.
	 */
	public List<SiceeDOggettoApe2015> findAll() throws SiceeDOggettoApe2015DaoException;

	/** 
	 * Returns all rows from the SICEE_D_OGGETTO_APE_2015 table that match the criteria 'ID_OGGETTO_APE = :idOggettoApe'.
	 */
	public List<SiceeDOggettoApe2015> findWhereIdOggettoApeEquals(long idOggettoApe) throws SiceeDOggettoApe2015DaoException;

	/** 
	 * Returns all rows from the SICEE_D_OGGETTO_APE_2015 table that match the criteria 'DESCR = :descr'.
	 */
	public List<SiceeDOggettoApe2015> findWhereDescrEquals(String descr) throws SiceeDOggettoApe2015DaoException;

	/** 
	 * Returns the rows from the SICEE_D_OGGETTO_APE_2015 table that matches the specified primary-key value.
	 */
	public SiceeDOggettoApe2015 findByPrimaryKey(SiceeDOggettoApe2015Pk pk) throws SiceeDOggettoApe2015DaoException;

}
