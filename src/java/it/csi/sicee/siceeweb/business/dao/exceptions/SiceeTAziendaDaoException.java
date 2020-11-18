/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceeweb.business.dao.exceptions;

public class SiceeTAziendaDaoException extends DaoException
{
	/**
	 * Method 'SiceeTAziendaDaoException'
	 * 
	 * @param message
	 */
	public SiceeTAziendaDaoException(String message)
	{
		super(message);
	}

	/**
	 * Method 'SiceeTAziendaDaoException'
	 * 
	 * @param message
	 * @param cause
	 */
	public SiceeTAziendaDaoException(String message, Throwable cause)
	{
		super(message, cause);
	}

}
