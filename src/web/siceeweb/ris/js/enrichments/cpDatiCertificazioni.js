

/**
 * Arricchimenti standard per il ContentPanel [cpDatiCertificazioni] da registrare nella
 * variabile globale uiEnricherMgr
 */
function initStdEnrichments4CpDatiCertificazioni() {
	var contentPanelName = "cpDatiCertificazioni";
}

/**
 * Arricchimenti custom
 */
function initCustomEnrichments4CpDatiCertificazioni(){
/*PROTECTED REGION ID(R-208267338) ENABLED START*/
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

function initUIStructCpDatiCertificazioni(){
	var contentPanelName = "cpDatiCertificazioni";
	var structure =
      {
        name: "p_pMain", panels: [
        {
          name: "p_pCenter", panels: [
          {
            name: "p_pHome", panels: [
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
            name: "p_pUserInfoCustomHome", panels: [
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

	initStdEnrichments4CpDatiCertificazioni();
	initCustomEnrichments4CpDatiCertificazioni();
	initUIStructCpDatiCertificazioni();
	uiEnricherMgr.setReady();
	uiEnricherMgr.applyAll("cpDatiCertificazioni");

});



