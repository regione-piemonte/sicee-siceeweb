<%@taglib uri="/struts-tags" prefix="s" %>
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="/customtag" prefix="customtag" %>
<%@taglib uri="/csiuicore" prefix="csiuicore" %>

	
	<div id="p_pDatiFontiRinnov" class="formPanelBlock"><!-- startFragment:p_pDatiFontiRinnov -->
		
	
<div class="formPanel" id="pDatiFontiRinnov">


	
	

	
	
			
	
	<div id="p_pErrDtFontiRinnov" class="stdMessagePanelBlock"><!-- startFragment:p_pErrDtFontiRinnov -->
	
	
<div class="stdMessagePanel" id="pErrDtFontiRinnov">
	<customtag:stdMessagePanel id="pErrDtFontiRinnov" errorMessage="true" errorDetails="false" actionMessage="true" />
</div>

	<!-- endFragment:p_pErrDtFontiRinnov --></div>

			
	
	<div id="p_pDtFontiRinnov" class="widgetsPanelBlock"><!-- startFragment:p_pDtFontiRinnov -->
	
	

<div class="widgetsPanel" id="pDtFontiRinnov">
	
	<customtag:widgetsPanel id="pDtFontiRinnovTbl" columns="2" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('cpCompilaz','tfTechUsoFontiRinnov')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpCompilaz.tfTechUsoFontiRinnov.label')}" labelFor="widg_tfTechUsoFontiRinnov" errorFor="appDatacertificato.energRinnov.techFontiRinnov" labelId="tfTechUsoFontiRinnovLbl"
	  >


<!-- widget tfTechUsoFontiRinnov -->
<s:textfield 
	
	
	name="appDatacertificato.energRinnov.techFontiRinnov" id="widg_tfTechUsoFontiRinnov"
maxlength="500"	disabled="isWidgetDisabled('cpCompilaz','tfTechUsoFontiRinnov')"
	size="15" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpCompilaz','tfannoInstallFontiRinnov')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpCompilaz.tfannoInstallFontiRinnov.label')}" labelFor="widg_tfannoInstallFontiRinnov" errorFor="appDatacertificato.energRinnov.annoInstall" labelId="tfannoInstallFontiRinnovLbl"
	  >


<!-- widget tfannoInstallFontiRinnov -->
<s:textfield 
	
	
	name="appDatacertificato.energRinnov.annoInstall" id="widg_tfannoInstallFontiRinnov"
maxlength="4"	disabled="isWidgetDisabled('cpCompilaz','tfannoInstallFontiRinnov')"
	size="15" cssClass="numbers"
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpCompilaz','tfEnergTermicaProdRinnov')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpCompilaz.tfEnergTermicaProdRinnov.label')}" labelFor="widg_tfEnergTermicaProdRinnov" errorFor="appDatacertificato.energRinnov.energTermicaProdotta" labelId="tfEnergTermicaProdRinnovLbl"
	  >


<!-- widget tfEnergTermicaProdRinnov -->
<s:textfield 
	
	
	name="appDatacertificato.energRinnov.energTermicaProdotta" id="widg_tfEnergTermicaProdRinnov"
maxlength="10"	disabled="isWidgetDisabled('cpCompilaz','tfEnergTermicaProdRinnov')"
	size="15" cssClass="numbers"
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpCompilaz','tfEnergElettricaProdRinnov')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpCompilaz.tfEnergElettricaProdRinnov.label')}" labelFor="widg_tfEnergElettricaProdRinnov" errorFor="appDatacertificato.energRinnov.energElettricaProdotta" labelId="tfEnergElettricaProdRinnovLbl"
	  >


<!-- widget tfEnergElettricaProdRinnov -->
<s:textfield 
	
	
	name="appDatacertificato.energRinnov.energElettricaProdotta" id="widg_tfEnergElettricaProdRinnov"
maxlength="10"	disabled="isWidgetDisabled('cpCompilaz','tfEnergElettricaProdRinnov')"
	size="15" cssClass="numbers"
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpCompilaz','tfAutoconsumoTermicoRinnov')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpCompilaz.tfAutoconsumoTermicoRinnov.label')}" labelFor="widg_tfAutoconsumoTermicoRinnov" errorFor="appDatacertificato.energRinnov.autoconsumoTermico" labelId="tfAutoconsumoTermicoRinnovLbl"
	  >


<!-- widget tfAutoconsumoTermicoRinnov -->
<s:textfield 
	
	
	name="appDatacertificato.energRinnov.autoconsumoTermico" id="widg_tfAutoconsumoTermicoRinnov"
maxlength="10"	disabled="isWidgetDisabled('cpCompilaz','tfAutoconsumoTermicoRinnov')"
	size="15" cssClass="numbers"
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpCompilaz','tfAutoconsumoElettricoRinnov')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpCompilaz.tfAutoconsumoElettricoRinnov.label')}" labelFor="widg_tfAutoconsumoElettricoRinnov" errorFor="appDatacertificato.energRinnov.autoconsumoElettrico" labelId="tfAutoconsumoElettricoRinnovLbl"
	  >


