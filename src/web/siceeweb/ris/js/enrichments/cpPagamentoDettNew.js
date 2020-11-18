

/**
 * Arricchimenti standard per il ContentPanel [cpPagamentoDettNew] da registrare nella
 * variabile globale uiEnricherMgr
 */
function initStdEnrichments4CpPagamentoDettNew() {
	var contentPanelName = "cpPagamentoDettNew";


}

/**
 * Arricchimenti custom
 */
function initCustomEnrichments4CpPagamentoDettNew(){
/*PROTECTED REGION ID(R62666568) ENABLED START*/
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

function initUIStructCpPagamentoDettNew(){
	var contentPanelName = "cpPagamentoDettNew";
	var structure =
      {
        name: "p_pMainPagamentoDetNew", panels: [
        {
          name: "p_pCenter", panels: [
          {
            name: "p_pPagamentoDettNew", panels: [
            {
              name: "p_pErrPagamentoDettNew", panels: [
              ]
            }
,            {
              name: "p_pDatiPagamentoDettNew", panels: []
            }
,            {
              name: "p_pDatiPagamentoDettNewTit", panels: []
            }
,            {
              name: "p_pPagamentoDettNewFun", panels: []
            }
,            {
              name: "p_pPagamentoDettNewNav", panels: []
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
            name: "p_pUserInfoCustomPagamento", panels: [
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

	initStdEnrichments4CpPagamentoDettNew();
	initCustomEnrichments4CpPagamentoDettNew();
	initUIStructCpPagamentoDettNew();
	uiEnricherMgr.setReady();
	uiEnricherMgr.applyAll("cpPagamentoDettNew");

});



