<%@taglib uri="/struts-tags" prefix="s" %>
<div id="p_udPreview" class="panelBlock"><!-- startFragment:p_udPreview -->
<div class="userDefinedPanel" id="udPreview">
<!--PROTECTED REGION ID(R-1052513672) ENABLED START-->
<!-- Inserire il codice del pannello -->
	<s:if test="%{appDatacertificato.datiAnagraficiImm.dtCatastali.dtFoto == null && appDatacertificato.datiAnagraficiImm.dtCatastali.nomeFoto == null}">
    	<div>Non ci sono foto da visualizzare</div>
	</s:if>
	<s:else>
		<!-- Alex: per centrare il div aggiungere a style: margin:auto; -->
		<div id="table_container">
		<table class="dataTable" border="1">
			<tr>
				<th class="nosort" width="5%">&nbsp;</th>
				<th class="nosort" width="30%">nome immagine</th>
				<th class="nosort" width="30%">tipo</th>
				<th class="nosort" width="30%">preview<sup>A</sup></th>
				<th class="nosort" width="5%">principale</th>
			</tr>
	</s:else>
	<s:if test="%{appDatacertificato.datiAnagraficiImm.dtCatastali.nomeFoto != null}">
			<tr class="odd">
				<td width="5%"><input type="radio" name="appDatafotoSelezionata" value="<s:property value="appDatacertificato.datiAnagraficiImm.dtCatastali.uidFoto"/>"></td>
				<td width="30%"><b><s:property value="appDatacertificato.datiAnagraficiImm.dtCatastali.nomeFoto"/></b></td>
				<td width="30%"><b><s:property value="appDatacertificato.datiAnagraficiImm.dtCatastali.descTipoFoto"/></b></td>
				<td width="30%"><img class="preview" title="<s:property value="appDatacertificato.datiAnagraficiImm.dtCatastali.nomeFoto"/>" src="data:image/png;base64,<s:property value="appDatacertificato.datiAnagraficiImm.dtCatastali.previewBase64"/>"></td>
				<td width="5%"><b>S</b></td>
			</tr>
	</s:if>
	<s:iterator value="appDatacertificato.datiAnagraficiImm.dtCatastali.dtFoto" status="rowstatus">
			<tr class="<s:if test="#rowstatus.odd == true">even</s:if><s:else>odd</s:else>">
				<td width="5%"><input type="radio" name="appDatafotoSelezionata" value="<s:property value="uidFoto"/>"></td>
				<td width="30%"><s:property value="nomeFoto"/></td>
				<td width="30%"><s:property value="descTipoFoto"/></td>
				<td width="30%"><img class="preview" title="<s:property value="nomeFoto"/>" src="data:image/png;base64,<s:property value="previewBase64"/>"></td>
				<td width="5%"><s:property value="flgPrincipale"/></td>
			</tr>
	</s:iterator>
	<s:if test="%{appDatacertificato.datiAnagraficiImm.dtCatastali.dtFoto != null || appDatacertificato.datiAnagraficiImm.dtCatastali.nomeFoto != null}">
		</table>
		</div>
	</s:if>

<!--PROTECTED REGION END-->
</div>
<!-- endFragment:p_udPreview --></div>
