<%@taglib uri="/struts-tags" prefix="s" %>
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="/customtag" prefix="customtag" %>
<%@taglib uri="/csiuicore" prefix="csiuicore" %><%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<fmt:setBundle basename="/it/csi/sicee/siceeweb/presentation/siceeweb/action/gestcertificatore/CpAttesaRTAction" />


<s:include value="fragments/header.jsp" ></s:include>



<!-- appmoduleId:base/gestcertificatore -->
<!-- pageId:cpAttesaRT -->

<s:form id="cpAttesaRT" action="cpAttesaRT" namespace="/base/gestcertificatore" method="post">


<%-- NO SCRIPT --%>
		
	
	
		
<!-- ####################### PANNELLO CONTENUTI ###################### -->
<div id="contentPanel">

	<!-- ================ UDLRC Layout UP PANEL ================ -->
	<div id="northPanel">
		<div class="wrapper">
		
	
	<div id="p_pUp" class="formPanelBlock"><!-- startFragment:p_pUp -->

	
	

	
	
			
	
	
<s:include value="/jsp/userpanels/cpAttesaRT_pUserInfoCustomRegistraz.jsp"></s:include>

	



	

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

	
		
			
<s:if test="isWidgetVisible('cpAttesaRT','menu')" >

	


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

					
	
	<div id="p_pCenter" class="formPanelBlock"><!-- startFragment:p_pCenter -->

	
	

	
	
			
	
	<div id="p_pAttesaRT" class="formPanelBlock"><!-- startFragment:p_pAttesaRT -->
		
	
<div class="formPanel" id="pAttesaRT">


	
	

	
	
			
	
	<div id="p_pErrPagamentoNew" class="stdMessagePanelBlock"><!-- startFragment:p_pErrPagamentoNew -->
	
	
<div class="stdMessagePanel" id="pErrPagamentoNew">
	<customtag:stdMessagePanel id="pErrPagamentoNew" errorMessage="true" errorDetails="false" actionMessage="true" />
</div>

	<!-- endFragment:p_pErrPagamentoNew --></div>

			
	
	<div id="p_pFiltro" class="widgetsPanelBlock"><!-- startFragment:p_pFiltro -->
	
	
<h4 class="wpLabel">Filtro lista richieste di ricarica </h4>
<div class="widgetsPanel" id="pFiltro">
	
	<customtag:widgetsPanel id="pFiltroTbl" columns="2" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('cpAttesaRT','cbStatiTrans')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpAttesaRT.cbStatiTrans.label')}" labelFor="widg_cbStatiTrans" errorFor="appDataidStatoTransazioneMdpNewSelez" labelId="cbStatiTransLbl"
	  >


<!-- widget cbStatiTrans -->

<s:url id="widg_cbStatiTransurlComboBoxValueChange"
   action="/siceeweb/cpAttesaRT!handleCbStatiTrans_VALUE_CHANGED" namespace="/base/gestcertificatore"  
   includeParams="all" portletUrlType="action" 
/>
<s:select name="appDataidStatoTransazioneMdpNewSelez" id="widg_cbStatiTrans"
	 
	

		title=" - Attenzione. Dopo aver selezionato un valore, la pagina verra' aggiornata automaticamente"
			
	  headerKey="" headerValue="" 
	  list="appDatastatiTransazioneMdpNew"
	  disabled="isWidgetDisabled('cpAttesaRT','cbStatiTrans')"
	  listKey="value"
	  listValue="label"
	  onclick="onCBClick(this,'confermacbStatiTrans','conferma','%{widg_cbStatiTransurlComboBoxValueChange}')" onfocus="inFocus(this)" onblur="lostFocus(this,'confermacbStatiTrans','conferma','%{widg_cbStatiTransurlComboBoxValueChange}')" 
	  />


	
</customtag:widgetsPanelColumn>

</s:if>

	



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_pFiltro --></div>

			
	
	<div id="p_pDettaglio" class="widgetsPanelBlock"><!-- startFragment:p_pDettaglio -->
	
	
<h4 class="wpLabel">Dettaglio richieste di ricarica </h4>
<div class="widgetsPanel" id="pDettaglio">
	

	
	
<s:if test="isWidgetVisible('cpAttesaRT','transCredito')" >

	
<div class="tableWidget">


