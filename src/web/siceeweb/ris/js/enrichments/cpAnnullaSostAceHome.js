

/**
 * Arricchimenti standard per il ContentPanel [cpAnnullaSostAceHome] da registrare nella
 * variabile globale uiEnricherMgr
 */
function initStdEnrichments4CpAnnullaSostAceHome() {
	var contentPanelName = "cpAnnullaSostAceHome";

	/// arricchimento di base per guigen::TextField [tfDataAnnullamento]
	var addBasicEnrichmentToTfDataAnnullamento =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfDataAnnullamento',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_pRicercaAceInviati", addBasicEnrichmentToTfDataAnnullamento);

}

/**
 * Arricchimenti custom
 */
function initCustomEnrichments4CpAnnullaSostAceHome(){
/*PROTECTED REGION ID(R-890914105) ENABLED START*/
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

function initUIStructCpAnnullaSostAceHome(){
	var contentPanelName = "cpAnnullaSostAceHome";
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

	initStdEnrichments4CpAnnullaSostAceHome();
	initCustomEnrichments4CpAnnullaSostAceHome();
	initUIStructCpAnnullaSostAceHome();
	uiEnricherMgr.setReady();
	uiEnricherMgr.applyAll("cpAnnullaSostAceHome");

});



