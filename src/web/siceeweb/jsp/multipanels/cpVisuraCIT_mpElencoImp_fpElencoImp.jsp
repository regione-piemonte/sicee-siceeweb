<%@taglib uri="/struts-tags" prefix="s" %>
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="/customtag" prefix="customtag" %>
<%@taglib uri="/csiuicore" prefix="csiuicore" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<fmt:setBundle basename="/it/csi/sicee/siceeweb/presentation/siceeweb/action/main/CpVisuraCITAction" />

	
	<div id="p_fpElencoImp" class="formPanelBlock"><!-- startFragment:p_fpElencoImp -->
		
	
<div class="formPanel" id="fpElencoImp">


	
	

	
	
			
	
	<div id="p_wpElencoImp" class="widgetsPanelBlock"><!-- startFragment:p_wpElencoImp -->
	
	
<h4 class="wpLabel">Elenco impianti trovati </h4>
<div class="widgetsPanel" id="wpElencoImp">
	

	
	
<s:if test="isWidgetVisible('cpVisuraCIT','tbElencoImp')" >

	
<div class="tableWidget">


<!-- widget tbElencoImp -->
	<csiuicore:ajaxify id="p_wpElencoImp" 
		widgetType="table"		
		pageId="cpVisuraCIT"
		javascriptDetection="false">
<s:set name="cpVisuraCIT_tbElencoImp_clearStatus" value="isTableClearStatus('cpVisuraCIT_tbElencoImp')" />
<s:url id="cpVisuraCITViewUrl"						   
					   action="cpVisuraCIT"
					   namespace="/base/main"/>
<display:table name="appDatavisuraImpiantoList"  				
			   excludedParams="*"			   export="false"
               id="widg_tbElencoImp"
               pagesize="10"
               keepStatus="true"
               requestURI="${cpVisuraCITViewUrl}"  
               clearStatus="${cpVisuraCIT_tbElencoImp_clearStatus}"
               uid="row_tbElencoImp"
               summary="" 
               class="dataTable">
	
		<display:column headerClass="nosort" media="html">
			<s:radio list="%{#attr.row_tbElencoImp.idRigaTabella}" name="appDataidRigaSelezionata" id="%{'tbElencoImp-editcell-'+ (#attr.row_tbElencoImp_rowNum - 1)}" cssClass="radio"
			/>
		</display:column>
		<display:column property="codiceImpianto" titleKey="cpVisuraCIT.tbElencoImp.codiceImpianto.label" 
			sortable="false" headerClass="nosort"
			format="{0,number,#,##0}"  class="numbers"  media="html"
			
 >
			
		</display:column>
		<display:column property="ubicazione" titleKey="cpVisuraCIT.tbElencoImp.ubicazione.label" 
			sortable="false" headerClass="nosort"
			    media="html"
			
 >
			
		</display:column>
		<display:column property="identResponsabile" titleKey="cpVisuraCIT.tbElencoImp.identResponsabile.label" 
			sortable="false" headerClass="nosort"
			    media="html"
			
 >
			
		</display:column>
		<display:column property="ident3Responsabile" titleKey="cpVisuraCIT.tbElencoImp.ident3Responsabile.label" 
			sortable="false" headerClass="nosort"
			    media="html"
			
 >
			
		</display:column>
</display:table>



	</csiuicore:ajaxify>


	
</div>

</s:if>

	



	
	
	
</div>

	<!-- endFragment:p_wpElencoImp --></div>

			
	
	<div id="p_wpElencoImpCom" class="widgetsPanelBlock"><!-- startFragment:p_wpElencoImpCom -->
	
	

<div class="widgetsPanel" id="wpElencoImpCom">
	
	<customtag:widgetsPanel id="wpElencoImpComTbl" columns="2" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('cpVisuraCIT','bDettImpianto')" >

	
<customtag:widgetsPanelColumn colSpan="2" >


<!-- widget bDettImpianto -->
<s:submit name="widg_bDettImpianto" id="widg_bDettImpianto" method="handleBDettImpianto_CLICKED"
	key="cpVisuraCIT.bDettImpianto.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpVisuraCIT','bDettImpianto')" />

	
</customtag:widgetsPanelColumn>

</s:if>

	



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_wpElencoImpCom --></div>

	

		
	
</div>

	<!-- endFragment:p_fpElencoImp --></div>
