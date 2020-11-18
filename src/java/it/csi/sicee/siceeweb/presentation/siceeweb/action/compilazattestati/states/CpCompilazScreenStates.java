package it.csi.sicee.siceeweb.presentation.siceeweb.action.compilazattestati.states;

import it.csi.sicee.siceeweb.presentation.siceeweb.action.ScreenStateCommand;

/**
 * Questa classe contiene le informazioni relative agli ScreenStates del ContentPanel cpCompilaz
 */
public final class CpCompilazScreenStates {

	/**
	 * Costruttore privato (questa e' una utility class)
	 */
	private CpCompilazScreenStates() {
		// costruttore intenzionalmente vuoto
	}

	/**
	 * Questa classe rappresenta lo ScreenState REGISTRAZIONE.
	 * NOTA BENE: questa classe e' attualmente non utilizzata (i widget visibili/abilitati sono
	 * contenuti nel file JSON che contiene il comando ScreenStateCommand.
	 * La classe e' pero' mantenuta per future evoluzioni. 
	 */
	public static final class REGISTRAZIONEScreenState {

		/**
		 * widget abilitati nello stato
		 */
		static final String[] WIDGETS_ON = new String[]{"bDtCatastaliIndietro", "bDtCatastaliAvanti",
				"vVerifIndDtCatastali", "vVerifIndProgettista", "menu", "txtObblDtCatastali", "cbProvDtCatastali",
				"cbComDtCatastali", "tfNCivDtCatastali", "tfCAPDtCatastali", "tfSezCatasto", "tfFoglioCatasto",
				"tfParticCatasto", "tfSubaltCatasto", "txtDescDtCatastaliSec", "cbProvDtCatastaliSec",
				"cbComDtCatastaliSec", "tfSezCatastoSec", "tfFoglioCatastoSec", "tfParticCatastoSec",
				"tfSubaltCatastoSec", "bAddDtCatastaleSecondario", "tblDtCatastaliSecondari",
				"bDelDtCatastaleSecondario", "tfPianoCatastali", "tfPianiTotCatastali", "tfNUnitaCatastali",
				"tfScalaCatastali", "tfInternoCatastali", "taNoteCatasto", "tfNomeProgettista", "tfCognomeProgettista",
				"cbRegProgettista", "cbProvProgettista", "cbComProgettista", "tfIndirizzoProgettista",
				"cbSceltaIndProgettista", "tfNCivProgettista", "tfCAPProgettista", "tfTelProgettista",
				"tfCellProgettista", "tfEmailProgettista", "tfFaxProgettista", "tfNomeDirLav", "tfCognomeDirLav",
				"cbRegDirLav", "cbProvDirLav", "cbComDirLav", "tfIndirizzoDirLav", "vVerifIndDirLav",
				"cbSceltaIndDirLav", "tfNCivDirLav", "tfCAPDirLav", "tfTelDirLav", "tfCellDirLav", "tfEmailDirLav",
				"tfFaxDirLav", "tfNomeCostr", "tfCognomeCostr", "cbRegCostr", "cbProvCostr", "cbComCostr",
				"tfIndirizzoCostr", "vVerifIndCostr", "cbSceltaIndCostr", "tfNCivCostr", "tfCAPCostr", "tfTelCostr",
				"tfCellCostr", "tfEmailCostr", "tfFaxCostr", "bDtResponsIndietro", "bDtResponsAvanti", "tfNome",
				"tfCognomeCoCertificatore", "tfMatrElencoRegCoCertificatore", "bDtCoCertificatoreIndietro",
				"bDtCertificatoreAvanti", "txtObblDtTecnici", "cbDestUso", "tfAnnoCostr", "tfAnnoRistrutt",
				"tfDescrizioneEdificio", "tfVolRiscaldato", "tfSuperfDispTot", "txtFattoreForma", "tfTrasmittOpache",
				"tfTrasmittTrasp", "tfSuperfUtile", "bDtTecniciCalcola", "bDtTecniciIndietro", "bDtTecniciAvanti",
				"txtObblFabbisogno", "tfFabbisognoRiscald", "txtLimiteNormaRegionale", "tfFabbisognoAcquaCalda",
				"tfEnAcquaCaldaRinnov", "txtNote1Fabbisogno", "bDtFabbisognoCalcola", "bDtFabbisognoIndietro",
				"bDtFabbisognoAvanti", "txtObblLocReale", "tfRendGenerazioneLocReale", "tfRendRegolazLocReale",
				"tfRendEmissLocReale", "tfRendDistribLocReale", "txtIndPrestEnergRiscaldLocReale",
				"txtIndPrestazEnergGlobLocReale", "txtNote1LocReale", "bDtLocReale", "bDtLocRealeIndietro",
				"bDtLocRealeAvanti", "txtObblLocTeor", "tfDomEnergRiscaldLocTeor", "txtLimNormRegLocTeor",
				"tfDomandaEnergAcquaCaldaLocTeor", "tfEnergTermAcquaCaldaRinnovLocTeor",
				"txtIndPrestazEnergGlobLocTeor", "txtClasseEnergLocTeor", "txtServEnergInclusiLocTeor",
				"txtNote1LocTeorica", "bDtLocTeor", "bDtLocTeoricaIndietro", "bDtLocTeoricaAvanti",
				"tfEmissioniGasSerra", "tfBoscoEquiv", "bDtGasSerraIndietro", "bDtGasSerraAvanti", "cbSistema",
				"tfIntervento", "rbsPriorita", "tfTempoRitorno", "bAddRaccomand", "tblRaccomandazioni", "bDelRaccomand",
				"bDtAltriRaccomandIndietro", "bDtAltriRaccomandAvanti", "cbClasseEnergEnerg", "tfPrestEnergRaggEnerg",
				"tfLimNormNazRiscaldEnerg", "cbQualitaInvolucroRaffrescEnerg", "txtRendGlobRiscaldEnerg",
				"tfValPrestPompaEnerg", "tfLimNormPrestPompaEnerg", "taAltreInfoEnerg", "bDtAltriEnergIndietro",
				"bDtAltriEnergAvanti", "cbMotivoRilascio", "tfMetodoCalcolo", "tfSoftwareUtilizzato",
				"tfDenominazProdSW", "bDtAltriGeneraliIndietro", "bDtAltriGeneraliAvanti", "txtObblDtSopralluoghi",
				"calDataSopralluogo", "taNoteSopralluogo", "cbDatiRedazione", "bDtAltriSopralluoghiIndietro",
				"bDtAltriSopralluoghiAvanti", "calDataTitoloAbitativo", "bDtNormative", "txtNormativa",
				"rbsAutorizzatoNormativa", "taMotivoNonAutorizz", "taUltNoteNormativa", "bDtNormativeIndietro",
				"bDtNormativeAvanti", "rbsImpBollinoRiscald", "tfNumBollinoImpRisc", "tfCodImpRiscald",
				"tfAnnoInstGenerRiscald", "tfPotenzaNomRiscald", "txtRendGenerazRiscald", "cbClasseEfficEnergRiscald",
				"cbTipoCombustibRiscald", "bDtriscaldamentoIndietro", "bDtRiscaldamentoAvanti", "tfAnnoInstGenerAcqua",
				"tfPotenzaNomAcqua", "cbClasseEfficEnergAcqua", "cbTipoCombustibAcqua", "bDtAcquaCaldaIndietro",
				"bDtAcquaCaldaAvanti", "tConsAnnoTermicoFossile", "tConsAnnoElettricoFossile", "tConsAnnoTermicoRinnov",
				"tConsAnnoElettricoRinnov", "tConsMedioTermico", "tConsMedioElettrico", "bDtConsumiIndietro",
				"bDtConsumiAvanti", "tfTechUsoFontiRinnov", "tfannoInstallFontiRinnov", "tfEnergTermicaProdRinnov",
				"tfEnergElettricaProdRinnov", "tfAutoconsumoTermicoRinnov", "tfAutoconsumoElettricoRinnov",
				"bDtFontiRinnovCalcola", "bDtFontiRinnovIndietro", "bDtFontiRinnovAvanti", "txtHeadDichiarazioni",
				"tblDichiarazioni", "calDataDichiarazione", "tfLuogoDichiarazione", "bDtDichiarazIndietro",
				"bDtDichiarazAvanti", "txtVisualizzaBozza", "btStampaBozza", "btStampaDefinitiva", "bDtStampaIndietro",
				"bDtStampaAvanti", "tfIndPrenenergRiscaldEnerg", "tfRendMedGlobImpTermicoLocReale", "bDtFotoIndietro",
				"bDtFotoAvanti", "txtObblDtFoto", "txtNomeFoto", "fileFotoCatasto", "txtNote1Foto", "btnCaricaFoto",
				"btnAnnullaAutorizzatoNormativa", "tfIndPrestEnergRiscaldLocTeor", "tfGradiGiorno", "txtZonaClimatica",
				"txtNote1DtCatastali", "rbsRipartizione", "tfTipoErogaz", "tfTipoDistribuz", "tfUIServite",
				"tfTipoRegolaz", "txtNote1Riscaldamento", "txtNote2Riscaldamento", "txtNote3Riscaldamento",
				"txtNote4Riscaldamento", "tfIndPrestazEnergAcquaCalda", "tfIndPrestEnergAcquaCaldaLocTeor",
				"rbsUsoPubblico", "cbTipoEdificio", "tfLimNormRegImpTerm", "bDtLimNormRegImpTermCalcola",
				"bDtEmissGasAndSuperfBosco", "cbEdificioPerformante", "txtObblAltriRaccomand",
				"txtObblDatiAltriGenerali", "txtObblDatiAltriEnerg", "txtObblDtRiscaldamento", "txtObblDtDichiarazioni",
				"cbTipoImpianto2", "cbCarattEdificio", "rbFabbisognoEnergia", "tfPercEnergiaFontiRinnov",
				"txtNote1FontiRinnovabili", "tfRicercaIndirizzo", "svuotaIndDtCatastaliText", "selezionaIndirizzo",
				"noIndirizzo", "tfRispondenzaUNITS"};

