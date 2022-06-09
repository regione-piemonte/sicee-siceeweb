<%@taglib uri="/struts-tags" prefix="s" %>
<s:include value="../fragments/header.jsp" ></s:include>

<s:form id="dlgDeleteDocForm" action="cpDocAggiuntiva" namespace="/base/gestattestati" method="post">

	<!-- ####################### PANNELLO CONTENUTI ###################### -->
	<div id="contentPanel">
		<div id="centerWrapper" class="floatWrapper">
			<div id="centerPanel">
			
			<a id="main_content" name="main_content"></a>
				<h3><s:text name="cpDocAggiuntiva.dlgDeleteDoc.label" /></h3>
				<div class="dialogPanel" id="dlgDeleteDoc">

		
		
<div id="p_pMsgEliminaDoc" class="msgBoxPanelBlock"><!-- startFragment:p_pMsgEliminaDoc -->

	
<div class="msgBoxPanel info" id="pMsgEliminaDoc">


		
<s:if test="isWidgetVisible('cpDocAggiuntiva','txtMsgEliminaDoc')" >

	
<p>


<!-- widget txtMsgEliminaDoc -->
<s:text name="cpDocAggiuntiva.txtMsgEliminaDoc.statictext.label" />

	
</p>

</s:if>

	


	
</div>

<!-- endFragment:p_pMsgEliminaDoc --></div>

	
	<div id="p_pCmdDeleteDoc" class="commandPanelBlock"><!-- startFragment:p_pCmdDeleteDoc -->
	
	
<div class="commandPanel navigation" id="pCmdDeleteDoc">

	
	
		

	
	
	
	<div class="button left">
		
<s:if test="isWidgetVisible('cpDocAggiuntiva','btnIndietro')" >

	



<!-- widget btnIndietro -->
<s:submit name="widg_btnIndietro" id="widg_btnIndietro" method="handleBtnIndietro_CLICKED"
	key="cpDocAggiuntiva.btnIndietro.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpDocAggiuntiva','btnIndietro')" />

	


</s:if>

	


	</div>
	
	

	
	
	
	

	
	
	
	<div class="button right">
		
<s:if test="isWidgetVisible('cpDocAggiuntiva','btnConferma')" >

	



<!-- widget btnConferma -->
<s:submit name="widg_btnConferma" id="widg_btnConferma" method="handleBtnConferma_CLICKED"
	key="cpDocAggiuntiva.btnConferma.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpDocAggiuntiva','btnConferma')" />

	


</s:if>

	


	</div>
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_pCmdDeleteDoc --></div>

				</div>

			</div>
		</div>
	</div>
	<!-- #################### FINE PANNELLO CONTENUTI #################### -->

</s:form>

<s:include value="../fragments/footer.jsp" ></s:include>
