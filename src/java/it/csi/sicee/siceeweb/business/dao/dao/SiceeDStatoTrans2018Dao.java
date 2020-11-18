/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceeweb.business.dao.dao;

import it.csi.sicee.siceeweb.business.dao.dao.SiceeDStatoTrans2018Dao;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeDStatoTrans2018;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeDStatoTrans2018Pk;
import it.csi.sicee.siceeweb.business.dao.exceptions.SiceeDStatoTrans2018DaoException;
import java.util.List;

public interface SiceeDStatoTrans2018Dao
{
	/**
	 * Method 'insert'
	 * 
	 * @param dto
	 * @return SiceeDStatoTrans2018Pk
	 */
	public SiceeDStatoTrans2018Pk insert(SiceeDStatoTrans2018 dto);

	/** 
	 * Updates a single row in the SICEE_D_STATO_TRANS_2018 table.
	 */
	public void update(SiceeDStatoTrans2018Pk pk, SiceeDStatoTrans2018 dto) throws SiceeDStatoTrans2018DaoException;

	/** 
	 * Deletes a single row in the SICEE_D_STATO_TRANS_2018 table.
	 */
	public void delete(SiceeDStatoTrans2018Pk pk) throws SiceeDStatoTrans2018DaoException;

	/** 
	 * Returns all rows from the SICEE_D_STATO_TRANS_2018 table that match the criteria 'ID_STATO_TRANS_2018 = :idStatoTrans2018'.
	 */
	public SiceeDStatoTrans2018 findByPrimaryKey(Integer idStatoTrans2018) throws SiceeDStatoTrans2018DaoException;

	/** 
	 * Returns all rows from the SICEE_D_STATO_TRANS_2018 table that match the criteria ''.
	 */
	public List<SiceeDStatoTrans2018> findAll() throws SiceeDStatoTrans2018DaoException;

	/** 
	 * Returns all rows from the SICEE_D_STATO_TRANS_2018 table that match the criteria 'ID_STATO_TRANS_2018 = :idStatoTrans2018'.
	 */
	public List<SiceeDStatoTrans2018> findWhereIdStatoTrans2018Equals(Integer idStatoTrans2018) throws SiceeDStatoTrans2018DaoException;

	/** 
	 * Returns all rows from the SICEE_D_STATO_TRANS_2018 table that match the criteria 'DESCR_STATO_TRANS = :descrStatoTrans'.
	 */
	public List<SiceeDStatoTrans2018> findWhereDescrStatoTransEquals(String descrStatoTrans) throws SiceeDStatoTrans2018DaoException;

	/** 
	 * Returns the rows from the SICEE_D_STATO_TRANS_2018 table that matches the specified primary-key value.
	 */
	public SiceeDStatoTrans2018 findByPrimaryKey(SiceeDStatoTrans2018Pk pk) throws SiceeDStatoTrans2018DaoException;

}
