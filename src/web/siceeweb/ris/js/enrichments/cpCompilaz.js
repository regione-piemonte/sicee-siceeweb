

/**
 * Arricchimenti standard per il ContentPanel [cpCompilaz] da registrare nella
 * variabile globale uiEnricherMgr
 */
function initStdEnrichments4CpCompilaz() {
	var contentPanelName = "cpCompilaz";


	/// arricchimento di base per guigen::TextField [tfGradiGiorno]
	var addBasicEnrichmentToTfGradiGiorno =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfGradiGiorno',
			 	false,
			 	'it.csi.sicee.siceeweb.dto.type.UDTPositiveInteger',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_pDtCatastali1Part", addBasicEnrichmentToTfGradiGiorno);
	/// arricchimento di base per guigen::TextField [tfRicercaIndirizzo]
	var addBasicEnrichmentToTfRicercaIndirizzo =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfRicercaIndirizzo',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_pDtCatastali1Part", addBasicEnrichmentToTfRicercaIndirizzo);

	/// arricchimento di base per guigen::TextField [tfIndirizzoDtCatastali]
	var addBasicEnrichmentToTfIndirizzoDtCatastali =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfIndirizzoDtCatastali',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_pDtCatastali1Part", addBasicEnrichmentToTfIndirizzoDtCatastali);
	/// arricchimento di base per guigen::TextField [tfNCivDtCatastali]
	var addBasicEnrichmentToTfNCivDtCatastali =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfNCivDtCatastali',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_pDtCatastali1Part", addBasicEnrichmentToTfNCivDtCatastali);
	/// arricchimento di base per guigen::TextField [tfCAPDtCatastali]
	var addBasicEnrichmentToTfCAPDtCatastali =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfCAPDtCatastali',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_pDtCatastali1Part", addBasicEnrichmentToTfCAPDtCatastali);
	/// arricchimento di base per guigen::TextField [tfSezCatasto]
	var addBasicEnrichmentToTfSezCatasto =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfSezCatasto',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_pDtCatastali1Part", addBasicEnrichmentToTfSezCatasto);
	/// arricchimento di base per guigen::TextField [tfFoglioCatasto]
	var addBasicEnrichmentToTfFoglioCatasto =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfFoglioCatasto',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_pDtCatastali1Part", addBasicEnrichmentToTfFoglioCatasto);
	/// arricchimento di base per guigen::TextField [tfParticCatasto]
	var addBasicEnrichmentToTfParticCatasto =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfParticCatasto',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_pDtCatastali1Part", addBasicEnrichmentToTfParticCatasto);
	/// arricchimento di base per guigen::TextField [tfSubaltCatasto]
	var addBasicEnrichmentToTfSubaltCatasto =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfSubaltCatasto',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_pDtCatastali1Part", addBasicEnrichmentToTfSubaltCatasto);


	/// arricchimento di base per guigen::TextField [tfSezCatastoSec]
	var addBasicEnrichmentToTfSezCatastoSec =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfSezCatastoSec',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_pDtCatastaliSecondari", addBasicEnrichmentToTfSezCatastoSec);
	/// arricchimento di base per guigen::TextField [tfFoglioCatastoSec]
	var addBasicEnrichmentToTfFoglioCatastoSec =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfFoglioCatastoSec',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_pDtCatastaliSecondari", addBasicEnrichmentToTfFoglioCatastoSec);
	/// arricchimento di base per guigen::TextField [tfParticCatastoSec]
	var addBasicEnrichmentToTfParticCatastoSec =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfParticCatastoSec',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_pDtCatastaliSecondari", addBasicEnrichmentToTfParticCatastoSec);
	/// arricchimento di base per guigen::TextField [tfSubaltCatastoSec]
	var addBasicEnrichmentToTfSubaltCatastoSec =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfSubaltCatastoSec',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_pDtCatastaliSecondari", addBasicEnrichmentToTfSubaltCatastoSec);


	/// arricchimento di base per guigen::TextField [tfPianoCatastali]
	var addBasicEnrichmentToTfPianoCatastali =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfPianoCatastali',
			 	false,
			 	'int',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_pDtCatastali2Part", addBasicEnrichmentToTfPianoCatastali);
	/// arricchimento di base per guigen::TextField [tfPianiTotCatastali]
	var addBasicEnrichmentToTfPianiTotCatastali =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfPianiTotCatastali',
			 	false,
			 	'it.csi.sicee.siceeweb.dto.type.UDTPositiveInteger',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_pDtCatastali2Part", addBasicEnrichmentToTfPianiTotCatastali);
	/// arricchimento di base per guigen::TextField [tfNUnitaCatastali]
	var addBasicEnrichmentToTfNUnitaCatastali =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfNUnitaCatastali',
			 	false,
			 	'it.csi.sicee.siceeweb.dto.type.UDTPositiveInteger',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_pDtCatastali2Part", addBasicEnrichmentToTfNUnitaCatastali);
	/// arricchimento di base per guigen::TextField [tfScalaCatastali]
	var addBasicEnrichmentToTfScalaCatastali =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfScalaCatastali',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_pDtCatastali2Part", addBasicEnrichmentToTfScalaCatastali);
	/// arricchimento di base per guigen::TextField [tfInternoCatastali]
	var addBasicEnrichmentToTfInternoCatastali =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfInternoCatastali',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_pDtCatastali2Part", addBasicEnrichmentToTfInternoCatastali);

	/// arricchimento di base per guigen::TextField [tfNomeProgettista]
	var addBasicEnrichmentToTfNomeProgettista =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfNomeProgettista',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_pDtProgettista", addBasicEnrichmentToTfNomeProgettista);
	/// arricchimento di base per guigen::TextField [tfCognomeProgettista]
	var addBasicEnrichmentToTfCognomeProgettista =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfCognomeProgettista',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_pDtProgettista", addBasicEnrichmentToTfCognomeProgettista);



	/// arricchimento di base per guigen::TextField [tfIndirizzoProgettista]
	var addBasicEnrichmentToTfIndirizzoProgettista =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfIndirizzoProgettista',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_pDtProgettista", addBasicEnrichmentToTfIndirizzoProgettista);

	/// arricchimento di base per guigen::TextField [tfNCivProgettista]
	var addBasicEnrichmentToTfNCivProgettista =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfNCivProgettista',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_pDtProgettista", addBasicEnrichmentToTfNCivProgettista);
	/// arricchimento di base per guigen::TextField [tfCAPProgettista]
	var addBasicEnrichmentToTfCAPProgettista =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfCAPProgettista',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_pDtProgettista", addBasicEnrichmentToTfCAPProgettista);
	/// arricchimento di base per guigen::TextField [tfTelProgettista]
	var addBasicEnrichmentToTfTelProgettista =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfTelProgettista',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_pDtProgettista", addBasicEnrichmentToTfTelProgettista);
	/// arricchimento di base per guigen::TextField [tfCellProgettista]
	var addBasicEnrichmentToTfCellProgettista =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfCellProgettista',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_pDtProgettista", addBasicEnrichmentToTfCellProgettista);
	/// arricchimento di base per guigen::TextField [tfEmailProgettista]
	var addBasicEnrichmentToTfEmailProgettista =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfEmailProgettista',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_pDtProgettista", addBasicEnrichmentToTfEmailProgettista);
	/// arricchimento di base per guigen::TextField [tfFaxProgettista]
	var addBasicEnrichmentToTfFaxProgettista =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfFaxProgettista',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_pDtProgettista", addBasicEnrichmentToTfFaxProgettista);
	/// arricchimento di base per guigen::TextField [tfNomeDirLav]
	var addBasicEnrichmentToTfNomeDirLav =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfNomeDirLav',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_pDtDirLav", addBasicEnrichmentToTfNomeDirLav);
	/// arricchimento di base per guigen::TextField [tfCognomeDirLav]
	var addBasicEnrichmentToTfCognomeDirLav =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfCognomeDirLav',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_pDtDirLav", addBasicEnrichmentToTfCognomeDirLav);



	/// arricchimento di base per guigen::TextField [tfIndirizzoDirLav]
	var addBasicEnrichmentToTfIndirizzoDirLav =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfIndirizzoDirLav',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_pDtDirLav", addBasicEnrichmentToTfIndirizzoDirLav);

	/// arricchimento di base per guigen::TextField [tfNCivDirLav]
	var addBasicEnrichmentToTfNCivDirLav =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfNCivDirLav',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_pDtDirLav", addBasicEnrichmentToTfNCivDirLav);
	/// arricchimento di base per guigen::TextField [tfCAPDirLav]
	var addBasicEnrichmentToTfCAPDirLav =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfCAPDirLav',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_pDtDirLav", addBasicEnrichmentToTfCAPDirLav);
	/// arricchimento di base per guigen::TextField [tfTelDirLav]
	var addBasicEnrichmentToTfTelDirLav =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfTelDirLav',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_pDtDirLav", addBasicEnrichmentToTfTelDirLav);
	/// arricchimento di base per guigen::TextField [tfCellDirLav]
	var addBasicEnrichmentToTfCellDirLav =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfCellDirLav',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_pDtDirLav", addBasicEnrichmentToTfCellDirLav);
	/// arricchimento di base per guigen::TextField [tfEmailDirLav]
	var addBasicEnrichmentToTfEmailDirLav =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfEmailDirLav',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_pDtDirLav", addBasicEnrichmentToTfEmailDirLav);
	/// arricchimento di base per guigen::TextField [tfFaxDirLav]
	var addBasicEnrichmentToTfFaxDirLav =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfFaxDirLav',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_pDtDirLav", addBasicEnrichmentToTfFaxDirLav);
	/// arricchimento di base per guigen::TextField [tfNomeCostr]
	var addBasicEnrichmentToTfNomeCostr =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfNomeCostr',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_pDtCostr", addBasicEnrichmentToTfNomeCostr);
	/// arricchimento di base per guigen::TextField [tfCognomeCostr]
	var addBasicEnrichmentToTfCognomeCostr =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfCognomeCostr',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_pDtCostr", addBasicEnrichmentToTfCognomeCostr);



	/// arricchimento di base per guigen::TextField [tfIndirizzoCostr]
	var addBasicEnrichmentToTfIndirizzoCostr =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfIndirizzoCostr',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_pDtCostr", addBasicEnrichmentToTfIndirizzoCostr);

	/// arricchimento di base per guigen::TextField [tfNCivCostr]
	var addBasicEnrichmentToTfNCivCostr =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfNCivCostr',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_pDtCostr", addBasicEnrichmentToTfNCivCostr);
	/// arricchimento di base per guigen::TextField [tfCAPCostr]
	var addBasicEnrichmentToTfCAPCostr =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfCAPCostr',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_pDtCostr", addBasicEnrichmentToTfCAPCostr);
	/// arricchimento di base per guigen::TextField [tfTelCostr]
	var addBasicEnrichmentToTfTelCostr =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfTelCostr',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_pDtCostr", addBasicEnrichmentToTfTelCostr);
	/// arricchimento di base per guigen::TextField [tfCellCostr]
	var addBasicEnrichmentToTfCellCostr =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfCellCostr',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_pDtCostr", addBasicEnrichmentToTfCellCostr);
	/// arricchimento di base per guigen::TextField [tfEmailCostr]
	var addBasicEnrichmentToTfEmailCostr =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfEmailCostr',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_pDtCostr", addBasicEnrichmentToTfEmailCostr);
	/// arricchimento di base per guigen::TextField [tfFaxCostr]
	var addBasicEnrichmentToTfFaxCostr =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfFaxCostr',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_pDtCostr", addBasicEnrichmentToTfFaxCostr);

	/// arricchimento di base per guigen::TextField [tfNome]
	var addBasicEnrichmentToTfNome =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfNome',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_pDtCoCertificatore", addBasicEnrichmentToTfNome);
	/// arricchimento di base per guigen::TextField [tfCognomeCoCertificatore]
	var addBasicEnrichmentToTfCognomeCoCertificatore =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfCognomeCoCertificatore',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_pDtCoCertificatore", addBasicEnrichmentToTfCognomeCoCertificatore);
	/// arricchimento di base per guigen::TextField [tfMatrElencoRegCoCertificatore]
	var addBasicEnrichmentToTfMatrElencoRegCoCertificatore =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfMatrElencoRegCoCertificatore',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_pDtCoCertificatore", addBasicEnrichmentToTfMatrElencoRegCoCertificatore);





	/// arricchimento di base per guigen::TextField [tfAnnoCostr]
	var addBasicEnrichmentToTfAnnoCostr =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfAnnoCostr',
			 	false,
			 	'it.csi.sicee.siceeweb.dto.type.UDTPositiveInteger',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_pDtTecnici", addBasicEnrichmentToTfAnnoCostr);
	/// arricchimento di base per guigen::TextField [tfAnnoRistrutt]
	var addBasicEnrichmentToTfAnnoRistrutt =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfAnnoRistrutt',
			 	false,
			 	'it.csi.sicee.siceeweb.dto.type.UDTPositiveInteger',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_pDtTecnici", addBasicEnrichmentToTfAnnoRistrutt);
	/// arricchimento di base per guigen::TextField [tfDescrizioneEdificio]
	var addBasicEnrichmentToTfDescrizioneEdificio =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfDescrizioneEdificio',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_pDtTecnici", addBasicEnrichmentToTfDescrizioneEdificio);
	/// arricchimento di base per guigen::TextField [tfSuperfUtile]
	var addBasicEnrichmentToTfSuperfUtile =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfSuperfUtile',
			 	false,
			 	'it.csi.sicee.siceeweb.dto.type.UDTPositiveDoubleFour',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_pDtTecnici", addBasicEnrichmentToTfSuperfUtile);
	/// arricchimento di base per guigen::TextField [tfVolRiscaldato]
	var addBasicEnrichmentToTfVolRiscaldato =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfVolRiscaldato',
			 	false,
			 	'it.csi.sicee.siceeweb.dto.type.UDTPositiveDoubleFour',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_pDtTecnici", addBasicEnrichmentToTfVolRiscaldato);
	/// arricchimento di base per guigen::TextField [tfSuperfDispTot]
	var addBasicEnrichmentToTfSuperfDispTot =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfSuperfDispTot',
			 	false,
			 	'it.csi.sicee.siceeweb.dto.type.UDTPositiveDoubleFour',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_pDtTecnici", addBasicEnrichmentToTfSuperfDispTot);
	/// arricchimento di base per guigen::TextField [tfTrasmittOpache]
	var addBasicEnrichmentToTfTrasmittOpache =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfTrasmittOpache',
			 	false,
			 	'it.csi.sicee.siceeweb.dto.type.UDTPositiveDoubleFour',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_pDtTecnici", addBasicEnrichmentToTfTrasmittOpache);
	/// arricchimento di base per guigen::TextField [tfTrasmittTrasp]
	var addBasicEnrichmentToTfTrasmittTrasp =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfTrasmittTrasp',
			 	false,
			 	'it.csi.sicee.siceeweb.dto.type.UDTPositiveDoubleFour',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_pDtTecnici", addBasicEnrichmentToTfTrasmittTrasp);


	/// arricchimento di base per guigen::TextField [tfFabbisognoRiscald]
	var addBasicEnrichmentToTfFabbisognoRiscald =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfFabbisognoRiscald',
			 	false,
			 	'it.csi.sicee.siceeweb.dto.type.UDTPositiveDoubleFour',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_pDtFabbisogno", addBasicEnrichmentToTfFabbisognoRiscald);
	/// arricchimento di base per guigen::TextField [tfFabbisognoAcquaCalda]
	var addBasicEnrichmentToTfFabbisognoAcquaCalda =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfFabbisognoAcquaCalda',
			 	false,
			 	'it.csi.sicee.siceeweb.dto.type.UDTPositiveDoubleFour',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_pDtFabbisogno", addBasicEnrichmentToTfFabbisognoAcquaCalda);
	/// arricchimento di base per guigen::TextField [tfEnAcquaCaldaRinnov]
	var addBasicEnrichmentToTfEnAcquaCaldaRinnov =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfEnAcquaCaldaRinnov',
			 	false,
			 	'it.csi.sicee.siceeweb.dto.type.UDTPositiveDoubleFour',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_pDtFabbisogno", addBasicEnrichmentToTfEnAcquaCaldaRinnov);
	/// arricchimento di base per guigen::TextField [tfIndPrestazEnergAcquaCalda]
	var addBasicEnrichmentToTfIndPrestazEnergAcquaCalda =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfIndPrestazEnergAcquaCalda',
			 	false,
			 	'it.csi.sicee.siceeweb.dto.type.UDTPositiveDoubleFour',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_pDtFabbisogno", addBasicEnrichmentToTfIndPrestazEnergAcquaCalda);
	/// arricchimento di base per guigen::TextField [tfFabbisognoCondiz]
	var addBasicEnrichmentToTfFabbisognoCondiz =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfFabbisognoCondiz',
			 	false,
			 	'it.csi.sicee.siceeweb.dto.type.UDTPositiveDoubleFour',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_pDtFabbisogno", addBasicEnrichmentToTfFabbisognoCondiz);
	/// arricchimento di base per guigen::TextField [tfIndPrestazEnergIlluminaz]
	var addBasicEnrichmentToTfIndPrestazEnergIlluminaz =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfIndPrestazEnergIlluminaz',
			 	false,
			 	'it.csi.sicee.siceeweb.dto.type.UDTPositiveDoubleFour',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_pDtFabbisogno", addBasicEnrichmentToTfIndPrestazEnergIlluminaz);


	/// arricchimento di base per guigen::TextField [tfRendGenerazioneLocReale]
	var addBasicEnrichmentToTfRendGenerazioneLocReale =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfRendGenerazioneLocReale',
			 	false,
			 	'it.csi.sicee.siceeweb.dto.type.UDTPositiveDoubleFour',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_pDtLocReale", addBasicEnrichmentToTfRendGenerazioneLocReale);
	/// arricchimento di base per guigen::TextField [tfRendRegolazLocReale]
	var addBasicEnrichmentToTfRendRegolazLocReale =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfRendRegolazLocReale',
			 	false,
			 	'it.csi.sicee.siceeweb.dto.type.UDTPositiveDoubleFour',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_pDtLocReale", addBasicEnrichmentToTfRendRegolazLocReale);
	/// arricchimento di base per guigen::TextField [tfRendEmissLocReale]
	var addBasicEnrichmentToTfRendEmissLocReale =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfRendEmissLocReale',
			 	false,
			 	'it.csi.sicee.siceeweb.dto.type.UDTPositiveDoubleFour',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_pDtLocReale", addBasicEnrichmentToTfRendEmissLocReale);
	/// arricchimento di base per guigen::TextField [tfRendDistribLocReale]
	var addBasicEnrichmentToTfRendDistribLocReale =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfRendDistribLocReale',
			 	false,
			 	'it.csi.sicee.siceeweb.dto.type.UDTPositiveDoubleFour',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_pDtLocReale", addBasicEnrichmentToTfRendDistribLocReale);
	/// arricchimento di base per guigen::TextField [tfRendMedGlobImpTermicoLocReale]
	var addBasicEnrichmentToTfRendMedGlobImpTermicoLocReale =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfRendMedGlobImpTermicoLocReale',
			 	false,
			 	'it.csi.sicee.siceeweb.dto.type.UDTPositiveDoubleFour',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_pDtLocReale", addBasicEnrichmentToTfRendMedGlobImpTermicoLocReale);
	/// arricchimento di base per guigen::TextField [tfIndPrestazEnergCondizLocReale]
	var addBasicEnrichmentToTfIndPrestazEnergCondizLocReale =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfIndPrestazEnergCondizLocReale',
			 	false,
			 	'it.csi.sicee.siceeweb.dto.type.UDTPositiveDoubleFour',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_pDtLocReale", addBasicEnrichmentToTfIndPrestazEnergCondizLocReale);
	/// arricchimento di base per guigen::TextField [tfIndPrestazEnergIlluminazLocReale]
	var addBasicEnrichmentToTfIndPrestazEnergIlluminazLocReale =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfIndPrestazEnergIlluminazLocReale',
			 	false,
			 	'it.csi.sicee.siceeweb.dto.type.UDTPositiveDoubleFour',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_pDtLocReale", addBasicEnrichmentToTfIndPrestazEnergIlluminazLocReale);


	/// arricchimento di base per guigen::TextField [tfDomEnergRiscaldLocTeor]
	var addBasicEnrichmentToTfDomEnergRiscaldLocTeor =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfDomEnergRiscaldLocTeor',
			 	false,
			 	'it.csi.sicee.siceeweb.dto.type.UDTPositiveDoubleFour',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_pDtLocTeorica", addBasicEnrichmentToTfDomEnergRiscaldLocTeor);
	/// arricchimento di base per guigen::TextField [tfIndPrestEnergRiscaldLocTeor]
	var addBasicEnrichmentToTfIndPrestEnergRiscaldLocTeor =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfIndPrestEnergRiscaldLocTeor',
			 	false,
			 	'it.csi.sicee.siceeweb.dto.type.UDTPositiveDoubleFour',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_pDtLocTeorica", addBasicEnrichmentToTfIndPrestEnergRiscaldLocTeor);
	/// arricchimento di base per guigen::TextField [tfDomandaEnergAcquaCaldaLocTeor]
	var addBasicEnrichmentToTfDomandaEnergAcquaCaldaLocTeor =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfDomandaEnergAcquaCaldaLocTeor',
			 	false,
			 	'it.csi.sicee.siceeweb.dto.type.UDTPositiveDoubleFour',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_pDtLocTeorica", addBasicEnrichmentToTfDomandaEnergAcquaCaldaLocTeor);
	/// arricchimento di base per guigen::TextField [tfEnergTermAcquaCaldaRinnovLocTeor]
	var addBasicEnrichmentToTfEnergTermAcquaCaldaRinnovLocTeor =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfEnergTermAcquaCaldaRinnovLocTeor',
			 	false,
			 	'it.csi.sicee.siceeweb.dto.type.UDTPositiveDoubleFour',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_pDtLocTeorica", addBasicEnrichmentToTfEnergTermAcquaCaldaRinnovLocTeor);
	/// arricchimento di base per guigen::TextField [tfIndPrestEnergAcquaCaldaLocTeor]
	var addBasicEnrichmentToTfIndPrestEnergAcquaCaldaLocTeor =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfIndPrestEnergAcquaCaldaLocTeor',
			 	false,
			 	'it.csi.sicee.siceeweb.dto.type.UDTPositiveDoubleFour',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_pDtLocTeorica", addBasicEnrichmentToTfIndPrestEnergAcquaCaldaLocTeor);


	/// arricchimento di base per guigen::TextField [tfTechUsoFontiRinnov]
	var addBasicEnrichmentToTfTechUsoFontiRinnov =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfTechUsoFontiRinnov',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_pDtFontiRinnov", addBasicEnrichmentToTfTechUsoFontiRinnov);
	/// arricchimento di base per guigen::TextField [tfannoInstallFontiRinnov]
	var addBasicEnrichmentToTfannoInstallFontiRinnov =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfannoInstallFontiRinnov',
			 	false,
			 	'it.csi.sicee.siceeweb.dto.type.UDTPositiveInteger',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_pDtFontiRinnov", addBasicEnrichmentToTfannoInstallFontiRinnov);
	/// arricchimento di base per guigen::TextField [tfEnergTermicaProdRinnov]
	var addBasicEnrichmentToTfEnergTermicaProdRinnov =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfEnergTermicaProdRinnov',
			 	false,
			 	'it.csi.sicee.siceeweb.dto.type.UDTPositiveDoubleFour',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_pDtFontiRinnov", addBasicEnrichmentToTfEnergTermicaProdRinnov);
	/// arricchimento di base per guigen::TextField [tfEnergElettricaProdRinnov]
	var addBasicEnrichmentToTfEnergElettricaProdRinnov =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfEnergElettricaProdRinnov',
			 	false,
			 	'it.csi.sicee.siceeweb.dto.type.UDTPositiveDoubleFour',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_pDtFontiRinnov", addBasicEnrichmentToTfEnergElettricaProdRinnov);
	/// arricchimento di base per guigen::TextField [tfAutoconsumoTermicoRinnov]
	var addBasicEnrichmentToTfAutoconsumoTermicoRinnov =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfAutoconsumoTermicoRinnov',
			 	false,
			 	'it.csi.sicee.siceeweb.dto.type.UDTPositiveDoubleFour',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_pDtFontiRinnov", addBasicEnrichmentToTfAutoconsumoTermicoRinnov);
	/// arricchimento di base per guigen::TextField [tfAutoconsumoElettricoRinnov]
	var addBasicEnrichmentToTfAutoconsumoElettricoRinnov =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfAutoconsumoElettricoRinnov',
			 	false,
			 	'it.csi.sicee.siceeweb.dto.type.UDTPositiveDoubleFour',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_pDtFontiRinnov", addBasicEnrichmentToTfAutoconsumoElettricoRinnov);
	/// arricchimento di base per guigen::TextField [tfPercEnergiaFontiRinnov]
	var addBasicEnrichmentToTfPercEnergiaFontiRinnov =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfPercEnergiaFontiRinnov',
			 	false,
			 	'it.csi.sicee.siceeweb.dto.type.UDTPositiveDoubleTwo',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_pDtFontiRinnov", addBasicEnrichmentToTfPercEnergiaFontiRinnov);



	/// arricchimento di base per guigen::TextField [tfMetodoCalcolo]
	var addBasicEnrichmentToTfMetodoCalcolo =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfMetodoCalcolo',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_pDtAltriGenerali", addBasicEnrichmentToTfMetodoCalcolo);
	/// arricchimento di base per guigen::TextField [tfSoftwareUtilizzato]
	var addBasicEnrichmentToTfSoftwareUtilizzato =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfSoftwareUtilizzato',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_pDtAltriGenerali", addBasicEnrichmentToTfSoftwareUtilizzato);
	/// arricchimento di base per guigen::TextField [tfDenominazProdSW]
	var addBasicEnrichmentToTfDenominazProdSW =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfDenominazProdSW',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_pDtAltriGenerali", addBasicEnrichmentToTfDenominazProdSW);


	/// arricchimento di base per guigen::TextField [tfIntervento]
	var addBasicEnrichmentToTfIntervento =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfIntervento',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_pDtAltriRaccomand1", addBasicEnrichmentToTfIntervento);
	/// arricchimento di base per guigen::TextField [tfTempoRitorno]
	var addBasicEnrichmentToTfTempoRitorno =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfTempoRitorno',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_pDtAltriRaccomand1", addBasicEnrichmentToTfTempoRitorno);




	/// arricchimento di base per guigen::TextField [tfPrestEnergRaggEnerg]
	var addBasicEnrichmentToTfPrestEnergRaggEnerg =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfPrestEnergRaggEnerg',
			 	false,
			 	'it.csi.sicee.siceeweb.dto.type.UDTPositiveDoubleFour',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_pDtAltriEnerg", addBasicEnrichmentToTfPrestEnergRaggEnerg);
	/// arricchimento di base per guigen::TextField [tfIndPrenenergRiscaldEnerg]
	var addBasicEnrichmentToTfIndPrenenergRiscaldEnerg =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfIndPrenenergRiscaldEnerg',
			 	false,
			 	'it.csi.sicee.siceeweb.dto.type.UDTPositiveDoubleFour',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_pDtAltriEnerg", addBasicEnrichmentToTfIndPrenenergRiscaldEnerg);
	/// arricchimento di base per guigen::TextField [tfLimNormNazRiscaldEnerg]
	var addBasicEnrichmentToTfLimNormNazRiscaldEnerg =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfLimNormNazRiscaldEnerg',
			 	false,
			 	'it.csi.sicee.siceeweb.dto.type.UDTPositiveDoubleFour',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_pDtAltriEnerg", addBasicEnrichmentToTfLimNormNazRiscaldEnerg);

	/// arricchimento di base per guigen::TextField [tfValPrestPompaEnerg]
	var addBasicEnrichmentToTfValPrestPompaEnerg =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfValPrestPompaEnerg',
			 	false,
			 	'it.csi.sicee.siceeweb.dto.type.UDTPositiveDoubleFour',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_pDtAltriEnerg", addBasicEnrichmentToTfValPrestPompaEnerg);
	/// arricchimento di base per guigen::TextField [tfLimNormPrestPompaEnerg]
	var addBasicEnrichmentToTfLimNormPrestPompaEnerg =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfLimNormPrestPompaEnerg',
			 	false,
			 	'it.csi.sicee.siceeweb.dto.type.UDTPositiveDoubleFour',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_pDtAltriEnerg", addBasicEnrichmentToTfLimNormPrestPompaEnerg);

	/// arricchimento per guigen::Calendar [calDataSopralluogo]: aggiunta datepicker
	var addDateToCalDataSopralluogo = function(){
		uiNRichLib.addDatePickerNRich("widg_calDataSopralluogo", 
		false, false, "", false);
	};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_pDtAltriSopralluoghi2", addDateToCalDataSopralluogo);


	/// arricchimento per guigen::Calendar [calDataTitoloAbitativo]: aggiunta datepicker
	var addDateToCalDataTitoloAbitativo = function(){
		uiNRichLib.addDatePickerNRich("widg_calDataTitoloAbitativo", 
		false, false, "", false);
	};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_pDtNormative", addDateToCalDataTitoloAbitativo);

	/// arricchimento di base per guigen::TextField [tfNumBollinoImpRisc]
	var addBasicEnrichmentToTfNumBollinoImpRisc =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfNumBollinoImpRisc',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_pDtRiscaldamento", addBasicEnrichmentToTfNumBollinoImpRisc);
	/// arricchimento di base per guigen::TextField [tfCodImpRiscald]
	var addBasicEnrichmentToTfCodImpRiscald =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfCodImpRiscald',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_pDtRiscaldamento", addBasicEnrichmentToTfCodImpRiscald);
	/// arricchimento di base per guigen::TextField [tfAnnoInstGenerRiscald]
	var addBasicEnrichmentToTfAnnoInstGenerRiscald =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfAnnoInstGenerRiscald',
			 	false,
			 	'it.csi.sicee.siceeweb.dto.type.UDTPositiveInteger',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_pDtRiscaldamento", addBasicEnrichmentToTfAnnoInstGenerRiscald);
	/// arricchimento di base per guigen::TextField [tfPotenzaNomRiscald]
	var addBasicEnrichmentToTfPotenzaNomRiscald =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfPotenzaNomRiscald',
			 	false,
			 	'it.csi.sicee.siceeweb.dto.type.UDTPositiveDoubleFour',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_pDtRiscaldamento", addBasicEnrichmentToTfPotenzaNomRiscald);
	/// arricchimento di base per guigen::TextField [tfLimNormRegImpTerm]
	var addBasicEnrichmentToTfLimNormRegImpTerm =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfLimNormRegImpTerm',
			 	false,
			 	'it.csi.sicee.siceeweb.dto.type.UDTPositiveDoubleFour',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_pDtRiscaldamento", addBasicEnrichmentToTfLimNormRegImpTerm);


	/// arricchimento di base per guigen::TextField [tfUIServite]
	var addBasicEnrichmentToTfUIServite =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfUIServite',
			 	false,
			 	'it.csi.sicee.siceeweb.dto.type.UDTPositiveInteger',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_pDtRiscaldamento", addBasicEnrichmentToTfUIServite);
	/// arricchimento di base per guigen::TextField [tfTipoErogaz]
	var addBasicEnrichmentToTfTipoErogaz =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfTipoErogaz',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_pDtRiscaldamento", addBasicEnrichmentToTfTipoErogaz);
	/// arricchimento di base per guigen::TextField [tfTipoDistribuz]
	var addBasicEnrichmentToTfTipoDistribuz =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfTipoDistribuz',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_pDtRiscaldamento", addBasicEnrichmentToTfTipoDistribuz);
	/// arricchimento di base per guigen::TextField [tfTipoRegolaz]
	var addBasicEnrichmentToTfTipoRegolaz =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfTipoRegolaz',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_pDtRiscaldamento", addBasicEnrichmentToTfTipoRegolaz);


	/// arricchimento di base per guigen::TextField [tfAnnoInstGenerAcqua]
	var addBasicEnrichmentToTfAnnoInstGenerAcqua =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfAnnoInstGenerAcqua',
			 	false,
			 	'it.csi.sicee.siceeweb.dto.type.UDTPositiveInteger',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_pDtAcquaCalda", addBasicEnrichmentToTfAnnoInstGenerAcqua);
	/// arricchimento di base per guigen::TextField [tfPotenzaNomAcqua]
	var addBasicEnrichmentToTfPotenzaNomAcqua =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfPotenzaNomAcqua',
			 	false,
			 	'it.csi.sicee.siceeweb.dto.type.UDTPositiveDoubleFour',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_pDtAcquaCalda", addBasicEnrichmentToTfPotenzaNomAcqua);



	/// arricchimento di base per guigen::TextField [tfEmissioniGasSerra]
	var addBasicEnrichmentToTfEmissioniGasSerra =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfEmissioniGasSerra',
			 	false,
			 	'it.csi.sicee.siceeweb.dto.type.UDTPositiveDoubleFour',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_pDtGasSerra", addBasicEnrichmentToTfEmissioniGasSerra);
	/// arricchimento di base per guigen::TextField [tfBoscoEquiv]
	var addBasicEnrichmentToTfBoscoEquiv =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfBoscoEquiv',
			 	false,
			 	'it.csi.sicee.siceeweb.dto.type.UDTPositiveDoubleFive',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_pDtGasSerra", addBasicEnrichmentToTfBoscoEquiv);


	/// arricchimento di base per guigen::TextField [tConsAnnoTermicoFossile]
	var addBasicEnrichmentToTConsAnnoTermicoFossile =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tConsAnnoTermicoFossile',
			 	false,
			 	'it.csi.sicee.siceeweb.dto.type.UDTPositiveDoubleFour',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_pDtConsumi", addBasicEnrichmentToTConsAnnoTermicoFossile);
	/// arricchimento di base per guigen::TextField [tConsAnnoElettricoFossile]
	var addBasicEnrichmentToTConsAnnoElettricoFossile =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tConsAnnoElettricoFossile',
			 	false,
			 	'it.csi.sicee.siceeweb.dto.type.UDTPositiveDoubleFour',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_pDtConsumi", addBasicEnrichmentToTConsAnnoElettricoFossile);
	/// arricchimento di base per guigen::TextField [tConsAnnoTermicoRinnov]
	var addBasicEnrichmentToTConsAnnoTermicoRinnov =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tConsAnnoTermicoRinnov',
			 	false,
			 	'it.csi.sicee.siceeweb.dto.type.UDTPositiveDoubleFour',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_pDtConsumi", addBasicEnrichmentToTConsAnnoTermicoRinnov);
	/// arricchimento di base per guigen::TextField [tConsAnnoElettricoRinnov]
	var addBasicEnrichmentToTConsAnnoElettricoRinnov =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tConsAnnoElettricoRinnov',
			 	false,
			 	'it.csi.sicee.siceeweb.dto.type.UDTPositiveDoubleFour',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_pDtConsumi", addBasicEnrichmentToTConsAnnoElettricoRinnov);
	/// arricchimento di base per guigen::TextField [tConsMedioTermico]
	var addBasicEnrichmentToTConsMedioTermico =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tConsMedioTermico',
			 	false,
			 	'it.csi.sicee.siceeweb.dto.type.UDTPositiveDoubleFour',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_pDtConsumi", addBasicEnrichmentToTConsMedioTermico);
	/// arricchimento di base per guigen::TextField [tConsMedioElettrico]
	var addBasicEnrichmentToTConsMedioElettrico =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tConsMedioElettrico',
			 	false,
			 	'it.csi.sicee.siceeweb.dto.type.UDTPositiveDoubleFour',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_pDtConsumi", addBasicEnrichmentToTConsMedioElettrico);

	/// arricchimento per guigen::Calendar [calDataDichiarazione]: aggiunta datepicker
	var addDateToCalDataDichiarazione = function(){
		uiNRichLib.addDatePickerNRich("widg_calDataDichiarazione", 
		false, false, "", false);
	};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_pLuogo", addDateToCalDataDichiarazione);
	/// arricchimento di base per guigen::TextField [tfLuogoDichiarazione]
	var addBasicEnrichmentToTfLuogoDichiarazione =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfLuogoDichiarazione',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_pLuogo", addBasicEnrichmentToTfLuogoDichiarazione);





}

