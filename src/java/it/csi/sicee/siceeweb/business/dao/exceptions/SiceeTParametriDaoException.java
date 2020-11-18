/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceeweb.business.dao.exceptions;

public class SiceeTParametriDaoException extends DaoException
{
	/**
	 * Method 'SiceeTParametriDaoException'
	 * 
	 * @param message
	 */
	public SiceeTParametriDaoException(String message)
	{
		super(message);
	}

	/**
	 * Method 'SiceeTParametriDaoException'
	 * 
	 * @param message
	 * @param cause
	 */
	public SiceeTParametriDaoException(String message, Throwable cause)
	{
		super(message, cause);
	}

}
