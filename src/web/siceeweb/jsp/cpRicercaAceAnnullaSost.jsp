<%@taglib uri="/struts-tags" prefix="s" %>
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="/customtag" prefix="customtag" %>
<%@taglib uri="/csiuicore" prefix="csiuicore" %><%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<fmt:setBundle basename="/it/csi/sicee/siceeweb/presentation/siceeweb/action/annullasostcert/CpRicercaAceAnnullaSostAction" />


<s:include value="fragments/header.jsp" ></s:include>



<!-- appmoduleId:base/annullaSostCert -->
<!-- pageId:cpRicercaAceAnnullaSost -->

<s:form id="cpRicercaAceAnnullaSost" action="cpRicercaAceAnnullaSost" namespace="/base/annullaSostCert" method="post">


<%-- NO SCRIPT --%>
		
	
	
		
<!-- ####################### PANNELLO CONTENUTI ###################### -->
<div id="contentPanel">

	<!-- ================ UDLRC Layout UP PANEL ================ -->
	<div id="northPanel">
		<div class="wrapper">
		
	
	<div id="p_pUp" class="formPanelBlock"><!-- startFragment:p_pUp -->

	
	

	
	
			
	
	
<s:include value="/jsp/userpanels/cpRicercaAceAnnullaSost_pUserInfoCustom.jsp"></s:include>

	



	

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

	
		
			
<s:if test="isWidgetVisible('cpRicercaAceAnnullaSost','menu')" >

	


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
				<h3><s:text name="cpRicercaAceAnnullaSost.pMain.label" /></h3>

					
	
	<div id="p_pCenter" class="formPanelBlock"><!-- startFragment:p_pCenter -->

	
	

	
	
			
	
	<div id="p_pErrRicercaAce" class="stdMessagePanelBlock"><!-- startFragment:p_pErrRicercaAce -->
	
	
<div class="stdMessagePanel" id="pErrRicercaAce">
	<customtag:stdMessagePanel id="pErrRicercaAce" errorMessage="true" errorDetails="false" actionMessage="true" />
</div>

	<!-- endFragment:p_pErrRicercaAce --></div>

			
	
	<div id="p_pTipoRicercaAceFun" class="commandPanelBlock"><!-- startFragment:p_pTipoRicercaAceFun -->
	
	
<div class="commandPanel functional" id="pTipoRicercaAceFun">

	
	
		

	
	
	
	<div class="button left">
		
<s:if test="isWidgetVisible('cpRicercaAceAnnullaSost','btnScegliAceOld')" >

	



<!-- widget btnScegliAceOld -->
	<csiuicore:ajaxify id="p_pCenter" 
		widgetType="button"
		 
		requestUri="/siceeweb/base/annullaSostCert/cpRicercaAceAnnullaSost!handleBtnScegliAceOld_CLICKED.do" 
		
		pageId="cpRicercaAceAnnullaSost" 
		formName="cpRicercaAceAnnullaSost"
		javascriptDetection="false">
<s:submit name="widg_btnScegliAceOld" id="widg_btnScegliAceOld" method="handleBtnScegliAceOld_CLICKED"
	key="cpRicercaAceAnnullaSost.btnScegliAceOld.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpRicercaAceAnnullaSost','btnScegliAceOld')" />

	</csiuicore:ajaxify>

	


</s:if>

	


	</div>
	
	

	
	
	
	

	
	
	
	<div class="button right">
		
<s:if test="isWidgetVisible('cpRicercaAceAnnullaSost','btnScegliAceNew')" >

	



<!-- widget btnScegliAceNew -->
	<csiuicore:ajaxify id="p_pCenter" 
		widgetType="button"
		 
		requestUri="/siceeweb/base/annullaSostCert/cpRicercaAceAnnullaSost!handleBtnScegliAceNew_CLICKED.do" 
		
		pageId="cpRicercaAceAnnullaSost" 
		formName="cpRicercaAceAnnullaSost"
		javascriptDetection="false">
<s:submit name="widg_btnScegliAceNew" id="widg_btnScegliAceNew" method="handleBtnScegliAceNew_CLICKED"
	key="cpRicercaAceAnnullaSost.btnScegliAceNew.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpRicercaAceAnnullaSost','btnScegliAceNew')" />

	</csiuicore:ajaxify>

	


