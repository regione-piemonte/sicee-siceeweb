/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceeweb.business.dao.dao;

import it.csi.sicee.siceeweb.business.dao.dao.SiceeDTipoRistrutt2015Dao;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeDTipoRistrutt2015;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeDTipoRistrutt2015Pk;
import it.csi.sicee.siceeweb.business.dao.exceptions.SiceeDTipoRistrutt2015DaoException;
import java.util.List;

public interface SiceeDTipoRistrutt2015Dao
{
	/**
	 * Method 'insert'
	 * 
	 * @param dto
	 * @return SiceeDTipoRistrutt2015Pk
	 */
	public SiceeDTipoRistrutt2015Pk insert(SiceeDTipoRistrutt2015 dto);

	/** 
	 * Updates a single row in the SICEE_D_TIPO_RISTRUTT_2015 table.
	 */
	public void update(SiceeDTipoRistrutt2015Pk pk, SiceeDTipoRistrutt2015 dto) throws SiceeDTipoRistrutt2015DaoException;

	/** 
	 * Deletes a single row in the SICEE_D_TIPO_RISTRUTT_2015 table.
	 */
	public void delete(SiceeDTipoRistrutt2015Pk pk) throws SiceeDTipoRistrutt2015DaoException;

	/** 
	 * Returns all rows from the SICEE_D_TIPO_RISTRUTT_2015 table that match the criteria 'ID_TIPO_RISTRUTTURAZ = :idTipoRistrutturaz'.
	 */
	public SiceeDTipoRistrutt2015 findByPrimaryKey(Integer idTipoRistrutturaz) throws SiceeDTipoRistrutt2015DaoException;

	/** 
	 * Returns all rows from the SICEE_D_TIPO_RISTRUTT_2015 table that match the criteria ''.
	 */
	public List<SiceeDTipoRistrutt2015> findAll() throws SiceeDTipoRistrutt2015DaoException;

	/** 
	 * Returns all rows from the SICEE_D_TIPO_RISTRUTT_2015 table that match the criteria 'ID_TIPO_RISTRUTTURAZ = :idTipoRistrutturaz'.
	 */
	public List<SiceeDTipoRistrutt2015> findWhereIdTipoRistrutturazEquals(Integer idTipoRistrutturaz) throws SiceeDTipoRistrutt2015DaoException;

	/** 
	 * Returns all rows from the SICEE_D_TIPO_RISTRUTT_2015 table that match the criteria 'DESCR = :descr'.
	 */
	public List<SiceeDTipoRistrutt2015> findWhereDescrEquals(String descr) throws SiceeDTipoRistrutt2015DaoException;

	/** 
	 * Returns the rows from the SICEE_D_TIPO_RISTRUTT_2015 table that matches the specified primary-key value.
	 */
	public SiceeDTipoRistrutt2015 findByPrimaryKey(SiceeDTipoRistrutt2015Pk pk) throws SiceeDTipoRistrutt2015DaoException;

}