		/**
		 * widget disabilitati nello stato
		 */
		static final String[] WIDGETS_OFF = new String[]{"cbSceltaIndDtCatastali", "svuotaIndDtCatastaliCombo",
				"tfIndirizzoDtCatastali", "txtNote1DtTecnici", "tfFabbisognoCondiz", "tfIndPrestazEnergIlluminaz",
				"tfIndPrestazEnergCondizLocReale", "tfIndPrestazEnergIlluminazLocReale", "txtNote1DtAltriEnerg",
				"tipoImpianto", "txtNote5Riscaldamento", "txtObblDtAcquaCalda", "txtObblDtGasSerra", "txtNote1GasSerra",
				"txtDettVisualizzaBozza", "txtSpace", "txtVisualizzaDefinitivo", "txtDettVisualizzaDefinitivo"};

		/**
		 * widget visibili nello stato
		 */
		static final String[] WIDGETS_SHOWN = new String[]{"bDtCatastaliIndietro", "bDtCatastaliAvanti", "menu",
				"txtObblDtCatastali", "cbProvDtCatastali", "cbComDtCatastali", "tfIndirizzoDtCatastali",
				"vVerifIndDtCatastali", "tfNCivDtCatastali", "tfCAPDtCatastali", "tfSezCatasto", "tfFoglioCatasto",
				"tfParticCatasto", "tfSubaltCatasto", "txtDescDtCatastaliSec", "cbProvDtCatastaliSec",
				"cbComDtCatastaliSec", "tfSezCatastoSec", "tfFoglioCatastoSec", "tfParticCatastoSec",
				"tfSubaltCatastoSec", "bAddDtCatastaleSecondario", "tblDtCatastaliSecondari",
				"bDelDtCatastaleSecondario", "tfPianoCatastali", "tfPianiTotCatastali", "tfNUnitaCatastali",
				"tfScalaCatastali", "tfInternoCatastali", "taNoteCatasto", "tfNomeProgettista", "tfCognomeProgettista",
				"cbRegProgettista", "cbProvProgettista", "cbComProgettista", "tfIndirizzoProgettista",
				"vVerifIndProgettista", "cbSceltaIndProgettista", "tfNCivProgettista", "tfCAPProgettista",
				"tfTelProgettista", "tfCellProgettista", "tfEmailProgettista", "tfFaxProgettista", "tfNomeDirLav",
				"tfCognomeDirLav", "cbRegDirLav", "cbProvDirLav", "cbComDirLav", "tfIndirizzoDirLav", "vVerifIndDirLav",
				"cbSceltaIndDirLav", "tfNCivDirLav", "tfCAPDirLav", "tfTelDirLav", "tfCellDirLav", "tfEmailDirLav",
				"tfFaxDirLav", "tfNomeCostr", "tfCognomeCostr", "cbRegCostr", "cbProvCostr", "cbComCostr",
				"tfIndirizzoCostr", "vVerifIndCostr", "cbSceltaIndCostr", "tfNCivCostr", "tfCAPCostr", "tfTelCostr",
				"tfCellCostr", "tfEmailCostr", "tfFaxCostr", "bDtResponsIndietro", "bDtResponsAvanti", "tfNome",
				"tfCognomeCoCertificatore", "tfMatrElencoRegCoCertificatore", "bDtCoCertificatoreIndietro",
				"bDtCertificatoreAvanti", "txtObblDtTecnici", "cbDestUso", "tfAnnoCostr", "tfAnnoRistrutt",
				"tfDescrizioneEdificio", "tfVolRiscaldato", "tfSuperfDispTot", "txtFattoreForma", "tfTrasmittOpache",
				"tfTrasmittTrasp", "tfSuperfUtile", "bDtTecniciCalcola", "bDtTecniciIndietro", "bDtTecniciAvanti",
				"txtObblFabbisogno", "tfFabbisognoRiscald", "txtLimiteNormaRegionale", "tfFabbisognoCondiz",
				"tfFabbisognoAcquaCalda", "tfEnAcquaCaldaRinnov", "tfIndPrestazEnergIlluminaz", "txtNote1Fabbisogno",
				"bDtFabbisognoCalcola", "bDtFabbisognoIndietro", "bDtFabbisognoAvanti", "txtObblLocReale",
				"tfRendGenerazioneLocReale", "tfRendRegolazLocReale", "tfRendEmissLocReale", "tfRendDistribLocReale",
				"txtIndPrestEnergRiscaldLocReale", "tfIndPrestazEnergCondizLocReale",
				"tfIndPrestazEnergIlluminazLocReale", "txtIndPrestazEnergGlobLocReale", "txtNote1LocReale",
				"bDtLocReale", "bDtLocRealeIndietro", "bDtLocRealeAvanti", "txtObblLocTeor", "tfDomEnergRiscaldLocTeor",
				"txtLimNormRegLocTeor", "tfDomandaEnergAcquaCaldaLocTeor", "tfEnergTermAcquaCaldaRinnovLocTeor",
				"txtIndPrestazEnergGlobLocTeor", "txtClasseEnergLocTeor", "txtServEnergInclusiLocTeor",
				"txtNote1LocTeorica", "bDtLocTeor", "bDtLocTeoricaIndietro", "bDtLocTeoricaAvanti",
				"tfEmissioniGasSerra", "tfBoscoEquiv", "bDtGasSerraIndietro", "bDtGasSerraAvanti", "cbSistema",
				"tfIntervento", "rbsPriorita", "tfTempoRitorno", "bAddRaccomand", "tblRaccomandazioni", "bDelRaccomand",
				"bDtAltriRaccomandIndietro", "bDtAltriRaccomandAvanti", "cbClasseEnergEnerg", "tfPrestEnergRaggEnerg",
				"tfLimNormNazRiscaldEnerg", "cbQualitaInvolucroRaffrescEnerg", "txtRendGlobRiscaldEnerg",
				"tfValPrestPompaEnerg", "tfLimNormPrestPompaEnerg", "taAltreInfoEnerg", "bDtAltriEnergIndietro",
				"bDtAltriEnergAvanti", "cbMotivoRilascio", "tfMetodoCalcolo", "tfSoftwareUtilizzato",
				"tfDenominazProdSW", "bDtAltriGeneraliIndietro", "bDtAltriGeneraliAvanti", "txtObblDtSopralluoghi",
				"calDataSopralluogo", "taNoteSopralluogo", "cbDatiRedazione", "bDtAltriSopralluoghiIndietro",
				"bDtAltriSopralluoghiAvanti", "calDataTitoloAbitativo", "bDtNormative", "txtNormativa",
				"rbsAutorizzatoNormativa", "taMotivoNonAutorizz", "taUltNoteNormativa", "bDtNormativeIndietro",
				"bDtNormativeAvanti", "rbsImpBollinoRiscald", "tfNumBollinoImpRisc", "tfCodImpRiscald",
				"tfAnnoInstGenerRiscald", "tfPotenzaNomRiscald", "txtRendGenerazRiscald", "cbClasseEfficEnergRiscald",
				"cbTipoCombustibRiscald", "bDtriscaldamentoIndietro", "bDtRiscaldamentoAvanti", "tfAnnoInstGenerAcqua",
				"tfPotenzaNomAcqua", "cbClasseEfficEnergAcqua", "cbTipoCombustibAcqua", "bDtAcquaCaldaIndietro",
				"bDtAcquaCaldaAvanti", "tConsAnnoTermicoFossile", "tConsAnnoElettricoFossile", "tConsAnnoTermicoRinnov",
				"tConsAnnoElettricoRinnov", "tConsMedioTermico", "tConsMedioElettrico", "bDtConsumiIndietro",
				"bDtConsumiAvanti", "tfTechUsoFontiRinnov", "tfannoInstallFontiRinnov", "tfEnergTermicaProdRinnov",
				"tfEnergElettricaProdRinnov", "tfAutoconsumoTermicoRinnov", "tfAutoconsumoElettricoRinnov",
				"bDtFontiRinnovCalcola", "bDtFontiRinnovIndietro", "bDtFontiRinnovAvanti", "txtHeadDichiarazioni",
				"tblDichiarazioni", "calDataDichiarazione", "tfLuogoDichiarazione", "bDtDichiarazIndietro",
				"bDtDichiarazAvanti", "txtVisualizzaBozza", "btStampaBozza", "btStampaDefinitiva", "bDtStampaIndietro",
				"bDtStampaAvanti", "txtNote1DtTecnici", "txtNote1GasSerra", "tfUIServite", "txtDettVisualizzaBozza",
				"txtVisualizzaDefinitivo", "txtDettVisualizzaDefinitivo", "tfIndPrenenergRiscaldEnerg",
				"txtNote1DtAltriEnerg", "tfRendMedGlobImpTermicoLocReale", "txtObblDtFoto", "txtNomeFoto",
				"fileFotoCatasto", "txtNote1Foto", "bDtFotoIndietro", "bDtFotoAvanti", "btnCaricaFoto",
				"btnAnnullaAutorizzatoNormativa", "txtObblAltriRaccomand", "tfIndPrestEnergRiscaldLocTeor",
				"tfGradiGiorno", "txtZonaClimatica", "txtNote1DtCatastali", "rbsRipartizione", "tfTipoErogaz",
				"tfTipoDistribuz", "tfTipoRegolaz", "txtNote1Riscaldamento", "txtNote2Riscaldamento",
				"txtNote3Riscaldamento", "txtNote4Riscaldamento", "tfIndPrestazEnergAcquaCalda",
				"tfIndPrestEnergAcquaCaldaLocTeor", "rbsUsoPubblico", "cbTipoEdificio", "tfLimNormRegImpTerm",
				"bDtLimNormRegImpTermCalcola", "bDtEmissGasAndSuperfBosco", "cbEdificioPerformante",
				"txtObblDatiAltriGenerali", "txtObblDatiAltriEnerg", "txtObblDtRiscaldamento", "txtObblDtDichiarazioni",
				"txtObblDtAcquaCalda", "txtObblDtGasSerra", "txtNote5Riscaldamento", "cbTipoImpianto2",
				"cbCarattEdificio", "rbFabbisognoEnergia", "tfPercEnergiaFontiRinnov", "txtNote1FontiRinnovabili",
				"tfRicercaIndirizzo", "svuotaIndDtCatastaliText", "tfRispondenzaUNITS", "tipoImpianto"};

