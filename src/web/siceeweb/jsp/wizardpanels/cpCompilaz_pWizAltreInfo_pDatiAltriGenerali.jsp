<%@taglib uri="/struts-tags" prefix="s" %>
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="/customtag" prefix="customtag" %>
<%@taglib uri="/csiuicore" prefix="csiuicore" %>

	
	<div id="p_pDatiAltriGenerali" class="formPanelBlock"><!-- startFragment:p_pDatiAltriGenerali -->
		
	
<div class="formPanel" id="pDatiAltriGenerali">


	
	

	
	
			
	
	<div id="p_pErrDtAltriGenerali" class="stdMessagePanelBlock"><!-- startFragment:p_pErrDtAltriGenerali -->
	
	
<div class="stdMessagePanel" id="pErrDtAltriGenerali">
	<customtag:stdMessagePanel id="pErrDtAltriGenerali" errorMessage="true" errorDetails="false" actionMessage="true" />
</div>

	<!-- endFragment:p_pErrDtAltriGenerali --></div>

			
	
	<div id="p_pDtAltriGenerali" class="widgetsPanelBlock"><!-- startFragment:p_pDtAltriGenerali -->
	
	

<div class="widgetsPanel" id="pDtAltriGenerali">
	
	<customtag:widgetsPanel id="pDtAltriGeneraliTbl" columns="2" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('cpCompilaz','txtObblDatiAltriGenerali')" >

	
<customtag:widgetsPanelColumn  colSpan="2"  >


<!-- widget txtObblDatiAltriGenerali -->
<s:text name="cpCompilaz.txtObblDatiAltriGenerali.statictext.label" />

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpCompilaz','cbMotivoRilascio')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpCompilaz.cbMotivoRilascio.label')}" labelFor="widg_cbMotivoRilascio" errorFor="appDatacertificato.altreInfo.generali.motivoRilascio" labelId="cbMotivoRilascioLbl"
	  >


<!-- widget cbMotivoRilascio -->
<s:select name="appDatacertificato.altreInfo.generali.motivoRilascio" id="widg_cbMotivoRilascio"
	 
	
		title=""
			
	  headerKey="" headerValue="" 
	  list="appDatamotiviRilascio"
	  disabled="isWidgetDisabled('cpCompilaz','cbMotivoRilascio')"
	  listKey="cod"
	  listValue="descr"
	  
	  />


	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpCompilaz','tfMetodoCalcolo')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpCompilaz.tfMetodoCalcolo.label')}" labelFor="widg_tfMetodoCalcolo" errorFor="appDatacertificato.altreInfo.generali.metodoCalcolo" labelId="tfMetodoCalcoloLbl"
	  >


<!-- widget tfMetodoCalcolo -->
<s:textfield 
	
	
	name="appDatacertificato.altreInfo.generali.metodoCalcolo" id="widg_tfMetodoCalcolo"
maxlength="100"	disabled="isWidgetDisabled('cpCompilaz','tfMetodoCalcolo')"
	size="15" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpCompilaz','tfSoftwareUtilizzato')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpCompilaz.tfSoftwareUtilizzato.label')}" labelFor="widg_tfSoftwareUtilizzato" errorFor="appDatacertificato.altreInfo.generali.software" labelId="tfSoftwareUtilizzatoLbl"
	  >


<!-- widget tfSoftwareUtilizzato -->
<s:textfield 
	
	
	name="appDatacertificato.altreInfo.generali.software" id="widg_tfSoftwareUtilizzato"
maxlength="100"	disabled="isWidgetDisabled('cpCompilaz','tfSoftwareUtilizzato')"
	size="15" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpCompilaz','tfDenominazProdSW')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpCompilaz.tfDenominazProdSW.label')}" labelFor="widg_tfDenominazProdSW" errorFor="appDatacertificato.altreInfo.generali.denomProduttore" labelId="tfDenominazProdSWLbl"
	  >


<!-- widget tfDenominazProdSW -->
<s:textfield 
	
	
	name="appDatacertificato.altreInfo.generali.denomProduttore" id="widg_tfDenominazProdSW"
maxlength="100"	disabled="isWidgetDisabled('cpCompilaz','tfDenominazProdSW')"
	size="15" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpCompilaz','tfRispondenzaUNITS')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpCompilaz.tfRispondenzaUNITS.label')}" labelFor="widg_tfRispondenzaUNITS" errorFor="appDatacertificato.altreInfo.generali.rispondenzaUNITS11300" labelId="tfRispondenzaUNITSLbl"
	  >


<!-- widget tfRispondenzaUNITS -->
<s:textarea 
	
	
	name="appDatacertificato.altreInfo.generali.rispondenzaUNITS11300" id="widg_tfRispondenzaUNITS"
	disabled="isWidgetDisabled('cpCompilaz','tfRispondenzaUNITS')"
	rows="7"
	cols="60"
	></s:textarea>

	
</customtag:widgetsPanelColumn>

</s:if>

	



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_pDtAltriGenerali --></div>

			
	
	<div id="p_pDtAltriGeneraliNav" class="commandPanelBlock"><!-- startFragment:p_pDtAltriGeneraliNav -->
	
	
<div class="commandPanel navigation" id="pDtAltriGeneraliNav">

	
	
		

	
	
	
	<div class="button left">
		
<s:if test="isWidgetVisible('cpCompilaz','bDtAltriGeneraliIndietro')" >

	



<!-- widget bDtAltriGeneraliIndietro -->
	<csiuicore:ajaxify id="p_pWizCompilazLiv1" 
		widgetType="button"
		 
		requestUri="/siceeweb/base/compilazattestati/cpCompilaz!handleBDtAltriGeneraliIndietro_CLICKED.do" 
		
		pageId="cpCompilaz" 
		formName="cpCompilaz"
		javascriptDetection="false">
<s:submit name="widg_bDtAltriGeneraliIndietro" id="widg_bDtAltriGeneraliIndietro" method="handleBDtAltriGeneraliIndietro_CLICKED"
	key="cpCompilaz.bDtAltriGeneraliIndietro.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpCompilaz','bDtAltriGeneraliIndietro')" />

	</csiuicore:ajaxify>

	


</s:if>

	


	</div>
	
	

	
	
	
	

	
	
	
	<div class="button right">
		
<s:if test="isWidgetVisible('cpCompilaz','bDtAltriGeneraliAvanti')" >

	



<!-- widget bDtAltriGeneraliAvanti -->
	<csiuicore:ajaxify id="p_pWizCompilazLiv1" 
		widgetType="button"
		 
		requestUri="/siceeweb/base/compilazattestati/cpCompilaz!handleBDtAltriGeneraliAvanti_CLICKED.do" 
		
		pageId="cpCompilaz" 
		formName="cpCompilaz"
		javascriptDetection="false">
<s:submit name="widg_bDtAltriGeneraliAvanti" id="widg_bDtAltriGeneraliAvanti" method="handleBDtAltriGeneraliAvanti_CLICKED"
	key="cpCompilaz.bDtAltriGeneraliAvanti.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpCompilaz','bDtAltriGeneraliAvanti')" />

	</csiuicore:ajaxify>

	


</s:if>

	


	</div>
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_pDtAltriGeneraliNav --></div>

	

		
	
</div>

	<!-- endFragment:p_pDatiAltriGenerali --></div>
