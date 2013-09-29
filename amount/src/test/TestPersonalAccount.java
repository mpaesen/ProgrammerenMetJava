package test;

import java.util.Random;

import model.Amount;
import model.PersonalAccount;
/**
 * 
 * @author Mathy Paesen
 * @since 29/09/2013
 *
 */

public class TestPersonalAccount {
	private static Random random = new Random();
	private static long accountNumber = 1;
	private static final int LIMIT = 35;
	private static final int FACTOR = 1000000;
	
	public static void main(String[] args) {
		int limit = random.nextInt(LIMIT);
		
		//fill array accounts
		PersonalAccount accounts[] = new PersonalAccount[limit];
		for(int i=0; i<accounts.length; i++){
			accounts[i]= getPersonalAccount();
		}
		
		//print all accounts
		for(int i=0; i<accounts.length; i++){
			System.out.println(accounts[i]);
		}
	}
	/**
	 * Create a random PersonalAccount
	 * @return PersonalAccount
	 */
	public static PersonalAccount getPersonalAccount(){
		PersonalAccount account = new PersonalAccount();
		account.setAccountnr(accountNumber++);
		double amount = FACTOR * random.nextDouble();
		Amount newbalance = new Amount(amount);
		account.setBalance(newbalance);
		return account;
	}

}
