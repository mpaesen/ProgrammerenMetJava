package lab12.solution.account;


public class InvalidAmountException extends TransactionException {

public InvalidAmountException() {
   super("Invalid amount");
}
}
