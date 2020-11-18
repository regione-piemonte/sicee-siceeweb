package it.csi.sicee.siceeweb.dto.certificatore;

public class Titolo implements java.io.Serializable {

	/// Field [id]
	private java.lang.String id = null;

	/**
	 * imposta il valore del campo [id]
	 * @param val
	 * @generated
	 */

	public void setId(java.lang.String val) {
		id = val;
	}

	/**
	 * legge il valore del campo [id]
	 * @generated
	 */
	public java.lang.String getId() {
		return id;
	}

	/// Field [descr]
	private java.lang.String descr = null;

	/**
	 * imposta il valore del campo [descr]
	 * @param val
	 * @generated
	 */

	public void setDescr(java.lang.String val) {
		descr = val;
	}

	/**
	 * legge il valore del campo [descr]
	 * @generated
	 */
	public java.lang.String getDescr() {
		return descr;
	}

	/// Field [sigla]
	private java.lang.String sigla = null;

	/**
	 * imposta il valore del campo [sigla]
	 * @param val
	 * @generated
	 */

	public void setSigla(java.lang.String val) {
		sigla = val;
	}

	/**
	 * legge il valore del campo [sigla]
	 * @generated
	 */
	public java.lang.String getSigla() {
		return sigla;
	}

	/// Field [edifici]
	private java.lang.Boolean edifici = null;

	/**
	 * imposta il valore del campo [edifici]
	 * @param val
	 * @generated
	 */

	public void setEdifici(java.lang.Boolean val) {
		edifici = val;
	}

	/**
	 * legge il valore del campo [edifici]
	 * @generated
	 */
	public java.lang.Boolean getEdifici() {
		return edifici;
	}

	/// Field [impianti]
	private java.lang.Boolean impianti = null;

	/**
	 * imposta il valore del campo [impianti]
	 * @param val
	 * @generated
	 */

	public void setImpianti(java.lang.Boolean val) {
		impianti = val;
	}

	/**
	 * legge il valore del campo [impianti]
	 * @generated
	 */
	public java.lang.Boolean getImpianti() {
		return impianti;
	}

	/// Field [flgMdp]
	private java.lang.String flgMdp = null;

	/**
	 * imposta il valore del campo [flgMdp]
	 * @param val
	 * @generated
	 */

	public void setFlgMdp(java.lang.String val) {
		flgMdp = val;
	}

	/**
	 * legge il valore del campo [flgMdp]
	 * @generated
	 */
	public java.lang.String getFlgMdp() {
		return flgMdp;
	}

	// il serial version uid e' fisso in quanto la classe in oggetto e' serializzabile
	// solo per la clusterizzazione della sessione web e non viene scambiata con altre
	// componenti.
	private static final long serialVersionUID = 1L;

	/**
	 * Costruttore vuoto del DTO.
	 * @generated
	 */
	public Titolo() {
		super();

	}

	/**
	 * @generated
	 */
	public String toString() {
		/*PROTECTED REGION ID(R-913220507) ENABLED START*/
		/// inserire qui la logica desiderata per la rappresenatazione a stringa
		return super.toString();
		/*PROTECTED REGION END*/
	}
}
