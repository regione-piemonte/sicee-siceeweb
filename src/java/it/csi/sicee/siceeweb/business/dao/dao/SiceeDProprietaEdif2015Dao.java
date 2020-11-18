/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceeweb.business.dao.dao;

import it.csi.sicee.siceeweb.business.dao.dao.SiceeDProprietaEdif2015Dao;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeDProprietaEdif2015;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeDProprietaEdif2015Pk;
import it.csi.sicee.siceeweb.business.dao.exceptions.SiceeDProprietaEdif2015DaoException;
import java.util.List;

public interface SiceeDProprietaEdif2015Dao
{
	/**
	 * Method 'insert'
	 * 
	 * @param dto
	 * @return SiceeDProprietaEdif2015Pk
	 */
	public SiceeDProprietaEdif2015Pk insert(SiceeDProprietaEdif2015 dto);

	/** 
	 * Updates a single row in the SICEE_D_PROPRIETA_EDIF_2015 table.
	 */
	public void update(SiceeDProprietaEdif2015Pk pk, SiceeDProprietaEdif2015 dto) throws SiceeDProprietaEdif2015DaoException;

	/** 
	 * Deletes a single row in the SICEE_D_PROPRIETA_EDIF_2015 table.
	 */
	public void delete(SiceeDProprietaEdif2015Pk pk) throws SiceeDProprietaEdif2015DaoException;

	/** 
	 * Returns all rows from the SICEE_D_PROPRIETA_EDIF_2015 table that match the criteria 'ID_PROPRIETA_EDI = :idProprietaEdi'.
	 */
	public SiceeDProprietaEdif2015 findByPrimaryKey(Integer idProprietaEdi) throws SiceeDProprietaEdif2015DaoException;

	/** 
	 * Returns all rows from the SICEE_D_PROPRIETA_EDIF_2015 table that match the criteria ''.
	 */
	public List<SiceeDProprietaEdif2015> findAll() throws SiceeDProprietaEdif2015DaoException;

	/** 
	 * Returns all rows from the SICEE_D_PROPRIETA_EDIF_2015 table that match the criteria 'ID_PROPRIETA_EDI = :idProprietaEdi'.
	 */
	public List<SiceeDProprietaEdif2015> findWhereIdProprietaEdiEquals(Integer idProprietaEdi) throws SiceeDProprietaEdif2015DaoException;

	/** 
	 * Returns all rows from the SICEE_D_PROPRIETA_EDIF_2015 table that match the criteria 'DESCR = :descr'.
	 */
	public List<SiceeDProprietaEdif2015> findWhereDescrEquals(String descr) throws SiceeDProprietaEdif2015DaoException;

	/** 
	 * Returns the rows from the SICEE_D_PROPRIETA_EDIF_2015 table that matches the specified primary-key value.
	 */
	public SiceeDProprietaEdif2015 findByPrimaryKey(SiceeDProprietaEdif2015Pk pk) throws SiceeDProprietaEdif2015DaoException;

}
