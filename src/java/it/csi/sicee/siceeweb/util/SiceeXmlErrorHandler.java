/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
/*
 * 
 */
package it.csi.sicee.siceeweb.util;

import java.util.ArrayList;

import org.apache.log4j.Logger;
import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

// TODO: Auto-generated Javadoc
/**
 * The Class SiceeXmlErrorHandler.
 */
public class SiceeXmlErrorHandler implements ErrorHandler {
	
	/** The log. */
	protected static Logger log = Logger.getLogger(Constants.APPLICATION_CODE
			+ ".business");
	
	//private static java.util.ResourceBundle rb = java.util.ResourceBundle
	//.getBundle("/META-INF/XMLSchemaMessagesRemapped");
	
	/** The list. */
	ArrayList<String> list = null;

	/**
	 * Gets the list.
	 *
	 * @return the list
	 */
	public ArrayList<String> getList() {
		return list;
	}
	
	/**
	 * Instantiates a new sicee xml error handler.
	 */
	public SiceeXmlErrorHandler() {
		this.list = new ArrayList<String>();		
	}

	/* (non-Javadoc)
	 * @see org.xml.sax.ErrorHandler#error(org.xml.sax.SAXParseException)
	 */
	public void error(SAXParseException e) throws SAXException {		
		list.add(convertMessageToItalian(e.getMessage()));
		
	}

	/* (non-Javadoc)
	 * @see org.xml.sax.ErrorHandler#fatalError(org.xml.sax.SAXParseException)
	 */
	public void fatalError(SAXParseException e) throws SAXException {
		list.add(convertMessageToItalian(e.getMessage()));
		
	}

	/* (non-Javadoc)
	 * @see org.xml.sax.ErrorHandler#warning(org.xml.sax.SAXParseException)
	 */
	public void warning(SAXParseException e) throws SAXException {
		list.add(convertMessageToItalian(e.getMessage()));
	}
	
	/**
	 * Convert message to italian.
	 *
	 * @param msg the msg
	 * @return the string
	 */
	private String convertMessageToItalian (String msg) {
		String converted = msg;
		log.warn("msg: " + msg);
		
		return converted;
	}

}
