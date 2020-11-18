<%@taglib uri="/struts-tags" prefix="s" %>
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="/customtag" prefix="customtag" %>
<%@taglib uri="/csiuicore" prefix="csiuicore" %>

<s:include value="fragments/header.jsp" ></s:include>



<!-- appmoduleId:base/main -->
<!-- pageId:cpPagamentoDettNew -->

<s:form id="cpPagamentoDettNew" action="cpPagamentoDettNew" namespace="/base/main" method="post">


<%-- NO SCRIPT --%>
		
	
	
		
<!-- ####################### PANNELLO CONTENUTI ###################### -->
<div id="contentPanel">

	<!-- ================ UDLRC Layout UP PANEL ================ -->
	<div id="northPanel">
		<div class="wrapper">
		
	
	<div id="p_pUp" class="formPanelBlock"><!-- startFragment:p_pUp -->

	
	

	
	
			
	
	
<s:include value="/jsp/userpanels/cpPagamentoDettNew_pUserInfoCustomPagamento.jsp"></s:include>

	



	

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

	
		
			
<s:if test="isWidgetVisible('cpPagamentoDettNew','menu')" >

	


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
				<h3><s:text name="cpPagamentoDettNew.pMainPagamentoDetNew.label" /></h3>

					
	
	<div id="p_pCenter" class="formPanelBlock"><!-- startFragment:p_pCenter -->

	
	

	
	
			
	
	<div id="p_pPagamentoDettNew" class="formPanelBlock"><!-- startFragment:p_pPagamentoDettNew -->
		
	
<div class="formPanel" id="pPagamentoDettNew">


	
	

	
	
			
	
	<div id="p_pErrPagamentoDettNew" class="stdMessagePanelBlock"><!-- startFragment:p_pErrPagamentoDettNew -->
	
	
<div class="stdMessagePanel" id="pErrPagamentoDettNew">
	<customtag:stdMessagePanel id="pErrPagamentoDettNew" errorMessage="true" errorDetails="false" actionMessage="false" />
</div>

	<!-- endFragment:p_pErrPagamentoDettNew --></div>

			
	
	<div id="p_pDatiPagamentoDettNew" class="widgetsPanelBlock"><!-- startFragment:p_pDatiPagamentoDettNew -->
	
	

<div class="widgetsPanel" id="pDatiPagamentoDettNew">
	
	<customtag:widgetsPanel id="pDatiPagamentoDettNewTbl" columns="2" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('cpPagamentoDettNew','ptIdentTrans')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpPagamentoDettNew.ptIdentTrans.label')}" labelFor="widg_ptIdentTrans" errorFor="appDatadatiPagamentoNew.idTransMdp" labelId="ptIdentTransLbl"   >


<!-- widget ptIdentTrans -->
<s:property value="appDatadatiPagamentoNew.idTransMdp" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpPagamentoDettNew','ptImporto')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpPagamentoDettNew.ptImporto.label')}" labelFor="widg_ptImporto" errorFor="appDatadatiPagamentoNew.importo" labelId="ptImportoLbl"   tdStyleClass="numbers">


<!-- widget ptImporto -->
<s:property value="appDatadatiPagamentoNew.importo" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_pDatiPagamentoDettNew --></div>

			
	
	<div id="p_pDatiPagamentoDettNewTit" class="widgetsPanelBlock"><!-- startFragment:p_pDatiPagamentoDettNewTit -->
	
	
<h4 class="wpLabel">Dati del versante </h4>
<div class="widgetsPanel" id="pDatiPagamentoDettNewTit">
	
	<customtag:widgetsPanel id="pDatiPagamentoDettNewTitTbl" columns="2" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('cpPagamentoDettNew','ptTipoPersona')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpPagamentoDettNew.ptTipoPersona.label')}" labelFor="widg_ptTipoPersona" errorFor="appDatadatiPagamentoNew.tipoPersonaDesc" labelId="ptTipoPersonaLbl"   >


<!-- widget ptTipoPersona -->
<s:property value="appDatadatiPagamentoNew.tipoPersonaDesc" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpPagamentoDettNew','ptCF')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpPagamentoDettNew.ptCF.label')}" labelFor="widg_ptCF" errorFor="appDatadatiPagamentoNew.codiceFiscale" labelId="ptCFLbl"   >


<!-- widget ptCF -->
<s:property value="appDatadatiPagamentoNew.codiceFiscale" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpPagamentoDettNew','ptNominativo')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpPagamentoDettNew.ptNominativo.label')}" labelFor="widg_ptNominativo" errorFor="appDatadatiPagamentoNew.anagraficaVersante" labelId="ptNominativoLbl"   >


<!-- widget ptNominativo -->
<s:property value="appDatadatiPagamentoNew.anagraficaVersante" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_pDatiPagamentoDettNewTit --></div>

			
	
	<div id="p_pPagamentoDettNewFun" class="commandPanelBlock"><!-- startFragment:p_pPagamentoDettNewFun -->
	
	
<div class="commandPanel functional" id="pPagamentoDettNewFun">

	
	
		

	
	
	
	

	
	
	
	

	
	
	
	<div class="button right">
		
<s:if test="isWidgetVisible('cpPagamentoDettNew','bRicevutaNew')" >

	



<!-- widget bRicevutaNew -->
<s:submit name="widg_bRicevutaNew" id="widg_bRicevutaNew" method="handleBRicevutaNew_CLICKED"
	key="cpPagamentoDettNew.bRicevutaNew.label" cssClass="buttonWidget showReport"
	disabled="isWidgetDisabled('cpPagamentoDettNew','bRicevutaNew')" />

	


</s:if>

	


	</div>
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_pPagamentoDettNewFun --></div>

			
	
	<div id="p_pPagamentoDettNewNav" class="commandPanelBlock"><!-- startFragment:p_pPagamentoDettNewNav -->
	
	
<div class="commandPanel navigation" id="pPagamentoDettNewNav">

	
	
		

	
	
	
	<div class="button left">
		
<s:if test="isWidgetVisible('cpPagamentoDettNew','bDettIndietroNew')" >

	



<!-- widget bDettIndietroNew -->
<s:submit name="widg_bDettIndietroNew" id="widg_bDettIndietroNew" method="handleBDettIndietroNew_CLICKED"
	key="cpPagamentoDettNew.bDettIndietroNew.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpPagamentoDettNew','bDettIndietroNew')" />

	


</s:if>

	


	</div>
	
	

	
	
	
	

	
	
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_pPagamentoDettNewNav --></div>

	

		
	
</div>

	<!-- endFragment:p_pPagamentoDettNew --></div>

	

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
