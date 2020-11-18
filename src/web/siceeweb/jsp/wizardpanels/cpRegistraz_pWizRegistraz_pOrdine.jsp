<%@taglib uri="/struts-tags" prefix="s" %>
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="/customtag" prefix="customtag" %>
<%@taglib uri="/csiuicore" prefix="csiuicore" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<fmt:setBundle basename="/it/csi/sicee/siceeweb/presentation/siceeweb/action/gestcertificatore/CpRegistrazAction" />

	
	<div id="p_pOrdine" class="formPanelBlock"><!-- startFragment:p_pOrdine -->
		
	
<div class="formPanel" id="pOrdine">


	
	

	
	
			
	
	<div id="p_pErrDtOrdine" class="stdMessagePanelBlock"><!-- startFragment:p_pErrDtOrdine -->
	
	
<div class="stdMessagePanel" id="pErrDtOrdine">
	<customtag:stdMessagePanel id="pErrDtOrdine" errorMessage="true" errorDetails="false" actionMessage="true" />
</div>

	<!-- endFragment:p_pErrDtOrdine --></div>

			
	
	<div id="p_pDtOrdine1" class="widgetsPanelBlock"><!-- startFragment:p_pDtOrdine1 -->
	
	
<h4 class="wpLabel">Titolo di studio </h4>
<div class="widgetsPanel" id="pDtOrdine1">
	
	<customtag:widgetsPanel id="pDtOrdine1Tbl" columns="2" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('cpRegistraz','txtObblOrdine')" >

	
<customtag:widgetsPanelColumn  colSpan="2"  >


<!-- widget txtObblOrdine -->
<s:text name="cpRegistraz.txtObblOrdine.statictext.label" />

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpRegistraz','rbsIscrittoOrdine')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRegistraz.rbsIscrittoOrdine.label')}" labelFor="widg_rbsIscrittoOrdine" errorFor="appDatacertificatore.dtOrdine.flagIscritto" labelId="rbsIscrittoOrdineLbl"
	  >


<!-- widget rbsIscrittoOrdine -->

	
<div id="appDatacertificatore.dtOrdine.flagIscritto" class="radiobuttons ">







<s:url id="widg_rbsIscrittoOrdineurlRadioButtonValueChange"
   action="/siceeweb/cpRegistraz!handleRbsIscrittoOrdine_VALUE_CHANGED" namespace="/base/gestcertificatore"  
   includeParams="all" portletUrlType="action" 
/>

<s:radio
	
	
	id="widg_rbIscrittoOrdineSi" name="appDatacertificatore.dtOrdine.flagIscritto"
	list="#{'S':'si'}"
	disabled="isWidgetDisabled('cpRegistraz','rbsIscrittoOrdine')"
	cssClass="radio"
	onclick="onRBClick('%{widg_rbsIscrittoOrdineurlRadioButtonValueChange}')" 
	/> <label  for="widg_rbIscrittoOrdineSiS"><s:text name="cpRegistraz.rbsIscrittoOrdine.rbIscrittoOrdineSi.label" /></label>








<s:radio
	
	
	id="widg_rbIscrittoOrdineNo" name="appDatacertificatore.dtOrdine.flagIscritto"
	list="#{'N':'no'}"
	disabled="isWidgetDisabled('cpRegistraz','rbsIscrittoOrdine')"
	cssClass="radio"
	onclick="onRBClick('%{widg_rbsIscrittoOrdineurlRadioButtonValueChange}')" 
	/> <label  for="widg_rbIscrittoOrdineNoN"><s:text name="cpRegistraz.rbsIscrittoOrdine.rbIscrittoOrdineNo.label" /></label>





	
</div>



	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpRegistraz','cbTipoIstr')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRegistraz.cbTipoIstr.label')}" labelFor="widg_cbTipoIstr" errorFor="appDatacertificatore.dtOrdine.tipoIstruzione" labelId="cbTipoIstrLbl"
	  >


<!-- widget cbTipoIstr -->

<s:url id="widg_cbTipoIstrurlComboBoxValueChange"
   action="/siceeweb/cpRegistraz!handleCbTipoIstr_VALUE_CHANGED" namespace="/base/gestcertificatore"  
   includeParams="all" portletUrlType="action" 
