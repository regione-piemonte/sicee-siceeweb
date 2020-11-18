<%@taglib uri="/struts-tags" prefix="s" %>
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="/customtag" prefix="customtag" %>
<%@taglib uri="/csiuicore" prefix="csiuicore" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<fmt:setBundle basename="/it/csi/sicee/siceeweb/presentation/siceeweb/action/compilazattestati/CpCompilazAction" />

	
	<div id="p_pDatiCatastali" class="formPanelBlock"><!-- startFragment:p_pDatiCatastali -->
		
	
<div class="formPanel" id="pDatiCatastali">


	
	

	
	
			
	
	<div id="p_pErrDtCastastali" class="stdMessagePanelBlock"><!-- startFragment:p_pErrDtCastastali -->
	
	
<div class="stdMessagePanel" id="pErrDtCastastali">
	<customtag:stdMessagePanel id="pErrDtCastastali" errorMessage="true" errorDetails="false" actionMessage="true" />
</div>

	<!-- endFragment:p_pErrDtCastastali --></div>

			
	
	<div id="p_pDtCatastali1Part" class="widgetsPanelBlock"><!-- startFragment:p_pDtCatastali1Part -->
	
	

<div class="widgetsPanel" id="pDtCatastali1Part">
	
	<customtag:widgetsPanel id="pDtCatastali1PartTbl" columns="8" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('cpCompilaz','txtObblDtCatastali')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="first" >


<!-- widget txtObblDtCatastali -->
<s:text name="cpCompilaz.txtObblDtCatastali.statictext.label" />

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpCompilaz','cbProvDtCatastali')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpCompilaz.cbProvDtCatastali.label')}" labelFor="widg_cbProvDtCatastali" errorFor="appDatacertificato.datiAnagraficiImm.dtCatastali.codProv" labelId="cbProvDtCatastaliLbl"
	position="first"  >


<!-- widget cbProvDtCatastali -->

<s:url id="widg_cbProvDtCatastaliurlComboBoxValueChange"
   action="/siceeweb/cpCompilaz!handleCbProvDtCatastali_VALUE_CHANGED" namespace="/base/compilazattestati"  
   includeParams="all" portletUrlType="action" 
/>
<s:select name="appDatacertificato.datiAnagraficiImm.dtCatastali.codProv" id="widg_cbProvDtCatastali"
	 
	

		title=" - Attenzione. Dopo aver selezionato un valore, la pagina verra' aggiornata automaticamente"
			
	  headerKey="" headerValue="" 
	  list="appDataprovinceCertDTCat"
	  disabled="isWidgetDisabled('cpCompilaz','cbProvDtCatastali')"
	  listKey="cod"
	  listValue="nome"
	  onclick="onCBClick(this,'confermacbProvDtCatastali','conferma','%{widg_cbProvDtCatastaliurlComboBoxValueChange}')" onfocus="inFocus(this)" onblur="lostFocus(this,'confermacbProvDtCatastali','conferma','%{widg_cbProvDtCatastaliurlComboBoxValueChange}')" 
	  />


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpCompilaz','cbComDtCatastali')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpCompilaz.cbComDtCatastali.label')}" labelFor="widg_cbComDtCatastali" errorFor="appDatacertificato.datiAnagraficiImm.dtCatastali.codComune" labelId="cbComDtCatastaliLbl"
	position="first"  >


<!-- widget cbComDtCatastali -->

<s:url id="widg_cbComDtCatastaliurlComboBoxValueChange"
   action="/siceeweb/cpCompilaz!handleCbComDtCatastali_VALUE_CHANGED" namespace="/base/compilazattestati"  
   includeParams="all" portletUrlType="action" 
