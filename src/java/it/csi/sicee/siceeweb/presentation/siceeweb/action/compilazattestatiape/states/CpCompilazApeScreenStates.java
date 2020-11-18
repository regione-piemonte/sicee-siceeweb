package it.csi.sicee.siceeweb.presentation.siceeweb.action.compilazattestatiape.states;

import it.csi.sicee.siceeweb.presentation.siceeweb.action.ScreenStateCommand;

/**
 * Questa classe contiene le informazioni relative agli ScreenStates del ContentPanel cpCompilazApe
 */
public final class CpCompilazApeScreenStates {

	/**
	 * Costruttore privato (questa e' una utility class)
	 */
	private CpCompilazApeScreenStates() {
		// costruttore intenzionalmente vuoto
	}

	/**
	 * Questa classe rappresenta lo ScreenState REGISTRAZIONE_NEW.
	 * NOTA BENE: questa classe e' attualmente non utilizzata (i widget visibili/abilitati sono
	 * contenuti nel file JSON che contiene il comando ScreenStateCommand.
	 * La classe e' pero' mantenuta per future evoluzioni. 
	 */
	public static final class REGISTRAZIONE_NEWScreenState {

		/**
		 * widget abilitati nello stato
		 */
		static final String[] WIDGETS_ON = new String[]{"menu", "tsApe", "cbProvDtCatastali", "cbComDtCatastali",
				"tfRicercaIndirizzo", "vVerifIndDtCatastali", "svuotaIndDtCatastaliText", "tfNCivDtCatastali",
				"tfCAPDtCatastali", "tfInternoDtCatastali", "tfScalaDtCatastali", "tfPianoDtCatastali",
				"tfIndirizzoCoordN", "tfIndirizzoCoordE", "tfSezCatasto", "tfFoglioCatasto", "tfParticCatasto",
				"tfSubaltCatasto", "rbTipoScadenza", "tfAnnoCostr", "tfAnnoRistrutt", "bSalva", "bViasualizzaApe",
				"bCompModApe", "bVerificaApe", "bConsolidaApe", "bInviaApe", "bIndietro", "fileFotoCatasto",
				"fileFotoCatastoAltre", "btnEliminaFoto", "btnCaricaFoto", "btnCaricaFotoAltre", "cbTipoFotoAltre",
				"tfNPianiComplessivi", "tfNPianiFtRisc", "cbFkTipoRistrutturaz", "cbFkTipolEdilizia",
				"cbFkTipolCostrutt", "cbFkProprietaEdi", "tfCodFiscCoCert", "tfCognomeCoCert", "tfNomeCoCert",
				"tfNumMatricolaCoCert", "bCercaCfCertificatori", "cbListaCf", "cbFkMotivo", "cbFkOggetto",
				"cbAltroServiziEnergia", "cbSistCatast", "tblDichiarazioneIndipendenza"};

		/**
		 * widget disabilitati nello stato
		 */
		static final String[] WIDGETS_OFF = new String[]{"txtObblDtCatastali", "txtZonaClimatica",
				"cbSceltaIndDtCatastali", "tfIndirizzoDtCatastali", "bCercaCoordinate", "calDtEmissione", "tfDestUso",
				"tfCodEdificioScolastico", "txtCoCertificatore", "txtNoteApeDatiGen", "txtNote1Foto", "txtObblDtFoto",
				"cbTipoFoto", "txtObblDtFotoAltre"};

		/**
		 * widget visibili nello stato
		 */
		static final String[] WIDGETS_SHOWN = new String[]{"tsApe", "menu", "txtObblDtCatastali", "cbProvDtCatastali",
				"cbComDtCatastali", "txtZonaClimatica", "tfRicercaIndirizzo", "vVerifIndDtCatastali",
				"tfIndirizzoDtCatastali", "svuotaIndDtCatastaliText", "tfNCivDtCatastali", "tfCAPDtCatastali",
				"tfInternoDtCatastali", "tfScalaDtCatastali", "tfPianoDtCatastali", "tfIndirizzoCoordN",
				"tfIndirizzoCoordE", "tfSezCatasto", "tfFoglioCatasto", "tfParticCatasto", "tfSubaltCatasto",
				"calDtEmissione", "rbTipoScadenza", "tfAnnoCostr", "tfAnnoRistrutt", "bSalva", "bViasualizzaApe",
				"bCompModApe", "bVerificaApe", "bConsolidaApe", "bInviaApe", "bIndietro", "txtNoteApeDatiGen",
				"btnEliminaFoto", "txtObblDtFoto", "txtObblDtFotoAltre", "fileFotoCatasto", "btnCaricaFoto",
				"txtNote1Foto", "fileFotoCatastoAltre", "cbTipoFotoAltre", "btnCaricaFotoAltre", "cbTipoFoto",
				"tfNPianiComplessivi", "tfNPianiFtRisc", "cbFkTipoRistrutturaz", "cbFkTipolEdilizia",
				"cbFkTipolCostrutt", "cbFkProprietaEdi", "tfCodFiscCoCert", "tfCognomeCoCert", "tfNomeCoCert",
				"tfNumMatricolaCoCert", "bCercaCfCertificatori", "cbListaCf", "cbFkMotivo", "cbFkOggetto",
				"cbAltroServiziEnergia", "txtCoCertificatore", "cbSistCatast", "tfDestUso", "tfCodEdificioScolastico",
				"tblDichiarazioneIndipendenza"};

		/**
		 * widget nascosti nello stato
		 */
		static final String[] WIDGETS_HIDDEN = new String[]{"cbSceltaIndDtCatastali", "bCercaCoordinate"};