</s:if>

	


	</div>
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_pTipoRicercaAceFun --></div>

			
	
	<div id="p_pRicercaAceInviatiByCodice" class="widgetsPanelBlock"><!-- startFragment:p_pRicercaAceInviatiByCodice -->
	
	
<h4 class="wpLabel">Ricerca per codice </h4>
<div class="widgetsPanel" id="pRicercaAceInviatiByCodice">
	
	<customtag:widgetsPanel id="pRicercaAceInviatiByCodiceTbl" columns="6" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('cpRicercaAceAnnullaSost','tfAnnoCertificato')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRicercaAceAnnullaSost.tfAnnoCertificato.label')}" labelFor="widg_tfAnnoCertificato" errorFor="appDatafiltroAce.annoCertificato" labelId="tfAnnoCertificatoLbl"
	position="first"  >


<!-- widget tfAnnoCertificato -->
<s:textfield 
	
	
	name="appDatafiltroAce.annoCertificato" id="widg_tfAnnoCertificato"
maxlength="4"	disabled="isWidgetDisabled('cpRicercaAceAnnullaSost','tfAnnoCertificato')"
	size="15" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpRicercaAceAnnullaSost','tfCertificatore')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRicercaAceAnnullaSost.tfCertificatore.label')}" labelFor="widg_tfCertificatore" errorFor="appDatafiltroAce.certificatore" labelId="tfCertificatoreLbl"
	  >


<!-- widget tfCertificatore -->
<s:textfield 
	
	
	name="appDatafiltroAce.certificatore" id="widg_tfCertificatore"
maxlength="6"	disabled="isWidgetDisabled('cpRicercaAceAnnullaSost','tfCertificatore')"
	size="15" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" />
</s:else>


	
<s:if test="isWidgetVisible('cpRicercaAceAnnullaSost','tfProgCertificato')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRicercaAceAnnullaSost.tfProgCertificato.label')}" labelFor="widg_tfProgCertificato" errorFor="appDatafiltroAce.progCertificato" labelId="tfProgCertificatoLbl"
	position="last"  >


<!-- widget tfProgCertificato -->
<s:textfield 
	
	
	name="appDatafiltroAce.progCertificato" id="widg_tfProgCertificato"
maxlength="4"	disabled="isWidgetDisabled('cpRicercaAceAnnullaSost','tfProgCertificato')"
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

			
	
	<div id="p_pRicercaAceByCodiceNote" class="widgetsPanelBlock"><!-- startFragment:p_pRicercaAceByCodiceNote -->
	
	

<div class="widgetsPanel" id="pRicercaAceByCodiceNote">
	
	<customtag:widgetsPanel id="pRicercaAceByCodiceNoteTbl" columns="2" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('cpRicercaAceAnnullaSost','ptNotaA')" >

	
<customtag:widgetsPanelColumn  colSpan="2"  >


<!-- widget ptNotaA -->
<s:text name="cpRicercaAceAnnullaSost.ptNotaA.statictext.label" />

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpRicercaAceAnnullaSost','ptNotaB')" >

	
<customtag:widgetsPanelColumn  colSpan="2"  >


<!-- widget ptNotaB -->
<s:text name="cpRicercaAceAnnullaSost.ptNotaB.statictext.label" />

	
</customtag:widgetsPanelColumn>

</s:if>

	



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_pRicercaAceByCodiceNote --></div>

			
	
	<div id="p_pRicercaAceByCodiceNav" class="commandPanelBlock"><!-- startFragment:p_pRicercaAceByCodiceNav -->
	
	
<div class="commandPanel navigation" id="pRicercaAceByCodiceNav">

	
	
		

	
	
	
	

	
	
	
	

	
	
	
	<div class="button right">
		
<s:if test="isWidgetVisible('cpRicercaAceAnnullaSost','btnAvantiByCodice')" >

	



<!-- widget btnAvantiByCodice -->
	<csiuicore:ajaxify id="p_pCenter,p_pErrRicercaAce" 
		widgetType="button"
		 
		requestUri="/siceeweb/base/annullaSostCert/cpRicercaAceAnnullaSost!handleBtnAvantiByCodice_CLICKED.do" 
		
		pageId="cpRicercaAceAnnullaSost" 
		formName="cpRicercaAceAnnullaSost"
		javascriptDetection="false">
