/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
/*
 * 
 */
package it.csi.sicee.siceeweb.business.facade;

import it.csi.sicee.siceeweb.dto.type.UDTDateValid;
import it.csi.sicee.siceeweb.dto.type.UDTPositiveDoubleFive;
import it.csi.sicee.siceeweb.dto.type.UDTPositiveDoubleFour;
import it.csi.sicee.siceeweb.dto.type.UDTPositiveDoubleTwo;
import it.csi.sicee.siceeweb.dto.type.UDTPositiveInteger;
import it.csi.sicee.siceeweb.util.Constants;

import java.text.DecimalFormat;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;

// TODO: Auto-generated Javadoc
/**
 * The Class BaseMgr.
 */
public class BaseMgr {
	
	/** The log. */
	protected static Logger log = Logger.getLogger(Constants.APPLICATION_CODE
			+ ".business");

	/** The Constant ONE_YEAR_MILLIS. */
	public static final long ONE_YEAR_MILLIS = 1000 * 60 * 60 * 24 * 365;

	/** The Constant TIPO_CURRICULUM_VITAE. */
	public static final Integer TIPO_CURRICULUM_VITAE = Integer.valueOf(1);

	/** The Constant TIPO_PARTECIPAZ_REGIONALE. */
	public static final Integer TIPO_PARTECIPAZ_REGIONALE = Integer.valueOf(2);

	/** The Constant TIPO_PROFITTO_REGIONALE. */
	public static final Integer TIPO_PROFITTO_REGIONALE = Integer.valueOf(3);

	/** The Constant TIPO_PROFITTO_NAZIONALE. */
	public static final Integer TIPO_PROFITTO_NAZIONALE = Integer.valueOf(4);

	/** The Constant TIPO_ATTESTATO_CORSO. */
	public static final Integer TIPO_ATTESTATO_CORSO = Integer.valueOf(5);

	/** The Constant TITOLO_DI_STUDIO. */
	public static final Integer TITOLO_DI_STUDIO = Integer.valueOf(6);

	
	/**
	 * convertToString.
	 *
	 * @param i the i
	 * @return the string
	 * String
	 */
	public static String convertToString(Boolean i) {
		if (i == null) {
			return null;
		} else {
			if (i) {
				return Constants.SI;
			} else {
				return Constants.NO;
			}
		}

	}

	/**
	 * Convert to string.
	 *
	 * @param i the i
	 * @return the string
	 */
	protected String convertToString(Integer i) {
		if (i == null) {
			return null;
		} else {
			return Integer.toString(i);
		}
	}

	/**
	 * convertToString.
	 *
	 * @param i the i
	 * @return String
	 */
	public static String convertToString(Long i) {
		if (i == null) {
			return null;
		} else {
			return Long.toString(i);
		}
	}

	/**
	 * Convert to string.
	 *
	 * @param i the i
	 * @return the string
	 */
	public static String convertToString(Double i) {
		if (i == null) {
			return null;
		} else {
			return parseNumberFive(i);
		}
	}

	/**
	 * Convert to string.
	 *
	 * @param i the i
	 * @return the string
	 */
	public static String convertToString(Float i) {
		if (i == null) {
			return null;
		} else {
			return Float.toString(i);
		}
	}
	
	
	/**
	 * Convert to double.
	 *
	 * @param s the s
	 * @return the double
	 */
	public static Double convertToDouble(Float s) {
		if (s == null) {
			return null;
		} else {
			try {
				log.debug("Float: "+s);
		        Double d = new Double(s.toString());
		        log.debug("Double: "+d);
		        return d;
			} catch (Exception e) {
				log.error("Float da convertire in Double: " + s);
				return null;
			}
		}
	}
	
	/**
	 * Convert to integer.
	 *
	 * @param udtPS the udt ps
	 * @return the integer
	 */
	public static Integer convertToInteger(UDTPositiveInteger udtPS) {
		if (udtPS == null) {
			return null;
		} else {
			try {
				return udtPS.getValue();
			} catch (Exception e) {
				return null;
			}
		}
	}

	/**
	 * Convert to integer.
	 *
	 * @param udtPS the udt ps
	 * @return the integer
	 */
	public static UDTPositiveInteger convertToUDTPositiveInteger(Integer i) {
		if (i == null) {
			return null;
		} else {
			try {
				return new UDTPositiveInteger(i);
			} catch (Exception e) {
				return null;
			}
		}
	}
	
