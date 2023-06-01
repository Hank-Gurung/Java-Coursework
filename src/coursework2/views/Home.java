package coursework2.views;

import coursework2.BankCard;
import coursework2.components.CustomButton;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Home extends JFrame{
    CustomButton debitCardButton,creditCardButton,displayButton;
    ArrayList<BankCard> bankCards = new ArrayList<>();
    public Home(){
        setTitle("Bank Form");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(700,700);
        setVisible(true);
        setLocationRelativeTo(null);
        debitCardButton  = new CustomButton("Debit Card");
        creditCardButton  = new CustomButton("Credit Card");
        displayButton = new CustomButton("Display");
        JPanel panel = new JPanel();
        GridBagLayout layout = new GridBagLayout();
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.CENTER;

        panel.setLayout(layout);

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(10,10,10,10);
        panel.add(debitCardButton, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(creditCardButton, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(displayButton, gbc);

        add(panel);

        debitCardButton.addActionListener(e -> {
            new DebitGui(bankCards);
        });

        creditCardButton.addActionListener(e -> {
            new CreditGui(bankCards);
        });

        displayButton.addActionListener(e -> {
            new Display(bankCards);
        });

    }
}
