package coursework2.components;

import javax.swing.*;

public class CustomComboBox extends JComboBox {
    public CustomComboBox(String[] data){
        super(data);
        setFont(new java.awt.Font("Arial",0,15));
        setForeground(new java.awt.Color(0,0,0));
        setBackground(new java.awt.Color(255,255,255));
        setMaximumRowCount(5);

    }
}
