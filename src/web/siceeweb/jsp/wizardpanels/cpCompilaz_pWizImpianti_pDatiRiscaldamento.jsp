<%@taglib uri="/struts-tags" prefix="s" %>
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="/customtag" prefix="customtag" %>
<%@taglib uri="/csiuicore" prefix="csiuicore" %>

	
	<div id="p_pDatiRiscaldamento" class="formPanelBlock"><!-- startFragment:p_pDatiRiscaldamento -->
		
	
<div class="formPanel" id="pDatiRiscaldamento">


	
	

	
	
			
	
	<div id="p_pErrDtRiscaldamento" class="stdMessagePanelBlock"><!-- startFragment:p_pErrDtRiscaldamento -->
	
	
<div class="stdMessagePanel" id="pErrDtRiscaldamento">
	<customtag:stdMessagePanel id="pErrDtRiscaldamento" errorMessage="true" errorDetails="false" actionMessage="true" />
</div>

	<!-- endFragment:p_pErrDtRiscaldamento --></div>

			
	
	<div id="p_pDtRiscaldamento" class="widgetsPanelBlock"><!-- startFragment:p_pDtRiscaldamento -->
	
	

<div class="widgetsPanel" id="pDtRiscaldamento">
	
	<customtag:widgetsPanel id="pDtRiscaldamentoTbl" columns="2" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('cpCompilaz','txtObblDtRiscaldamento')" >

	
<customtag:widgetsPanelColumn  colSpan="2"  >


<!-- widget txtObblDtRiscaldamento -->
<s:text name="cpCompilaz.txtObblDtRiscaldamento.statictext.label" />

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpCompilaz','rbsImpBollinoRiscald')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpCompilaz.rbsImpBollinoRiscald.label')}" labelFor="widg_rbsImpBollinoRiscald" errorFor="appDatacertificato.impianti.riscaldamento.flgBollino" labelId="rbsImpBollinoRiscaldLbl"
	  >


<!-- widget rbsImpBollinoRiscald -->

	
<div id="appDatacertificato.impianti.riscaldamento.flgBollino" class="radiobuttons ">







<s:radio
	
	
	id="widg_rbImpBollinoriscaldSi" name="appDatacertificato.impianti.riscaldamento.flgBollino"
	list="#{'S':'Si'}"
	disabled="isWidgetDisabled('cpCompilaz','rbsImpBollinoRiscald')"
	cssClass="radio"
	
	/> <label  for="widg_rbImpBollinoriscaldSiS"><s:text name="cpCompilaz.rbsImpBollinoRiscald.rbImpBollinoriscaldSi.label" /></label>








<s:radio
	
	
	id="widg_rbImpBollinoriscaldNo" name="appDatacertificato.impianti.riscaldamento.flgBollino"
	list="#{'N':'No'}"
	disabled="isWidgetDisabled('cpCompilaz','rbsImpBollinoRiscald')"
	cssClass="radio"
	
	/> <label  for="widg_rbImpBollinoriscaldNoN"><s:text name="cpCompilaz.rbsImpBollinoRiscald.rbImpBollinoriscaldNo.label" /></label>





	
</div>



	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpCompilaz','tfNumBollinoImpRisc')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpCompilaz.tfNumBollinoImpRisc.label')}" labelFor="widg_tfNumBollinoImpRisc" errorFor="appDatacertificato.impianti.riscaldamento.numBollino" labelId="tfNumBollinoImpRiscLbl"
	  >


<!-- widget tfNumBollinoImpRisc -->
<s:textfield 
	
	
	name="appDatacertificato.impianti.riscaldamento.numBollino" id="widg_tfNumBollinoImpRisc"
maxlength="20"	disabled="isWidgetDisabled('cpCompilaz','tfNumBollinoImpRisc')"
	size="15" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpCompilaz','tfCodImpRiscald')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpCompilaz.tfCodImpRiscald.label')}" labelFor="widg_tfCodImpRiscald" errorFor="appDatacertificato.impianti.riscaldamento.codImpianto" labelId="tfCodImpRiscaldLbl"
	  >


<!-- widget tfCodImpRiscald -->
<s:textfield 
	
	
	name="appDatacertificato.impianti.riscaldamento.codImpianto" id="widg_tfCodImpRiscald"
