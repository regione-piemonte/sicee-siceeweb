<%@taglib uri="/struts-tags" prefix="s" %>
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="/customtag" prefix="customtag" %>
<%@taglib uri="/csiuicore" prefix="csiuicore" %>

	
	<div id="p_pDatiClEnerg" class="formPanelBlock"><!-- startFragment:p_pDatiClEnerg -->
		
	


	
	

	
	
			
	
	
	<div class="wizardPanelContent">
	<div id="p_pWizClEnerg" class="wizardPanelBlock"><!-- startFragment:p_pWizClEnerg -->
	
	
<div class="wizardPanel" id="pWizClEnerg">
	<ol>
		<s:url id="cpCompilaz_pWizClEnerg_pDatiLocReale_URL" action="cpCompilaz" namespace="/base/compilazattestati" method="handleChangeTab" includeParams="get">
			<s:param name="selectedTabKey" value="%{'cpCompilaz_pWizClEnerg_selectedMultiPanel'}" />
			<s:param name="selectedTabValue" value="%{'cpCompilaz_pWizClEnerg_pDatiLocReale'}" />
		</s:url>
		<s:if test="%{#session.cpCompilaz_pWizClEnerg_selectedMultiPanel == 'cpCompilaz_pWizClEnerg_pDatiLocReale' || #session.cpCompilaz_pWizClEnerg_selectedMultiPanel == null}">
	<li class="item-1 active"><span class="activeItem">4.1. <s:text name="cpCompilaz.pDatiLocReale.label" /></span><span class="separator"> | </span></li>
		</s:if>
		<s:else>
				
	<li class="item-1"><span class="wizardItem">4.1. <s:text name="cpCompilaz.pDatiLocReale.label" /></span><span class="separator"> | </span></li>
		</s:else>
		<s:url id="cpCompilaz_pWizClEnerg_pDatiLocTeorica_URL" action="cpCompilaz" namespace="/base/compilazattestati" method="handleChangeTab" includeParams="get">
			<s:param name="selectedTabKey" value="%{'cpCompilaz_pWizClEnerg_selectedMultiPanel'}" />
			<s:param name="selectedTabValue" value="%{'cpCompilaz_pWizClEnerg_pDatiLocTeorica'}" />
		</s:url>
		<s:if test="%{#session.cpCompilaz_pWizClEnerg_selectedMultiPanel == 'cpCompilaz_pWizClEnerg_pDatiLocTeorica'}">
	<li class="item-2 active"><span class="activeItem">4.2. <s:text name="cpCompilaz.pDatiLocTeorica.label" /></span><span class="separator"> | </span></li>
		</s:if>
		<s:else>
				
	<li class="item-2"><span class="wizardItem">4.2. <s:text name="cpCompilaz.pDatiLocTeorica.label" /></span><span class="separator"> | </span></li>
		</s:else>
	</ol>
</div>


	
		

		
<s:if test="#session.cpCompilaz_pWizClEnerg_selectedMultiPanel == 'cpCompilaz_pWizClEnerg_pDatiLocReale' || #session.cpCompilaz_pWizClEnerg_selectedMultiPanel == null">
	<s:include value="/jsp/wizardpanels/cpCompilaz_pWizClEnerg_pDatiLocReale.jsp" ></s:include>
</s:if>
		

		
<s:if test="#session.cpCompilaz_pWizClEnerg_selectedMultiPanel == 'cpCompilaz_pWizClEnerg_pDatiLocTeorica'">
	<s:include value="/jsp/wizardpanels/cpCompilaz_pWizClEnerg_pDatiLocTeorica.jsp" ></s:include>
</s:if>
	<!-- endFragment:p_pWizClEnerg --></div>
	</div>

	

		
	

	<!-- endFragment:p_pDatiClEnerg --></div>
