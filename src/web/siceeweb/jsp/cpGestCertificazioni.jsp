<%@taglib uri="/struts-tags" prefix="s" %>
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="/customtag" prefix="customtag" %>
<%@taglib uri="/csiuicore" prefix="csiuicore" %><%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<fmt:setBundle basename="/it/csi/sicee/siceeweb/presentation/siceeweb/action/gestattestati/CpGestCertificazioniAction" />


<s:include value="fragments/header.jsp" ></s:include>



<!-- appmoduleId:base/gestattestati -->
<!-- pageId:cpGestCertificazioni -->

<s:form id="cpGestCertificazioni" action="cpGestCertificazioni" namespace="/base/gestattestati" method="post">


<%-- NO SCRIPT --%>
		
	
	
		
<!-- ####################### PANNELLO CONTENUTI ###################### -->
<div id="contentPanel">

	<!-- ================ UDLRC Layout UP PANEL ================ -->
	<div id="northPanel">
		<div class="wrapper">
		
	
	<div id="p_pUp" class="formPanelBlock"><!-- startFragment:p_pUp -->

	
	

	
	
			
	
	
<s:include value="/jsp/userpanels/cpGestCertificazioni_pUserInfoCustomGestACE.jsp"></s:include>

	



	

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

	
		
			
<s:if test="isWidgetVisible('cpGestCertificazioni','menu')" >

	


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
				<h3><s:text name="cpGestCertificazioni.pMain.label" /></h3>

					
	
	<div id="p_pCenter" class="formPanelBlock"><!-- startFragment:p_pCenter -->

	
	

	
	
			
	
	<div id="p_pListaCert" class="formPanelBlock"><!-- startFragment:p_pListaCert -->
		
	
<div class="formPanel" id="pListaCert">


	
	

	
	
			
	
	<div id="p_pErrListaCert" class="stdMessagePanelBlock"><!-- startFragment:p_pErrListaCert -->
	
	
<div class="stdMessagePanel" id="pErrListaCert">
	<customtag:stdMessagePanel id="pErrListaCert" errorMessage="true" errorDetails="false" actionMessage="true" />
</div>

	<!-- endFragment:p_pErrListaCert --></div>

			
	
	<div id="p_pLista" class="widgetsPanelBlock"><!-- startFragment:p_pLista -->
	
	

<div class="widgetsPanel" id="pLista">
	

	
	
<s:if test="isWidgetVisible('cpGestCertificazioni','tblAttestati')" >

	
<div class="tableWidget">


<!-- widget tblAttestati -->
<s:set name="cpGestCertificazioni_tblAttestati_clearStatus" value="isTableClearStatus('cpGestCertificazioni_tblAttestati')" />
<s:url id="cpGestCertificazioniViewUrl"						   
					   action="cpGestCertificazioni"
					   namespace="/base/gestattestati"/>
<display:table name="appDatachiaviAttestati"  				
			   excludedParams="*"			   export="false"
               id="widg_tblAttestati"
               pagesize="10"
               keepStatus="true"
               requestURI="${cpGestCertificazioniViewUrl}"  
               clearStatus="${cpGestCertificazioni_tblAttestati_clearStatus}"
               uid="row_tblAttestati"
               summary="" 
               class="dataTable">
	
		<display:column headerClass="nosort" media="html">
			<s:radio list="%{#attr.row_tblAttestati.idRigaTabella}" name="appDataidRigaSelezionata" id="%{'tblAttestati-editcell-'+ (#attr.row_tblAttestati_rowNum - 1)}" cssClass="radio"
			/>
		</display:column>
		<display:column property="cod" titleKey="cpGestCertificazioni.tblAttestati.cod.label" 
			sortable="true" headerClass="sortable"
			    media="html"
			
 >
			
		</display:column>
		<display:column property="indirizzo" titleKey="cpGestCertificazioni.tblAttestati.indirizzo.label" 
			sortable="false" headerClass="nosort"
			    media="html"
			
 >
			
		</display:column>
		<display:column property="dataUltimaCompilazione" titleKey="cpGestCertificazioni.tblAttestati.dataUltimaCompilazione.label" 
			sortable="true" headerClass="sortable"
			    media="html"
			
 >
			
		</display:column>
		<display:column property="stato" titleKey="cpGestCertificazioni.tblAttestati.stato.label" 
			sortable="true" headerClass="sortable"
			    media="html"
			
 >
			
		</display:column>
</display:table>





	
</div>

</s:if>

	



	
	
	
</div>

	<!-- endFragment:p_pLista --></div>

			
	
	<div id="p_pCompilNavPrimo" class="commandPanelBlock"><!-- startFragment:p_pCompilNavPrimo -->
	
	
<div class="commandPanel functional" id="pCompilNavPrimo">

	
	
		

	
	
	
	

	
	
	
	

	
	
	
	<div class="button right">
		
<s:if test="isWidgetVisible('cpGestCertificazioni','bImportaDati')" >

	



<!-- widget bImportaDati -->
	<csiuicore:ajaxify id="p_pCenter" 
		widgetType="button"
		 
		requestUri="/siceeweb/base/gestattestati/cpGestCertificazioni!handleBImportaDati_CLICKED.do" 
		
		pageId="cpGestCertificazioni" 
		formName="cpGestCertificazioni"
		javascriptDetection="false">
