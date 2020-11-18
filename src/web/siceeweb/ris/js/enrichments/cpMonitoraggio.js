

/**
 * Arricchimenti standard per il ContentPanel [cpMonitoraggio] da registrare nella
 * variabile globale uiEnricherMgr
 */
function initStdEnrichments4CpMonitoraggio() {
	var contentPanelName = "cpMonitoraggio";



}

/**
 * Arricchimenti custom
 */
function initCustomEnrichments4CpMonitoraggio(){
/*PROTECTED REGION ID(R-1865041796) ENABLED START*/
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

function initUIStructCpMonitoraggio(){
	var contentPanelName = "cpMonitoraggio";
	var structure =
      {
        name: "p_pMain", panels: [
        {
          name: "p_pVerifica", panels: [
          {
            name: "p_pErrMonitoraggio", panels: [
            ]
          }
,          {
            name: "p_pDatabase", panels: []
          }
,          {
            name: "p_pTavt", panels: []
          }
,          {
            name: "p_pTope", panels: []
          }
,          {
            name: "p_pIndex", panels: []
          }
,          {
            name: "p_pModol", panels: []
          }
          ]
        }
,        {
          name: "p_pLeftMenu", panels: [
          {
            name: "p_pMenu", panels: []
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

	initStdEnrichments4CpMonitoraggio();
	initCustomEnrichments4CpMonitoraggio();
	initUIStructCpMonitoraggio();
	uiEnricherMgr.setReady();
	uiEnricherMgr.applyAll("cpMonitoraggio");

});



