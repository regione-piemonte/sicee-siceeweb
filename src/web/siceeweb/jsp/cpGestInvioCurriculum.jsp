<%@taglib uri="/struts-tags" prefix="s" %>
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="/customtag" prefix="customtag" %>
<%@taglib uri="/csiuicore" prefix="csiuicore" %><%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<fmt:setBundle basename="/it/csi/sicee/siceeweb/presentation/siceeweb/action/gestattestati/CpGestInvioCurriculumAction" />


<s:include value="fragments/header.jsp" ></s:include>



<!-- appmoduleId:base/gestattestati -->
<!-- pageId:cpGestInvioCurriculum -->

<s:form id="cpGestInvioCurriculum" action="cpGestInvioCurriculum" namespace="/base/gestattestati" method="post" enctype="multipart/form-data">


<%-- NO SCRIPT --%>
		
	
	
		
<!-- ####################### PANNELLO CONTENUTI ###################### -->
<div id="contentPanel">

	<!-- ================ UDLRC Layout UP PANEL ================ -->
	<div id="northPanel">
		<div class="wrapper">
		
	
	<div id="p_pUp" class="formPanelBlock"><!-- startFragment:p_pUp -->

	
	

	
	
			
	
	
<s:include value="/jsp/userpanels/cpGestInvioCurriculum_pUserInfoCustomGestACE.jsp"></s:include>

	



	

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

	
		
			
<s:if test="isWidgetVisible('cpGestInvioCurriculum','menu')" >

	


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
				<h3><s:text name="cpGestInvioCurriculum.pMain.label" /></h3>

					
	
	<div id="p_pCenter" class="formPanelBlock"><!-- startFragment:p_pCenter -->

	
	

	
	
			
	
	<div id="p_pInvioCert" class="formPanelBlock"><!-- startFragment:p_pInvioCert -->
		
	
<div class="formPanel" id="pInvioCert">


	
	

	
	
			
	
	<div id="p_pErrInvioDocumento" class="stdMessagePanelBlock"><!-- startFragment:p_pErrInvioDocumento -->
	
	
<div class="stdMessagePanel" id="pErrInvioDocumento">
	<customtag:stdMessagePanel id="pErrInvioDocumento" errorMessage="true" errorDetails="false" actionMessage="true" />
</div>

	<!-- endFragment:p_pErrInvioDocumento --></div>

			
	
	<div id="p_pInvio" class="widgetsPanelBlock"><!-- startFragment:p_pInvio -->
	
	

<div class="widgetsPanel" id="pInvio">
	
	<customtag:widgetsPanel id="pInvioTbl" columns="2" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('cpGestInvioCurriculum','txtInvio')" >

	
<customtag:widgetsPanelColumn  colSpan="2"  >


<!-- widget txtInvio -->
<s:text name="cpGestInvioCurriculum.txtInvio.statictext.label" />

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestInvioCurriculum','fileAttestato')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestInvioCurriculum.fileAttestato.label')}" labelFor="widg_fileAttestato" errorFor="widg_fileAttestato" labelId="fileAttestatoLbl"
	  >


<s:file 
	
	
	name="widg_fileAttestato" id="widg_fileAttestato"
	disabled="isWidgetDisabled('cpGestInvioCurriculum','fileAttestato')"
	
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestInvioCurriculum','ckTrattDatiPersonaliCurriculum')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestInvioCurriculum.ckTrattDatiPersonaliCurriculum.label')}" labelFor="widg_ckTrattDatiPersonaliCurriculum" errorFor="appDataflagDatiPersCurriculum" labelId="ckTrattDatiPersonaliCurriculumLbl"
	  >


<!-- widget ckTrattDatiPersonaliCurriculum -->
<s:checkbox 
	
	
	name="appDataflagDatiPersCurriculum" id="widg_ckTrattDatiPersonaliCurriculum"
	disabled="isWidgetDisabled('cpGestInvioCurriculum','ckTrattDatiPersonaliCurriculum')"
	cssClass="checkbox"
	
	/> 
