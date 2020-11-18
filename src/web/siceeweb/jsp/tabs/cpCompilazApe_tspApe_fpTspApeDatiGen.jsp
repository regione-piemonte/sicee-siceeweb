<%@taglib uri="/struts-tags" prefix="s" %>
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="/customtag" prefix="customtag" %>
<%@taglib uri="/csiuicore" prefix="csiuicore" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<fmt:setBundle basename="/it/csi/sicee/siceeweb/presentation/siceeweb/action/compilazattestatiape/CpCompilazApeAction" />

	
	<div id="p_fpTspApeDatiGen" class="formPanelBlock"><!-- startFragment:p_fpTspApeDatiGen -->
		
	
<div class="formPanel" id="fpTspApeDatiGen">


	
	

	
	
			
	
	<div id="p_pErrDtGenerali" class="stdMessagePanelBlock"><!-- startFragment:p_pErrDtGenerali -->
	
	
<div class="stdMessagePanel" id="pErrDtGenerali">
	<customtag:stdMessagePanel id="pErrDtGenerali" errorMessage="true" errorDetails="false" actionMessage="true" />
</div>

	<!-- endFragment:p_pErrDtGenerali --></div>

			
	
	<div id="p_wpDatiGenerali" class="widgetsPanelBlock"><!-- startFragment:p_wpDatiGenerali -->
	
	
<h4 class="wpLabel">Dati identificativi e di validita' certificato </h4>
<div class="widgetsPanel" id="wpDatiGenerali">
	
	<customtag:widgetsPanel id="wpDatiGeneraliTbl" columns="6" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('cpCompilazApe','txtObblDtCatastali')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="first" >


<!-- widget txtObblDtCatastali -->
<s:text name="cpCompilazApe.txtObblDtCatastali.statictext.label" />

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpCompilazApe','cbProvDtCatastali')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpCompilazApe.cbProvDtCatastali.label')}" labelFor="widg_cbProvDtCatastali" errorFor="appDatacertificato.datiAnagraficiImm.dtCatastali.codProv" labelId="cbProvDtCatastaliLbl"
	position="first"  >


<!-- widget cbProvDtCatastali -->

<s:url id="widg_cbProvDtCatastaliurlComboBoxValueChange"
   action="/siceeweb/cpCompilazApe!handleCbProvDtCatastali_VALUE_CHANGED" namespace="/base/compilazattestatiape"  
   includeParams="all" portletUrlType="action" 
/>
<s:select name="appDatacertificato.datiAnagraficiImm.dtCatastali.codProv" id="widg_cbProvDtCatastali"
	 
	

		title=" - Attenzione. Dopo aver selezionato un valore, la pagina verra' aggiornata automaticamente"
			
	  headerKey="" headerValue="" 
	  list="appDataprovinceCertDTCat"
	  disabled="isWidgetDisabled('cpCompilazApe','cbProvDtCatastali')"
	  listKey="cod"
	  listValue="nome"
	  onclick="onCBClick(this,'confermacbProvDtCatastali','conferma','%{widg_cbProvDtCatastaliurlComboBoxValueChange}')" onfocus="inFocus(this)" onblur="lostFocus(this,'confermacbProvDtCatastali','conferma','%{widg_cbProvDtCatastaliurlComboBoxValueChange}')" 
	  />


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpCompilazApe','cbComDtCatastali')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpCompilazApe.cbComDtCatastali.label')}" labelFor="widg_cbComDtCatastali" errorFor="appDatacertificato.datiAnagraficiImm.dtCatastali.codComune" labelId="cbComDtCatastaliLbl"
	position="first"  >


<!-- widget cbComDtCatastali -->

<s:url id="widg_cbComDtCatastaliurlComboBoxValueChange"
   action="/siceeweb/cpCompilazApe!handleCbComDtCatastali_VALUE_CHANGED" namespace="/base/compilazattestatiape"  
   includeParams="all" portletUrlType="action" 
/>
<s:select name="appDatacertificato.datiAnagraficiImm.dtCatastali.codComune" id="widg_cbComDtCatastali"
	 
	

		title=" - Attenzione. Dopo aver selezionato un valore, la pagina verra' aggiornata automaticamente"
			
	  headerKey="" headerValue="" 
	  list="appDatacomuniCertDtCat"
	  disabled="isWidgetDisabled('cpCompilazApe','cbComDtCatastali')"
	  listKey="cod"
	  listValue="nome"
	  onclick="onCBClick(this,'confermacbComDtCatastali','conferma','%{widg_cbComDtCatastaliurlComboBoxValueChange}')" onfocus="inFocus(this)" onblur="lostFocus(this,'confermacbComDtCatastali','conferma','%{widg_cbComDtCatastaliurlComboBoxValueChange}')" 
	  />


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpCompilazApe','txtZonaClimatica')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpCompilazApe.txtZonaClimatica.label')}" labelFor="widg_txtZonaClimatica" errorFor="appDatacertificato.datiAnagraficiImm.dtCatastali.zonaClimatica" labelId="txtZonaClimaticaLbl"   >


