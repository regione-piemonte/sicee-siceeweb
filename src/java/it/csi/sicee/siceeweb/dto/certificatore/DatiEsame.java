package it.csi.sicee.siceeweb.dto.certificatore;

import com.opensymphony.xwork2.validator.annotations.*;

/**
 * DTO relativo al ComplexType DatiEsame.
 * @generated 
 */
@Validation
public class DatiEsame implements java.io.Serializable {

	/// Field [id]
	private java.lang.Integer id = null;

	/**
	 * imposta il valore del campo [id]
	 * @param val
	 * @generated
	 */

	public void setId(java.lang.Integer val) {
		id = val;
	}

	/**
	 * legge il valore del campo [id]
	 * @generated
	 */
	public java.lang.Integer getId() {
		return id;
	}

	/// Field [fkCertificatore]
	private java.lang.String fkCertificatore = null;

	/**
	 * imposta il valore del campo [fkCertificatore]
	 * @param val
	 * @generated
	 */

	public void setFkCertificatore(java.lang.String val) {
		fkCertificatore = val;
	}

	/**
	 * legge il valore del campo [fkCertificatore]
	 * @generated
	 */
	public java.lang.String getFkCertificatore() {
		return fkCertificatore;
	}

	/// Field [corso]
	private java.lang.String corso = null;

	/**
	 * imposta il valore del campo [corso]
	 * @param val
	 * @generated
	 */

	public void setCorso(java.lang.String val) {
		corso = val;
	}

	/**
	 * legge il valore del campo [corso]
	 * @generated
	 */
	public java.lang.String getCorso() {
		return corso;
	}

	/// Field [modulo1DataDal]
	private it.csi.sicee.siceeweb.dto.type.UDTDateValid modulo1DataDal = null;

	/**
	 * imposta il valore del campo [modulo1DataDal]
	 * @param val
	 * @generated
	 */
	@CustomValidator(type = "csiUdDateValidator", message = "", key = "DatiEsame.modulo1DataDal.validator.label", parameters = {
			@ValidationParameter(name = "format", value = "dd/MM/yyyy")})
	public void setModulo1DataDal(it.csi.sicee.siceeweb.dto.type.UDTDateValid val) {
		modulo1DataDal = val;
	}

	/**
	 * legge il valore del campo [modulo1DataDal]
	 * @generated
	 */
	public it.csi.sicee.siceeweb.dto.type.UDTDateValid getModulo1DataDal() {
		return modulo1DataDal;
	}

	/// Field [modulo1DataAl]
	private it.csi.sicee.siceeweb.dto.type.UDTDateValid modulo1DataAl = null;

	/**
	 * imposta il valore del campo [modulo1DataAl]
	 * @param val
	 * @generated
	 */
	@CustomValidator(type = "csiUdDateValidator", message = "", key = "DatiEsame.modulo1DataAl.validator.label", parameters = {
			@ValidationParameter(name = "format", value = "dd/MM/yyyy")})
	public void setModulo1DataAl(it.csi.sicee.siceeweb.dto.type.UDTDateValid val) {
		modulo1DataAl = val;
	}

	/**
	 * legge il valore del campo [modulo1DataAl]
	 * @generated
	 */
	public it.csi.sicee.siceeweb.dto.type.UDTDateValid getModulo1DataAl() {
		return modulo1DataAl;
	}

	/// Field [modulo2DataDal]
	private it.csi.sicee.siceeweb.dto.type.UDTDateValid modulo2DataDal = null;

	/**
	 * imposta il valore del campo [modulo2DataDal]
	 * @param val
	 * @generated
	 */
	@CustomValidator(type = "csiUdDateValidator", message = "", key = "DatiEsame.modulo2DataDal.validator.label", parameters = {
			@ValidationParameter(name = "format", value = "dd/MM/yyyy")})
	public void setModulo2DataDal(it.csi.sicee.siceeweb.dto.type.UDTDateValid val) {
		modulo2DataDal = val;
	}

	/**
	 * legge il valore del campo [modulo2DataDal]
	 * @generated
	 */
	public it.csi.sicee.siceeweb.dto.type.UDTDateValid getModulo2DataDal() {
		return modulo2DataDal;
	}

	/// Field [modulo2DataAl]
	private it.csi.sicee.siceeweb.dto.type.UDTDateValid modulo2DataAl = null;

