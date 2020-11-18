<%@taglib uri="/struts-tags" prefix="s" %>
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="/customtag" prefix="customtag" %>
<%@taglib uri="/csiuicore" prefix="csiuicore" %>

	
	<div id="p_pDatiTecnici" class="formPanelBlock"><!-- startFragment:p_pDatiTecnici -->
		
	
<div class="formPanel" id="pDatiTecnici">


	
	

	
	
			
	
	<div id="p_pErrDtTecnici" class="stdMessagePanelBlock"><!-- startFragment:p_pErrDtTecnici -->
	
	
<div class="stdMessagePanel" id="pErrDtTecnici">
	<customtag:stdMessagePanel id="pErrDtTecnici" errorMessage="true" errorDetails="false" actionMessage="true" />
</div>

	<!-- endFragment:p_pErrDtTecnici --></div>

			
	
	<div id="p_pDtTecnici" class="widgetsPanelBlock"><!-- startFragment:p_pDtTecnici -->
	
	

<div class="widgetsPanel" id="pDtTecnici">
	
	<customtag:widgetsPanel id="pDtTecniciTbl" columns="2" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('cpCompilaz','txtObblDtTecnici')" >

	
<customtag:widgetsPanelColumn  colSpan="2"  >


<!-- widget txtObblDtTecnici -->
<s:text name="cpCompilaz.txtObblDtTecnici.statictext.label" />

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpCompilaz','cbDestUso')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpCompilaz.cbDestUso.label')}" labelFor="widg_cbDestUso" errorFor="appDatacertificato.datiTecnici.destUso" labelId="cbDestUsoLbl"
	  >


<!-- widget cbDestUso -->

<s:url id="widg_cbDestUsourlComboBoxValueChange"
   action="/siceeweb/cpCompilaz!handleCbDestUso_VALUE_CHANGED" namespace="/base/compilazattestati"  
   includeParams="all" portletUrlType="action" 
/>
<s:select name="appDatacertificato.datiTecnici.destUso" id="widg_cbDestUso"
	 
	

		title=" - Attenzione. Dopo aver selezionato un valore, la pagina verra' aggiornata automaticamente"
			
	  headerKey="" headerValue="" 
	  list="appDatadestinazioniUso"
	  disabled="isWidgetDisabled('cpCompilaz','cbDestUso')"
	  listKey="cod"
	  listValue="descr"
	  onclick="onCBClick(this,'confermacbDestUso','conferma','%{widg_cbDestUsourlComboBoxValueChange}')" onfocus="inFocus(this)" onblur="lostFocus(this,'confermacbDestUso','conferma','%{widg_cbDestUsourlComboBoxValueChange}')" 
	  />


	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpCompilaz','cbTipoImpianto2')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpCompilaz.cbTipoImpianto2.label')}" labelFor="widg_cbTipoImpianto2" errorFor="appDatacertificato.datiTecnici.tipoImpianto" labelId="cbTipoImpianto2Lbl"
	  >


<!-- widget cbTipoImpianto2 -->

<s:url id="widg_cbTipoImpianto2urlComboBoxValueChange"
   action="/siceeweb/cpCompilaz!handleCbTipoImpianto2_VALUE_CHANGED" namespace="/base/compilazattestati"  
   includeParams="all" portletUrlType="action" 
/>
<s:select name="appDatacertificato.datiTecnici.tipoImpianto" id="widg_cbTipoImpianto2"
	 
	

		title=" - Attenzione. Dopo aver selezionato un valore, la pagina verra' aggiornata automaticamente"
			
	  headerKey="" headerValue="" 
	  list="appDatatipiImpianto"
	  disabled="isWidgetDisabled('cpCompilaz','cbTipoImpianto2')"
	  listKey="cod"
	  listValue="descr"
	  onclick="onCBClick(this,'confermacbTipoImpianto2','conferma','%{widg_cbTipoImpianto2urlComboBoxValueChange}')" onfocus="inFocus(this)" onblur="lostFocus(this,'confermacbTipoImpianto2','conferma','%{widg_cbTipoImpianto2urlComboBoxValueChange}')" 
	  />


	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpCompilaz','cbTipoEdificio')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpCompilaz.cbTipoEdificio.label')}" labelFor="widg_cbTipoEdificio" errorFor="appDatacertificato.datiTecnici.tipoEdificio" labelId="cbTipoEdificioLbl"
	  >


