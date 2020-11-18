/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceeweb.business.dao.dao;

import it.csi.sicee.siceeweb.business.dao.dao.SiceeWEmailNewsletterDao;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeWEmailNewsletter;
import it.csi.sicee.siceeweb.business.dao.exceptions.SiceeWEmailNewsletterDaoException;
import java.util.List;

// TODO: Auto-generated Javadoc
/**
 * The Interface SiceeWEmailNewsletterDao.
 */
public interface SiceeWEmailNewsletterDao
{
	
	/**
	 * Method 'insert'.
	 *
	 * @param dto the dto
	 */
	public void insert(SiceeWEmailNewsletter dto);

	/**
	 * Returns all rows from the SICEE_W_EMAIL_NEWSLETTER table that match the criteria ''.
	 *
	 * @return the list
	 * @throws SiceeWEmailNewsletterDaoException the sicee w email newsletter dao exception
	 */
	public List<SiceeWEmailNewsletter> findAll() throws SiceeWEmailNewsletterDaoException;

	/**
	 * Returns all rows from the SICEE_W_EMAIL_NEWSLETTER table that match the criteria 'EMAIL = :eMail'.
	 *
	 * @param eMail the e mail
	 * @return the sicee w email newsletter
	 * @throws SiceeWEmailNewsletterDaoException the sicee w email newsletter dao exception
	 */
	public SiceeWEmailNewsletter findWhereEmailEquals(String eMail) throws SiceeWEmailNewsletterDaoException;

}
