package it.csi.sicee.siceeweb.dto.certificatore;

import com.opensymphony.xwork2.validator.annotations.*;

/**
 * DTO relativo al ComplexType DatiCertificatore.
 * @generated 
 */
@Validation
public class DatiCertificatore implements java.io.Serializable {

	/// Field [idCertificatore]
	private java.lang.String idCertificatore = null;

	/**
	 * imposta il valore del campo [idCertificatore]
	 * @param val
	 * @generated
	 */

	public void setIdCertificatore(java.lang.String val) {
		idCertificatore = val;
	}

	/**
	 * legge il valore del campo [idCertificatore]
	 * @generated
	 */
	public java.lang.String getIdCertificatore() {
		return idCertificatore;
	}

	/// Field [dtAnag]
	private it.csi.sicee.siceeweb.dto.certificatore.DatiAnag dtAnag = null;

	/**
	 * imposta il valore del campo [dtAnag]
	 * @param val
	 * @generated
	 */
	@VisitorFieldValidator(message = "", key = "DatiCertificatore.dtAnag.visitorvalidator.label", appendPrefix = true)
	public void setDtAnag(it.csi.sicee.siceeweb.dto.certificatore.DatiAnag val) {
		dtAnag = val;
	}

	/**
	 * legge il valore del campo [dtAnag]
	 * @generated
	 */
	public it.csi.sicee.siceeweb.dto.certificatore.DatiAnag getDtAnag() {
		return dtAnag;
	}

	/// Field [dtResidenza]
	private it.csi.sicee.siceeweb.dto.certificatore.DatiResidenza dtResidenza = null;

	/**
	 * imposta il valore del campo [dtResidenza]
	 * @param val
	 * @generated
	 */

	public void setDtResidenza(it.csi.sicee.siceeweb.dto.certificatore.DatiResidenza val) {
		dtResidenza = val;
	}

	/**
	 * legge il valore del campo [dtResidenza]
	 * @generated
	 */
	public it.csi.sicee.siceeweb.dto.certificatore.DatiResidenza getDtResidenza() {
		return dtResidenza;
	}

	/// Field [dtStudio]
	private it.csi.sicee.siceeweb.dto.certificatore.DatiStudio dtStudio = null;

	/**
	 * imposta il valore del campo [dtStudio]
	 * @param val
	 * @generated
	 */
	@VisitorFieldValidator(message = "", key = "DatiCertificatore.dtStudio.visitorvalidator.label", appendPrefix = true)
	public void setDtStudio(it.csi.sicee.siceeweb.dto.certificatore.DatiStudio val) {
		dtStudio = val;
	}

	/**
	 * legge il valore del campo [dtStudio]
	 * @generated
	 */
	public it.csi.sicee.siceeweb.dto.certificatore.DatiStudio getDtStudio() {
		return dtStudio;
	}

	/// Field [dtOrdine]
	private it.csi.sicee.siceeweb.dto.certificatore.DatiOrdine dtOrdine = null;

	/**
	 * imposta il valore del campo [dtOrdine]
	 * @param val
	 * @generated
	 */
	@VisitorFieldValidator(message = "", key = "DatiCertificatore.dtOrdine.visitorvalidator.label", appendPrefix = true)
	public void setDtOrdine(it.csi.sicee.siceeweb.dto.certificatore.DatiOrdine val) {
		dtOrdine = val;
	}

	/**
	 * legge il valore del campo [dtOrdine]
	 * @generated
	 */
	public it.csi.sicee.siceeweb.dto.certificatore.DatiOrdine getDtOrdine() {
		return dtOrdine;
	}

	/// Field [dtCompetenze]
	private it.csi.sicee.siceeweb.dto.certificatore.DatiCompetenze dtCompetenze = null;

	/**
	 * imposta il valore del campo [dtCompetenze]
	 * @param val
	 * @generated
	 */

	public void setDtCompetenze(it.csi.sicee.siceeweb.dto.certificatore.DatiCompetenze val) {
		dtCompetenze = val;
	}

	/**
	 * legge il valore del campo [dtCompetenze]
	 * @generated
	 */
	public it.csi.sicee.siceeweb.dto.certificatore.DatiCompetenze getDtCompetenze() {
		return dtCompetenze;
	}

	/// Field [numCertificatore]
	private java.lang.String numCertificatore = null;

	/**
	 * imposta il valore del campo [numCertificatore]
	 * @param val
	 * @generated
	 */

	public void setNumCertificatore(java.lang.String val) {
		numCertificatore = val;
	}

