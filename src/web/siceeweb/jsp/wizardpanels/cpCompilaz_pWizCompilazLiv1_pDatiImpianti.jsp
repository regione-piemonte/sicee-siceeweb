<%@taglib uri="/struts-tags" prefix="s" %>
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="/customtag" prefix="customtag" %>
<%@taglib uri="/csiuicore" prefix="csiuicore" %>

	
	<div id="p_pDatiImpianti" class="formPanelBlock"><!-- startFragment:p_pDatiImpianti -->
		
	


	
	

	
	
			
	
	
	<div class="wizardPanelContent">
	<div id="p_pWizImpianti" class="wizardPanelBlock"><!-- startFragment:p_pWizImpianti -->
	
	
<div class="wizardPanel" id="pWizImpianti">
	<ol>
		<s:url id="cpCompilaz_pWizImpianti_pDatiRiscaldamento_URL" action="cpCompilaz" namespace="/base/compilazattestati" method="handleChangeTab" includeParams="get">
			<s:param name="selectedTabKey" value="%{'cpCompilaz_pWizImpianti_selectedMultiPanel'}" />
			<s:param name="selectedTabValue" value="%{'cpCompilaz_pWizImpianti_pDatiRiscaldamento'}" />
		</s:url>
		<s:if test="%{#session.cpCompilaz_pWizImpianti_selectedMultiPanel == 'cpCompilaz_pWizImpianti_pDatiRiscaldamento' || #session.cpCompilaz_pWizImpianti_selectedMultiPanel == null}">
	<li class="item-1 active"><span class="activeItem">8.1. <s:text name="cpCompilaz.pDatiRiscaldamento.label" /></span><span class="separator"> | </span></li>
		</s:if>
		<s:else>
				
	<li class="item-1"><span class="wizardItem">8.1. <s:text name="cpCompilaz.pDatiRiscaldamento.label" /></span><span class="separator"> | </span></li>
		</s:else>
		<s:url id="cpCompilaz_pWizImpianti_pDatiAcquaCalda_URL" action="cpCompilaz" namespace="/base/compilazattestati" method="handleChangeTab" includeParams="get">
			<s:param name="selectedTabKey" value="%{'cpCompilaz_pWizImpianti_selectedMultiPanel'}" />
			<s:param name="selectedTabValue" value="%{'cpCompilaz_pWizImpianti_pDatiAcquaCalda'}" />
		</s:url>
		<s:if test="%{#session.cpCompilaz_pWizImpianti_selectedMultiPanel == 'cpCompilaz_pWizImpianti_pDatiAcquaCalda'}">
	<li class="item-2 active"><span class="activeItem">8.2. <s:text name="cpCompilaz.pDatiAcquaCalda.label" /></span><span class="separator"> | </span></li>
		</s:if>
		<s:else>
				
	<li class="item-2"><span class="wizardItem">8.2. <s:text name="cpCompilaz.pDatiAcquaCalda.label" /></span><span class="separator"> | </span></li>
		</s:else>
	</ol>
</div>


	
		

		
<s:if test="#session.cpCompilaz_pWizImpianti_selectedMultiPanel == 'cpCompilaz_pWizImpianti_pDatiRiscaldamento' || #session.cpCompilaz_pWizImpianti_selectedMultiPanel == null">
	<s:include value="/jsp/wizardpanels/cpCompilaz_pWizImpianti_pDatiRiscaldamento.jsp" ></s:include>
</s:if>
		

		
<s:if test="#session.cpCompilaz_pWizImpianti_selectedMultiPanel == 'cpCompilaz_pWizImpianti_pDatiAcquaCalda'">
	<s:include value="/jsp/wizardpanels/cpCompilaz_pWizImpianti_pDatiAcquaCalda.jsp" ></s:include>
</s:if>
	<!-- endFragment:p_pWizImpianti --></div>
	</div>

	

		
	

	<!-- endFragment:p_pDatiImpianti --></div>
