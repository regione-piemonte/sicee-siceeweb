<%@taglib uri="/struts-tags" prefix="s" %>
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="/customtag" prefix="customtag" %>
<%@taglib uri="/csiuicore" prefix="csiuicore" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<fmt:setBundle basename="/it/csi/sicee/siceeweb/presentation/siceeweb/action/gestcertificatore/CpTransazAction" />

	
	<div id="p_pAcquistoCrediti" class="formPanelBlock"><!-- startFragment:p_pAcquistoCrediti -->
		
	


	
	

	
	
			
	
	<div id="p_pErrListCrediti" class="stdMessagePanelBlock"><!-- startFragment:p_pErrListCrediti -->
	
	
<div class="stdMessagePanel" id="pErrListCrediti">
	<customtag:stdMessagePanel id="pErrListCrediti" errorMessage="true" errorDetails="false" actionMessage="true" />
</div>

	<!-- endFragment:p_pErrListCrediti --></div>

			
	
	<div id="p_pFiltro" class="widgetsPanelBlock"><!-- startFragment:p_pFiltro -->
	
	
<h4 class="wpLabel">Filtro lista transazioni in attesa </h4>
<div class="widgetsPanel" id="pFiltro">
	
	<customtag:widgetsPanel id="pFiltroTbl" columns="2" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('cpTransaz','cbTipoRic')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpTransaz.cbTipoRic.label')}" labelFor="widg_cbTipoRic" errorFor="appDatacodRicercaTransazioniNewSelez" labelId="cbTipoRicLbl"
	  >


<!-- widget cbTipoRic -->

<s:url id="widg_cbTipoRicurlComboBoxValueChange"
   action="/siceeweb/cpTransaz!handleCbTipoRic_VALUE_CHANGED" namespace="/base/gestcertificatore"  
   includeParams="all" portletUrlType="action" 
/>
<s:select name="appDatacodRicercaTransazioniNewSelez" id="widg_cbTipoRic"
	 
	

		title=" - Attenzione. Dopo aver selezionato un valore, la pagina verra' aggiornata automaticamente"
			
	  headerKey="" headerValue="" 
	  list="appDatatipoRicercaTransazioniNew"
	  disabled="isWidgetDisabled('cpTransaz','cbTipoRic')"
	  listKey="value"
	  listValue="label"
	  onclick="onCBClick(this,'confermacbTipoRic','conferma','%{widg_cbTipoRicurlComboBoxValueChange}')" onfocus="inFocus(this)" onblur="lostFocus(this,'confermacbTipoRic','conferma','%{widg_cbTipoRicurlComboBoxValueChange}')" 
	  />


	
</customtag:widgetsPanelColumn>

</s:if>

	



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_pFiltro --></div>

			
	
	<div id="p_pListaCrediti" class="widgetsPanelBlock"><!-- startFragment:p_pListaCrediti -->
	
	

<div class="widgetsPanel" id="pListaCrediti">
	

	
	
<s:if test="isWidgetVisible('cpTransaz','transCredito')" >

	
<div class="tableWidget">


<!-- widget transCredito -->
<s:set name="cpTransaz_transCredito_clearStatus" value="isTableClearStatus('cpTransaz_transCredito')" />
<s:url id="cpTransazViewUrl"						   
					   action="cpTransaz"
					   namespace="/base/gestcertificatore"/>
<display:table name="appDatatransazioneCredito"  				
			   excludedParams="*"			   export="false"
               id="widg_transCredito"
               pagesize="10"
               keepStatus="true"
               requestURI="${cpTransazViewUrl}"  
               clearStatus="${cpTransaz_transCredito_clearStatus}"
               uid="row_transCredito"
               summary="" 
               class="dataTable">
	
		<display:column headerClass="nosort" media="html">
			<s:radio list="%{#attr.row_transCredito.idCredito}" name="appDataidTransazione" id="%{'transCredito-editcell-'+ (#attr.row_transCredito_rowNum - 1)}" cssClass="radio"
			/>
		</display:column>
		<display:column property="valoreCreditoIniziale" titleKey="cpTransaz.transCredito.valoreCreditoIniziale.label" 
			sortable="false" headerClass="nosort"
			format="{0,number,#,##0.00}"  class="numbers"  media="html"
			
 >
			
		</display:column>
		<display:column property="valoreOperazione" titleKey="cpTransaz.transCredito.valoreOperazione.label" 
			sortable="false" headerClass="nosort"
			format="{0,number,#,##0.00}"  class="numbers"  media="html"
			
 >
			
		</display:column>
		<display:column property="valoreCreditoFinale" titleKey="cpTransaz.transCredito.valoreCreditoFinale.label" 
			sortable="false" headerClass="nosort"
			format="{0,number,#,##0.00}"  class="numbers"  media="html"
			
 >
			
		</display:column>
		<display:column property="dataOperazione" titleKey="cpTransaz.transCredito.dataOperazione.label" 
			sortable="false" headerClass="nosort"
			    media="html"
			
 >
			
		</display:column>
		<display:column property="descrizioneOperazione" titleKey="cpTransaz.transCredito.descrizioneOperazione.label" 
			sortable="false" headerClass="nosort"
			    media="html"
			
 >
			
		</display:column>
