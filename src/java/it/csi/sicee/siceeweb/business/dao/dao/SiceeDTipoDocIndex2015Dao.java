/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceeweb.business.dao.dao;

import it.csi.sicee.siceeweb.business.dao.dao.SiceeDTipoDocIndex2015Dao;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeDTipoDocIndex2015;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeDTipoDocIndex2015Pk;
import it.csi.sicee.siceeweb.business.dao.exceptions.SiceeDTipoDocIndex2015DaoException;
import java.util.List;

public interface SiceeDTipoDocIndex2015Dao
{
	/**
	 * Method 'insert'
	 * 
	 * @param dto
	 * @return SiceeDTipoDocIndex2015Pk
	 */
	public SiceeDTipoDocIndex2015Pk insert(SiceeDTipoDocIndex2015 dto);

	/** 
	 * Updates a single row in the SICEE_D_TIPO_DOC_INDEX_2015 table.
	 */
	public void update(SiceeDTipoDocIndex2015Pk pk, SiceeDTipoDocIndex2015 dto) throws SiceeDTipoDocIndex2015DaoException;

	/** 
	 * Deletes a single row in the SICEE_D_TIPO_DOC_INDEX_2015 table.
	 */
	public void delete(SiceeDTipoDocIndex2015Pk pk) throws SiceeDTipoDocIndex2015DaoException;

	/** 
	 * Returns all rows from the SICEE_D_TIPO_DOC_INDEX_2015 table that match the criteria 'ID_TIPO_DOC = :idTipoDoc'.
	 */
	public SiceeDTipoDocIndex2015 findByPrimaryKey(Integer idTipoDoc) throws SiceeDTipoDocIndex2015DaoException;

	/** 
	 * Returns all rows from the SICEE_D_TIPO_DOC_INDEX_2015 table that match the criteria ''.
	 */
	public List<SiceeDTipoDocIndex2015> findAll() throws SiceeDTipoDocIndex2015DaoException;

	/** 
	 * Returns all rows from the SICEE_D_TIPO_DOC_INDEX_2015 table that match the criteria 'ID_TIPO_DOC = :idTipoDoc'.
	 */
	public List<SiceeDTipoDocIndex2015> findWhereIdTipoDocEquals(Integer idTipoDoc) throws SiceeDTipoDocIndex2015DaoException;

	/** 
	 * Returns all rows from the SICEE_D_TIPO_DOC_INDEX_2015 table that match the criteria 'DESCR = :descr'.
	 */
	public List<SiceeDTipoDocIndex2015> findWhereDescrEquals(String descr) throws SiceeDTipoDocIndex2015DaoException;

	/** 
	 * Returns the rows from the SICEE_D_TIPO_DOC_INDEX_2015 table that matches the specified primary-key value.
	 */
	public SiceeDTipoDocIndex2015 findByPrimaryKey(SiceeDTipoDocIndex2015Pk pk) throws SiceeDTipoDocIndex2015DaoException;

}
