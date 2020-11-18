package it.csi.sicee.siceeweb.util;

/**
 * <p>Classe delle costanti applicative.</p>
 *
 * @author GuiGen
 */
public final class Constants {
	/**
	 * identificativo dell'applicativo.
	 */
	public static final String APPLICATION_CODE = "siceeweb";

	/**
	 * nome dell'attributo di sessione in cui viene memorizzato il valore corrente del
	 * captcha 
	 */
	public static final String CAPTCHA_SESSION_NAME = "current_captcha_value";

	/*PROTECTED REGION ID(R1581691183) ENABLED START*/
	// Add here your constants
	/** The rb. */
	private static java.util.ResourceBundle rb = java.util.ResourceBundle.getBundle("/META-INF/siceeweb");

	/** The siceews tenant username. */
	public static final String WS_SICEEWS_URL = rb.getString("siceeweb.siceews.url");

	/** The mdp id app. */
	public static String MDP_ID_APP = rb.getString("mdp.application.id");

	/** The formatter data web. */
	public static java.text.SimpleDateFormat FORMATTER_DATA_WEB = new java.text.SimpleDateFormat("dd/MM/yyyy");

	/** The formatter data completa web. */
	public static java.text.SimpleDateFormat FORMATTER_DATA_COMPLETA_WEB = new java.text.SimpleDateFormat(
			"dd/MM/yyyy HH:mm:ss");

	/** The formatter anno web. */
	public static java.text.SimpleDateFormat FORMATTER_ANNO_WEB = new java.text.SimpleDateFormat("yyyy");

	/** The Constant EDIFICIO_RESIDENZIALE. */
	public static final String EDIFICIO_RESIDENZIALE = "R";

	/** The Constant EDIFICIO_NON_RESIDENZIALE. */
	public static final String EDIFICIO_NON_RESIDENZIALE = "N";

	/** The Constant ISTAT_TORINO. */
	public static final String ISTAT_TORINO = "001272";

	/** The Constant ISTAT_TORINO. */
	public static final String DESC_NAZIONE_ITALIA = "IT";

	/** The Constant CERTIFICATI_FIRMATI_AMMESSI. */
	public static final String CERTIFICATI_FIRMATI_AMMESSI = "CERTIFICATI_FIRMATI_AMMESSI";

	/** The Constant FORMATI_IMMAGINI_AMMESSI. */
	public static final String FORMATI_IMMAGINI_AMMESSI = "FORMATI_IMMAGINI_AMMESSI";

	/** The Constant FOTO_ABILITATA. */
	public static final String FOTO_ABILITATA = "FOTO_ABILITATA";

	/** The Constant IMPORT_XML. */
	public static final String IMPORT_XML = "PULSANTE_IMPORTA";

	/** The Constant URL_XSD. */
	public static final String URL_XSD = "URL_XSD";

	public static final String SCHEMA_URL = "schemaorg_apache_xmlbeans/src/src/adobe/Schemas/";
	public static final String APE_2015_COMPLETO = SCHEMA_URL + "APE2015completo-schema-v5.0.0.xsd";
	public static final String IMAGES_URL = "img/attestato2015/";

	/** The Constant NUMBER_OF_DAYS. */
	public static final long NUMBER_OF_DAYS = 30;

	/** The Constant ID_RICERCA_ACE_OLD. */
	public static final int ID_RICERCA_ACE_OLD = 1;

	/** The Constant ID_RICERCA_ACE_NEW. */
	public static final int ID_RICERCA_ACE_NEW = 2;

	/** The numero max ace trattamento. */
	public static String NUMERO_MAX_ACE_TRATTAMENTO = "NUMERO_MAX_ACE_TRATTAMENTO";

	/** The Constant VERIFICA_OK. */
	public static final Integer VERIFICA_OK = 1;

	/** The Constant VERIFICA_KO. */
	public static final Integer VERIFICA_KO = 2;

	/** The Constant VERIFICA_NON_COMPLETA. */
	public static final Integer VERIFICA_NON_COMPLETA = 3;

	public static final int NUMERO_DECIMALI = 2;

	/**
	 * Lunghezza di una partita IVA
	 */
	public static final int PARTITA_IVA_LEN = 11;
	/**
	 * Espressione regolare per la partita IVA
	 */
	public static final String PARTITA_IVA = "[0-9]{11}";

	/**
	 * Espressione regolare per la data
	 */
	public static final String DATA = "^(((0[1-9]|[12]\\d|3[01])\\/(0[13578]|1[02])\\/((1[6-9]|[2-9]\\d)\\d{2}))|((0[1-9]|[12]\\d|30)\\/(0[13456789]|1[012])\\/((1[6-9]|[2-9]\\d)\\d{2}))|((0[1-9]|1\\d|2[0-8])\\/02\\/((1[6-9]|[2-9]\\d)\\d{2}))|(29\\/02\\/((1[6-9]|[2-9]\\d)(0[48]|[2468][048]|[13579][26])|((16|[2468][048]|[3579][26])00))))$";

	/**
	 * Lunghezza di un codice fiscale
	 */
	public static final int CODICE_FISCALE_LEN = 16;

