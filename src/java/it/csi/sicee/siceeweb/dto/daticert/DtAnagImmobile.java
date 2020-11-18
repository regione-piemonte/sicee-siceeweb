package it.csi.sicee.siceeweb.dto.daticert;

public class DtAnagImmobile implements java.io.Serializable {

	/// Field [dtCatastali]
	private it.csi.sicee.siceeweb.dto.daticert.DtCatastali dtCatastali = null;

	/**
	 * imposta il valore del campo [dtCatastali]
	 * @param val
	 * @generated
	 */

	public void setDtCatastali(it.csi.sicee.siceeweb.dto.daticert.DtCatastali val) {
		dtCatastali = val;
	}

	/**
	 * legge il valore del campo [dtCatastali]
	 * @generated
	 */
	public it.csi.sicee.siceeweb.dto.daticert.DtCatastali getDtCatastali() {
		return dtCatastali;
	}

	/// Field [dtResponsabili]
	private it.csi.sicee.siceeweb.dto.daticert.DtResponsabili dtResponsabili = null;

	/**
	 * imposta il valore del campo [dtResponsabili]
	 * @param val
	 * @generated
	 */

	public void setDtResponsabili(it.csi.sicee.siceeweb.dto.daticert.DtResponsabili val) {
		dtResponsabili = val;
	}

	/**
	 * legge il valore del campo [dtResponsabili]
	 * @generated
	 */
	public it.csi.sicee.siceeweb.dto.daticert.DtResponsabili getDtResponsabili() {
		return dtResponsabili;
	}

	/// Field [dtCoCertificatore]
	private it.csi.sicee.siceeweb.dto.daticert.DtCoCertificatore dtCoCertificatore = null;

	/**
	 * imposta il valore del campo [dtCoCertificatore]
	 * @param val
	 * @generated
	 */

	public void setDtCoCertificatore(it.csi.sicee.siceeweb.dto.daticert.DtCoCertificatore val) {
		dtCoCertificatore = val;
	}

	/**
	 * legge il valore del campo [dtCoCertificatore]
	 * @generated
	 */
	public it.csi.sicee.siceeweb.dto.daticert.DtCoCertificatore getDtCoCertificatore() {
		return dtCoCertificatore;
	}

	// il serial version uid e' fisso in quanto la classe in oggetto e' serializzabile
	// solo per la clusterizzazione della sessione web e non viene scambiata con altre
	// componenti.
	private static final long serialVersionUID = 1L;

	/**
	 * Costruttore vuoto del DTO.
	 * @generated
	 */
	public DtAnagImmobile() {
		super();

		this.setDtCatastali(new it.csi.sicee.siceeweb.dto.daticert.DtCatastali());

		this.setDtResponsabili(new it.csi.sicee.siceeweb.dto.daticert.DtResponsabili());

		this.setDtCoCertificatore(new it.csi.sicee.siceeweb.dto.daticert.DtCoCertificatore());

	}

	/**
	 * @generated
	 */
	public String toString() {
		/*PROTECTED REGION ID(R-441627847) ENABLED START*/
		/// inserire qui la logica desiderata per la rappresenatazione a stringa
		return super.toString();
		/*PROTECTED REGION END*/
	}
}
