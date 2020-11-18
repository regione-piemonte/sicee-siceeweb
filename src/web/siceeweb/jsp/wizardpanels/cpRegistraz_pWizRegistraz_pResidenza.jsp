<%@taglib uri="/struts-tags" prefix="s" %>
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="/customtag" prefix="customtag" %>
<%@taglib uri="/csiuicore" prefix="csiuicore" %>

	
	<div id="p_pResidenza" class="formPanelBlock"><!-- startFragment:p_pResidenza -->
		
	
<div class="formPanel" id="pResidenza">


	
	

	
	
			
	
	<div id="p_pErrDtRes" class="stdMessagePanelBlock"><!-- startFragment:p_pErrDtRes -->
	
	
<div class="stdMessagePanel" id="pErrDtRes">
	<customtag:stdMessagePanel id="pErrDtRes" errorMessage="true" errorDetails="false" actionMessage="true" />
</div>

	<!-- endFragment:p_pErrDtRes --></div>

			
	
	<div id="p_pDtRes1" class="widgetsPanelBlock"><!-- startFragment:p_pDtRes1 -->
	
	
<h4 class="wpLabel">Dati Residenza </h4>
<div class="widgetsPanel" id="pDtRes1">
	
	<customtag:widgetsPanel id="pDtRes1Tbl" columns="8" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('cpRegistraz','txtObblResid')" >

	
<customtag:widgetsPanelColumn  colSpan="4" position="first" >


<!-- widget txtObblResid -->
<s:text name="cpRegistraz.txtObblResid.statictext.label" />

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="4" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpRegistraz','txtNull')" >

	
<customtag:widgetsPanelColumn  colSpan="4" position="first" >


<!-- widget txtNull -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="4" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpRegistraz','rbFlgResidenzaItalia')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRegistraz.rbFlgResidenzaItalia.label')}" labelFor="widg_rbFlgResidenzaItalia" errorFor="appDatacertificatore.dtResidenza.flgResidenzaItalia" labelId="rbFlgResidenzaItaliaLbl"
	position="last" colSpan="3" >


<!-- widget rbFlgResidenzaItalia -->

	
<div id="appDatacertificatore.dtResidenza.flgResidenzaItalia" class="radiobuttons ">







<s:url id="widg_rbFlgResidenzaItaliaurlRadioButtonValueChange"
   action="/siceeweb/cpRegistraz!handleRbFlgResidenzaItalia_VALUE_CHANGED" namespace="/base/gestcertificatore"  
   includeParams="all" portletUrlType="action" 
/>

<s:radio
	
title=""	
	id="widg_rbFlgResidenzaItaliaS" name="appDatacertificatore.dtResidenza.flgResidenzaItalia"
	list="#{'S':'si'}"
	disabled="isWidgetDisabled('cpRegistraz','rbFlgResidenzaItalia')"
	cssClass="radio"
	onclick="onRBClick('%{widg_rbFlgResidenzaItaliaurlRadioButtonValueChange}')" 
	/> <label  for="widg_rbFlgResidenzaItaliaSS"><s:text name="cpRegistraz.rbFlgResidenzaItalia.rbFlgResidenzaItaliaS.label" /></label>








<s:radio
	
title=""	
	id="widg_rbFlgResidenzaItaliaN" name="appDatacertificatore.dtResidenza.flgResidenzaItalia"
	list="#{'N':'no'}"
	disabled="isWidgetDisabled('cpRegistraz','rbFlgResidenzaItalia')"
	cssClass="radio"
	onclick="onRBClick('%{widg_rbFlgResidenzaItaliaurlRadioButtonValueChange}')" 
	/> <label  for="widg_rbFlgResidenzaItaliaNN"><s:text name="cpRegistraz.rbFlgResidenzaItalia.rbFlgResidenzaItaliaN.label" /></label>





	
</div>



	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="4" position="last"/>
</s:else>



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_pDtRes1 --></div>

			
	
	<div id="p_pDtResItaliana" class="widgetsPanelBlock"><!-- startFragment:p_pDtResItaliana -->
	
	
