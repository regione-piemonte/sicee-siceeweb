/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceeweb.business.dao.dao;

import it.csi.sicee.siceeweb.business.dao.dao.SiceeDRuoloCert2015Dao;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeDRuoloCert2015;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeDRuoloCert2015Pk;
import it.csi.sicee.siceeweb.business.dao.exceptions.SiceeDRuoloCert2015DaoException;
import java.util.List;

public interface SiceeDRuoloCert2015Dao
{
	/**
	 * Method 'insert'
	 * 
	 * @param dto
	 * @return SiceeDRuoloCert2015Pk
	 */
	public SiceeDRuoloCert2015Pk insert(SiceeDRuoloCert2015 dto);

	/** 
	 * Updates a single row in the SICEE_D_RUOLO_CERT_2015 table.
	 */
	public void update(SiceeDRuoloCert2015Pk pk, SiceeDRuoloCert2015 dto) throws SiceeDRuoloCert2015DaoException;

	/** 
	 * Deletes a single row in the SICEE_D_RUOLO_CERT_2015 table.
	 */
	public void delete(SiceeDRuoloCert2015Pk pk) throws SiceeDRuoloCert2015DaoException;

	/** 
	 * Returns all rows from the SICEE_D_RUOLO_CERT_2015 table that match the criteria 'ID_RUOLO_CERT = :idRuoloCert'.
	 */
	public SiceeDRuoloCert2015 findByPrimaryKey(long idRuoloCert) throws SiceeDRuoloCert2015DaoException;

	/** 
	 * Returns all rows from the SICEE_D_RUOLO_CERT_2015 table that match the criteria ''.
	 */
	public List<SiceeDRuoloCert2015> findAll() throws SiceeDRuoloCert2015DaoException;

	/** 
	 * Returns all rows from the SICEE_D_RUOLO_CERT_2015 table that match the criteria 'ID_RUOLO_CERT = :idRuoloCert'.
	 */
	public List<SiceeDRuoloCert2015> findWhereIdRuoloCertEquals(long idRuoloCert) throws SiceeDRuoloCert2015DaoException;

	/** 
	 * Returns all rows from the SICEE_D_RUOLO_CERT_2015 table that match the criteria 'DESCR = :descr'.
	 */
	public List<SiceeDRuoloCert2015> findWhereDescrEquals(String descr) throws SiceeDRuoloCert2015DaoException;

	/** 
	 * Returns the rows from the SICEE_D_RUOLO_CERT_2015 table that matches the specified primary-key value.
	 */
	public SiceeDRuoloCert2015 findByPrimaryKey(SiceeDRuoloCert2015Pk pk) throws SiceeDRuoloCert2015DaoException;

}
