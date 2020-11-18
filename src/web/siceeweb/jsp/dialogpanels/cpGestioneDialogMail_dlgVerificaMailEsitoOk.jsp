<%@taglib uri="/struts-tags" prefix="s" %>
<s:include value="../fragments/header.jsp" ></s:include>

<s:form id="dlgVerificaMailEsitoOkForm" action="cpGestioneDialogMail" namespace="/base/gestcertificatore" method="post">

	<!-- ####################### PANNELLO CONTENUTI ###################### -->
	<div id="contentPanel">
		<div id="centerWrapper" class="floatWrapper">
			<div id="centerPanel">
			
			<a id="main_content" name="main_content"></a>
				<h3><s:text name="cpGestioneDialogMail.dlgVerificaMailEsitoOk.label" /></h3>
				<div class="dialogPanel" id="dlgVerificaMailEsitoOk">

		
		
<div id="p_pMsgMailEsitoOk" class="msgBoxPanelBlock"><!-- startFragment:p_pMsgMailEsitoOk -->

	
<div class="msgBoxPanel info" id="pMsgMailEsitoOk">


		
<s:if test="isWidgetVisible('cpGestioneDialogMail','txtMsgMailEsitoOK')" >

	
<p>


<!-- widget txtMsgMailEsitoOK -->
<s:text name="cpGestioneDialogMail.txtMsgMailEsitoOK.statictext.label" />

	
</p>

</s:if>

	


	
</div>

<!-- endFragment:p_pMsgMailEsitoOk --></div>

	
	<div id="p_cpMailEsitoOK" class="commandPanelBlock"><!-- startFragment:p_cpMailEsitoOK -->
	
	
<div class="commandPanel functional" id="cpMailEsitoOK">

	
	
		

	
	
	
	

	
	
	
	

	
	
	
	<div class="button right">
		
<s:if test="isWidgetVisible('cpGestioneDialogMail','cbMailEsitoOK')" >

	



<!-- widget cbMailEsitoOK -->
<s:submit name="widg_cbMailEsitoOK" id="widg_cbMailEsitoOK" method="handleCbMailEsitoOK_CLICKED"
	key="cpGestioneDialogMail.cbMailEsitoOK.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpGestioneDialogMail','cbMailEsitoOK')" />

	


</s:if>

	


	</div>
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_cpMailEsitoOK --></div>

				</div>

			</div>
		</div>
	</div>
	<!-- #################### FINE PANNELLO CONTENUTI #################### -->

</s:form>

<s:include value="../fragments/footer.jsp" ></s:include>
