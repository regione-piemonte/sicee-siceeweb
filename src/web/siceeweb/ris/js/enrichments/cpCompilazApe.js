

/**
 * Arricchimenti standard per il ContentPanel [cpCompilazApe] da registrare nella
 * variabile globale uiEnricherMgr
 */
function initStdEnrichments4CpCompilazApe() {
	var contentPanelName = "cpCompilazApe";


	/// arricchimento di base per guigen::TextField [tfRicercaIndirizzo]
	var addBasicEnrichmentToTfRicercaIndirizzo =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfRicercaIndirizzo',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpDatiGenerali", addBasicEnrichmentToTfRicercaIndirizzo);

	/// arricchimento di base per guigen::TextField [tfIndirizzoDtCatastali]
	var addBasicEnrichmentToTfIndirizzoDtCatastali =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfIndirizzoDtCatastali',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpDatiGenerali", addBasicEnrichmentToTfIndirizzoDtCatastali);
	/// arricchimento di base per guigen::TextField [tfNCivDtCatastali]
	var addBasicEnrichmentToTfNCivDtCatastali =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfNCivDtCatastali',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpDatiGenerali", addBasicEnrichmentToTfNCivDtCatastali);
	/// arricchimento di base per guigen::TextField [tfCAPDtCatastali]
	var addBasicEnrichmentToTfCAPDtCatastali =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfCAPDtCatastali',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpDatiGenerali", addBasicEnrichmentToTfCAPDtCatastali);
	/// arricchimento di base per guigen::TextField [tfInternoDtCatastali]
	var addBasicEnrichmentToTfInternoDtCatastali =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfInternoDtCatastali',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpDatiGenerali", addBasicEnrichmentToTfInternoDtCatastali);
	/// arricchimento di base per guigen::TextField [tfScalaDtCatastali]
	var addBasicEnrichmentToTfScalaDtCatastali =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfScalaDtCatastali',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpDatiGenerali", addBasicEnrichmentToTfScalaDtCatastali);
	/// arricchimento di base per guigen::TextField [tfPianoDtCatastali]
	var addBasicEnrichmentToTfPianoDtCatastali =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfPianoDtCatastali',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpDatiGenerali", addBasicEnrichmentToTfPianoDtCatastali);
	/// arricchimento di base per guigen::TextField [tfNPianiComplessivi]
	var addBasicEnrichmentToTfNPianiComplessivi =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfNPianiComplessivi',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpDatiGenerali", addBasicEnrichmentToTfNPianiComplessivi);
	/// arricchimento di base per guigen::TextField [tfNPianiFtRisc]
	var addBasicEnrichmentToTfNPianiFtRisc =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfNPianiFtRisc',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpDatiGenerali", addBasicEnrichmentToTfNPianiFtRisc);
	/// arricchimento di base per guigen::TextField [tfIndirizzoCoordN]
	var addBasicEnrichmentToTfIndirizzoCoordN =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfIndirizzoCoordN',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpDatiGenerali", addBasicEnrichmentToTfIndirizzoCoordN);
	/// arricchimento di base per guigen::TextField [tfIndirizzoCoordE]
	var addBasicEnrichmentToTfIndirizzoCoordE =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfIndirizzoCoordE',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpDatiGenerali", addBasicEnrichmentToTfIndirizzoCoordE);

	/// arricchimento di base per guigen::TextField [tfSezCatasto]
	var addBasicEnrichmentToTfSezCatasto =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfSezCatasto',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpDatiGenerali", addBasicEnrichmentToTfSezCatasto);
	/// arricchimento di base per guigen::TextField [tfFoglioCatasto]
	var addBasicEnrichmentToTfFoglioCatasto =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfFoglioCatasto',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpDatiGenerali", addBasicEnrichmentToTfFoglioCatasto);
	/// arricchimento di base per guigen::TextField [tfParticCatasto]
	var addBasicEnrichmentToTfParticCatasto =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfParticCatasto',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpDatiGenerali", addBasicEnrichmentToTfParticCatasto);
	/// arricchimento di base per guigen::TextField [tfSubaltCatasto]
	var addBasicEnrichmentToTfSubaltCatasto =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfSubaltCatasto',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpDatiGenerali", addBasicEnrichmentToTfSubaltCatasto);
	/// arricchimento per guigen::Calendar [calDtEmissione]: aggiunta datepicker
	var addDateToCalDtEmissione = function(){
		uiNRichLib.addDatePickerNRich("widg_calDtEmissione", 
		false, false, "", false);
	};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpDatiGenerali", addDateToCalDtEmissione);
	/// arricchimento di base per guigen::TextField [tfAnnoCostr]
	var addBasicEnrichmentToTfAnnoCostr =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfAnnoCostr',
			 	false,
			 	'it.csi.sicee.siceeweb.dto.type.UDTPositiveInteger',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpDatiGenerali", addBasicEnrichmentToTfAnnoCostr);
	/// arricchimento di base per guigen::TextField [tfAnnoRistrutt]
	var addBasicEnrichmentToTfAnnoRistrutt =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfAnnoRistrutt',
			 	false,
			 	'it.csi.sicee.siceeweb.dto.type.UDTPositiveInteger',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpDatiGenerali", addBasicEnrichmentToTfAnnoRistrutt);
	/// arricchimento di base per guigen::TextField [tfDestUso]
	var addBasicEnrichmentToTfDestUso =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfDestUso',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpDatiGenerali", addBasicEnrichmentToTfDestUso);
	/// arricchimento di base per guigen::TextField [tfCodEdificioScolastico]
	var addBasicEnrichmentToTfCodEdificioScolastico =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfCodEdificioScolastico',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpDatiGenerali", addBasicEnrichmentToTfCodEdificioScolastico);







	/// arricchimento di base per guigen::TextField [tfCodFiscCoCert]
	var addBasicEnrichmentToTfCodFiscCoCert =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfCodFiscCoCert',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpDatiCoCertificatore", addBasicEnrichmentToTfCodFiscCoCert);

	/// arricchimento di base per guigen::TextField [tfCognomeCoCert]
	var addBasicEnrichmentToTfCognomeCoCert =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfCognomeCoCert',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpDatiCoCertificatore", addBasicEnrichmentToTfCognomeCoCert);
	/// arricchimento di base per guigen::TextField [tfNomeCoCert]
	var addBasicEnrichmentToTfNomeCoCert =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfNomeCoCert',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpDatiCoCertificatore", addBasicEnrichmentToTfNomeCoCert);
	/// arricchimento di base per guigen::TextField [tfNumMatricolaCoCert]
	var addBasicEnrichmentToTfNumMatricolaCoCert =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfNumMatricolaCoCert',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpDatiCoCertificatore", addBasicEnrichmentToTfNumMatricolaCoCert);
	/// arricchimento per guigen::Calendar [cDataSopralluogo]: aggiunta datepicker
	var addDateToCDataSopralluogo = function(){
		uiNRichLib.addDatePickerNRich("widg_cDataSopralluogo", 
		false, false, "", false);
	};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpDataSopralluogo", addDateToCDataSopralluogo);





}

