package it.csi.sicee.siceeweb.dto.daticert;

public class DtListaCf implements java.io.Serializable {

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

	/// Field [codiceFiscale]
	private java.lang.String codiceFiscale = null;

	/**
	 * imposta il valore del campo [codiceFiscale]
	 * @param val
	 * @generated
	 */

	public void setCodiceFiscale(java.lang.String val) {
		codiceFiscale = val;
	}

	/**
	 * legge il valore del campo [codiceFiscale]
	 * @generated
	 */
	public java.lang.String getCodiceFiscale() {
		return codiceFiscale;
	}

	// il serial version uid e' fisso in quanto la classe in oggetto e' serializzabile
	// solo per la clusterizzazione della sessione web e non viene scambiata con altre
	// componenti.
	private static final long serialVersionUID = 1L;

	/**
	 * Costruttore vuoto del DTO.
	 * @generated
	 */
	public DtListaCf() {
		super();

	}

	/**
	 * @generated
	 */
	public String toString() {
		/*PROTECTED REGION ID(R-1028119970) ENABLED START*/
		/// inserire qui la logica desiderata per la rappresenatazione a stringa
		return super.toString();
		/*PROTECTED REGION END*/
	}
}