<s:submit name="widg_btnAvantiByCodice" id="widg_btnAvantiByCodice" method="handleBtnAvantiByCodice_CLICKED"
	key="cpRicercaAceAnnullaSost.btnAvantiByCodice.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpRicercaAceAnnullaSost','btnAvantiByCodice')" />

	</csiuicore:ajaxify>

	


</s:if>

	


	</div>
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_pRicercaAceByCodiceNav --></div>

			
	
	<div id="p_pRicercaAce" class="widgetsPanelBlock"><!-- startFragment:p_pRicercaAce -->
	
	
<h4 class="wpLabel">Ricerca per parametri  </h4>
<div class="widgetsPanel" id="pRicercaAce">
	
	<customtag:widgetsPanel id="pRicercaAceTbl" columns="8" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('cpRicercaAceAnnullaSost','cbProvRicercaAce')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRicercaAceAnnullaSost.cbProvRicercaAce.label')}" labelFor="widg_cbProvRicercaAce" errorFor="appDatafiltroAce.codProv" labelId="cbProvRicercaAceLbl"
	position="first" colSpan="3" >


<!-- widget cbProvRicercaAce -->

<s:url id="widg_cbProvRicercaAceurlComboBoxValueChange"
   action="/siceeweb/cpRicercaAceAnnullaSost!handleCbProvRicercaAce_VALUE_CHANGED" namespace="/base/annullaSostCert"  
   includeParams="all" portletUrlType="action" 
/>
<s:select name="appDatafiltroAce.codProv" id="widg_cbProvRicercaAce"
	 
	

		title=" - Attenzione. Dopo aver selezionato un valore, la pagina verra' aggiornata automaticamente"
			
	  headerKey="" headerValue="" 
	  list="appDataprovince"
	  disabled="isWidgetDisabled('cpRicercaAceAnnullaSost','cbProvRicercaAce')"
	  listKey="cod"
	  listValue="nome"
	  onclick="onCBClick(this,'confermacbProvRicercaAce','conferma','%{widg_cbProvRicercaAceurlComboBoxValueChange}')" onfocus="inFocus(this)" onblur="lostFocus(this,'confermacbProvRicercaAce','conferma','%{widg_cbProvRicercaAceurlComboBoxValueChange}')" 
	  />


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="4" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpRicercaAceAnnullaSost','cbComRicercaAce')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRicercaAceAnnullaSost.cbComRicercaAce.label')}" labelFor="widg_cbComRicercaAce" errorFor="appDatafiltroAce.codComune" labelId="cbComRicercaAceLbl"
	position="first" colSpan="3" >


<!-- widget cbComRicercaAce -->
<s:select name="appDatafiltroAce.codComune" id="widg_cbComRicercaAce"
	 
	
		title=""
			
	  headerKey="" headerValue="" 
	  list="appDatacomuni"
	  disabled="isWidgetDisabled('cpRicercaAceAnnullaSost','cbComRicercaAce')"
	  listKey="cod"
	  listValue="nome"
	  
	  />


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="4" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpRicercaAceAnnullaSost','tfComRicercaAce')" >

	
<customtag:widgetsPanelColumn 
	position="last" colSpan="4" >


<!-- widget tfComRicercaAce -->
<s:textfield 
	
	
	name="appDatafiltroAce.descComune" id="widg_tfComRicercaAce"
maxlength="50"	disabled="isWidgetDisabled('cpRicercaAceAnnullaSost','tfComRicercaAce')"
	size="50" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="4" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpRicercaAceAnnullaSost','tfIndirizzoRicercaAce')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRicercaAceAnnullaSost.tfIndirizzoRicercaAce.label')}" labelFor="widg_tfIndirizzoRicercaAce" errorFor="appDatafiltroAce.descIndirizzo" labelId="tfIndirizzoRicercaAceLbl"
	position="first" colSpan="3" >


<!-- widget tfIndirizzoRicercaAce -->
<s:textfield 
	
	
	name="appDatafiltroAce.descIndirizzo" id="widg_tfIndirizzoRicercaAce"
