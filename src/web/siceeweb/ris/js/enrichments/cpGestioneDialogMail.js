

/**
 * Arricchimenti standard per il ContentPanel [cpGestioneDialogMail] da registrare nella
 * variabile globale uiEnricherMgr
 */
function initStdEnrichments4CpGestioneDialogMail() {
	var contentPanelName = "cpGestioneDialogMail";
}

/**
 * Arricchimenti custom
 */
function initCustomEnrichments4CpGestioneDialogMail(){
/*PROTECTED REGION ID(R-408872886) ENABLED START*/
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

function initUIStructCpGestioneDialogMail(){
	var contentPanelName = "cpGestioneDialogMail";
	var structure =
      {
        name: "p_pGestioneDialogMail", panels: [
        {
          name: "p_pCenter", panels: [
          {
            name: "p_fpGestioneDialogMail", panels: [
            {
              name: "p_mpGestioneDialogMail", panels: [
              ]
            }
,            {
              name: "p_wpGestioneDialogMail", panels: []
            }
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

	initStdEnrichments4CpGestioneDialogMail();
	initCustomEnrichments4CpGestioneDialogMail();
	initUIStructCpGestioneDialogMail();
	uiEnricherMgr.setReady();
	uiEnricherMgr.applyAll("cpGestioneDialogMail");

});



