/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceeweb.business.dao.dao;

import it.csi.sicee.siceeweb.business.dao.dao.SiceeDTipolCostrutt2015Dao;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeDTipolCostrutt2015;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeDTipolCostrutt2015Pk;
import it.csi.sicee.siceeweb.business.dao.exceptions.SiceeDTipolCostrutt2015DaoException;
import java.util.List;

public interface SiceeDTipolCostrutt2015Dao
{
	/**
	 * Method 'insert'
	 * 
	 * @param dto
	 * @return SiceeDTipolCostrutt2015Pk
	 */
	public SiceeDTipolCostrutt2015Pk insert(SiceeDTipolCostrutt2015 dto);

	/** 
	 * Updates a single row in the SICEE_D_TIPOL_COSTRUTT_2015 table.
	 */
	public void update(SiceeDTipolCostrutt2015Pk pk, SiceeDTipolCostrutt2015 dto) throws SiceeDTipolCostrutt2015DaoException;

	/** 
	 * Deletes a single row in the SICEE_D_TIPOL_COSTRUTT_2015 table.
	 */
	public void delete(SiceeDTipolCostrutt2015Pk pk) throws SiceeDTipolCostrutt2015DaoException;

	/** 
	 * Returns all rows from the SICEE_D_TIPOL_COSTRUTT_2015 table that match the criteria 'ID_TIPOL_COSTRUTT = :idTipolCostrutt'.
	 */
	public SiceeDTipolCostrutt2015 findByPrimaryKey(Integer idTipolCostrutt) throws SiceeDTipolCostrutt2015DaoException;

	/** 
	 * Returns all rows from the SICEE_D_TIPOL_COSTRUTT_2015 table that match the criteria ''.
	 */
	public List<SiceeDTipolCostrutt2015> findAll() throws SiceeDTipolCostrutt2015DaoException;

	/** 
	 * Returns all rows from the SICEE_D_TIPOL_COSTRUTT_2015 table that match the criteria 'ID_TIPOL_COSTRUTT = :idTipolCostrutt'.
	 */
	public List<SiceeDTipolCostrutt2015> findWhereIdTipolCostruttEquals(Integer idTipolCostrutt) throws SiceeDTipolCostrutt2015DaoException;

	/** 
	 * Returns all rows from the SICEE_D_TIPOL_COSTRUTT_2015 table that match the criteria 'DESCR = :descr'.
	 */
	public List<SiceeDTipolCostrutt2015> findWhereDescrEquals(String descr) throws SiceeDTipolCostrutt2015DaoException;

	/** 
	 * Returns the rows from the SICEE_D_TIPOL_COSTRUTT_2015 table that matches the specified primary-key value.
	 */
	public SiceeDTipolCostrutt2015 findByPrimaryKey(SiceeDTipolCostrutt2015Pk pk) throws SiceeDTipolCostrutt2015DaoException;

}
