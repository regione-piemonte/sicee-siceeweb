/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceeweb.business.dao.exceptions;

public class SiceeTRispettoNormativeDaoException extends DaoException
{
	/**
	 * Method 'SiceeTRispettoNormativeDaoException'
	 * 
	 * @param message
	 */
	public SiceeTRispettoNormativeDaoException(String message)
	{
		super(message);
	}

	/**
	 * Method 'SiceeTRispettoNormativeDaoException'
	 * 
	 * @param message
	 * @param cause
	 */
	public SiceeTRispettoNormativeDaoException(String message, Throwable cause)
	{
		super(message, cause);
	}

}