	/**
	 * legge il valore del campo [numCertificatore]
	 * @generated
	 */
	public java.lang.String getNumCertificatore() {
		return numCertificatore;
	}

	/// Field [dataScadenzaRegistrazione]
	private java.lang.String dataScadenzaRegistrazione = null;

	/**
	 * imposta il valore del campo [dataScadenzaRegistrazione]
	 * @param val
	 * @generated
	 */

	public void setDataScadenzaRegistrazione(java.lang.String val) {
		dataScadenzaRegistrazione = val;
	}

	/**
	 * legge il valore del campo [dataScadenzaRegistrazione]
	 * @generated
	 */
	public java.lang.String getDataScadenzaRegistrazione() {
		return dataScadenzaRegistrazione;
	}

	/// Field [dataIscrizioneRegistrazione]
	private java.lang.String dataIscrizioneRegistrazione = null;

	/**
	 * imposta il valore del campo [dataIscrizioneRegistrazione]
	 * @param val
	 * @generated
	 */

	public void setDataIscrizioneRegistrazione(java.lang.String val) {
		dataIscrizioneRegistrazione = val;
	}

	/**
	 * legge il valore del campo [dataIscrizioneRegistrazione]
	 * @generated
	 */
	public java.lang.String getDataIscrizioneRegistrazione() {
		return dataIscrizioneRegistrazione;
	}

	/// Field [numeroAceDisp]
	private java.lang.Integer numeroAceDisp = null;

	/**
	 * imposta il valore del campo [numeroAceDisp]
	 * @param val
	 * @generated
	 */

	public void setNumeroAceDisp(java.lang.Integer val) {
		numeroAceDisp = val;
	}

	/**
	 * legge il valore del campo [numeroAceDisp]
	 * @generated
	 */
	public java.lang.Integer getNumeroAceDisp() {
		return numeroAceDisp;
	}

	/// Field [dtEsameReg]
	private it.csi.sicee.siceeweb.dto.certificatore.DatiEsame dtEsameReg = null;

	/**
	 * imposta il valore del campo [dtEsameReg]
	 * @param val
	 * @generated
	 */
	@VisitorFieldValidator(message = "", key = "DatiCertificatore.dtEsameReg.visitorvalidator.label", appendPrefix = true)
	public void setDtEsameReg(it.csi.sicee.siceeweb.dto.certificatore.DatiEsame val) {
		dtEsameReg = val;
	}

	/**
	 * legge il valore del campo [dtEsameReg]
	 * @generated
	 */
	public it.csi.sicee.siceeweb.dto.certificatore.DatiEsame getDtEsameReg() {
		return dtEsameReg;
	}

	/// Field [dtEsameNaz]
	private it.csi.sicee.siceeweb.dto.certificatore.DatiEsame dtEsameNaz = null;

	/**
	 * imposta il valore del campo [dtEsameNaz]
	 * @param val
	 * @generated
	 */
	@VisitorFieldValidator(message = "", key = "DatiCertificatore.dtEsameNaz.visitorvalidator.label", appendPrefix = true)
	public void setDtEsameNaz(it.csi.sicee.siceeweb.dto.certificatore.DatiEsame val) {
		dtEsameNaz = val;
	}

	/**
	 * legge il valore del campo [dtEsameNaz]
	 * @generated
	 */
	public it.csi.sicee.siceeweb.dto.certificatore.DatiEsame getDtEsameNaz() {
		return dtEsameNaz;
	}

	/// Field [eMailErrata]
	private boolean eMailErrata = false;

	/**
	 * imposta il valore del campo [eMailErrata]
	 * @param val
	 * @generated
	 */

	public void setEMailErrata(boolean val) {
		eMailErrata = val;
	}

	/**
	 * legge il valore del campo [eMailErrata]
	 * @generated
	 */
	public boolean getEMailErrata() {
		return eMailErrata;
	}

	/// Field [stato]
	private java.lang.Integer stato = null;

	/**
	 * imposta il valore del campo [stato]
	 * @param val
	 * @generated
	 */

	public void setStato(java.lang.Integer val) {
		stato = val;
	}

	/**
	 * legge il valore del campo [stato]
	 * @generated
	 */
	public java.lang.Integer getStato() {
		return stato;
	}

	/// Field [transazioneAnomale]
	private boolean transazioneAnomale = false;

	/**
	 * imposta il valore del campo [transazioneAnomale]
	 * @param val
	 * @generated
	 */

	public void setTransazioneAnomale(boolean val) {
		transazioneAnomale = val;
	}

