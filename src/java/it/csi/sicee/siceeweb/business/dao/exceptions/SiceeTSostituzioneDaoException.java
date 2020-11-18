/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceeweb.business.dao.exceptions;

public class SiceeTSostituzioneDaoException extends DaoException
{
	/**
	 * Method 'SiceeTSostituzioneDaoException'
	 * 
	 * @param message
	 */
	public SiceeTSostituzioneDaoException(String message)
	{
		super(message);
	}

	/**
	 * Method 'SiceeTSostituzioneDaoException'
	 * 
	 * @param message
	 * @param cause
	 */
	public SiceeTSostituzioneDaoException(String message, Throwable cause)
	{
		super(message, cause);
	}

}