<h4 class="wpLabel">Residenza Italiana </h4>
<div class="widgetsPanel" id="pDtResItaliana">
	
	<customtag:widgetsPanel id="pDtResItalianaTbl" columns="8" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('cpRegistraz','cbRegResid')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRegistraz.cbRegResid.label')}" labelFor="widg_cbRegResid" errorFor="appDatacertificatore.dtResidenza.codReg" labelId="cbRegResidLbl"
	position="first" colSpan="7" >


<!-- widget cbRegResid -->

<s:url id="widg_cbRegResidurlComboBoxValueChange"
   action="/siceeweb/cpRegistraz!handleCbRegResid_VALUE_CHANGED" namespace="/base/gestcertificatore"  
   includeParams="all" portletUrlType="action" 
/>
<s:select name="appDatacertificatore.dtResidenza.codReg" id="widg_cbRegResid"
	 
	

		title=" - Attenzione. Dopo aver selezionato un valore, la pagina verra' aggiornata automaticamente"
			
	  headerKey="" headerValue="" 
	  list="appDataregioniRes"
	  disabled="isWidgetDisabled('cpRegistraz','cbRegResid')"
	  listKey="cod"
	  listValue="nome"
	  onclick="onCBClick(this,'confermacbRegResid','conferma','%{widg_cbRegResidurlComboBoxValueChange}')" onfocus="inFocus(this)" onblur="lostFocus(this,'confermacbRegResid','conferma','%{widg_cbRegResidurlComboBoxValueChange}')" 
	  />


	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpRegistraz','cbProvResid')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRegistraz.cbProvResid.label')}" labelFor="widg_cbProvResid" errorFor="appDatacertificatore.dtResidenza.codProv" labelId="cbProvResidLbl"
	position="first" colSpan="7" >


<!-- widget cbProvResid -->

<s:url id="widg_cbProvResidurlComboBoxValueChange"
   action="/siceeweb/cpRegistraz!handleCbProvResid_VALUE_CHANGED" namespace="/base/gestcertificatore"  
   includeParams="all" portletUrlType="action" 
/>
<s:select name="appDatacertificatore.dtResidenza.codProv" id="widg_cbProvResid"
	 
	

		title=" - Attenzione. Dopo aver selezionato un valore, la pagina verra' aggiornata automaticamente"
			
	  headerKey="" headerValue="" 
	  list="appDataprovinceResRegione"
	  disabled="isWidgetDisabled('cpRegistraz','cbProvResid')"
	  listKey="cod"
	  listValue="nome"
	  onclick="onCBClick(this,'confermacbProvResid','conferma','%{widg_cbProvResidurlComboBoxValueChange}')" onfocus="inFocus(this)" onblur="lostFocus(this,'confermacbProvResid','conferma','%{widg_cbProvResidurlComboBoxValueChange}')" 
	  />


	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpRegistraz','cbComResid')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRegistraz.cbComResid.label')}" labelFor="widg_cbComResid" errorFor="appDatacertificatore.dtResidenza.codComune" labelId="cbComResidLbl"
	position="first" colSpan="7" >


<!-- widget cbComResid -->

<s:url id="widg_cbComResidurlComboBoxValueChange"
   action="/siceeweb/cpRegistraz!handleCbComResid_VALUE_CHANGED" namespace="/base/gestcertificatore"  
   includeParams="all" portletUrlType="action" 
/>
<s:select name="appDatacertificatore.dtResidenza.codComune" id="widg_cbComResid"
	 
	

		title=" - Attenzione. Dopo aver selezionato un valore, la pagina verra' aggiornata automaticamente"
			
	  headerKey="" headerValue="" 
	  list="appDatacomuniResProvincia"
	  disabled="isWidgetDisabled('cpRegistraz','cbComResid')"
	  listKey="cod"
	  listValue="nome"
	  onclick="onCBClick(this,'confermacbComResid','conferma','%{widg_cbComResidurlComboBoxValueChange}')" onfocus="inFocus(this)" onblur="lostFocus(this,'confermacbComResid','conferma','%{widg_cbComResidurlComboBoxValueChange}')" 
	  />


	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpRegistraz','tfIndirizzoRes')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRegistraz.tfIndirizzoRes.label')}" labelFor="widg_tfIndirizzoRes" errorFor="appDatacertificatore.dtResidenza.descrIndirizzo" labelId="tfIndirizzoResLbl"
	position="first" colSpan="3" >