<!-- widget cbTipoEdificio -->

<s:url id="widg_cbTipoEdificiourlComboBoxValueChange"
   action="/siceeweb/cpCompilaz!handleCbTipoEdificio_VALUE_CHANGED" namespace="/base/compilazattestati"  
   includeParams="all" portletUrlType="action" 
/>
<s:select name="appDatacertificato.datiTecnici.tipoEdificio" id="widg_cbTipoEdificio"
	 
	

		title=" - Attenzione. Dopo aver selezionato un valore, la pagina verra' aggiornata automaticamente"
			
	  headerKey="" headerValue="" 
	  list="appDatatipiEdificio"
	  disabled="isWidgetDisabled('cpCompilaz','cbTipoEdificio')"
	  listKey="cod"
	  listValue="descr"
	  onclick="onCBClick(this,'confermacbTipoEdificio','conferma','%{widg_cbTipoEdificiourlComboBoxValueChange}')" onfocus="inFocus(this)" onblur="lostFocus(this,'confermacbTipoEdificio','conferma','%{widg_cbTipoEdificiourlComboBoxValueChange}')" 
	  />


	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpCompilaz','cbCarattEdificio')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpCompilaz.cbCarattEdificio.label')}" labelFor="widg_cbCarattEdificio" errorFor="appDatacertificato.datiTecnici.carattEdificio" labelId="cbCarattEdificioLbl"
	  >


<!-- widget cbCarattEdificio -->
<s:select name="appDatacertificato.datiTecnici.carattEdificio" id="widg_cbCarattEdificio"
	 
	
		title=""
			
	  headerKey="" headerValue="" 
	  list="appDatacarattEdificio"
	  disabled="isWidgetDisabled('cpCompilaz','cbCarattEdificio')"
	  listKey="cod"
	  listValue="descr"
	  
	  />


	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpCompilaz','rbsUsoPubblico')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpCompilaz.rbsUsoPubblico.label')}" labelFor="widg_rbsUsoPubblico" errorFor="appDatacertificato.datiTecnici.flagUsoPubblico" labelId="rbsUsoPubblicoLbl"
	  >


<!-- widget rbsUsoPubblico -->

	
<div id="appDatacertificato.datiTecnici.flagUsoPubblico" class="radiobuttons ">







<s:radio
	
	
	id="widg_rbUsoPubblicoSi" name="appDatacertificato.datiTecnici.flagUsoPubblico"
	list="#{'S':'SI'}"
	disabled="isWidgetDisabled('cpCompilaz','rbsUsoPubblico')"
	cssClass="radio"
	
	/> <label  for="widg_rbUsoPubblicoSiS"><s:text name="cpCompilaz.rbsUsoPubblico.rbUsoPubblicoSi.label" /></label>








<s:radio
	
	
	id="widg_rbUsoPubblicoNo" name="appDatacertificato.datiTecnici.flagUsoPubblico"
	list="#{'N':'No'}"
	disabled="isWidgetDisabled('cpCompilaz','rbsUsoPubblico')"
	cssClass="radio"
	
	/> <label  for="widg_rbUsoPubblicoNoN"><s:text name="cpCompilaz.rbsUsoPubblico.rbUsoPubblicoNo.label" /></label>





	
</div>



	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpCompilaz','tfAnnoCostr')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpCompilaz.tfAnnoCostr.label')}" labelFor="widg_tfAnnoCostr" errorFor="appDatacertificato.datiTecnici.annoCostr" labelId="tfAnnoCostrLbl"
	  >


<!-- widget tfAnnoCostr -->
<s:textfield 
	
	
	name="appDatacertificato.datiTecnici.annoCostr" id="widg_tfAnnoCostr"
maxlength="4"	disabled="isWidgetDisabled('cpCompilaz','tfAnnoCostr')"
	size="15" cssClass="numbers"
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpCompilaz','tfAnnoRistrutt')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpCompilaz.tfAnnoRistrutt.label')}" labelFor="widg_tfAnnoRistrutt" errorFor="appDatacertificato.datiTecnici.annoUltimaRistrutt" labelId="tfAnnoRistruttLbl"
	  >


