package it.csi.sicee.siceeweb.dto.geo;

public class Provincia implements java.io.Serializable {

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
	public Provincia() {
		super();

	}

	/**
	 * @generated
	 */
	public String toString() {
		/*PROTECTED REGION ID(R1008913142) ENABLED START*/
		/// inserire qui la logica desiderata per la rappresenatazione a stringa
		return super.toString();
		/*PROTECTED REGION END*/
	}
}