/**
 * Arricchimenti custom
 */
function initCustomEnrichments4CpCompilazApe(){
/*PROTECTED REGION ID(R196957408) ENABLED START*/
	/*
	 * definire e registrare qui eventuali arricchimenti custom, nel formato:
	 * var customEnr_n = function(){
	 *	// codice da eseguire all'applicazione dell'arricchimento
	 * };
	 * String customEnr_fragmentID = p_[id del pannello a cui deve essere associato l'arricchimento];
	 * uiEnricherMgr.registerEnrichment(contentPanelName, customEnr_fragmentID, customEnr_n);
	*/

/*PROTECTED REGION END*/
}

function initUIStructCpCompilazApe(){
	var contentPanelName = "cpCompilazApe";
	var structure =
      {
        name: "p_pMainApe", panels: [
        {
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
,        {
          name: "p_pCenter", panels: [
          {
            name: "p_tspApe", panels: [
            {
              name: "p_fpTspApeDatiGen", panels: [
              {
                name: "p_pErrDtGenerali", panels: [
                ]
              }
,              {
                name: "p_wpDatiGenerali", panels: []
              }
,              {
                name: "p_wpMotivazioneAttestato", panels: []
              }
,              {
                name: "p_wpDichiarazioneInd", panels: []
              }
,              {
                name: "p_wpDatiCoCertificatore", panels: []
              }
              ]
            }
,            {
              name: "p_fpTspApeSopralluogo", panels: [
              {
                name: "p_pErrSopralluogo", panels: [
                ]
              }
,              {
                name: "p_wpDataSopralluogo", panels: []
              }
,              {
                name: "p_udPreview", panels: [
                ]
              }
,              {
                name: "p_cpPreview", panels: []
              }
,              {
                name: "p_wpTextNote", panels: []
              }
,              {
                name: "p_wpImmaginePrincipale", panels: []
              }
,              {
                name: "p_wpImmaginiSecondarie", panels: []
              }
              ]
            }
            ]
          }
,          {
            name: "p_cpCompilazApe", panels: []
          }
,          {
            name: "p_cpNavCompilazApe", panels: []
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

	initStdEnrichments4CpCompilazApe();
	initCustomEnrichments4CpCompilazApe();
	initUIStructCpCompilazApe();
	uiEnricherMgr.setReady();
	uiEnricherMgr.applyAll("cpCompilazApe");

});



