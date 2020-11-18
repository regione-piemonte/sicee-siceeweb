/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceeweb.business.dao.exceptions;

public class SiceeRCertRuoliDaoException extends DaoException
{
	/**
	 * Method 'SiceeRCertRuoliDaoException'
	 * 
	 * @param message
	 */
	public SiceeRCertRuoliDaoException(String message)
	{
		super(message);
	}

	/**
	 * Method 'SiceeRCertRuoliDaoException'
	 * 
	 * @param message
	 * @param cause
	 */
	public SiceeRCertRuoliDaoException(String message, Throwable cause)
	{
		super(message, cause);
	}

}
