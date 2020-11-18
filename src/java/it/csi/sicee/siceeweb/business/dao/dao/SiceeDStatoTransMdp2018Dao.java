/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceeweb.business.dao.dao;

import it.csi.sicee.siceeweb.business.dao.dao.SiceeDStatoTransMdp2018Dao;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeDStatoTransMdp2018;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeDStatoTransMdp2018Pk;
import it.csi.sicee.siceeweb.business.dao.exceptions.SiceeDStatoTransMdp2018DaoException;
import java.util.List;

public interface SiceeDStatoTransMdp2018Dao
{
	/**
	 * Method 'insert'
	 * 
	 * @param dto
	 * @return SiceeDStatoTransMdp2018Pk
	 */
	public SiceeDStatoTransMdp2018Pk insert(SiceeDStatoTransMdp2018 dto);

	/** 
	 * Updates a single row in the SICEE_D_STATO_TRANS_MDP_2018 table.
	 */
	public void update(SiceeDStatoTransMdp2018Pk pk, SiceeDStatoTransMdp2018 dto) throws SiceeDStatoTransMdp2018DaoException;

	/** 
	 * Deletes a single row in the SICEE_D_STATO_TRANS_MDP_2018 table.
	 */
	public void delete(SiceeDStatoTransMdp2018Pk pk) throws SiceeDStatoTransMdp2018DaoException;

	/** 
	 * Returns all rows from the SICEE_D_STATO_TRANS_MDP_2018 table that match the criteria 'ID_STATO_TRANS_MDP_2018 = :idStatoTransMdp2018'.
	 */
	public SiceeDStatoTransMdp2018 findByPrimaryKey(Integer idStatoTransMdp2018) throws SiceeDStatoTransMdp2018DaoException;

	/** 
	 * Returns all rows from the SICEE_D_STATO_TRANS_MDP_2018 table that match the criteria ''.
	 */
	public List<SiceeDStatoTransMdp2018> findAll() throws SiceeDStatoTransMdp2018DaoException;

	/** 
	 * Returns all rows from the SICEE_D_STATO_TRANS_MDP_2018 table that match the criteria 'ID_STATO_TRANS_MDP_2018 = :idStatoTransMdp2018'.
	 */
	public List<SiceeDStatoTransMdp2018> findWhereIdStatoTransMdp2018Equals(Integer idStatoTransMdp2018) throws SiceeDStatoTransMdp2018DaoException;

	/** 
	 * Returns all rows from the SICEE_D_STATO_TRANS_MDP_2018 table that match the criteria 'DESCR_STATO_TRANS_MDP = :descrStatoTransMdp'.
	 */
	public List<SiceeDStatoTransMdp2018> findWhereDescrStatoTransMdpEquals(String descrStatoTransMdp) throws SiceeDStatoTransMdp2018DaoException;

	/** 
	 * Returns the rows from the SICEE_D_STATO_TRANS_MDP_2018 table that matches the specified primary-key value.
	 */
	public SiceeDStatoTransMdp2018 findByPrimaryKey(SiceeDStatoTransMdp2018Pk pk) throws SiceeDStatoTransMdp2018DaoException;

}
