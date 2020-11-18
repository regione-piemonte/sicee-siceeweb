<%@taglib uri="/struts-tags" prefix="s" %>
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="/customtag" prefix="customtag" %>
<%@taglib uri="/csiuicore" prefix="csiuicore" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<fmt:setBundle basename="/it/csi/sicee/siceeweb/presentation/siceeweb/action/gestcertificatore/CpTransazAction" />

	
	<div id="p_pAcquistoAce" class="formPanelBlock"><!-- startFragment:p_pAcquistoAce -->
		
	
<div class="formPanel" id="pAcquistoAce">


	
	

	
	
			
	
	<div id="p_pErrListTransAce" class="stdMessagePanelBlock"><!-- startFragment:p_pErrListTransAce -->
	
	
<div class="stdMessagePanel" id="pErrListTransAce">
	<customtag:stdMessagePanel id="pErrListTransAce" errorMessage="true" errorDetails="false" actionMessage="true" />
</div>

	<!-- endFragment:p_pErrListTransAce --></div>

			
	
	<div id="p_pListaAce" class="widgetsPanelBlock"><!-- startFragment:p_pListaAce -->
	
	

<div class="widgetsPanel" id="pListaAce">
	

	
	
<s:if test="isWidgetVisible('cpTransaz','transAce')" >

	
<div class="tableWidget">


<!-- widget transAce -->
<s:set name="cpTransaz_transAce_clearStatus" value="isTableClearStatus('cpTransaz_transAce')" />
<s:url id="cpTransazViewUrl"						   
					   action="cpTransaz"
					   namespace="/base/gestcertificatore"/>
<display:table name="appDatatransazioneAce"  				
			   excludedParams="*"			   export="false"
               id="widg_transAce"
               pagesize="10"
               keepStatus="true"
               requestURI="${cpTransazViewUrl}"  
               clearStatus="${cpTransaz_transAce_clearStatus}"
               uid="row_transAce"
               summary="" 
               class="dataTable">
	
		<display:column headerClass="nosort" media="html">
			<s:radio list="%{#attr.row_transAce.idTransazione}" name="appDataidTransazione" id="%{'transAce-editcell-'+ (#attr.row_transAce_rowNum - 1)}" cssClass="radio"
			/>
		</display:column>
		<display:column property="numeroTransazione" titleKey="cpTransaz.transAce.numeroTransazione.label" 
			sortable="true" headerClass="sortable"
			    media="html"
			
 >
			
		</display:column>
		<display:column property="dataTransazione" titleKey="cpTransaz.transAce.dataTransazione.label" 
			sortable="true" headerClass="sortable"
			    media="html"
			
 >
			
		</display:column>
		<display:column property="quantita" titleKey="cpTransaz.transAce.quantita.label" 
			sortable="false" headerClass="nosort"
			    media="html"
			
 >
			
		</display:column>
</display:table>





	
</div>

</s:if>

	



	
	
	
</div>

	<!-- endFragment:p_pListaAce --></div>

			
	
	<div id="p_pStampaRicevutaAce" class="commandPanelBlock"><!-- startFragment:p_pStampaRicevutaAce -->
	
	
<div class="commandPanel functional" id="pStampaRicevutaAce">

	
	
		

	
	
	
	

	
	
	
	

	
	
	
	<div class="button right">
		
<s:if test="isWidgetVisible('cpTransaz','bStampaRicevutaAce')" >

	



<!-- widget bStampaRicevutaAce -->
<s:submit name="widg_bStampaRicevutaAce" id="widg_bStampaRicevutaAce" method="handleBStampaRicevutaAce_CLICKED"
	key="cpTransaz.bStampaRicevutaAce.label" cssClass="buttonWidget showReport"
	disabled="isWidgetDisabled('cpTransaz','bStampaRicevutaAce')" />

	


</s:if>

	


	</div>
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_pStampaRicevutaAce --></div>

	

		
	
</div>

	<!-- endFragment:p_pAcquistoAce --></div>
