/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceeweb.business.dao.exceptions;

public class SiceeTDatiGeneraliDaoException extends DaoException
{
	/**
	 * Method 'SiceeTDatiGeneraliDaoException'
	 * 
	 * @param message
	 */
	public SiceeTDatiGeneraliDaoException(String message)
	{
		super(message);
	}

	/**
	 * Method 'SiceeTDatiGeneraliDaoException'
	 * 
	 * @param message
	 * @param cause
	 */
	public SiceeTDatiGeneraliDaoException(String message, Throwable cause)
	{
		super(message, cause);
	}

}
