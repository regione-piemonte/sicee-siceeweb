package it.csi.sicee.siceeweb.dto.daticert;

public class DtResponsabili implements java.io.Serializable {

	/// Field [dtProgettista]
	private it.csi.sicee.siceeweb.dto.daticert.SoggResponsabile dtProgettista = null;

	/**
	 * imposta il valore del campo [dtProgettista]
	 * @param val
	 * @generated
	 */

	public void setDtProgettista(it.csi.sicee.siceeweb.dto.daticert.SoggResponsabile val) {
		dtProgettista = val;
	}

	/**
	 * legge il valore del campo [dtProgettista]
	 * @generated
	 */
	public it.csi.sicee.siceeweb.dto.daticert.SoggResponsabile getDtProgettista() {
		return dtProgettista;
	}

	/// Field [dtDirLavori]
	private it.csi.sicee.siceeweb.dto.daticert.SoggResponsabile dtDirLavori = null;

	/**
	 * imposta il valore del campo [dtDirLavori]
	 * @param val
	 * @generated
	 */

	public void setDtDirLavori(it.csi.sicee.siceeweb.dto.daticert.SoggResponsabile val) {
		dtDirLavori = val;
	}

	/**
	 * legge il valore del campo [dtDirLavori]
	 * @generated
	 */
	public it.csi.sicee.siceeweb.dto.daticert.SoggResponsabile getDtDirLavori() {
		return dtDirLavori;
	}

	/// Field [dtCostruttore]
	private it.csi.sicee.siceeweb.dto.daticert.SoggResponsabile dtCostruttore = null;

	/**
	 * imposta il valore del campo [dtCostruttore]
	 * @param val
	 * @generated
	 */

	public void setDtCostruttore(it.csi.sicee.siceeweb.dto.daticert.SoggResponsabile val) {
		dtCostruttore = val;
	}

	/**
	 * legge il valore del campo [dtCostruttore]
	 * @generated
	 */
	public it.csi.sicee.siceeweb.dto.daticert.SoggResponsabile getDtCostruttore() {
		return dtCostruttore;
	}

	// il serial version uid e' fisso in quanto la classe in oggetto e' serializzabile
	// solo per la clusterizzazione della sessione web e non viene scambiata con altre
	// componenti.
	private static final long serialVersionUID = 1L;

	/**
	 * Costruttore vuoto del DTO.
	 * @generated
	 */
	public DtResponsabili() {
		super();

		this.setDtProgettista(new it.csi.sicee.siceeweb.dto.daticert.SoggResponsabile());

		this.setDtDirLavori(new it.csi.sicee.siceeweb.dto.daticert.SoggResponsabile());

		this.setDtCostruttore(new it.csi.sicee.siceeweb.dto.daticert.SoggResponsabile());

	}

	/**
	 * @generated
	 */
	public String toString() {
		/*PROTECTED REGION ID(R457588737) ENABLED START*/
		/// inserire qui la logica desiderata per la rappresenatazione a stringa
		return super.toString();
		/*PROTECTED REGION END*/
	}
}
