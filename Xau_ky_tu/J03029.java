import java.util.ArrayList;
import java.util.Scanner;

public class J03029 {
    private static String title(String s) {
        return s.substring(0, 1).toUpperCase() + s.substring(1).toLowerCase();
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        ArrayList<String> res = new ArrayList<>();
        byte start = 1, end = 0;
        String sentence = "";
        while (sc.hasNextLine()) {
            String data[] = sc.nextLine().trim().split("\\s+");
            for (int i = 0; i < data.length; ++i) {
                String x = data[i];

                //Nếu từ là dấu ngắt câu, kết thúc câu đang nạp
                if (x.equals(".") || x.equals("?") || x.equals("!")) {
                    sentence = sentence.trim() + x;
                    res.add(sentence);
                    sentence = "";
                    start = 1;
                    continue;                         
                }

                //Kiểm tra từ có dấu hiệu kết thúc câu
                if (x.endsWith(".") || x.endsWith("?") || x.endsWith("!")) end = 1;
                
                //Kiểm tra các từ không phải từ cuối của 1 dòng
                if (i < data.length - 1) {
                    //Nếu đây là từ bắt đầu câu
                    if (start == 1) {
                        //Nếu đây cũng là từ kết thúc câu
                        if (end == 1) {
                            String tmp = title(x);
                            sentence += tmp.substring(0, tmp.length() - 1) + " ";
                            res.add(sentence);
                            sentence = "";
                            end = 0;
                        }
                        else {
                            sentence += title(x) + " ";
                            start = 0;
                        }
                    }
                    //Nếu đây không phải từ bắt đầu câu
                    else {
                        //Nếu đây là từ kết thúc câu
                        if (end == 1) {
                            sentence += x.toLowerCase().substring(0, x.length() - 1) + " ";
                            res.add(sentence);
                            sentence = "";
                            end = 0;
                            start = 1;
                        }
                        else {
                            sentence += x.toLowerCase() + " ";
                        }
                    }
                }
                //Kiểm tra từ cuối của dòng
                else {
                    if (start == 1) {
                        //Nếu đây là từ bắt đầu câu cũng có dấu hiệu kết thúc câu
                        if (end == 1) {
                            sentence += title(x);
                            res.add(sentence);
                            sentence = "";
                            end = 0;
                        }
                        //Từ hết dòng nhưng không có dấu hiệu kết thúc => thêm "."
                        else {
                            sentence += title(x) + ".";
                        }
                    }
                    else {
                        sentence += x.toLowerCase();
                        //Từ hết dòng nhưng không có dấu hiệu kết thúc => thêm "."
                        if (end == 0) sentence += ".";      
                        res.add(sentence);
                        sentence = "";
                        end = 0;  
                        start = 1;
                    }
                }
            }
            
        }
        
        for (String x : res) System.out.println(x);
        
        sc.close();
    }
    
}
