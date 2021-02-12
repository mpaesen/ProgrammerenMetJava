package structural.proxy;

public class You {
    private String name;
    private Account account;
    private boolean card;

    public You(String name) {
        this.name = name;
    }

    public int getAccountNumber() {
        return this.account.getAccountNumber();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public boolean getCard() {
        return card;
    }

    public void setCard(boolean card) {
        this.card = card;
    }
}
