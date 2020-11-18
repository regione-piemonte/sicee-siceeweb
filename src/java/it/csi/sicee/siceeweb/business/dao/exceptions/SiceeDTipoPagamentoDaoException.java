/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceeweb.business.dao.exceptions;

public class SiceeDTipoPagamentoDaoException extends DaoException
{
	/**
	 * Method 'SiceeDTipoPagamentoDaoException'
	 * 
	 * @param message
	 */
	public SiceeDTipoPagamentoDaoException(String message)
	{
		super(message);
	}

	/**
	 * Method 'SiceeDTipoPagamentoDaoException'
	 * 
	 * @param message
	 * @param cause
	 */
	public SiceeDTipoPagamentoDaoException(String message, Throwable cause)
	{
		super(message, cause);
	}

}