<!-- widget txtZonaClimatica -->
<s:property value="appDatacertificato.datiAnagraficiImm.dtCatastali.zonaClimatica" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" />
</s:else>


	
<s:if test="isWidgetVisible('cpCompilazApe','tfRicercaIndirizzo')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpCompilazApe.tfRicercaIndirizzo.label')}" labelFor="widg_tfRicercaIndirizzo" errorFor="appDatacertificato.datiAnagraficiImm.dtCatastali.ricercaIndirizzo" labelId="tfRicercaIndirizzoLbl"
	position="first"  >


<!-- widget tfRicercaIndirizzo -->
<s:textfield 
	
	
	name="appDatacertificato.datiAnagraficiImm.dtCatastali.ricercaIndirizzo" id="widg_tfRicercaIndirizzo"
maxlength="160"	disabled="isWidgetDisabled('cpCompilazApe','tfRicercaIndirizzo')"
	size="30" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpCompilazApe','vVerifIndDtCatastali')" >

	
<customtag:widgetsPanelColumn colSpan="2" >


<!-- widget vVerifIndDtCatastali -->
<s:submit name="widg_vVerifIndDtCatastali" id="widg_vVerifIndDtCatastali" method="handleVVerifIndDtCatastali_CLICKED"
	key="cpCompilazApe.vVerifIndDtCatastali.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpCompilazApe','vVerifIndDtCatastali')" />

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" />
</s:else>


	
<s:if test="isWidgetVisible('cpCompilazApe','wpDatiGenerali_4_3_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget wpDatiGenerali_4_3_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpCompilazApe','cbSceltaIndDtCatastali')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpCompilazApe.cbSceltaIndDtCatastali.label')}" labelFor="widg_cbSceltaIndDtCatastali" errorFor="appDatacertificato.datiAnagraficiImm.dtCatastali.codIndirizzo" labelId="cbSceltaIndDtCatastaliLbl"
	position="first"  >


<!-- widget cbSceltaIndDtCatastali -->
<s:select name="appDatacertificato.datiAnagraficiImm.dtCatastali.codIndirizzo" id="widg_cbSceltaIndDtCatastali"
	 
	
		title=""
			
	  headerKey="" headerValue="" 
	  list="appDatasuggestIndirizzoDtCat"
	  disabled="isWidgetDisabled('cpCompilazApe','cbSceltaIndDtCatastali')"
	  listKey="cod"
	  listValue="descr"
	  
	  />


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpCompilazApe','wpDatiGenerali_5_2_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2"  >


<!-- widget wpDatiGenerali_5_2_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" />
</s:else>


	
<s:if test="isWidgetVisible('cpCompilazApe','wpDatiGenerali_5_3_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget wpDatiGenerali_5_3_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpCompilazApe','tfIndirizzoDtCatastali')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpCompilazApe.tfIndirizzoDtCatastali.label')}" labelFor="widg_tfIndirizzoDtCatastali" errorFor="appDatacertificato.datiAnagraficiImm.dtCatastali.descrIndirizzo" labelId="tfIndirizzoDtCatastaliLbl"
	position="first"  >


<!-- widget tfIndirizzoDtCatastali -->
<s:textfield 
	
title=""	
	name="appDatacertificato.datiAnagraficiImm.dtCatastali.descrIndirizzo" id="widg_tfIndirizzoDtCatastali"
maxlength="160"	disabled="isWidgetDisabled('cpCompilazApe','tfIndirizzoDtCatastali')"
	size="30" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpCompilazApe','svuotaIndDtCatastaliText')" >

	
<customtag:widgetsPanelColumn colSpan="2" >


<!-- widget svuotaIndDtCatastaliText -->
<s:submit name="widg_svuotaIndDtCatastaliText" id="widg_svuotaIndDtCatastaliText" method="handleSvuotaIndDtCatastaliText_CLICKED"
	key="cpCompilazApe.svuotaIndDtCatastaliText.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpCompilazApe','svuotaIndDtCatastaliText')" />

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" />
</s:else>


	
<s:if test="isWidgetVisible('cpCompilazApe','wpDatiGenerali_6_3_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget wpDatiGenerali_6_3_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpCompilazApe','tfNCivDtCatastali')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpCompilazApe.tfNCivDtCatastali.label')}" labelFor="widg_tfNCivDtCatastali" errorFor="appDatacertificato.datiAnagraficiImm.dtCatastali.numCiv" labelId="tfNCivDtCatastaliLbl"
	position="first"  >


<!-- widget tfNCivDtCatastali -->
<s:textfield 
	
title=""	
	name="appDatacertificato.datiAnagraficiImm.dtCatastali.numCiv" id="widg_tfNCivDtCatastali"
maxlength="10"	disabled="isWidgetDisabled('cpCompilazApe','tfNCivDtCatastali')"
	size="9" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpCompilazApe','tfCAPDtCatastali')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpCompilazApe.tfCAPDtCatastali.label')}" labelFor="widg_tfCAPDtCatastali" errorFor="appDatacertificato.datiAnagraficiImm.dtCatastali.cap" labelId="tfCAPDtCatastaliLbl"
	  >


<!-- widget tfCAPDtCatastali -->
<s:textfield 
	
	
	name="appDatacertificato.datiAnagraficiImm.dtCatastali.cap" id="widg_tfCAPDtCatastali"
maxlength="5"	disabled="isWidgetDisabled('cpCompilazApe','tfCAPDtCatastali')"
	size="9" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" />
