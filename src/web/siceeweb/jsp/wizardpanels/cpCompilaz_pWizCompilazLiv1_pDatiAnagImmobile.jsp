<%@taglib uri="/struts-tags" prefix="s" %>
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="/customtag" prefix="customtag" %>
<%@taglib uri="/csiuicore" prefix="csiuicore" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<fmt:setBundle basename="/it/csi/sicee/siceeweb/presentation/siceeweb/action/compilazattestati/CpCompilazAction" />

	
	<div id="p_pDatiAnagImmobile" class="formPanelBlock"><!-- startFragment:p_pDatiAnagImmobile -->
		
	


	
	

	
	
			
	
	
	<div class="wizardPanelContent">
	<div id="p_pWizAnagImmobile" class="wizardPanelBlock"><!-- startFragment:p_pWizAnagImmobile -->
	
	
<div class="wizardPanel" id="pWizAnagImmobile">
	<ol>
		<s:url id="cpCompilaz_pWizAnagImmobile_pDatiCatastali_URL" action="cpCompilaz" namespace="/base/compilazattestati" method="handleChangeTab" includeParams="get">
			<s:param name="selectedTabKey" value="%{'cpCompilaz_pWizAnagImmobile_selectedMultiPanel'}" />
			<s:param name="selectedTabValue" value="%{'cpCompilaz_pWizAnagImmobile_pDatiCatastali'}" />
		</s:url>
		<s:if test="%{#session.cpCompilaz_pWizAnagImmobile_selectedMultiPanel == 'cpCompilaz_pWizAnagImmobile_pDatiCatastali' || #session.cpCompilaz_pWizAnagImmobile_selectedMultiPanel == null}">
	<li class="item-1 active"><span class="activeItem">1.1. <s:text name="cpCompilaz.pDatiCatastali.label" /></span><span class="separator"> | </span></li>
		</s:if>
		<s:else>
				
	<li class="item-1"><span class="wizardItem">1.1. <s:text name="cpCompilaz.pDatiCatastali.label" /></span><span class="separator"> | </span></li>
		</s:else>
		<s:url id="cpCompilaz_pWizAnagImmobile_pDatiResponsabili_URL" action="cpCompilaz" namespace="/base/compilazattestati" method="handleChangeTab" includeParams="get">
			<s:param name="selectedTabKey" value="%{'cpCompilaz_pWizAnagImmobile_selectedMultiPanel'}" />
			<s:param name="selectedTabValue" value="%{'cpCompilaz_pWizAnagImmobile_pDatiResponsabili'}" />
		</s:url>
		<s:if test="%{#session.cpCompilaz_pWizAnagImmobile_selectedMultiPanel == 'cpCompilaz_pWizAnagImmobile_pDatiResponsabili'}">
	<li class="item-2 active"><span class="activeItem">1.2. <s:text name="cpCompilaz.pDatiResponsabili.label" /></span><span class="separator"> | </span></li>
		</s:if>
		<s:else>
				
	<li class="item-2"><span class="wizardItem">1.2. <s:text name="cpCompilaz.pDatiResponsabili.label" /></span><span class="separator"> | </span></li>
		</s:else>
		<s:url id="cpCompilaz_pWizAnagImmobile_pDatiCoCertificatore_URL" action="cpCompilaz" namespace="/base/compilazattestati" method="handleChangeTab" includeParams="get">
			<s:param name="selectedTabKey" value="%{'cpCompilaz_pWizAnagImmobile_selectedMultiPanel'}" />
			<s:param name="selectedTabValue" value="%{'cpCompilaz_pWizAnagImmobile_pDatiCoCertificatore'}" />
		</s:url>
		<s:if test="%{#session.cpCompilaz_pWizAnagImmobile_selectedMultiPanel == 'cpCompilaz_pWizAnagImmobile_pDatiCoCertificatore'}">
	<li class="item-3 active"><span class="activeItem">1.3. <s:text name="cpCompilaz.pDatiCoCertificatore.label" /></span><span class="separator"> | </span></li>
		</s:if>
		<s:else>
				
	<li class="item-3"><span class="wizardItem">1.3. <s:text name="cpCompilaz.pDatiCoCertificatore.label" /></span><span class="separator"> | </span></li>
		</s:else>
	</ol>
</div>


	
		

		
<s:if test="#session.cpCompilaz_pWizAnagImmobile_selectedMultiPanel == 'cpCompilaz_pWizAnagImmobile_pDatiCatastali' || #session.cpCompilaz_pWizAnagImmobile_selectedMultiPanel == null">
	<s:include value="/jsp/wizardpanels/cpCompilaz_pWizAnagImmobile_pDatiCatastali.jsp" ></s:include>
</s:if>
		

		
<s:if test="#session.cpCompilaz_pWizAnagImmobile_selectedMultiPanel == 'cpCompilaz_pWizAnagImmobile_pDatiResponsabili'">
	<s:include value="/jsp/wizardpanels/cpCompilaz_pWizAnagImmobile_pDatiResponsabili.jsp" ></s:include>
</s:if>
		

		
<s:if test="#session.cpCompilaz_pWizAnagImmobile_selectedMultiPanel == 'cpCompilaz_pWizAnagImmobile_pDatiCoCertificatore'">
	<s:include value="/jsp/wizardpanels/cpCompilaz_pWizAnagImmobile_pDatiCoCertificatore.jsp" ></s:include>
</s:if>
	<!-- endFragment:p_pWizAnagImmobile --></div>
	</div>

	

		
	

	<!-- endFragment:p_pDatiAnagImmobile --></div>
