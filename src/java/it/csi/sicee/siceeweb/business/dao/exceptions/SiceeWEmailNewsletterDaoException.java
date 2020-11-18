/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceeweb.business.dao.exceptions;

public class SiceeWEmailNewsletterDaoException extends DaoException
{
	/**
	 * Method 'SiceeWEmailNewsletterDaoException'
	 * 
	 * @param message
	 */
	public SiceeWEmailNewsletterDaoException(String message)
	{
		super(message);
	}

	/**
	 * Method 'SiceeWEmailNewsletterDaoException'
	 * 
	 * @param message
	 * @param cause
	 */
	public SiceeWEmailNewsletterDaoException(String message, Throwable cause)
	{
		super(message, cause);
	}

}
