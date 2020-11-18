<%@taglib uri="/struts-tags" prefix="s" %>
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="/customtag" prefix="customtag" %>
<%@taglib uri="/csiuicore" prefix="csiuicore" %>

	
	<div id="p_pDatiResponsabili" class="formPanelBlock"><!-- startFragment:p_pDatiResponsabili -->
		
	
<div class="formPanel" id="pDatiResponsabili">


	
	

	
	
			
	
	<div id="p_pErrDtRespons" class="stdMessagePanelBlock"><!-- startFragment:p_pErrDtRespons -->
	
	
<div class="stdMessagePanel" id="pErrDtRespons">
	<customtag:stdMessagePanel id="pErrDtRespons" errorMessage="true" errorDetails="false" actionMessage="true" />
</div>

	<!-- endFragment:p_pErrDtRespons --></div>

			
	
	<div id="p_pDtProgettista" class="widgetsPanelBlock"><!-- startFragment:p_pDtProgettista -->
	
	
<h4 class="wpLabel">Progettista </h4>
<div class="widgetsPanel" id="pDtProgettista">
	
	<customtag:widgetsPanel id="pDtProgettistaTbl" columns="8" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('cpCompilaz','pDtProgettista_1_1_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="first" >


<!-- widget pDtProgettista_1_1_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpCompilaz','pDtProgettista_1_2_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2"  >


<!-- widget pDtProgettista_1_2_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" />
</s:else>


	
<s:if test="isWidgetVisible('cpCompilaz','pDtProgettista_1_3_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2"  >


<!-- widget pDtProgettista_1_3_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" />
</s:else>


	
<s:if test="isWidgetVisible('cpCompilaz','pDtProgettista_1_4_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget pDtProgettista_1_4_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpCompilaz','tfNomeProgettista')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpCompilaz.tfNomeProgettista.label')}" labelFor="widg_tfNomeProgettista" errorFor="appDatacertificato.datiAnagraficiImm.dtResponsabili.dtProgettista.nome" labelId="tfNomeProgettistaLbl"
	position="first" colSpan="7" >


<!-- widget tfNomeProgettista -->
<s:textfield 
	
	
	name="appDatacertificato.datiAnagraficiImm.dtResponsabili.dtProgettista.nome" id="widg_tfNomeProgettista"
maxlength="30"	disabled="isWidgetDisabled('cpCompilaz','tfNomeProgettista')"
	size="15" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpCompilaz','tfCognomeProgettista')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpCompilaz.tfCognomeProgettista.label')}" labelFor="widg_tfCognomeProgettista" errorFor="appDatacertificato.datiAnagraficiImm.dtResponsabili.dtProgettista.cognome" labelId="tfCognomeProgettistaLbl"
	position="first" colSpan="7" >


<!-- widget tfCognomeProgettista -->
<s:textfield 
	
	
	name="appDatacertificato.datiAnagraficiImm.dtResponsabili.dtProgettista.cognome" id="widg_tfCognomeProgettista"
maxlength="50"	disabled="isWidgetDisabled('cpCompilaz','tfCognomeProgettista')"
	size="15" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpCompilaz','cbRegProgettista')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpCompilaz.cbRegProgettista.label')}" labelFor="widg_cbRegProgettista" errorFor="appDatacertificato.datiAnagraficiImm.dtResponsabili.dtProgettista.codReg" labelId="cbRegProgettistaLbl"
	position="first" colSpan="7" >


<!-- widget cbRegProgettista -->

<s:url id="widg_cbRegProgettistaurlComboBoxValueChange"
   action="/siceeweb/cpCompilaz!handleCbRegProgettista_VALUE_CHANGED" namespace="/base/compilazattestati"  
   includeParams="all" portletUrlType="action" 
/>
<s:select name="appDatacertificato.datiAnagraficiImm.dtResponsabili.dtProgettista.codReg" id="widg_cbRegProgettista"
	 
	

		title=" - Attenzione. Dopo aver selezionato un valore, la pagina verra' aggiornata automaticamente"
			
	  headerKey="" headerValue="" 
	  list="appDataregioniCertProgettista"
	  disabled="isWidgetDisabled('cpCompilaz','cbRegProgettista')"
	  listKey="cod"
	  listValue="nome"
	  onclick="onCBClick(this,'confermacbRegProgettista','conferma','%{widg_cbRegProgettistaurlComboBoxValueChange}')" onfocus="inFocus(this)" onblur="lostFocus(this,'confermacbRegProgettista','conferma','%{widg_cbRegProgettistaurlComboBoxValueChange}')" 
	  />


	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpCompilaz','cbProvProgettista')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpCompilaz.cbProvProgettista.label')}" labelFor="widg_cbProvProgettista" errorFor="appDatacertificato.datiAnagraficiImm.dtResponsabili.dtProgettista.codProv" labelId="cbProvProgettistaLbl"
	position="first" colSpan="7" >


<!-- widget cbProvProgettista -->

<s:url id="widg_cbProvProgettistaurlComboBoxValueChange"
   action="/siceeweb/cpCompilaz!handleCbProvProgettista_VALUE_CHANGED" namespace="/base/compilazattestati"  
   includeParams="all" portletUrlType="action" 
