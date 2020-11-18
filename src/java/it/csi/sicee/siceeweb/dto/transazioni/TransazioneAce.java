package it.csi.sicee.siceeweb.dto.transazioni;

public class TransazioneAce extends it.csi.sicee.siceeweb.dto.transazioni.Transazione implements java.io.Serializable {

	/// Field [quantita]
	private java.lang.String quantita = null;

	/**
	 * imposta il valore del campo [quantita]
	 * @param val
	 * @generated
	 */

	public void setQuantita(java.lang.String val) {
		quantita = val;
	}

	/**
	 * legge il valore del campo [quantita]
	 * @generated
	 */
	public java.lang.String getQuantita() {
		return quantita;
	}

	// il serial version uid e' fisso in quanto la classe in oggetto e' serializzabile
	// solo per la clusterizzazione della sessione web e non viene scambiata con altre
	// componenti.
	private static final long serialVersionUID = 1L;

	/**
	 * Costruttore vuoto del DTO.
	 * @generated
	 */
	public TransazioneAce() {
		super();

	}

	/**
	 * @generated
	 */
	public String toString() {
		/*PROTECTED REGION ID(R-1305204411) ENABLED START*/
		/// inserire qui la logica desiderata per la rappresenatazione a stringa
		return super.toString();
		/*PROTECTED REGION END*/
	}
}