</s:else>


	
<s:if test="isWidgetVisible('cpCompilazApe','wpDatiGenerali_7_3_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget wpDatiGenerali_7_3_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpCompilazApe','tfInternoDtCatastali')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpCompilazApe.tfInternoDtCatastali.label')}" labelFor="widg_tfInternoDtCatastali" errorFor="appDatacertificato.datiAnagraficiImm.dtCatastali.interno" labelId="tfInternoDtCatastaliLbl"
	position="first"  >


<!-- widget tfInternoDtCatastali -->
<s:textfield 
	
	
	name="appDatacertificato.datiAnagraficiImm.dtCatastali.interno" id="widg_tfInternoDtCatastali"
maxlength="10"	disabled="isWidgetDisabled('cpCompilazApe','tfInternoDtCatastali')"
	size="9" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpCompilazApe','tfScalaDtCatastali')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpCompilazApe.tfScalaDtCatastali.label')}" labelFor="widg_tfScalaDtCatastali" errorFor="appDatacertificato.datiAnagraficiImm.dtCatastali.scala" labelId="tfScalaDtCatastaliLbl"
	  >


<!-- widget tfScalaDtCatastali -->
<s:textfield 
	
	
	name="appDatacertificato.datiAnagraficiImm.dtCatastali.scala" id="widg_tfScalaDtCatastali"
maxlength="10"	disabled="isWidgetDisabled('cpCompilazApe','tfScalaDtCatastali')"
	size="9" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" />
</s:else>


	
<s:if test="isWidgetVisible('cpCompilazApe','wpDatiGenerali_8_3_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget wpDatiGenerali_8_3_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpCompilazApe','tfPianoDtCatastali')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpCompilazApe.tfPianoDtCatastali.label')}" labelFor="widg_tfPianoDtCatastali" errorFor="appDatacertificato.datiAnagraficiImm.dtCatastali.piano" labelId="tfPianoDtCatastaliLbl"
	position="first"  >


<!-- widget tfPianoDtCatastali -->
<s:textfield 
	
	
	name="appDatacertificato.datiAnagraficiImm.dtCatastali.piano" id="widg_tfPianoDtCatastali"
maxlength="3"	disabled="isWidgetDisabled('cpCompilazApe','tfPianoDtCatastali')"
	size="9" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpCompilazApe','wpDatiGenerali_9_2_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2"  >


<!-- widget wpDatiGenerali_9_2_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" />
</s:else>


	
<s:if test="isWidgetVisible('cpCompilazApe','wpDatiGenerali_9_3_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget wpDatiGenerali_9_3_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpCompilazApe','tfNPianiComplessivi')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpCompilazApe.tfNPianiComplessivi.label')}" labelFor="widg_tfNPianiComplessivi" errorFor="appDatacertificato.datiAnagraficiImm.dtCatastali.pianiTot" labelId="tfNPianiComplessiviLbl"
	position="first"  >


<!-- widget tfNPianiComplessivi -->
<s:textfield 
	
	
	name="appDatacertificato.datiAnagraficiImm.dtCatastali.pianiTot" id="widg_tfNPianiComplessivi"
maxlength="10"	disabled="isWidgetDisabled('cpCompilazApe','tfNPianiComplessivi')"
	size="9" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpCompilazApe','tfNPianiFtRisc')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpCompilazApe.tfNPianiFtRisc.label')}" labelFor="widg_tfNPianiFtRisc" errorFor="appDatacertificato.datiAnagraficiImm.dtCatastali.numPianiFtRisc" labelId="tfNPianiFtRiscLbl"
	  >


<!-- widget tfNPianiFtRisc -->
<s:textfield 
	
	
	name="appDatacertificato.datiAnagraficiImm.dtCatastali.numPianiFtRisc" id="widg_tfNPianiFtRisc"
maxlength="10"	disabled="isWidgetDisabled('cpCompilazApe','tfNPianiFtRisc')"
	size="9" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" />
</s:else>


	
<s:if test="isWidgetVisible('cpCompilazApe','wpDatiGenerali_10_3_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget wpDatiGenerali_10_3_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpCompilazApe','tfIndirizzoCoordN')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpCompilazApe.tfIndirizzoCoordN.label')}" labelFor="widg_tfIndirizzoCoordN" errorFor="appDatacertificato.datiAnagraficiImm.dtCatastali.coordN" labelId="tfIndirizzoCoordNLbl"
	position="first"  >


<!-- widget tfIndirizzoCoordN -->
<s:textfield 
	
title=""	
	name="appDatacertificato.datiAnagraficiImm.dtCatastali.coordN" id="widg_tfIndirizzoCoordN"
maxlength="25"	disabled="isWidgetDisabled('cpCompilazApe','tfIndirizzoCoordN')"
	size="30" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpCompilazApe','tfIndirizzoCoordE')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpCompilazApe.tfIndirizzoCoordE.label')}" labelFor="widg_tfIndirizzoCoordE" errorFor="appDatacertificato.datiAnagraficiImm.dtCatastali.coordE" labelId="tfIndirizzoCoordELbl"
	  >


<!-- widget tfIndirizzoCoordE -->
<s:textfield 
	
title=""	
	name="appDatacertificato.datiAnagraficiImm.dtCatastali.coordE" id="widg_tfIndirizzoCoordE"
