<%@taglib uri="/struts-tags" prefix="s" %>
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="/customtag" prefix="customtag" %>
<%@taglib uri="/csiuicore" prefix="csiuicore" %><%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<fmt:setBundle basename="/it/csi/sicee/siceeweb/presentation/siceeweb/action/gestattestati/CpRisultatoRicercaAceAction" />


<s:include value="fragments/header.jsp" ></s:include>



<!-- appmoduleId:base/gestattestati -->
<!-- pageId:cpRisultatoRicercaAce -->

<s:form id="cpRisultatoRicercaAce" action="cpRisultatoRicercaAce" namespace="/base/gestattestati" method="post">


<%-- NO SCRIPT --%>
		
	
	
		
<!-- ####################### PANNELLO CONTENUTI ###################### -->
<div id="contentPanel">

	<!-- ================ UDLRC Layout UP PANEL ================ -->
	<div id="northPanel">
		<div class="wrapper">
		
	
	<div id="p_pUp" class="formPanelBlock"><!-- startFragment:p_pUp -->

	
	

	
	
			
	
	
<s:include value="/jsp/userpanels/cpRisultatoRicercaAce_pUserInfoCustom.jsp"></s:include>

	



	

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

	
		
			
<s:if test="isWidgetVisible('cpRisultatoRicercaAce','menu')" >

	


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
				<h3><s:text name="cpRisultatoRicercaAce.pMain.label" /></h3>

					
	
	<div id="p_pCenter" class="formPanelBlock"><!-- startFragment:p_pCenter -->

	
	

	
	
			
	
	<div id="p_pErrRisultatoRicercaAce" class="stdMessagePanelBlock"><!-- startFragment:p_pErrRisultatoRicercaAce -->
	
	
<div class="stdMessagePanel" id="pErrRisultatoRicercaAce">
	<customtag:stdMessagePanel id="pErrRisultatoRicercaAce" errorMessage="true" errorDetails="false" actionMessage="true" />
</div>

	<!-- endFragment:p_pErrRisultatoRicercaAce --></div>

			
	
	<div id="p_pRisultatoRicercaAce" class="widgetsPanelBlock"><!-- startFragment:p_pRisultatoRicercaAce -->
	
	

<div class="widgetsPanel" id="pRisultatoRicercaAce">
	

	
	
<s:if test="isWidgetVisible('cpRisultatoRicercaAce','tblRisultatoRicercaAceInviati')" >

	
<div class="tableWidget">


<!-- widget tblRisultatoRicercaAceInviati -->
<s:set name="cpRisultatoRicercaAce_tblRisultatoRicercaAceInviati_clearStatus" value="isTableClearStatus('cpRisultatoRicercaAce_tblRisultatoRicercaAceInviati')" />
<s:url id="cpRisultatoRicercaAceViewUrl"						   
					   action="cpRisultatoRicercaAce"
					   namespace="/base/gestattestati"/>
<display:table name="appDatacertificatiInviati"  				
			   excludedParams="*"			   export="false"
               id="widg_tblRisultatoRicercaAceInviati"
               pagesize="10"
               keepStatus="true"
               requestURI="${cpRisultatoRicercaAceViewUrl}"  
               clearStatus="${cpRisultatoRicercaAce_tblRisultatoRicercaAceInviati_clearStatus}"
               uid="row_tblRisultatoRicercaAceInviati"
               summary="" 
decorator="it.csi.sicee.siceeweb.presentation.decorator.gestattestati.CpRisultatoRicercaAceTblRisultatoRicercaAceInviatiCustomDecorator"               class="dataTable">
	
		<display:column headerClass="nosort" media="html">
			<s:radio list="%{#attr.row_tblRisultatoRicercaAceInviati.idRigaTabella}" name="appDataidRigaSelezionata" id="%{'tblRisultatoRicercaAceInviati-editcell-'+ (#attr.row_tblRisultatoRicercaAceInviati_rowNum - 1)}" cssClass="radio"
			/>
		</display:column>
		<display:column property="codice" titleKey="cpRisultatoRicercaAce.tblRisultatoRicercaAceInviati.codice.label" 
			sortable="true" headerClass="sortable"
			    media="html"
			
 >
			
		</display:column>
		<display:column property="descIndirizzo" titleKey="cpRisultatoRicercaAce.tblRisultatoRicercaAceInviati.descIndirizzo.label" 
			sortable="false" headerClass="nosort"
			    media="html"
			
 >
			
		</display:column>
		<display:column property="dataUpload" titleKey="cpRisultatoRicercaAce.tblRisultatoRicercaAceInviati.dataUpload.label" 
			sortable="true" headerClass="sortable"
			 comparator="it.csi.sicee.siceeweb.presentation.siceeweb.comparator.CsiDateComparator"   media="html"
			
 >
			
		</display:column>
		<display:column property="dataScadenza" titleKey="cpRisultatoRicercaAce.tblRisultatoRicercaAceInviati.dataScadenza.label" 
			sortable="true" headerClass="sortable"
			 comparator="it.csi.sicee.siceeweb.presentation.siceeweb.comparator.CsiDateComparator"   media="html"
			
 >
			
		</display:column>
		<display:column property="stato" titleKey="cpRisultatoRicercaAce.tblRisultatoRicercaAceInviati.stato.label" 
			sortable="true" headerClass="sortable"
			    media="html"
			
 >
			
		</display:column>
		<display:column property="linkDownload" titleKey="cpRisultatoRicercaAce.tblRisultatoRicercaAceInviati.linkDownload.label" 
			sortable="false" headerClass="nosort"
			    media="html"
			
 >
			
		</display:column>
		<display:column property="flgRicevuta" titleKey="cpRisultatoRicercaAce.tblRisultatoRicercaAceInviati.flgRicevuta.label" 
			sortable="false" headerClass="nosort"
			    media="html"
			
 >
			
		</display:column>
		<display:column property="linkDownloadInd" titleKey="cpRisultatoRicercaAce.tblRisultatoRicercaAceInviati.linkDownloadInd.label" 
			sortable="false" headerClass="nosort"
			    media="html"
			
 >
			
		</display:column>
