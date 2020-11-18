<%@taglib uri="/struts-tags" prefix="s" %>
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="/customtag" prefix="customtag" %>
<%@taglib uri="/csiuicore" prefix="csiuicore" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<fmt:setBundle basename="/it/csi/sicee/siceeweb/presentation/siceeweb/action/compilazattestati/CpCompilazAction" />

	
	<div id="p_pDatiDichiaraz" class="formPanelBlock"><!-- startFragment:p_pDatiDichiaraz -->
		
	
<div class="formPanel" id="pDatiDichiaraz">


	
	

	
	
			
	
	<div id="p_pErrDtDichiaraz" class="stdMessagePanelBlock"><!-- startFragment:p_pErrDtDichiaraz -->
	
	
<div class="stdMessagePanel" id="pErrDtDichiaraz">
	<customtag:stdMessagePanel id="pErrDtDichiaraz" errorMessage="true" errorDetails="false" actionMessage="true" />
</div>

	<!-- endFragment:p_pErrDtDichiaraz --></div>

			
	
	<div id="p_pLabel" class="widgetsPanelBlock"><!-- startFragment:p_pLabel -->
	
	

<div class="widgetsPanel" id="pLabel">
	
	<customtag:widgetsPanel id="pLabelTbl" columns="2" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('cpCompilaz','txtObblDtDichiarazioni')" >

	
<customtag:widgetsPanelColumn  colSpan="2"  >


<!-- widget txtObblDtDichiarazioni -->
<s:text name="cpCompilaz.txtObblDtDichiarazioni.statictext.label" />

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpCompilaz','txtHeadDichiarazioni')" >

	
<customtag:widgetsPanelColumn  colSpan="2"  >


<!-- widget txtHeadDichiarazioni -->
<s:text name="cpCompilaz.txtHeadDichiarazioni.statictext.label" />

	
</customtag:widgetsPanelColumn>

</s:if>

	



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_pLabel --></div>

			
	
	<div id="p_pDtDichiarazioni" class="widgetsPanelBlock"><!-- startFragment:p_pDtDichiarazioni -->
	
	

<div class="widgetsPanel" id="pDtDichiarazioni">
	

	
	
<s:if test="isWidgetVisible('cpCompilaz','tblDichiarazioni')" >

	
<div class="tableWidget">


<!-- widget tblDichiarazioni -->
<s:set name="cpCompilaz_tblDichiarazioni_clearStatus" value="isTableClearStatus('cpCompilaz_tblDichiarazioni')" />
<s:url id="cpCompilazViewUrl"						   
					   action="cpCompilaz"
					   namespace="/base/compilazattestati"/>
<display:table name="appDatadichiarazioni"  				
			   excludedParams="*"			   export="false"
               id="widg_tblDichiarazioni"
               pagesize="0"
               keepStatus="true"
               requestURI="${cpCompilazViewUrl}"  
               clearStatus="${cpCompilaz_tblDichiarazioni_clearStatus}"
               uid="row_tblDichiarazioni"
               summary="" 
               class="dataTable">
	
		<display:column headerClass="nosort" media="html">
			<s:radio list="%{#attr.row_tblDichiarazioni.cod}" name="appDatatempDichiarazSelez" id="%{'tblDichiarazioni-editcell-'+ (#attr.row_tblDichiarazioni_rowNum - 1)}" cssClass="radio"
			/>
		</display:column>
		<display:column property="descr" titleKey="cpCompilaz.tblDichiarazioni.descr.label" 
			sortable="false" headerClass="nosort"
			    media="html"
			
 >
			
		</display:column>
</display:table>





	
</div>

</s:if>

	



	
	
	
</div>

	<!-- endFragment:p_pDtDichiarazioni --></div>

			
	
	<div id="p_pLuogo" class="widgetsPanelBlock"><!-- startFragment:p_pLuogo -->
	
	

<div class="widgetsPanel" id="pLuogo">
	
	<customtag:widgetsPanel id="pLuogoTbl" columns="2" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('cpCompilaz','calDataDichiarazione')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpCompilaz.calDataDichiarazione.label')}" labelFor="widg_calDataDichiarazione" errorFor="appDatacertificato.dichiarazioni.dataDichiarazione" labelId="calDataDichiarazioneLbl"
	  >


<!-- widget calDataDichiarazione -->
<s:textfield 
	
	
	name="appDatacertificato.dichiarazioni.dataDichiarazione" id="widg_calDataDichiarazione"
	disabled="isWidgetDisabled('cpCompilaz','calDataDichiarazione')"
	size="10" maxlength="10" 
	cssClass="calendar"
/> <div class="infoCalendar"></div>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpCompilaz','tfLuogoDichiarazione')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpCompilaz.tfLuogoDichiarazione.label')}" labelFor="widg_tfLuogoDichiarazione" errorFor="appDatacertificato.dichiarazioni.luogoDichiarazione" labelId="tfLuogoDichiarazioneLbl"
	  >


<!-- widget tfLuogoDichiarazione -->
<s:textfield 
	
	
	name="appDatacertificato.dichiarazioni.luogoDichiarazione" id="widg_tfLuogoDichiarazione"
maxlength="100"	disabled="isWidgetDisabled('cpCompilaz','tfLuogoDichiarazione')"
	size="15" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_pLuogo --></div>

			
	
	<div id="p_pDtDichiarazNav" class="commandPanelBlock"><!-- startFragment:p_pDtDichiarazNav -->
	
	
<div class="commandPanel navigation" id="pDtDichiarazNav">

	
	
		

	
	
	
	<div class="button left">
		
<s:if test="isWidgetVisible('cpCompilaz','bDtDichiarazIndietro')" >

	



<!-- widget bDtDichiarazIndietro -->
	<csiuicore:ajaxify id="p_pWizCompilazLiv1" 
		widgetType="button"
		 
		requestUri="/siceeweb/base/compilazattestati/cpCompilaz!handleBDtDichiarazIndietro_CLICKED.do" 
		
		pageId="cpCompilaz" 
		formName="cpCompilaz"
		javascriptDetection="false">
<s:submit name="widg_bDtDichiarazIndietro" id="widg_bDtDichiarazIndietro" method="handleBDtDichiarazIndietro_CLICKED"
	key="cpCompilaz.bDtDichiarazIndietro.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpCompilaz','bDtDichiarazIndietro')" />

	</csiuicore:ajaxify>

	


</s:if>

	


	</div>
	
	

	
	
	
	

	
	
	
	<div class="button right">
		
<s:if test="isWidgetVisible('cpCompilaz','bDtDichiarazAvanti')" >

	



<!-- widget bDtDichiarazAvanti -->
	<csiuicore:ajaxify id="p_pWizCompilazLiv1" 
		widgetType="button"
		 
		requestUri="/siceeweb/base/compilazattestati/cpCompilaz!handleBDtDichiarazAvanti_CLICKED.do" 
		
		pageId="cpCompilaz" 
		formName="cpCompilaz"
		javascriptDetection="false">
<s:submit name="widg_bDtDichiarazAvanti" id="widg_bDtDichiarazAvanti" method="handleBDtDichiarazAvanti_CLICKED"
	key="cpCompilaz.bDtDichiarazAvanti.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpCompilaz','bDtDichiarazAvanti')" />

	</csiuicore:ajaxify>

	


</s:if>

	


	</div>
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_pDtDichiarazNav --></div>

	

		
	
</div>

	<!-- endFragment:p_pDatiDichiaraz --></div>
