package it.csi.sicee.siceeweb.dto.daticert;

public class DtEnergiaFontiRinnov implements java.io.Serializable {

	/// Field [techFontiRinnov]
	private java.lang.String techFontiRinnov = null;

	/**
	 * imposta il valore del campo [techFontiRinnov]
	 * @param val
	 * @generated
	 */

	public void setTechFontiRinnov(java.lang.String val) {
		techFontiRinnov = val;
	}

	/**
	 * legge il valore del campo [techFontiRinnov]
	 * @generated
	 */
	public java.lang.String getTechFontiRinnov() {
		return techFontiRinnov;
	}

	/// Field [annoInstall]
	private java.lang.String annoInstall = null;

	/**
	 * imposta il valore del campo [annoInstall]
	 * @param val
	 * @generated
	 */

	public void setAnnoInstall(java.lang.String val) {
		annoInstall = val;
	}

	/**
	 * legge il valore del campo [annoInstall]
	 * @generated
	 */
	public java.lang.String getAnnoInstall() {
		return annoInstall;
	}

	/// Field [energTermicaProdotta]
	private it.csi.sicee.siceeweb.dto.type.UDTPositiveDoubleFour energTermicaProdotta = null;

	/**
	 * imposta il valore del campo [energTermicaProdotta]
	 * @param val
	 * @generated
	 */

	public void setEnergTermicaProdotta(it.csi.sicee.siceeweb.dto.type.UDTPositiveDoubleFour val) {
		energTermicaProdotta = val;
	}

	/**
	 * legge il valore del campo [energTermicaProdotta]
	 * @generated
	 */
	public it.csi.sicee.siceeweb.dto.type.UDTPositiveDoubleFour getEnergTermicaProdotta() {
		return energTermicaProdotta;
	}

	/// Field [energElettricaProdotta]
	private it.csi.sicee.siceeweb.dto.type.UDTPositiveDoubleFour energElettricaProdotta = null;

	/**
	 * imposta il valore del campo [energElettricaProdotta]
	 * @param val
	 * @generated
	 */

	public void setEnergElettricaProdotta(it.csi.sicee.siceeweb.dto.type.UDTPositiveDoubleFour val) {
		energElettricaProdotta = val;
	}

	/**
	 * legge il valore del campo [energElettricaProdotta]
	 * @generated
	 */
	public it.csi.sicee.siceeweb.dto.type.UDTPositiveDoubleFour getEnergElettricaProdotta() {
		return energElettricaProdotta;
	}

	/// Field [autoconsumoTermico]
	private it.csi.sicee.siceeweb.dto.type.UDTPositiveDoubleFour autoconsumoTermico = null;

	/**
	 * imposta il valore del campo [autoconsumoTermico]
	 * @param val
	 * @generated
	 */

	public void setAutoconsumoTermico(it.csi.sicee.siceeweb.dto.type.UDTPositiveDoubleFour val) {
		autoconsumoTermico = val;
	}

	/**
	 * legge il valore del campo [autoconsumoTermico]
	 * @generated
	 */
	public it.csi.sicee.siceeweb.dto.type.UDTPositiveDoubleFour getAutoconsumoTermico() {
		return autoconsumoTermico;
	}

	/// Field [autoconsumoElettrico]
	private it.csi.sicee.siceeweb.dto.type.UDTPositiveDoubleFour autoconsumoElettrico = null;

	/**
	 * imposta il valore del campo [autoconsumoElettrico]
	 * @param val
	 * @generated
	 */

	public void setAutoconsumoElettrico(it.csi.sicee.siceeweb.dto.type.UDTPositiveDoubleFour val) {
		autoconsumoElettrico = val;
	}

	/**
	 * legge il valore del campo [autoconsumoElettrico]
	 * @generated
	 */
	public it.csi.sicee.siceeweb.dto.type.UDTPositiveDoubleFour getAutoconsumoElettrico() {
		return autoconsumoElettrico;
	}

	/// Field [percEnergiaFontiRinnov]
	private it.csi.sicee.siceeweb.dto.type.UDTPositiveDoubleTwo percEnergiaFontiRinnov = null;

	/**
	 * imposta il valore del campo [percEnergiaFontiRinnov]
	 * @param val
	 * @generated
	 */

	public void setPercEnergiaFontiRinnov(it.csi.sicee.siceeweb.dto.type.UDTPositiveDoubleTwo val) {
		percEnergiaFontiRinnov = val;
	}

	/**
	 * legge il valore del campo [percEnergiaFontiRinnov]
	 * @generated
	 */
	public it.csi.sicee.siceeweb.dto.type.UDTPositiveDoubleTwo getPercEnergiaFontiRinnov() {
		return percEnergiaFontiRinnov;
	}

	// il serial version uid e' fisso in quanto la classe in oggetto e' serializzabile
	// solo per la clusterizzazione della sessione web e non viene scambiata con altre
	// componenti.
	private static final long serialVersionUID = 1L;

	/**
	 * Costruttore vuoto del DTO.
	 * @generated
	 */
	public DtEnergiaFontiRinnov() {
		super();

	}

	/**
	 * @generated
	 */
	public String toString() {
		/*PROTECTED REGION ID(R1801579919) ENABLED START*/
		/// inserire qui la logica desiderata per la rappresenatazione a stringa
		return super.toString();
		/*PROTECTED REGION END*/
	}
}