/>
<s:select name="appDatacertificato.datiAnagraficiImm.dtCatastali.codComune" id="widg_cbComDtCatastali"
	 
	

		title=" - Attenzione. Dopo aver selezionato un valore, la pagina verra' aggiornata automaticamente"
			
	  headerKey="" headerValue="" 
	  list="appDatacomuniCertDtCat"
	  disabled="isWidgetDisabled('cpCompilaz','cbComDtCatastali')"
	  listKey="cod"
	  listValue="nome"
	  onclick="onCBClick(this,'confermacbComDtCatastali','conferma','%{widg_cbComDtCatastaliurlComboBoxValueChange}')" onfocus="inFocus(this)" onblur="lostFocus(this,'confermacbComDtCatastali','conferma','%{widg_cbComDtCatastaliurlComboBoxValueChange}')" 
	  />


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpCompilaz','txtZonaClimatica')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpCompilaz.txtZonaClimatica.label')}" labelFor="widg_txtZonaClimatica" errorFor="appDatacertificato.datiAnagraficiImm.dtCatastali.zonaClimatica" labelId="txtZonaClimaticaLbl"  position="first" >


<!-- widget txtZonaClimatica -->
<s:property value="appDatacertificato.datiAnagraficiImm.dtCatastali.zonaClimatica" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpCompilaz','tfGradiGiorno')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpCompilaz.tfGradiGiorno.label')}" labelFor="widg_tfGradiGiorno" errorFor="appDatacertificato.datiAnagraficiImm.dtCatastali.gradiGiorno" labelId="tfGradiGiornoLbl"
	  >


<!-- widget tfGradiGiorno -->
<s:textfield 
	
	
	name="appDatacertificato.datiAnagraficiImm.dtCatastali.gradiGiorno" id="widg_tfGradiGiorno"
maxlength="6"	disabled="isWidgetDisabled('cpCompilaz','tfGradiGiorno')"
	size="9" cssClass="numbers"
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" />
</s:else>


	
<s:if test="isWidgetVisible('cpCompilaz','tfRicercaIndirizzo')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpCompilaz.tfRicercaIndirizzo.label')}" labelFor="widg_tfRicercaIndirizzo" errorFor="appDatacertificato.datiAnagraficiImm.dtCatastali.ricercaIndirizzo" labelId="tfRicercaIndirizzoLbl"
	position="first"  >


<!-- widget tfRicercaIndirizzo -->
<s:textfield 
	
	
	name="appDatacertificato.datiAnagraficiImm.dtCatastali.ricercaIndirizzo" id="widg_tfRicercaIndirizzo"
maxlength="160"	disabled="isWidgetDisabled('cpCompilaz','tfRicercaIndirizzo')"
	size="30" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpCompilaz','vVerifIndDtCatastali')" >

	
<customtag:widgetsPanelColumn colSpan="2" >


<!-- widget vVerifIndDtCatastali -->
	<csiuicore:ajaxify id="p_pWizCompilazLiv1" 
		widgetType="button"
		 
		requestUri="/siceeweb/base/compilazattestati/cpCompilaz!handleVVerifIndDtCatastali_CLICKED.do" 
		
		pageId="cpCompilaz" 
		formName="cpCompilaz"
		javascriptDetection="false">
<s:submit name="widg_vVerifIndDtCatastali" id="widg_vVerifIndDtCatastali" method="handleVVerifIndDtCatastali_CLICKED"
	key="cpCompilaz.vVerifIndDtCatastali.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpCompilaz','vVerifIndDtCatastali')" />

	</csiuicore:ajaxify>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" />
</s:else>


	
<s:if test="isWidgetVisible('cpCompilaz','selezionaIndirizzo')" >

	
<customtag:widgetsPanelColumn  colSpan="6" position="first" >


<!-- widget selezionaIndirizzo -->
<s:text name="cpCompilaz.selezionaIndirizzo.statictext.label" />

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="6" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpCompilaz','cbSceltaIndDtCatastali')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpCompilaz.cbSceltaIndDtCatastali.label')}" labelFor="widg_cbSceltaIndDtCatastali" errorFor="appDatacertificato.datiAnagraficiImm.dtCatastali.codIndirizzo" labelId="cbSceltaIndDtCatastaliLbl"
	position="first" colSpan="3" >


<!-- widget cbSceltaIndDtCatastali -->
<s:select name="appDatacertificato.datiAnagraficiImm.dtCatastali.codIndirizzo" id="widg_cbSceltaIndDtCatastali"
	 
	
		title=""
			
	  headerKey="" headerValue="" 
	  list="appDatasuggestIndirizzoDtCat"
	  disabled="isWidgetDisabled('cpCompilaz','cbSceltaIndDtCatastali')"
	  listKey="cod"
	  listValue="descr"
	  
	  />


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="4" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpCompilaz','svuotaIndDtCatastaliCombo')" >

	
<customtag:widgetsPanelColumn colSpan="2" >


