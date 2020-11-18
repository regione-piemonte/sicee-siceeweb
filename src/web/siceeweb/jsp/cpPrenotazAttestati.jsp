<%@taglib uri="/struts-tags" prefix="s" %>
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="/customtag" prefix="customtag" %>
<%@taglib uri="/csiuicore" prefix="csiuicore" %>

<s:include value="fragments/header.jsp" ></s:include>



<!-- appmoduleId:base/gestattestati -->
<!-- pageId:cpPrenotazAttestati -->

<s:form id="cpPrenotazAttestati" action="cpPrenotazAttestati" namespace="/base/gestattestati" method="post">


<%-- NO SCRIPT --%>
		
	
	
		
<!-- ####################### PANNELLO CONTENUTI ###################### -->
<div id="contentPanel">

	<!-- ================ UDLRC Layout UP PANEL ================ -->
	<div id="northPanel">
		<div class="wrapper">
		
	
	<div id="p_pUp" class="formPanelBlock"><!-- startFragment:p_pUp -->

	
	

	
	
			
	
	
<s:include value="/jsp/userpanels/cpPrenotazAttestati_pUserInfoCustomPrenACE.jsp"></s:include>

	



	

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

	
		
			
<s:if test="isWidgetVisible('cpPrenotazAttestati','menu')" >

	


	<s:include value="fragments/menu.jsp"></s:include>

	

</s:if>

	


		
	
	
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
				<h3><s:text name="cpPrenotazAttestati.pMain.label" /></h3>

					
	
	<div id="p_pCenter" class="formPanelBlock"><!-- startFragment:p_pCenter -->

	
	

	
	
			
	
	<div id="p_pPrenotazioneACE" class="formPanelBlock"><!-- startFragment:p_pPrenotazioneACE -->
		
	
<div class="formPanel" id="pPrenotazioneACE">


	
	

	
	
			
	
	<div id="p_pErrori" class="stdMessagePanelBlock"><!-- startFragment:p_pErrori -->
	
	
<div class="stdMessagePanel" id="pErrori">
	<customtag:stdMessagePanel id="pErrori" errorMessage="true" errorDetails="false" actionMessage="false" />
</div>

	<!-- endFragment:p_pErrori --></div>

			
	
	<div id="p_pDatiPrenotazione" class="widgetsPanelBlock"><!-- startFragment:p_pDatiPrenotazione -->
	
	

<div class="widgetsPanel" id="pDatiPrenotazione">
	
	<customtag:widgetsPanel id="pDatiPrenotazioneTbl" columns="2" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('cpPrenotazAttestati','txtValoreCreditoFinale')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpPrenotazAttestati.txtValoreCreditoFinale.label')}" labelFor="widg_txtValoreCreditoFinale" errorFor="appDatavaloreCreditoFinale" labelId="txtValoreCreditoFinaleLbl"   >


<!-- widget txtValoreCreditoFinale -->
<s:property value="appDatavaloreCreditoFinale" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpPrenotazAttestati','txtSpiegazione')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="" labelFor="widg_txtSpiegazione" errorFor="widg_txtSpiegazione" labelId="txtSpiegazioneLbl"   >


<!-- widget txtSpiegazione -->
<s:text name="cpPrenotazAttestati.txtSpiegazione.statictext.label" />

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpPrenotazAttestati','rbsLotti')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpPrenotazAttestati.rbsLotti.label')}" labelFor="widg_rbsLotti" errorFor="appDatanumACEDesiderati" labelId="rbsLottiLbl"
	  >


<!-- widget rbsLotti -->

	
<div id="appDatanumACEDesiderati" class="radiobuttons ">







<s:radio
	
	
	id="widg_rbN1" name="appDatanumACEDesiderati"
	list="#{'1':'1'}"
	disabled="isWidgetDisabled('cpPrenotazAttestati','rbsLotti')"
	cssClass="radio"
	
	/> <label  for="widg_rbN11"><s:text name="cpPrenotazAttestati.rbsLotti.rbN1.label" /></label>








<s:radio
	
	
	id="widg_rbN5" name="appDatanumACEDesiderati"
	list="#{'5':'5'}"
	disabled="isWidgetDisabled('cpPrenotazAttestati','rbsLotti')"
	cssClass="radio"
	
	/> <label  for="widg_rbN55"><s:text name="cpPrenotazAttestati.rbsLotti.rbN5.label" /></label>








<s:radio
	
	
	id="widg_rbN10" name="appDatanumACEDesiderati"
	list="#{'10':'10'}"
	disabled="isWidgetDisabled('cpPrenotazAttestati','rbsLotti')"
	cssClass="radio"
	
	/> <label  for="widg_rbN1010"><s:text name="cpPrenotazAttestati.rbsLotti.rbN10.label" /></label>








<s:radio
	
	
	id="widg_rbN20" name="appDatanumACEDesiderati"
	list="#{'20':'20'}"
	disabled="isWidgetDisabled('cpPrenotazAttestati','rbsLotti')"
	cssClass="radio"
	
	/> <label  for="widg_rbN2020"><s:text name="cpPrenotazAttestati.rbsLotti.rbN20.label" /></label>








<s:radio
	
	
	id="widg_rbN50" name="appDatanumACEDesiderati"
	list="#{'50':'50'}"
	disabled="isWidgetDisabled('cpPrenotazAttestati','rbsLotti')"
	cssClass="radio"
	
	/> <label  for="widg_rbN5050"><s:text name="cpPrenotazAttestati.rbsLotti.rbN50.label" /></label>








<s:radio
	
	
	id="widg_rbN100" name="appDatanumACEDesiderati"
	list="#{'100':'100'}"
	disabled="isWidgetDisabled('cpPrenotazAttestati','rbsLotti')"
	cssClass="radio"
	
	/> <label  for="widg_rbN100100"><s:text name="cpPrenotazAttestati.rbsLotti.rbN100.label" /></label>





	
</div>



	
</customtag:widgetsPanelColumn>

</s:if>

	



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_pDatiPrenotazione --></div>

			
	
	<div id="p_pPagamentoNav" class="commandPanelBlock"><!-- startFragment:p_pPagamentoNav -->
	
	
<div class="commandPanel navigation" id="pPagamentoNav">

	
	
		

	
	
	
	

	
	
	
	

	
	
	
	<div class="button right">
		
<s:if test="isWidgetVisible('cpPrenotazAttestati','bPagaAvanti')" >

	



<!-- widget bPagaAvanti -->
	<csiuicore:ajaxify id="p_pCenter" 
		widgetType="button"
		 
		requestUri="/siceeweb/base/gestattestati/cpPrenotazAttestati!handleBPagaAvanti_CLICKED.do" 
		
		pageId="cpPrenotazAttestati" 
		formName="cpPrenotazAttestati"
		javascriptDetection="false">
<s:submit name="widg_bPagaAvanti" id="widg_bPagaAvanti" method="handleBPagaAvanti_CLICKED"
	key="cpPrenotazAttestati.bPagaAvanti.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpPrenotazAttestati','bPagaAvanti')" />

	</csiuicore:ajaxify>

	


</s:if>

	


	</div>
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_pPagamentoNav --></div>

	

		
	
</div>

	<!-- endFragment:p_pPrenotazioneACE --></div>

	

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
