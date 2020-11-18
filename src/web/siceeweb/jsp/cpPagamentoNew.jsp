<%@taglib uri="/struts-tags" prefix="s" %>
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="/customtag" prefix="customtag" %>
<%@taglib uri="/csiuicore" prefix="csiuicore" %>

<s:include value="fragments/header.jsp" ></s:include>



<!-- appmoduleId:base/main -->
<!-- pageId:cpPagamentoNew -->

<s:form id="cpPagamentoNew" action="cpPagamentoNew" namespace="/base/main" method="post">


<%-- NO SCRIPT --%>
		
	
	
		
<!-- ####################### PANNELLO CONTENUTI ###################### -->
<div id="contentPanel">

	<!-- ================ UDLRC Layout UP PANEL ================ -->
	<div id="northPanel">
		<div class="wrapper">
		
	
	<div id="p_pUp" class="formPanelBlock"><!-- startFragment:p_pUp -->

	
	

	
	
			
	
	
<s:include value="/jsp/userpanels/cpPagamentoNew_pUserInfoCustomPagamento.jsp"></s:include>

	



	

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

	
		
			
<s:if test="isWidgetVisible('cpPagamentoNew','menu')" >

	


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
				<h3><s:text name="cpPagamentoNew.pMainPagamentoNew.label" /></h3>

					
	
	<div id="p_pCenter" class="formPanelBlock"><!-- startFragment:p_pCenter -->

	
	

	
	
			
	
	<div id="p_pPagamentoNew" class="formPanelBlock"><!-- startFragment:p_pPagamentoNew -->
		
	
<div class="formPanel" id="pPagamentoNew">


	
	

	
	
			
	
	<div id="p_pErrPagamentoNew" class="stdMessagePanelBlock"><!-- startFragment:p_pErrPagamentoNew -->
	
	
<div class="stdMessagePanel" id="pErrPagamentoNew">
	<customtag:stdMessagePanel id="pErrPagamentoNew" errorMessage="true" errorDetails="false" actionMessage="true" />
</div>

	<!-- endFragment:p_pErrPagamentoNew --></div>

			
	
	<div id="p_pDatiPagamentoNew" class="widgetsPanelBlock"><!-- startFragment:p_pDatiPagamentoNew -->
	
	

<div class="widgetsPanel" id="pDatiPagamentoNew">
	
	<customtag:widgetsPanel id="pDatiPagamentoNewTbl" columns="2" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('cpPagamentoNew','tfImporto')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpPagamentoNew.tfImporto.label')}" labelFor="widg_tfImporto" errorFor="appDatadatiPagamentoNew.importo" labelId="tfImportoLbl"
	  >


<!-- widget tfImporto -->
<s:textfield 
	
	
	name="appDatadatiPagamentoNew.importo" id="widg_tfImporto"
maxlength="6"	disabled="isWidgetDisabled('cpPagamentoNew','tfImporto')"
	size="15" cssClass="numbers"
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_pDatiPagamentoNew --></div>

			
	
	<div id="p_pDatiPagamentoNewTit" class="widgetsPanelBlock"><!-- startFragment:p_pDatiPagamentoNewTit -->
	
	
<h4 class="wpLabel">Dati del versante </h4>
<div class="widgetsPanel" id="pDatiPagamentoNewTit">
	
	<customtag:widgetsPanel id="pDatiPagamentoNewTitTbl" columns="2" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('cpPagamentoNew','rbsTipoPersona')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpPagamentoNew.rbsTipoPersona.label')}" labelFor="widg_rbsTipoPersona" errorFor="appDatadatiPagamentoNew.tipoPersona" labelId="rbsTipoPersonaLbl"
	  >


<!-- widget rbsTipoPersona -->

	
<div id="appDatadatiPagamentoNew.tipoPersona" class="radiobuttons ">







<s:radio
	
	
	id="widg_rbPF" name="appDatadatiPagamentoNew.tipoPersona"
	list="#{'F':'Persona fisica'}"
	disabled="isWidgetDisabled('cpPagamentoNew','rbsTipoPersona')"
	cssClass="radio"
	
	/> <label  for="widg_rbPFF"><s:text name="cpPagamentoNew.rbsTipoPersona.rbPF.label" /></label>








<s:radio
	
	
	id="widg_rbPG" name="appDatadatiPagamentoNew.tipoPersona"
	list="#{'G':'Persona giuridica'}"
	disabled="isWidgetDisabled('cpPagamentoNew','rbsTipoPersona')"
	cssClass="radio"
	
	/> <label  for="widg_rbPGG"><s:text name="cpPagamentoNew.rbsTipoPersona.rbPG.label" /></label>





	
</div>



	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpPagamentoNew','tfCF')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpPagamentoNew.tfCF.label')}" labelFor="widg_tfCF" errorFor="appDatadatiPagamentoNew.codiceFiscale" labelId="tfCFLbl"
	  >


<!-- widget tfCF -->
<s:textfield 
	
	
	name="appDatadatiPagamentoNew.codiceFiscale" id="widg_tfCF"
maxlength="16"	disabled="isWidgetDisabled('cpPagamentoNew','tfCF')"
	size="20" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpPagamentoNew','tfNominativo')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpPagamentoNew.tfNominativo.label')}" labelFor="widg_tfNominativo" errorFor="appDatadatiPagamentoNew.anagraficaVersante" labelId="tfNominativoLbl"
	  >


<!-- widget tfNominativo -->
<s:textfield 
	
	
	name="appDatadatiPagamentoNew.anagraficaVersante" id="widg_tfNominativo"
maxlength="50"	disabled="isWidgetDisabled('cpPagamentoNew','tfNominativo')"
	size="20" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_pDatiPagamentoNewTit --></div>

			
	
	<div id="p_pPagamentoNewFun" class="commandPanelBlock"><!-- startFragment:p_pPagamentoNewFun -->
	
	
<div class="commandPanel functional" id="pPagamentoNewFun">

	
	
		

	
	
	
	

	
	
	
	

	
	
	
	<div class="button right">
		
<s:if test="isWidgetVisible('cpPagamentoNew','bPagaAvantiNew')" >

	



<!-- widget bPagaAvantiNew -->
<s:submit name="widg_bPagaAvantiNew" id="widg_bPagaAvantiNew" method="handleBPagaAvantiNew_CLICKED"
	key="cpPagamentoNew.bPagaAvantiNew.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpPagamentoNew','bPagaAvantiNew')" />

	


</s:if>

	


	</div>
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_pPagamentoNewFun --></div>

			
	
	<div id="p_pPagamentoNewNav" class="commandPanelBlock"><!-- startFragment:p_pPagamentoNewNav -->
	
	
<div class="commandPanel navigation" id="pPagamentoNewNav">

	
	
		

	
	
	
	<div class="button left">
		
<s:if test="isWidgetVisible('cpPagamentoNew','bPagaAnnullaNew')" >

	



<!-- widget bPagaAnnullaNew -->
<s:submit name="widg_bPagaAnnullaNew" id="widg_bPagaAnnullaNew" method="handleBPagaAnnullaNew_CLICKED"
	key="cpPagamentoNew.bPagaAnnullaNew.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpPagamentoNew','bPagaAnnullaNew')" />

	


</s:if>

	


	</div>
	
	

	
	
	
	

	
	
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_pPagamentoNewNav --></div>

	

		
	
</div>

	<!-- endFragment:p_pPagamentoNew --></div>

	

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
