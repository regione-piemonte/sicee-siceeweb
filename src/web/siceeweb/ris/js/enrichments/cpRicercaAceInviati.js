

/**
 * Arricchimenti standard per il ContentPanel [cpRicercaAceInviati] da registrare nella
 * variabile globale uiEnricherMgr
 */
function initStdEnrichments4CpRicercaAceInviati() {
	var contentPanelName = "cpRicercaAceInviati";
	/// arricchimento di base per guigen::TextField [tfAnnoCertificato]
	var addBasicEnrichmentToTfAnnoCertificato =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfAnnoCertificato',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_pRicercaAceInviatiByCodice", addBasicEnrichmentToTfAnnoCertificato);
	/// arricchimento di base per guigen::TextField [tfCertificatore]
	var addBasicEnrichmentToTfCertificatore =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfCertificatore',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_pRicercaAceInviatiByCodice", addBasicEnrichmentToTfCertificatore);
	/// arricchimento di base per guigen::TextField [tfProgCertificato]
	var addBasicEnrichmentToTfProgCertificato =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfProgCertificato',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_pRicercaAceInviatiByCodice", addBasicEnrichmentToTfProgCertificato);



	/// arricchimento di base per guigen::TextField [tfComRicercaAce]
	var addBasicEnrichmentToTfComRicercaAce =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfComRicercaAce',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_pRicercaAceInviati", addBasicEnrichmentToTfComRicercaAce);
	/// arricchimento di base per guigen::TextField [tfIndirizzoRicercaAce]
	var addBasicEnrichmentToTfIndirizzoRicercaAce =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfIndirizzoRicercaAce',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_pRicercaAceInviati", addBasicEnrichmentToTfIndirizzoRicercaAce);
	/// arricchimento di base per guigen::TextField [tfNCivRicercaAce]
	var addBasicEnrichmentToTfNCivRicercaAce =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfNCivRicercaAce',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_pRicercaAceInviati", addBasicEnrichmentToTfNCivRicercaAce);
	/// arricchimento di base per guigen::TextField [tfSezCatasto]
	var addBasicEnrichmentToTfSezCatasto =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfSezCatasto',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_pRicercaAceInviati", addBasicEnrichmentToTfSezCatasto);
	/// arricchimento di base per guigen::TextField [tfFoglioCatasto]
	var addBasicEnrichmentToTfFoglioCatasto =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfFoglioCatasto',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_pRicercaAceInviati", addBasicEnrichmentToTfFoglioCatasto);
	/// arricchimento di base per guigen::TextField [tfParticCatasto]
	var addBasicEnrichmentToTfParticCatasto =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfParticCatasto',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_pRicercaAceInviati", addBasicEnrichmentToTfParticCatasto);
	/// arricchimento di base per guigen::TextField [tfSubaltCatasto]
	var addBasicEnrichmentToTfSubaltCatasto =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfSubaltCatasto',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_pRicercaAceInviati", addBasicEnrichmentToTfSubaltCatasto);

}

/**
 * Arricchimenti custom
 */
function initCustomEnrichments4CpRicercaAceInviati(){
/*PROTECTED REGION ID(R1557989415) ENABLED START*/
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

function initUIStructCpRicercaAceInviati(){
	var contentPanelName = "cpRicercaAceInviati";
	var structure =
      {
        name: "p_pMain", panels: [
        {
          name: "p_pCenter", panels: [
          {
            name: "p_pErrRicercaAce", panels: [
            ]
          }
,          {
            name: "p_pRicercaAceInviatiByCodice", panels: []
          }
,          {
            name: "p_pRicercaAceInviatiByCodiceNote", panels: []
          }
,          {
            name: "p_pRicercaAceInviatiByCodiceNav", panels: []
          }
,          {
            name: "p_pRicercaAceInviati", panels: []
          }
,          {
            name: "p_pRicercaAceInviatiNav", panels: []
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
            name: "p_pUserInfoCustom", panels: [
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

	initStdEnrichments4CpRicercaAceInviati();
	initCustomEnrichments4CpRicercaAceInviati();
	initUIStructCpRicercaAceInviati();
	uiEnricherMgr.setReady();
	uiEnricherMgr.applyAll("cpRicercaAceInviati");

});



