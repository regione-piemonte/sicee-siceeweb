package it.csi.sicee.siceeweb.dto.geo;

public class Comune implements java.io.Serializable {

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

	/// Field [codCatasto]
	private java.lang.String codCatasto = null;

	/**
	 * imposta il valore del campo [codCatasto]
	 * @param val
	 * @generated
	 */

	public void setCodCatasto(java.lang.String val) {
		codCatasto = val;
	}

	/**
	 * legge il valore del campo [codCatasto]
	 * @generated
	 */
	public java.lang.String getCodCatasto() {
		return codCatasto;
	}

	/// Field [codProv]
	private java.lang.String codProv = null;

	/**
	 * imposta il valore del campo [codProv]
	 * @param val
	 * @generated
	 */

	public void setCodProv(java.lang.String val) {
		codProv = val;
	}

	/**
	 * legge il valore del campo [codProv]
	 * @generated
	 */
	public java.lang.String getCodProv() {
		return codProv;
	}

	/// Field [nomeProv]
	private java.lang.String nomeProv = null;

	/**
	 * imposta il valore del campo [nomeProv]
	 * @param val
	 * @generated
	 */

	public void setNomeProv(java.lang.String val) {
		nomeProv = val;
	}

	/**
	 * legge il valore del campo [nomeProv]
	 * @generated
	 */
	public java.lang.String getNomeProv() {
		return nomeProv;
	}

	// il serial version uid e' fisso in quanto la classe in oggetto e' serializzabile
	// solo per la clusterizzazione della sessione web e non viene scambiata con altre
	// componenti.
	private static final long serialVersionUID = 1L;

	/**
	 * Costruttore vuoto del DTO.
	 * @generated
	 */
	public Comune() {
		super();

	}

	/**
	 * @generated
	 */
	public String toString() {
		/*PROTECTED REGION ID(R-1561855366) ENABLED START*/
		/// inserire qui la logica desiderata per la rappresenatazione a stringa
		return super.toString();
		/*PROTECTED REGION END*/
	}
}
