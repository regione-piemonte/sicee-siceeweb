package it.csi.sicee.siceeweb.dto.attestati;

public class Raccomandazione implements java.io.Serializable {

	/// Field [id]
	private java.lang.String id = null;

	/**
	 * imposta il valore del campo [id]
	 * @param val
	 * @generated
	 */

	public void setId(java.lang.String val) {
		id = val;
	}

	/**
	 * legge il valore del campo [id]
	 * @generated
	 */
	public java.lang.String getId() {
		return id;
	}

	/// Field [codSistema]
	private java.lang.String codSistema = null;

	/**
	 * imposta il valore del campo [codSistema]
	 * @param val
	 * @generated
	 */

	public void setCodSistema(java.lang.String val) {
		codSistema = val;
	}

	/**
	 * legge il valore del campo [codSistema]
	 * @generated
	 */
	public java.lang.String getCodSistema() {
		return codSistema;
	}

	/// Field [intervento]
	private java.lang.String intervento = null;

	/**
	 * imposta il valore del campo [intervento]
	 * @param val
	 * @generated
	 */

	public void setIntervento(java.lang.String val) {
		intervento = val;
	}

	/**
	 * legge il valore del campo [intervento]
	 * @generated
	 */
	public java.lang.String getIntervento() {
		return intervento;
	}

	/// Field [priorita]
	private java.lang.String priorita = null;

	/**
	 * imposta il valore del campo [priorita]
	 * @param val
	 * @generated
	 */

	public void setPriorita(java.lang.String val) {
		priorita = val;
	}

	/**
	 * legge il valore del campo [priorita]
	 * @generated
	 */
	public java.lang.String getPriorita() {
		return priorita;
	}

	/// Field [tempoRitorno]
	private java.lang.String tempoRitorno = null;

	/**
	 * imposta il valore del campo [tempoRitorno]
	 * @param val
	 * @generated
	 */

	public void setTempoRitorno(java.lang.String val) {
		tempoRitorno = val;
	}

	/**
	 * legge il valore del campo [tempoRitorno]
	 * @generated
	 */
	public java.lang.String getTempoRitorno() {
		return tempoRitorno;
	}

	/// Field [descrPriorita]
	private java.lang.String descrPriorita = null;

	/**
	 * imposta il valore del campo [descrPriorita]
	 * @param val
	 * @generated
	 */

	public void setDescrPriorita(java.lang.String val) {
		descrPriorita = val;
	}

	/**
	 * legge il valore del campo [descrPriorita]
	 * @generated
	 */
	public java.lang.String getDescrPriorita() {
		return descrPriorita;
	}

	// il serial version uid e' fisso in quanto la classe in oggetto e' serializzabile
	// solo per la clusterizzazione della sessione web e non viene scambiata con altre
	// componenti.
	private static final long serialVersionUID = 1L;

	/**
	 * Costruttore vuoto del DTO.
	 * @generated
	 */
	public Raccomandazione() {
		super();

	}

	/**
	 * @generated
	 */
	public String toString() {
		/*PROTECTED REGION ID(R267999625) ENABLED START*/
		/// inserire qui la logica desiderata per la rappresenatazione a stringa
		return super.toString();
		/*PROTECTED REGION END*/
	}
}
