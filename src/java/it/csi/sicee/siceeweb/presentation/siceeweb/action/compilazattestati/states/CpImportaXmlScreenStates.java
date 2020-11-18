package it.csi.sicee.siceeweb.presentation.siceeweb.action.compilazattestati.states;

import it.csi.sicee.siceeweb.presentation.siceeweb.action.ScreenStateCommand;

/**
 * Questa classe contiene le informazioni relative agli ScreenStates del ContentPanel cpImportaXml
 */
public final class CpImportaXmlScreenStates {

	/**
	 * Costruttore privato (questa e' una utility class)
	 */
	private CpImportaXmlScreenStates() {
		// costruttore intenzionalmente vuoto
	}

	/**
	 * Questa classe rappresenta lo ScreenState CARICA_XML.
	 * NOTA BENE: questa classe e' attualmente non utilizzata (i widget visibili/abilitati sono
	 * contenuti nel file JSON che contiene il comando ScreenStateCommand.
	 * La classe e' pero' mantenuta per future evoluzioni. 
	 */
	public static final class CARICA_XMLScreenState {

		/**
		 * widget abilitati nello stato
		 */
		static final String[] WIDGETS_ON = new String[]{"fileCaricaXml", "btnCaricaXml", "btnIndietro", "menu"};

		/**
		 * widget disabilitati nello stato
		 */
		static final String[] WIDGETS_OFF = new String[]{"cbProvDtCatastali", "cbComDtCatastali", "tfGradiGiorno",
				"btnCalcoli", "btnAnnulla", "tblXmlResult", "rbImporta", "ptNote", "btnConferma"};

		/**
		 * widget visibili nello stato
		 */
		static final String[] WIDGETS_SHOWN = new String[]{"fileCaricaXml", "btnCaricaXml", "btnIndietro", "menu"};

		/**
		 * widget nascosti nello stato
		 */
		static final String[] WIDGETS_HIDDEN = new String[]{"cbProvDtCatastali", "cbComDtCatastali", "tfGradiGiorno",
				"btnCalcoli", "btnAnnulla", "tblXmlResult", "rbImporta", "ptNote", "btnConferma"};

		/**
		 * Istanza del comando che permette di passare a questo stato
		 */
		static final ScreenStateCommand COMMAND = new ScreenStateCommand("CARICA_XML", WIDGETS_ON, WIDGETS_OFF,
				WIDGETS_SHOWN, WIDGETS_HIDDEN);

		/**
		 * Costruttore privato (questa e' una utility class)
		 */
		private CARICA_XMLScreenState() {
			// costruttore intenzionalmente vuoto
		}
	}

	/**
	 * Questa classe rappresenta lo ScreenState ESEGUI_CALCOLI.
	 * NOTA BENE: questa classe e' attualmente non utilizzata (i widget visibili/abilitati sono
	 * contenuti nel file JSON che contiene il comando ScreenStateCommand.
	 * La classe e' pero' mantenuta per future evoluzioni. 
	 */
	public static final class ESEGUI_CALCOLIScreenState {

		/**
		 * widget abilitati nello stato
		 */
		static final String[] WIDGETS_ON = new String[]{"btnIndietro", "menu", "cbProvDtCatastali", "cbComDtCatastali",
				"tfGradiGiorno", "btnCalcoli", "btnAnnulla"};

		/**
		 * widget disabilitati nello stato
		 */
		static final String[] WIDGETS_OFF = new String[]{"fileCaricaXml", "btnCaricaXml", "tblXmlResult", "rbImporta",
				"ptNote", "btnConferma"};

		/**
		 * widget visibili nello stato
		 */
		static final String[] WIDGETS_SHOWN = new String[]{"btnIndietro", "menu", "cbProvDtCatastali",
				"cbComDtCatastali", "tfGradiGiorno", "btnCalcoli", "fileCaricaXml", "btnCaricaXml", "btnAnnulla"};

		/**
		 * widget nascosti nello stato
		 */
		static final String[] WIDGETS_HIDDEN = new String[]{"tblXmlResult", "rbImporta", "ptNote", "btnConferma"};

		/**
		 * Istanza del comando che permette di passare a questo stato
		 */
		static final ScreenStateCommand COMMAND = new ScreenStateCommand("ESEGUI_CALCOLI", WIDGETS_ON, WIDGETS_OFF,
				WIDGETS_SHOWN, WIDGETS_HIDDEN);

		/**
		 * Costruttore privato (questa e' una utility class)
		 */
		private ESEGUI_CALCOLIScreenState() {
			// costruttore intenzionalmente vuoto
		}
	}

	/**
	 * Questa classe rappresenta lo ScreenState CALCOLI_EFFETTUATI.
	 * NOTA BENE: questa classe e' attualmente non utilizzata (i widget visibili/abilitati sono
	 * contenuti nel file JSON che contiene il comando ScreenStateCommand.
	 * La classe e' pero' mantenuta per future evoluzioni. 
	 */
	public static final class CALCOLI_EFFETTUATIScreenState {

		/**
		 * widget abilitati nello stato
		 */
		static final String[] WIDGETS_ON = new String[]{"rbImporta", "btnIndietro", "menu", "btnAnnulla",
				"btnConferma"};

		/**
		 * widget disabilitati nello stato
		 */
		static final String[] WIDGETS_OFF = new String[]{"fileCaricaXml", "btnCaricaXml", "cbProvDtCatastali",
				"cbComDtCatastali", "tfGradiGiorno", "btnCalcoli", "tblXmlResult", "ptNote"};

		/**
		 * widget visibili nello stato
		 */
		static final String[] WIDGETS_SHOWN = new String[]{"cbProvDtCatastali", "cbComDtCatastali", "tfGradiGiorno",
				"btnCalcoli", "tblXmlResult", "rbImporta", "btnIndietro", "menu", "btnConferma", "fileCaricaXml",
				"btnCaricaXml", "btnAnnulla", "ptNote"};

		/**
		 * widget nascosti nello stato
		 */
		static final String[] WIDGETS_HIDDEN = new String[]{};

		/**
		 * Istanza del comando che permette di passare a questo stato
		 */
		static final ScreenStateCommand COMMAND = new ScreenStateCommand("CALCOLI_EFFETTUATI", WIDGETS_ON, WIDGETS_OFF,
				WIDGETS_SHOWN, WIDGETS_HIDDEN);

		/**
		 * Costruttore privato (questa e' una utility class)
		 */
		private CALCOLI_EFFETTUATIScreenState() {
			// costruttore intenzionalmente vuoto
		}
	}

}
