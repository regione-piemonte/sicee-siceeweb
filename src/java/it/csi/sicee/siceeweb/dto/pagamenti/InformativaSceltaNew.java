package it.csi.sicee.siceeweb.dto.pagamenti;

public class InformativaSceltaNew implements java.io.Serializable {

	/// Field [idInformativa]
	private java.lang.Integer idInformativa = null;

	/**
	 * imposta il valore del campo [idInformativa]
	 * @param val
	 * @generated
	 */

	public void setIdInformativa(java.lang.Integer val) {
		idInformativa = val;
	}

	/**
	 * legge il valore del campo [idInformativa]
	 * @generated
	 */
	public java.lang.Integer getIdInformativa() {
		return idInformativa;
	}

	/// Field [identificativo]
	private java.lang.String identificativo = null;

	/**
	 * imposta il valore del campo [identificativo]
	 * @param val
	 * @generated
	 */

	public void setIdentificativo(java.lang.String val) {
		identificativo = val;
	}

	/**
	 * legge il valore del campo [identificativo]
	 * @generated
	 */
	public java.lang.String getIdentificativo() {
		return identificativo;
	}

	/// Field [ragioneSociale]
	private java.lang.String ragioneSociale = null;

	/**
	 * imposta il valore del campo [ragioneSociale]
	 * @param val
	 * @generated
	 */

	public void setRagioneSociale(java.lang.String val) {
		ragioneSociale = val;
	}

	/**
	 * legge il valore del campo [ragioneSociale]
	 * @generated
	 */
	public java.lang.String getRagioneSociale() {
		return ragioneSociale;
	}

	/// Field [descrizioneServizio]
	private java.lang.String descrizioneServizio = null;

	/**
	 * imposta il valore del campo [descrizioneServizio]
	 * @param val
	 * @generated
	 */

	public void setDescrizioneServizio(java.lang.String val) {
		descrizioneServizio = val;
	}

	/**
	 * legge il valore del campo [descrizioneServizio]
	 * @generated
	 */
	public java.lang.String getDescrizioneServizio() {
		return descrizioneServizio;
	}

	// il serial version uid e' fisso in quanto la classe in oggetto e' serializzabile
	// solo per la clusterizzazione della sessione web e non viene scambiata con altre
	// componenti.
	private static final long serialVersionUID = 1L;

	/**
	 * Costruttore vuoto del DTO.
	 * @generated
	 */
	public InformativaSceltaNew() {
		super();

	}

	/**
	 * @generated
	 */
	public String toString() {
		/*PROTECTED REGION ID(R-1221396862) ENABLED START*/
		/// inserire qui la logica desiderata per la rappresenatazione a stringa
		return super.toString();
		/*PROTECTED REGION END*/
	}
}