<!-- widget svuotaIndDtCatastaliCombo -->
	<csiuicore:ajaxify id="p_pWizCompilazLiv1" 
		widgetType="button"
		 
		requestUri="/siceeweb/base/compilazattestati/cpCompilaz!handleSvuotaIndDtCatastaliCombo_CLICKED.do" 
		
		pageId="cpCompilaz" 
		formName="cpCompilaz"
		javascriptDetection="false">
<s:submit name="widg_svuotaIndDtCatastaliCombo" id="widg_svuotaIndDtCatastaliCombo" method="handleSvuotaIndDtCatastaliCombo_CLICKED"
	key="cpCompilaz.svuotaIndDtCatastaliCombo.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpCompilaz','svuotaIndDtCatastaliCombo')" />

	</csiuicore:ajaxify>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" />
</s:else>


	
<s:if test="isWidgetVisible('cpCompilaz','noIndirizzo')" >

	
<customtag:widgetsPanelColumn  colSpan="6" position="first" >


<!-- widget noIndirizzo -->
<s:text name="cpCompilaz.noIndirizzo.statictext.label" />

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="6" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpCompilaz','tfIndirizzoDtCatastali')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpCompilaz.tfIndirizzoDtCatastali.label')}" labelFor="widg_tfIndirizzoDtCatastali" errorFor="appDatacertificato.datiAnagraficiImm.dtCatastali.descrIndirizzo" labelId="tfIndirizzoDtCatastaliLbl"
	position="first"  >


<!-- widget tfIndirizzoDtCatastali -->
<s:textfield 
	
title=""	
	name="appDatacertificato.datiAnagraficiImm.dtCatastali.descrIndirizzo" id="widg_tfIndirizzoDtCatastali"
maxlength="160"	disabled="isWidgetDisabled('cpCompilaz','tfIndirizzoDtCatastali')"
	size="30" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpCompilaz','svuotaIndDtCatastaliText')" >

	
<customtag:widgetsPanelColumn colSpan="2" >


<!-- widget svuotaIndDtCatastaliText -->
<s:submit name="widg_svuotaIndDtCatastaliText" id="widg_svuotaIndDtCatastaliText" method="handleSvuotaIndDtCatastaliText_CLICKED"
	key="cpCompilaz.svuotaIndDtCatastaliText.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpCompilaz','svuotaIndDtCatastaliText')" />

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" />
</s:else>


	
<s:if test="isWidgetVisible('cpCompilaz','tfNCivDtCatastali')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpCompilaz.tfNCivDtCatastali.label')}" labelFor="widg_tfNCivDtCatastali" errorFor="appDatacertificato.datiAnagraficiImm.dtCatastali.numCiv" labelId="tfNCivDtCatastaliLbl"
	position="first"  >


<!-- widget tfNCivDtCatastali -->
<s:textfield 
	
	
	name="appDatacertificato.datiAnagraficiImm.dtCatastali.numCiv" id="widg_tfNCivDtCatastali"
maxlength="10"	disabled="isWidgetDisabled('cpCompilaz','tfNCivDtCatastali')"
	size="9" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpCompilaz','tfCAPDtCatastali')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpCompilaz.tfCAPDtCatastali.label')}" labelFor="widg_tfCAPDtCatastali" errorFor="appDatacertificato.datiAnagraficiImm.dtCatastali.cap" labelId="tfCAPDtCatastaliLbl"
	  >


<!-- widget tfCAPDtCatastali -->
<s:textfield 
	
	
	name="appDatacertificato.datiAnagraficiImm.dtCatastali.cap" id="widg_tfCAPDtCatastali"
maxlength="5"	disabled="isWidgetDisabled('cpCompilaz','tfCAPDtCatastali')"
	size="9" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" />
</s:else>


	
<s:if test="isWidgetVisible('cpCompilaz','tfSezCatasto')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpCompilaz.tfSezCatasto.label')}" labelFor="widg_tfSezCatasto" errorFor="appDatacertificato.datiAnagraficiImm.dtCatastali.sezione" labelId="tfSezCatastoLbl"
	position="first"  >


