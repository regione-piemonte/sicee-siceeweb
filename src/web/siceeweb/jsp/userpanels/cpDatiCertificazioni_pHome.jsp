<%@taglib uri="/struts-tags" prefix="s" %>
<div id="p_pHome" class="panelBlock"><!-- startFragment:p_pHome -->
<div class="userDefinedPanel" id="pHome">
<!--PROTECTED REGION ID(R500082948) ENABLED START-->
<!-- Inserire il codice del pannello -->
<div class="contenuti">	
	<dl>
	<s:if test="isMenuVisible('mnuPrenotAttestati')">
		<s:if test="isMenuEnabled('mnuPrenotAttestati')">
			<dt>
			<s:url id="targetUrlPrenotaz" action="goToMnuPrenotAttestatiFromMenu" includeParams="none" namespace="/secure"/>
			<s:a href="%{targetUrlPrenotaz}">
				<s:text name="Prenotazione e acquisto codici A.P.E." />
			</s:a>
			</dt>
			<dd>
			Tramite la funzione &egrave; possibile effettuare la prenotazione e l'acquisto di uno o pi&ugrave; codici A.P.E.. Conclusa l'operazione, il sistema comunica i codici acquistati tramite la stampa di una ricevuta.
			</dd>
		</s:if>
		<s:else>
			<dt>
				<s:text name="Prenotazione e acquisto codici A.P.E." />
			</dt>
			<dd>
			Tramite la funzione &egrave; possibile effettuare la prenotazione e l'acquisto di uno o pi&ugrave; codici A.P.E.. Conclusa l'operazione, il sistema comunica i codici acquistati tramite la stampa di una ricevuta.
			</dd>
		</s:else>
	</s:if>
	
	
	<s:if test="isMenuVisible('mnuRicercaACE')">
		<s:if test="isMenuEnabled('mnuRicercaACE')">
			<dt>
			<s:url id="targetUrlMnuRicercaACE" action="goToMnuRicercaACEFromMenu" includeParams="none" namespace="/secure"/>
			<s:a href="%{targetUrlMnuRicercaACE}" id="menu_items_mnuRicercaACE">
				<s:text name="mnuRicercaACE.label" />
			</s:a>
			</dt>
			<dd>
			In questa sezione &egrave; possibile effettuare la ricerca degli A.P.E. inviati, visualizzando il documento inviato e la relativa ricevuta di invio. 
			Inoltre, &egrave; possibile visualizzare un report di tutti i dati dell'A.P.E. e procedere alla compilazione di un nuovo A.P.E. duplincandone uno esistente.  
			</dd>
		</s:if>
		<s:else>
			<dt>
			<s:text name="Ricerca A.P.E." />
			</dt>
			<dd>
			In questa sezione &egrave; possibile effettuare la ricerca degli A.P.E. inviati, visualizzando il documento inviato e la relativa ricevuta di invio. 
			Inoltre, &egrave; possibile visualizzare un report di tutti i dati dell'A.P.E. e procedere alla compilazione di un nuovo A.P.E. duplincandone uno esistente.  
			</dd>
		</s:else>
	</s:if>	
	
	<s:if test="isMenuVisible('mnuGestACE')">
		<s:if test="isMenuEnabled('mnuGestACE')">
			<dt>
			<s:url id="targetUrlCertificati" action="goToMnuGestACEFromMenu" includeParams="none" namespace="/secure"/>
			<s:a href="%{targetUrlCertificati}">
				<s:text name="Compilazione e trasmissione A.P.E." />
			</s:a>
			</dt>
			<dd>
				La funzione permette di compilare on line le informazioni utili per la redazione dell'Attestato di Prestazione Energetica. Inserite le informazioni necessarie, il sistema crea il pdf del Modulo A.P.E. che il certificatore dovr&agrave; preventivamente firmare digitalmente per trasmetterlo alla Regione Piemonte. L&rsquo;invio avverr&agrave; direttamente a sistema. Questa funzione &egrave; disponibile solo per i Certificatori iscritti in Elenco e che hanno acquistato almeno un codice A.P.E..  
			</dd>
		</s:if>
		<s:else>
			<dt>
				<s:text name="Compilazione e trasmissione A.P.E." />
			</dt>
			<dd>
				La funzione permette di compilare on line le informazioni utili per la redazione dell'Attestato di Prestazione Energetica. Inserite le informazioni necessarie, il sistema crea il pdf del Modulo A.P.E. che il certificatore dovr&agrave; preventivamente firmare digitalmente per trasmetterlo alla Regione Piemonte. L&rsquo;invio avverr&agrave; direttamente a sistema. Questa funzione &egrave; disponibile solo per i Certificatori iscritti in Elenco e che hanno acquistato almeno un codice A.P.E.. 			
			</dd>
		</s:else>
	</s:if>
	
	<s:if test="isMenuVisible('mnuAnnullaACE')">
		<s:if test="isMenuEnabled('mnuAnnullaACE')">
			<dt>
			<s:url id="targetUrlCertificati" action="goToMnuAnnullaACEFromMenu" includeParams="none" namespace="/secure"/>
			<s:a href="%{targetUrlCertificati}">
				<s:text name="Sostituzione A.P.E." />
			</s:a>
			</dt>
			<dd>
				In questa sezione &egrave; possibile effettuare la sostituzione di uno o pi&ugrave; A.P.E. gi&agrave; inviati indicando la motivazione della sostituzione.
				E' possibile sostituire anche A.P.E. di altri certificatori che verranno avvisati tramite email dell'avvenuta sostituzione.
				Per poter effettuare la sostituzione &egrave; necessario cercare sia l'A.P.E. che deve essere sostituito sia l'A.P.E. che lo
				deve sostituire; l'A.P.E. sostituito non avr&agrave; pi&ugrave; validit&agrave;.
				Gli estremi della sostituzione vengono riportati anche nella ricevuta di invio A.P.E..   
			</dd>
		</s:if>
		<s:else>
			<dt>
				<s:text name="Sostituzione A.P.E." />
			</dt>
			<dd>
				In questa sezione &egrave; possibile effettuare la sostituzione di uno o pi&ugrave; A.P.E. gi&agrave; inviati indicando la motivazione della sostituzione.
				E' possibile sostituire anche A.P.E. di altri certificatori che verranno avvisati tramite email dell'avvenuta sostituzione.
				Per poter effettuare la sostituzione &egrave; necessario cercare sia l'A.P.E. che deve essere sostituito sia l'A.P.E. che lo
				deve sostituire; l'A.P.E. sostituito non avr&agrave; pi&ugrave; validit&agrave;.
				Gli estremi della sostituzione vengono riportati anche nella ricevuta di invio A.P.E..  			
			</dd>
		</s:else>
	</s:if>
	
	</dl>
	
</div>
<!--PROTECTED REGION END-->
</div>
<!-- endFragment:p_pHome --></div>
