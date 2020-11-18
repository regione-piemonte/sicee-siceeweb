package it.csi.sicee.siceeweb.presentation.siceeweb.action.gestcertificatore.states;

import it.csi.sicee.siceeweb.presentation.siceeweb.action.ScreenStateCommand;

/**
 * Questa classe contiene le informazioni relative agli ScreenStates del ContentPanel cpRegistraz
 */
public final class CpRegistrazScreenStates {

	/**
	 * Costruttore privato (questa e' una utility class)
	 */
	private CpRegistrazScreenStates() {
		// costruttore intenzionalmente vuoto
	}

	/**
	 * Questa classe rappresenta lo ScreenState REGISTRATO_NON_PAGANTE.
	 * NOTA BENE: questa classe e' attualmente non utilizzata (i widget visibili/abilitati sono
	 * contenuti nel file JSON che contiene il comando ScreenStateCommand.
	 * La classe e' pero' mantenuta per future evoluzioni. 
	 */
	public static final class REGISTRATO_NON_PAGANTEScreenState {

		/**
		 * widget abilitati nello stato
		 */
		static final String[] WIDGETS_ON = new String[]{"txtObblAnag", "calDtNascita", "cbRegNasc", "cbProvNasc",
				"cbComNasc", "bDtAnagAvanti", "txtObblResid", "cbRegResid", "cbProvResid", "cbComResid",
				"tfIndirizzoRes", "vVerifIndRes", "cbSceltaIndRes", "tfNCivRes", "tfCAPRes", "tfTelRes", "tfCellRes",
				"tfEmailRes", "tfFaxRes", "bDtResIndietro", "bDtResAvanti", "tfRagSociale", "tfPIVA", "cbRegStudio",
				"cbProvStudio", "cbComStudio", "tfIndirizzoStudio", "vVerifIndStudio", "cbSceltaIndStudio",
				"tfNCivStudio", "tfCAPStudio", "bDtStudioIndietro", "bDtStudioAvanti", "txtObblOrdine",
				"rbsIscrittoOrdine", "cbTipoIstr", "cbCodiceIstr", "tfSettoreIscriz", "tfSezioneIscriz", "tfNumIscriz",
				"tfAlboIscriz", "calDataIscrizione", "bDtOrdineIndietro", "bDtOrdineAvanti", "tfNomeRiep",
				"tfCognomeRiep", "tfCF", "tfTitoloIstruzione", "tfTipoIstruzione", "txtTrattDatiPers",
				"ckTrattDatiPers", "txtAutocertificazione", "ckAutocert", "bDtRiepilogoIndietro", "bDtRiepilogoAvanti",
				"menu", "tfCognome", "tfNome", "tfProvinciaIscriz", "tfStatoEstero", "cbAutorizzaTelefono",
				"cbAutorizzaCell", "cbAutorizzaEmail", "cbAutorizzaNewsletter", "tfEmailPec", "tfSitoWeb",
				"ptPresaVisione", "cbAccettoVisione", "txtMsgPagOK1", "btPagOK", "txtNotaA", "txtTitolo",
				"txtEsameNotaA", "tfCittaEstera", "tfViaEstera", "tfCivicoEstero", "tfCapEstero", "tfStatoResEstero",
				"rbFlgResidenzaItalia", "tblAttPartNewSummary", "attPartNew", "bInsAttPartNew", "tblAttPartOldSummary",
				"tblTitoloStudioSummary", "attTitoloStudio", "bInsAttTitoloStudio"};

		/**
		 * widget disabilitati nello stato
		 */
		static final String[] WIDGETS_OFF = new String[]{"tfCodFisc", "txtNull", "txtObblContatti", "hvPagamentoOK"};

