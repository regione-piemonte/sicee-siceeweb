/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceeweb.business.dao.dao;

import it.csi.sicee.siceeweb.business.dao.dao.SiceeDZonaClimatica2015Dao;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeDZonaClimatica2015;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeDZonaClimatica2015Pk;
import it.csi.sicee.siceeweb.business.dao.exceptions.SiceeDZonaClimatica2015DaoException;
import java.util.List;

public interface SiceeDZonaClimatica2015Dao
{
	/**
	 * Method 'insert'
	 * 
	 * @param dto
	 * @return SiceeDZonaClimatica2015Pk
	 */
	public SiceeDZonaClimatica2015Pk insert(SiceeDZonaClimatica2015 dto);

	/** 
	 * Updates a single row in the SICEE_D_ZONA_CLIMATICA_2015 table.
	 */
	public void update(SiceeDZonaClimatica2015Pk pk, SiceeDZonaClimatica2015 dto) throws SiceeDZonaClimatica2015DaoException;

	/** 
	 * Deletes a single row in the SICEE_D_ZONA_CLIMATICA_2015 table.
	 */
	public void delete(SiceeDZonaClimatica2015Pk pk) throws SiceeDZonaClimatica2015DaoException;

	/** 
	 * Returns all rows from the SICEE_D_ZONA_CLIMATICA_2015 table that match the criteria 'COD_ZONA = :codZona'.
	 */
	public SiceeDZonaClimatica2015 findByPrimaryKey(String codZona) throws SiceeDZonaClimatica2015DaoException;

	/** 
	 * Returns all rows from the SICEE_D_ZONA_CLIMATICA_2015 table that match the criteria ''.
	 */
	public List<SiceeDZonaClimatica2015> findAll() throws SiceeDZonaClimatica2015DaoException;

	/** 
	 * Returns all rows from the SICEE_D_ZONA_CLIMATICA_2015 table that match the criteria 'COD_ZONA = :codZona'.
	 */
	public List<SiceeDZonaClimatica2015> findWhereCodZonaEquals(String codZona) throws SiceeDZonaClimatica2015DaoException;

	/** 
	 * Returns the rows from the SICEE_D_ZONA_CLIMATICA_2015 table that matches the specified primary-key value.
	 */
	public SiceeDZonaClimatica2015 findByPrimaryKey(SiceeDZonaClimatica2015Pk pk) throws SiceeDZonaClimatica2015DaoException;

}
