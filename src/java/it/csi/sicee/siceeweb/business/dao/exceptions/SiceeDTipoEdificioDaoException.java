/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceeweb.business.dao.exceptions;

public class SiceeDTipoEdificioDaoException extends DaoException
{
	/**
	 * Method 'SiceeDTipoEdificioDaoException'
	 * 
	 * @param message
	 */
	public SiceeDTipoEdificioDaoException(String message)
	{
		super(message);
	}

	/**
	 * Method 'SiceeDTipoEdificioDaoException'
	 * 
	 * @param message
	 * @param cause
	 */
	public SiceeDTipoEdificioDaoException(String message, Throwable cause)
	{
		super(message, cause);
	}

}
