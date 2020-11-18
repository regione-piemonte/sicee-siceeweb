

/**
 * Arricchimenti standard per il ContentPanel [cpDatiCertificatore] da registrare nella
 * variabile globale uiEnricherMgr
 */
function initStdEnrichments4CpDatiCertificatore() {
	var contentPanelName = "cpDatiCertificatore";
}

/**
 * Arricchimenti custom
 */
function initCustomEnrichments4CpDatiCertificatore(){
/*PROTECTED REGION ID(R-1703019017) ENABLED START*/
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

function initUIStructCpDatiCertificatore(){
	var contentPanelName = "cpDatiCertificatore";
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

	initStdEnrichments4CpDatiCertificatore();
	initCustomEnrichments4CpDatiCertificatore();
	initUIStructCpDatiCertificatore();
	uiEnricherMgr.setReady();
	uiEnricherMgr.applyAll("cpDatiCertificatore");

});



