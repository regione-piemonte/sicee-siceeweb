/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceeweb.business.dao.exceptions;

public class SiceeTExportBoDaoException extends DaoException
{
	/**
	 * Method 'SiceeTExportBoDaoException'
	 * 
	 * @param message
	 */
	public SiceeTExportBoDaoException(String message)
	{
		super(message);
	}

	/**
	 * Method 'SiceeTExportBoDaoException'
	 * 
	 * @param message
	 * @param cause
	 */
	public SiceeTExportBoDaoException(String message, Throwable cause)
	{
		super(message, cause);
	}

}
