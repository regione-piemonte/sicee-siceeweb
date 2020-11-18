package it.csi.sicee.siceeweb.dto.daticert;

public class DtImpAcqua implements java.io.Serializable {

	/// Field [annoInstallGeneratore]
	private java.lang.String annoInstallGeneratore = null;

	/**
	 * imposta il valore del campo [annoInstallGeneratore]
	 * @param val
	 * @generated
	 */

	public void setAnnoInstallGeneratore(java.lang.String val) {
		annoInstallGeneratore = val;
	}

	/**
	 * legge il valore del campo [annoInstallGeneratore]
	 * @generated
	 */
	public java.lang.String getAnnoInstallGeneratore() {
		return annoInstallGeneratore;
	}

	/// Field [potNomCompl]
	private it.csi.sicee.siceeweb.dto.type.UDTPositiveDoubleFour potNomCompl = null;

	/**
	 * imposta il valore del campo [potNomCompl]
	 * @param val
	 * @generated
	 */

	public void setPotNomCompl(it.csi.sicee.siceeweb.dto.type.UDTPositiveDoubleFour val) {
		potNomCompl = val;
	}

	/**
	 * legge il valore del campo [potNomCompl]
	 * @generated
	 */
	public it.csi.sicee.siceeweb.dto.type.UDTPositiveDoubleFour getPotNomCompl() {
		return potNomCompl;
	}

	/// Field [classeEfficienzaEnerg]
	private java.lang.String classeEfficienzaEnerg = null;

	/**
	 * imposta il valore del campo [classeEfficienzaEnerg]
	 * @param val
	 * @generated
	 */

	public void setClasseEfficienzaEnerg(java.lang.String val) {
		classeEfficienzaEnerg = val;
	}

	/**
	 * legge il valore del campo [classeEfficienzaEnerg]
	 * @generated
	 */
	public java.lang.String getClasseEfficienzaEnerg() {
		return classeEfficienzaEnerg;
	}

	/// Field [combustibileFossile]
	private java.lang.String combustibileFossile = null;

	/**
	 * imposta il valore del campo [combustibileFossile]
	 * @param val
	 * @generated
	 */

	public void setCombustibileFossile(java.lang.String val) {
		combustibileFossile = val;
	}

	/**
	 * legge il valore del campo [combustibileFossile]
	 * @generated
	 */
	public java.lang.String getCombustibileFossile() {
		return combustibileFossile;
	}

	// il serial version uid e' fisso in quanto la classe in oggetto e' serializzabile
	// solo per la clusterizzazione della sessione web e non viene scambiata con altre
	// componenti.
	private static final long serialVersionUID = 1L;

	/**
	 * Costruttore vuoto del DTO.
	 * @generated
	 */
	public DtImpAcqua() {
		super();

	}

	/**
	 * @generated
	 */
	public String toString() {
		/*PROTECTED REGION ID(R-446037713) ENABLED START*/
		/// inserire qui la logica desiderata per la rappresenatazione a stringa
		return super.toString();
		/*PROTECTED REGION END*/
	}
}