/>
<s:select name="appDatacertificatore.dtOrdine.tipoIstruzione" id="widg_cbTipoIstr"
	 
	

		title=" - Attenzione. Dopo aver selezionato un valore, la pagina verra' aggiornata automaticamente"
			
	  headerKey="" headerValue="" 
	  list="appDatatipoIstruzione"
	  disabled="isWidgetDisabled('cpRegistraz','cbTipoIstr')"
	  listKey="id"
	  listValue="descr"
	  onclick="onCBClick(this,'confermacbTipoIstr','conferma','%{widg_cbTipoIstrurlComboBoxValueChange}')" onfocus="inFocus(this)" onblur="lostFocus(this,'confermacbTipoIstr','conferma','%{widg_cbTipoIstrurlComboBoxValueChange}')" 
	  />


	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpRegistraz','cbCodiceIstr')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRegistraz.cbCodiceIstr.label')}" labelFor="widg_cbCodiceIstr" errorFor="appDatacertificatore.dtOrdine.codiceIstruzione" labelId="cbCodiceIstrLbl"
	  >


<!-- widget cbCodiceIstr -->

<s:url id="widg_cbCodiceIstrurlComboBoxValueChange"
   action="/siceeweb/cpRegistraz!handleCbCodiceIstr_VALUE_CHANGED" namespace="/base/gestcertificatore"  
   includeParams="all" portletUrlType="action" 
/>
<s:select name="appDatacertificatore.dtOrdine.codiceIstruzione" id="widg_cbCodiceIstr"
	 
	

		title=" - Attenzione. Dopo aver selezionato un valore, la pagina verra' aggiornata automaticamente"
			
	  headerKey="" headerValue="" 
	  list="appDatacodiceIstruzione"
	  disabled="isWidgetDisabled('cpRegistraz','cbCodiceIstr')"
	  listKey="id"
	  listValue="cod"
	  onclick="onCBClick(this,'confermacbCodiceIstr','conferma','%{widg_cbCodiceIstrurlComboBoxValueChange}')" onfocus="inFocus(this)" onblur="lostFocus(this,'confermacbCodiceIstr','conferma','%{widg_cbCodiceIstrurlComboBoxValueChange}')" 
	  />


	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpRegistraz','txtTitolo')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpRegistraz.txtTitolo.label')}" labelFor="widg_txtTitolo" errorFor="appDatacertificatore.dtOrdine.titoloIstruzione" labelId="txtTitoloLbl"   >


<!-- widget txtTitolo -->
<s:property value="appDatacertificatore.dtOrdine.titoloIstruzione" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpRegistraz','tfSezioneIscriz')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRegistraz.tfSezioneIscriz.label')}" labelFor="widg_tfSezioneIscriz" errorFor="appDatacertificatore.dtOrdine.sezione" labelId="tfSezioneIscrizLbl"
	  >


<!-- widget tfSezioneIscriz -->
<s:textfield 
	
	
	name="appDatacertificatore.dtOrdine.sezione" id="widg_tfSezioneIscriz"
maxlength="50"	disabled="isWidgetDisabled('cpRegistraz','tfSezioneIscriz')"
	size="20" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpRegistraz','tfSettoreIscriz')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRegistraz.tfSettoreIscriz.label')}" labelFor="widg_tfSettoreIscriz" errorFor="appDatacertificatore.dtOrdine.settore" labelId="tfSettoreIscrizLbl"
	  >


<!-- widget tfSettoreIscriz -->
<s:textfield 
	
	
	name="appDatacertificatore.dtOrdine.settore" id="widg_tfSettoreIscriz"
maxlength="50"	disabled="isWidgetDisabled('cpRegistraz','tfSettoreIscriz')"
	size="20" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpRegistraz','tfAlboIscriz')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRegistraz.tfAlboIscriz.label')}" labelFor="widg_tfAlboIscriz" errorFor="appDatacertificatore.dtOrdine.albo" labelId="tfAlboIscrizLbl"
	  >


