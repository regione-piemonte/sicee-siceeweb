

/**
 * Arricchimenti standard per il ContentPanel [cpGestCertificazioni] da registrare nella
 * variabile globale uiEnricherMgr
 */
function initStdEnrichments4CpGestCertificazioni() {
	var contentPanelName = "cpGestCertificazioni";


}

/**
 * Arricchimenti custom
 */
function initCustomEnrichments4CpGestCertificazioni(){
/*PROTECTED REGION ID(R383520707) ENABLED START*/
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

function initUIStructCpGestCertificazioni(){
	var contentPanelName = "cpGestCertificazioni";
	var structure =
      {
        name: "p_pMain", panels: [
        {
          name: "p_pCenter", panels: [
          {
            name: "p_pListaCert", panels: [
            {
              name: "p_pErrListaCert", panels: [
              ]
            }
,            {
              name: "p_pLista", panels: []
            }
,            {
              name: "p_pCompilNavPrimo", panels: []
            }
,            {
              name: "p_pCompilNav", panels: []
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
            name: "p_pUserInfoCustomGestACE", panels: [
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

	initStdEnrichments4CpGestCertificazioni();
	initCustomEnrichments4CpGestCertificazioni();
	initUIStructCpGestCertificazioni();
	uiEnricherMgr.setReady();
	uiEnricherMgr.applyAll("cpGestCertificazioni");

});



