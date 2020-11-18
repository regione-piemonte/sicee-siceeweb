

/**
 * Arricchimenti standard per il ContentPanel [cpRegistraz] da registrare nella
 * variabile globale uiEnricherMgr
 */
function initStdEnrichments4CpRegistraz() {
	var contentPanelName = "cpRegistraz";
	/// arricchimento di base per guigen::TextField [tfCognome]
	var addBasicEnrichmentToTfCognome =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfCognome',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_pDtAnag1", addBasicEnrichmentToTfCognome);
	/// arricchimento di base per guigen::TextField [tfNome]
	var addBasicEnrichmentToTfNome =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfNome',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_pDtAnag1", addBasicEnrichmentToTfNome);
	/// arricchimento di base per guigen::TextField [tfCodFisc]
	var addBasicEnrichmentToTfCodFisc =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfCodFisc',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_pDtAnag1", addBasicEnrichmentToTfCodFisc);
	/// arricchimento per guigen::Calendar [calDtNascita]: aggiunta datepicker
	var addDateToCalDtNascita = function(){
		uiNRichLib.addDatePickerNRich("widg_calDtNascita", 
		false, false, "", false);
	};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_pDtAnag1", addDateToCalDtNascita);
	/// arricchimento di base per guigen::TextField [tfStatoEstero]
	var addBasicEnrichmentToTfStatoEstero =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfStatoEstero',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_pDtAnag1", addBasicEnrichmentToTfStatoEstero);







	/// arricchimento di base per guigen::TextField [tfIndirizzoRes]
	var addBasicEnrichmentToTfIndirizzoRes =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfIndirizzoRes',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_pDtResItaliana", addBasicEnrichmentToTfIndirizzoRes);

	/// arricchimento di base per guigen::TextField [tfNCivRes]
	var addBasicEnrichmentToTfNCivRes =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfNCivRes',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_pDtResItaliana", addBasicEnrichmentToTfNCivRes);
	/// arricchimento di base per guigen::TextField [tfCAPRes]
	var addBasicEnrichmentToTfCAPRes =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfCAPRes',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_pDtResItaliana", addBasicEnrichmentToTfCAPRes);
	/// arricchimento di base per guigen::TextField [tfStatoResEstero]
	var addBasicEnrichmentToTfStatoResEstero =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfStatoResEstero',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_pDtResEstera", addBasicEnrichmentToTfStatoResEstero);
	/// arricchimento di base per guigen::TextField [tfCittaEstera]
	var addBasicEnrichmentToTfCittaEstera =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfCittaEstera',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_pDtResEstera", addBasicEnrichmentToTfCittaEstera);
	/// arricchimento di base per guigen::TextField [tfCapEstero]
	var addBasicEnrichmentToTfCapEstero =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfCapEstero',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_pDtResEstera", addBasicEnrichmentToTfCapEstero);
	/// arricchimento di base per guigen::TextField [tfViaEstera]
	var addBasicEnrichmentToTfViaEstera =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfViaEstera',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_pDtResEstera", addBasicEnrichmentToTfViaEstera);
	/// arricchimento di base per guigen::TextField [tfCivicoEstero]
	var addBasicEnrichmentToTfCivicoEstero =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfCivicoEstero',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_pDtResEstera", addBasicEnrichmentToTfCivicoEstero);
	/// arricchimento di base per guigen::TextField [tfTelRes]
	var addBasicEnrichmentToTfTelRes =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfTelRes',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_pDtContatti", addBasicEnrichmentToTfTelRes);
	/// arricchimento di base per guigen::TextField [tfCellRes]
	var addBasicEnrichmentToTfCellRes =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfCellRes',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_pDtContatti", addBasicEnrichmentToTfCellRes);
	/// arricchimento di base per guigen::TextField [tfEmailRes]
	var addBasicEnrichmentToTfEmailRes =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfEmailRes',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_pDtContatti", addBasicEnrichmentToTfEmailRes);
	/// arricchimento di base per guigen::TextField [tfEmailPec]
	var addBasicEnrichmentToTfEmailPec =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfEmailPec',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_pDtContatti", addBasicEnrichmentToTfEmailPec);
	/// arricchimento di base per guigen::TextField [tfFaxRes]
	var addBasicEnrichmentToTfFaxRes =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfFaxRes',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_pDtContatti", addBasicEnrichmentToTfFaxRes);
	/// arricchimento di base per guigen::TextField [tfSitoWeb]
	var addBasicEnrichmentToTfSitoWeb =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfSitoWeb',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_pDtContatti", addBasicEnrichmentToTfSitoWeb);

	/// arricchimento di base per guigen::TextField [tfRagSociale]
	var addBasicEnrichmentToTfRagSociale =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfRagSociale',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_pDtStudio1", addBasicEnrichmentToTfRagSociale);
	/// arricchimento di base per guigen::TextField [tfPIVA]
	var addBasicEnrichmentToTfPIVA =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfPIVA',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_pDtStudio1", addBasicEnrichmentToTfPIVA);



	/// arricchimento di base per guigen::TextField [tfIndirizzoStudio]
	var addBasicEnrichmentToTfIndirizzoStudio =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfIndirizzoStudio',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_pDtStudio1", addBasicEnrichmentToTfIndirizzoStudio);

	/// arricchimento di base per guigen::TextField [tfNCivStudio]
	var addBasicEnrichmentToTfNCivStudio =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfNCivStudio',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_pDtStudio1", addBasicEnrichmentToTfNCivStudio);
	/// arricchimento di base per guigen::TextField [tfCAPStudio]
	var addBasicEnrichmentToTfCAPStudio =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfCAPStudio',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_pDtStudio1", addBasicEnrichmentToTfCAPStudio);



	/// arricchimento di base per guigen::TextField [tfSezioneIscriz]
	var addBasicEnrichmentToTfSezioneIscriz =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfSezioneIscriz',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_pDtOrdine1", addBasicEnrichmentToTfSezioneIscriz);
	/// arricchimento di base per guigen::TextField [tfSettoreIscriz]
	var addBasicEnrichmentToTfSettoreIscriz =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfSettoreIscriz',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_pDtOrdine1", addBasicEnrichmentToTfSettoreIscriz);
	/// arricchimento di base per guigen::TextField [tfAlboIscriz]
	var addBasicEnrichmentToTfAlboIscriz =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfAlboIscriz',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_pDtOrdine1", addBasicEnrichmentToTfAlboIscriz);
	/// arricchimento di base per guigen::TextField [tfProvinciaIscriz]
	var addBasicEnrichmentToTfProvinciaIscriz =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfProvinciaIscriz',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_pDtOrdine1", addBasicEnrichmentToTfProvinciaIscriz);
	/// arricchimento di base per guigen::TextField [tfNumIscriz]
	var addBasicEnrichmentToTfNumIscriz =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfNumIscriz',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_pDtOrdine1", addBasicEnrichmentToTfNumIscriz);
	/// arricchimento per guigen::Calendar [calDataIscrizione]: aggiunta datepicker
	var addDateToCalDataIscrizione = function(){
		uiNRichLib.addDatePickerNRich("widg_calDataIscrizione", 
		false, false, "", false);
	};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_pDtOrdine1", addDateToCalDataIscrizione);


}

