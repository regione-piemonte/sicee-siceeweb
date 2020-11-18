/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceeweb.business.dao.exceptions;

public class SiceeTImpRiscaldamentoAcsDaoException extends DaoException
{
	/**
	 * Method 'SiceeTImpRiscaldamentoAcsDaoException'
	 * 
	 * @param message
	 */
	public SiceeTImpRiscaldamentoAcsDaoException(String message)
	{
		super(message);
	}

	/**
	 * Method 'SiceeTImpRiscaldamentoAcsDaoException'
	 * 
	 * @param message
	 * @param cause
	 */
	public SiceeTImpRiscaldamentoAcsDaoException(String message, Throwable cause)
	{
		super(message, cause);
	}

}
