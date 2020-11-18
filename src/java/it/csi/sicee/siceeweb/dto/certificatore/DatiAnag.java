package it.csi.sicee.siceeweb.dto.certificatore;

import com.opensymphony.xwork2.validator.annotations.*;

/**
 * DTO relativo al ComplexType DatiAnag.
 * @generated 
 */
@Validation
public class DatiAnag implements java.io.Serializable {

	/// Field [cognome]
	private java.lang.String cognome = null;

	/**
	 * imposta il valore del campo [cognome]
	 * @param val
	 * @generated
	 */

	public void setCognome(java.lang.String val) {
		cognome = val;
	}

	/**
	 * legge il valore del campo [cognome]
	 * @generated
	 */
	public java.lang.String getCognome() {
		return cognome;
	}

	/// Field [nome]
	private java.lang.String nome = null;

	/**
	 * imposta il valore del campo [nome]
	 * @param val
	 * @generated
	 */

	public void setNome(java.lang.String val) {
		nome = val;
	}

	/**
	 * legge il valore del campo [nome]
	 * @generated
	 */
	public java.lang.String getNome() {
		return nome;
	}

	/// Field [dataNascita]
	private it.csi.sicee.siceeweb.dto.type.UDTDateValid dataNascita = null;

	/**
	 * imposta il valore del campo [dataNascita]
	 * @param val
	 * @generated
	 */
	@CustomValidator(type = "csiUdDateValidator", message = "", key = "DatiAnag.dataNascita.validator.label", parameters = {
			@ValidationParameter(name = "format", value = "dd/MM/yyyy")})
	public void setDataNascita(it.csi.sicee.siceeweb.dto.type.UDTDateValid val) {
		dataNascita = val;
	}

	/**
	 * legge il valore del campo [dataNascita]
	 * @generated
	 */
	public it.csi.sicee.siceeweb.dto.type.UDTDateValid getDataNascita() {
		return dataNascita;
	}

	/// Field [codFisc]
	private java.lang.String codFisc = null;

	/**
	 * imposta il valore del campo [codFisc]
	 * @param val
	 * @generated
	 */

	public void setCodFisc(java.lang.String val) {
		codFisc = val;
	}

	/**
	 * legge il valore del campo [codFisc]
	 * @generated
	 */
	public java.lang.String getCodFisc() {
		return codFisc;
	}

	/// Field [codRegNasc]
	private java.lang.String codRegNasc = null;

	/**
	 * imposta il valore del campo [codRegNasc]
	 * @param val
	 * @generated
	 */

	public void setCodRegNasc(java.lang.String val) {
		codRegNasc = val;
	}

	/**
	 * legge il valore del campo [codRegNasc]
	 * @generated
	 */
	public java.lang.String getCodRegNasc() {
		return codRegNasc;
	}

	/// Field [codProvNasc]
	private java.lang.String codProvNasc = null;

	/**
	 * imposta il valore del campo [codProvNasc]
	 * @param val
	 * @generated
	 */

	public void setCodProvNasc(java.lang.String val) {
		codProvNasc = val;
	}

	/**
	 * legge il valore del campo [codProvNasc]
	 * @generated
	 */
	public java.lang.String getCodProvNasc() {
		return codProvNasc;
	}

	/// Field [codComuneNasc]
	private java.lang.String codComuneNasc = null;

	/**
	 * imposta il valore del campo [codComuneNasc]
	 * @param val
	 * @generated
	 */

	public void setCodComuneNasc(java.lang.String val) {
		codComuneNasc = val;
	}

	/**
	 * legge il valore del campo [codComuneNasc]
	 * @generated
	 */
	public java.lang.String getCodComuneNasc() {
		return codComuneNasc;
	}

	/// Field [descrRegNasc]
	private java.lang.String descrRegNasc = null;

	/**
	 * imposta il valore del campo [descrRegNasc]
	 * @param val
	 * @generated
	 */

	public void setDescrRegNasc(java.lang.String val) {
		descrRegNasc = val;
	}

	/**
	 * legge il valore del campo [descrRegNasc]
	 * @generated
	 */
	public java.lang.String getDescrRegNasc() {
		return descrRegNasc;
	}

	/// Field [descrProvNasc]
	private java.lang.String descrProvNasc = null;

	/**
	 * imposta il valore del campo [descrProvNasc]
	 * @param val
	 * @generated
	 */

	public void setDescrProvNasc(java.lang.String val) {
		descrProvNasc = val;
	}

	/**
	 * legge il valore del campo [descrProvNasc]
	 * @generated
	 */
	public java.lang.String getDescrProvNasc() {
		return descrProvNasc;
	}

	/// Field [descrComuneNasc]
	private java.lang.String descrComuneNasc = null;

	/**
	 * imposta il valore del campo [descrComuneNasc]
	 * @param val
	 * @generated
	 */

	public void setDescrComuneNasc(java.lang.String val) {
		descrComuneNasc = val;
	}

	/**
	 * legge il valore del campo [descrComuneNasc]
	 * @generated
	 */
	public java.lang.String getDescrComuneNasc() {
		return descrComuneNasc;
	}

	/// Field [statoEstero]
	private java.lang.String statoEstero = null;

	/**
	 * imposta il valore del campo [statoEstero]
	 * @param val
	 * @generated
	 */

	public void setStatoEstero(java.lang.String val) {
		statoEstero = val;
	}

	/**
	 * legge il valore del campo [statoEstero]
	 * @generated
	 */
	public java.lang.String getStatoEstero() {
		return statoEstero;
	}

	// il serial version uid e' fisso in quanto la classe in oggetto e' serializzabile
	// solo per la clusterizzazione della sessione web e non viene scambiata con altre
	// componenti.
	private static final long serialVersionUID = 1L;

	/**
	 * Costruttore vuoto del DTO.
	 * @generated
	 */
	public DatiAnag() {
		super();

	}

	/**
	 * @generated
	 */
	public String toString() {
		/*PROTECTED REGION ID(R-1349748841) ENABLED START*/
		/// inserire qui la logica desiderata per la rappresenatazione a stringa
		return super.toString();
		/*PROTECTED REGION END*/
	}
}
