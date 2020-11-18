/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceeweb.business.dao.exceptions;

public class SiceeTCertificatoreDaoException extends DaoException
{
	/**
	 * Method 'SiceeTCertificatoreDaoException'
	 * 
	 * @param message
	 */
	public SiceeTCertificatoreDaoException(String message)
	{
		super(message);
	}

	/**
	 * Method 'SiceeTCertificatoreDaoException'
	 * 
	 * @param message
	 * @param cause
	 */
	public SiceeTCertificatoreDaoException(String message, Throwable cause)
	{
		super(message, cause);
	}

}