		/**
		 * widget visibili nello stato
		 */
		static final String[] WIDGETS_SHOWN = new String[]{"txtObblAnag", "tfCognome", "tfNome", "tfCodFisc",
				"calDtNascita", "cbRegNasc", "cbProvNasc", "cbComNasc", "bDtAnagAvanti", "txtObblResid", "cbRegResid",
				"cbProvResid", "cbComResid", "tfIndirizzoRes", "vVerifIndRes", "cbSceltaIndRes", "tfNCivRes",
				"tfCAPRes", "tfTelRes", "tfCellRes", "tfEmailRes", "tfFaxRes", "bDtResIndietro", "bDtResAvanti",
				"tfRagSociale", "tfPIVA", "cbRegStudio", "cbProvStudio", "cbComStudio", "tfIndirizzoStudio",
				"vVerifIndStudio", "cbSceltaIndStudio", "tfNCivStudio", "tfCAPStudio", "bDtStudioIndietro",
				"bDtStudioAvanti", "txtObblOrdine", "rbsIscrittoOrdine", "cbTipoIstr", "cbCodiceIstr", "txtTitolo",
				"tfSettoreIscriz", "tfSezioneIscriz", "tfNumIscriz", "tfAlboIscriz", "calDataIscrizione",
				"ptPresaVisione", "cbAccettoVisione", "bDtOrdineIndietro", "bDtOrdineAvanti", "tfNomeRiep",
				"tfCognomeRiep", "tfCF", "tfTitoloIstruzione", "tfTipoIstruzione", "txtTrattDatiPers",
				"ckTrattDatiPers", "txtAutocertificazione", "ckAutocert", "bDtRiepilogoIndietro", "bDtRiepilogoAvanti",
				"menu", "tfProvinciaIscriz", "tfStatoEstero", "cbAutorizzaTelefono", "cbAutorizzaCell",
				"cbAutorizzaEmail", "tfEmailPec", "cbAutorizzaNewsletter", "tfSitoWeb", "txtEsameNotaA", "txtMsgPagOK1",
				"btPagOK", "txtNotaA", "tfCittaEstera", "tfViaEstera", "tfCivicoEstero", "tfCapEstero",
				"tfStatoResEstero", "rbFlgResidenzaItalia", "tblAttPartNewSummary", "attPartNew", "bInsAttPartNew",
				"tblAttPartOldSummary", "tblTitoloStudioSummary", "attTitoloStudio", "bInsAttTitoloStudio"};

		/**
		 * widget nascosti nello stato
		 */
		static final String[] WIDGETS_HIDDEN = new String[]{"txtNull", "txtObblContatti", "hvPagamentoOK"};

		/**
		 * Istanza del comando che permette di passare a questo stato
		 */
		static final ScreenStateCommand COMMAND = new ScreenStateCommand("REGISTRATO_NON_PAGANTE", WIDGETS_ON,
				WIDGETS_OFF, WIDGETS_SHOWN, WIDGETS_HIDDEN);

		/**
		 * Costruttore privato (questa e' una utility class)
		 */
		private REGISTRATO_NON_PAGANTEScreenState() {
			// costruttore intenzionalmente vuoto
		}
	}

	/**
	 * Questa classe rappresenta lo ScreenState REGISTRATO_PAGANTE.
	 * NOTA BENE: questa classe e' attualmente non utilizzata (i widget visibili/abilitati sono
	 * contenuti nel file JSON che contiene il comando ScreenStateCommand.
	 * La classe e' pero' mantenuta per future evoluzioni. 
	 */
	public static final class REGISTRATO_PAGANTEScreenState {

		/**
		 * widget abilitati nello stato
		 */
		static final String[] WIDGETS_ON = new String[]{"bDtAnagAvanti", "vVerifIndRes", "bDtResIndietro",
				"bDtResAvanti", "vVerifIndStudio", "bDtStudioIndietro", "bDtStudioAvanti", "bDtOrdineIndietro",
				"bDtOrdineAvanti", "bDtRiepilogoIndietro", "bDtRiepilogoAvanti", "menu", "cbRegResid", "cbProvResid",
				"cbComResid", "cbSceltaIndRes", "tfIndirizzoRes", "tfNCivRes", "tfCAPRes", "tfTelRes", "tfCellRes",
				"tfEmailRes", "tfEmailPec", "tfSitoWeb", "cbAutorizzaTelefono", "cbAutorizzaCell", "cbAutorizzaEmail",
				"cbAutorizzaNewsletter", "tfRagSociale", "tfPIVA", "tfIndirizzoStudio", "tfNCivStudio", "tfCAPStudio",
				"cbRegStudio", "cbProvStudio", "cbComStudio", "cbSceltaIndStudio", "rbsIscrittoOrdine", "cbTipoIstr",
				"cbCodiceIstr", "ptPresaVisione", "cbAccettoVisione", "tfFaxRes", "txtMsgPagOK1", "btPagOK",
				"txtTitolo", "txtEsameNotaA", "tfCittaEstera", "tfViaEstera", "tfCivicoEstero", "tfCapEstero",
				"tfStatoResEstero", "rbFlgResidenzaItalia", "tblAttPartNewSummary", "attPartNew", "bInsAttPartNew",
				"tblAttPartOldSummary", "tblTitoloStudioSummary", "attTitoloStudio", "bInsAttTitoloStudio"};

