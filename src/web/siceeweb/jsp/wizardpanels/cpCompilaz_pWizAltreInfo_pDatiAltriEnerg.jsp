<%@taglib uri="/struts-tags" prefix="s" %>
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="/customtag" prefix="customtag" %>
<%@taglib uri="/csiuicore" prefix="csiuicore" %>

	
	<div id="p_pDatiAltriEnerg" class="formPanelBlock"><!-- startFragment:p_pDatiAltriEnerg -->
		
	
<div class="formPanel" id="pDatiAltriEnerg">


	
	

	
	
			
	
	<div id="p_pErrDtAltriEnerg" class="stdMessagePanelBlock"><!-- startFragment:p_pErrDtAltriEnerg -->
	
	
<div class="stdMessagePanel" id="pErrDtAltriEnerg">
	<customtag:stdMessagePanel id="pErrDtAltriEnerg" errorMessage="true" errorDetails="false" actionMessage="true" />
</div>

	<!-- endFragment:p_pErrDtAltriEnerg --></div>

			
	
	<div id="p_pDtAltriEnerg" class="widgetsPanelBlock"><!-- startFragment:p_pDtAltriEnerg -->
	
	

<div class="widgetsPanel" id="pDtAltriEnerg">
	
	<customtag:widgetsPanel id="pDtAltriEnergTbl" columns="2" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('cpCompilaz','txtObblDatiAltriEnerg')" >

	
<customtag:widgetsPanelColumn  colSpan="2"  >


<!-- widget txtObblDatiAltriEnerg -->
<s:text name="cpCompilaz.txtObblDatiAltriEnerg.statictext.label" />

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpCompilaz','cbClasseEnergEnerg')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpCompilaz.cbClasseEnergEnerg.label')}" labelFor="widg_cbClasseEnergEnerg" errorFor="appDatacertificato.altreInfo.energetiche.classeEnergEdificio" labelId="cbClasseEnergEnergLbl"
	  >


<!-- widget cbClasseEnergEnerg -->
<s:select name="appDatacertificato.altreInfo.energetiche.classeEnergEdificio" id="widg_cbClasseEnergEnerg"
	 
	
		title=""
			
	  headerKey="" headerValue="" 
	  list="appDataclassiEnergetiche"
	  disabled="isWidgetDisabled('cpCompilaz','cbClasseEnergEnerg')"
	  listKey="cod"
	  listValue="descr"
	  
	  />


	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpCompilaz','tfPrestEnergRaggEnerg')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpCompilaz.tfPrestEnergRaggEnerg.label')}" labelFor="widg_tfPrestEnergRaggEnerg" errorFor="appDatacertificato.altreInfo.energetiche.prestEnergRaggiungibile" labelId="tfPrestEnergRaggEnergLbl"
	  >


<!-- widget tfPrestEnergRaggEnerg -->
<s:textfield 
	
	
	name="appDatacertificato.altreInfo.energetiche.prestEnergRaggiungibile" id="widg_tfPrestEnergRaggEnerg"
maxlength="10"	disabled="isWidgetDisabled('cpCompilaz','tfPrestEnergRaggEnerg')"
	size="15" cssClass="numbers"
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpCompilaz','tfIndPrenenergRiscaldEnerg')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpCompilaz.tfIndPrenenergRiscaldEnerg.label')}" labelFor="widg_tfIndPrenenergRiscaldEnerg" errorFor="appDatacertificato.altreInfo.energetiche.indPrestEnergRiscald" labelId="tfIndPrenenergRiscaldEnergLbl"
	  >


<!-- widget tfIndPrenenergRiscaldEnerg -->
<s:textfield 
	
	
	name="appDatacertificato.altreInfo.energetiche.indPrestEnergRiscald" id="widg_tfIndPrenenergRiscaldEnerg"
maxlength="10"	disabled="isWidgetDisabled('cpCompilaz','tfIndPrenenergRiscaldEnerg')"
	size="15" cssClass="numbers"
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpCompilaz','tfLimNormNazRiscaldEnerg')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpCompilaz.tfLimNormNazRiscaldEnerg.label')}" labelFor="widg_tfLimNormNazRiscaldEnerg" errorFor="appDatacertificato.altreInfo.energetiche.limNormaNazRiscald" labelId="tfLimNormNazRiscaldEnergLbl"
	  >


<!-- widget tfLimNormNazRiscaldEnerg -->
<s:textfield 
	
	
	name="appDatacertificato.altreInfo.energetiche.limNormaNazRiscald" id="widg_tfLimNormNazRiscaldEnerg"
maxlength="10"	disabled="isWidgetDisabled('cpCompilaz','tfLimNormNazRiscaldEnerg')"
	size="15" cssClass="numbers"
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpCompilaz','cbQualitaInvolucroRaffrescEnerg')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpCompilaz.cbQualitaInvolucroRaffrescEnerg.label')}" labelFor="widg_cbQualitaInvolucroRaffrescEnerg" errorFor="appDatacertificato.altreInfo.energetiche.qualitaInvolucroRaffresc" labelId="cbQualitaInvolucroRaffrescEnergLbl"
	  >


