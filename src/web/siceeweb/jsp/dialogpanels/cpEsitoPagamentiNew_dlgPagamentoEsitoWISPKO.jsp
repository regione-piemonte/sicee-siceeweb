<%@taglib uri="/struts-tags" prefix="s" %>
<s:include value="../fragments/header.jsp" ></s:include>

<s:form id="dlgPagamentoEsitoWISPKOForm" action="cpEsitoPagamentiNew" namespace="/base/main" method="post">

	<!-- ####################### PANNELLO CONTENUTI ###################### -->
	<div id="contentPanel">
		<div id="centerWrapper" class="floatWrapper">
			<div id="centerPanel">
			
			<a id="main_content" name="main_content"></a>
				<h3><s:text name="cpEsitoPagamentiNew.dlgPagamentoEsitoWISPKO.label" /></h3>
				<div class="dialogPanel" id="dlgPagamentoEsitoWISPKO">

		
		
<div id="p_pMsgPagWISPKO" class="msgBoxPanelBlock"><!-- startFragment:p_pMsgPagWISPKO -->

	
<div class="msgBoxPanel error" id="pMsgPagWISPKO">


		
<s:if test="isWidgetVisible('cpEsitoPagamentiNew','txtMsgPagWISPKO')" >

	
<p>


<!-- widget txtMsgPagWISPKO -->
<s:text name="cpEsitoPagamentiNew.txtMsgPagWISPKO.statictext.label" />

	
</p>

</s:if>

	


	
</div>

<!-- endFragment:p_pMsgPagWISPKO --></div>

	
	<div id="p_pCmdPagWISPKO" class="commandPanelBlock"><!-- startFragment:p_pCmdPagWISPKO -->
	
	
<div class="commandPanel navigation" id="pCmdPagWISPKO">

	
	
		

	
	
	
	

	
	
	
	

	
	
	
	<div class="button right">
		
<s:if test="isWidgetVisible('cpEsitoPagamentiNew','bPagWISPKO')" >

	



<!-- widget bPagWISPKO -->
	<csiuicore:ajaxify id="p_pCenter" 
		widgetType="button"
		 
		requestUri="/siceeweb/base/main/cpEsitoPagamentiNew!handleBPagWISPKO_CLICKED.do" 
		
		pageId="cpEsitoPagamentiNew" 
		formName="cpEsitoPagamentiNew"
		javascriptDetection="false">
<s:submit name="widg_bPagWISPKO" id="widg_bPagWISPKO" method="handleBPagWISPKO_CLICKED"
	key="cpEsitoPagamentiNew.bPagWISPKO.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpEsitoPagamentiNew','bPagWISPKO')" />

	</csiuicore:ajaxify>

	


</s:if>

	


	</div>
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_pCmdPagWISPKO --></div>

				</div>

			</div>
		</div>
	</div>
	<!-- #################### FINE PANNELLO CONTENUTI #################### -->

</s:form>

<s:include value="../fragments/footer.jsp" ></s:include>
