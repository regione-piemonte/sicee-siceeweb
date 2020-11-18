package it.csi.sicee.siceeweb.dto.daticert;

public class DtDichiarazFinale implements java.io.Serializable {

	/// Field [codDichiaraz]
	private java.lang.Integer codDichiaraz = null;

	/**
	 * imposta il valore del campo [codDichiaraz]
	 * @param val
	 * @generated
	 */

	public void setCodDichiaraz(java.lang.Integer val) {
		codDichiaraz = val;
	}

	/**
	 * legge il valore del campo [codDichiaraz]
	 * @generated
	 */
	public java.lang.Integer getCodDichiaraz() {
		return codDichiaraz;
	}

	/// Field [dataDichiarazione]
	private it.csi.sicee.siceeweb.dto.type.UDTDateValid dataDichiarazione = null;

	/**
	 * imposta il valore del campo [dataDichiarazione]
	 * @param val
	 * @generated
	 */

	public void setDataDichiarazione(it.csi.sicee.siceeweb.dto.type.UDTDateValid val) {
		dataDichiarazione = val;
	}

	/**
	 * legge il valore del campo [dataDichiarazione]
	 * @generated
	 */
	public it.csi.sicee.siceeweb.dto.type.UDTDateValid getDataDichiarazione() {
		return dataDichiarazione;
	}

	/// Field [luogoDichiarazione]
	private java.lang.String luogoDichiarazione = null;

	/**
	 * imposta il valore del campo [luogoDichiarazione]
	 * @param val
	 * @generated
	 */

	public void setLuogoDichiarazione(java.lang.String val) {
		luogoDichiarazione = val;
	}

	/**
	 * legge il valore del campo [luogoDichiarazione]
	 * @generated
	 */
	public java.lang.String getLuogoDichiarazione() {
		return luogoDichiarazione;
	}

	// il serial version uid e' fisso in quanto la classe in oggetto e' serializzabile
	// solo per la clusterizzazione della sessione web e non viene scambiata con altre
	// componenti.
	private static final long serialVersionUID = 1L;

	/**
	 * Costruttore vuoto del DTO.
	 * @generated
	 */
	public DtDichiarazFinale() {
		super();

	}

	/**
	 * @generated
	 */
	public String toString() {
		/*PROTECTED REGION ID(R-2146785584) ENABLED START*/
		/// inserire qui la logica desiderata per la rappresenatazione a stringa
		return super.toString();
		/*PROTECTED REGION END*/
	}
}
