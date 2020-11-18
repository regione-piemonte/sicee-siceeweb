/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceeweb.business.dao.exceptions;

public class SiceeWCertificatoreDaoException extends DaoException
{
	/**
	 * Method 'SiceeWCertificatoreDaoException'
	 * 
	 * @param message
	 */
	public SiceeWCertificatoreDaoException(String message)
	{
		super(message);
	}

	/**
	 * Method 'SiceeWCertificatoreDaoException'
	 * 
	 * @param message
	 * @param cause
	 */
	public SiceeWCertificatoreDaoException(String message, Throwable cause)
	{
		super(message, cause);
	}

}
