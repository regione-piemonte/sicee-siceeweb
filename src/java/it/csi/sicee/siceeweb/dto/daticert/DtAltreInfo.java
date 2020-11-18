package it.csi.sicee.siceeweb.dto.daticert;

public class DtAltreInfo implements java.io.Serializable {

	/// Field [flgEdificioPerformante]
	private java.lang.Boolean flgEdificioPerformante = null;

	/**
	 * imposta il valore del campo [flgEdificioPerformante]
	 * @param val
	 * @generated
	 */

	public void setFlgEdificioPerformante(java.lang.Boolean val) {
		flgEdificioPerformante = val;
	}

	/**
	 * legge il valore del campo [flgEdificioPerformante]
	 * @generated
	 */
	public java.lang.Boolean getFlgEdificioPerformante() {
		return flgEdificioPerformante;
	}

	/// Field [raccomandazioni]
	private java.util.ArrayList<it.csi.sicee.siceeweb.dto.attestati.Raccomandazione> raccomandazioni = new java.util.ArrayList<it.csi.sicee.siceeweb.dto.attestati.Raccomandazione>();

	/**
	 * imposta il valore del campo [raccomandazioni]
	 * @param val
	 * @generated
	 */

	public void setRaccomandazioni(java.util.ArrayList<it.csi.sicee.siceeweb.dto.attestati.Raccomandazione> val) {
		raccomandazioni = val;
	}

	/**
	 * legge il valore del campo [raccomandazioni]
	 * @generated
	 */
	public java.util.ArrayList<it.csi.sicee.siceeweb.dto.attestati.Raccomandazione> getRaccomandazioni() {
		return raccomandazioni;
	}

	/// Field [energetiche]
	private it.csi.sicee.siceeweb.dto.daticert.DtAIEnergetiche energetiche = null;

	/**
	 * imposta il valore del campo [energetiche]
	 * @param val
	 * @generated
	 */

	public void setEnergetiche(it.csi.sicee.siceeweb.dto.daticert.DtAIEnergetiche val) {
		energetiche = val;
	}

	/**
	 * legge il valore del campo [energetiche]
	 * @generated
	 */
	public it.csi.sicee.siceeweb.dto.daticert.DtAIEnergetiche getEnergetiche() {
		return energetiche;
	}

	/// Field [generali]
	private it.csi.sicee.siceeweb.dto.daticert.DtAIGenerali generali = null;

	/**
	 * imposta il valore del campo [generali]
	 * @param val
	 * @generated
	 */

	public void setGenerali(it.csi.sicee.siceeweb.dto.daticert.DtAIGenerali val) {
		generali = val;
	}

	/**
	 * legge il valore del campo [generali]
	 * @generated
	 */
	public it.csi.sicee.siceeweb.dto.daticert.DtAIGenerali getGenerali() {
		return generali;
	}

	/// Field [sopralluoghi]
	private it.csi.sicee.siceeweb.dto.daticert.DtAISopralluoghi sopralluoghi = null;

	/**
	 * imposta il valore del campo [sopralluoghi]
	 * @param val
	 * @generated
	 */

	public void setSopralluoghi(it.csi.sicee.siceeweb.dto.daticert.DtAISopralluoghi val) {
		sopralluoghi = val;
	}

	/**
	 * legge il valore del campo [sopralluoghi]
	 * @generated
	 */
	public it.csi.sicee.siceeweb.dto.daticert.DtAISopralluoghi getSopralluoghi() {
		return sopralluoghi;
	}

	/// Field [flgSigmater]
	private java.lang.Boolean flgSigmater = null;

	/**
	 * imposta il valore del campo [flgSigmater]
	 * @param val
	 * @generated
	 */

	public void setFlgSigmater(java.lang.Boolean val) {
		flgSigmater = val;
	}

	/**
	 * legge il valore del campo [flgSigmater]
	 * @generated
	 */
	public java.lang.Boolean getFlgSigmater() {
		return flgSigmater;
	}

	// il serial version uid e' fisso in quanto la classe in oggetto e' serializzabile
	// solo per la clusterizzazione della sessione web e non viene scambiata con altre
	// componenti.
	private static final long serialVersionUID = 1L;

	/**
	 * Costruttore vuoto del DTO.
	 * @generated
	 */
	public DtAltreInfo() {
		super();

	}

	/**
	 * @generated
	 */
	public String toString() {
		/*PROTECTED REGION ID(R324507778) ENABLED START*/
		/// inserire qui la logica desiderata per la rappresenatazione a stringa
		return super.toString();
		/*PROTECTED REGION END*/
	}
}