	/**
	 * Espressione regolare per il CAP
	 */
	public static final String CAP = "[0-9]{5}";

	/** The Constant ERROR_CODE_91. */
	public static final String ERROR_CODE_91 = "ERROR_CODE_91";

	/** The Constant ERROR_CODE_92. */
	public static final String ERROR_CODE_92 = "ERROR_CODE_92";

	/** The Constant ERROR_CODE_93. */
	public static final String ERROR_CODE_93 = "ERROR_CODE_93";

	/** The Constant ERROR_CODE_0. */
	public static final String ERROR_CODE_0 = "ERROR_CODE_0";

	/** The Constant ERROR_CODE_1. */
	public static final String ERROR_CODE_1 = "ERROR_CODE_1";

	/** The Constant ERROR_CODE_2. */
	public static final String ERROR_CODE_2 = "ERROR_CODE_2";

	/** The Constant ERROR_CODE_3. */
	public static final String ERROR_CODE_3 = "ERROR_CODE_3";

	/** The Constant ERROR_CODE_4. */
	public static final String ERROR_CODE_4 = "ERROR_CODE_4";

	/** The Constant ERROR_CODE_5. */
	public static final String ERROR_CODE_5 = "ERROR_CODE_5";

	/** The Constant ERROR_CODE_6. */
	public static final String ERROR_CODE_6 = "ERROR_CODE_6";

	/** The Constant ERROR_CODE_7. */
	public static final String ERROR_CODE_7 = "ERROR_CODE_7";

	/** The Constant KO_SIGNANDCERT_1. */
	public static final String KO_SIGNANDCERT_1 = "KO_SIGNANDCERT_1";

	/** The Constant KO_SIGNANDCERT_2. */
	public static final String KO_SIGNANDCERT_2 = "KO_SIGNANDCERT_2";

	/** The Constant KO_SIGNANDCERT_3. */
	public static final String KO_SIGNANDCERT_3 = "KO_SIGNANDCERT_3";

	/** The Constant KO_SIGNANDCERT_400. */
	public static final String KO_SIGNANDCERT_400 = "KO_SIGNANDCERT_400";

	/** The numero minimo id certificatore. */
	public static String NUMERO_MINIMO_ID_CERTIFICATORE = "NUMERO_MINIMO_ID_CERTIFICATORE";

	/** The data inizio sostituzione. */
	public static String DATA_INIZIO_SOSTITUZIONE = "DATA_INIZIO_SOSTITUZIONE";

	/** The numero max ace sostituzione. */
	public static String NUMERO_MAX_ACE_SOSTITUZIONE = "NUMERO_MAX_ACE_SOSTITUZIONE";

	/** The anno min costruzione. */
	public static String ANNO_MIN_COSTRUZIONE = "ANNO_MIN_COSTRUZIONE";

	/** The ora verifica mail. */
	public static String ORE_VERIFICA_EMAIL = "ORE_VERIFICA_EMAIL";

	/** The testo verifica mail. */
	public static String TESTO_VERIFICA_EMAIL = "TESTO_VERIFICA_EMAIL";

	/** The Constant ERROR_CODE_INDEX. */
	public static final String ERROR_CODE_INDEX = "ERROR_CODE_INEX";

	/** The Constant ERROR_CODE_FIRMA. */
	public static final String ERROR_CODE_FIRMA_CERT = "ERROR_CODE_FIRMA_CERT";

	/** The Constant ERROR_CODE_FIRMA. */
	public static final String ERROR_CODE_FIRMA_COCERT = "ERROR_CODE_FIRMA_COCERT";

	/** The Constant TIPOLOGIA_ALLEGATO_ACE. */
	public static final String TIPOLOGIA_ALLEGATO_ACE = "CERTIFICATO";
	public static final String TIPOLOGIA_ALLEGATO_ACE_NEW = "CERTIFICATO_NEW";

	/** The Constant TIPOLOGIA_TARGHETTA_ACE. */
	public static final String TIPOLOGIA_TARGHETTA_ACE = "TARGHETTA";

	/** The Constant TIPOLOGIA_ALLEGATO_IMG. */
	public static final String TIPOLOGIA_ALLEGATO_IMG = "IMMAGINE";

	/** The Constant TIPOLOGIA_ALLEGATO_XML */
	public static final String TIPOLOGIA_ALLEGATO_XML = "XML";

	/** The Constant TIPOLOGIA_ALLEGATO_CV. */
	public static final String TIPOLOGIA_ALLEGATO_CV = "CURRICULUM_VITAE";

	/** The Constant TIPOLOGIA_ALLEGATO_PARTECIPAZ_REGIONALE. */
	public static final String TIPOLOGIA_ALLEGATO_PARTECIPAZ_REGIONALE = "PARTECIPAZ_REGIONALE";

	/** The Constant TIPOLOGIA_ALLEGATO_PROFITTO_REGIONALE. */
	public static final String TIPOLOGIA_ALLEGATO_PROFITTO_REGIONALE = "PROFITTO_REGIONALE";

