package it.csi.sicee.siceeweb.dto.pagamenti;

public class GestioneCreditoNew implements java.io.Serializable {

	/// Field [importoApe]
	private java.lang.Float importoApe = null;

	/**
	 * imposta il valore del campo [importoApe]
	 * @param val
	 * @generated
	 */

	public void setImportoApe(java.lang.Float val) {
		importoApe = val;
	}

	/**
	 * legge il valore del campo [importoApe]
	 * @generated
	 */
	public java.lang.Float getImportoApe() {
		return importoApe;
	}

	/// Field [importoRegistrazione]
	private java.lang.Float importoRegistrazione = null;

	/**
	 * imposta il valore del campo [importoRegistrazione]
	 * @param val
	 * @generated
	 */

	public void setImportoRegistrazione(java.lang.Float val) {
		importoRegistrazione = val;
	}

	/**
	 * legge il valore del campo [importoRegistrazione]
	 * @generated
	 */
	public java.lang.Float getImportoRegistrazione() {
		return importoRegistrazione;
	}

	/// Field [importoAquisto]
	private java.lang.Float importoAquisto = null;

	/**
	 * imposta il valore del campo [importoAquisto]
	 * @param val
	 * @generated
	 */

	public void setImportoAquisto(java.lang.Float val) {
		importoAquisto = val;
	}

	/**
	 * legge il valore del campo [importoAquisto]
	 * @generated
	 */
	public java.lang.Float getImportoAquisto() {
		return importoAquisto;
	}

	/// Field [numeroApe]
	private java.lang.String numeroApe = null;

	/**
	 * imposta il valore del campo [numeroApe]
	 * @param val
	 * @generated
	 */

	public void setNumeroApe(java.lang.String val) {
		numeroApe = val;
	}

	/**
	 * legge il valore del campo [numeroApe]
	 * @generated
	 */
	public java.lang.String getNumeroApe() {
		return numeroApe;
	}

	/// Field [creditoDisponibile]
	private java.lang.Float creditoDisponibile = null;

	/**
	 * imposta il valore del campo [creditoDisponibile]
	 * @param val
	 * @generated
	 */

	public void setCreditoDisponibile(java.lang.Float val) {
		creditoDisponibile = val;
	}

	/**
	 * legge il valore del campo [creditoDisponibile]
	 * @generated
	 */
	public java.lang.Float getCreditoDisponibile() {
		return creditoDisponibile;
	}

	// il serial version uid e' fisso in quanto la classe in oggetto e' serializzabile
	// solo per la clusterizzazione della sessione web e non viene scambiata con altre
	// componenti.
	private static final long serialVersionUID = 1L;

	/**
	 * Costruttore vuoto del DTO.
	 * @generated
	 */
	public GestioneCreditoNew() {
		super();

	}

	/**
	 * @generated
	 */
	public String toString() {
		/*PROTECTED REGION ID(R1682356388) ENABLED START*/
		/// inserire qui la logica desiderata per la rappresenatazione a stringa
		return super.toString();
		/*PROTECTED REGION END*/
	}
}
