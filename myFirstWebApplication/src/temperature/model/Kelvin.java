// FrontEnd Plus GUI for JAD
// DeCompiled : Kelvin.class

package temperature.model;

import java.math.BigDecimal;

// Referenced classes of package model:
//            Temperature
public class Kelvin extends Temperature {
	public static final BigDecimal KELVIN = new BigDecimal(273D);

	public Kelvin(double temp) {
		super(temp);
		setSymbol('K');
	}

	public Temperature getTempInCelcius() {
		BigDecimal conversie = (getTemperature().add(KELVIN.negate()))
				.setScale(SCALE, BigDecimal.ROUND_HALF_UP);
		return new Celcius(conversie.doubleValue());
	}
}