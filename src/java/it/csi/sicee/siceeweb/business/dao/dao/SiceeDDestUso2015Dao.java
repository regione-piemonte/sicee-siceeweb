/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceeweb.business.dao.dao;

import it.csi.sicee.siceeweb.business.dao.dao.SiceeDDestUso2015Dao;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeDDestUso2015;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeDDestUso2015Pk;
import it.csi.sicee.siceeweb.business.dao.exceptions.SiceeDDestUso2015DaoException;
import java.util.List;

public interface SiceeDDestUso2015Dao
{
	/**
	 * Method 'insert'
	 * 
	 * @param dto
	 * @return SiceeDDestUso2015Pk
	 */
	public SiceeDDestUso2015Pk insert(SiceeDDestUso2015 dto);

	/** 
	 * Updates a single row in the SICEE_D_DEST_USO_2015 table.
	 */
	public void update(SiceeDDestUso2015Pk pk, SiceeDDestUso2015 dto) throws SiceeDDestUso2015DaoException;

	/** 
	 * Deletes a single row in the SICEE_D_DEST_USO_2015 table.
	 */
	public void delete(SiceeDDestUso2015Pk pk) throws SiceeDDestUso2015DaoException;

	/** 
	 * Returns all rows from the SICEE_D_DEST_USO_2015 table that match the criteria 'ID_DEST_USO_2015 = :idDestUso2015'.
	 */
	public SiceeDDestUso2015 findByPrimaryKey(Integer idDestUso2015) throws SiceeDDestUso2015DaoException;

	/** 
	 * Returns all rows from the SICEE_D_DEST_USO_2015 table that match the criteria ''.
	 */
	public List<SiceeDDestUso2015> findAll() throws SiceeDDestUso2015DaoException;

	/** 
	 * Returns all rows from the SICEE_D_DEST_USO_2015 table that match the criteria 'ID_DEST_USO_2015 = :idDestUso2015'.
	 */
	public List<SiceeDDestUso2015> findWhereIdDestUso2015Equals(Integer idDestUso2015) throws SiceeDDestUso2015DaoException;

	/** 
	 * Returns all rows from the SICEE_D_DEST_USO_2015 table that match the criteria 'SIGLA = :sigla'.
	 */
	public List<SiceeDDestUso2015> findWhereSiglaEquals(String sigla) throws SiceeDDestUso2015DaoException;

	/** 
	 * Returns all rows from the SICEE_D_DEST_USO_2015 table that match the criteria 'DESCR = :descr'.
	 */
	public List<SiceeDDestUso2015> findWhereDescrEquals(String descr) throws SiceeDDestUso2015DaoException;

	/** 
	 * Returns all rows from the SICEE_D_DEST_USO_2015 table that match the criteria 'FLG_RESIDENZIALE = :flgResidenziale'.
	 */
	public List<SiceeDDestUso2015> findWhereFlgResidenzialeEquals(String flgResidenziale) throws SiceeDDestUso2015DaoException;

	/** 
	 * Returns all rows from the SICEE_D_DEST_USO_2015 table that match the criteria 'FLG_ATTIVO = :flgAttivo'.
	 */
	public List<SiceeDDestUso2015> findWhereFlgAttivoEquals(Integer flgAttivo) throws SiceeDDestUso2015DaoException;

	/** 
	 * Returns the rows from the SICEE_D_DEST_USO_2015 table that matches the specified primary-key value.
	 */
	public SiceeDDestUso2015 findByPrimaryKey(SiceeDDestUso2015Pk pk) throws SiceeDDestUso2015DaoException;

}
