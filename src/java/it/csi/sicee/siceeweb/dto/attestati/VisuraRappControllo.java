package it.csi.sicee.siceeweb.dto.attestati;

public class VisuraRappControllo implements java.io.Serializable {

	/// Field [descTipoDoc]
	private java.lang.String descTipoDoc = null;

	/**
	 * imposta il valore del campo [descTipoDoc]
	 * @param val
	 * @generated
	 */

	public void setDescTipoDoc(java.lang.String val) {
		descTipoDoc = val;
	}

	/**
	 * legge il valore del campo [descTipoDoc]
	 * @generated
	 */
	public java.lang.String getDescTipoDoc() {
		return descTipoDoc;
	}

	/// Field [bollino]
	private java.lang.String bollino = null;

	/**
	 * imposta il valore del campo [bollino]
	 * @param val
	 * @generated
	 */

	public void setBollino(java.lang.String val) {
		bollino = val;
	}

	/**
	 * legge il valore del campo [bollino]
	 * @generated
	 */
	public java.lang.String getBollino() {
		return bollino;
	}

	/// Field [dtControllo]
	private java.lang.String dtControllo = null;

	/**
	 * imposta il valore del campo [dtControllo]
	 * @param val
	 * @generated
	 */

	public void setDtControllo(java.lang.String val) {
		dtControllo = val;
	}

	/**
	 * legge il valore del campo [dtControllo]
	 * @generated
	 */
	public java.lang.String getDtControllo() {
		return dtControllo;
	}

	/// Field [apparecchiature]
	private java.lang.String apparecchiature = null;

	/**
	 * imposta il valore del campo [apparecchiature]
	 * @param val
	 * @generated
	 */

	public void setApparecchiature(java.lang.String val) {
		apparecchiature = val;
	}

	/**
	 * legge il valore del campo [apparecchiature]
	 * @generated
	 */
	public java.lang.String getApparecchiature() {
		return apparecchiature;
	}

	/// Field [uidIndexLibretto]
	private java.lang.String uidIndexLibretto = null;

	/**
	 * imposta il valore del campo [uidIndexLibretto]
	 * @param val
	 * @generated
	 */

	public void setUidIndexLibretto(java.lang.String val) {
		uidIndexLibretto = val;
	}

	/**
	 * legge il valore del campo [uidIndexLibretto]
	 * @generated
	 */
	public java.lang.String getUidIndexLibretto() {
		return uidIndexLibretto;
	}

	/// Field [linkDownloadLib]
	private java.lang.String linkDownloadLib = null;

	/**
	 * imposta il valore del campo [linkDownloadLib]
	 * @param val
	 * @generated
	 */

	public void setLinkDownloadLib(java.lang.String val) {
		linkDownloadLib = val;
	}

	/**
	 * legge il valore del campo [linkDownloadLib]
	 * @generated
	 */
	public java.lang.String getLinkDownloadLib() {
		return linkDownloadLib;
	}

	// il serial version uid e' fisso in quanto la classe in oggetto e' serializzabile
	// solo per la clusterizzazione della sessione web e non viene scambiata con altre
	// componenti.
	private static final long serialVersionUID = 1L;

	/**
	 * Costruttore vuoto del DTO.
	 * @generated
	 */
	public VisuraRappControllo() {
		super();

	}

	/**
	 * @generated
	 */
	public String toString() {
		/*PROTECTED REGION ID(R1957032886) ENABLED START*/
		/// inserire qui la logica desiderata per la rappresenatazione a stringa
		return super.toString();
		/*PROTECTED REGION END*/
	}
}
