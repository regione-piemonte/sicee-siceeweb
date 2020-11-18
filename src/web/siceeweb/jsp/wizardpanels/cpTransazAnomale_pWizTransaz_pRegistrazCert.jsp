<%@taglib uri="/struts-tags" prefix="s" %>
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="/customtag" prefix="customtag" %>
<%@taglib uri="/csiuicore" prefix="csiuicore" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<fmt:setBundle basename="/it/csi/sicee/siceeweb/presentation/siceeweb/action/gestcertificatore/CpTransazAnomaleAction" />

	
	<div id="p_pRegistrazCert" class="formPanelBlock"><!-- startFragment:p_pRegistrazCert -->
		
	
<div class="formPanel" id="pRegistrazCert">


	
	

	
	
			
	
	<div id="p_pErrListTransReg" class="stdMessagePanelBlock"><!-- startFragment:p_pErrListTransReg -->
	
	
<div class="stdMessagePanel" id="pErrListTransReg">
	<customtag:stdMessagePanel id="pErrListTransReg" errorMessage="true" errorDetails="false" actionMessage="true" />
</div>

	<!-- endFragment:p_pErrListTransReg --></div>

			
	
	<div id="p_pListaReg" class="widgetsPanelBlock"><!-- startFragment:p_pListaReg -->
	
	

<div class="widgetsPanel" id="pListaReg">
	

	
	
<s:if test="isWidgetVisible('cpTransazAnomale','transReg')" >

	
<div class="tableWidget">


<!-- widget transReg -->
<s:set name="cpTransazAnomale_transReg_clearStatus" value="isTableClearStatus('cpTransazAnomale_transReg')" />
<s:url id="cpTransazAnomaleViewUrl"						   
					   action="cpTransazAnomale"
					   namespace="/base/gestcertificatore"/>
<display:table name="appDatatransazioneRegistrazione"  				
			   excludedParams="*"			   export="false"
               id="widg_transReg"
               pagesize="10"
               keepStatus="true"
               requestURI="${cpTransazAnomaleViewUrl}"  
               clearStatus="${cpTransazAnomale_transReg_clearStatus}"
               uid="row_transReg"
               summary="" 
               class="dataTable">
	
		<display:column headerClass="nosort" media="html">
			<s:radio list="%{#attr.row_transReg.idTransazione}" name="appDataidTransazione" id="%{'transReg-editcell-'+ (#attr.row_transReg_rowNum - 1)}" cssClass="radio"
			/>
		</display:column>
		<display:column property="numeroTransazione" titleKey="cpTransazAnomale.transReg.numeroTransazione.label" 
			sortable="true" headerClass="sortable"
			    media="html"
			
 >
			
		</display:column>
		<display:column property="dataTransazione" titleKey="cpTransazAnomale.transReg.dataTransazione.label" 
			sortable="true" headerClass="sortable"
			    media="html"
			
 >
			
		</display:column>
</display:table>





	
</div>

</s:if>

	



	
	
	
</div>

	<!-- endFragment:p_pListaReg --></div>

			
	
	<div id="p_pVerificaReg" class="commandPanelBlock"><!-- startFragment:p_pVerificaReg -->
	
	
<div class="commandPanel functional" id="pVerificaReg">

	
	
		

	
	
	
	

	
	
	
	

	
	
	
	<div class="button right">
		
<s:if test="isWidgetVisible('cpTransazAnomale','bVerificaTransazioneReg')" >

	



<!-- widget bVerificaTransazioneReg -->
	<csiuicore:ajaxify id="p_pErrListTransReg" 
		widgetType="button"
		 
		requestUri="/siceeweb/base/gestcertificatore/cpTransazAnomale!handleBVerificaTransazioneReg_CLICKED.do" 
		
		pageId="cpTransazAnomale" 
		formName="cpTransazAnomale"
		javascriptDetection="false">
<s:submit name="widg_bVerificaTransazioneReg" id="widg_bVerificaTransazioneReg" method="handleBVerificaTransazioneReg_CLICKED"
	key="cpTransazAnomale.bVerificaTransazioneReg.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpTransazAnomale','bVerificaTransazioneReg')" />

	</csiuicore:ajaxify>

	


</s:if>

	


	</div>
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_pVerificaReg --></div>

	

		
	
</div>

	<!-- endFragment:p_pRegistrazCert --></div>
