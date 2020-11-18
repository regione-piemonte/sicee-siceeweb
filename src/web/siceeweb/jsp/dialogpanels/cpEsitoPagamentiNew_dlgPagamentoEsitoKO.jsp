<%@taglib uri="/struts-tags" prefix="s" %>
<s:include value="../fragments/header.jsp" ></s:include>

<s:form id="dlgPagamentoEsitoKOForm" action="cpEsitoPagamentiNew" namespace="/base/main" method="post">

	<!-- ####################### PANNELLO CONTENUTI ###################### -->
	<div id="contentPanel">
		<div id="centerWrapper" class="floatWrapper">
			<div id="centerPanel">
			
			<a id="main_content" name="main_content"></a>
				<h3><s:text name="cpEsitoPagamentiNew.dlgPagamentoEsitoKO.label" /></h3>
				<div class="dialogPanel" id="dlgPagamentoEsitoKO">

		
		
<div id="p_pMsgPagKO" class="msgBoxPanelBlock"><!-- startFragment:p_pMsgPagKO -->

	
<div class="msgBoxPanel error" id="pMsgPagKO">


		
<s:if test="isWidgetVisible('cpEsitoPagamentiNew','txtMsgPagKO1')" >

	
<p>


<!-- widget txtMsgPagKO1 -->
<s:text name="cpEsitoPagamentiNew.txtMsgPagKO1.statictext.label" />

	
</p>

</s:if>

	


	
</div>

<!-- endFragment:p_pMsgPagKO --></div>

	
	<div id="p_pCmdPagKO" class="commandPanelBlock"><!-- startFragment:p_pCmdPagKO -->
	
	
<div class="commandPanel navigation" id="pCmdPagKO">

	
	
		

	
	
	
	

	
	
	
	

	
	
	
	<div class="button right">
		
<s:if test="isWidgetVisible('cpEsitoPagamentiNew','bPagKO')" >

	



<!-- widget bPagKO -->
	<csiuicore:ajaxify id="p_pCenter" 
		widgetType="button"
		 
		requestUri="/siceeweb/base/main/cpEsitoPagamentiNew!handleBPagKO_CLICKED.do" 
		
		pageId="cpEsitoPagamentiNew" 
		formName="cpEsitoPagamentiNew"
		javascriptDetection="false">
<s:submit name="widg_bPagKO" id="widg_bPagKO" method="handleBPagKO_CLICKED"
	key="cpEsitoPagamentiNew.bPagKO.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpEsitoPagamentiNew','bPagKO')" />

	</csiuicore:ajaxify>

	


</s:if>

	


	</div>
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_pCmdPagKO --></div>

				</div>

			</div>
		</div>
	</div>
	<!-- #################### FINE PANNELLO CONTENUTI #################### -->

</s:form>

<s:include value="../fragments/footer.jsp" ></s:include>
