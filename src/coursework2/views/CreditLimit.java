package coursework2.views;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

import coursework2.BankCard;
import coursework2.CreditCard;
import coursework2.components.*;

public class CreditLimit extends JFrame {
    CustomButton setCreditButton, clearButton, displayButton;
    CustomLabel  setCreditLimitLabel, cardIdLabel, newCreditLimitLabel, gracePeriodLabel;
    CustomTextField cardIdTF, creditLimitTF, gracePeriodTF;

    public CreditLimit(ArrayList<BankCard> bankCards){
        super("Set Credit Limit");
        setSize(700, 700);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);

        JPanel panel = new JPanel();

        setCreditLimitLabel = new CustomLabel("Set Credit Limit");
        cardIdLabel = new CustomLabel("Card Id");
        newCreditLimitLabel = new CustomLabel("New Credit Limit");
        gracePeriodLabel = new CustomLabel("New Grace Period");

        cardIdTF = new CustomTextField("");
        creditLimitTF = new CustomTextField("");
        gracePeriodTF = new CustomTextField("");

        setCreditButton = new CustomButton("Set");
        clearButton = new CustomButton("Clear");
        displayButton = new CustomButton("Display");

        setCreditButton.addActionListener(e -> {
            try {
                String cardId = cardIdTF.getText();
                String creditLimit = creditLimitTF.getText();
                String gracePeriod = gracePeriodTF.getText();
                if (cardId.equals("") || creditLimit.equals("") || gracePeriod.equals("")) {
                    JOptionPane.showMessageDialog(null, "Please fill all the fields");
                } else {
                    int card = Integer.parseInt(cardId);
                    int credit = Integer.parseInt(creditLimit);
                    int grace = Integer.parseInt(gracePeriod);
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
//                    when card is found calls the method to set CreditCard
                    if (foundCard) {
                        setCreditLimit(creditCard, credit, grace);
                        JOptionPane.showMessageDialog(null, "Successfully Set Credit Limit");
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
            new CreditDisplay(bankCards);
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
        panel.add(setCreditLimitLabel, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        panel.add(cardIdLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        panel.add(cardIdTF, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(newCreditLimitLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        panel.add(creditLimitTF, gbc);


        gbc.gridx = 0;
        gbc.gridy = 3;
        panel.add(gracePeriodLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 3;
        panel.add(gracePeriodTF, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        panel.add(clearButton, gbc);

        gbc.gridx = 1;
        gbc.gridy = 4;
        panel.add(setCreditButton, gbc);

        gbc.gridx = 2;
        gbc.gridy = 4;
        panel.add(displayButton, gbc);

        add(panel);
    }

//    method to Set creditCard and calls the method in CreditCard Class
    public void setCreditLimit(CreditCard creditCard, int credit, int grace){
        if(credit <= 2.5*creditCard.getBalanceAmount()){
           creditCard.creditLimit(credit, grace);
        }
    }
    public void clear(){
        cardIdTF.setText("");
        creditLimitTF.setText("");
        gracePeriodTF.setText("");
    }
}
