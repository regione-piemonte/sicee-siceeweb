<%@taglib uri="/struts-tags" prefix="s" %>
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="/customtag" prefix="customtag" %>
<%@taglib uri="/csiuicore" prefix="csiuicore" %>

	
	<div id="p_pStudio" class="formPanelBlock"><!-- startFragment:p_pStudio -->
		
	
<div class="formPanel" id="pStudio">


	
	

	
	
			
	
	<div id="p_pErrDtStudio" class="stdMessagePanelBlock"><!-- startFragment:p_pErrDtStudio -->
	
	
<div class="stdMessagePanel" id="pErrDtStudio">
	<customtag:stdMessagePanel id="pErrDtStudio" errorMessage="true" errorDetails="false" actionMessage="true" />
</div>

	<!-- endFragment:p_pErrDtStudio --></div>

			
	
	<div id="p_pDtStudio1" class="widgetsPanelBlock"><!-- startFragment:p_pDtStudio1 -->
	
	

<div class="widgetsPanel" id="pDtStudio1">
	
	<customtag:widgetsPanel id="pDtStudio1Tbl" columns="6" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('cpRegistraz','tfRagSociale')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRegistraz.tfRagSociale.label')}" labelFor="widg_tfRagSociale" errorFor="appDatacertificatore.dtStudio.ragSociale" labelId="tfRagSocialeLbl"
	position="first" colSpan="5" >


<!-- widget tfRagSociale -->
<s:textfield 
	
	
	name="appDatacertificatore.dtStudio.ragSociale" id="widg_tfRagSociale"
maxlength="50"	disabled="isWidgetDisabled('cpRegistraz','tfRagSociale')"
	size="20" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpRegistraz','tfPIVA')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRegistraz.tfPIVA.label')}" labelFor="widg_tfPIVA" errorFor="appDatacertificatore.dtStudio.partitaIVA" labelId="tfPIVALbl"
	position="first" colSpan="5" >


<!-- widget tfPIVA -->
<s:textfield 
	
	
	name="appDatacertificatore.dtStudio.partitaIVA" id="widg_tfPIVA"
maxlength="11"	disabled="isWidgetDisabled('cpRegistraz','tfPIVA')"
	size="20" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpRegistraz','cbRegStudio')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRegistraz.cbRegStudio.label')}" labelFor="widg_cbRegStudio" errorFor="appDatacertificatore.dtStudio.codReg" labelId="cbRegStudioLbl"
	position="first" colSpan="5" >


<!-- widget cbRegStudio -->

<s:url id="widg_cbRegStudiourlComboBoxValueChange"
   action="/siceeweb/cpRegistraz!handleCbRegStudio_VALUE_CHANGED" namespace="/base/gestcertificatore"  
   includeParams="all" portletUrlType="action" 
/>
<s:select name="appDatacertificatore.dtStudio.codReg" id="widg_cbRegStudio"
	 
	

		title=" - Attenzione. Dopo aver selezionato un valore, la pagina verra' aggiornata automaticamente"
			
	  headerKey="" headerValue="" 
	  list="appDataregioniStudio"
	  disabled="isWidgetDisabled('cpRegistraz','cbRegStudio')"
	  listKey="cod"
	  listValue="nome"
	  onclick="onCBClick(this,'confermacbRegStudio','conferma','%{widg_cbRegStudiourlComboBoxValueChange}')" onfocus="inFocus(this)" onblur="lostFocus(this,'confermacbRegStudio','conferma','%{widg_cbRegStudiourlComboBoxValueChange}')" 
	  />


	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpRegistraz','cbProvStudio')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRegistraz.cbProvStudio.label')}" labelFor="widg_cbProvStudio" errorFor="appDatacertificatore.dtStudio.codProv" labelId="cbProvStudioLbl"
	position="first" colSpan="5" >


<!-- widget cbProvStudio -->

<s:url id="widg_cbProvStudiourlComboBoxValueChange"
   action="/siceeweb/cpRegistraz!handleCbProvStudio_VALUE_CHANGED" namespace="/base/gestcertificatore"  
   includeParams="all" portletUrlType="action" 
/>
<s:select name="appDatacertificatore.dtStudio.codProv" id="widg_cbProvStudio"
	 
	

		title=" - Attenzione. Dopo aver selezionato un valore, la pagina verra' aggiornata automaticamente"
			
	  headerKey="" headerValue="" 
	  list="appDataprovinceStudioRegione"
	  disabled="isWidgetDisabled('cpRegistraz','cbProvStudio')"
	  listKey="cod"
	  listValue="nome"
	  onclick="onCBClick(this,'confermacbProvStudio','conferma','%{widg_cbProvStudiourlComboBoxValueChange}')" onfocus="inFocus(this)" onblur="lostFocus(this,'confermacbProvStudio','conferma','%{widg_cbProvStudiourlComboBoxValueChange}')" 
	  />


	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpRegistraz','cbComStudio')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRegistraz.cbComStudio.label')}" labelFor="widg_cbComStudio" errorFor="appDatacertificatore.dtStudio.codComune" labelId="cbComStudioLbl"
	position="first" colSpan="5" >


<!-- widget cbComStudio -->

<s:url id="widg_cbComStudiourlComboBoxValueChange"
   action="/siceeweb/cpRegistraz!handleCbComStudio_VALUE_CHANGED" namespace="/base/gestcertificatore"  
   includeParams="all" portletUrlType="action" 
