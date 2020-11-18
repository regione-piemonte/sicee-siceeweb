

/**
 * Arricchimenti standard per il ContentPanel [cpPrenotazAttestati] da registrare nella
 * variabile globale uiEnricherMgr
 */
function initStdEnrichments4CpPrenotazAttestati() {
	var contentPanelName = "cpPrenotazAttestati";

}

/**
 * Arricchimenti custom
 */
function initCustomEnrichments4CpPrenotazAttestati(){
/*PROTECTED REGION ID(R-1507615459) ENABLED START*/
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

function initUIStructCpPrenotazAttestati(){
	var contentPanelName = "cpPrenotazAttestati";
	var structure =
      {
        name: "p_pMain", panels: [
        {
          name: "p_pCenter", panels: [
          {
            name: "p_pPrenotazioneACE", panels: [
            {
              name: "p_pErrori", panels: [
              ]
            }
,            {
              name: "p_pDatiPrenotazione", panels: []
            }
,            {
              name: "p_pPagamentoNav", panels: []
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
            name: "p_pUserInfoCustomPrenACE", panels: [
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

	initStdEnrichments4CpPrenotazAttestati();
	initCustomEnrichments4CpPrenotazAttestati();
	initUIStructCpPrenotazAttestati();
	uiEnricherMgr.setReady();
	uiEnricherMgr.applyAll("cpPrenotazAttestati");

});



