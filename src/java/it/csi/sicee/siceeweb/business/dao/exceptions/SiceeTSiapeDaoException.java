/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceeweb.business.dao.exceptions;

public class SiceeTSiapeDaoException extends DaoException
{
	/**
	 * Method 'SiceeTSiapeDaoException'
	 * 
	 * @param message
	 */
	public SiceeTSiapeDaoException(String message)
	{
		super(message);
	}

	/**
	 * Method 'SiceeTSiapeDaoException'
	 * 
	 * @param message
	 * @param cause
	 */
	public SiceeTSiapeDaoException(String message, Throwable cause)
	{
		super(message, cause);
	}

}
