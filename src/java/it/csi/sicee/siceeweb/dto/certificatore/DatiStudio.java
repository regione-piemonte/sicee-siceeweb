package it.csi.sicee.siceeweb.dto.certificatore;

import com.opensymphony.xwork2.validator.annotations.*;

/**
 * DTO relativo al ComplexType DatiStudio.
 * @generated 
 */
@Validation
public class DatiStudio implements java.io.Serializable {

	/// Field [idAzienda]
	private long idAzienda = 0;

	/**
	 * imposta il valore del campo [idAzienda]
	 * @param val
	 * @generated
	 */

	public void setIdAzienda(long val) {
		idAzienda = val;
	}

	/**
	 * legge il valore del campo [idAzienda]
	 * @generated
	 */
	public long getIdAzienda() {
		return idAzienda;
	}

	/// Field [ragSociale]
	private java.lang.String ragSociale = null;

	/**
	 * imposta il valore del campo [ragSociale]
	 * @param val
	 * @generated
	 */

	public void setRagSociale(java.lang.String val) {
		ragSociale = val;
	}

	/**
	 * legge il valore del campo [ragSociale]
	 * @generated
	 */
	public java.lang.String getRagSociale() {
		return ragSociale;
	}

	/// Field [partitaIVA]
	private java.lang.String partitaIVA = null;

	/**
	 * imposta il valore del campo [partitaIVA]
	 * @param val
	 * @generated
	 */
	@StringLengthFieldValidator(type = ValidatorType.FIELD, minLength = "11", maxLength = "11", message = "", key = "DatiStudio.partitaIVA.validator.label")
	public void setPartitaIVA(java.lang.String val) {
		partitaIVA = val;
	}

	/**
	 * legge il valore del campo [partitaIVA]
	 * @generated
	 */
	public java.lang.String getPartitaIVA() {
		return partitaIVA;
	}

	/// Field [codReg]
	private java.lang.String codReg = null;

	/**
	 * imposta il valore del campo [codReg]
	 * @param val
	 * @generated
	 */

	public void setCodReg(java.lang.String val) {
		codReg = val;
	}

	/**
	 * legge il valore del campo [codReg]
	 * @generated
	 */
	public java.lang.String getCodReg() {
		return codReg;
	}

	/// Field [descrReg]
	private java.lang.String descrReg = null;

	/**
	 * imposta il valore del campo [descrReg]
	 * @param val
	 * @generated
	 */

	public void setDescrReg(java.lang.String val) {
		descrReg = val;
	}

	/**
	 * legge il valore del campo [descrReg]
	 * @generated
	 */
	public java.lang.String getDescrReg() {
		return descrReg;
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

	/// Field [codComune]
	private java.lang.String codComune = null;

	/**
	 * imposta il valore del campo [codComune]
	 * @param val
	 * @generated
	 */

	public void setCodComune(java.lang.String val) {
		codComune = val;
	}

	/**
	 * legge il valore del campo [codComune]
	 * @generated
	 */
	public java.lang.String getCodComune() {
		return codComune;
	}

	/// Field [descrComune]
	private java.lang.String descrComune = null;

	/**
	 * imposta il valore del campo [descrComune]
	 * @param val
	 * @generated
	 */

	public void setDescrComune(java.lang.String val) {
		descrComune = val;
	}

	/**
	 * legge il valore del campo [descrComune]
	 * @generated
	 */
	public java.lang.String getDescrComune() {
		return descrComune;
	}

	/// Field [descrIndirizzo]
	private java.lang.String descrIndirizzo = null;

	/**
	 * imposta il valore del campo [descrIndirizzo]
	 * @param val
	 * @generated
	 */

	public void setDescrIndirizzo(java.lang.String val) {
		descrIndirizzo = val;
	}

	/**
	 * legge il valore del campo [descrIndirizzo]
	 * @generated
	 */
	public java.lang.String getDescrIndirizzo() {
		return descrIndirizzo;
	}

	/// Field [codIndirizzo]
	private java.lang.Integer codIndirizzo = null;

	/**
	 * imposta il valore del campo [codIndirizzo]
	 * @param val
	 * @generated
	 */

	public void setCodIndirizzo(java.lang.Integer val) {
		codIndirizzo = val;
	}

	/**
	 * legge il valore del campo [codIndirizzo]
	 * @generated
	 */
	public java.lang.Integer getCodIndirizzo() {
		return codIndirizzo;
	}

	/// Field [numCiv]
	private java.lang.String numCiv = null;

	/**
	 * imposta il valore del campo [numCiv]
	 * @param val
	 * @generated
	 */

	public void setNumCiv(java.lang.String val) {
		numCiv = val;
	}

	/**
	 * legge il valore del campo [numCiv]
	 * @generated
	 */
	public java.lang.String getNumCiv() {
		return numCiv;
	}

	/// Field [cap]
	private java.lang.String cap = null;

	/**
	 * imposta il valore del campo [cap]
	 * @param val
	 * @generated
	 */

	public void setCap(java.lang.String val) {
		cap = val;
	}

	/**
	 * legge il valore del campo [cap]
	 * @generated
	 */
	public java.lang.String getCap() {
		return cap;
	}

	// il serial version uid e' fisso in quanto la classe in oggetto e' serializzabile
	// solo per la clusterizzazione della sessione web e non viene scambiata con altre
	// componenti.
	private static final long serialVersionUID = 1L;

	/**
	 * Costruttore vuoto del DTO.
	 * @generated
	 */
	public DatiStudio() {
		super();

	}

	/**
	 * @generated
	 */
	public String toString() {
		/*PROTECTED REGION ID(R-96434342) ENABLED START*/
		/// inserire qui la logica desiderata per la rappresenatazione a stringa
		return super.toString();
		/*PROTECTED REGION END*/
	}
}
