<%@taglib uri="/struts-tags" prefix="s" %>
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="/customtag" prefix="customtag" %>
<%@taglib uri="/csiuicore" prefix="csiuicore" %><%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<fmt:setBundle basename="/it/csi/sicee/siceeweb/presentation/siceeweb/action/annullasostcert/CpRiepilogoAceAnnullaSostAction" />


<s:include value="fragments/header.jsp" ></s:include>



<!-- appmoduleId:base/annullaSostCert -->
<!-- pageId:cpRiepilogoAceAnnullaSost -->

<s:form id="cpRiepilogoAceAnnullaSost" action="cpRiepilogoAceAnnullaSost" namespace="/base/annullaSostCert" method="post">


<%-- NO SCRIPT --%>
		
	
	
		
<!-- ####################### PANNELLO CONTENUTI ###################### -->
<div id="contentPanel">

	<!-- ================ UDLRC Layout UP PANEL ================ -->
	<div id="northPanel">
		<div class="wrapper">
		
	
	<div id="p_pUp" class="formPanelBlock"><!-- startFragment:p_pUp -->

	
	

	
	
			
	
	
<s:include value="/jsp/userpanels/cpRiepilogoAceAnnullaSost_pUserInfoCustom.jsp"></s:include>

	



	

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

	
		
			
<s:if test="isWidgetVisible('cpRiepilogoAceAnnullaSost','menu')" >

	


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
				<h3><s:text name="cpRiepilogoAceAnnullaSost.pMain.label" /></h3>

					
	
	<div id="p_pCenter" class="formPanelBlock"><!-- startFragment:p_pCenter -->

	
	

	
	
			
	
	<div id="p_pErrRicercaAce" class="stdMessagePanelBlock"><!-- startFragment:p_pErrRicercaAce -->
	
	
<div class="stdMessagePanel" id="pErrRicercaAce">
	<customtag:stdMessagePanel id="pErrRicercaAce" errorMessage="true" errorDetails="false" actionMessage="true" />
</div>

	<!-- endFragment:p_pErrRicercaAce --></div>

			
	
	<div id="p_wpRiepilogoParametri" class="widgetsPanelBlock"><!-- startFragment:p_wpRiepilogoParametri -->
	
	
<h4 class="wpLabel">Riepilogo parametri sostituzione </h4>
<div class="widgetsPanel" id="wpRiepilogoParametri">
	
	<customtag:widgetsPanel id="wpRiepilogoParametriTbl" columns="2" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('cpRiepilogoAceAnnullaSost','ptMotivazione')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpRiepilogoAceAnnullaSost.ptMotivazione.label')}" labelFor="widg_ptMotivazione" errorFor="appDatadatiAnnullamento.descMotivo" labelId="ptMotivazioneLbl"   >


<!-- widget ptMotivazione -->
<s:property value="appDatadatiAnnullamento.descMotivo" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpRiepilogoAceAnnullaSost','ptRiepData')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpRiepilogoAceAnnullaSost.ptRiepData.label')}" labelFor="widg_ptRiepData" errorFor="appDatadatiAnnullamento.data" labelId="ptRiepDataLbl"   >


<!-- widget ptRiepData -->
<s:property value="appDatadatiAnnullamento.data" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpRiepilogoAceAnnullaSost','ptRiepNote')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpRiepilogoAceAnnullaSost.ptRiepNote.label')}" labelFor="widg_ptRiepNote" errorFor="appDatadatiAnnullamento.note" labelId="ptRiepNoteLbl"   >


<!-- widget ptRiepNote -->
<s:property value="appDatadatiAnnullamento.note" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpRiepilogoAceAnnullaSost','ptRiepPregresso')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpRiepilogoAceAnnullaSost.ptRiepPregresso.label')}" labelFor="widg_ptRiepPregresso" errorFor="appDatadatiAnnullamento.descFlgRicercaPregresso" labelId="ptRiepPregressoLbl"   >


<!-- widget ptRiepPregresso -->
<s:property value="appDatadatiAnnullamento.descFlgRicercaPregresso" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_wpRiepilogoParametri --></div>

			
	
	<div id="p_wpAceDaSostituire" class="widgetsPanelBlock"><!-- startFragment:p_wpAceDaSostituire -->
	
	
<h4 class="wpLabel">A.P.E. da sostituire </h4>
<div class="widgetsPanel" id="wpAceDaSostituire">
	

	
	
<s:if test="isWidgetVisible('cpRiepilogoAceAnnullaSost','tblCarrelloAceOld')" >

	
<div class="tableWidget">


<!-- widget tblCarrelloAceOld -->
<s:set name="cpRiepilogoAceAnnullaSost_tblCarrelloAceOld_clearStatus" value="isTableClearStatus('cpRiepilogoAceAnnullaSost_tblCarrelloAceOld')" />
<s:url id="cpRiepilogoAceAnnullaSostViewUrl"						   
					   action="cpRiepilogoAceAnnullaSost"
					   namespace="/base/annullaSostCert"/>
