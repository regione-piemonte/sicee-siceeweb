<%@taglib uri="/struts-tags" prefix="s" %>
<s:include value="../fragments/header.jsp" ></s:include>

<s:form id="dlgCompletataRegistrazioneOkForm" action="cpRegistraz" namespace="/base/gestcertificatore" method="post">

	<!-- ####################### PANNELLO CONTENUTI ###################### -->
	<div id="contentPanel">
		<div id="centerWrapper" class="floatWrapper">
			<div id="centerPanel">
			
			<a id="main_content" name="main_content"></a>
				<h3><s:text name="cpRegistraz.dlgCompletataRegistrazioneOk.label" /></h3>
				<div class="dialogPanel" id="dlgCompletataRegistrazioneOk">

		
		
<div id="p_pMsgPagOk" class="msgBoxPanelBlock"><!-- startFragment:p_pMsgPagOk -->

	
<div class="msgBoxPanel info" id="pMsgPagOk">


		
<s:if test="isWidgetVisible('cpRegistraz','txtMsgPagOK1')" >

	
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
		
<s:if test="isWidgetVisible('cpRegistraz','btPagOK')" >

	



<!-- widget btPagOK -->
<s:submit name="widg_btPagOK" id="widg_btPagOK" method="handleBtPagOK_CLICKED"
	key="cpRegistraz.btPagOK.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpRegistraz','btPagOK')" />

	


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
