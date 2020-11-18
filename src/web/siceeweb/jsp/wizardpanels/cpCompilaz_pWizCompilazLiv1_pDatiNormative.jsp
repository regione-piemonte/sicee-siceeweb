<%@taglib uri="/struts-tags" prefix="s" %>
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="/customtag" prefix="customtag" %>
<%@taglib uri="/csiuicore" prefix="csiuicore" %>

	
	<div id="p_pDatiNormative" class="formPanelBlock"><!-- startFragment:p_pDatiNormative -->
		
	
<div class="formPanel" id="pDatiNormative">


	
	

	
	
			
	
	<div id="p_pErrDtNormative" class="stdMessagePanelBlock"><!-- startFragment:p_pErrDtNormative -->
	
	
<div class="stdMessagePanel" id="pErrDtNormative">
	<customtag:stdMessagePanel id="pErrDtNormative" errorMessage="true" errorDetails="false" actionMessage="true" />
</div>

	<!-- endFragment:p_pErrDtNormative --></div>

			
	
	<div id="p_pDtNormative" class="widgetsPanelBlock"><!-- startFragment:p_pDtNormative -->
	
	

<div class="widgetsPanel" id="pDtNormative">
	
	<customtag:widgetsPanel id="pDtNormativeTbl" columns="4" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('cpCompilaz','calDataTitoloAbitativo')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpCompilaz.calDataTitoloAbitativo.label')}" labelFor="widg_calDataTitoloAbitativo" errorFor="appDatacertificato.rispNorme.dataTitolo" labelId="calDataTitoloAbitativoLbl"
	position="first"  >


<!-- widget calDataTitoloAbitativo -->
<s:textfield 
	
	
	name="appDatacertificato.rispNorme.dataTitolo" id="widg_calDataTitoloAbitativo"
	disabled="isWidgetDisabled('cpCompilaz','calDataTitoloAbitativo')"
	size="10" maxlength="10" 
	cssClass="calendar"
/> <div class="infoCalendar"></div>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpCompilaz','bDtNormative')" >

	
<customtag:widgetsPanelColumn colSpan="2" position="last">


<!-- widget bDtNormative -->
<s:submit name="widg_bDtNormative" id="widg_bDtNormative" method="handleBDtNormative_CLICKED"
	key="cpCompilaz.bDtNormative.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpCompilaz','bDtNormative')" />

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpCompilaz','txtNormativa')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpCompilaz.txtNormativa.label')}" labelFor="widg_txtNormativa" errorFor="appDatacertificato.rispNorme.descrNorma" labelId="txtNormativaLbl"  position="first" >


<!-- widget txtNormativa -->
<s:property value="appDatacertificato.rispNorme.descrNorma" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpCompilaz','pDtNormative_2_2_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget pDtNormative_2_2_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpCompilaz','rbsAutorizzatoNormativa')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpCompilaz.rbsAutorizzatoNormativa.label')}" labelFor="widg_rbsAutorizzatoNormativa" errorFor="appDatacertificato.rispNorme.autorizzato" labelId="rbsAutorizzatoNormativaLbl"
	position="first"  >


<!-- widget rbsAutorizzatoNormativa -->

	
<div id="appDatacertificato.rispNorme.autorizzato" class="radiobuttons ">







<s:radio
	
	
	id="widg_rbAutorizzatoSi" name="appDatacertificato.rispNorme.autorizzato"
	list="#{'S':'Si'}"
	disabled="isWidgetDisabled('cpCompilaz','rbsAutorizzatoNormativa')"
	cssClass="radio"
	
	/> <label  for="widg_rbAutorizzatoSiS"><s:text name="cpCompilaz.rbsAutorizzatoNormativa.rbAutorizzatoSi.label" /></label>








<s:radio
	
	
	id="widg_rbAutorizzatoNo" name="appDatacertificato.rispNorme.autorizzato"
	list="#{'N':'No'}"
	disabled="isWidgetDisabled('cpCompilaz','rbsAutorizzatoNormativa')"
	cssClass="radio"
	
	/> <label  for="widg_rbAutorizzatoNoN"><s:text name="cpCompilaz.rbsAutorizzatoNormativa.rbAutorizzatoNo.label" /></label>





	
