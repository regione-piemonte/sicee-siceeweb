package it.csi.sicee.siceeweb.dto.daticert;

public class DtClasseEnerg implements java.io.Serializable {

	/// Field [locReale]
	private it.csi.sicee.siceeweb.dto.daticert.DtLocReale locReale = null;

	/**
	 * imposta il valore del campo [locReale]
	 * @param val
	 * @generated
	 */

	public void setLocReale(it.csi.sicee.siceeweb.dto.daticert.DtLocReale val) {
		locReale = val;
	}

	/**
	 * legge il valore del campo [locReale]
	 * @generated
	 */
	public it.csi.sicee.siceeweb.dto.daticert.DtLocReale getLocReale() {
		return locReale;
	}

	/// Field [locTeorica]
	private it.csi.sicee.siceeweb.dto.daticert.DtLocTeorica locTeorica = null;

	/**
	 * imposta il valore del campo [locTeorica]
	 * @param val
	 * @generated
	 */

	public void setLocTeorica(it.csi.sicee.siceeweb.dto.daticert.DtLocTeorica val) {
		locTeorica = val;
	}

	/**
	 * legge il valore del campo [locTeorica]
	 * @generated
	 */
	public it.csi.sicee.siceeweb.dto.daticert.DtLocTeorica getLocTeorica() {
		return locTeorica;
	}

	// il serial version uid e' fisso in quanto la classe in oggetto e' serializzabile
	// solo per la clusterizzazione della sessione web e non viene scambiata con altre
	// componenti.
	private static final long serialVersionUID = 1L;

	/**
	 * Costruttore vuoto del DTO.
	 * @generated
	 */
	public DtClasseEnerg() {
		super();

		this.setLocReale(new it.csi.sicee.siceeweb.dto.daticert.DtLocReale());

		this.setLocTeorica(new it.csi.sicee.siceeweb.dto.daticert.DtLocTeorica());

	}

	/**
	 * @generated
	 */
	public String toString() {
		/*PROTECTED REGION ID(R-1869963972) ENABLED START*/
		/// inserire qui la logica desiderata per la rappresenatazione a stringa
		return super.toString();
		/*PROTECTED REGION END*/
	}
}
