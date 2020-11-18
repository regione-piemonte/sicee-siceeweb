<%@taglib uri="/struts-tags" prefix="s" %>
<s:include value="../fragments/header.jsp" ></s:include>

<s:form id="dlgPagamentoEsitoKOForm" action="cpEsitoPagamenti" namespace="/base/main" method="post">

	<!-- ####################### PANNELLO CONTENUTI ###################### -->
	<div id="contentPanel">
		<div id="centerWrapper" class="floatWrapper">
			<div id="centerPanel">
			
			<a id="main_content" name="main_content"></a>
				<h3><s:text name="cpEsitoPagamenti.dlgPagamentoEsitoKO.label" /></h3>
				<div class="dialogPanel" id="dlgPagamentoEsitoKO">

		
		
<div id="p_pMsgPagKO" class="msgBoxPanelBlock"><!-- startFragment:p_pMsgPagKO -->

	
<div class="msgBoxPanel error" id="pMsgPagKO">


		
<s:if test="isWidgetVisible('cpEsitoPagamenti','txtMsgPagKO1')" >

	
<p>


<!-- widget txtMsgPagKO1 -->
<s:text name="cpEsitoPagamenti.txtMsgPagKO1.statictext.label" />

	
</p>

</s:if>

		
<s:if test="isWidgetVisible('cpEsitoPagamenti','txtMsgPagKO2')" >

	
<p>


<!-- widget txtMsgPagKO2 -->
<s:text name="cpEsitoPagamenti.txtMsgPagKO2.statictext.label" />

	
</p>

</s:if>

	


	
</div>

<!-- endFragment:p_pMsgPagKO --></div>

	
	<div id="p_pCmdPagKO" class="commandPanelBlock"><!-- startFragment:p_pCmdPagKO -->
	
	
<div class="commandPanel navigation" id="pCmdPagKO">

	
	
		

	
	
	
	

	
	
	
	

	
	
	
	<div class="button right">
		
<s:if test="isWidgetVisible('cpEsitoPagamenti','bPagKO')" >

	



<!-- widget bPagKO -->
	<csiuicore:ajaxify id="p_pCenter" 
		widgetType="button"
		 
		requestUri="/siceeweb/base/main/cpEsitoPagamenti!handleBPagKO_CLICKED.do" 
		
		pageId="cpEsitoPagamenti" 
		formName="cpEsitoPagamenti"
		javascriptDetection="false">
<s:submit name="widg_bPagKO" id="widg_bPagKO" method="handleBPagKO_CLICKED"
	key="cpEsitoPagamenti.bPagKO.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpEsitoPagamenti','bPagKO')" />

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
