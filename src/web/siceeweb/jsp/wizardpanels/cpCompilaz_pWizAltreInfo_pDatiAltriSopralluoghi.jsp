<%@taglib uri="/struts-tags" prefix="s" %>
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="/customtag" prefix="customtag" %>
<%@taglib uri="/csiuicore" prefix="csiuicore" %>

	
	<div id="p_pDatiAltriSopralluoghi" class="formPanelBlock"><!-- startFragment:p_pDatiAltriSopralluoghi -->
		
	
<div class="formPanel" id="pDatiAltriSopralluoghi">


	
	

	
	
			
	
	<div id="p_pErrDtAltriSopralluoghi" class="stdMessagePanelBlock"><!-- startFragment:p_pErrDtAltriSopralluoghi -->
	
	
<div class="stdMessagePanel" id="pErrDtAltriSopralluoghi">
	<customtag:stdMessagePanel id="pErrDtAltriSopralluoghi" errorMessage="true" errorDetails="false" actionMessage="true" />
</div>

	<!-- endFragment:p_pErrDtAltriSopralluoghi --></div>

			
	
	<div id="p_pDtAltriSopralluoghi1" class="widgetsPanelBlock"><!-- startFragment:p_pDtAltriSopralluoghi1 -->
	
	

<div class="widgetsPanel" id="pDtAltriSopralluoghi1">
	
	<customtag:widgetsPanel id="pDtAltriSopralluoghi1Tbl" columns="2" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('cpCompilaz','txtObblDtSopralluoghi')" >

	
<customtag:widgetsPanelColumn  colSpan="2"  >


<!-- widget txtObblDtSopralluoghi -->
<s:text name="cpCompilaz.txtObblDtSopralluoghi.statictext.label" />

	
</customtag:widgetsPanelColumn>

</s:if>

	



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_pDtAltriSopralluoghi1 --></div>

			
	
	<div id="p_pDtAltriSopralluoghi2" class="widgetsPanelBlock"><!-- startFragment:p_pDtAltriSopralluoghi2 -->
	
	
<h4 class="wpLabel">Sopralluoghi </h4>
<div class="widgetsPanel" id="pDtAltriSopralluoghi2">
	
	<customtag:widgetsPanel id="pDtAltriSopralluoghi2Tbl" columns="2" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('cpCompilaz','calDataSopralluogo')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpCompilaz.calDataSopralluogo.label')}" labelFor="widg_calDataSopralluogo" errorFor="appDatacertificato.altreInfo.sopralluoghi.data" labelId="calDataSopralluogoLbl"
	  >


<!-- widget calDataSopralluogo -->
<s:textfield 
	
	
	name="appDatacertificato.altreInfo.sopralluoghi.data" id="widg_calDataSopralluogo"
	disabled="isWidgetDisabled('cpCompilaz','calDataSopralluogo')"
	size="10" maxlength="10" 
	cssClass="calendar"
/> <div class="infoCalendar"></div>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpCompilaz','taNoteSopralluogo')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpCompilaz.taNoteSopralluogo.label')}" labelFor="widg_taNoteSopralluogo" errorFor="appDatacertificato.altreInfo.sopralluoghi.note" labelId="taNoteSopralluogoLbl"
	  >


<!-- widget taNoteSopralluogo -->
<s:textarea 
	
	
	name="appDatacertificato.altreInfo.sopralluoghi.note" id="widg_taNoteSopralluogo"
	disabled="isWidgetDisabled('cpCompilaz','taNoteSopralluogo')"
	rows="7"
	cols="60"
	></s:textarea>

	
</customtag:widgetsPanelColumn>

</s:if>

	



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_pDtAltriSopralluoghi2 --></div>

			
	
	<div id="p_pDtAltriSopralluoghi3" class="widgetsPanelBlock"><!-- startFragment:p_pDtAltriSopralluoghi3 -->
	
	
<h4 class="wpLabel">Dati di ingresso </h4>
<div class="widgetsPanel" id="pDtAltriSopralluoghi3">
	
	<customtag:widgetsPanel id="pDtAltriSopralluoghi3Tbl" columns="2" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('cpCompilaz','cbDatiRedazione')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpCompilaz.cbDatiRedazione.label')}" labelFor="widg_cbDatiRedazione" errorFor="appDatacertificato.altreInfo.sopralluoghi.tipoRedazione" labelId="cbDatiRedazioneLbl"
	  >


<!-- widget cbDatiRedazione -->
<s:select name="appDatacertificato.altreInfo.sopralluoghi.tipoRedazione" id="widg_cbDatiRedazione"
	 
	
		title=""
			
	  headerKey="" headerValue="" 
	  list="appDatatipiRedazione"
	  disabled="isWidgetDisabled('cpCompilaz','cbDatiRedazione')"
	  listKey="cod"
	  listValue="descr"
	  
	  />


	
</customtag:widgetsPanelColumn>

</s:if>

	



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_pDtAltriSopralluoghi3 --></div>

			
	
	<div id="p_pDtAltriSopralluoghiNav" class="commandPanelBlock"><!-- startFragment:p_pDtAltriSopralluoghiNav -->
	
	
<div class="commandPanel navigation" id="pDtAltriSopralluoghiNav">

	
	
		

	
	
	
	<div class="button left">
		
<s:if test="isWidgetVisible('cpCompilaz','bDtAltriSopralluoghiIndietro')" >

	



<!-- widget bDtAltriSopralluoghiIndietro -->
	<csiuicore:ajaxify id="p_pWizCompilazLiv1" 
		widgetType="button"
		 
		requestUri="/siceeweb/base/compilazattestati/cpCompilaz!handleBDtAltriSopralluoghiIndietro_CLICKED.do" 
		
		pageId="cpCompilaz" 
		formName="cpCompilaz"
		javascriptDetection="false">
<s:submit name="widg_bDtAltriSopralluoghiIndietro" id="widg_bDtAltriSopralluoghiIndietro" method="handleBDtAltriSopralluoghiIndietro_CLICKED"
	key="cpCompilaz.bDtAltriSopralluoghiIndietro.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpCompilaz','bDtAltriSopralluoghiIndietro')" />

	</csiuicore:ajaxify>

	


</s:if>

	


	</div>
	
	

	
	
	
	

	
	
	
	<div class="button right">
		
<s:if test="isWidgetVisible('cpCompilaz','bDtAltriSopralluoghiAvanti')" >

	



<!-- widget bDtAltriSopralluoghiAvanti -->
	<csiuicore:ajaxify id="p_pWizCompilazLiv1" 
		widgetType="button"
		 
		requestUri="/siceeweb/base/compilazattestati/cpCompilaz!handleBDtAltriSopralluoghiAvanti_CLICKED.do" 
		
		pageId="cpCompilaz" 
		formName="cpCompilaz"
		javascriptDetection="false">
<s:submit name="widg_bDtAltriSopralluoghiAvanti" id="widg_bDtAltriSopralluoghiAvanti" method="handleBDtAltriSopralluoghiAvanti_CLICKED"
	key="cpCompilaz.bDtAltriSopralluoghiAvanti.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpCompilaz','bDtAltriSopralluoghiAvanti')" />

	</csiuicore:ajaxify>

	


</s:if>

	


	</div>
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_pDtAltriSopralluoghiNav --></div>

	

		
	
</div>

	<!-- endFragment:p_pDatiAltriSopralluoghi --></div>
