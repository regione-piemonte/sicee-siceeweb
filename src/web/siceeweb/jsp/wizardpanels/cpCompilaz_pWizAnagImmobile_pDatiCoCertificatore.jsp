<%@taglib uri="/struts-tags" prefix="s" %>
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="/customtag" prefix="customtag" %>
<%@taglib uri="/csiuicore" prefix="csiuicore" %>

	
	<div id="p_pDatiCoCertificatore" class="formPanelBlock"><!-- startFragment:p_pDatiCoCertificatore -->
		
	
<div class="formPanel" id="pDatiCoCertificatore">


	
	

	
	
			
	
	<div id="p_pErrDtCoCertificatore" class="stdMessagePanelBlock"><!-- startFragment:p_pErrDtCoCertificatore -->
	
	
<div class="stdMessagePanel" id="pErrDtCoCertificatore">
	<customtag:stdMessagePanel id="pErrDtCoCertificatore" errorMessage="true" errorDetails="false" actionMessage="true" />
</div>

	<!-- endFragment:p_pErrDtCoCertificatore --></div>

			
	
	<div id="p_pDtCoCertificatore" class="widgetsPanelBlock"><!-- startFragment:p_pDtCoCertificatore -->
	
	

<div class="widgetsPanel" id="pDtCoCertificatore">
	
	<customtag:widgetsPanel id="pDtCoCertificatoreTbl" columns="2" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('cpCompilaz','tfNome')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpCompilaz.tfNome.label')}" labelFor="widg_tfNome" errorFor="appDatacertificato.datiAnagraficiImm.dtCoCertificatore.nome" labelId="tfNomeLbl"
	  >


<!-- widget tfNome -->
<s:textfield 
	
	
	name="appDatacertificato.datiAnagraficiImm.dtCoCertificatore.nome" id="widg_tfNome"
maxlength="20"	disabled="isWidgetDisabled('cpCompilaz','tfNome')"
	size="50" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpCompilaz','tfCognomeCoCertificatore')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpCompilaz.tfCognomeCoCertificatore.label')}" labelFor="widg_tfCognomeCoCertificatore" errorFor="appDatacertificato.datiAnagraficiImm.dtCoCertificatore.cognome" labelId="tfCognomeCoCertificatoreLbl"
	  >


<!-- widget tfCognomeCoCertificatore -->
<s:textfield 
	
	
	name="appDatacertificato.datiAnagraficiImm.dtCoCertificatore.cognome" id="widg_tfCognomeCoCertificatore"
maxlength="50"	disabled="isWidgetDisabled('cpCompilaz','tfCognomeCoCertificatore')"
	size="50" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpCompilaz','tfMatrElencoRegCoCertificatore')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpCompilaz.tfMatrElencoRegCoCertificatore.label')}" labelFor="widg_tfMatrElencoRegCoCertificatore" errorFor="appDatacertificato.datiAnagraficiImm.dtCoCertificatore.numMatricola" labelId="tfMatrElencoRegCoCertificatoreLbl"
	  >


<!-- widget tfMatrElencoRegCoCertificatore -->
<s:textfield 
	
	
	name="appDatacertificato.datiAnagraficiImm.dtCoCertificatore.numMatricola" id="widg_tfMatrElencoRegCoCertificatore"
maxlength="6"	disabled="isWidgetDisabled('cpCompilaz','tfMatrElencoRegCoCertificatore')"
	size="50" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_pDtCoCertificatore --></div>

			
	
	<div id="p_pDtCoCertificatoreNav" class="commandPanelBlock"><!-- startFragment:p_pDtCoCertificatoreNav -->
	
	
<div class="commandPanel navigation" id="pDtCoCertificatoreNav">

	
	
		

	
	
	
	<div class="button left">
		
<s:if test="isWidgetVisible('cpCompilaz','bDtCoCertificatoreIndietro')" >

	



<!-- widget bDtCoCertificatoreIndietro -->
<s:submit name="widg_bDtCoCertificatoreIndietro" id="widg_bDtCoCertificatoreIndietro" method="handleBDtCoCertificatoreIndietro_CLICKED"
	key="cpCompilaz.bDtCoCertificatoreIndietro.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpCompilaz','bDtCoCertificatoreIndietro')" />

	


</s:if>

	


	</div>
	
	

	
	
	
	

	
	
	
	<div class="button right">
		
<s:if test="isWidgetVisible('cpCompilaz','bDtCertificatoreAvanti')" >

	



<!-- widget bDtCertificatoreAvanti -->
	<csiuicore:ajaxify id="p_pWizCompilazLiv1" 
		widgetType="button"
		 
		requestUri="/siceeweb/base/compilazattestati/cpCompilaz!handleBDtCertificatoreAvanti_CLICKED.do" 
		
		pageId="cpCompilaz" 
		formName="cpCompilaz"
		javascriptDetection="false">
<s:submit name="widg_bDtCertificatoreAvanti" id="widg_bDtCertificatoreAvanti" method="handleBDtCertificatoreAvanti_CLICKED"
	key="cpCompilaz.bDtCertificatoreAvanti.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpCompilaz','bDtCertificatoreAvanti')" />

	</csiuicore:ajaxify>

	


</s:if>

	


	</div>
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_pDtCoCertificatoreNav --></div>

	

		
	
</div>

	<!-- endFragment:p_pDatiCoCertificatore --></div>
