

/**
 * Arricchimenti standard per il ContentPanel [cpEsitoAceAnnullaSost] da registrare nella
 * variabile globale uiEnricherMgr
 */
function initStdEnrichments4CpEsitoAceAnnullaSost() {
	var contentPanelName = "cpEsitoAceAnnullaSost";

}

/**
 * Arricchimenti custom
 */
function initCustomEnrichments4CpEsitoAceAnnullaSost(){
/*PROTECTED REGION ID(R-214146862) ENABLED START*/
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

function initUIStructCpEsitoAceAnnullaSost(){
	var contentPanelName = "cpEsitoAceAnnullaSost";
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
            name: "p_wpAceSostitutivi", panels: []
          }
,          {
            name: "p_pConfermaCarrelloAceNav", panels: []
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

	initStdEnrichments4CpEsitoAceAnnullaSost();
	initCustomEnrichments4CpEsitoAceAnnullaSost();
	initUIStructCpEsitoAceAnnullaSost();
	uiEnricherMgr.setReady();
	uiEnricherMgr.applyAll("cpEsitoAceAnnullaSost");

});



