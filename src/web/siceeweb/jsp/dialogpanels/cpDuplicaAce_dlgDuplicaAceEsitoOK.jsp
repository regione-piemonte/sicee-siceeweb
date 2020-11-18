<%@taglib uri="/struts-tags" prefix="s" %>
<s:include value="../fragments/header.jsp" ></s:include>

<s:form id="dlgDuplicaAceEsitoOKForm" action="cpDuplicaAce" namespace="/base/gestattestati" method="post">

	<!-- ####################### PANNELLO CONTENUTI ###################### -->
	<div id="contentPanel">
		<div id="centerWrapper" class="floatWrapper">
			<div id="centerPanel">
			
			<a id="main_content" name="main_content"></a>
				<h3><s:text name="cpDuplicaAce.dlgDuplicaAceEsitoOK.label" /></h3>
				<div class="dialogPanel" id="dlgDuplicaAceEsitoOK">

		
		
<div id="p_pMsgDuplicaAceOk" class="msgBoxPanelBlock"><!-- startFragment:p_pMsgDuplicaAceOk -->

	
<div class="msgBoxPanel info" id="pMsgDuplicaAceOk">


		
<s:if test="isWidgetVisible('cpDuplicaAce','txtMsgDuplicaAceOK1')" >

	
<p>


<!-- widget txtMsgDuplicaAceOK1 -->
<s:property value="appDatamsgDuplicaAce" escape="false" />

	
</p>

</s:if>

	


	
</div>

<!-- endFragment:p_pMsgDuplicaAceOk --></div>

	
	<div id="p_pCmdDuplicaAceOK" class="commandPanelBlock"><!-- startFragment:p_pCmdDuplicaAceOK -->
	
	
<div class="commandPanel navigation" id="pCmdDuplicaAceOK">

	
	
		

	
	
	
	

	
	
	
	

	
	
	
	<div class="button right">
		
<s:if test="isWidgetVisible('cpDuplicaAce','bDuplicaAceOK')" >

	



<!-- widget bDuplicaAceOK -->
	<csiuicore:ajaxify id="p_pCenter" 
		widgetType="button"
		 
		requestUri="/siceeweb/base/gestattestati/cpDuplicaAce!handleBDuplicaAceOK_CLICKED.do" 
		
		pageId="cpDuplicaAce" 
		formName="cpDuplicaAce"
		javascriptDetection="false">
<s:submit name="widg_bDuplicaAceOK" id="widg_bDuplicaAceOK" method="handleBDuplicaAceOK_CLICKED"
	key="cpDuplicaAce.bDuplicaAceOK.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpDuplicaAce','bDuplicaAceOK')" />

	</csiuicore:ajaxify>

	


</s:if>

	


	</div>
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_pCmdDuplicaAceOK --></div>

				</div>

			</div>
		</div>
	</div>
	<!-- #################### FINE PANNELLO CONTENUTI #################### -->

</s:form>

<s:include value="../fragments/footer.jsp" ></s:include>
