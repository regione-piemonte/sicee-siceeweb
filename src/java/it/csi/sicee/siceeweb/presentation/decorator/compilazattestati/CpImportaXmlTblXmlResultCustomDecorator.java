package it.csi.sicee.siceeweb.presentation.decorator.compilazattestati;

/*PROTECTED REGION ID(R-1848036828) ENABLED START*/
/// inserire qui eventuali import aggiuntive
import java.text.NumberFormat;
import java.util.Locale;
import it.csi.sicee.siceeweb.util.GenericUtil;
import it.csi.sicee.siceeweb.dto.daticert.ImportXmlResult; /*PROTECTED REGION END*/

import org.displaytag.decorator.TableDecorator;

public class CpImportaXmlTblXmlResultCustomDecorator extends TableDecorator {

	public CpImportaXmlTblXmlResultCustomDecorator() {
		super();

	}

	/*PROTECTED REGION ID(R-869168159) ENABLED START*/
	/// Questo spazio e' destinato alla definizione del Decorator.
	/// La documentazione sull'utilizzo dei decoratori della display tag e' disponibile all'url:
	/// http://displaytag.sourceforge.net/1.2
	public String getMatched() {
		ImportXmlResult res = (ImportXmlResult) this.getCurrentRowObject();
		if (GenericUtil.isNullOrEmpty(res.getMatched())) {
			return "";
		}

		if (res.getMatched()) {
			return "<img src=\"/siceeweb/img/true-icon.gif\" />";
		} else {
			return "<img src=\"/siceeweb/img/false-icon.gif\" />";
		}
	}

	/*PROTECTED REGION END*/

}