<!-- widget tfAnnoRistrutt -->
<s:textfield 
	
	
	name="appDatacertificato.datiTecnici.annoUltimaRistrutt" id="widg_tfAnnoRistrutt"
maxlength="4"	disabled="isWidgetDisabled('cpCompilaz','tfAnnoRistrutt')"
	size="15" cssClass="numbers"
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpCompilaz','tfDescrizioneEdificio')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpCompilaz.tfDescrizioneEdificio.label')}" labelFor="widg_tfDescrizioneEdificio" errorFor="appDatacertificato.datiTecnici.descrizioneEdificio" labelId="tfDescrizioneEdificioLbl"
	  >


<!-- widget tfDescrizioneEdificio -->
<s:textfield 
	
	
	name="appDatacertificato.datiTecnici.descrizioneEdificio" id="widg_tfDescrizioneEdificio"
maxlength="25"	disabled="isWidgetDisabled('cpCompilaz','tfDescrizioneEdificio')"
	size="15" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpCompilaz','tfSuperfUtile')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpCompilaz.tfSuperfUtile.label')}" labelFor="widg_tfSuperfUtile" errorFor="appDatacertificato.datiTecnici.superficieUtile" labelId="tfSuperfUtileLbl"
	  >


<!-- widget tfSuperfUtile -->
<s:textfield 
	
	
	name="appDatacertificato.datiTecnici.superficieUtile" id="widg_tfSuperfUtile"
maxlength="10"	disabled="isWidgetDisabled('cpCompilaz','tfSuperfUtile')"
	size="15" cssClass="numbers"
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpCompilaz','tfVolRiscaldato')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpCompilaz.tfVolRiscaldato.label')}" labelFor="widg_tfVolRiscaldato" errorFor="appDatacertificato.datiTecnici.volLordoRiscald" labelId="tfVolRiscaldatoLbl"
	  >


<!-- widget tfVolRiscaldato -->
<s:textfield 
	
	
	name="appDatacertificato.datiTecnici.volLordoRiscald" id="widg_tfVolRiscaldato"
maxlength="10"	disabled="isWidgetDisabled('cpCompilaz','tfVolRiscaldato')"
	size="15" cssClass="numbers"
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpCompilaz','tfSuperfDispTot')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpCompilaz.tfSuperfDispTot.label')}" labelFor="widg_tfSuperfDispTot" errorFor="appDatacertificato.datiTecnici.supDispTot" labelId="tfSuperfDispTotLbl"
	  >


<!-- widget tfSuperfDispTot -->
<s:textfield 
	
	
	name="appDatacertificato.datiTecnici.supDispTot" id="widg_tfSuperfDispTot"
maxlength="10"	disabled="isWidgetDisabled('cpCompilaz','tfSuperfDispTot')"
	size="15" cssClass="numbers"
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpCompilaz','txtFattoreForma')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpCompilaz.txtFattoreForma.label')}" labelFor="widg_txtFattoreForma" errorFor="appDatacertificato.datiTecnici.fattoreForma" labelId="txtFattoreFormaLbl"   tdStyleClass="numbers">


<!-- widget txtFattoreForma -->
<s:property value="appDatacertificato.datiTecnici.fattoreForma" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpCompilaz','tfTrasmittOpache')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpCompilaz.tfTrasmittOpache.label')}" labelFor="widg_tfTrasmittOpache" errorFor="appDatacertificato.datiTecnici.trasmittanzaOpache" labelId="tfTrasmittOpacheLbl"
	  >


<!-- widget tfTrasmittOpache -->
<s:textfield 
	
	
	name="appDatacertificato.datiTecnici.trasmittanzaOpache" id="widg_tfTrasmittOpache"
maxlength="10"	disabled="isWidgetDisabled('cpCompilaz','tfTrasmittOpache')"
	size="15" cssClass="numbers"
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpCompilaz','tfTrasmittTrasp')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpCompilaz.tfTrasmittTrasp.label')}" labelFor="widg_tfTrasmittTrasp" errorFor="appDatacertificato.datiTecnici.trasmittanzaTrasp" labelId="tfTrasmittTraspLbl"
	  >


