

/**
 * Arricchimenti standard per il ContentPanel [cpImportaXml] da registrare nella
 * variabile globale uiEnricherMgr
 */
function initStdEnrichments4CpImportaXml() {
	var contentPanelName = "cpImportaXml";


	/// arricchimento di base per guigen::TextField [tfGradiGiorno]
	var addBasicEnrichmentToTfGradiGiorno =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfGradiGiorno',
			 	false,
			 	'it.csi.sicee.siceeweb.dto.type.UDTPositiveInteger',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_pDatiAggiuntivi", addBasicEnrichmentToTfGradiGiorno);


}

/**
 * Arricchimenti custom
 */
function initCustomEnrichments4CpImportaXml(){
/*PROTECTED REGION ID(R-616381302) ENABLED START*/
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

function initUIStructCpImportaXml(){
	var contentPanelName = "cpImportaXml";
	var structure =
      {
        name: "p_pMain", panels: [
        {
          name: "p_pCenter", panels: [
          {
            name: "p_pMessagePanel", panels: [
            ]
          }
,          {
            name: "p_pDatiAggiuntivi", panels: []
          }
,          {
            name: "p_cpEffettuaCalcoli", panels: []
          }
,          {
            name: "p_pTable", panels: []
          }
,          {
            name: "p_pRisultati", panels: []
          }
,          {
            name: "p_mbpNote", panels: [
            ]
          }
,          {
            name: "p_cpNavigazione", panels: []
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
            name: "p_pUserInfoCustomHome", panels: [
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

	initStdEnrichments4CpImportaXml();
	initCustomEnrichments4CpImportaXml();
	initUIStructCpImportaXml();
	uiEnricherMgr.setReady();
	uiEnricherMgr.applyAll("cpImportaXml");

});



