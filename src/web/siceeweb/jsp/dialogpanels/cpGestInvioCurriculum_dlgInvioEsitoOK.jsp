<%@taglib uri="/struts-tags" prefix="s" %>
<s:include value="../fragments/header.jsp" ></s:include>

<s:form id="dlgInvioEsitoOKForm" action="cpGestInvioCurriculum" namespace="/base/gestattestati" method="post">

	<!-- ####################### PANNELLO CONTENUTI ###################### -->
	<div id="contentPanel">
		<div id="centerWrapper" class="floatWrapper">
			<div id="centerPanel">
			
			<a id="main_content" name="main_content"></a>
				<h3><s:text name="cpGestInvioCurriculum.dlgInvioEsitoOK.label" /></h3>
				<div class="dialogPanel" id="dlgInvioEsitoOK">

		
		
<div id="p_pMsgInvioOk" class="msgBoxPanelBlock"><!-- startFragment:p_pMsgInvioOk -->

	
<div class="msgBoxPanel info" id="pMsgInvioOk">


		
<s:if test="isWidgetVisible('cpGestInvioCurriculum','txtMsgInvioOK1')" >

	
<p>


<!-- widget txtMsgInvioOK1 -->
<s:text name="cpGestInvioCurriculum.txtMsgInvioOK1.statictext.label" />

	
</p>

</s:if>

	


	
</div>

<!-- endFragment:p_pMsgInvioOk --></div>

	
	<div id="p_pCmdInvioOK" class="commandPanelBlock"><!-- startFragment:p_pCmdInvioOK -->
	
	
<div class="commandPanel navigation" id="pCmdInvioOK">

	
	
		

	
	
	
	

	
	
	
	

	
	
	
	<div class="button right">
		
<s:if test="isWidgetVisible('cpGestInvioCurriculum','bInvioOK')" >

	



<!-- widget bInvioOK -->
	<csiuicore:ajaxify id="p_pCenter" 
		widgetType="button"
		 
		requestUri="/siceeweb/base/gestattestati/cpGestInvioCurriculum!handleBInvioOK_CLICKED.do" 
		
		pageId="cpGestInvioCurriculum" 
		formName="cpGestInvioCurriculum"
		javascriptDetection="false">
<s:submit name="widg_bInvioOK" id="widg_bInvioOK" method="handleBInvioOK_CLICKED"
	key="cpGestInvioCurriculum.bInvioOK.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpGestInvioCurriculum','bInvioOK')" />

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
