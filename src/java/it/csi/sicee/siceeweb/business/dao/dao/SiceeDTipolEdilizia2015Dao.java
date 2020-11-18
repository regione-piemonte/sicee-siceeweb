/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceeweb.business.dao.dao;

import it.csi.sicee.siceeweb.business.dao.dao.SiceeDTipolEdilizia2015Dao;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeDTipolEdilizia2015;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeDTipolEdilizia2015Pk;
import it.csi.sicee.siceeweb.business.dao.exceptions.SiceeDTipolEdilizia2015DaoException;
import java.util.List;

public interface SiceeDTipolEdilizia2015Dao
{
	/**
	 * Method 'insert'
	 * 
	 * @param dto
	 * @return SiceeDTipolEdilizia2015Pk
	 */
	public SiceeDTipolEdilizia2015Pk insert(SiceeDTipolEdilizia2015 dto);

	/** 
	 * Updates a single row in the SICEE_D_TIPOL_EDILIZIA_2015 table.
	 */
	public void update(SiceeDTipolEdilizia2015Pk pk, SiceeDTipolEdilizia2015 dto) throws SiceeDTipolEdilizia2015DaoException;

	/** 
	 * Deletes a single row in the SICEE_D_TIPOL_EDILIZIA_2015 table.
	 */
	public void delete(SiceeDTipolEdilizia2015Pk pk) throws SiceeDTipolEdilizia2015DaoException;

	/** 
	 * Returns all rows from the SICEE_D_TIPOL_EDILIZIA_2015 table that match the criteria 'ID_TIPOL_EDILIZIA = :idTipolEdilizia'.
	 */
	public SiceeDTipolEdilizia2015 findByPrimaryKey(Integer idTipolEdilizia) throws SiceeDTipolEdilizia2015DaoException;

	/** 
	 * Returns all rows from the SICEE_D_TIPOL_EDILIZIA_2015 table that match the criteria ''.
	 */
	public List<SiceeDTipolEdilizia2015> findAll() throws SiceeDTipolEdilizia2015DaoException;

	/** 
	 * Returns all rows from the SICEE_D_TIPOL_EDILIZIA_2015 table that match the criteria 'ID_TIPOL_EDILIZIA = :idTipolEdilizia'.
	 */
	public List<SiceeDTipolEdilizia2015> findWhereIdTipolEdiliziaEquals(Integer idTipolEdilizia) throws SiceeDTipolEdilizia2015DaoException;

	/** 
	 * Returns all rows from the SICEE_D_TIPOL_EDILIZIA_2015 table that match the criteria 'DESCR = :descr'.
	 */
	public List<SiceeDTipolEdilizia2015> findWhereDescrEquals(String descr) throws SiceeDTipolEdilizia2015DaoException;

	/** 
	 * Returns the rows from the SICEE_D_TIPOL_EDILIZIA_2015 table that matches the specified primary-key value.
	 */
	public SiceeDTipolEdilizia2015 findByPrimaryKey(SiceeDTipolEdilizia2015Pk pk) throws SiceeDTipolEdilizia2015DaoException;

}
