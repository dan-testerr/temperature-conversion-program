package Temperature_Conversion_Modification_2613;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class convert extends JFrame implements ActionListener
{
    private final JTextField jTextField;
    private final JLabel instruct;
    private final JLabel temps;
    private final JRadioButton FButton;
    private final JRadioButton CButton;
    private final JRadioButton KButton;
    private ButtonGroup radioGroup;
    
    // constructor to add jtextfield, jbutton, and jlabel to jframe
    public convert()
    {
        super("fahrenheit to celsius");
        setLayout(new FlowLayout());

        jTextField = new JTextField("", 10);
        add(jTextField);

        JButton button = new JButton("convert");
        button.addActionListener(this);
        add(button);
        
        instruct = new JLabel("enter value of selected temperature, then click 'convert'");
        temps = new JLabel("??? F°  =  ??? C°  =  ??? K°");
        add(instruct);
        // create radio buttons
        FButton = new JRadioButton("fahrenheit", true);
        CButton = new JRadioButton("celsius", false);
        KButton = new JRadioButton("kelvin", false);
        add(FButton);
        add(CButton);
        add(KButton);
        add(temps);
        
        // create logical relationship between JRadioButtons
        radioGroup = new ButtonGroup();
        radioGroup.add(FButton);
        radioGroup.add(CButton);
        radioGroup.add(KButton);        
    }
    
    @Override
    public void actionPerformed(ActionEvent event)
    {
        if(FButton.isSelected())
        {
            try
            {
                double fahren = Double.parseDouble(jTextField.getText());
                double celsius = ((5.0 / 9.0) * (fahren - 32));
                double kelvin = celsius + 273.15;

                temps.setText(String.format("%.1f F°  =  %.1f C°  =  %.1f K°", fahren, celsius, kelvin));
            } 
            catch (NumberFormatException e)
            {
                temps.setText("that's not a number, try again");
            }
        }
        if(CButton.isSelected())
        {
            try
            {
                double celsius = Double.parseDouble(jTextField.getText());
                double fahren = (celsius * (9.0 / 5.0) + 32);
                double kelvin = celsius + 273.15;

                temps.setText(String.format("%.1f F°  =  %.1f C°  =  %.1f K°", fahren, celsius, kelvin));
            } 
            catch (NumberFormatException e)
            {
                temps.setText("that's not a number, try again");
            }
        }
        if(KButton.isSelected())
        {
            try
            {
                double kelvin = Double.parseDouble(jTextField.getText());
                double celsius = kelvin - 273.15;
                double fahren = (celsius * (9.0 / 5.0) + 32);

                temps.setText(String.format("%.1f F°  =  %.1f C°  =  %.1f K°", fahren, celsius, kelvin));
            } 
            catch (NumberFormatException e)
            {
                temps.setText("that's not a number, try again");
            }
        }
    }
}