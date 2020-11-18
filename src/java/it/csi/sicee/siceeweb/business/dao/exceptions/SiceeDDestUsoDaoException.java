/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceeweb.business.dao.exceptions;

public class SiceeDDestUsoDaoException extends DaoException
{
	/**
	 * Method 'SiceeDDestUsoDaoException'
	 * 
	 * @param message
	 */
	public SiceeDDestUsoDaoException(String message)
	{
		super(message);
	}

	/**
	 * Method 'SiceeDDestUsoDaoException'
	 * 
	 * @param message
	 * @param cause
	 */
	public SiceeDDestUsoDaoException(String message, Throwable cause)
	{
		super(message, cause);
	}

}
