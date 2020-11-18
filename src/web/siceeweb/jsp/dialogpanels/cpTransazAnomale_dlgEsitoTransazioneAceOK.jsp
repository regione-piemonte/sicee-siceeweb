<%@taglib uri="/struts-tags" prefix="s" %>
<s:include value="../fragments/header.jsp" ></s:include>

<s:form id="dlgEsitoTransazioneAceOKForm" action="cpTransazAnomale" namespace="/base/gestcertificatore" method="post">

	<!-- ####################### PANNELLO CONTENUTI ###################### -->
	<div id="contentPanel">
		<div id="centerWrapper" class="floatWrapper">
			<div id="centerPanel">
			
			<a id="main_content" name="main_content"></a>
				<h3><s:text name="cpTransazAnomale.dlgEsitoTransazioneAceOK.label" /></h3>
				<div class="dialogPanel" id="dlgEsitoTransazioneAceOK">

		
		
<div id="p_pMsgEsitoTransazioneAceOK" class="msgBoxPanelBlock"><!-- startFragment:p_pMsgEsitoTransazioneAceOK -->

	
<div class="msgBoxPanel info" id="pMsgEsitoTransazioneAceOK">


		
<s:if test="isWidgetVisible('cpTransazAnomale','txtMsgEsitoTransazioneAce')" >

	
<p>


<!-- widget txtMsgEsitoTransazioneAce -->
<s:property value="appDatamsgEsitoTransazione" escape="false" />

	
</p>

</s:if>

	


	
</div>

<!-- endFragment:p_pMsgEsitoTransazioneAceOK --></div>

	
	<div id="p_pCmdEsitoTransazioneAceOK" class="commandPanelBlock"><!-- startFragment:p_pCmdEsitoTransazioneAceOK -->
	
	
<div class="commandPanel navigation" id="pCmdEsitoTransazioneAceOK">

	
	
		

	
	
	
	

	
	
	
	

	
	
	
	<div class="button right">
		
<s:if test="isWidgetVisible('cpTransazAnomale','bStampaRicevutaAce')" >

	



<!-- widget bStampaRicevutaAce -->
<s:submit name="widg_bStampaRicevutaAce" id="widg_bStampaRicevutaAce" method="handleBStampaRicevutaAce_CLICKED"
	key="cpTransazAnomale.bStampaRicevutaAce.label" cssClass="buttonWidget showReport"
	disabled="isWidgetDisabled('cpTransazAnomale','bStampaRicevutaAce')" />

	


</s:if>

	


		
<s:if test="isWidgetVisible('cpTransazAnomale','bEsitoTransazioneAceOK')" >

	



<!-- widget bEsitoTransazioneAceOK -->
	<csiuicore:ajaxify id="p_pCenter" 
		widgetType="button"
		 
		requestUri="/siceeweb/base/gestcertificatore/cpTransazAnomale!handleBEsitoTransazioneAceOK_CLICKED.do" 
		
		pageId="cpTransazAnomale" 
		formName="cpTransazAnomale"
		javascriptDetection="false">
<s:submit name="widg_bEsitoTransazioneAceOK" id="widg_bEsitoTransazioneAceOK" method="handleBEsitoTransazioneAceOK_CLICKED"
	key="cpTransazAnomale.bEsitoTransazioneAceOK.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpTransazAnomale','bEsitoTransazioneAceOK')" />

	</csiuicore:ajaxify>

	


</s:if>

	


	</div>
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_pCmdEsitoTransazioneAceOK --></div>

				</div>

			</div>
		</div>
	</div>
	<!-- #################### FINE PANNELLO CONTENUTI #################### -->

</s:form>

<s:include value="../fragments/footer.jsp" ></s:include>
