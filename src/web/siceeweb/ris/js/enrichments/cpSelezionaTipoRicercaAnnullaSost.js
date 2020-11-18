

/**
 * Arricchimenti standard per il ContentPanel [cpSelezionaTipoRicercaAnnullaSost] da registrare nella
 * variabile globale uiEnricherMgr
 */
function initStdEnrichments4CpSelezionaTipoRicercaAnnullaSost() {
	var contentPanelName = "cpSelezionaTipoRicercaAnnullaSost";


}

/**
 * Arricchimenti custom
 */
function initCustomEnrichments4CpSelezionaTipoRicercaAnnullaSost(){
/*PROTECTED REGION ID(R1306451204) ENABLED START*/
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

function initUIStructCpSelezionaTipoRicercaAnnullaSost(){
	var contentPanelName = "cpSelezionaTipoRicercaAnnullaSost";
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
            name: "p_pTipoRicercaAceFun", panels: []
          }
,          {
            name: "p_pConfermaAceNav", panels: []
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

	initStdEnrichments4CpSelezionaTipoRicercaAnnullaSost();
	initCustomEnrichments4CpSelezionaTipoRicercaAnnullaSost();
	initUIStructCpSelezionaTipoRicercaAnnullaSost();
	uiEnricherMgr.setReady();
	uiEnricherMgr.applyAll("cpSelezionaTipoRicercaAnnullaSost");

});