<!-- widget tfTrasmittTrasp -->
<s:textfield 
	
	
	name="appDatacertificato.datiTecnici.trasmittanzaTrasp" id="widg_tfTrasmittTrasp"
maxlength="10"	disabled="isWidgetDisabled('cpCompilaz','tfTrasmittTrasp')"
	size="15" cssClass="numbers"
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpCompilaz','txtNote1DtTecnici')" >

	
<customtag:widgetsPanelColumn  colSpan="2"  >


<!-- widget txtNote1DtTecnici -->
<s:text name="cpCompilaz.txtNote1DtTecnici.statictext.label" />

	
</customtag:widgetsPanelColumn>

</s:if>

	



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_pDtTecnici --></div>

			
	
	<div id="p_pDtTecniciFun" class="commandPanelBlock"><!-- startFragment:p_pDtTecniciFun -->
	
	
<div class="commandPanel functional" id="pDtTecniciFun">

	
	
		

	
	
	
	

	
	
	
	

	
	
	
	<div class="button right">
		
<s:if test="isWidgetVisible('cpCompilaz','bDtTecniciCalcola')" >

	



<!-- widget bDtTecniciCalcola -->
	<csiuicore:ajaxify id="p_pWizCompilazLiv1" 
		widgetType="button"
		 
		requestUri="/siceeweb/base/compilazattestati/cpCompilaz!handleBDtTecniciCalcola_CLICKED.do" 
		
		pageId="cpCompilaz" 
		formName="cpCompilaz"
		javascriptDetection="false">
<s:submit name="widg_bDtTecniciCalcola" id="widg_bDtTecniciCalcola" method="handleBDtTecniciCalcola_CLICKED"
	key="cpCompilaz.bDtTecniciCalcola.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpCompilaz','bDtTecniciCalcola')" />

	</csiuicore:ajaxify>

	


</s:if>

	


	</div>
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_pDtTecniciFun --></div>

			
	
	<div id="p_pDtTecniciNav" class="commandPanelBlock"><!-- startFragment:p_pDtTecniciNav -->
	
	
<div class="commandPanel navigation" id="pDtTecniciNav">

	
	
		

	
	
	
	<div class="button left">
		
<s:if test="isWidgetVisible('cpCompilaz','bDtTecniciIndietro')" >

	



<!-- widget bDtTecniciIndietro -->
	<csiuicore:ajaxify id="p_pWizCompilazLiv1" 
		widgetType="button"
		 
		requestUri="/siceeweb/base/compilazattestati/cpCompilaz!handleBDtTecniciIndietro_CLICKED.do" 
		
		pageId="cpCompilaz" 
		formName="cpCompilaz"
		javascriptDetection="false">
<s:submit name="widg_bDtTecniciIndietro" id="widg_bDtTecniciIndietro" method="handleBDtTecniciIndietro_CLICKED"
	key="cpCompilaz.bDtTecniciIndietro.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpCompilaz','bDtTecniciIndietro')" />

	</csiuicore:ajaxify>

	


</s:if>

	


	</div>
	
	

	
	
	
	

	
	
	
	<div class="button right">
		
<s:if test="isWidgetVisible('cpCompilaz','bDtTecniciAvanti')" >

	



<!-- widget bDtTecniciAvanti -->
	<csiuicore:ajaxify id="p_pWizCompilazLiv1" 
		widgetType="button"
		 
		requestUri="/siceeweb/base/compilazattestati/cpCompilaz!handleBDtTecniciAvanti_CLICKED.do" 
		
		pageId="cpCompilaz" 
		formName="cpCompilaz"
		javascriptDetection="false">
<s:submit name="widg_bDtTecniciAvanti" id="widg_bDtTecniciAvanti" method="handleBDtTecniciAvanti_CLICKED"
	key="cpCompilaz.bDtTecniciAvanti.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpCompilaz','bDtTecniciAvanti')" />

	</csiuicore:ajaxify>

	


</s:if>

	


	</div>
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_pDtTecniciNav --></div>

	

		
	
</div>

	<!-- endFragment:p_pDatiTecnici --></div>
