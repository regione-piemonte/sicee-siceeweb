<%@taglib uri="/struts-tags" prefix="s" %>
<s:include value="../fragments/header.jsp" ></s:include>

<s:form id="dlgEsitoTransazioneRegOKForm" action="cpTransazAnomale" namespace="/base/gestcertificatore" method="post">

	<!-- ####################### PANNELLO CONTENUTI ###################### -->
	<div id="contentPanel">
		<div id="centerWrapper" class="floatWrapper">
			<div id="centerPanel">
			
			<a id="main_content" name="main_content"></a>
				<h3><s:text name="cpTransazAnomale.dlgEsitoTransazioneRegOK.label" /></h3>
				<div class="dialogPanel" id="dlgEsitoTransazioneRegOK">

		
		
<div id="p_pMsgEsitoTransazioneRegOK" class="msgBoxPanelBlock"><!-- startFragment:p_pMsgEsitoTransazioneRegOK -->

	
<div class="msgBoxPanel info" id="pMsgEsitoTransazioneRegOK">


		
<s:if test="isWidgetVisible('cpTransazAnomale','txtMsgEsitoTransazioneReg')" >

	
<p>


<!-- widget txtMsgEsitoTransazioneReg -->
<s:property value="appDatamsgEsitoTransazione" escape="false" />

	
</p>

</s:if>

	


	
</div>

<!-- endFragment:p_pMsgEsitoTransazioneRegOK --></div>

	
	<div id="p_pCmdEsitoTransazioneRegOK" class="commandPanelBlock"><!-- startFragment:p_pCmdEsitoTransazioneRegOK -->
	
	
<div class="commandPanel navigation" id="pCmdEsitoTransazioneRegOK">

	
	
		

	
	
	
	

	
	
	
	

	
	
	
	<div class="button right">
		
<s:if test="isWidgetVisible('cpTransazAnomale','bStampaRicevutaReg')" >

	



<!-- widget bStampaRicevutaReg -->
<s:submit name="widg_bStampaRicevutaReg" id="widg_bStampaRicevutaReg" method="handleBStampaRicevutaReg_CLICKED"
	key="cpTransazAnomale.bStampaRicevutaReg.label" cssClass="buttonWidget showReport"
	disabled="isWidgetDisabled('cpTransazAnomale','bStampaRicevutaReg')" />

	


</s:if>

	


		
<s:if test="isWidgetVisible('cpTransazAnomale','bEsitoTransazioneRegOK')" >

	



<!-- widget bEsitoTransazioneRegOK -->
	<csiuicore:ajaxify id="p_pCenter" 
		widgetType="button"
		 
		requestUri="/siceeweb/base/gestcertificatore/cpTransazAnomale!handleBEsitoTransazioneRegOK_CLICKED.do" 
		
		pageId="cpTransazAnomale" 
		formName="cpTransazAnomale"
		javascriptDetection="false">
<s:submit name="widg_bEsitoTransazioneRegOK" id="widg_bEsitoTransazioneRegOK" method="handleBEsitoTransazioneRegOK_CLICKED"
	key="cpTransazAnomale.bEsitoTransazioneRegOK.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpTransazAnomale','bEsitoTransazioneRegOK')" />

	</csiuicore:ajaxify>

	


</s:if>

	


	</div>
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_pCmdEsitoTransazioneRegOK --></div>

				</div>

			</div>
		</div>
	</div>
	<!-- #################### FINE PANNELLO CONTENUTI #################### -->

</s:form>

<s:include value="../fragments/footer.jsp" ></s:include>