<!-- widget tfIndirizzoRes -->
<s:textfield 
	
	
	name="appDatacertificatore.dtResidenza.descrIndirizzo" id="widg_tfIndirizzoRes"
maxlength="30"	disabled="isWidgetDisabled('cpRegistraz','tfIndirizzoRes')"
	size="50" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="4" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpRegistraz','vVerifIndRes')" >

	
<customtag:widgetsPanelColumn colSpan="2" >


<!-- widget vVerifIndRes -->
<s:submit name="widg_vVerifIndRes" id="widg_vVerifIndRes" method="handleVVerifIndRes_CLICKED"
	key="cpRegistraz.vVerifIndRes.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpRegistraz','vVerifIndRes')" />

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" />
</s:else>


	
<s:if test="isWidgetVisible('cpRegistraz','cbSceltaIndRes')" >

	
<customtag:widgetsPanelColumn 
	position="last" colSpan="2" >


<!-- widget cbSceltaIndRes -->

<s:url id="widg_cbSceltaIndResurlComboBoxValueChange"
   action="/siceeweb/cpRegistraz!handleCbSceltaIndRes_VALUE_CHANGED" namespace="/base/gestcertificatore"  
   includeParams="all" portletUrlType="action" 
/>
<s:select name="appDatasuggestIndirizzoCode" id="widg_cbSceltaIndRes"
	 
	

		title=" - Attenzione. Dopo aver selezionato un valore, la pagina verra' aggiornata automaticamente"
			
	  headerKey="" headerValue="" 
	  list="appDatasuggestIndirizzo"
	  disabled="isWidgetDisabled('cpRegistraz','cbSceltaIndRes')"
	  listKey="cod"
	  listValue="descr"
	  onclick="onCBClick(this,'confermacbSceltaIndRes','conferma','%{widg_cbSceltaIndResurlComboBoxValueChange}')" onfocus="inFocus(this)" onblur="lostFocus(this,'confermacbSceltaIndRes','conferma','%{widg_cbSceltaIndResurlComboBoxValueChange}')" 
	  />


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpRegistraz','tfNCivRes')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRegistraz.tfNCivRes.label')}" labelFor="widg_tfNCivRes" errorFor="appDatacertificatore.dtResidenza.numCiv" labelId="tfNCivResLbl"
	position="first" colSpan="3" >


<!-- widget tfNCivRes -->
<s:textfield 
	
	
	name="appDatacertificatore.dtResidenza.numCiv" id="widg_tfNCivRes"
maxlength="5"	disabled="isWidgetDisabled('cpRegistraz','tfNCivRes')"
	size="15" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="4" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpRegistraz','tfCAPRes')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRegistraz.tfCAPRes.label')}" labelFor="widg_tfCAPRes" errorFor="appDatacertificatore.dtResidenza.cap" labelId="tfCAPResLbl"
	position="last" colSpan="3" >


<!-- widget tfCAPRes -->
<s:textfield 
	
	
	name="appDatacertificatore.dtResidenza.cap" id="widg_tfCAPRes"
maxlength="5"	disabled="isWidgetDisabled('cpRegistraz','tfCAPRes')"
	size="15" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="4" position="last"/>
</s:else>



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_pDtResItaliana --></div>

			
	
	<div id="p_pDtResEstera" class="widgetsPanelBlock"><!-- startFragment:p_pDtResEstera -->
	
	
<h4 class="wpLabel">Residenza Estera </h4>
<div class="widgetsPanel" id="pDtResEstera">
	
	<customtag:widgetsPanel id="pDtResEsteraTbl" columns="8" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('cpRegistraz','tfStatoResEstero')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRegistraz.tfStatoResEstero.label')}" labelFor="widg_tfStatoResEstero" errorFor="appDatacertificatore.dtResidenza.statoResEstero" labelId="tfStatoResEsteroLbl"
	position="first"  >