/**
 * Arricchimenti custom
 */
function initCustomEnrichments4CpCompilaz(){
/*PROTECTED REGION ID(R-762256678) ENABLED START*/

/*PROTECTED REGION END*/
}

function initUIStructCpCompilaz(){
	var contentPanelName = "cpCompilaz";
	var structure =
      {
        name: "p_pMain", panels: [
        {
          name: "p_pCenter", panels: [
          {
            name: "p_pWizCompilazLiv1", panels: [
            {
              name: "p_pDatiAnagImmobile", panels: [
              {
                name: "p_pWizAnagImmobile", panels: [
                {
                  name: "p_pDatiCatastali", panels: [
                  {
                    name: "p_pErrDtCastastali", panels: [
                    ]
                  }
,                  {
                    name: "p_pDtCatastali1Part", panels: []
                  }
,                  {
                    name: "p_pDtCatastaliSecondari", panels: []
                  }
,                  {
                    name: "p_pDtCatastaliAdd", panels: []
                  }
,                  {
                    name: "p_pDtCatastaliSecondariiElenco", panels: []
                  }
,                  {
                    name: "p_pDtCatastaliDel", panels: []
                  }
,                  {
                    name: "p_pDtCatastali2Part", panels: []
                  }
,                  {
                    name: "p_pDtCatastaliNav", panels: []
                  }
                  ]
                }
,                {
                  name: "p_pDatiResponsabili", panels: [
                  {
                    name: "p_pErrDtRespons", panels: [
                    ]
                  }
,                  {
                    name: "p_pDtProgettista", panels: []
                  }
,                  {
                    name: "p_pDtDirLav", panels: []
                  }
,                  {
                    name: "p_pDtCostr", panels: []
                  }
,                  {
                    name: "p_pDtResponsNav", panels: []
                  }
                  ]
                }
,                {
                  name: "p_pDatiCoCertificatore", panels: [
                  {
                    name: "p_pErrDtCoCertificatore", panels: [
                    ]
                  }
,                  {
                    name: "p_pDtCoCertificatore", panels: []
                  }
,                  {
                    name: "p_pDtCoCertificatoreNav", panels: []
                  }
                  ]
                }
                ]
              }
              ]
            }
,            {
              name: "p_pDatiTecnici", panels: [
              {
                name: "p_pErrDtTecnici", panels: [
                ]
              }
,              {
                name: "p_pDtTecnici", panels: []
              }
,              {
                name: "p_pDtTecniciFun", panels: []
              }
,              {
                name: "p_pDtTecniciNav", panels: []
              }
              ]
            }
,            {
              name: "p_pDatiFabbisogno", panels: [
              {
                name: "p_pErrDtFabbisogno", panels: [
                ]
              }
,              {
                name: "p_pDtFabbisogno", panels: []
              }
,              {
                name: "p_pDtFabbisognoFun", panels: []
              }
,              {
                name: "p_pDtFabbisognoNav", panels: []
              }
              ]
            }
,            {
              name: "p_pDatiClEnerg", panels: [
              {
                name: "p_pWizClEnerg", panels: [
                {
                  name: "p_pDatiLocReale", panels: [
                  {
                    name: "p_pErrDtLocReale", panels: [
                    ]
                  }
,                  {
                    name: "p_pDtLocReale", panels: []
                  }
,                  {
                    name: "p_pDtLocRealeFun", panels: []
                  }
,                  {
                    name: "p_pDtLocRealeNav", panels: []
                  }
                  ]
                }
,                {
                  name: "p_pDatiLocTeorica", panels: [
                  {
                    name: "p_pErrDtLocTeorica", panels: [
                    ]
                  }
,                  {
                    name: "p_pDtLocTeorica", panels: []
                  }
,                  {
                    name: "p_pDtLocTeoricaFun", panels: []
                  }
,                  {
                    name: "p_pDtLocTeoricaNav", panels: []
                  }
                  ]
                }
                ]
              }
              ]
            }
,            {
              name: "p_pDatiFontiRinnov", panels: [
              {
                name: "p_pErrDtFontiRinnov", panels: [
                ]
              }
,              {
                name: "p_pDtFontiRinnov", panels: []
              }
,              {
                name: "p_pDtFontiRinnovFun", panels: []
              }
,              {
                name: "p_pDtFontiRinnovNav", panels: []
              }
              ]
            }
,            {
              name: "p_pDatiAltreInfo", panels: [
              {
                name: "p_pWizAltreInfo", panels: [
                {
                  name: "p_pDatiAltriGenerali", panels: [
                  {
                    name: "p_pErrDtAltriGenerali", panels: [
                    ]
                  }
,                  {
                    name: "p_pDtAltriGenerali", panels: []
                  }
,                  {
                    name: "p_pDtAltriGeneraliNav", panels: []
                  }
                  ]
                }
,                {
                  name: "p_pDatiAltriRaccomand", panels: [
                  {
                    name: "p_pErrDtAltriRaccomand", panels: [
                    ]
                  }
,                  {
                    name: "p_pDtAltriRaccomand1", panels: []
                  }
,                  {
                    name: "p_pCmdRaccomand1", panels: []
                  }
,                  {
                    name: "p_pDtAltriRaccomand2", panels: []
                  }
,                  {
                    name: "p_pCmdRaccomand2", panels: []
                  }
,                  {
                    name: "p_pDtAltriRaccomandNav", panels: []
                  }
                  ]
                }
,                {
                  name: "p_pDatiAltriEnerg", panels: [
                  {
                    name: "p_pErrDtAltriEnerg", panels: [
                    ]
                  }
,                  {
                    name: "p_pDtAltriEnerg", panels: []
                  }
,                  {
                    name: "p_pDtAltriEnergNav", panels: []
                  }
                  ]
                }
,                {
                  name: "p_pDatiAltriSopralluoghi", panels: [
                  {
                    name: "p_pErrDtAltriSopralluoghi", panels: [
                    ]
                  }
,                  {
                    name: "p_pDtAltriSopralluoghi1", panels: []
                  }
,                  {
                    name: "p_pDtAltriSopralluoghi2", panels: []
                  }
,                  {
                    name: "p_pDtAltriSopralluoghi3", panels: []
                  }
,                  {
                    name: "p_pDtAltriSopralluoghiNav", panels: []
                  }
                  ]
                }
                ]
              }
              ]
            }
,            {
              name: "p_pDatiNormative", panels: [
              {
                name: "p_pErrDtNormative", panels: [
                ]
              }
,              {
                name: "p_pDtNormative", panels: []
              }
,              {
                name: "p_pDtNormativeNav", panels: []
              }
              ]
            }
,            {
              name: "p_pDatiImpianti", panels: [
              {
                name: "p_pWizImpianti", panels: [
                {
                  name: "p_pDatiRiscaldamento", panels: [
                  {
                    name: "p_pErrDtRiscaldamento", panels: [
                    ]
                  }
,                  {
                    name: "p_pDtRiscaldamento", panels: []
                  }
,                  {
                    name: "p_pDtRiscaldamentoFun", panels: []
                  }
,                  {
                    name: "p_pDtRiscaldamentoNav", panels: []
                  }
                  ]
                }
,                {
                  name: "p_pDatiAcquaCalda", panels: [
                  {
                    name: "p_pErrDtAcquaCalda", panels: [
                    ]
                  }
,                  {
                    name: "p_pDtAcquaCalda", panels: []
                  }
,                  {
                    name: "p_pDtAcquaCaldaNav", panels: []
                  }
                  ]
                }
                ]
              }
              ]
            }
,            {
              name: "p_pDatiGasSerra", panels: [
              {
                name: "p_pErrDtGasSerra", panels: [
                ]
              }
,              {
                name: "p_pDtGasSerra", panels: []
              }
,              {
                name: "p_pDtGasSerraFun", panels: []
              }
,              {
                name: "p_pDtGasSerraNav", panels: []
              }
              ]
            }
,            {
              name: "p_pDatiConsumi", panels: [
              {
                name: "p_pErrDtConsumi", panels: [
                ]
              }
,              {
                name: "p_pDtConsumi", panels: []
              }
,              {
                name: "p_pDtConsumiNav", panels: []
              }
              ]
            }
,            {
              name: "p_pDatiDichiaraz", panels: [
              {
                name: "p_pErrDtDichiaraz", panels: [
                ]
              }
,              {
                name: "p_pLabel", panels: []
              }
,              {
                name: "p_pDtDichiarazioni", panels: []
              }
,              {
                name: "p_pLuogo", panels: []
              }
,              {
                name: "p_pDtDichiarazNav", panels: []
              }
              ]
            }
,            {
              name: "p_pDatiFoto", panels: [
              {
                name: "p_pErrDtFoto", panels: [
                ]
              }
,              {
                name: "p_pDtCaricaFoto", panels: []
              }
,              {
                name: "p_pDtFoto", panels: []
              }
,              {
                name: "p_pDtFotoNav", panels: []
              }
              ]
            }
,            {
              name: "p_pStampaCertitificato", panels: [
              {
                name: "p_msgStampa", panels: [
                ]
              }
,              {
                name: "p_pDtStampa", panels: []
              }
,              {
                name: "p_pDtStampaNav", panels: []
              }
              ]
            }
            ]
          }
          ]
        }
,        {
          name: "p_pLeft", panels: [
          {
            name: "p_pMenu", panels: []
          }
          ]
        }
,        {
          name: "p_pUp", panels: [
          {
            name: "p_pUserInfoCustomRegistraz", panels: [
            ]
          }
          ]
        }
        ]
      }
;
	uiEnricherMgr.setPageStructure(contentPanelName, structure);
}



// startup dell arricchimento con JQuery
$( function() {
	uiNRichLib.initStateManager();

	initStdEnrichments4CpCompilaz();
	initCustomEnrichments4CpCompilaz();
	initUIStructCpCompilaz();
	uiEnricherMgr.setReady();
	uiEnricherMgr.applyAll("cpCompilaz");

});



