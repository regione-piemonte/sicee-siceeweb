

/**
 * Arricchimenti standard per il ContentPanel [cpDettaglioSostituzioni] da registrare nella
 * variabile globale uiEnricherMgr
 */
function initStdEnrichments4CpDettaglioSostituzioni() {
	var contentPanelName = "cpDettaglioSostituzioni";

}

/**
 * Arricchimenti custom
 */
function initCustomEnrichments4CpDettaglioSostituzioni(){
/*PROTECTED REGION ID(R966895886) ENABLED START*/
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

function initUIStructCpDettaglioSostituzioni(){
	var contentPanelName = "cpDettaglioSostituzioni";
	var structure =
      {
        name: "p_pMain", panels: [
        {
          name: "p_pCenter", panels: [
          {
            name: "p_pErrDettaglioSostituzione", panels: [
            ]
          }
,          {
            name: "p_wpAceSostituito", panels: []
          }
,          {
            name: "p_pRisultatoVediSostituzioni", panels: []
          }
,          {
            name: "p_pDettaglioSostituzioni", panels: []
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

	initStdEnrichments4CpDettaglioSostituzioni();
	initCustomEnrichments4CpDettaglioSostituzioni();
	initUIStructCpDettaglioSostituzioni();
	uiEnricherMgr.setReady();
	uiEnricherMgr.applyAll("cpDettaglioSostituzioni");

});