/>
<s:select name="appDatacertificato.datiAnagraficiImm.dtResponsabili.dtProgettista.codProv" id="widg_cbProvProgettista"
	 
	

		title=" - Attenzione. Dopo aver selezionato un valore, la pagina verra' aggiornata automaticamente"
			
	  headerKey="" headerValue="" 
	  list="appDataprovinceCertProgettista"
	  disabled="isWidgetDisabled('cpCompilaz','cbProvProgettista')"
	  listKey="cod"
	  listValue="nome"
	  onclick="onCBClick(this,'confermacbProvProgettista','conferma','%{widg_cbProvProgettistaurlComboBoxValueChange}')" onfocus="inFocus(this)" onblur="lostFocus(this,'confermacbProvProgettista','conferma','%{widg_cbProvProgettistaurlComboBoxValueChange}')" 
	  />


	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpCompilaz','cbComProgettista')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpCompilaz.cbComProgettista.label')}" labelFor="widg_cbComProgettista" errorFor="appDatacertificato.datiAnagraficiImm.dtResponsabili.dtProgettista.codComune" labelId="cbComProgettistaLbl"
	position="first" colSpan="7" >


<!-- widget cbComProgettista -->

<s:url id="widg_cbComProgettistaurlComboBoxValueChange"
   action="/siceeweb/cpCompilaz!handleCbComProgettista_VALUE_CHANGED" namespace="/base/compilazattestati"  
   includeParams="all" portletUrlType="action" 
/>
<s:select name="appDatacertificato.datiAnagraficiImm.dtResponsabili.dtProgettista.codComune" id="widg_cbComProgettista"
	 
	

		title=" - Attenzione. Dopo aver selezionato un valore, la pagina verra' aggiornata automaticamente"
			
	  headerKey="" headerValue="" 
	  list="appDatacomuniCertProgettista"
	  disabled="isWidgetDisabled('cpCompilaz','cbComProgettista')"
	  listKey="cod"
	  listValue="nome"
	  onclick="onCBClick(this,'confermacbComProgettista','conferma','%{widg_cbComProgettistaurlComboBoxValueChange}')" onfocus="inFocus(this)" onblur="lostFocus(this,'confermacbComProgettista','conferma','%{widg_cbComProgettistaurlComboBoxValueChange}')" 
	  />


	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpCompilaz','tfIndirizzoProgettista')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpCompilaz.tfIndirizzoProgettista.label')}" labelFor="widg_tfIndirizzoProgettista" errorFor="appDatacertificato.datiAnagraficiImm.dtResponsabili.dtProgettista.descrIndirizzo" labelId="tfIndirizzoProgettistaLbl"
	position="first" colSpan="3" >


<!-- widget tfIndirizzoProgettista -->
<s:textfield 
	
	
	name="appDatacertificato.datiAnagraficiImm.dtResponsabili.dtProgettista.descrIndirizzo" id="widg_tfIndirizzoProgettista"
maxlength="30"	disabled="isWidgetDisabled('cpCompilaz','tfIndirizzoProgettista')"
	size="50" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="4" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpCompilaz','vVerifIndProgettista')" >

	
<customtag:widgetsPanelColumn colSpan="2" >


<!-- widget vVerifIndProgettista -->
<s:submit name="widg_vVerifIndProgettista" id="widg_vVerifIndProgettista" method="handleVVerifIndProgettista_CLICKED"
	key="cpCompilaz.vVerifIndProgettista.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpCompilaz','vVerifIndProgettista')" />

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" />
</s:else>


	
<s:if test="isWidgetVisible('cpCompilaz','cbSceltaIndProgettista')" >

	
<customtag:widgetsPanelColumn 
	position="last" colSpan="2" >


<!-- widget cbSceltaIndProgettista -->

<s:url id="widg_cbSceltaIndProgettistaurlComboBoxValueChange"
   action="/siceeweb/cpCompilaz!handleCbSceltaIndProgettista_VALUE_CHANGED" namespace="/base/compilazattestati"  
   includeParams="all" portletUrlType="action" 
/>
<s:select name="appDatasuggestIndirizzoCodProgettista" id="widg_cbSceltaIndProgettista"
	 
	

		title=" - Attenzione. Dopo aver selezionato un valore, la pagina verra' aggiornata automaticamente"
			
	  headerKey="" headerValue="" 
	  list="appDatasuggestIndirizzoCertProgettista"
	  disabled="isWidgetDisabled('cpCompilaz','cbSceltaIndProgettista')"
	  listKey="cod"
	  listValue="descr"
	  onclick="onCBClick(this,'confermacbSceltaIndProgettista','conferma','%{widg_cbSceltaIndProgettistaurlComboBoxValueChange}')" onfocus="inFocus(this)" onblur="lostFocus(this,'confermacbSceltaIndProgettista','conferma','%{widg_cbSceltaIndProgettistaurlComboBoxValueChange}')" 
	  />


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpCompilaz','tfNCivProgettista')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpCompilaz.tfNCivProgettista.label')}" labelFor="widg_tfNCivProgettista" errorFor="appDatacertificato.datiAnagraficiImm.dtResponsabili.dtProgettista.numCiv" labelId="tfNCivProgettistaLbl"
	position="first" colSpan="3" >


<!-- widget tfNCivProgettista -->
<s:textfield 
	
	
	name="appDatacertificato.datiAnagraficiImm.dtResponsabili.dtProgettista.numCiv" id="widg_tfNCivProgettista"
