package it.csi.sicee.siceeweb.dto.certificatore;

public class DatiCompetenze implements java.io.Serializable {

	/// Field [edifici]
	private java.lang.String edifici = null;

	/**
	 * imposta il valore del campo [edifici]
	 * @param val
	 * @generated
	 */

	public void setEdifici(java.lang.String val) {
		edifici = val;
	}

	/**
	 * legge il valore del campo [edifici]
	 * @generated
	 */
	public java.lang.String getEdifici() {
		return edifici;
	}

	/// Field [impianti]
	private java.lang.String impianti = null;

	/**
	 * imposta il valore del campo [impianti]
	 * @param val
	 * @generated
	 */

	public void setImpianti(java.lang.String val) {
		impianti = val;
	}

	/**
	 * legge il valore del campo [impianti]
	 * @generated
	 */
	public java.lang.String getImpianti() {
		return impianti;
	}

	// il serial version uid e' fisso in quanto la classe in oggetto e' serializzabile
	// solo per la clusterizzazione della sessione web e non viene scambiata con altre
	// componenti.
	private static final long serialVersionUID = 1L;

	/**
	 * Costruttore vuoto del DTO.
	 * @generated
	 */
	public DatiCompetenze() {
		super();

	}

	/**
	 * @generated
	 */
	public String toString() {
		/*PROTECTED REGION ID(R450736150) ENABLED START*/
		/// inserire qui la logica desiderata per la rappresenatazione a stringa
		return super.toString();
		/*PROTECTED REGION END*/
	}
}
