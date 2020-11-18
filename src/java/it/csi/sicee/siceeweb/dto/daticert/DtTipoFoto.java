package it.csi.sicee.siceeweb.dto.daticert;

public class DtTipoFoto implements java.io.Serializable {

	/// Field [idTipoFoto]
	private int idTipoFoto = 0;

	/**
	 * imposta il valore del campo [idTipoFoto]
	 * @param val
	 * @generated
	 */

	public void setIdTipoFoto(int val) {
		idTipoFoto = val;
	}

	/**
	 * legge il valore del campo [idTipoFoto]
	 * @generated
	 */
	public int getIdTipoFoto() {
		return idTipoFoto;
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

	// il serial version uid e' fisso in quanto la classe in oggetto e' serializzabile
	// solo per la clusterizzazione della sessione web e non viene scambiata con altre
	// componenti.
	private static final long serialVersionUID = 1L;

	/**
	 * Costruttore vuoto del DTO.
	 * @generated
	 */
	public DtTipoFoto() {
		super();

	}

	/**
	 * @generated
	 */
	public String toString() {
		/*PROTECTED REGION ID(R693603224) ENABLED START*/
		/// inserire qui la logica desiderata per la rappresenatazione a stringa
		return super.toString();
		/*PROTECTED REGION END*/
	}
}