maxlength="10"	disabled="isWidgetDisabled('cpCompilaz','tfNCivProgettista')"
	size="15" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="4" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpCompilaz','tfCAPProgettista')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpCompilaz.tfCAPProgettista.label')}" labelFor="widg_tfCAPProgettista" errorFor="appDatacertificato.datiAnagraficiImm.dtResponsabili.dtProgettista.cap" labelId="tfCAPProgettistaLbl"
	position="last" colSpan="3" >


<!-- widget tfCAPProgettista -->
<s:textfield 
	
	
	name="appDatacertificato.datiAnagraficiImm.dtResponsabili.dtProgettista.cap" id="widg_tfCAPProgettista"
maxlength="5"	disabled="isWidgetDisabled('cpCompilaz','tfCAPProgettista')"
	size="15" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="4" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpCompilaz','tfTelProgettista')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpCompilaz.tfTelProgettista.label')}" labelFor="widg_tfTelProgettista" errorFor="appDatacertificato.datiAnagraficiImm.dtResponsabili.dtProgettista.tel" labelId="tfTelProgettistaLbl"
	position="first" colSpan="3" >


<!-- widget tfTelProgettista -->
<s:textfield 
	
	
	name="appDatacertificato.datiAnagraficiImm.dtResponsabili.dtProgettista.tel" id="widg_tfTelProgettista"
maxlength="20"	disabled="isWidgetDisabled('cpCompilaz','tfTelProgettista')"
	size="15" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="4" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpCompilaz','tfCellProgettista')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpCompilaz.tfCellProgettista.label')}" labelFor="widg_tfCellProgettista" errorFor="appDatacertificato.datiAnagraficiImm.dtResponsabili.dtProgettista.cell" labelId="tfCellProgettistaLbl"
	position="last" colSpan="3" >


<!-- widget tfCellProgettista -->
<s:textfield 
	
	
	name="appDatacertificato.datiAnagraficiImm.dtResponsabili.dtProgettista.cell" id="widg_tfCellProgettista"
maxlength="20"	disabled="isWidgetDisabled('cpCompilaz','tfCellProgettista')"
	size="15" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="4" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpCompilaz','tfEmailProgettista')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpCompilaz.tfEmailProgettista.label')}" labelFor="widg_tfEmailProgettista" errorFor="appDatacertificato.datiAnagraficiImm.dtResponsabili.dtProgettista.email" labelId="tfEmailProgettistaLbl"
	position="first" colSpan="3" >


<!-- widget tfEmailProgettista -->
<s:textfield 
	
	
	name="appDatacertificato.datiAnagraficiImm.dtResponsabili.dtProgettista.email" id="widg_tfEmailProgettista"
maxlength="70"	disabled="isWidgetDisabled('cpCompilaz','tfEmailProgettista')"
	size="15" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="4" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpCompilaz','tfFaxProgettista')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpCompilaz.tfFaxProgettista.label')}" labelFor="widg_tfFaxProgettista" errorFor="appDatacertificato.datiAnagraficiImm.dtResponsabili.dtProgettista.fax" labelId="tfFaxProgettistaLbl"
	position="last" colSpan="3" >


<!-- widget tfFaxProgettista -->
<s:textfield 
	
	
	name="appDatacertificato.datiAnagraficiImm.dtResponsabili.dtProgettista.fax" id="widg_tfFaxProgettista"
maxlength="30"	disabled="isWidgetDisabled('cpCompilaz','tfFaxProgettista')"
	size="15" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="4" position="last"/>
</s:else>



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_pDtProgettista --></div>

			
	
	<div id="p_pDtDirLav" class="widgetsPanelBlock"><!-- startFragment:p_pDtDirLav -->
	
	
<h4 class="wpLabel">Direttore lavori </h4>
<div class="widgetsPanel" id="pDtDirLav">
	
	<customtag:widgetsPanel id="pDtDirLavTbl" columns="8" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('cpCompilaz','pDtDirLav_1_1_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="first" >


<!-- widget pDtDirLav_1_1_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpCompilaz','pDtDirLav_1_2_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2"  >


<!-- widget pDtDirLav_1_2_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" />
</s:else>


	
<s:if test="isWidgetVisible('cpCompilaz','pDtDirLav_1_3_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2"  >


<!-- widget pDtDirLav_1_3_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" />
</s:else>


	
<s:if test="isWidgetVisible('cpCompilaz','pDtDirLav_1_4_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget pDtDirLav_1_4_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpCompilaz','tfNomeDirLav')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpCompilaz.tfNomeDirLav.label')}" labelFor="widg_tfNomeDirLav" errorFor="appDatacertificato.datiAnagraficiImm.dtResponsabili.dtDirLavori.nome" labelId="tfNomeDirLavLbl"
	position="first" colSpan="7" >


<!-- widget tfNomeDirLav -->
<s:textfield 
	
	
	name="appDatacertificato.datiAnagraficiImm.dtResponsabili.dtDirLavori.nome" id="widg_tfNomeDirLav"
maxlength="30"	disabled="isWidgetDisabled('cpCompilaz','tfNomeDirLav')"
	size="15" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpCompilaz','tfCognomeDirLav')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpCompilaz.tfCognomeDirLav.label')}" labelFor="widg_tfCognomeDirLav" errorFor="appDatacertificato.datiAnagraficiImm.dtResponsabili.dtDirLavori.cognome" labelId="tfCognomeDirLavLbl"
	position="first" colSpan="7" >


