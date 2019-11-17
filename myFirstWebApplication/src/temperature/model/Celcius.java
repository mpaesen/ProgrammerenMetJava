// FrontEnd Plus GUI for JAD
// DeCompiled : Celcius.class

package temperature.model;

import java.math.BigDecimal;

// Referenced classes of package model:
//            Temperature
public class Celcius extends Temperature {
	public Celcius(double temp) {
		super(temp);
		setSymbol('C');
	}

	public Temperature getTempInFarenheit() {
		BigDecimal conversie = ((getTemperature().multiply(Farenheit.FACTOR18))
				.add(Farenheit.FARENHEIT).setScale(SCALE,
				BigDecimal.ROUND_HALF_UP)).setScale(SCALE,
				BigDecimal.ROUND_HALF_UP);
		return new Farenheit(conversie.doubleValue());
	}

	public Temperature getTempInKelvin() {
		BigDecimal conversie = (getTemperature().add(Kelvin.KELVIN).setScale(
				SCALE, BigDecimal.ROUND_HALF_UP)).setScale(SCALE,
				BigDecimal.ROUND_HALF_UP);
		return new Kelvin(conversie.doubleValue());
	}
}