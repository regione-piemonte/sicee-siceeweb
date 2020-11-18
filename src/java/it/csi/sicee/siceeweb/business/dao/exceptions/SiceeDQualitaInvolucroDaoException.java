/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceeweb.business.dao.exceptions;

public class SiceeDQualitaInvolucroDaoException extends DaoException
{
	/**
	 * Method 'SiceeDQualitaInvolucroDaoException'
	 * 
	 * @param message
	 */
	public SiceeDQualitaInvolucroDaoException(String message)
	{
		super(message);
	}

	/**
	 * Method 'SiceeDQualitaInvolucroDaoException'
	 * 
	 * @param message
	 * @param cause
	 */
	public SiceeDQualitaInvolucroDaoException(String message, Throwable cause)
	{
		super(message, cause);
	}

}
