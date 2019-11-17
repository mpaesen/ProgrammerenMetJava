// FrontEnd Plus GUI for JAD
// DeCompiled : Farenheit.class

package temperature.model;

import java.math.BigDecimal;

// Referenced classes of package model:
//            Temperature
public class Farenheit extends Temperature {
	public static final BigDecimal FARENHEIT = new BigDecimal(32D);

	public static final BigDecimal FACTOR18 = new BigDecimal(1.8D);

	public Farenheit(double temp) {
		super(temp);
		setSymbol('F');
	}

	public Temperature getTempInCelcius() {
		BigDecimal conversie = ((getTemperature().add(FARENHEIT.negate()))
				.divide(FACTOR18, SCALE, BigDecimal.ROUND_HALF_UP)).setScale(
				SCALE, BigDecimal.ROUND_HALF_UP);
		return new Celcius(conversie.doubleValue());
	}
}