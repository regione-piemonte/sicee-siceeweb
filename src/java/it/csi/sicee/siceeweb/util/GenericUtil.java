/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
/*
 * 
 */
package it.csi.sicee.siceeweb.util;

import it.csi.sicee.siceeweb.business.dao.dto.SiceeTDatiEner2015;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeTParametri;
import it.csi.sicee.siceeweb.business.facade.MiscMgr;
import it.csi.sicee.siceeweb.dto.ace.Ace;
import it.csi.sicee.siceeweb.dto.ace.FiltroRicercaAce;
import it.csi.sicee.siceeweb.dto.attestati.AttestatoSummary;
import it.csi.sicee.siceeweb.dto.commons.LabelValueCombo;
import it.csi.sicee.siceeweb.dto.type.UDTDateValid;
import it.csi.sicee.siceeweb.dto.type.UDTPositiveDoubleFive;
import it.csi.sicee.siceeweb.dto.type.UDTPositiveDoubleFour;
import it.csi.sicee.siceeweb.dto.type.UDTPositiveInteger;

import java.io.InputStream;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.StringTokenizer;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * The Class GenericUtil.
 */
public class GenericUtil {

	/** The Constant BEGIN. */
	static final int BEGIN = 1;

	/** The Constant END. */
	static final int END = 2;

	/** The Constant VALUE. */
	static final int VALUE = 3;

	/** The Constant TEST. */
	static final int TEST = 4;

	/** The Constant SIMPLE. */
	static final int SIMPLE = 5;
	
	private final static String VALUE_PLACEHOLDER = "##value##";
	private final static String VALUE_PLACEHOLDER1 = "##value1##";
	private final static String VALUE_PLACEHOLDER2 = "##value2##";


	/** The log. */
	protected static Logger log = Logger.getLogger(Constants.APPLICATION_CODE);

	/**
	 * Stampa.
	 * 
	 * @param o
	 *            the o
	 * @param useLog4j
	 *            the use log4j
	 * @param depth
	 *            the depth
	 * @param testName
	 *            the test name
	 */
	public static void stampa(Object o, boolean useLog4j, int depth,
			String testName) {
		try {
			if (useLog4j) {
				log.debug(testName + " BEGIN");
			} else {
				System.out.println(testName + " BEGIN");
			}
			if (o != null) {
				if (o.getClass().isArray()) {
					Object[] a = (Object[]) o;
					stampa(a, useLog4j, depth);
				} else {
					stampa(o, useLog4j, depth);
				}
			}
			if (useLog4j) {
				log.debug(testName + " END");
			} else {
				System.out.println(testName + " END");
			}
		} catch (Exception e) {
			log.error(e);
		}
	}

	/**
	 * Stampa.
	 * 
	 * @param o
	 *            the o
	 * @param useLog4j
	 *            the use log4j
	 * @param depth
	 *            the depth
	 */
	public static void stampa(Object o, boolean useLog4j, int depth) {

		try {
			if (o == null) {
				print(o, null, useLog4j, depth, BEGIN);
			} else {
				if (o instanceof String) {
					print(o, o, useLog4j, depth, SIMPLE);
				} else {
					print(o, null, useLog4j, depth, BEGIN);
					callGetMethods(o, useLog4j, depth + 1);
					print(o, null, useLog4j, depth, END);
				}
			}
		} catch (Exception e) {
			log.error(e);
		}
	}

	/**
	 * Prints the.
	 * 
	 * @param o
	 *            the o
	 * @param value
	 *            the value
	 * @param useLog4j
	 *            the use log4j
	 * @param depth
	 *            the depth
	 * @param type
	 *            the type
	 * @throws Exception
	 *             the exception
	 */
	private static void print(Object o, Object value, boolean useLog4j,
			int depth, int type) throws Exception {

		StringBuffer tab = new StringBuffer();
		for (int i = 0; i < depth; i++) {
			tab.append("\t");
		}
		if (o != null) {
			String className = o.getClass().getName();
			switch (type) {
			case BEGIN:
				tab.append(className);
				tab.append(" BEGIN");
				break;
			case END:
				tab.append(className);
				tab.append(" END");
				break;
			case VALUE:
				tab.append(((Method) o).getName());
				tab.append(" == ");
				tab.append(value);
				break;
			case SIMPLE:
				tab.append(o);
				tab.append(" == ");
				tab.append(value);
				break;
			default:

			}
		} else if (type == TEST) {
			tab.append("");
		} else {
			tab.append("Oggetto nullo!!");
		}

		if (useLog4j) {
			log.debug(tab);
		} else {
			System.out.println(tab);
		}

	}

