<%@taglib uri="/struts-tags" prefix="s" %>
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="/customtag" prefix="customtag" %>
<%@taglib uri="/csiuicore" prefix="csiuicore" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<fmt:setBundle basename="/it/csi/sicee/siceeweb/presentation/siceeweb/action/main/CpVisuraCITAction" />

	
	<div id="p_fpDettImpianto" class="formPanelBlock"><!-- startFragment:p_fpDettImpianto -->
		
	
<div class="formPanel" id="fpDettImpianto">


	
	

	
	
			
	
	<div id="p_wpDettImpianto" class="widgetsPanelBlock"><!-- startFragment:p_wpDettImpianto -->
	
	

<div class="widgetsPanel" id="wpDettImpianto">
	
	<customtag:widgetsPanel id="wpDettImpiantoTbl" columns="2" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('cpVisuraCIT','ptCodImp')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpVisuraCIT.ptCodImp.label')}" labelFor="widg_ptCodImp" errorFor="appDatavisuraImpianto.codiceImpianto" labelId="ptCodImpLbl"   tdStyleClass="numbers">


<!-- widget ptCodImp -->
<s:property value="appDatavisuraImpianto.codiceImpianto" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpVisuraCIT','ptDescStato')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpVisuraCIT.ptDescStato.label')}" labelFor="widg_ptDescStato" errorFor="appDatavisuraImpianto.descStato" labelId="ptDescStatoLbl"   >


<!-- widget ptDescStato -->
<s:property value="appDatavisuraImpianto.descStato" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpVisuraCIT','ptDtAssegnazione')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpVisuraCIT.ptDtAssegnazione.label')}" labelFor="widg_ptDtAssegnazione" errorFor="appDatavisuraImpianto.dtAssegnazione" labelId="ptDtAssegnazioneLbl"   >


<!-- widget ptDtAssegnazione -->
<s:property value="appDatavisuraImpianto.dtAssegnazione" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpVisuraCIT','ptDtDismissione')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpVisuraCIT.ptDtDismissione.label')}" labelFor="widg_ptDtDismissione" errorFor="appDatavisuraImpianto.dtDismissione" labelId="ptDtDismissioneLbl"   >


<!-- widget ptDtDismissione -->
<s:property value="appDatavisuraImpianto.dtDismissione" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpVisuraCIT','ptMotivoDisimissione')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpVisuraCIT.ptMotivoDisimissione.label')}" labelFor="widg_ptMotivoDisimissione" errorFor="appDatavisuraImpianto.motivoDisimissione" labelId="ptMotivoDisimissioneLbl"   >


<!-- widget ptMotivoDisimissione -->
<s:property value="appDatavisuraImpianto.motivoDisimissione" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpVisuraCIT','ptUbicazione')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpVisuraCIT.ptUbicazione.label')}" labelFor="widg_ptUbicazione" errorFor="appDatavisuraImpianto.ubicazione" labelId="ptUbicazioneLbl"   >


<!-- widget ptUbicazione -->
<s:property value="appDatavisuraImpianto.ubicazione" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpVisuraCIT','ptResponsabile')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpVisuraCIT.ptResponsabile.label')}" labelFor="widg_ptResponsabile" errorFor="appDatavisuraImpianto.identResponsabile" labelId="ptResponsabileLbl"   >


<!-- widget ptResponsabile -->
<s:property value="appDatavisuraImpianto.identResponsabile" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpVisuraCIT','pt3responsabile')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpVisuraCIT.pt3responsabile.label')}" labelFor="widg_pt3responsabile" errorFor="appDatavisuraImpianto.ident3Responsabile" labelId="pt3responsabileLbl"   >


<!-- widget pt3responsabile -->
<s:property value="appDatavisuraImpianto.ident3Responsabile" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpVisuraCIT','ptDtUltAggLibretto')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpVisuraCIT.ptDtUltAggLibretto.label')}" labelFor="widg_ptDtUltAggLibretto" errorFor="appDatavisuraImpianto.dtUltAggLibretto" labelId="ptDtUltAggLibrettoLbl"   >


<!-- widget ptDtUltAggLibretto -->
<s:property value="appDatavisuraImpianto.dtUltAggLibretto" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_wpDettImpianto --></div>

			
	
	<div id="p_wpRifCatastale" class="widgetsPanelBlock"><!-- startFragment:p_wpRifCatastale -->
	
	
<h4 class="wpLabel">Riferimenti catastali </h4>
<div class="widgetsPanel" id="wpRifCatastale">
	

	
	
<s:if test="isWidgetVisible('cpVisuraCIT','tbDatiCatastali')" >

	
<div class="tableWidget">


<!-- widget tbDatiCatastali -->
	<csiuicore:ajaxify id="p_wpRifCatastale" 
		widgetType="table"		
		pageId="cpVisuraCIT"
		javascriptDetection="false">
<s:set name="cpVisuraCIT_tbDatiCatastali_clearStatus" value="isTableClearStatus('cpVisuraCIT_tbDatiCatastali')" />
<s:url id="cpVisuraCITViewUrl"						   
					   action="cpVisuraCIT"
					   namespace="/base/main"/>
