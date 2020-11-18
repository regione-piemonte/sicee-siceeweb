<%@taglib uri="/struts-tags" prefix="s" %>
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="/customtag" prefix="customtag" %>
<%@taglib uri="/csiuicore" prefix="csiuicore" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<fmt:setBundle basename="/it/csi/sicee/siceeweb/presentation/siceeweb/action/compilazattestati/CpCompilazAction" />

	
	<div id="p_pDatiAltreInfo" class="formPanelBlock"><!-- startFragment:p_pDatiAltreInfo -->
		
	


	
	

	
	
			
	
	
	<div class="wizardPanelContent">
	<div id="p_pWizAltreInfo" class="wizardPanelBlock"><!-- startFragment:p_pWizAltreInfo -->
	
	
<div class="wizardPanel" id="pWizAltreInfo">
	<ol>
		<s:url id="cpCompilaz_pWizAltreInfo_pDatiAltriGenerali_URL" action="cpCompilaz" namespace="/base/compilazattestati" method="handleChangeTab" includeParams="get">
			<s:param name="selectedTabKey" value="%{'cpCompilaz_pWizAltreInfo_selectedMultiPanel'}" />
			<s:param name="selectedTabValue" value="%{'cpCompilaz_pWizAltreInfo_pDatiAltriGenerali'}" />
		</s:url>
		<s:if test="%{#session.cpCompilaz_pWizAltreInfo_selectedMultiPanel == 'cpCompilaz_pWizAltreInfo_pDatiAltriGenerali' || #session.cpCompilaz_pWizAltreInfo_selectedMultiPanel == null}">
	<li class="item-1 active"><span class="activeItem">6.1. <s:text name="cpCompilaz.pDatiAltriGenerali.label" /></span><span class="separator"> | </span></li>
		</s:if>
		<s:else>
				
	<li class="item-1"><span class="wizardItem">6.1. <s:text name="cpCompilaz.pDatiAltriGenerali.label" /></span><span class="separator"> | </span></li>
		</s:else>
		<s:url id="cpCompilaz_pWizAltreInfo_pDatiAltriRaccomand_URL" action="cpCompilaz" namespace="/base/compilazattestati" method="handleChangeTab" includeParams="get">
			<s:param name="selectedTabKey" value="%{'cpCompilaz_pWizAltreInfo_selectedMultiPanel'}" />
			<s:param name="selectedTabValue" value="%{'cpCompilaz_pWizAltreInfo_pDatiAltriRaccomand'}" />
		</s:url>
		<s:if test="%{#session.cpCompilaz_pWizAltreInfo_selectedMultiPanel == 'cpCompilaz_pWizAltreInfo_pDatiAltriRaccomand'}">
	<li class="item-2 active"><span class="activeItem">6.2. <s:text name="cpCompilaz.pDatiAltriRaccomand.label" /></span><span class="separator"> | </span></li>
		</s:if>
		<s:else>
				
	<li class="item-2"><span class="wizardItem">6.2. <s:text name="cpCompilaz.pDatiAltriRaccomand.label" /></span><span class="separator"> | </span></li>
		</s:else>
		<s:url id="cpCompilaz_pWizAltreInfo_pDatiAltriEnerg_URL" action="cpCompilaz" namespace="/base/compilazattestati" method="handleChangeTab" includeParams="get">
			<s:param name="selectedTabKey" value="%{'cpCompilaz_pWizAltreInfo_selectedMultiPanel'}" />
			<s:param name="selectedTabValue" value="%{'cpCompilaz_pWizAltreInfo_pDatiAltriEnerg'}" />
		</s:url>
		<s:if test="%{#session.cpCompilaz_pWizAltreInfo_selectedMultiPanel == 'cpCompilaz_pWizAltreInfo_pDatiAltriEnerg'}">
	<li class="item-3 active"><span class="activeItem">6.3. <s:text name="cpCompilaz.pDatiAltriEnerg.label" /></span><span class="separator"> | </span></li>
		</s:if>
		<s:else>
				
	<li class="item-3"><span class="wizardItem">6.3. <s:text name="cpCompilaz.pDatiAltriEnerg.label" /></span><span class="separator"> | </span></li>
		</s:else>
		<s:url id="cpCompilaz_pWizAltreInfo_pDatiAltriSopralluoghi_URL" action="cpCompilaz" namespace="/base/compilazattestati" method="handleChangeTab" includeParams="get">
			<s:param name="selectedTabKey" value="%{'cpCompilaz_pWizAltreInfo_selectedMultiPanel'}" />
			<s:param name="selectedTabValue" value="%{'cpCompilaz_pWizAltreInfo_pDatiAltriSopralluoghi'}" />
		</s:url>
		<s:if test="%{#session.cpCompilaz_pWizAltreInfo_selectedMultiPanel == 'cpCompilaz_pWizAltreInfo_pDatiAltriSopralluoghi'}">
	<li class="item-4 active"><span class="activeItem">6.4. <s:text name="cpCompilaz.pDatiAltriSopralluoghi.label" /></span><span class="separator"> | </span></li>
		</s:if>
		<s:else>
				
	<li class="item-4"><span class="wizardItem">6.4. <s:text name="cpCompilaz.pDatiAltriSopralluoghi.label" /></span><span class="separator"> | </span></li>
		</s:else>
	</ol>
</div>


	
		

		
<s:if test="#session.cpCompilaz_pWizAltreInfo_selectedMultiPanel == 'cpCompilaz_pWizAltreInfo_pDatiAltriGenerali' || #session.cpCompilaz_pWizAltreInfo_selectedMultiPanel == null">
	<s:include value="/jsp/wizardpanels/cpCompilaz_pWizAltreInfo_pDatiAltriGenerali.jsp" ></s:include>
</s:if>
		

		
<s:if test="#session.cpCompilaz_pWizAltreInfo_selectedMultiPanel == 'cpCompilaz_pWizAltreInfo_pDatiAltriRaccomand'">
	<s:include value="/jsp/wizardpanels/cpCompilaz_pWizAltreInfo_pDatiAltriRaccomand.jsp" ></s:include>
</s:if>
		

		
<s:if test="#session.cpCompilaz_pWizAltreInfo_selectedMultiPanel == 'cpCompilaz_pWizAltreInfo_pDatiAltriEnerg'">
	<s:include value="/jsp/wizardpanels/cpCompilaz_pWizAltreInfo_pDatiAltriEnerg.jsp" ></s:include>
</s:if>
		

		
<s:if test="#session.cpCompilaz_pWizAltreInfo_selectedMultiPanel == 'cpCompilaz_pWizAltreInfo_pDatiAltriSopralluoghi'">
	<s:include value="/jsp/wizardpanels/cpCompilaz_pWizAltreInfo_pDatiAltriSopralluoghi.jsp" ></s:include>
</s:if>
	<!-- endFragment:p_pWizAltreInfo --></div>
	</div>

	

		
	

	<!-- endFragment:p_pDatiAltreInfo --></div>
