

/**
 * Arricchimenti standard per il ContentPanel [cpNonAbilitato] da registrare nella
 * variabile globale uiEnricherMgr
 */
function initStdEnrichments4CpNonAbilitato() {
	var contentPanelName = "cpNonAbilitato";

}

/**
 * Arricchimenti custom
 */
function initCustomEnrichments4CpNonAbilitato(){
/*PROTECTED REGION ID(R1226473391) ENABLED START*/
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

function initUIStructCpNonAbilitato(){
	var contentPanelName = "cpNonAbilitato";
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

	initStdEnrichments4CpNonAbilitato();
	initCustomEnrichments4CpNonAbilitato();
	initUIStructCpNonAbilitato();
	uiEnricherMgr.setReady();
	uiEnricherMgr.applyAll("cpNonAbilitato");

});



