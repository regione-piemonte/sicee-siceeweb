package it.csi.sicee.siceeweb.dto.daticert;

public class DtGasSerra implements java.io.Serializable {

	/// Field [emissioniGasSerra]
	private it.csi.sicee.siceeweb.dto.type.UDTPositiveDoubleFour emissioniGasSerra = null;

	/**
	 * imposta il valore del campo [emissioniGasSerra]
	 * @param val
	 * @generated
	 */

	public void setEmissioniGasSerra(it.csi.sicee.siceeweb.dto.type.UDTPositiveDoubleFour val) {
		emissioniGasSerra = val;
	}

	/**
	 * legge il valore del campo [emissioniGasSerra]
	 * @generated
	 */
	public it.csi.sicee.siceeweb.dto.type.UDTPositiveDoubleFour getEmissioniGasSerra() {
		return emissioniGasSerra;
	}

	/// Field [supBoscoEquiv]
	private it.csi.sicee.siceeweb.dto.type.UDTPositiveDoubleFive supBoscoEquiv = null;

	/**
	 * imposta il valore del campo [supBoscoEquiv]
	 * @param val
	 * @generated
	 */

	public void setSupBoscoEquiv(it.csi.sicee.siceeweb.dto.type.UDTPositiveDoubleFive val) {
		supBoscoEquiv = val;
	}

	/**
	 * legge il valore del campo [supBoscoEquiv]
	 * @generated
	 */
	public it.csi.sicee.siceeweb.dto.type.UDTPositiveDoubleFive getSupBoscoEquiv() {
		return supBoscoEquiv;
	}

	// il serial version uid e' fisso in quanto la classe in oggetto e' serializzabile
	// solo per la clusterizzazione della sessione web e non viene scambiata con altre
	// componenti.
	private static final long serialVersionUID = 1L;

	/**
	 * Costruttore vuoto del DTO.
	 * @generated
	 */
	public DtGasSerra() {
		super();

	}

	/**
	 * @generated
	 */
	public String toString() {
		/*PROTECTED REGION ID(R507037302) ENABLED START*/
		/// inserire qui la logica desiderata per la rappresenatazione a stringa
		return super.toString();
		/*PROTECTED REGION END*/
	}
}
