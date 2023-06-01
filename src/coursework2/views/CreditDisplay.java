package coursework2.views;

import coursework2.BankCard;
import coursework2.CreditCard;

import javax.swing.*;
import java.util.ArrayList;

public class CreditDisplay extends JFrame {
    public CreditDisplay(ArrayList<BankCard> bankCards){
        super("Display Credit Cards");
        setSize(700,700);
        setLocationRelativeTo(null);
        setVisible(true);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        String[] columnName = {"Card Id", "Bank Account", "Client Name", "Issuer Bank", "Balance Amount", "Cvc Number", "Interest Rate", "Expiration Date","Credit Limit", "Grace Period", "isGranted"};

        ArrayList<CreditCard> creditCards = new ArrayList<>();
        for (BankCard bankCard : bankCards) {
            if (bankCard instanceof CreditCard) {
                creditCards.add((CreditCard) bankCard);
            }
        }
        String[][] data = new String[creditCards.size()][11];
        for(int i=0; i< creditCards.size(); i++){
            data[i][0] = String.valueOf(creditCards.get(i).getCardId());
            data[i][1] = String.valueOf(creditCards.get(i).getClientName());
            data[i][2] = String.valueOf(creditCards.get(i).getIssuerBank());
            data[i][3] = String.valueOf(creditCards.get(i).getBankAccount());
            data[i][4] = String.valueOf(creditCards.get(i).getBalanceAmount());
            data[i][5] = String.valueOf(creditCards.get(i).getCvcNumber());
            data[i][6] = String.valueOf(creditCards.get(i).getInterestRate());
            data[i][7] = String.valueOf(creditCards.get(i).getExpirationDate());
            data[i][8] = String.valueOf(creditCards.get(i).getCreditLimit());
            data[i][9] = String.valueOf(creditCards.get(i).getGracePeriod());
            data[i][10] = String.valueOf(creditCards.get(i).getIsGranted());
        }
        JTable table = new JTable(data, columnName);
        JScrollPane scrollPane = new JScrollPane(table);
        panel.add(scrollPane);
        add(panel);

    }
}
