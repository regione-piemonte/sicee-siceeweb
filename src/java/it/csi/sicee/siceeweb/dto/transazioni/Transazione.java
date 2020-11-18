package it.csi.sicee.siceeweb.dto.transazioni;

public class Transazione implements java.io.Serializable {

	/// Field [idTransazione]
	private java.lang.Long idTransazione = null;

	/**
	 * imposta il valore del campo [idTransazione]
	 * @param val
	 * @generated
	 */

	public void setIdTransazione(java.lang.Long val) {
		idTransazione = val;
	}

	/**
	 * legge il valore del campo [idTransazione]
	 * @generated
	 */
	public java.lang.Long getIdTransazione() {
		return idTransazione;
	}

	/// Field [numeroTransazione]
	private java.lang.String numeroTransazione = null;

	/**
	 * imposta il valore del campo [numeroTransazione]
	 * @param val
	 * @generated
	 */

	public void setNumeroTransazione(java.lang.String val) {
		numeroTransazione = val;
	}

	/**
	 * legge il valore del campo [numeroTransazione]
	 * @generated
	 */
	public java.lang.String getNumeroTransazione() {
		return numeroTransazione;
	}

	/// Field [dataTransazione]
	private java.lang.String dataTransazione = null;

	/**
	 * imposta il valore del campo [dataTransazione]
	 * @param val
	 * @generated
	 */

	public void setDataTransazione(java.lang.String val) {
		dataTransazione = val;
	}

	/**
	 * legge il valore del campo [dataTransazione]
	 * @generated
	 */
	public java.lang.String getDataTransazione() {
		return dataTransazione;
	}

	/// Field [tipoTransazione]
	private java.lang.String tipoTransazione = null;

	/**
	 * imposta il valore del campo [tipoTransazione]
	 * @param val
	 * @generated
	 */

	public void setTipoTransazione(java.lang.String val) {
		tipoTransazione = val;
	}

	/**
	 * legge il valore del campo [tipoTransazione]
	 * @generated
	 */
	public java.lang.String getTipoTransazione() {
		return tipoTransazione;
	}

	/// Field [stato]
	private java.lang.String stato = null;

	/**
	 * imposta il valore del campo [stato]
	 * @param val
	 * @generated
	 */

	public void setStato(java.lang.String val) {
		stato = val;
	}

	/**
	 * legge il valore del campo [stato]
	 * @generated
	 */
	public java.lang.String getStato() {
		return stato;
	}

	/// Field [idCertificatore]
	private java.lang.String idCertificatore = null;

	/**
	 * imposta il valore del campo [idCertificatore]
	 * @param val
	 * @generated
	 */

	public void setIdCertificatore(java.lang.String val) {
		idCertificatore = val;
	}

	/**
	 * legge il valore del campo [idCertificatore]
	 * @generated
	 */
	public java.lang.String getIdCertificatore() {
		return idCertificatore;
	}

	// il serial version uid e' fisso in quanto la classe in oggetto e' serializzabile
	// solo per la clusterizzazione della sessione web e non viene scambiata con altre
	// componenti.
	private static final long serialVersionUID = 1L;

	/**
	 * Costruttore vuoto del DTO.
	 * @generated
	 */
	public Transazione() {
		super();

	}

	/**
	 * @generated
	 */
	public String toString() {
		/*PROTECTED REGION ID(R1768410294) ENABLED START*/
		/// inserire qui la logica desiderata per la rappresenatazione a stringa
		return super.toString();
		/*PROTECTED REGION END*/
	}
}
