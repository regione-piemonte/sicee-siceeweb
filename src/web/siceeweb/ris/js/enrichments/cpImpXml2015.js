

/**
 * Arricchimenti standard per il ContentPanel [cpImpXml2015] da registrare nella
 * variabile globale uiEnricherMgr
 */
function initStdEnrichments4CpImpXml2015() {
	var contentPanelName = "cpImpXml2015";

}

/**
 * Arricchimenti custom
 */
function initCustomEnrichments4CpImpXml2015(){
/*PROTECTED REGION ID(R-1722128644) ENABLED START*/
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

function initUIStructCpImpXml2015(){
	var contentPanelName = "cpImpXml2015";
	var structure =
      {
        name: "p_pMain", panels: [
        {
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
,        {
          name: "p_pCenter", panels: [
          {
            name: "p_pMessagePanel", panels: [
            ]
          }
,          {
            name: "p_pDati", panels: []
          }
,          {
            name: "p_cpNavigazione", panels: []
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

	initStdEnrichments4CpImpXml2015();
	initCustomEnrichments4CpImpXml2015();
	initUIStructCpImpXml2015();
	uiEnricherMgr.setReady();
	uiEnricherMgr.applyAll("cpImpXml2015");

});



