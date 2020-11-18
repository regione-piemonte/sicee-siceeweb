

/**
 * Arricchimenti standard per il ContentPanel [cpRiepilogoAceAnnullaSost] da registrare nella
 * variabile globale uiEnricherMgr
 */
function initStdEnrichments4CpRiepilogoAceAnnullaSost() {
	var contentPanelName = "cpRiepilogoAceAnnullaSost";



}

/**
 * Arricchimenti custom
 */
function initCustomEnrichments4CpRiepilogoAceAnnullaSost(){
/*PROTECTED REGION ID(R348106702) ENABLED START*/
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

function initUIStructCpRiepilogoAceAnnullaSost(){
	var contentPanelName = "cpRiepilogoAceAnnullaSost";
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
            name: "p_wpRiepilogoParametri", panels: []
          }
,          {
            name: "p_wpAceDaSostituire", panels: []
          }
,          {
            name: "p_pEliminaOldCarrelloAceFun", panels: []
          }
,          {
            name: "p_wpAceSostitutivi", panels: []
          }
,          {
            name: "p_pEliminaNewCarrelloAceFun", panels: []
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

	initStdEnrichments4CpRiepilogoAceAnnullaSost();
	initCustomEnrichments4CpRiepilogoAceAnnullaSost();
	initUIStructCpRiepilogoAceAnnullaSost();
	uiEnricherMgr.setReady();
	uiEnricherMgr.applyAll("cpRiepilogoAceAnnullaSost");

});