<!-- widget tfAlboIscriz -->
<s:textfield 
	
	
	name="appDatacertificatore.dtOrdine.albo" id="widg_tfAlboIscriz"
maxlength="100"	disabled="isWidgetDisabled('cpRegistraz','tfAlboIscriz')"
	size="20" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpRegistraz','tfProvinciaIscriz')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRegistraz.tfProvinciaIscriz.label')}" labelFor="widg_tfProvinciaIscriz" errorFor="appDatacertificatore.dtOrdine.descrProv" labelId="tfProvinciaIscrizLbl"
	  >


<!-- widget tfProvinciaIscriz -->
<s:textfield 
	
	
	name="appDatacertificatore.dtOrdine.descrProv" id="widg_tfProvinciaIscriz"
maxlength="30"	disabled="isWidgetDisabled('cpRegistraz','tfProvinciaIscriz')"
	size="20" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpRegistraz','tfNumIscriz')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRegistraz.tfNumIscriz.label')}" labelFor="widg_tfNumIscriz" errorFor="appDatacertificatore.dtOrdine.numIscrizione" labelId="tfNumIscrizLbl"
	  >


<!-- widget tfNumIscriz -->
<s:textfield 
	
	
	name="appDatacertificatore.dtOrdine.numIscrizione" id="widg_tfNumIscriz"
maxlength="20"	disabled="isWidgetDisabled('cpRegistraz','tfNumIscriz')"
	size="20" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpRegistraz','calDataIscrizione')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRegistraz.calDataIscrizione.label')}" labelFor="widg_calDataIscrizione" errorFor="appDatacertificatore.dtOrdine.dataIscrizione" labelId="calDataIscrizioneLbl"
	  >


<!-- widget calDataIscrizione -->
<s:textfield 
	
	
	name="appDatacertificatore.dtOrdine.dataIscrizione" id="widg_calDataIscrizione"
	disabled="isWidgetDisabled('cpRegistraz','calDataIscrizione')"
	size="10" maxlength="10" 
	cssClass="calendar"
/> <div class="infoCalendar"></div>

	
</customtag:widgetsPanelColumn>

</s:if>

	



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_pDtOrdine1 --></div>

			
	
	<div id="p_pListaTitoloStudio" class="widgetsPanelBlock"><!-- startFragment:p_pListaTitoloStudio -->
	
	
<h4 class="wpLabel">Titolo di studio </h4>
<div class="widgetsPanel" id="pListaTitoloStudio">
	

	
	
<s:if test="isWidgetVisible('cpRegistraz','tblTitoloStudioSummary')" >

	
<div class="tableWidget">


<!-- widget tblTitoloStudioSummary -->
<s:set name="cpRegistraz_tblTitoloStudioSummary_clearStatus" value="isTableClearStatus('cpRegistraz_tblTitoloStudioSummary')" />
<s:url id="cpRegistrazViewUrl"						   
					   action="cpRegistraz"
					   namespace="/base/gestcertificatore"/>
<display:table name="appDatachiaviTitoloStudio"  				
			   excludedParams="*"			   export="false"
               id="widg_tblTitoloStudioSummary"
               pagesize="0"
               keepStatus="true"
               requestURI="${cpRegistrazViewUrl}"  
               clearStatus="${cpRegistraz_tblTitoloStudioSummary_clearStatus}"
               uid="row_tblTitoloStudioSummary"
               summary="" 
decorator="it.csi.sicee.siceeweb.presentation.decorator.gestcertificatore.CpRegistrazTblTitoloStudioSummaryCustomDecorator"               class="dataTable">
	
		<display:column property="nome" titleKey="cpRegistraz.tblTitoloStudioSummary.nome.label" 
			sortable="false" headerClass="nosort"
			    media="html"
			
 >
			
		</display:column>
		<display:column property="tipo" titleKey="cpRegistraz.tblTitoloStudioSummary.tipo.label" 
			sortable="false" headerClass="nosort"
			    media="html"
			
 >
			
		</display:column>
		<display:column property="dataUpload" titleKey="cpRegistraz.tblTitoloStudioSummary.dataUpload.label" 
			sortable="false" headerClass="nosort"
			    media="html"
			
 >
			
		</display:column>
		<display:column property="flgScarico" titleKey="cpRegistraz.tblTitoloStudioSummary.flgScarico.label" 
			sortable="false" headerClass="nosort"
			    media="html"
			
 >
			
		</display:column>
