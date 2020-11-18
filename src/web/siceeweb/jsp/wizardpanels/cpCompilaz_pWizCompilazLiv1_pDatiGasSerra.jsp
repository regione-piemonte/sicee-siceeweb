<%@taglib uri="/struts-tags" prefix="s" %>
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="/customtag" prefix="customtag" %>
<%@taglib uri="/csiuicore" prefix="csiuicore" %>

	
	<div id="p_pDatiGasSerra" class="formPanelBlock"><!-- startFragment:p_pDatiGasSerra -->
		
	
<div class="formPanel" id="pDatiGasSerra">


	
	

	
	
			
	
	<div id="p_pErrDtGasSerra" class="stdMessagePanelBlock"><!-- startFragment:p_pErrDtGasSerra -->
	
	
<div class="stdMessagePanel" id="pErrDtGasSerra">
	<customtag:stdMessagePanel id="pErrDtGasSerra" errorMessage="true" errorDetails="false" actionMessage="true" />
</div>

	<!-- endFragment:p_pErrDtGasSerra --></div>

			
	
	<div id="p_pDtGasSerra" class="widgetsPanelBlock"><!-- startFragment:p_pDtGasSerra -->
	
	

<div class="widgetsPanel" id="pDtGasSerra">
	
	<customtag:widgetsPanel id="pDtGasSerraTbl" columns="2" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('cpCompilaz','txtObblDtGasSerra')" >

	
<customtag:widgetsPanelColumn  colSpan="2"  >


<!-- widget txtObblDtGasSerra -->
<s:text name="cpCompilaz.txtObblDtGasSerra.statictext.label" />

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpCompilaz','tfEmissioniGasSerra')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpCompilaz.tfEmissioniGasSerra.label')}" labelFor="widg_tfEmissioniGasSerra" errorFor="appDatacertificato.gasSerra.emissioniGasSerra" labelId="tfEmissioniGasSerraLbl"
	  >


<!-- widget tfEmissioniGasSerra -->
<s:textfield 
	
	
	name="appDatacertificato.gasSerra.emissioniGasSerra" id="widg_tfEmissioniGasSerra"
maxlength="10"	disabled="isWidgetDisabled('cpCompilaz','tfEmissioniGasSerra')"
	size="15" cssClass="numbers"
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpCompilaz','tfBoscoEquiv')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpCompilaz.tfBoscoEquiv.label')}" labelFor="widg_tfBoscoEquiv" errorFor="appDatacertificato.gasSerra.supBoscoEquiv" labelId="tfBoscoEquivLbl"
	  >


<!-- widget tfBoscoEquiv -->
<s:textfield 
	
	
	name="appDatacertificato.gasSerra.supBoscoEquiv" id="widg_tfBoscoEquiv"
maxlength="15"	disabled="isWidgetDisabled('cpCompilaz','tfBoscoEquiv')"
	size="15" cssClass="numbers"
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpCompilaz','txtNote1GasSerra')" >

	
<customtag:widgetsPanelColumn  colSpan="2"  >


<!-- widget txtNote1GasSerra -->
<s:text name="cpCompilaz.txtNote1GasSerra.statictext.label" />

	
</customtag:widgetsPanelColumn>

</s:if>

	



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_pDtGasSerra --></div>

			
	
	<div id="p_pDtGasSerraFun" class="commandPanelBlock"><!-- startFragment:p_pDtGasSerraFun -->
	
	
<div class="commandPanel functional" id="pDtGasSerraFun">

	
	
		

	
	
	
	

	
	
	
	

	
	
	
	<div class="button right">
		
<s:if test="isWidgetVisible('cpCompilaz','bDtEmissGasAndSuperfBosco')" >

	



<!-- widget bDtEmissGasAndSuperfBosco -->
	<csiuicore:ajaxify id="p_pWizCompilazLiv1" 
		widgetType="button"
		 
		requestUri="/siceeweb/base/compilazattestati/cpCompilaz!handleBDtEmissGasAndSuperfBosco_CLICKED.do" 
		
		pageId="cpCompilaz" 
		formName="cpCompilaz"
		javascriptDetection="false">
<s:submit name="widg_bDtEmissGasAndSuperfBosco" id="widg_bDtEmissGasAndSuperfBosco" method="handleBDtEmissGasAndSuperfBosco_CLICKED"
	key="cpCompilaz.bDtEmissGasAndSuperfBosco.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpCompilaz','bDtEmissGasAndSuperfBosco')" />

	</csiuicore:ajaxify>

	


</s:if>

	


	</div>
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_pDtGasSerraFun --></div>

			
	
	<div id="p_pDtGasSerraNav" class="commandPanelBlock"><!-- startFragment:p_pDtGasSerraNav -->
	
	
<div class="commandPanel navigation" id="pDtGasSerraNav">

	
	
		

	
	
	
	<div class="button left">
		
<s:if test="isWidgetVisible('cpCompilaz','bDtGasSerraIndietro')" >

	



<!-- widget bDtGasSerraIndietro -->
	<csiuicore:ajaxify id="p_pWizCompilazLiv1" 
		widgetType="button"
		 
		requestUri="/siceeweb/base/compilazattestati/cpCompilaz!handleBDtGasSerraIndietro_CLICKED.do" 
		
		pageId="cpCompilaz" 
		formName="cpCompilaz"
		javascriptDetection="false">
<s:submit name="widg_bDtGasSerraIndietro" id="widg_bDtGasSerraIndietro" method="handleBDtGasSerraIndietro_CLICKED"
	key="cpCompilaz.bDtGasSerraIndietro.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpCompilaz','bDtGasSerraIndietro')" />

	</csiuicore:ajaxify>

	


</s:if>

	


	</div>
	
	

	
	
	
	

	
	
	
	<div class="button right">
		
<s:if test="isWidgetVisible('cpCompilaz','bDtGasSerraAvanti')" >

	



<!-- widget bDtGasSerraAvanti -->
	<csiuicore:ajaxify id="p_pWizCompilazLiv1" 
		widgetType="button"
		 
		requestUri="/siceeweb/base/compilazattestati/cpCompilaz!handleBDtGasSerraAvanti_CLICKED.do" 
		
		pageId="cpCompilaz" 
		formName="cpCompilaz"
		javascriptDetection="false">
<s:submit name="widg_bDtGasSerraAvanti" id="widg_bDtGasSerraAvanti" method="handleBDtGasSerraAvanti_CLICKED"
	key="cpCompilaz.bDtGasSerraAvanti.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpCompilaz','bDtGasSerraAvanti')" />

	</csiuicore:ajaxify>

	


</s:if>

	


	</div>
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_pDtGasSerraNav --></div>

	

		
	
</div>

	<!-- endFragment:p_pDatiGasSerra --></div>
