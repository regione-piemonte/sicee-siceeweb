/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceeweb.business.dao.exceptions;

public class SiceeDCarattEdificioDaoException extends DaoException
{
	/**
	 * Method 'SiceeDCarattEdificioDaoException'
	 * 
	 * @param message
	 */
	public SiceeDCarattEdificioDaoException(String message)
	{
		super(message);
	}

	/**
	 * Method 'SiceeDCarattEdificioDaoException'
	 * 
	 * @param message
	 * @param cause
	 */
	public SiceeDCarattEdificioDaoException(String message, Throwable cause)
	{
		super(message, cause);
	}

}
