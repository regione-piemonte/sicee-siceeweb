package it.csi.sicee.siceeweb.dto.annullamento;

public class DtAnnullamento implements java.io.Serializable {

	/// Field [idMotivo]
	private java.lang.Integer idMotivo = null;

	/**
	 * imposta il valore del campo [idMotivo]
	 * @param val
	 * @generated
	 */

	public void setIdMotivo(java.lang.Integer val) {
		idMotivo = val;
	}

	/**
	 * legge il valore del campo [idMotivo]
	 * @generated
	 */
	public java.lang.Integer getIdMotivo() {
		return idMotivo;
	}

	/// Field [descMotivo]
	private java.lang.String descMotivo = null;

	/**
	 * imposta il valore del campo [descMotivo]
	 * @param val
	 * @generated
	 */

	public void setDescMotivo(java.lang.String val) {
		descMotivo = val;
	}

	/**
	 * legge il valore del campo [descMotivo]
	 * @generated
	 */
	public java.lang.String getDescMotivo() {
		return descMotivo;
	}

	/// Field [data]
	private java.lang.String data = null;

	/**
	 * imposta il valore del campo [data]
	 * @param val
	 * @generated
	 */

	public void setData(java.lang.String val) {
		data = val;
	}

	/**
	 * legge il valore del campo [data]
	 * @generated
	 */
	public java.lang.String getData() {
		return data;
	}

	/// Field [note]
	private java.lang.String note = null;

	/**
	 * imposta il valore del campo [note]
	 * @param val
	 * @generated
	 */

	public void setNote(java.lang.String val) {
		note = val;
	}

	/**
	 * legge il valore del campo [note]
	 * @generated
	 */
	public java.lang.String getNote() {
		return note;
	}

	/// Field [flgRicercaPregresso]
	private boolean flgRicercaPregresso = false;

	/**
	 * imposta il valore del campo [flgRicercaPregresso]
	 * @param val
	 * @generated
	 */

	public void setFlgRicercaPregresso(boolean val) {
		flgRicercaPregresso = val;
	}

	/**
	 * legge il valore del campo [flgRicercaPregresso]
	 * @generated
	 */
	public boolean getFlgRicercaPregresso() {
		return flgRicercaPregresso;
	}

	/// Field [descFlgRicercaPregresso]
	private java.lang.String descFlgRicercaPregresso = null;

	/**
	 * imposta il valore del campo [descFlgRicercaPregresso]
	 * @param val
	 * @generated
	 */

	public void setDescFlgRicercaPregresso(java.lang.String val) {
		descFlgRicercaPregresso = val;
	}

	/**
	 * legge il valore del campo [descFlgRicercaPregresso]
	 * @generated
	 */
	public java.lang.String getDescFlgRicercaPregresso() {
		return descFlgRicercaPregresso;
	}

	// il serial version uid e' fisso in quanto la classe in oggetto e' serializzabile
	// solo per la clusterizzazione della sessione web e non viene scambiata con altre
	// componenti.
	private static final long serialVersionUID = 1L;

	/**
	 * Costruttore vuoto del DTO.
	 * @generated
	 */
	public DtAnnullamento() {
		super();

	}

	/**
	 * @generated
	 */
	public String toString() {
		/*PROTECTED REGION ID(R-930247822) ENABLED START*/
		/// inserire qui la logica desiderata per la rappresenatazione a stringa
		return super.toString();
		/*PROTECTED REGION END*/
	}
}