<!-- widget tfAutoconsumoElettricoRinnov -->
<s:textfield 
	
	
	name="appDatacertificato.energRinnov.autoconsumoElettrico" id="widg_tfAutoconsumoElettricoRinnov"
maxlength="10"	disabled="isWidgetDisabled('cpCompilaz','tfAutoconsumoElettricoRinnov')"
	size="15" cssClass="numbers"
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpCompilaz','tfPercEnergiaFontiRinnov')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpCompilaz.tfPercEnergiaFontiRinnov.label')}" labelFor="widg_tfPercEnergiaFontiRinnov" errorFor="appDatacertificato.energRinnov.percEnergiaFontiRinnov" labelId="tfPercEnergiaFontiRinnovLbl"
	  >


<!-- widget tfPercEnergiaFontiRinnov -->
<s:textfield 
	
	
	name="appDatacertificato.energRinnov.percEnergiaFontiRinnov" id="widg_tfPercEnergiaFontiRinnov"
	disabled="isWidgetDisabled('cpCompilaz','tfPercEnergiaFontiRinnov')"
	size="15" cssClass="numbers"
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpCompilaz','txtNote1FontiRinnovabili')" >

	
<customtag:widgetsPanelColumn  colSpan="2"  >


<!-- widget txtNote1FontiRinnovabili -->
<s:text name="cpCompilaz.txtNote1FontiRinnovabili.statictext.label" />

	
</customtag:widgetsPanelColumn>

</s:if>

	



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_pDtFontiRinnov --></div>

			
	
	<div id="p_pDtFontiRinnovFun" class="commandPanelBlock"><!-- startFragment:p_pDtFontiRinnovFun -->
	
	
<div class="commandPanel functional" id="pDtFontiRinnovFun">

	
	
		

	
	
	
	

	
	
	
	

	
	
	
	<div class="button right">
		
<s:if test="isWidgetVisible('cpCompilaz','bDtFontiRinnovCalcola')" >

	



<!-- widget bDtFontiRinnovCalcola -->
	<csiuicore:ajaxify id="p_pWizCompilazLiv1" 
		widgetType="button"
		 
		requestUri="/siceeweb/base/compilazattestati/cpCompilaz!handleBDtFontiRinnovCalcola_CLICKED.do" 
		
		pageId="cpCompilaz" 
		formName="cpCompilaz"
		javascriptDetection="false">
<s:submit name="widg_bDtFontiRinnovCalcola" id="widg_bDtFontiRinnovCalcola" method="handleBDtFontiRinnovCalcola_CLICKED"
	key="cpCompilaz.bDtFontiRinnovCalcola.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpCompilaz','bDtFontiRinnovCalcola')" />

	</csiuicore:ajaxify>

	


</s:if>

	


	</div>
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_pDtFontiRinnovFun --></div>

			
	
	<div id="p_pDtFontiRinnovNav" class="commandPanelBlock"><!-- startFragment:p_pDtFontiRinnovNav -->
	
	
<div class="commandPanel navigation" id="pDtFontiRinnovNav">

	
	
		

	
	
	
	<div class="button left">
		
<s:if test="isWidgetVisible('cpCompilaz','bDtFontiRinnovIndietro')" >

	



<!-- widget bDtFontiRinnovIndietro -->
	<csiuicore:ajaxify id="p_pWizCompilazLiv1" 
		widgetType="button"
		 
		requestUri="/siceeweb/base/compilazattestati/cpCompilaz!handleBDtFontiRinnovIndietro_CLICKED.do" 
		
		pageId="cpCompilaz" 
		formName="cpCompilaz"
		javascriptDetection="false">
<s:submit name="widg_bDtFontiRinnovIndietro" id="widg_bDtFontiRinnovIndietro" method="handleBDtFontiRinnovIndietro_CLICKED"
	key="cpCompilaz.bDtFontiRinnovIndietro.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpCompilaz','bDtFontiRinnovIndietro')" />

	</csiuicore:ajaxify>

	


</s:if>

	


	</div>
	
	

	
	
	
	

	
	
	
	<div class="button right">
		
<s:if test="isWidgetVisible('cpCompilaz','bDtFontiRinnovAvanti')" >

	



<!-- widget bDtFontiRinnovAvanti -->
	<csiuicore:ajaxify id="p_pWizCompilazLiv1" 
		widgetType="button"
		 
		requestUri="/siceeweb/base/compilazattestati/cpCompilaz!handleBDtFontiRinnovAvanti_CLICKED.do" 
		
		pageId="cpCompilaz" 
		formName="cpCompilaz"
		javascriptDetection="false">
<s:submit name="widg_bDtFontiRinnovAvanti" id="widg_bDtFontiRinnovAvanti" method="handleBDtFontiRinnovAvanti_CLICKED"
	key="cpCompilaz.bDtFontiRinnovAvanti.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpCompilaz','bDtFontiRinnovAvanti')" />

	</csiuicore:ajaxify>

	


</s:if>

	


	</div>
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_pDtFontiRinnovNav --></div>

	

		
	
</div>

	<!-- endFragment:p_pDatiFontiRinnov --></div>
