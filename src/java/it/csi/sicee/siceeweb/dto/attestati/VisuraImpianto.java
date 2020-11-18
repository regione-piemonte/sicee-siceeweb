package it.csi.sicee.siceeweb.dto.attestati;

public class VisuraImpianto implements java.io.Serializable {

	/// Field [idRigaTabella]
	private java.lang.Integer idRigaTabella = null;

	/**
	 * imposta il valore del campo [idRigaTabella]
	 * @param val
	 * @generated
	 */

	public void setIdRigaTabella(java.lang.Integer val) {
		idRigaTabella = val;
	}

	/**
	 * legge il valore del campo [idRigaTabella]
	 * @generated
	 */
	public java.lang.Integer getIdRigaTabella() {
		return idRigaTabella;
	}

	/// Field [codiceImpianto]
	private it.csi.sicee.siceeweb.dto.type.UDTPositiveInteger codiceImpianto = null;

	/**
	 * imposta il valore del campo [codiceImpianto]
	 * @param val
	 * @generated
	 */

	public void setCodiceImpianto(it.csi.sicee.siceeweb.dto.type.UDTPositiveInteger val) {
		codiceImpianto = val;
	}

	/**
	 * legge il valore del campo [codiceImpianto]
	 * @generated
	 */
	public it.csi.sicee.siceeweb.dto.type.UDTPositiveInteger getCodiceImpianto() {
		return codiceImpianto;
	}

	/// Field [descStato]
	private java.lang.String descStato = null;

	/**
	 * imposta il valore del campo [descStato]
	 * @param val
	 * @generated
	 */

	public void setDescStato(java.lang.String val) {
		descStato = val;
	}

	/**
	 * legge il valore del campo [descStato]
	 * @generated
	 */
	public java.lang.String getDescStato() {
		return descStato;
	}

	/// Field [dtAssegnazione]
	private java.lang.String dtAssegnazione = null;

	/**
	 * imposta il valore del campo [dtAssegnazione]
	 * @param val
	 * @generated
	 */

	public void setDtAssegnazione(java.lang.String val) {
		dtAssegnazione = val;
	}

	/**
	 * legge il valore del campo [dtAssegnazione]
	 * @generated
	 */
	public java.lang.String getDtAssegnazione() {
		return dtAssegnazione;
	}

	/// Field [dtDismissione]
	private java.lang.String dtDismissione = null;

	/**
	 * imposta il valore del campo [dtDismissione]
	 * @param val
	 * @generated
	 */

	public void setDtDismissione(java.lang.String val) {
		dtDismissione = val;
	}

	/**
	 * legge il valore del campo [dtDismissione]
	 * @generated
	 */
	public java.lang.String getDtDismissione() {
		return dtDismissione;
	}

	/// Field [motivoDisimissione]
	private java.lang.String motivoDisimissione = null;

	/**
	 * imposta il valore del campo [motivoDisimissione]
	 * @param val
	 * @generated
	 */

	public void setMotivoDisimissione(java.lang.String val) {
		motivoDisimissione = val;
	}

	/**
	 * legge il valore del campo [motivoDisimissione]
	 * @generated
	 */
	public java.lang.String getMotivoDisimissione() {
		return motivoDisimissione;
	}

	/// Field [ubicazione]
	private java.lang.String ubicazione = null;

	/**
	 * imposta il valore del campo [ubicazione]
	 * @param val
	 * @generated
	 */

	public void setUbicazione(java.lang.String val) {
		ubicazione = val;
	}

	/**
	 * legge il valore del campo [ubicazione]
	 * @generated
	 */
	public java.lang.String getUbicazione() {
		return ubicazione;
	}

	/// Field [identResponsabile]
	private java.lang.String identResponsabile = null;

	/**
	 * imposta il valore del campo [identResponsabile]
	 * @param val
	 * @generated
	 */

	public void setIdentResponsabile(java.lang.String val) {
		identResponsabile = val;
	}