	/** The Constant TIPOLOGIA_ALLEGATO_PROFITTO_NAZIONALE. */
	public static final String TIPOLOGIA_ALLEGATO_PROFITTO_NAZIONALE = "PROFITTO_NAZIONALE";

	/** The Constant TIPOLOGIA_ATTESTATO_CORSO. */
	public static final String TIPOLOGIA_ATTESTATO_CORSO = "ATTESTATO_CORSO";

	/** The Constant TIPOLOGIA_TITOLO_DI_STUDIO. */
	public static final String TIPOLOGIA_TITOLO_DI_STUDIO = "TITOLO_DI_STUDIO";

	public static final String ESITO_SUPERATO = "SUPERATO";
	public static final String ESITO_SUPERATO_DESC = "Superato";
	public static final String ESITO_SUPERATO_SESS_SUCC = "SUPERATO_SESS_SUCC";
	public static final String ESITO_SUPERATO_SESS_SUCC_DESC = "Superato in sessione successiva";
	public static final String ESITO_RESPINTO = "RESPINTO";
	public static final String ESITO_RESPINTO_DESC = "Respinto";

	/** The Constant VALIDAZIONE-1. */
	public static final int VALIDAZIONE_1 = 1;
	/** The Constant VALIDAZIONE-2. */
	public static final int VALIDAZIONE_2 = 2;
	/** The Constant VALIDAZIONE-3. */
	public static final int VALIDAZIONE_3 = 3;
	/** The Constant VALIDAZIONE-3. */
	public static final int VALIDAZIONE_4 = 4;

	/** The Constant EDIFICI_ADIBITI_A_RESIDENZA. */
	public static final String EDIFICI_ADIBITI_A_RESIDENZA = "E1";

	/** The Constant ID_DEST_USO_E1_1. */
	public static final int ID_DEST_USO_E1_1 = 2;

	/** The Constant ID_DEST_USO_E1_2. */
	public static final int ID_DEST_USO_E1_2 = 3;

	/** The Constant NUOVO. */
	public static final int NUOVO = 0;

	/** The Constant BOZZA. */
	public static final int BOZZA = 1;

	/** The Constant CONSOLIDATO. */
	public static final int CONSOLIDATO = 2;

	/** The Constant INVIATO. */
	public static final int INVIATO = 3;

	/** The Constant ANNULLATO. */
	public static final int ANNULLATO = 4;

	/** The Constant DA_INVIARE. */
	public static final int DA_INVIARE = 5;

	/** The Constant SOSPESO. */
	public static final int SOSPESO = 6;

	/** The Constant CANCELLATO. */
	public static final int CANCELLATO = 7;

	/** The Constant ANNULLATO_BO. */
	public static final int ANNULLATO_BO = 8;

	// E' un codice convenzionale non inserito sul DB, mi serve per creare la query
	/** The Constant INVIATO_ANNULLATO. */
	public static final int INVIATO_ANNULLATO = 99;

	/** The Constant DESC_STATO_INVIATO. */
	public static final String DESC_STATO_INVIATO = "Inviato";

	/** The Constant ID_TIPO_AZIONE_INVIO. */
	public static final long ID_TIPO_AZIONE_INVIO = 1;

	/** The Constant ID_TIPO_AZIONE_CANCELLAZIONE. */
	public static final long ID_TIPO_AZIONE_ANNULLAMENTO = 2;

	/** The Constant ID_ANNUL_ERRORI_MATERIALI. */
	public static final int ID_ANNUL_ERRORI_MATERIALI = 1;

	/** The Constant ID_ANNUL_RISTRUTTURAZIONI. */
	public static final int ID_ANNUL_RISTRUTTURAZIONI = 2;

	/** The Constant ID_ANNUL_RIQUALIFICAZIONE. */
	public static final int ID_ANNUL_RIQUALIFICAZIONE = 3;

	/** The Constant ID_ANNUL_FRAZIONAMENTO. */
	public static final int ID_ANNUL_FRAZIONAMENTO = 4;

	/** The Constant ID_ANNUL_ACCORPAMENTO. */
	public static final int ID_ANNUL_ACCORPAMENTO = 5;

	/** The Constant W3C_XML_SCHEMA_NS_URI. */
	public static final String W3C_XML_SCHEMA_NS_URI = "http://www.w3.org/2001/XMLSchema";

	/** The Constant OGGETTO_MAIL_XML. */
	public static final String OGGETTO_MAIL_XML = "OGGETTO_MAIL_XML";

	/** The Constant TESTO_MAIL_XML_TXT. */
	public static final String TESTO_MAIL_XML_TXT = "TESTO_MAIL_XML_TXT";

	/** The Constant TESTO_MAIL_XML_HTML. */
	public static final String TESTO_MAIL_XML_HTML = "TESTO_MAIL_XML_HTML";

	/** The Constant EMAIL_XML. */
	public static final String EMAIL_XML = "EMAIL_XML";

	/** The Constant CARRIAGE_RETURN. */
	public static final String CARRIAGE_RETURN = "@cr@";

