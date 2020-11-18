package it.csi.sicee.siceeweb.dto.pagamenti;

import com.opensymphony.xwork2.validator.annotations.*;

/**
 * DTO relativo al ComplexType DatiPagamento.
 * @generated 
 */
@Validation
public class DatiPagamento implements java.io.Serializable {

	/// Field [importo]
	private double importo = 0;

	/**
	 * imposta il valore del campo [importo]
	 * @param val
	 * @generated
	 */

	public void setImporto(double val) {
		importo = val;
	}

	/**
	 * legge il valore del campo [importo]
	 * @generated
	 */
	public double getImporto() {
		return importo;
	}

	/// Field [causale]
	private java.lang.String causale = null;

	/**
	 * imposta il valore del campo [causale]
	 * @param val
	 * @generated
	 */

	public void setCausale(java.lang.String val) {
		causale = val;
	}

	/**
	 * legge il valore del campo [causale]
	 * @generated
	 */
	public java.lang.String getCausale() {
		return causale;
	}

	/// Field [dataValuta]
	private it.csi.sicee.siceeweb.dto.type.UDTDateValid dataValuta = null;

	/**
	 * imposta il valore del campo [dataValuta]
	 * @param val
	 * @generated
	 */
	@CustomValidator(type = "csiUdDateValidator", message = "", key = "DatiPagamento.dataValuta.validator.label", parameters = {
			@ValidationParameter(name = "format", value = "dd/MM/yyyy")})
	public void setDataValuta(it.csi.sicee.siceeweb.dto.type.UDTDateValid val) {
		dataValuta = val;
	}

	/**
	 * legge il valore del campo [dataValuta]
	 * @generated
	 */
	public it.csi.sicee.siceeweb.dto.type.UDTDateValid getDataValuta() {
		return dataValuta;
	}

	/// Field [idTransazioneMDP]
	private java.lang.String idTransazioneMDP = null;

	/**
	 * imposta il valore del campo [idTransazioneMDP]
	 * @param val
	 * @generated
	 */

	public void setIdTransazioneMDP(java.lang.String val) {
		idTransazioneMDP = val;
	}

	/**
	 * legge il valore del campo [idTransazioneMDP]
	 * @generated
	 */
	public java.lang.String getIdTransazioneMDP() {
		return idTransazioneMDP;
	}

	/// Field [cro]
	private java.lang.String cro = null;

	/**
	 * imposta il valore del campo [cro]
	 * @param val
	 * @generated
	 */

	public void setCro(java.lang.String val) {
		cro = val;
	}

	/**
	 * legge il valore del campo [cro]
	 * @generated
	 */
	public java.lang.String getCro() {
		return cro;
	}

	/// Field [eseguitoDaCognome]
	private java.lang.String eseguitoDaCognome = null;

	/**
	 * imposta il valore del campo [eseguitoDaCognome]
	 * @param val
	 * @generated
	 */

	public void setEseguitoDaCognome(java.lang.String val) {
		eseguitoDaCognome = val;
	}

	/**
	 * legge il valore del campo [eseguitoDaCognome]
	 * @generated
	 */
	public java.lang.String getEseguitoDaCognome() {
		return eseguitoDaCognome;
	}

	/// Field [eseguitoDaNome]
	private java.lang.String eseguitoDaNome = null;

	/**
	 * imposta il valore del campo [eseguitoDaNome]
	 * @param val
	 * @generated
	 */

	public void setEseguitoDaNome(java.lang.String val) {
		eseguitoDaNome = val;
	}

	/**
	 * legge il valore del campo [eseguitoDaNome]
	 * @generated
	 */
	public java.lang.String getEseguitoDaNome() {
		return eseguitoDaNome;
	}

	/// Field [modPagamento]
	private java.lang.String modPagamento = null;

	/**
	 * imposta il valore del campo [modPagamento]
	 * @param val
	 * @generated
	 */

	public void setModPagamento(java.lang.String val) {
		modPagamento = val;
	}

	/**
	 * legge il valore del campo [modPagamento]
	 * @generated
	 */
	public java.lang.String getModPagamento() {
		return modPagamento;
	}

	/// Field [quantita]
	private java.lang.Integer quantita = null;

	/**
	 * imposta il valore del campo [quantita]
	 * @param val
	 * @generated
	 */

	public void setQuantita(java.lang.Integer val) {
		quantita = val;
	}

	/**
	 * legge il valore del campo [quantita]
	 * @generated
	 */
	public java.lang.Integer getQuantita() {
		return quantita;
	}

	/// Field [tipo]
	private java.lang.String tipo = null;

	/**
	 * imposta il valore del campo [tipo]
	 * @param val
	 * @generated
	 */

	public void setTipo(java.lang.String val) {
		tipo = val;
	}

	/**
	 * legge il valore del campo [tipo]
	 * @generated
	 */
	public java.lang.String getTipo() {
		return tipo;
	}

	/// Field [idTransazione]
	private java.lang.Long idTransazione = null;

	/**
	 * imposta il valore del campo [idTransazione]
	 * @param val
	 * @generated
	 */

	public void setIdTransazione(java.lang.Long val) {
		idTransazione = val;
	}

	/**
	 * legge il valore del campo [idTransazione]
	 * @generated
	 */
	public java.lang.Long getIdTransazione() {
		return idTransazione;
	}

	/// Field [statoTransazione]
	private java.lang.String statoTransazione = null;

	/**
	 * imposta il valore del campo [statoTransazione]
	 * @param val
	 * @generated
	 */

	public void setStatoTransazione(java.lang.String val) {
		statoTransazione = val;
	}

	/**
	 * legge il valore del campo [statoTransazione]
	 * @generated
	 */
	public java.lang.String getStatoTransazione() {
		return statoTransazione;
	}

	// il serial version uid e' fisso in quanto la classe in oggetto e' serializzabile
	// solo per la clusterizzazione della sessione web e non viene scambiata con altre
	// componenti.
	private static final long serialVersionUID = 1L;

	/**
	 * Costruttore vuoto del DTO.
	 * @generated
	 */
	public DatiPagamento() {
		super();

	}

	/**
	 * @generated
	 */
	public String toString() {
		/*PROTECTED REGION ID(R-824002962) ENABLED START*/
		/// inserire qui la logica desiderata per la rappresenatazione a stringa
		return super.toString();
		/*PROTECTED REGION END*/
	}
}
