

/**
 * Arricchimenti standard per il ContentPanel [cpPagamento] da registrare nella
 * variabile globale uiEnricherMgr
 */
function initStdEnrichments4CpPagamento() {
	var contentPanelName = "cpPagamento";

	/// arricchimento per guigen::Calendar [calDataValuta]: aggiunta datepicker
	var addDateToCalDataValuta = function(){
		uiNRichLib.addDatePickerNRich("widg_calDataValuta", 
		false, false, "", false);
	};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_pDatiPagamento", addDateToCalDataValuta);
	/// arricchimento di base per guigen::TextField [tfCRO]
	var addBasicEnrichmentToTfCRO =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfCRO',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_pDatiPagamento", addBasicEnrichmentToTfCRO);
	/// arricchimento di base per guigen::TextField [tfCognomeEsecutore]
	var addBasicEnrichmentToTfCognomeEsecutore =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfCognomeEsecutore',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_pDatiPagamento", addBasicEnrichmentToTfCognomeEsecutore);
	/// arricchimento di base per guigen::TextField [tfNomeEsecutore]
	var addBasicEnrichmentToTfNomeEsecutore =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfNomeEsecutore',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_pDatiPagamento", addBasicEnrichmentToTfNomeEsecutore);

}

/**
 * Arricchimenti custom
 */
function initCustomEnrichments4CpPagamento(){
/*PROTECTED REGION ID(R-1643440613) ENABLED START*/
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

function initUIStructCpPagamento(){
	var contentPanelName = "cpPagamento";
	var structure =
      {
        name: "p_pMain", panels: [
        {
          name: "p_pCenter", panels: [
          {
            name: "p_pPagamento", panels: [
            {
              name: "p_pErrPagamento", panels: [
              ]
            }
,            {
              name: "p_pDatiPagamento", panels: []
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

	initStdEnrichments4CpPagamento();
	initCustomEnrichments4CpPagamento();
	initUIStructCpPagamento();
	uiEnricherMgr.setReady();
	uiEnricherMgr.applyAll("cpPagamento");

});



