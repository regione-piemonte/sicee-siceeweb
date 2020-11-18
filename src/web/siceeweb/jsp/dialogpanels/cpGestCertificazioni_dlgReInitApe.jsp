<%@taglib uri="/struts-tags" prefix="s" %>
<s:include value="../fragments/header.jsp" ></s:include>

<s:form id="dlgReInitApeForm" action="cpGestCertificazioni" namespace="/base/gestattestati" method="post">

	<!-- ####################### PANNELLO CONTENUTI ###################### -->
	<div id="contentPanel">
		<div id="centerWrapper" class="floatWrapper">
			<div id="centerPanel">
			
			<a id="main_content" name="main_content"></a>
				<h3><s:text name="cpGestCertificazioni.dlgReInitApe.label" /></h3>
				<div class="dialogPanel" id="dlgReInitApe">

		
		
<div id="p_pMsgReInitAPE" class="msgBoxPanelBlock"><!-- startFragment:p_pMsgReInitAPE -->

	
<div class="msgBoxPanel info" id="pMsgReInitAPE">


		
<s:if test="isWidgetVisible('cpGestCertificazioni','txtMsgReInitAPE')" >

	
<p>


<!-- widget txtMsgReInitAPE -->
<s:text name="cpGestCertificazioni.txtMsgReInitAPE.statictext.label" />

	
</p>

</s:if>

	


	
</div>

<!-- endFragment:p_pMsgReInitAPE --></div>

	
	<div id="p_pCmdReInitAPE" class="commandPanelBlock"><!-- startFragment:p_pCmdReInitAPE -->
	
	
<div class="commandPanel navigation" id="pCmdReInitAPE">

	
	
		

	
	
	
	<div class="button left">
		
<s:if test="isWidgetVisible('cpGestCertificazioni','btnIndietro')" >

	



<!-- widget btnIndietro -->
<s:submit name="widg_btnIndietro" id="widg_btnIndietro" method="handleBtnIndietro_CLICKED"
	key="cpGestCertificazioni.btnIndietro.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpGestCertificazioni','btnIndietro')" />

	


</s:if>

	


	</div>
	
	

	
	
	
	

	
	
	
	<div class="button right">
		
<s:if test="isWidgetVisible('cpGestCertificazioni','btnConferma')" >

	



<!-- widget btnConferma -->
<s:submit name="widg_btnConferma" id="widg_btnConferma" method="handleBtnConferma_CLICKED"
	key="cpGestCertificazioni.btnConferma.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpGestCertificazioni','btnConferma')" />

	


</s:if>

	


	</div>
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_pCmdReInitAPE --></div>

				</div>

			</div>
		</div>
	</div>
	<!-- #################### FINE PANNELLO CONTENUTI #################### -->

</s:form>

<s:include value="../fragments/footer.jsp" ></s:include>