</display:table>





	
</div>

</s:if>

	



	
	
	
</div>

	<!-- endFragment:p_pListaTitoloStudio --></div>

			
	
	<div id="p_pUploadTitoloStudio" class="widgetsPanelBlock"><!-- startFragment:p_pUploadTitoloStudio -->
	
	

<div class="widgetsPanel" id="pUploadTitoloStudio">
	
	<customtag:widgetsPanel id="pUploadTitoloStudioTbl" columns="4" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('cpRegistraz','attTitoloStudio')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRegistraz.attTitoloStudio.label')}" labelFor="widg_attTitoloStudio" errorFor="widg_attTitoloStudio" labelId="attTitoloStudioLbl"
	position="first"  >


<s:file 
	
title=""	
	name="widg_attTitoloStudio" id="widg_attTitoloStudio"
	disabled="isWidgetDisabled('cpRegistraz','attTitoloStudio')"
	
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpRegistraz','bInsAttTitoloStudio')" >

	
<customtag:widgetsPanelColumn colSpan="2" position="last">


<!-- widget bInsAttTitoloStudio -->
<s:submit name="widg_bInsAttTitoloStudio" id="widg_bInsAttTitoloStudio" method="handleBInsAttTitoloStudio_CLICKED"
	key="cpRegistraz.bInsAttTitoloStudio.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpRegistraz','bInsAttTitoloStudio')" />

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_pUploadTitoloStudio --></div>

			
	
	<div id="p_pPresaVisione" class="widgetsPanelBlock"><!-- startFragment:p_pPresaVisione -->
	
	

<div class="widgetsPanel" id="pPresaVisione">
	
	<customtag:widgetsPanel id="pPresaVisioneTbl" columns="2" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('cpRegistraz','ptPresaVisione')" >

	
<customtag:widgetsPanelColumn  colSpan="2"  >


<!-- widget ptPresaVisione -->
<s:text name="cpRegistraz.ptPresaVisione.statictext.label" />

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpRegistraz','cbAccettoVisione')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRegistraz.cbAccettoVisione.label')}" labelFor="widg_cbAccettoVisione" errorFor="appDatacertificatore.dtOrdine.presaVisione" labelId="cbAccettoVisioneLbl"
	  >


<!-- widget cbAccettoVisione -->
<s:checkbox 
	
	
	name="appDatacertificatore.dtOrdine.presaVisione" id="widg_cbAccettoVisione"
	disabled="isWidgetDisabled('cpRegistraz','cbAccettoVisione')"
	cssClass="checkbox"
	
	/> 
<s:if test="!isWidgetDisabled('cpRegistraz','cbAccettoVisione')" >
	<s:hidden name="__checkbox_appDatacertificatore.dtOrdine.presaVisione" id="__checkbox_widg_cbAccettoVisione" />
</s:if>

	
</customtag:widgetsPanelColumn>

</s:if>

	



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_pPresaVisione --></div>

			
	
	<div id="p_pListaAttPartNew" class="widgetsPanelBlock"><!-- startFragment:p_pListaAttPartNew -->
	
	
<h4 class="wpLabel">Corsi ed esami sostenuti </h4>
<div class="widgetsPanel" id="pListaAttPartNew">
	

	
	
<s:if test="isWidgetVisible('cpRegistraz','tblAttPartNewSummary')" >

	
<div class="tableWidget">


<!-- widget tblAttPartNewSummary -->
<s:set name="cpRegistraz_tblAttPartNewSummary_clearStatus" value="isTableClearStatus('cpRegistraz_tblAttPartNewSummary')" />
<s:url id="cpRegistrazViewUrl"						   
					   action="cpRegistraz"
					   namespace="/base/gestcertificatore"/>