		/**
		 * widget nascosti nello stato
		 */
		static final String[] WIDGETS_HIDDEN = new String[]{"selezionaIndirizzo", "cbSceltaIndDtCatastali",
				"svuotaIndDtCatastaliCombo", "noIndirizzo", "txtSpace"};

		/**
		 * Istanza del comando che permette di passare a questo stato
		 */
		static final ScreenStateCommand COMMAND = new ScreenStateCommand("REGISTRAZIONE", WIDGETS_ON, WIDGETS_OFF,
				WIDGETS_SHOWN, WIDGETS_HIDDEN);

		/**
		 * Costruttore privato (questa e' una utility class)
		 */
		private REGISTRAZIONEScreenState() {
			// costruttore intenzionalmente vuoto
		}
	}

	/**
	 * Questa classe rappresenta lo ScreenState VISUALIZZAZIONE.
	 * NOTA BENE: questa classe e' attualmente non utilizzata (i widget visibili/abilitati sono
	 * contenuti nel file JSON che contiene il comando ScreenStateCommand.
	 * La classe e' pero' mantenuta per future evoluzioni. 
	 */
	public static final class VISUALIZZAZIONEScreenState {

		/**
		 * widget abilitati nello stato
		 */
		static final String[] WIDGETS_ON = new String[]{"bDtCatastaliIndietro", "bDtCatastaliAvanti", "menu",
				"bDtResponsIndietro", "bDtResponsAvanti", "bDtCoCertificatoreIndietro", "bDtCertificatoreAvanti",
				"bDtTecniciIndietro", "bDtTecniciAvanti", "bDtFabbisognoIndietro", "bDtFabbisognoAvanti",
				"bDtLocRealeIndietro", "bDtLocRealeAvanti", "bDtLocTeoricaIndietro", "bDtLocTeoricaAvanti",
				"bDtAltriRaccomandIndietro", "bDtAltriRaccomandAvanti", "bDtAltriEnergIndietro", "bDtAltriEnergAvanti",
				"bDtAltriGeneraliIndietro", "bDtAltriGeneraliAvanti", "bDtAltriSopralluoghiIndietro",
				"bDtAltriSopralluoghiAvanti", "bDtNormativeIndietro", "bDtNormativeAvanti", "bDtriscaldamentoIndietro",
				"bDtRiscaldamentoAvanti", "bDtAcquaCaldaIndietro", "bDtAcquaCaldaAvanti", "bDtConsumiIndietro",
				"bDtConsumiAvanti", "bDtFontiRinnovIndietro", "bDtFontiRinnovAvanti", "bDtDichiarazIndietro",
				"bDtDichiarazAvanti", "btStampaDefinitiva", "bDtStampaIndietro", "bDtStampaAvanti",
				"bDtGasSerraIndietro", "bDtGasSerraAvanti", "bDtFotoIndietro", "bDtFotoAvanti"};

