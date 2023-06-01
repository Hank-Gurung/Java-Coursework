package coursework2;

public class BankCard {
    private int cardID;
    private String clientName;
    private String issuerBank;
    private String bankAccount;
    private double balanceAmount;
    private String cardType;
    //parameterized constructor
    public BankCard(int cardID, String issuerBank, String bankAccount, double balanceAmount,String cardType){
        this.cardID = cardID;
        this.issuerBank = issuerBank;
        this.bankAccount = bankAccount;
        this.balanceAmount = balanceAmount;
        this.cardType = cardType;
        this.clientName = "";
    }

    public void setClientName(String clientName){
        this.clientName = clientName;//setter for clientName
    }

    public String getClientName(){
        return this.clientName;//getter for clientName
    }

    public int getCardId(){
        return this.cardID;//getter for cardId
    }

    public String getIssuerBank(){
        return this.issuerBank;//getter for issuerBank
    }

    public String getCardType() {
        return cardType;
    }
    public String getBankAccount(){
        return this.bankAccount;//getter for bankAccount
    }

    public double getBalanceAmount(){
        return this.balanceAmount;//getter for balanceAmount
    }

    public void setBalanceAmount(double balanceAmount){
        this.balanceAmount=balanceAmount;//setter for balanceAmount
    }

    public void display() {//displays the details of coursework2.BankCard
        if (clientName.equals("")) {//checks the condition
            System.out.println("Client name not assigned");
        } else {
            System.out.println("Card ID: " + cardID);
            System.out.println("Client Name: " + clientName);
            System.out.println("Issuer Bank: " + issuerBank);
            System.out.println("Bank Account: " + bankAccount);
            System.out.println("Balance Amount: " + balanceAmount);
        }
    }

}