	/** The Constant CODICE_ACE. */
	public static final String CODICE_ACE = "@codice.ace@";

	/** The Constant COGNOME_CERTIFICATORE. */
	public static final String COGNOME_CERTIFICATORE = "@cognome.certificatore@";

	/** The Constant NOME_CERTIFICATORE. */
	public static final String NOME_CERTIFICATORE = "@nome.certificatore@";

	/** The Constant DATA_INVIO. */
	public static final String DATA_INVIO = "@data@";

	/** The Constant LISTA_ERRORI. */
	public static final String LISTA_ERRORI = "@lista errori@";

	/** The Constant OGGETTO_MAIL_SOSTITUZIONE. */
	public static final String OGGETTO_MAIL_SOSTITUZIONE = "OGGETTO_MAIL_SOSTITUZIONE";

	/** The Constant TESTO_MAIL_SOSTITUZIONE_TXT. */
	public static final String TESTO_MAIL_SOSTITUZIONE_TXT = "TESTO_MAIL_SOSTITUZIONE_TXT";

	/** The Constant TESTO_MAIL_SOSTITUZIONE_HTML. */
	public static final String TESTO_MAIL_SOSTITUZIONE_HTML = "TESTO_MAIL_SOSTITUZIONE_HTML";

	/** The Constant MITTENTE_MAIL_SOSTITUZIONE. */
	public static final String MITTENTE_MAIL_SOSTITUZIONE = "MITTENTE_MAIL_SOSTITUZIONE";

	/** The Constant CODICE_ACE_OLD. */
	public static final String CODICE_ACE_OLD = "@codice.ace.old@";

	/** The Constant CODICE_ACE_NEW. */
	public static final String CODICE_ACE_NEW = "@codice.ace.new@";

	/** The Constant MOTIVAZIONE. */
	public static final String MOTIVAZIONE = "@motivazione@";

	/** The Constant NOTE. */
	public static final String NOTE = "@note@";

	/** The Constant OGGETTO_MAIL_SOSTITUZIONE. */
	public static final String OGGETTO_MAIL_VERIFICA = "OGGETTO_MAIL_VERIFICA";

	/** The Constant TESTO_MAIL_SOSTITUZIONE_TXT. */
	public static final String TESTO_MAIL_VERIFICA_TXT = "TESTO_MAIL_VERIFICA_TXT";

	/** The Constant TESTO_MAIL_SOSTITUZIONE_HTML. */
	public static final String TESTO_MAIL_VERIFICA_HTML = "TESTO_MAIL_VERIFICA_HTML";

	/** The Constant MITTENTE_MAIL_SOSTITUZIONE. */
	public static final String MITTENTE_MAIL_VERIFICA = "MITTENTE_MAIL_VERIFICA";

	/** The Constant LINK_MAIL. */
	public static final String LINK_MAIL = "@link.email@";

	/** The Constant LINK_MAIL. */
	public static final String LINK_SCADENZA = "@scadenza_link@";

	/** The Constant PASSPHRASE. */
	public static final String PASSPHRASE = "PassPhrase";

	/** The Constant URL_MAIL_VERIFICA. */
	public static final String URL_MAIL_VERIFICA = "URL_MAIL_VERIFICA";

	/** The Constant TOTALE_ORE_ESAME. */
	public static final String TOTALE_ORE_ESAME = "TOTALE_ORE_ESAME";

	/** The Constant DATA_ESAME. */
	public static final String DATA_ESAME = "DATA_ESAME";

	/** The Constant SERVIZI_ENERGETICI_INCLUSI. */
	public static final String SERVIZI_ENERGETICI_INCLUSI = "Riscaldamento e acqua calda sanitaria";

	/** The Constant SIGLA_CORSO_OBBLIGATORIO. */
	public static final String SIGLA_CORSO_OBBLIGATORIO = "3";

	/** The Constant CLASSE_ENERGETICA_APIU. */
	public static final String CLASSE_ENERGETICA_APIU = "1";

	/** The mail host. */
	public static String MAIL_HOST = rb.getString("mail.host");

	/** The mail port. */
	public static String MAIL_PORT = rb.getString("mail.port");

	/** The mail mitt xml. */
	public static String MAIL_MITT_XML = "MITTENTE_EMAIL_XML";

	/** The si. */
	public static String SI = "S";

	/** The no. */
	public static String NO = "N";

	/** The label si. */
	public static String LABEL_SI = "Si";

	/** The label no. */
	public static String LABEL_NO = "No";

	/** The Constant LIMITE_NORMATIVO_MINIMO. */
	public static final double LIMITE_NORMATIVO_MINIMO = 0.77d;

	/** The Constant LIMITE_NORMATIVO_MASSIMO. */
	public static final double LIMITE_NORMATIVO_MASSIMO = 0.86d;

	/** The Constant ERROR_CODE_XML_1. */
	public static final String ERROR_CODE_XML_1 = "Caricamento file XML non avvenuto correttamente.";

	/** The Constant ERROR_CODE_XML_2. */
	public static final String ERROR_CODE_XML_2 = "E' stata notificata una mail al servizio SICEE contenente tutte le informazioni riguardanti gli errori del documento inviato. Sarete contattati al più presto.";

