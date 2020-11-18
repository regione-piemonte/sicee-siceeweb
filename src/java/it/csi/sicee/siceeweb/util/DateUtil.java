/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
/*
 * 
 */
package it.csi.sicee.siceeweb.util;

import it.csi.sicee.siceeweb.business.BEException;
import it.csi.sicee.siceeweb.business.facade.BaseMgr;
import it.csi.sicee.siceeweb.dto.type.UDTDateValid;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.apache.log4j.Logger;

// TODO: Auto-generated Javadoc
/**
 * The Class DateUtil.
 */
public class DateUtil {

	private static Logger log = Logger.getLogger(Constants.APPLICATION_CODE + ".util");

	/**
	 * Adds the one year.
	 *
	 * @param base the base
	 * @return the string
	 * @throws BEException the bE exception
	 */
	public static String addOneYear(String base) throws BEException {
		java.util.Date dt_base = convertToDate(base);
		Calendar cal_base = Calendar.getInstance();
		cal_base.setTime(dt_base);
		cal_base.add(Calendar.YEAR, 1);
		java.util.Date dt_after = cal_base.getTime();
		return DateUtil.convertToString(dt_after);
	}

	/**
	 * Adds the one day.
	 *
	 * @param base the base
	 * @return the string
	 * @throws BEException the bE exception
	 */
	public static String addOneDay(String base) throws BEException {
		java.util.Date dt_base = convertToDate(base);
		Calendar cal_base = Calendar.getInstance();
		cal_base.setTime(dt_base);
		cal_base.add(Calendar.DAY_OF_YEAR, 1);
		java.util.Date dt_after = cal_base.getTime();
		return DateUtil.convertToString(dt_after);
	}

	/**
	 * Adds the hour.
	 *
	 * @param base the base
	 * @return the string
	 * @throws BEException the bE exception
	 */
	public static Date addHour(String date, int hour) throws BEException {
		java.util.Date dt_base = convertToDateCompleta(date);
		Calendar cal_base = Calendar.getInstance();
		cal_base.setTime(dt_base);
		cal_base.add(Calendar.HOUR, hour);
		java.util.Date dt_after = cal_base.getTime();
		return dt_after;
	}

	
	/**
	 * Diff date.
	 *
	 * @param date1 the date1
	 * @param date2 the date2
	 * @return true, if successful
	 * @throws BEException the bE exception
	 */
	public static boolean diffDate(String date1, String date2)
			throws BEException {
		java.util.Date dt_base1 = convertToDate(date1);
		java.util.Date dt_base2 = convertToDate(date2);
	
		if (dt_base2 == null) {
			return false;
		}
	
		Calendar cal_base1 = Calendar.getInstance();
		cal_base1.setTime(dt_base1);
	
		Calendar cal_base2 = Calendar.getInstance();
		cal_base2.setTime(dt_base2);
	
		// Get date in milliseconds
		long milisecond1 = cal_base1.getTimeInMillis();
		long milisecond2 = cal_base2.getTimeInMillis();
	
		// Find date difference in milliseconds
		long diffInMSec = milisecond2 - milisecond1;
	
		// Find date difference in days
		// (24 hours 60 minutes 60 seconds 1000 millisecond)
		long diffOfDays = diffInMSec / (24 * 60 * 60 * 1000);
	
		return (diffOfDays >= 0 && diffOfDays <= Constants.NUMBER_OF_DAYS) ? true
				: false;
	}

	public static boolean isScadenzaSuccessivaANumAnni(java.util.Date dtScadenza, java.util.Date dtEmissione, int numberOfYears)
			throws BEException {
	
		if (dtEmissione == null) {
			return false;
		}

		Calendar cal_base2 = Calendar.getInstance();
		cal_base2.setTime(dtEmissione);
		cal_base2.add(Calendar.YEAR, numberOfYears);

		Calendar cal_base1 = Calendar.getInstance();
		cal_base1.setTime(dtScadenza);
	
		// Get date in milliseconds
		long milisecond1 = cal_base1.getTimeInMillis();
		long milisecond2 = cal_base2.getTimeInMillis();
	
		// Find date difference in milliseconds
		long diffInMSec = milisecond2 - milisecond1;
	
		return (diffInMSec < 0) ? true : false;
	}

	public static boolean checkDateOrder(Date dataPrec, Date dataSucc, boolean canBeEqual) {
		try {
			if (dataPrec == null || dataSucc == null) {
				return false;
			}
			int confronto = dataPrec.compareTo(dataSucc);
			
			if (confronto > 0 || (!canBeEqual && confronto == 0)) {
				return false;
			}
//			if (confronto > 0) 
//			{
//				return false;
//			}

		} catch (Exception ex) {
			return false;
		}
		return true;
	}
	
