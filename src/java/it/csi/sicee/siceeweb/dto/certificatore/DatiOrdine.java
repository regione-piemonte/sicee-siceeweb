package it.csi.sicee.siceeweb.dto.certificatore;

import com.opensymphony.xwork2.validator.annotations.*;

/**
 * DTO relativo al ComplexType DatiOrdine.
 * @generated 
 */
@Validation
public class DatiOrdine implements java.io.Serializable {

	/// Field [flagIscritto]
	private java.lang.String flagIscritto = null;

	/**
	 * imposta il valore del campo [flagIscritto]
	 * @param val
	 * @generated
	 */

	public void setFlagIscritto(java.lang.String val) {
		flagIscritto = val;
	}

	/**
	 * legge il valore del campo [flagIscritto]
	 * @generated
	 */
	public java.lang.String getFlagIscritto() {
		return flagIscritto;
	}

	/// Field [tipoIstruzione]
	private java.lang.String tipoIstruzione = null;

	/**
	 * imposta il valore del campo [tipoIstruzione]
	 * @param val
	 * @generated
	 */

	public void setTipoIstruzione(java.lang.String val) {
		tipoIstruzione = val;
	}

	/**
	 * legge il valore del campo [tipoIstruzione]
	 * @generated
	 */
	public java.lang.String getTipoIstruzione() {
		return tipoIstruzione;
	}

	/// Field [descTipoIstruzione]
	private java.lang.String descTipoIstruzione = null;

	/**
	 * imposta il valore del campo [descTipoIstruzione]
	 * @param val
	 * @generated
	 */

	public void setDescTipoIstruzione(java.lang.String val) {
		descTipoIstruzione = val;
	}

	/**
	 * legge il valore del campo [descTipoIstruzione]
	 * @generated
	 */
	public java.lang.String getDescTipoIstruzione() {
		return descTipoIstruzione;
	}

	/// Field [codiceIstruzione]
	private java.lang.String codiceIstruzione = null;

	/**
	 * imposta il valore del campo [codiceIstruzione]
	 * @param val
	 * @generated
	 */

	public void setCodiceIstruzione(java.lang.String val) {
		codiceIstruzione = val;
	}

	/**
	 * legge il valore del campo [codiceIstruzione]
	 * @generated
	 */
	public java.lang.String getCodiceIstruzione() {
		return codiceIstruzione;
	}

	/// Field [titoloIstruzione]
	private java.lang.String titoloIstruzione = null;

	/**
	 * imposta il valore del campo [titoloIstruzione]
	 * @param val
	 * @generated
	 */

	public void setTitoloIstruzione(java.lang.String val) {
		titoloIstruzione = val;
	}

	/**
	 * legge il valore del campo [titoloIstruzione]
	 * @generated
	 */
	public java.lang.String getTitoloIstruzione() {
		return titoloIstruzione;
	}

	/// Field [descCodTitoloIstruzione]
	private java.lang.String descCodTitoloIstruzione = null;

	/**
	 * imposta il valore del campo [descCodTitoloIstruzione]
	 * @param val
	 * @generated
	 */

	public void setDescCodTitoloIstruzione(java.lang.String val) {
		descCodTitoloIstruzione = val;
	}

	/**
	 * legge il valore del campo [descCodTitoloIstruzione]
	 * @generated
	 */
	public java.lang.String getDescCodTitoloIstruzione() {
		return descCodTitoloIstruzione;
	}

	/// Field [titolo]
	private it.csi.sicee.siceeweb.dto.certificatore.Titolo titolo = null;

	/**
	 * imposta il valore del campo [titolo]
	 * @param val
	 * @generated
	 */

	public void setTitolo(it.csi.sicee.siceeweb.dto.certificatore.Titolo val) {
		titolo = val;
	}

	/**
	 * legge il valore del campo [titolo]
	 * @generated
	 */
	public it.csi.sicee.siceeweb.dto.certificatore.Titolo getTitolo() {
		return titolo;
	}

	/// Field [settore]
	private java.lang.String settore = null;

	/**
	 * imposta il valore del campo [settore]
	 * @param val
	 * @generated
	 */

	public void setSettore(java.lang.String val) {
		settore = val;
	}