	/** The Constant ERROR_CODE_XML_3. */
	public static final String ERROR_CODE_XML_3 = "E' necessario verificare l'XML.";

	/** The Constant ERROR_CODE_XML_4. */
	public static final String ERROR_CODE_XML_4 = "Attenzione! La versione dell'xml non e' aggiornata. Si prega di contattare la software house.";

	/** The Constant PROGETTISTA. */
	public static final Integer PROGETTISTA = 1;

	/** The Constant DIRETTORE_LAVORI. */
	public static final Integer DIRETTORE_LAVORI = 2;

	/** The Constant COSTRUTTORE. */
	public static final Integer COSTRUTTORE = 3;

	/** The Constant ID_TIPO_IMP_AUTONOMO. */
	public static final Integer ID_TIPO_IMP_AUTONOMO = 1;

	/** The Constant ID_TIPO_IMP_CENTRALIZZATO. */
	public static final Integer ID_TIPO_IMP_CENTRALIZZATO = 2;

	/** The Constant ID_TIPO_IMP_NON_PRESENTE. */
	public static final Integer ID_TIPO_IMP_NON_PRESENTE = 3;

	/** The Constant PROVENIENZA_RICERCA_ACE. */
	public static final String PROVENIENZA_RICERCA_ACE = "RicercaACE";

	/** The Constant COD_REGIONE_PIEMONTE. */
	public static final String COD_REGIONE_PIEMONTE = "01";

	/** The Constant COD_REGIONE_PIEMONTE. */
	public static final String DESC_REGIONE_PIEMONTE = "PIEMONTE";

	/** The Constant IMAGE_HOME_WIDTH. */
	public static final float IMAGE_HOME_WIDTH = 215f;

	/** The Constant IMAGE_HOME_HEIGHT. */
	public static final float IMAGE_HOME_HEIGHT = 84f;

	/** The Constant IMAGE_HOME_Y. */
	public static final float IMAGE_HOME_Y = 540f;

	/** The Constant IMAGE_HOME_X. */
	public static final float IMAGE_HOME_X = 69f;

	/** The Constant IMAGE_HOME_CENTER_X. */
	public static final float IMAGE_HOME_CENTER_X = Constants.IMAGE_HOME_X + (((int) IMAGE_HOME_WIDTH) >> 1);

	/** The Constant FIRMA_PDF. */
	public static final String FIRMA_PDF = "FIRMA_PDF";

	//public static final int NUMERO_MASSIMO_DATI_CATASTALI = 20;

	/** The Constant IMAGE_SIZE. */
	public static final long IMAGE_SIZE = 512000;

	public static final int IMAGE_WIDTH_HEIGHT_MAX = 500;

	/** The Constant SICEEWEB. */
	public static final String SICEEWEB = "SICEEWEB";

	/** The Constant PAGINA_SELEZIONE_TIPO_RICERCA. */
	public static final String PAGINA_SELEZIONE_TIPO_RICERCA = "PAGINA_SELEZIONE_TIPO_RICERCA";

	/** The Constant PAGINA_RICERCA_ACE. */
	public static final String PAGINA_RICERCA_ACE = "PAGINA_RICERCA_ACE";

	/*
	 * STATI DEL CERTIFICATORE -- BEGIN
	 */

	/** The Constant STATO_CERTIFICATORE_NUOVO_ISCRITTO. */
	public static final int STATO_CERTIFICATORE_NUOVO_ISCRITTO = 0;

	/** The Constant STATO_CERTIFICATORE_REGISTRATO_VALIDO. */
	public static final int STATO_CERTIFICATORE_REGISTRATO_VALIDO = 1;

	/** The Constant STATO_CERTIFICATORE_REGISTRATO_SCADUTO. */
	public static final int STATO_CERTIFICATORE_REGISTRATO_SCADUTO = 2;

	/** The Constant STATO_CERTIFICATORE_REGISTRATO_NEAR_SCADENZA. */
	public static final int STATO_CERTIFICATORE_REGISTRATO_NEAR_SCADENZA = 3;

	/** The Constant STATO_CERTIFICATORE_ERRATO. */
	public static final int STATO_CERTIFICATORE_ERRATO = -1;

	// stati blocco -- begin
	/** The Constant ID_BLOCCO_CERTIFICATORE_RADIATO. */
	public static final int ID_BLOCCO_CERTIFICATORE_RADIATO = 1;

	/** The Constant ID_BLOCCO_CERTIFICATORE_DECEDUTO. */
	public static final int ID_BLOCCO_CERTIFICATORE_DECEDUTO = 2;

	/** The Constant ID_BLOCCO_CERTIFICATORE_ASSENZA_TITOLO_STUDIO. */
	public static final int ID_BLOCCO_CERTIFICATORE_ASSENZA_TITOLO_STUDIO = 3;

	/** The Constant ID_BLOCCO_CERTIFICATORE_FALSE_DICHIARAZIONI. */
	public static final int ID_BLOCCO_CERTIFICATORE_FALSE_DICHIARAZIONI = 4;

