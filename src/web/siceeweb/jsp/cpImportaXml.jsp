<%@taglib uri="/struts-tags" prefix="s" %>
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="/customtag" prefix="customtag" %>
<%@taglib uri="/csiuicore" prefix="csiuicore" %><%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<fmt:setBundle basename="/it/csi/sicee/siceeweb/presentation/siceeweb/action/compilazattestati/CpImportaXmlAction" />


<s:include value="fragments/header.jsp" ></s:include>



<!-- appmoduleId:base/compilazattestati -->
<!-- pageId:cpImportaXml -->

<s:form id="cpImportaXml" action="cpImportaXml" namespace="/base/compilazattestati" method="post" enctype="multipart/form-data">


<%-- NO SCRIPT --%>
		
	
	
		
<!-- ####################### PANNELLO CONTENUTI ###################### -->
<div id="contentPanel">

	<!-- ================ UDLRC Layout UP PANEL ================ -->
	<div id="northPanel">
		<div class="wrapper">
		
	
	<div id="p_pUp" class="formPanelBlock"><!-- startFragment:p_pUp -->

	
	

	
	
			
	
	
<s:include value="/jsp/userpanels/cpImportaXml_pUserInfoCustomHome.jsp"></s:include>

	



	

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

	
		
			
<s:if test="isWidgetVisible('cpImportaXml','menu')" >

	


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
				<h3><s:text name="cpImportaXml.pMain.label" /></h3>

					
	
	<div id="p_pCenter" class="formPanelBlock"><!-- startFragment:p_pCenter -->

	
	

	
	
			
	
	<div id="p_pMessagePanel" class="stdMessagePanelBlock"><!-- startFragment:p_pMessagePanel -->
	
	
<div class="stdMessagePanel" id="pMessagePanel">
	<customtag:stdMessagePanel id="pMessagePanel" errorMessage="true" errorDetails="false" actionMessage="true" />
</div>

	<!-- endFragment:p_pMessagePanel --></div>

			
	
	<div id="p_pDatiAggiuntivi" class="widgetsPanelBlock"><!-- startFragment:p_pDatiAggiuntivi -->
	
	

<div class="widgetsPanel" id="pDatiAggiuntivi">
	
	<customtag:widgetsPanel id="pDatiAggiuntiviTbl" columns="4" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('cpImportaXml','fileCaricaXml')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpImportaXml.fileCaricaXml.label')}" labelFor="widg_fileCaricaXml" errorFor="widg_fileCaricaXml" labelId="fileCaricaXmlLbl"
	position="first"  >


<s:file 
	
	
	name="widg_fileCaricaXml" id="widg_fileCaricaXml"
	disabled="isWidgetDisabled('cpImportaXml','fileCaricaXml')"
	
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpImportaXml','btnCaricaXml')" >

	
<customtag:widgetsPanelColumn colSpan="2" position="last">


<!-- widget btnCaricaXml -->
	<csiuicore:ajaxify id="p_pCenter" 
		widgetType="button"
		 
		requestUri="/siceeweb/base/compilazattestati/cpImportaXml!handleBtnCaricaXml_CLICKED.do" 
		
		pageId="cpImportaXml" 
		formName="cpImportaXml"
		javascriptDetection="false">
<s:submit name="widg_btnCaricaXml" id="widg_btnCaricaXml" method="handleBtnCaricaXml_CLICKED"
	key="cpImportaXml.btnCaricaXml.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpImportaXml','btnCaricaXml')" />

	</csiuicore:ajaxify>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpImportaXml','cbProvDtCatastali')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpImportaXml.cbProvDtCatastali.label')}" labelFor="widg_cbProvDtCatastali" errorFor="appDatacertificato.datiAnagraficiImm.dtCatastali.codProv" labelId="cbProvDtCatastaliLbl"
	position="first" colSpan="3" >


<!-- widget cbProvDtCatastali -->

<s:url id="widg_cbProvDtCatastaliurlComboBoxValueChange"
   action="/siceeweb/cpImportaXml!handleCbProvDtCatastali_VALUE_CHANGED" namespace="/base/compilazattestati"  
   includeParams="all" portletUrlType="action" 
/>
<s:select name="appDatacertificato.datiAnagraficiImm.dtCatastali.codProv" id="widg_cbProvDtCatastali"
	 
	

		title=" - Attenzione. Dopo aver selezionato un valore, la pagina verra' aggiornata automaticamente"
			
	  headerKey="" headerValue="" 
	  list="appDataprovinceCertDTCat"
	  disabled="isWidgetDisabled('cpImportaXml','cbProvDtCatastali')"
	  listKey="cod"
	  listValue="nome"
	  onclick="onCBClick(this,'confermacbProvDtCatastali','conferma','%{widg_cbProvDtCatastaliurlComboBoxValueChange}')" onfocus="inFocus(this)" onblur="lostFocus(this,'confermacbProvDtCatastali','conferma','%{widg_cbProvDtCatastaliurlComboBoxValueChange}')" 
	  />


	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpImportaXml','cbComDtCatastali')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpImportaXml.cbComDtCatastali.label')}" labelFor="widg_cbComDtCatastali" errorFor="appDatacertificato.datiAnagraficiImm.dtCatastali.codComune" labelId="cbComDtCatastaliLbl"
	position="first" colSpan="3" >


