

/**
 * Arricchimenti standard per il ContentPanel [cpVisuraCIT] da registrare nella
 * variabile globale uiEnricherMgr
 */
function initStdEnrichments4CpVisuraCIT() {
	var contentPanelName = "cpVisuraCIT";
	/// arricchimento di base per guigen::TextField [tfRicCodice]
	var addBasicEnrichmentToTfRicCodice =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfRicCodice',
			 	false,
			 	'it.csi.sicee.siceeweb.dto.type.UDTPositiveInteger',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpVisura", addBasicEnrichmentToTfRicCodice);
	/// arricchimento di base per guigen::TextField [tfRicPod]
	var addBasicEnrichmentToTfRicPod =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfRicPod',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpVisura", addBasicEnrichmentToTfRicPod);
	/// arricchimento di base per guigen::TextField [tfRicPdr]
	var addBasicEnrichmentToTfRicPdr =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfRicPdr',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpVisura", addBasicEnrichmentToTfRicPdr);


}

/**
 * Arricchimenti custom
 */
function initCustomEnrichments4CpVisuraCIT(){
/*PROTECTED REGION ID(R-1993908513) ENABLED START*/
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

function initUIStructCpVisuraCIT(){
	var contentPanelName = "cpVisuraCIT";
	var structure =
      {
        name: "p_pMain", panels: [
        {
          name: "p_pCenter", panels: [
          {
            name: "p_pVisura", panels: [
            {
              name: "p_pErrVisura", panels: [
              ]
            }
,            {
              name: "p_wpVisura", panels: []
            }
,            {
              name: "p_mpElencoImp", panels: [
              {
                name: "p_fpElencoImp", panels: [
                {
                  name: "p_wpElencoImp", panels: []
                }
,                {
                  name: "p_wpElencoImpCom", panels: []
                }
                ]
              }
              ]
            }
,            {
              name: "p_mpDettImpianto", panels: [
              {
                name: "p_fpDettImpianto", panels: [
                {
                  name: "p_wpDettImpianto", panels: []
                }
,                {
                  name: "p_wpRifCatastale", panels: []
                }
,                {
                  name: "p_wpRappControllo", panels: []
                }
,                {
                  name: "p_cpDettImpCom", panels: []
                }
                ]
              }
              ]
            }
,            {
              name: "p_cpNavVisura", panels: []
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
            name: "p_pUserInfoCustomPagamento", panels: [
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

	initStdEnrichments4CpVisuraCIT();
	initCustomEnrichments4CpVisuraCIT();
	initUIStructCpVisuraCIT();
	uiEnricherMgr.setReady();
	uiEnricherMgr.applyAll("cpVisuraCIT");

});



