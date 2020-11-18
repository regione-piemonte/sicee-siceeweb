<%@taglib uri="/struts-tags" prefix="s" %>
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="/customtag" prefix="customtag" %>
<%@taglib uri="/csiuicore" prefix="csiuicore" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<fmt:setBundle basename="/it/csi/sicee/siceeweb/presentation/siceeweb/action/compilazattestati/CpCompilazAction" />

	
	<div id="p_pDatiAltriRaccomand" class="formPanelBlock"><!-- startFragment:p_pDatiAltriRaccomand -->
		
	
<div class="formPanel" id="pDatiAltriRaccomand">


	
	

	
	
			
	
	<div id="p_pErrDtAltriRaccomand" class="stdMessagePanelBlock"><!-- startFragment:p_pErrDtAltriRaccomand -->
	
	
<div class="stdMessagePanel" id="pErrDtAltriRaccomand">
	<customtag:stdMessagePanel id="pErrDtAltriRaccomand" errorMessage="true" errorDetails="false" actionMessage="true" />
</div>

	<!-- endFragment:p_pErrDtAltriRaccomand --></div>

			
	
	<div id="p_pDtAltriRaccomand1" class="widgetsPanelBlock"><!-- startFragment:p_pDtAltriRaccomand1 -->
	
	

<div class="widgetsPanel" id="pDtAltriRaccomand1">
	
	<customtag:widgetsPanel id="pDtAltriRaccomand1Tbl" columns="2" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('cpCompilaz','txtObblAltriRaccomand')" >

	
<customtag:widgetsPanelColumn  colSpan="2"  >


<!-- widget txtObblAltriRaccomand -->
<s:text name="cpCompilaz.txtObblAltriRaccomand.statictext.label" />

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpCompilaz','cbSistema')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpCompilaz.cbSistema.label')}" labelFor="widg_cbSistema" errorFor="widg_cbSistema" labelId="cbSistemaLbl"
	  >


<!-- widget cbSistema -->
<s:select name="widg_cbSistema" id="widg_cbSistema"
	 
	
		title=""
			
	  headerKey="" headerValue="" 
	  list="appDatasistemi"
	  disabled="isWidgetDisabled('cpCompilaz','cbSistema')"
	  listKey="cod"
	  listValue="descr"
	  
	  />


	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpCompilaz','tfIntervento')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpCompilaz.tfIntervento.label')}" labelFor="widg_tfIntervento" errorFor="widg_tfIntervento" labelId="tfInterventoLbl"
	  >


<!-- widget tfIntervento -->
<s:textfield 
	
	
	name="widg_tfIntervento" id="widg_tfIntervento"
maxlength="60"	disabled="isWidgetDisabled('cpCompilaz','tfIntervento')"
	size="50" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpCompilaz','rbsPriorita')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpCompilaz.rbsPriorita.label')}" labelFor="widg_rbsPriorita" errorFor="widg_rbsPriorita" labelId="rbsPrioritaLbl"
	  >


<!-- widget rbsPriorita -->

	
<div id="widg_rbsPriorita" class="radiobuttons ">







<s:radio
	
	
	id="widg_rbAlta" name="widg_rbsPriorita"
	list="#{'1 - ALTA':'alta'}"
	disabled="isWidgetDisabled('cpCompilaz','rbsPriorita')"
	cssClass="radio"
	
	/> <label  for="widg_rbAlta1 - ALTA"><s:text name="cpCompilaz.rbsPriorita.rbAlta.label" /></label>








<s:radio
	
	
	id="widg_rbMedia" name="widg_rbsPriorita"
	list="#{'2 - MEDIA':'media'}"
	disabled="isWidgetDisabled('cpCompilaz','rbsPriorita')"
	cssClass="radio"
	
	/> <label  for="widg_rbMedia2 - MEDIA"><s:text name="cpCompilaz.rbsPriorita.rbMedia.label" /></label>








<s:radio
	
	
	id="widg_rbBassa" name="widg_rbsPriorita"
	list="#{'3 - BASSA':'bassa'}"
	disabled="isWidgetDisabled('cpCompilaz','rbsPriorita')"
	cssClass="radio"
	
	/> <label  for="widg_rbBassa3 - BASSA"><s:text name="cpCompilaz.rbsPriorita.rbBassa.label" /></label>





	
