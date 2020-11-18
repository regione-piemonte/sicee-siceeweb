package it.csi.sicee.siceeweb.dto.daticert;

public class DtCoCertificatore implements java.io.Serializable {

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

	/// Field [cognome]
	private java.lang.String cognome = null;

	/**
	 * imposta il valore del campo [cognome]
	 * @param val
	 * @generated
	 */

	public void setCognome(java.lang.String val) {
		cognome = val;
	}

	/**
	 * legge il valore del campo [cognome]
	 * @generated
	 */
	public java.lang.String getCognome() {
		return cognome;
	}

	/// Field [numMatricola]
	private java.lang.String numMatricola = null;

	/**
	 * imposta il valore del campo [numMatricola]
	 * @param val
	 * @generated
	 */

	public void setNumMatricola(java.lang.String val) {
		numMatricola = val;
	}

	/**
	 * legge il valore del campo [numMatricola]
	 * @generated
	 */
	public java.lang.String getNumMatricola() {
		return numMatricola;
	}

	/// Field [codFisc]
	private java.lang.String codFisc = null;

	/**
	 * imposta il valore del campo [codFisc]
	 * @param val
	 * @generated
	 */

	public void setCodFisc(java.lang.String val) {
		codFisc = val;
	}

	/**
	 * legge il valore del campo [codFisc]
	 * @generated
	 */
	public java.lang.String getCodFisc() {
		return codFisc;
	}

	// il serial version uid e' fisso in quanto la classe in oggetto e' serializzabile
	// solo per la clusterizzazione della sessione web e non viene scambiata con altre
	// componenti.
	private static final long serialVersionUID = 1L;

	/**
	 * Costruttore vuoto del DTO.
	 * @generated
	 */
	public DtCoCertificatore() {
		super();

	}

	/**
	 * @generated
	 */
	public String toString() {
		/*PROTECTED REGION ID(R-1383933024) ENABLED START*/
		/// inserire qui la logica desiderata per la rappresenatazione a stringa
		return super.toString();
		/*PROTECTED REGION END*/
	}
}
