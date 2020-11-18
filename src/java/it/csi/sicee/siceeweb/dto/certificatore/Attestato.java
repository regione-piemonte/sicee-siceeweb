package it.csi.sicee.siceeweb.dto.certificatore;

public class Attestato implements java.io.Serializable {

	/// Field [tipo]
	private java.lang.Integer tipo = null;

	/**
	 * imposta il valore del campo [tipo]
	 * @param val
	 * @generated
	 */

	public void setTipo(java.lang.Integer val) {
		tipo = val;
	}

	/**
	 * legge il valore del campo [tipo]
	 * @generated
	 */
	public java.lang.Integer getTipo() {
		return tipo;
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
	public Attestato() {
		super();

	}

	/**
	 * @generated
	 */
	public String toString() {
		/*PROTECTED REGION ID(R1693159197) ENABLED START*/
		/// inserire qui la logica desiderata per la rappresenatazione a stringa
		return super.toString();
		/*PROTECTED REGION END*/
	}
}
