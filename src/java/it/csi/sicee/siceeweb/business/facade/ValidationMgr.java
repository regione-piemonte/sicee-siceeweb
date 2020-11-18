/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceeweb.business.facade;



import it.csi.sicee.siceeweb.business.facade.exceptions.ValidationManagerException;



import it.csi.sicee.siceeweb.dto.pagamenti.DatiPagamentoNew;
import it.csi.sicee.siceeweb.dto.type.UDTPositiveDoubleTwo;
import it.csi.sicee.siceeweb.util.Constants;
import it.csi.sicee.siceeweb.util.Converter;
import it.csi.sicee.siceeweb.util.DateUtil;
import it.csi.sicee.siceeweb.util.GenericUtil;
import it.csi.sicee.siceeweb.util.Messages;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

public class ValidationMgr {
	
	protected static Logger log = Logger.getLogger(Constants.APPLICATION_CODE + ".business.manager");

	
	/**
	 * Manager del DB
	 */
	//protected DbMgr dbMgr;
	
	/**
	 * Restituisce il manager del DB
	 * 
	 * @return Manager del DB
	 */
//	public DbMgr getDbMgr() {
//		return dbMgr;
//	}

	/**
	 * Imposta i manager del DB
	 * 
	 * @param serviziMgr Manager del DB
	 */
//	public void setDbMgr(DbMgr dbMgr) {
//		this.dbMgr = dbMgr;
//	}
	
