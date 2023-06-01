package coursework2.views;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

import coursework2.BankCard;
import coursework2.CreditCard;
import coursework2.components.*;

public class CancelCredit extends JFrame {
    CustomLabel titleLabel, cardLabel;
    CustomButton submitButton, clearButton, displayButton;
    CustomTextField cardTextfield;
    public CancelCredit(ArrayList<BankCard> bankCards){
        super("Cancel Credit Card");
        setSize(700, 700);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);

        JPanel panel = new JPanel();

        titleLabel = new CustomLabel("Cancel Credit Card");
        cardLabel = new CustomLabel("Card Id");

        cardTextfield = new CustomTextField("");

        submitButton = new CustomButton("Submit");
        clearButton = new CustomButton("Clear");
        displayButton = new CustomButton("Display");

        submitButton.addActionListener(e -> {
            try {
                String cardId = cardTextfield.getText();

                if (cardId.equals("")) {
                    JOptionPane.showMessageDialog(null, "Please fill the field");
                } else {
                    int card = Integer.parseInt(cardId);
//                    checking for card
                    boolean foundCard = false;
                    CreditCard creditCard = null;
                    for (BankCard bankCard : bankCards) {
                        if (bankCard instanceof CreditCard) {
                            creditCard = (CreditCard) bankCard;
                            if (creditCard.getCardId() == card) {
                                foundCard = true;
                                break;
                            }
                        }
                    }
//                    when card is found it calls the method to perform necessary actions
                    if(foundCard){
                        cancelCreditCard(creditCard);
                        JOptionPane.showMessageDialog(null,"Credit Card successfully cancelled");
                        clear();
                    }else{
                        JOptionPane.showMessageDialog(null,"Card not found.");
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
            new CreditDisplay(bankCards);
        });

        GridBagLayout layout = new GridBagLayout();
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.CENTER;
        panel.setLayout(layout);

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.CENTER;
        panel.add(titleLabel, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        panel.add(cardLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        panel.add(cardTextfield, gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        panel.add(submitButton, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        panel.add(clearButton, gbc);

        gbc.gridx = 2;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        panel.add(displayButton, gbc);

        add(panel);
    }

//    method to cancel Credit Card and calls the method in CreditCard class
    public void cancelCreditCard(CreditCard creditCard){

        creditCard.cancelCreditCard();
    }
    public void clear(){

        cardTextfield.setText("");
    }

}
