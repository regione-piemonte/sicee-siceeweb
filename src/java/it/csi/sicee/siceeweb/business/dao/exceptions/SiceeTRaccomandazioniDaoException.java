/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceeweb.business.dao.exceptions;

public class SiceeTRaccomandazioniDaoException extends DaoException
{
	/**
	 * Method 'SiceeTRaccomandazioniDaoException'
	 * 
	 * @param message
	 */
	public SiceeTRaccomandazioniDaoException(String message)
	{
		super(message);
	}

	/**
	 * Method 'SiceeTRaccomandazioniDaoException'
	 * 
	 * @param message
	 * @param cause
	 */
	public SiceeTRaccomandazioniDaoException(String message, Throwable cause)
	{
		super(message, cause);
	}

}
