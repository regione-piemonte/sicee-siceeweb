/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceeweb.business.dao.exceptions;

public class SiceeDTipoIstruzioneDaoException extends DaoException
{
	/**
	 * Method 'SiceeDTipoIstruzioneDaoException'
	 * 
	 * @param message
	 */
	public SiceeDTipoIstruzioneDaoException(String message)
	{
		super(message);
	}

	/**
	 * Method 'SiceeDTipoIstruzioneDaoException'
	 * 
	 * @param message
	 * @param cause
	 */
	public SiceeDTipoIstruzioneDaoException(String message, Throwable cause)
	{
		super(message, cause);
	}

}
