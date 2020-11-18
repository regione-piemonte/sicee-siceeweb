/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceeweb.business.dao.exceptions;

public class SiceeTConsumiEdificioDaoException extends DaoException
{
	/**
	 * Method 'SiceeTConsumiEdificioDaoException'
	 * 
	 * @param message
	 */
	public SiceeTConsumiEdificioDaoException(String message)
	{
		super(message);
	}

	/**
	 * Method 'SiceeTConsumiEdificioDaoException'
	 * 
	 * @param message
	 * @param cause
	 */
	public SiceeTConsumiEdificioDaoException(String message, Throwable cause)
	{
		super(message, cause);
	}

}