<s:submit name="widg_bImportaDati" id="widg_bImportaDati" method="handleBImportaDati_CLICKED"
	key="cpGestCertificazioni.bImportaDati.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpGestCertificazioni','bImportaDati')" />

	</csiuicore:ajaxify>

	


</s:if>

	


		
<s:if test="isWidgetVisible('cpGestCertificazioni','bReConsAPE')" >

	



<!-- widget bReConsAPE -->
<s:submit name="widg_bReConsAPE" id="widg_bReConsAPE" method="handleBReConsAPE_CLICKED"
	key="cpGestCertificazioni.bReConsAPE.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpGestCertificazioni','bReConsAPE')" />

	


</s:if>

	


		
<s:if test="isWidgetVisible('cpGestCertificazioni','bReInitAPE')" >

	



<!-- widget bReInitAPE -->
<s:submit name="widg_bReInitAPE" id="widg_bReInitAPE" method="handleBReInitAPE_CLICKED"
	key="cpGestCertificazioni.bReInitAPE.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpGestCertificazioni','bReInitAPE')" />

	


</s:if>

	


		
<s:if test="isWidgetVisible('cpGestCertificazioni','bPagaAvanti')" >

	



<!-- widget bPagaAvanti -->
	<csiuicore:ajaxify id="p_pCenter" 
		widgetType="button"
		 
		requestUri="/siceeweb/base/gestattestati/cpGestCertificazioni!handleBPagaAvanti_CLICKED.do" 
		
		pageId="cpGestCertificazioni" 
		formName="cpGestCertificazioni"
		javascriptDetection="false">
<s:submit name="widg_bPagaAvanti" id="widg_bPagaAvanti" method="handleBPagaAvanti_CLICKED"
	key="cpGestCertificazioni.bPagaAvanti.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpGestCertificazioni','bPagaAvanti')" />

	</csiuicore:ajaxify>

	


</s:if>

	


		
<s:if test="isWidgetVisible('cpGestCertificazioni','bDettApe')" >

	



<!-- widget bDettApe -->
	<csiuicore:ajaxify id="p_pCenter" 
		widgetType="button"
		 
		requestUri="/siceeweb/base/gestattestati/cpGestCertificazioni!handleBDettApe_CLICKED.do" 
		
		pageId="cpGestCertificazioni" 
		formName="cpGestCertificazioni"
		javascriptDetection="false">
<s:submit name="widg_bDettApe" id="widg_bDettApe" method="handleBDettApe_CLICKED"
	key="cpGestCertificazioni.bDettApe.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpGestCertificazioni','bDettApe')" />

	</csiuicore:ajaxify>

	


</s:if>

	


	</div>
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_pCompilNavPrimo --></div>

			
	
	<div id="p_pCompilNav" class="commandPanelBlock"><!-- startFragment:p_pCompilNav -->
	
	
<div class="commandPanel functional" id="pCompilNav">

	
	
		

	
	
	
	

	
	
	
	

	
	
	
	<div class="button right">
		
<s:if test="isWidgetVisible('cpGestCertificazioni','bDownloadModulo')" >

	



<!-- widget bDownloadModulo -->
	<csiuicore:ajaxify id="p_pCenter" 
		widgetType="button"
		 
		requestUri="/siceeweb/base/gestattestati/cpGestCertificazioni!handleBDownloadModulo_CLICKED.do" 
		
		pageId="cpGestCertificazioni" 
		formName="cpGestCertificazioni"
		javascriptDetection="false">
<s:submit name="widg_bDownloadModulo" id="widg_bDownloadModulo" method="handleBDownloadModulo_CLICKED"
	key="cpGestCertificazioni.bDownloadModulo.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpGestCertificazioni','bDownloadModulo')" />

	</csiuicore:ajaxify>

	


</s:if>

	


		
<s:if test="isWidgetVisible('cpGestCertificazioni','btStampaAce')" >

	



<!-- widget btStampaAce -->
<s:submit name="widg_btStampaAce" id="widg_btStampaAce" method="handleBtStampaAce_CLICKED"
	key="cpGestCertificazioni.btStampaAce.label" cssClass="buttonWidget showReport"
	disabled="isWidgetDisabled('cpGestCertificazioni','btStampaAce')" />

	


</s:if>

	


		
<s:if test="isWidgetVisible('cpGestCertificazioni','bStampaReport')" >

	



<!-- widget bStampaReport -->
	<csiuicore:ajaxify id="p_pCenter" 
		widgetType="button"
		 
		requestUri="/siceeweb/base/gestattestati/cpGestCertificazioni!handleBStampaReport_CLICKED.do" 
		
		pageId="cpGestCertificazioni" 
		formName="cpGestCertificazioni"
		javascriptDetection="false">
<s:submit name="widg_bStampaReport" id="widg_bStampaReport" method="handleBStampaReport_CLICKED"
	key="cpGestCertificazioni.bStampaReport.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpGestCertificazioni','bStampaReport')" />

	</csiuicore:ajaxify>

	


</s:if>

	


		
<s:if test="isWidgetVisible('cpGestCertificazioni','bVisuraCit')" >

	



<!-- widget bVisuraCit -->
<s:submit name="widg_bVisuraCit" id="widg_bVisuraCit" method="handleBVisuraCit_CLICKED"
	key="cpGestCertificazioni.bVisuraCit.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpGestCertificazioni','bVisuraCit')" />

	


</s:if>

	


	</div>
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_pCompilNav --></div>

	

		
	
</div>

	<!-- endFragment:p_pListaCert --></div>

	

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