/>
<s:select name="appDatacertificatore.dtStudio.codComune" id="widg_cbComStudio"
	 
	

		title=" - Attenzione. Dopo aver selezionato un valore, la pagina verra' aggiornata automaticamente"
			
	  headerKey="" headerValue="" 
	  list="appDatacomuniStudioProvincia"
	  disabled="isWidgetDisabled('cpRegistraz','cbComStudio')"
	  listKey="cod"
	  listValue="nome"
	  onclick="onCBClick(this,'confermacbComStudio','conferma','%{widg_cbComStudiourlComboBoxValueChange}')" onfocus="inFocus(this)" onblur="lostFocus(this,'confermacbComStudio','conferma','%{widg_cbComStudiourlComboBoxValueChange}')" 
	  />


	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpRegistraz','tfIndirizzoStudio')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRegistraz.tfIndirizzoStudio.label')}" labelFor="widg_tfIndirizzoStudio" errorFor="appDatacertificatore.dtStudio.descrIndirizzo" labelId="tfIndirizzoStudioLbl"
	position="first"  >


<!-- widget tfIndirizzoStudio -->
<s:textfield 
	
	
	name="appDatacertificatore.dtStudio.descrIndirizzo" id="widg_tfIndirizzoStudio"
maxlength="100"	disabled="isWidgetDisabled('cpRegistraz','tfIndirizzoStudio')"
	size="50" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpRegistraz','vVerifIndStudio')" >

	
<customtag:widgetsPanelColumn colSpan="2" >


<!-- widget vVerifIndStudio -->
<s:submit name="widg_vVerifIndStudio" id="widg_vVerifIndStudio" method="handleVVerifIndStudio_CLICKED"
	key="cpRegistraz.vVerifIndStudio.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpRegistraz','vVerifIndStudio')" />

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" />
</s:else>


	
<s:if test="isWidgetVisible('cpRegistraz','cbSceltaIndStudio')" >

	
<customtag:widgetsPanelColumn 
	position="last" colSpan="2" >


<!-- widget cbSceltaIndStudio -->

<s:url id="widg_cbSceltaIndStudiourlComboBoxValueChange"
   action="/siceeweb/cpRegistraz!handleCbSceltaIndStudio_VALUE_CHANGED" namespace="/base/gestcertificatore"  
   includeParams="all" portletUrlType="action" 
/>
<s:select name="appDatasuggestIndirizzoCode" id="widg_cbSceltaIndStudio"
	 
	

		title=" - Attenzione. Dopo aver selezionato un valore, la pagina verra' aggiornata automaticamente"
			
	  headerKey="" headerValue="" 
	  list="appDatasuggestIndirizzo"
	  disabled="isWidgetDisabled('cpRegistraz','cbSceltaIndStudio')"
	  listKey="cod"
	  listValue="descr"
	  onclick="onCBClick(this,'confermacbSceltaIndStudio','conferma','%{widg_cbSceltaIndStudiourlComboBoxValueChange}')" onfocus="inFocus(this)" onblur="lostFocus(this,'confermacbSceltaIndStudio','conferma','%{widg_cbSceltaIndStudiourlComboBoxValueChange}')" 
	  />


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpRegistraz','tfNCivStudio')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRegistraz.tfNCivStudio.label')}" labelFor="widg_tfNCivStudio" errorFor="appDatacertificatore.dtStudio.numCiv" labelId="tfNCivStudioLbl"
	position="first"  >


<!-- widget tfNCivStudio -->
<s:textfield 
	
	
	name="appDatacertificatore.dtStudio.numCiv" id="widg_tfNCivStudio"
maxlength="10"	disabled="isWidgetDisabled('cpRegistraz','tfNCivStudio')"
	size="20" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpRegistraz','tfCAPStudio')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRegistraz.tfCAPStudio.label')}" labelFor="widg_tfCAPStudio" errorFor="appDatacertificatore.dtStudio.cap" labelId="tfCAPStudioLbl"
	position="last" colSpan="3" >


<!-- widget tfCAPStudio -->
<s:textfield 
	
	
	name="appDatacertificatore.dtStudio.cap" id="widg_tfCAPStudio"
maxlength="5"	disabled="isWidgetDisabled('cpRegistraz','tfCAPStudio')"
	size="15" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="4" position="last"/>
</s:else>



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_pDtStudio1 --></div>

			
	
	<div id="p_pDtStudioNav" class="commandPanelBlock"><!-- startFragment:p_pDtStudioNav -->
	
	
<div class="commandPanel navigation" id="pDtStudioNav">

	
	
		

	
	
	
	<div class="button left">
		
<s:if test="isWidgetVisible('cpRegistraz','bDtStudioIndietro')" >

	



<!-- widget bDtStudioIndietro -->
	<csiuicore:ajaxify id="p_pWizRegistraz,p_pUp" 
		widgetType="button"
		 
		requestUri="/siceeweb/base/gestcertificatore/cpRegistraz!handleBDtStudioIndietro_CLICKED.do" 
		
		pageId="cpRegistraz" 
		formName="cpRegistraz"
		javascriptDetection="false">
<s:submit name="widg_bDtStudioIndietro" id="widg_bDtStudioIndietro" method="handleBDtStudioIndietro_CLICKED"
	key="cpRegistraz.bDtStudioIndietro.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpRegistraz','bDtStudioIndietro')" />

	</csiuicore:ajaxify>

	


</s:if>

	


	</div>
	
	

	
	
	
	

	
	
	
	<div class="button right">
		
<s:if test="isWidgetVisible('cpRegistraz','bDtStudioAvanti')" >

	



<!-- widget bDtStudioAvanti -->
<s:submit name="widg_bDtStudioAvanti" id="widg_bDtStudioAvanti" method="handleBDtStudioAvanti_CLICKED"
	key="cpRegistraz.bDtStudioAvanti.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpRegistraz','bDtStudioAvanti')" />

	


</s:if>

	


	</div>
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_pDtStudioNav --></div>

	

		
	
</div>

	<!-- endFragment:p_pStudio --></div>
