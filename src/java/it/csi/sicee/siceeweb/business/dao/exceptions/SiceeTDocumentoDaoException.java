/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceeweb.business.dao.exceptions;

public class SiceeTDocumentoDaoException extends DaoException
{
	/**
	 * Method 'SiceeTDocumentoDaoException'
	 * 
	 * @param message
	 */
	public SiceeTDocumentoDaoException(String message)
	{
		super(message);
	}

	/**
	 * Method 'SiceeTDocumentoDaoException'
	 * 
	 * @param message
	 * @param cause
	 */
	public SiceeTDocumentoDaoException(String message, Throwable cause)
	{
		super(message, cause);
	}

}
