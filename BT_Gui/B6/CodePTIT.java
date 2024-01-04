import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class CodePTIT extends JFrame {
    private JPanel hinhChuNhat;
    private JPanel ptBacNhat;
    private JPanel soNguyenTo;
    private JPanel tongGiaiThua;
    private JPanel hinhVuong;

    public CodePTIT(String title) throws HeadlessException {
        super(title);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(700, 400);
        setLocationRelativeTo(null);

        JTabbedPane allTab = new JTabbedPane();

        hinhChuNhat = panelHCN();
        ptBacNhat = panelPTbacNhat();
        soNguyenTo = panelSoNguyenTo();
        tongGiaiThua = panelTongGT();
        hinhVuong = panelHinhVuong();

        allTab.addTab("J01001", hinhChuNhat);
        allTab.addTab("J01003", ptBacNhat);
        allTab.addTab("J01004", soNguyenTo);
        allTab.addTab("J01009", tongGiaiThua);
        allTab.addTab("J01025", hinhVuong);

        add(allTab);
    }

    private static JPanel panelHCN() {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        JPanel inp_outp = new JPanel();
        inp_outp.setLayout(new GridLayout(4, 2));

        JLabel lengthLabel = new JLabel("Chiều dài:");
        JTextField lengthField = new JTextField();
        lengthLabel.setHorizontalAlignment(SwingConstants.CENTER);

        JLabel widthLabel = new JLabel("Chiều rộng:");
        JTextField widthField = new JTextField();
        widthLabel.setHorizontalAlignment(SwingConstants.CENTER);

        JLabel resultPerimeter = new JLabel("Chu vi:");
        resultPerimeter.setHorizontalAlignment(SwingConstants.CENTER);
        JLabel perimeterValue = new JLabel();
        JLabel resultArea = new JLabel("Diện tích:");
        resultArea.setHorizontalAlignment(SwingConstants.CENTER);
        JLabel areaValue = new JLabel();

        inp_outp.add(lengthLabel);
        inp_outp.add(lengthField);
        inp_outp.add(widthLabel);
        inp_outp.add(widthField);
        inp_outp.add(resultPerimeter);
        inp_outp.add(perimeterValue);
        inp_outp.add(resultArea);
        inp_outp.add(areaValue);

        JButton calculateButton = new JButton("Tính");

        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int length = Integer.parseInt(lengthField.getText().trim());
                    int width = Integer.parseInt(widthField.getText().trim());
                    if (length <= 0 || width <= 0) throw new NumberFormatException();

                    int perimeter = 2 * (length + width);
                    int area = length * width;
                    perimeterValue.setText(String.valueOf(perimeter));
                    areaValue.setText(String.valueOf(area));
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Dữ liệu nhập vào chỉ là các số nguyên dương", "Lỗi", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        JLabel des = new JLabel("Chương trình tính chu vi và diện tích hình chữ nhật");
        des.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(des, BorderLayout.NORTH);
        panel.add(inp_outp, BorderLayout.CENTER);
        panel.add(calculateButton, BorderLayout.SOUTH);

        return panel;
    }

    private static JPanel panelPTbacNhat() {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        JPanel inp_outp = new JPanel();
        inp_outp.setLayout(new GridLayout(3, 2));

        JLabel aLabel = new JLabel("Hệ số a:");
        aLabel.setHorizontalAlignment(SwingConstants.CENTER);
        JTextField aField = new JTextField();

        JLabel bLabel = new JLabel("Hệ số b:");
        bLabel.setHorizontalAlignment(SwingConstants.CENTER);
        JTextField bField = new JTextField();

        JLabel resLabel = new JLabel("Kết quả:");
        resLabel.setHorizontalAlignment(SwingConstants.CENTER);
        JLabel resValue = new JLabel();

        inp_outp.add(aLabel);
        inp_outp.add(aField);
        inp_outp.add(bLabel);
        inp_outp.add(bField);
        inp_outp.add(resLabel);
        inp_outp.add(resValue);

        JButton solveButton = new JButton("Giải phương trình");      
        solveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double a = Double.parseDouble(aField.getText().trim());
                    double b = Double.parseDouble(bField.getText().trim());

                    if (a == 0) {
                        if (b == 0) resValue.setText("Phương trình có vô số nghiệm!"); 
                        else resValue.setText("Phương trình vô nghiệm!");
                    }
                    else 
                        resValue.setText("Phương trình có nghiệm x: " + String.format("%.2f", -1.0f * b / a)); 
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Dữ liệu nhập vào chỉ là các số thực", "Lỗi", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        JLabel des = new JLabel("Chương trình giải phương trình bậc nhất dạng ax + b = 0");
        des.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(des, BorderLayout.NORTH);
        panel.add(inp_outp, BorderLayout.CENTER);
        panel.add(solveButton, BorderLayout.SOUTH);

        return panel;
    }

    private static JPanel panelSoNguyenTo() {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        JPanel inp_outp = new JPanel();
        inp_outp.setLayout(new GridLayout(2, 2));

        JLabel nLabel = new JLabel("Nhập số nguyên n:");
        JTextField nField = new JTextField();
        nLabel.setHorizontalAlignment(SwingConstants.CENTER);

        JLabel resLabel = new JLabel("Kết quả:");
        resLabel.setHorizontalAlignment(SwingConstants.CENTER);
        JLabel resValue = new JLabel();

        inp_outp.add(nLabel);
        inp_outp.add(nField);
        inp_outp.add(resLabel);
        inp_outp.add(resValue);
        
        JButton calculateButton = new JButton("Kiểm tra");

        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int n = Integer.parseInt(nField.getText().trim());
                    if (n <= 0) throw new NumberFormatException();
                    
                    int flag = 1;
                    if (n < 2) flag = 0;
                    else {
                        for (int i = 2; i <= Math.sqrt(n); i++)
                            if (n % i == 0) {
                                flag = 0; break;
                            }
                    }
                    
                    if (flag == 1) resValue.setText("Số bạn vừa nhập là số nguyên tố");
                    else resValue.setText("Số bạn vừa nhập KHÔNG PHẢI là số nguyên tố");
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Dữ liệu nhập vào chỉ là số nguyên dương", "Lỗi", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        JLabel des = new JLabel("Chương trình kiểm tra số nguyên tố");
        des.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(des, BorderLayout.NORTH);
        panel.add(inp_outp, BorderLayout.CENTER);
        panel.add(calculateButton, BorderLayout.SOUTH);

        return panel;
    }

    private static JPanel panelTongGT() {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        JPanel inp_outp = new JPanel();
        inp_outp.setLayout(new GridLayout(2, 2));

        JLabel nLabel = new JLabel("Nhập số nguyên n:");
        JTextField nField = new JTextField();
        nLabel.setHorizontalAlignment(SwingConstants.CENTER);

        JLabel resLabel = new JLabel("Kết quả:");
        resLabel.setHorizontalAlignment(SwingConstants.CENTER);
        JLabel resValue = new JLabel();

        inp_outp.add(nLabel);
        inp_outp.add(nField);
        inp_outp.add(resLabel);
        inp_outp.add(resValue);
        
        JButton calculateButton = new JButton("Tính");

        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int n = Integer.parseInt(nField.getText().trim());
                    if (n <= 0 || n > 20) throw new NumberFormatException();
                    
                    Long res = 0l;
                    for (long i = 1; i <= n; i++) {
                        long tmp = 1;
                        for (long j = 1; j <= i; j++) tmp *= j;
                        res += tmp;
                    }                    
                    
                    resValue.setText(String.valueOf(res));
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Dữ liệu nhập vào chỉ là số nguyên dương không quá 20", "Lỗi", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        JLabel des = new JLabel("Chương trình tính tổng S = 1 + 1.2 + 1.2.3 + ... + 1.2.3...n");
        des.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(des, BorderLayout.NORTH);
        panel.add(inp_outp, BorderLayout.CENTER);
        panel.add(calculateButton, BorderLayout.SOUTH);

        return panel;
    }

    private static JPanel panelHinhVuong() {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        JPanel inp_outp = new JPanel();
        inp_outp.setLayout(new GridLayout(5, 2));

        JLabel p1Label = new JLabel("Toạ độ điểm trái dưới của hình chữ nhật đầu tiên:");
        JTextField p1Field = new JTextField();
        p1Label.setHorizontalAlignment(SwingConstants.CENTER);
        
        JLabel p2Label = new JLabel("Toạ độ điểm phải trên của hình chữ nhật đầu tiên:");
        JTextField p2Field = new JTextField();
        p2Label.setHorizontalAlignment(SwingConstants.CENTER);

        JLabel p3Label = new JLabel("Toạ độ điểm trái dưới của hình chữ nhật thứ hai:");
        JTextField p3Field = new JTextField();
        p3Label.setHorizontalAlignment(SwingConstants.CENTER);

        JLabel p4Label = new JLabel("Toạ độ điểm phải trên của hình chữ nhật thứ hai:");
        JTextField p4Field = new JTextField();
        p4Label.setHorizontalAlignment(SwingConstants.CENTER);

        JLabel resLabel = new JLabel("Diện tích hình vuông nhỏ nhất phủ kín 2 hình chữ nhật trên:");
        resLabel.setHorizontalAlignment(SwingConstants.CENTER);
        JLabel resValue = new JLabel();

        inp_outp.add(p1Label);
        inp_outp.add(p1Field);
        inp_outp.add(p2Label);
        inp_outp.add(p2Field);
        inp_outp.add(p3Label);
        inp_outp.add(p3Field);
        inp_outp.add(p4Label);
        inp_outp.add(p4Field);
        inp_outp.add(resLabel);
        inp_outp.add(resValue);

        JButton calculateButton = new JButton("Tìm");
        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    ArrayList<Integer> x = new ArrayList<>(4);
                    ArrayList<Integer> y = new ArrayList<>(4);

                    String[] topLeft1 = p1Field.getText().trim().split(" ");
                    if (topLeft1.length != 2) 
                        throw new NumberFormatException("not enough data");
                    
                    x.add(Integer.parseInt(topLeft1[0]));
                    y.add(Integer.parseInt(topLeft1[1]));

                    String[] bottomRight1 = p2Field.getText().trim().split(" ");
                    if (bottomRight1.length != 2) 
                        throw new NumberFormatException("not enough data");
                    
                    x.add(Integer.parseInt(bottomRight1[0]));
                    y.add(Integer.parseInt(bottomRight1[1]));

                    String[] topLeft2 = p3Field.getText().trim().split(" ");
                    if (topLeft2.length != 2) 
                        throw new NumberFormatException("not enough data");
                    
                    x.add(Integer.parseInt(topLeft2[0]));
                    y.add(Integer.parseInt(topLeft2[1]));

                    String[] bottomRight2 = p4Field.getText().trim().split(" ");
                    if (bottomRight2.length != 2) 
                        throw new NumberFormatException("not enough data");
                    
                    x.add(Integer.parseInt(bottomRight2[0]));
                    y.add(Integer.parseInt(bottomRight2[1]));

                    if (Collections.max(x) > 1000 || Collections.min(x) < -1000 || Collections.max(y) > 1000 || Collections.min(y) < -1000) throw new NumberFormatException("more than");

                    int edge = Math.max(Collections.max(x) - Collections.min(x), Collections.max(y) - Collections.min(y));
                    resValue.setText(String.valueOf(edge * edge));                    
                } catch (Exception ex) {
                    if (ex.getMessage().equals("not enough data")) 
                        JOptionPane.showMessageDialog(null, "Dữ liệu các đỉnh nhập không đúng định dạng \"x y\"", "Lỗi", JOptionPane.ERROR_MESSAGE);               
                    else 
                        JOptionPane.showMessageDialog(null, "Dữ liệu nhập vào chỉ là các số nguyên có giá trị tuyệt đối không quá 1000", "Lỗi", JOptionPane.ERROR_MESSAGE);
                       
                }
            }
        });

        JLabel des = new JLabel("Chương trình tìm kích thước hình vuông nhỏ nhất phủ kín 2 hình chữ nhật trên mặt phẳng Oxy");
        des.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(des, BorderLayout.NORTH);
        panel.add(inp_outp, BorderLayout.CENTER);
        panel.add(calculateButton, BorderLayout.SOUTH);

        return panel;
    }

}

