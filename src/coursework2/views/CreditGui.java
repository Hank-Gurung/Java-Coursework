package coursework2.views;

import coursework2.BankCard;
import coursework2.components.CustomButton;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class CreditGui extends JFrame {
    CustomButton addCreditButton,setCreditLimitButton,cancelCreditButton,displayButton;
    public CreditGui(ArrayList<BankCard> bankCards) {
        super("Credit Card");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(700, 700);
        setLocationRelativeTo(null);
        setVisible(true);

        addCreditButton = new CustomButton("Add Credit Card");
        setCreditLimitButton = new CustomButton("Set Credit Limit");
        cancelCreditButton = new CustomButton("Cancel Credit Card");
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
        gbc.insets = new Insets(10, 10, 10, 10);
        panel.add(addCreditButton, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(setCreditLimitButton, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(cancelCreditButton, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        panel.add(displayButton, gbc);

        add(panel);

        addCreditButton.addActionListener(e -> {
            new AddCredit(bankCards);
        });

        setCreditLimitButton.addActionListener(e -> {
            new CreditLimit(bankCards);
        });

        cancelCreditButton.addActionListener(e -> {
           new CancelCredit(bankCards);
        });

        displayButton.addActionListener(e -> {
            new CreditDisplay(bankCards);
        });
    }
}