maxlength="25"	disabled="isWidgetDisabled('cpCompilazApe','tfIndirizzoCoordE')"
	size="30" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" />
</s:else>


	
<s:if test="isWidgetVisible('cpCompilazApe','bCercaCoordinate')" >

	
<customtag:widgetsPanelColumn colSpan="2" position="last">


<!-- widget bCercaCoordinate -->
<s:submit name="widg_bCercaCoordinate" id="widg_bCercaCoordinate" method="handleBCercaCoordinate_CLICKED"
	key="cpCompilazApe.bCercaCoordinate.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpCompilazApe','bCercaCoordinate')" />

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpCompilazApe','cbSistCatast')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpCompilazApe.cbSistCatast.label')}" labelFor="widg_cbSistCatast" errorFor="appDatacertificato.datiAnagraficiImm.dtCatastali.sistCatast" labelId="cbSistCatastLbl"
	position="first"  >


<!-- widget cbSistCatast -->
<s:select name="appDatacertificato.datiAnagraficiImm.dtCatastali.sistCatast" id="widg_cbSistCatast"
	 
	
		title=""
			
	   
	  list="appDatarifCatasto"
	  disabled="isWidgetDisabled('cpCompilazApe','cbSistCatast')"
	  listKey="codTipo"
	  listValue="descr"
	  
	  />


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpCompilazApe','wpDatiGenerali_12_2_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2"  >


<!-- widget wpDatiGenerali_12_2_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" />
</s:else>


	
<s:if test="isWidgetVisible('cpCompilazApe','wpDatiGenerali_12_3_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget wpDatiGenerali_12_3_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpCompilazApe','tfSezCatasto')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpCompilazApe.tfSezCatasto.label')}" labelFor="widg_tfSezCatasto" errorFor="appDatacertificato.datiAnagraficiImm.dtCatastali.sezione" labelId="tfSezCatastoLbl"
	position="first"  >


<!-- widget tfSezCatasto -->
<s:textfield 
	
	
	name="appDatacertificato.datiAnagraficiImm.dtCatastali.sezione" id="widg_tfSezCatasto"
maxlength="5"	disabled="isWidgetDisabled('cpCompilazApe','tfSezCatasto')"
	size="9" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpCompilazApe','tfFoglioCatasto')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpCompilazApe.tfFoglioCatasto.label')}" labelFor="widg_tfFoglioCatasto" errorFor="appDatacertificato.datiAnagraficiImm.dtCatastali.foglio" labelId="tfFoglioCatastoLbl"
	  >


<!-- widget tfFoglioCatasto -->
<s:textfield 
	
	
	name="appDatacertificato.datiAnagraficiImm.dtCatastali.foglio" id="widg_tfFoglioCatasto"
maxlength="5"	disabled="isWidgetDisabled('cpCompilazApe','tfFoglioCatasto')"
	size="9" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" />
</s:else>


	
<s:if test="isWidgetVisible('cpCompilazApe','wpDatiGenerali_13_3_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget wpDatiGenerali_13_3_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpCompilazApe','tfParticCatasto')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpCompilazApe.tfParticCatasto.label')}" labelFor="widg_tfParticCatasto" errorFor="appDatacertificato.datiAnagraficiImm.dtCatastali.particella" labelId="tfParticCatastoLbl"
	position="first"  >


<!-- widget tfParticCatasto -->
<s:textfield 
	
	
	name="appDatacertificato.datiAnagraficiImm.dtCatastali.particella" id="widg_tfParticCatasto"
maxlength="9"	disabled="isWidgetDisabled('cpCompilazApe','tfParticCatasto')"
	size="9" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpCompilazApe','tfSubaltCatasto')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpCompilazApe.tfSubaltCatasto.label')}" labelFor="widg_tfSubaltCatasto" errorFor="appDatacertificato.datiAnagraficiImm.dtCatastali.subalterno" labelId="tfSubaltCatastoLbl"
	  >


<!-- widget tfSubaltCatasto -->
<s:textfield 
	
	
	name="appDatacertificato.datiAnagraficiImm.dtCatastali.subalterno" id="widg_tfSubaltCatasto"
maxlength="4"	disabled="isWidgetDisabled('cpCompilazApe','tfSubaltCatasto')"
	size="9" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" />
</s:else>


	
<s:if test="isWidgetVisible('cpCompilazApe','wpDatiGenerali_14_3_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget wpDatiGenerali_14_3_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpCompilazApe','calDtEmissione')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpCompilazApe.calDtEmissione.label')}" labelFor="widg_calDtEmissione" errorFor="appDatacertificato.dichiarazioni.dataDichiarazione" labelId="calDtEmissioneLbl"
	position="first"  >


<!-- widget calDtEmissione -->
<s:textfield 
	
title=""	
	name="appDatacertificato.dichiarazioni.dataDichiarazione" id="widg_calDtEmissione"
	disabled="isWidgetDisabled('cpCompilazApe','calDtEmissione')"
	size="10" maxlength="10" 
	cssClass="calendar"
/> <div class="infoCalendar"></div>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpCompilazApe','rbTipoScadenza')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpCompilazApe.rbTipoScadenza.label')}" labelFor="widg_rbTipoScadenza" errorFor="appDatacertificato.idScadenza" labelId="rbTipoScadenzaLbl"
	  >


