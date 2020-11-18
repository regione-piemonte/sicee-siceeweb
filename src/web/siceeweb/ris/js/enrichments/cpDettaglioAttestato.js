

/**
 * Arricchimenti standard per il ContentPanel [cpDettaglioAttestato] da registrare nella
 * variabile globale uiEnricherMgr
 */
function initStdEnrichments4CpDettaglioAttestato() {
	var contentPanelName = "cpDettaglioAttestato";

}

/**
 * Arricchimenti custom
 */
function initCustomEnrichments4CpDettaglioAttestato(){
/*PROTECTED REGION ID(R-1009990885) ENABLED START*/
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

function initUIStructCpDettaglioAttestato(){
	var contentPanelName = "cpDettaglioAttestato";
	var structure =
      {
        name: "p_pMain", panels: [
        {
          name: "p_pCenter", panels: [
          {
            name: "p_pDettaglioAttestato", panels: []
          }
,          {
            name: "p_pDettaglioAttestatoNAV", panels: []
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
            name: "p_pUserInfoCustom", panels: [
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

	initStdEnrichments4CpDettaglioAttestato();
	initCustomEnrichments4CpDettaglioAttestato();
	initUIStructCpDettaglioAttestato();
	uiEnricherMgr.setReady();
	uiEnricherMgr.applyAll("cpDettaglioAttestato");

});