	/**
	 * Convert to integer.
	 *
	 * @param s the s
	 * @return the integer
	 */
	public static Integer convertToInteger(String s) {
		if (s == null || s.length() == 0) {
			return null;
		} else {
			try {
				return new Integer(Integer.parseInt(s));
			} catch (Exception e) {
				return null;
			}
		}
	}

	/**
	 * Convert to double.
	 *
	 * @param s the s
	 * @return the double
	 */
	public Double convertToDouble(String s) {
		if (s == null || s.length() == 0) {
			return null;
		} else {
			try {
				return new Double(Double.parseDouble(s.replaceAll(",", ".")));
			} catch (Exception e) {
				log.error("Stringa da convertire in Double: " + s);
				return null;
			}
		}
	}

	
	
	/**
	 * Convert to long.
	 *
	 * @param s the s
	 * @return the long
	 */
	public Long convertToLong(String s) {
		if (s == null || s.length() == 0) {
			return null;
		} else {
			try {
				return new Long(Long.parseLong(s));
			} catch (Exception e) {
				return null;
			}
		}
	}

	/**
	 * Convert to long.
	 *
	 * @param s the s
	 * @return the long
	 */
	public Long convertToLong(Double s) {
		if (s == null) {
			return null;
		} else {
			try {
				return s.longValue();
			} catch (Exception e) {
				return null;
			}
		}
	}
	
	/**
	 * Convert to Float.
	 *
	 * @param s the s
	 * @return the Float
	 */
	public Float convertToFloat(Double s) {
		if (s == null) {
			return null;
		} else {
			try {
				return s.floatValue();
			} catch (Exception e) {
				return null;
			}
		}
	}
	/**
	 * Convert to boolean.
	 *
	 * @param s the s
	 * @return the boolean
	 */
	public static Boolean convertToBoolean(String s) {
		if (s == null || s.length() == 0) {
			return null;
		} else {
			try {
				if (s.equalsIgnoreCase(Constants.SI)) {
					return true;
				} else {
					return false;
				}
			} catch (Exception e) {
				return null;
			}
		}
	}

	/**
	 * Instantiates a new base mgr.
	 */
	public BaseMgr() {
		super();
	}

	/**
	 * Checks if is null or empty.
	 *
	 * @param s the s
	 * @return true, if is null or empty
	 */
	public static boolean isNullOrEmpty(String s) {
		return s == null || s.trim().length() == 0;
	}

	/**
	 * Checks if is null or empty.
	 *
	 * @param n the n
	 * @return true, if is null or empty
	 */
	public static boolean isNullOrEmpty(UDTPositiveDoubleFour n) {
		return n == null || n.getValue() == null;
	}

	/**
	 * Checks if is null or empty.
	 *
	 * @param n the n
	 * @return true, if is null or empty
	 */
	public static boolean isNullOrEmpty(UDTPositiveDoubleFive n) {
		return n == null || n.getValue() == null;
	}

	/**
	 * Checks if is null or empty.
	 *
	 * @param n the n
	 * @return true, if is null or empty
	 */
	public static boolean isNullOrEmpty(UDTPositiveInteger n) {
		return n == null || n.getValue() == null;
	}

	/**
	 * Checks if is null or empty.
	 *
	 * @param n the n
	 * @return true, if is null or empty
	 */
	public static boolean isNullOrEmpty(UDTDateValid n) {
		return n == null || n.getValue() == null;
	}

	/**
	 * Checks if is null or empty.
	 *
	 * @param s the s
	 * @return true, if is null or empty
	 */
	public static boolean isNullOrEmpty(Double s) {
		return s == null;
	}

	/**
	 * Checks if is null or empty.
	 *
	 * @param s the s
	 * @return true, if is null or empty
	 */
	public static boolean isNullOrEmpty(Integer s) {
		return s == null;
	}

	/**
	 * Checks if is null or empty.
	 *
	 * @param s the s
	 * @return true, if is null or empty
	 */
	public static boolean isNullOrEmpty(Date s) {
		return s == null;
	}

	/**
	 * Check valide number.
	 *
	 * @param num the num
	 * @return true, if successful
	 */
	public static boolean checkValideNumber(String num) {
		if (!BaseMgr.isNullOrEmpty(num)) {
			if (num.matches("^[+]?\\d*$")) {
				return true;
			} else {
				return false;
			}
		}

		return false;
	}

