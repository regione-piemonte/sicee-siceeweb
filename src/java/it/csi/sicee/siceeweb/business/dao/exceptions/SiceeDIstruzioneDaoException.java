/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceeweb.business.dao.exceptions;

public class SiceeDIstruzioneDaoException extends DaoException
{
	/**
	 * Method 'SiceeDIstruzioneDaoException'
	 * 
	 * @param message
	 */
	public SiceeDIstruzioneDaoException(String message)
	{
		super(message);
	}

	/**
	 * Method 'SiceeDIstruzioneDaoException'
	 * 
	 * @param message
	 * @param cause
	 */
	public SiceeDIstruzioneDaoException(String message, Throwable cause)
	{
		super(message, cause);
	}

}
