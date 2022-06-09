

/**
 * Arricchimenti standard per il ContentPanel [cpUploadDocAggiuntiva] da registrare nella
 * variabile globale uiEnricherMgr
 */
function initStdEnrichments4CpUploadDocAggiuntiva() {
	var contentPanelName = "cpUploadDocAggiuntiva";
	/// arricchimento per guigen::ComboBox [cbTipoDoc]: autonarrowing
	var addNarrowingToCbTipoDoc =
		function(){
			uiNRichLib.addComboNarrowingNRich(
				'widg_cbTipoDoc',
			 	true);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_pTipoDoc", addNarrowingToCbTipoDoc);




}

/**
 * Arricchimenti custom
 */
function initCustomEnrichments4CpUploadDocAggiuntiva(){
/*PROTECTED REGION ID(R519030029) ENABLED START*/
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

function initUIStructCpUploadDocAggiuntiva(){
	var contentPanelName = "cpUploadDocAggiuntiva";
	var structure =
      {
        name: "p_pUploadDocAggiuntiva", panels: [
        {
          name: "p_pCenter", panels: [
          {
            name: "p_pInvioDoc", panels: []
          }
,          {
            name: "p_pTipoDoc", panels: []
          }
,          {
            name: "p_fpUploadDocAggiuntiva", panels: [
            {
              name: "p_pErrori", panels: [
              ]
            }
,            {
              name: "p_pDocAggiuntivaNav", panels: []
            }
,            {
              name: "p_indietroNav", panels: []
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

	initStdEnrichments4CpUploadDocAggiuntiva();
	initCustomEnrichments4CpUploadDocAggiuntiva();
	initUIStructCpUploadDocAggiuntiva();
	uiEnricherMgr.setReady();
	uiEnricherMgr.applyAll("cpUploadDocAggiuntiva");

});



