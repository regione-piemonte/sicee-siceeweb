<%@taglib uri="/struts-tags" prefix="s" %>
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="/customtag" prefix="customtag" %>
<%@taglib uri="/csiuicore" prefix="csiuicore" %>

	
	<div id="p_pDatiFabbisogno" class="formPanelBlock"><!-- startFragment:p_pDatiFabbisogno -->
		
	
<div class="formPanel" id="pDatiFabbisogno">


	
	

	
	
			
	
	<div id="p_pErrDtFabbisogno" class="stdMessagePanelBlock"><!-- startFragment:p_pErrDtFabbisogno -->
	
	
<div class="stdMessagePanel" id="pErrDtFabbisogno">
	<customtag:stdMessagePanel id="pErrDtFabbisogno" errorMessage="true" errorDetails="false" actionMessage="true" />
</div>

	<!-- endFragment:p_pErrDtFabbisogno --></div>

			
	
	<div id="p_pDtFabbisogno" class="widgetsPanelBlock"><!-- startFragment:p_pDtFabbisogno -->
	
	

<div class="widgetsPanel" id="pDtFabbisogno">
	
	<customtag:widgetsPanel id="pDtFabbisognoTbl" columns="2" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('cpCompilaz','txtObblFabbisogno')" >

	
<customtag:widgetsPanelColumn  colSpan="2"  >


<!-- widget txtObblFabbisogno -->
<s:text name="cpCompilaz.txtObblFabbisogno.statictext.label" />

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpCompilaz','tfFabbisognoRiscald')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpCompilaz.tfFabbisognoRiscald.label')}" labelFor="widg_tfFabbisognoRiscald" errorFor="appDatacertificato.indFabbisogno.domEnergRiscald" labelId="tfFabbisognoRiscaldLbl"
	  >


<!-- widget tfFabbisognoRiscald -->
<s:textfield 
	
	
	name="appDatacertificato.indFabbisogno.domEnergRiscald" id="widg_tfFabbisognoRiscald"
maxlength="10"	disabled="isWidgetDisabled('cpCompilaz','tfFabbisognoRiscald')"
	size="15" cssClass="numbers"
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpCompilaz','txtLimiteNormaRegionale')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpCompilaz.txtLimiteNormaRegionale.label')}" labelFor="widg_txtLimiteNormaRegionale" errorFor="appDatacertificato.indFabbisogno.limNormRegione" labelId="txtLimiteNormaRegionaleLbl"   tdStyleClass="numbers">


<!-- widget txtLimiteNormaRegionale -->
<s:property value="appDatacertificato.indFabbisogno.limNormRegione" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpCompilaz','rbFabbisognoEnergia')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpCompilaz.rbFabbisognoEnergia.label')}" labelFor="widg_rbFabbisognoEnergia" errorFor="appDatacertificato.indFabbisogno.fabAcquaCaldaSanit" labelId="rbFabbisognoEnergiaLbl"
	  >


<!-- widget rbFabbisognoEnergia -->
	<csiuicore:ajaxify id="p_pDatiFabbisogno" 
		widgetType="radio" 
		requestUri="/siceeweb/base/compilazattestati/cpCompilaz!handleRbFabbisognoEnergia_VALUE_CHANGED.do"
		pageId="cpCompilaz"
		formName="cpCompilaz"
		javascriptDetection="false">

	
<div id="appDatacertificato.indFabbisogno.fabAcquaCaldaSanit" class="radiobuttons ">







<s:url id="widg_rbFabbisognoEnergiaurlRadioButtonValueChange"
   action="/siceeweb/cpCompilaz!handleRbFabbisognoEnergia_VALUE_CHANGED" namespace="/base/compilazattestati"  
   includeParams="all" portletUrlType="action" 
/>

<s:radio
	
	
	id="widg_rbFabAcquaCalsaSanitSi" name="appDatacertificato.indFabbisogno.fabAcquaCaldaSanit"
	list="#{'S':'SI'}"
	disabled="isWidgetDisabled('cpCompilaz','rbFabbisognoEnergia')"
	cssClass="radio"
	onclick="onRBClick('%{widg_rbFabbisognoEnergiaurlRadioButtonValueChange}')" 
	/> <label  for="widg_rbFabAcquaCalsaSanitSiS"><s:text name="cpCompilaz.rbFabbisognoEnergia.rbFabAcquaCalsaSanitSi.label" /></label>








