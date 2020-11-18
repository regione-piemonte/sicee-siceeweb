/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceeweb.business.dao.dao;

import it.csi.sicee.siceeweb.business.dao.dto.OptimizedSiceeTCorso2015;
import it.csi.sicee.siceeweb.business.dao.exceptions.OptimizedSiceeTCorso2015DaoException;

import java.util.List;

// TODO: Auto-generated Javadoc
/**
 * The Interface OptimizedSiceeTCorso2015Dao.
 */
public interface OptimizedSiceeTCorso2015Dao
{

	/**
	 * Method 'executeByCodiceFiscale'.
	 *
	 * @param codiceFiscale the codice fiscale
	 * @return List<OptimizedSiceeTCorso2015>
	 * @throws OptimizedSiceeTCorso2015DaoException the optimized sicee t corso 2015 dao exception
	 */	public List<OptimizedSiceeTCorso2015> executeByCodiceFiscale(String CodiceFiscale) throws OptimizedSiceeTCorso2015DaoException;

}