maxlength="160"	disabled="isWidgetDisabled('cpRicercaAceAnnullaSost','tfIndirizzoRicercaAce')"
	size="50" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="4" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpRicercaAceAnnullaSost','tfNCivRicercaAce')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRicercaAceAnnullaSost.tfNCivRicercaAce.label')}" labelFor="widg_tfNCivRicercaAce" errorFor="appDatafiltroAce.numCivico" labelId="tfNCivRicercaAceLbl"
	  >


<!-- widget tfNCivRicercaAce -->
<s:textfield 
	
	
	name="appDatafiltroAce.numCivico" id="widg_tfNCivRicercaAce"
maxlength="10"	disabled="isWidgetDisabled('cpRicercaAceAnnullaSost','tfNCivRicercaAce')"
	size="9" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" />
</s:else>


	
<s:if test="isWidgetVisible('cpRicercaAceAnnullaSost','tfSezCatasto')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRicercaAceAnnullaSost.tfSezCatasto.label')}" labelFor="widg_tfSezCatasto" errorFor="appDatafiltroAce.sezione" labelId="tfSezCatastoLbl"
	position="first"  >


<!-- widget tfSezCatasto -->
<s:textfield 
	
	
	name="appDatafiltroAce.sezione" id="widg_tfSezCatasto"
maxlength="5"	disabled="isWidgetDisabled('cpRicercaAceAnnullaSost','tfSezCatasto')"
	size="9" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpRicercaAceAnnullaSost','tfFoglioCatasto')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRicercaAceAnnullaSost.tfFoglioCatasto.label')}" labelFor="widg_tfFoglioCatasto" errorFor="appDatafiltroAce.foglio" labelId="tfFoglioCatastoLbl"
	  >


<!-- widget tfFoglioCatasto -->
<s:textfield 
	
	
	name="appDatafiltroAce.foglio" id="widg_tfFoglioCatasto"
maxlength="5"	disabled="isWidgetDisabled('cpRicercaAceAnnullaSost','tfFoglioCatasto')"
	size="9" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" />
</s:else>


	
<s:if test="isWidgetVisible('cpRicercaAceAnnullaSost','tfParticCatasto')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRicercaAceAnnullaSost.tfParticCatasto.label')}" labelFor="widg_tfParticCatasto" errorFor="appDatafiltroAce.particella" labelId="tfParticCatastoLbl"
	  >


<!-- widget tfParticCatasto -->
<s:textfield 
	
	
	name="appDatafiltroAce.particella" id="widg_tfParticCatasto"
maxlength="9"	disabled="isWidgetDisabled('cpRicercaAceAnnullaSost','tfParticCatasto')"
	size="9" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" />
</s:else>


	
<s:if test="isWidgetVisible('cpRicercaAceAnnullaSost','tfSubaltCatasto')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRicercaAceAnnullaSost.tfSubaltCatasto.label')}" labelFor="widg_tfSubaltCatasto" errorFor="appDatafiltroAce.subalterno" labelId="tfSubaltCatastoLbl"
	position="last"  >


<!-- widget tfSubaltCatasto -->
<s:textfield 
	
	
	name="appDatafiltroAce.subalterno" id="widg_tfSubaltCatasto"
maxlength="4"	disabled="isWidgetDisabled('cpRicercaAceAnnullaSost','tfSubaltCatasto')"
	size="9" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_pRicercaAce --></div>

			
	
	<div id="p_pRicercaAceByFiltroNav" class="commandPanelBlock"><!-- startFragment:p_pRicercaAceByFiltroNav -->
	
	
<div class="commandPanel navigation" id="pRicercaAceByFiltroNav">

	
	
		

	
	
	
	

	
	
	
	

	
	
	
	<div class="button right">
		
<s:if test="isWidgetVisible('cpRicercaAceAnnullaSost','btnAvanti')" >

	



<!-- widget btnAvanti -->
	<csiuicore:ajaxify id="p_pCenter" 
		widgetType="button"
		 
		requestUri="/siceeweb/base/annullaSostCert/cpRicercaAceAnnullaSost!handleBtnAvanti_CLICKED.do" 
		
		pageId="cpRicercaAceAnnullaSost" 
		formName="cpRicercaAceAnnullaSost"
		javascriptDetection="false">