<!-- widget transCredito -->
<s:set name="cpAttesaRT_transCredito_clearStatus" value="isTableClearStatus('cpAttesaRT_transCredito')" />
<s:url id="cpAttesaRTViewUrl"						   
					   action="cpAttesaRT"
					   namespace="/base/gestcertificatore"/>
<display:table name="appDatadatiPagamentoNewList"  				
			   excludedParams="*"			   export="false"
               id="widg_transCredito"
               pagesize="10"
               keepStatus="true"
               requestURI="${cpAttesaRTViewUrl}"  
               clearStatus="${cpAttesaRT_transCredito_clearStatus}"
               uid="row_transCredito"
               summary="" 
               class="dataTable">
	
		<display:column headerClass="nosort" media="html">
			<s:radio list="%{#attr.row_transCredito.idTransazione2018}" name="appDataidDatiPagamentoNewSelez" id="%{'transCredito-editcell-'+ (#attr.row_transCredito_rowNum - 1)}" cssClass="radio"
			/>
		</display:column>
		<display:column property="idTransMdp" titleKey="cpAttesaRT.transCredito.idTransMdp.label" 
			sortable="false" headerClass="nosort"
			    media="html"
			
 >
			
		</display:column>
		<display:column property="importo" titleKey="cpAttesaRT.transCredito.importo.label" 
			sortable="false" headerClass="nosort"
			format="{0,number,#,##0.00}"  class="numbers"  media="html"
			
 >
			
		</display:column>
		<display:column property="dtTransazione" titleKey="cpAttesaRT.transCredito.dtTransazione.label" 
			sortable="false" headerClass="nosort"
			    media="html"
			
 >
			
		</display:column>
		<display:column property="tipoPersonaDesc" titleKey="cpAttesaRT.transCredito.tipoPersonaDesc.label" 
			sortable="false" headerClass="nosort"
			    media="html"
			
 >
			
		</display:column>
		<display:column property="codiceFiscale" titleKey="cpAttesaRT.transCredito.codiceFiscale.label" 
			sortable="false" headerClass="nosort"
			    media="html"
			
 >
			
		</display:column>
		<display:column property="anagraficaVersante" titleKey="cpAttesaRT.transCredito.anagraficaVersante.label" 
			sortable="false" headerClass="nosort"
			    media="html"
			
 >
			
		</display:column>
</display:table>





	
</div>

</s:if>

	



	
	
	
</div>

	<!-- endFragment:p_pDettaglio --></div>

			
	
	<div id="p_pAttesaRTFun" class="commandPanelBlock"><!-- startFragment:p_pAttesaRTFun -->
	
	
<div class="commandPanel functional" id="pAttesaRTFun">

	
	
		

	
	
	
	

	
	
	
	

	
	
	
	<div class="button right">
		
<s:if test="isWidgetVisible('cpAttesaRT','bRicevutaNew')" >

	



<!-- widget bRicevutaNew -->
<s:submit name="widg_bRicevutaNew" id="widg_bRicevutaNew" method="handleBRicevutaNew_CLICKED"
	key="cpAttesaRT.bRicevutaNew.label" cssClass="buttonWidget showReport"
	disabled="isWidgetDisabled('cpAttesaRT','bRicevutaNew')" />

	


</s:if>

	


	</div>
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_pAttesaRTFun --></div>

			
	
	<div id="p_pAttesaRTNav" class="commandPanelBlock"><!-- startFragment:p_pAttesaRTNav -->
	
	
<div class="commandPanel navigation" id="pAttesaRTNav">

	
	
		

	
	
	
	<div class="button left">
		
<s:if test="isWidgetVisible('cpAttesaRT','bAttesaRTIndietro')" >

	



<!-- widget bAttesaRTIndietro -->
<s:submit name="widg_bAttesaRTIndietro" id="widg_bAttesaRTIndietro" method="handleBAttesaRTIndietro_CLICKED"
	key="cpAttesaRT.bAttesaRTIndietro.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpAttesaRT','bAttesaRTIndietro')" />

	


</s:if>

	


	</div>
	
	

	
	
	
	

	
	
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_pAttesaRTNav --></div>

	

		
	
</div>

	<!-- endFragment:p_pAttesaRT --></div>

	

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