<!-- widget tfStatoResEstero -->
<s:textfield 
	
	
	name="appDatacertificatore.dtResidenza.statoResEstero" id="widg_tfStatoResEstero"
maxlength="100"	disabled="isWidgetDisabled('cpRegistraz','tfStatoResEstero')"
	size="50" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpRegistraz','pDtResEstera_1_2_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2"  >


<!-- widget pDtResEstera_1_2_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" />
</s:else>


	
<s:if test="isWidgetVisible('cpRegistraz','pDtResEstera_1_3_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2"  >


<!-- widget pDtResEstera_1_3_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" />
</s:else>


	
<s:if test="isWidgetVisible('cpRegistraz','pDtResEstera_1_4_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget pDtResEstera_1_4_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpRegistraz','tfCittaEstera')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRegistraz.tfCittaEstera.label')}" labelFor="widg_tfCittaEstera" errorFor="appDatacertificatore.dtResidenza.cittaEstera" labelId="tfCittaEsteraLbl"
	position="first"  >


<!-- widget tfCittaEstera -->
<s:textfield 
	
	
	name="appDatacertificatore.dtResidenza.cittaEstera" id="widg_tfCittaEstera"
maxlength="100"	disabled="isWidgetDisabled('cpRegistraz','tfCittaEstera')"
	size="50" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpRegistraz','pDtResEstera_2_2_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2"  >


<!-- widget pDtResEstera_2_2_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" />
</s:else>


	
<s:if test="isWidgetVisible('cpRegistraz','tfCapEstero')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRegistraz.tfCapEstero.label')}" labelFor="widg_tfCapEstero" errorFor="appDatacertificatore.dtResidenza.capEstero" labelId="tfCapEsteroLbl"
	  >


<!-- widget tfCapEstero -->
<s:textfield 
	
	
	name="appDatacertificatore.dtResidenza.capEstero" id="widg_tfCapEstero"
maxlength="10"	disabled="isWidgetDisabled('cpRegistraz','tfCapEstero')"
	size="15" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" />
</s:else>


	
<s:if test="isWidgetVisible('cpRegistraz','pDtResEstera_2_4_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget pDtResEstera_2_4_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpRegistraz','tfViaEstera')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRegistraz.tfViaEstera.label')}" labelFor="widg_tfViaEstera" errorFor="appDatacertificatore.dtResidenza.viaEstera" labelId="tfViaEsteraLbl"
	position="first"  >


<!-- widget tfViaEstera -->
<s:textfield 
	
	
	name="appDatacertificatore.dtResidenza.viaEstera" id="widg_tfViaEstera"
maxlength="100"	disabled="isWidgetDisabled('cpRegistraz','tfViaEstera')"
	size="50" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpRegistraz','pDtResEstera_3_2_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2"  >


<!-- widget pDtResEstera_3_2_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" />
</s:else>


	
<s:if test="isWidgetVisible('cpRegistraz','tfCivicoEstero')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRegistraz.tfCivicoEstero.label')}" labelFor="widg_tfCivicoEstero" errorFor="appDatacertificatore.dtResidenza.civicoEstero" labelId="tfCivicoEsteroLbl"
	  >


<!-- widget tfCivicoEstero -->
<s:textfield 
	
	
	name="appDatacertificatore.dtResidenza.civicoEstero" id="widg_tfCivicoEstero"
maxlength="10"	disabled="isWidgetDisabled('cpRegistraz','tfCivicoEstero')"
	size="15" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" />
</s:else>


	
<s:if test="isWidgetVisible('cpRegistraz','pDtResEstera_3_4_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget pDtResEstera_3_4_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_pDtResEstera --></div>

			
	
	<div id="p_pDtContatti" class="widgetsPanelBlock"><!-- startFragment:p_pDtContatti -->
	
	
<h4 class="wpLabel">Contatti </h4>
<div class="widgetsPanel" id="pDtContatti">
	
	<customtag:widgetsPanel id="pDtContattiTbl" columns="4" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('cpRegistraz','txtObblContatti')" >

	
<customtag:widgetsPanelColumn  colSpan="6" position="first" >


