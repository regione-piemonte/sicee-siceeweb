<%@taglib uri="/struts-tags" prefix="s" %>
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="/customtag" prefix="customtag" %>
<%@taglib uri="/csiuicore" prefix="csiuicore" %>

	
	<div id="p_pRiepilogo" class="formPanelBlock"><!-- startFragment:p_pRiepilogo -->
		
	
<div class="formPanel" id="pRiepilogo">


	
	

	
	
			
	
	<div id="p_pErrRiepilogo" class="stdMessagePanelBlock"><!-- startFragment:p_pErrRiepilogo -->
	
	
<div class="stdMessagePanel" id="pErrRiepilogo">
	<customtag:stdMessagePanel id="pErrRiepilogo" errorMessage="true" errorDetails="false" actionMessage="true" />
</div>

	<!-- endFragment:p_pErrRiepilogo --></div>

			
	
	<div id="p_pDtRiepilogo1" class="widgetsPanelBlock"><!-- startFragment:p_pDtRiepilogo1 -->
	
	

<div class="widgetsPanel" id="pDtRiepilogo1">
	
	<customtag:widgetsPanel id="pDtRiepilogo1Tbl" columns="2" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('cpRegistraz','tfNomeRiep')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpRegistraz.tfNomeRiep.label')}" labelFor="widg_tfNomeRiep" errorFor="appDatacertificatore.dtAnag.nome" labelId="tfNomeRiepLbl"   >


<!-- widget tfNomeRiep -->
<s:property value="appDatacertificatore.dtAnag.nome" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpRegistraz','tfCognomeRiep')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpRegistraz.tfCognomeRiep.label')}" labelFor="widg_tfCognomeRiep" errorFor="appDatacertificatore.dtAnag.cognome" labelId="tfCognomeRiepLbl"   >


<!-- widget tfCognomeRiep -->
<s:property value="appDatacertificatore.dtAnag.cognome" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpRegistraz','tfCF')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpRegistraz.tfCF.label')}" labelFor="widg_tfCF" errorFor="appDatacertificatore.dtAnag.codFisc" labelId="tfCFLbl"   >


<!-- widget tfCF -->
<s:property value="appDatacertificatore.dtAnag.codFisc" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpRegistraz','tfTipoIstruzione')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpRegistraz.tfTipoIstruzione.label')}" labelFor="widg_tfTipoIstruzione" errorFor="appDatacertificatore.dtOrdine.descTipoIstruzione" labelId="tfTipoIstruzioneLbl"   >


<!-- widget tfTipoIstruzione -->
<s:property value="appDatacertificatore.dtOrdine.descTipoIstruzione" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpRegistraz','tfTitoloIstruzione')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpRegistraz.tfTitoloIstruzione.label')}" labelFor="widg_tfTitoloIstruzione" errorFor="appDatacertificatore.dtOrdine.descCodTitoloIstruzione" labelId="tfTitoloIstruzioneLbl"   >


<!-- widget tfTitoloIstruzione -->
<s:property value="appDatacertificatore.dtOrdine.descCodTitoloIstruzione" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_pDtRiepilogo1 --></div>

			
	
	<div id="p_pDtRiepilogo2" class="widgetsPanelBlock"><!-- startFragment:p_pDtRiepilogo2 -->
	
	
<h4 class="wpLabel">Trattamento dati personali </h4>
<div class="widgetsPanel" id="pDtRiepilogo2">
	
	<customtag:widgetsPanel id="pDtRiepilogo2Tbl" columns="2" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('cpRegistraz','txtTrattDatiPers')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpRegistraz.txtTrattDatiPers.label')}" labelFor="widg_txtTrattDatiPers" errorFor="widg_txtTrattDatiPers" labelId="txtTrattDatiPersLbl"   >


<!-- widget txtTrattDatiPers -->
<s:text name="cpRegistraz.txtTrattDatiPers.statictext.label" />

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpRegistraz','ckTrattDatiPers')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRegistraz.ckTrattDatiPers.label')}" labelFor="widg_ckTrattDatiPers" errorFor="appDataflagDatiPers" labelId="ckTrattDatiPersLbl"
	  >


<!-- widget ckTrattDatiPers -->
<s:checkbox 
	
	
	name="appDataflagDatiPers" id="widg_ckTrattDatiPers"
	disabled="isWidgetDisabled('cpRegistraz','ckTrattDatiPers')"
	cssClass="checkbox"
	
	/> 
