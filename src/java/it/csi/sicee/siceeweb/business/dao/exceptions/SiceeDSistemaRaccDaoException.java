/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceeweb.business.dao.exceptions;

public class SiceeDSistemaRaccDaoException extends DaoException
{
	/**
	 * Method 'SiceeDSistemaRaccDaoException'
	 * 
	 * @param message
	 */
	public SiceeDSistemaRaccDaoException(String message)
	{
		super(message);
	}

	/**
	 * Method 'SiceeDSistemaRaccDaoException'
	 * 
	 * @param message
	 * @param cause
	 */
	public SiceeDSistemaRaccDaoException(String message, Throwable cause)
	{
		super(message, cause);
	}

}
