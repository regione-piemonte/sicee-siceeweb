<%@taglib uri="/struts-tags" prefix="s" %>
<s:include value="../fragments/header.jsp" ></s:include>

<s:form id="dlgEsitoTransazioneKOForm" action="cpTransazAnomale" namespace="/base/gestcertificatore" method="post">

	<!-- ####################### PANNELLO CONTENUTI ###################### -->
	<div id="contentPanel">
		<div id="centerWrapper" class="floatWrapper">
			<div id="centerPanel">
			
			<a id="main_content" name="main_content"></a>
				<h3><s:text name="cpTransazAnomale.dlgEsitoTransazioneKO.label" /></h3>
				<div class="dialogPanel" id="dlgEsitoTransazioneKO">

		
		
<div id="p_pMsgEsitoTransazioneKO" class="msgBoxPanelBlock"><!-- startFragment:p_pMsgEsitoTransazioneKO -->

	
<div class="msgBoxPanel error" id="pMsgEsitoTransazioneKO">


		
<s:if test="isWidgetVisible('cpTransazAnomale','txtMsgEsitoTransazioneKO')" >

	
<p>


<!-- widget txtMsgEsitoTransazioneKO -->
<s:property value="appDatamsgEsitoTransazione" escape="false" />

	
</p>

</s:if>

	


	
</div>

<!-- endFragment:p_pMsgEsitoTransazioneKO --></div>

	
	<div id="p_pCmdEsitoTransazioneKO" class="commandPanelBlock"><!-- startFragment:p_pCmdEsitoTransazioneKO -->
	
	
<div class="commandPanel navigation" id="pCmdEsitoTransazioneKO">

	
	
		

	
	
	
	

	
	
	
	

	
	
	
	<div class="button right">
		
<s:if test="isWidgetVisible('cpTransazAnomale','bEsitoTransazioneKO')" >

	



<!-- widget bEsitoTransazioneKO -->
	<csiuicore:ajaxify id="p_pCenter" 
		widgetType="button"
		 
		requestUri="/siceeweb/base/gestcertificatore/cpTransazAnomale!handleBEsitoTransazioneKO_CLICKED.do" 
		
		pageId="cpTransazAnomale" 
		formName="cpTransazAnomale"
		javascriptDetection="false">
<s:submit name="widg_bEsitoTransazioneKO" id="widg_bEsitoTransazioneKO" method="handleBEsitoTransazioneKO_CLICKED"
	key="cpTransazAnomale.bEsitoTransazioneKO.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpTransazAnomale','bEsitoTransazioneKO')" />

	</csiuicore:ajaxify>

	


</s:if>

	


	</div>
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_pCmdEsitoTransazioneKO --></div>

				</div>

			</div>
		</div>
	</div>
	<!-- #################### FINE PANNELLO CONTENUTI #################### -->

</s:form>

<s:include value="../fragments/footer.jsp" ></s:include>