</display:table>





	
</div>

</s:if>

	



	
	
	
</div>

	<!-- endFragment:p_pListaCrediti --></div>

			
	
	<div id="p_pVerificaCrediti" class="commandPanelBlock"><!-- startFragment:p_pVerificaCrediti -->
	
	
<div class="commandPanel functional" id="pVerificaCrediti">

	
	
		

	
	
	
	<div class="button left">
		
<s:if test="isWidgetVisible('cpTransaz','bRicaricaCredito')" >

	



<!-- widget bRicaricaCredito -->
<s:submit name="widg_bRicaricaCredito" id="widg_bRicaricaCredito" method="handleBRicaricaCredito_CLICKED"
	key="cpTransaz.bRicaricaCredito.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpTransaz','bRicaricaCredito')" />

	


</s:if>

	


		
<s:if test="isWidgetVisible('cpTransaz','bDettRicarica')" >

	



<!-- widget bDettRicarica -->
<s:submit name="widg_bDettRicarica" id="widg_bDettRicarica" method="handleBDettRicarica_CLICKED"
	key="cpTransaz.bDettRicarica.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpTransaz','bDettRicarica')" />

	


</s:if>

	


		
<s:if test="isWidgetVisible('cpTransaz','bGeneraApe')" >

	



<!-- widget bGeneraApe -->
<s:submit name="widg_bGeneraApe" id="widg_bGeneraApe" method="handleBGeneraApe_CLICKED"
	key="cpTransaz.bGeneraApe.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpTransaz','bGeneraApe')" />

	


</s:if>

	


		
<s:if test="isWidgetVisible('cpTransaz','bPagaIscrizioneAnnuale')" >

	



<!-- widget bPagaIscrizioneAnnuale -->
<s:submit name="widg_bPagaIscrizioneAnnuale" id="widg_bPagaIscrizioneAnnuale" method="handleBPagaIscrizioneAnnuale_CLICKED"
	key="cpTransaz.bPagaIscrizioneAnnuale.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpTransaz','bPagaIscrizioneAnnuale')" />

	


</s:if>

	


		
<s:if test="isWidgetVisible('cpTransaz','bListaRT')" >

	



<!-- widget bListaRT -->
<s:submit name="widg_bListaRT" id="widg_bListaRT" method="handleBListaRT_CLICKED"
	key="cpTransaz.bListaRT.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpTransaz','bListaRT')" />

	


</s:if>

	


		
<s:if test="isWidgetVisible('cpTransaz','bRicevutaApe')" >

	



<!-- widget bRicevutaApe -->
<s:submit name="widg_bRicevutaApe" id="widg_bRicevutaApe" method="handleBRicevutaApe_CLICKED"
	key="cpTransaz.bRicevutaApe.label" cssClass="buttonWidget showReport"
	disabled="isWidgetDisabled('cpTransaz','bRicevutaApe')" />

	


</s:if>

	


	</div>
	
	

	
	
	
	

	
	
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_pVerificaCrediti --></div>

			
	
	
	<div id="p_mpGeneraApe" class="panelBlock"><!-- startFragment:p_mpGeneraApe -->
		

		
<s:if test="#session.cpTransaz_mpGeneraApe_selectedMultiPanel == 'cpTransaz_mpGeneraApe_fpGeneraApe'">
	<s:include value="/jsp/multipanels/cpTransaz_mpGeneraApe_fpGeneraApe.jsp" ></s:include>
</s:if>
	<!-- endFragment:p_mpGeneraApe --></div>

	

		
	

	<!-- endFragment:p_pAcquistoCrediti --></div>
