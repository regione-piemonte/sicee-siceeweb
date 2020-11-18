/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceeweb.business.dao.dao;

import it.csi.sicee.siceeweb.business.dao.dao.SiceeDTipoOp2018Dao;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeDTipoOp2018;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeDTipoOp2018Pk;
import it.csi.sicee.siceeweb.business.dao.exceptions.SiceeDTipoOp2018DaoException;
import java.util.List;

public interface SiceeDTipoOp2018Dao
{
	/**
	 * Method 'insert'
	 * 
	 * @param dto
	 * @return SiceeDTipoOp2018Pk
	 */
	public SiceeDTipoOp2018Pk insert(SiceeDTipoOp2018 dto);

	/** 
	 * Updates a single row in the SICEE_D_TIPO_OP_2018 table.
	 */
	public void update(SiceeDTipoOp2018Pk pk, SiceeDTipoOp2018 dto) throws SiceeDTipoOp2018DaoException;

	/** 
	 * Deletes a single row in the SICEE_D_TIPO_OP_2018 table.
	 */
	public void delete(SiceeDTipoOp2018Pk pk) throws SiceeDTipoOp2018DaoException;

	/** 
	 * Returns all rows from the SICEE_D_TIPO_OP_2018 table that match the criteria 'ID_TIPO_OP_2018 = :idTipoOp2018'.
	 */
	public SiceeDTipoOp2018 findByPrimaryKey(Integer idTipoOp2018) throws SiceeDTipoOp2018DaoException;

	/** 
	 * Returns all rows from the SICEE_D_TIPO_OP_2018 table that match the criteria ''.
	 */
	public List<SiceeDTipoOp2018> findAll() throws SiceeDTipoOp2018DaoException;

	/** 
	 * Returns all rows from the SICEE_D_TIPO_OP_2018 table that match the criteria 'ID_TIPO_OP_2018 = :idTipoOp2018'.
	 */
	public List<SiceeDTipoOp2018> findWhereIdTipoOp2018Equals(Integer idTipoOp2018) throws SiceeDTipoOp2018DaoException;

	/** 
	 * Returns all rows from the SICEE_D_TIPO_OP_2018 table that match the criteria 'DESCR_TIPO_OP_2018 = :descrTipoOp2018'.
	 */
	public List<SiceeDTipoOp2018> findWhereDescrTipoOp2018Equals(String descrTipoOp2018) throws SiceeDTipoOp2018DaoException;

	/** 
	 * Returns the rows from the SICEE_D_TIPO_OP_2018 table that matches the specified primary-key value.
	 */
	public SiceeDTipoOp2018 findByPrimaryKey(SiceeDTipoOp2018Pk pk) throws SiceeDTipoOp2018DaoException;

}
