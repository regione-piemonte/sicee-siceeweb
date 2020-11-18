

/**
 * Arricchimenti standard per il ContentPanel [cpDisabled] da registrare nella
 * variabile globale uiEnricherMgr
 */
function initStdEnrichments4CpDisabled() {
	var contentPanelName = "cpDisabled";
}

/**
 * Arricchimenti custom
 */
function initCustomEnrichments4CpDisabled(){
/*PROTECTED REGION ID(R-1901814037) ENABLED START*/
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

function initUIStructCpDisabled(){
	var contentPanelName = "cpDisabled";
	var structure =
      {
        name: "p_pMain", panels: [
        {
          name: "p_pCenter", panels: [
          {
            name: "p_pDisabled", panels: []
          }
,          {
            name: "p_pSession", panels: [
            ]
          }
          ]
        }
,        {
          name: "p_pLeft", panels: [
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

	initStdEnrichments4CpDisabled();
	initCustomEnrichments4CpDisabled();
	initUIStructCpDisabled();
	uiEnricherMgr.setReady();
	uiEnricherMgr.applyAll("cpDisabled");

});



