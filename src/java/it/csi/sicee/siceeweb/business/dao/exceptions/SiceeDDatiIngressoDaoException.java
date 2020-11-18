/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceeweb.business.dao.exceptions;

public class SiceeDDatiIngressoDaoException extends DaoException
{
	/**
	 * Method 'SiceeDDatiIngressoDaoException'
	 * 
	 * @param message
	 */
	public SiceeDDatiIngressoDaoException(String message)
	{
		super(message);
	}

	/**
	 * Method 'SiceeDDatiIngressoDaoException'
	 * 
	 * @param message
	 * @param cause
	 */
	public SiceeDDatiIngressoDaoException(String message, Throwable cause)
	{
		super(message, cause);
	}

}