<display:table name="appDatavisuraRifCatastaleList"  				
			   excludedParams="*"			   export="false"
               id="widg_tbDatiCatastali"
               pagesize="0"
               keepStatus="true"
               requestURI="${cpVisuraCITViewUrl}"  
               clearStatus="${cpVisuraCIT_tbDatiCatastali_clearStatus}"
               uid="row_tbDatiCatastali"
               summary="" 
               class="dataTable">
	
		<display:column property="sezione" titleKey="cpVisuraCIT.tbDatiCatastali.sezione.label" 
			sortable="false" headerClass="nosort"
			    media="html"
			
 >
			
		</display:column>
		<display:column property="foglio" titleKey="cpVisuraCIT.tbDatiCatastali.foglio.label" 
			sortable="false" headerClass="nosort"
			    media="html"
			
 >
			
		</display:column>
		<display:column property="particella" titleKey="cpVisuraCIT.tbDatiCatastali.particella.label" 
			sortable="false" headerClass="nosort"
			    media="html"
			
 >
			
		</display:column>
		<display:column property="subalterno" titleKey="cpVisuraCIT.tbDatiCatastali.subalterno.label" 
			sortable="false" headerClass="nosort"
			    media="html"
			
 >
			
		</display:column>
		<display:column property="pod" titleKey="cpVisuraCIT.tbDatiCatastali.pod.label" 
			sortable="false" headerClass="nosort"
			    media="html"
			
 >
			
		</display:column>
		<display:column property="pdr" titleKey="cpVisuraCIT.tbDatiCatastali.pdr.label" 
			sortable="false" headerClass="nosort"
			    media="html"
			
 >
			
		</display:column>
</display:table>



	</csiuicore:ajaxify>


	
</div>

</s:if>

	



	
	
	
</div>

	<!-- endFragment:p_wpRifCatastale --></div>

			
	
	<div id="p_wpRappControllo" class="widgetsPanelBlock"><!-- startFragment:p_wpRappControllo -->
	
	
<h4 class="wpLabel">Rapporti di efficienza energetica </h4>
<div class="widgetsPanel" id="wpRappControllo">
	

	
	
<s:if test="isWidgetVisible('cpVisuraCIT','tbRappControllo')" >

	
<div class="tableWidget">


<!-- widget tbRappControllo -->
	<csiuicore:ajaxify id="p_wpRappControllo" 
		widgetType="table"		
		pageId="cpVisuraCIT"
		javascriptDetection="false">
<s:set name="cpVisuraCIT_tbRappControllo_clearStatus" value="isTableClearStatus('cpVisuraCIT_tbRappControllo')" />
<s:url id="cpVisuraCITViewUrl"						   
					   action="cpVisuraCIT"
					   namespace="/base/main"/>
<display:table name="appDatavisuraRappControlloList"  				
			   excludedParams="*"			   export="false"
               id="widg_tbRappControllo"
               pagesize="0"
               keepStatus="true"
               requestURI="${cpVisuraCITViewUrl}"  
               clearStatus="${cpVisuraCIT_tbRappControllo_clearStatus}"
               uid="row_tbRappControllo"
               summary="" 
               class="dataTable">
	
		<display:column property="descTipoDoc" titleKey="cpVisuraCIT.tbRappControllo.descTipoDoc.label" 
			sortable="false" headerClass="nosort"
			    media="html"
			
 >
			
		</display:column>
		<display:column property="bollino" titleKey="cpVisuraCIT.tbRappControllo.bollino.label" 
			sortable="false" headerClass="nosort"
			    media="html"
			
 >
			
		</display:column>
		<display:column property="dtControllo" titleKey="cpVisuraCIT.tbRappControllo.dtControllo.label" 
			sortable="false" headerClass="nosort"
			    media="html"
			
 >
			
		</display:column>
		<display:column property="apparecchiature" titleKey="cpVisuraCIT.tbRappControllo.apparecchiature.label" 
			sortable="false" headerClass="nosort"
			    media="html"
			
 >
			
		</display:column>
</display:table>



	</csiuicore:ajaxify>


	
</div>

</s:if>

	



	
	
	
</div>

	<!-- endFragment:p_wpRappControllo --></div>

			
	
	<div id="p_cpDettImpCom" class="commandPanelBlock"><!-- startFragment:p_cpDettImpCom -->
	
	
<div class="commandPanel functional" id="cpDettImpCom">

	
	
		

	
	
	
	<div class="button left">
		
<s:if test="isWidgetVisible('cpVisuraCIT','bApriLibretto')" >

	



<!-- widget bApriLibretto -->
<s:submit name="widg_bApriLibretto" id="widg_bApriLibretto" method="handleBApriLibretto_CLICKED"
	key="cpVisuraCIT.bApriLibretto.label" cssClass="buttonWidget showReport"
	disabled="isWidgetDisabled('cpVisuraCIT','bApriLibretto')" />

	


</s:if>

	


	</div>
	
	

	
	
	
	

	
	
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_cpDettImpCom --></div>

	

		
	
</div>

	<!-- endFragment:p_fpDettImpianto --></div>
