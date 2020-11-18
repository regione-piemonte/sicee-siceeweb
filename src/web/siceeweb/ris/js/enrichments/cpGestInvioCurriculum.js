

/**
 * Arricchimenti standard per il ContentPanel [cpGestInvioCurriculum] da registrare nella
 * variabile globale uiEnricherMgr
 */
function initStdEnrichments4CpGestInvioCurriculum() {
	var contentPanelName = "cpGestInvioCurriculum";

}

/**
 * Arricchimenti custom
 */
function initCustomEnrichments4CpGestInvioCurriculum(){
/*PROTECTED REGION ID(R-1141188440) ENABLED START*/
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

function initUIStructCpGestInvioCurriculum(){
	var contentPanelName = "cpGestInvioCurriculum";
	var structure =
      {
        name: "p_pMain", panels: [
        {
          name: "p_pCenter", panels: [
          {
            name: "p_pInvioCert", panels: [
            {
              name: "p_pErrInvioDocumento", panels: [
              ]
            }
,            {
              name: "p_pInvio", panels: []
            }
,            {
              name: "p_pPagamentoNav", panels: []
            }
,            {
              name: "p_pListaDocumenti", panels: []
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

	initStdEnrichments4CpGestInvioCurriculum();
	initCustomEnrichments4CpGestInvioCurriculum();
	initUIStructCpGestInvioCurriculum();
	uiEnricherMgr.setReady();
	uiEnricherMgr.applyAll("cpGestInvioCurriculum");

});



