

/**
 * Arricchimenti standard per il ContentPanel [cpTransaz] da registrare nella
 * variabile globale uiEnricherMgr
 */
function initStdEnrichments4CpTransaz() {
	var contentPanelName = "cpTransaz";




	/// arricchimento di base per guigen::TextField [tfNumApe]
	var addBasicEnrichmentToTfNumApe =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfNumApe',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpGenApe", addBasicEnrichmentToTfNumApe);

}

/**
 * Arricchimenti custom
 */
function initCustomEnrichments4CpTransaz(){
/*PROTECTED REGION ID(R-1230776362) ENABLED START*/
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

function initUIStructCpTransaz(){
	var contentPanelName = "cpTransaz";
	var structure =
      {
        name: "p_pMain", panels: [
        {
          name: "p_pCenter", panels: [
          {
            name: "p_pWizTransaz", panels: [
            {
              name: "p_pRegistrazCert", panels: [
              {
                name: "p_pErrListTransReg", panels: [
                ]
              }
,              {
                name: "p_pListaReg", panels: []
              }
,              {
                name: "p_pStampaRicevutaReg", panels: []
              }
              ]
            }
,            {
              name: "p_pAcquistoAce", panels: [
              {
                name: "p_pErrListTransAce", panels: [
                ]
              }
,              {
                name: "p_pListaAce", panels: []
              }
,              {
                name: "p_pStampaRicevutaAce", panels: []
              }
              ]
            }
,            {
              name: "p_pAcquistoCrediti", panels: [
              {
                name: "p_pErrListCrediti", panels: [
                ]
              }
,              {
                name: "p_pFiltro", panels: []
              }
,              {
                name: "p_pListaCrediti", panels: []
              }
,              {
                name: "p_pVerificaCrediti", panels: []
              }
,              {
                name: "p_mpGeneraApe", panels: [
                {
                  name: "p_fpGeneraApe", panels: [
                  {
                    name: "p_wpGenApe", panels: []
                  }
,                  {
                    name: "p_cpGeneraApeFun", panels: []
                  }
                  ]
                }
                ]
              }
              ]
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

	initStdEnrichments4CpTransaz();
	initCustomEnrichments4CpTransaz();
	initUIStructCpTransaz();
	uiEnricherMgr.setReady();
	uiEnricherMgr.applyAll("cpTransaz");

});