	/**
	 * Check valide telephone number.
	 *
	 * @param num the num
	 * @return true, if successful
	 */
	public static boolean checkValideTelephoneNumber(String num) {
		return true;
	}

	/**
	 * Check valide email.
	 *
	 * @param email the email
	 * @return true, if successful
	 */
	public static boolean checkValideEmail(String email) {
		if (!BaseMgr.isNullOrEmpty(email)) {
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
	 * Check valide double with five decimal numbers.
	 *
	 * @param num the num
	 * @return true, if successful
	 */
	public static boolean checkValideDoubleWithFiveDecimalNumbers(String num) {
		log.debug("Numero da validare: " + num);
		if (!BaseMgr.isNullOrEmpty(num)) {
			if (num.matches("^(?=.*[0-9].*$)\\d{0,10}(?:\\,\\d{0,5})?$")) {
				log.debug("validato: " + num);
				return true;
			} else {
				return false;
			}
		}

		return false;
	}
	
	
	/**
	 * Check valide double with eight decimal numbers.
	 *
	 * @param num the num
	 * @return true, if successful
	 */
	public static boolean checkValideDoubleWithEightDecimalNumbers(String num) {
		log.debug("Numero da validare: " + num);
		if (!BaseMgr.isNullOrEmpty(num)) {
			if (num.matches("^(?=.*[0-9].*$)\\d{0,10}(?:\\,\\d{0,8})?$")) {
				log.debug("validato: " + num);
				return true;
			} else {
				return false;
			}
		}

		return false;
	}

	/**
	 * Check valide codice fiscale.
	 *
	 * @param email the email
	 * @return true, if successful
	 */
	public static boolean checkValideCF(String cf) {
		if (!BaseMgr.isNullOrEmpty(cf)) {
			if (cf
					.matches("[a-zA-Z]{6}[\\dlmnpqrstuvLMNPQRSTUV]{2}[abcdehlmprstABCDEHLMPRST][\\dlmnpqrstuvLMNPQRSTUV]{2}[a-zA-Z][\\dlmnpqrstuvLMNPQRSTUV]{3}[a-zA-Z]")) {
				return true;
			} else {
				return false;
			}
		}

		return false;
	}

	
	/**
	 * Parses the number for print.
	 *
	 * @param d the d
	 * @return the string
	 */
	protected String parseNumberForPrint(Double d) {
		String str = "";
		DecimalFormat df = new DecimalFormat("############.#####");
		if (d != null) {
			str = df.format(d);
		}

		return str;
	}

	/**
	 * Parses the number five.
	 *
	 * @param d the d
	 * @return the string
	 */
	protected static String parseNumberFive(Double d) {
		String str = "";
		DecimalFormat df = new DecimalFormat("############.######");
		if (d != null) {
			str = df.format(d);
		}

		return str;
	}

	/**
	 * To upper case.
	 *
	 * @param str the str
	 * @return the string
	 */
	protected String toUpperCase(String str) {
		return (str != null) ? str.toUpperCase() : null;
	}

	/**
	 * Convert to.
	 *
	 * @param num the num
	 * @return the double
	 */
	public static Double convertTo(UDTPositiveDoubleFive num) {

		return (num != null) ? num.getValue() : null;
	}

	/**
	 * Convert to.
	 *
	 * @param num the num
	 * @return the double
	 */
	public static Integer convertTo(Long num) {

		return (num != null) ? new Integer(num.intValue()) : null;
	}

	
	/**
	 * Convert to.
	 *
	 * @param num the num
	 * @return the double
	 */
	public static Double convertTo(UDTPositiveDoubleTwo num) {

		return (num != null) ? num.getValue() : null;
	}

	/**
	 * Convert to string.
	 *
	 * @param num the num
	 * @return the string
	 */
	public static String convertToString(UDTPositiveDoubleFive num) {
		java.util.Locale.setDefault(java.util.Locale.ITALY);
		java.text.DecimalFormat df = new java.text.DecimalFormat(
				"##########.#####");

		return (num != null) ? df.format(num.getValue()) : null;
	}

	/**
	 * Convert to string.
	 *
	 * @param num the num
	 * @return the string
	 */
	public static String convertToString(UDTPositiveDoubleTwo num) {
		java.util.Locale.setDefault(java.util.Locale.ITALY);
		java.text.DecimalFormat df = new java.text.DecimalFormat(
				"##########.##");
		return (num != null) ? df.format(num.getValue()) : null;
	}

	/**
	 * Converto to string.
	 *
	 * @param dt the dt
	 * @return the string
	 */
	protected String convertoToString(UDTDateValid dt) {
		if (dt != null) {
			return dt.getValue();
		}

		return null;
	}

	/**
	 * Convert to string.
	 *
	 * @param num the num
	 * @return the string
	 */
	public static String convertToString(UDTPositiveDoubleFour num) {
		java.util.Locale.setDefault(java.util.Locale.ITALY);
		java.text.DecimalFormat df = new java.text.DecimalFormat(
				"##########.####");

		return (num != null) ? df.format(num.getValue()) : null;
	}

	/**
	 * Convert to.
	 *
	 * @param num the num
	 * @return the integer
	 */
	protected Integer convertTo(UDTPositiveInteger num) {

		return (num != null) ? num.getValue() : null;
	}

	/**
	 * Convert to.
	 *
	 * @param num the num
	 * @return the long
	 */
	public static Long convertToLong(Integer num) {

		return (num != null) ? Long.parseLong(num.toString()) : null;
	}

	
	/**
	 * Convert to.
	 *
	 * @param num the num
	 * @return the double
	 */
	public static Double convertTo(UDTPositiveDoubleFour num) {

		return (num != null) ? num.getValue() : null;
	}

	/**
	 * Convert to.
	 *
	 * @param num the num
	 * @return the uDT positive double four
	 */
	public static UDTPositiveDoubleFour convertTo(Double num) {

		return (num != null) ? new UDTPositiveDoubleFour(num) : null;
	}

	/**
	 * Convert to double five.
	 *
	 * @param num the num
	 * @return the uDT positive double five
	 */
	protected UDTPositiveDoubleFive convertToDoubleFive(Double num) {

		return (num != null) ? new UDTPositiveDoubleFive(num) : null;
	}

	/**
	 * Convert to double two.
	 *
	 * @param num the num
	 * @return the uDT positive double two
	 */
	public static UDTPositiveDoubleTwo convertToDoubleTwo(Double num) {

		return (num != null) ? new UDTPositiveDoubleTwo(num) : null;
	}

	
	/**
	 * Convert to.
	 *
	 * @param num the num
	 * @return the uDT positive integer
	 */
	protected UDTPositiveInteger convertTo(Integer num) {

		return (num != null) ? new UDTPositiveInteger(num) : null;
	}

	/**
	 * Checks if is null or empty.
	 *
	 * @param list the list
	 * @return true, if is null or empty
	 */
	public static boolean isNullOrEmpty(List<?> list) {
		if (list == null)
			return true;
		
		return (list != null) ? list.isEmpty() : false;
	}

	/**
	 * Checks if is null or empty.
	 *
	 * @param flag the flag
	 * @return true, if is null or empty
	 */
	public static boolean isNullOrEmpty(Boolean flag) {
		return (flag != null) ? false : true;
	}

	/**
	 * Gets the value not null.
	 *
	 * @param value the value
	 * @return the value not null
	 */
	public static Object getValueNotNull(Object value) {
		return (value != null) ? value : "";
	}

	/**
	 * Convert to string for report.
	 *
	 * @param obj the obj
	 * @return the string
	 */
	public String convertToStringForReport(Object obj) {
		if (obj != null) {
			/*
			 * String className = obj.getClass().getName(); String
			 * valueForReport = String.valueOf(obj); if
			 * (className.indexOf("String") >0 ) return valueForReport;
			 * 
			 * if (valueForReport.indexOf(".") > 0){ valueForReport =
			 * valueForReport.replace(".", ","); if
			 * (valueForReport.endsWith(",0")){ valueForReport =
			 * valueForReport.substring(0, valueForReport.length()-2); } return
			 * valueForReport; } else return valueForReport;
			 */
			return obj.toString();
		} else {
			return "";
		}
	}

	/**
	 * Checks if is null or empty.
	 *
	 * @param obj the obj
	 * @return true, if is null or empty
	 */
	public static boolean isNullOrEmpty(Object obj) {
		if (obj == null) {
			return true;
		}

		return false;
	}
	
	

	/**
	 * Recupera chiave attestato.
	 *
	 * @param idCertificatore the id certificatore
	 * @param numeroAttestato the numero attestato
	 * @return the string[]
	 */
	public static String[] recuperaChiaveAttestato(String idCertificatore,
			String numeroAttestato) {
		String[] split = numeroAttestato.split(" ");

		split[1] = idCertificatore;

		return split;
	}
}