/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceeweb.business.dao.exceptions;

public class SiceeRDestClasseDaoException extends DaoException
{
	/**
	 * Method 'SiceeRDestClasseDaoException'
	 * 
	 * @param message
	 */
	public SiceeRDestClasseDaoException(String message)
	{
		super(message);
	}

	/**
	 * Method 'SiceeRDestClasseDaoException'
	 * 
	 * @param message
	 * @param cause
	 */
	public SiceeRDestClasseDaoException(String message, Throwable cause)
	{
		super(message, cause);
	}

}