<!-- widget txtObblContatti -->
<s:text name="cpRegistraz.txtObblContatti.statictext.label" />

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="6" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpRegistraz','tfTelRes')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRegistraz.tfTelRes.label')}" labelFor="widg_tfTelRes" errorFor="appDatacertificatore.dtResidenza.tel" labelId="tfTelResLbl"
	position="first"  >


<!-- widget tfTelRes -->
<s:textfield 
	
	
	name="appDatacertificatore.dtResidenza.tel" id="widg_tfTelRes"
maxlength="20"	disabled="isWidgetDisabled('cpRegistraz','tfTelRes')"
	size="15" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpRegistraz','cbAutorizzaTelefono')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRegistraz.cbAutorizzaTelefono.label')}" labelFor="widg_cbAutorizzaTelefono" errorFor="appDatacertificatore.dtResidenza.flgAutorTel" labelId="cbAutorizzaTelefonoLbl"
	position="last"  >


<!-- widget cbAutorizzaTelefono -->
<s:checkbox 
	
	
	name="appDatacertificatore.dtResidenza.flgAutorTel" id="widg_cbAutorizzaTelefono"
	disabled="isWidgetDisabled('cpRegistraz','cbAutorizzaTelefono')"
	cssClass="checkbox"
	
	/> 
<s:if test="!isWidgetDisabled('cpRegistraz','cbAutorizzaTelefono')" >
	<s:hidden name="__checkbox_appDatacertificatore.dtResidenza.flgAutorTel" id="__checkbox_widg_cbAutorizzaTelefono" />
</s:if>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpRegistraz','tfCellRes')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRegistraz.tfCellRes.label')}" labelFor="widg_tfCellRes" errorFor="appDatacertificatore.dtResidenza.cell" labelId="tfCellResLbl"
	position="first"  >


<!-- widget tfCellRes -->
<s:textfield 
	
	
	name="appDatacertificatore.dtResidenza.cell" id="widg_tfCellRes"
maxlength="20"	disabled="isWidgetDisabled('cpRegistraz','tfCellRes')"
	size="15" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpRegistraz','cbAutorizzaCell')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRegistraz.cbAutorizzaCell.label')}" labelFor="widg_cbAutorizzaCell" errorFor="appDatacertificatore.dtResidenza.flgAutorCell" labelId="cbAutorizzaCellLbl"
	position="last"  >


<!-- widget cbAutorizzaCell -->
<s:checkbox 
	
	
	name="appDatacertificatore.dtResidenza.flgAutorCell" id="widg_cbAutorizzaCell"
	disabled="isWidgetDisabled('cpRegistraz','cbAutorizzaCell')"
	cssClass="checkbox"
	
	/> 
<s:if test="!isWidgetDisabled('cpRegistraz','cbAutorizzaCell')" >
	<s:hidden name="__checkbox_appDatacertificatore.dtResidenza.flgAutorCell" id="__checkbox_widg_cbAutorizzaCell" />
</s:if>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpRegistraz','tfEmailRes')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRegistraz.tfEmailRes.label')}" labelFor="widg_tfEmailRes" errorFor="appDatacertificatore.dtResidenza.email" labelId="tfEmailResLbl"
	position="first"  >


<!-- widget tfEmailRes -->
<s:textfield 
	
	
	name="appDatacertificatore.dtResidenza.email" id="widg_tfEmailRes"
maxlength="70"	disabled="isWidgetDisabled('cpRegistraz','tfEmailRes')"
	size="15" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpRegistraz','cbAutorizzaEmail')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRegistraz.cbAutorizzaEmail.label')}" labelFor="widg_cbAutorizzaEmail" errorFor="appDatacertificatore.dtResidenza.flgAutorEmail" labelId="cbAutorizzaEmailLbl"
	position="last"  >


<!-- widget cbAutorizzaEmail -->
<s:checkbox 
	
	
	name="appDatacertificatore.dtResidenza.flgAutorEmail" id="widg_cbAutorizzaEmail"
	disabled="isWidgetDisabled('cpRegistraz','cbAutorizzaEmail')"
	cssClass="checkbox"
	
	/> 
