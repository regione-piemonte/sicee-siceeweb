<%@taglib uri="/struts-tags" prefix="s" %>
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="/customtag" prefix="customtag" %>
<%@taglib uri="/csiuicore" prefix="csiuicore" %>

<s:include value="fragments/header.jsp" ></s:include>



<!-- appmoduleId:base/gestattestati -->
<!-- pageId:cpRicercaAceInviati -->

<s:form id="cpRicercaAceInviati" action="cpRicercaAceInviati" namespace="/base/gestattestati" method="post">


<%-- NO SCRIPT --%>
		
	
	
		
<!-- ####################### PANNELLO CONTENUTI ###################### -->
<div id="contentPanel">

	<!-- ================ UDLRC Layout UP PANEL ================ -->
	<div id="northPanel">
		<div class="wrapper">
		
	
	<div id="p_pUp" class="formPanelBlock"><!-- startFragment:p_pUp -->

	
	

	
	
			
	
	
<s:include value="/jsp/userpanels/cpRicercaAceInviati_pUserInfoCustom.jsp"></s:include>

	



	

	<!-- endFragment:p_pUp --></div>

		</div>
	</div>
	<!-- ================ FINE UDLRC Layout UP PANEL ================ -->


	<!-- ================ UDLRC Layout WEST-CENTER-EAST WRAPPER ================ -->
	<div id="westCenterWrapper" class="floatWrapper">
		<!-- ***** UDLRC Layout LEFT PANEL ***** -->
		<div id="westPanel">
			<div class="wrapper">
			
	
	<div id="p_pLeft" class="formPanelBlock"><!-- startFragment:p_pLeft -->

	
	

	
	
			
	
	<div id="p_pMenu" class="menuPanelBlock"><!-- startFragment:p_pMenu -->
	
	
<div class="menuPanel vertical" id="pMenu">

	
		
			
<s:if test="isWidgetVisible('cpRicercaAceInviati','menu')" >

	


	<s:include value="fragments/menu.jsp"></s:include>

	

</s:if>

	


		
	
	
</div>

	<!-- endFragment:p_pMenu --></div>

	

	<!-- endFragment:p_pLeft --></div>

			</div>
		</div>
		<!-- ***** FINE UDLRC Layout LEFT PANEL ***** -->


		<!-- ***** UDLRC Layout CENTER PANEL ***** -->
		<div id="centerPanel">
			
			<a id="main_content" name="main_content"></a>
			<div class="wrapper">
				<!-- titolo pannello PRIMO livello -->
				<h3><s:text name="cpRicercaAceInviati.pMain.label" /></h3>

					
	
	<div id="p_pCenter" class="formPanelBlock"><!-- startFragment:p_pCenter -->

	
	

	
	
			
	
	<div id="p_pErrRicercaAce" class="stdMessagePanelBlock"><!-- startFragment:p_pErrRicercaAce -->
	
	
<div class="stdMessagePanel" id="pErrRicercaAce">
	<customtag:stdMessagePanel id="pErrRicercaAce" errorMessage="true" errorDetails="false" actionMessage="true" />
</div>

	<!-- endFragment:p_pErrRicercaAce --></div>

			
	
	<div id="p_pRicercaAceInviatiByCodice" class="widgetsPanelBlock"><!-- startFragment:p_pRicercaAceInviatiByCodice -->
	
	
<h4 class="wpLabel">Ricerca per codice </h4>
<div class="widgetsPanel" id="pRicercaAceInviatiByCodice">
	
	<customtag:widgetsPanel id="pRicercaAceInviatiByCodiceTbl" columns="6" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('cpRicercaAceInviati','tfAnnoCertificato')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRicercaAceInviati.tfAnnoCertificato.label')}" labelFor="widg_tfAnnoCertificato" errorFor="appDatafiltroAce.annoCertificato" labelId="tfAnnoCertificatoLbl"
	position="first"  >


<!-- widget tfAnnoCertificato -->
<s:textfield 
	
	
	name="appDatafiltroAce.annoCertificato" id="widg_tfAnnoCertificato"
maxlength="4"	disabled="isWidgetDisabled('cpRicercaAceInviati','tfAnnoCertificato')"
	size="15" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpRicercaAceInviati','tfCertificatore')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRicercaAceInviati.tfCertificatore.label')}" labelFor="widg_tfCertificatore" errorFor="appDatafiltroAce.certificatore" labelId="tfCertificatoreLbl"
	  >


<!-- widget tfCertificatore -->
<s:textfield 
	
	
	name="appDatafiltroAce.certificatore" id="widg_tfCertificatore"
