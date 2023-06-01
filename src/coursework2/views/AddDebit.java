package coursework2.views;

import coursework2.BankCard;
import coursework2.DebitCard;
import coursework2.components.*;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class AddDebit extends JFrame {
    CustomTextField balaceAmTF, cardIdTF, bankAccTF, issuerBankTF, clientNameTF, pinNoTF;
    CustomButton addButton, clearButton, displayButton;
    CustomLabel addDebitLabel, balanceAmountLabel, cardIdLabel, bankAccLabel, issuerBankLabel, clientNameLabel, pinNoLabel;
    public AddDebit(ArrayList<BankCard> bankCards){
        super("Add Debit Card");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(700, 700);
        setLocationRelativeTo(null);
        setVisible(true);

        JPanel panel = new JPanel();

        addDebitLabel = new CustomLabel("Add Debit Card");
        balanceAmountLabel = new CustomLabel("Balance Amount");
        cardIdLabel = new CustomLabel("Card Id");
        bankAccLabel = new CustomLabel("Bank Account");
        issuerBankLabel = new CustomLabel("Issuer Bank");
        clientNameLabel = new CustomLabel("Client Name");
        pinNoLabel = new CustomLabel("Pin Number");

        balaceAmTF = new CustomTextField("");
        cardIdTF = new CustomTextField("");
        bankAccTF = new CustomTextField("");
        issuerBankTF = new CustomTextField("");
        clientNameTF = new CustomTextField("");
        pinNoTF = new CustomTextField("");

        addButton = new CustomButton("Add");
        clearButton = new CustomButton("Clear");
        displayButton = new CustomButton("Display");

        addButton.addActionListener(e -> {
            try {
                String balanceAmount = balaceAmTF.getText();
                String cardId = cardIdTF.getText();
                String bankAccount = bankAccTF.getText();
                String issuerBank = issuerBankTF.getText();
                String clientName = clientNameTF.getText();
                String pinNumber = pinNoTF.getText();

                if (balanceAmount.equals("") || cardId.equals("") || bankAccount.equals("") || issuerBank.equals("") || clientName.equals("") || pinNumber.equals("")) {
                    JOptionPane.showMessageDialog(null, "Please fill all the fields");
                } else {
//                    convert string to necessary data types
                    double balance = Double.parseDouble(balanceAmount);
                    int card = Integer.parseInt(cardId);
                    int pin = Integer.parseInt(pinNumber);
                    DebitCard debitCard = new DebitCard(card, issuerBank, bankAccount, balance, clientName, pin);
                    bankCards.add(debitCard);
                    JOptionPane.showMessageDialog(null, "Debit Card added successfully");
                    clear();
                }
            }
            catch(Exception E){
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
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.CENTER;
        panel.setLayout(gbl);

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
        panel.add(balanceAmountLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        panel.add(balaceAmTF, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(cardIdLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        panel.add(cardIdTF, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        panel.add(bankAccLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 3;
        panel.add(bankAccTF, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        panel.add(issuerBankLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 4;
        panel.add(issuerBankTF, gbc);

        gbc.gridx = 0;
        gbc.gridy = 5;
        panel.add(clientNameLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 5;
        panel.add(clientNameTF, gbc);

        gbc.gridx = 0;
        gbc.gridy = 6;
        panel.add(pinNoLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 6;
        panel.add(pinNoTF, gbc);

        gbc.gridx = 0;
        gbc.gridy = 7;
        panel.add(clearButton, gbc);


        gbc.gridx = 1;
        gbc.gridy = 7;
        panel.add(addButton, gbc);

        gbc.gridx = 2;
        gbc.gridy = 7;
        panel.add(displayButton, gbc);

        add(panel);
    }

    public void clear() {
        balaceAmTF.setText("");
        cardIdTF.setText("");
        bankAccTF.setText("");
        issuerBankTF.setText("");
        clientNameTF.setText("");
        pinNoTF.setText("");
    }
}
