

/**
 * Arricchimenti standard per il ContentPanel [cpBloccoUtente] da registrare nella
 * variabile globale uiEnricherMgr
 */
function initStdEnrichments4CpBloccoUtente() {
	var contentPanelName = "cpBloccoUtente";
}

/**
 * Arricchimenti custom
 */
function initCustomEnrichments4CpBloccoUtente(){
/*PROTECTED REGION ID(R-1293443246) ENABLED START*/
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

function initUIStructCpBloccoUtente(){
	var contentPanelName = "cpBloccoUtente";
	var structure =
      {
        name: "p_pMain", panels: [
        {
          name: "p_pCenter", panels: [
          {
            name: "p_pErrBloccoUtente", panels: [
            ]
          }
,          {
            name: "p_pBloccoUtenteMessaggi", panels: []
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

	initStdEnrichments4CpBloccoUtente();
	initCustomEnrichments4CpBloccoUtente();
	initUIStructCpBloccoUtente();
	uiEnricherMgr.setReady();
	uiEnricherMgr.applyAll("cpBloccoUtente");

});



