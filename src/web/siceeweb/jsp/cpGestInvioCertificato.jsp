<%@taglib uri="/struts-tags" prefix="s" %>
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="/customtag" prefix="customtag" %>
<%@taglib uri="/csiuicore" prefix="csiuicore" %>

<s:include value="fragments/header.jsp" ></s:include>



<!-- appmoduleId:base/gestattestati -->
<!-- pageId:cpGestInvioCertificato -->

<s:form id="cpGestInvioCertificato" action="cpGestInvioCertificato" namespace="/base/gestattestati" method="post" enctype="multipart/form-data">


<%-- NO SCRIPT --%>
		
	
	
		
<!-- ####################### PANNELLO CONTENUTI ###################### -->
<div id="contentPanel">

	<!-- ================ UDLRC Layout UP PANEL ================ -->
	<div id="northPanel">
		<div class="wrapper">
		
	
	<div id="p_pUp" class="formPanelBlock"><!-- startFragment:p_pUp -->

	
	

	
	
			
	
	
<s:include value="/jsp/userpanels/cpGestInvioCertificato_pUserInfoCustomGestACE.jsp"></s:include>

	



	

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

	
		
			
<s:if test="isWidgetVisible('cpGestInvioCertificato','menu')" >

	


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
				<h3><s:text name="cpGestInvioCertificato.pMain.label" /></h3>

					
	
	<div id="p_pCenter" class="formPanelBlock"><!-- startFragment:p_pCenter -->

	
	

	
	
			
	
	<div id="p_pInvioCert" class="formPanelBlock"><!-- startFragment:p_pInvioCert -->
		
	
<div class="formPanel" id="pInvioCert">


	
	

	
	
			
	
	<div id="p_pErrInvioDocumento" class="stdMessagePanelBlock"><!-- startFragment:p_pErrInvioDocumento -->
	
	
<div class="stdMessagePanel" id="pErrInvioDocumento">
	<customtag:stdMessagePanel id="pErrInvioDocumento" errorMessage="true" errorDetails="false" actionMessage="true" />
</div>

	<!-- endFragment:p_pErrInvioDocumento --></div>

			
	
	<div id="p_pInvioC" class="widgetsPanelBlock"><!-- startFragment:p_pInvioC -->
	
	

<div class="widgetsPanel" id="pInvioC">
	
	<customtag:widgetsPanel id="pInvioCTbl" columns="2" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('cpGestInvioCertificato','txtInvio')" >

	
<customtag:widgetsPanelColumn  colSpan="2"  >


<!-- widget txtInvio -->
<s:text name="cpGestInvioCertificato.txtInvio.statictext.label" />

	
</customtag:widgetsPanelColumn>

</s:if>

	



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_pInvioC --></div>

			
	
	<div id="p_pInvioA" class="widgetsPanelBlock"><!-- startFragment:p_pInvioA -->
	
	
<h4 class="wpLabel">Specifica tipologia di certificato  </h4>
<div class="widgetsPanel" id="pInvioA">
	
	<customtag:widgetsPanel id="pInvioATbl" columns="2" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('cpGestInvioCertificato','rbConsensoAceSostitutivo')" >

	
<customtag:widgetsPanelColumn 
	 colSpan="2" >


<!-- widget rbConsensoAceSostitutivo -->

	
<div id="appDatadichiarazioneAceSostitutivo" class="radiobuttons ">







<s:radio
	
	
	id="widg_rbConsensoAceSostitutivoNo" name="appDatadichiarazioneAceSostitutivo"
	list="#{'N':'Nuovo certificato'}"
	disabled="isWidgetDisabled('cpGestInvioCertificato','rbConsensoAceSostitutivo')"
	cssClass="radio"
	
	/> <label  for="widg_rbConsensoAceSostitutivoNoN"><s:text name="cpGestInvioCertificato.rbConsensoAceSostitutivo.rbConsensoAceSostitutivoNo.label" /></label>








<s:radio
	
	
	id="widg_rbConsensoAceSostitutivoSi" name="appDatadichiarazioneAceSostitutivo"
	list="#{'S':'Certificato per sostituzione <sup>A</sup>'}"
	disabled="isWidgetDisabled('cpGestInvioCertificato','rbConsensoAceSostitutivo')"
	cssClass="radio"
	
	/> <label  for="widg_rbConsensoAceSostitutivoSiS"><s:text name="cpGestInvioCertificato.rbConsensoAceSostitutivo.rbConsensoAceSostitutivoSi.label" /></label>





	
</div>



	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestInvioCertificato','txtNote')" >

	
<customtag:widgetsPanelColumn  colSpan="2"  >


<!-- widget txtNote -->
<s:text name="cpGestInvioCertificato.txtNote.statictext.label" />

	
</customtag:widgetsPanelColumn>

</s:if>

	



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_pInvioA --></div>

			
	
	<div id="p_pInvioB" class="widgetsPanelBlock"><!-- startFragment:p_pInvioB -->
	
	
<h4 class="wpLabel">Carica file </h4>
<div class="widgetsPanel" id="pInvioB">
	
	<customtag:widgetsPanel id="pInvioBTbl" columns="2" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('cpGestInvioCertificato','fileAttestato')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestInvioCertificato.fileAttestato.label')}" labelFor="widg_fileAttestato" errorFor="widg_fileAttestato" labelId="fileAttestatoLbl"
	  >


<s:file 
	
	
	name="widg_fileAttestato" id="widg_fileAttestato"
	disabled="isWidgetDisabled('cpGestInvioCertificato','fileAttestato')"
	
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_pInvioB --></div>

			
	
	<div id="p_pInvioFun" class="commandPanelBlock"><!-- startFragment:p_pInvioFun -->
	
	
<div class="commandPanel functional" id="pInvioFun">

	
	
		

	
	
	
	

	
	
	
	

	
	
	
	<div class="button right">
		
<s:if test="isWidgetVisible('cpGestInvioCertificato','bInvioAvanti')" >

	



<!-- widget bInvioAvanti -->
<s:submit name="widg_bInvioAvanti" id="widg_bInvioAvanti" method="handleBInvioAvanti_CLICKED"
	key="cpGestInvioCertificato.bInvioAvanti.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpGestInvioCertificato','bInvioAvanti')" />

	


</s:if>

	


	</div>
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_pInvioFun --></div>

			
	
	<div id="p_pInvioNav" class="commandPanelBlock"><!-- startFragment:p_pInvioNav -->
	
	
<div class="commandPanel navigation" id="pInvioNav">

	
	
		

	
	
	
	<div class="button left">
		
<s:if test="isWidgetVisible('cpGestInvioCertificato','bIndietro')" >

	



<!-- widget bIndietro -->
<s:submit name="widg_bIndietro" id="widg_bIndietro" method="handleBIndietro_CLICKED"
	key="cpGestInvioCertificato.bIndietro.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpGestInvioCertificato','bIndietro')" />

	


</s:if>

	


	</div>
	
	

	
	
	
	

	
	
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_pInvioNav --></div>

	

		
	
</div>

	<!-- endFragment:p_pInvioCert --></div>

	

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
