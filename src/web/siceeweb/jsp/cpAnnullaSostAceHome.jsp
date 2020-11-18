<%@taglib uri="/struts-tags" prefix="s" %>
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="/customtag" prefix="customtag" %>
<%@taglib uri="/csiuicore" prefix="csiuicore" %>

<s:include value="fragments/header.jsp" ></s:include>



<!-- appmoduleId:base/annullaSostCert -->
<!-- pageId:cpAnnullaSostAceHome -->

<s:form id="cpAnnullaSostAceHome" action="cpAnnullaSostAceHome" namespace="/base/annullaSostCert" method="post">


<%-- NO SCRIPT --%>
		
	
	
		
<!-- ####################### PANNELLO CONTENUTI ###################### -->
<div id="contentPanel">

	<!-- ================ UDLRC Layout UP PANEL ================ -->
	<div id="northPanel">
		<div class="wrapper">
		
	
	<div id="p_pUp" class="formPanelBlock"><!-- startFragment:p_pUp -->

	
	

	
	
			
	
	
<s:include value="/jsp/userpanels/cpAnnullaSostAceHome_pUserInfoCustom.jsp"></s:include>

	



	

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

	
		
			
<s:if test="isWidgetVisible('cpAnnullaSostAceHome','menu')" >

	


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
				<h3><s:text name="cpAnnullaSostAceHome.pMain.label" /></h3>

					
	
	<div id="p_pCenter" class="formPanelBlock"><!-- startFragment:p_pCenter -->

	
	

	
	
			
	
	<div id="p_pErrRicercaAce" class="stdMessagePanelBlock"><!-- startFragment:p_pErrRicercaAce -->
	
	
<div class="stdMessagePanel" id="pErrRicercaAce">
	<customtag:stdMessagePanel id="pErrRicercaAce" errorMessage="true" errorDetails="false" actionMessage="true" />
</div>

	<!-- endFragment:p_pErrRicercaAce --></div>

			
	
	<div id="p_pRicercaAceInviati" class="widgetsPanelBlock"><!-- startFragment:p_pRicercaAceInviati -->
	
	
<h4 class="wpLabel">Motivazione sostituzione </h4>
<div class="widgetsPanel" id="pRicercaAceInviati">
	
	<customtag:widgetsPanel id="pRicercaAceInviatiTbl" columns="2" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('cpAnnullaSostAceHome','cbMotivazioneAce')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpAnnullaSostAceHome.cbMotivazioneAce.label')}" labelFor="widg_cbMotivazioneAce" errorFor="appDatadatiAnnullamento.idMotivo" labelId="cbMotivazioneAceLbl"
	  fieldRequired="true">


<!-- widget cbMotivazioneAce -->
<s:select name="appDatadatiAnnullamento.idMotivo" id="widg_cbMotivazioneAce"
	 
	
		title=""
			
	  headerKey="" headerValue="" 
	  list="appDatamotiviAnnullamento"
	  disabled="isWidgetDisabled('cpAnnullaSostAceHome','cbMotivazioneAce')"
	  listKey="cod"
	  listValue="descr"
	  
	  />


	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpAnnullaSostAceHome','tfDataAnnullamento')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpAnnullaSostAceHome.tfDataAnnullamento.label')}" labelFor="widg_tfDataAnnullamento" errorFor="appDatadatiAnnullamento.data" labelId="tfDataAnnullamentoLbl"
	  >


<!-- widget tfDataAnnullamento -->
<s:textfield 
	
	
	name="appDatadatiAnnullamento.data" id="widg_tfDataAnnullamento"
maxlength="10"	disabled="isWidgetDisabled('cpAnnullaSostAceHome','tfDataAnnullamento')"
	size="15" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpAnnullaSostAceHome','taNote')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpAnnullaSostAceHome.taNote.label')}" labelFor="widg_taNote" errorFor="appDatadatiAnnullamento.note" labelId="taNoteLbl"
	  fieldRequired="true">


<!-- widget taNote -->
<s:textarea 
	
	
	name="appDatadatiAnnullamento.note" id="widg_taNote"
	disabled="isWidgetDisabled('cpAnnullaSostAceHome','taNote')"
	rows="10"
	cols="60"
	></s:textarea>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpAnnullaSostAceHome','cbPregresso')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpAnnullaSostAceHome.cbPregresso.label')}" labelFor="widg_cbPregresso" errorFor="appDatadatiAnnullamento.flgRicercaPregresso" labelId="cbPregressoLbl"
	  >


<!-- widget cbPregresso -->
<s:checkbox 
	
	
	name="appDatadatiAnnullamento.flgRicercaPregresso" id="widg_cbPregresso"
	disabled="isWidgetDisabled('cpAnnullaSostAceHome','cbPregresso')"
	cssClass="checkbox"
	
	/> 
<s:if test="!isWidgetDisabled('cpAnnullaSostAceHome','cbPregresso')" >
	<s:hidden name="__checkbox_appDatadatiAnnullamento.flgRicercaPregresso" id="__checkbox_widg_cbPregresso" />
</s:if>

	
</customtag:widgetsPanelColumn>

</s:if>

	



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_pRicercaAceInviati --></div>

			
	
	<div id="p_pRicercaAceInviatiNav" class="commandPanelBlock"><!-- startFragment:p_pRicercaAceInviatiNav -->
	
	
<div class="commandPanel navigation" id="pRicercaAceInviatiNav">

	
	
		

	
	
	
	

	
	
	
	

	
	
	
	<div class="button right">
		
<s:if test="isWidgetVisible('cpAnnullaSostAceHome','btnAvanti')" >

	



<!-- widget btnAvanti -->
	<csiuicore:ajaxify id="p_pErrRicercaAce" 
		widgetType="button"
		 
		requestUri="/siceeweb/base/annullaSostCert/cpAnnullaSostAceHome!handleBtnAvanti_CLICKED.do" 
		
		pageId="cpAnnullaSostAceHome" 
		formName="cpAnnullaSostAceHome"
		javascriptDetection="false">
<s:submit name="widg_btnAvanti" id="widg_btnAvanti" method="handleBtnAvanti_CLICKED"
	key="cpAnnullaSostAceHome.btnAvanti.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpAnnullaSostAceHome','btnAvanti')" />

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
