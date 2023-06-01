package coursework2;

public class CreditCard extends BankCard{
    private int cvcNumber;
    private double creditLimit;
    private double interestRate;
    private String expirationDate;
    private int gracePeriod;
    private boolean isGranted;

    //parameterized constructor
    public CreditCard(int cardID, String issuerBank, String bankAccount, double balanceAmount, String clientName, int cvcNumber, double interestRate, String expirationDate){
        super(cardID, issuerBank, bankAccount, balanceAmount, "Credit Card");
        super.setBalanceAmount(balanceAmount);
        super.setClientName(clientName);
        this.cvcNumber=cvcNumber;
        this.interestRate=interestRate;
        this.expirationDate=expirationDate;
        this.isGranted=false;
    }

    public int getCvcNumber(){
        return this.cvcNumber;//getter for cvcNumber
    }

    public double getCreditLimit(){
        return this.creditLimit;//getter for crditLimit
    }

    public double getInterestRate(){
        return this.interestRate;//getter for interestRate
    }

    public String getExpirationDate(){
        return this.expirationDate;//getter for expirationDate
    }

    public int getGracePeriod(){
        return this.gracePeriod;//getter for gracePeriod
    }

    public boolean getIsGranted(){
        return this.isGranted;
    }

    public void setCreditLimit(double creditLimit){
        this.creditLimit=creditLimit;//setter for creditlimit
    }

    public void creditLimit(double creditLimit, int gracePeriod) {
        //checks the condition
        if (creditLimit <= 2.5 * getBalanceAmount()){
            this.creditLimit = creditLimit;
            this.gracePeriod = gracePeriod;
            isGranted = true;
//            System.out.println("Your Credit is granted");
        }
        else{
            System.out.println("Credit cannot be issued");
        }
    }

    // method to cancel the credit card
    public void cancelCreditCard(){
        cvcNumber = 0;
        creditLimit = 0;
        gracePeriod = 0;
        isGranted = false;
    }

    //method to display credit card detail
    public void display(){
        super.display();
        if (isGranted){
            System.out.println("CVC Number: " + cvcNumber);
            System.out.println("Credit Limit: " + creditLimit);
            System.out.println("Interest Rate: " + interestRate);
            System.out.println("Expiration Date: " + expirationDate);
            System.out.println("Grace Period: " + gracePeriod);
        } else {
            System.out.println("Credit not granted yet");
        }
    }
}