<!-- widget tfCognomeDirLav -->
<s:textfield 
	
	
	name="appDatacertificato.datiAnagraficiImm.dtResponsabili.dtDirLavori.cognome" id="widg_tfCognomeDirLav"
maxlength="50"	disabled="isWidgetDisabled('cpCompilaz','tfCognomeDirLav')"
	size="15" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpCompilaz','cbRegDirLav')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpCompilaz.cbRegDirLav.label')}" labelFor="widg_cbRegDirLav" errorFor="appDatacertificato.datiAnagraficiImm.dtResponsabili.dtDirLavori.codReg" labelId="cbRegDirLavLbl"
	position="first" colSpan="7" >


<!-- widget cbRegDirLav -->

<s:url id="widg_cbRegDirLavurlComboBoxValueChange"
   action="/siceeweb/cpCompilaz!handleCbRegDirLav_VALUE_CHANGED" namespace="/base/compilazattestati"  
   includeParams="all" portletUrlType="action" 
/>
<s:select name="appDatacertificato.datiAnagraficiImm.dtResponsabili.dtDirLavori.codReg" id="widg_cbRegDirLav"
	 
	

		title=" - Attenzione. Dopo aver selezionato un valore, la pagina verra' aggiornata automaticamente"
			
	  headerKey="" headerValue="" 
	  list="appDataregioniCertDirLav"
	  disabled="isWidgetDisabled('cpCompilaz','cbRegDirLav')"
	  listKey="cod"
	  listValue="nome"
	  onclick="onCBClick(this,'confermacbRegDirLav','conferma','%{widg_cbRegDirLavurlComboBoxValueChange}')" onfocus="inFocus(this)" onblur="lostFocus(this,'confermacbRegDirLav','conferma','%{widg_cbRegDirLavurlComboBoxValueChange}')" 
	  />


	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpCompilaz','cbProvDirLav')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpCompilaz.cbProvDirLav.label')}" labelFor="widg_cbProvDirLav" errorFor="appDatacertificato.datiAnagraficiImm.dtResponsabili.dtDirLavori.codProv" labelId="cbProvDirLavLbl"
	position="first" colSpan="7" >


<!-- widget cbProvDirLav -->

<s:url id="widg_cbProvDirLavurlComboBoxValueChange"
   action="/siceeweb/cpCompilaz!handleCbProvDirLav_VALUE_CHANGED" namespace="/base/compilazattestati"  
   includeParams="all" portletUrlType="action" 
/>
<s:select name="appDatacertificato.datiAnagraficiImm.dtResponsabili.dtDirLavori.codProv" id="widg_cbProvDirLav"
	 
	

		title=" - Attenzione. Dopo aver selezionato un valore, la pagina verra' aggiornata automaticamente"
			
	  headerKey="" headerValue="" 
	  list="appDataprovinceCertDirLav"
	  disabled="isWidgetDisabled('cpCompilaz','cbProvDirLav')"
	  listKey="cod"
	  listValue="nome"
	  onclick="onCBClick(this,'confermacbProvDirLav','conferma','%{widg_cbProvDirLavurlComboBoxValueChange}')" onfocus="inFocus(this)" onblur="lostFocus(this,'confermacbProvDirLav','conferma','%{widg_cbProvDirLavurlComboBoxValueChange}')" 
	  />


	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpCompilaz','cbComDirLav')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpCompilaz.cbComDirLav.label')}" labelFor="widg_cbComDirLav" errorFor="appDatacertificato.datiAnagraficiImm.dtResponsabili.dtDirLavori.codComune" labelId="cbComDirLavLbl"
	position="first" colSpan="7" >


<!-- widget cbComDirLav -->

<s:url id="widg_cbComDirLavurlComboBoxValueChange"
   action="/siceeweb/cpCompilaz!handleCbComDirLav_VALUE_CHANGED" namespace="/base/compilazattestati"  
   includeParams="all" portletUrlType="action" 
/>
<s:select name="appDatacertificato.datiAnagraficiImm.dtResponsabili.dtDirLavori.codComune" id="widg_cbComDirLav"
	 
	

		title=" - Attenzione. Dopo aver selezionato un valore, la pagina verra' aggiornata automaticamente"
			
	  headerKey="" headerValue="" 
	  list="appDatacomuniCertDirLav"
	  disabled="isWidgetDisabled('cpCompilaz','cbComDirLav')"
	  listKey="cod"
	  listValue="nome"
	  onclick="onCBClick(this,'confermacbComDirLav','conferma','%{widg_cbComDirLavurlComboBoxValueChange}')" onfocus="inFocus(this)" onblur="lostFocus(this,'confermacbComDirLav','conferma','%{widg_cbComDirLavurlComboBoxValueChange}')" 
	  />


	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpCompilaz','tfIndirizzoDirLav')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpCompilaz.tfIndirizzoDirLav.label')}" labelFor="widg_tfIndirizzoDirLav" errorFor="appDatacertificato.datiAnagraficiImm.dtResponsabili.dtDirLavori.descrIndirizzo" labelId="tfIndirizzoDirLavLbl"
	position="first" colSpan="3" >


