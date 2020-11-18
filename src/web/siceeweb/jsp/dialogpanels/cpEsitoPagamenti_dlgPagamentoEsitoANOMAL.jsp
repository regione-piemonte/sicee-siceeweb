<%@taglib uri="/struts-tags" prefix="s" %>
<s:include value="../fragments/header.jsp" ></s:include>

<s:form id="dlgPagamentoEsitoANOMALForm" action="cpEsitoPagamenti" namespace="/base/main" method="post">

	<!-- ####################### PANNELLO CONTENUTI ###################### -->
	<div id="contentPanel">
		<div id="centerWrapper" class="floatWrapper">
			<div id="centerPanel">
			
			<a id="main_content" name="main_content"></a>
				<h3><s:text name="cpEsitoPagamenti.dlgPagamentoEsitoANOMAL.label" /></h3>
				<div class="dialogPanel" id="dlgPagamentoEsitoANOMAL">

		
		
<div id="p_pMsgPagANOMAL" class="msgBoxPanelBlock"><!-- startFragment:p_pMsgPagANOMAL -->

	
<div class="msgBoxPanel error" id="pMsgPagANOMAL">


		
<s:if test="isWidgetVisible('cpEsitoPagamenti','txtMsgPagANOMAL1')" >

	
<p>


<!-- widget txtMsgPagANOMAL1 -->
<s:text name="cpEsitoPagamenti.txtMsgPagANOMAL1.statictext.label" />

	
</p>

</s:if>

		
<s:if test="isWidgetVisible('cpEsitoPagamenti','txtMsgPagANOMAL2')" >

	
<p>


<!-- widget txtMsgPagANOMAL2 -->
<s:text name="cpEsitoPagamenti.txtMsgPagANOMAL2.statictext.label" />

	
</p>

</s:if>

	


	
</div>

<!-- endFragment:p_pMsgPagANOMAL --></div>

	
	<div id="p_pCmdPagANOMAL" class="commandPanelBlock"><!-- startFragment:p_pCmdPagANOMAL -->
	
	
<div class="commandPanel navigation" id="pCmdPagANOMAL">

	
	
		

	
	
	
	

	
	
	
	

	
	
	
	<div class="button right">
		
<s:if test="isWidgetVisible('cpEsitoPagamenti','bPagANOMAL')" >

	



<!-- widget bPagANOMAL -->
	<csiuicore:ajaxify id="p_pCenter" 
		widgetType="button"
		 
		requestUri="/siceeweb/base/main/cpEsitoPagamenti!handleBPagANOMAL_CLICKED.do" 
		
		pageId="cpEsitoPagamenti" 
		formName="cpEsitoPagamenti"
		javascriptDetection="false">
<s:submit name="widg_bPagANOMAL" id="widg_bPagANOMAL" method="handleBPagANOMAL_CLICKED"
	key="cpEsitoPagamenti.bPagANOMAL.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpEsitoPagamenti','bPagANOMAL')" />

	</csiuicore:ajaxify>

	


</s:if>

	


	</div>
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_pCmdPagANOMAL --></div>

				</div>

			</div>
		</div>
	</div>
	<!-- #################### FINE PANNELLO CONTENUTI #################### -->

</s:form>

<s:include value="../fragments/footer.jsp" ></s:include>
