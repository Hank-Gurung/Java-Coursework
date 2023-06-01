package coursework2.views;

import javax.swing.*;
import java.awt.*;
import coursework2.components.*;
import coursework2.BankCard;
import coursework2.DebitCard;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
public class WithdrawDebit extends JFrame {
    CustomButton withdrawButton, clearButton, displayButton;
    CustomTextField cardIdTF, withdrawlAmmTF, pinNoTF;
    CustomLabel withdrawLabel, cardIdLabel, withdrawlAmountLabel, pinNoLabel, DOWithdrawl;
    CustomComboBox yearDrop,monthDrop,dayDrop;

    public WithdrawDebit(ArrayList<BankCard> bankCards){
        super("Withdraw from Debit Card");
        setSize(700, 700);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);

        JPanel panel = new JPanel();

        withdrawLabel = new CustomLabel("Withdraw from Debit Card");
        cardIdLabel = new CustomLabel("Card Id");
        withdrawlAmountLabel = new CustomLabel("Withdrawal Amount");
        pinNoLabel = new CustomLabel("PIN Number");
        DOWithdrawl = new CustomLabel("Date of Withdrawal");

        cardIdTF = new CustomTextField("");
        withdrawlAmmTF = new CustomTextField("");
        pinNoTF = new CustomTextField("");

        withdrawButton = new CustomButton("Withdraw");
        clearButton = new CustomButton("Clear");
        displayButton = new CustomButton("Display");
        yearDrop = new CustomComboBox(new String[]{
                "select year", "2016", "2017", "2018", "2019",
                "2020", "2021", "2022", "2023", "2024", "2025"
        });

        monthDrop = new CustomComboBox(new String[]{
                "select month", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10","11","12"});
        //days
        dayDrop = new CustomComboBox(new String[]{
                "select day", "01", "02", "03", "04", "05", "06", "07", "08", "09",
                "10","11","12","13","14","15","16","17","18","19","20",
                "21","22","23","24","25","26","27","28","29","30","31"});

        withdrawButton.addActionListener(e -> {
            try{
                String cardId = cardIdTF.getText();
                String withdrawalAmount = withdrawlAmmTF.getText();
                String pinNumber = pinNoTF.getText();

                if (cardId.equals("") ||  pinNumber.equals("") || yearDrop.getSelectedItem().equals("select year")|| monthDrop.getSelectedItem().equals("select month") || dayDrop.getSelectedItem().equals("select day")){
                    JOptionPane.showMessageDialog(null, "Please fill all the fields");
                }else {
                    int card = Integer.parseInt(cardId);
                    int withdraw = Integer.parseInt(withdrawalAmount);
                    int pin = Integer.parseInt(pinNumber);
                    String dateOfWithdrawal = yearDrop.getSelectedItem() + "-" + monthDrop.getSelectedItem() + "-" + dayDrop.getSelectedItem();
                    boolean foundCard = false;
                    DebitCard debitCard = null;
                    for (BankCard bankCard : bankCards) {
                        if (bankCard instanceof DebitCard) {
                            debitCard = (DebitCard) bankCard;
                            if (debitCard.getCardId() == card) {
                                foundCard = true;
                                break;
                            }
                        }
                    }
//                    when card is found calls to method to withdraw
                    if (foundCard) {
                        withdraw(debitCard, pin, withdraw, dateOfWithdrawal);
                        clear();
                    } else {
                        JOptionPane.showMessageDialog(null, "Card not found");
                    }
                }
            }catch(Exception E){
                JOptionPane.showMessageDialog(null, "Please Fill the Form Correctly");
            }

        });

        clearButton.addActionListener(e -> {
            clear();
        });

        displayButton.addActionListener(e -> {
            new DebitDisplay(bankCards);
        });

        GridBagLayout gbl = new GridBagLayout();
        GridBagConstraints gbc = new GridBagConstraints();
        panel.setLayout(gbl);

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.CENTER;
        panel.add(withdrawLabel, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        panel.add(cardIdLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        panel.add(cardIdTF, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        panel.add(withdrawlAmountLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        panel.add(withdrawlAmmTF, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 1;
        panel.add(pinNoLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.gridwidth = 1;
        panel.add(pinNoTF, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 1;
        panel.add(DOWithdrawl, gbc);

        gbc.gridx = 1;
        gbc.gridy = 4;
        gbc.gridwidth = 1;
        panel.add(yearDrop, gbc);

        gbc.gridx = 1;
        gbc.gridy = 5;
        gbc.gridwidth = 1;
        panel.add(monthDrop, gbc);

        gbc.gridx = 1;
        gbc.gridy = 6;
        gbc.gridwidth = 1;
        panel.add(dayDrop, gbc);

        gbc.gridx = 0;
        gbc.gridy = 7;
        gbc.gridwidth = 1;
        panel.add(clearButton, gbc);

        gbc.gridx = 1;
        gbc.gridy = 7;
        gbc.gridwidth = 1;
        panel.add(withdrawButton, gbc);

        gbc.gridx = 2;
        gbc.gridy = 7;
        gbc.gridwidth = 1;
        panel.add(displayButton, gbc);

        add(panel);
    }

//    method to Withdraw and calls the method in DebitCard Class
    public  void withdraw(DebitCard debitCard,int pin,int withdrawal,String dateOfWithdrawal) {
        if (debitCard.getPinNumber() == pin) {
            if (debitCard.getBalanceAmount() < withdrawal) {
                JOptionPane.showMessageDialog(null, "Insufficient Funds");
                return;
            }
            debitCard.withdraw(withdrawal, dateOfWithdrawal, pin);
            JOptionPane.showMessageDialog(null, "Withdrawal Successful");
            clear();
        }else {
            JOptionPane.showMessageDialog(null, "Incorrect Pin Number");
        }
    }

    public void clear(){
        cardIdTF.setText("");
        withdrawlAmmTF.setText("");
        pinNoTF.setText("");
        yearDrop.setSelectedIndex(0);
        monthDrop.setSelectedIndex(0);
        dayDrop.setSelectedIndex(0);

    }
}