		/**
		 * widget disabilitati nello stato
		 */
		static final String[] WIDGETS_OFF = new String[]{"txtObblDtCatastali", "cbProvDtCatastali", "cbComDtCatastali",
				"txtZonaClimatica", "tfGradiGiorno", "tfRicercaIndirizzo", "vVerifIndDtCatastali", "selezionaIndirizzo",
				"cbSceltaIndDtCatastali", "svuotaIndDtCatastaliCombo", "noIndirizzo", "tfIndirizzoDtCatastali",
				"svuotaIndDtCatastaliText", "tfNCivDtCatastali", "tfCAPDtCatastali", "tfSezCatasto", "tfFoglioCatasto",
				"tfParticCatasto", "tfSubaltCatasto", "txtDescDtCatastaliSec", "cbProvDtCatastaliSec",
				"cbComDtCatastaliSec", "tfSezCatastoSec", "tfFoglioCatastoSec", "tfParticCatastoSec",
				"tfSubaltCatastoSec", "bAddDtCatastaleSecondario", "tblDtCatastaliSecondari",
				"bDelDtCatastaleSecondario", "tfPianoCatastali", "tfPianiTotCatastali", "tfNUnitaCatastali",
				"tfScalaCatastali", "tfInternoCatastali", "taNoteCatasto", "txtNote1DtCatastali", "tfNomeProgettista",
				"tfCognomeProgettista", "cbRegProgettista", "cbProvProgettista", "cbComProgettista",
				"tfIndirizzoProgettista", "vVerifIndProgettista", "cbSceltaIndProgettista", "tfNCivProgettista",
				"tfCAPProgettista", "tfTelProgettista", "tfCellProgettista", "tfEmailProgettista", "tfFaxProgettista",
				"tfNomeDirLav", "tfCognomeDirLav", "cbRegDirLav", "cbProvDirLav", "cbComDirLav", "tfIndirizzoDirLav",
				"vVerifIndDirLav", "cbSceltaIndDirLav", "tfNCivDirLav", "tfCAPDirLav", "tfTelDirLav", "tfCellDirLav",
				"tfEmailDirLav", "tfFaxDirLav", "tfNomeCostr", "tfCognomeCostr", "cbRegCostr", "cbProvCostr",
				"cbComCostr", "tfIndirizzoCostr", "vVerifIndCostr", "cbSceltaIndCostr", "tfNCivCostr", "tfCAPCostr",
				"tfTelCostr", "tfCellCostr", "tfEmailCostr", "tfFaxCostr", "tfNome", "tfCognomeCoCertificatore",
				"tfMatrElencoRegCoCertificatore", "txtObblDtTecnici", "cbDestUso", "cbTipoImpianto2", "cbTipoEdificio",
				"cbCarattEdificio", "rbsUsoPubblico", "tfAnnoCostr", "tfAnnoRistrutt", "tfDescrizioneEdificio",
				"tfSuperfUtile", "tfVolRiscaldato", "tfSuperfDispTot", "txtFattoreForma", "tfTrasmittOpache",
				"tfTrasmittTrasp", "txtNote1DtTecnici", "bDtTecniciCalcola", "txtObblFabbisogno", "tfFabbisognoRiscald",
				"txtLimiteNormaRegionale", "rbFabbisognoEnergia", "tfFabbisognoAcquaCalda", "tfEnAcquaCaldaRinnov",
				"tfIndPrestazEnergAcquaCalda", "tfFabbisognoCondiz", "tfIndPrestazEnergIlluminaz", "txtNote1Fabbisogno",
				"bDtFabbisognoCalcola", "txtObblLocReale", "tfRendGenerazioneLocReale", "tfRendRegolazLocReale",
				"tfRendEmissLocReale", "tfRendDistribLocReale", "tfRendMedGlobImpTermicoLocReale",
				"txtIndPrestEnergRiscaldLocReale", "tfIndPrestazEnergCondizLocReale",
				"tfIndPrestazEnergIlluminazLocReale", "txtIndPrestazEnergGlobLocReale", "txtNote1LocReale",
				"bDtLocReale", "txtObblLocTeor", "tfDomEnergRiscaldLocTeor", "txtLimNormRegLocTeor",
				"tfIndPrestEnergRiscaldLocTeor", "tfDomandaEnergAcquaCaldaLocTeor",
				"tfEnergTermAcquaCaldaRinnovLocTeor", "tfIndPrestEnergAcquaCaldaLocTeor",
				"txtIndPrestazEnergGlobLocTeor", "txtClasseEnergLocTeor", "txtServEnergInclusiLocTeor",
				"txtNote1LocTeorica", "bDtLocTeor", "tfTechUsoFontiRinnov", "tfannoInstallFontiRinnov",
				"tfEnergTermicaProdRinnov", "tfEnergElettricaProdRinnov", "tfAutoconsumoTermicoRinnov",
				"tfAutoconsumoElettricoRinnov", "tfPercEnergiaFontiRinnov", "txtNote1FontiRinnovabili",
				"bDtFontiRinnovCalcola", "txtObblDatiAltriGenerali", "cbMotivoRilascio", "tfMetodoCalcolo",
				"tfSoftwareUtilizzato", "tfDenominazProdSW", "tfRispondenzaUNITS", "txtObblAltriRaccomand", "cbSistema",
				"tfIntervento", "rbsPriorita", "tfTempoRitorno", "cbEdificioPerformante", "bAddRaccomand",
				"tblRaccomandazioni", "bDelRaccomand", "txtObblDatiAltriEnerg", "cbClasseEnergEnerg",
				"tfPrestEnergRaggEnerg", "tfIndPrenenergRiscaldEnerg", "tfLimNormNazRiscaldEnerg",
				"cbQualitaInvolucroRaffrescEnerg", "txtRendGlobRiscaldEnerg", "tfValPrestPompaEnerg",
				"tfLimNormPrestPompaEnerg", "taAltreInfoEnerg", "txtNote1DtAltriEnerg", "txtObblDtSopralluoghi",
				"calDataSopralluogo", "taNoteSopralluogo", "cbDatiRedazione", "calDataTitoloAbitativo", "bDtNormative",
				"txtNormativa", "rbsAutorizzatoNormativa", "btnAnnullaAutorizzatoNormativa", "taMotivoNonAutorizz",
				"taUltNoteNormativa", "txtObblDtRiscaldamento", "rbsImpBollinoRiscald", "tfNumBollinoImpRisc",
				"tfCodImpRiscald", "tfAnnoInstGenerRiscald", "tfPotenzaNomRiscald", "tfLimNormRegImpTerm",
				"txtRendGenerazRiscald", "cbClasseEfficEnergRiscald", "cbTipoCombustibRiscald", "tfUIServite",
				"rbsRipartizione", "tipoImpianto", "tfTipoErogaz", "tfTipoDistribuz", "tfTipoRegolaz",
				"txtNote1Riscaldamento", "txtNote5Riscaldamento", "txtNote2Riscaldamento", "txtNote3Riscaldamento",
				"txtNote4Riscaldamento", "bDtLimNormRegImpTermCalcola", "txtObblDtAcquaCalda", "tfAnnoInstGenerAcqua",
				"tfPotenzaNomAcqua", "cbClasseEfficEnergAcqua", "cbTipoCombustibAcqua", "txtObblDtGasSerra",
				"tfEmissioniGasSerra", "tfBoscoEquiv", "txtNote1GasSerra", "bDtEmissGasAndSuperfBosco",
				"tConsAnnoTermicoFossile", "tConsAnnoElettricoFossile", "tConsAnnoTermicoRinnov",
				"tConsAnnoElettricoRinnov", "tConsMedioTermico", "tConsMedioElettrico", "txtObblDtDichiarazioni",
				"txtHeadDichiarazioni", "tblDichiarazioni", "calDataDichiarazione", "tfLuogoDichiarazione",
				"txtObblDtFoto", "fileFotoCatasto", "txtNomeFoto", "txtNote1Foto", "btnCaricaFoto",
				"txtVisualizzaBozza", "txtDettVisualizzaBozza", "txtSpace", "txtVisualizzaDefinitivo",
				"txtDettVisualizzaDefinitivo", "btStampaBozza"};

