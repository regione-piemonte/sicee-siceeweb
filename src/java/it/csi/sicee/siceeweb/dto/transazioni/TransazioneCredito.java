package it.csi.sicee.siceeweb.dto.transazioni;

public class TransazioneCredito implements java.io.Serializable {

	/// Field [idCredito]
	private java.lang.String idCredito = null;

	/**
	 * imposta il valore del campo [idCredito]
	 * @param val
	 * @generated
	 */

	public void setIdCredito(java.lang.String val) {
		idCredito = val;
	}

	/**
	 * legge il valore del campo [idCredito]
	 * @generated
	 */
	public java.lang.String getIdCredito() {
		return idCredito;
	}

	/// Field [valoreOperazione]
	private java.lang.Float valoreOperazione = null;

	/**
	 * imposta il valore del campo [valoreOperazione]
	 * @param val
	 * @generated
	 */

	public void setValoreOperazione(java.lang.Float val) {
		valoreOperazione = val;
	}

	/**
	 * legge il valore del campo [valoreOperazione]
	 * @generated
	 */
	public java.lang.Float getValoreOperazione() {
		return valoreOperazione;
	}

	/// Field [valoreCreditoIniziale]
	private java.lang.Float valoreCreditoIniziale = null;

	/**
	 * imposta il valore del campo [valoreCreditoIniziale]
	 * @param val
	 * @generated
	 */

	public void setValoreCreditoIniziale(java.lang.Float val) {
		valoreCreditoIniziale = val;
	}

	/**
	 * legge il valore del campo [valoreCreditoIniziale]
	 * @generated
	 */
	public java.lang.Float getValoreCreditoIniziale() {
		return valoreCreditoIniziale;
	}

	/// Field [valoreCreditoFinale]
	private java.lang.Float valoreCreditoFinale = null;

	/**
	 * imposta il valore del campo [valoreCreditoFinale]
	 * @param val
	 * @generated
	 */

	public void setValoreCreditoFinale(java.lang.Float val) {
		valoreCreditoFinale = val;
	}

	/**
	 * legge il valore del campo [valoreCreditoFinale]
	 * @generated
	 */
	public java.lang.Float getValoreCreditoFinale() {
		return valoreCreditoFinale;
	}

	/// Field [dataOperazione]
	private java.lang.String dataOperazione = null;

	/**
	 * imposta il valore del campo [dataOperazione]
	 * @param val
	 * @generated
	 */

	public void setDataOperazione(java.lang.String val) {
		dataOperazione = val;
	}

	/**
	 * legge il valore del campo [dataOperazione]
	 * @generated
	 */
	public java.lang.String getDataOperazione() {
		return dataOperazione;
	}

	/// Field [descrizioneOperazione]
	private java.lang.String descrizioneOperazione = null;

	/**
	 * imposta il valore del campo [descrizioneOperazione]
	 * @param val
	 * @generated
	 */

	public void setDescrizioneOperazione(java.lang.String val) {
		descrizioneOperazione = val;
	}

	/**
	 * legge il valore del campo [descrizioneOperazione]
	 * @generated
	 */
	public java.lang.String getDescrizioneOperazione() {
		return descrizioneOperazione;
	}

	// il serial version uid e' fisso in quanto la classe in oggetto e' serializzabile
	// solo per la clusterizzazione della sessione web e non viene scambiata con altre
	// componenti.
	private static final long serialVersionUID = 1L;

	/**
	 * Costruttore vuoto del DTO.
	 * @generated
	 */
	public TransazioneCredito() {
		super();

	}

	/**
	 * @generated
	 */
	public String toString() {
		/*PROTECTED REGION ID(R757466968) ENABLED START*/
		/// inserire qui la logica desiderata per la rappresenatazione a stringa
		return super.toString();
		/*PROTECTED REGION END*/
	}
}
