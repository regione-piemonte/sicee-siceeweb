/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceeweb.business.dao.exceptions;

public class SiceeTFabbisognoDaoException extends DaoException
{
	/**
	 * Method 'SiceeTFabbisognoDaoException'
	 * 
	 * @param message
	 */
	public SiceeTFabbisognoDaoException(String message)
	{
		super(message);
	}

	/**
	 * Method 'SiceeTFabbisognoDaoException'
	 * 
	 * @param message
	 * @param cause
	 */
	public SiceeTFabbisognoDaoException(String message, Throwable cause)
	{
		super(message, cause);
	}

}
