package test;

import business.Account;
import business.AccountFactory;
import business.Amount;
import business.SavingAccount;


public class TestSavingsAccount {

	public static void main(String[] args) {
		Account account = new AccountFactory().createAccount(AccountFactory.Type.SAVING);
		account.setBeginSaldo(new Amount(1000.0));
		System.out.printf("\nBeginsaldo before: %.2f", account.getBeginSaldo().getAmount());
		account = GenerateTestData.createTransactions(account);
		System.out.printf("\nAll transactions: %s", account.getTransactions());
		System.out.printf("\nTotal transactions: %.2f", account.totalTransactions().getAmount());
		System.out.printf("\n\tBaseIntrest: %.2f", ((SavingAccount)account).baseIntrest().getAmount());
		System.out.printf("\n\tLoyalty premium: %.2f", ((SavingAccount)account).loyaltyPremium().getAmount());
		System.out.printf("\n\tGrowth premium: %.2f", ((SavingAccount)account).growthPremium().getAmount());

		account.updateAccount();
		System.out.printf("\nBeginsaldo after update: %.2f", account.getBeginSaldo().getAmount());
	
	}

}