		/**
		 * widget disabilitati nello stato
		 */
		static final String[] WIDGETS_OFF = new String[]{"txtObblAnag", "tfCognome", "tfNome", "tfCodFisc",
				"calDtNascita", "tfStatoEstero", "cbRegNasc", "cbProvNasc", "cbComNasc", "txtNotaA", "txtObblResid",
				"txtNull", "txtObblContatti", "txtObblOrdine", "tfSezioneIscriz", "tfSettoreIscriz", "tfAlboIscriz",
				"tfProvinciaIscriz", "tfNumIscriz", "calDataIscrizione", "tfNomeRiep", "tfCognomeRiep", "tfCF",
				"tfTipoIstruzione", "tfTitoloIstruzione", "txtTrattDatiPers", "ckTrattDatiPers",
				"txtAutocertificazione", "ckAutocert", "hvPagamentoOK"};

		/**
		 * widget visibili nello stato
		 */
		static final String[] WIDGETS_SHOWN = new String[]{"txtObblAnag", "tfCognome", "tfNome", "tfCodFisc",
				"calDtNascita", "cbRegNasc", "cbProvNasc", "cbComNasc", "bDtAnagAvanti", "txtObblResid", "cbRegResid",
				"cbProvResid", "cbComResid", "tfIndirizzoRes", "vVerifIndRes", "cbSceltaIndRes", "tfNCivRes",
				"tfCAPRes", "tfTelRes", "tfCellRes", "tfEmailRes", "tfFaxRes", "bDtResIndietro", "bDtResAvanti",
				"tfRagSociale", "tfPIVA", "cbRegStudio", "cbProvStudio", "cbComStudio", "tfIndirizzoStudio",
				"vVerifIndStudio", "cbSceltaIndStudio", "tfNCivStudio", "tfCAPStudio", "bDtStudioIndietro",
				"bDtStudioAvanti", "txtObblOrdine", "rbsIscrittoOrdine", "cbTipoIstr", "cbCodiceIstr",
				"tfSettoreIscriz", "tfSezioneIscriz", "tfNumIscriz", "tfAlboIscriz", "calDataIscrizione",
				"bDtOrdineIndietro", "bDtOrdineAvanti", "tfNomeRiep", "tfCognomeRiep", "tfCF", "tfTitoloIstruzione",
				"tfTipoIstruzione", "txtTrattDatiPers", "ckTrattDatiPers", "txtAutocertificazione", "ckAutocert",
				"bDtRiepilogoIndietro", "bDtRiepilogoAvanti", "menu", "tfProvinciaIscriz", "tfStatoEstero",
				"cbAutorizzaTelefono", "cbAutorizzaCell", "cbAutorizzaEmail", "tfEmailPec", "cbAutorizzaNewsletter",
				"ptPresaVisione", "cbAccettoVisione", "tfSitoWeb", "txtMsgPagOK1", "btPagOK", "txtNotaA", "txtTitolo",
				"txtEsameNotaA", "tfCittaEstera", "tfViaEstera", "tfCivicoEstero", "tfCapEstero", "tfStatoResEstero",
				"rbFlgResidenzaItalia", "tblAttPartNewSummary", "attPartNew", "bInsAttPartNew", "tblAttPartOldSummary",
				"tblTitoloStudioSummary", "attTitoloStudio", "bInsAttTitoloStudio"};

		/**
		 * widget nascosti nello stato
		 */
		static final String[] WIDGETS_HIDDEN = new String[]{"txtNull", "txtObblContatti", "hvPagamentoOK"};

		/**
		 * Istanza del comando che permette di passare a questo stato
		 */
		static final ScreenStateCommand COMMAND = new ScreenStateCommand("REGISTRATO_PAGANTE", WIDGETS_ON, WIDGETS_OFF,
				WIDGETS_SHOWN, WIDGETS_HIDDEN);