<!-- widget rbTipoScadenza -->

	
<div id="appDatacertificato.idScadenza" class="radiobuttons ">







<s:radio
	
	
	id="widg_rbIdScadAnnoSuccessivo" name="appDatacertificato.idScadenza"
	list="#{'2':'31/12 dell&rsquo;anno successivo all&rsquo;emissione'}"
	disabled="isWidgetDisabled('cpCompilazApe','rbTipoScadenza')"
	cssClass="radio"
	
	/> <label  for="widg_rbIdScadAnnoSuccessivo2"><s:text name="cpCompilazApe.rbTipoScadenza.rbIdScadAnnoSuccessivo.label" /></label>








<s:radio
	
	
	id="widg_rbIdScad10Anni" name="appDatacertificato.idScadenza"
	list="#{'3':'10 ANNI'}"
	disabled="isWidgetDisabled('cpCompilazApe','rbTipoScadenza')"
	cssClass="radio"
	
	/> <label  for="widg_rbIdScad10Anni3"><s:text name="cpCompilazApe.rbTipoScadenza.rbIdScad10Anni.label" /></label>





	
</div>



	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" />
</s:else>


	
<s:if test="isWidgetVisible('cpCompilazApe','wpDatiGenerali_15_3_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget wpDatiGenerali_15_3_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpCompilazApe','tfAnnoCostr')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpCompilazApe.tfAnnoCostr.label')}" labelFor="widg_tfAnnoCostr" errorFor="appDatacertificato.datiTecnici.annoCostr" labelId="tfAnnoCostrLbl"
	position="first"  >


<!-- widget tfAnnoCostr -->
<s:textfield 
	
	
	name="appDatacertificato.datiTecnici.annoCostr" id="widg_tfAnnoCostr"
maxlength="4"	disabled="isWidgetDisabled('cpCompilazApe','tfAnnoCostr')"
	size="15" cssClass="numbers"
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpCompilazApe','tfAnnoRistrutt')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpCompilazApe.tfAnnoRistrutt.label')}" labelFor="widg_tfAnnoRistrutt" errorFor="appDatacertificato.datiTecnici.annoUltimaRistrutt" labelId="tfAnnoRistruttLbl"
	  >


<!-- widget tfAnnoRistrutt -->
<s:textfield 
	
	
	name="appDatacertificato.datiTecnici.annoUltimaRistrutt" id="widg_tfAnnoRistrutt"
maxlength="4"	disabled="isWidgetDisabled('cpCompilazApe','tfAnnoRistrutt')"
	size="15" cssClass="numbers"
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" />
</s:else>


	
<s:if test="isWidgetVisible('cpCompilazApe','wpDatiGenerali_16_3_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget wpDatiGenerali_16_3_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpCompilazApe','tfDestUso')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpCompilazApe.tfDestUso.label')}" labelFor="widg_tfDestUso" errorFor="appDatacertificato.datiTecnici.descDestUso" labelId="tfDestUsoLbl"
	position="first"  >


<!-- widget tfDestUso -->
<s:textfield 
	
title=""	
	name="appDatacertificato.datiTecnici.descDestUso" id="widg_tfDestUso"
maxlength="300"	disabled="isWidgetDisabled('cpCompilazApe','tfDestUso')"
	size="40" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpCompilazApe','tfCodEdificioScolastico')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpCompilazApe.tfCodEdificioScolastico.label')}" labelFor="widg_tfCodEdificioScolastico" errorFor="appDatacertificato.datiTecnici.codEdificioScolastico" labelId="tfCodEdificioScolasticoLbl"
	  >


<!-- widget tfCodEdificioScolastico -->
<s:textfield 
	
	
	name="appDatacertificato.datiTecnici.codEdificioScolastico" id="widg_tfCodEdificioScolastico"
maxlength="150"	disabled="isWidgetDisabled('cpCompilazApe','tfCodEdificioScolastico')"
	size="30" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" />
</s:else>


	
<s:if test="isWidgetVisible('cpCompilazApe','wpDatiGenerali_17_3_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget wpDatiGenerali_17_3_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpCompilazApe','cbFkTipoRistrutturaz')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpCompilazApe.cbFkTipoRistrutturaz.label')}" labelFor="widg_cbFkTipoRistrutturaz" errorFor="appDatacertificato.datiTecnici.tipoRistrutturazione" labelId="cbFkTipoRistrutturazLbl"
	position="first"  >


<!-- widget cbFkTipoRistrutturaz -->
<s:select name="appDatacertificato.datiTecnici.tipoRistrutturazione" id="widg_cbFkTipoRistrutturaz"
	 
	
		title=""
			
	  headerKey="" headerValue="" 
	  list="appDatatipoRistrutt"
	  disabled="isWidgetDisabled('cpCompilazApe','cbFkTipoRistrutturaz')"
	  listKey="idTipo"
	  listValue="descr"
	  
	  />


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpCompilazApe','cbFkTipolEdilizia')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpCompilazApe.cbFkTipolEdilizia.label')}" labelFor="widg_cbFkTipolEdilizia" errorFor="appDatacertificato.datiTecnici.tipolEdilizia" labelId="cbFkTipolEdiliziaLbl"
	  >