<!-- widget tfIndirizzoDirLav -->
<s:textfield 
	
	
	name="appDatacertificato.datiAnagraficiImm.dtResponsabili.dtDirLavori.descrIndirizzo" id="widg_tfIndirizzoDirLav"
maxlength="30"	disabled="isWidgetDisabled('cpCompilaz','tfIndirizzoDirLav')"
	size="50" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="4" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpCompilaz','vVerifIndDirLav')" >

	
<customtag:widgetsPanelColumn colSpan="2" >


<!-- widget vVerifIndDirLav -->
<s:submit name="widg_vVerifIndDirLav" id="widg_vVerifIndDirLav" method="handleVVerifIndDirLav_CLICKED"
	key="cpCompilaz.vVerifIndDirLav.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpCompilaz','vVerifIndDirLav')" />

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" />
</s:else>


	
<s:if test="isWidgetVisible('cpCompilaz','cbSceltaIndDirLav')" >

	
<customtag:widgetsPanelColumn 
	position="last" colSpan="2" >


<!-- widget cbSceltaIndDirLav -->

<s:url id="widg_cbSceltaIndDirLavurlComboBoxValueChange"
   action="/siceeweb/cpCompilaz!handleCbSceltaIndDirLav_VALUE_CHANGED" namespace="/base/compilazattestati"  
   includeParams="all" portletUrlType="action" 
/>
<s:select name="appDatasuggestIndirizzoCodDirLav" id="widg_cbSceltaIndDirLav"
	 
	

		title=" - Attenzione. Dopo aver selezionato un valore, la pagina verra' aggiornata automaticamente"
			
	  headerKey="" headerValue="" 
	  list="appDatasuggestIndirizzoCertDirLav"
	  disabled="isWidgetDisabled('cpCompilaz','cbSceltaIndDirLav')"
	  listKey="cod"
	  listValue="descr"
	  onclick="onCBClick(this,'confermacbSceltaIndDirLav','conferma','%{widg_cbSceltaIndDirLavurlComboBoxValueChange}')" onfocus="inFocus(this)" onblur="lostFocus(this,'confermacbSceltaIndDirLav','conferma','%{widg_cbSceltaIndDirLavurlComboBoxValueChange}')" 
	  />


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpCompilaz','tfNCivDirLav')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpCompilaz.tfNCivDirLav.label')}" labelFor="widg_tfNCivDirLav" errorFor="appDatacertificato.datiAnagraficiImm.dtResponsabili.dtDirLavori.numCiv" labelId="tfNCivDirLavLbl"
	position="first" colSpan="3" >


<!-- widget tfNCivDirLav -->
<s:textfield 
	
	
	name="appDatacertificato.datiAnagraficiImm.dtResponsabili.dtDirLavori.numCiv" id="widg_tfNCivDirLav"
maxlength="10"	disabled="isWidgetDisabled('cpCompilaz','tfNCivDirLav')"
	size="15" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="4" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpCompilaz','tfCAPDirLav')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpCompilaz.tfCAPDirLav.label')}" labelFor="widg_tfCAPDirLav" errorFor="appDatacertificato.datiAnagraficiImm.dtResponsabili.dtDirLavori.cap" labelId="tfCAPDirLavLbl"
	position="last" colSpan="3" >


<!-- widget tfCAPDirLav -->
<s:textfield 
	
	
	name="appDatacertificato.datiAnagraficiImm.dtResponsabili.dtDirLavori.cap" id="widg_tfCAPDirLav"
maxlength="5"	disabled="isWidgetDisabled('cpCompilaz','tfCAPDirLav')"
	size="15" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="4" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpCompilaz','tfTelDirLav')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpCompilaz.tfTelDirLav.label')}" labelFor="widg_tfTelDirLav" errorFor="appDatacertificato.datiAnagraficiImm.dtResponsabili.dtDirLavori.tel" labelId="tfTelDirLavLbl"
	position="first" colSpan="3" >


<!-- widget tfTelDirLav -->
<s:textfield 
	
	
	name="appDatacertificato.datiAnagraficiImm.dtResponsabili.dtDirLavori.tel" id="widg_tfTelDirLav"
maxlength="20"	disabled="isWidgetDisabled('cpCompilaz','tfTelDirLav')"
	size="15" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="4" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpCompilaz','tfCellDirLav')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpCompilaz.tfCellDirLav.label')}" labelFor="widg_tfCellDirLav" errorFor="appDatacertificato.datiAnagraficiImm.dtResponsabili.dtDirLavori.cell" labelId="tfCellDirLavLbl"
	position="last" colSpan="3" >


<!-- widget tfCellDirLav -->
<s:textfield 
	
	
	name="appDatacertificato.datiAnagraficiImm.dtResponsabili.dtDirLavori.cell" id="widg_tfCellDirLav"
maxlength="20"	disabled="isWidgetDisabled('cpCompilaz','tfCellDirLav')"
	size="15" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="4" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpCompilaz','tfEmailDirLav')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpCompilaz.tfEmailDirLav.label')}" labelFor="widg_tfEmailDirLav" errorFor="appDatacertificato.datiAnagraficiImm.dtResponsabili.dtDirLavori.email" labelId="tfEmailDirLavLbl"
	position="first" colSpan="3" >


<!-- widget tfEmailDirLav -->
<s:textfield 
	
	
	name="appDatacertificato.datiAnagraficiImm.dtResponsabili.dtDirLavori.email" id="widg_tfEmailDirLav"