	public static boolean checkDateOrder(String dataPrec, String dataSucc, boolean canBeEqual) {
		try {
			
			Date convertedDatePrec = convertToDate(dataPrec);
			Date convertedDateSucc = convertToDate(dataSucc);

			return checkDateOrder(convertedDatePrec, convertedDateSucc, canBeEqual);
		} catch (Exception ex) {
			return false;
		}
		
	}
	
	
	
	public static boolean checkDateFuture(String dateToCheck) {
		try {
			Date convertedDate = null;
	
			convertedDate = convertToDate(dateToCheck);
			if(convertedDate.getTime() > System.currentTimeMillis()) {
				return false;
			}
		} catch (Exception ex) {
			return false;
		}
		return true;
	}
	
	public static boolean checkValideDate(String date) {
		if (GenericUtil.isNotNullOrEmpty(date)) {
			if (date.matches(Constants.DATA))
				return true;
			else return false;
		}
		
		return false;
	}
	/**
	 * Restituisce l'anno corrente
	 * 
	 */
	public static int getAnnoCorrente(){

		GregorianCalendar calendar = null;

		calendar = new GregorianCalendar();
		calendar.setTime(new Date());
		return calendar.get(Calendar.YEAR);
	}
	
	public static Date getFineAnnoCorrente(){

		return getFineAnno(getAnnoCorrente());
		
		
	}
	
	public static Date getFineAnnoSuccessivo(){

		return getFineAnno(getAnnoCorrente()+1);
	}
/*	
	public static Date getAggiungi10Anni(Date dataInizio)
	{
		
		GregorianCalendar calendar = null;

		calendar = new GregorianCalendar();

		calendar.setTime(dataInizio);
		
		int annoInizio = calendar.get(Calendar.YEAR);

		calendar.set(Calendar.YEAR, annoInizio+10);
		
		Date data = calendar.getTime();
		
		//System.out.println("data: "+data);

		return data;
	}
*/
	
	public static Date getAggiungi10Anni(Date dataInizio)
	{
		log.debug("DateUtil::getAggiungi10Anni START");
		GregorianCalendar calendar = null;
		calendar = new GregorianCalendar();
		
		calendar.setTime(dataInizio);
		int giornoInizio = calendar.get(Calendar.DATE);
		int meseInizio = calendar.get(Calendar.MONTH);
		int annoInizio = calendar.get(Calendar.YEAR);

		calendar = new GregorianCalendar();
		calendar.set(annoInizio+10, meseInizio, giornoInizio);
		//log.debug("calendar: "+calendar);

		Date data = calendar.getTime();
		//log.debug("data: "+data);

		log.debug("DateUtil::getAggiungi10Anni END");
		return data;
	}

	private static Date getFineAnno(int anno)
	{
		log.debug("DateUtil::getFineAnno START");
		GregorianCalendar calendar = null;
		calendar = new GregorianCalendar();
		
		calendar.set(anno, 11, 31);
		//log.debug("calendar: "+calendar);
		
		Date data = calendar.getTime();
		//log.debug("data: "+data);

		log.debug("DateUtil::getFineAnno END");
		return data;
	}
	
	/**
	 * Adds the ten year.
	 *
	 * @param base the base
	 * @return the string
	 * @throws BEException the bE exception
	 */
	public static String addTenYear(String base) throws BEException {
		if (!BaseMgr.isNullOrEmpty(base)) {
			java.util.Date dt_base = convertToDate(base);
			Calendar cal_base = Calendar.getInstance();
			cal_base.setTime(dt_base);
			cal_base.add(Calendar.YEAR, 10);
			java.util.Date dt_after = cal_base.getTime();
			return DateUtil.convertToString(dt_after);
		} else {
			return null;
		}
	}

	/**
	 * Adds the ten year.
	 *
	 * @param base the base
	 * @return the string
	 * @throws BEException the bE exception
	 */
	public static String addTenYear(UDTDateValid base) throws BEException {
		if (!BaseMgr.isNullOrEmpty(base)) {
			java.util.Date dt_base = convertToDate(base);
			Calendar cal_base = Calendar.getInstance();
			cal_base.setTime(dt_base);
			cal_base.add(Calendar.YEAR, 10);
			java.util.Date dt_after = cal_base.getTime();
			return DateUtil.convertToString(dt_after);
		} else {
			return null;
		}
	}

