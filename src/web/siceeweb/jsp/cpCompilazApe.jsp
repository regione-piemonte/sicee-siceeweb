<%@taglib uri="/struts-tags" prefix="s" %>
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="/customtag" prefix="customtag" %>
<%@taglib uri="/csiuicore" prefix="csiuicore" %><%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<fmt:setBundle basename="/it/csi/sicee/siceeweb/presentation/siceeweb/action/compilazattestatiape/CpCompilazApeAction" />


<s:include value="fragments/header.jsp" ></s:include>



<!-- appmoduleId:base/compilazattestatiape -->
<!-- pageId:cpCompilazApe -->

<s:form id="cpCompilazApe" action="cpCompilazApe" namespace="/base/compilazattestatiape" method="post" enctype="multipart/form-data">


<%-- NO SCRIPT --%>
		
	
	
		
<!-- ####################### PANNELLO CONTENUTI ###################### -->
<div id="contentPanel">

	<!-- ================ UDLRC Layout UP PANEL ================ -->
	<div id="northPanel">
		<div class="wrapper">
		
	
	<div id="p_pUp" class="formPanelBlock"><!-- startFragment:p_pUp -->

	
	

	
	
			
	
	
<s:include value="/jsp/userpanels/cpCompilazApe_pUserInfoCustomRegistraz.jsp"></s:include>

	



	

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

	
		
			
<s:if test="isWidgetVisible('cpCompilazApe','menu')" >

	


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
				<h3><s:text name="cpCompilazApe.pMainApe.label" /></h3>

					
	
	<div id="p_pCenter" class="formPanelBlock"><!-- startFragment:p_pCenter -->

	
	

	
	
			
	
	
	<div class="tabSetPanelContent">
	<div id="p_tspApe" class="tabSetPanelBlock"><!-- startFragment:p_tspApe -->
	
	
<div class="tabSetPanel" id="tspApe">
	<ul>
		<s:url id="cpCompilazApe_tspApe_fpTspApeDatiGen_URL" action="cpCompilazApe" namespace="/base/compilazattestatiape" method="handleChangeTab" includeParams="get">
			<s:param name="selectedTabKey" value="%{'cpCompilazApe_tspApe_selectedMultiPanel'}" />
			<s:param name="selectedTabValue" value="%{'cpCompilazApe_tspApe_fpTspApeDatiGen'}" />
		</s:url>
		<s:if test="%{#session.cpCompilazApe_tspApe_selectedMultiPanel == 'cpCompilazApe_tspApe_fpTspApeDatiGen' || #session.cpCompilazApe_tspApe_selectedMultiPanel == null}">
			<li class="item-1 active"
			title="Dati generali"
			>
			<span class="activeItem"><s:text name="cpCompilazApe.fpTspApeDatiGen.label" /></span></li>
		</s:if>
		<s:else>
			<li class="item-1">

	<csiuicore:ajaxify id="p_tspApe" 
		widgetType="button" 
		requestUri="/siceeweb/base/compilazattestatiape/cpCompilazApe!handle_CpCompilazApe_TspApe_FpTspApeDatiGen_CLICKED.do" 
		pageId="cpCompilazApe" 
		formName="cpCompilazApe"
		javascriptDetection="false">
				<s:submit name="tsApe"
				          id="tsApe_fpTspApeDatiGen"
				          method="handle_CpCompilazApe_TspApe_FpTspApeDatiGen_CLICKED"
				          title="Dati generali"
				          key="cpCompilazApe.fpTspApeDatiGen.label" />
					
	</csiuicore:ajaxify>
			</li>
		</s:else>
		<s:url id="cpCompilazApe_tspApe_fpTspApeSopralluogo_URL" action="cpCompilazApe" namespace="/base/compilazattestatiape" method="handleChangeTab" includeParams="get">
			<s:param name="selectedTabKey" value="%{'cpCompilazApe_tspApe_selectedMultiPanel'}" />
			<s:param name="selectedTabValue" value="%{'cpCompilazApe_tspApe_fpTspApeSopralluogo'}" />
		</s:url>
		<s:if test="%{#session.cpCompilazApe_tspApe_selectedMultiPanel == 'cpCompilazApe_tspApe_fpTspApeSopralluogo'}">
			<li class="item-2 active"
			title="Sopralluogo"
			>
			<span class="activeItem"><s:text name="cpCompilazApe.fpTspApeSopralluogo.label" /></span></li>
		</s:if>
		<s:else>
			<li class="item-2">

	<csiuicore:ajaxify id="p_tspApe" 
		widgetType="button" 
		requestUri="/siceeweb/base/compilazattestatiape/cpCompilazApe!handle_CpCompilazApe_TspApe_FpTspApeSopralluogo_CLICKED.do" 
		pageId="cpCompilazApe" 
		formName="cpCompilazApe"
		javascriptDetection="false">
				<s:submit name="tsApe"
				          id="tsApe_fpTspApeSopralluogo"
				          method="handle_CpCompilazApe_TspApe_FpTspApeSopralluogo_CLICKED"
				          title="Sopralluogo"
				          key="cpCompilazApe.fpTspApeSopralluogo.label" />
					
	</csiuicore:ajaxify>
			</li>
		</s:else>
	</ul>
