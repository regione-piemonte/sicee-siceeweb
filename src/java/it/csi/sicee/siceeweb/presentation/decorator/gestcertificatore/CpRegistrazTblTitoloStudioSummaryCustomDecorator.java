package it.csi.sicee.siceeweb.presentation.decorator.gestcertificatore;

/*PROTECTED REGION ID(R1404753083) ENABLED START*/
/// inserire qui eventuali import aggiuntive
import it.csi.sicee.siceeweb.dto.commons.DocumentSummary;
import it.csi.sicee.siceeweb.util.GenericUtil;
/*PROTECTED REGION END*/

import org.displaytag.decorator.TableDecorator;

public class CpRegistrazTblTitoloStudioSummaryCustomDecorator extends TableDecorator {

	public CpRegistrazTblTitoloStudioSummaryCustomDecorator() {
		super();

	}

	/*PROTECTED REGION ID(R41478200) ENABLED START*/
	/// Questo spazio e' destinato alla definizione del Decorator.
	/// La documentazione sull'utilizzo dei decoratori della display tag e' disponibile all'url:
	/// http://displaytag.sourceforge.net/1.2  

	public String getFlgScarico() {
		DocumentSummary doc = (DocumentSummary) this.getCurrentRowObject();

		String ret = null;
		//String codice = doc.getCod();
		String uid = doc.getUid();

		if (!GenericUtil.isNullOrEmpty(doc.getFlgScarico())) {

			ret = "<a id=\"id_linkable_cell\" href=\"/siceeweb/base/gestcertificatore/cpRegistraz!handleTblTitoloStudioSummary_CLICKED.do?idRiga="
					+ uid
					//+ codice
					+ "&amp;idColonna=flgScarico\"><span class=\"pdf\">Scarica</a></span></a>";
		}

		return ret;

	}

	/*PROTECTED REGION END*/

}
