package it.csi.sicee.siceeweb.dto.daticert;

public class DtAISopralluoghi implements java.io.Serializable {

	/// Field [data]
	private it.csi.sicee.siceeweb.dto.type.UDTDateValid data = null;

	/**
	 * imposta il valore del campo [data]
	 * @param val
	 * @generated
	 */

	public void setData(it.csi.sicee.siceeweb.dto.type.UDTDateValid val) {
		data = val;
	}

	/**
	 * legge il valore del campo [data]
	 * @generated
	 */
	public it.csi.sicee.siceeweb.dto.type.UDTDateValid getData() {
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

	/// Field [tipoRedazione]
	private java.lang.String tipoRedazione = null;

	/**
	 * imposta il valore del campo [tipoRedazione]
	 * @param val
	 * @generated
	 */

	public void setTipoRedazione(java.lang.String val) {
		tipoRedazione = val;
	}

	/**
	 * legge il valore del campo [tipoRedazione]
	 * @generated
	 */
	public java.lang.String getTipoRedazione() {
		return tipoRedazione;
	}

	// il serial version uid e' fisso in quanto la classe in oggetto e' serializzabile
	// solo per la clusterizzazione della sessione web e non viene scambiata con altre
	// componenti.
	private static final long serialVersionUID = 1L;

	/**
	 * Costruttore vuoto del DTO.
	 * @generated
	 */
	public DtAISopralluoghi() {
		super();

	}

	/**
	 * @generated
	 */
	public String toString() {
		/*PROTECTED REGION ID(R-2132391789) ENABLED START*/
		/// inserire qui la logica desiderata per la rappresenatazione a stringa
		return super.toString();
		/*PROTECTED REGION END*/
	}
}
