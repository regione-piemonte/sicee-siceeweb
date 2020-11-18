

/**
 * Arricchimenti standard per il ContentPanel [cpRobot] da registrare nella
 * variabile globale uiEnricherMgr
 */
function initStdEnrichments4CpRobot() {
	var contentPanelName = "cpRobot";

}

/**
 * Arricchimenti custom
 */
function initCustomEnrichments4CpRobot(){
/*PROTECTED REGION ID(R-1269283361) ENABLED START*/
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

function initUIStructCpRobot(){
	var contentPanelName = "cpRobot";
	var structure =
      {
        name: "p_pMain", panels: [
        {
          name: "p_pCenter", panels: [
          {
            name: "p_pRobotPanel", panels: [
            {
              name: "p_cpRobotFunc", panels: []
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

	initStdEnrichments4CpRobot();
	initCustomEnrichments4CpRobot();
	initUIStructCpRobot();
	uiEnricherMgr.setReady();
	uiEnricherMgr.applyAll("cpRobot");

});



