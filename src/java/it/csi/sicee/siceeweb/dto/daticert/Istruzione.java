package it.csi.sicee.siceeweb.dto.daticert;

public class Istruzione implements java.io.Serializable {

	/// Field [id]
	private java.lang.String id = null;

	/**
	 * imposta il valore del campo [id]
	 * @param val
	 * @generated
	 */

	public void setId(java.lang.String val) {
		id = val;
	}

	/**
	 * legge il valore del campo [id]
	 * @generated
	 */
	public java.lang.String getId() {
		return id;
	}

	/// Field [cod]
	private java.lang.String cod = null;

	/**
	 * imposta il valore del campo [cod]
	 * @param val
	 * @generated
	 */

	public void setCod(java.lang.String val) {
		cod = val;
	}

	/**
	 * legge il valore del campo [cod]
	 * @generated
	 */
	public java.lang.String getCod() {
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
	public Istruzione() {
		super();

	}

	/**
	 * @generated
	 */
	public String toString() {
		/*PROTECTED REGION ID(R1012164410) ENABLED START*/
		/// inserire qui la logica desiderata per la rappresenatazione a stringa
		return super.toString();
		/*PROTECTED REGION END*/
	}
}
