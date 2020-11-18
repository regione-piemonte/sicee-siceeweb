/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceeweb.business.dao.dao;

import it.csi.sicee.siceeweb.business.dao.dao.SiceeDTipoFoto2015Dao;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeDTipoFoto2015;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeDTipoFoto2015Pk;
import it.csi.sicee.siceeweb.business.dao.exceptions.SiceeDTipoFoto2015DaoException;
import java.util.List;

public interface SiceeDTipoFoto2015Dao
{
	/**
	 * Method 'insert'
	 * 
	 * @param dto
	 * @return SiceeDTipoFoto2015Pk
	 */
	public SiceeDTipoFoto2015Pk insert(SiceeDTipoFoto2015 dto);

	/** 
	 * Updates a single row in the SICEE_D_TIPO_FOTO_2015 table.
	 */
	public void update(SiceeDTipoFoto2015Pk pk, SiceeDTipoFoto2015 dto) throws SiceeDTipoFoto2015DaoException;

	/** 
	 * Deletes a single row in the SICEE_D_TIPO_FOTO_2015 table.
	 */
	public void delete(SiceeDTipoFoto2015Pk pk) throws SiceeDTipoFoto2015DaoException;

	/** 
	 * Returns all rows from the SICEE_D_TIPO_FOTO_2015 table that match the criteria 'ID_TIPO_FOTO = :idTipoFoto'.
	 */
	public SiceeDTipoFoto2015 findByPrimaryKey(long idTipoFoto) throws SiceeDTipoFoto2015DaoException;

	/** 
	 * Returns all rows from the SICEE_D_TIPO_FOTO_2015 table that match the criteria ''.
	 */
	public List<SiceeDTipoFoto2015> findAll() throws SiceeDTipoFoto2015DaoException;

	/** 
	 * Returns all rows from the SICEE_D_TIPO_FOTO_2015 table that match the criteria 'ID_TIPO_FOTO = :idTipoFoto'.
	 */
	public List<SiceeDTipoFoto2015> findWhereIdTipoFotoEquals(long idTipoFoto) throws SiceeDTipoFoto2015DaoException;

	/** 
	 * Returns all rows from the SICEE_D_TIPO_FOTO_2015 table that match the criteria 'DESCR = :descr'.
	 */
	public List<SiceeDTipoFoto2015> findWhereDescrEquals(String descr) throws SiceeDTipoFoto2015DaoException;

	/** 
	 * Returns the rows from the SICEE_D_TIPO_FOTO_2015 table that matches the specified primary-key value.
	 */
	public SiceeDTipoFoto2015 findByPrimaryKey(SiceeDTipoFoto2015Pk pk) throws SiceeDTipoFoto2015DaoException;

}
