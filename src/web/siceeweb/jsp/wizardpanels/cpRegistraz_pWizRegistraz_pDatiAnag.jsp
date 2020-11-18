<%@taglib uri="/struts-tags" prefix="s" %>
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="/customtag" prefix="customtag" %>
<%@taglib uri="/csiuicore" prefix="csiuicore" %>

	
	<div id="p_pDatiAnag" class="formPanelBlock"><!-- startFragment:p_pDatiAnag -->
		
	
<div class="formPanel" id="pDatiAnag">


	
	

	
	
			
	
	<div id="p_pErrDtAnag" class="stdMessagePanelBlock"><!-- startFragment:p_pErrDtAnag -->
	
	
<div class="stdMessagePanel" id="pErrDtAnag">
	<customtag:stdMessagePanel id="pErrDtAnag" errorMessage="true" errorDetails="false" actionMessage="true" />
</div>

	<!-- endFragment:p_pErrDtAnag --></div>

			
	
	<div id="p_pDtAnag1" class="widgetsPanelBlock"><!-- startFragment:p_pDtAnag1 -->
	
	

<div class="widgetsPanel" id="pDtAnag1">
	
	<customtag:widgetsPanel id="pDtAnag1Tbl" columns="2" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('cpRegistraz','txtObblAnag')" >

	
<customtag:widgetsPanelColumn  colSpan="2"  >


<!-- widget txtObblAnag -->
<s:text name="cpRegistraz.txtObblAnag.statictext.label" />

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpRegistraz','tfCognome')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRegistraz.tfCognome.label')}" labelFor="widg_tfCognome" errorFor="appDatacertificatore.dtAnag.cognome" labelId="tfCognomeLbl"
	  >


<!-- widget tfCognome -->
<s:textfield 
	
	
	name="appDatacertificatore.dtAnag.cognome" id="widg_tfCognome"
maxlength="50"	disabled="isWidgetDisabled('cpRegistraz','tfCognome')"
	size="50" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpRegistraz','tfNome')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRegistraz.tfNome.label')}" labelFor="widg_tfNome" errorFor="appDatacertificatore.dtAnag.nome" labelId="tfNomeLbl"
	  >


<!-- widget tfNome -->
<s:textfield 
	
	
	name="appDatacertificatore.dtAnag.nome" id="widg_tfNome"
maxlength="30"	disabled="isWidgetDisabled('cpRegistraz','tfNome')"
	size="50" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpRegistraz','tfCodFisc')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRegistraz.tfCodFisc.label')}" labelFor="widg_tfCodFisc" errorFor="appDatacertificatore.dtAnag.codFisc" labelId="tfCodFiscLbl"
	  >


<!-- widget tfCodFisc -->
<s:textfield 
	
	
	name="appDatacertificatore.dtAnag.codFisc" id="widg_tfCodFisc"
maxlength="30"	disabled="isWidgetDisabled('cpRegistraz','tfCodFisc')"
	size="50" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpRegistraz','calDtNascita')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRegistraz.calDtNascita.label')}" labelFor="widg_calDtNascita" errorFor="appDatacertificatore.dtAnag.dataNascita" labelId="calDtNascitaLbl"
	  >


<!-- widget calDtNascita -->
<s:textfield 
	
title=""	
	name="appDatacertificatore.dtAnag.dataNascita" id="widg_calDtNascita"
	disabled="isWidgetDisabled('cpRegistraz','calDtNascita')"
	size="10" maxlength="10" 
	cssClass="calendar"
/> <div class="infoCalendar"></div>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpRegistraz','tfStatoEstero')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRegistraz.tfStatoEstero.label')}" labelFor="widg_tfStatoEstero" errorFor="appDatacertificatore.dtAnag.statoEstero" labelId="tfStatoEsteroLbl"
	  >


<!-- widget tfStatoEstero -->
<s:textfield 
	
	
	name="appDatacertificatore.dtAnag.statoEstero" id="widg_tfStatoEstero"
maxlength="100"	disabled="isWidgetDisabled('cpRegistraz','tfStatoEstero')"
	size="50" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpRegistraz','cbRegNasc')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRegistraz.cbRegNasc.label')}" labelFor="widg_cbRegNasc" errorFor="appDatacertificatore.dtAnag.codRegNasc" labelId="cbRegNascLbl"
	  >


<!-- widget cbRegNasc -->

<s:url id="widg_cbRegNascurlComboBoxValueChange"
   action="/siceeweb/cpRegistraz!handleCbRegNasc_VALUE_CHANGED" namespace="/base/gestcertificatore"  
   includeParams="all" portletUrlType="action" 