	/**
	 * @param per il controllo del codice fiscale
	 */
	private static char carattere[] = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H',
		'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U',
		'V', 'W', 'X', 'Y', 'Z', '0', '1', '2', '3', '4', '5', '6', '7',
		'8', '9' };
	private static int valore_pari[] = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11,
		12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 0, 1, 2, 3,
		4, 5, 6, 7, 8, 9 };
	private static int valore_dispari[] = { 1, 0, 5, 7, 9, 13, 15, 17, 19, 21,
		2, 4, 18, 20, 11, 3, 6, 8, 12, 14, 16, 10, 22, 25, 24, 23, 1, 0, 5,
		7, 9, 13, 15, 17, 19, 21 };

	private static final char carattere_di_controllo[] = { 'A', 'B', 'C', 'D',
		'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q',
		'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z' };
	
	
	public void checkSelezioneElemento(String elementoSelezionato) throws ValidationManagerException {

		if (GenericUtil.isNullOrEmpty(elementoSelezionato))
		{
			throw new ValidationManagerException(new Message(Messages.ERROR_SELEZIONARE_VOCE_ELENCO));
		}
	}
	
	public void checkSelezioneElemento(Integer elementoSelezionato) throws ValidationManagerException {

		if (GenericUtil.isNullOrEmpty(elementoSelezionato))
		{
			throw new ValidationManagerException(new Message(Messages.ERROR_SELEZIONARE_VOCE_ELENCO));
		}
		
	}
	
	public void checkSelezioneElemento(ArrayList<Integer> elementiSelezionati) throws ValidationManagerException {

		if (elementiSelezionati == null || elementiSelezionati.size() == 0)
		{
			throw new ValidationManagerException(new Message(Messages.ERROR_SELEZIONARE_VOCE_ELENCO));
		}
		
	}
	
	
	/**
	 * Verifica l'ordine di due date
	 * 
	 * @param dataPrec Data che si presume precedente
	 * @param dataSucc Data che si presume successiva
	 * @param canBeEqual True se le date possono essere uguali, false altrimenti
	 * @param dataPrecField Campo associato alla data precedente
	 * @param dataSuccField Campo associato alla data successiva
	 * @param dataPrecLabel Etichetta associata alla data precedente
	 * @param dataSuccLabel Etichetta associata alla data successiva
	 * @param m Messaggio d'errore da utilizzare
	 * @throws ValidationManagerException La prima data non precede la seconda
	 */
	protected void checkDateOrderMesDataSucc(String dataPrec, String dataSucc, boolean canBeEqual, String dataPrecField, String dataSuccField,
			Message m) throws ValidationManagerException {

		checkDate(dataPrec, dataPrecField);
		checkDate(dataSucc, dataSuccField);
		if(!DateUtil.checkDateOrder(dataPrec, dataSucc, canBeEqual)) {
			
			m.replacePlaceholder(dataSucc);
			
			ValidationManagerException ex = new ValidationManagerException();
			ex.addField(dataPrecField);
			ex.addField(dataSuccField);
			ex.setMsg(m);
			throw ex;
		}
	}
	
	/**
	 * Verifica se un numero e' in formato intero. CHK9
	 * 
	 * @param numeroDaVerificare Numero da verificare
	 * @param numberField Campo associato al nome
	 * @return Numero convertito in intero
	 * @throws ValidationManagerException Il numero non e' informato intero
	 */
	protected void checkNumeroIntero(String numeroDaVerificare, String numberField) throws ValidationManagerException {
		ValidationManagerException ex = null;

		if (GenericUtil.isNotNullOrEmpty(numeroDaVerificare))
		{
				if (!GenericUtil.isValideNumber(numeroDaVerificare))
				{
					ex = new ValidationManagerException();
					ex.addField(numberField, Messages.ERROR_SOLO_NEMERICI_INTERI);
					throw ex;
				}
		}
		
	}
	
	/**
	 * Verifica se un numero e' in formato intero. CHK9
	 * 
	 * @param numeroDaVerificare Numero da verificare
	 * @param numberField Campo associato al nome
	 * @return Numero convertito in intero
	 * @throws ValidationManagerException Il numero non e' informato intero
	 */
	protected void checkNumeroIntero(String numeroDaVerificare, String numberField, int maxLenght) throws ValidationManagerException {
		ValidationManagerException ex = null;
		if (GenericUtil.isNotNullOrEmpty(numeroDaVerificare))
		{
			if (!GenericUtil.isValideMaxLenghtNumber(numeroDaVerificare, maxLenght))
			{
				ex = new ValidationManagerException();
				ex.addField(numberField, Messages.ERROR_SOLO_NEMERICI_INTERI);
				throw ex;
			}
		}

	}
	
	/**
	 * Verifica se un numero e' in formato intero. CHK9
	 * 
	 * @param numeroDaVerificare Numero da verificare
	 * @param numberField Campo associato al nome
	 * @return Numero convertito in intero
	 * @throws ValidationManagerException Il numero non e' informato intero
	 */
	protected void checkNumeroIntero(Integer numeroDaVerificare, String numberField, int maxLenght) throws ValidationManagerException {
//		ValidationManagerException ex = null;
		if (GenericUtil.isNotNullOrEmpty(numeroDaVerificare))
		{
			/*
			if (!GenericUtil.checkValideLenghtNumber(numeroDaVerificare, maxLenght))
			{
				ex = new ValidationManagerException();
				ex.addField(numberField, Messages.S012);
				throw ex;
			}
			*/
		}

	}

	protected void checkNumero(String numeroDaVerificare, String numberField, int maxInteger, int maxDecimal) throws ValidationManagerException {
		ValidationManagerException ex = null;

		if (GenericUtil.isNotNullOrEmpty(numeroDaVerificare))
		{
			// Se il numero ha la virgola, si sostituisce l'eventuale punto con
			// la virgola
			numeroDaVerificare = numeroDaVerificare.replace(",", ".");

			if (!GenericUtil.isNumeroDecimaleValido(numeroDaVerificare, maxInteger, maxDecimal))
			{
				Message message = new Message(Messages.ERROR_NUMERO_NON_CORRETTO);
				message.replacePlaceholder(maxInteger);
				message.replacePlaceholder(maxDecimal);

				ex = new ValidationManagerException();
				ex.addField(numberField, message.getText());
				throw ex;
			}
		}

	}
	
	protected void checkNumero(UDTPositiveDoubleTwo numeroDaVerificare, String numberField, int maxInteger, int maxDecimal) throws ValidationManagerException {
		ValidationManagerException ex = null;
		
		if (GenericUtil.isNotNullOrEmpty(numeroDaVerificare))
		{
			checkNumero(numeroDaVerificare.toString(), numberField, maxInteger, maxDecimal);
			
		}

	}
	
	/**
	 * Verifica se una data rispetta il formato richiesto e se e' valida
	 * 
	 * @param dateToCheck Data da controllare
	 * @param dateField Campo associato alla data
	 * @return Data parsificata
	 * @throws ValidationManagerException Errore durante la verifica
	 */
	public Date checkDate(String dateToCheck, String dateField) throws ValidationManagerException {
		ValidationManagerException ex = null;
		Date dateParsed = null;

		if(!DateUtil.checkValideDate(dateToCheck)) {
				ex = new ValidationManagerException(new Message(Messages.ERROR_FORMALE_DATA));
				ex.addField(dateField);
				throw ex;
		}
		else
		{
			try {
				dateParsed = DateUtil.convertToDate(dateToCheck);
			}
			catch(Exception e) {
				ex = new ValidationManagerException(new Message(Messages.ERROR_FORMALE_DATA));
				ex.addField(dateField);
				throw ex;
			}
		}
		return dateParsed;
	}
	
	
	
	

	
	
	
	/**
	 * Verifica se un codice fiscale e' formalmente valido
	 * 
	 * @param codiceFiscale Il codice fiscale da verificare
	 * @param codiceFiscaleField Campo associato al codice fiscale
	 * @throws ValidationManagerException Il codice fiscale non e' formalmente
	 *             valido
	 */
	
	private void checkCodiceFiscalePartitaIva(String codiceFiscale, String codiceFiscaleField) throws ValidationManagerException {
//		ValidationManagerException ex = null;
		
		if (GenericUtil.isNotNullOrEmpty(codiceFiscale))
		{
			
			if (codiceFiscale.length() == Constants.PARTITA_IVA_LEN)
			{
				controlloPIVA(codiceFiscale, codiceFiscaleField);
			}
			else
			{
				controlloCf(codiceFiscale, codiceFiscaleField);
			}
			
			
//			if(codiceFiscale.length() > Constants.CODICE_FISCALE_LEN) {
//				ex = new ValidationManagerException(new Message(Messages.ERROR_FORMALE_CODICE_FISCALE));
//				ex.addField(codiceFiscaleField);
//				throw ex;
//			}
			
			
		}
	}
	
	
	/**
	 * Verifica se una stringa e' alfanumerica e la lunghezza minima di caratteri
	 * 
	 * @param s La stringa da verificare
	 * @param minLenght La lunghezza minima
	 * @param field Campo associato alla stringa
	 * @throws ValidationManagerException La stringa non e' valida
	 */
	private void checkAlphanumericStringMinLenght(String s, int minLenght, String field) throws ValidationManagerException {
		
		s = GenericUtil.getStringValid(s);;
		if (GenericUtil.isNotNullOrEmpty(s))
		{
			if (!StringUtils.isAlphanumericSpace(s) || s.length() < minLenght) {
				Message message = new Message(Messages.ERROR_LUNGHEZZA_MINIMA);
				message.replacePlaceholder(minLenght);
				ValidationManagerException ex = new ValidationManagerException(message);
				ex.addField(field, message.getText());
				throw ex;
			}
		}
	}

	/**
	 * Verifica se una stringa e' alfanumerica e la lunghezza minima di caratteri
	 * 
	 * @param s La stringa da verificare
	 * @param minLenght La lunghezza minima
	 * @param field Campo associato alla stringa
	 * @throws ValidationManagerException La stringa non e' valida
	 */
	private void checkAlphanumericStringMaxLenght(String s, int maxLenght, String field) throws ValidationManagerException {
		
		log.debug("PASSO 1");
		
		s = GenericUtil.getStringValid(s);;
		
		if (log.isDebugEnabled())
			log.debug("PASSO 2: "+s);

		if (GenericUtil.isNotNullOrEmpty(s))
		{
			if (log.isDebugEnabled())
			{
				log.debug("PASSO 3");
				log.debug("PASSO 3.1 Stampo la lunghezza: "+s.length());
				log.debug("PASSO 3.2 Stampo la StringUtils.isAlphanumericSpace(s): "+StringUtils.isAlphanumericSpace(s));
			}
			
			if(!StringUtils.isAlphanumericSpace(s) || s.length() > maxLenght) {

				log.debug("PASSO 4");

				Message message = new Message(Messages.ERROR_LUNGHEZZA_MASSIMA);
				message.replacePlaceholder(maxLenght);
				ValidationManagerException ex = new ValidationManagerException(message);
				if (field != null)
					ex.addField(field, message.getText());
				throw ex;
			}
		}
	}
	
	/**
	 * Verifica se una stringa e' alfanumerica e la lunghezza minima di caratteri
	 * 
	 * @param s La stringa da verificare
	 * @param minLenght La lunghezza minima
	 * @param field Campo associato alla stringa
	 * @throws ValidationManagerException La stringa non e' valida
	 */
	private void checkStringMaxLenght(String s, int maxLenght, String field) throws ValidationManagerException {
		
		log.debug("PASSO 1");
		
		s = GenericUtil.getStringValid(s);;
		
		if (log.isDebugEnabled())
			log.debug("PASSO 2: "+s);

		if (GenericUtil.isNotNullOrEmpty(s))
		{
			log.debug("PASSO 3");
			log.debug("PASSO 3.1 Stampo la lunghezza: "+s.length());

			if(s.length() > maxLenght) {

				log.debug("PASSO 4");

				Message message = new Message(Messages.ERROR_LUNGHEZZA_MASSIMA);
				message.replacePlaceholder(maxLenght);
				ValidationManagerException ex = new ValidationManagerException(message);
				ex.addField(field, message.getText());
				throw ex;
			}
		}
	}
	
	/**
	 * Verifica se il CAP e' della lunghezza corretta
	 * 
	 * @param cap Il String da verificare
	 * @param field Campo associato alla stringa
	 * @throws ValidationManagerException La stringa non e' un CAP valido
	 */
	private void checkCAP(String cap, String field) throws ValidationManagerException {
		
		log.debug("STAMPO IL CAP: "+cap);
		if(GenericUtil.isNotNullOrEmpty(cap)) {
			
			log.debug("SONO ENTRATO");
			ValidationManagerException ex;
			if (!GenericUtil.isStringValid(cap, Constants.CAP))
			{
				log.debug("ERRORE CAP");
				ex = new ValidationManagerException(new Message(Messages.ERROR_FORMALE_CAP));
				ex.addField(field);
				throw ex;
			}
		}
	}
	
	/**
	 * Verifica la validita' di un intervallo
	 * 
	 * @param from Valore di inizio intervallo
	 * @param to Valore di fine intervallo
	 * @param fromField Campo associato all'inizio dell'intervallo
	 * @param toField Campo associato alla fine dell'intervallo
	 * @throws ValidationManagerException L'intervallo non e' valido
	 */
	private void checkIntervallo(Date from, Date to, String fromField, String toField) throws ValidationManagerException {
		ValidationManagerException ex = null;

		if(from.after(to)) {
			ex = new ValidationManagerException(new Message(Messages.ERROR_RANGE_DATE_NON_SEQUENZA));
			ex.addField(fromField);
			ex.addField(toField);
			throw ex;
		}
	}
	
	public void controlloCf(String codFiscale, String codiceFiscaleField) throws ValidationManagerException{
		ValidationManagerException ex = null;
		char caratt;
		boolean ok = false;
		int controllo = -1;
		int resto;
		int sum_pari = 0;
		int sum_dispari = 0;
		// per l'ulteriore controllo del carattere finale
		int restoTwo = 0;
		String codiceFiscale = null;

		if ((codFiscale != null) && (codFiscale.length() == 16)) {
			codiceFiscale = codFiscale.toUpperCase();
			codFiscale = codFiscale.toUpperCase();
			for (int i = 1; i <= 15; i++) {
				int row;
				caratt = codFiscale.charAt(0);
				codFiscale = codFiscale.substring(1);

				for (row = 1; row <= 36; row++) {
					if (carattere[row - 1] == caratt) {
						if ((i / 2) * 2 == i) {
							sum_pari = sum_pari + valore_pari[row - 1];
							break;
						} else {
							sum_dispari = sum_dispari + valore_dispari[row - 1];
							break;
						}
					}
				}
				// Occorre controllare se l'utente ha inserito caratteri non
				// alfanumerici,
				// perche' in alcuni casi, con probabilita' minima ma non nulla,
				// il metodo
				// potrebbe non restituire il messaggio di errore
				if (row > 36) {
					// Il carattere non corrisponde a nessun valore salvato
					// nell'array
					// 'carattere', per cui viene creato il messaggio di errore
					// e si
					// forza l'uscita dal metodo, per non eseguire altro codice
					// a questo
					// punto inutile
					ex = new ValidationManagerException(new Message(Messages.ERROR_FORMALE_CODICE_FISCALE));
					ex.addField(codiceFiscaleField);
					throw ex;
				}
			}

			resto = (sum_pari + sum_dispari) - ((sum_pari + sum_dispari) / 26)
					* 26;
			caratt = codFiscale.charAt(0);

			for (int row = 1; row <= 36; row++) {
				if (carattere[row - 1] == caratt) {
					controllo = valore_pari[row - 1];
					break;
				}
			}
			/**
			 * ci sono alcuni casi in cui fare affidamemto al controllo di
			 * seguito non e' sufficiente per il corretto controllo del codice
			 * fiscale allora aggiungo io un controllo utilizzando il carattere
			 * di controllo finale del codice fiscale
			 */
			if (controllo == resto)
				ok = true;

			/**
			 * a questo punto visto che questo controllo non e' molto preciso
			 * vado a fare il controllo dell'ultimo carattere ma fuori allora
			 * devo prendere il resto che e' stato trovato precedentemente
			 */
			restoTwo = resto;

			if (ok) {
				/**
				 * agginta di francesca in data 17/01/2006 perche' non funziona il
				 * controllo sopra per il codice fiscale: mrlmfsc97s20c351 faccio
				 * l'ulteriore controllo del carattere finale di controllo
				 */
				
				if (carattere_di_controllo[restoTwo] == codiceFiscale.charAt(15))
					ok = true;
				else
					ok = false;
			}
		}

		if (!ok) {
			ex = new ValidationManagerException(new Message(Messages.ERROR_FORMALE_CODICE_FISCALE));
			ex.addField(codiceFiscaleField);
			throw ex;
		}
	}
	
	
	private void controlloPIVA(String partitaIva, String partitaIvaField) throws ValidationManagerException {
		boolean ok = false;
		int somma = 0;
		ValidationManagerException ex = null;
		if (validateCurrency(partitaIva, partitaIvaField) == null)
			return;

		if ((partitaIva != null) && (partitaIva.length() == 11)) {
			for (int i = 0; i <= 8; i += 2) {
				somma += partitaIva.charAt(i) - '0';
			}

			for (int i = 1; i <= 9; i += 2) {
				int temp = (partitaIva.charAt(i) - '0') * 2;
				if (temp > 9)
					temp -= 9;
				somma += temp;
			}

			if ((10 - somma % 10) % 10 == partitaIva.charAt(10) - '0') {
				ok = true;
			}
		}

		if (!ok)
		{
			ex = new ValidationManagerException(new Message(Messages.ERROR_PARTITA_IVA));
			ex.addField(partitaIvaField);
			throw ex;
		}
	}
	
	
	public Double validateCurrency(String field, String partitaIvaField) throws ValidationManagerException{
		ValidationManagerException ex = null;
		if (field == null || field.length() == 0)
			return null;
		try {
			double value = Double.parseDouble(field);
			return new Double(value);
		} catch (NumberFormatException nfEx) {
			ex = new ValidationManagerException(new Message(Messages.ERROR_SOLO_NUMERICI));
			ex.addField(partitaIvaField);
			throw ex;
		}
	}
	
	/**
	 * Verifica se un valore e' numerico
	 * 
	 * @param number Numero da verificare
	 * @param maxLength Numero massimo di cifre ammesse
	 * @param numberField Campo associato al nome
	 * @return Restituisce il numero convertito in long
	 * @throws ValidationManagerException Il valore non e' un numero
	 */
	protected long checkNumber(String number, int maxLength, String numberField) throws ValidationManagerException {
		ValidationManagerException ex = null;
		long value;

		value = 0;
		if(StringUtils.isNotBlank(number)) {
			
			if(!StringUtils.isNumeric(number)) {
				ex = new ValidationManagerException(new Message(Messages.ERROR_SOLO_NEMERICI_INTERI));
				ex.addField(numberField);
				throw ex;
			}
			checkNumeroIntero(number, numberField);
			if(number.length() > maxLength) {
				ex = new ValidationManagerException(new Message(Messages.ERROR_SOLO_NEMERICI_INTERI));
				ex.addField(numberField);
				throw ex;
			}
			value = new BigDecimal(number).longValue();
			if(value < 0) {
				ex = new ValidationManagerException(new Message(Messages.ERROR_SOLO_NEMERICI_INTERI));
				ex.addField(numberField);
				throw ex;
			}
		}
		
		return value;
	}
	
	protected void isDataFutura(String dateToCheck, String dateField) throws ValidationManagerException {
		ValidationManagerException ex = null;
		Date convertedDate = null;

		convertedDate = checkDate(dateToCheck, dateField);
		if(convertedDate.getTime() > System.currentTimeMillis()) {
			
			ex = new ValidationManagerException(new Message(Messages.ERROR_DATA_FUTURA));
			ex.addField(dateField);
			throw ex;
		}
	}

	
	public void checkEmail(String emailField, String email, ServiziMgr mgr) throws ValidationManagerException {
		ValidationManagerException ex = null;
		
		if (!GenericUtil.isValideEmail(email))
		{
			ex = new ValidationManagerException(new Message(Messages.ERROR_EMAIL_FORMAT));
			ex.addField(emailField);
			throw ex;
		}
	}
	
	
	public void validazioneFormalePagamentoNew(DatiPagamentoNew pagamento) throws ValidationManagerException {
		
		ValidationManagerException validationException = new ValidationManagerException();
		
		boolean check = true;

		if (BaseMgr.isNullOrEmpty(pagamento.getImporto())) {

			validationException.addFieldRequired("appDatadatiPagamentoNew.importo");
		}

		if (BaseMgr.isNullOrEmpty(pagamento.getTipoPersona())) {

			validationException.addFieldRequired(
					"appDatadatiPagamentoNew.tipoPersona");
		}

		if (BaseMgr.isNullOrEmpty(pagamento.getCodiceFiscale())) {
			validationException.addFieldRequired(
					"appDatadatiPagamentoNew.codiceFiscale");
		}

		if (BaseMgr.isNullOrEmpty(pagamento.getAnagraficaVersante())) {
			validationException.addFieldRequired(
					"appDatadatiPagamentoNew.anagraficaVersante");
		}

		if(!validationException.getFieldList().isEmpty()){
			throw validationException;	
		}
		
		checkCodiceFiscalePartitaIva(pagamento.getCodiceFiscale(), "appDatadatiPagamentoNew.codiceFiscale");

		checkNumero(pagamento.getImporto(), "appDatadatiPagamentoNew.importo", 3, 2);

		if (BaseMgr.convertTo(pagamento.getImporto()).doubleValue() <= 0)
		{
			validationException = new ValidationManagerException();
			validationException.addField("appDatadatiPagamentoNew.importo", Messages.ERROR_NUMERO_NON_VALIDO);

//			validationException = new ValidationManagerException(new Message(Messages.ERROR_NUMERO_NON_VALIDO));
//			validationException.addField("appDatadatiPagamentoNew.importo");
			throw validationException;
		}
		
		/*
		if (!GenericUtil.isNumeroDecimaleValidoMaxDec(pagamento.getImporto().getValue(), Constants.NUMERO_DECIMALI)) {
			
			validationException = new ValidationManagerException(new Message(Messages.ERROR_DECIMALI_NON_CORRETTI));
			validationException.addField("appDatadatiPagamentoNew.importo");
			throw validationException;
		}
		*/

	}
	

	
	public static void main(String[] args) throws Exception {
		
		
	}
}