		/**
		 * Costruttore privato (questa e' una utility class)
		 */
		private REGISTRATO_PAGANTEScreenState() {
			// costruttore intenzionalmente vuoto
		}
	}

	/**
	 * Questa classe rappresenta lo ScreenState RIREGISTRAZIONE.
	 * NOTA BENE: questa classe e' attualmente non utilizzata (i widget visibili/abilitati sono
	 * contenuti nel file JSON che contiene il comando ScreenStateCommand.
	 * La classe e' pero' mantenuta per future evoluzioni. 
	 */
	public static final class RIREGISTRAZIONEScreenState {

		/**
		 * widget abilitati nello stato
		 */
		static final String[] WIDGETS_ON = new String[]{"txtObblAnag", "calDtNascita", "cbRegNasc", "cbProvNasc",
				"cbComNasc", "bDtAnagAvanti", "txtObblResid", "cbRegResid", "cbProvResid", "cbComResid",
				"tfIndirizzoRes", "vVerifIndRes", "cbSceltaIndRes", "tfNCivRes", "tfCAPRes", "tfTelRes", "tfCellRes",
				"tfEmailRes", "tfFaxRes", "bDtResIndietro", "bDtResAvanti", "tfRagSociale", "tfPIVA", "cbRegStudio",
				"cbProvStudio", "cbComStudio", "tfIndirizzoStudio", "vVerifIndStudio", "cbSceltaIndStudio",
				"tfNCivStudio", "tfCAPStudio", "bDtStudioIndietro", "bDtStudioAvanti", "txtObblOrdine",
				"tfSettoreIscriz", "tfSezioneIscriz", "tfNumIscriz", "tfAlboIscriz", "calDataIscrizione",
				"bDtOrdineIndietro", "bDtOrdineAvanti", "tfNomeRiep", "tfCognomeRiep", "tfCF", "tfTitoloIstruzione",
				"tfTipoIstruzione", "txtTrattDatiPers", "ckTrattDatiPers", "txtAutocertificazione", "ckAutocert",
				"bDtRiepilogoIndietro", "bDtRiepilogoAvanti", "menu", "cbTipoIstr", "tfProvinciaIscriz",
				"tfStatoEstero", "cbAutorizzaTelefono", "cbAutorizzaCell", "cbAutorizzaEmail", "cbAutorizzaNewsletter",
				"tfEmailPec", "tfSitoWeb", "btPagOK", "txtMsgPagOK1", "txtNotaA", "rbsIscrittoOrdine", "cbCodiceIstr",
				"ptPresaVisione", "cbAccettoVisione", "txtTitolo", "txtEsameNotaA", "tfCittaEstera", "tfViaEstera",
				"tfCivicoEstero", "tfCapEstero", "tfStatoResEstero", "rbFlgResidenzaItalia", "tblAttPartNewSummary",
				"attPartNew", "bInsAttPartNew", "tblAttPartOldSummary", "tblTitoloStudioSummary", "attTitoloStudio",
				"bInsAttTitoloStudio"};

		/**
		 * widget disabilitati nello stato
		 */
		static final String[] WIDGETS_OFF = new String[]{"tfCognome", "tfNome", "tfCodFisc", "txtNull",
				"txtObblContatti", "hvPagamentoOK"};

