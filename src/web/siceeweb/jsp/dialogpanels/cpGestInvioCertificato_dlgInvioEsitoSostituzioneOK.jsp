<%@taglib uri="/struts-tags" prefix="s" %>
<s:include value="../fragments/header.jsp" ></s:include>

<s:form id="dlgInvioEsitoSostituzioneOKForm" action="cpGestInvioCertificato" namespace="/base/gestattestati" method="post">

	<!-- ####################### PANNELLO CONTENUTI ###################### -->
	<div id="contentPanel">
		<div id="centerWrapper" class="floatWrapper">
			<div id="centerPanel">
			
			<a id="main_content" name="main_content"></a>
				<h3><s:text name="cpGestInvioCertificato.dlgInvioEsitoSostituzioneOK.label" /></h3>
				<div class="dialogPanel" id="dlgInvioEsitoSostituzioneOK">

		
		
<div id="p_pMsgInvioSostituzioneOk" class="msgBoxPanelBlock"><!-- startFragment:p_pMsgInvioSostituzioneOk -->

	
<div class="msgBoxPanel info" id="pMsgInvioSostituzioneOk">


		
<s:if test="isWidgetVisible('cpGestInvioCertificato','txtMsgInvioSostituzioneOK1')" >

	
<p>


<!-- widget txtMsgInvioSostituzioneOK1 -->
<s:text name="cpGestInvioCertificato.txtMsgInvioSostituzioneOK1.statictext.label" />

	
</p>

</s:if>

	


	
</div>

<!-- endFragment:p_pMsgInvioSostituzioneOk --></div>

	
	<div id="p_pCmdInvioSostituzioneOK" class="commandPanelBlock"><!-- startFragment:p_pCmdInvioSostituzioneOK -->
	
	
<div class="commandPanel navigation" id="pCmdInvioSostituzioneOK">

	
	
		

	
	
	
	

	
	
	
	

	
	
	
	<div class="button right">
		
<s:if test="isWidgetVisible('cpGestInvioCertificato','bSostituzioneOK')" >

	



<!-- widget bSostituzioneOK -->
<s:submit name="widg_bSostituzioneOK" id="widg_bSostituzioneOK" method="handleBSostituzioneOK_CLICKED"
	key="cpGestInvioCertificato.bSostituzioneOK.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpGestInvioCertificato','bSostituzioneOK')" />

	


</s:if>

	


		
<s:if test="isWidgetVisible('cpGestInvioCertificato','bInvioSostituzioneOK')" >

	



<!-- widget bInvioSostituzioneOK -->
	<csiuicore:ajaxify id="p_pCenter" 
		widgetType="button"
		 
		requestUri="/siceeweb/base/gestattestati/cpGestInvioCertificato!handleBInvioSostituzioneOK_CLICKED.do" 
		
		pageId="cpGestInvioCertificato" 
		formName="cpGestInvioCertificato"
		javascriptDetection="false">
<s:submit name="widg_bInvioSostituzioneOK" id="widg_bInvioSostituzioneOK" method="handleBInvioSostituzioneOK_CLICKED"
	key="cpGestInvioCertificato.bInvioSostituzioneOK.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpGestInvioCertificato','bInvioSostituzioneOK')" />

	</csiuicore:ajaxify>

	


</s:if>

	


	</div>
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_pCmdInvioSostituzioneOK --></div>

				</div>

			</div>
		</div>
	</div>
	<!-- #################### FINE PANNELLO CONTENUTI #################### -->

</s:form>

<s:include value="../fragments/footer.jsp" ></s:include>