	/**
	 * Call get methods.
	 * 
	 * @param o
	 *            the o
	 * @param useLog4j
	 *            the use log4j
	 * @param depth
	 *            the depth
	 */
	private static void callGetMethods(Object o, boolean useLog4j, int depth) {
		try {
			Method[] meth = o.getClass().getDeclaredMethods();
			for (int i = 0; i < meth.length; i++) {
				Method thisM = meth[i];
				if (thisM.getName().startsWith("get")) {
					if (!thisM.getName().equals("get")) {
						Object result = thisM.invoke(o, new Object[] {});
						if (result != null && result.getClass().isArray()) {
							Object[] a = (Object[]) result;
							stampa(a, useLog4j, depth);
						} else {
							print(thisM, result, useLog4j, depth, VALUE);
						}
					}
				}
			}
		} catch (Exception e) {
			log.error(e);
		}
	}

	/**
	 * Stampa.
	 * 
	 * @param o
	 *            the o
	 * @param useLog4j
	 *            the use log4j
	 * @param depth
	 *            the depth
	 * @throws Exception
	 *             the exception
	 */
	public static void stampa(Object[] o, boolean useLog4j, int depth)
			throws Exception {
		String className = o.getClass().getSimpleName();
		for (int i = 0; i < o.length; i++) {
			stampa(o[i], false, depth);
		}

		if (o.length == 0) {
			System.out.println(className + " vuoto");
		}

	}

	/**
	 * Checks if is null or empty.
	 * 
	 * @param n
	 *            the n
	 * @return true, if is null or empty
	 */
	public static boolean isNullOrEmpty(UDTPositiveDoubleFour n) {
		return n == null || n.getValue() == null;
	}

	/**
	 * Checks if is null or empty.
	 * 
	 * @param n
	 *            the n
	 * @return true, if is null or empty
	 */
	public static boolean isNullOrEmpty(UDTPositiveDoubleFive n) {
		return n == null || n.getValue() == null;
	}

	/**
	 * Checks if is null or empty.
	 * 
	 * @param n
	 *            the n
	 * @return true, if is null or empty
	 */
	public static boolean isNullOrEmpty(UDTPositiveInteger n) {
		return n == null || n.getValue() == null;
	}

	/**
	 * Checks if is null or empty.
	 * 
	 * @param s
	 *            the s
	 * @return true, if is null or empty
	 */
	public static boolean isNullOrEmpty(String s) {
		return s == null || s.trim().length() == 0;
	}

	/**
	 * Checks if is null or empty.
	 * 
	 * @param s
	 *            the s
	 * @return true, if is null or empty
	 */
	public static boolean isNullOrEmpty(Integer s) {
		return s == null;
	}

	/**
	 * Checks if is null or empty.
	 * 
	 * @param s
	 *            the s
	 * @return true, if is null or empty
	 */
	public static boolean isNullOrEmpty(Double s) {
		return s == null;
	}

	/**
	 * Checks if is null or empty.
	 * 
	 * @param s
	 *            the s
	 * @return true, if is null or empty
	 */
	public static boolean isNullOrEmpty(Boolean s) {
		return s == null;
	}

	/**
	 * Checks if is null or empty.
	 * 
	 * @param s
	 *            the s
	 * @return true, if is null or empty
	 */
	public static boolean isNullOrEmpty(Object s) {
		return s == null;
	}

	public static boolean isNullOrEmpty(List<?> s) {
		if (s != null) {
			return s.isEmpty();
		}

		return s == null;
	}

	/**
	 * Checks if is null or empty.
	 * 
	 * @param n
	 *            the n
	 * @return true, if is null or empty
	 */
	public static boolean isNullOrEmpty(UDTDateValid n) {
		return n == null || n.getValue() == null;
	}

	/**
	 * Checks if is null or empty.
	 * 
	 * @param s
	 *            the s
	 * @return true, if is null or empty
	 */
	public static boolean isNotNullOrEmpty(String s) {
		return s != null && s.trim().length() > 0;
	}
	