<s:if test="!isWidgetDisabled('cpRegistraz','ckTrattDatiPers')" >
	<s:hidden name="__checkbox_appDataflagDatiPers" id="__checkbox_widg_ckTrattDatiPers" />
</s:if>

	
</customtag:widgetsPanelColumn>

</s:if>

	



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_pDtRiepilogo2 --></div>

			
	
	<div id="p_pDtRiepilogo3" class="widgetsPanelBlock"><!-- startFragment:p_pDtRiepilogo3 -->
	
	
<h4 class="wpLabel">Autocertificazione </h4>
<div class="widgetsPanel" id="pDtRiepilogo3">
	
	<customtag:widgetsPanel id="pDtRiepilogo3Tbl" columns="2" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('cpRegistraz','txtAutocertificazione')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpRegistraz.txtAutocertificazione.label')}" labelFor="widg_txtAutocertificazione" errorFor="widg_txtAutocertificazione" labelId="txtAutocertificazioneLbl"   >


<!-- widget txtAutocertificazione -->
<s:text name="cpRegistraz.txtAutocertificazione.statictext.label" />

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpRegistraz','ckAutocert')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRegistraz.ckAutocert.label')}" labelFor="widg_ckAutocert" errorFor="appDataflagAutocert" labelId="ckAutocertLbl"
	  >


<!-- widget ckAutocert -->
<s:checkbox 
	
	
	name="appDataflagAutocert" id="widg_ckAutocert"
	disabled="isWidgetDisabled('cpRegistraz','ckAutocert')"
	cssClass="checkbox"
	
	/> 
<s:if test="!isWidgetDisabled('cpRegistraz','ckAutocert')" >
	<s:hidden name="__checkbox_appDataflagAutocert" id="__checkbox_widg_ckAutocert" />
</s:if>

	
</customtag:widgetsPanelColumn>

</s:if>

	



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_pDtRiepilogo3 --></div>

			
	
	<div id="p_pDatiPagamento" class="widgetsPanelBlock"><!-- startFragment:p_pDatiPagamento -->
	
	

<div class="widgetsPanel" id="pDatiPagamento">
	
	<customtag:widgetsPanel id="pDatiPagamentoTbl" columns="2" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('cpRegistraz','hvPagamentoOK')" >

	
<div class="hidden">


<!-- widget hvPagamentoOK -->
<s:hidden name="widg_hvPagamentoOK" id="widg_hvPagamentoOK" />

	
</div>

</s:if>

	



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_pDatiPagamento --></div>

			
	
	<div id="p_pDtRiepilogoNav" class="commandPanelBlock"><!-- startFragment:p_pDtRiepilogoNav -->
	
	
<div class="commandPanel navigation" id="pDtRiepilogoNav">

	
	
		

	
	
	
	<div class="button left">
		
<s:if test="isWidgetVisible('cpRegistraz','bDtRiepilogoIndietro')" >

	



<!-- widget bDtRiepilogoIndietro -->
	<csiuicore:ajaxify id="p_pWizRegistraz,p_pUp" 
		widgetType="button"
		 
		requestUri="/siceeweb/base/gestcertificatore/cpRegistraz!handleBDtRiepilogoIndietro_CLICKED.do" 
		
		pageId="cpRegistraz" 
		formName="cpRegistraz"
		javascriptDetection="false">
<s:submit name="widg_bDtRiepilogoIndietro" id="widg_bDtRiepilogoIndietro" method="handleBDtRiepilogoIndietro_CLICKED"
	key="cpRegistraz.bDtRiepilogoIndietro.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpRegistraz','bDtRiepilogoIndietro')" />

	</csiuicore:ajaxify>

	


</s:if>

	


	</div>
	
	

	
	
	
	

	
	
	
	<div class="button right">
		
<s:if test="isWidgetVisible('cpRegistraz','bDtRiepilogoAvanti')" >

	



<!-- widget bDtRiepilogoAvanti -->
<s:submit name="widg_bDtRiepilogoAvanti" id="widg_bDtRiepilogoAvanti" method="handleBDtRiepilogoAvanti_CLICKED"
	key="cpRegistraz.bDtRiepilogoAvanti.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpRegistraz','bDtRiepilogoAvanti')" />

	


</s:if>

	


	</div>
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_pDtRiepilogoNav --></div>

	

		
	
</div>

	<!-- endFragment:p_pRiepilogo --></div>