<!-- widget cbQualitaInvolucroRaffrescEnerg -->
<s:select name="appDatacertificato.altreInfo.energetiche.qualitaInvolucroRaffresc" id="widg_cbQualitaInvolucroRaffrescEnerg"
	 
	
		title=""
			
	  headerKey="" headerValue="" 
	  list="appDataqualitaInvolucro"
	  disabled="isWidgetDisabled('cpCompilaz','cbQualitaInvolucroRaffrescEnerg')"
	  listKey="cod"
	  listValue="descr"
	  
	  />


	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpCompilaz','txtRendGlobRiscaldEnerg')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpCompilaz.txtRendGlobRiscaldEnerg.label')}" labelFor="widg_txtRendGlobRiscaldEnerg" errorFor="appDatacertificato.classeEnerg.locReale.rendGlobTermico" labelId="txtRendGlobRiscaldEnergLbl"   tdStyleClass="numbers">


<!-- widget txtRendGlobRiscaldEnerg -->
<s:property value="appDatacertificato.classeEnerg.locReale.rendGlobTermico" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpCompilaz','tfValPrestPompaEnerg')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpCompilaz.tfValPrestPompaEnerg.label')}" labelFor="widg_tfValPrestPompaEnerg" errorFor="appDatacertificato.altreInfo.energetiche.prestazPompaCalore" labelId="tfValPrestPompaEnergLbl"
	  >


<!-- widget tfValPrestPompaEnerg -->
<s:textfield 
	
	
	name="appDatacertificato.altreInfo.energetiche.prestazPompaCalore" id="widg_tfValPrestPompaEnerg"
maxlength="10"	disabled="isWidgetDisabled('cpCompilaz','tfValPrestPompaEnerg')"
	size="15" cssClass="numbers"
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpCompilaz','tfLimNormPrestPompaEnerg')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpCompilaz.tfLimNormPrestPompaEnerg.label')}" labelFor="widg_tfLimNormPrestPompaEnerg" errorFor="appDatacertificato.altreInfo.energetiche.limNormaPrestPompa" labelId="tfLimNormPrestPompaEnergLbl"
	  >


<!-- widget tfLimNormPrestPompaEnerg -->
<s:textfield 
	
	
	name="appDatacertificato.altreInfo.energetiche.limNormaPrestPompa" id="widg_tfLimNormPrestPompaEnerg"
maxlength="10"	disabled="isWidgetDisabled('cpCompilaz','tfLimNormPrestPompaEnerg')"
	size="15" cssClass="numbers"
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpCompilaz','taAltreInfoEnerg')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpCompilaz.taAltreInfoEnerg.label')}" labelFor="widg_taAltreInfoEnerg" errorFor="appDatacertificato.altreInfo.energetiche.altreInfo" labelId="taAltreInfoEnergLbl"
	  >


<!-- widget taAltreInfoEnerg -->
<s:textarea 
	
	
	name="appDatacertificato.altreInfo.energetiche.altreInfo" id="widg_taAltreInfoEnerg"
	disabled="isWidgetDisabled('cpCompilaz','taAltreInfoEnerg')"
	rows="7"
	cols="60"
	></s:textarea>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpCompilaz','txtNote1DtAltriEnerg')" >

	
<customtag:widgetsPanelColumn  colSpan="2"  >


<!-- widget txtNote1DtAltriEnerg -->
<s:text name="cpCompilaz.txtNote1DtAltriEnerg.statictext.label" />

	
</customtag:widgetsPanelColumn>

</s:if>

	



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_pDtAltriEnerg --></div>

			
	
	<div id="p_pDtAltriEnergNav" class="commandPanelBlock"><!-- startFragment:p_pDtAltriEnergNav -->
	
	
<div class="commandPanel navigation" id="pDtAltriEnergNav">

	
	
		

	
	
	
	<div class="button left">
		
<s:if test="isWidgetVisible('cpCompilaz','bDtAltriEnergIndietro')" >

	



<!-- widget bDtAltriEnergIndietro -->
	<csiuicore:ajaxify id="p_pWizCompilazLiv1" 
		widgetType="button"
		 
		requestUri="/siceeweb/base/compilazattestati/cpCompilaz!handleBDtAltriEnergIndietro_CLICKED.do" 
		
		pageId="cpCompilaz" 
		formName="cpCompilaz"
		javascriptDetection="false">
<s:submit name="widg_bDtAltriEnergIndietro" id="widg_bDtAltriEnergIndietro" method="handleBDtAltriEnergIndietro_CLICKED"
	key="cpCompilaz.bDtAltriEnergIndietro.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpCompilaz','bDtAltriEnergIndietro')" />

	</csiuicore:ajaxify>

	


</s:if>

	


	</div>
	
	

	
	
	
	

	
	
	
	<div class="button right">
		
<s:if test="isWidgetVisible('cpCompilaz','bDtAltriEnergAvanti')" >

	



<!-- widget bDtAltriEnergAvanti -->
	<csiuicore:ajaxify id="p_pWizCompilazLiv1" 
		widgetType="button"
		 
		requestUri="/siceeweb/base/compilazattestati/cpCompilaz!handleBDtAltriEnergAvanti_CLICKED.do" 
		
		pageId="cpCompilaz" 
		formName="cpCompilaz"
		javascriptDetection="false">
<s:submit name="widg_bDtAltriEnergAvanti" id="widg_bDtAltriEnergAvanti" method="handleBDtAltriEnergAvanti_CLICKED"
	key="cpCompilaz.bDtAltriEnergAvanti.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpCompilaz','bDtAltriEnergAvanti')" />

	</csiuicore:ajaxify>

	


</s:if>

	


	</div>
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_pDtAltriEnergNav --></div>

	

		
	
</div>

	<!-- endFragment:p_pDatiAltriEnerg --></div>
