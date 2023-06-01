package coursework2.components;

import javax.swing.*;
import java.awt.*;

public class CustomButton extends JButton {
    public CustomButton(String text){
        super(text);
        setFocusPainted(false);
        setFont(new Font("Arial", 0, 18));
        setForeground(new java.awt.Color(0, 0, 0));
        setBackground(new java.awt.Color(255, 255, 255));

    }
}
