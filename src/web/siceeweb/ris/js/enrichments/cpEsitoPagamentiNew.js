

/**
 * Arricchimenti standard per il ContentPanel [cpEsitoPagamentiNew] da registrare nella
 * variabile globale uiEnricherMgr
 */
function initStdEnrichments4CpEsitoPagamentiNew() {
	var contentPanelName = "cpEsitoPagamentiNew";
}

/**
 * Arricchimenti custom
 */
function initCustomEnrichments4CpEsitoPagamentiNew(){
/*PROTECTED REGION ID(R587226795) ENABLED START*/
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

function initUIStructCpEsitoPagamentiNew(){
	var contentPanelName = "cpEsitoPagamentiNew";
	var structure =
      {
        name: "p_pMain", panels: [
        {
          name: "p_pCenter", panels: [
          {
            name: "p_pPagamento", panels: [
            {
              name: "p_pErrPagamento", panels: [
              ]
            }
,            {
              name: "p_pDatiPagamento", panels: []
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
            name: "p_pUserInfo", panels: [
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

	initStdEnrichments4CpEsitoPagamentiNew();
	initCustomEnrichments4CpEsitoPagamentiNew();
	initUIStructCpEsitoPagamentiNew();
	uiEnricherMgr.setReady();
	uiEnricherMgr.applyAll("cpEsitoPagamentiNew");

});