</display:table>





	
</div>

</s:if>

	



	
	
	
</div>

	<!-- endFragment:p_pRisultatoRicercaAce --></div>

			
	
	<div id="p_pRisultatoRicercaAceNav" class="commandPanelBlock"><!-- startFragment:p_pRisultatoRicercaAceNav -->
	
	
<div class="commandPanel functional" id="pRisultatoRicercaAceNav">

	
	
		

	
	
	
	

	
	
	
	

	
	
	
	<div class="button right">
		
<s:if test="isWidgetVisible('cpRisultatoRicercaAce','bVediSostituzioni')" >

	



<!-- widget bVediSostituzioni -->
	<csiuicore:ajaxify id="p_pCenter" 
		widgetType="button"
		 
		requestUri="/siceeweb/base/gestattestati/cpRisultatoRicercaAce!handleBVediSostituzioni_CLICKED.do" 
		
		pageId="cpRisultatoRicercaAce" 
		formName="cpRisultatoRicercaAce"
		javascriptDetection="false">
<s:submit name="widg_bVediSostituzioni" id="widg_bVediSostituzioni" method="handleBVediSostituzioni_CLICKED"
	key="cpRisultatoRicercaAce.bVediSostituzioni.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpRisultatoRicercaAce','bVediSostituzioni')" />

	</csiuicore:ajaxify>

	


</s:if>

	


		
<s:if test="isWidgetVisible('cpRisultatoRicercaAce','bDuplicaDati')" >

	



<!-- widget bDuplicaDati -->
	<csiuicore:ajaxify id="p_pCenter" 
		widgetType="button"
		 
		requestUri="/siceeweb/base/gestattestati/cpRisultatoRicercaAce!handleBDuplicaDati_CLICKED.do" 
		
		pageId="cpRisultatoRicercaAce" 
		formName="cpRisultatoRicercaAce"
		javascriptDetection="false">
<s:submit name="widg_bDuplicaDati" id="widg_bDuplicaDati" method="handleBDuplicaDati_CLICKED"
	key="cpRisultatoRicercaAce.bDuplicaDati.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpRisultatoRicercaAce','bDuplicaDati')" />

	</csiuicore:ajaxify>

	


</s:if>

	


		
<s:if test="isWidgetVisible('cpRisultatoRicercaAce','bStampaReport')" >

	



<!-- widget bStampaReport -->
	<csiuicore:ajaxify id="p_pCenter" 
		widgetType="button"
		 
		requestUri="/siceeweb/base/gestattestati/cpRisultatoRicercaAce!handleBStampaReport_CLICKED.do" 
		
		pageId="cpRisultatoRicercaAce" 
		formName="cpRisultatoRicercaAce"
		javascriptDetection="false">
<s:submit name="widg_bStampaReport" id="widg_bStampaReport" method="handleBStampaReport_CLICKED"
	key="cpRisultatoRicercaAce.bStampaReport.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpRisultatoRicercaAce','bStampaReport')" />

	</csiuicore:ajaxify>

	


</s:if>

	


		
<s:if test="isWidgetVisible('cpRisultatoRicercaAce','bVisuliazza')" >

	



<!-- widget bVisuliazza -->
	<csiuicore:ajaxify id="p_pCenter" 
		widgetType="button"
		 
		requestUri="/siceeweb/base/gestattestati/cpRisultatoRicercaAce!handleBVisuliazza_CLICKED.do" 
		
		pageId="cpRisultatoRicercaAce" 
		formName="cpRisultatoRicercaAce"
		javascriptDetection="false">
<s:submit name="widg_bVisuliazza" id="widg_bVisuliazza" method="handleBVisuliazza_CLICKED"
	key="cpRisultatoRicercaAce.bVisuliazza.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpRisultatoRicercaAce','bVisuliazza')" />

	</csiuicore:ajaxify>

	


</s:if>

	


		
<s:if test="isWidgetVisible('cpRisultatoRicercaAce','bNuovaRicerca')" >

	



<!-- widget bNuovaRicerca -->
	<csiuicore:ajaxify id="p_pCenter" 
		widgetType="button"
		 
		requestUri="/siceeweb/base/gestattestati/cpRisultatoRicercaAce!handleBNuovaRicerca_CLICKED.do" 
		
		pageId="cpRisultatoRicercaAce" 
		formName="cpRisultatoRicercaAce"
		javascriptDetection="false">
<s:submit name="widg_bNuovaRicerca" id="widg_bNuovaRicerca" method="handleBNuovaRicerca_CLICKED"
	key="cpRisultatoRicercaAce.bNuovaRicerca.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpRisultatoRicercaAce','bNuovaRicerca')" />

	</csiuicore:ajaxify>

	


</s:if>

	


	</div>
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_pRisultatoRicercaAceNav --></div>

	

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
