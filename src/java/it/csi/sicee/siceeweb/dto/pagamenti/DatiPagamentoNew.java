package it.csi.sicee.siceeweb.dto.pagamenti;

public class DatiPagamentoNew implements java.io.Serializable {

	/// Field [idTransazione2018]
	private int idTransazione2018 = 0;

	/**
	 * imposta il valore del campo [idTransazione2018]
	 * @param val
	 * @generated
	 */

	public void setIdTransazione2018(int val) {
		idTransazione2018 = val;
	}

	/**
	 * legge il valore del campo [idTransazione2018]
	 * @generated
	 */
	public int getIdTransazione2018() {
		return idTransazione2018;
	}

	/// Field [idTransMdp]
	private java.lang.String idTransMdp = null;

	/**
	 * imposta il valore del campo [idTransMdp]
	 * @param val
	 * @generated
	 */

	public void setIdTransMdp(java.lang.String val) {
		idTransMdp = val;
	}

	/**
	 * legge il valore del campo [idTransMdp]
	 * @generated
	 */
	public java.lang.String getIdTransMdp() {
		return idTransMdp;
	}

	/// Field [idInformativaMdp]
	private int idInformativaMdp = 0;

	/**
	 * imposta il valore del campo [idInformativaMdp]
	 * @param val
	 * @generated
	 */

	public void setIdInformativaMdp(int val) {
		idInformativaMdp = val;
	}

	/**
	 * legge il valore del campo [idInformativaMdp]
	 * @generated
	 */
	public int getIdInformativaMdp() {
		return idInformativaMdp;
	}

	/// Field [importo]
	private it.csi.sicee.siceeweb.dto.type.UDTPositiveDoubleTwo importo = null;

	/**
	 * imposta il valore del campo [importo]
	 * @param val
	 * @generated
	 */

	public void setImporto(it.csi.sicee.siceeweb.dto.type.UDTPositiveDoubleTwo val) {
		importo = val;
	}

	/**
	 * legge il valore del campo [importo]
	 * @generated
	 */
	public it.csi.sicee.siceeweb.dto.type.UDTPositiveDoubleTwo getImporto() {
		return importo;
	}

	/// Field [tipoPersona]
	private java.lang.String tipoPersona = null;

	/**
	 * imposta il valore del campo [tipoPersona]
	 * @param val
	 * @generated
	 */

	public void setTipoPersona(java.lang.String val) {
		tipoPersona = val;
	}

	/**
	 * legge il valore del campo [tipoPersona]
	 * @generated
	 */
	public java.lang.String getTipoPersona() {
		return tipoPersona;
	}

	/// Field [tipoPersonaDesc]
	private java.lang.String tipoPersonaDesc = null;

	/**
	 * imposta il valore del campo [tipoPersonaDesc]
	 * @param val
	 * @generated
	 */

	public void setTipoPersonaDesc(java.lang.String val) {
		tipoPersonaDesc = val;
	}

	/**
	 * legge il valore del campo [tipoPersonaDesc]
	 * @generated
	 */
	public java.lang.String getTipoPersonaDesc() {
		return tipoPersonaDesc;
	}

	/// Field [codiceFiscale]
	private java.lang.String codiceFiscale = null;

	/**
	 * imposta il valore del campo [codiceFiscale]
	 * @param val
	 * @generated
	 */

	public void setCodiceFiscale(java.lang.String val) {
		codiceFiscale = val;
	}

	/**
	 * legge il valore del campo [codiceFiscale]
	 * @generated
	 */
	public java.lang.String getCodiceFiscale() {
		return codiceFiscale;
	}

	/// Field [anagraficaVersante]
	private java.lang.String anagraficaVersante = null;

	/**
	 * imposta il valore del campo [anagraficaVersante]
	 * @param val
	 * @generated
	 */

	public void setAnagraficaVersante(java.lang.String val) {
		anagraficaVersante = val;
	}

	/**
	 * legge il valore del campo [anagraficaVersante]
	 * @generated
	 */
	public java.lang.String getAnagraficaVersante() {
		return anagraficaVersante;
	}

	/// Field [dtTransazione]
	private java.lang.String dtTransazione = null;

	/**
	 * imposta il valore del campo [dtTransazione]
	 * @param val
	 * @generated
	 */

	public void setDtTransazione(java.lang.String val) {
		dtTransazione = val;
	}

	/**
	 * legge il valore del campo [dtTransazione]
	 * @generated
	 */
	public java.lang.String getDtTransazione() {
		return dtTransazione;
	}

	/// Field [idCertificatore]
	private int idCertificatore = 0;

	/**
	 * imposta il valore del campo [idCertificatore]
	 * @param val
	 * @generated
	 */

	public void setIdCertificatore(int val) {
		idCertificatore = val;
	}

	/**
	 * legge il valore del campo [idCertificatore]
	 * @generated
	 */
	public int getIdCertificatore() {
		return idCertificatore;
	}

	/// Field [idStatoTrans2018]
	private int idStatoTrans2018 = 0;

	/**
	 * imposta il valore del campo [idStatoTrans2018]
	 * @param val
	 * @generated
	 */

	public void setIdStatoTrans2018(int val) {
		idStatoTrans2018 = val;
	}

	/**
	 * legge il valore del campo [idStatoTrans2018]
	 * @generated
	 */
	public int getIdStatoTrans2018() {
		return idStatoTrans2018;
	}

	// il serial version uid e' fisso in quanto la classe in oggetto e' serializzabile
	// solo per la clusterizzazione della sessione web e non viene scambiata con altre
	// componenti.
	private static final long serialVersionUID = 1L;

	/**
	 * Costruttore vuoto del DTO.
	 * @generated
	 */
	public DatiPagamentoNew() {
		super();

	}

	/**
	 * @generated
	 */
	public String toString() {
		/*PROTECTED REGION ID(R-239597398) ENABLED START*/
		/// inserire qui la logica desiderata per la rappresenatazione a stringa
		return super.toString();
		/*PROTECTED REGION END*/
	}
}
