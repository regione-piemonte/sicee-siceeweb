/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceeweb.business.dao.dao;

import it.csi.sicee.siceeweb.business.dao.dto.OptimizedSiceeTCredito;
import it.csi.sicee.siceeweb.business.dao.exceptions.OptimizedSiceeTCreditoDaoException;

import java.util.List;

// TODO: Auto-generated Javadoc
/**
 * The Interface OptimizedSiceeTCorso2015Dao.
 */
public interface OptimizedSiceeTCreditoDao
{

	/**
	 * Method 'executeByFkCertificatore'.
	 *
	 * @param executeByFkCertificatore the fk certificatore
	 * @return List<OptimizedSiceeTCredito>
	 * @throws OptimizedSiceeTCreditoDaoException the optimized sicee t credito dao exception
	 */	
	public OptimizedSiceeTCredito executeByFkCertificatore(String fkCertificatore) throws OptimizedSiceeTCreditoDaoException;

}
