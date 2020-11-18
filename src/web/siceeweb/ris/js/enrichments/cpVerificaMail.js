

/**
 * Arricchimenti standard per il ContentPanel [cpVerificaMail] da registrare nella
 * variabile globale uiEnricherMgr
 */
function initStdEnrichments4CpVerificaMail() {
	var contentPanelName = "cpVerificaMail";
	/// arricchimento di base per guigen::TextField [tfEmail]
	var addBasicEnrichmentToTfEmail =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfEmail',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_pMail", addBasicEnrichmentToTfEmail);

}

/**
 * Arricchimenti custom
 */
function initCustomEnrichments4CpVerificaMail(){
/*PROTECTED REGION ID(R1741119053) ENABLED START*/
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

function initUIStructCpVerificaMail(){
	var contentPanelName = "cpVerificaMail";
	var structure =
      {
        name: "p_pVerificaMail", panels: [
        {
          name: "p_pCenter", panels: [
          {
            name: "p_pErrMail", panels: [
            ]
          }
,          {
            name: "p_pMail", panels: []
          }
,          {
            name: "p_cpMail", panels: []
          }
          ]
        }
,        {
          name: "p_pUp", panels: [
          {
            name: "p_pUserInfoCustomRegistraz", panels: [
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

	initStdEnrichments4CpVerificaMail();
	initCustomEnrichments4CpVerificaMail();
	initUIStructCpVerificaMail();
	uiEnricherMgr.setReady();
	uiEnricherMgr.applyAll("cpVerificaMail");

});



