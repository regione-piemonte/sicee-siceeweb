/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceeweb.business.dao.exceptions;

public class SiceeDRuoloDaoException extends DaoException
{
	/**
	 * Method 'SiceeDRuoloDaoException'
	 * 
	 * @param message
	 */
	public SiceeDRuoloDaoException(String message)
	{
		super(message);
	}

	/**
	 * Method 'SiceeDRuoloDaoException'
	 * 
	 * @param message
	 * @param cause
	 */
	public SiceeDRuoloDaoException(String message, Throwable cause)
	{
		super(message, cause);
	}

}
