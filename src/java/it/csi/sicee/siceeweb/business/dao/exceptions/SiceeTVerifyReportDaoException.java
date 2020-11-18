/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceeweb.business.dao.exceptions;

public class SiceeTVerifyReportDaoException extends DaoException
{
	/**
	 * Method 'SiceeTVerifyReportDaoException'
	 * 
	 * @param message
	 */
	public SiceeTVerifyReportDaoException(String message)
	{
		super(message);
	}

	/**
	 * Method 'SiceeTVerifyReportDaoException'
	 * 
	 * @param message
	 * @param cause
	 */
	public SiceeTVerifyReportDaoException(String message, Throwable cause)
	{
		super(message, cause);
	}

}
