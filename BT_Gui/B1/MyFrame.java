package B1;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MyFrame extends JFrame implements ActionListener {
    private JPanel p = new JPanel();
    private JButton ok = new JButton("Choose color");

    public MyFrame(String title) throws HeadlessException {
        super(title);
        setSize(400, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        add(p, BorderLayout.CENTER);
        add(ok, BorderLayout.SOUTH);;
        ok.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Color init = p.getBackground();
        Color choosen = JColorChooser.showDialog(null, "Selected", init);
        if(choosen != null)
            p.setBackground(choosen);
    }
}