		/**
		 * widget visibili nello stato
		 */
		static final String[] WIDGETS_SHOWN = new String[]{"txtObblAnag", "tfCognome", "tfNome", "tfCodFisc",
				"calDtNascita", "cbRegNasc", "cbProvNasc", "cbComNasc", "bDtAnagAvanti", "txtObblResid", "cbRegResid",
				"cbProvResid", "cbComResid", "tfIndirizzoRes", "vVerifIndRes", "cbSceltaIndRes", "tfNCivRes",
				"tfCAPRes", "tfTelRes", "tfCellRes", "tfEmailRes", "tfFaxRes", "bDtResIndietro", "bDtResAvanti",
				"tfRagSociale", "tfPIVA", "cbRegStudio", "cbProvStudio", "cbComStudio", "tfIndirizzoStudio",
				"vVerifIndStudio", "cbSceltaIndStudio", "tfNCivStudio", "tfCAPStudio", "bDtStudioIndietro",
				"bDtStudioAvanti", "txtObblOrdine", "tfSettoreIscriz", "tfSezioneIscriz", "tfNumIscriz",
				"calDataIscrizione", "bDtOrdineIndietro", "bDtOrdineAvanti", "tfNomeRiep", "tfCognomeRiep", "tfCF",
				"tfTitoloIstruzione", "tfTipoIstruzione", "txtTrattDatiPers", "ckTrattDatiPers",
				"txtAutocertificazione", "ckAutocert", "bDtRiepilogoIndietro", "bDtRiepilogoAvanti", "menu",
				"cbTipoIstr", "tfProvinciaIscriz", "tfStatoEstero", "cbAutorizzaTelefono", "cbAutorizzaCell",
				"cbAutorizzaEmail", "cbAutorizzaNewsletter", "tfEmailPec", "tfSitoWeb", "btPagOK", "txtMsgPagOK1",
				"txtNotaA", "rbsIscrittoOrdine", "tfAlboIscriz", "cbCodiceIstr", "ptPresaVisione", "cbAccettoVisione",
				"txtTitolo", "txtEsameNotaA", "tfCittaEstera", "tfViaEstera", "tfCivicoEstero", "tfCapEstero",
				"tfStatoResEstero", "rbFlgResidenzaItalia", "tblAttPartNewSummary", "attPartNew", "bInsAttPartNew",
				"tblAttPartOldSummary", "tblTitoloStudioSummary", "attTitoloStudio", "bInsAttTitoloStudio"};

		/**
		 * widget nascosti nello stato
		 */
		static final String[] WIDGETS_HIDDEN = new String[]{"txtNull", "txtObblContatti", "hvPagamentoOK"};

		/**
		 * Istanza del comando che permette di passare a questo stato
		 */
		static final ScreenStateCommand COMMAND = new ScreenStateCommand("RIREGISTRAZIONE", WIDGETS_ON, WIDGETS_OFF,
				WIDGETS_SHOWN, WIDGETS_HIDDEN);

		/**
		 * Costruttore privato (questa e' una utility class)
		 */
		private RIREGISTRAZIONEScreenState() {
			// costruttore intenzionalmente vuoto
		}
	}

	/**
	 * Questa classe rappresenta lo ScreenState NUOVA_REGISTRAZIONE.
	 * NOTA BENE: questa classe e' attualmente non utilizzata (i widget visibili/abilitati sono
	 * contenuti nel file JSON che contiene il comando ScreenStateCommand.
	 * La classe e' pero' mantenuta per future evoluzioni. 
	 */
	public static final class NUOVA_REGISTRAZIONEScreenState {

		/**
		 * widget abilitati nello stato
		 */
		static final String[] WIDGETS_ON = new String[]{"txtObblAnag", "calDtNascita", "cbRegNasc", "cbProvNasc",
				"cbComNasc", "bDtAnagAvanti", "txtObblResid", "cbRegResid", "cbProvResid", "cbComResid",
				"tfIndirizzoRes", "vVerifIndRes", "cbSceltaIndRes", "tfNCivRes", "tfCAPRes", "tfTelRes", "tfCellRes",
				"tfEmailRes", "tfFaxRes", "bDtResIndietro", "bDtResAvanti", "tfRagSociale", "tfPIVA", "cbRegStudio",
				"cbProvStudio", "cbComStudio", "tfIndirizzoStudio", "vVerifIndStudio", "cbSceltaIndStudio",
				"tfNCivStudio", "tfCAPStudio", "bDtStudioIndietro", "bDtStudioAvanti", "txtObblOrdine",
				"rbsIscrittoOrdine", "cbTipoIstr", "cbCodiceIstr", "tfSettoreIscriz", "tfSezioneIscriz", "tfNumIscriz",
				"tfAlboIscriz", "calDataIscrizione", "bDtOrdineIndietro", "bDtOrdineAvanti", "tfNomeRiep",
				"tfCognomeRiep", "tfCF", "tfTitoloIstruzione", "tfTipoIstruzione", "txtTrattDatiPers",
				"ckTrattDatiPers", "txtAutocertificazione", "ckAutocert", "bDtRiepilogoIndietro", "bDtRiepilogoAvanti",
				"menu", "tfCognome", "tfNome", "tfProvinciaIscriz", "tfStatoEstero", "cbAutorizzaTelefono",
				"cbAutorizzaCell", "cbAutorizzaEmail", "cbAutorizzaNewsletter", "tfEmailPec", "tfSitoWeb",
				"txtMsgPagOK1", "btPagOK", "txtNotaA", "ptPresaVisione", "cbAccettoVisione", "txtTitolo",
				"txtEsameNotaA", "tfCittaEstera", "tfViaEstera", "tfCivicoEstero", "tfCapEstero", "tfStatoResEstero",
				"rbFlgResidenzaItalia", "tblAttPartNewSummary", "attPartNew", "bInsAttPartNew", "tblAttPartOldSummary",
				"tblTitoloStudioSummary", "attTitoloStudio", "bInsAttTitoloStudio"};