maxlength="70"	disabled="isWidgetDisabled('cpCompilaz','tfEmailDirLav')"
	size="15" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="4" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpCompilaz','tfFaxDirLav')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpCompilaz.tfFaxDirLav.label')}" labelFor="widg_tfFaxDirLav" errorFor="appDatacertificato.datiAnagraficiImm.dtResponsabili.dtDirLavori.fax" labelId="tfFaxDirLavLbl"
	position="last" colSpan="3" >


<!-- widget tfFaxDirLav -->
<s:textfield 
	
	
	name="appDatacertificato.datiAnagraficiImm.dtResponsabili.dtDirLavori.fax" id="widg_tfFaxDirLav"
maxlength="30"	disabled="isWidgetDisabled('cpCompilaz','tfFaxDirLav')"
	size="15" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="4" position="last"/>
</s:else>



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_pDtDirLav --></div>

			
	
	<div id="p_pDtCostr" class="widgetsPanelBlock"><!-- startFragment:p_pDtCostr -->
	
	
<h4 class="wpLabel">Costruttore </h4>
<div class="widgetsPanel" id="pDtCostr">
	
	<customtag:widgetsPanel id="pDtCostrTbl" columns="8" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('cpCompilaz','pDtCostr_1_1_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="first" >


<!-- widget pDtCostr_1_1_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpCompilaz','pDtCostr_1_2_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2"  >


<!-- widget pDtCostr_1_2_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" />
</s:else>


	
<s:if test="isWidgetVisible('cpCompilaz','pDtCostr_1_3_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2"  >


<!-- widget pDtCostr_1_3_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" />
</s:else>


	
<s:if test="isWidgetVisible('cpCompilaz','pDtCostr_1_4_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget pDtCostr_1_4_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpCompilaz','tfNomeCostr')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpCompilaz.tfNomeCostr.label')}" labelFor="widg_tfNomeCostr" errorFor="appDatacertificato.datiAnagraficiImm.dtResponsabili.dtCostruttore.nome" labelId="tfNomeCostrLbl"
	position="first" colSpan="7" >


<!-- widget tfNomeCostr -->
<s:textfield 
	
	
	name="appDatacertificato.datiAnagraficiImm.dtResponsabili.dtCostruttore.nome" id="widg_tfNomeCostr"
maxlength="30"	disabled="isWidgetDisabled('cpCompilaz','tfNomeCostr')"
	size="15" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpCompilaz','tfCognomeCostr')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpCompilaz.tfCognomeCostr.label')}" labelFor="widg_tfCognomeCostr" errorFor="appDatacertificato.datiAnagraficiImm.dtResponsabili.dtCostruttore.cognome" labelId="tfCognomeCostrLbl"
	position="first" colSpan="7" >


<!-- widget tfCognomeCostr -->
<s:textfield 
	
	
	name="appDatacertificato.datiAnagraficiImm.dtResponsabili.dtCostruttore.cognome" id="widg_tfCognomeCostr"
maxlength="50"	disabled="isWidgetDisabled('cpCompilaz','tfCognomeCostr')"
	size="15" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpCompilaz','cbRegCostr')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpCompilaz.cbRegCostr.label')}" labelFor="widg_cbRegCostr" errorFor="appDatacertificato.datiAnagraficiImm.dtResponsabili.dtCostruttore.codReg" labelId="cbRegCostrLbl"
	position="first" colSpan="7" >


<!-- widget cbRegCostr -->

<s:url id="widg_cbRegCostrurlComboBoxValueChange"
   action="/siceeweb/cpCompilaz!handleCbRegCostr_VALUE_CHANGED" namespace="/base/compilazattestati"  
   includeParams="all" portletUrlType="action" 
/>
<s:select name="appDatacertificato.datiAnagraficiImm.dtResponsabili.dtCostruttore.codReg" id="widg_cbRegCostr"
	 
	

		title=" - Attenzione. Dopo aver selezionato un valore, la pagina verra' aggiornata automaticamente"
			
	  headerKey="" headerValue="" 
	  list="appDataregioniCertCostr"
	  disabled="isWidgetDisabled('cpCompilaz','cbRegCostr')"
	  listKey="cod"
	  listValue="nome"
	  onclick="onCBClick(this,'confermacbRegCostr','conferma','%{widg_cbRegCostrurlComboBoxValueChange}')" onfocus="inFocus(this)" onblur="lostFocus(this,'confermacbRegCostr','conferma','%{widg_cbRegCostrurlComboBoxValueChange}')" 
	  />


	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpCompilaz','cbProvCostr')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpCompilaz.cbProvCostr.label')}" labelFor="widg_cbProvCostr" errorFor="appDatacertificato.datiAnagraficiImm.dtResponsabili.dtCostruttore.codProv" labelId="cbProvCostrLbl"
	position="first" colSpan="7" >


<!-- widget cbProvCostr -->

<s:url id="widg_cbProvCostrurlComboBoxValueChange"
   action="/siceeweb/cpCompilaz!handleCbProvCostr_VALUE_CHANGED" namespace="/base/compilazattestati"  
   includeParams="all" portletUrlType="action" 
