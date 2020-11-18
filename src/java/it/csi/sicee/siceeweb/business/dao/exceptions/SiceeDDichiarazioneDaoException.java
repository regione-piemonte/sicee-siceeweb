/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceeweb.business.dao.exceptions;

public class SiceeDDichiarazioneDaoException extends DaoException
{
	/**
	 * Method 'SiceeDDichiarazioneDaoException'
	 * 
	 * @param message
	 */
	public SiceeDDichiarazioneDaoException(String message)
	{
		super(message);
	}

	/**
	 * Method 'SiceeDDichiarazioneDaoException'
	 * 
	 * @param message
	 * @param cause
	 */
	public SiceeDDichiarazioneDaoException(String message, Throwable cause)
	{
		super(message, cause);
	}

}