		/**
		 * widget disabilitati nello stato
		 */
		static final String[] WIDGETS_OFF = new String[]{"tfCodFisc", "txtNull", "txtObblContatti", "hvPagamentoOK"};

		/**
		 * widget visibili nello stato
		 */
		static final String[] WIDGETS_SHOWN = new String[]{"txtObblAnag", "tfCognome", "tfNome", "tfCodFisc",
				"calDtNascita", "cbRegNasc", "cbProvNasc", "cbComNasc", "bDtAnagAvanti", "txtObblResid", "cbRegResid",
				"cbProvResid", "cbComResid", "tfIndirizzoRes", "vVerifIndRes", "cbSceltaIndRes", "tfNCivRes",
				"tfCAPRes", "tfTelRes", "tfCellRes", "tfEmailRes", "tfFaxRes", "bDtResIndietro", "bDtResAvanti",
				"tfRagSociale", "tfPIVA", "cbRegStudio", "cbProvStudio", "cbComStudio", "tfIndirizzoStudio",
				"vVerifIndStudio", "cbSceltaIndStudio", "tfNCivStudio", "tfCAPStudio", "bDtStudioIndietro",
				"bDtStudioAvanti", "txtObblOrdine", "rbsIscrittoOrdine", "cbTipoIstr", "cbCodiceIstr",
				"tfSettoreIscriz", "tfSezioneIscriz", "tfNumIscriz", "tfAlboIscriz", "calDataIscrizione",
				"bDtOrdineIndietro", "bDtOrdineAvanti", "tfNomeRiep", "tfCognomeRiep", "tfCF", "tfTitoloIstruzione",
				"tfTipoIstruzione", "txtTrattDatiPers", "ckTrattDatiPers", "txtAutocertificazione", "ckAutocert",
				"bDtRiepilogoIndietro", "bDtRiepilogoAvanti", "menu", "tfProvinciaIscriz", "tfStatoEstero",
				"cbAutorizzaTelefono", "cbAutorizzaCell", "cbAutorizzaEmail", "tfEmailPec", "cbAutorizzaNewsletter",
				"tfSitoWeb", "txtMsgPagOK1", "btPagOK", "txtNotaA", "ptPresaVisione", "cbAccettoVisione", "txtTitolo",
				"txtEsameNotaA", "tfCittaEstera", "tfViaEstera", "tfCivicoEstero", "tfCapEstero", "tfStatoResEstero",
				"rbFlgResidenzaItalia", "tblAttPartNewSummary", "attPartNew", "bInsAttPartNew", "tblAttPartOldSummary",
				"tblTitoloStudioSummary", "attTitoloStudio", "bInsAttTitoloStudio"};

		/**
		 * widget nascosti nello stato
		 */
		static final String[] WIDGETS_HIDDEN = new String[]{"txtNull", "txtObblContatti", "hvPagamentoOK"};

		/**
		 * Istanza del comando che permette di passare a questo stato
		 */
		static final ScreenStateCommand COMMAND = new ScreenStateCommand("NUOVA_REGISTRAZIONE", WIDGETS_ON, WIDGETS_OFF,
				WIDGETS_SHOWN, WIDGETS_HIDDEN);

		/**
		 * Costruttore privato (questa e' una utility class)
		 */
		private NUOVA_REGISTRAZIONEScreenState() {
			// costruttore intenzionalmente vuoto
		}
	}

}