</div>



	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpCompilaz','tfTempoRitorno')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpCompilaz.tfTempoRitorno.label')}" labelFor="widg_tfTempoRitorno" errorFor="widg_tfTempoRitorno" labelId="tfTempoRitornoLbl"
	  >


<!-- widget tfTempoRitorno -->
<s:textfield 
	
	
	name="widg_tfTempoRitorno" id="widg_tfTempoRitorno"
maxlength="10"	disabled="isWidgetDisabled('cpCompilaz','tfTempoRitorno')"
	size="50" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpCompilaz','cbEdificioPerformante')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpCompilaz.cbEdificioPerformante.label')}" labelFor="widg_cbEdificioPerformante" errorFor="appDatacertificato.altreInfo.flgEdificioPerformante" labelId="cbEdificioPerformanteLbl"
	  >


<!-- widget cbEdificioPerformante -->
<s:checkbox 
	
	
	name="appDatacertificato.altreInfo.flgEdificioPerformante" id="widg_cbEdificioPerformante"
	disabled="isWidgetDisabled('cpCompilaz','cbEdificioPerformante')"
	cssClass="checkbox"
	
	/> 
<s:if test="!isWidgetDisabled('cpCompilaz','cbEdificioPerformante')" >
	<s:hidden name="__checkbox_appDatacertificato.altreInfo.flgEdificioPerformante" id="__checkbox_widg_cbEdificioPerformante" />
</s:if>

	
</customtag:widgetsPanelColumn>

</s:if>

	



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_pDtAltriRaccomand1 --></div>

			
	
	<div id="p_pCmdRaccomand1" class="commandPanelBlock"><!-- startFragment:p_pCmdRaccomand1 -->
	
	
<div class="commandPanel functional" id="pCmdRaccomand1">

	
	
		

	
	
	
	<div class="button left">
		
<s:if test="isWidgetVisible('cpCompilaz','bAddRaccomand')" >

	



<!-- widget bAddRaccomand -->
	<csiuicore:ajaxify id="p_pCenter,p_pWizCompilazLiv1" 
		widgetType="button"
		 
		requestUri="/siceeweb/base/compilazattestati/cpCompilaz!handleBAddRaccomand_CLICKED.do" 
		
		pageId="cpCompilaz" 
		formName="cpCompilaz"
		javascriptDetection="false">
<s:submit name="widg_bAddRaccomand" id="widg_bAddRaccomand" method="handleBAddRaccomand_CLICKED"
	key="cpCompilaz.bAddRaccomand.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpCompilaz','bAddRaccomand')" />

	</csiuicore:ajaxify>

	


</s:if>

	


	</div>
	
	

	
	
	
	

	
	
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_pCmdRaccomand1 --></div>

			
	
	<div id="p_pDtAltriRaccomand2" class="widgetsPanelBlock"><!-- startFragment:p_pDtAltriRaccomand2 -->
	
	

<div class="widgetsPanel" id="pDtAltriRaccomand2">
	

	
	
<s:if test="isWidgetVisible('cpCompilaz','tblRaccomandazioni')" >

	
<div class="tableWidget">


<!-- widget tblRaccomandazioni -->
<s:set name="cpCompilaz_tblRaccomandazioni_clearStatus" value="isTableClearStatus('cpCompilaz_tblRaccomandazioni')" />
<s:url id="cpCompilazViewUrl"						   
					   action="cpCompilaz"
					   namespace="/base/compilazattestati"/>
<display:table name="appDatatempRaccomandazioni"  				
			   excludedParams="*"			   export="false"
               id="widg_tblRaccomandazioni"
               pagesize="0"
               keepStatus="true"
               requestURI="${cpCompilazViewUrl}"  
               clearStatus="${cpCompilaz_tblRaccomandazioni_clearStatus}"
               uid="row_tblRaccomandazioni"
               summary="" 
               class="dataTable">
	
		<display:column headerClass="nosort" media="html">
			<s:radio list="%{#attr.row_tblRaccomandazioni.id}" name="appDataraccomandazioneSelezionata" id="%{'tblRaccomandazioni-editcell-'+ (#attr.row_tblRaccomandazioni_rowNum - 1)}" cssClass="radio"
			/>
		</display:column>
		<display:column property="codSistema" titleKey="cpCompilaz.tblRaccomandazioni.codSistema.label" 
			sortable="false" headerClass="nosort"
			    media="html"
			
 >
			
		</display:column>
		<display:column property="intervento" titleKey="cpCompilaz.tblRaccomandazioni.intervento.label" 
			sortable="false" headerClass="nosort"
			    media="html"
			
 >
			
		</display:column>
		<display:column property="descrPriorita" titleKey="cpCompilaz.tblRaccomandazioni.descrPriorita.label" 
			sortable="false" headerClass="nosort"
			    media="html"
			
 >
			
		</display:column>
		<display:column property="tempoRitorno" titleKey="cpCompilaz.tblRaccomandazioni.tempoRitorno.label" 
			sortable="false" headerClass="nosort"
			    media="html"
			
 >
			
		</display:column>
