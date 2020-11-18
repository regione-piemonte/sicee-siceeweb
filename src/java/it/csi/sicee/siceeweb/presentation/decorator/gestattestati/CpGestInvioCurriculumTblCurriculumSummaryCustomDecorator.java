package it.csi.sicee.siceeweb.presentation.decorator.gestattestati;

/*PROTECTED REGION ID(R-1297903281) ENABLED START*/
/// inserire qui eventuali import aggiuntive

import it.csi.sicee.siceeweb.dto.attestati.CurriculumSummary;
import it.csi.sicee.siceeweb.util.GenericUtil;

/*PROTECTED REGION END*/

import org.displaytag.decorator.TableDecorator;

public class CpGestInvioCurriculumTblCurriculumSummaryCustomDecorator extends TableDecorator {

	public CpGestInvioCurriculumTblCurriculumSummaryCustomDecorator() {
		super();

	}

	/*PROTECTED REGION ID(R1540340172) ENABLED START*/
	/// Questo spazio e' destinato alla definizione del Decorator.
	/// La documentazione sull'utilizzo dei decoratori della display tag e' disponibile all'url:
	/// http://displaytag.sourceforge.net/1.2  

	public String getFlgScarico() {
		CurriculumSummary curr = (CurriculumSummary) this.getCurrentRowObject();

		String ret = null;

		String codice = curr.getCod();

		if (!GenericUtil.isNullOrEmpty(curr.getFlgScarico())) {

			ret = "<a id=\"id_linkable_cell\" href=\"/siceeweb/base/gestattestati/cpGestInvioCurriculum!handleTblCurriculumSummary_CLICKED.do?idRiga="
					+ codice + "&amp;idColonna=flgScarico\"><span class=\"pdf\">Scarica</span></a>";

		}

		return ret;

	}
	/*PROTECTED REGION END*/

}
