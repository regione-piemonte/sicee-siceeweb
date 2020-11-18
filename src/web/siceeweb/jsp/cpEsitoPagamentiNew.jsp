<%@taglib uri="/struts-tags" prefix="s" %>
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="/customtag" prefix="customtag" %>
<%@taglib uri="/csiuicore" prefix="csiuicore" %>

<s:include value="fragments/header.jsp" ></s:include>



<!-- appmoduleId:base/main -->
<!-- pageId:cpEsitoPagamentiNew -->

<s:form id="cpEsitoPagamentiNew" action="cpEsitoPagamentiNew" namespace="/base/main" method="post">


<%-- NO SCRIPT --%>
		
	
	
		
<!-- ####################### PANNELLO CONTENUTI ###################### -->
<div id="contentPanel">

	<!-- ================ UDLRC Layout UP PANEL ================ -->
	<div id="northPanel">
		<div class="wrapper">
		
	
	<div id="p_pUp" class="formPanelBlock"><!-- startFragment:p_pUp -->

	
	

	
	
			
	
	<div id="p_pUserInfo" class="userInfoPanelBlock"><!-- startFragment:p_pUserInfo -->
	
	
<div class="userInfoPanel" id="pUserInfo">
	<div class="userData">
		<span class="user">Utente: <span class="value"><s:property value="appDatacurrentUser.nome" /> <s:property value="appDatacurrentUser.cognome" /></span></span>
		<span class="organization">Ente: <span class="value"><s:property value="appDatacurrentUser.ente" /></span></span>
		<span class="role">Ruolo: <span class="value"><s:property value="appDatacurrentUser.ruolo" /></span></span>
	</div>
	<div class="userInfoActions">
		<!-- uscita dal servizio e/o cambio ruolo -->
		<s:url id="logoutUrl" action="Logout" namespace="/secure" method="confirmLogout" />
		<s:a href="%{logoutUrl}" title="chiudi: questo link fa uscire dal servizio">esci</s:a>
	</div>
</div>

	<!-- endFragment:p_pUserInfo --></div>

	

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

	
		
			
<s:if test="isWidgetVisible('cpEsitoPagamentiNew','menu')" >

	


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
				<h3><s:text name="cpEsitoPagamentiNew.pMain.label" /></h3>

					
	
	<div id="p_pCenter" class="formPanelBlock"><!-- startFragment:p_pCenter -->

	
	

	
	
			
	
	<div id="p_pPagamento" class="formPanelBlock"><!-- startFragment:p_pPagamento -->
		
	
<h4 class="fpLabel"><s:text name="cpEsitoPagamentiNew.pPagamento.label" /></h4>
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
	

	
	
<s:if test="isWidgetVisible('cpEsitoPagamentiNew','hvPagamentoWISPOK')" >

	
<div class="hidden">


<!-- widget hvPagamentoWISPOK -->
<s:hidden name="widg_hvPagamentoWISPOK" id="widg_hvPagamentoWISPOK" />

	
</div>

</s:if>

	


	
<s:if test="isWidgetVisible('cpEsitoPagamentiNew','hvPagamentoWISPKO')" >

	
<div class="hidden">


<!-- widget hvPagamentoWISPKO -->
<s:hidden name="widg_hvPagamentoWISPKO" id="widg_hvPagamentoWISPKO" />

	
</div>

</s:if>

	


	
<s:if test="isWidgetVisible('cpEsitoPagamentiNew','hvPagamentoOK')" >

	
<div class="hidden">


<!-- widget hvPagamentoOK -->
<s:hidden name="widg_hvPagamentoOK" id="widg_hvPagamentoOK" />

	
</div>

</s:if>

	


	
<s:if test="isWidgetVisible('cpEsitoPagamentiNew','hvPagamentoKO')" >

	
<div class="hidden">


<!-- widget hvPagamentoKO -->
<s:hidden name="widg_hvPagamentoKO" id="widg_hvPagamentoKO" />

	
</div>

</s:if>

	


	
<s:if test="isWidgetVisible('cpEsitoPagamentiNew','hvPagamentoBACK')" >

	
<div class="hidden">


<!-- widget hvPagamentoBACK -->
<s:hidden name="widg_hvPagamentoBACK" id="widg_hvPagamentoBACK" />

	
</div>

</s:if>

	



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_pDatiPagamento --></div>

	

		
	
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
