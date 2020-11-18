/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceeweb.business.dao.exceptions;

public class SiceeTTransazioneAceDaoException extends DaoException
{
	/**
	 * Method 'SiceeTTransazioneAceDaoException'
	 * 
	 * @param message
	 */
	public SiceeTTransazioneAceDaoException(String message)
	{
		super(message);
	}

	/**
	 * Method 'SiceeTTransazioneAceDaoException'
	 * 
	 * @param message
	 * @param cause
	 */
	public SiceeTTransazioneAceDaoException(String message, Throwable cause)
	{
		super(message, cause);
	}

}
