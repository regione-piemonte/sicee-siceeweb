/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceeweb.business.dao.exceptions;

public class SiceeDGradiGiornoDaoException extends DaoException
{
	/**
	 * Method 'SiceeDGradiGiornoDaoException'
	 * 
	 * @param message
	 */
	public SiceeDGradiGiornoDaoException(String message)
	{
		super(message);
	}

	/**
	 * Method 'SiceeDGradiGiornoDaoException'
	 * 
	 * @param message
	 * @param cause
	 */
	public SiceeDGradiGiornoDaoException(String message, Throwable cause)
	{
		super(message, cause);
	}

}
