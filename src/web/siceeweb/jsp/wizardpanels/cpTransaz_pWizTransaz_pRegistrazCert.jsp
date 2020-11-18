<%@taglib uri="/struts-tags" prefix="s" %>
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="/customtag" prefix="customtag" %>
<%@taglib uri="/csiuicore" prefix="csiuicore" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<fmt:setBundle basename="/it/csi/sicee/siceeweb/presentation/siceeweb/action/gestcertificatore/CpTransazAction" />

	
	<div id="p_pRegistrazCert" class="formPanelBlock"><!-- startFragment:p_pRegistrazCert -->
		
	
<div class="formPanel" id="pRegistrazCert">


	
	

	
	
			
	
	<div id="p_pErrListTransReg" class="stdMessagePanelBlock"><!-- startFragment:p_pErrListTransReg -->
	
	
<div class="stdMessagePanel" id="pErrListTransReg">
	<customtag:stdMessagePanel id="pErrListTransReg" errorMessage="true" errorDetails="false" actionMessage="true" />
</div>

	<!-- endFragment:p_pErrListTransReg --></div>

			
	
	<div id="p_pListaReg" class="widgetsPanelBlock"><!-- startFragment:p_pListaReg -->
	
	

<div class="widgetsPanel" id="pListaReg">
	

	
	
<s:if test="isWidgetVisible('cpTransaz','transReg')" >

	
<div class="tableWidget">


<!-- widget transReg -->
<s:set name="cpTransaz_transReg_clearStatus" value="isTableClearStatus('cpTransaz_transReg')" />
<s:url id="cpTransazViewUrl"						   
					   action="cpTransaz"
					   namespace="/base/gestcertificatore"/>
<display:table name="appDatatransazioneRegistrazione"  				
			   excludedParams="*"			   export="false"
               id="widg_transReg"
               pagesize="10"
               keepStatus="true"
               requestURI="${cpTransazViewUrl}"  
               clearStatus="${cpTransaz_transReg_clearStatus}"
               uid="row_transReg"
               summary="" 
               class="dataTable">
	
		<display:column headerClass="nosort" media="html">
			<s:radio list="%{#attr.row_transReg.idTransazione}" name="appDataidTransazione" id="%{'transReg-editcell-'+ (#attr.row_transReg_rowNum - 1)}" cssClass="radio"
			/>
		</display:column>
		<display:column property="numeroTransazione" titleKey="cpTransaz.transReg.numeroTransazione.label" 
			sortable="true" headerClass="sortable"
			    media="html"
			
 >
			
		</display:column>
		<display:column property="dataTransazione" titleKey="cpTransaz.transReg.dataTransazione.label" 
			sortable="true" headerClass="sortable"
			    media="html"
			
 >
			
		</display:column>
</display:table>





	
</div>

</s:if>

	



	
	
	
</div>

	<!-- endFragment:p_pListaReg --></div>

			
	
	<div id="p_pStampaRicevutaReg" class="commandPanelBlock"><!-- startFragment:p_pStampaRicevutaReg -->
	
	
<div class="commandPanel functional" id="pStampaRicevutaReg">

	
	
		

	
	
	
	

	
	
	
	

	
	
	
	<div class="button right">
		
<s:if test="isWidgetVisible('cpTransaz','bStampaRicevutaReg')" >

	



<!-- widget bStampaRicevutaReg -->
<s:submit name="widg_bStampaRicevutaReg" id="widg_bStampaRicevutaReg" method="handleBStampaRicevutaReg_CLICKED"
	key="cpTransaz.bStampaRicevutaReg.label" cssClass="buttonWidget showReport"
	disabled="isWidgetDisabled('cpTransaz','bStampaRicevutaReg')" />

	


</s:if>

	


	</div>
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_pStampaRicevutaReg --></div>

	

		
	
</div>

	<!-- endFragment:p_pRegistrazCert --></div>