maxlength="6"	disabled="isWidgetDisabled('cpRicercaAceInviati','tfCertificatore')"
	size="15" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" />
</s:else>


	
<s:if test="isWidgetVisible('cpRicercaAceInviati','tfProgCertificato')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRicercaAceInviati.tfProgCertificato.label')}" labelFor="widg_tfProgCertificato" errorFor="appDatafiltroAce.progCertificato" labelId="tfProgCertificatoLbl"
	position="last"  >


<!-- widget tfProgCertificato -->
<s:textfield 
	
	
	name="appDatafiltroAce.progCertificato" id="widg_tfProgCertificato"
maxlength="4"	disabled="isWidgetDisabled('cpRicercaAceInviati','tfProgCertificato')"
	size="15" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_pRicercaAceInviatiByCodice --></div>

			
	
	<div id="p_pRicercaAceInviatiByCodiceNote" class="widgetsPanelBlock"><!-- startFragment:p_pRicercaAceInviatiByCodiceNote -->
	
	

<div class="widgetsPanel" id="pRicercaAceInviatiByCodiceNote">
	
	<customtag:widgetsPanel id="pRicercaAceInviatiByCodiceNoteTbl" columns="2" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('cpRicercaAceInviati','ptNotaA')" >

	
<customtag:widgetsPanelColumn  colSpan="2"  >


<!-- widget ptNotaA -->
<s:text name="cpRicercaAceInviati.ptNotaA.statictext.label" />

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpRicercaAceInviati','ptNotaB')" >

	
<customtag:widgetsPanelColumn  colSpan="2"  >


<!-- widget ptNotaB -->
<s:text name="cpRicercaAceInviati.ptNotaB.statictext.label" />

	
</customtag:widgetsPanelColumn>

</s:if>

	



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_pRicercaAceInviatiByCodiceNote --></div>

			
	
	<div id="p_pRicercaAceInviatiByCodiceNav" class="commandPanelBlock"><!-- startFragment:p_pRicercaAceInviatiByCodiceNav -->
	
	
<div class="commandPanel navigation" id="pRicercaAceInviatiByCodiceNav">

	
	
		

	
	
	
	

	
	
	
	

	
	
	
	<div class="button right">
		
<s:if test="isWidgetVisible('cpRicercaAceInviati','btnAvantiByCodice')" >

	



<!-- widget btnAvantiByCodice -->
	<csiuicore:ajaxify id="p_pCenter" 
		widgetType="button"
		 
		requestUri="/siceeweb/base/gestattestati/cpRicercaAceInviati!handleBtnAvantiByCodice_CLICKED.do" 
		
		pageId="cpRicercaAceInviati" 
		formName="cpRicercaAceInviati"
		javascriptDetection="false">
<s:submit name="widg_btnAvantiByCodice" id="widg_btnAvantiByCodice" method="handleBtnAvantiByCodice_CLICKED"
	key="cpRicercaAceInviati.btnAvantiByCodice.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpRicercaAceInviati','btnAvantiByCodice')" />

	</csiuicore:ajaxify>

	


</s:if>

	


	</div>
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_pRicercaAceInviatiByCodiceNav --></div>

			
	
	<div id="p_pRicercaAceInviati" class="widgetsPanelBlock"><!-- startFragment:p_pRicercaAceInviati -->
	
	
<h4 class="wpLabel">Ricerca per parametri </h4>
<div class="widgetsPanel" id="pRicercaAceInviati">
	
	<customtag:widgetsPanel id="pRicercaAceInviatiTbl" columns="8" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('cpRicercaAceInviati','cbProvRicercaAce')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRicercaAceInviati.cbProvRicercaAce.label')}" labelFor="widg_cbProvRicercaAce" errorFor="appDatafiltroAce.codProv" labelId="cbProvRicercaAceLbl"
	position="first" colSpan="3" >


<!-- widget cbProvRicercaAce -->

<s:url id="widg_cbProvRicercaAceurlComboBoxValueChange"
   action="/siceeweb/cpRicercaAceInviati!handleCbProvRicercaAce_VALUE_CHANGED" namespace="/base/gestattestati"  
   includeParams="all" portletUrlType="action" 
