<%@taglib uri="/struts-tags" prefix="s" %>
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="/customtag" prefix="customtag" %>
<%@taglib uri="/csiuicore" prefix="csiuicore" %>

<s:include value="fragments/header.jsp" ></s:include>



<!-- appmoduleId:base/annullaSostCert -->
<!-- pageId:cpSelezionaTipoRicercaAnnullaSost -->

<s:form id="cpSelezionaTipoRicercaAnnullaSost" action="cpSelezionaTipoRicercaAnnullaSost" namespace="/base/annullaSostCert" method="post">


<%-- NO SCRIPT --%>
		
	
	
		
<!-- ####################### PANNELLO CONTENUTI ###################### -->
<div id="contentPanel">

	<!-- ================ UDLRC Layout UP PANEL ================ -->
	<div id="northPanel">
		<div class="wrapper">
		
	
	<div id="p_pUp" class="formPanelBlock"><!-- startFragment:p_pUp -->

	
	

	
	
			
	
	
<s:include value="/jsp/userpanels/cpSelezionaTipoRicercaAnnullaSost_pUserInfoCustom.jsp"></s:include>

	



	

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

	
		
			
<s:if test="isWidgetVisible('cpSelezionaTipoRicercaAnnullaSost','menu')" >

	


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
				<h3><s:text name="cpSelezionaTipoRicercaAnnullaSost.pMain.label" /></h3>

					
	
	<div id="p_pCenter" class="formPanelBlock"><!-- startFragment:p_pCenter -->

	
	

	
	
			
	
	<div id="p_pErrRicercaAce" class="stdMessagePanelBlock"><!-- startFragment:p_pErrRicercaAce -->
	
	
<div class="stdMessagePanel" id="pErrRicercaAce">
	<customtag:stdMessagePanel id="pErrRicercaAce" errorMessage="true" errorDetails="false" actionMessage="true" />
</div>

	<!-- endFragment:p_pErrRicercaAce --></div>

			
	
	<div id="p_pTipoRicercaAceFun" class="commandPanelBlock"><!-- startFragment:p_pTipoRicercaAceFun -->
	
	
<div class="commandPanel functional" id="pTipoRicercaAceFun">

	
	
		

	
	
	
	<div class="button left">
		
<s:if test="isWidgetVisible('cpSelezionaTipoRicercaAnnullaSost','btnScegliAceOld')" >

	



<!-- widget btnScegliAceOld -->
	<csiuicore:ajaxify id="p_pCenter" 
		widgetType="button"
		 
		requestUri="/siceeweb/base/annullaSostCert/cpSelezionaTipoRicercaAnnullaSost!handleBtnScegliAceOld_CLICKED.do" 
		
		pageId="cpSelezionaTipoRicercaAnnullaSost" 
		formName="cpSelezionaTipoRicercaAnnullaSost"
		javascriptDetection="false">
<s:submit name="widg_btnScegliAceOld" id="widg_btnScegliAceOld" method="handleBtnScegliAceOld_CLICKED"
	key="cpSelezionaTipoRicercaAnnullaSost.btnScegliAceOld.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpSelezionaTipoRicercaAnnullaSost','btnScegliAceOld')" />

	</csiuicore:ajaxify>

	


</s:if>

	


	</div>
	
	

	
	
	
	

	
	
	
	<div class="button right">
		
<s:if test="isWidgetVisible('cpSelezionaTipoRicercaAnnullaSost','btnScegliAceNew')" >

	



<!-- widget btnScegliAceNew -->
	<csiuicore:ajaxify id="p_pCenter" 
		widgetType="button"
		 
		requestUri="/siceeweb/base/annullaSostCert/cpSelezionaTipoRicercaAnnullaSost!handleBtnScegliAceNew_CLICKED.do" 
		
		pageId="cpSelezionaTipoRicercaAnnullaSost" 
		formName="cpSelezionaTipoRicercaAnnullaSost"
		javascriptDetection="false">
<s:submit name="widg_btnScegliAceNew" id="widg_btnScegliAceNew" method="handleBtnScegliAceNew_CLICKED"
	key="cpSelezionaTipoRicercaAnnullaSost.btnScegliAceNew.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpSelezionaTipoRicercaAnnullaSost','btnScegliAceNew')" />

	</csiuicore:ajaxify>

	


</s:if>

	


	</div>
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_pTipoRicercaAceFun --></div>

			
	
	<div id="p_pConfermaAceNav" class="commandPanelBlock"><!-- startFragment:p_pConfermaAceNav -->
	
	
<div class="commandPanel navigation" id="pConfermaAceNav">

	
	
		

	
	
	
	<div class="button left">
		
<s:if test="isWidgetVisible('cpSelezionaTipoRicercaAnnullaSost','btnIndietro')" >

	



<!-- widget btnIndietro -->
	<csiuicore:ajaxify id="p_pCenter" 
		widgetType="button"
		 
		requestUri="/siceeweb/base/annullaSostCert/cpSelezionaTipoRicercaAnnullaSost!handleBtnIndietro_CLICKED.do" 
		
		pageId="cpSelezionaTipoRicercaAnnullaSost" 
		formName="cpSelezionaTipoRicercaAnnullaSost"
		javascriptDetection="false">
<s:submit name="widg_btnIndietro" id="widg_btnIndietro" method="handleBtnIndietro_CLICKED"
	key="cpSelezionaTipoRicercaAnnullaSost.btnIndietro.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpSelezionaTipoRicercaAnnullaSost','btnIndietro')" />

	</csiuicore:ajaxify>

	


</s:if>

	


	</div>
	
	

	
	
	
	

	
	
	
	<div class="button right">
		
<s:if test="isWidgetVisible('cpSelezionaTipoRicercaAnnullaSost','btnVisualizzaCarrello')" >

	



<!-- widget btnVisualizzaCarrello -->
	<csiuicore:ajaxify id="p_pCenter" 
		widgetType="button"
		 
		requestUri="/siceeweb/base/annullaSostCert/cpSelezionaTipoRicercaAnnullaSost!handleBtnVisualizzaCarrello_CLICKED.do" 
		
		pageId="cpSelezionaTipoRicercaAnnullaSost" 
		formName="cpSelezionaTipoRicercaAnnullaSost"
		javascriptDetection="false">
<s:submit name="widg_btnVisualizzaCarrello" id="widg_btnVisualizzaCarrello" method="handleBtnVisualizzaCarrello_CLICKED"
	key="cpSelezionaTipoRicercaAnnullaSost.btnVisualizzaCarrello.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpSelezionaTipoRicercaAnnullaSost','btnVisualizzaCarrello')" />

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