	/**
	 * legge il valore del campo [identResponsabile]
	 * @generated
	 */
	public java.lang.String getIdentResponsabile() {
		return identResponsabile;
	}

	/// Field [ident3Responsabile]
	private java.lang.String ident3Responsabile = null;

	/**
	 * imposta il valore del campo [ident3Responsabile]
	 * @param val
	 * @generated
	 */

	public void setIdent3Responsabile(java.lang.String val) {
		ident3Responsabile = val;
	}

	/**
	 * legge il valore del campo [ident3Responsabile]
	 * @generated
	 */
	public java.lang.String getIdent3Responsabile() {
		return ident3Responsabile;
	}

	/// Field [dtUltAggLibretto]
	private java.lang.String dtUltAggLibretto = null;

	/**
	 * imposta il valore del campo [dtUltAggLibretto]
	 * @param val
	 * @generated
	 */

	public void setDtUltAggLibretto(java.lang.String val) {
		dtUltAggLibretto = val;
	}

	/**
	 * legge il valore del campo [dtUltAggLibretto]
	 * @generated
	 */
	public java.lang.String getDtUltAggLibretto() {
		return dtUltAggLibretto;
	}

	/// Field [uidIndexLibretto]
	private java.lang.String uidIndexLibretto = null;

	/**
	 * imposta il valore del campo [uidIndexLibretto]
	 * @param val
	 * @generated
	 */

	public void setUidIndexLibretto(java.lang.String val) {
		uidIndexLibretto = val;
	}

	/**
	 * legge il valore del campo [uidIndexLibretto]
	 * @generated
	 */
	public java.lang.String getUidIndexLibretto() {
		return uidIndexLibretto;
	}

	/// Field [rifCatastale]
	private java.util.ArrayList<it.csi.sicee.siceeweb.dto.attestati.VisuraRifCatastale> rifCatastale = new java.util.ArrayList<it.csi.sicee.siceeweb.dto.attestati.VisuraRifCatastale>();

	/**
	 * imposta il valore del campo [rifCatastale]
	 * @param val
	 * @generated
	 */

	public void setRifCatastale(java.util.ArrayList<it.csi.sicee.siceeweb.dto.attestati.VisuraRifCatastale> val) {
		rifCatastale = val;
	}

	/**
	 * legge il valore del campo [rifCatastale]
	 * @generated
	 */
	public java.util.ArrayList<it.csi.sicee.siceeweb.dto.attestati.VisuraRifCatastale> getRifCatastale() {
		return rifCatastale;
	}

	/// Field [rappControllo]
	private java.util.ArrayList<it.csi.sicee.siceeweb.dto.attestati.VisuraRappControllo> rappControllo = new java.util.ArrayList<it.csi.sicee.siceeweb.dto.attestati.VisuraRappControllo>();

	/**
	 * imposta il valore del campo [rappControllo]
	 * @param val
	 * @generated
	 */

	public void setRappControllo(java.util.ArrayList<it.csi.sicee.siceeweb.dto.attestati.VisuraRappControllo> val) {
		rappControllo = val;
	}

	/**
	 * legge il valore del campo [rappControllo]
	 * @generated
	 */
	public java.util.ArrayList<it.csi.sicee.siceeweb.dto.attestati.VisuraRappControllo> getRappControllo() {
		return rappControllo;
	}

	// il serial version uid e' fisso in quanto la classe in oggetto e' serializzabile
	// solo per la clusterizzazione della sessione web e non viene scambiata con altre
	// componenti.
	private static final long serialVersionUID = 1L;

	/**
	 * Costruttore vuoto del DTO.
	 * @generated
	 */
	public VisuraImpianto() {
		super();

	}

	/**
	 * @generated
	 */
	public String toString() {
		/*PROTECTED REGION ID(R-369211784) ENABLED START*/
		/// inserire qui la logica desiderata per la rappresenatazione a stringa
		return super.toString();
		/*PROTECTED REGION END*/
	}
}
