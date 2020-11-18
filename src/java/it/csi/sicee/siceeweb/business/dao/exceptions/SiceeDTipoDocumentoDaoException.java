/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceeweb.business.dao.exceptions;

public class SiceeDTipoDocumentoDaoException extends DaoException
{
	/**
	 * Method 'SiceeDTipoDocumentoDaoException'
	 * 
	 * @param message
	 */
	public SiceeDTipoDocumentoDaoException(String message)
	{
		super(message);
	}

	/**
	 * Method 'SiceeDTipoDocumentoDaoException'
	 * 
	 * @param message
	 * @param cause
	 */
	public SiceeDTipoDocumentoDaoException(String message, Throwable cause)
	{
		super(message, cause);
	}

}