<!-- widget cbComDtCatastali -->

<s:url id="widg_cbComDtCatastaliurlComboBoxValueChange"
   action="/siceeweb/cpImportaXml!handleCbComDtCatastali_VALUE_CHANGED" namespace="/base/compilazattestati"  
   includeParams="all" portletUrlType="action" 
/>
<s:select name="appDatacertificato.datiAnagraficiImm.dtCatastali.codComune" id="widg_cbComDtCatastali"
	 
	

		title=" - Attenzione. Dopo aver selezionato un valore, la pagina verra' aggiornata automaticamente"
			
	  headerKey="" headerValue="" 
	  list="appDatacomuniCertDtCat"
	  disabled="isWidgetDisabled('cpImportaXml','cbComDtCatastali')"
	  listKey="cod"
	  listValue="nome"
	  onclick="onCBClick(this,'confermacbComDtCatastali','conferma','%{widg_cbComDtCatastaliurlComboBoxValueChange}')" onfocus="inFocus(this)" onblur="lostFocus(this,'confermacbComDtCatastali','conferma','%{widg_cbComDtCatastaliurlComboBoxValueChange}')" 
	  />


	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpImportaXml','tfGradiGiorno')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpImportaXml.tfGradiGiorno.label')}" labelFor="widg_tfGradiGiorno" errorFor="appDatacertificato.datiAnagraficiImm.dtCatastali.gradiGiorno" labelId="tfGradiGiornoLbl"
	position="first" colSpan="3" >


<!-- widget tfGradiGiorno -->
<s:textfield 
	
	
	name="appDatacertificato.datiAnagraficiImm.dtCatastali.gradiGiorno" id="widg_tfGradiGiorno"
maxlength="6"	disabled="isWidgetDisabled('cpImportaXml','tfGradiGiorno')"
	size="15" cssClass="numbers"
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_pDatiAggiuntivi --></div>

			
	
	<div id="p_cpEffettuaCalcoli" class="commandPanelBlock"><!-- startFragment:p_cpEffettuaCalcoli -->
	
	
<div class="commandPanel functional" id="cpEffettuaCalcoli">

	
	
		

	
	
	
	<div class="button left">
		
<s:if test="isWidgetVisible('cpImportaXml','btnAnnulla')" >

	



<!-- widget btnAnnulla -->
	<csiuicore:ajaxify id="p_pCenter" 
		widgetType="button"
		 
		requestUri="/siceeweb/base/compilazattestati/cpImportaXml!handleBtnAnnulla_CLICKED.do" 
		
		pageId="cpImportaXml" 
		formName="cpImportaXml"
		javascriptDetection="false">
<s:submit name="widg_btnAnnulla" id="widg_btnAnnulla" method="handleBtnAnnulla_CLICKED"
	key="cpImportaXml.btnAnnulla.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpImportaXml','btnAnnulla')" />

	</csiuicore:ajaxify>

	


</s:if>

	


	</div>
	
	

	
	
	
	

	
	
	
	<div class="button right">
		
<s:if test="isWidgetVisible('cpImportaXml','btnCalcoli')" >

	



<!-- widget btnCalcoli -->
	<csiuicore:ajaxify id="p_pCenter" 
		widgetType="button"
		 
		requestUri="/siceeweb/base/compilazattestati/cpImportaXml!handleBtnCalcoli_CLICKED.do" 
		
		pageId="cpImportaXml" 
		formName="cpImportaXml"
		javascriptDetection="false">
<s:submit name="widg_btnCalcoli" id="widg_btnCalcoli" method="handleBtnCalcoli_CLICKED"
	key="cpImportaXml.btnCalcoli.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpImportaXml','btnCalcoli')" />

	</csiuicore:ajaxify>

	


</s:if>

	


	</div>
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_cpEffettuaCalcoli --></div>

			
	
	<div id="p_pTable" class="widgetsPanelBlock"><!-- startFragment:p_pTable -->
	
	

<div class="widgetsPanel" id="pTable">
	

	
	
<s:if test="isWidgetVisible('cpImportaXml','tblXmlResult')" >

	
<div class="tableWidget">


<!-- widget tblXmlResult -->
<s:set name="cpImportaXml_tblXmlResult_clearStatus" value="isTableClearStatus('cpImportaXml_tblXmlResult')" />
<s:url id="cpImportaXmlViewUrl"						   
					   action="cpImportaXml"
					   namespace="/base/compilazattestati"/>
<display:table name="appDataxmlResult"  				
			   excludedParams="*"			   export="false"
               id="widg_tblXmlResult"
               pagesize="0"
               keepStatus="true"
               requestURI="${cpImportaXmlViewUrl}"  
               clearStatus="${cpImportaXml_tblXmlResult_clearStatus}"
               uid="row_tblXmlResult"
               summary="" 