	/**
	 * Checks if is null or empty.
	 * 
	 * @param s
	 *            the s
	 * @return true, if is null or empty
	 */
	public static boolean isNotNullOrEmpty(Integer s) {
		return s != null;
	}

	/**
	 * Checks if is not null or empty.
	 * 
	 * @param s
	 *            the s
	 * @return true, if is not null or empty
	 */
	public static boolean isNotNullOrEmpty(Object s) {
		return s != null;
	}
	
	public static String getStringValid(String s) {
		return StringUtils.trimToEmpty(s);
	}
	
	/**
	 * Verifica se una stringa e' valida rispetto ad una espressione regolare
	 * 
	 * @param string La stringa da verificare
	 * @param regex L'espressione regolare
	 * @return True se la stringa e' valida, false altrimenti
	 */
	public static boolean isStringValid(String string, String regex) {
		Pattern pattern = null;
		Matcher matcher = null;
		boolean isValid;

		isValid = false;
		if(string != null) {
			
			System.out.println("string: "+string);
			System.out.println("regex: "+regex);
			
			pattern = Pattern.compile(regex);
			matcher = pattern.matcher(string);
			isValid = matcher.matches();
		}
		
		System.out.println("isValid: "+isValid);
		return isValid;
	}
	
	/**
	 * Check valide email.
	 *
	 * @param email the email
	 * @return true, if successful
	 */
	public static boolean isValideEmail(String email) {
		if (!isNullOrEmpty(email)) {
			if (email
					.matches("\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*([,;]\\s*\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*)*")) {
				return true;
			} else {
				return false;
			}
		}

		return false;
	}
	
	/**
	 * Check valide  number.
	 * 
	 * @param num
	 *            the num
	 * @return true, if successful
	 */
	public static boolean isValideMaxLenghtNumber(String num, int lenght) {
		if (!isNullOrEmpty(num)) {
			String exp = "^[0-9]{0,"+lenght+"}";
			//log.debug("STAMPO LA EXP (checkValideLenghtNumber): "+exp);
			if (num.matches(exp))
				return true;
			else
				return false;
		}

		return false;
	}
	
	/**
	 * Check filtro ace.
	 * 
	 * @param filtro
	 *            the filtro
	 * @return true, if successful
	 */
	public static boolean checkFiltroAce(FiltroRicercaAce filtro) {
		int errors = 0;
		if (!checkValideFourNumber(filtro.getAnnoCertificato())) {
			errors++;
		}
		if (!checkValideSixNumber(filtro.getCertificatore())) {
			errors++;
		}
		if (!checkValideFourNumber(filtro.getProgCertificato())) {
			errors++;
		}

		if (errors > 0) {
			return false;
		}

		return true;
	}

	/**
	 * Check filtro ace2.
	 * 
	 * @param filtro
	 *            the filtro
	 * @return true, if successful
	 */
	public static boolean checkFiltroAce2(FiltroRicercaAce filtro) {

		if (log.isDebugEnabled())
		{
			GenericUtil.stampa(filtro, true, 3);
		}
		
		if (isNullOrEmpty(filtro.getCodProv())
				&& isNullOrEmpty(filtro.getCodComune())
				&& isNullOrEmpty(filtro.getDescComune())
				&& isNullOrEmpty(filtro.getDescIndirizzo())
				&& isNullOrEmpty(filtro.getNumCivico())
				&& isNullOrEmpty(filtro.getSezione())
				&& isNullOrEmpty(filtro.getFoglio())
				&& isNullOrEmpty(filtro.getParticella())
				&& isNullOrEmpty(filtro.getSubalterno())
				&& isNullOrEmpty(filtro.getStato())) {
			return false;
		}

		return true;
	}

	/**
	 * Check valide six number.
	 * 
	 * @param num
	 *            the num
	 * @return true, if successful
	 */
	public static boolean checkValideSixNumber(String num) {
		if (!isNullOrEmpty(num)) {
			if (num.matches("^[0-9]{6}"))
				return true;
			else
				return false;
		}

		return false;
	}

	/**
	 * Check valide four number.
	 * 
	 * @param num
	 *            the num
	 * @return true, if successful
	 */
	public static boolean checkValideFourNumber(String num) {
		if (!isNullOrEmpty(num)) {
			if (num.matches("^[0-9]{4}"))
				return true;
			else
				return false;
		}

		return false;
	}