/**
 * Arricchimenti custom
 */
function initCustomEnrichments4CpRegistraz(){
/*PROTECTED REGION ID(R1859232298) ENABLED START*/
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

function initUIStructCpRegistraz(){
	var contentPanelName = "cpRegistraz";
	var structure =
      {
        name: "p_pMain", panels: [
        {
          name: "p_pCenter", panels: [
          {
            name: "p_pWizRegistraz", panels: [
            {
              name: "p_pDatiAnag", panels: [
              {
                name: "p_pErrDtAnag", panels: [
                ]
              }
,              {
                name: "p_pDtAnag1", panels: []
              }
,              {
                name: "p_pDtAnagNav", panels: []
              }
              ]
            }
,            {
              name: "p_pResidenza", panels: [
              {
                name: "p_pErrDtRes", panels: [
                ]
              }
,              {
                name: "p_pDtRes1", panels: []
              }
,              {
                name: "p_pDtResItaliana", panels: []
              }
,              {
                name: "p_pDtResEstera", panels: []
              }
,              {
                name: "p_pDtContatti", panels: []
              }
,              {
                name: "p_pDtResNav", panels: []
              }
              ]
            }
,            {
              name: "p_pStudio", panels: [
              {
                name: "p_pErrDtStudio", panels: [
                ]
              }
,              {
                name: "p_pDtStudio1", panels: []
              }
,              {
                name: "p_pDtStudioNav", panels: []
              }
              ]
            }
,            {
              name: "p_pOrdine", panels: [
              {
                name: "p_pErrDtOrdine", panels: [
                ]
              }
,              {
                name: "p_pDtOrdine1", panels: []
              }
,              {
                name: "p_pListaTitoloStudio", panels: []
              }
,              {
                name: "p_pUploadTitoloStudio", panels: []
              }
,              {
                name: "p_pPresaVisione", panels: []
              }
,              {
                name: "p_pListaAttPartNew", panels: []
              }
,              {
                name: "p_pUploadAttPartNew", panels: []
              }
,              {
                name: "p_pListaAttPartOld", panels: []
              }
,              {
                name: "p_pNote", panels: []
              }
,              {
                name: "p_pDtOrdineNav", panels: []
              }
              ]
            }
,            {
              name: "p_pRiepilogo", panels: [
              {
                name: "p_pErrRiepilogo", panels: [
                ]
              }
,              {
                name: "p_pDtRiepilogo1", panels: []
              }
,              {
                name: "p_pDtRiepilogo2", panels: []
              }
,              {
                name: "p_pDtRiepilogo3", panels: []
              }
,              {
                name: "p_pDatiPagamento", panels: []
              }
,              {
                name: "p_pDtRiepilogoNav", panels: []
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

	initStdEnrichments4CpRegistraz();
	initCustomEnrichments4CpRegistraz();
	initUIStructCpRegistraz();
	uiEnricherMgr.setReady();
	uiEnricherMgr.applyAll("cpRegistraz");

});



