<%@taglib uri="/struts-tags" prefix="s" %>
<s:include value="../fragments/header.jsp" ></s:include>

<s:form id="dlgInvioEsitoKOForm" action="cpGestInvioCurriculum" namespace="/base/gestattestati" method="post">

	<!-- ####################### PANNELLO CONTENUTI ###################### -->
	<div id="contentPanel">
		<div id="centerWrapper" class="floatWrapper">
			<div id="centerPanel">
			
			<a id="main_content" name="main_content"></a>
				<h3><s:text name="cpGestInvioCurriculum.dlgInvioEsitoKO.label" /></h3>
				<div class="dialogPanel" id="dlgInvioEsitoKO">

		
		
<div id="p_pMsgInvioKo" class="msgBoxPanelBlock"><!-- startFragment:p_pMsgInvioKo -->

	
<div class="msgBoxPanel error" id="pMsgInvioKo">


		
<s:if test="isWidgetVisible('cpGestInvioCurriculum','txtMsgInvioKO1')" >

	
<p>


<!-- widget txtMsgInvioKO1 -->
<s:text name="cpGestInvioCurriculum.txtMsgInvioKO1.statictext.label" />

	
</p>

</s:if>

	


	
</div>

<!-- endFragment:p_pMsgInvioKo --></div>

	
	<div id="p_pCmdInvioKO" class="commandPanelBlock"><!-- startFragment:p_pCmdInvioKO -->
	
	
<div class="commandPanel navigation" id="pCmdInvioKO">

	
	
		

	
	
	
	

	
	
	
	

	
	
	
	<div class="button right">
		
<s:if test="isWidgetVisible('cpGestInvioCurriculum','bInvioKo')" >

	



<!-- widget bInvioKo -->
	<csiuicore:ajaxify id="p_pCenter" 
		widgetType="button"
		 
		requestUri="/siceeweb/base/gestattestati/cpGestInvioCurriculum!handleBInvioKo_CLICKED.do" 
		
		pageId="cpGestInvioCurriculum" 
		formName="cpGestInvioCurriculum"
		javascriptDetection="false">
<s:submit name="widg_bInvioKo" id="widg_bInvioKo" method="handleBInvioKo_CLICKED"
	key="cpGestInvioCurriculum.bInvioKo.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpGestInvioCurriculum','bInvioKo')" />

	</csiuicore:ajaxify>

	


</s:if>

	


	</div>
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_pCmdInvioKO --></div>

				</div>

			</div>
		</div>
	</div>
	<!-- #################### FINE PANNELLO CONTENUTI #################### -->

</s:form>

<s:include value="../fragments/footer.jsp" ></s:include>
