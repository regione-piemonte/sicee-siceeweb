

/**
 * Arricchimenti standard per il ContentPanel [cpGestInvioCertificato] da registrare nella
 * variabile globale uiEnricherMgr
 */
function initStdEnrichments4CpGestInvioCertificato() {
	var contentPanelName = "cpGestInvioCertificato";


}

/**
 * Arricchimenti custom
 */
function initCustomEnrichments4CpGestInvioCertificato(){
/*PROTECTED REGION ID(R1306511832) ENABLED START*/
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

function initUIStructCpGestInvioCertificato(){
	var contentPanelName = "cpGestInvioCertificato";
	var structure =
      {
        name: "p_pMain", panels: [
        {
          name: "p_pCenter", panels: [
          {
            name: "p_pInvioCert", panels: [
            {
              name: "p_pErrInvioDocumento", panels: [
              ]
            }
,            {
              name: "p_pInvioC", panels: []
            }
,            {
              name: "p_pInvioA", panels: []
            }
,            {
              name: "p_pInvioB", panels: []
            }
,            {
              name: "p_pInvioFun", panels: []
            }
,            {
              name: "p_pInvioNav", panels: []
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

	initStdEnrichments4CpGestInvioCertificato();
	initCustomEnrichments4CpGestInvioCertificato();
	initUIStructCpGestInvioCertificato();
	uiEnricherMgr.setReady();
	uiEnricherMgr.applyAll("cpGestInvioCertificato");

});



