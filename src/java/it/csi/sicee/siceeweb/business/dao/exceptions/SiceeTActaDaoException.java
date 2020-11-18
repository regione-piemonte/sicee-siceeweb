/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceeweb.business.dao.exceptions;

public class SiceeTActaDaoException extends DaoException
{
	/**
	 * Method 'SiceeTActaDaoException'
	 * 
	 * @param message
	 */
	public SiceeTActaDaoException(String message)
	{
		super(message);
	}

	/**
	 * Method 'SiceeTActaDaoException'
	 * 
	 * @param message
	 * @param cause
	 */
	public SiceeTActaDaoException(String message, Throwable cause)
	{
		super(message, cause);
	}

}
