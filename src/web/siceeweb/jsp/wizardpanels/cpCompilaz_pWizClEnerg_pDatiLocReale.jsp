<%@taglib uri="/struts-tags" prefix="s" %>
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="/customtag" prefix="customtag" %>
<%@taglib uri="/csiuicore" prefix="csiuicore" %>

	
	<div id="p_pDatiLocReale" class="formPanelBlock"><!-- startFragment:p_pDatiLocReale -->
		
	
<div class="formPanel" id="pDatiLocReale">


	
	

	
	
			
	
	<div id="p_pErrDtLocReale" class="stdMessagePanelBlock"><!-- startFragment:p_pErrDtLocReale -->
	
	
<div class="stdMessagePanel" id="pErrDtLocReale">
	<customtag:stdMessagePanel id="pErrDtLocReale" errorMessage="true" errorDetails="false" actionMessage="true" />
</div>

	<!-- endFragment:p_pErrDtLocReale --></div>

			
	
	<div id="p_pDtLocReale" class="widgetsPanelBlock"><!-- startFragment:p_pDtLocReale -->
	
	

<div class="widgetsPanel" id="pDtLocReale">
	
	<customtag:widgetsPanel id="pDtLocRealeTbl" columns="2" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('cpCompilaz','txtObblLocReale')" >

	
<customtag:widgetsPanelColumn  colSpan="2"  >


<!-- widget txtObblLocReale -->
<s:text name="cpCompilaz.txtObblLocReale.statictext.label" />

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpCompilaz','tfRendGenerazioneLocReale')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpCompilaz.tfRendGenerazioneLocReale.label')}" labelFor="widg_tfRendGenerazioneLocReale" errorFor="appDatacertificato.classeEnerg.locReale.rendGeneraz" labelId="tfRendGenerazioneLocRealeLbl"
	  >


<!-- widget tfRendGenerazioneLocReale -->
<s:textfield 
	
	
	name="appDatacertificato.classeEnerg.locReale.rendGeneraz" id="widg_tfRendGenerazioneLocReale"
maxlength="10"	disabled="isWidgetDisabled('cpCompilaz','tfRendGenerazioneLocReale')"
	size="15" cssClass="numbers"
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpCompilaz','tfRendRegolazLocReale')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpCompilaz.tfRendRegolazLocReale.label')}" labelFor="widg_tfRendRegolazLocReale" errorFor="appDatacertificato.classeEnerg.locReale.rendRegolaz" labelId="tfRendRegolazLocRealeLbl"
	  >


<!-- widget tfRendRegolazLocReale -->
<s:textfield 
	
	
	name="appDatacertificato.classeEnerg.locReale.rendRegolaz" id="widg_tfRendRegolazLocReale"
maxlength="10"	disabled="isWidgetDisabled('cpCompilaz','tfRendRegolazLocReale')"
	size="15" cssClass="numbers"
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpCompilaz','tfRendEmissLocReale')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpCompilaz.tfRendEmissLocReale.label')}" labelFor="widg_tfRendEmissLocReale" errorFor="appDatacertificato.classeEnerg.locReale.rendEmissione" labelId="tfRendEmissLocRealeLbl"
	  >


<!-- widget tfRendEmissLocReale -->
<s:textfield 
	
	
	name="appDatacertificato.classeEnerg.locReale.rendEmissione" id="widg_tfRendEmissLocReale"
maxlength="10"	disabled="isWidgetDisabled('cpCompilaz','tfRendEmissLocReale')"
	size="15" cssClass="numbers"
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpCompilaz','tfRendDistribLocReale')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpCompilaz.tfRendDistribLocReale.label')}" labelFor="widg_tfRendDistribLocReale" errorFor="appDatacertificato.classeEnerg.locReale.rendDistrib" labelId="tfRendDistribLocRealeLbl"
	  >


<!-- widget tfRendDistribLocReale -->
<s:textfield 
	
	
	name="appDatacertificato.classeEnerg.locReale.rendDistrib" id="widg_tfRendDistribLocReale"
maxlength="10"	disabled="isWidgetDisabled('cpCompilaz','tfRendDistribLocReale')"
	size="15" cssClass="numbers"
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpCompilaz','tfRendMedGlobImpTermicoLocReale')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpCompilaz.tfRendMedGlobImpTermicoLocReale.label')}" labelFor="widg_tfRendMedGlobImpTermicoLocReale" errorFor="appDatacertificato.classeEnerg.locReale.rendGlobTermico" labelId="tfRendMedGlobImpTermicoLocRealeLbl"
	  >


<!-- widget tfRendMedGlobImpTermicoLocReale -->
<s:textfield 
	
	
	name="appDatacertificato.classeEnerg.locReale.rendGlobTermico" id="widg_tfRendMedGlobImpTermicoLocReale"
maxlength="10"	disabled="isWidgetDisabled('cpCompilaz','tfRendMedGlobImpTermicoLocReale')"
	size="15" cssClass="numbers"
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpCompilaz','txtIndPrestEnergRiscaldLocReale')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpCompilaz.txtIndPrestEnergRiscaldLocReale.label')}" labelFor="widg_txtIndPrestEnergRiscaldLocReale" errorFor="appDatacertificato.classeEnerg.locReale.indPrestEnergRiscald" labelId="txtIndPrestEnergRiscaldLocRealeLbl"   tdStyleClass="numbers">


<!-- widget txtIndPrestEnergRiscaldLocReale -->
<s:property value="appDatacertificato.classeEnerg.locReale.indPrestEnergRiscald" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpCompilaz','tfIndPrestazEnergCondizLocReale')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpCompilaz.tfIndPrestazEnergCondizLocReale.label')}" labelFor="widg_tfIndPrestazEnergCondizLocReale" errorFor="appDatacertificato.classeEnerg.locReale.indPrestEnergCondiz" labelId="tfIndPrestazEnergCondizLocRealeLbl"
	  >