<!-- widget tfSezCatasto -->
<s:textfield 
	
	
	name="appDatacertificato.datiAnagraficiImm.dtCatastali.sezione" id="widg_tfSezCatasto"
maxlength="5"	disabled="isWidgetDisabled('cpCompilaz','tfSezCatasto')"
	size="9" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpCompilaz','tfFoglioCatasto')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpCompilaz.tfFoglioCatasto.label')}" labelFor="widg_tfFoglioCatasto" errorFor="appDatacertificato.datiAnagraficiImm.dtCatastali.foglio" labelId="tfFoglioCatastoLbl"
	  >


<!-- widget tfFoglioCatasto -->
<s:textfield 
	
	
	name="appDatacertificato.datiAnagraficiImm.dtCatastali.foglio" id="widg_tfFoglioCatasto"
maxlength="5"	disabled="isWidgetDisabled('cpCompilaz','tfFoglioCatasto')"
	size="9" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" />
</s:else>


	
<s:if test="isWidgetVisible('cpCompilaz','tfParticCatasto')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpCompilaz.tfParticCatasto.label')}" labelFor="widg_tfParticCatasto" errorFor="appDatacertificato.datiAnagraficiImm.dtCatastali.particella" labelId="tfParticCatastoLbl"
	  >


<!-- widget tfParticCatasto -->
<s:textfield 
	
	
	name="appDatacertificato.datiAnagraficiImm.dtCatastali.particella" id="widg_tfParticCatasto"
maxlength="9"	disabled="isWidgetDisabled('cpCompilaz','tfParticCatasto')"
	size="9" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" />
</s:else>


	
<s:if test="isWidgetVisible('cpCompilaz','tfSubaltCatasto')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpCompilaz.tfSubaltCatasto.label')}" labelFor="widg_tfSubaltCatasto" errorFor="appDatacertificato.datiAnagraficiImm.dtCatastali.subalterno" labelId="tfSubaltCatastoLbl"
	position="last"  >


<!-- widget tfSubaltCatasto -->
<s:textfield 
	
	
	name="appDatacertificato.datiAnagraficiImm.dtCatastali.subalterno" id="widg_tfSubaltCatasto"
maxlength="4"	disabled="isWidgetDisabled('cpCompilaz','tfSubaltCatasto')"
	size="9" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_pDtCatastali1Part --></div>

			
	
	<div id="p_pDtCatastaliSecondari" class="widgetsPanelBlock"><!-- startFragment:p_pDtCatastaliSecondari -->
	
	
<h4 class="wpLabel">Dati catastali secondari </h4>
<div class="widgetsPanel" id="pDtCatastaliSecondari">
	
	<customtag:widgetsPanel id="pDtCatastaliSecondariTbl" columns="8" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('cpCompilaz','txtDescDtCatastaliSec')" >

	
<customtag:widgetsPanelColumn  colSpan="8" position="first" >


<!-- widget txtDescDtCatastaliSec -->
<s:text name="cpCompilaz.txtDescDtCatastaliSec.statictext.label" />

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpCompilaz','cbProvDtCatastaliSec')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpCompilaz.cbProvDtCatastaliSec.label')}" labelFor="widg_cbProvDtCatastaliSec" errorFor="appDatacertificato.datiAnagraficiImm.dtCatastali.codProvSec" labelId="cbProvDtCatastaliSecLbl"
	position="first"  >


<!-- widget cbProvDtCatastaliSec -->

<s:url id="widg_cbProvDtCatastaliSecurlComboBoxValueChange"
   action="/siceeweb/cpCompilaz!handleCbProvDtCatastaliSec_VALUE_CHANGED" namespace="/base/compilazattestati"  
   includeParams="all" portletUrlType="action" 
