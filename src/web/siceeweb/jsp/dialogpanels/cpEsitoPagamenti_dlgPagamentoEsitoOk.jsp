<%@taglib uri="/struts-tags" prefix="s" %>
<s:include value="../fragments/header.jsp" ></s:include>

<s:form id="dlgPagamentoEsitoOkForm" action="cpEsitoPagamenti" namespace="/base/main" method="post">

	<!-- ####################### PANNELLO CONTENUTI ###################### -->
	<div id="contentPanel">
		<div id="centerWrapper" class="floatWrapper">
			<div id="centerPanel">
			
			<a id="main_content" name="main_content"></a>
				<h3><s:text name="cpEsitoPagamenti.dlgPagamentoEsitoOk.label" /></h3>
				<div class="dialogPanel" id="dlgPagamentoEsitoOk">

		
		
<div id="p_pMsgPagOk" class="msgBoxPanelBlock"><!-- startFragment:p_pMsgPagOk -->

	
<div class="msgBoxPanel info" id="pMsgPagOk">


		
<s:if test="isWidgetVisible('cpEsitoPagamenti','txtMsgPagOK1')" >

	
<p>


<!-- widget txtMsgPagOK1 -->
<s:property value="appDatamsgPagamento" escape="false" />

	
</p>

</s:if>

	


	
</div>

<!-- endFragment:p_pMsgPagOk --></div>

	
	<div id="p_pCmdPagOK" class="commandPanelBlock"><!-- startFragment:p_pCmdPagOK -->
	
	
<div class="commandPanel navigation" id="pCmdPagOK">

	
	
		

	
	
	
	

	
	
	
	

	
	
	
	<div class="button right">
		
<s:if test="isWidgetVisible('cpEsitoPagamenti','bStampaRicevutaRegistrazione')" >

	



<!-- widget bStampaRicevutaRegistrazione -->
<s:submit name="widg_bStampaRicevutaRegistrazione" id="widg_bStampaRicevutaRegistrazione" method="handleBStampaRicevutaRegistrazione_CLICKED"
	key="cpEsitoPagamenti.bStampaRicevutaRegistrazione.label" cssClass="buttonWidget showReport"
	disabled="isWidgetDisabled('cpEsitoPagamenti','bStampaRicevutaRegistrazione')" />

	


</s:if>

	


		
<s:if test="isWidgetVisible('cpEsitoPagamenti','bStampaRicevutaACE')" >

	



<!-- widget bStampaRicevutaACE -->
<s:submit name="widg_bStampaRicevutaACE" id="widg_bStampaRicevutaACE" method="handleBStampaRicevutaACE_CLICKED"
	key="cpEsitoPagamenti.bStampaRicevutaACE.label" cssClass="buttonWidget showReport"
	disabled="isWidgetDisabled('cpEsitoPagamenti','bStampaRicevutaACE')" />

	


</s:if>

	


		
<s:if test="isWidgetVisible('cpEsitoPagamenti','bPagOK')" >

	



<!-- widget bPagOK -->
	<csiuicore:ajaxify id="p_pCenter" 
		widgetType="button"
		 
		requestUri="/siceeweb/base/main/cpEsitoPagamenti!handleBPagOK_CLICKED.do" 
		
		pageId="cpEsitoPagamenti" 
		formName="cpEsitoPagamenti"
		javascriptDetection="false">
<s:submit name="widg_bPagOK" id="widg_bPagOK" method="handleBPagOK_CLICKED"
	key="cpEsitoPagamenti.bPagOK.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpEsitoPagamenti','bPagOK')" />

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
