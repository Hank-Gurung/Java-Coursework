package coursework2.views;

import coursework2.BankCard;
import coursework2.components.CustomButton;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class DebitGui extends JFrame {
    CustomButton addDebitButton,withdrawButton,displayButton;
    public DebitGui(ArrayList<BankCard> bankCards){
        super("Debit Card");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(700,700);
        setLocationRelativeTo(null);
        setVisible(true);

        addDebitButton = new CustomButton("Add Debit Card");
        withdrawButton = new CustomButton("Withdraw from Debit Card");
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
        panel.add(addDebitButton, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(withdrawButton, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(displayButton, gbc);


//
        add(panel);

        addDebitButton.addActionListener(e -> {
            new AddDebit(bankCards);
        });

        withdrawButton.addActionListener(e -> {
            new WithdrawDebit(bankCards);
        });

        displayButton.addActionListener(e -> {
            new DebitDisplay(bankCards);
        });


    }
}
