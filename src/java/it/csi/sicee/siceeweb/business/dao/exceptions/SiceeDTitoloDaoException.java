/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceeweb.business.dao.exceptions;

public class SiceeDTitoloDaoException extends DaoException
{
	/**
	 * Method 'SiceeDTitoloDaoException'
	 * 
	 * @param message
	 */
	public SiceeDTitoloDaoException(String message)
	{
		super(message);
	}

	/**
	 * Method 'SiceeDTitoloDaoException'
	 * 
	 * @param message
	 * @param cause
	 */
	public SiceeDTitoloDaoException(String message, Throwable cause)
	{
		super(message, cause);
	}

}