/>
<s:select name="appDatacertificato.datiAnagraficiImm.dtCatastali.codProvSec" id="widg_cbProvDtCatastaliSec"
	 
	

		title=" - Attenzione. Dopo aver selezionato un valore, la pagina verra' aggiornata automaticamente"
			
	  headerKey="" headerValue="" 
	  list="appDataprovinceCertDTCat"
	  disabled="isWidgetDisabled('cpCompilaz','cbProvDtCatastaliSec')"
	  listKey="cod"
	  listValue="nome"
	  onclick="onCBClick(this,'confermacbProvDtCatastaliSec','conferma','%{widg_cbProvDtCatastaliSecurlComboBoxValueChange}')" onfocus="inFocus(this)" onblur="lostFocus(this,'confermacbProvDtCatastaliSec','conferma','%{widg_cbProvDtCatastaliSecurlComboBoxValueChange}')" 
	  />


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpCompilaz','cbComDtCatastaliSec')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpCompilaz.cbComDtCatastaliSec.label')}" labelFor="widg_cbComDtCatastaliSec" errorFor="appDatacertificato.datiAnagraficiImm.dtCatastali.codComuneSec" labelId="cbComDtCatastaliSecLbl"
	position="first"  >


<!-- widget cbComDtCatastaliSec -->
<s:select name="appDatacertificato.datiAnagraficiImm.dtCatastali.codComuneSec" id="widg_cbComDtCatastaliSec"
	 
	
		title=""
			
	  headerKey="" headerValue="" 
	  list="appDatacomuniCertDtCatSecondari"
	  disabled="isWidgetDisabled('cpCompilaz','cbComDtCatastaliSec')"
	  listKey="cod"
	  listValue="nome"
	  
	  />


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpCompilaz','tfSezCatastoSec')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpCompilaz.tfSezCatastoSec.label')}" labelFor="widg_tfSezCatastoSec" errorFor="appDatacertificato.datiAnagraficiImm.dtCatastali.sezioneSec" labelId="tfSezCatastoSecLbl"
	position="first"  >


<!-- widget tfSezCatastoSec -->
<s:textfield 
	
	
	name="appDatacertificato.datiAnagraficiImm.dtCatastali.sezioneSec" id="widg_tfSezCatastoSec"
maxlength="5"	disabled="isWidgetDisabled('cpCompilaz','tfSezCatastoSec')"
	size="9" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpCompilaz','tfFoglioCatastoSec')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpCompilaz.tfFoglioCatastoSec.label')}" labelFor="widg_tfFoglioCatastoSec" errorFor="appDatacertificato.datiAnagraficiImm.dtCatastali.foglioSec" labelId="tfFoglioCatastoSecLbl"
	  >


<!-- widget tfFoglioCatastoSec -->
<s:textfield 
	
	
	name="appDatacertificato.datiAnagraficiImm.dtCatastali.foglioSec" id="widg_tfFoglioCatastoSec"
maxlength="5"	disabled="isWidgetDisabled('cpCompilaz','tfFoglioCatastoSec')"
	size="9" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" />
</s:else>


	
<s:if test="isWidgetVisible('cpCompilaz','tfParticCatastoSec')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpCompilaz.tfParticCatastoSec.label')}" labelFor="widg_tfParticCatastoSec" errorFor="appDatacertificato.datiAnagraficiImm.dtCatastali.particellaSec" labelId="tfParticCatastoSecLbl"
	  >


<!-- widget tfParticCatastoSec -->
<s:textfield 
	
	
	name="appDatacertificato.datiAnagraficiImm.dtCatastali.particellaSec" id="widg_tfParticCatastoSec"
maxlength="9"	disabled="isWidgetDisabled('cpCompilaz','tfParticCatastoSec')"
	size="9" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" />
</s:else>


	
<s:if test="isWidgetVisible('cpCompilaz','tfSubaltCatastoSec')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpCompilaz.tfSubaltCatastoSec.label')}" labelFor="widg_tfSubaltCatastoSec" errorFor="appDatacertificato.datiAnagraficiImm.dtCatastali.subalternoSec" labelId="tfSubaltCatastoSecLbl"
	position="last"  >


<!-- widget tfSubaltCatastoSec -->
<s:textfield 
	
	
	name="appDatacertificato.datiAnagraficiImm.dtCatastali.subalternoSec" id="widg_tfSubaltCatastoSec"
