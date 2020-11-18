/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceeweb.business.dao.dao;

import it.csi.sicee.siceeweb.business.dao.dao.SiceeDTipoImpianto2015Dao;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeDTipoImpianto2015;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeDTipoImpianto2015Pk;
import it.csi.sicee.siceeweb.business.dao.exceptions.SiceeDTipoImpianto2015DaoException;
import java.util.List;

public interface SiceeDTipoImpianto2015Dao
{
	/**
	 * Method 'insert'
	 * 
	 * @param dto
	 * @return SiceeDTipoImpianto2015Pk
	 */
	public SiceeDTipoImpianto2015Pk insert(SiceeDTipoImpianto2015 dto);

	/** 
	 * Updates a single row in the SICEE_D_TIPO_IMPIANTO_2015 table.
	 */
	public void update(SiceeDTipoImpianto2015Pk pk, SiceeDTipoImpianto2015 dto) throws SiceeDTipoImpianto2015DaoException;

	/** 
	 * Deletes a single row in the SICEE_D_TIPO_IMPIANTO_2015 table.
	 */
	public void delete(SiceeDTipoImpianto2015Pk pk) throws SiceeDTipoImpianto2015DaoException;

	/** 
	 * Returns all rows from the SICEE_D_TIPO_IMPIANTO_2015 table that match the criteria 'ID_TIPO_IMPIANTO = :idTipoImpianto'.
	 */
	public SiceeDTipoImpianto2015 findByPrimaryKey(Integer idTipoImpianto) throws SiceeDTipoImpianto2015DaoException;

	/** 
	 * Returns all rows from the SICEE_D_TIPO_IMPIANTO_2015 table that match the criteria ''.
	 */
	public List<SiceeDTipoImpianto2015> findAll() throws SiceeDTipoImpianto2015DaoException;

	/** 
	 * Returns all rows from the SICEE_D_TIPO_IMPIANTO_2015 table that match the criteria 'ID_TIPO_IMPIANTO = :idTipoImpianto'.
	 */
	public List<SiceeDTipoImpianto2015> findWhereIdTipoImpiantoEquals(Integer idTipoImpianto) throws SiceeDTipoImpianto2015DaoException;

	/** 
	 * Returns all rows from the SICEE_D_TIPO_IMPIANTO_2015 table that match the criteria 'DESCR = :descr'.
	 */
	public List<SiceeDTipoImpianto2015> findWhereDescrEquals(String descr) throws SiceeDTipoImpianto2015DaoException;

	/** 
	 * Returns the rows from the SICEE_D_TIPO_IMPIANTO_2015 table that matches the specified primary-key value.
	 */
	public SiceeDTipoImpianto2015 findByPrimaryKey(SiceeDTipoImpianto2015Pk pk) throws SiceeDTipoImpianto2015DaoException;

}
