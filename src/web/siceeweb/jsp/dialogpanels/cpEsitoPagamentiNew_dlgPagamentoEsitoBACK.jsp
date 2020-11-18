<%@taglib uri="/struts-tags" prefix="s" %>
<s:include value="../fragments/header.jsp" ></s:include>

<s:form id="dlgPagamentoEsitoBACKForm" action="cpEsitoPagamentiNew" namespace="/base/main" method="post">

	<!-- ####################### PANNELLO CONTENUTI ###################### -->
	<div id="contentPanel">
		<div id="centerWrapper" class="floatWrapper">
			<div id="centerPanel">
			
			<a id="main_content" name="main_content"></a>
				<h3><s:text name="cpEsitoPagamentiNew.dlgPagamentoEsitoBACK.label" /></h3>
				<div class="dialogPanel" id="dlgPagamentoEsitoBACK">

		
		
<div id="p_pMsgPagBACK" class="msgBoxPanelBlock"><!-- startFragment:p_pMsgPagBACK -->

	
<div class="msgBoxPanel error" id="pMsgPagBACK">


		
<s:if test="isWidgetVisible('cpEsitoPagamentiNew','txtMsgPagABACK')" >

	
<p>


<!-- widget txtMsgPagABACK -->
<s:text name="cpEsitoPagamentiNew.txtMsgPagABACK.statictext.label" />

	
</p>

</s:if>

	


	
</div>

<!-- endFragment:p_pMsgPagBACK --></div>

	
	<div id="p_pCmdPagBACK" class="commandPanelBlock"><!-- startFragment:p_pCmdPagBACK -->
	
	
<div class="commandPanel navigation" id="pCmdPagBACK">

	
	
		

	
	
	
	

	
	
	
	

	
	
	
	<div class="button right">
		
<s:if test="isWidgetVisible('cpEsitoPagamentiNew','bPagBACK')" >

	



<!-- widget bPagBACK -->
	<csiuicore:ajaxify id="p_pCenter" 
		widgetType="button"
		 
		requestUri="/siceeweb/base/main/cpEsitoPagamentiNew!handleBPagBACK_CLICKED.do" 
		
		pageId="cpEsitoPagamentiNew" 
		formName="cpEsitoPagamentiNew"
		javascriptDetection="false">
<s:submit name="widg_bPagBACK" id="widg_bPagBACK" method="handleBPagBACK_CLICKED"
	key="cpEsitoPagamentiNew.bPagBACK.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpEsitoPagamentiNew','bPagBACK')" />

	</csiuicore:ajaxify>

	


</s:if>

	


	</div>
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_pCmdPagBACK --></div>

				</div>

			</div>
		</div>
	</div>
	<!-- #################### FINE PANNELLO CONTENUTI #################### -->

</s:form>

<s:include value="../fragments/footer.jsp" ></s:include>