maxlength="50"	disabled="isWidgetDisabled('cpCompilaz','tfCodImpRiscald')"
	size="15" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpCompilaz','tfAnnoInstGenerRiscald')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpCompilaz.tfAnnoInstGenerRiscald.label')}" labelFor="widg_tfAnnoInstGenerRiscald" errorFor="appDatacertificato.impianti.riscaldamento.annoInstallGeneratore" labelId="tfAnnoInstGenerRiscaldLbl"
	  >


<!-- widget tfAnnoInstGenerRiscald -->
<s:textfield 
	
	
	name="appDatacertificato.impianti.riscaldamento.annoInstallGeneratore" id="widg_tfAnnoInstGenerRiscald"
maxlength="4"	disabled="isWidgetDisabled('cpCompilaz','tfAnnoInstGenerRiscald')"
	size="15" cssClass="numbers"
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpCompilaz','tfPotenzaNomRiscald')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpCompilaz.tfPotenzaNomRiscald.label')}" labelFor="widg_tfPotenzaNomRiscald" errorFor="appDatacertificato.impianti.riscaldamento.potNomCompl" labelId="tfPotenzaNomRiscaldLbl"
	  >


<!-- widget tfPotenzaNomRiscald -->
<s:textfield 
	
	
	name="appDatacertificato.impianti.riscaldamento.potNomCompl" id="widg_tfPotenzaNomRiscald"
maxlength="10"	disabled="isWidgetDisabled('cpCompilaz','tfPotenzaNomRiscald')"
	size="15" cssClass="numbers"
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpCompilaz','tfLimNormRegImpTerm')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpCompilaz.tfLimNormRegImpTerm.label')}" labelFor="widg_tfLimNormRegImpTerm" errorFor="appDatacertificato.impianti.riscaldamento.limNormRegImpTerm" labelId="tfLimNormRegImpTermLbl"
	  >


<!-- widget tfLimNormRegImpTerm -->
<s:textfield 
	
	
	name="appDatacertificato.impianti.riscaldamento.limNormRegImpTerm" id="widg_tfLimNormRegImpTerm"
maxlength="10"	disabled="isWidgetDisabled('cpCompilaz','tfLimNormRegImpTerm')"
	size="15" cssClass="numbers"
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpCompilaz','txtRendGenerazRiscald')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpCompilaz.txtRendGenerazRiscald.label')}" labelFor="widg_txtRendGenerazRiscald" errorFor="appDatacertificato.classeEnerg.locReale.rendGeneraz" labelId="txtRendGenerazRiscaldLbl"   tdStyleClass="numbers">


<!-- widget txtRendGenerazRiscald -->
<s:property value="appDatacertificato.classeEnerg.locReale.rendGeneraz" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpCompilaz','cbClasseEfficEnergRiscald')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpCompilaz.cbClasseEfficEnergRiscald.label')}" labelFor="widg_cbClasseEfficEnergRiscald" errorFor="appDatacertificato.impianti.riscaldamento.classeEfficienzaEnerg" labelId="cbClasseEfficEnergRiscaldLbl"
	  >


<!-- widget cbClasseEfficEnergRiscald -->
<s:select name="appDatacertificato.impianti.riscaldamento.classeEfficienzaEnerg" id="widg_cbClasseEfficEnergRiscald"
	 
	
		title=""
			
	  headerKey="" headerValue="" 
	  list="appDataclassiEfficienzaEnergetiche"
	  disabled="isWidgetDisabled('cpCompilaz','cbClasseEfficEnergRiscald')"
	  listKey="cod"
	  listValue="descr"
	  
	  />


	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpCompilaz','cbTipoCombustibRiscald')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpCompilaz.cbTipoCombustibRiscald.label')}" labelFor="widg_cbTipoCombustibRiscald" errorFor="appDatacertificato.impianti.riscaldamento.combustibileFossile" labelId="cbTipoCombustibRiscaldLbl"
	  >


<!-- widget cbTipoCombustibRiscald -->
<s:select name="appDatacertificato.impianti.riscaldamento.combustibileFossile" id="widg_cbTipoCombustibRiscald"
	 
	
		title=""
			
	  headerKey="" headerValue="" 
	  list="appDatatipiCombustibileRiscaldamento"
	  disabled="isWidgetDisabled('cpCompilaz','cbTipoCombustibRiscald')"
	  listKey="cod"
	  listValue="descr"
	  
	  />


	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpCompilaz','tfUIServite')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpCompilaz.tfUIServite.label')}" labelFor="widg_tfUIServite" errorFor="appDatacertificato.impianti.uiServite" labelId="tfUIServiteLbl"
	  >


