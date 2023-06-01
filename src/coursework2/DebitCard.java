package coursework2;

public class DebitCard extends BankCard{
    private int pinNumber;
    private int withdrawalAmount;
    private String dateOfWithdrawal;
    private boolean hasWithdrawn;
    //parameterized constructor
    public DebitCard(int cardID, String issuerBank, String bankAccount, double balanceAmount, String clientName, int pinNumber){
        super(cardID, issuerBank, bankAccount, balanceAmount, "Debit Card");
        super.setBalanceAmount(balanceAmount);
        super.setClientName(clientName);
        this.pinNumber = pinNumber;
        this.hasWithdrawn = false;
    }

    public int getPinNumber(){
        return this.pinNumber;//getter for pinNumber
    }

    public int getWithdrawalAmount(){
        return this.withdrawalAmount;//getter for withdrawalAmount
    }

    public boolean hasWithdrawn() {

        return hasWithdrawn;
    }
    public String getDateOfwithdrawal(){
        return this.dateOfWithdrawal;//getter for dateOfWithdrawal
    }

    public void setWithdrawalAmount(int withdrawalAmount){
        this.withdrawalAmount=withdrawalAmount;//setter for withdrawalAmount
    }

    public void withdraw(int withdrawalAmount, String dateOfWithdrawal, int pinNumber){
        //checks is pinNumber is correct or not
        if (this.pinNumber == pinNumber){
            //checks if there is sufficient balance or not
            if (getBalanceAmount() >= withdrawalAmount){
                /*substracts withdrawalAmount from balanceAmount
                and calculate new balanceAmount*/
                setBalanceAmount(getBalanceAmount() - withdrawalAmount);
                this.dateOfWithdrawal = dateOfWithdrawal;
                this.withdrawalAmount = withdrawalAmount;
                hasWithdrawn = true;
                System.out.println("Withdrawal successful. Your remaining balance is " + getBalanceAmount());
            }
            else{
                System.out.println("Insufficient balance.");
            }
        }
        else{
            System.out.println("Invalid pin number.");
        }
    }

    public void display(){//displays the details
        super.display();//calls superclass method
        System.out.println("Pin Number: " + pinNumber);
        if (hasWithdrawn) {
            System.out.println("Withdrawal Amount: " + withdrawalAmount);
            System.out.println("Date of Withdrawal Amount: " + dateOfWithdrawal);
        }
        else{
            System.out.println("Incomplete Transaction.");
        }
    }

}
