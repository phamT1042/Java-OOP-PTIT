package B7;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.text.ParseException;
import java.util.*;
import javax.swing.table.DefaultTableModel;

public class ReadFileStudent extends JFrame implements ActionListener {
    private DefaultTableModel tableModel;
    private JTable studentTable;
    private JButton loadButton;
    private JButton sortButton;
    private ArrayList<SinhVien> dsSV;
    
    public ReadFileStudent(String title) throws HeadlessException {
        super(title);
        setSize(600, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        tableModel = new DefaultTableModel();
        tableModel.addColumn("Mã sinh viên");
        tableModel.addColumn("Họ tên");
        tableModel.addColumn("Lớp");
        tableModel.addColumn("Ngày sinh");
        tableModel.addColumn("GPA");

        studentTable = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(studentTable);
        loadButton = new JButton("Đọc thông tin");
        sortButton = new JButton("Sắp xếp tăng dần theo GPA");

        loadButton.addActionListener(this);
        sortButton.addActionListener(this);

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(loadButton);
        buttonPanel.add(sortButton);

        add(scrollPane, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
    }

    private void loadStudentDataFromFile() throws NumberFormatException, ParseException {
        dsSV = new ArrayList<>();
        tableModel.setRowCount(0); // Clear the table

        JFileChooser fileChooser = new JFileChooser();
        int returnValue = fileChooser.showOpenDialog(null);

        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            try {
                Scanner sc = new Scanner(new FileReader(selectedFile));

                int n = Integer.parseInt(sc.nextLine());
                for (int i = 0; i < n; i++) {
                    SinhVien a = new SinhVien(sc.nextLine(), sc.nextLine(), sc.nextLine(), Double.parseDouble(sc.nextLine()));
                    dsSV.add(a);
                    String[] newRow = {a.getMaSV(), a.getTen(), a.getLop(), a.getNgaySinh(), String.valueOf(a.getGpa())};
                    tableModel.addRow(newRow);
                }

                sc.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void sortStudentData() {
        tableModel.setRowCount(0);
        try {
            if (dsSV != null) {
                if (dsSV.isEmpty()) throw new Exception();
                else Collections.sort(dsSV);
            }
            else throw new Exception();
        }
        catch (Exception test) {
            JOptionPane.showMessageDialog(null, "Chưa có sinh viên để sắp xếp", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }

        for (SinhVien a : dsSV) 
            tableModel.addRow(new String[]{a.getMaSV(), a.getTen(), a.getLop(), a.getNgaySinh(), String.valueOf(a.getGpa())});
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == loadButton) {
            try {
                loadStudentDataFromFile();
            } catch (Exception x) {
                x.printStackTrace();
            }
        }
        else sortStudentData();
    }
}