<s:if test="!isWidgetDisabled('cpRegistraz','cbAutorizzaEmail')" >
	<s:hidden name="__checkbox_appDatacertificatore.dtResidenza.flgAutorEmail" id="__checkbox_widg_cbAutorizzaEmail" />
</s:if>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpRegistraz','tfEmailPec')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRegistraz.tfEmailPec.label')}" labelFor="widg_tfEmailPec" errorFor="appDatacertificatore.dtResidenza.emailPec" labelId="tfEmailPecLbl"
	position="first"  >


<!-- widget tfEmailPec -->
<s:textfield 
	
	
	name="appDatacertificatore.dtResidenza.emailPec" id="widg_tfEmailPec"
maxlength="70"	disabled="isWidgetDisabled('cpRegistraz','tfEmailPec')"
	size="15" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpRegistraz','tfFaxRes')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRegistraz.tfFaxRes.label')}" labelFor="widg_tfFaxRes" errorFor="appDatacertificatore.dtResidenza.fax" labelId="tfFaxResLbl"
	position="first"  >


<!-- widget tfFaxRes -->
<s:textfield 
	
	
	name="appDatacertificatore.dtResidenza.fax" id="widg_tfFaxRes"
	disabled="isWidgetDisabled('cpRegistraz','tfFaxRes')"
	size="15" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpRegistraz','tfSitoWeb')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRegistraz.tfSitoWeb.label')}" labelFor="widg_tfSitoWeb" errorFor="appDatacertificatore.dtResidenza.sitoWeb" labelId="tfSitoWebLbl"
	position="first"  >


<!-- widget tfSitoWeb -->
<s:textfield 
	
	
	name="appDatacertificatore.dtResidenza.sitoWeb" id="widg_tfSitoWeb"
maxlength="50"	disabled="isWidgetDisabled('cpRegistraz','tfSitoWeb')"
	size="15" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpRegistraz','cbAutorizzaNewsletter')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRegistraz.cbAutorizzaNewsletter.label')}" labelFor="widg_cbAutorizzaNewsletter" errorFor="appDatacertificatore.dtResidenza.flgNewsletter" labelId="cbAutorizzaNewsletterLbl"
	position="first"  >


<!-- widget cbAutorizzaNewsletter -->
<s:checkbox 
	
	
	name="appDatacertificatore.dtResidenza.flgNewsletter" id="widg_cbAutorizzaNewsletter"
	disabled="isWidgetDisabled('cpRegistraz','cbAutorizzaNewsletter')"
	cssClass="checkbox"
	
	/> 
<s:if test="!isWidgetDisabled('cpRegistraz','cbAutorizzaNewsletter')" >
	<s:hidden name="__checkbox_appDatacertificatore.dtResidenza.flgNewsletter" id="__checkbox_widg_cbAutorizzaNewsletter" />
</s:if>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_pDtContatti --></div>

			
	
	<div id="p_pDtResNav" class="commandPanelBlock"><!-- startFragment:p_pDtResNav -->
	
	
<div class="commandPanel navigation" id="pDtResNav">

	
	
		

	
	
	
	<div class="button left">
		
<s:if test="isWidgetVisible('cpRegistraz','bDtResIndietro')" >

	



<!-- widget bDtResIndietro -->
<s:submit name="widg_bDtResIndietro" id="widg_bDtResIndietro" method="handleBDtResIndietro_CLICKED"
	key="cpRegistraz.bDtResIndietro.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpRegistraz','bDtResIndietro')" />

	


</s:if>

	


	</div>
	
	

	
	
	
	

	
	
	
	<div class="button right">
		
<s:if test="isWidgetVisible('cpRegistraz','bDtResAvanti')" >

	



<!-- widget bDtResAvanti -->
<s:submit name="widg_bDtResAvanti" id="widg_bDtResAvanti" method="handleBDtResAvanti_CLICKED"
	key="cpRegistraz.bDtResAvanti.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpRegistraz','bDtResAvanti')" />

	


</s:if>

	


	</div>
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_pDtResNav --></div>

	

		
	
</div>

	<!-- endFragment:p_pResidenza --></div>
