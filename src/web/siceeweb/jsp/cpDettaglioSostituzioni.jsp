<%@taglib uri="/struts-tags" prefix="s" %>
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="/customtag" prefix="customtag" %>
<%@taglib uri="/csiuicore" prefix="csiuicore" %><%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<fmt:setBundle basename="/it/csi/sicee/siceeweb/presentation/siceeweb/action/gestattestati/CpDettaglioSostituzioniAction" />


<s:include value="fragments/header.jsp" ></s:include>



<!-- appmoduleId:base/gestattestati -->
<!-- pageId:cpDettaglioSostituzioni -->

<s:form id="cpDettaglioSostituzioni" action="cpDettaglioSostituzioni" namespace="/base/gestattestati" method="post">


<%-- NO SCRIPT --%>
		
	
	
		
<!-- ####################### PANNELLO CONTENUTI ###################### -->
<div id="contentPanel">

	<!-- ================ UDLRC Layout UP PANEL ================ -->
	<div id="northPanel">
		<div class="wrapper">
		
	
	<div id="p_pUp" class="formPanelBlock"><!-- startFragment:p_pUp -->

	
	

	
	
			
	
	
<s:include value="/jsp/userpanels/cpDettaglioSostituzioni_pUserInfoCustom.jsp"></s:include>

	



	

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

	
		
			
<s:if test="isWidgetVisible('cpDettaglioSostituzioni','menu')" >

	


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
				<h3><s:text name="cpDettaglioSostituzioni.pMain.label" /></h3>

					
	
	<div id="p_pCenter" class="formPanelBlock"><!-- startFragment:p_pCenter -->

	
	

	
	
			
	
	<div id="p_pErrDettaglioSostituzione" class="stdMessagePanelBlock"><!-- startFragment:p_pErrDettaglioSostituzione -->
	
	
<div class="stdMessagePanel" id="pErrDettaglioSostituzione">
	<customtag:stdMessagePanel id="pErrDettaglioSostituzione" errorMessage="true" errorDetails="false" actionMessage="true" />
</div>

	<!-- endFragment:p_pErrDettaglioSostituzione --></div>

			
	
	<div id="p_wpAceSostituito" class="widgetsPanelBlock"><!-- startFragment:p_wpAceSostituito -->
	
	

<div class="widgetsPanel" id="wpAceSostituito">
	
	<customtag:widgetsPanel id="wpAceSostituitoTbl" columns="2" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('cpDettaglioSostituzioni','ptNCertificato')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpDettaglioSostituzioni.ptNCertificato.label')}" labelFor="widg_ptNCertificato" errorFor="appDatacodAttestatoSelezionato" labelId="ptNCertificatoLbl"   >


<!-- widget ptNCertificato -->
<s:property value="appDatacodAttestatoSelezionato" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_wpAceSostituito --></div>

			
	
	<div id="p_pRisultatoVediSostituzioni" class="widgetsPanelBlock"><!-- startFragment:p_pRisultatoVediSostituzioni -->
	
	

<div class="widgetsPanel" id="pRisultatoVediSostituzioni">
	

	
	
<s:if test="isWidgetVisible('cpDettaglioSostituzioni','tblVediSostituzioni')" >

	
<div class="tableWidget">


<!-- widget tblVediSostituzioni -->
<s:set name="cpDettaglioSostituzioni_tblVediSostituzioni_clearStatus" value="isTableClearStatus('cpDettaglioSostituzioni_tblVediSostituzioni')" />
<s:url id="cpDettaglioSostituzioniViewUrl"						   
					   action="cpDettaglioSostituzioni"
					   namespace="/base/gestattestati"/>
<display:table name="appDatacertificatiSostituiti"  				
			   excludedParams="*"			   export="false"
               id="widg_tblVediSostituzioni"
               pagesize="0"
               keepStatus="true"
               requestURI="${cpDettaglioSostituzioniViewUrl}"  
               clearStatus="${cpDettaglioSostituzioni_tblVediSostituzioni_clearStatus}"
               uid="row_tblVediSostituzioni"
               summary="" 
               class="dataTable">
	
		<display:column property="codice" titleKey="cpDettaglioSostituzioni.tblVediSostituzioni.codice.label" 
			sortable="true" headerClass="sortable"
			    media="html"
			
 >
			
		</display:column>
		<display:column property="stato" titleKey="cpDettaglioSostituzioni.tblVediSostituzioni.stato.label" 
			sortable="true" headerClass="sortable"
			    media="html"
			
 >
			
		</display:column>
</display:table>





	
</div>

</s:if>

	



	
	
	
</div>

	<!-- endFragment:p_pRisultatoVediSostituzioni --></div>

			
	
	<div id="p_pDettaglioSostituzioni" class="commandPanelBlock"><!-- startFragment:p_pDettaglioSostituzioni -->
	
	
<div class="commandPanel navigation" id="pDettaglioSostituzioni">

	
	
		

	
	
	
	<div class="button left">
		
<s:if test="isWidgetVisible('cpDettaglioSostituzioni','bIndietro')" >

	



<!-- widget bIndietro -->
	<csiuicore:ajaxify id="p_pCenter" 
		widgetType="button"
		 
		requestUri="/siceeweb/base/gestattestati/cpDettaglioSostituzioni!handleBIndietro_CLICKED.do" 
		
		pageId="cpDettaglioSostituzioni" 
		formName="cpDettaglioSostituzioni"
		javascriptDetection="false">
<s:submit name="widg_bIndietro" id="widg_bIndietro" method="handleBIndietro_CLICKED"
	key="cpDettaglioSostituzioni.bIndietro.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpDettaglioSostituzioni','bIndietro')" />

	</csiuicore:ajaxify>

	


</s:if>

	


	</div>
	
	

	
	
	
	

	
	
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_pDettaglioSostituzioni --></div>

	

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