	/** The Constant ID_BLOCCO_CERTIFICATORE_ASSENZA_CORSO. */
	public static final int ID_BLOCCO_CERTIFICATORE_ASSENZA_CORSO = 5;

	/** The Constant ID_BLOCCO_CERTIFICATORE_MANCANZA_INFORMAZIONI. */
	public static final int ID_BLOCCO_CERTIFICATORE_MANCANZA_INFORMAZIONI = 6;

	/** The Constant ID_BLOCCO_CERTIFICATORE_FALSE_DICHIARAZIONI. */
	public static final int ID_BLOCCO_CERTIFICATORE_MANCANZA_GENERICA = 7;

	// stati blocco -- end

	/*
	 * STATI DEL CERTIFICATORE -- END
	 */

	// codice per messaggi di stato
	/** The Constant MSG_UTENTE_RADIATO. */
	public static final String MSG_UTENTE_RADIATO = "MSG_UTENTE_RADIATO";

	/** The Constant MSG_UTENTE_DECEDUTO. */
	public static final String MSG_UTENTE_DECEDUTO = "MSG_UTENTE_DECEDUTO";

	/** The Constant MSG_UTENTE_FALSE_DICHIARAZIONI. */
	public static final String MSG_UTENTE_FALSE_DICHIARAZIONI = "MSG_UTENTE_FALSE_DICHIARAZIONI";

	/** The Constant DATA_SCADENZA_REGISTRAZIONE_ILLIMITATA. */
	public static final String DATA_SCADENZA_REGISTRAZIONE_ILLIMITATA = "12/12/2059";

	/** The Constant PK_PROGR. */
	public static final int PK_PROGR = 2;

	/** The Constant PK_ANNO. */
	public static final int PK_ANNO = 0;

	/** The Constant PK_ID_CERTIFICATORE. */
	public static final int PK_ID_CERTIFICATORE = 1;

	/** The Constant PK_NUM_CERTIFICATORE. */
	public static final int PK_NUM_CERTIFICATORE = 1;

	/** The Constant CODICI_FISCALI_MONITORAGGIO. */
	public static final String CODICI_FISCALI_MONITORAGGIO = "CODICI_FISCALI_MONITORAGGIO";

	/** The Constant CODICI_FISCALI_MONITORAGGIO. */
	public static final String SICEE_USER_ENABLED = "SICEE_USER_ENABLED";

	// new dosign begin
	/** The Constant KO_SIGNANDCERT_4_9. */
	public static final String KO_SIGNANDCERT_4_9 = "KO_SIGNANDCERT_4_9";

	/** The Constant KO_SIGNANDCERT_10. */
	public static final String KO_SIGNANDCERT_10 = "KO_SIGNANDCERT_10";

	/** The Constant KO_SIGNANDCERT_11. */
	public static final String KO_SIGNANDCERT_11 = "KO_SIGNANDCERT_11";

	/** The Constant KO_SIGNANDCERT_12. */
	public static final String KO_SIGNANDCERT_12 = "KO_SIGNANDCERT_12";

	/** The Constant KO_SIGNATURE_TYPE_FORMAT. */
	public static final String KO_SIGNATURE_TYPE_FORMAT = "KO_SIGNATURE_TYPE_FORMAT";

	/** The Constant KO_FILE_TYPE. */
	public static final String KO_FILE_TYPE = "KO_FILE_TYPE";

	/** The Constant KO_COMPLIANCE. */
	public static final String KO_COMPLIANCE = "KO_COMPLIANCE";

	/** The Constant KO_DIGEST_ALGORITHM. */
	public static final String KO_DIGEST_ALGORITHM = "KO_DIGEST_ALGORITHM";
	// new dosign end

	/** The Constant DIVIDE_LINK. */
	public static final String DIVIDE_LINK = ";";

	/** The Constant DIVIDE_IDS. */
	public static final String DIVIDE_IDS = "@";

	public static final Integer ERRORE_INDEX = 1;
	public static final Integer ERRORE_FOTO = 2;

	/** The Constant TRANSAZIONE_INIZIALIZED. */
	public static final String TRANSAZIONE_INIZIALIZED = "1";

	/** The Constant TRANSAZIONE_STARTED. */
	public static final String TRANSAZIONE_STARTED = "3";

	/** The Constant PAGAMENTO_CC. */
	public static final String PAGAMENTO_CC = "CC";

	/** The Constant PAGAMENTO_BB. */
	public static final String PAGAMENTO_BB = "BB";

	/** The Constant TRANSAZIONE_OLD_MDP. */
	public static final int TRANSAZIONE_OLD_MDP = 6;

	/** The Constant TRANSAZIONE_MDP_OK. */
	public static final long TRANSAZIONE_MDP_OK = 4;

	/** The Constant TRANSAZIONE_MDP_KO. */
	public static final long TRANSAZIONE_MDP_KO = 5;

	/** The Constant TRANSAZIONE_MDP_ABORT. */
	public static final long TRANSAZIONE_MDP_ABORT = 6;

