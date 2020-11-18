/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceeweb.business.dao.exceptions;

public class SiceeTFirmaMarcaDaoException extends DaoException
{
	/**
	 * Method 'SiceeTFirmaMarcaDaoException'
	 * 
	 * @param message
	 */
	public SiceeTFirmaMarcaDaoException(String message)
	{
		super(message);
	}

	/**
	 * Method 'SiceeTFirmaMarcaDaoException'
	 * 
	 * @param message
	 * @param cause
	 */
	public SiceeTFirmaMarcaDaoException(String message, Throwable cause)
	{
		super(message, cause);
	}

}
