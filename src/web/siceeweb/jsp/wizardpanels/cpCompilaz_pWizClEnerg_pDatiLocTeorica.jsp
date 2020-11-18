<%@taglib uri="/struts-tags" prefix="s" %>
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="/customtag" prefix="customtag" %>
<%@taglib uri="/csiuicore" prefix="csiuicore" %>

	
	<div id="p_pDatiLocTeorica" class="formPanelBlock"><!-- startFragment:p_pDatiLocTeorica -->
		
	
<div class="formPanel" id="pDatiLocTeorica">


	
	

	
	
			
	
	<div id="p_pErrDtLocTeorica" class="stdMessagePanelBlock"><!-- startFragment:p_pErrDtLocTeorica -->
	
	
<div class="stdMessagePanel" id="pErrDtLocTeorica">
	<customtag:stdMessagePanel id="pErrDtLocTeorica" errorMessage="true" errorDetails="false" actionMessage="true" />
</div>

	<!-- endFragment:p_pErrDtLocTeorica --></div>

			
	
	<div id="p_pDtLocTeorica" class="widgetsPanelBlock"><!-- startFragment:p_pDtLocTeorica -->
	
	

<div class="widgetsPanel" id="pDtLocTeorica">
	
	<customtag:widgetsPanel id="pDtLocTeoricaTbl" columns="2" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('cpCompilaz','txtObblLocTeor')" >

	
<customtag:widgetsPanelColumn  colSpan="2"  >


<!-- widget txtObblLocTeor -->
<s:text name="cpCompilaz.txtObblLocTeor.statictext.label" />

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpCompilaz','tfDomEnergRiscaldLocTeor')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpCompilaz.tfDomEnergRiscaldLocTeor.label')}" labelFor="widg_tfDomEnergRiscaldLocTeor" errorFor="appDatacertificato.classeEnerg.locTeorica.domEnergRiscald" labelId="tfDomEnergRiscaldLocTeorLbl"
	  >


<!-- widget tfDomEnergRiscaldLocTeor -->
<s:textfield 
	
	
	name="appDatacertificato.classeEnerg.locTeorica.domEnergRiscald" id="widg_tfDomEnergRiscaldLocTeor"
maxlength="10"	disabled="isWidgetDisabled('cpCompilaz','tfDomEnergRiscaldLocTeor')"
	size="15" cssClass="numbers"
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpCompilaz','txtLimNormRegLocTeor')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpCompilaz.txtLimNormRegLocTeor.label')}" labelFor="widg_txtLimNormRegLocTeor" errorFor="appDatacertificato.classeEnerg.locTeorica.limNormaRegione" labelId="txtLimNormRegLocTeorLbl"   tdStyleClass="numbers">


<!-- widget txtLimNormRegLocTeor -->
<s:property value="appDatacertificato.classeEnerg.locTeorica.limNormaRegione" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpCompilaz','tfIndPrestEnergRiscaldLocTeor')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpCompilaz.tfIndPrestEnergRiscaldLocTeor.label')}" labelFor="widg_tfIndPrestEnergRiscaldLocTeor" errorFor="appDatacertificato.classeEnerg.locTeorica.indPrestEnergRiscald" labelId="tfIndPrestEnergRiscaldLocTeorLbl"
	  >


<!-- widget tfIndPrestEnergRiscaldLocTeor -->
<s:textfield 
	
	
	name="appDatacertificato.classeEnerg.locTeorica.indPrestEnergRiscald" id="widg_tfIndPrestEnergRiscaldLocTeor"
maxlength="10"	disabled="isWidgetDisabled('cpCompilaz','tfIndPrestEnergRiscaldLocTeor')"
	size="15" cssClass="numbers"
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpCompilaz','tfDomandaEnergAcquaCaldaLocTeor')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpCompilaz.tfDomandaEnergAcquaCaldaLocTeor.label')}" labelFor="widg_tfDomandaEnergAcquaCaldaLocTeor" errorFor="appDatacertificato.classeEnerg.locTeorica.domEnergAcqua" labelId="tfDomandaEnergAcquaCaldaLocTeorLbl"
	  >


