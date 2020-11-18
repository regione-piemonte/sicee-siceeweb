<%@taglib uri="/struts-tags" prefix="s" %>
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="/customtag" prefix="customtag" %>
<%@taglib uri="/csiuicore" prefix="csiuicore" %><%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<fmt:setBundle basename="/it/csi/sicee/siceeweb/presentation/siceeweb/action/annullasostcert/CpEsitoAceAnnullaSostAction" />


<s:include value="fragments/header.jsp" ></s:include>



<!-- appmoduleId:base/annullaSostCert -->
<!-- pageId:cpEsitoAceAnnullaSost -->

<s:form id="cpEsitoAceAnnullaSost" action="cpEsitoAceAnnullaSost" namespace="/base/annullaSostCert" method="post">


<%-- NO SCRIPT --%>
		
	
	
		
<!-- ####################### PANNELLO CONTENUTI ###################### -->
<div id="contentPanel">

	<!-- ================ UDLRC Layout UP PANEL ================ -->
	<div id="northPanel">
		<div class="wrapper">
		
	
	<div id="p_pUp" class="formPanelBlock"><!-- startFragment:p_pUp -->

	
	

	
	
			
	
	
<s:include value="/jsp/userpanels/cpEsitoAceAnnullaSost_pUserInfoCustom.jsp"></s:include>

	



	

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

	
		
			
<s:if test="isWidgetVisible('cpEsitoAceAnnullaSost','menu')" >

	


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
				<h3><s:text name="cpEsitoAceAnnullaSost.pMain.label" /></h3>

					
	
	<div id="p_pCenter" class="formPanelBlock"><!-- startFragment:p_pCenter -->

	
	

	
	
			
	
	<div id="p_pErrRicercaAce" class="stdMessagePanelBlock"><!-- startFragment:p_pErrRicercaAce -->
	
	
<div class="stdMessagePanel" id="pErrRicercaAce">
	<customtag:stdMessagePanel id="pErrRicercaAce" errorMessage="true" errorDetails="false" actionMessage="true" />
</div>

	<!-- endFragment:p_pErrRicercaAce --></div>

			
	
	<div id="p_wpAceSostitutivi" class="widgetsPanelBlock"><!-- startFragment:p_wpAceSostitutivi -->
	
	
<h4 class="wpLabel">A.P.E. sostitutivi </h4>
<div class="widgetsPanel" id="wpAceSostitutivi">
	

	
	
<s:if test="isWidgetVisible('cpEsitoAceAnnullaSost','tblCarrelloAceNew')" >

	
<div class="tableWidget">


<!-- widget tblCarrelloAceNew -->
<s:set name="cpEsitoAceAnnullaSost_tblCarrelloAceNew_clearStatus" value="isTableClearStatus('cpEsitoAceAnnullaSost_tblCarrelloAceNew')" />
<s:url id="cpEsitoAceAnnullaSostViewUrl"						   
					   action="cpEsitoAceAnnullaSost"
					   namespace="/base/annullaSostCert"/>
<display:table name="appDatacarrelloAceNew"  				
			   excludedParams="*"			   export="false"
               id="widg_tblCarrelloAceNew"
               pagesize="0"
               keepStatus="true"
               requestURI="${cpEsitoAceAnnullaSostViewUrl}"  
               clearStatus="${cpEsitoAceAnnullaSost_tblCarrelloAceNew_clearStatus}"
               uid="row_tblCarrelloAceNew"
               summary="" 
               class="dataTable">
	
		<display:column headerClass="nosort" media="html">
			<s:radio list="%{#attr.row_tblCarrelloAceNew.codice}" name="appDatacodAttestatoDaStampare" id="%{'tblCarrelloAceNew-editcell-'+ (#attr.row_tblCarrelloAceNew_rowNum - 1)}" cssClass="radio"
			/>
		</display:column>
		<display:column property="codice" titleKey="cpEsitoAceAnnullaSost.tblCarrelloAceNew.codice.label" 
			sortable="false" headerClass="nosort"
			    media="html"
			
 >
			
		</display:column>
		<display:column property="descIndirizzo" titleKey="cpEsitoAceAnnullaSost.tblCarrelloAceNew.descIndirizzo.label" 
			sortable="false" headerClass="nosort"
			    media="html"
			
 >
			
		</display:column>
		<display:column property="descDatiCat" titleKey="cpEsitoAceAnnullaSost.tblCarrelloAceNew.descDatiCat.label" 
			sortable="false" headerClass="nosort"
			    media="html"
			
 >
			
		</display:column>
</display:table>





	
</div>

</s:if>

	



	
	
	
</div>

	<!-- endFragment:p_wpAceSostitutivi --></div>

			
	
	<div id="p_pConfermaCarrelloAceNav" class="commandPanelBlock"><!-- startFragment:p_pConfermaCarrelloAceNav -->
	
	
<div class="commandPanel navigation" id="pConfermaCarrelloAceNav">

	
	
		

	
	
	
	

	
	
	
	

	
	
	
	<div class="button right">
		
<s:if test="isWidgetVisible('cpEsitoAceAnnullaSost','bStampaRicevutaInvio')" >

	



<!-- widget bStampaRicevutaInvio -->
<s:submit name="widg_bStampaRicevutaInvio" id="widg_bStampaRicevutaInvio" method="handleBStampaRicevutaInvio_CLICKED"
	key="cpEsitoAceAnnullaSost.bStampaRicevutaInvio.label" cssClass="buttonWidget showReport"
	disabled="isWidgetDisabled('cpEsitoAceAnnullaSost','bStampaRicevutaInvio')" />

	


</s:if>

	


	</div>
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_pConfermaCarrelloAceNav --></div>

	

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