<!-- widget cbFkTipolEdilizia -->
<s:select name="appDatacertificato.datiTecnici.tipolEdilizia" id="widg_cbFkTipolEdilizia"
	 
	
		title=""
			
	  headerKey="" headerValue="" 
	  list="appDatatipolEdilizia"
	  disabled="isWidgetDisabled('cpCompilazApe','cbFkTipolEdilizia')"
	  listKey="idTipo"
	  listValue="descr"
	  
	  />


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" />
</s:else>


	
<s:if test="isWidgetVisible('cpCompilazApe','wpDatiGenerali_18_3_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget wpDatiGenerali_18_3_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpCompilazApe','cbFkTipolCostrutt')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpCompilazApe.cbFkTipolCostrutt.label')}" labelFor="widg_cbFkTipolCostrutt" errorFor="appDatacertificato.datiTecnici.tipolCostruttiva" labelId="cbFkTipolCostruttLbl"
	position="first"  >


<!-- widget cbFkTipolCostrutt -->
<s:select name="appDatacertificato.datiTecnici.tipolCostruttiva" id="widg_cbFkTipolCostrutt"
	 
	
		title=""
			
	  headerKey="" headerValue="" 
	  list="appDatatipolCostrutt"
	  disabled="isWidgetDisabled('cpCompilazApe','cbFkTipolCostrutt')"
	  listKey="idTipo"
	  listValue="descr"
	  
	  />


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpCompilazApe','cbFkProprietaEdi')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpCompilazApe.cbFkProprietaEdi.label')}" labelFor="widg_cbFkProprietaEdi" errorFor="appDatacertificato.datiTecnici.proprEdificio" labelId="cbFkProprietaEdiLbl"
	  >


<!-- widget cbFkProprietaEdi -->
<s:select name="appDatacertificato.datiTecnici.proprEdificio" id="widg_cbFkProprietaEdi"
	 
	
		title=""
			
	  headerKey="" headerValue="" 
	  list="appDataproprEdificio"
	  disabled="isWidgetDisabled('cpCompilazApe','cbFkProprietaEdi')"
	  listKey="idTipo"
	  listValue="descr"
	  
	  />


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" />
</s:else>


	
<s:if test="isWidgetVisible('cpCompilazApe','wpDatiGenerali_19_3_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget wpDatiGenerali_19_3_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpCompilazApe','wpDatiGenerali_20_1_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="first" >


<!-- widget wpDatiGenerali_20_1_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpCompilazApe','wpDatiGenerali_20_2_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2"  >


<!-- widget wpDatiGenerali_20_2_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" />
</s:else>


	
<s:if test="isWidgetVisible('cpCompilazApe','wpDatiGenerali_20_3_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget wpDatiGenerali_20_3_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpCompilazApe','wpDatiGenerali_21_1_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="first" >


<!-- widget wpDatiGenerali_21_1_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpCompilazApe','wpDatiGenerali_21_2_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2"  >


<!-- widget wpDatiGenerali_21_2_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" />
</s:else>


	
<s:if test="isWidgetVisible('cpCompilazApe','wpDatiGenerali_21_3_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget wpDatiGenerali_21_3_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_wpDatiGenerali --></div>

			
	
	<div id="p_wpMotivazioneAttestato" class="widgetsPanelBlock"><!-- startFragment:p_wpMotivazioneAttestato -->
	
	
<h4 class="wpLabel">Dati dell'attestato </h4>
<div class="widgetsPanel" id="wpMotivazioneAttestato">
	
	<customtag:widgetsPanel id="wpMotivazioneAttestatoTbl" columns="6" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('cpCompilazApe','cbFkOggetto')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpCompilazApe.cbFkOggetto.label')}" labelFor="widg_cbFkOggetto" errorFor="appDatacertificato.datiTecnici.oggetto" labelId="cbFkOggettoLbl"
	position="first"  >


<!-- widget cbFkOggetto -->
<s:select name="appDatacertificato.datiTecnici.oggetto" id="widg_cbFkOggetto"
	 
	
		title=""
			
	  headerKey="" headerValue="" 
	  list="appDataoggettiApeLista"
	  disabled="isWidgetDisabled('cpCompilazApe','cbFkOggetto')"
	  listKey="idTipo"
	  listValue="descr"
	  
	  />


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpCompilazApe','wpMotivazioneAttestato_1_2_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2"  >


<!-- widget wpMotivazioneAttestato_1_2_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" />
</s:else>


	
<s:if test="isWidgetVisible('cpCompilazApe','wpMotivazioneAttestato_1_3_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget wpMotivazioneAttestato_1_3_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpCompilazApe','cbFkMotivo')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpCompilazApe.cbFkMotivo.label')}" labelFor="widg_cbFkMotivo" errorFor="appDatacertificato.altreInfo.generali.motivoRilascio" labelId="cbFkMotivoLbl"
	position="first"  >


<!-- widget cbFkMotivo -->

<s:url id="widg_cbFkMotivourlComboBoxValueChange"
   action="/siceeweb/cpCompilazApe!handleCbFkMotivo_VALUE_CHANGED" namespace="/base/compilazattestatiape"  
   includeParams="all" portletUrlType="action" 