<s:submit name="widg_btnAvanti" id="widg_btnAvanti" method="handleBtnAvanti_CLICKED"
	key="cpRicercaAceAnnullaSost.btnAvanti.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpRicercaAceAnnullaSost','btnAvanti')" />

	</csiuicore:ajaxify>

	


</s:if>

	


	</div>
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_pRicercaAceByFiltroNav --></div>

			
	
	<div id="p_pRisultatoRicercaAce" class="widgetsPanelBlock"><!-- startFragment:p_pRisultatoRicercaAce -->
	
	

<div class="widgetsPanel" id="pRisultatoRicercaAce">
	

	
	
<s:if test="isWidgetVisible('cpRicercaAceAnnullaSost','tblRisultatoRicercaAceInviati')" >

	
<div class="tableWidget">


<!-- widget tblRisultatoRicercaAceInviati -->
<s:set name="cpRicercaAceAnnullaSost_tblRisultatoRicercaAceInviati_clearStatus" value="isTableClearStatus('cpRicercaAceAnnullaSost_tblRisultatoRicercaAceInviati')" />
<s:url id="cpRicercaAceAnnullaSostViewUrl"						   
					   action="cpRicercaAceAnnullaSost"
					   namespace="/base/annullaSostCert"/>
<display:table name="appDatacertificatiTrovati"  				
			   excludedParams="*"			   export="false"
               id="widg_tblRisultatoRicercaAceInviati"
               pagesize="10"
               keepStatus="true"
               requestURI="${cpRicercaAceAnnullaSostViewUrl}"  
               clearStatus="${cpRicercaAceAnnullaSost_tblRisultatoRicercaAceInviati_clearStatus}"
               uid="row_tblRisultatoRicercaAceInviati"
               summary="" 
decorator="it.csi.sicee.siceeweb.presentation.decorator.annullasostcert.CpRicercaAceAnnullaSostTblRisultatoRicercaAceInviatiCustomDecorator"               class="dataTable">
	
		<display:column headerClass="nosort" media="html">
			<s:checkboxlist list="%{#attr.row_tblRisultatoRicercaAceInviati.codice}" name="appDatacodiciCertificatiSelezionati" id="%{'tblRisultatoRicercaAceInviati-editcell-'+ (#attr.row_tblRisultatoRicercaAceInviati_rowNum - 1)}" cssClass="checkbox"
			/>
		</display:column>
		<display:column property="codice" titleKey="cpRicercaAceAnnullaSost.tblRisultatoRicercaAceInviati.codice.label" 
			sortable="true" headerClass="sortable"
			    media="html"
			
 >
			
		</display:column>
		<display:column property="descIndirizzo" titleKey="cpRicercaAceAnnullaSost.tblRisultatoRicercaAceInviati.descIndirizzo.label" 
			sortable="false" headerClass="nosort"
			    media="html"
			
 >
			
		</display:column>
		<display:column property="descDatiCat" titleKey="cpRicercaAceAnnullaSost.tblRisultatoRicercaAceInviati.descDatiCat.label" 
			sortable="true" headerClass="sortable"
			    media="html"
			
 >
			
		</display:column>
		<display:column property="flgInviato" titleKey="cpRicercaAceAnnullaSost.tblRisultatoRicercaAceInviati.flgInviato.label" 
			sortable="false" headerClass="nosort"
			    media="html"
			
 >
			
		</display:column>
</display:table>

<s:hidden name="__tableselectionempty_appDatacodiciCertificatiSelezionati" id="__tableselectionempty_widg_tblRisultatoRicercaAceInviati" />




	
</div>

</s:if>

	



	
	
	
</div>

	<!-- endFragment:p_pRisultatoRicercaAce --></div>

			
	
	<div id="p_pAggiungiCarrelloAceNav" class="commandPanelBlock"><!-- startFragment:p_pAggiungiCarrelloAceNav -->
	
	
<div class="commandPanel functional" id="pAggiungiCarrelloAceNav">

	
	
		

	
	
	
	<div class="button left">
		
<s:if test="isWidgetVisible('cpRicercaAceAnnullaSost','btnCarrello')" >

	