/>
<s:select name="appDatacertificato.datiAnagraficiImm.dtResponsabili.dtCostruttore.codProv" id="widg_cbProvCostr"
	 
	

		title=" - Attenzione. Dopo aver selezionato un valore, la pagina verra' aggiornata automaticamente"
			
	  headerKey="" headerValue="" 
	  list="appDataprovinceCertCostr"
	  disabled="isWidgetDisabled('cpCompilaz','cbProvCostr')"
	  listKey="cod"
	  listValue="nome"
	  onclick="onCBClick(this,'confermacbProvCostr','conferma','%{widg_cbProvCostrurlComboBoxValueChange}')" onfocus="inFocus(this)" onblur="lostFocus(this,'confermacbProvCostr','conferma','%{widg_cbProvCostrurlComboBoxValueChange}')" 
	  />


	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpCompilaz','cbComCostr')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpCompilaz.cbComCostr.label')}" labelFor="widg_cbComCostr" errorFor="appDatacertificato.datiAnagraficiImm.dtResponsabili.dtCostruttore.codComune" labelId="cbComCostrLbl"
	position="first" colSpan="7" >


<!-- widget cbComCostr -->

<s:url id="widg_cbComCostrurlComboBoxValueChange"
   action="/siceeweb/cpCompilaz!handleCbComCostr_VALUE_CHANGED" namespace="/base/compilazattestati"  
   includeParams="all" portletUrlType="action" 
/>
<s:select name="appDatacertificato.datiAnagraficiImm.dtResponsabili.dtCostruttore.codComune" id="widg_cbComCostr"
	 
	

		title=" - Attenzione. Dopo aver selezionato un valore, la pagina verra' aggiornata automaticamente"
			
	  headerKey="" headerValue="" 
	  list="appDatacomuniCertCostr"
	  disabled="isWidgetDisabled('cpCompilaz','cbComCostr')"
	  listKey="cod"
	  listValue="nome"
	  onclick="onCBClick(this,'confermacbComCostr','conferma','%{widg_cbComCostrurlComboBoxValueChange}')" onfocus="inFocus(this)" onblur="lostFocus(this,'confermacbComCostr','conferma','%{widg_cbComCostrurlComboBoxValueChange}')" 
	  />


	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpCompilaz','tfIndirizzoCostr')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpCompilaz.tfIndirizzoCostr.label')}" labelFor="widg_tfIndirizzoCostr" errorFor="appDatacertificato.datiAnagraficiImm.dtResponsabili.dtCostruttore.descrIndirizzo" labelId="tfIndirizzoCostrLbl"
	position="first" colSpan="3" >


<!-- widget tfIndirizzoCostr -->
<s:textfield 
	
	
	name="appDatacertificato.datiAnagraficiImm.dtResponsabili.dtCostruttore.descrIndirizzo" id="widg_tfIndirizzoCostr"
maxlength="30"	disabled="isWidgetDisabled('cpCompilaz','tfIndirizzoCostr')"
	size="50" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="4" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpCompilaz','vVerifIndCostr')" >

	
<customtag:widgetsPanelColumn colSpan="2" >


<!-- widget vVerifIndCostr -->
<s:submit name="widg_vVerifIndCostr" id="widg_vVerifIndCostr" method="handleVVerifIndCostr_CLICKED"
	key="cpCompilaz.vVerifIndCostr.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpCompilaz','vVerifIndCostr')" />

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" />
</s:else>


	
<s:if test="isWidgetVisible('cpCompilaz','cbSceltaIndCostr')" >

	
<customtag:widgetsPanelColumn 
	position="last" colSpan="2" >


<!-- widget cbSceltaIndCostr -->

<s:url id="widg_cbSceltaIndCostrurlComboBoxValueChange"
   action="/siceeweb/cpCompilaz!handleCbSceltaIndCostr_VALUE_CHANGED" namespace="/base/compilazattestati"  
   includeParams="all" portletUrlType="action" 
/>
<s:select name="appDatasuggestIndirizzoCodCostr" id="widg_cbSceltaIndCostr"
	 
	

		title=" - Attenzione. Dopo aver selezionato un valore, la pagina verra' aggiornata automaticamente"
			
	  headerKey="" headerValue="" 
	  list="appDatasuggestIndirizzoCertCostr"
	  disabled="isWidgetDisabled('cpCompilaz','cbSceltaIndCostr')"
	  listKey="cod"
	  listValue="descr"
	  onclick="onCBClick(this,'confermacbSceltaIndCostr','conferma','%{widg_cbSceltaIndCostrurlComboBoxValueChange}')" onfocus="inFocus(this)" onblur="lostFocus(this,'confermacbSceltaIndCostr','conferma','%{widg_cbSceltaIndCostrurlComboBoxValueChange}')" 
	  />


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpCompilaz','tfNCivCostr')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpCompilaz.tfNCivCostr.label')}" labelFor="widg_tfNCivCostr" errorFor="appDatacertificato.datiAnagraficiImm.dtResponsabili.dtCostruttore.numCiv" labelId="tfNCivCostrLbl"
	position="first" colSpan="3" >


<!-- widget tfNCivCostr -->
<s:textfield 
	
	
	name="appDatacertificato.datiAnagraficiImm.dtResponsabili.dtCostruttore.numCiv" id="widg_tfNCivCostr"
maxlength="10"	disabled="isWidgetDisabled('cpCompilaz','tfNCivCostr')"
	size="15" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="4" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpCompilaz','tfCAPCostr')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpCompilaz.tfCAPCostr.label')}" labelFor="widg_tfCAPCostr" errorFor="appDatacertificato.datiAnagraficiImm.dtResponsabili.dtCostruttore.cap" labelId="tfCAPCostrLbl"
	position="last" colSpan="3" >


