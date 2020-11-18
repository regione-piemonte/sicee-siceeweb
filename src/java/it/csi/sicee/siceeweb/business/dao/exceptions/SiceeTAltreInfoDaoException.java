/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceeweb.business.dao.exceptions;

public class SiceeTAltreInfoDaoException extends DaoException
{
	/**
	 * Method 'SiceeTAltreInfoDaoException'
	 * 
	 * @param message
	 */
	public SiceeTAltreInfoDaoException(String message)
	{
		super(message);
	}

	/**
	 * Method 'SiceeTAltreInfoDaoException'
	 * 
	 * @param message
	 * @param cause
	 */
	public SiceeTAltreInfoDaoException(String message, Throwable cause)
	{
		super(message, cause);
	}

}
