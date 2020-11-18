package it.csi.sicee.siceeweb.presentation.siceeweb.converter;

import java.util.Map;

import it.csi.sicee.siceeweb.dto.type.UDTPositiveDoubleTwo;

import org.apache.struts2.util.StrutsTypeConverter;

import com.opensymphony.xwork2.conversion.TypeConversionException;

/*PROTECTED REGION ID(R-1462165863) ENABLED START*/
//inserire qui eventuali import aggiuntivi

/*PROTECTED REGION END*/

/**
 * Custom Type Converter per lo user defined type [PositiveDoubleTwo].
 * 
 * @author [GUIGEN]
 * @generated
 */
public class UDTPositiveDoubleTwoConverter extends StrutsTypeConverter {

	/**
	 * Trasforma una rappresentazione a stringa di un oggetto di tipo
	 * UDTPositiveDoubleTwo.
	 * @param  context
	 * @param  values
	 * @param  toClass
	 * @return
	 * @see org.apache.struts2.util.StrutsTypeConverter#convertFromString(java.util.Map, java.lang.String[], java.lang.Class)
	 */
	@Override
	public Object convertFromString(Map context, String[] values, Class toClass) {
		/*PROTECTED REGION ID(R261966449) ENABLED START*/
		if (values != null && values.length > 0 && values[0] != null && values[0].trim().length() > 0) {
			String s = values[0].trim();
			java.util.Locale.setDefault(java.util.Locale.ITALY);
			java.text.DecimalFormat df = new java.text.DecimalFormat("##########.##");

			//df.setMinimumFractionDigits(2);
			//df.setMaximumFractionDigits(2);

			try {
				java.text.ParsePosition parsePosition = new java.text.ParsePosition(0);
				Number n = df.parse(s, parsePosition);

				if (!s.matches("^[0-9]{1,10}(,[0-9]{0,2})?$")) {
					throw new java.text.ParseException("impossibile convertire l'intera stringa",
							parsePosition.getIndex());
				}

				if (parsePosition.getIndex() != s.length()) {
					throw new java.text.ParseException("impossibile convertire l'intera stringa",
							parsePosition.getIndex());
				}
				if (n.doubleValue() < 0) {
					throw new java.text.ParseException("sono permessi solo numeri positivi", parsePosition.getIndex());
				}

				return new UDTPositiveDoubleTwo(n.doubleValue());
			} catch (java.text.ParseException e) {
				throw new TypeConversionException(e);
			}

		}
		return null;
		/*PROTECTED REGION END*/
	}

	/**
	 * Trasforma una istanza di UDTPositiveDoubleTwo nella rappresentazione a stringa.
	 * @param
	 * @param
	 * @return
	 * @see org.apache.struts2.util.StrutsTypeConverter#convertToString(java.util.Map, java.lang.Object)
	 */
	@Override
	public String convertToString(Map context, Object o) {
		UDTPositiveDoubleTwo val = (UDTPositiveDoubleTwo) o;
		/*PROTECTED REGION ID(R1224453634) ENABLED START*/
		if (o instanceof UDTPositiveDoubleTwo) {
			if (val.getValue() != null) {
				java.util.Locale.setDefault(java.util.Locale.ITALY);
				java.text.DecimalFormat df = new java.text.DecimalFormat("##########.##");
				//df.setMinimumFractionDigits(2);
				//df.setMaximumFractionDigits(2);
				return df.format(((UDTPositiveDoubleTwo) o).getValue());
			}
		}

		return val.toString();
		/*PROTECTED REGION END*/
	}

}