decorator="it.csi.sicee.siceeweb.presentation.decorator.compilazattestati.CpImportaXmlTblXmlResultCustomDecorator"               class="dataTable">
	
		<display:column property="descrizione" titleKey="cpImportaXml.tblXmlResult.descrizione.label" 
			sortable="false" headerClass="nosort"
			    media="html"
			
 >
			
		</display:column>
		<display:column property="valoreXml" titleKey="cpImportaXml.tblXmlResult.valoreXml.label" 
			sortable="false" headerClass="nosort"
			    media="html"
			
 >
			
		</display:column>
		<display:column property="valoreCalcolato" titleKey="cpImportaXml.tblXmlResult.valoreCalcolato.label" 
			sortable="false" headerClass="nosort"
			    media="html"
			
 >
			
		</display:column>
		<display:column property="matched" titleKey="cpImportaXml.tblXmlResult.matched.label" 
			sortable="false" headerClass="nosort"
			    media="html"
			
 >
			
		</display:column>
</display:table>





	
</div>

</s:if>

	



	
	
	
</div>

	<!-- endFragment:p_pTable --></div>

			
	
	<div id="p_pRisultati" class="widgetsPanelBlock"><!-- startFragment:p_pRisultati -->
	
	

<div class="widgetsPanel" id="pRisultati">
	
	<customtag:widgetsPanel id="pRisultatiTbl" columns="2" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('cpImportaXml','rbImporta')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpImportaXml.rbImporta.label')}" labelFor="widg_rbImporta" errorFor="appDataesitoImportaXml" labelId="rbImportaLbl"
	  >


<!-- widget rbImporta -->

	
<div id="appDataesitoImportaXml" class="radiobuttons ">







<s:radio
	
	
	id="widg_rbbImportaSi" name="appDataesitoImportaXml"
	list="#{'S':'si'}"
	disabled="isWidgetDisabled('cpImportaXml','rbImporta')"
	cssClass="radio"
	
	/> <label  for="widg_rbbImportaSiS"><s:text name="cpImportaXml.rbImporta.rbbImportaSi.label" /></label>








<s:radio
	
	
	id="widg_rbbImportaNo" name="appDataesitoImportaXml"
	list="#{'N':'no'}"
	disabled="isWidgetDisabled('cpImportaXml','rbImporta')"
	cssClass="radio"
	
	/> <label  for="widg_rbbImportaNoN"><s:text name="cpImportaXml.rbImporta.rbbImportaNo.label" /></label>





	
</div>



	
</customtag:widgetsPanelColumn>

</s:if>

	



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_pRisultati --></div>

			
	
<div id="p_mbpNote" class="msgBoxPanelBlock"><!-- startFragment:p_mbpNote -->

		
<s:if test="isWidgetVisible('cpImportaXml','ptNote')" >

	
<p>


<!-- widget ptNote -->
<s:text name="cpImportaXml.ptNote.statictext.label" />

	
</p>

</s:if>

	

<!-- endFragment:p_mbpNote --></div>

			
	
	<div id="p_cpNavigazione" class="commandPanelBlock"><!-- startFragment:p_cpNavigazione -->
	
	
<div class="commandPanel navigation" id="cpNavigazione">

	
	
		

	
	
	
	<div class="button left">
		
<s:if test="isWidgetVisible('cpImportaXml','btnIndietro')" >

	



<!-- widget btnIndietro -->
	<csiuicore:ajaxify id="p_pCenter" 
		widgetType="button"
		 
		requestUri="/siceeweb/base/compilazattestati/cpImportaXml!handleBtnIndietro_CLICKED.do" 
		
		pageId="cpImportaXml" 
		formName="cpImportaXml"
		javascriptDetection="false">
<s:submit name="widg_btnIndietro" id="widg_btnIndietro" method="handleBtnIndietro_CLICKED"
	key="cpImportaXml.btnIndietro.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpImportaXml','btnIndietro')" />

	</csiuicore:ajaxify>

	


</s:if>

	


	</div>
	
	

	
	
	
	

	
	
	
	<div class="button right">
		
<s:if test="isWidgetVisible('cpImportaXml','btnConferma')" >

	



<!-- widget btnConferma -->
	<csiuicore:ajaxify id="p_pCenter" 
		widgetType="button"
		 
		requestUri="/siceeweb/base/compilazattestati/cpImportaXml!handleBtnConferma_CLICKED.do" 
		
		pageId="cpImportaXml" 
		formName="cpImportaXml"
		javascriptDetection="false">
<s:submit name="widg_btnConferma" id="widg_btnConferma" method="handleBtnConferma_CLICKED"
	key="cpImportaXml.btnConferma.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpImportaXml','btnConferma')" />

	</csiuicore:ajaxify>

	


</s:if>

	


	</div>
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_cpNavigazione --></div>

	

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