<!-- widget tfDomandaEnergAcquaCaldaLocTeor -->
<s:textfield 
	
	
	name="appDatacertificato.classeEnerg.locTeorica.domEnergAcqua" id="widg_tfDomandaEnergAcquaCaldaLocTeor"
maxlength="10"	disabled="isWidgetDisabled('cpCompilaz','tfDomandaEnergAcquaCaldaLocTeor')"
	size="15" cssClass="numbers"
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpCompilaz','tfEnergTermAcquaCaldaRinnovLocTeor')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpCompilaz.tfEnergTermAcquaCaldaRinnovLocTeor.label')}" labelFor="widg_tfEnergTermAcquaCaldaRinnovLocTeor" errorFor="appDatacertificato.classeEnerg.locTeorica.energTermAcquaRinnov" labelId="tfEnergTermAcquaCaldaRinnovLocTeorLbl"
	  >


<!-- widget tfEnergTermAcquaCaldaRinnovLocTeor -->
<s:textfield 
	
	
	name="appDatacertificato.classeEnerg.locTeorica.energTermAcquaRinnov" id="widg_tfEnergTermAcquaCaldaRinnovLocTeor"
maxlength="10"	disabled="isWidgetDisabled('cpCompilaz','tfEnergTermAcquaCaldaRinnovLocTeor')"
	size="15" cssClass="numbers"
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpCompilaz','tfIndPrestEnergAcquaCaldaLocTeor')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpCompilaz.tfIndPrestEnergAcquaCaldaLocTeor.label')}" labelFor="widg_tfIndPrestEnergAcquaCaldaLocTeor" errorFor="appDatacertificato.classeEnerg.locTeorica.indPrestEnergAcqua" labelId="tfIndPrestEnergAcquaCaldaLocTeorLbl"
	  >


<!-- widget tfIndPrestEnergAcquaCaldaLocTeor -->
<s:textfield 
	
	
	name="appDatacertificato.classeEnerg.locTeorica.indPrestEnergAcqua" id="widg_tfIndPrestEnergAcquaCaldaLocTeor"
maxlength="10"	disabled="isWidgetDisabled('cpCompilaz','tfIndPrestEnergAcquaCaldaLocTeor')"
	size="15" cssClass="numbers"
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpCompilaz','txtIndPrestazEnergGlobLocTeor')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpCompilaz.txtIndPrestazEnergGlobLocTeor.label')}" labelFor="widg_txtIndPrestazEnergGlobLocTeor" errorFor="appDatacertificato.classeEnerg.locTeorica.indPrestEnergGlob" labelId="txtIndPrestazEnergGlobLocTeorLbl"   tdStyleClass="numbers">


<!-- widget txtIndPrestazEnergGlobLocTeor -->
<s:property value="appDatacertificato.classeEnerg.locTeorica.indPrestEnergGlob" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpCompilaz','txtClasseEnergLocTeor')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpCompilaz.txtClasseEnergLocTeor.label')}" labelFor="widg_txtClasseEnergLocTeor" errorFor="appDatacertificato.classeEnerg.locTeorica.descClasseEnerg" labelId="txtClasseEnergLocTeorLbl"   >


<!-- widget txtClasseEnergLocTeor -->
<s:property value="appDatacertificato.classeEnerg.locTeorica.descClasseEnerg" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpCompilaz','txtServEnergInclusiLocTeor')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpCompilaz.txtServEnergInclusiLocTeor.label')}" labelFor="widg_txtServEnergInclusiLocTeor" errorFor="appDatacertificato.classeEnerg.locTeorica.servEnergInclusi" labelId="txtServEnergInclusiLocTeorLbl"   >