	/**
	 * legge il valore del campo [settore]
	 * @generated
	 */
	public java.lang.String getSettore() {
		return settore;
	}

	/// Field [sezione]
	private java.lang.String sezione = null;

	/**
	 * imposta il valore del campo [sezione]
	 * @param val
	 * @generated
	 */

	public void setSezione(java.lang.String val) {
		sezione = val;
	}

	/**
	 * legge il valore del campo [sezione]
	 * @generated
	 */
	public java.lang.String getSezione() {
		return sezione;
	}

	/// Field [albo]
	private java.lang.String albo = null;

	/**
	 * imposta il valore del campo [albo]
	 * @param val
	 * @generated
	 */

	public void setAlbo(java.lang.String val) {
		albo = val;
	}

	/**
	 * legge il valore del campo [albo]
	 * @generated
	 */
	public java.lang.String getAlbo() {
		return albo;
	}

	/// Field [codProv]
	private java.lang.String codProv = null;

	/**
	 * imposta il valore del campo [codProv]
	 * @param val
	 * @generated
	 */

	public void setCodProv(java.lang.String val) {
		codProv = val;
	}

	/**
	 * legge il valore del campo [codProv]
	 * @generated
	 */
	public java.lang.String getCodProv() {
		return codProv;
	}

	/// Field [numIscrizione]
	private java.lang.String numIscrizione = null;

	/**
	 * imposta il valore del campo [numIscrizione]
	 * @param val
	 * @generated
	 */

	public void setNumIscrizione(java.lang.String val) {
		numIscrizione = val;
	}

	/**
	 * legge il valore del campo [numIscrizione]
	 * @generated
	 */
	public java.lang.String getNumIscrizione() {
		return numIscrizione;
	}

	/// Field [dataIscrizione]
	private it.csi.sicee.siceeweb.dto.type.UDTDateValid dataIscrizione = null;

	/**
	 * imposta il valore del campo [dataIscrizione]
	 * @param val
	 * @generated
	 */
	@CustomValidator(type = "csiUdDateValidator", message = "", key = "DatiOrdine.dataIscrizione.validator.label", parameters = {
			@ValidationParameter(name = "format", value = "dd/MM/yyyy")})
	public void setDataIscrizione(it.csi.sicee.siceeweb.dto.type.UDTDateValid val) {
		dataIscrizione = val;
	}

	/**
	 * legge il valore del campo [dataIscrizione]
	 * @generated
	 */
	public it.csi.sicee.siceeweb.dto.type.UDTDateValid getDataIscrizione() {
		return dataIscrizione;
	}

	/// Field [descrProv]
	private java.lang.String descrProv = null;

	/**
	 * imposta il valore del campo [descrProv]
	 * @param val
	 * @generated
	 */

	public void setDescrProv(java.lang.String val) {
		descrProv = val;
	}

	/**
	 * legge il valore del campo [descrProv]
	 * @generated
	 */
	public java.lang.String getDescrProv() {
		return descrProv;
	}

	/// Field [presaVisione]
	private java.lang.Boolean presaVisione = null;

	/**
	 * imposta il valore del campo [presaVisione]
	 * @param val
	 * @generated
	 */

	public void setPresaVisione(java.lang.Boolean val) {
		presaVisione = val;
	}

	/**
	 * legge il valore del campo [presaVisione]
	 * @generated
	 */
	public java.lang.Boolean getPresaVisione() {
		return presaVisione;
	}

	// il serial version uid e' fisso in quanto la classe in oggetto e' serializzabile
	// solo per la clusterizzazione della sessione web e non viene scambiata con altre
	// componenti.
	private static final long serialVersionUID = 1L;

	/**
	 * Costruttore vuoto del DTO.
	 * @generated
	 */
	public DatiOrdine() {
		super();

		this.setTitolo(new it.csi.sicee.siceeweb.dto.certificatore.Titolo());

	}

	/**
	 * @generated
	 */
	public String toString() {
		/*PROTECTED REGION ID(R-164514333) ENABLED START*/
		/// inserire qui la logica desiderata per la rappresenatazione a stringa
		return super.toString();
		/*PROTECTED REGION END*/
	}
}