<!-- widget tfIndPrestazEnergCondizLocReale -->
<s:textfield 
	
	
	name="appDatacertificato.classeEnerg.locReale.indPrestEnergCondiz" id="widg_tfIndPrestazEnergCondizLocReale"
maxlength="10"	disabled="isWidgetDisabled('cpCompilaz','tfIndPrestazEnergCondizLocReale')"
	size="15" cssClass="numbers"
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpCompilaz','tfIndPrestazEnergIlluminazLocReale')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpCompilaz.tfIndPrestazEnergIlluminazLocReale.label')}" labelFor="widg_tfIndPrestazEnergIlluminazLocReale" errorFor="appDatacertificato.classeEnerg.locReale.indPrestEnergIlluminaz" labelId="tfIndPrestazEnergIlluminazLocRealeLbl"
	  >


<!-- widget tfIndPrestazEnergIlluminazLocReale -->
<s:textfield 
	
	
	name="appDatacertificato.classeEnerg.locReale.indPrestEnergIlluminaz" id="widg_tfIndPrestazEnergIlluminazLocReale"
maxlength="10"	disabled="isWidgetDisabled('cpCompilaz','tfIndPrestazEnergIlluminazLocReale')"
	size="15" cssClass="numbers"
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpCompilaz','txtIndPrestazEnergGlobLocReale')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpCompilaz.txtIndPrestazEnergGlobLocReale.label')}" labelFor="widg_txtIndPrestazEnergGlobLocReale" errorFor="appDatacertificato.classeEnerg.locReale.indPrestEnergGlob" labelId="txtIndPrestazEnergGlobLocRealeLbl"   tdStyleClass="numbers">


<!-- widget txtIndPrestazEnergGlobLocReale -->
<s:property value="appDatacertificato.classeEnerg.locReale.indPrestEnergGlob" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpCompilaz','txtNote1LocReale')" >

	
<customtag:widgetsPanelColumn  colSpan="2"  >


<!-- widget txtNote1LocReale -->
<s:text name="cpCompilaz.txtNote1LocReale.statictext.label" />

	
</customtag:widgetsPanelColumn>

</s:if>

	



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_pDtLocReale --></div>

			
	
	<div id="p_pDtLocRealeFun" class="commandPanelBlock"><!-- startFragment:p_pDtLocRealeFun -->
	
	
<div class="commandPanel functional" id="pDtLocRealeFun">

	
	
		

	
	
	
	

	
	
	
	

	
	
	
	<div class="button right">
		
<s:if test="isWidgetVisible('cpCompilaz','bDtLocReale')" >

	



<!-- widget bDtLocReale -->
	<csiuicore:ajaxify id="p_pWizCompilazLiv1" 
		widgetType="button"
		 
		requestUri="/siceeweb/base/compilazattestati/cpCompilaz!handleBDtLocReale_CLICKED.do" 
		
		pageId="cpCompilaz" 
		formName="cpCompilaz"
		javascriptDetection="false">
<s:submit name="widg_bDtLocReale" id="widg_bDtLocReale" method="handleBDtLocReale_CLICKED"
	key="cpCompilaz.bDtLocReale.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpCompilaz','bDtLocReale')" />

	</csiuicore:ajaxify>

	


</s:if>

	


	</div>
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_pDtLocRealeFun --></div>

			
	
	<div id="p_pDtLocRealeNav" class="commandPanelBlock"><!-- startFragment:p_pDtLocRealeNav -->
	
	
<div class="commandPanel navigation" id="pDtLocRealeNav">

	
	
		

	
	
	
	<div class="button left">
		
<s:if test="isWidgetVisible('cpCompilaz','bDtLocRealeIndietro')" >

	



<!-- widget bDtLocRealeIndietro -->
	<csiuicore:ajaxify id="p_pWizCompilazLiv1" 
		widgetType="button"
		 
		requestUri="/siceeweb/base/compilazattestati/cpCompilaz!handleBDtLocRealeIndietro_CLICKED.do" 
		
		pageId="cpCompilaz" 
		formName="cpCompilaz"
		javascriptDetection="false">
<s:submit name="widg_bDtLocRealeIndietro" id="widg_bDtLocRealeIndietro" method="handleBDtLocRealeIndietro_CLICKED"
	key="cpCompilaz.bDtLocRealeIndietro.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpCompilaz','bDtLocRealeIndietro')" />

	</csiuicore:ajaxify>

	


</s:if>

	


	</div>
	
	

	
	
	
	

	
	
	
	<div class="button right">
		
<s:if test="isWidgetVisible('cpCompilaz','bDtLocRealeAvanti')" >

	



<!-- widget bDtLocRealeAvanti -->
	<csiuicore:ajaxify id="p_pWizCompilazLiv1" 
		widgetType="button"
		 
		requestUri="/siceeweb/base/compilazattestati/cpCompilaz!handleBDtLocRealeAvanti_CLICKED.do" 
		
		pageId="cpCompilaz" 
		formName="cpCompilaz"
		javascriptDetection="false">
<s:submit name="widg_bDtLocRealeAvanti" id="widg_bDtLocRealeAvanti" method="handleBDtLocRealeAvanti_CLICKED"
	key="cpCompilaz.bDtLocRealeAvanti.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpCompilaz','bDtLocRealeAvanti')" />

	</csiuicore:ajaxify>

	


</s:if>

	


	</div>
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_pDtLocRealeNav --></div>

	

		
	
</div>

	<!-- endFragment:p_pDatiLocReale --></div>
