package it.csi.sicee.siceeweb.dto.daticert;

public class DtFoto implements java.io.Serializable {

	/// Field [idFoto]
	private long idFoto = 0;

	/**
	 * imposta il valore del campo [idFoto]
	 * @param val
	 * @generated
	 */

	public void setIdFoto(long val) {
		idFoto = val;
	}

	/**
	 * legge il valore del campo [idFoto]
	 * @generated
	 */
	public long getIdFoto() {
		return idFoto;
	}

	/// Field [uidFoto]
	private java.lang.String uidFoto = null;

	/**
	 * imposta il valore del campo [uidFoto]
	 * @param val
	 * @generated
	 */

	public void setUidFoto(java.lang.String val) {
		uidFoto = val;
	}

	/**
	 * legge il valore del campo [uidFoto]
	 * @generated
	 */
	public java.lang.String getUidFoto() {
		return uidFoto;
	}

	/// Field [nomeFoto]
	private java.lang.String nomeFoto = null;

	/**
	 * imposta il valore del campo [nomeFoto]
	 * @param val
	 * @generated
	 */

	public void setNomeFoto(java.lang.String val) {
		nomeFoto = val;
	}

	/**
	 * legge il valore del campo [nomeFoto]
	 * @generated
	 */
	public java.lang.String getNomeFoto() {
		return nomeFoto;
	}

	/// Field [dataUpFoto]
	private java.lang.String dataUpFoto = null;

	/**
	 * imposta il valore del campo [dataUpFoto]
	 * @param val
	 * @generated
	 */

	public void setDataUpFoto(java.lang.String val) {
		dataUpFoto = val;
	}

	/**
	 * legge il valore del campo [dataUpFoto]
	 * @generated
	 */
	public java.lang.String getDataUpFoto() {
		return dataUpFoto;
	}

	/// Field [flgPrincipale]
	private java.lang.String flgPrincipale = null;

	/**
	 * imposta il valore del campo [flgPrincipale]
	 * @param val
	 * @generated
	 */

	public void setFlgPrincipale(java.lang.String val) {
		flgPrincipale = val;
	}

	/**
	 * legge il valore del campo [flgPrincipale]
	 * @generated
	 */
	public java.lang.String getFlgPrincipale() {
		return flgPrincipale;
	}

	/// Field [previewBase64]
	private java.lang.String previewBase64 = null;

	/**
	 * imposta il valore del campo [previewBase64]
	 * @param val
	 * @generated
	 */

	public void setPreviewBase64(java.lang.String val) {
		previewBase64 = val;
	}

	/**
	 * legge il valore del campo [previewBase64]
	 * @generated
	 */
	public java.lang.String getPreviewBase64() {
		return previewBase64;
	}

	/// Field [fkTipoFoto]
	private int fkTipoFoto = 0;

	/**
	 * imposta il valore del campo [fkTipoFoto]
	 * @param val
	 * @generated
	 */

	public void setFkTipoFoto(int val) {
		fkTipoFoto = val;
	}

	/**
	 * legge il valore del campo [fkTipoFoto]
	 * @generated
	 */
	public int getFkTipoFoto() {
		return fkTipoFoto;
	}

	/// Field [descTipoFoto]
	private java.lang.String descTipoFoto = null;

	/**
	 * imposta il valore del campo [descTipoFoto]
	 * @param val
	 * @generated
	 */

	public void setDescTipoFoto(java.lang.String val) {
		descTipoFoto = val;
	}

	/**
	 * legge il valore del campo [descTipoFoto]
	 * @generated
	 */
	public java.lang.String getDescTipoFoto() {
		return descTipoFoto;
	}

	// il serial version uid e' fisso in quanto la classe in oggetto e' serializzabile
	// solo per la clusterizzazione della sessione web e non viene scambiata con altre
	// componenti.
	private static final long serialVersionUID = 1L;

	/**
	 * Costruttore vuoto del DTO.
	 * @generated
	 */
	public DtFoto() {
		super();

	}

	/**
	 * @generated
	 */
	public String toString() {
		/*PROTECTED REGION ID(R1177656388) ENABLED START*/
		/// inserire qui la logica desiderata per la rappresenatazione a stringa
		return super.toString();
		/*PROTECTED REGION END*/
	}
}
