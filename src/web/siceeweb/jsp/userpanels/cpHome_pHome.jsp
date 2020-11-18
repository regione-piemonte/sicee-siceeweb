<%@taglib uri="/struts-tags" prefix="s" %>
<div id="p_pHome" class="panelBlock"><!-- startFragment:p_pHome -->
<div class="userDefinedPanel" id="pHome">
<!--PROTECTED REGION ID(R-567039396) ENABLED START-->
<!-- Inserire il codice del pannello -->
	<div class="contenuti">	
	<dl>
	<dt>
	<s:url id="targetUrlDatiCert" action="goToMnuGstDatiCertFromMenu" includeParams="none" namespace="/secure"/>
	<s:a href="%{targetUrlDatiCert} ">
		<s:text name="Dati certificatore" />
	</s:a>
	</dt>
	<dd>
	In questa sezione il certificatore pu&ograve; visualizzare e modificare le informazioni inserite in fase di registrazione, visionare tutte le transazioni effettuate con le relative ricevute e inviare il proprio curriculum vitae che sar&agrave; pubblicato nell'elenco dei certificatori.

	</dd>
	
	<dt>
	<s:url id="targetUrlMnuGstCert" action="goToMnuGstCertFromMenu" includeParams="none"  namespace="/secure"/>
	<s:a href="%{targetUrlMnuGstCert}">
		<s:text name="Gestione A.P.E. (Attestato Prestazione Energetica)" />
	</s:a>
	</dt>
	<dd>
	In questa sezione il certificatore pu&ograve; compilare uno o pi&ugrave; A.P.E., pu&ograve; trasmetterli a Regione ed effettuare le ricerche su tutti gli A.P.E. inviati con la possibilit&agrave; di visionare tutti i dati contenuti in un A.P.E..
	</dd>
	
	<!-- 
	<s:if test="isMenuVisible('mnuPrenotAttestati')">
		<s:if test="isMenuEnabled('mnuPrenotAttestati')">
			<dt>
			<s:url id="targetUrlPrenotaz" action="goToMnuPrenotAttestatiFromMenu" includeParams="none" />
			<s:a href="%{targetUrlPrenotaz}">
				<s:text name="Prenotazione e acquisto codici A.C.E (Attestato Prestazione Energetica)" />
			</s:a>
			</dt>
			<dd>
			Tramite la funzione &egrave; possibile effettuare la prenotazione e l'acquisto di uno o pi&ugrave; codici A.P.E.. Conclusa l'operazione, il sistema comunica i codici acquistati tramite la stampa di una ricevuta.
			</dd>
		</s:if>
		<s:else>
			<dt>
				<s:text name="Prenotazione e acquisto codici A.C.E (Attestato Prestazione Energetica)" />
			</dt>
			<dd>
			Tramite la funzione &egrave; possibile effettuare la prenotazione e l'acquisto di uno o pi&ugrave; codici A.P.E.. Conclusa l'operazione, il sistema comunica i codici acquistati tramite la stampa di una ricevuta.
			</dd>
		</s:else>
	</s:if>
	
	
	<s:if test="isMenuVisible('mnuGestACE')">
		<s:if test="isMenuEnabled('mnuGestACE')">
			<dt>
			<s:url id="targetUrlCertificati" action="goToMnuGestACEFromMenu" includeParams="none" />
			<s:a href="%{targetUrlCertificati}">
				<s:text name="Compilazione e trasmissione A.C.E (Attestato Prestazione Energetica)" />
			</s:a>
			</dt>
			<dd>
				La funzione permette di compilare on line le informazioni utili per la redazione dell'Attestato di Prestazione Energetica. Inserite le informazioni necessarie, il sistema crea il pdf del Modulo A.P.E. che il certificatore dovr&agrave; preventivamente firmare elettronicamente per trasmetterlo alla Regione Piemonte. L&rsquo;invio avverr&agrave; direttamente a sistema. Questa funzione &egrave; disponibile solo per i Certificatori iscritti in Elenco e che hanno acquistato almeno un codice A.P.E..  
			</dd>
		</s:if>
		<s:else>
			<dt>
				<s:text name="Compilazione e trasmissione A.P.E (Attestato Prestazione Energetica)" />
			</dt>
			<dd>
				La funzione permette di compilare on line le informazioni utili per la redazione dell'Attestato di Prestazione Energetica. Inserite le informazioni necessarie, il sistema crea il pdf del Modulo A.P.E. che il certificatore dovr&agrave; preventivamente firmare elettronicamente per trasmetterlo alla Regione Piemonte. L&rsquo;invio avverr&agrave; direttamente a sistema. Questa funzione &egrave; disponibile solo per i Certificatori iscritti in Elenco e che hanno acquistato almeno un codice A.P.E.. 			
			</dd>
		</s:else>
	</s:if>
 -->	
	</dl>
	</div>
<!--PROTECTED REGION END-->
</div>
<!-- endFragment:p_pHome --></div>
