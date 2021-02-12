/** 
 *  Exercise : 		Opdracht3 : Ontwerpen met java
 *  FileName :   	Adres.java
 *  @author Pascal Sempels 
 *  @version Revision : 1.0  date : 06/02/2010
 *  
 *  CalculatorBean : wordt gebruikt als bean voor gegevens door te sturen naar de Calc.jsp 
 */
package beans;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public class CalculatorBean {

	// de members
	private double getalA ;
	private double getalB;
	private double result;
	private String functie;
	private boolean aangepast = true;

	
	//Getters en Setters
	/**
	 * @return the getalA
	 */
	public double getGetalA() {
		return this.getalA;
	}
	/**
	 * @param getalA the getalA to set
	 */
	public void setGetalA(double getalA) {
		this.getalA = getalA;
	}
	/**
	 * @return the getalB
	 */
	public double getGetalB() {
		return this.getalB;
	}
	/**
	 * @param getalB the getalB to set
	 */
	public void setGetalB(double getalB) {
		this.getalB = getalB;
	}
	/**
	 * @return the result
	 */
	public double getResult() {
		return this.result;
	}
	
//	public void setResult(double result){
//		this.result = result;
//	}
	/**
	 * @param result the result to set
	 */
	public String getSom(){
		this.aangepast=false;
		this.result = this.getalA+this.getalB;
		return "Som";
	}
	
	public String getVerschil(){
		this.aangepast=false;
		this.result = this.getalA-this.getalB;
	return "Verschil";
	}
	
	public String getProduct(){
		this.aangepast=false;
		this.result = this.getalA*this.getalB;
		return "Product";
	}
	public String getQuotient() {
		if( getalB != 0){
		this.result = this.getalA / this.getalB;
		this.aangepast=false;
		}
		else {
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,"DivByZero","Delen door null mag niet");
			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage(null, msg);
		}
		return "Quoti�nt";
	}
//	public void setFunctie(String functie) {
//		this.functie = functie;
//	}
	public String getFunctie() {
		return functie;
	}
	
	//Constructor
	/**
	 * Default constructor
	 */
	public CalculatorBean() {}
	
	
	//methodes
	
	/**
	 * Het initialiseren van de getallen
	 */

	public String ClearCalculator() {
		this.getalA=0;
		this.getalB=0;
		this.result=0;
		this.aangepast=true;
		return "Clear";
	}

	public boolean isAangepast() {
		return aangepast;
	}
	
	
	
}