	/**
	 * Verify param.
	 * 
	 * @param param
	 *            the param
	 * @param paramMancante
	 *            the param mancante
	 * @return true, if successful
	 */
	public static boolean verifyParam(SiceeTParametri param,
			String paramMancante) {
		if (param == null) {
			log.debug("PARAMETRO " + paramMancante + " INESISTENTE");
			return false;
		}

		return true;
	}

	/**
	 * Checks if is numero.
	 * 
	 * @param numero
	 *            the numero
	 * @return true, if is numero
	 */
	public static boolean isNumero(String numero) {

		boolean isValido = false;

		if (StringUtils.isNotEmpty(numero)) {
			try {
				new Integer(numero).intValue();
				isValido = true;
			} catch (Exception ex) {
				log.error(ex);
			}
		}

		return isValido;

	}
	
	public static boolean isNumeroDecimaleValido(String num, int maxInteri, int maxDecimal)
	{
		
		boolean ret = isDecimalNumber(num);
		int posPunto = num.indexOf(".");
		
		//System.out.println("posPunto: "+posPunto);
		
		if (ret)
		{
			if (posPunto > 0)
			{
				// son presenti decimali
				
				String inte = num.substring(0, posPunto);
				//System.out.println("inte: "+inte);
	
				String dec = num.substring(posPunto+1);
				//System.out.println("dec: "+dec);
				
				if (inte.length() > maxInteri || dec.length() > maxDecimal)
				{
					ret = false;
				}
			}
			else
			{
				if (num.length() > maxInteri)
				{
					ret = false;
				}
			}
		}
		return ret;
	}
	
	public static boolean isNumeroDecimaleValidoMaxDec(double num, int maxDecimal)
	{
		return isNumeroDecimaleValidoMaxDec(Converter.convertToString(num), maxDecimal);
	}
	
	public static boolean isNumeroDecimaleValidoMaxDec(String num, int maxDecimal)
	{
		num = num.replace(",", ".");
		boolean ret = isDecimalNumber(num);
		int posPunto = num.indexOf(".");
		
		System.out.println("posPunto: "+posPunto);
		
		if (ret)
		{
			if (posPunto > 0)
			{
				// son presenti decimali
				
				String dec = num.substring(posPunto+1);
				System.out.println("dec: "+dec);
				
				if (dec.length() > maxDecimal)
				{
					ret = false;
				}
			}
			
		}
		return ret;
	}
	
	/**
	 * Check valide four number.
	 * 
	 * @param num
	 *            the num
	 * @return true, if successful
	 */
	public static boolean isValideNumber(String num) {
		if (!isNullOrEmpty(num)) {
			if (num.matches("^[0-9]*"))
				return true;
			else
				return false;
		}

		return false;
	}
	
	/**
	 * Check valide four number.
	 * 
	 * @param num
	 *            the num
	 * @return true, if successful
	 */
	public static boolean isValideNumberTrim(String num) {
		if (!isNullOrEmpty(num)) {
			if (num.trim().matches("^[0-9]*"))
				return true;
			else
				return false;
		}

		return false;
	}
	
	/**
	 * Controlla se un numero è decimale.
	 * 
	 * @return the data odierna
	 */
	public static boolean isDecimalNumber(String num){
			try{
					Double.parseDouble(num);
					return true;
				}catch(Exception e){
					return false;
			}
		}
	

	public static Double effettuaDivisione(Double numeratore, Double denominatore)
	{
		if (numeratore != null && numeratore > 0 && denominatore != null && denominatore > 0)
			return numeratore/denominatore;
		else
			return null;
	}
	
	/**
	 * Gets the data odierna.
	 * 
	 * @return the data odierna
	 */
	public static String getDataOdierna() {
		return Constants.FORMATTER_DATA_WEB.format(new Date(System
				.currentTimeMillis()));
	}

	/**
	 * Gets the data odierna completa.
	 * 
	 * @return the data odierna completa
	 */
	public static String getDataOdiernaCompleta() {
		return Constants.FORMATTER_DATA_COMPLETA_WEB.format(new Date(System
				.currentTimeMillis()));
	}