<!-- widget btnCarrello -->
	<csiuicore:ajaxify id="p_pCenter" 
		widgetType="button"
		 
		requestUri="/siceeweb/base/annullaSostCert/cpRicercaAceAnnullaSost!handleBtnCarrello_CLICKED.do" 
		
		pageId="cpRicercaAceAnnullaSost" 
		formName="cpRicercaAceAnnullaSost"
		javascriptDetection="false">
<s:submit name="widg_btnCarrello" id="widg_btnCarrello" method="handleBtnCarrello_CLICKED"
	key="cpRicercaAceAnnullaSost.btnCarrello.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpRicercaAceAnnullaSost','btnCarrello')" />

	</csiuicore:ajaxify>

	


</s:if>

	


	</div>
	
	

	
	
	
	

	
	
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_pAggiungiCarrelloAceNav --></div>

			
	
	<div id="p_pTornaSceltaFun" class="commandPanelBlock"><!-- startFragment:p_pTornaSceltaFun -->
	
	
<div class="commandPanel navigation" id="pTornaSceltaFun">

	
	
		

	
	
	
	<div class="button left">
		
<s:if test="isWidgetVisible('cpRicercaAceAnnullaSost','btTornaScelta')" >

	



<!-- widget btTornaScelta -->
	<csiuicore:ajaxify id="p_pCenter" 
		widgetType="button"
		 
		requestUri="/siceeweb/base/annullaSostCert/cpRicercaAceAnnullaSost!handleBtTornaScelta_CLICKED.do" 
		
		pageId="cpRicercaAceAnnullaSost" 
		formName="cpRicercaAceAnnullaSost"
		javascriptDetection="false">
<s:submit name="widg_btTornaScelta" id="widg_btTornaScelta" method="handleBtTornaScelta_CLICKED"
	key="cpRicercaAceAnnullaSost.btTornaScelta.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpRicercaAceAnnullaSost','btTornaScelta')" />

	</csiuicore:ajaxify>

	


</s:if>

	


	</div>
	
	

	
	
	
	

	
	
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_pTornaSceltaFun --></div>

			
	
	<div id="p_pConfermaAceNav" class="commandPanelBlock"><!-- startFragment:p_pConfermaAceNav -->
	
	
<div class="commandPanel navigation" id="pConfermaAceNav">

	
	
		

	
	
	
	<div class="button left">
		
<s:if test="isWidgetVisible('cpRicercaAceAnnullaSost','btnIndietro')" >

	



<!-- widget btnIndietro -->
	<csiuicore:ajaxify id="p_pCenter" 
		widgetType="button"
		 
		requestUri="/siceeweb/base/annullaSostCert/cpRicercaAceAnnullaSost!handleBtnIndietro_CLICKED.do" 
		
		pageId="cpRicercaAceAnnullaSost" 
		formName="cpRicercaAceAnnullaSost"
		javascriptDetection="false">
<s:submit name="widg_btnIndietro" id="widg_btnIndietro" method="handleBtnIndietro_CLICKED"
	key="cpRicercaAceAnnullaSost.btnIndietro.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpRicercaAceAnnullaSost','btnIndietro')" />

	</csiuicore:ajaxify>

	


</s:if>

	


	</div>
	
	

	
	
	
	

	
	
	
	<div class="button right">
		
<s:if test="isWidgetVisible('cpRicercaAceAnnullaSost','btnVisualizzaCarrello')" >

	



<!-- widget btnVisualizzaCarrello -->
	<csiuicore:ajaxify id="p_pCenter" 
		widgetType="button"
		 
		requestUri="/siceeweb/base/annullaSostCert/cpRicercaAceAnnullaSost!handleBtnVisualizzaCarrello_CLICKED.do" 
		
		pageId="cpRicercaAceAnnullaSost" 
		formName="cpRicercaAceAnnullaSost"
		javascriptDetection="false">
<s:submit name="widg_btnVisualizzaCarrello" id="widg_btnVisualizzaCarrello" method="handleBtnVisualizzaCarrello_CLICKED"
	key="cpRicercaAceAnnullaSost.btnVisualizzaCarrello.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpRicercaAceAnnullaSost','btnVisualizzaCarrello')" />

	</csiuicore:ajaxify>

	


</s:if>

	


	</div>
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_pConfermaAceNav --></div>

	

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