<s:radio
	
	
	id="widg_rbFabAcquaCalsaSanitNo" name="appDatacertificato.indFabbisogno.fabAcquaCaldaSanit"
	list="#{'N':'NO'}"
	disabled="isWidgetDisabled('cpCompilaz','rbFabbisognoEnergia')"
	cssClass="radio"
	onclick="onRBClick('%{widg_rbFabbisognoEnergiaurlRadioButtonValueChange}')" 
	/> <label  for="widg_rbFabAcquaCalsaSanitNoN"><s:text name="cpCompilaz.rbFabbisognoEnergia.rbFabAcquaCalsaSanitNo.label" /></label>





	
</div>


	</csiuicore:ajaxify>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpCompilaz','tfFabbisognoAcquaCalda')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpCompilaz.tfFabbisognoAcquaCalda.label')}" labelFor="widg_tfFabbisognoAcquaCalda" errorFor="appDatacertificato.indFabbisogno.domEnergAcqua" labelId="tfFabbisognoAcquaCaldaLbl"
	  >


<!-- widget tfFabbisognoAcquaCalda -->
<s:textfield 
	
	
	name="appDatacertificato.indFabbisogno.domEnergAcqua" id="widg_tfFabbisognoAcquaCalda"
maxlength="10"	disabled="isWidgetDisabled('cpCompilaz','tfFabbisognoAcquaCalda')"
	size="15" cssClass="numbers"
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpCompilaz','tfEnAcquaCaldaRinnov')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpCompilaz.tfEnAcquaCaldaRinnov.label')}" labelFor="widg_tfEnAcquaCaldaRinnov" errorFor="appDatacertificato.indFabbisogno.energTermAcquaRinnov" labelId="tfEnAcquaCaldaRinnovLbl"
	  >


<!-- widget tfEnAcquaCaldaRinnov -->
<s:textfield 
	
	
	name="appDatacertificato.indFabbisogno.energTermAcquaRinnov" id="widg_tfEnAcquaCaldaRinnov"
maxlength="10"	disabled="isWidgetDisabled('cpCompilaz','tfEnAcquaCaldaRinnov')"
	size="15" cssClass="numbers"
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpCompilaz','tfIndPrestazEnergAcquaCalda')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpCompilaz.tfIndPrestazEnergAcquaCalda.label')}" labelFor="widg_tfIndPrestazEnergAcquaCalda" errorFor="appDatacertificato.indFabbisogno.indPrestEnergAcqua" labelId="tfIndPrestazEnergAcquaCaldaLbl"
	  >


<!-- widget tfIndPrestazEnergAcquaCalda -->
<s:textfield 
	
	
	name="appDatacertificato.indFabbisogno.indPrestEnergAcqua" id="widg_tfIndPrestazEnergAcquaCalda"
maxlength="10"	disabled="isWidgetDisabled('cpCompilaz','tfIndPrestazEnergAcquaCalda')"
	size="15" cssClass="numbers"
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpCompilaz','tfFabbisognoCondiz')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpCompilaz.tfFabbisognoCondiz.label')}" labelFor="widg_tfFabbisognoCondiz" errorFor="appDatacertificato.indFabbisogno.fabbCondizionamento" labelId="tfFabbisognoCondizLbl"
	  >


<!-- widget tfFabbisognoCondiz -->
<s:textfield 
	
	
	name="appDatacertificato.indFabbisogno.fabbCondizionamento" id="widg_tfFabbisognoCondiz"
maxlength="10"	disabled="isWidgetDisabled('cpCompilaz','tfFabbisognoCondiz')"
	size="15" cssClass="numbers"
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpCompilaz','tfIndPrestazEnergIlluminaz')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpCompilaz.tfIndPrestazEnergIlluminaz.label')}" labelFor="widg_tfIndPrestazEnergIlluminaz" errorFor="appDatacertificato.indFabbisogno.indPrestEnergIlluminaz" labelId="tfIndPrestazEnergIlluminazLbl"
	  >


