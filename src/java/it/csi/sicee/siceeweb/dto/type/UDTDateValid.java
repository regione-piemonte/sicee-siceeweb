package it.csi.sicee.siceeweb.dto.type;

/*PROTECTED REGION ID(R263007699) ENABLED START*/
//inserire qui eventuali import aggiuntivi

/*PROTECTED REGION END*/
/**
 * Implementazione dello user defined type [DateValid].
 * <ul>
 * <li>tipo scalare base: DATE</li>
 * <li>modificatori:
 *   <ul>
 *	 </ul>
 * </li>
 * </ul>
 * @generated
 */
public class UDTDateValid implements java.io.Serializable, Comparable {

	// il serial version uid e' fisso in quanto la classe in oggetto e' serializzabile
	// solo per la clusterizzazione della sessione web e non viene scambiata con altre
	// componenti.
	private static final long serialVersionUID = 1L;

	/**
	 * Costruttore vuoto del DTO.
	 */
	public UDTDateValid() {
		super();
	}

	/**
	 * Costruttore per valore del DTO.
	 */
	public UDTDateValid(java.lang.String v) {
		super();
		_value = v;
	}

	private java.lang.String _value;

	public java.lang.String getValue() {
		return _value;
	}

	public void setValue(java.lang.String s) {
		_value = s;
	}

	/**
	 * implementazione del confronto di uguaglianza tra due istanze
	 * di UDTDateValid. 
	 */
	public boolean equals(Object other) {
		// un oggetto nullo e' distinto da tutti gli altri
		if (other == null)
			return false;
		// un oggetto di tipo differente non puo' essere uguale
		if (!(other instanceof UDTDateValid))
			return false;
		UDTDateValid otherSpecific = (UDTDateValid) other;
		// un valore nullo non e' uguale ad un valore non nullo
		if ((_value == null && otherSpecific.getValue() != null)
				|| (_value != null && otherSpecific.getValue() == null))
			return false;
		// valori entrambi non nulli: posso confrontare
		/*PROTECTED REGION ID(R423925105) ENABLED START*/
		// TODO inserire qui la logica specifica di confronto e rimuovere l'eccezione UnsupportedOperationException
		//return _value.equals(otherSpecific.getValue());
		throw new UnsupportedOperationException("Metodo UDTDateValid.equals() non implementato");
		/*PROTECTED REGION END*/
	}

	/**
	 * implementazione della comparazione quantitativa tra due istanze
	 * di UDTDateValid. 
	 */
	public int compareTo(Object other) {
		// un oggetto nullo e' distinto da tutti gli altri e per convenzione li precede
		if (other == null)
			return +1;
		// un oggetto di tipo differente non puo' essere confrontato
		if (!(other instanceof UDTDateValid))
			throw new IllegalArgumentException("impossibile confrontare un UDTDateValid con " + other.getClass());
		UDTDateValid otherSpecific = (UDTDateValid) other;
		// un valore nullo precede un valore non nullo
		if (_value == null && otherSpecific.getValue() != null)
			return -1;
		if (_value != null && otherSpecific.getValue() == null)
			return +1;
		// due valori nulli sono uguali
		if (_value == null && otherSpecific.getValue() == null)
			return 0;
		// valori entrambi non nulli: posso confrontare
		/*PROTECTED REGION ID(R-566386324) ENABLED START*/
		// TODO: inserire qui la logica specifica di confronto e rimuovere l'eccezione UnsupportedOperationException
		//return _value.compareTo(otherSpecific.getValue());		
		throw new UnsupportedOperationException("Metodo UDTDateValid.compareTo() non implementato");
		/*PROTECTED REGION END*/
	}

	public int hashCode() {
		return _value == null ? 0 : _value.hashCode();
	}

	public String toString() {
		/*PROTECTED REGION ID(R1192300858) ENABLED START*/
		return getValue();
		/*PROTECTED REGION END*/

	}

	/*PROTECTED REGION ID(R-814483357) ENABLED START*/
	// inserire qui eventuali metodi aggiuntivi
	/*PROTECTED REGION END*/

}
