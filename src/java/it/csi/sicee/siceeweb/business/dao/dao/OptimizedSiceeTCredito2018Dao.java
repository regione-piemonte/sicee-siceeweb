/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceeweb.business.dao.dao;

import it.csi.sicee.siceeweb.business.dao.dto.OptimizedSiceeTCredito2018;
import it.csi.sicee.siceeweb.business.dao.exceptions.OptimizedSiceeTCredito2018DaoException;

import java.util.List;

// TODO: Auto-generated Javadoc
/**
 * The Interface OptimizedSiceeTCorso2015Dao.
 */
public interface OptimizedSiceeTCredito2018Dao
{

	/**
	 * Method 'executeByFkCertificatore'.
	 *
	 * @param executeByFkCertificatore the fk certificatore
	 * @return List<OptimizedSiceeTCredito>
	 * @throws OptimizedSiceeTCreditoDaoException the optimized sicee t credito dao exception
	 */	
	public List<OptimizedSiceeTCredito2018> executeByFkCertificatore(String fkCertificatore, String codTipoRic) throws OptimizedSiceeTCredito2018DaoException;

}