/>
<s:select name="appDatafiltroAce.codProv" id="widg_cbProvRicercaAce"
	 
	

		title=" - Attenzione. Dopo aver selezionato un valore, la pagina verra' aggiornata automaticamente"
			
	  headerKey="" headerValue="" 
	  list="appDataprovince"
	  disabled="isWidgetDisabled('cpRicercaAceInviati','cbProvRicercaAce')"
	  listKey="cod"
	  listValue="nome"
	  onclick="onCBClick(this,'confermacbProvRicercaAce','conferma','%{widg_cbProvRicercaAceurlComboBoxValueChange}')" onfocus="inFocus(this)" onblur="lostFocus(this,'confermacbProvRicercaAce','conferma','%{widg_cbProvRicercaAceurlComboBoxValueChange}')" 
	  />


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="4" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpRicercaAceInviati','cbComRicercaAce')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRicercaAceInviati.cbComRicercaAce.label')}" labelFor="widg_cbComRicercaAce" errorFor="appDatafiltroAce.codComune" labelId="cbComRicercaAceLbl"
	position="first" colSpan="3" >


<!-- widget cbComRicercaAce -->

<s:url id="widg_cbComRicercaAceurlComboBoxValueChange"
   action="/siceeweb/cpRicercaAceInviati!handleCbComRicercaAce_VALUE_CHANGED" namespace="/base/gestattestati"  
   includeParams="all" portletUrlType="action" 
/>
<s:select name="appDatafiltroAce.codComune" id="widg_cbComRicercaAce"
	 
	

		title=" - Attenzione. Dopo aver selezionato un valore, la pagina verra' aggiornata automaticamente"
			
	  headerKey="" headerValue="" 
	  list="appDatacomuni"
	  disabled="isWidgetDisabled('cpRicercaAceInviati','cbComRicercaAce')"
	  listKey="cod"
	  listValue="nome"
	  onclick="onCBClick(this,'confermacbComRicercaAce','conferma','%{widg_cbComRicercaAceurlComboBoxValueChange}')" onfocus="inFocus(this)" onblur="lostFocus(this,'confermacbComRicercaAce','conferma','%{widg_cbComRicercaAceurlComboBoxValueChange}')" 
	  />


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="4" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpRicercaAceInviati','tfComRicercaAce')" >

	
<customtag:widgetsPanelColumn 
	position="last" colSpan="4" >


<!-- widget tfComRicercaAce -->
<s:textfield 
	
	
	name="appDatafiltroAce.descComune" id="widg_tfComRicercaAce"
maxlength="50"	disabled="isWidgetDisabled('cpRicercaAceInviati','tfComRicercaAce')"
	size="50" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="4" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpRicercaAceInviati','tfIndirizzoRicercaAce')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRicercaAceInviati.tfIndirizzoRicercaAce.label')}" labelFor="widg_tfIndirizzoRicercaAce" errorFor="appDatafiltroAce.descIndirizzo" labelId="tfIndirizzoRicercaAceLbl"
	position="first" colSpan="3" >


<!-- widget tfIndirizzoRicercaAce -->
<s:textfield 
	
	
	name="appDatafiltroAce.descIndirizzo" id="widg_tfIndirizzoRicercaAce"
maxlength="160"	disabled="isWidgetDisabled('cpRicercaAceInviati','tfIndirizzoRicercaAce')"
	size="50" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="4" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpRicercaAceInviati','tfNCivRicercaAce')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRicercaAceInviati.tfNCivRicercaAce.label')}" labelFor="widg_tfNCivRicercaAce" errorFor="appDatafiltroAce.numCivico" labelId="tfNCivRicercaAceLbl"
	  >


<!-- widget tfNCivRicercaAce -->
<s:textfield 
	
	
	name="appDatafiltroAce.numCivico" id="widg_tfNCivRicercaAce"
maxlength="10"	disabled="isWidgetDisabled('cpRicercaAceInviati','tfNCivRicercaAce')"
	size="9" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" />
</s:else>


	
<s:if test="isWidgetVisible('cpRicercaAceInviati','tfSezCatasto')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRicercaAceInviati.tfSezCatasto.label')}" labelFor="widg_tfSezCatasto" errorFor="appDatafiltroAce.sezione" labelId="tfSezCatastoLbl"
	position="first"  >


<!-- widget tfSezCatasto -->
<s:textfield 
	
	
	name="appDatafiltroAce.sezione" id="widg_tfSezCatasto"
maxlength="5"	disabled="isWidgetDisabled('cpRicercaAceInviati','tfSezCatasto')"
	size="9" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpRicercaAceInviati','tfFoglioCatasto')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRicercaAceInviati.tfFoglioCatasto.label')}" labelFor="widg_tfFoglioCatasto" errorFor="appDatafiltroAce.foglio" labelId="tfFoglioCatastoLbl"
	  >


<!-- widget tfFoglioCatasto -->
<s:textfield 
	
	
	name="appDatafiltroAce.foglio" id="widg_tfFoglioCatasto"
