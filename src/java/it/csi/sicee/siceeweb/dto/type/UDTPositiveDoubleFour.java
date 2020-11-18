package it.csi.sicee.siceeweb.dto.type;

/*PROTECTED REGION ID(R2141688369) ENABLED START*/
//inserire qui eventuali import aggiuntivi
import java.text.DecimalFormat;
import java.text.NumberFormat;
/*PROTECTED REGION END*/
/**
 * Implementazione dello user defined type [PositiveDoubleFour].
 * <ul>
 * <li>tipo scalare base: DOUBLE</li>
 * <li>modificatori:
 *   <ul>
 *	 </ul>
 * </li>
 * </ul>
 * @generated
 */
public class UDTPositiveDoubleFour implements java.io.Serializable, Comparable {

	// il serial version uid e' fisso in quanto la classe in oggetto e' serializzabile
	// solo per la clusterizzazione della sessione web e non viene scambiata con altre
	// componenti.
	private static final long serialVersionUID = 1L;

	/**
	 * Costruttore vuoto del DTO.
	 */
	public UDTPositiveDoubleFour() {
		super();
	}

	/**
	 * Costruttore per valore del DTO.
	 */
	public UDTPositiveDoubleFour(java.lang.Double v) {
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
	 * di UDTPositiveDoubleFour. 
	 */
	public boolean equals(Object other) {
		// un oggetto nullo e' distinto da tutti gli altri
		if (other == null)
			return false;
		// un oggetto di tipo differente non puo' essere uguale
		if (!(other instanceof UDTPositiveDoubleFour))
			return false;
		UDTPositiveDoubleFour otherSpecific = (UDTPositiveDoubleFour) other;
		// un valore nullo non e' uguale ad un valore non nullo
		if ((_value == null && otherSpecific.getValue() != null)
				|| (_value != null && otherSpecific.getValue() == null))
			return false;
		// valori entrambi non nulli: posso confrontare
		/*PROTECTED REGION ID(R670112111) ENABLED START*/
		// TODO inserire qui la logica specifica di confronto e rimuovere l'eccezione UnsupportedOperationException
		//return _value.equals(otherSpecific.getValue());
		throw new UnsupportedOperationException("Metodo UDTPositiveDoubleFour.equals() non implementato");
		/*PROTECTED REGION END*/
	}

	/**
	 * implementazione della comparazione quantitativa tra due istanze
	 * di UDTPositiveDoubleFour. 
	 */
	public int compareTo(Object other) {
		// un oggetto nullo e' distinto da tutti gli altri e per convenzione li precede
		if (other == null)
			return +1;
		// un oggetto di tipo differente non puo' essere confrontato
		if (!(other instanceof UDTPositiveDoubleFour))
			throw new IllegalArgumentException(
					"impossibile confrontare un UDTPositiveDoubleFour con " + other.getClass());
		UDTPositiveDoubleFour otherSpecific = (UDTPositiveDoubleFour) other;
		// un valore nullo precede un valore non nullo
		if (_value == null && otherSpecific.getValue() != null)
			return -1;
		if (_value != null && otherSpecific.getValue() == null)
			return +1;
		// due valori nulli sono uguali
		if (_value == null && otherSpecific.getValue() == null)
			return 0;
		// valori entrambi non nulli: posso confrontare
		/*PROTECTED REGION ID(R2081535150) ENABLED START*/
		// TODO: inserire qui la logica specifica di confronto e rimuovere l'eccezione UnsupportedOperationException
		//return _value.compareTo(otherSpecific.getValue());		
		throw new UnsupportedOperationException("Metodo UDTPositiveDoubleFour.compareTo() non implementato");
		/*PROTECTED REGION END*/
	}

	public int hashCode() {
		return _value == null ? 0 : _value.hashCode();
	}

	public String toString() {
		/*PROTECTED REGION ID(R-1925366276) ENABLED START*/
		if (_value == null)
			return "";

		return formatter.format(_value);
		/*PROTECTED REGION END*/

	}

	/*PROTECTED REGION ID(R1848975557) ENABLED START*/
	// inserire qui eventuali metodi aggiuntivi 
	private static NumberFormat formatter = new DecimalFormat("################0.####");
	/*PROTECTED REGION END*/

}