/>
<s:select name="appDatacertificatore.dtAnag.codRegNasc" id="widg_cbRegNasc"
	 
	

		title=" - Attenzione. Dopo aver selezionato un valore, la pagina verra' aggiornata automaticamente"
			
	  headerKey="" headerValue="" 
	  list="appDataregioni"
	  disabled="isWidgetDisabled('cpRegistraz','cbRegNasc')"
	  listKey="cod"
	  listValue="nome"
	  onclick="onCBClick(this,'confermacbRegNasc','conferma','%{widg_cbRegNascurlComboBoxValueChange}')" onfocus="inFocus(this)" onblur="lostFocus(this,'confermacbRegNasc','conferma','%{widg_cbRegNascurlComboBoxValueChange}')" 
	  />


	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpRegistraz','cbProvNasc')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRegistraz.cbProvNasc.label')}" labelFor="widg_cbProvNasc" errorFor="appDatacertificatore.dtAnag.codProvNasc" labelId="cbProvNascLbl"
	  >


<!-- widget cbProvNasc -->

<s:url id="widg_cbProvNascurlComboBoxValueChange"
   action="/siceeweb/cpRegistraz!handleCbProvNasc_VALUE_CHANGED" namespace="/base/gestcertificatore"  
   includeParams="all" portletUrlType="action" 
/>
<s:select name="appDatacertificatore.dtAnag.codProvNasc" id="widg_cbProvNasc"
	 
	

		title=" - Attenzione. Dopo aver selezionato un valore, la pagina verra' aggiornata automaticamente"
			
	  headerKey="" headerValue="" 
	  list="appDataprovinceRegione"
	  disabled="isWidgetDisabled('cpRegistraz','cbProvNasc')"
	  listKey="cod"
	  listValue="nome"
	  onclick="onCBClick(this,'confermacbProvNasc','conferma','%{widg_cbProvNascurlComboBoxValueChange}')" onfocus="inFocus(this)" onblur="lostFocus(this,'confermacbProvNasc','conferma','%{widg_cbProvNascurlComboBoxValueChange}')" 
	  />


	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpRegistraz','cbComNasc')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRegistraz.cbComNasc.label')}" labelFor="widg_cbComNasc" errorFor="appDatacertificatore.dtAnag.codComuneNasc" labelId="cbComNascLbl"
	  >


<!-- widget cbComNasc -->

<s:url id="widg_cbComNascurlComboBoxValueChange"
   action="/siceeweb/cpRegistraz!handleCbComNasc_VALUE_CHANGED" namespace="/base/gestcertificatore"  
   includeParams="all" portletUrlType="action" 
/>
<s:select name="appDatacertificatore.dtAnag.codComuneNasc" id="widg_cbComNasc"
	 
	

		title=" - Attenzione. Dopo aver selezionato un valore, la pagina verra' aggiornata automaticamente"
			
	  headerKey="" headerValue="" 
	  list="appDatacomuniProvincia"
	  disabled="isWidgetDisabled('cpRegistraz','cbComNasc')"
	  listKey="cod"
	  listValue="nome"
	  onclick="onCBClick(this,'confermacbComNasc','conferma','%{widg_cbComNascurlComboBoxValueChange}')" onfocus="inFocus(this)" onblur="lostFocus(this,'confermacbComNasc','conferma','%{widg_cbComNascurlComboBoxValueChange}')" 
	  />


	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpRegistraz','txtNotaA')" >

	
<customtag:widgetsPanelColumn  colSpan="2"  >


<!-- widget txtNotaA -->
<s:text name="cpRegistraz.txtNotaA.statictext.label" />

	
</customtag:widgetsPanelColumn>

</s:if>

	



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_pDtAnag1 --></div>

			
	
	<div id="p_pDtAnagNav" class="commandPanelBlock"><!-- startFragment:p_pDtAnagNav -->
	
	
<div class="commandPanel navigation" id="pDtAnagNav">

	
	
		

	
	
	
	

	
	
	
	

	
	
	
	<div class="button right">
		
<s:if test="isWidgetVisible('cpRegistraz','bDtAnagAvanti')" >

	



<!-- widget bDtAnagAvanti -->
<s:submit name="widg_bDtAnagAvanti" id="widg_bDtAnagAvanti" method="handleBDtAnagAvanti_CLICKED"
	key="cpRegistraz.bDtAnagAvanti.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpRegistraz','bDtAnagAvanti')" />

	


</s:if>

	


	</div>
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_pDtAnagNav --></div>

	

		
	
</div>

	<!-- endFragment:p_pDatiAnag --></div>