<s:if test="!isWidgetDisabled('cpGestInvioCurriculum','ckTrattDatiPersonaliCurriculum')" >
	<s:hidden name="__checkbox_appDataflagDatiPersCurriculum" id="__checkbox_widg_ckTrattDatiPersonaliCurriculum" />
</s:if>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestInvioCurriculum','txtDocAmmessi')" >

	
<customtag:widgetsPanelColumn  colSpan="2"  >


<!-- widget txtDocAmmessi -->
<s:text name="cpGestInvioCurriculum.txtDocAmmessi.statictext.label" />

	
</customtag:widgetsPanelColumn>

</s:if>

	



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_pInvio --></div>

			
	
	<div id="p_pPagamentoNav" class="commandPanelBlock"><!-- startFragment:p_pPagamentoNav -->
	
	
<div class="commandPanel navigation" id="pPagamentoNav">

	
	
		

	
	
	
	

	
	
	
	

	
	
	
	<div class="button right">
		
<s:if test="isWidgetVisible('cpGestInvioCurriculum','bInvioAvanti')" >

	



<!-- widget bInvioAvanti -->
<s:submit name="widg_bInvioAvanti" id="widg_bInvioAvanti" method="handleBInvioAvanti_CLICKED"
	key="cpGestInvioCurriculum.bInvioAvanti.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpGestInvioCurriculum','bInvioAvanti')" />

	


</s:if>

	


	</div>
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_pPagamentoNav --></div>

			
	
	<div id="p_pListaDocumenti" class="widgetsPanelBlock"><!-- startFragment:p_pListaDocumenti -->
	
	

<div class="widgetsPanel" id="pListaDocumenti">
	

	
	
<s:if test="isWidgetVisible('cpGestInvioCurriculum','tblCurriculumSummary')" >

	
<div class="tableWidget">


<!-- widget tblCurriculumSummary -->
<s:set name="cpGestInvioCurriculum_tblCurriculumSummary_clearStatus" value="isTableClearStatus('cpGestInvioCurriculum_tblCurriculumSummary')" />
<s:url id="cpGestInvioCurriculumViewUrl"						   
					   action="cpGestInvioCurriculum"
					   namespace="/base/gestattestati"/>
<display:table name="appDatachiaviCurriculum"  				
			   excludedParams="*"			   export="false"
               id="widg_tblCurriculumSummary"
               pagesize="10"
               keepStatus="true"
               requestURI="${cpGestInvioCurriculumViewUrl}"  
               clearStatus="${cpGestInvioCurriculum_tblCurriculumSummary_clearStatus}"
               uid="row_tblCurriculumSummary"
               summary="" 
decorator="it.csi.sicee.siceeweb.presentation.decorator.gestattestati.CpGestInvioCurriculumTblCurriculumSummaryCustomDecorator"               class="dataTable">
	
		<display:column property="nome" titleKey="cpGestInvioCurriculum.tblCurriculumSummary.nome.label" 
			sortable="false" headerClass="nosort"
			    media="html"
			
 >
			
		</display:column>
		<display:column property="tipo" titleKey="cpGestInvioCurriculum.tblCurriculumSummary.tipo.label" 
			sortable="false" headerClass="nosort"
			    media="html"
			
 >
			
		</display:column>
		<display:column property="dataUpload" titleKey="cpGestInvioCurriculum.tblCurriculumSummary.dataUpload.label" 
			sortable="false" headerClass="nosort"
			    media="html"
			
 >
			
		</display:column>
		<display:column property="flgScarico" titleKey="cpGestInvioCurriculum.tblCurriculumSummary.flgScarico.label" 
			sortable="false" headerClass="nosort"
			    media="html"
			
 >
			
		</display:column>
</display:table>





	
</div>

</s:if>

	



	
	
	
</div>

	<!-- endFragment:p_pListaDocumenti --></div>

	

		
	
</div>

	<!-- endFragment:p_pInvioCert --></div>

	

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
