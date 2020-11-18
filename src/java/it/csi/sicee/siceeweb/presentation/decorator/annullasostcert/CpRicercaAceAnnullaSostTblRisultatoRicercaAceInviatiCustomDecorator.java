package it.csi.sicee.siceeweb.presentation.decorator.annullasostcert;

/*PROTECTED REGION ID(R-1402647234) ENABLED START*/
/// inserire qui eventuali import aggiuntive

import it.csi.sicee.siceeweb.dto.ace.Ace;
import it.csi.sicee.siceeweb.util.GenericUtil;

/*PROTECTED REGION END*/

import org.displaytag.decorator.TableDecorator;

public class CpRicercaAceAnnullaSostTblRisultatoRicercaAceInviatiCustomDecorator extends TableDecorator {

	public CpRicercaAceAnnullaSostTblRisultatoRicercaAceInviatiCustomDecorator() {
		super();

	}

	/*PROTECTED REGION ID(R-2124569221) ENABLED START*/
	/// Questo spazio e' destinato alla definizione del Decorator.
	/// La documentazione sull'utilizzo dei decoratori della display tag e' disponibile all'url:
	/// http://displaytag.sourceforge.net/1.2  

	public String getFlgInviato() {
		Ace ace = (Ace) this.getCurrentRowObject();

		String ret = null;

		String codice = ace.getAnno() + " " + ace.getCertificatore() + " " + ace.getNumero();

		if (!GenericUtil.isNullOrEmpty(ace.getFlgInviato())) {

			ret = "<a id=\"id_linkable_cell\" href=\"/siceeweb/base/annullaSostCert/cpRicercaAceAnnullaSost!handleTblRisultatoRicercaAceInviati_CLICKED.do?idRiga="
					+ codice + "&amp;idColonna=flgInviato\"><span class=\"pdf\">Modulo A.P.E.</span></a>";
		}

		return ret;

	}

	/*PROTECTED REGION END*/

}