</div>



	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpCompilaz','btnAnnullaAutorizzatoNormativa')" >

	
<customtag:widgetsPanelColumn colSpan="2" position="last">


<!-- widget btnAnnullaAutorizzatoNormativa -->
	<csiuicore:ajaxify id="p_pCenter" 
		widgetType="button"
		 
		requestUri="/siceeweb/base/compilazattestati/cpCompilaz!handleBtnAnnullaAutorizzatoNormativa_CLICKED.do" 
		
		pageId="cpCompilaz" 
		formName="cpCompilaz"
		javascriptDetection="false">
<s:submit name="widg_btnAnnullaAutorizzatoNormativa" id="widg_btnAnnullaAutorizzatoNormativa" method="handleBtnAnnullaAutorizzatoNormativa_CLICKED"
	key="cpCompilaz.btnAnnullaAutorizzatoNormativa.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpCompilaz','btnAnnullaAutorizzatoNormativa')" />

	</csiuicore:ajaxify>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpCompilaz','taMotivoNonAutorizz')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpCompilaz.taMotivoNonAutorizz.label')}" labelFor="widg_taMotivoNonAutorizz" errorFor="appDatacertificato.rispNorme.motivoNonConformita" labelId="taMotivoNonAutorizzLbl"
	position="first" colSpan="3" >


<!-- widget taMotivoNonAutorizz -->
<s:textarea 
	
	
	name="appDatacertificato.rispNorme.motivoNonConformita" id="widg_taMotivoNonAutorizz"
	disabled="isWidgetDisabled('cpCompilaz','taMotivoNonAutorizz')"
	rows="7"
	cols="60"
	></s:textarea>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpCompilaz','taUltNoteNormativa')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpCompilaz.taUltNoteNormativa.label')}" labelFor="widg_taUltNoteNormativa" errorFor="appDatacertificato.rispNorme.note" labelId="taUltNoteNormativaLbl"
	position="first" colSpan="3" >


<!-- widget taUltNoteNormativa -->
<s:textarea 
	
	
	name="appDatacertificato.rispNorme.note" id="widg_taUltNoteNormativa"
	disabled="isWidgetDisabled('cpCompilaz','taUltNoteNormativa')"
	rows="7"
	cols="60"
	></s:textarea>

	
</customtag:widgetsPanelColumn>

</s:if>

	



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_pDtNormative --></div>

			
	
	<div id="p_pDtNormativeNav" class="commandPanelBlock"><!-- startFragment:p_pDtNormativeNav -->
	
	
<div class="commandPanel navigation" id="pDtNormativeNav">

	
	
		

	
	
	
	<div class="button left">
		
<s:if test="isWidgetVisible('cpCompilaz','bDtNormativeIndietro')" >

	



<!-- widget bDtNormativeIndietro -->
<s:submit name="widg_bDtNormativeIndietro" id="widg_bDtNormativeIndietro" method="handleBDtNormativeIndietro_CLICKED"
	key="cpCompilaz.bDtNormativeIndietro.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpCompilaz','bDtNormativeIndietro')" />

	


</s:if>

	


	</div>
	
	

	
	
	
	

	
	
	
	<div class="button right">
		
<s:if test="isWidgetVisible('cpCompilaz','bDtNormativeAvanti')" >

	



<!-- widget bDtNormativeAvanti -->
	<csiuicore:ajaxify id="p_pWizCompilazLiv1" 
		widgetType="button"
		 
		requestUri="/siceeweb/base/compilazattestati/cpCompilaz!handleBDtNormativeAvanti_CLICKED.do" 
		
		pageId="cpCompilaz" 
		formName="cpCompilaz"
		javascriptDetection="false">
<s:submit name="widg_bDtNormativeAvanti" id="widg_bDtNormativeAvanti" method="handleBDtNormativeAvanti_CLICKED"
	key="cpCompilaz.bDtNormativeAvanti.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpCompilaz','bDtNormativeAvanti')" />

	</csiuicore:ajaxify>

	


</s:if>

	


	</div>
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_pDtNormativeNav --></div>

	

		
	
</div>

	<!-- endFragment:p_pDatiNormative --></div>
