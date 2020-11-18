package it.csi.sicee.siceeweb.dto.geo;

public class Indirizzo implements java.io.Serializable {

	/// Field [cod]
	private java.lang.Integer cod = null;

	/**
	 * imposta il valore del campo [cod]
	 * @param val
	 * @generated
	 */

	public void setCod(java.lang.Integer val) {
		cod = val;
	}

	/**
	 * legge il valore del campo [cod]
	 * @generated
	 */
	public java.lang.Integer getCod() {
		return cod;
	}

	/// Field [descr]
	private java.lang.String descr = null;

	/**
	 * imposta il valore del campo [descr]
	 * @param val
	 * @generated
	 */

	public void setDescr(java.lang.String val) {
		descr = val;
	}

	/**
	 * legge il valore del campo [descr]
	 * @generated
	 */
	public java.lang.String getDescr() {
		return descr;
	}

	// il serial version uid e' fisso in quanto la classe in oggetto e' serializzabile
	// solo per la clusterizzazione della sessione web e non viene scambiata con altre
	// componenti.
	private static final long serialVersionUID = 1L;

	/**
	 * Costruttore vuoto del DTO.
	 * @generated
	 */
	public Indirizzo() {
		super();

	}

	/**
	 * @generated
	 */
	public String toString() {
		/*PROTECTED REGION ID(R500373431) ENABLED START*/
		/// inserire qui la logica desiderata per la rappresenatazione a stringa
		return super.toString();
		/*PROTECTED REGION END*/
	}
}
