/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceeweb.business.dao.exceptions;

public class SiceeTRuoliEdificioDaoException extends DaoException
{
	/**
	 * Method 'SiceeTRuoliEdificioDaoException'
	 * 
	 * @param message
	 */
	public SiceeTRuoliEdificioDaoException(String message)
	{
		super(message);
	}

	/**
	 * Method 'SiceeTRuoliEdificioDaoException'
	 * 
	 * @param message
	 * @param cause
	 */
	public SiceeTRuoliEdificioDaoException(String message, Throwable cause)
	{
		super(message, cause);
	}

}