</div>


	
		

		
<s:if test="#session.cpCompilazApe_tspApe_selectedMultiPanel == 'cpCompilazApe_tspApe_fpTspApeDatiGen' || #session.cpCompilazApe_tspApe_selectedMultiPanel == null">
	<s:include value="/jsp/tabs/cpCompilazApe_tspApe_fpTspApeDatiGen.jsp" ></s:include>
</s:if>
		

		
<s:if test="#session.cpCompilazApe_tspApe_selectedMultiPanel == 'cpCompilazApe_tspApe_fpTspApeSopralluogo'">
	<s:include value="/jsp/tabs/cpCompilazApe_tspApe_fpTspApeSopralluogo.jsp" ></s:include>
</s:if>
	<!-- endFragment:p_tspApe --></div>
	</div>

			
	
	<div id="p_cpCompilazApe" class="commandPanelBlock"><!-- startFragment:p_cpCompilazApe -->
	
	
<div class="commandPanel functional" id="cpCompilazApe">

	
	
		

	
	
	
	

	
	
	
	

	
	
	
	<div class="button right">
		
<s:if test="isWidgetVisible('cpCompilazApe','bInviaApe')" >

	



<!-- widget bInviaApe -->
<s:submit name="widg_bInviaApe" id="widg_bInviaApe" method="handleBInviaApe_CLICKED"
	key="cpCompilazApe.bInviaApe.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpCompilazApe','bInviaApe')" />

	


</s:if>

	


		
<s:if test="isWidgetVisible('cpCompilazApe','bConsolidaApe')" >

	



<!-- widget bConsolidaApe -->
<s:submit name="widg_bConsolidaApe" id="widg_bConsolidaApe" method="handleBConsolidaApe_CLICKED"
	key="cpCompilazApe.bConsolidaApe.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpCompilazApe','bConsolidaApe')" />

	


</s:if>

	


		
<s:if test="isWidgetVisible('cpCompilazApe','bCompModApe')" >

	



<!-- widget bCompModApe -->
<s:submit name="widg_bCompModApe" id="widg_bCompModApe" method="handleBCompModApe_CLICKED"
	key="cpCompilazApe.bCompModApe.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpCompilazApe','bCompModApe')" />

	


</s:if>

	


		
<s:if test="isWidgetVisible('cpCompilazApe','bViasualizzaApe')" >

	



<!-- widget bViasualizzaApe -->
<s:submit name="widg_bViasualizzaApe" id="widg_bViasualizzaApe" method="handleBViasualizzaApe_CLICKED"
	key="cpCompilazApe.bViasualizzaApe.label" cssClass="buttonWidget showReport"
	disabled="isWidgetDisabled('cpCompilazApe','bViasualizzaApe')" />

	


</s:if>

	


		
<s:if test="isWidgetVisible('cpCompilazApe','bVerificaApe')" >

	



<!-- widget bVerificaApe -->
<s:submit name="widg_bVerificaApe" id="widg_bVerificaApe" method="handleBVerificaApe_CLICKED"
	key="cpCompilazApe.bVerificaApe.label" cssClass="buttonWidget showReport"
	disabled="isWidgetDisabled('cpCompilazApe','bVerificaApe')" />

	


</s:if>

	


	</div>
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_cpCompilazApe --></div>

			
	
	<div id="p_cpNavCompilazApe" class="commandPanelBlock"><!-- startFragment:p_cpNavCompilazApe -->
	
	
<div class="commandPanel navigation" id="cpNavCompilazApe">

	
	
		

	
	
	
	<div class="button left">
		
<s:if test="isWidgetVisible('cpCompilazApe','bIndietro')" >

	



<!-- widget bIndietro -->
<s:submit name="widg_bIndietro" id="widg_bIndietro" method="handleBIndietro_CLICKED"
	key="cpCompilazApe.bIndietro.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpCompilazApe','bIndietro')" />

	


</s:if>

	


	</div>
	
	

	
	
	
	

	
	
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_cpNavCompilazApe --></div>

	

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
