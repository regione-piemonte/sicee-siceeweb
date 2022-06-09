<%@taglib uri="/struts-tags" prefix="s" %>
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="/customtag" prefix="customtag" %>
<%@taglib uri="/csiuicore" prefix="csiuicore" %><%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<fmt:setBundle basename="/it/csi/sicee/siceeweb/presentation/siceeweb/action/main/CpVisuraCITAction" />


<s:include value="fragments/header.jsp" ></s:include>



<!-- appmoduleId:base/main -->
<!-- pageId:cpVisuraCIT -->

<s:form id="cpVisuraCIT" action="cpVisuraCIT" namespace="/base/main" method="post">


<%-- NO SCRIPT --%>
		
	
	
		
<!-- ####################### PANNELLO CONTENUTI ###################### -->
<div id="contentPanel">

	<!-- ================ UDLRC Layout UP PANEL ================ -->
	<div id="northPanel">
		<div class="wrapper">
		
	
	<div id="p_pUp" class="formPanelBlock"><!-- startFragment:p_pUp -->

	
	

	
	
			
	
	
<s:include value="/jsp/userpanels/cpVisuraCIT_pUserInfoCustomPagamento.jsp"></s:include>

	



	

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

	
		
			
<s:if test="isWidgetVisible('cpVisuraCIT','menu')" >

	


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
				<h3><s:text name="cpVisuraCIT.pMain.label" /></h3>

					
	
	<div id="p_pCenter" class="formPanelBlock"><!-- startFragment:p_pCenter -->

	
	

	
	
			
	
	<div id="p_pVisura" class="formPanelBlock"><!-- startFragment:p_pVisura -->
		
	


	
	

	
	
			
	
	<div id="p_pErrVisura" class="stdMessagePanelBlock"><!-- startFragment:p_pErrVisura -->
	
	
<div class="stdMessagePanel" id="pErrVisura">
	<customtag:stdMessagePanel id="pErrVisura" errorMessage="true" errorDetails="false" actionMessage="true" />
</div>

	<!-- endFragment:p_pErrVisura --></div>

			
	
	<div id="p_wpVisura" class="widgetsPanelBlock"><!-- startFragment:p_wpVisura -->
	
	
<h4 class="wpLabel">Visura </h4>
<div class="widgetsPanel" id="wpVisura">
	
	<customtag:widgetsPanel id="wpVisuraTbl" columns="4" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('cpVisuraCIT','tfRicCodice')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpVisuraCIT.tfRicCodice.label')}" labelFor="widg_tfRicCodice" errorFor="appDatavisuraRicerca.codImpianto" labelId="tfRicCodiceLbl"
	position="first"  >


<!-- widget tfRicCodice -->
<s:textfield 
	
	
	name="appDatavisuraRicerca.codImpianto" id="widg_tfRicCodice"
maxlength="11"	disabled="isWidgetDisabled('cpVisuraCIT','tfRicCodice')"
	size="15" cssClass="numbers"
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpVisuraCIT','vRicercaCodImpianto')" >

	
<customtag:widgetsPanelColumn colSpan="2" position="last">


<!-- widget vRicercaCodImpianto -->
<s:submit name="widg_vRicercaCodImpianto" id="widg_vRicercaCodImpianto" method="handleVRicercaCodImpianto_CLICKED"
	key="cpVisuraCIT.vRicercaCodImpianto.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpVisuraCIT','vRicercaCodImpianto')" />

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpVisuraCIT','tfRicPod')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpVisuraCIT.tfRicPod.label')}" labelFor="widg_tfRicPod" errorFor="appDatavisuraRicerca.pod" labelId="tfRicPodLbl"
	position="first"  >


<!-- widget tfRicPod -->
<s:textfield 
	
	
	name="appDatavisuraRicerca.pod" id="widg_tfRicPod"
maxlength="20"	disabled="isWidgetDisabled('cpVisuraCIT','tfRicPod')"
	size="15" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpVisuraCIT','vRicercaPod')" >

	
<customtag:widgetsPanelColumn colSpan="2" position="last">


<!-- widget vRicercaPod -->
<s:submit name="widg_vRicercaPod" id="widg_vRicercaPod" method="handleVRicercaPod_CLICKED"
	key="cpVisuraCIT.vRicercaPod.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpVisuraCIT','vRicercaPod')" />

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpVisuraCIT','tfRicPdr')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpVisuraCIT.tfRicPdr.label')}" labelFor="widg_tfRicPdr" errorFor="appDatavisuraRicerca.pdr" labelId="tfRicPdrLbl"
	position="first"  >


<!-- widget tfRicPdr -->
<s:textfield 
	
	
	name="appDatavisuraRicerca.pdr" id="widg_tfRicPdr"
maxlength="20"	disabled="isWidgetDisabled('cpVisuraCIT','tfRicPdr')"
	size="15" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpVisuraCIT','vRicercaPdr')" >

	
