

/**
 * Arricchimenti standard per il ContentPanel [cpDocAggiuntiva] da registrare nella
 * variabile globale uiEnricherMgr
 */
function initStdEnrichments4CpDocAggiuntiva() {
	var contentPanelName = "cpDocAggiuntiva";


}

/**
 * Arricchimenti custom
 */
function initCustomEnrichments4CpDocAggiuntiva(){
/*PROTECTED REGION ID(R-423279218) ENABLED START*/
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

function initUIStructCpDocAggiuntiva(){
	var contentPanelName = "cpDocAggiuntiva";
	var structure =
      {
        name: "p_pDocAggiuntiva", panels: [
        {
          name: "p_pCenter", panels: [
          {
            name: "p_fpDocAggiuntiva", panels: [
            {
              name: "p_pErrori", panels: [
              ]
            }
,            {
              name: "p_wpDocAggiuntiva", panels: []
            }
,            {
              name: "p_pDocAggiuntivaNav", panels: []
            }
,            {
              name: "p_indietroNav", panels: []
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

	initStdEnrichments4CpDocAggiuntiva();
	initCustomEnrichments4CpDocAggiuntiva();
	initUIStructCpDocAggiuntiva();
	uiEnricherMgr.setReady();
	uiEnricherMgr.applyAll("cpDocAggiuntiva");

});



