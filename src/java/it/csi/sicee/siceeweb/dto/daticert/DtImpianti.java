package it.csi.sicee.siceeweb.dto.daticert;

public class DtImpianti implements java.io.Serializable {

	/// Field [riscaldamento]
	private it.csi.sicee.siceeweb.dto.daticert.DtImpRiscald riscaldamento = null;

	/**
	 * imposta il valore del campo [riscaldamento]
	 * @param val
	 * @generated
	 */

	public void setRiscaldamento(it.csi.sicee.siceeweb.dto.daticert.DtImpRiscald val) {
		riscaldamento = val;
	}

	/**
	 * legge il valore del campo [riscaldamento]
	 * @generated
	 */
	public it.csi.sicee.siceeweb.dto.daticert.DtImpRiscald getRiscaldamento() {
		return riscaldamento;
	}

	/// Field [acqua]
	private it.csi.sicee.siceeweb.dto.daticert.DtImpAcqua acqua = null;

	/**
	 * imposta il valore del campo [acqua]
	 * @param val
	 * @generated
	 */

	public void setAcqua(it.csi.sicee.siceeweb.dto.daticert.DtImpAcqua val) {
		acqua = val;
	}

	/**
	 * legge il valore del campo [acqua]
	 * @generated
	 */
	public it.csi.sicee.siceeweb.dto.daticert.DtImpAcqua getAcqua() {
		return acqua;
	}

	/// Field [uiServite]
	private java.lang.String uiServite = null;

	/**
	 * imposta il valore del campo [uiServite]
	 * @param val
	 * @generated
	 */

	public void setUiServite(java.lang.String val) {
		uiServite = val;
	}

	/**
	 * legge il valore del campo [uiServite]
	 * @generated
	 */
	public java.lang.String getUiServite() {
		return uiServite;
	}

	/// Field [flgRipartizione]
	private java.lang.String flgRipartizione = null;

	/**
	 * imposta il valore del campo [flgRipartizione]
	 * @param val
	 * @generated
	 */

	public void setFlgRipartizione(java.lang.String val) {
		flgRipartizione = val;
	}

	/**
	 * legge il valore del campo [flgRipartizione]
	 * @generated
	 */
	public java.lang.String getFlgRipartizione() {
		return flgRipartizione;
	}

	/// Field [tipoTermErogaz]
	private java.lang.String tipoTermErogaz = null;

	/**
	 * imposta il valore del campo [tipoTermErogaz]
	 * @param val
	 * @generated
	 */

	public void setTipoTermErogaz(java.lang.String val) {
		tipoTermErogaz = val;
	}

	/**
	 * legge il valore del campo [tipoTermErogaz]
	 * @generated
	 */
	public java.lang.String getTipoTermErogaz() {
		return tipoTermErogaz;
	}

	/// Field [tipoDistrib]
	private java.lang.String tipoDistrib = null;

	/**
	 * imposta il valore del campo [tipoDistrib]
	 * @param val
	 * @generated
	 */

	public void setTipoDistrib(java.lang.String val) {
		tipoDistrib = val;
	}

	/**
	 * legge il valore del campo [tipoDistrib]
	 * @generated
	 */
	public java.lang.String getTipoDistrib() {
		return tipoDistrib;
	}

	/// Field [tipoRegolaz]
	private java.lang.String tipoRegolaz = null;

	/**
	 * imposta il valore del campo [tipoRegolaz]
	 * @param val
	 * @generated
	 */

	public void setTipoRegolaz(java.lang.String val) {
		tipoRegolaz = val;
	}

	/**
	 * legge il valore del campo [tipoRegolaz]
	 * @generated
	 */
	public java.lang.String getTipoRegolaz() {
		return tipoRegolaz;
	}

	// il serial version uid e' fisso in quanto la classe in oggetto e' serializzabile
	// solo per la clusterizzazione della sessione web e non viene scambiata con altre
	// componenti.
	private static final long serialVersionUID = 1L;

	/**
	 * Costruttore vuoto del DTO.
	 * @generated
	 */
	public DtImpianti() {
		super();

		this.setRiscaldamento(new it.csi.sicee.siceeweb.dto.daticert.DtImpRiscald());

		this.setAcqua(new it.csi.sicee.siceeweb.dto.daticert.DtImpAcqua());

	}

	/**
	 * @generated
	 */
	public String toString() {
		/*PROTECTED REGION ID(R162244927) ENABLED START*/
		/// inserire qui la logica desiderata per la rappresenatazione a stringa
		return super.toString();
		/*PROTECTED REGION END*/
	}
}
