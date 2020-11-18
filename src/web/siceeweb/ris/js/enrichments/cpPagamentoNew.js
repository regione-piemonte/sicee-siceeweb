

/**
 * Arricchimenti standard per il ContentPanel [cpPagamentoNew] da registrare nella
 * variabile globale uiEnricherMgr
 */
function initStdEnrichments4CpPagamentoNew() {
	var contentPanelName = "cpPagamentoNew";
	/// arricchimento di base per guigen::TextField [tfImporto]
	var addBasicEnrichmentToTfImporto =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfImporto',
			 	false,
			 	'it.csi.sicee.siceeweb.dto.type.UDTPositiveDoubleTwo',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_pDatiPagamentoNew", addBasicEnrichmentToTfImporto);
	/// arricchimento di base per guigen::TextField [tfCF]
	var addBasicEnrichmentToTfCF =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfCF',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_pDatiPagamentoNewTit", addBasicEnrichmentToTfCF);
	/// arricchimento di base per guigen::TextField [tfNominativo]
	var addBasicEnrichmentToTfNominativo =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfNominativo',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_pDatiPagamentoNewTit", addBasicEnrichmentToTfNominativo);


}

/**
 * Arricchimenti custom
 */
function initCustomEnrichments4CpPagamentoNew(){
/*PROTECTED REGION ID(R320532233) ENABLED START*/
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

function initUIStructCpPagamentoNew(){
	var contentPanelName = "cpPagamentoNew";
	var structure =
      {
        name: "p_pMainPagamentoNew", panels: [
        {
          name: "p_pCenter", panels: [
          {
            name: "p_pPagamentoNew", panels: [
            {
              name: "p_pErrPagamentoNew", panels: [
              ]
            }
,            {
              name: "p_pDatiPagamentoNew", panels: []
            }
,            {
              name: "p_pDatiPagamentoNewTit", panels: []
            }
,            {
              name: "p_pPagamentoNewFun", panels: []
            }
,            {
              name: "p_pPagamentoNewNav", panels: []
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

	initStdEnrichments4CpPagamentoNew();
	initCustomEnrichments4CpPagamentoNew();
	initUIStructCpPagamentoNew();
	uiEnricherMgr.setReady();
	uiEnricherMgr.applyAll("cpPagamentoNew");

});