	/**
	 * Convert to string.
	 *
	 * @param dt the dt
	 * @return the string
	 */
	public static String getDataCorrenteFormat() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		return sdf.format(new Date());
	}
	
	/**
	 * Convert to string.
	 *
	 * @param dt the dt
	 * @return the string
	 */
	public static String convertToString(java.util.Date dt) {
		if (dt != null) {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			return sdf.format(dt);
		} else
			return null;
	}
	
	/**
	 * Convert to string.
	 *
	 * @param dt the dt
	 * @return the string
	 */
	public static String convertToStringRevert(java.util.Date dt) {
		if (dt != null) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			return sdf.format(dt);
		} else
			return null;
	}
	
	/**
	 * Convert to string data completa.
	 *
	 * @param dt the dt
	 * @return the string
	 */
	public static String convertToStringDataCompleta(java.util.Date dt) {
		if (dt != null) {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
			return sdf.format(dt);
		} else
			return null;
	}

	public static String convertToStringDataCompletaRevert(java.util.Date dt) {
		if (dt != null) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd_HHmmss");
			return sdf.format(dt);
		} else
			return null;
	}

	/**
	 * Convert to string.
	 *
	 * @param dt the dt
	 * @return the string
	 */
	public static String convertToString(UDTDateValid dt) {
		if (dt != null) {			
			return dt.getValue();
		} else
			return null;
	}

	/**
	 * Gets the anno from udt date valid.
	 *
	 * @param dt the dt
	 * @return the anno from udt date valid
	 */
	public static String getAnnoFromUDTDateValid(UDTDateValid dt) {
		String res = null;
		if (!GenericUtil.isNullOrEmpty(dt)) {
			res = convertToString(dt).substring(6);
		}
		
		return res;
	}

	
	/**
	 * Convert to udt date valid.
	 *
	 * @param dt the dt
	 * @return the uDT date valid
	 */
	public static UDTDateValid convertToUDTDateValid(java.util.Date dt) {
		if (dt != null) {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			UDTDateValid udt = new UDTDateValid();
			udt.setValue(sdf.format(dt));
			return udt;
		} else
			return null;
	}

	/**
	 * Convert to udt date valid.
	 *
	 * @param dt the dt
	 * @return the uDT date valid
	 */
	public static UDTDateValid convertToUDTDateCompletaValid(java.util.Date dt) {
		if (dt != null) {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
			UDTDateValid udt = new UDTDateValid();
			udt.setValue(sdf.format(dt));
			return udt;
		} else
			return null;
	}
	
	/**
	 * Convert to date.
	 *
	 * @param s the s
	 * @return the java.util. date
	 * @throws BEException the bE exception
	 */
	public static java.util.Date convertToDate(String s) throws BEException {
		if (s != null && s.length() > 0) {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			try {
				return sdf.parse(s);
			} catch (ParseException e) {
				throw new BEException("Errore nella parsificazioen della data "
						+ s, e);
			}
		} else
			return null;
	}
	
	/**
	 * Convert to date completa.
	 *
	 * @param s the s
	 * @return the java.util. date
	 * @throws BEException the bE exception
	 */
	public static java.util.Date convertToDateCompleta(String s) throws BEException {
		if (s != null && s.length() > 0) {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
			try {
				return sdf.parse(s);
			} catch (ParseException e) {
				throw new BEException("Errore nella parsificazioen della data "
						+ s, e);
			}
		} else
			return null;
	}

	
	/**
	 * Convert to date.
	 *
	 * @param s the s
	 * @return the java.util. date
	 * @throws BEException the bE exception
	 */
	public static java.util.Date convertToDate(UDTDateValid s) throws BEException {
		if (s != null ) {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			try {
				return sdf.parse(s.getValue());
			} catch (ParseException e) {
				throw new BEException("Errore nella parsificazioen della data "
						+ s, e);
			}
		} else
			return null;
	}

	/**
	 * Convert to date from xml.
	 *
	 * @param s the s
	 * @return the java.util. date
	 * @throws BEException the bE exception
	 */
	public static java.util.Date convertToDateFromXml(String s)
			throws BEException {
		if (s != null && s.length() > 0) {
			try {
				return convertToDate(s);
			} catch (BEException e) {
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				try {
					return sdf.parse(s);
				} catch (ParseException ex) {
					throw new BEException("Errore nella parsificazione della data "
							+ s, ex);
				}
			}
		} else
			return null;
	}

	/**
	 * Convert to timestamp.
	 *
	 * @param s the s
	 * @return the java.sql. timestamp
	 * @throws BEException the bE exception
	 */
	public static java.sql.Timestamp convertToTimestamp(String s)
			throws BEException {
		Timestamp time = null;
		if (s != null && s.length() > 0) {
			time = new Timestamp(new Long(s));
		}

		return time;
	}

	/**
	 * Convert to timestamp.
	 *
	 * @param s the s
	 * @return the java.sql. timestamp
	 * @throws BEException the bE exception
	 */
	public static java.sql.Timestamp convertToTimestamp(Date s)
			throws BEException {
		Timestamp time = null;
		if (s != null) {
			time = new Timestamp(s.getTime());
		}

		return time;
	}

}
