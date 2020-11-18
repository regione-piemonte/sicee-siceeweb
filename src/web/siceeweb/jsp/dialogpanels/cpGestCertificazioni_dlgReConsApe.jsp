<%@taglib uri="/struts-tags" prefix="s" %>
<s:include value="../fragments/header.jsp" ></s:include>

<s:form id="dlgReConsApeForm" action="cpGestCertificazioni" namespace="/base/gestattestati" method="post">

	<!-- ####################### PANNELLO CONTENUTI ###################### -->
	<div id="contentPanel">
		<div id="centerWrapper" class="floatWrapper">
			<div id="centerPanel">
			
			<a id="main_content" name="main_content"></a>
				<h3><s:text name="cpGestCertificazioni.dlgReConsApe.label" /></h3>
				<div class="dialogPanel" id="dlgReConsApe">

		
		
<div id="p_pMsgReConsAPE" class="msgBoxPanelBlock"><!-- startFragment:p_pMsgReConsAPE -->

	
<div class="msgBoxPanel info" id="pMsgReConsAPE">


		
<s:if test="isWidgetVisible('cpGestCertificazioni','txtMsgReConsAPE')" >

	
<p>


<!-- widget txtMsgReConsAPE -->
<s:text name="cpGestCertificazioni.txtMsgReConsAPE.statictext.label" />

	
</p>

</s:if>

	


	
</div>

<!-- endFragment:p_pMsgReConsAPE --></div>

	
	<div id="p_pCmdReConsAPE" class="commandPanelBlock"><!-- startFragment:p_pCmdReConsAPE -->
	
	
<div class="commandPanel navigation" id="pCmdReConsAPE">

	
	
		

	
	
	
	<div class="button left">
		
<s:if test="isWidgetVisible('cpGestCertificazioni','btnIndietroCons')" >

	



<!-- widget btnIndietroCons -->
<s:submit name="widg_btnIndietroCons" id="widg_btnIndietroCons" method="handleBtnIndietroCons_CLICKED"
	key="cpGestCertificazioni.btnIndietroCons.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpGestCertificazioni','btnIndietroCons')" />

	


</s:if>

	


	</div>
	
	

	
	
	
	

	
	
	
	<div class="button right">
		
<s:if test="isWidgetVisible('cpGestCertificazioni','btnConfermaCons')" >

	



<!-- widget btnConfermaCons -->
<s:submit name="widg_btnConfermaCons" id="widg_btnConfermaCons" method="handleBtnConfermaCons_CLICKED"
	key="cpGestCertificazioni.btnConfermaCons.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpGestCertificazioni','btnConfermaCons')" />

	


</s:if>

	


	</div>
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_pCmdReConsAPE --></div>

				</div>

			</div>
		</div>
	</div>
	<!-- #################### FINE PANNELLO CONTENUTI #################### -->

</s:form>

<s:include value="../fragments/footer.jsp" ></s:include>