/>
<s:select name="appDatacertificato.altreInfo.generali.motivoRilascio" id="widg_cbFkMotivo"
	 
	

		title=" - Attenzione. Dopo aver selezionato un valore, la pagina verra' aggiornata automaticamente"
			
	  headerKey="" headerValue="" 
	  list="appDatamotiviRilascio"
	  disabled="isWidgetDisabled('cpCompilazApe','cbFkMotivo')"
	  listKey="cod"
	  listValue="descr"
	  onclick="onCBClick(this,'confermacbFkMotivo','conferma','%{widg_cbFkMotivourlComboBoxValueChange}')" onfocus="inFocus(this)" onblur="lostFocus(this,'confermacbFkMotivo','conferma','%{widg_cbFkMotivourlComboBoxValueChange}')" 
	  />


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpCompilazApe','cbAltroServiziEnergia')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpCompilazApe.cbAltroServiziEnergia.label')}" labelFor="widg_cbAltroServiziEnergia" errorFor="appDatacertificato.altreInfo.generali.altroServiziEnergia" labelId="cbAltroServiziEnergiaLbl"
	  >


<!-- widget cbAltroServiziEnergia -->
<s:select name="appDatacertificato.altreInfo.generali.altroServiziEnergia" id="widg_cbAltroServiziEnergia"
	 
	
		title=""
			
	  headerKey="" headerValue="" 
	  list="appDataserviziEnergia"
	  disabled="isWidgetDisabled('cpCompilazApe','cbAltroServiziEnergia')"
	  listKey="cod"
	  listValue="descr"
	  
	  />


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" />
</s:else>


	
<s:if test="isWidgetVisible('cpCompilazApe','wpMotivazioneAttestato_2_3_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget wpMotivazioneAttestato_2_3_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_wpMotivazioneAttestato --></div>

			
	
	<div id="p_wpDichiarazioneInd" class="widgetsPanelBlock"><!-- startFragment:p_wpDichiarazioneInd -->
	
	

<div class="widgetsPanel" id="wpDichiarazioneInd">
	

	
	
<s:if test="isWidgetVisible('cpCompilazApe','tblDichiarazioneIndipendenza')" >

	
<div class="tableWidget">


<!-- widget tblDichiarazioneIndipendenza -->
<s:set name="cpCompilazApe_tblDichiarazioneIndipendenza_clearStatus" value="isTableClearStatus('cpCompilazApe_tblDichiarazioneIndipendenza')" />
<s:url id="cpCompilazApeViewUrl"						   
					   action="cpCompilazApe"
					   namespace="/base/compilazattestatiape"/>
<display:table name="appDatadichiarazioni"  				
			   excludedParams="*"			   export="false"
               id="widg_tblDichiarazioneIndipendenza"
               pagesize="0"
               keepStatus="true"
               requestURI="${cpCompilazApeViewUrl}"  
               clearStatus="${cpCompilazApe_tblDichiarazioneIndipendenza_clearStatus}"
               uid="row_tblDichiarazioneIndipendenza"
               summary="" 
               class="dataTable">
	
		<display:column headerClass="nosort" media="html">
			<s:radio list="%{#attr.row_tblDichiarazioneIndipendenza.cod}" name="appDatatempDichiarazSelez" id="%{'tblDichiarazioneIndipendenza-editcell-'+ (#attr.row_tblDichiarazioneIndipendenza_rowNum - 1)}" cssClass="radio"
			/>
		</display:column>
		<display:column property="descr" titleKey="cpCompilazApe.tblDichiarazioneIndipendenza.descr.label" 
			sortable="true" headerClass="sortable"
			    media="html"
			
 >
			
		</display:column>
</display:table>





	
</div>

</s:if>

	



	
	
	
</div>

	<!-- endFragment:p_wpDichiarazioneInd --></div>

			
	
	<div id="p_wpDatiCoCertificatore" class="widgetsPanelBlock"><!-- startFragment:p_wpDatiCoCertificatore -->
	
	
<h4 class="wpLabel">Dati co-certificatore </h4>
<div class="widgetsPanel" id="wpDatiCoCertificatore">
	
	<customtag:widgetsPanel id="wpDatiCoCertificatoreTbl" columns="6" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('cpCompilazApe','txtCoCertificatore')" >

	
<customtag:widgetsPanelColumn  colSpan="6" position="first" >


<!-- widget txtCoCertificatore -->
<s:text name="cpCompilazApe.txtCoCertificatore.statictext.label" />

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpCompilazApe','tfCodFiscCoCert')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpCompilazApe.tfCodFiscCoCert.label')}" labelFor="widg_tfCodFiscCoCert" errorFor="appDatacertificato.datiAnagraficiImm.dtCoCertificatore.codFisc" labelId="tfCodFiscCoCertLbl"
	position="first"  >


<!-- widget tfCodFiscCoCert -->
<s:textfield 
	
	
	name="appDatacertificato.datiAnagraficiImm.dtCoCertificatore.codFisc" id="widg_tfCodFiscCoCert"
maxlength="30"	disabled="isWidgetDisabled('cpCompilazApe','tfCodFiscCoCert')"
	size="50" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpCompilazApe','bCercaCfCertificatori')" >

	
<customtag:widgetsPanelColumn colSpan="2" >


