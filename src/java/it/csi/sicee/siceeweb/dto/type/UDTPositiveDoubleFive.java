package it.csi.sicee.siceeweb.dto.type;

/*PROTECTED REGION ID(R1503323069) ENABLED START*/
//inserire qui eventuali import aggiuntivi
import java.text.DecimalFormat;
import java.text.NumberFormat;
/*PROTECTED REGION END*/
/**
 * Implementazione dello user defined type [PositiveDoubleFive].
 * <ul>
 * <li>tipo scalare base: DOUBLE</li>
 * <li>modificatori:
 *   <ul>
 *	 </ul>
 * </li>
 * </ul>
 * @generated
 */
public class UDTPositiveDoubleFive implements java.io.Serializable, Comparable {

	// il serial version uid e' fisso in quanto la classe in oggetto e' serializzabile
	// solo per la clusterizzazione della sessione web e non viene scambiata con altre
	// componenti.
	private static final long serialVersionUID = 1L;

	/**
	 * Costruttore vuoto del DTO.
	 */
	public UDTPositiveDoubleFive() {
		super();
	}

	/**
	 * Costruttore per valore del DTO.
	 */
	public UDTPositiveDoubleFive(java.lang.Double v) {
		super();
		_value = v;
	}

	private java.lang.Double _value;

	public java.lang.Double getValue() {
		return _value;
	}

	public void setValue(java.lang.Double s) {
		_value = s;
	}

	/**
	 * implementazione del confronto di uguaglianza tra due istanze
	 * di UDTPositiveDoubleFive. 
	 */
	public boolean equals(Object other) {
		// un oggetto nullo e' distinto da tutti gli altri
		if (other == null)
			return false;
		// un oggetto di tipo differente non puo' essere uguale
		if (!(other instanceof UDTPositiveDoubleFive))
			return false;
		UDTPositiveDoubleFive otherSpecific = (UDTPositiveDoubleFive) other;
		// un valore nullo non e' uguale ad un valore non nullo
		if ((_value == null && otherSpecific.getValue() != null)
				|| (_value != null && otherSpecific.getValue() == null))
			return false;
		// valori entrambi non nulli: posso confrontare
		/*PROTECTED REGION ID(R1731985507) ENABLED START*/
		// TODO inserire qui la logica specifica di confronto e rimuovere l'eccezione UnsupportedOperationException
		//return _value.equals(otherSpecific.getValue());
		throw new UnsupportedOperationException("Metodo UDTPositiveDoubleFive.equals() non implementato");
		/*PROTECTED REGION END*/
	}

	/**
	 * implementazione della comparazione quantitativa tra due istanze
	 * di UDTPositiveDoubleFive. 
	 */
	public int compareTo(Object other) {
		// un oggetto nullo e' distinto da tutti gli altri e per convenzione li precede
		if (other == null)
			return +1;
		// un oggetto di tipo differente non puo' essere confrontato
		if (!(other instanceof UDTPositiveDoubleFive))
			throw new IllegalArgumentException(
					"impossibile confrontare un UDTPositiveDoubleFive con " + other.getClass());
		UDTPositiveDoubleFive otherSpecific = (UDTPositiveDoubleFive) other;
		// un valore nullo precede un valore non nullo
		if (_value == null && otherSpecific.getValue() != null)
			return -1;
		if (_value != null && otherSpecific.getValue() == null)
			return +1;
		// due valori nulli sono uguali
		if (_value == null && otherSpecific.getValue() == null)
			return 0;
		// valori entrambi non nulli: posso confrontare
		/*PROTECTED REGION ID(R-377226950) ENABLED START*/
		// TODO: inserire qui la logica specifica di confronto e rimuovere l'eccezione UnsupportedOperationException
		//return _value.compareTo(otherSpecific.getValue());		
		throw new UnsupportedOperationException("Metodo UDTPositiveDoubleFive.compareTo() non implementato");
		/*PROTECTED REGION END*/
	}

	public int hashCode() {
		return _value == null ? 0 : _value.hashCode();
	}

	public String toString() {
		/*PROTECTED REGION ID(R2091965320) ENABLED START*/
		if (_value == null)
			return "";

		return formatter.format(_value);
		/*PROTECTED REGION END*/

	}

	/*PROTECTED REGION ID(R107092665) ENABLED START*/
	// inserire qui eventuali metodi aggiuntivi
	private static NumberFormat formatter = new DecimalFormat("################0.#####");
	/*PROTECTED REGION END*/

}
