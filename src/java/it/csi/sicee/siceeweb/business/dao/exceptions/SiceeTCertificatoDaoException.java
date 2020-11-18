/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceeweb.business.dao.exceptions;

public class SiceeTCertificatoDaoException extends DaoException
{
	/**
	 * Method 'SiceeTCertificatoDaoException'
	 * 
	 * @param message
	 */
	public SiceeTCertificatoDaoException(String message)
	{
		super(message);
	}

	/**
	 * Method 'SiceeTCertificatoDaoException'
	 * 
	 * @param message
	 * @param cause
	 */
	public SiceeTCertificatoDaoException(String message, Throwable cause)
	{
		super(message, cause);
	}

}