<display:table name="appDatacarrelloAceOld"  				
			   excludedParams="*"			   export="false"
               id="widg_tblCarrelloAceOld"
               pagesize="0"
               keepStatus="true"
               requestURI="${cpRiepilogoAceAnnullaSostViewUrl}"  
               clearStatus="${cpRiepilogoAceAnnullaSost_tblCarrelloAceOld_clearStatus}"
               uid="row_tblCarrelloAceOld"
               summary="" 
               class="dataTable">
	
		<display:column headerClass="nosort" media="html">
			<s:radio list="%{#attr.row_tblCarrelloAceOld.codice}" name="appDatacodiceCertificatoDaSostituireSelezionato" id="%{'tblCarrelloAceOld-editcell-'+ (#attr.row_tblCarrelloAceOld_rowNum - 1)}" cssClass="radio"
			/>
		</display:column>
		<display:column property="codice" titleKey="cpRiepilogoAceAnnullaSost.tblCarrelloAceOld.codice.label" 
			sortable="false" headerClass="nosort"
			    media="html"
			
 >
			
		</display:column>
		<display:column property="descIndirizzo" titleKey="cpRiepilogoAceAnnullaSost.tblCarrelloAceOld.descIndirizzo.label" 
			sortable="false" headerClass="nosort"
			    media="html"
			
 >
			
		</display:column>
		<display:column property="descDatiCat" titleKey="cpRiepilogoAceAnnullaSost.tblCarrelloAceOld.descDatiCat.label" 
			sortable="false" headerClass="nosort"
			    media="html"
			
 >
			
		</display:column>
</display:table>





	
</div>

</s:if>

	



	
	
	
</div>

	<!-- endFragment:p_wpAceDaSostituire --></div>

			
	
	<div id="p_pEliminaOldCarrelloAceFun" class="commandPanelBlock"><!-- startFragment:p_pEliminaOldCarrelloAceFun -->
	
	
<div class="commandPanel functional" id="pEliminaOldCarrelloAceFun">

	
	
		

	
	
	
	<div class="button left">
		
<s:if test="isWidgetVisible('cpRiepilogoAceAnnullaSost','btnCarrelloEliminaOld')" >

	



<!-- widget btnCarrelloEliminaOld -->
	<csiuicore:ajaxify id="p_pCenter" 
		widgetType="button"
		 
		requestUri="/siceeweb/base/annullaSostCert/cpRiepilogoAceAnnullaSost!handleBtnCarrelloEliminaOld_CLICKED.do" 
		
		pageId="cpRiepilogoAceAnnullaSost" 
		formName="cpRiepilogoAceAnnullaSost"
		javascriptDetection="false">
<s:submit name="widg_btnCarrelloEliminaOld" id="widg_btnCarrelloEliminaOld" method="handleBtnCarrelloEliminaOld_CLICKED"
	key="cpRiepilogoAceAnnullaSost.btnCarrelloEliminaOld.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpRiepilogoAceAnnullaSost','btnCarrelloEliminaOld')" />

	</csiuicore:ajaxify>

	


</s:if>

	


	</div>
	
	

	
	
	
	

	
	
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_pEliminaOldCarrelloAceFun --></div>

			
	
	<div id="p_wpAceSostitutivi" class="widgetsPanelBlock"><!-- startFragment:p_wpAceSostitutivi -->
	
	
<h4 class="wpLabel">A.P.E. sostitutivi </h4>
<div class="widgetsPanel" id="wpAceSostitutivi">
	

	
	
<s:if test="isWidgetVisible('cpRiepilogoAceAnnullaSost','tblCarrelloAceNew')" >

	
<div class="tableWidget">


<!-- widget tblCarrelloAceNew -->
<s:set name="cpRiepilogoAceAnnullaSost_tblCarrelloAceNew_clearStatus" value="isTableClearStatus('cpRiepilogoAceAnnullaSost_tblCarrelloAceNew')" />
<s:url id="cpRiepilogoAceAnnullaSostViewUrl"						   
					   action="cpRiepilogoAceAnnullaSost"
					   namespace="/base/annullaSostCert"/>
