<%@taglib uri="/struts-tags" prefix="s" %>
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="/customtag" prefix="customtag" %>
<%@taglib uri="/csiuicore" prefix="csiuicore" %>

<s:include value="fragments/header.jsp" ></s:include>



<!-- appmoduleId:base/main -->
<!-- pageId:cpPagamento -->

<s:form id="cpPagamento" action="cpPagamento" namespace="/base/main" method="post">


<%-- NO SCRIPT --%>
		
	
	
		
<!-- ####################### PANNELLO CONTENUTI ###################### -->
<div id="contentPanel">

	<!-- ================ UDLRC Layout UP PANEL ================ -->
	<div id="northPanel">
		<div class="wrapper">
		
	
	<div id="p_pUp" class="formPanelBlock"><!-- startFragment:p_pUp -->

	
	

	
	
			
	
	
<s:include value="/jsp/userpanels/cpPagamento_pUserInfoCustomPagamento.jsp"></s:include>

	



	

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

	
		
			
<s:if test="isWidgetVisible('cpPagamento','menu')" >

	


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
				<h3><s:text name="cpPagamento.pMain.label" /></h3>

					
	
	<div id="p_pCenter" class="formPanelBlock"><!-- startFragment:p_pCenter -->

	
	

	
	
			
	
	<div id="p_pPagamento" class="formPanelBlock"><!-- startFragment:p_pPagamento -->
		
	
<div class="formPanel" id="pPagamento">


	
	

	
	
			
	
	<div id="p_pErrPagamento" class="stdMessagePanelBlock"><!-- startFragment:p_pErrPagamento -->
	
	
<div class="stdMessagePanel" id="pErrPagamento">
	<customtag:stdMessagePanel id="pErrPagamento" errorMessage="true" errorDetails="false" actionMessage="false" />
</div>

	<!-- endFragment:p_pErrPagamento --></div>

			
	
	<div id="p_pDatiPagamento" class="widgetsPanelBlock"><!-- startFragment:p_pDatiPagamento -->
	
	

<div class="widgetsPanel" id="pDatiPagamento">
	
	<customtag:widgetsPanel id="pDatiPagamentoTbl" columns="2" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('cpPagamento','cbGestoreModalitaPagamento')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpPagamento.cbGestoreModalitaPagamento.label')}" labelFor="widg_cbGestoreModalitaPagamento" errorFor="appDataidGestorePagamento" labelId="cbGestoreModalitaPagamentoLbl"
	  >


<!-- widget cbGestoreModalitaPagamento -->
<s:select name="appDataidGestorePagamento" id="widg_cbGestoreModalitaPagamento"
	 
	
		title=""
			
	  headerKey="" headerValue="" 
	  list="appDatagestoriPagamento"
	  disabled="isWidgetDisabled('cpPagamento','cbGestoreModalitaPagamento')"
	  listKey="cod"
	  listValue="nome"
	  
	  />


	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpPagamento','txtImporto')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpPagamento.txtImporto.label')}" labelFor="widg_txtImporto" errorFor="appDatadatiPagamento.importo" labelId="txtImportoLbl"   tdStyleClass="numbers">


<!-- widget txtImporto -->
<s:property value="appDatadatiPagamento.importo" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpPagamento','calDataValuta')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpPagamento.calDataValuta.label')}" labelFor="widg_calDataValuta" errorFor="appDatadatiPagamento.dataValuta" labelId="calDataValutaLbl"
	  >


<!-- widget calDataValuta -->
<s:textfield 
	
	
	name="appDatadatiPagamento.dataValuta" id="widg_calDataValuta"
	disabled="isWidgetDisabled('cpPagamento','calDataValuta')"
	size="10" maxlength="10" 
	cssClass="calendar"
/> <div class="infoCalendar"></div>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpPagamento','txtCausale')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpPagamento.txtCausale.label')}" labelFor="widg_txtCausale" errorFor="appDatadatiPagamento.causale" labelId="txtCausaleLbl"   >


<!-- widget txtCausale -->
<s:property value="appDatadatiPagamento.causale" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpPagamento','rbsTipoPagamento')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpPagamento.rbsTipoPagamento.label')}" labelFor="widg_rbsTipoPagamento" errorFor="appDatadatiPagamento.modPagamento" labelId="rbsTipoPagamentoLbl"
	  >


<!-- widget rbsTipoPagamento -->

	
<div id="appDatadatiPagamento.modPagamento" class="radiobuttons ">







<s:radio
	
	
	id="widg_rbPagaBonifico" name="appDatadatiPagamento.modPagamento"
	list="#{'BB':'Bonifico bancario'}"
	disabled="isWidgetDisabled('cpPagamento','rbsTipoPagamento')"
	cssClass="radio"
	
	/> <label  for="widg_rbPagaBonificoBB"><s:text name="cpPagamento.rbsTipoPagamento.rbPagaBonifico.label" /></label>








