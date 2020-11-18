/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceeweb.business.dao.exceptions;

public class SiceeDTipoImpiantoDaoException extends DaoException
{
	/**
	 * Method 'SiceeDTipoImpiantoDaoException'
	 * 
	 * @param message
	 */
	public SiceeDTipoImpiantoDaoException(String message)
	{
		super(message);
	}

	/**
	 * Method 'SiceeDTipoImpiantoDaoException'
	 * 
	 * @param message
	 * @param cause
	 */
	public SiceeDTipoImpiantoDaoException(String message, Throwable cause)
	{
		super(message, cause);
	}

}
