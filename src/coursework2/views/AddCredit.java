package coursework2.views;

import coursework2.BankCard;
import coursework2.CreditCard;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import coursework2.components.*;

public class AddCredit extends JFrame {
    CustomTextField cardIdTF, clientNameTF, issuerBankTF, bankAccTF, balanceAmmTF, cvcNoTF, interestRateTF, t8;
    CustomLabel addDebitLabel, cardIdLabel, clientNameLabel, issuerBankLabel, bankAccLabel, balanceAmmLabel, cvcNoLabel, interestRateLabel, expirationDateLabel;
    CustomButton addbutton, clearButton, displayButton;
    CustomComboBox yearDrop, monthDrop, dayDrop;
    public AddCredit(ArrayList<BankCard> bankCards){
        super("Add Credit Card");
        setSize(700, 700);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);

        JPanel panel = new JPanel();
        GridBagLayout gbl = new GridBagLayout();
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.CENTER;
        panel.setLayout(gbl);

        addDebitLabel = new CustomLabel("Add Credit Card");
        cardIdLabel = new CustomLabel("Card Id");
        clientNameLabel = new CustomLabel("Client Name");
        issuerBankLabel = new CustomLabel("Issue Bank");
        bankAccLabel = new CustomLabel("Bank Account");
        balanceAmmLabel = new CustomLabel("Balance Amount");
        cvcNoLabel = new CustomLabel("CVC Number");
        interestRateLabel = new CustomLabel("Interest Rate");
        expirationDateLabel = new CustomLabel("Expiration Date");

        cardIdTF = new CustomTextField("");
        clientNameTF = new CustomTextField("");
        issuerBankTF = new CustomTextField("");
        bankAccTF = new CustomTextField("");
        balanceAmmTF = new CustomTextField("");
        cvcNoTF = new CustomTextField("");
        interestRateTF = new CustomTextField("");
        t8 = new CustomTextField("");


        addbutton = new CustomButton("Add");
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

//      when button is clicked add to arraylist
        addbutton.addActionListener(e -> {
            try {
                String cardId = cardIdTF.getText();
                String clientName = clientNameTF.getText();
                String issuerBank = issuerBankTF.getText();
                String bankAccount = bankAccTF.getText();
                String balanceAmount = balanceAmmTF.getText();
                String cvcNumber = cvcNoTF.getText();
                String interestRate = interestRateTF.getText();

                if (cardId.equals("") || clientName.equals("") || issuerBank.equals("") || bankAccount.equals("") || balanceAmount.equals("") || cvcNumber.equals("") ||
                        interestRate.equals("") || yearDrop.getSelectedItem().equals("select year") || monthDrop.getSelectedItem().equals("select month") || dayDrop.getSelectedItem().equals("select day")) {
                    JOptionPane.showMessageDialog(null, "Please fill all the fields");
                } else {
//                    convert string to necessary data types
                    int card = Integer.parseInt(cardId);
                    double balance = Double.parseDouble(balanceAmount);
                    int cvc = Integer.parseInt(cvcNumber);
                    double interest = Double.parseDouble(interestRate);
                    String expirationDate = yearDrop.getSelectedItem() + "-" + monthDrop.getSelectedItem() + "-" + dayDrop.getSelectedItem();
                    CreditCard creditCard = new CreditCard(card, clientName, issuerBank, balance, bankAccount, cvc, interest, expirationDate);
                    bankCards.add(creditCard);
                    JOptionPane.showMessageDialog(null, "Credit Card added successfully");
                    clear();
                }
            }catch(Exception E){
                JOptionPane.showMessageDialog(null, "Please Fill the Form Correctly");

            }
        });

        clearButton.addActionListener(e -> {
            clear();
        });

        displayButton.addActionListener(e -> {
            new CreditDisplay(bankCards);

        });



        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.CENTER;
        panel.add(addDebitLabel, gbc);

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
        panel.add(clientNameLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        panel.add(clientNameTF, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 1;
        panel.add(issuerBankLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.gridwidth = 1;
        panel.add(issuerBankTF, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 1;
        panel.add(bankAccLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 4;
        gbc.gridwidth = 1;
        panel.add(bankAccTF, gbc);

        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = 1;
        panel.add(balanceAmmLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 5;
        gbc.gridwidth = 1;
        panel.add(balanceAmmTF, gbc);

        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.gridwidth = 1;
        panel.add(cvcNoLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 6;
        gbc.gridwidth = 1;
        panel.add(cvcNoTF, gbc);

        gbc.gridx = 0;
        gbc.gridy = 7;
        gbc.gridwidth = 1;
        panel.add(interestRateLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 7;
        gbc.gridwidth = 1;
        panel.add(interestRateTF, gbc);

        gbc.gridx = 0;
        gbc.gridy = 8;
        gbc.gridwidth = 1;
        panel.add(expirationDateLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 8;
        gbc.gridwidth = 1;
        panel.add(yearDrop, gbc);

        gbc.gridx = 1;
        gbc.gridy = 9;
        gbc.gridwidth = 1;
        panel.add(monthDrop, gbc);

        gbc.gridx = 1;
        gbc.gridy = 10;
        gbc.gridwidth = 1;
        panel.add(dayDrop, gbc);

        gbc.gridx = 0;
        gbc.gridy = 11;
        gbc.gridwidth = 1;
        panel.add(displayButton, gbc);

        gbc.gridx = 1;
        gbc.gridy = 11;
        gbc.gridwidth = 1;
        panel.add(addbutton, gbc);

        gbc.gridx = 2;
        gbc.gridy = 11;
        gbc.gridwidth = 1;
        panel.add(displayButton, gbc);

        add(panel);
    }

    public void clear(){
        cardIdTF.setText("");
        clientNameTF.setText("");
        issuerBankTF.setText("");
        bankAccTF.setText("");
        balanceAmmTF.setText("");
        cvcNoTF.setText("");
        interestRateTF.setText("");
        t8.setText("");
        yearDrop.setSelectedIndex(0);
        monthDrop.setSelectedIndex(0);
        dayDrop.setSelectedIndex(0);

    }
}