<display:table name="appDatachiaviAttPartNew"  				
			   excludedParams="*"			   export="false"
               id="widg_tblAttPartNewSummary"
               pagesize="0"
               keepStatus="true"
               requestURI="${cpRegistrazViewUrl}"  
               clearStatus="${cpRegistraz_tblAttPartNewSummary_clearStatus}"
               uid="row_tblAttPartNewSummary"
               summary="" 
decorator="it.csi.sicee.siceeweb.presentation.decorator.gestcertificatore.CpRegistrazTblAttPartNewSummaryCustomDecorator"               class="dataTable">
	
		<display:column headerClass="nosort" media="html">
			<s:radio list="%{#attr.row_tblAttPartNewSummary.idCorso}" name="appDataidCorsoSelected" id="%{'tblAttPartNewSummary-editcell-'+ (#attr.row_tblAttPartNewSummary_rowNum - 1)}" cssClass="radio"
			/>
		</display:column>
		<display:column property="titolo" titleKey="cpRegistraz.tblAttPartNewSummary.titolo.label" 
			sortable="false" headerClass="nosort"
			    media="html"
			
 >
			
		</display:column>
		<display:column property="denominazione" titleKey="cpRegistraz.tblAttPartNewSummary.denominazione.label" 
			sortable="false" headerClass="nosort"
			    media="html"
			
 >
			
		</display:column>
		<display:column property="totaleOre" titleKey="cpRegistraz.tblAttPartNewSummary.totaleOre.label" 
			sortable="false" headerClass="nosort"
			    media="html"
			
 >
			
		</display:column>
		<display:column property="dataEsame" titleKey="cpRegistraz.tblAttPartNewSummary.dataEsame.label" 
			sortable="false" headerClass="nosort"
			    media="html"
			
 >
			
		</display:column>
		<display:column property="esitoEsame" titleKey="cpRegistraz.tblAttPartNewSummary.esitoEsame.label" 
			sortable="false" headerClass="nosort"
			    media="html"
			
 >
			
		</display:column>
		<display:column property="flgScarico" titleKey="cpRegistraz.tblAttPartNewSummary.flgScarico.label" 
			sortable="false" headerClass="nosort"
			    media="html"
			
 >
			
		</display:column>
</display:table>





	
</div>

</s:if>

	



	
	
	
</div>

	<!-- endFragment:p_pListaAttPartNew --></div>

			
	
	<div id="p_pUploadAttPartNew" class="widgetsPanelBlock"><!-- startFragment:p_pUploadAttPartNew -->
	
	

<div class="widgetsPanel" id="pUploadAttPartNew">
	
	<customtag:widgetsPanel id="pUploadAttPartNewTbl" columns="4" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('cpRegistraz','attPartNew')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRegistraz.attPartNew.label')}" labelFor="widg_attPartNew" errorFor="widg_attPartNew" labelId="attPartNewLbl"
	position="first"  >


<s:file 
	
	
	name="widg_attPartNew" id="widg_attPartNew"
	disabled="isWidgetDisabled('cpRegistraz','attPartNew')"
	
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpRegistraz','bInsAttPartNew')" >

	
<customtag:widgetsPanelColumn colSpan="2" position="last">


<!-- widget bInsAttPartNew -->
<s:submit name="widg_bInsAttPartNew" id="widg_bInsAttPartNew" method="handleBInsAttPartNew_CLICKED"
	key="cpRegistraz.bInsAttPartNew.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpRegistraz','bInsAttPartNew')" />

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_pUploadAttPartNew --></div>

			
	
	<div id="p_pListaAttPartOld" class="widgetsPanelBlock"><!-- startFragment:p_pListaAttPartOld -->
	
	
<h4 class="wpLabel">Attestati di partecipazione e profitto a corsi regionali e nazionali antecedenti al 20/06/2016 </h4>
<div class="widgetsPanel" id="pListaAttPartOld">
	

	
	
<s:if test="isWidgetVisible('cpRegistraz','tblAttPartOldSummary')" >

	
<div class="tableWidget">


<!-- widget tblAttPartOldSummary -->
<s:set name="cpRegistraz_tblAttPartOldSummary_clearStatus" value="isTableClearStatus('cpRegistraz_tblAttPartOldSummary')" />
<s:url id="cpRegistrazViewUrl"						   
					   action="cpRegistraz"
					   namespace="/base/gestcertificatore"/>