<display:table name="appDatacarrelloAceNew"  				
			   excludedParams="*"			   export="false"
               id="widg_tblCarrelloAceNew"
               pagesize="0"
               keepStatus="true"
               requestURI="${cpRiepilogoAceAnnullaSostViewUrl}"  
               clearStatus="${cpRiepilogoAceAnnullaSost_tblCarrelloAceNew_clearStatus}"
               uid="row_tblCarrelloAceNew"
               summary="" 
               class="dataTable">
	
		<display:column headerClass="nosort" media="html">
			<s:radio list="%{#attr.row_tblCarrelloAceNew.codice}" name="appDatacodiceCertificatoSostitutivoSelezionato" id="%{'tblCarrelloAceNew-editcell-'+ (#attr.row_tblCarrelloAceNew_rowNum - 1)}" cssClass="radio"
			/>
		</display:column>
		<display:column property="codice" titleKey="cpRiepilogoAceAnnullaSost.tblCarrelloAceNew.codice.label" 
			sortable="false" headerClass="nosort"
			    media="html"
			
 >
			
		</display:column>
		<display:column property="descIndirizzo" titleKey="cpRiepilogoAceAnnullaSost.tblCarrelloAceNew.descIndirizzo.label" 
			sortable="false" headerClass="nosort"
			    media="html"
			
 >
			
		</display:column>
		<display:column property="descDatiCat" titleKey="cpRiepilogoAceAnnullaSost.tblCarrelloAceNew.descDatiCat.label" 
			sortable="false" headerClass="nosort"
			    media="html"
			
 >
			
		</display:column>
</display:table>





	
</div>

</s:if>

	



	
	
	
</div>

	<!-- endFragment:p_wpAceSostitutivi --></div>

			
	
	<div id="p_pEliminaNewCarrelloAceFun" class="commandPanelBlock"><!-- startFragment:p_pEliminaNewCarrelloAceFun -->
	
	
<div class="commandPanel functional" id="pEliminaNewCarrelloAceFun">

	
	
		

	
	
	
	<div class="button left">
		
<s:if test="isWidgetVisible('cpRiepilogoAceAnnullaSost','btnCarrelloEliminaNew')" >

	



<!-- widget btnCarrelloEliminaNew -->
	<csiuicore:ajaxify id="p_pCenter" 
		widgetType="button"
		 
		requestUri="/siceeweb/base/annullaSostCert/cpRiepilogoAceAnnullaSost!handleBtnCarrelloEliminaNew_CLICKED.do" 
		
		pageId="cpRiepilogoAceAnnullaSost" 
		formName="cpRiepilogoAceAnnullaSost"
		javascriptDetection="false">
<s:submit name="widg_btnCarrelloEliminaNew" id="widg_btnCarrelloEliminaNew" method="handleBtnCarrelloEliminaNew_CLICKED"
	key="cpRiepilogoAceAnnullaSost.btnCarrelloEliminaNew.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpRiepilogoAceAnnullaSost','btnCarrelloEliminaNew')" />

	</csiuicore:ajaxify>

	


</s:if>

	


	</div>
	
	

	
	
	
	

	
	
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_pEliminaNewCarrelloAceFun --></div>

			
	
	<div id="p_pConfermaCarrelloAceNav" class="commandPanelBlock"><!-- startFragment:p_pConfermaCarrelloAceNav -->
	
	
<div class="commandPanel navigation" id="pConfermaCarrelloAceNav">

	
	
		

	
	
	
	<div class="button left">
		
<s:if test="isWidgetVisible('cpRiepilogoAceAnnullaSost','btnIndietro')" >

	



<!-- widget btnIndietro -->
	<csiuicore:ajaxify id="p_pCenter" 
		widgetType="button"
		 
		requestUri="/siceeweb/base/annullaSostCert/cpRiepilogoAceAnnullaSost!handleBtnIndietro_CLICKED.do" 
		
		pageId="cpRiepilogoAceAnnullaSost" 
		formName="cpRiepilogoAceAnnullaSost"
		javascriptDetection="false">
<s:submit name="widg_btnIndietro" id="widg_btnIndietro" method="handleBtnIndietro_CLICKED"
	key="cpRiepilogoAceAnnullaSost.btnIndietro.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpRiepilogoAceAnnullaSost','btnIndietro')" />

	</csiuicore:ajaxify>

	


</s:if>

	


	</div>
	
	

	
	
	
	

	
	
	
	<div class="button right">
		
<s:if test="isWidgetVisible('cpRiepilogoAceAnnullaSost','btnConfermaSostituzione')" >

	



<!-- widget btnConfermaSostituzione -->
	<csiuicore:ajaxify id="p_pCenter" 
		widgetType="button"
		 
		requestUri="/siceeweb/base/annullaSostCert/cpRiepilogoAceAnnullaSost!handleBtnConfermaSostituzione_CLICKED.do" 
		
		pageId="cpRiepilogoAceAnnullaSost" 
		formName="cpRiepilogoAceAnnullaSost"
		javascriptDetection="false">
<s:submit name="widg_btnConfermaSostituzione" id="widg_btnConfermaSostituzione" method="handleBtnConfermaSostituzione_CLICKED"
	key="cpRiepilogoAceAnnullaSost.btnConfermaSostituzione.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpRiepilogoAceAnnullaSost','btnConfermaSostituzione')" />

	</csiuicore:ajaxify>

	


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
