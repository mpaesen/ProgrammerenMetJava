/** 
 *  Exercise : 		Opdracht3 : Ontwerpen met java
 *  FileName :   	Adres.java
 *  @author Pascal Sempels 
 *  @version Revision : 1.0  date : 06/02/2010
 *  
 *  TempBean :Classe die wordt gebruikt om gegevens door te geven naar Temp.jsp 
 */
package beans;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;



public class TempBean {
 //Members
	private static final double MIN_C = -273.15;
	private static final double MIN_F = -459.67;
	private static final double MIN_K = 0;
	
	private double tempWaarde;
	private double tempCResult;
	private double tempKResult;
	private double tempFResult;
	private String temperatuurSchaal;
	private String functie="";
	private boolean aangepast= true;
	
	//Constructors
	/**
	 * Default Constructor
	 */
	public TempBean() {	
		aangepast= true;
	}
	
	
	//Getters en Setters
	/**
	 * @return the temp
	 */
	public double getTempWaarde() {
		return tempWaarde;
	}
	
	/**
	 * @param temp the temp to set
	 */
	public void setTempWaarde(double temp) {
		this.tempWaarde = temp;
	}
	/**
	 * @return the tempResult
	 */
	public double getTempCResult() {
		return tempCResult;
	}
	/**
	 * @param tempResult the tempResult to set
	 */
	public void setTempCResult(double tempResult) {
		this.tempCResult = tempResult;
	}
	/**
	 * @return the tempResult
	 */
	public double getTempFResult() {
		return tempFResult;
	}
	/**
	 * @param tempResult the tempResult to set
	 */
	public void setTempFResult(double tempResult) {
		this.tempFResult = tempResult;
	}
	/**
	 * @return the tempResult
	 */
	public double getTempKResult() {
		return tempKResult;
	}
	/**
	 * @param tempResult the tempResult to set
	 */
	public void setTempKResult(double tempResult) {
		this.tempKResult = tempResult;
	}
	/**
	 * @return the functie
	 */
	public String getFunctie() {
		return functie;
	}
	/**
	 * @param functie the functie to set
	 */
	public void setFunctie(String functie) {
		this.functie = functie;
	}
	public void setTemperatuurSchaal(String temperatuurSchaal) {
		this.temperatuurSchaal = temperatuurSchaal;
	}
	public String getTemperatuurSchaal() {
		return temperatuurSchaal;
	}
	//Method's
	
	/**
	 * Methode om een temperatuurwaarde om te rekenen naar Celsius;Fahrenheit;Kelvin
	 */
	public String Converteer() throws Exception{
		FacesContext context = FacesContext.getCurrentInstance();
		if (this.temperatuurSchaal.equals("°C")){
			if(this.tempWaarde < MIN_C ){
				FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,"Waarde < Min_°C","TemperatuurWaarde lager dan het minimum graden Celcius !");
				context.addMessage(null, msg);
				this.tempWaarde=0.0;
			}else { 
				this.setTempCResult(this.tempWaarde);
				this.setTempFResult(((this.tempWaarde*9/5)+32));
				this.setTempKResult((this.tempWaarde+273.15));
			}
		}else if (this.temperatuurSchaal.equals("°F")){
			if(this.tempWaarde < MIN_F ){
				FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,"Waarde < Min_°F","TemperatuurWaarde lager dan het minimum graden Fahrenheit !");
				context.addMessage(null, msg);
				this.tempWaarde=0.0;
			}else { 
				this.setTempCResult((this.tempWaarde-32)*5/9);
				this.setTempFResult(this.tempWaarde);
				this.setTempKResult((this.tempWaarde-32)*5/9+273.15);
			}
			
		}else if(this.temperatuurSchaal.equals("K")){
			if(this.tempWaarde < MIN_K ){
				 	FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,"Waarde < Min_K","TemperatuurWaarde lager dan het minimum Kelvin !");
					context.addMessage(null, msg);
					this.tempWaarde=0.0;
			}else { 
				this.setTempCResult(this.tempWaarde-273.15);
				this.setTempFResult((this.tempWaarde-273.15)*9/5+32);
				this.setTempKResult(this.tempWaarde);
			}
		}
		aangepast = false;
		return "Geconverteerd";
	}


	public void setAangepast(boolean aangepast) {
		this.aangepast = aangepast;
	}


	public boolean isAangepast() {
		return aangepast;
	}
}
