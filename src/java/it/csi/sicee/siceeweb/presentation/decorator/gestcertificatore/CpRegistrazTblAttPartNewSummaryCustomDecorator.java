package it.csi.sicee.siceeweb.presentation.decorator.gestcertificatore;

/*PROTECTED REGION ID(R757895646) ENABLED START*/
/// inserire qui eventuali import aggiuntive
import it.csi.sicee.siceeweb.dto.attestati.CorsoAttestatoSummary;
import it.csi.sicee.siceeweb.util.GenericUtil;
/*PROTECTED REGION END*/

import org.displaytag.decorator.TableDecorator;

public class CpRegistrazTblAttPartNewSummaryCustomDecorator extends TableDecorator {

	public CpRegistrazTblAttPartNewSummaryCustomDecorator() {
		super();

	}

	/*PROTECTED REGION ID(R107844123) ENABLED START*/
	/// Questo spazio e' destinato alla definizione del Decorator.
	/// La documentazione sull'utilizzo dei decoratori della display tag e' disponibile all'url:
	/// http://displaytag.sourceforge.net/1.2  

	public String getFlgScarico() {
		CorsoAttestatoSummary doc = (CorsoAttestatoSummary) this.getCurrentRowObject();

		String ret = null;
		String uid = doc.getIdentificDoc();

		if (!GenericUtil.isNullOrEmpty(doc.getIdentificDoc())) {

			ret = "<a id=\"id_linkable_cell\" href=\"/siceeweb/base/gestcertificatore/cpRegistraz!handleTblAttPartNewSummary_CLICKED.do?idRiga="
					+ uid + "&amp;idColonna=flgScarico\"><span class=\"pdf\">Scarica</a></span></a>";

		}

		return ret;

	}

	/*PROTECTED REGION END*/

}