<!-- widget tfUIServite -->
<s:textfield 
	
	
	name="appDatacertificato.impianti.uiServite" id="widg_tfUIServite"
maxlength="20"	disabled="isWidgetDisabled('cpCompilaz','tfUIServite')"
	size="15" cssClass="numbers"
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpCompilaz','rbsRipartizione')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpCompilaz.rbsRipartizione.label')}" labelFor="widg_rbsRipartizione" errorFor="appDatacertificato.impianti.flgRipartizione" labelId="rbsRipartizioneLbl"
	  >


<!-- widget rbsRipartizione -->

	
<div id="appDatacertificato.impianti.flgRipartizione" class="radiobuttons ">







<s:radio
	
	
	id="widg_rbRipartizioneSi" name="appDatacertificato.impianti.flgRipartizione"
	list="#{'S':'Si'}"
	disabled="isWidgetDisabled('cpCompilaz','rbsRipartizione')"
	cssClass="radio"
	
	/> <label  for="widg_rbRipartizioneSiS"><s:text name="cpCompilaz.rbsRipartizione.rbRipartizioneSi.label" /></label>








<s:radio
	
	
	id="widg_rbRipartizioneNo" name="appDatacertificato.impianti.flgRipartizione"
	list="#{'N':'No'}"
	disabled="isWidgetDisabled('cpCompilaz','rbsRipartizione')"
	cssClass="radio"
	
	/> <label  for="widg_rbRipartizioneNoN"><s:text name="cpCompilaz.rbsRipartizione.rbRipartizioneNo.label" /></label>





	
</div>



	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpCompilaz','tipoImpianto')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpCompilaz.tipoImpianto.label')}" labelFor="widg_tipoImpianto" errorFor="appDatacertificato.datiTecnici.tipoImpiantoDesc" labelId="tipoImpiantoLbl"   >


<!-- widget tipoImpianto -->
<s:property value="appDatacertificato.datiTecnici.tipoImpiantoDesc" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpCompilaz','tfTipoErogaz')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpCompilaz.tfTipoErogaz.label')}" labelFor="widg_tfTipoErogaz" errorFor="appDatacertificato.impianti.tipoTermErogaz" labelId="tfTipoErogazLbl"
	  >


<!-- widget tfTipoErogaz -->
<s:textfield 
	
	
	name="appDatacertificato.impianti.tipoTermErogaz" id="widg_tfTipoErogaz"
maxlength="100"	disabled="isWidgetDisabled('cpCompilaz','tfTipoErogaz')"
	size="15" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpCompilaz','tfTipoDistribuz')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpCompilaz.tfTipoDistribuz.label')}" labelFor="widg_tfTipoDistribuz" errorFor="appDatacertificato.impianti.tipoDistrib" labelId="tfTipoDistribuzLbl"
	  >


<!-- widget tfTipoDistribuz -->
<s:textfield 
	
	
	name="appDatacertificato.impianti.tipoDistrib" id="widg_tfTipoDistribuz"
maxlength="100"	disabled="isWidgetDisabled('cpCompilaz','tfTipoDistribuz')"
	size="15" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpCompilaz','tfTipoRegolaz')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpCompilaz.tfTipoRegolaz.label')}" labelFor="widg_tfTipoRegolaz" errorFor="appDatacertificato.impianti.tipoRegolaz" labelId="tfTipoRegolazLbl"
	  >


<!-- widget tfTipoRegolaz -->
<s:textfield 
	
	
	name="appDatacertificato.impianti.tipoRegolaz" id="widg_tfTipoRegolaz"
maxlength="100"	disabled="isWidgetDisabled('cpCompilaz','tfTipoRegolaz')"
	size="15" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpCompilaz','txtNote1Riscaldamento')" >

	
<customtag:widgetsPanelColumn  colSpan="2"  >


<!-- widget txtNote1Riscaldamento -->
<s:text name="cpCompilaz.txtNote1Riscaldamento.statictext.label" />

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpCompilaz','txtNote5Riscaldamento')" >

	
<customtag:widgetsPanelColumn  colSpan="2"  >


<!-- widget txtNote5Riscaldamento -->
<s:text name="cpCompilaz.txtNote5Riscaldamento.statictext.label" />

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpCompilaz','txtNote2Riscaldamento')" >

	
<customtag:widgetsPanelColumn  colSpan="2"  >