maxlength="4"	disabled="isWidgetDisabled('cpCompilaz','tfSubaltCatastoSec')"
	size="9" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_pDtCatastaliSecondari --></div>

			
	
	<div id="p_pDtCatastaliAdd" class="commandPanelBlock"><!-- startFragment:p_pDtCatastaliAdd -->
	
	
<div class="commandPanel functional" id="pDtCatastaliAdd">

	
	
		

	
	
	
	<div class="button left">
		
<s:if test="isWidgetVisible('cpCompilaz','bAddDtCatastaleSecondario')" >

	



<!-- widget bAddDtCatastaleSecondario -->
	<csiuicore:ajaxify id="p_pCenter" 
		widgetType="button"
		 
		requestUri="/siceeweb/base/compilazattestati/cpCompilaz!handleBAddDtCatastaleSecondario_CLICKED.do" 
		
		pageId="cpCompilaz" 
		formName="cpCompilaz"
		javascriptDetection="false">
<s:submit name="widg_bAddDtCatastaleSecondario" id="widg_bAddDtCatastaleSecondario" method="handleBAddDtCatastaleSecondario_CLICKED"
	key="cpCompilaz.bAddDtCatastaleSecondario.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpCompilaz','bAddDtCatastaleSecondario')" />

	</csiuicore:ajaxify>

	


</s:if>

	


	</div>
	
	

	
	
	
	

	
	
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_pDtCatastaliAdd --></div>

			
	
	<div id="p_pDtCatastaliSecondariiElenco" class="widgetsPanelBlock"><!-- startFragment:p_pDtCatastaliSecondariiElenco -->
	
	

<div class="widgetsPanel" id="pDtCatastaliSecondariiElenco">
	

	
	
<s:if test="isWidgetVisible('cpCompilaz','tblDtCatastaliSecondari')" >

	
<div class="tableWidget">


<!-- widget tblDtCatastaliSecondari -->
<s:set name="cpCompilaz_tblDtCatastaliSecondari_clearStatus" value="isTableClearStatus('cpCompilaz_tblDtCatastaliSecondari')" />
<s:url id="cpCompilazViewUrl"						   
					   action="cpCompilaz"
					   namespace="/base/compilazattestati"/>
<display:table name="appDatatempDtCatastaliSecondari"  				
			   excludedParams="*"			   export="false"
               id="widg_tblDtCatastaliSecondari"
               pagesize="0"
               keepStatus="true"
               requestURI="${cpCompilazViewUrl}"  
               clearStatus="${cpCompilaz_tblDtCatastaliSecondari_clearStatus}"
               uid="row_tblDtCatastaliSecondari"
               summary="" 
               class="dataTable">
	
		<display:column headerClass="nosort" media="html">
			<s:radio list="%{#attr.row_tblDtCatastaliSecondari.id}" name="appDatadatoCatastaleSelezionato" id="%{'tblDtCatastaliSecondari-editcell-'+ (#attr.row_tblDtCatastaliSecondari_rowNum - 1)}" cssClass="radio"
			/>
		</display:column>
		<display:column property="descrProv" titleKey="cpCompilaz.tblDtCatastaliSecondari.descrProv.label" 
			sortable="false" headerClass="nosort"
			    media="html"
			
 >
			
		</display:column>
		<display:column property="descrComune" titleKey="cpCompilaz.tblDtCatastaliSecondari.descrComune.label" 
			sortable="false" headerClass="nosort"
			    media="html"
			
 >
			
		</display:column>
		<display:column property="sezione" titleKey="cpCompilaz.tblDtCatastaliSecondari.sezione.label" 
			sortable="false" headerClass="nosort"
			    media="html"
			
 >
			
		</display:column>
		<display:column property="foglio" titleKey="cpCompilaz.tblDtCatastaliSecondari.foglio.label" 
			sortable="false" headerClass="nosort"
			    media="html"
			
 >
			
		</display:column>
		<display:column property="particella" titleKey="cpCompilaz.tblDtCatastaliSecondari.particella.label" 
			sortable="false" headerClass="nosort"
			    media="html"
			
 >
			
		</display:column>
		<display:column property="subalterno" titleKey="cpCompilaz.tblDtCatastaliSecondari.subalterno.label" 
			sortable="false" headerClass="nosort"
			    media="html"
			
 >
			
		</display:column>
