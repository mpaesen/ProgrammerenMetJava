package model;

import temperature.view.TestTemperature;

/**
 * Write a description of class Conversion here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Conversion {
    /**
     * convert temperatuur omrekeningen Celcius -> Fahrenheit: (temp * 1.8 ) +
     * 32 Celcius -> Kelvin: temp + 273
     *
     * @param Temperature, char
     * @return Temperature
     */
    public static Temperature convert(Temperature temp, char type) {
        // put your code here
        switch (type) {
            case Temperature.CELCIUS:
                return convertToCelcius(temp);
            case Temperature.KELVIN:
                return convertToKelvin(temp);
            case Temperature.FARENHEIT:
                return convertToFarenheit(temp);
            default:
                return null;
        }
    }

    /**
     * convert to Celcius
     *
     * @param temperature, symbol
     * @return temperature
     */
    public static Temperature convertToCelcius(Temperature temp) {
        switch (temp.getSymbol()) {
            case Temperature.CELCIUS:
                return temp;
            case Temperature.KELVIN:
                return ((Kelvin) temp).getTempInCelcius();
            case Temperature.FARENHEIT:
                return ((Farenheit) temp).getTempInCelcius();
            default:
                return null;
        }
    }

    /**
     * convert to Farenheit
     *
     * @param temperature, symbol
     * @return temperature
     */
    public static Temperature convertToFarenheit(Temperature temp) {
        switch (temp.getSymbol()) {
            case Temperature.FARENHEIT:
                return temp;
            case Temperature.KELVIN:
                return ((Celcius) ((Kelvin) temp).getTempInCelcius())
                        .getTempInFarenheit();
            case Temperature.CELCIUS:
                return ((Celcius) temp).getTempInFarenheit();
            default:
                return null;
        }
    }

    /**
     * convert to Kelvin
     *
     * @param temperature, symbol
     * @return temperature
     */
    public static Temperature convertToKelvin(Temperature temp) {
        switch (temp.getSymbol()) {
            case Temperature.KELVIN:
                return temp;
            case Temperature.CELCIUS:
                return ((Celcius) temp).getTempInKelvin();
            case Temperature.FARENHEIT:
                return ((Celcius) ((Farenheit) temp).getTempInCelcius())
                        .getTempInKelvin();
            default:
                return null;
        }
    }

    /**
     * addition method: Adds 2 different temperatures into a new temperature
     * instance
     *
     * @param Temperature, Temperature, Symbol
     * @return Temperature
     */
    public static Temperature add(Temperature temp1, Temperature temp2,
                                  char symbol) {
        Temperature temp, operand1 = temp1, operand2 = temp2;
        switch (symbol) {
            case Temperature.KELVIN: {
                temp = new Kelvin(0.0d);
                operand1 = convertToKelvin(temp1);
                operand2 = convertToKelvin(temp2);
            }
            break;
            case Temperature.CELCIUS: {
                temp = new Celcius(0.0d);
                operand1 = convertToCelcius(temp1);
                operand2 = convertToCelcius(temp2);
            }
            break;
            case Temperature.FARENHEIT: {
                temp = new Farenheit(0.0d);
                operand1 = convertToFarenheit(temp1);
                operand2 = convertToFarenheit(temp2);
            }
            break;
            default:
                temp = null;
        }
        temp.setTemperature(operand1.getTemperature().add(
                operand2.getTemperature()));
        return temp;
    }

    /**
     * @param String (temperature)
     * @return String
     * @purpose get the temperature value
     * @autor Mathy paesen
     */
    public static double getWebTemperatureInput(String temperature) {
        String stringValue;
        double doubleValue = 0.0;
        boolean isNumber = false;
        do {
            stringValue = temperature;
            try {
                doubleValue = Double.parseDouble(stringValue);
                isNumber = true;
            } catch (NumberFormatException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } while (!isNumber);
        return doubleValue;
    }

    /**
     * @param String (user's choices)
     * @return char
     * @purpose get the temperature (symbol) choice
     * @autor Mathy paesen
     */
    public static char getWebSymbolInput(String choice) {
        char inputValue;
        do {
            inputValue = Character.toUpperCase(choice.charAt(0));
        } while ((inputValue != Temperature.CELCIUS)
                && (inputValue != Temperature.FARENHEIT)
                && (inputValue != Temperature.KELVIN) && (inputValue != 'Q'));
        if (inputValue == 'Q')
            System.exit(0);
        return inputValue;
    }

    /**
     * @param String (user's choices)
     * @return char
     * @purpose let the user choose between Conversion & Addition
     * @autor Mathy paesen
     */
    public static char getWebChoice(String choice) {
        char inputValue;
        do {
            inputValue = Character.toUpperCase(choice.charAt(0));
        } while ((inputValue != Temperature.CONVERSION)
                && (inputValue != Temperature.ADDITION) && (inputValue != 'Q'));
        if (inputValue == 'Q')
            System.exit(0);
        return inputValue;
    }

    /**
     * Generated by Together on Oct 8, 2003
     */
    public static Temperature convertInitialTemperature(Temperature temp,
                                                        char inputValue) {
        Temperature tempOut = null;
        switch (inputValue) {
            case Temperature.CELCIUS:
                tempOut = Conversion.convertToCelcius(temp);
                break;
            case Temperature.KELVIN:
                tempOut = Conversion.convertToKelvin(temp);
                break;
            case Temperature.FARENHEIT:
                tempOut = Conversion.convertToFarenheit(temp);
                break;
            default:
                break;
        }
        return tempOut;
    }

    /**
     * Generated by Together on Oct 8, 2003
     */
    public static Temperature getInitialTemperature(char inputValue) {
        double doubleValue;
        doubleValue = TestTemperature.getTemperatureInput("Temperature :");
        Temperature temp = createTemperature(inputValue, doubleValue);
        return temp;
    }

    /**
     * Modified by Mathy on Sept 2, 2004
     */
    public static Temperature getWebInitialTemperature(String temperature,
                                                       char inputValue) {
        double doubleValue;
        doubleValue = getWebTemperatureInput(temperature);
        Temperature temp = createTemperature(inputValue, doubleValue);
        return temp;
    }

    private static Temperature createTemperature(char inputValue,
                                                 double doubleValue) {
        Temperature temp = null;
        switch (inputValue) {
            case Temperature.CELCIUS:
                temp = new Celcius(doubleValue);
                break;
            case Temperature.KELVIN:
                temp = new Kelvin(doubleValue);
                break;
            case Temperature.FARENHEIT:
                temp = new Farenheit(doubleValue);
                break;
            default:
                break;
        }
        return temp;
    }
}