

/**
 * Arricchimenti standard per il ContentPanel [cpEsci] da registrare nella
 * variabile globale uiEnricherMgr
 */
function initStdEnrichments4CpEsci() {
	var contentPanelName = "cpEsci";

}

/**
 * Arricchimenti custom
 */
function initCustomEnrichments4CpEsci(){
/*PROTECTED REGION ID(R-1917476221) ENABLED START*/
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

function initUIStructCpEsci(){
	var contentPanelName = "cpEsci";
	var structure =
      {
        name: "p_pMain", panels: [
        {
          name: "p_pCenter", panels: [
          {
            name: "p_pErrNonAbilitato", panels: [
            ]
          }
,          {
            name: "p_msgKoAutenticazione", panels: [
            ]
          }
,          {
            name: "p_cmdKoAutenticazione", panels: []
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
            name: "p_pUserInfoCustomHome", panels: [
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

	initStdEnrichments4CpEsci();
	initCustomEnrichments4CpEsci();
	initUIStructCpEsci();
	uiEnricherMgr.setReady();
	uiEnricherMgr.applyAll("cpEsci");

});



