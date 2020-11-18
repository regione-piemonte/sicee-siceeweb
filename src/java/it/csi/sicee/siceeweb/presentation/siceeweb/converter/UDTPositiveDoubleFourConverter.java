package it.csi.sicee.siceeweb.presentation.siceeweb.converter;

import java.util.Map;

import it.csi.sicee.siceeweb.dto.type.UDTPositiveDoubleFour;

import org.apache.struts2.util.StrutsTypeConverter;

import com.opensymphony.xwork2.conversion.TypeConversionException;

/*PROTECTED REGION ID(R-1199247453) ENABLED START*/
//inserire qui eventuali import aggiuntivi

/*PROTECTED REGION END*/

/**
 * Custom Type Converter per lo user defined type [PositiveDoubleFour].
 * 
 * @author [GUIGEN]
 * @generated
 */
public class UDTPositiveDoubleFourConverter extends StrutsTypeConverter {

	/**
	 * Trasforma una rappresentazione a stringa di un oggetto di tipo
	 * UDTPositiveDoubleFour.
	 * @param  context
	 * @param  values
	 * @param  toClass
	 * @return
	 * @see org.apache.struts2.util.StrutsTypeConverter#convertFromString(java.util.Map, java.lang.String[], java.lang.Class)
	 */
	@Override
	public Object convertFromString(Map context, String[] values, Class toClass) {
		/*PROTECTED REGION ID(R-472582375) ENABLED START*/
		if (values != null && values.length > 0 && values[0] != null && values[0].trim().length() > 0) {
			String s = values[0].trim();
			java.util.Locale.setDefault(java.util.Locale.ITALY);
			java.text.DecimalFormat df = new java.text.DecimalFormat("##########.####");

			//df.setMinimumFractionDigits(2);
			//df.setMaximumFractionDigits(2);

			try {
				java.text.ParsePosition parsePosition = new java.text.ParsePosition(0);
				Number n = df.parse(s, parsePosition);

				if (!s.matches("^[0-9]{1,10}(,[0-9]{0,4})?$")) {
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

				return new UDTPositiveDoubleFour(n.doubleValue());
			} catch (java.text.ParseException e) {
				throw new TypeConversionException(e);
			}

		}
		return null;
		/*PROTECTED REGION END*/
	}

	/**
	 * Trasforma una istanza di UDTPositiveDoubleFour nella rappresentazione a stringa.
	 * @param
	 * @param
	 * @return
	 * @see org.apache.struts2.util.StrutsTypeConverter#convertToString(java.util.Map, java.lang.Object)
	 */
	@Override
	public String convertToString(Map context, Object o) {
		UDTPositiveDoubleFour val = (UDTPositiveDoubleFour) o;
		/*PROTECTED REGION ID(R-184130390) ENABLED START*/
		if (o instanceof UDTPositiveDoubleFour) {
			if (val.getValue() != null) {
				java.util.Locale.setDefault(java.util.Locale.ITALY);
				java.text.DecimalFormat df = new java.text.DecimalFormat("##########.####");
				//df.setMinimumFractionDigits(2);
				//df.setMaximumFractionDigits(2);
				return df.format(((UDTPositiveDoubleFour) o).getValue());
			}
		}

		return val.toString();
		/*PROTECTED REGION END*/
	}

}
