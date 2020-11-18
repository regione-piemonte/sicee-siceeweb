<%@taglib uri="/struts-tags" prefix="s" %>
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="/customtag" prefix="customtag" %>
<%@taglib uri="/csiuicore" prefix="csiuicore" %>

<s:include value="fragments/header.jsp" ></s:include>



<!-- appmoduleId:base/gestcertificatore -->
<!-- pageId:cpVerificaMail -->

<s:form id="cpVerificaMail" action="cpVerificaMail" namespace="/base/gestcertificatore" method="post">


<%-- NO SCRIPT --%>
		
	
	
		
<!-- ####################### PANNELLO CONTENUTI ###################### -->
<div id="contentPanel">

	<!-- ================ UDLRC Layout UP PANEL ================ -->
	<div id="northPanel">
		<div class="wrapper">
		
	
	<div id="p_pUp" class="formPanelBlock"><!-- startFragment:p_pUp -->

	
	

	
	
			
	
	
<s:include value="/jsp/userpanels/cpVerificaMail_pUserInfoCustomRegistraz.jsp"></s:include>

	



	

	<!-- endFragment:p_pUp --></div>

		</div>
	</div>
	<!-- ================ FINE UDLRC Layout UP PANEL ================ -->


	<!-- ================ UDLRC Layout WEST-CENTER-EAST WRAPPER ================ -->
	<div id="centerWrapper" class="floatWrapper">


		<!-- ***** UDLRC Layout CENTER PANEL ***** -->
		<div id="centerPanel">
			
			<a id="main_content" name="main_content"></a>
			<div class="wrapper">
				<!-- titolo pannello PRIMO livello -->
				<h3><s:text name="cpVerificaMail.pVerificaMail.label" /></h3>

					
	
	<div id="p_pCenter" class="formPanelBlock"><!-- startFragment:p_pCenter -->

	
	

	
	
			
	
	<div id="p_pErrMail" class="stdMessagePanelBlock"><!-- startFragment:p_pErrMail -->
	
	
<div class="stdMessagePanel" id="pErrMail">
	<customtag:stdMessagePanel id="pErrMail" errorMessage="true" errorDetails="false" actionMessage="true" />
</div>

	<!-- endFragment:p_pErrMail --></div>

			
	
	<div id="p_pMail" class="widgetsPanelBlock"><!-- startFragment:p_pMail -->
	
	

<div class="widgetsPanel" id="pMail">
	
	<customtag:widgetsPanel id="pMailTbl" columns="2" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('cpVerificaMail','tfEmail')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpVerificaMail.tfEmail.label')}" labelFor="widg_tfEmail" errorFor="appDatamailVerifica" labelId="tfEmailLbl"
	  >


<!-- widget tfEmail -->
<s:textfield 
	
	
	name="appDatamailVerifica" id="widg_tfEmail"
maxlength="70"	disabled="isWidgetDisabled('cpVerificaMail','tfEmail')"
	size="30" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_pMail --></div>

			
	
	<div id="p_cpMail" class="commandPanelBlock"><!-- startFragment:p_cpMail -->
	
	
<div class="commandPanel functional" id="cpMail">

	
	
		

	
	
	
	

	
	
	
	

	
	
	
	<div class="button right">
		
<s:if test="isWidgetVisible('cpVerificaMail','bVerificaMail')" >

	



<!-- widget bVerificaMail -->
<s:submit name="widg_bVerificaMail" id="widg_bVerificaMail" method="handleBVerificaMail_CLICKED"
	key="cpVerificaMail.bVerificaMail.label" cssClass="buttonWidget showReport"
	disabled="isWidgetDisabled('cpVerificaMail','bVerificaMail')" />

	


</s:if>

	


	</div>
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_cpMail --></div>

	

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
