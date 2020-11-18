<%@ taglib uri="/struts-tags" prefix="s" %>

<div id="p_pUserInfoCustom"><!-- startFragment:p_pUserInfoCustomRegistraz -->
<!-- Inserire il codice del pannello -->
<div id="contUtente">
	<div id="Utente">
	<s:if test="%{appDatacertificatore != null}">
		<s:if test="%{appDatacertificatore.stato == 1 || appDatacertificatore.stato == 3}">
		<span id="datiUtente">
			Certificatore: <strong><s:property value="appDatacurrentUser.nome" /> <s:property value="appDatacurrentUser.cognome" /></strong> 
			| N. iscrizione: <strong><s:property value="appDatacertificatore.numCertificatore" /></strong>
			<s:if test="%{appDatacertificatore.stato == 3}">
				| Data scadenza: <strong><FONT color="red"><s:property value="appDatacertificatore.dataScadenzaRegistrazione" /></FONT></strong>
			</s:if>
			<s:else>
				<s:if test='%{appDatacertificatore.dtOrdine.titolo.flgMdp == "S"}'>
					| Data scadenza: <strong><s:property value="appDatacertificatore.dataScadenzaRegistrazione" /></strong>
				</s:if>
			</s:else>
			
			
			<s:if test="%{appDatacertificatore.eMailErrata}">
				 | <strong><FONT color="red">Il campo email &egrave; errato. Si prega di modificarlo.</FONT></strong>
			</s:if>
			<s:if test="%{appDatacertificatore.transazioneAnomale}">
				 | <strong><FONT color="red">Transazioni anomale presenti.</FONT></strong>
			</s:if>
		</span>
	    </s:if>
	    <s:else>
		<span id="datiUtente">
			Utente: <strong><s:property value="appDatacurrentUser.nome" /> <s:property value="appDatacurrentUser.cognome" /></strong>
			<s:if test="%{appDatacertificatore.dataScadenzaRegistrazione == null}"> 
			| <strong>L'utente non &egrave ancora registrato all'elenco dei certificatori</strong>
			</s:if>
			<s:else>
			| <strong>L'iscrizione all'Elenco regionale certificatori &egrave scaduta. Si prega di procedere al rinnovo.</strong>
			</s:else>
			<s:if test="%{appDatacertificatore.transazioneAnomale}">
				 | <strong><FONT color="red">Transazioni anomale presenti.</FONT></strong>
			</s:if>
		</span>
	    </s:else>
	    
	    
	    <s:if test="%{appDatacertificatore.idBlocco != null}">
			<br>
			<span id="datiUtente">
				<FONT color="red"><strong>Blocco attivo: </strong><s:property value="appDatacertificatore.descBlocco" /> </FONT>
			</span>
	    </s:if>
	    
	    
	</s:if>
	<s:else>
		<span id="datiUtente"><FONT color="red">ERRORE NEL TESTALINO!!!</FONT></span>
	</s:else>
	
	<span id="logout">
		<s:url id="targetUrlEsci" action="cpEsci" includeParams="none"  namespace="/base/main"/>
		<s:a href="%{targetUrlEsci}" title="Disconnetti dal servizio">
			<s:text name="esci" />
		</s:a>
		
	</span>
	</div>
	
</div>

<!-- endFragment:p_pUserInfoCustomRegistraz --></div>