<display:table name="appDatachiaviAttPartOld"  				
			   excludedParams="*"			   export="false"
               id="widg_tblAttPartOldSummary"
               pagesize="0"
               keepStatus="true"
               requestURI="${cpRegistrazViewUrl}"  
               clearStatus="${cpRegistraz_tblAttPartOldSummary_clearStatus}"
               uid="row_tblAttPartOldSummary"
               summary="" 
decorator="it.csi.sicee.siceeweb.presentation.decorator.gestcertificatore.CpRegistrazTblAttPartOldSummaryCustomDecorator"               class="dataTable">
	
		<display:column property="nome" titleKey="cpRegistraz.tblAttPartOldSummary.nome.label" 
			sortable="false" headerClass="nosort"
			    media="html"
			
 >
			
		</display:column>
		<display:column property="tipo" titleKey="cpRegistraz.tblAttPartOldSummary.tipo.label" 
			sortable="false" headerClass="nosort"
			    media="html"
			
 >
			
		</display:column>
		<display:column property="dataUpload" titleKey="cpRegistraz.tblAttPartOldSummary.dataUpload.label" 
			sortable="false" headerClass="nosort"
			    media="html"
			
 >
			
		</display:column>
		<display:column property="flgScarico" titleKey="cpRegistraz.tblAttPartOldSummary.flgScarico.label" 
			sortable="false" headerClass="nosort"
			    media="html"
			
 >
			
		</display:column>
</display:table>





	
</div>

</s:if>

	



	
	
	
</div>

	<!-- endFragment:p_pListaAttPartOld --></div>

			
	
	<div id="p_pNote" class="widgetsPanelBlock"><!-- startFragment:p_pNote -->
	
	

<div class="widgetsPanel" id="pNote">
	
	<customtag:widgetsPanel id="pNoteTbl" columns="2" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('cpRegistraz','txtEsameNotaA')" >

	
<customtag:widgetsPanelColumn  colSpan="2"  >


<!-- widget txtEsameNotaA -->
<s:text name="cpRegistraz.txtEsameNotaA.statictext.label" />

	
</customtag:widgetsPanelColumn>

</s:if>

	



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_pNote --></div>

			
	
	<div id="p_pDtOrdineNav" class="commandPanelBlock"><!-- startFragment:p_pDtOrdineNav -->
	
	
<div class="commandPanel navigation" id="pDtOrdineNav">

	
	
		

	
	
	
	<div class="button left">
		
<s:if test="isWidgetVisible('cpRegistraz','bDtOrdineIndietro')" >

	



<!-- widget bDtOrdineIndietro -->
	<csiuicore:ajaxify id="p_pWizRegistraz,p_pUp" 
		widgetType="button"
		 
		requestUri="/siceeweb/base/gestcertificatore/cpRegistraz!handleBDtOrdineIndietro_CLICKED.do" 
		
		pageId="cpRegistraz" 
		formName="cpRegistraz"
		javascriptDetection="false">
<s:submit name="widg_bDtOrdineIndietro" id="widg_bDtOrdineIndietro" method="handleBDtOrdineIndietro_CLICKED"
	key="cpRegistraz.bDtOrdineIndietro.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpRegistraz','bDtOrdineIndietro')" />

	</csiuicore:ajaxify>

	


</s:if>

	


	</div>
	
	

	
	
	
	

	
	
	
	<div class="button right">
		
<s:if test="isWidgetVisible('cpRegistraz','bDtOrdineAvanti')" >

	



<!-- widget bDtOrdineAvanti -->
<s:submit name="widg_bDtOrdineAvanti" id="widg_bDtOrdineAvanti" method="handleBDtOrdineAvanti_CLICKED"
	key="cpRegistraz.bDtOrdineAvanti.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpRegistraz','bDtOrdineAvanti')" />

	


</s:if>

	


	</div>
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_pDtOrdineNav --></div>

	

		
	
</div>

	<!-- endFragment:p_pOrdine --></div>
