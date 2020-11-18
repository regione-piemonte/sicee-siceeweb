<%@taglib uri="/struts-tags" prefix="s" %>
<s:include value="../fragments/header.jsp" ></s:include>

<s:form id="dlgVerificaMailEsitoKoForm" action="cpGestioneDialogMail" namespace="/base/gestcertificatore" method="post">

	<!-- ####################### PANNELLO CONTENUTI ###################### -->
	<div id="contentPanel">
		<div id="centerWrapper" class="floatWrapper">
			<div id="centerPanel">
			
			<a id="main_content" name="main_content"></a>
				<h3><s:text name="cpGestioneDialogMail.dlgVerificaMailEsitoKo.label" /></h3>
				<div class="dialogPanel" id="dlgVerificaMailEsitoKo">

		
		
<div id="p_pMsgMailEsitoKO" class="msgBoxPanelBlock"><!-- startFragment:p_pMsgMailEsitoKO -->

	
<div class="msgBoxPanel error" id="pMsgMailEsitoKO">


		
<s:if test="isWidgetVisible('cpGestioneDialogMail','txtMsgMailEsitoKO')" >

	
<p>


<!-- widget txtMsgMailEsitoKO -->
<s:property value="appDatamsgEsitoVerificaMail" escape="false" />

	
</p>

</s:if>

	


	
</div>

<!-- endFragment:p_pMsgMailEsitoKO --></div>

	
	<div id="p_cpMailEsitoKO" class="commandPanelBlock"><!-- startFragment:p_cpMailEsitoKO -->
	
	
<div class="commandPanel functional" id="cpMailEsitoKO">

	
	
		

	
	
	
	

	
	
	
	

	
	
	
	<div class="button right">
		
<s:if test="isWidgetVisible('cpGestioneDialogMail','cbMailEsitoKO')" >

	



<!-- widget cbMailEsitoKO -->
<s:submit name="widg_cbMailEsitoKO" id="widg_cbMailEsitoKO" method="handleCbMailEsitoKO_CLICKED"
	key="cpGestioneDialogMail.cbMailEsitoKO.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpGestioneDialogMail','cbMailEsitoKO')" />

	


</s:if>

	


	</div>
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_cpMailEsitoKO --></div>

				</div>

			</div>
		</div>
	</div>
	<!-- #################### FINE PANNELLO CONTENUTI #################### -->

</s:form>

<s:include value="../fragments/footer.jsp" ></s:include>
