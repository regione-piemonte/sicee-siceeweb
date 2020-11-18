

/**
 * Arricchimenti standard per il ContentPanel [cpAttesaRT] da registrare nella
 * variabile globale uiEnricherMgr
 */
function initStdEnrichments4CpAttesaRT() {
	var contentPanelName = "cpAttesaRT";



}

/**
 * Arricchimenti custom
 */
function initCustomEnrichments4CpAttesaRT(){
/*PROTECTED REGION ID(R-1264993437) ENABLED START*/
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

function initUIStructCpAttesaRT(){
	var contentPanelName = "cpAttesaRT";
	var structure =
      {
        name: "p_pMainAttesaRT", panels: [
        {
          name: "p_pCenter", panels: [
          {
            name: "p_pAttesaRT", panels: [
            {
              name: "p_pErrPagamentoNew", panels: [
              ]
            }
,            {
              name: "p_pFiltro", panels: []
            }
,            {
              name: "p_pDettaglio", panels: []
            }
,            {
              name: "p_pAttesaRTFun", panels: []
            }
,            {
              name: "p_pAttesaRTNav", panels: []
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

	initStdEnrichments4CpAttesaRT();
	initCustomEnrichments4CpAttesaRT();
	initUIStructCpAttesaRT();
	uiEnricherMgr.setReady();
	uiEnricherMgr.applyAll("cpAttesaRT");

});