<!-- widget tfIndPrestazEnergIlluminaz -->
<s:textfield 
	
	
	name="appDatacertificato.indFabbisogno.indPrestEnergIlluminaz" id="widg_tfIndPrestazEnergIlluminaz"
maxlength="10"	disabled="isWidgetDisabled('cpCompilaz','tfIndPrestazEnergIlluminaz')"
	size="15" cssClass="numbers"
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpCompilaz','txtNote1Fabbisogno')" >

	
<customtag:widgetsPanelColumn  colSpan="2"  >


<!-- widget txtNote1Fabbisogno -->
<s:text name="cpCompilaz.txtNote1Fabbisogno.statictext.label" />

	
</customtag:widgetsPanelColumn>

</s:if>

	



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_pDtFabbisogno --></div>

			
	
	<div id="p_pDtFabbisognoFun" class="commandPanelBlock"><!-- startFragment:p_pDtFabbisognoFun -->
	
	
<div class="commandPanel functional" id="pDtFabbisognoFun">

	
	
		

	
	
	
	

	
	
	
	

	
	
	
	<div class="button right">
		
<s:if test="isWidgetVisible('cpCompilaz','bDtFabbisognoCalcola')" >

	



<!-- widget bDtFabbisognoCalcola -->
	<csiuicore:ajaxify id="p_pWizCompilazLiv1" 
		widgetType="button"
		 
		requestUri="/siceeweb/base/compilazattestati/cpCompilaz!handleBDtFabbisognoCalcola_CLICKED.do" 
		
		pageId="cpCompilaz" 
		formName="cpCompilaz"
		javascriptDetection="false">
<s:submit name="widg_bDtFabbisognoCalcola" id="widg_bDtFabbisognoCalcola" method="handleBDtFabbisognoCalcola_CLICKED"
	key="cpCompilaz.bDtFabbisognoCalcola.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpCompilaz','bDtFabbisognoCalcola')" />

	</csiuicore:ajaxify>

	


</s:if>

	


	</div>
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_pDtFabbisognoFun --></div>

			
	
	<div id="p_pDtFabbisognoNav" class="commandPanelBlock"><!-- startFragment:p_pDtFabbisognoNav -->
	
	
<div class="commandPanel navigation" id="pDtFabbisognoNav">

	
	
		

	
	
	
	<div class="button left">
		
<s:if test="isWidgetVisible('cpCompilaz','bDtFabbisognoIndietro')" >

	



<!-- widget bDtFabbisognoIndietro -->
	<csiuicore:ajaxify id="p_pWizCompilazLiv1" 
		widgetType="button"
		 
		requestUri="/siceeweb/base/compilazattestati/cpCompilaz!handleBDtFabbisognoIndietro_CLICKED.do" 
		
		pageId="cpCompilaz" 
		formName="cpCompilaz"
		javascriptDetection="false">
<s:submit name="widg_bDtFabbisognoIndietro" id="widg_bDtFabbisognoIndietro" method="handleBDtFabbisognoIndietro_CLICKED"
	key="cpCompilaz.bDtFabbisognoIndietro.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpCompilaz','bDtFabbisognoIndietro')" />

	</csiuicore:ajaxify>

	


</s:if>

	


	</div>
	
	

	
	
	
	

	
	
	
	<div class="button right">
		
<s:if test="isWidgetVisible('cpCompilaz','bDtFabbisognoAvanti')" >

	



<!-- widget bDtFabbisognoAvanti -->
	<csiuicore:ajaxify id="p_pWizCompilazLiv1" 
		widgetType="button"
		 
		requestUri="/siceeweb/base/compilazattestati/cpCompilaz!handleBDtFabbisognoAvanti_CLICKED.do" 
		
		pageId="cpCompilaz" 
		formName="cpCompilaz"
		javascriptDetection="false">
<s:submit name="widg_bDtFabbisognoAvanti" id="widg_bDtFabbisognoAvanti" method="handleBDtFabbisognoAvanti_CLICKED"
	key="cpCompilaz.bDtFabbisognoAvanti.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpCompilaz','bDtFabbisognoAvanti')" />

	</csiuicore:ajaxify>

	


</s:if>

	


	</div>
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_pDtFabbisognoNav --></div>

	

		
	
</div>

	<!-- endFragment:p_pDatiFabbisogno --></div>