</display:table>





	
</div>

</s:if>

	



	
	
	
</div>

	<!-- endFragment:p_pDtCatastaliSecondariiElenco --></div>

			
	
	<div id="p_pDtCatastaliDel" class="commandPanelBlock"><!-- startFragment:p_pDtCatastaliDel -->
	
	
<div class="commandPanel functional" id="pDtCatastaliDel">

	
	
		

	
	
	
	<div class="button left">
		
<s:if test="isWidgetVisible('cpCompilaz','bDelDtCatastaleSecondario')" >

	



<!-- widget bDelDtCatastaleSecondario -->
	<csiuicore:ajaxify id="p_pCenter" 
		widgetType="button"
		 
		requestUri="/siceeweb/base/compilazattestati/cpCompilaz!handleBDelDtCatastaleSecondario_CLICKED.do" 
		
		pageId="cpCompilaz" 
		formName="cpCompilaz"
		javascriptDetection="false">
<s:submit name="widg_bDelDtCatastaleSecondario" id="widg_bDelDtCatastaleSecondario" method="handleBDelDtCatastaleSecondario_CLICKED"
	key="cpCompilaz.bDelDtCatastaleSecondario.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpCompilaz','bDelDtCatastaleSecondario')" />

	</csiuicore:ajaxify>

	


</s:if>

	


	</div>
	
	

	
	
	
	

	
	
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_pDtCatastaliDel --></div>

			
	
	<div id="p_pDtCatastali2Part" class="widgetsPanelBlock"><!-- startFragment:p_pDtCatastali2Part -->
	
	

<div class="widgetsPanel" id="pDtCatastali2Part">
	
	<customtag:widgetsPanel id="pDtCatastali2PartTbl" columns="8" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('cpCompilaz','tfPianoCatastali')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpCompilaz.tfPianoCatastali.label')}" labelFor="widg_tfPianoCatastali" errorFor="appDatacertificato.datiAnagraficiImm.dtCatastali.piano" labelId="tfPianoCatastaliLbl"
	position="first"  >


<!-- widget tfPianoCatastali -->
<s:textfield 
	
	
	name="appDatacertificato.datiAnagraficiImm.dtCatastali.piano" id="widg_tfPianoCatastali"
maxlength="3"	disabled="isWidgetDisabled('cpCompilaz','tfPianoCatastali')"
	size="9" cssClass="numbers"
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpCompilaz','tfPianiTotCatastali')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpCompilaz.tfPianiTotCatastali.label')}" labelFor="widg_tfPianiTotCatastali" errorFor="appDatacertificato.datiAnagraficiImm.dtCatastali.pianiTot" labelId="tfPianiTotCatastaliLbl"
	  >


<!-- widget tfPianiTotCatastali -->
<s:textfield 
	
	
	name="appDatacertificato.datiAnagraficiImm.dtCatastali.pianiTot" id="widg_tfPianiTotCatastali"
maxlength="3"	disabled="isWidgetDisabled('cpCompilaz','tfPianiTotCatastali')"
	size="9" cssClass="numbers"
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" />
</s:else>


	
<s:if test="isWidgetVisible('cpCompilaz','tfNUnitaCatastali')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpCompilaz.tfNUnitaCatastali.label')}" labelFor="widg_tfNUnitaCatastali" errorFor="appDatacertificato.datiAnagraficiImm.dtCatastali.numUnita" labelId="tfNUnitaCatastaliLbl"
	position="first"  >


<!-- widget tfNUnitaCatastali -->
<s:textfield 
	
	
	name="appDatacertificato.datiAnagraficiImm.dtCatastali.numUnita" id="widg_tfNUnitaCatastali"
maxlength="3"	disabled="isWidgetDisabled('cpCompilaz','tfNUnitaCatastali')"
	size="9" cssClass="numbers"
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpCompilaz','tfScalaCatastali')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpCompilaz.tfScalaCatastali.label')}" labelFor="widg_tfScalaCatastali" errorFor="appDatacertificato.datiAnagraficiImm.dtCatastali.scala" labelId="tfScalaCatastaliLbl"
	  >