<!-- widget txtNote2Riscaldamento -->
<s:text name="cpCompilaz.txtNote2Riscaldamento.statictext.label" />

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpCompilaz','txtNote3Riscaldamento')" >

	
<customtag:widgetsPanelColumn  colSpan="2"  >


<!-- widget txtNote3Riscaldamento -->
<s:text name="cpCompilaz.txtNote3Riscaldamento.statictext.label" />

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpCompilaz','txtNote4Riscaldamento')" >

	
<customtag:widgetsPanelColumn  colSpan="2"  >


<!-- widget txtNote4Riscaldamento -->
<s:text name="cpCompilaz.txtNote4Riscaldamento.statictext.label" />

	
</customtag:widgetsPanelColumn>

</s:if>

	



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_pDtRiscaldamento --></div>

			
	
	<div id="p_pDtRiscaldamentoFun" class="commandPanelBlock"><!-- startFragment:p_pDtRiscaldamentoFun -->
	
	
<div class="commandPanel functional" id="pDtRiscaldamentoFun">

	
	
		

	
	
	
	

	
	
	
	

	
	
	
	<div class="button right">
		
<s:if test="isWidgetVisible('cpCompilaz','bDtLimNormRegImpTermCalcola')" >

	



<!-- widget bDtLimNormRegImpTermCalcola -->
	<csiuicore:ajaxify id="p_pWizCompilazLiv1" 
		widgetType="button"
		 
		requestUri="/siceeweb/base/compilazattestati/cpCompilaz!handleBDtLimNormRegImpTermCalcola_CLICKED.do" 
		
		pageId="cpCompilaz" 
		formName="cpCompilaz"
		javascriptDetection="false">
<s:submit name="widg_bDtLimNormRegImpTermCalcola" id="widg_bDtLimNormRegImpTermCalcola" method="handleBDtLimNormRegImpTermCalcola_CLICKED"
	key="cpCompilaz.bDtLimNormRegImpTermCalcola.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpCompilaz','bDtLimNormRegImpTermCalcola')" />

	</csiuicore:ajaxify>

	


</s:if>

	


	</div>
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_pDtRiscaldamentoFun --></div>

			
	
	<div id="p_pDtRiscaldamentoNav" class="commandPanelBlock"><!-- startFragment:p_pDtRiscaldamentoNav -->
	
	
<div class="commandPanel navigation" id="pDtRiscaldamentoNav">

	
	
		

	
	
	
	<div class="button left">
		
<s:if test="isWidgetVisible('cpCompilaz','bDtriscaldamentoIndietro')" >

	



<!-- widget bDtriscaldamentoIndietro -->
	<csiuicore:ajaxify id="p_pWizCompilazLiv1" 
		widgetType="button"
		 
		requestUri="/siceeweb/base/compilazattestati/cpCompilaz!handleBDtriscaldamentoIndietro_CLICKED.do" 
		
		pageId="cpCompilaz" 
		formName="cpCompilaz"
		javascriptDetection="false">
<s:submit name="widg_bDtriscaldamentoIndietro" id="widg_bDtriscaldamentoIndietro" method="handleBDtriscaldamentoIndietro_CLICKED"
	key="cpCompilaz.bDtriscaldamentoIndietro.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpCompilaz','bDtriscaldamentoIndietro')" />

	</csiuicore:ajaxify>

	


</s:if>

	


	</div>
	
	

	
	
	
	

	
	
	
	<div class="button right">
		
<s:if test="isWidgetVisible('cpCompilaz','bDtRiscaldamentoAvanti')" >

	



<!-- widget bDtRiscaldamentoAvanti -->
	<csiuicore:ajaxify id="p_pWizCompilazLiv1" 
		widgetType="button"
		 
		requestUri="/siceeweb/base/compilazattestati/cpCompilaz!handleBDtRiscaldamentoAvanti_CLICKED.do" 
		
		pageId="cpCompilaz" 
		formName="cpCompilaz"
		javascriptDetection="false">
<s:submit name="widg_bDtRiscaldamentoAvanti" id="widg_bDtRiscaldamentoAvanti" method="handleBDtRiscaldamentoAvanti_CLICKED"
	key="cpCompilaz.bDtRiscaldamentoAvanti.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpCompilaz','bDtRiscaldamentoAvanti')" />

	</csiuicore:ajaxify>

	


</s:if>

	


	</div>
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_pDtRiscaldamentoNav --></div>

	

		
	
</div>

	<!-- endFragment:p_pDatiRiscaldamento --></div>