		/**
		 * widget visibili nello stato
		 */
		static final String[] WIDGETS_SHOWN = new String[]{"bDtCatastaliIndietro", "bDtCatastaliAvanti", "menu",
				"txtObblDtCatastali", "cbProvDtCatastali", "cbComDtCatastali", "tfIndirizzoDtCatastali",
				"tfNCivDtCatastali", "tfCAPDtCatastali", "tfSezCatasto", "tfFoglioCatasto", "tfParticCatasto",
				"tfSubaltCatasto", "txtDescDtCatastaliSec", "cbProvDtCatastaliSec", "cbComDtCatastaliSec",
				"tfSezCatastoSec", "tfFoglioCatastoSec", "tfParticCatastoSec", "tfSubaltCatastoSec",
				"bAddDtCatastaleSecondario", "tblDtCatastaliSecondari", "bDelDtCatastaleSecondario", "tfPianoCatastali",
				"tfPianiTotCatastali", "tfNUnitaCatastali", "tfScalaCatastali", "tfInternoCatastali", "taNoteCatasto",
				"tfNomeProgettista", "tfCognomeProgettista", "cbRegProgettista", "cbProvProgettista",
				"cbComProgettista", "tfIndirizzoProgettista", "vVerifIndProgettista", "cbSceltaIndProgettista",
				"tfNCivProgettista", "tfCAPProgettista", "tfTelProgettista", "tfCellProgettista", "tfEmailProgettista",
				"tfFaxProgettista", "tfNomeDirLav", "tfCognomeDirLav", "cbRegDirLav", "cbProvDirLav", "cbComDirLav",
				"tfIndirizzoDirLav", "vVerifIndDirLav", "cbSceltaIndDirLav", "tfNCivDirLav", "tfCAPDirLav",
				"tfTelDirLav", "tfCellDirLav", "tfEmailDirLav", "tfFaxDirLav", "tfNomeCostr", "tfCognomeCostr",
				"cbRegCostr", "cbProvCostr", "cbComCostr", "tfIndirizzoCostr", "vVerifIndCostr", "cbSceltaIndCostr",
				"tfNCivCostr", "tfCAPCostr", "tfTelCostr", "tfCellCostr", "tfEmailCostr", "tfFaxCostr",
				"bDtResponsIndietro", "bDtResponsAvanti", "tfNome", "tfCognomeCoCertificatore",
				"tfMatrElencoRegCoCertificatore", "bDtCoCertificatoreIndietro", "bDtCertificatoreAvanti",
				"txtObblDtTecnici", "cbDestUso", "tfAnnoCostr", "tfAnnoRistrutt", "tfDescrizioneEdificio",
				"tfVolRiscaldato", "tfSuperfDispTot", "txtFattoreForma", "tfTrasmittOpache", "tfTrasmittTrasp",
				"tfSuperfUtile", "bDtTecniciCalcola", "bDtTecniciIndietro", "bDtTecniciAvanti", "txtObblFabbisogno",
				"tfFabbisognoRiscald", "txtLimiteNormaRegionale", "tfFabbisognoCondiz", "tfFabbisognoAcquaCalda",
				"tfEnAcquaCaldaRinnov", "tfIndPrestazEnergIlluminaz", "txtNote1Fabbisogno", "bDtFabbisognoCalcola",
				"bDtFabbisognoIndietro", "bDtFabbisognoAvanti", "txtObblLocReale", "tfRendGenerazioneLocReale",
				"tfRendRegolazLocReale", "tfRendEmissLocReale", "tfRendDistribLocReale",
				"txtIndPrestEnergRiscaldLocReale", "tfIndPrestazEnergCondizLocReale",
				"tfIndPrestazEnergIlluminazLocReale", "txtIndPrestazEnergGlobLocReale", "txtNote1LocReale",
				"bDtLocReale", "bDtLocRealeIndietro", "bDtLocRealeAvanti", "txtObblLocTeor", "tfDomEnergRiscaldLocTeor",
				"txtLimNormRegLocTeor", "tfDomandaEnergAcquaCaldaLocTeor", "tfEnergTermAcquaCaldaRinnovLocTeor",
				"txtIndPrestazEnergGlobLocTeor", "txtClasseEnergLocTeor", "txtServEnergInclusiLocTeor",
				"txtNote1LocTeorica", "bDtLocTeor", "bDtLocTeoricaIndietro", "bDtLocTeoricaAvanti",
				"tfEmissioniGasSerra", "tfBoscoEquiv", "bDtGasSerraIndietro", "bDtGasSerraAvanti", "cbSistema",
				"tfIntervento", "rbsPriorita", "tfTempoRitorno", "bAddRaccomand", "tblRaccomandazioni", "bDelRaccomand",
				"bDtAltriRaccomandIndietro", "bDtAltriRaccomandAvanti", "cbClasseEnergEnerg", "tfPrestEnergRaggEnerg",
				"tfLimNormNazRiscaldEnerg", "cbQualitaInvolucroRaffrescEnerg", "txtRendGlobRiscaldEnerg",
				"tfValPrestPompaEnerg", "tfLimNormPrestPompaEnerg", "taAltreInfoEnerg", "bDtAltriEnergIndietro",
				"bDtAltriEnergAvanti", "cbMotivoRilascio", "tfMetodoCalcolo", "tfSoftwareUtilizzato",
				"tfDenominazProdSW", "bDtAltriGeneraliIndietro", "bDtAltriGeneraliAvanti", "txtObblDtSopralluoghi",
				"calDataSopralluogo", "taNoteSopralluogo", "cbDatiRedazione", "bDtAltriSopralluoghiIndietro",
				"bDtAltriSopralluoghiAvanti", "calDataTitoloAbitativo", "bDtNormative", "txtNormativa",
				"rbsAutorizzatoNormativa", "taMotivoNonAutorizz", "taUltNoteNormativa", "bDtNormativeIndietro",
				"bDtNormativeAvanti", "rbsImpBollinoRiscald", "tfNumBollinoImpRisc", "tfCodImpRiscald",
				"tfAnnoInstGenerRiscald", "tfPotenzaNomRiscald", "txtRendGenerazRiscald", "cbClasseEfficEnergRiscald",
				"cbTipoCombustibRiscald", "bDtriscaldamentoIndietro", "bDtRiscaldamentoAvanti", "tfAnnoInstGenerAcqua",
				"tfPotenzaNomAcqua", "cbClasseEfficEnergAcqua", "cbTipoCombustibAcqua", "bDtAcquaCaldaIndietro",
				"bDtAcquaCaldaAvanti", "tConsAnnoTermicoFossile", "tConsAnnoElettricoFossile", "tConsAnnoTermicoRinnov",
				"tConsAnnoElettricoRinnov", "tConsMedioTermico", "tConsMedioElettrico", "bDtConsumiIndietro",
				"bDtConsumiAvanti", "tfTechUsoFontiRinnov", "tfannoInstallFontiRinnov", "tfEnergTermicaProdRinnov",
				"tfEnergElettricaProdRinnov", "tfAutoconsumoTermicoRinnov", "tfAutoconsumoElettricoRinnov",
				"bDtFontiRinnovCalcola", "bDtFontiRinnovIndietro", "bDtFontiRinnovAvanti", "txtHeadDichiarazioni",
				"tblDichiarazioni", "calDataDichiarazione", "tfLuogoDichiarazione", "bDtDichiarazIndietro",
				"bDtDichiarazAvanti", "txtVisualizzaBozza", "btStampaBozza", "btStampaDefinitiva", "bDtStampaIndietro",
				"bDtStampaAvanti", "txtNote1DtTecnici", "txtNote1GasSerra", "tfUIServite", "tfIndPrenenergRiscaldEnerg",
				"txtDettVisualizzaBozza", "txtVisualizzaDefinitivo", "txtDettVisualizzaDefinitivo",
				"txtNote1DtAltriEnerg", "tfRendMedGlobImpTermicoLocReale", "txtObblDtFoto", "txtNomeFoto",
				"fileFotoCatasto", "txtNote1Foto", "bDtFotoIndietro", "bDtFotoAvanti", "btnCaricaFoto",
				"btnAnnullaAutorizzatoNormativa", "txtObblAltriRaccomand", "tfIndPrestEnergRiscaldLocTeor",
				"tfGradiGiorno", "txtZonaClimatica", "txtNote1DtCatastali", "rbsRipartizione", "tfTipoErogaz",
				"tfTipoDistribuz", "tfTipoRegolaz", "txtNote1Riscaldamento", "txtNote2Riscaldamento",
				"txtNote3Riscaldamento", "txtNote4Riscaldamento", "tfIndPrestazEnergAcquaCalda",
				"tfIndPrestEnergAcquaCaldaLocTeor", "rbsUsoPubblico", "cbTipoEdificio", "tfLimNormRegImpTerm",
				"bDtLimNormRegImpTermCalcola", "bDtEmissGasAndSuperfBosco", "cbEdificioPerformante",
				"txtObblDatiAltriGenerali", "txtObblDatiAltriEnerg", "txtObblDtRiscaldamento", "txtObblDtDichiarazioni",
				"txtObblDtAcquaCalda", "txtObblDtGasSerra", "txtNote5Riscaldamento", "cbTipoImpianto2",
				"cbCarattEdificio", "rbFabbisognoEnergia", "tfPercEnergiaFontiRinnov", "txtNote1FontiRinnovabili",
				"tfRispondenzaUNITS"};

		/**
		 * widget nascosti nello stato
		 */
		static final String[] WIDGETS_HIDDEN = new String[]{"tfRicercaIndirizzo", "vVerifIndDtCatastali",
				"selezionaIndirizzo", "cbSceltaIndDtCatastali", "svuotaIndDtCatastaliCombo", "noIndirizzo",
				"svuotaIndDtCatastaliText", "tipoImpianto", "txtSpace"};

		/**
		 * Istanza del comando che permette di passare a questo stato
		 */
		static final ScreenStateCommand COMMAND = new ScreenStateCommand("VISUALIZZAZIONE", WIDGETS_ON, WIDGETS_OFF,
				WIDGETS_SHOWN, WIDGETS_HIDDEN);

		/**
		 * Costruttore privato (questa e' una utility class)
		 */
		private VISUALIZZAZIONEScreenState() {
			// costruttore intenzionalmente vuoto
		}
	}

}
