package it.csi.sicee.siceeweb.presentation.siceeweb.converter;

import java.util.Map;

import it.csi.sicee.siceeweb.dto.type.UDTDateValid;

import org.apache.struts2.util.StrutsTypeConverter;

import com.opensymphony.xwork2.conversion.TypeConversionException;

/*PROTECTED REGION ID(R541609413) ENABLED START*/
//inserire qui eventuali import aggiuntivi

/*PROTECTED REGION END*/

/**
 * Custom Type Converter per lo user defined type [DateValid].
 * 
 * @author [GUIGEN]
 * @generated
 */
public class UDTDateValidConverter extends StrutsTypeConverter {

	/**
	 * Trasforma una rappresentazione a stringa di un oggetto di tipo
	 * UDTDateValid.
	 * @param  context
	 * @param  values
	 * @param  toClass
	 * @return
	 * @see org.apache.struts2.util.StrutsTypeConverter#convertFromString(java.util.Map, java.lang.String[], java.lang.Class)
	 */
	@Override
	public Object convertFromString(Map context, String[] values, Class toClass) {
		/*PROTECTED REGION ID(R156077765) ENABLED START*/
		if (values != null && values.length > 0 && values[0] != null && values[0].trim().length() > 0) {
			String s = values[0].trim();
			java.util.Locale.setDefault(java.util.Locale.ITALY);
			java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("dd/MM/yyyy");

			try {
				java.text.ParsePosition parsePosition = new java.text.ParsePosition(0);

				if (!s.matches(
						"^(((0[1-9]|[12]\\d|3[01])\\/(0[13578]|1[02])\\/((1[6-9]|[2-9]\\d)\\d{2}))|((0[1-9]|[12]\\d|30)\\/(0[13456789]|1[012])\\/((1[6-9]|[2-9]\\d)\\d{2}))|((0[1-9]|1\\d|2[0-8])\\/02\\/((1[6-9]|[2-9]\\d)\\d{2}))|(29\\/02\\/((1[6-9]|[2-9]\\d)(0[48]|[2468][048]|[13579][26])|((16|[2468][048]|[3579][26])00))))$")) {
					throw new java.text.ParseException("impossibile convertire l'intera stringa",
							parsePosition.getIndex());
				}

				return new UDTDateValid(s);
			} catch (java.text.ParseException e) {
				throw new TypeConversionException(e);
			}

		}
		return null;
		/*PROTECTED REGION END*/
	}

	/**
	 * Trasforma una istanza di UDTDateValid nella rappresentazione a stringa.
	 * @param
	 * @param
	 * @return
	 * @see org.apache.struts2.util.StrutsTypeConverter#convertToString(java.util.Map, java.lang.Object)
	 */
	@Override
	public String convertToString(Map context, Object o) {
		UDTDateValid val = (UDTDateValid) o;
		/*PROTECTED REGION ID(R-992413866) ENABLED START*/
		if (o instanceof UDTDateValid) {
			if (val.getValue() != null) {
				java.util.Locale.setDefault(java.util.Locale.ITALY);

				return ((UDTDateValid) o).getValue();
			}
		}

		return val.toString();
		/*PROTECTED REGION END*/
	}

}
