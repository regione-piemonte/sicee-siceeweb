<%@taglib uri="/struts-tags" prefix="s" %>
<s:include value="../fragments/header.jsp" ></s:include>

<s:form id="dlgPagamentoEsitoABORTForm" action="cpEsitoPagamenti" namespace="/base/main" method="post">

	<!-- ####################### PANNELLO CONTENUTI ###################### -->
	<div id="contentPanel">
		<div id="centerWrapper" class="floatWrapper">
			<div id="centerPanel">
			
			<a id="main_content" name="main_content"></a>
				<h3><s:text name="cpEsitoPagamenti.dlgPagamentoEsitoABORT.label" /></h3>
				<div class="dialogPanel" id="dlgPagamentoEsitoABORT">

		
		
<div id="p_pMsgPagABORT" class="msgBoxPanelBlock"><!-- startFragment:p_pMsgPagABORT -->

	
<div class="msgBoxPanel error" id="pMsgPagABORT">


		
<s:if test="isWidgetVisible('cpEsitoPagamenti','txtMsgPagABORT')" >

	
<p>


<!-- widget txtMsgPagABORT -->
<s:text name="cpEsitoPagamenti.txtMsgPagABORT.statictext.label" />

	
</p>

</s:if>

	


	
</div>

<!-- endFragment:p_pMsgPagABORT --></div>

	
	<div id="p_pCmdPagABORT" class="commandPanelBlock"><!-- startFragment:p_pCmdPagABORT -->
	
	
<div class="commandPanel navigation" id="pCmdPagABORT">

	
	
		

	
	
	
	

	
	
	
	

	
	
	
	<div class="button right">
		
<s:if test="isWidgetVisible('cpEsitoPagamenti','bPagABORT')" >

	



<!-- widget bPagABORT -->
	<csiuicore:ajaxify id="p_pCenter" 
		widgetType="button"
		 
		requestUri="/siceeweb/base/main/cpEsitoPagamenti!handleBPagABORT_CLICKED.do" 
		
		pageId="cpEsitoPagamenti" 
		formName="cpEsitoPagamenti"
		javascriptDetection="false">
<s:submit name="widg_bPagABORT" id="widg_bPagABORT" method="handleBPagABORT_CLICKED"
	key="cpEsitoPagamenti.bPagABORT.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpEsitoPagamenti','bPagABORT')" />

	</csiuicore:ajaxify>

	


</s:if>

	


	</div>
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_pCmdPagABORT --></div>

				</div>

			</div>
		</div>
	</div>
	<!-- #################### FINE PANNELLO CONTENUTI #################### -->

</s:form>

<s:include value="../fragments/footer.jsp" ></s:include>
