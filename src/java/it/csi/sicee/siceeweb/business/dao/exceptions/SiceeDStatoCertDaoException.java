/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceeweb.business.dao.exceptions;

public class SiceeDStatoCertDaoException extends DaoException
{
	/**
	 * Method 'SiceeDStatoCertDaoException'
	 * 
	 * @param message
	 */
	public SiceeDStatoCertDaoException(String message)
	{
		super(message);
	}

	/**
	 * Method 'SiceeDStatoCertDaoException'
	 * 
	 * @param message
	 * @param cause
	 */
	public SiceeDStatoCertDaoException(String message, Throwable cause)
	{
		super(message, cause);
	}

}