	/** The Constant TRANSAZIONE_MDP_MIDDLE. */
	public static final long TRANSAZIONE_MDP_MIDDLE = 3;

	public static final String VALIDITA_NOME_FILE = "VALIDITA_NOME_FILE";

	public static final String SEDE_REGIONE_PIEMONTE = "SEDE_REGIONE_PIEMONTE";

	////costanti per individuare l'oggetto del pagamento (serve per gestire la logica di
	//// recepimento dell'esito
	public static final String PAGAMENTO_REGISTRAZIONE = "PAGA_REG";
	public static final String PAGAMENTO_ACE = "PAGA_ACE";

	//	public static final String MSG_OK_REGISTRAZ_NAZ = "La registrazione all'elenco regionale e' avvenuta con successo, con le Sue competenze e' possibile operare su tutto il territorio nazionale. Il suo N. di iscrizione e' il seguente: ";
	//	public static final String MSG_OK_REGISTRAZ_REG = "La registrazione all'elenco regionale e' avvenuta con successo, con le Sue competenze e' possibile operare solo sul territorio regionale. Il suo N. di iscrizione e' il seguente: ";

	public static final String MSG_OK_REGISTRAZ_NAZ = "La registrazione all'elenco regionale e' avvenuta con successo. Il suo N. di iscrizione e' il seguente: ";
	public static final String MSG_OK_REGISTRAZ_REG = "La registrazione all'elenco regionale e' avvenuta con successo. Il suo N. di iscrizione e' il seguente: ";

	public static final String SESSIONE_VAR_MESSAGGE = "messaggio";

	public static final String MODOL_ENCODING = "UTF-8";
	public static final String CODICE_APPLICAZIONE_MODOL = "SICEE";
	public static final String CODICE_MODULO_MODOL_APE = "MODULO_APE_2015-v1.0.0";
	public static final String CODICE_MODULO_MODOL_APE_2015 = "MODULO_APE_2015-v2.0.0";
	public static final String CODICE_MODULO_MODOL_TARGHETTA = "MODULO_TARGHETTA_2015-v1.0.0";

	/** The boolean constants */
	public static final boolean TRUE = true;
	public static final boolean FALSE = false;

	public static final Integer ID_PDF_APE_CONSOLIDATO = 1;
	public static final Integer ID_PDF_APE_FIRMATO = 2;
	public static final Integer ID_PDF_INDICATORE_APE = 3;

	//	public static final String ESITO_PAGAMENTO_OK = "ok";
	//	public static final String ESITO_PAGAMENTO_KO = "ko";
	//	public static final String ESITO_PAGAMENTO_ABORT = "abort";

	public static final int ID_COMBUSTIBILE_ENERGIAELETTRICA = 200;
	public static final int ID_COMBUSTIBILE_GASNATURALE = 201;
	public static final int ID_COMBUSTIBILE_GPL = 202;
	public static final int ID_COMBUSTIBILE_CARBONE = 203;

	public static final int ID_COMBUSTIBILE_GASOLIO = 204;
	public static final int ID_COMBUSTIBILE_GASOL = 214;
	public static final int ID_COMBUSTIBILE_OLIO_COMBUSTIBILE = 215;

	public static final int ID_COMBUSTIBILE_BIOMASSESOLIDE = 205;
	public static final int ID_COMBUSTIBILE_BIOMASSELIQUIDE = 206;
	public static final int ID_COMBUSTIBILE_BIOMASSEGASSOSE = 207;
	public static final int ID_COMBUSTIBILE_SOLAREFOTOVOLTAICO = 208;
	public static final int ID_COMBUSTIBILE_SOLARETERMICO = 209;
	public static final int ID_COMBUSTIBILE_EOLICO = 210;
	public static final int ID_COMBUSTIBILE_TELERISCALDAMENTO = 211;
	public static final int ID_COMBUSTIBILE_TELERAFFRESCAMENTO = 212;
	public static final int ID_COMBUSTIBILE_ALTRO = 213;

	public static final int ID_MOTIVO_ALTRO = 105;
	public static final int ID_MOTIVO_ANTE_OPERAM = 200;
	public static final int ID_MOTIVO_POST_OPERAM = 201;

	public static final int ID_CLASSE_ENERGETICA_A4 = 100;
	public static final int ID_CLASSE_ENERGETICA_A3 = 101;
	public static final int ID_CLASSE_ENERGETICA_A2 = 102;
	public static final int ID_CLASSE_ENERGETICA_A1 = 103;
	public static final int ID_CLASSE_ENERGETICA_B = 104;
	public static final int ID_CLASSE_ENERGETICA_C = 105;
	public static final int ID_CLASSE_ENERGETICA_D = 106;
	public static final int ID_CLASSE_ENERGETICA_E = 107;
	public static final int ID_CLASSE_ENERGETICA_F = 108;
	public static final int ID_CLASSE_ENERGETICA_G = 109;

