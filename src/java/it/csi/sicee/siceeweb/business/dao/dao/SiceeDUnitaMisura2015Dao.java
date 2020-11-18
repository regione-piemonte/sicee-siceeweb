/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceeweb.business.dao.dao;

import it.csi.sicee.siceeweb.business.dao.dao.SiceeDUnitaMisura2015Dao;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeDUnitaMisura2015;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeDUnitaMisura2015Pk;
import it.csi.sicee.siceeweb.business.dao.exceptions.SiceeDUnitaMisura2015DaoException;
import java.util.List;

public interface SiceeDUnitaMisura2015Dao
{
	/**
	 * Method 'insert'
	 * 
	 * @param dto
	 * @return SiceeDUnitaMisura2015Pk
	 */
	public SiceeDUnitaMisura2015Pk insert(SiceeDUnitaMisura2015 dto);

	/** 
	 * Updates a single row in the SICEE_D_UNITA_MISURA_2015 table.
	 */
	public void update(SiceeDUnitaMisura2015Pk pk, SiceeDUnitaMisura2015 dto) throws SiceeDUnitaMisura2015DaoException;

	/** 
	 * Deletes a single row in the SICEE_D_UNITA_MISURA_2015 table.
	 */
	public void delete(SiceeDUnitaMisura2015Pk pk) throws SiceeDUnitaMisura2015DaoException;

	/** 
	 * Returns all rows from the SICEE_D_UNITA_MISURA_2015 table that match the criteria 'ID_UNITA_MISURA = :idUnitaMisura'.
	 */
	public SiceeDUnitaMisura2015 findByPrimaryKey(Integer idUnitaMisura) throws SiceeDUnitaMisura2015DaoException;

	/** 
	 * Returns all rows from the SICEE_D_UNITA_MISURA_2015 table that match the criteria ''.
	 */
	public List<SiceeDUnitaMisura2015> findAll() throws SiceeDUnitaMisura2015DaoException;

	/** 
	 * Returns all rows from the SICEE_D_UNITA_MISURA_2015 table that match the criteria 'ID_UNITA_MISURA = :idUnitaMisura'.
	 */
	public List<SiceeDUnitaMisura2015> findWhereIdUnitaMisuraEquals(Integer idUnitaMisura) throws SiceeDUnitaMisura2015DaoException;

	/** 
	 * Returns all rows from the SICEE_D_UNITA_MISURA_2015 table that match the criteria 'DESCR = :descr'.
	 */
	public List<SiceeDUnitaMisura2015> findWhereDescrEquals(String descr) throws SiceeDUnitaMisura2015DaoException;

	/** 
	 * Returns the rows from the SICEE_D_UNITA_MISURA_2015 table that matches the specified primary-key value.
	 */
	public SiceeDUnitaMisura2015 findByPrimaryKey(SiceeDUnitaMisura2015Pk pk) throws SiceeDUnitaMisura2015DaoException;

}