<!-- widget tfScalaCatastali -->
<s:textfield 
	
	
	name="appDatacertificato.datiAnagraficiImm.dtCatastali.scala" id="widg_tfScalaCatastali"
maxlength="10"	disabled="isWidgetDisabled('cpCompilaz','tfScalaCatastali')"
	size="9" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" />
</s:else>


	
<s:if test="isWidgetVisible('cpCompilaz','tfInternoCatastali')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpCompilaz.tfInternoCatastali.label')}" labelFor="widg_tfInternoCatastali" errorFor="appDatacertificato.datiAnagraficiImm.dtCatastali.interno" labelId="tfInternoCatastaliLbl"
	  >


<!-- widget tfInternoCatastali -->
<s:textfield 
	
	
	name="appDatacertificato.datiAnagraficiImm.dtCatastali.interno" id="widg_tfInternoCatastali"
maxlength="10"	disabled="isWidgetDisabled('cpCompilaz','tfInternoCatastali')"
	size="9" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" />
</s:else>


	
<s:if test="isWidgetVisible('cpCompilaz','taNoteCatasto')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpCompilaz.taNoteCatasto.label')}" labelFor="widg_taNoteCatasto" errorFor="appDatacertificato.datiAnagraficiImm.dtCatastali.note" labelId="taNoteCatastoLbl"
	position="first" colSpan="7" >


<!-- widget taNoteCatasto -->
<s:textarea 
	
	
	name="appDatacertificato.datiAnagraficiImm.dtCatastali.note" id="widg_taNoteCatasto"
	disabled="isWidgetDisabled('cpCompilaz','taNoteCatasto')"
	rows="7"
	cols="60"
	></s:textarea>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpCompilaz','txtNote1DtCatastali')" >

	
<customtag:widgetsPanelColumn  colSpan="8" position="first" >


<!-- widget txtNote1DtCatastali -->
<s:text name="cpCompilaz.txtNote1DtCatastali.statictext.label" />

	
</customtag:widgetsPanelColumn>

</s:if>

	



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_pDtCatastali2Part --></div>

			
	
	<div id="p_pDtCatastaliNav" class="commandPanelBlock"><!-- startFragment:p_pDtCatastaliNav -->
	
	
<div class="commandPanel navigation" id="pDtCatastaliNav">

	
	
		

	
	
	
	<div class="button left">
		
<s:if test="isWidgetVisible('cpCompilaz','bDtCatastaliIndietro')" >

	



<!-- widget bDtCatastaliIndietro -->
	<csiuicore:ajaxify id="p_pCenter" 
		widgetType="button"
		 
		requestUri="/siceeweb/base/compilazattestati/cpCompilaz!handleBDtCatastaliIndietro_CLICKED.do" 
		
		pageId="cpCompilaz" 
		formName="cpCompilaz"
		javascriptDetection="false">
<s:submit name="widg_bDtCatastaliIndietro" id="widg_bDtCatastaliIndietro" method="handleBDtCatastaliIndietro_CLICKED"
	key="cpCompilaz.bDtCatastaliIndietro.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpCompilaz','bDtCatastaliIndietro')" />

	</csiuicore:ajaxify>

	


</s:if>

	


	</div>
	
	

	
	
	
	

	
	
	
	<div class="button right">
		
<s:if test="isWidgetVisible('cpCompilaz','bDtCatastaliAvanti')" >

	



<!-- widget bDtCatastaliAvanti -->
	<csiuicore:ajaxify id="p_pWizCompilazLiv1" 
		widgetType="button"
		 
		requestUri="/siceeweb/base/compilazattestati/cpCompilaz!handleBDtCatastaliAvanti_CLICKED.do" 
		
		pageId="cpCompilaz" 
		formName="cpCompilaz"
		javascriptDetection="false">
<s:submit name="widg_bDtCatastaliAvanti" id="widg_bDtCatastaliAvanti" method="handleBDtCatastaliAvanti_CLICKED"
	key="cpCompilaz.bDtCatastaliAvanti.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpCompilaz','bDtCatastaliAvanti')" />

	</csiuicore:ajaxify>

	


</s:if>

	


	</div>
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_pDtCatastaliNav --></div>

	

		
	
</div>

	<!-- endFragment:p_pDatiCatastali --></div>
