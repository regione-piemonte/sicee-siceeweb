package it.csi.sicee.siceeweb.dto.ace;

public class DocumentoAggiuntivo implements java.io.Serializable {

	/// Field [id]
	private int id = 0;

	/**
	 * imposta il valore del campo [id]
	 * @param val
	 * @generated
	 */

	public void setId(int val) {
		id = val;
	}

	/**
	 * legge il valore del campo [id]
	 * @generated
	 */
	public int getId() {
		return id;
	}

	/// Field [nomeDocumento]
	private java.lang.String nomeDocumento = null;

	/**
	 * imposta il valore del campo [nomeDocumento]
	 * @param val
	 * @generated
	 */

	public void setNomeDocumento(java.lang.String val) {
		nomeDocumento = val;
	}

	/**
	 * legge il valore del campo [nomeDocumento]
	 * @generated
	 */
	public java.lang.String getNomeDocumento() {
		return nomeDocumento;
	}

	/// Field [tipoDocumento]
	private java.lang.String tipoDocumento = null;

	/**
	 * imposta il valore del campo [tipoDocumento]
	 * @param val
	 * @generated
	 */

	public void setTipoDocumento(java.lang.String val) {
		tipoDocumento = val;
	}

	/**
	 * legge il valore del campo [tipoDocumento]
	 * @generated
	 */
	public java.lang.String getTipoDocumento() {
		return tipoDocumento;
	}

	/// Field [dataUpload]
	private java.lang.String dataUpload = null;

	/**
	 * imposta il valore del campo [dataUpload]
	 * @param val
	 * @generated
	 */

	public void setDataUpload(java.lang.String val) {
		dataUpload = val;
	}

	/**
	 * legge il valore del campo [dataUpload]
	 * @generated
	 */
	public java.lang.String getDataUpload() {
		return dataUpload;
	}

	/// Field [statoDocumento]
	private java.lang.String statoDocumento = null;

	/**
	 * imposta il valore del campo [statoDocumento]
	 * @param val
	 * @generated
	 */

	public void setStatoDocumento(java.lang.String val) {
		statoDocumento = val;
	}

	/**
	 * legge il valore del campo [statoDocumento]
	 * @generated
	 */
	public java.lang.String getStatoDocumento() {
		return statoDocumento;
	}

	// il serial version uid e' fisso in quanto la classe in oggetto e' serializzabile
	// solo per la clusterizzazione della sessione web e non viene scambiata con altre
	// componenti.
	private static final long serialVersionUID = 1L;

	/**
	 * Costruttore vuoto del DTO.
	 * @generated
	 */
	public DocumentoAggiuntivo() {
		super();

	}

	/**
	 * @generated
	 */
	public String toString() {
		/*PROTECTED REGION ID(R1784428058) ENABLED START*/
		/// inserire qui la logica desiderata per la rappresenatazione a stringa
		return super.toString();
		/*PROTECTED REGION END*/
	}
}
