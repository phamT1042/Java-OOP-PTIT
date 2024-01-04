/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package B5;

/**
 *
 * @author admin
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;


public class ImageGet extends JFrame implements ActionListener{
    JPanel display = new JPanel();
    JPanel bnt = new JPanel();
    JButton op = new JButton("Open");
    JButton cs = new JButton("Change size");
    JLabel w = new JLabel("Width");
    JLabel h = new JLabel("Height");
    JTextField width = new JTextField(6);
    JTextField height = new JTextField(6);


    public ImageGet(String title) throws HeadlessException {
        super(title);
        setLayout(new BorderLayout());
        display.setLayout(new FlowLayout());
        add(display, BorderLayout.CENTER);
        add(bnt, BorderLayout.SOUTH);
        bnt.setLayout(new GridLayout(1,4));
        bnt.add(op);
        bnt.add(cs);
        bnt.add(w);
        bnt.add(width);
        bnt.add(h);
        bnt.add(height);
        op.addActionListener(this);
        cs.addActionListener(this);
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == op){
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.showOpenDialog(null);
            try {
                BufferedImage pic = ImageIO.read(new File(fileChooser.getSelectedFile().getAbsolutePath()));
                display.add(new Pic(pic));
                setVisible(true);
            }
            catch (IOException ex){
      
            }
        } else if (e.getSource() == cs) {
            setSize(Integer.parseInt(width.getText()), Integer.parseInt(height.getText()));
            setLocationRelativeTo(null);
            setVisible(true);
        }
    }
    
}
