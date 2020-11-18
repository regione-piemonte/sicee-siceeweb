<%@taglib uri="/struts-tags" prefix="s" %>
<s:include value="../fragments/header.jsp" ></s:include>

<s:form id="dlgMsgConfermaMailForm" action="cpGestioneDialogMail" namespace="/base/gestcertificatore" method="post">

	<!-- ####################### PANNELLO CONTENUTI ###################### -->
	<div id="contentPanel">
		<div id="centerWrapper" class="floatWrapper">
			<div id="centerPanel">
			
			<a id="main_content" name="main_content"></a>
				<h3><s:text name="cpGestioneDialogMail.dlgMsgConfermaMail.label" /></h3>
				<div class="dialogPanel" id="dlgMsgConfermaMail">

		
		
<div id="p_pMsgPagConf" class="msgBoxPanelBlock"><!-- startFragment:p_pMsgPagConf -->

	
<div class="msgBoxPanel info" id="pMsgPagConf">


		
<s:if test="isWidgetVisible('cpGestioneDialogMail','txtMsgConfMail')" >

	
<p>


<!-- widget txtMsgConfMail -->
<s:text name="cpGestioneDialogMail.txtMsgConfMail.statictext.label" />

	
</p>

</s:if>

	


	
</div>

<!-- endFragment:p_pMsgPagConf --></div>

	
	<div id="p_pCmdPagConf" class="commandPanelBlock"><!-- startFragment:p_pCmdPagConf -->
	
	
<div class="commandPanel navigation" id="pCmdPagConf">

	
	
		

	
	
	
	

	
	
	
	

	
	
	
	<div class="button right">
		
<s:if test="isWidgetVisible('cpGestioneDialogMail','btPagConf')" >

	



<!-- widget btPagConf -->
<s:submit name="widg_btPagConf" id="widg_btPagConf" method="handleBtPagConf_CLICKED"
	key="cpGestioneDialogMail.btPagConf.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpGestioneDialogMail','btPagConf')" />

	


</s:if>

	


	</div>
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_pCmdPagConf --></div>

				</div>

			</div>
		</div>
	</div>
	<!-- #################### FINE PANNELLO CONTENUTI #################### -->

</s:form>

<s:include value="../fragments/footer.jsp" ></s:include>