<customtag:widgetsPanelColumn colSpan="2" position="last">


<!-- widget vRicercaPdr -->
<s:submit name="widg_vRicercaPdr" id="widg_vRicercaPdr" method="handleVRicercaPdr_CLICKED"
	key="cpVisuraCIT.vRicercaPdr.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpVisuraCIT','vRicercaPdr')" />

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_wpVisura --></div>

			
	
	<div id="p_wpVisuraIndirizzo" class="widgetsPanelBlock"><!-- startFragment:p_wpVisuraIndirizzo -->
	
	
<h4 class="wpLabel">Ricerca impianto per indirizzo </h4>
<div class="widgetsPanel" id="wpVisuraIndirizzo">
	
	<customtag:widgetsPanel id="wpVisuraIndirizzoTbl" columns="8" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('cpVisuraCIT','tfRicIstat')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpVisuraCIT.tfRicIstat.label')}" labelFor="widg_tfRicIstat" errorFor="appDatavisuraRicerca.istat" labelId="tfRicIstatLbl"
	position="first"  >


<!-- widget tfRicIstat -->
<s:textfield 
	
	
	name="appDatavisuraRicerca.istat" id="widg_tfRicIstat"
maxlength="11"	disabled="isWidgetDisabled('cpVisuraCIT','tfRicIstat')"
	size="15" cssClass="numbers"
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpVisuraCIT','tfRicIndirizzo')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpVisuraCIT.tfRicIndirizzo.label')}" labelFor="widg_tfRicIndirizzo" errorFor="appDatavisuraRicerca.indirizzo" labelId="tfRicIndirizzoLbl"
	  >


<!-- widget tfRicIndirizzo -->
<s:textfield 
	
	
	name="appDatavisuraRicerca.indirizzo" id="widg_tfRicIndirizzo"
maxlength="30"	disabled="isWidgetDisabled('cpVisuraCIT','tfRicIndirizzo')"
	size="30" cssClass="numbers"
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" />
</s:else>


	
<s:if test="isWidgetVisible('cpVisuraCIT','tfRicCivico')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpVisuraCIT.tfRicCivico.label')}" labelFor="widg_tfRicCivico" errorFor="appDatavisuraRicerca.civico" labelId="tfRicCivicoLbl"
	  >


<!-- widget tfRicCivico -->
<s:textfield 
	
	
	name="appDatavisuraRicerca.civico" id="widg_tfRicCivico"
maxlength="11"	disabled="isWidgetDisabled('cpVisuraCIT','tfRicCivico')"
	size="15" cssClass="numbers"
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" />
</s:else>


	
<s:if test="isWidgetVisible('cpVisuraCIT','vRicercaIndirizzo')" >

	
<customtag:widgetsPanelColumn colSpan="2" position="last">


<!-- widget vRicercaIndirizzo -->
<s:submit name="widg_vRicercaIndirizzo" id="widg_vRicercaIndirizzo" method="handleVRicercaIndirizzo_CLICKED"
	key="cpVisuraCIT.vRicercaIndirizzo.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpVisuraCIT','vRicercaIndirizzo')" />

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_wpVisuraIndirizzo --></div>

			
	
	
	<div id="p_mpElencoImp" class="panelBlock"><!-- startFragment:p_mpElencoImp -->
		

		
<s:if test="#session.cpVisuraCIT_mpElencoImp_selectedMultiPanel == 'cpVisuraCIT_mpElencoImp_fpElencoImp'">
	<s:include value="/jsp/multipanels/cpVisuraCIT_mpElencoImp_fpElencoImp.jsp" ></s:include>
</s:if>
	<!-- endFragment:p_mpElencoImp --></div>

			
	
	
	<div id="p_mpDettImpianto" class="panelBlock"><!-- startFragment:p_mpDettImpianto -->
		

		
<s:if test="#session.cpVisuraCIT_mpDettImpianto_selectedMultiPanel == 'cpVisuraCIT_mpDettImpianto_fpDettImpianto'">
	<s:include value="/jsp/multipanels/cpVisuraCIT_mpDettImpianto_fpDettImpianto.jsp" ></s:include>
</s:if>
	<!-- endFragment:p_mpDettImpianto --></div>

			
	
	<div id="p_cpNavVisura" class="commandPanelBlock"><!-- startFragment:p_cpNavVisura -->
	
	
<div class="commandPanel navigation" id="cpNavVisura">

	
	
		

	
	
	
	<div class="button left">
		
<s:if test="isWidgetVisible('cpVisuraCIT','bIndietro')" >

	



<!-- widget bIndietro -->
<s:submit name="widg_bIndietro" id="widg_bIndietro" method="handleBIndietro_CLICKED"
	key="cpVisuraCIT.bIndietro.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpVisuraCIT','bIndietro')" />

	


</s:if>

	


	</div>
	
	

	
	
	
	

	
	
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_cpNavVisura --></div>

	

		
	

	<!-- endFragment:p_pVisura --></div>

	

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
