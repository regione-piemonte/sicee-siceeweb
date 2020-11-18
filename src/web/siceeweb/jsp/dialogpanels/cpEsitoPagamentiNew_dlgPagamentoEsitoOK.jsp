<%@taglib uri="/struts-tags" prefix="s" %>
<s:include value="../fragments/header.jsp" ></s:include>

<s:form id="dlgPagamentoEsitoOKForm" action="cpEsitoPagamentiNew" namespace="/base/main" method="post">

	<!-- ####################### PANNELLO CONTENUTI ###################### -->
	<div id="contentPanel">
		<div id="centerWrapper" class="floatWrapper">
			<div id="centerPanel">
			
			<a id="main_content" name="main_content"></a>
				<h3><s:text name="cpEsitoPagamentiNew.dlgPagamentoEsitoOK.label" /></h3>
				<div class="dialogPanel" id="dlgPagamentoEsitoOK">

		
		
<div id="p_pMsgPagOk" class="msgBoxPanelBlock"><!-- startFragment:p_pMsgPagOk -->

	
<div class="msgBoxPanel info" id="pMsgPagOk">


		
<s:if test="isWidgetVisible('cpEsitoPagamentiNew','txtMsgPagOK1')" >

	
<p>


<!-- widget txtMsgPagOK1 -->
<s:text name="cpEsitoPagamentiNew.txtMsgPagOK1.statictext.label" />

	
</p>

</s:if>

	


	
</div>

<!-- endFragment:p_pMsgPagOk --></div>

	
	<div id="p_pCmdPagOK" class="commandPanelBlock"><!-- startFragment:p_pCmdPagOK -->
	
	
<div class="commandPanel navigation" id="pCmdPagOK">

	
	
		

	
	
	
	

	
	
	
	

	
	
	
	<div class="button right">
		
<s:if test="isWidgetVisible('cpEsitoPagamentiNew','bPagOK')" >

	



<!-- widget bPagOK -->
	<csiuicore:ajaxify id="p_pCenter" 
		widgetType="button"
		 
		requestUri="/siceeweb/base/main/cpEsitoPagamentiNew!handleBPagOK_CLICKED.do" 
		
		pageId="cpEsitoPagamentiNew" 
		formName="cpEsitoPagamentiNew"
		javascriptDetection="false">
<s:submit name="widg_bPagOK" id="widg_bPagOK" method="handleBPagOK_CLICKED"
	key="cpEsitoPagamentiNew.bPagOK.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpEsitoPagamentiNew','bPagOK')" />

	</csiuicore:ajaxify>

	


</s:if>

	


	</div>
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_pCmdPagOK --></div>

				</div>

			</div>
		</div>
	</div>
	<!-- #################### FINE PANNELLO CONTENUTI #################### -->

</s:form>

<s:include value="../fragments/footer.jsp" ></s:include>