<s:radio
	
	
	id="widg_rbPagaCarta" name="appDatadatiPagamento.modPagamento"
	list="#{'BB':'Carta di credito'}"
	disabled="isWidgetDisabled('cpPagamento','rbsTipoPagamento')"
	cssClass="radio"
	
	/> <label  for="widg_rbPagaCartaBB"><s:text name="cpPagamento.rbsTipoPagamento.rbPagaCarta.label" /></label>





	
</div>



	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpPagamento','txtModPagaCC')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpPagamento.txtModPagaCC.label')}" labelFor="widg_txtModPagaCC" errorFor="widg_txtModPagaCC" labelId="txtModPagaCCLbl"   >


<!-- widget txtModPagaCC -->
<s:text name="cpPagamento.txtModPagaCC.statictext.label" />

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpPagamento','txtModPagaBB')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpPagamento.txtModPagaBB.label')}" labelFor="widg_txtModPagaBB" errorFor="widg_txtModPagaBB" labelId="txtModPagaBBLbl"   >


<!-- widget txtModPagaBB -->
<s:text name="cpPagamento.txtModPagaBB.statictext.label" />

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpPagamento','tfCRO')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpPagamento.tfCRO.label')}" labelFor="widg_tfCRO" errorFor="appDatadatiPagamento.cro" labelId="tfCROLbl"
	  >


<!-- widget tfCRO -->
<s:textfield 
	
	
	name="appDatadatiPagamento.cro" id="widg_tfCRO"
maxlength="70"	disabled="isWidgetDisabled('cpPagamento','tfCRO')"
	size="11" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpPagamento','txtEseguitoda')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpPagamento.txtEseguitoda.label')}" labelFor="widg_txtEseguitoda" errorFor="widg_txtEseguitoda" labelId="txtEseguitodaLbl"   tdStyleClass="numbers">


<!-- widget txtEseguitoda -->


	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpPagamento','tfCognomeEsecutore')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpPagamento.tfCognomeEsecutore.label')}" labelFor="widg_tfCognomeEsecutore" errorFor="appDatadatiPagamento.eseguitoDaCognome" labelId="tfCognomeEsecutoreLbl"
	  >


<!-- widget tfCognomeEsecutore -->
<s:textfield 
	
	
	name="appDatadatiPagamento.eseguitoDaCognome" id="widg_tfCognomeEsecutore"
maxlength="50"	disabled="isWidgetDisabled('cpPagamento','tfCognomeEsecutore')"
	size="30" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpPagamento','tfNomeEsecutore')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpPagamento.tfNomeEsecutore.label')}" labelFor="widg_tfNomeEsecutore" errorFor="appDatadatiPagamento.eseguitoDaNome" labelId="tfNomeEsecutoreLbl"
	  >


<!-- widget tfNomeEsecutore -->
<s:textfield 
	
	
	name="appDatadatiPagamento.eseguitoDaNome" id="widg_tfNomeEsecutore"
maxlength="30"	disabled="isWidgetDisabled('cpPagamento','tfNomeEsecutore')"
	size="30" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_pDatiPagamento --></div>

			
	
	<div id="p_pPagamentoNav" class="commandPanelBlock"><!-- startFragment:p_pPagamentoNav -->
	
	
<div class="commandPanel navigation" id="pPagamentoNav">

	
	
		

	
	
	
	<div class="button left">
		
<s:if test="isWidgetVisible('cpPagamento','bPagaAnnulla')" >

	



<!-- widget bPagaAnnulla -->
	<csiuicore:ajaxify id="p_pCenter" 
		widgetType="button"
		 
		requestUri="/siceeweb/base/main/cpPagamento!handleBPagaAnnulla_CLICKED.do" 
		
		pageId="cpPagamento" 
		formName="cpPagamento"
		javascriptDetection="false">
<s:submit name="widg_bPagaAnnulla" id="widg_bPagaAnnulla" method="handleBPagaAnnulla_CLICKED"
	key="cpPagamento.bPagaAnnulla.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpPagamento','bPagaAnnulla')" />

	</csiuicore:ajaxify>

	


</s:if>

	


	</div>
	
	

	
	
	
	

	
	
	
	<div class="button right">
		
<s:if test="isWidgetVisible('cpPagamento','bPagaAvanti')" >

	



<!-- widget bPagaAvanti -->
<s:submit name="widg_bPagaAvanti" id="widg_bPagaAvanti" method="handleBPagaAvanti_CLICKED"
	key="cpPagamento.bPagaAvanti.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpPagamento','bPagaAvanti')" />

	


</s:if>

	


	</div>
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_pPagamentoNav --></div>

	

		
	
</div>

	<!-- endFragment:p_pPagamento --></div>

	

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
