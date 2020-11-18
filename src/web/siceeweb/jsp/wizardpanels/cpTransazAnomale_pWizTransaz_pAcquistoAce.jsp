<%@taglib uri="/struts-tags" prefix="s" %>
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="/customtag" prefix="customtag" %>
<%@taglib uri="/csiuicore" prefix="csiuicore" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<fmt:setBundle basename="/it/csi/sicee/siceeweb/presentation/siceeweb/action/gestcertificatore/CpTransazAnomaleAction" />

	
	<div id="p_pAcquistoAce" class="formPanelBlock"><!-- startFragment:p_pAcquistoAce -->
		
	
<div class="formPanel" id="pAcquistoAce">


	
	

	
	
			
	
	<div id="p_pErrListTransAce" class="stdMessagePanelBlock"><!-- startFragment:p_pErrListTransAce -->
	
	
<div class="stdMessagePanel" id="pErrListTransAce">
	<customtag:stdMessagePanel id="pErrListTransAce" errorMessage="true" errorDetails="false" actionMessage="true" />
</div>

	<!-- endFragment:p_pErrListTransAce --></div>

			
	
	<div id="p_pListaAce" class="widgetsPanelBlock"><!-- startFragment:p_pListaAce -->
	
	

<div class="widgetsPanel" id="pListaAce">
	

	
	
<s:if test="isWidgetVisible('cpTransazAnomale','transAce')" >

	
<div class="tableWidget">


<!-- widget transAce -->
<s:set name="cpTransazAnomale_transAce_clearStatus" value="isTableClearStatus('cpTransazAnomale_transAce')" />
<s:url id="cpTransazAnomaleViewUrl"						   
					   action="cpTransazAnomale"
					   namespace="/base/gestcertificatore"/>
<display:table name="appDatatransazioneAce"  				
			   excludedParams="*"			   export="false"
               id="widg_transAce"
               pagesize="10"
               keepStatus="true"
               requestURI="${cpTransazAnomaleViewUrl}"  
               clearStatus="${cpTransazAnomale_transAce_clearStatus}"
               uid="row_transAce"
               summary="" 
               class="dataTable">
	
		<display:column headerClass="nosort" media="html">
			<s:radio list="%{#attr.row_transAce.idTransazione}" name="appDataidTransazione" id="%{'transAce-editcell-'+ (#attr.row_transAce_rowNum - 1)}" cssClass="radio"
			/>
		</display:column>
		<display:column property="numeroTransazione" titleKey="cpTransazAnomale.transAce.numeroTransazione.label" 
			sortable="true" headerClass="sortable"
			    media="html"
			
 >
			
		</display:column>
		<display:column property="dataTransazione" titleKey="cpTransazAnomale.transAce.dataTransazione.label" 
			sortable="true" headerClass="sortable"
			    media="html"
			
 >
			
		</display:column>
		<display:column property="quantita" titleKey="cpTransazAnomale.transAce.quantita.label" 
			sortable="false" headerClass="nosort"
			    media="html"
			
 >
			
		</display:column>
</display:table>





	
</div>

</s:if>

	



	
	
	
</div>

	<!-- endFragment:p_pListaAce --></div>

			
	
	<div id="p_pVerificaAce" class="commandPanelBlock"><!-- startFragment:p_pVerificaAce -->
	
	
<div class="commandPanel functional" id="pVerificaAce">

	
	
		

	
	
	
	

	
	
	
	

	
	
	
	<div class="button right">
		
<s:if test="isWidgetVisible('cpTransazAnomale','bVerificaTransazioneAce')" >

	



<!-- widget bVerificaTransazioneAce -->
	<csiuicore:ajaxify id="p_pErrListTransAce" 
		widgetType="button"
		 
		requestUri="/siceeweb/base/gestcertificatore/cpTransazAnomale!handleBVerificaTransazioneAce_CLICKED.do" 
		
		pageId="cpTransazAnomale" 
		formName="cpTransazAnomale"
		javascriptDetection="false">
<s:submit name="widg_bVerificaTransazioneAce" id="widg_bVerificaTransazioneAce" method="handleBVerificaTransazioneAce_CLICKED"
	key="cpTransazAnomale.bVerificaTransazioneAce.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpTransazAnomale','bVerificaTransazioneAce')" />

	</csiuicore:ajaxify>

	


</s:if>

	


	</div>
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_pVerificaAce --></div>

	

		
	
</div>

	<!-- endFragment:p_pAcquistoAce --></div>
