package it.csi.sicee.siceeweb.dto.annullamento;

public class Carrello implements java.io.Serializable {

	/// Field [codAceNew]
	private java.util.ArrayList<it.csi.sicee.siceeweb.dto.LabelValue> codAceNew = new java.util.ArrayList<it.csi.sicee.siceeweb.dto.LabelValue>();

	/**
	 * imposta il valore del campo [codAceNew]
	 * @param val
	 * @generated
	 */

	public void setCodAceNew(java.util.ArrayList<it.csi.sicee.siceeweb.dto.LabelValue> val) {
		codAceNew = val;
	}

	/**
	 * legge il valore del campo [codAceNew]
	 * @generated
	 */
	public java.util.ArrayList<it.csi.sicee.siceeweb.dto.LabelValue> getCodAceNew() {
		return codAceNew;
	}

	/// Field [codAceOld]
	private java.util.ArrayList<it.csi.sicee.siceeweb.dto.LabelValue> codAceOld = new java.util.ArrayList<it.csi.sicee.siceeweb.dto.LabelValue>();

	/**
	 * imposta il valore del campo [codAceOld]
	 * @param val
	 * @generated
	 */

	public void setCodAceOld(java.util.ArrayList<it.csi.sicee.siceeweb.dto.LabelValue> val) {
		codAceOld = val;
	}

	/**
	 * legge il valore del campo [codAceOld]
	 * @generated
	 */
	public java.util.ArrayList<it.csi.sicee.siceeweb.dto.LabelValue> getCodAceOld() {
		return codAceOld;
	}

	// il serial version uid e' fisso in quanto la classe in oggetto e' serializzabile
	// solo per la clusterizzazione della sessione web e non viene scambiata con altre
	// componenti.
	private static final long serialVersionUID = 1L;

	/**
	 * Costruttore vuoto del DTO.
	 * @generated
	 */
	public Carrello() {
		super();

	}

	/**
	 * @generated
	 */
	public String toString() {
		/*PROTECTED REGION ID(R-339196538) ENABLED START*/
		/// inserire qui la logica desiderata per la rappresenatazione a stringa
		return super.toString();
		/*PROTECTED REGION END*/
	}
}
