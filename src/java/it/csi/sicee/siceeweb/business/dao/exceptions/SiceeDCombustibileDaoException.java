/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceeweb.business.dao.exceptions;

public class SiceeDCombustibileDaoException extends DaoException
{
	/**
	 * Method 'SiceeDCombustibileDaoException'
	 * 
	 * @param message
	 */
	public SiceeDCombustibileDaoException(String message)
	{
		super(message);
	}

	/**
	 * Method 'SiceeDCombustibileDaoException'
	 * 
	 * @param message
	 * @param cause
	 */
	public SiceeDCombustibileDaoException(String message, Throwable cause)
	{
		super(message, cause);
	}

}
