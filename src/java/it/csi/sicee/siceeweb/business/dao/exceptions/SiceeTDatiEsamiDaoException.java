/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceeweb.business.dao.exceptions;

public class SiceeTDatiEsamiDaoException extends DaoException
{
	/**
	 * Method 'SiceeTDatiEsamiDaoException'
	 * 
	 * @param message
	 */
	public SiceeTDatiEsamiDaoException(String message)
	{
		super(message);
	}

	/**
	 * Method 'SiceeTDatiEsamiDaoException'
	 * 
	 * @param message
	 * @param cause
	 */
	public SiceeTDatiEsamiDaoException(String message, Throwable cause)
	{
		super(message, cause);
	}

}
