

/**
 * Arricchimenti standard per il ContentPanel [cpDuplicaAce] da registrare nella
 * variabile globale uiEnricherMgr
 */
function initStdEnrichments4CpDuplicaAce() {
	var contentPanelName = "cpDuplicaAce";

}

/**
 * Arricchimenti custom
 */
function initCustomEnrichments4CpDuplicaAce(){
/*PROTECTED REGION ID(R-837619464) ENABLED START*/
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

function initUIStructCpDuplicaAce(){
	var contentPanelName = "cpDuplicaAce";
	var structure =
      {
        name: "p_pMain", panels: [
        {
          name: "p_pCenter", panels: [
          {
            name: "p_pErrDuplicaAce", panels: [
            ]
          }
,          {
            name: "p_msgSel", panels: [
            ]
          }
,          {
            name: "p_pMsg", panels: []
          }
,          {
            name: "p_pTable", panels: []
          }
,          {
            name: "p_pDuplicaAceNav", panels: []
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

	initStdEnrichments4CpDuplicaAce();
	initCustomEnrichments4CpDuplicaAce();
	initUIStructCpDuplicaAce();
	uiEnricherMgr.setReady();
	uiEnricherMgr.applyAll("cpDuplicaAce");

});