		/**
		 * Istanza del comando che permette di passare a questo stato
		 */
		static final ScreenStateCommand COMMAND = new ScreenStateCommand("REGISTRAZIONE_NEW", WIDGETS_ON, WIDGETS_OFF,
				WIDGETS_SHOWN, WIDGETS_HIDDEN);

		/**
		 * Costruttore privato (questa e' una utility class)
		 */
		private REGISTRAZIONE_NEWScreenState() {
			// costruttore intenzionalmente vuoto
		}
	}

	/**
	 * Questa classe rappresenta lo ScreenState VISUALIZZAZIONE_NEW.
	 * NOTA BENE: questa classe e' attualmente non utilizzata (i widget visibili/abilitati sono
	 * contenuti nel file JSON che contiene il comando ScreenStateCommand.
	 * La classe e' pero' mantenuta per future evoluzioni. 
	 */
	public static final class VISUALIZZAZIONE_NEWScreenState {

		/**
		 * widget abilitati nello stato
		 */
		static final String[] WIDGETS_ON = new String[]{"bViasualizzaApe", "bCompModApe", "bVerificaApe",
				"bConsolidaApe", "bInviaApe", "tsApe", "menu", "bIndietro", "btnEliminaFoto", "fileFotoCatasto",
				"btnCaricaFoto", "fileFotoCatastoAltre", "cbTipoFotoAltre", "btnCaricaFotoAltre"};

		/**
		 * widget disabilitati nello stato
		 */
		static final String[] WIDGETS_OFF = new String[]{"txtObblDtCatastali", "cbProvDtCatastali", "cbComDtCatastali",
				"txtZonaClimatica", "tfRicercaIndirizzo", "vVerifIndDtCatastali", "cbSceltaIndDtCatastali",
				"tfIndirizzoDtCatastali", "svuotaIndDtCatastaliText", "tfNCivDtCatastali", "tfCAPDtCatastali",
				"tfInternoDtCatastali", "tfScalaDtCatastali", "tfPianoDtCatastali", "tfNPianiComplessivi",
				"tfNPianiFtRisc", "tfIndirizzoCoordN", "tfIndirizzoCoordE", "bCercaCoordinate", "cbSistCatast",
				"tfSezCatasto", "tfFoglioCatasto", "tfParticCatasto", "tfSubaltCatasto", "calDtEmissione",
				"rbTipoScadenza", "tfAnnoCostr", "tfAnnoRistrutt", "tfDestUso", "tfCodEdificioScolastico",
				"cbFkTipoRistrutturaz", "cbFkTipolEdilizia", "cbFkTipolCostrutt", "cbFkProprietaEdi", "cbFkOggetto",
				"cbFkMotivo", "cbAltroServiziEnergia", "tblDichiarazioneIndipendenza", "txtCoCertificatore",
				"tfCodFiscCoCert", "bCercaCfCertificatori", "cbListaCf", "tfCognomeCoCert", "tfNomeCoCert",
				"tfNumMatricolaCoCert", "txtNoteApeDatiGen", "bSalva", "txtNote1Foto", "txtObblDtFoto", "cbTipoFoto",
				"txtObblDtFotoAltre"};

		/**
		 * widget visibili nello stato
		 */
		static final String[] WIDGETS_SHOWN = new String[]{"txtObblDtCatastali", "cbProvDtCatastali",
				"cbComDtCatastali", "txtZonaClimatica", "cbSceltaIndDtCatastali", "tfIndirizzoDtCatastali",
				"tfNCivDtCatastali", "tfCAPDtCatastali", "tfInternoDtCatastali", "tfScalaDtCatastali",
				"tfPianoDtCatastali", "tfIndirizzoCoordN", "tfIndirizzoCoordE", "tfSezCatasto", "tfFoglioCatasto",
				"tfParticCatasto", "tfSubaltCatasto", "calDtEmissione", "rbTipoScadenza", "tfAnnoCostr",
				"tfAnnoRistrutt", "bViasualizzaApe", "bCompModApe", "bVerificaApe", "bConsolidaApe", "bInviaApe",
				"menu", "tsApe", "bIndietro", "txtNoteApeDatiGen", "tfNPianiComplessivi", "tfNPianiFtRisc",
				"cbFkTipoRistrutturaz", "cbFkTipolEdilizia", "cbFkTipolCostrutt", "cbFkProprietaEdi", "tfCodFiscCoCert",
				"tfCognomeCoCert", "tfNomeCoCert", "tfNumMatricolaCoCert", "cbFkMotivo", "cbFkOggetto",
				"cbAltroServiziEnergia", "txtCoCertificatore", "cbSistCatast", "tfDestUso", "tfCodEdificioScolastico",
				"tblDichiarazioneIndipendenza"};

		/**
		 * widget nascosti nello stato
		 */
		static final String[] WIDGETS_HIDDEN = new String[]{"tfRicercaIndirizzo", "vVerifIndDtCatastali",
				"svuotaIndDtCatastaliText", "bCercaCoordinate", "bCercaCfCertificatori", "cbListaCf", "bSalva",
				"btnEliminaFoto", "txtNote1Foto", "txtObblDtFoto", "fileFotoCatasto", "cbTipoFoto", "btnCaricaFoto",
				"txtObblDtFotoAltre", "fileFotoCatastoAltre", "cbTipoFotoAltre", "btnCaricaFotoAltre"};

		/**
		 * Istanza del comando che permette di passare a questo stato
		 */
		static final ScreenStateCommand COMMAND = new ScreenStateCommand("VISUALIZZAZIONE_NEW", WIDGETS_ON, WIDGETS_OFF,
				WIDGETS_SHOWN, WIDGETS_HIDDEN);

		/**
		 * Costruttore privato (questa e' una utility class)
		 */
		private VISUALIZZAZIONE_NEWScreenState() {
			// costruttore intenzionalmente vuoto
		}
	}

}
