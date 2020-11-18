package it.csi.sicee.siceeweb.dto.daticert;

public class ImportXmlResult implements java.io.Serializable {

	/// Field [descrizione]
	private java.lang.String descrizione = null;

	/**
	 * imposta il valore del campo [descrizione]
	 * @param val
	 * @generated
	 */

	public void setDescrizione(java.lang.String val) {
		descrizione = val;
	}

	/**
	 * legge il valore del campo [descrizione]
	 * @generated
	 */
	public java.lang.String getDescrizione() {
		return descrizione;
	}

	/// Field [valoreXml]
	private java.lang.String valoreXml = null;

	/**
	 * imposta il valore del campo [valoreXml]
	 * @param val
	 * @generated
	 */

	public void setValoreXml(java.lang.String val) {
		valoreXml = val;
	}

	/**
	 * legge il valore del campo [valoreXml]
	 * @generated
	 */
	public java.lang.String getValoreXml() {
		return valoreXml;
	}

	/// Field [valoreCalcolato]
	private java.lang.String valoreCalcolato = null;

	/**
	 * imposta il valore del campo [valoreCalcolato]
	 * @param val
	 * @generated
	 */

	public void setValoreCalcolato(java.lang.String val) {
		valoreCalcolato = val;
	}

	/**
	 * legge il valore del campo [valoreCalcolato]
	 * @generated
	 */
	public java.lang.String getValoreCalcolato() {
		return valoreCalcolato;
	}

	/// Field [matched]
	private java.lang.Boolean matched = null;

	/**
	 * imposta il valore del campo [matched]
	 * @param val
	 * @generated
	 */

	public void setMatched(java.lang.Boolean val) {
		matched = val;
	}

	/**
	 * legge il valore del campo [matched]
	 * @generated
	 */
	public java.lang.Boolean getMatched() {
		return matched;
	}

	// il serial version uid e' fisso in quanto la classe in oggetto e' serializzabile
	// solo per la clusterizzazione della sessione web e non viene scambiata con altre
	// componenti.
	private static final long serialVersionUID = 1L;

	/**
	 * Costruttore vuoto del DTO.
	 * @generated
	 */
	public ImportXmlResult() {
		super();

	}

	/**
	 * @generated
	 */
	public String toString() {
		/*PROTECTED REGION ID(R-710987593) ENABLED START*/
		/// inserire qui la logica desiderata per la rappresenatazione a stringa
		return super.toString();
		/*PROTECTED REGION END*/
	}
}
