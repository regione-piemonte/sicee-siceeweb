<%@taglib uri="/struts-tags" prefix="s" %>
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="/customtag" prefix="customtag" %>
<%@taglib uri="/csiuicore" prefix="csiuicore" %>

<s:include value="fragments/header.jsp" ></s:include>



<!-- appmoduleId:base/main -->
<!-- pageId:cpNonAbilitato -->

<s:form id="cpNonAbilitato" action="cpNonAbilitato" namespace="/base/main" method="post">


<%-- NO SCRIPT --%>
		
	
	
		
<!-- ####################### PANNELLO CONTENUTI ###################### -->
<div id="contentPanel">

	<!-- ================ UDLRC Layout UP PANEL ================ -->
	<div id="northPanel">
		<div class="wrapper">
		
	
	<div id="p_pUp" class="formPanelBlock"><!-- startFragment:p_pUp -->

	
	

	
	
			
	
	
<s:include value="/jsp/userpanels/cpNonAbilitato_pUserInfoCustomHome.jsp"></s:include>

	



	

	<!-- endFragment:p_pUp --></div>

		</div>
	</div>
	<!-- ================ FINE UDLRC Layout UP PANEL ================ -->


	<!-- ================ UDLRC Layout WEST-CENTER-EAST WRAPPER ================ -->
	<div id="westCenterWrapper" class="floatWrapper">
		<!-- ***** UDLRC Layout LEFT PANEL ***** -->
		<div id="westPanel">
			<div class="wrapper">
			
	
	<div id="p_pLeft" class="formPanelBlock"><!-- startFragment:p_pLeft -->

	
	

	
	
			
	
	<div id="p_pMenu" class="menuPanelBlock"><!-- startFragment:p_pMenu -->
	
	
<div class="menuPanel vertical" id="pMenu">

	
	
	
</div>

	<!-- endFragment:p_pMenu --></div>

	

	<!-- endFragment:p_pLeft --></div>

			</div>
		</div>
		<!-- ***** FINE UDLRC Layout LEFT PANEL ***** -->


		<!-- ***** UDLRC Layout CENTER PANEL ***** -->
		<div id="centerPanel">
			
			<a id="main_content" name="main_content"></a>
			<div class="wrapper">
				<!-- titolo pannello PRIMO livello -->
				<h3><s:text name="cpNonAbilitato.pMain.label" /></h3>

					
	
	<div id="p_pCenter" class="formPanelBlock"><!-- startFragment:p_pCenter -->

	
	

	
	
			
	
	<div id="p_pErrNonAbilitato" class="stdMessagePanelBlock"><!-- startFragment:p_pErrNonAbilitato -->
	
	
<div class="stdMessagePanel" id="pErrNonAbilitato">
	<customtag:stdMessagePanel id="pErrNonAbilitato" errorMessage="false" errorDetails="false" actionMessage="true" />
</div>

	<!-- endFragment:p_pErrNonAbilitato --></div>

			
	
<div id="p_msgKoAutenticazione" class="msgBoxPanelBlock"><!-- startFragment:p_msgKoAutenticazione -->

		
<s:if test="isWidgetVisible('cpNonAbilitato','txtKoAutenticazione')" >

	
<p>


<!-- widget txtKoAutenticazione -->
<s:text name="cpNonAbilitato.txtKoAutenticazione.statictext.label" />

	
</p>

</s:if>

	

<!-- endFragment:p_msgKoAutenticazione --></div>

			
	
	<div id="p_cmdKoAutenticazione" class="commandPanelBlock"><!-- startFragment:p_cmdKoAutenticazione -->
	
	
<div class="commandPanel navigation" id="cmdKoAutenticazione">

	
	
		

	
	
	
	

	
	
	
	

	
	
	
	<div class="button right">
		
<s:if test="isWidgetVisible('cpNonAbilitato','bKoAutenticazione')" >

	



<!-- widget bKoAutenticazione -->
	<csiuicore:ajaxify id="p_pCenter" 
		widgetType="button"
		 
		requestUri="/siceeweb/base/main/cpNonAbilitato!handleBKoAutenticazione_CLICKED.do" 
		
		pageId="cpNonAbilitato" 
		formName="cpNonAbilitato"
		javascriptDetection="false">
<s:submit name="widg_bKoAutenticazione" id="widg_bKoAutenticazione" method="handleBKoAutenticazione_CLICKED"
	key="cpNonAbilitato.bKoAutenticazione.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpNonAbilitato','bKoAutenticazione')" />

	</csiuicore:ajaxify>

	


</s:if>

	


	</div>
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_cmdKoAutenticazione --></div>

	

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
