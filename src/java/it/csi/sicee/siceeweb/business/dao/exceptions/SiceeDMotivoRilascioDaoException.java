/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceeweb.business.dao.exceptions;

public class SiceeDMotivoRilascioDaoException extends DaoException
{
	/**
	 * Method 'SiceeDMotivoRilascioDaoException'
	 * 
	 * @param message
	 */
	public SiceeDMotivoRilascioDaoException(String message)
	{
		super(message);
	}

	/**
	 * Method 'SiceeDMotivoRilascioDaoException'
	 * 
	 * @param message
	 * @param cause
	 */
	public SiceeDMotivoRilascioDaoException(String message, Throwable cause)
	{
		super(message, cause);
	}

}