<!-- widget tfCAPCostr -->
<s:textfield 
	
	
	name="appDatacertificato.datiAnagraficiImm.dtResponsabili.dtCostruttore.cap" id="widg_tfCAPCostr"
maxlength="5"	disabled="isWidgetDisabled('cpCompilaz','tfCAPCostr')"
	size="15" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="4" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpCompilaz','tfTelCostr')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpCompilaz.tfTelCostr.label')}" labelFor="widg_tfTelCostr" errorFor="appDatacertificato.datiAnagraficiImm.dtResponsabili.dtCostruttore.tel" labelId="tfTelCostrLbl"
	position="first" colSpan="3" >


<!-- widget tfTelCostr -->
<s:textfield 
	
	
	name="appDatacertificato.datiAnagraficiImm.dtResponsabili.dtCostruttore.tel" id="widg_tfTelCostr"
maxlength="20"	disabled="isWidgetDisabled('cpCompilaz','tfTelCostr')"
	size="15" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="4" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpCompilaz','tfCellCostr')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpCompilaz.tfCellCostr.label')}" labelFor="widg_tfCellCostr" errorFor="appDatacertificato.datiAnagraficiImm.dtResponsabili.dtCostruttore.cell" labelId="tfCellCostrLbl"
	position="last" colSpan="3" >


<!-- widget tfCellCostr -->
<s:textfield 
	
	
	name="appDatacertificato.datiAnagraficiImm.dtResponsabili.dtCostruttore.cell" id="widg_tfCellCostr"
maxlength="20"	disabled="isWidgetDisabled('cpCompilaz','tfCellCostr')"
	size="15" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="4" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpCompilaz','tfEmailCostr')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpCompilaz.tfEmailCostr.label')}" labelFor="widg_tfEmailCostr" errorFor="appDatacertificato.datiAnagraficiImm.dtResponsabili.dtCostruttore.email" labelId="tfEmailCostrLbl"
	position="first" colSpan="3" >


<!-- widget tfEmailCostr -->
<s:textfield 
	
	
	name="appDatacertificato.datiAnagraficiImm.dtResponsabili.dtCostruttore.email" id="widg_tfEmailCostr"
maxlength="70"	disabled="isWidgetDisabled('cpCompilaz','tfEmailCostr')"
	size="15" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="4" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpCompilaz','tfFaxCostr')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpCompilaz.tfFaxCostr.label')}" labelFor="widg_tfFaxCostr" errorFor="appDatacertificato.datiAnagraficiImm.dtResponsabili.dtCostruttore.fax" labelId="tfFaxCostrLbl"
	position="last" colSpan="3" >


<!-- widget tfFaxCostr -->
<s:textfield 
	
	
	name="appDatacertificato.datiAnagraficiImm.dtResponsabili.dtCostruttore.fax" id="widg_tfFaxCostr"
maxlength="30"	disabled="isWidgetDisabled('cpCompilaz','tfFaxCostr')"
	size="15" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="4" position="last"/>
</s:else>



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_pDtCostr --></div>

			
	
	<div id="p_pDtResponsNav" class="commandPanelBlock"><!-- startFragment:p_pDtResponsNav -->
	
	
<div class="commandPanel navigation" id="pDtResponsNav">

	
	
		

	
	
	
	<div class="button left">
		
<s:if test="isWidgetVisible('cpCompilaz','bDtResponsIndietro')" >

	



<!-- widget bDtResponsIndietro -->
	<csiuicore:ajaxify id="p_pWizCompilazLiv1" 
		widgetType="button"
		 
		requestUri="/siceeweb/base/compilazattestati/cpCompilaz!handleBDtResponsIndietro_CLICKED.do" 
		
		pageId="cpCompilaz" 
		formName="cpCompilaz"
		javascriptDetection="false">
<s:submit name="widg_bDtResponsIndietro" id="widg_bDtResponsIndietro" method="handleBDtResponsIndietro_CLICKED"
	key="cpCompilaz.bDtResponsIndietro.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpCompilaz','bDtResponsIndietro')" />

	</csiuicore:ajaxify>

	


</s:if>

	


	</div>
	
	

	
	
	
	

	
	
	
	<div class="button right">
		
<s:if test="isWidgetVisible('cpCompilaz','bDtResponsAvanti')" >

	



<!-- widget bDtResponsAvanti -->
	<csiuicore:ajaxify id="p_pWizCompilazLiv1" 
		widgetType="button"
		 
		requestUri="/siceeweb/base/compilazattestati/cpCompilaz!handleBDtResponsAvanti_CLICKED.do" 
		
		pageId="cpCompilaz" 
		formName="cpCompilaz"
		javascriptDetection="false">
<s:submit name="widg_bDtResponsAvanti" id="widg_bDtResponsAvanti" method="handleBDtResponsAvanti_CLICKED"
	key="cpCompilaz.bDtResponsAvanti.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpCompilaz','bDtResponsAvanti')" />

	</csiuicore:ajaxify>

	


</s:if>

	


	</div>
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_pDtResponsNav --></div>

	

		
	
</div>

	<!-- endFragment:p_pDatiResponsabili --></div>