	/**
	 * legge il valore del campo [transazioneAnomale]
	 * @generated
	 */
	public boolean getTransazioneAnomale() {
		return transazioneAnomale;
	}

	/// Field [flgAggEmail]
	private java.lang.Boolean flgAggEmail = null;

	/**
	 * imposta il valore del campo [flgAggEmail]
	 * @param val
	 * @generated
	 */

	public void setFlgAggEmail(java.lang.Boolean val) {
		flgAggEmail = val;
	}

	/**
	 * legge il valore del campo [flgAggEmail]
	 * @generated
	 */
	public java.lang.Boolean getFlgAggEmail() {
		return flgAggEmail;
	}

	/// Field [flgAggDati]
	private java.lang.Boolean flgAggDati = null;

	/**
	 * imposta il valore del campo [flgAggDati]
	 * @param val
	 * @generated
	 */

	public void setFlgAggDati(java.lang.Boolean val) {
		flgAggDati = val;
	}

	/**
	 * legge il valore del campo [flgAggDati]
	 * @generated
	 */
	public java.lang.Boolean getFlgAggDati() {
		return flgAggDati;
	}

	/// Field [dataAggEmail]
	private java.lang.String dataAggEmail = null;

	/**
	 * imposta il valore del campo [dataAggEmail]
	 * @param val
	 * @generated
	 */

	public void setDataAggEmail(java.lang.String val) {
		dataAggEmail = val;
	}

	/**
	 * legge il valore del campo [dataAggEmail]
	 * @generated
	 */
	public java.lang.String getDataAggEmail() {
		return dataAggEmail;
	}

	/// Field [dataAggDati]
	private java.lang.String dataAggDati = null;

	/**
	 * imposta il valore del campo [dataAggDati]
	 * @param val
	 * @generated
	 */

	public void setDataAggDati(java.lang.String val) {
		dataAggDati = val;
	}

	/**
	 * legge il valore del campo [dataAggDati]
	 * @generated
	 */
	public java.lang.String getDataAggDati() {
		return dataAggDati;
	}

	/// Field [flgCompetenzeNaz]
	private java.lang.Boolean flgCompetenzeNaz = null;

	/**
	 * imposta il valore del campo [flgCompetenzeNaz]
	 * @param val
	 * @generated
	 */

	public void setFlgCompetenzeNaz(java.lang.Boolean val) {
		flgCompetenzeNaz = val;
	}

	/**
	 * legge il valore del campo [flgCompetenzeNaz]
	 * @generated
	 */
	public java.lang.Boolean getFlgCompetenzeNaz() {
		return flgCompetenzeNaz;
	}

	/// Field [dataEmailVerifica]
	private java.lang.String dataEmailVerifica = null;

	/**
	 * imposta il valore del campo [dataEmailVerifica]
	 * @param val
	 * @generated
	 */

	public void setDataEmailVerifica(java.lang.String val) {
		dataEmailVerifica = val;
	}

	/**
	 * legge il valore del campo [dataEmailVerifica]
	 * @generated
	 */
	public java.lang.String getDataEmailVerifica() {
		return dataEmailVerifica;
	}

	/// Field [idBlocco]
	private java.lang.Integer idBlocco = null;

	/**
	 * imposta il valore del campo [idBlocco]
	 * @param val
	 * @generated
	 */

	public void setIdBlocco(java.lang.Integer val) {
		idBlocco = val;
	}

	/**
	 * legge il valore del campo [idBlocco]
	 * @generated
	 */
	public java.lang.Integer getIdBlocco() {
		return idBlocco;
	}

	/// Field [descBlocco]
	private java.lang.String descBlocco = null;

	/**
	 * imposta il valore del campo [descBlocco]
	 * @param val
	 * @generated
	 */

	public void setDescBlocco(java.lang.String val) {
		descBlocco = val;
	}

	/**
	 * legge il valore del campo [descBlocco]
	 * @generated
	 */
	public java.lang.String getDescBlocco() {
		return descBlocco;
	}

	// il serial version uid e' fisso in quanto la classe in oggetto e' serializzabile
	// solo per la clusterizzazione della sessione web e non viene scambiata con altre
	// componenti.
	private static final long serialVersionUID = 1L;

	/**
	 * Costruttore vuoto del DTO.
	 * @generated
	 */
	public DatiCertificatore() {
		super();

	}

	/**
	 * @generated
	 */
	public String toString() {
		/*PROTECTED REGION ID(R-606454296) ENABLED START*/
		/// inserire qui la logica desiderata per la rappresenatazione a stringa
		return super.toString();
		/*PROTECTED REGION END*/
	}
}