<!-- widget bCercaCfCertificatori -->
<s:submit name="widg_bCercaCfCertificatori" id="widg_bCercaCfCertificatori" method="handleBCercaCfCertificatori_CLICKED"
	key="cpCompilazApe.bCercaCfCertificatori.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpCompilazApe','bCercaCfCertificatori')" />

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" />
</s:else>


	
<s:if test="isWidgetVisible('cpCompilazApe','wpDatiCoCertificatore_3_3_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget wpDatiCoCertificatore_3_3_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpCompilazApe','cbListaCf')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="" labelFor="widg_cbListaCf" errorFor="appDatacfSel" labelId="cbListaCfLbl"
	position="first"  >


<!-- widget cbListaCf -->

<s:url id="widg_cbListaCfurlComboBoxValueChange"
   action="/siceeweb/cpCompilazApe!handleCbListaCf_VALUE_CHANGED" namespace="/base/compilazattestatiape"  
   includeParams="all" portletUrlType="action" 
/>
<s:select name="appDatacfSel" id="widg_cbListaCf"
	 
	

		title=" - Attenzione. Dopo aver selezionato un valore, la pagina verra' aggiornata automaticamente"
			
	  headerKey="" headerValue="" 
	  list="appDatalistaCf"
	  disabled="isWidgetDisabled('cpCompilazApe','cbListaCf')"
	  listKey="idCertificatore"
	  listValue="codiceFiscale"
	  onclick="onCBClick(this,'confermacbListaCf','conferma','%{widg_cbListaCfurlComboBoxValueChange}')" onfocus="inFocus(this)" onblur="lostFocus(this,'confermacbListaCf','conferma','%{widg_cbListaCfurlComboBoxValueChange}')" 
	  />


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpCompilazApe','wpDatiCoCertificatore_4_2_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2"  >


<!-- widget wpDatiCoCertificatore_4_2_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" />
</s:else>


	
<s:if test="isWidgetVisible('cpCompilazApe','wpDatiCoCertificatore_4_3_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget wpDatiCoCertificatore_4_3_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpCompilazApe','tfCognomeCoCert')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpCompilazApe.tfCognomeCoCert.label')}" labelFor="widg_tfCognomeCoCert" errorFor="appDatacertificato.datiAnagraficiImm.dtCoCertificatore.cognome" labelId="tfCognomeCoCertLbl"
	position="first"  >


<!-- widget tfCognomeCoCert -->
<s:textfield 
	
	
	name="appDatacertificato.datiAnagraficiImm.dtCoCertificatore.cognome" id="widg_tfCognomeCoCert"
maxlength="50"	disabled="isWidgetDisabled('cpCompilazApe','tfCognomeCoCert')"
	size="50" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpCompilazApe','tfNomeCoCert')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpCompilazApe.tfNomeCoCert.label')}" labelFor="widg_tfNomeCoCert" errorFor="appDatacertificato.datiAnagraficiImm.dtCoCertificatore.nome" labelId="tfNomeCoCertLbl"
	  >


<!-- widget tfNomeCoCert -->
<s:textfield 
	
	
	name="appDatacertificato.datiAnagraficiImm.dtCoCertificatore.nome" id="widg_tfNomeCoCert"
maxlength="20"	disabled="isWidgetDisabled('cpCompilazApe','tfNomeCoCert')"
	size="50" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" />
</s:else>


	
<s:if test="isWidgetVisible('cpCompilazApe','wpDatiCoCertificatore_5_3_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget wpDatiCoCertificatore_5_3_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpCompilazApe','tfNumMatricolaCoCert')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpCompilazApe.tfNumMatricolaCoCert.label')}" labelFor="widg_tfNumMatricolaCoCert" errorFor="appDatacertificato.datiAnagraficiImm.dtCoCertificatore.numMatricola" labelId="tfNumMatricolaCoCertLbl"
	position="first"  >


<!-- widget tfNumMatricolaCoCert -->
<s:textfield 
	
	
	name="appDatacertificato.datiAnagraficiImm.dtCoCertificatore.numMatricola" id="widg_tfNumMatricolaCoCert"
maxlength="100"	disabled="isWidgetDisabled('cpCompilazApe','tfNumMatricolaCoCert')"
	size="50" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpCompilazApe','wpDatiCoCertificatore_6_2_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2"  >


<!-- widget wpDatiCoCertificatore_6_2_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" />
</s:else>


	
<s:if test="isWidgetVisible('cpCompilazApe','wpDatiCoCertificatore_6_3_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget wpDatiCoCertificatore_6_3_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpCompilazApe','txtNoteApeDatiGen')" >

	
<customtag:widgetsPanelColumn  colSpan="6" position="first" >


<!-- widget txtNoteApeDatiGen -->
<s:text name="cpCompilazApe.txtNoteApeDatiGen.statictext.label" />

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpCompilazApe','bSalva')" >

	
<customtag:widgetsPanelColumn colSpan="2" >


<!-- widget bSalva -->
<s:submit name="widg_bSalva" id="widg_bSalva" method="handleBSalva_CLICKED"
	key="cpCompilazApe.bSalva.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpCompilazApe','bSalva')" />

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" />
</s:else>


	
<s:if test="isWidgetVisible('cpCompilazApe','wpDatiCoCertificatore_7_3_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget wpDatiCoCertificatore_7_3_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_wpDatiCoCertificatore --></div>

	

		
	
</div>

	<!-- endFragment:p_fpTspApeDatiGen --></div>
