<%@taglib uri="/struts-tags" prefix="s" %>
<s:include value="../fragments/header.jsp" ></s:include>

<s:form id="dlgEsitoTransazioneMIDDLEForm" action="cpTransazAnomale" namespace="/base/gestcertificatore" method="post">

	<!-- ####################### PANNELLO CONTENUTI ###################### -->
	<div id="contentPanel">
		<div id="centerWrapper" class="floatWrapper">
			<div id="centerPanel">
			
			<a id="main_content" name="main_content"></a>
				<h3><s:text name="cpTransazAnomale.dlgEsitoTransazioneMIDDLE.label" /></h3>
				<div class="dialogPanel" id="dlgEsitoTransazioneMIDDLE">

		
		
<div id="p_pMsgEsitoTransazioneMIDDLE" class="msgBoxPanelBlock"><!-- startFragment:p_pMsgEsitoTransazioneMIDDLE -->

	
<div class="msgBoxPanel error" id="pMsgEsitoTransazioneMIDDLE">


		
<s:if test="isWidgetVisible('cpTransazAnomale','txtMsgEsitoTransazioneMIDDLE')" >

	
<p>


<!-- widget txtMsgEsitoTransazioneMIDDLE -->
<s:property value="appDatamsgEsitoTransazione" escape="false" />

	
</p>

</s:if>

	


	
</div>

<!-- endFragment:p_pMsgEsitoTransazioneMIDDLE --></div>

	
	<div id="p_pCmdEsitoTransazioneMIDDLE" class="commandPanelBlock"><!-- startFragment:p_pCmdEsitoTransazioneMIDDLE -->
	
	
<div class="commandPanel navigation" id="pCmdEsitoTransazioneMIDDLE">

	
	
		

	
	
	
	

	
	
	
	

	
	
	
	<div class="button right">
		
<s:if test="isWidgetVisible('cpTransazAnomale','bEsitoTransazioneMIDDLE')" >

	



<!-- widget bEsitoTransazioneMIDDLE -->
	<csiuicore:ajaxify id="p_pCenter" 
		widgetType="button"
		 
		requestUri="/siceeweb/base/gestcertificatore/cpTransazAnomale!handleBEsitoTransazioneMIDDLE_CLICKED.do" 
		
		pageId="cpTransazAnomale" 
		formName="cpTransazAnomale"
		javascriptDetection="false">
<s:submit name="widg_bEsitoTransazioneMIDDLE" id="widg_bEsitoTransazioneMIDDLE" method="handleBEsitoTransazioneMIDDLE_CLICKED"
	key="cpTransazAnomale.bEsitoTransazioneMIDDLE.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpTransazAnomale','bEsitoTransazioneMIDDLE')" />

	</csiuicore:ajaxify>

	


</s:if>

	


	</div>
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_pCmdEsitoTransazioneMIDDLE --></div>

				</div>

			</div>
		</div>
	</div>
	<!-- #################### FINE PANNELLO CONTENUTI #################### -->

</s:form>

<s:include value="../fragments/footer.jsp" ></s:include>
