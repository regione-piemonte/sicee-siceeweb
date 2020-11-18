package it.csi.sicee.siceeweb.dto.attestati;

public class VisuraRicerca implements java.io.Serializable {

	/// Field [codImpianto]
	private it.csi.sicee.siceeweb.dto.type.UDTPositiveInteger codImpianto = null;

	/**
	 * imposta il valore del campo [codImpianto]
	 * @param val
	 * @generated
	 */

	public void setCodImpianto(it.csi.sicee.siceeweb.dto.type.UDTPositiveInteger val) {
		codImpianto = val;
	}

	/**
	 * legge il valore del campo [codImpianto]
	 * @generated
	 */
	public it.csi.sicee.siceeweb.dto.type.UDTPositiveInteger getCodImpianto() {
		return codImpianto;
	}

	/// Field [pod]
	private java.lang.String pod = null;

	/**
	 * imposta il valore del campo [pod]
	 * @param val
	 * @generated
	 */

	public void setPod(java.lang.String val) {
		pod = val;
	}

	/**
	 * legge il valore del campo [pod]
	 * @generated
	 */
	public java.lang.String getPod() {
		return pod;
	}

	/// Field [pdr]
	private java.lang.String pdr = null;

	/**
	 * imposta il valore del campo [pdr]
	 * @param val
	 * @generated
	 */

	public void setPdr(java.lang.String val) {
		pdr = val;
	}

	/**
	 * legge il valore del campo [pdr]
	 * @generated
	 */
	public java.lang.String getPdr() {
		return pdr;
	}

	/// Field [uid]
	private java.lang.String uid = null;

	/**
	 * imposta il valore del campo [uid]
	 * @param val
	 * @generated
	 */

	public void setUid(java.lang.String val) {
		uid = val;
	}

	/**
	 * legge il valore del campo [uid]
	 * @generated
	 */
	public java.lang.String getUid() {
		return uid;
	}

	// il serial version uid e' fisso in quanto la classe in oggetto e' serializzabile
	// solo per la clusterizzazione della sessione web e non viene scambiata con altre
	// componenti.
	private static final long serialVersionUID = 1L;

	/**
	 * Costruttore vuoto del DTO.
	 * @generated
	 */
	public VisuraRicerca() {
		super();

	}

	/**
	 * @generated
	 */
	public String toString() {
		/*PROTECTED REGION ID(R601577852) ENABLED START*/
		/// inserire qui la logica desiderata per la rappresenatazione a stringa
		return super.toString();
		/*PROTECTED REGION END*/
	}
}
