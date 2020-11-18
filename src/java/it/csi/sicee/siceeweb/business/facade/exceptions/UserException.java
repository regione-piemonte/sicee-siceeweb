/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceeweb.business.facade.exceptions;


public class UserException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7583376730326946211L;
	
	protected Throwable throwable;
	
	
	/**
	 * Inizializza un'istanza della classe
	 * 
	 * @param cause Causa dell'eccezione
	 * @param msg Messaggio associato all'eccezione
	 */
	public UserException(Throwable cause, String msg) {
		super(msg, cause);
	}
	
	public UserException(String msg){
		super(msg);
	}
	
}
