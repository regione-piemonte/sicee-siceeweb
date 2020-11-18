

/**
 * Arricchimenti standard per il ContentPanel [cpHome] da registrare nella
 * variabile globale uiEnricherMgr
 */
function initStdEnrichments4CpHome() {
	var contentPanelName = "cpHome";

}

/**
 * Arricchimenti custom
 */
function initCustomEnrichments4CpHome(){
/*PROTECTED REGION ID(R-997468914) ENABLED START*/
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

function initUIStructCpHome(){
	var contentPanelName = "cpHome";
	var structure =
      {
        name: "p_pMain", panels: [
        {
          name: "p_pCenter", panels: [
          {
            name: "p_pErrDtAnag", panels: [
            ]
          }
,          {
            name: "p_pHome", panels: [
            ]
          }
,          {
            name: "p_cpStampa", panels: []
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

	initStdEnrichments4CpHome();
	initCustomEnrichments4CpHome();
	initUIStructCpHome();
	uiEnricherMgr.setReady();
	uiEnricherMgr.applyAll("cpHome");

});



