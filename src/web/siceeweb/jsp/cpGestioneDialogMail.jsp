<%@taglib uri="/struts-tags" prefix="s" %>
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="/customtag" prefix="customtag" %>
<%@taglib uri="/csiuicore" prefix="csiuicore" %>

<s:include value="fragments/header.jsp" ></s:include>



<!-- appmoduleId:base/gestcertificatore -->
<!-- pageId:cpGestioneDialogMail -->

<s:form id="cpGestioneDialogMail" action="cpGestioneDialogMail" namespace="/base/gestcertificatore" method="post">


<%-- NO SCRIPT --%>
		
	
	
		
<!-- ####################### PANNELLO CONTENUTI ###################### -->
<div id="contentPanel">



	<!-- ================ UDLRC Layout WEST-CENTER-EAST WRAPPER ================ -->
	<div id="centerWrapper" class="floatWrapper">


		<!-- ***** UDLRC Layout CENTER PANEL ***** -->
		<div id="centerPanel">
			
			<a id="main_content" name="main_content"></a>
			<div class="wrapper">

					
	
	<div id="p_pCenter" class="formPanelBlock"><!-- startFragment:p_pCenter -->

	
	

	
	
			
	
	<div id="p_fpGestioneDialogMail" class="formPanelBlock"><!-- startFragment:p_fpGestioneDialogMail -->
		
	
<div class="formPanel" id="fpGestioneDialogMail">


	
	

	
	
			
	
	<div id="p_mpGestioneDialogMail" class="stdMessagePanelBlock"><!-- startFragment:p_mpGestioneDialogMail -->
	
	
<div class="stdMessagePanel" id="mpGestioneDialogMail">
	<customtag:stdMessagePanel id="mpGestioneDialogMail" errorMessage="true" errorDetails="false" actionMessage="true" />
</div>

	<!-- endFragment:p_mpGestioneDialogMail --></div>

			
	
	<div id="p_wpGestioneDialogMail" class="widgetsPanelBlock"><!-- startFragment:p_wpGestioneDialogMail -->
	
	

<div class="widgetsPanel" id="wpGestioneDialogMail">
	
	<customtag:widgetsPanel id="wpGestioneDialogMailTbl" columns="2" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('cpGestioneDialogMail','hvEsitoMailOK')" >

	
<div class="hidden">


<!-- widget hvEsitoMailOK -->
<s:hidden name="widg_hvEsitoMailOK" id="widg_hvEsitoMailOK" />

	
</div>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestioneDialogMail','hvEsitoMailKO')" >

	
<div class="hidden">


<!-- widget hvEsitoMailKO -->
<s:hidden name="widg_hvEsitoMailKO" id="widg_hvEsitoMailKO" />

	
</div>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestioneDialogMail','hvEsitoMailMSG')" >

	
<div class="hidden">


<!-- widget hvEsitoMailMSG -->
<s:hidden name="widg_hvEsitoMailMSG" id="widg_hvEsitoMailMSG" />

	
</div>

</s:if>

	



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_wpGestioneDialogMail --></div>

	

		
	
</div>

	<!-- endFragment:p_fpGestioneDialogMail --></div>

	

	<!-- endFragment:p_pCenter --></div>

			</div>
		</div>
		<!-- ***** FINE UDLRC Layout CENTER PANEL ***** -->



	</div>
	<!-- ================ FINE UDLRC Layout WEST-CENTER-EAST WRAPPER ================ -->



</div>
<!-- #################### FINE PANNELLO CONTENUTI #################### -->




</s:form>


	<s:include value="fragments/footer.jsp" ></s:include>
