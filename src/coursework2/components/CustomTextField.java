package coursework2.components;

import javax.swing.*;

public class CustomTextField extends JTextField {
    public CustomTextField(String text){
        super(text);
        setColumns(30);
        setMargin(new java.awt.Insets(10, 10, 10, 10));

    }
}
