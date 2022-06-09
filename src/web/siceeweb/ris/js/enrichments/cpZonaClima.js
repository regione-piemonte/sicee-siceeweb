

/**
 * Arricchimenti standard per il ContentPanel [cpZonaClima] da registrare nella
 * variabile globale uiEnricherMgr
 */
function initStdEnrichments4CpZonaClima() {
	var contentPanelName = "cpZonaClima";
	/// arricchimento per guigen::ComboBox [cbZonaClima]: autonarrowing
	var addNarrowingToCbZonaClima =
		function(){
			uiNRichLib.addComboNarrowingNRich(
				'widg_cbZonaClima',
			 	true);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_pWZonaClima", addNarrowingToCbZonaClima);




}

/**
 * Arricchimenti custom
 */
function initCustomEnrichments4CpZonaClima(){
/*PROTECTED REGION ID(R1077172577) ENABLED START*/
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

function initUIStructCpZonaClima(){
	var contentPanelName = "cpZonaClima";
	var structure =
      {
        name: "p_pZonaClima", panels: [
        {
          name: "p_pCenter", panels: [
          {
            name: "p_pWZonaClima", panels: []
          }
,          {
            name: "p_fpZonaClima", panels: [
            {
              name: "p_pErrori", panels: [
              ]
            }
,            {
              name: "p_pZonaClimaNav", panels: []
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

	initStdEnrichments4CpZonaClima();
	initCustomEnrichments4CpZonaClima();
	initUIStructCpZonaClima();
	uiEnricherMgr.setReady();
	uiEnricherMgr.applyAll("cpZonaClima");

});