<!-- widget txtServEnergInclusiLocTeor -->
<s:property value="appDatacertificato.classeEnerg.locTeorica.servEnergInclusi" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpCompilaz','txtNote1LocTeorica')" >

	
<customtag:widgetsPanelColumn  colSpan="2"  >


<!-- widget txtNote1LocTeorica -->
<s:text name="cpCompilaz.txtNote1LocTeorica.statictext.label" />

	
</customtag:widgetsPanelColumn>

</s:if>

	



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_pDtLocTeorica --></div>

			
	
	<div id="p_pDtLocTeoricaFun" class="commandPanelBlock"><!-- startFragment:p_pDtLocTeoricaFun -->
	
	
<div class="commandPanel functional" id="pDtLocTeoricaFun">

	
	
		

	
	
	
	

	
	
	
	

	
	
	
	<div class="button right">
		
<s:if test="isWidgetVisible('cpCompilaz','bDtLocTeor')" >

	



<!-- widget bDtLocTeor -->
	<csiuicore:ajaxify id="p_pWizCompilazLiv1" 
		widgetType="button"
		 
		requestUri="/siceeweb/base/compilazattestati/cpCompilaz!handleBDtLocTeor_CLICKED.do" 
		
		pageId="cpCompilaz" 
		formName="cpCompilaz"
		javascriptDetection="false">
<s:submit name="widg_bDtLocTeor" id="widg_bDtLocTeor" method="handleBDtLocTeor_CLICKED"
	key="cpCompilaz.bDtLocTeor.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpCompilaz','bDtLocTeor')" />

	</csiuicore:ajaxify>

	


</s:if>

	


	</div>
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_pDtLocTeoricaFun --></div>

			
	
	<div id="p_pDtLocTeoricaNav" class="commandPanelBlock"><!-- startFragment:p_pDtLocTeoricaNav -->
	
	
<div class="commandPanel navigation" id="pDtLocTeoricaNav">

	
	
		

	
	
	
	<div class="button left">
		
<s:if test="isWidgetVisible('cpCompilaz','bDtLocTeoricaIndietro')" >

	



<!-- widget bDtLocTeoricaIndietro -->
	<csiuicore:ajaxify id="p_pWizCompilazLiv1" 
		widgetType="button"
		 
		requestUri="/siceeweb/base/compilazattestati/cpCompilaz!handleBDtLocTeoricaIndietro_CLICKED.do" 
		
		pageId="cpCompilaz" 
		formName="cpCompilaz"
		javascriptDetection="false">
<s:submit name="widg_bDtLocTeoricaIndietro" id="widg_bDtLocTeoricaIndietro" method="handleBDtLocTeoricaIndietro_CLICKED"
	key="cpCompilaz.bDtLocTeoricaIndietro.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpCompilaz','bDtLocTeoricaIndietro')" />

	</csiuicore:ajaxify>

	


</s:if>

	


	</div>
	
	

	
	
	
	

	
	
	
	<div class="button right">
		
<s:if test="isWidgetVisible('cpCompilaz','bDtLocTeoricaAvanti')" >

	



<!-- widget bDtLocTeoricaAvanti -->
	<csiuicore:ajaxify id="p_pWizCompilazLiv1" 
		widgetType="button"
		 
		requestUri="/siceeweb/base/compilazattestati/cpCompilaz!handleBDtLocTeoricaAvanti_CLICKED.do" 
		
		pageId="cpCompilaz" 
		formName="cpCompilaz"
		javascriptDetection="false">
<s:submit name="widg_bDtLocTeoricaAvanti" id="widg_bDtLocTeoricaAvanti" method="handleBDtLocTeoricaAvanti_CLICKED"
	key="cpCompilaz.bDtLocTeoricaAvanti.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpCompilaz','bDtLocTeoricaAvanti')" />

	</csiuicore:ajaxify>

	


</s:if>

	


	</div>
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_pDtLocTeoricaNav --></div>

	

		
	
</div>

	<!-- endFragment:p_pDatiLocTeorica --></div>
