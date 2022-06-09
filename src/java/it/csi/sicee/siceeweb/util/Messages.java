/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
/*
 * 
 */
package it.csi.sicee.siceeweb.util;


/**
 * The Class Messages.
 */
public class Messages {

	// Classe che contieni le costanti MESSAGGI
	public final static String ERROR_FIELD_FORMAL_ERROR = "campo non corretto";

	public static final String ERROR_RECUPERO_DB = "Errore durante il recupero dei dati. Contattare l'amministratore di sistema";
	public static final String ERROR_UPDATE_DB = "Errore durante l'aggiornamento dei dati. Contattare l'amministratore di sistema";
	public static final String ERROR_RECUPERO_SERVIZIO = "Errore durante il recupero dei dati dal servizio. Contattare l'amministratore di sistema";
	public static final String INFO_SALVATAGGIO_CORRETTO = "il salvataggio e' avvenuto correttamente";
	public static final String ERROR_INVIARE_MAIL_ASSISTENZA = "L'inserimento delle informazione e' avvenuto correttamente. La procedura SIPEE rimarra' sospesa fino alla verifica delle informazioni trasmesse.<BR>Per velocizzare la riattivazione, si consiglia di comunicare l'avvenuto inserimento delle informazioni scrivendo ad assistenza.energia@csi.it";

	public final static String ERROR_CAMPO_ABBIGATORIO = "il campo e' obbligatorio";
	public final static String ERROR_SELEZIONARE_VOCE_ELENCO	= "selezionare una voce dall'elenco";
	public final static String ERROR_NUMERO_NON_CORRETTO = "ammette massimo ##value## interi e ##value## decimali";
	public final static String ERROR_DECIMALI_NON_CORRETTI = "ammette al massimo 2 decimali";
	public final static String ERROR_FORMALE_DATA = "data formalmente errata";

	public static final String ERROR_BLOCCO_CERTIFICATORE_RADIATO = "ATTENZIONE! L'utilizzo della procedura e' al momento sospesa a causa di cancellazione/radiazione dall'albo professionale di appartenenza. E' stata inviata una mail di chiarimento all'indirizzo email indicato in dati registrazione.";
  	public static final String ERROR_BLOCCO_CERTIFICATORE_ASSENZA_TITOLO_STUDIO = "ATTENZIONE! L'utilizzo della procedura e' al momento sospesa a causa del mancato caricamento del titolo di studio in SIPEE. E' stata inviata una mail di chiarimento all'indirizzo email indicato in dati registrazione.";
  	public static final String ERROR_BLOCCO_CERTIFICATORE_FALSE_DICHIARAZIONI = "ATTENZIONE! L'utilizzo della procedura e' al momento sospesa a causa di 'Dichiarazioni false e/o Mendaci'. E' stata inviata una mail di chiarimento all'indirizzo email indicato in dati registrazione.";
  	public static final String ERROR_BLOCCO_CERTIFICATORE_ASSENZA_CORSO = "ATTENZIONE! L'utilizzo della procedura e' al momento sospesa a causa del mancato caricamento in SIPEE delle informazioni inerenti la partecipazione al corso di formazione e/o aggiornamento e relativo attestato. E' stata inviata una mail di chiarimento all'indirizzo email indicato in dati registrazione.";
  	public static final String ERROR_BLOCCO_CERTIFICATORE_MANCANZA_INFORMAZIONI = "ATTENZIONE! L'utilizzo della procedura e' al momento sospesa a causa del mancato caricamento /aggiornamento in SIPEE delle informazioni. E' stata inviata una mail di chiarimento all'indirizzo email indicato in dati registrazione.";
  	public static final String ERROR_BLOCCO_CERTIFICATORE_MANCANZA_GENERICA = "ATTENZIONE! L'utilizzo della procedura e' al momento sospesa. E' stata inviata una mail di chiarimento all'indirizzo email indicato in dati registrazione";

  	public static final String ERROR_CREDITO_INSUFFICIENTE = "ATTENZIONE! Il credito disponibile (##value1##&euro;) e' insufficiente per procedere con la richiesta effettuata (importo minimo ##value2##&euro;)";
  	public static final String ERROR_MDP = "ATTENZIONE! Si e' verificato un problema tecnico, si prega di contattare l'assistenza";
  	
  	public static final String ERROR_ISCRIZIONE_ANNUALE_NON_NEC = "ATTENZIONE! l'iscrizione annuale non e' necessaria";
  	
	public final static String ERROR_LUNGHEZZA = "il campo deve essere di ##value## caratteri";
	public final static String ERROR_LUNGHEZZA_MINIMA = "il campo accetta minimo ##value## caratteri alfanumerici";
	public final static String ERROR_LUNGHEZZA_MASSIMA = "il campo accetta massimo ##value## caratteri alfanumerici";

	public final static String ERROR_FORMALE_CAP = "CAP formalmente errato";
	public final static String ERROR_FORMALE_CODICE_FISCALE = "codice fiscale formalmente errato";
	public final static String ERROR_PARTITA_IVA = "partita iva formalmente errata";
	public final static String ERROR_SOLO_NUMERICI = "il campo deve essere numerico";
	public final static String ERROR_SOLO_NEMERICI_INTERI = "indicare un valore numerico intero";
	public final static String ERROR_NUMERO_NON_VALIDO = "indicare un valore valido";

	public final static String ERROR_DATA_FUTURA = "non e' possibile inserire una data futura";
	public final static String ERROR_EMAIL_FORMAT= "indirizzo e-mail formalmente non corretto";

	public final static String ERROR_RANGE_DATE_NON_SEQUENZA = "Il range indicato non e' in sequenza";
	
	public static final String ERROR_DATA_SOPRALLUOGO_NON_VALIDA = "Indicare una data di sopralluogo valida";
	public static final String ERROR_DATA_SOPRALLUOGO_MANCANTE = "Occorre inserire la data in cui è avvenuto il sopralluogo";
	public static final String ERROR_CARICAMENTO_FOTO = "Errore durante il caricamento della foto";
	public static final String ERROR_ELIMINAZIONE_FOTO = "Errore durante l'eliminazione della foto";
	public static final String ERROR_VALIDAZIONE_FOTO = "Errore durante la validazione della foto";

}
