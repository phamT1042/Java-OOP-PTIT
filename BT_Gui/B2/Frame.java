/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package B2;

/**
 *
 * @author admin
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Frame extends JFrame implements ActionListener
{
    private JPanel tools;
    private JButton OK;
    private JButton color;
    private JComboBox<String> type;
    private JComboBox<String> geometry;
    private String selectedType;
    private Color selectedColor;
    private int scale = 1;

    public Frame() throws HeadlessException
    {
        super("Drawing");

        tools = new JPanel();
        color = new JButton("Choose colour");
        color.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                Color choosen = JColorChooser.showDialog(null, "Selected", Color.RED);
                selectedColor = choosen;
            }
        });
        type = new JComboBox<>();
        geometry = new JComboBox<>();
        OK = new JButton("OK");
        selectedColor = Color.red;
        selectedType = "Fill";

        setLayout(new BorderLayout());

        type.addItem("Fill");
        type.addItem("Not Fill");
     
        geometry.addItem("Rectangle");
        geometry.addItem("Square");
        geometry.addItem("Circle");
        geometry.addItem("Polygon");

        tools.setLayout(new FlowLayout());
        tools.add(OK);
        tools.add(geometry);
        tools.add(type);
        tools.add(color);
        add(tools, BorderLayout.SOUTH);

        OK.addActionListener(this);

        setSize(600, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == OK)
        {
            selectedType = type.getSelectedItem().toString(); 
            switch (geometry.getSelectedItem().toString())
            {
                case "Rectangle":
                    add(new Rectangle(scale, selectedType, selectedColor));
                    break;
                case "Square":
                    add(new Square(scale, selectedType, selectedColor));
                    break;
                case "Circle":
                    add(new Circle(scale, selectedType, selectedColor));
                    break;
                case "Polygon":
                    add(new Polygons(scale, selectedType, selectedColor));
                    break;
            }
            setVisible(true);
        }
    }
}