	/**
	 * Gets the anno corrente.
	 * 
	 * @return the anno corrente
	 */
	public static String getAnnoCorrente() {
		return Constants.FORMATTER_ANNO_WEB.format(new Date(System
				.currentTimeMillis()));
	}

	/**
	 * Gets the anno prossimo.
	 * 
	 * @return the anno prossimo
	 */
	public static int getAnnoProssimo() {
		Integer annoCorrente = new Integer(getAnnoCorrente());
		return annoCorrente+1;
	}

	public static Double convertTo(UDTPositiveDoubleFive num) {

		return (num != null) ? num.getValue() : null;
	}

	public static Integer convertTo(UDTPositiveInteger num) {

		return (num != null) ? num.getValue() : null;
	}

	public static Double convertTo(UDTPositiveDoubleFour num) {

		return (num != null) ? num.getValue() : null;
	}

	public static UDTPositiveDoubleFour convertTo(Double num) {

		return (num != null) ? new UDTPositiveDoubleFour(num) : null;
	}

	public static UDTPositiveDoubleFive convertToDoubleFive(Double num) {

		return (num != null) ? new UDTPositiveDoubleFive(num) : null;
	}

	public static UDTPositiveInteger convertTo(Integer num) {

		return (num != null) ? new UDTPositiveInteger(num) : null;
	}

	public static boolean convertTo(String num) {

		return (num != null) ? num.equalsIgnoreCase(Constants.SI) : false;
	}
	
	public static URL getURLInClassPath(String fileName) {
		return GenericUtil.class.getClassLoader().getResource(fileName);
	}
	
	public static InputStream getInputSInClassPath(String fileName) {
		return GenericUtil.class.getClassLoader().getResourceAsStream(fileName);
	}
	
	public static String getIndirizzoNormalizzato(String indirizzo)
	{
		StringBuffer indirizzoBuffer = new StringBuffer();
		
		if (indirizzo != null)
		{
			StringTokenizer tok = new StringTokenizer(indirizzo);
			while (tok.hasMoreTokens()) {
				String tmp = tok.nextToken();
				indirizzoBuffer.append(tmp+" ");
			}
		}
		
		return indirizzoBuffer.toString().trim();
	}
	
	
	public static BigDecimal getBigDecimalValid(BigDecimal num) {

		return num != null?num:new BigDecimal(0);
	}

	
	public static String normalizzaSql(String valore)
	{
		String ret = null;
		if (!isNullOrEmpty(valore))
		{
			ret = valore.trim().toUpperCase();	
		}
		
		return ret;
	}
	
	public static Integer calcolaSmileInverno(
			Double ePhnd, Double ePhndLimite) {

		Integer smile = null;

//		Double ePhnd = datiEner2015.getEph();
//		Double ePhndLimite = datiEner2015.getEphLimite();

		if (ePhnd != null && ePhndLimite != null) {
			double vEPhnd = ePhnd.doubleValue();
			double vEPhndLimite = ePhndLimite.doubleValue();

			if (vEPhnd > 0 && vEPhndLimite >= 0) {
				if (vEPhnd <= (1 * vEPhndLimite)) {
					smile = Constants.ID_SMILE_FELICE;
				} else if (((1 * vEPhndLimite) < vEPhnd)
						&& (vEPhnd <= (1.7 * vEPhndLimite))) {
					smile = Constants.ID_SMILE_SERIO;
				} else if (vEPhnd > (1.7 * vEPhndLimite)) {
					smile = Constants.ID_SMILE_TRISTE;
				}
			}
		}

		return smile;

	}

	public static Integer calcolaSmileEstate(Double asolAsup, Double yie) {

		Integer smile = null;

		if (asolAsup != null && yie != null) {
			double vAsolAsup = asolAsup.doubleValue();
			double vYie = yie.doubleValue();

			if (vAsolAsup >= 0 && vYie >= 0) {
				if ((vAsolAsup <= 0.03) && (vYie <= 0.14)) {
					smile = Constants.ID_SMILE_FELICE;
				} else if (((vAsolAsup <= 0.03) && (vYie > 0.14))
						|| ((vAsolAsup > 0.03) && (vYie <= 0.14))) {
					smile = Constants.ID_SMILE_SERIO;
				} else if ((vAsolAsup > 0.03) && (vYie > 0.14)) {
					smile = Constants.ID_SMILE_TRISTE;
				}
			}
		}
		return smile;

	}
	