maxlength="5"	disabled="isWidgetDisabled('cpRicercaAceInviati','tfFoglioCatasto')"
	size="9" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" />
</s:else>


	
<s:if test="isWidgetVisible('cpRicercaAceInviati','tfParticCatasto')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRicercaAceInviati.tfParticCatasto.label')}" labelFor="widg_tfParticCatasto" errorFor="appDatafiltroAce.particella" labelId="tfParticCatastoLbl"
	  >


<!-- widget tfParticCatasto -->
<s:textfield 
	
	
	name="appDatafiltroAce.particella" id="widg_tfParticCatasto"
maxlength="9"	disabled="isWidgetDisabled('cpRicercaAceInviati','tfParticCatasto')"
	size="9" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" />
</s:else>


	
<s:if test="isWidgetVisible('cpRicercaAceInviati','tfSubaltCatasto')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRicercaAceInviati.tfSubaltCatasto.label')}" labelFor="widg_tfSubaltCatasto" errorFor="appDatafiltroAce.subalterno" labelId="tfSubaltCatastoLbl"
	position="last"  >


<!-- widget tfSubaltCatasto -->
<s:textfield 
	
	
	name="appDatafiltroAce.subalterno" id="widg_tfSubaltCatasto"
maxlength="4"	disabled="isWidgetDisabled('cpRicercaAceInviati','tfSubaltCatasto')"
	size="9" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpRicercaAceInviati','rbStato')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRicercaAceInviati.rbStato.label')}" labelFor="widg_rbStato" errorFor="appDatafiltroAce.stato" labelId="rbStatoLbl"
	position="first" colSpan="3" >


<!-- widget rbStato -->

	
<div id="appDatafiltroAce.stato" class="radiobuttons ">







<s:radio
	
	
	id="widg_rbInviato" name="appDatafiltroAce.stato"
	list="#{'3':'inviato'}"
	disabled="isWidgetDisabled('cpRicercaAceInviati','rbStato')"
	cssClass="radio"
	
	/> <label  for="widg_rbInviato3"><s:text name="cpRicercaAceInviati.rbStato.rbInviato.label" /></label>








<s:radio
	
	
	id="widg_rbAnnullato" name="appDatafiltroAce.stato"
	list="#{'4':'annullato'}"
	disabled="isWidgetDisabled('cpRicercaAceInviati','rbStato')"
	cssClass="radio"
	
	/> <label  for="widg_rbAnnullato4"><s:text name="cpRicercaAceInviati.rbStato.rbAnnullato.label" /></label>








<s:radio
	
	
	id="widg_rbEntrambi" name="appDatafiltroAce.stato"
	list="#{'99':'entrambi'}"
	disabled="isWidgetDisabled('cpRicercaAceInviati','rbStato')"
	cssClass="radio"
	
	/> <label  for="widg_rbEntrambi99"><s:text name="cpRicercaAceInviati.rbStato.rbEntrambi.label" /></label>





	
</div>



	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="4" position="first"/>
</s:else>



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_pRicercaAceInviati --></div>

			
	
	<div id="p_pRicercaAceInviatiNav" class="commandPanelBlock"><!-- startFragment:p_pRicercaAceInviatiNav -->
	
	
<div class="commandPanel navigation" id="pRicercaAceInviatiNav">

	
	
		

	
	
	
	

	
	
	
	

	
	
	
	<div class="button right">
		
<s:if test="isWidgetVisible('cpRicercaAceInviati','btnAvanti')" >

	



<!-- widget btnAvanti -->
	<csiuicore:ajaxify id="p_pCenter" 
		widgetType="button"
		 
		requestUri="/siceeweb/base/gestattestati/cpRicercaAceInviati!handleBtnAvanti_CLICKED.do" 
		
		pageId="cpRicercaAceInviati" 
		formName="cpRicercaAceInviati"
		javascriptDetection="false">
<s:submit name="widg_btnAvanti" id="widg_btnAvanti" method="handleBtnAvanti_CLICKED"
	key="cpRicercaAceInviati.btnAvanti.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpRicercaAceInviati','btnAvanti')" />

	</csiuicore:ajaxify>

	


</s:if>

	


	</div>
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_pRicercaAceInviatiNav --></div>

	

	<!-- endFragment:p_pCenter --></div>

			</div>
		</div>
		<!-- ***** FINE UDLRC Layout CENTER PANEL ***** -->



	</div>
	<!-- ================ FINE UDLRC Layout WEST-CENTER-EAST WRAPPER ================ -->



</div>
<!-- #################### FINE PANNELLO CONTENUTI #################### -->




</s:form>


	<s:include value="fragments/footer.jsp" ></s:include>
