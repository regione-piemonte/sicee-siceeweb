package it.csi.sicee.siceeweb.dto.daticert;

public class DtRispettoNorme implements java.io.Serializable {

	/// Field [dataTitolo]
	private it.csi.sicee.siceeweb.dto.type.UDTDateValid dataTitolo = null;

	/**
	 * imposta il valore del campo [dataTitolo]
	 * @param val
	 * @generated
	 */

	public void setDataTitolo(it.csi.sicee.siceeweb.dto.type.UDTDateValid val) {
		dataTitolo = val;
	}

	/**
	 * legge il valore del campo [dataTitolo]
	 * @generated
	 */
	public it.csi.sicee.siceeweb.dto.type.UDTDateValid getDataTitolo() {
		return dataTitolo;
	}

	/// Field [descrNorma]
	private java.lang.String descrNorma = null;

	/**
	 * imposta il valore del campo [descrNorma]
	 * @param val
	 * @generated
	 */

	public void setDescrNorma(java.lang.String val) {
		descrNorma = val;
	}

	/**
	 * legge il valore del campo [descrNorma]
	 * @generated
	 */
	public java.lang.String getDescrNorma() {
		return descrNorma;
	}

	/// Field [codNorma]
	private java.lang.String codNorma = null;

	/**
	 * imposta il valore del campo [codNorma]
	 * @param val
	 * @generated
	 */

	public void setCodNorma(java.lang.String val) {
		codNorma = val;
	}

	/**
	 * legge il valore del campo [codNorma]
	 * @generated
	 */
	public java.lang.String getCodNorma() {
		return codNorma;
	}

	/// Field [autorizzato]
	private java.lang.String autorizzato = null;

	/**
	 * imposta il valore del campo [autorizzato]
	 * @param val
	 * @generated
	 */

	public void setAutorizzato(java.lang.String val) {
		autorizzato = val;
	}

	/**
	 * legge il valore del campo [autorizzato]
	 * @generated
	 */
	public java.lang.String getAutorizzato() {
		return autorizzato;
	}

	/// Field [motivoNonConformita]
	private java.lang.String motivoNonConformita = null;

	/**
	 * imposta il valore del campo [motivoNonConformita]
	 * @param val
	 * @generated
	 */

	public void setMotivoNonConformita(java.lang.String val) {
		motivoNonConformita = val;
	}

	/**
	 * legge il valore del campo [motivoNonConformita]
	 * @generated
	 */
	public java.lang.String getMotivoNonConformita() {
		return motivoNonConformita;
	}

	/// Field [note]
	private java.lang.String note = null;

	/**
	 * imposta il valore del campo [note]
	 * @param val
	 * @generated
	 */

	public void setNote(java.lang.String val) {
		note = val;
	}

	/**
	 * legge il valore del campo [note]
	 * @generated
	 */
	public java.lang.String getNote() {
		return note;
	}

	// il serial version uid e' fisso in quanto la classe in oggetto e' serializzabile
	// solo per la clusterizzazione della sessione web e non viene scambiata con altre
	// componenti.
	private static final long serialVersionUID = 1L;

	/**
	 * Costruttore vuoto del DTO.
	 * @generated
	 */
	public DtRispettoNorme() {
		super();

	}

	/**
	 * @generated
	 */
	public String toString() {
		/*PROTECTED REGION ID(R-2053142621) ENABLED START*/
		/// inserire qui la logica desiderata per la rappresenatazione a stringa
		return super.toString();
		/*PROTECTED REGION END*/
	}
}
