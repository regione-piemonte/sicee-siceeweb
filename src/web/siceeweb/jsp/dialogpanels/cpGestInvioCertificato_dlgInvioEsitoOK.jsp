<%@taglib uri="/struts-tags" prefix="s" %>
<s:include value="../fragments/header.jsp" ></s:include>

<s:form id="dlgInvioEsitoOKForm" action="cpGestInvioCertificato" namespace="/base/gestattestati" method="post">

	<!-- ####################### PANNELLO CONTENUTI ###################### -->
	<div id="contentPanel">
		<div id="centerWrapper" class="floatWrapper">
			<div id="centerPanel">
			
			<a id="main_content" name="main_content"></a>
				<h3><s:text name="cpGestInvioCertificato.dlgInvioEsitoOK.label" /></h3>
				<div class="dialogPanel" id="dlgInvioEsitoOK">

		
		
<div id="p_pMsgInvioOk" class="msgBoxPanelBlock"><!-- startFragment:p_pMsgInvioOk -->

	
<div class="msgBoxPanel info" id="pMsgInvioOk">


		
<s:if test="isWidgetVisible('cpGestInvioCertificato','txtMsgInvioOK1')" >

	
<p>


<!-- widget txtMsgInvioOK1 -->
<s:text name="cpGestInvioCertificato.txtMsgInvioOK1.statictext.label" />

	
</p>

</s:if>

	


	
</div>

<!-- endFragment:p_pMsgInvioOk --></div>

	
	<div id="p_pCmdInvioOK" class="commandPanelBlock"><!-- startFragment:p_pCmdInvioOK -->
	
	
<div class="commandPanel navigation" id="pCmdInvioOK">

	
	
		

	
	
	
	

	
	
	
	

	
	
	
	<div class="button right">
		
<s:if test="isWidgetVisible('cpGestInvioCertificato','bStampaRicevutaInvio')" >

	



<!-- widget bStampaRicevutaInvio -->
<s:submit name="widg_bStampaRicevutaInvio" id="widg_bStampaRicevutaInvio" method="handleBStampaRicevutaInvio_CLICKED"
	key="cpGestInvioCertificato.bStampaRicevutaInvio.label" cssClass="buttonWidget showReport"
	disabled="isWidgetDisabled('cpGestInvioCertificato','bStampaRicevutaInvio')" />

	


</s:if>

	


		
<s:if test="isWidgetVisible('cpGestInvioCertificato','bInvioOK')" >

	



<!-- widget bInvioOK -->
	<csiuicore:ajaxify id="p_pCenter" 
		widgetType="button"
		 
		requestUri="/siceeweb/base/gestattestati/cpGestInvioCertificato!handleBInvioOK_CLICKED.do" 
		
		pageId="cpGestInvioCertificato" 
		formName="cpGestInvioCertificato"
		javascriptDetection="false">
<s:submit name="widg_bInvioOK" id="widg_bInvioOK" method="handleBInvioOK_CLICKED"
	key="cpGestInvioCertificato.bInvioOK.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpGestInvioCertificato','bInvioOK')" />

	</csiuicore:ajaxify>

	


</s:if>

	


	</div>
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_pCmdInvioOK --></div>

				</div>

			</div>
		</div>
	</div>
	<!-- #################### FINE PANNELLO CONTENUTI #################### -->

</s:form>

<s:include value="../fragments/footer.jsp" ></s:include>