	/**
	 * imposta il valore del campo [modulo2DataAl]
	 * @param val
	 * @generated
	 */
	@CustomValidator(type = "csiUdDateValidator", message = "", key = "DatiEsame.modulo2DataAl.validator.label", parameters = {
			@ValidationParameter(name = "format", value = "dd/MM/yyyy")})
	public void setModulo2DataAl(it.csi.sicee.siceeweb.dto.type.UDTDateValid val) {
		modulo2DataAl = val;
	}

	/**
	 * legge il valore del campo [modulo2DataAl]
	 * @generated
	 */
	public it.csi.sicee.siceeweb.dto.type.UDTDateValid getModulo2DataAl() {
		return modulo2DataAl;
	}

	/// Field [totaleOre]
	private it.csi.sicee.siceeweb.dto.type.UDTPositiveInteger totaleOre = null;

	/**
	 * imposta il valore del campo [totaleOre]
	 * @param val
	 * @generated
	 */

	public void setTotaleOre(it.csi.sicee.siceeweb.dto.type.UDTPositiveInteger val) {
		totaleOre = val;
	}

	/**
	 * legge il valore del campo [totaleOre]
	 * @generated
	 */
	public it.csi.sicee.siceeweb.dto.type.UDTPositiveInteger getTotaleOre() {
		return totaleOre;
	}

	/// Field [attestazionePartecipazione]
	private java.lang.String attestazionePartecipazione = null;

	/**
	 * imposta il valore del campo [attestazionePartecipazione]
	 * @param val
	 * @generated
	 */

	public void setAttestazionePartecipazione(java.lang.String val) {
		attestazionePartecipazione = val;
	}

	/**
	 * legge il valore del campo [attestazionePartecipazione]
	 * @generated
	 */
	public java.lang.String getAttestazionePartecipazione() {
		return attestazionePartecipazione;
	}

	/// Field [dataPartecipazione]
	private it.csi.sicee.siceeweb.dto.type.UDTDateValid dataPartecipazione = null;

	/**
	 * imposta il valore del campo [dataPartecipazione]
	 * @param val
	 * @generated
	 */

	public void setDataPartecipazione(it.csi.sicee.siceeweb.dto.type.UDTDateValid val) {
		dataPartecipazione = val;
	}

	/**
	 * legge il valore del campo [dataPartecipazione]
	 * @generated
	 */
	public it.csi.sicee.siceeweb.dto.type.UDTDateValid getDataPartecipazione() {
		return dataPartecipazione;
	}

	/// Field [attestazioneEsame]
	private java.lang.String attestazioneEsame = null;

	/**
	 * imposta il valore del campo [attestazioneEsame]
	 * @param val
	 * @generated
	 */

	public void setAttestazioneEsame(java.lang.String val) {
		attestazioneEsame = val;
	}

	/**
	 * legge il valore del campo [attestazioneEsame]
	 * @generated
	 */
	public java.lang.String getAttestazioneEsame() {
		return attestazioneEsame;
	}

	/// Field [dataEsame]
	private it.csi.sicee.siceeweb.dto.type.UDTDateValid dataEsame = null;

	/**
	 * imposta il valore del campo [dataEsame]
	 * @param val
	 * @generated
	 */

	public void setDataEsame(it.csi.sicee.siceeweb.dto.type.UDTDateValid val) {
		dataEsame = val;
	}

	/**
	 * legge il valore del campo [dataEsame]
	 * @generated
	 */
	public it.csi.sicee.siceeweb.dto.type.UDTDateValid getDataEsame() {
		return dataEsame;
	}

	/// Field [flagSostenuto]
	private java.lang.String flagSostenuto = null;

	/**
	 * imposta il valore del campo [flagSostenuto]
	 * @param val
	 * @generated
	 */

	public void setFlagSostenuto(java.lang.String val) {
		flagSostenuto = val;
	}

	/**
	 * legge il valore del campo [flagSostenuto]
	 * @generated
	 */
	public java.lang.String getFlagSostenuto() {
		return flagSostenuto;
	}

	// il serial version uid e' fisso in quanto la classe in oggetto e' serializzabile
	// solo per la clusterizzazione della sessione web e non viene scambiata con altre
	// componenti.
	private static final long serialVersionUID = 1L;

	/**
	 * Costruttore vuoto del DTO.
	 * @generated
	 */
	public DatiEsame() {
		super();

	}

	/**
	 * @generated
	 */
	public String toString() {
		/*PROTECTED REGION ID(R-996042337) ENABLED START*/
		/// inserire qui la logica desiderata per la rappresenatazione a stringa
		return super.toString();
		/*PROTECTED REGION END*/
	}
}