	public static final int SEZIONE_CLIMAINVER = 1;
	public static final int SEZIONE_CLIMAEST = 2;
	public static final int SEZIONE_ACQUACALDA = 3;
	public static final int SEZIONE_IMPIANTICOMBINATI = 4;
	public static final int SEZIONE_PRODFONTIRINN = 5;
	public static final int SEZIONE_VENTMECC = 6;
	public static final int SEZIONE_ILLUMINAZIONE = 7;
	public static final int SEZIONE_TRASPORTO = 8;

	public static final int ID_SMILE_FELICE = 0;
	public static final int ID_SMILE_SERIO = 1;
	public static final int ID_SMILE_TRISTE = 2;

	public static final int ID_OGGETTO_APE_INTERO_EDIFICIO = 0;

	//public static final int ID_TIPO_SCADENZA_ANNO_IN_CORSO = 1;
	public static final int ID_TIPO_SCADENZA_ANNO_SUCCESSIVO = 2;
	public static final int ID_TIPO_SCADENZA_ANNO_10 = 3;

	public static final Integer CODERR_FKCLASSEENERGETICA = 101;

	public static final int IMAGEPREVIEW_WIDTH = 100;
	public static final int IMAGEPREVIEW_HEIGHT = 100;

	/** COSTANTI DELLA PROCEDURA DA IMPORTAZIONE DA XML ESTERNO */
	/** CODICI */
	public static final int OK_CODE_IMPXML = 0;
	//public static final int ERROR_CODE_IMPXML_NULLPOINTER = 1;
	//public static final int ERROR_CODE_IMPXML_IO = 2;
	//public static final int ERROR_CODE_IMPXML_PARSE = 3;
	/** DESCRIZIONI */
	public static final String OK_DESC_IMPXML = "Import del file XML effettuato con successo";
	//public static final String ERROR_DESC_IMPXML_NULLPOINTER = "Eccezione di Null Pointer nel processamento del documento XML";
	//public static final String ERROR_DESC_IMPXML_IO = "Eccezione di I/O nell'apertura del documento XML";
	//public static final String ERROR_DESC_IMPXML_PARSE = "Eccezione nel parsing del documento XML";

	public static final Double COSTO_DEFAULT_ACE = 15.00;

	public static final String ID_RIF_CATASTO_NCEU = "NCEU";
	public static final String ID_RIF_CATASTO_NCT = "NCT";
	public static final String ID_RIF_CATASTO_CT = "CT";

	public static final String DESC_RIF_CATASTO_NCEU = "Catasto fabbricati";
	public static final String DESC_RIF_CATASTO_NCT = "Catasto terreni";
	public static final String DESC_RIF_CATASTO_CT = "Catasto tavolare";

	public static final int ID_DICHIARAZIONE_NEW = 100;

	public static final String STATO_MODULO_BOZZA_DA_XML = "BOZZA_DA_XML";

	public static final int LUNGHEZZA_MASSIMA_NOTE = 2000;

	public static final int LUNGHEZZA_MASSIMA_LOG = 500;

	public static final String ACTA_ESTENSIONE_FILE_AMMESSA = ".pdf.p7m";

	public static final int ID_TIPO_OP_STORNO = 1;
	public static final int ID_TIPO_OP_RICARICA = 2;
	public static final int ID_TIPO_OP_GENERA_APE = 3;
	public static final int ID_TIPO_OP_ISCRIZIONE_ANN = 4;
	public static final int ID_TIPO_OP_STORNO_ERROR = 5;

	public static final String SIGLA_TIPO_PERS_PF = "F";
	public static final String SIGLA_TIPO_PERS_PG = "G";

	public static final String DESC_TIPO_PERS_PF = "Persona fisica";
	public static final String DESC_TIPO_PERS_PG = "Persona Giuridica";

	/** The Constant ID_TRANSAZIONE_ACE_FITTIZIA. */
	public static final Integer ID_TRANSAZIONE_ACE_FITTIZIA = 0;

	public static final int ID_STATO_TRANS_2018_CREA_TRANS = 1;
	public static final int ID_STATO_TRANS_2018_URL_WIS = 2;
	public static final int ID_STATO_TRANS_2018_AVVIO_TRANS = 3;
	public static final int ID_STATO_TRANS_2018_ATTESA_RT = 4;
	public static final int ID_STATO_TRANS_2018_PAGAMENTO_OK = 5;
	public static final int ID_STATO_TRANS_2018_FALLITO = 6;
	public static final int ID_STATO_TRANS_2018_ANNULLATO = 7;
	public static final int ID_STATO_TRANS_2018_PAGAMENTO_KO = 8;
	public static final int ID_STATO_TRANS_2018_PAGAMENTO_KO_AUTO = 9;

	public static final int NUM_RICERCA_PARZ = 200;

	public static String COD_TIPO_RICERCA_PARZ = "PARZ";
	public static String COD_TIPO_RICERCA_TOT = "TOT";

	public static String DESC_TIPO_RICERCA_PARZ = "Ultime " + NUM_RICERCA_PARZ;
	public static String DESC_TIPO_RICERCA_TOT = "Tutte";

	public static final String RUOLO_CERTIFICATORE_LOG_ACCESSO = "SICEEWEB-CERTIFICATORE";

	/*PROTECTED REGION END*/
}
