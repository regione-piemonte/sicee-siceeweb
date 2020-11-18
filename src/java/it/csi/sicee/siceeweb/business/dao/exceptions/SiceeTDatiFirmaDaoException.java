/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceeweb.business.dao.exceptions;

public class SiceeTDatiFirmaDaoException extends DaoException
{
	/**
	 * Method 'SiceeTDatiFirmaDaoException'
	 * 
	 * @param message
	 */
	public SiceeTDatiFirmaDaoException(String message)
	{
		super(message);
	}

	/**
	 * Method 'SiceeTDatiFirmaDaoException'
	 * 
	 * @param message
	 * @param cause
	 */
	public SiceeTDatiFirmaDaoException(String message, Throwable cause)
	{
		super(message, cause);
	}

}