</display:table>





	
</div>

</s:if>

	



	
	
	
</div>

	<!-- endFragment:p_pDtAltriRaccomand2 --></div>

			
	
	<div id="p_pCmdRaccomand2" class="commandPanelBlock"><!-- startFragment:p_pCmdRaccomand2 -->
	
	
<div class="commandPanel functional" id="pCmdRaccomand2">

	
	
		

	
	
	
	<div class="button left">
		
<s:if test="isWidgetVisible('cpCompilaz','bDelRaccomand')" >

	



<!-- widget bDelRaccomand -->
	<csiuicore:ajaxify id="p_pWizCompilazLiv1" 
		widgetType="button"
		 
		requestUri="/siceeweb/base/compilazattestati/cpCompilaz!handleBDelRaccomand_CLICKED.do" 
		
		pageId="cpCompilaz" 
		formName="cpCompilaz"
		javascriptDetection="false">
<s:submit name="widg_bDelRaccomand" id="widg_bDelRaccomand" method="handleBDelRaccomand_CLICKED"
	key="cpCompilaz.bDelRaccomand.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpCompilaz','bDelRaccomand')" />

	</csiuicore:ajaxify>

	


</s:if>

	


	</div>
	
	

	
	
	
	

	
	
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_pCmdRaccomand2 --></div>

			
	
	<div id="p_pDtAltriRaccomandNav" class="commandPanelBlock"><!-- startFragment:p_pDtAltriRaccomandNav -->
	
	
<div class="commandPanel navigation" id="pDtAltriRaccomandNav">

	
	
		

	
	
	
	<div class="button left">
		
<s:if test="isWidgetVisible('cpCompilaz','bDtAltriRaccomandIndietro')" >

	



<!-- widget bDtAltriRaccomandIndietro -->
	<csiuicore:ajaxify id="p_pWizCompilazLiv1" 
		widgetType="button"
		 
		requestUri="/siceeweb/base/compilazattestati/cpCompilaz!handleBDtAltriRaccomandIndietro_CLICKED.do" 
		
		pageId="cpCompilaz" 
		formName="cpCompilaz"
		javascriptDetection="false">
<s:submit name="widg_bDtAltriRaccomandIndietro" id="widg_bDtAltriRaccomandIndietro" method="handleBDtAltriRaccomandIndietro_CLICKED"
	key="cpCompilaz.bDtAltriRaccomandIndietro.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpCompilaz','bDtAltriRaccomandIndietro')" />

	</csiuicore:ajaxify>

	


</s:if>

	


	</div>
	
	

	
	
	
	

	
	
	
	<div class="button right">
		
<s:if test="isWidgetVisible('cpCompilaz','bDtAltriRaccomandAvanti')" >

	



<!-- widget bDtAltriRaccomandAvanti -->
	<csiuicore:ajaxify id="p_pWizCompilazLiv1" 
		widgetType="button"
		 
		requestUri="/siceeweb/base/compilazattestati/cpCompilaz!handleBDtAltriRaccomandAvanti_CLICKED.do" 
		
		pageId="cpCompilaz" 
		formName="cpCompilaz"
		javascriptDetection="false">
<s:submit name="widg_bDtAltriRaccomandAvanti" id="widg_bDtAltriRaccomandAvanti" method="handleBDtAltriRaccomandAvanti_CLICKED"
	key="cpCompilaz.bDtAltriRaccomandAvanti.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpCompilaz','bDtAltriRaccomandAvanti')" />

	</csiuicore:ajaxify>

	


</s:if>

	


	</div>
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_pDtAltriRaccomandNav --></div>

	

		
	
</div>

	<!-- endFragment:p_pDatiAltriRaccomand --></div>
