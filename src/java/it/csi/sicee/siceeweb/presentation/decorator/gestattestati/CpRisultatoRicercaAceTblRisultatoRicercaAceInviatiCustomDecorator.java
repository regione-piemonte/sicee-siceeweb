package it.csi.sicee.siceeweb.presentation.decorator.gestattestati;

/*PROTECTED REGION ID(R1676917415) ENABLED START*/
/// inserire qui eventuali import aggiuntive
import it.csi.sicee.siceeweb.dto.ace.Ace;
import it.csi.sicee.siceeweb.util.Constants;
import it.csi.sicee.siceeweb.util.GenericUtil;

/*PROTECTED REGION END*/

import org.displaytag.decorator.TableDecorator;

public class CpRisultatoRicercaAceTblRisultatoRicercaAceInviatiCustomDecorator extends TableDecorator {

	public CpRisultatoRicercaAceTblRisultatoRicercaAceInviatiCustomDecorator() {
		super();

	}

	/*PROTECTED REGION ID(R-2125833948) ENABLED START*/
	/// Questo spazio e' destinato alla definizione del Decorator.
	/// La documentazione sull'utilizzo dei decoratori della display tag e' disponibile all'url:
	/// http://displaytag.sourceforge.net/1.2  

	public String getLinkDownloadInd() {
		Ace ace = (Ace) this.getCurrentRowObject();

		String ret = null;

		String codice = ace.getAnno() + " " + ace.getCertificatore() + " " + ace.getNumero();

		if (!GenericUtil.isNullOrEmpty(ace.getLinkDownloadInd())) {
			ret = "<a id=\"id_linkable_cell\" href=\"/siceeweb/base/gestattestati/cpRisultatoRicercaAce!handleTblRisultatoRicercaAceInviati_CLICKED.do?idRiga="
					+ codice + "&amp;idColonna=linkDownloadInd\"><span class=\"pdf\">Targa A.P.E.</span></a>";
		}

		return ret;

	}

	public String getFlgRicevuta() {
		Ace ace = (Ace) this.getCurrentRowObject();

		String ret = null;

		String codice = ace.getAnno() + " " + ace.getCertificatore() + " " + ace.getNumero();

		if (!GenericUtil.isNullOrEmpty(ace.getFlgRicevuta())) {
			ret = "<a id=\"id_linkable_cell\" href=\"/siceeweb/base/gestattestati/cpRisultatoRicercaAce!handleTblRisultatoRicercaAceInviati_CLICKED.do?idRiga="
					+ codice + "&amp;idColonna=flgRicevuta\"><span class=\"pdf\">Ricevuta A.P.E.</span></a>";
		}

		return ret;

	}

	public String getLinkDownload() {
		Ace ace = (Ace) this.getCurrentRowObject();

		String ret = null;

		String codice = ace.getAnno() + " " + ace.getCertificatore() + " " + ace.getNumero();

		if (!GenericUtil.isNullOrEmpty(ace.getLinkDownload())) {
			ret = "<a id=\"id_linkable_cell\" href=\"/siceeweb/base/gestattestati/cpRisultatoRicercaAce!handleTblRisultatoRicercaAceInviati_CLICKED.do?idRiga="
					+ codice + "&amp;idColonna=linkDownload\"><span class=\"pdf\">Modulo A.P.E.</span></a>";
		}

		return ret;

	}

	/*PROTECTED REGION END*/

}
