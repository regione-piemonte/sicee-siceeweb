package it.csi.sicee.siceeweb.dto.commons;

public class DocumentSummary implements java.io.Serializable {

	/// Field [cod]
	private java.lang.String cod = null;

	/**
	 * imposta il valore del campo [cod]
	 * @param val
	 * @generated
	 */

	public void setCod(java.lang.String val) {
		cod = val;
	}

	/**
	 * legge il valore del campo [cod]
	 * @generated
	 */
	public java.lang.String getCod() {
		return cod;
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

	/// Field [tipo]
	private java.lang.String tipo = null;

	/**
	 * imposta il valore del campo [tipo]
	 * @param val
	 * @generated
	 */

	public void setTipo(java.lang.String val) {
		tipo = val;
	}

	/**
	 * legge il valore del campo [tipo]
	 * @generated
	 */
	public java.lang.String getTipo() {
		return tipo;
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

	/// Field [flgScarico]
	private java.lang.String flgScarico = null;

	/**
	 * imposta il valore del campo [flgScarico]
	 * @param val
	 * @generated
	 */

	public void setFlgScarico(java.lang.String val) {
		flgScarico = val;
	}

	/**
	 * legge il valore del campo [flgScarico]
	 * @generated
	 */
	public java.lang.String getFlgScarico() {
		return flgScarico;
	}

	/// Field [nome]
	private java.lang.String nome = null;

	/**
	 * imposta il valore del campo [nome]
	 * @param val
	 * @generated
	 */

	public void setNome(java.lang.String val) {
		nome = val;
	}

	/**
	 * legge il valore del campo [nome]
	 * @generated
	 */
	public java.lang.String getNome() {
		return nome;
	}

	// il serial version uid e' fisso in quanto la classe in oggetto e' serializzabile
	// solo per la clusterizzazione della sessione web e non viene scambiata con altre
	// componenti.
	private static final long serialVersionUID = 1L;

	/**
	 * Costruttore vuoto del DTO.
	 * @generated
	 */
	public DocumentSummary() {
		super();

	}

	/**
	 * @generated
	 */
	public String toString() {
		/*PROTECTED REGION ID(R2141256733) ENABLED START*/
		/// inserire qui la logica desiderata per la rappresenatazione a stringa
		return super.toString();
		/*PROTECTED REGION END*/
	}
}
