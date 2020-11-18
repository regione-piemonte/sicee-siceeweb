/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceeweb.business.dao.exceptions;

public class SiceeDPrioritaDaoException extends DaoException
{
	/**
	 * Method 'SiceeDPrioritaDaoException'
	 * 
	 * @param message
	 */
	public SiceeDPrioritaDaoException(String message)
	{
		super(message);
	}

	/**
	 * Method 'SiceeDPrioritaDaoException'
	 * 
	 * @param message
	 * @param cause
	 */
	public SiceeDPrioritaDaoException(String message, Throwable cause)
	{
		super(message, cause);
	}

}
