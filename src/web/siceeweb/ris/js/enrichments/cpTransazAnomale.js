

/**
 * Arricchimenti standard per il ContentPanel [cpTransazAnomale] da registrare nella
 * variabile globale uiEnricherMgr
 */
function initStdEnrichments4CpTransazAnomale() {
	var contentPanelName = "cpTransazAnomale";


}

/**
 * Arricchimenti custom
 */
function initCustomEnrichments4CpTransazAnomale(){
/*PROTECTED REGION ID(R840784125) ENABLED START*/
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

function initUIStructCpTransazAnomale(){
	var contentPanelName = "cpTransazAnomale";
	var structure =
      {
        name: "p_pMain", panels: [
        {
          name: "p_pCenter", panels: [
          {
            name: "p_pWizTransaz", panels: [
            {
              name: "p_pRegistrazCert", panels: [
              {
                name: "p_pErrListTransReg", panels: [
                ]
              }
,              {
                name: "p_pListaReg", panels: []
              }
,              {
                name: "p_pVerificaReg", panels: []
              }
              ]
            }
,            {
              name: "p_pAcquistoAce", panels: [
              {
                name: "p_pErrListTransAce", panels: [
                ]
              }
,              {
                name: "p_pListaAce", panels: []
              }
,              {
                name: "p_pVerificaAce", panels: []
              }
              ]
            }
            ]
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
            name: "p_pUserInfoCustomRegistraz", panels: [
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

	initStdEnrichments4CpTransazAnomale();
	initCustomEnrichments4CpTransazAnomale();
	initUIStructCpTransazAnomale();
	uiEnricherMgr.setReady();
	uiEnricherMgr.applyAll("cpTransazAnomale");

});