	public static Double calcolaRapportoSV(Double superficieDisperdente, Double volLordoRisc) {

		Double rapportoSV = null;

		if (superficieDisperdente != null && volLordoRisc != null && 
				(superficieDisperdente.doubleValue() > 0) && (volLordoRisc.doubleValue() > 0)) {

			rapportoSV = (superficieDisperdente.doubleValue()/volLordoRisc.doubleValue());
		}
		
		return rapportoSV;

	}
	
	
	public static String normalizzaCFFirma(String cfFirma)
	{
		
		if (log.isDebugEnabled())
			log.debug("Stampo cfFirma (prima): "+cfFirma);
		
		if (cfFirma != null && cfFirma.length() > Constants.CODICE_FISCALE_LEN)
		{
			
			cfFirma = cfFirma.substring(cfFirma.length()-Constants.CODICE_FISCALE_LEN);
	
		}
		
		if (log.isDebugEnabled())
			log.debug("Stampo cfFirma (dopo): "+cfFirma);
		
		return cfFirma;
	}

	/**
	 * Ritorna il messaggio con due parametri di sostituzione
	 * 
	 * @param text Testo del messaggio
	 * @param value1 Valore da sostituire
	 */
	public static String formattaMessaggio(String text, String value1) {
		
		text = text.replaceFirst(VALUE_PLACEHOLDER1, value1);

		return text;
	}
	

	/**
	 * Ritorna il messaggio con due parametri di sostituzione
	 * 
	 * @param text Testo del messaggio
	 * @param value1 Valore da sostituire
	 * @param value2 Valore da sostituire
	 */
	public static String formattaMessaggio(String text, String value1, String value2) {
		
		text = text.replaceFirst(VALUE_PLACEHOLDER1, value1);
		text = text.replaceFirst(VALUE_PLACEHOLDER2, value2);

		return text;
	}
	
	public static ArrayList<LabelValueCombo> getComboTipoRicerca()
	{
		LabelValueCombo codDes = new LabelValueCombo();
		
		ArrayList<LabelValueCombo> combo = new ArrayList<LabelValueCombo>();
		
		codDes.setValue(Constants.COD_TIPO_RICERCA_PARZ);
		codDes.setLabel(Constants.DESC_TIPO_RICERCA_PARZ);
		combo.add(codDes);
		
		codDes = new LabelValueCombo();
		codDes.setValue(Constants.COD_TIPO_RICERCA_TOT);
		codDes.setLabel(Constants.DESC_TIPO_RICERCA_TOT);
		combo.add(codDes);
		
		return combo;
		
		
	}
	
	public static String getAceByIdRiga(Integer idRiga, ArrayList<Ace> aceList)
	{
		String numeroCertificato = null;
		
		if (idRiga != null && aceList != null)
		{
			for (Ace ace : aceList) {
				
				if (idRiga.intValue() == ace.getIdRigaTabella().intValue())
				{
					numeroCertificato = ace.getCodice();
				}
			}
		}
		
		return numeroCertificato;
	}
	
	public static String getAttestatoByIdRiga(Integer idRiga, ArrayList<AttestatoSummary> attestatoList)
	{
		String numeroCertificato = null;
		log.debug("########################");

		if (idRiga != null && attestatoList != null)
		{
			log.debug("idRiga - "+idRiga);
			for (AttestatoSummary ace : attestatoList) {
				
				log.debug("getAttestatoByIdRiga - "+ace.getIdRigaTabella());
				
				if (idRiga.intValue() == ace.getIdRigaTabella().intValue())
				{
					numeroCertificato = ace.getCod();
					log.debug("numeroCertificato - "+numeroCertificato);
				}
			}
		}
		log.debug("########################");
		
		return numeroCertificato;
	}
	
	public static boolean isCertificatoPresente(String idCertificato, ArrayList<Ace> aceList) {
		boolean isPresente = false;

		if (idCertificato != null && idCertificato != null) {
			for (Ace ace : aceList) {

				if (idCertificato.equals(ace.getCodice())) {
					isPresente = true;
				}
			}
		}

		return isPresente;
	}
	
	public static String getNomeFile(int tipoDoc, int idDoc, String nomeFile)
	{
		
		return "TIPO"+tipoDoc+"_ID"+idDoc+"_"+nomeFile;
	}
}