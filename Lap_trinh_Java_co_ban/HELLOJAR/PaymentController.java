import java.util.ArrayList;
import java.util.Scanner;
import vn.edu.ptit.Invoice;
import vn.edu.ptit.Rule;
import vn.edu.ptit.Student;
import vn.edu.ptit.Subject;

public class PaymentController {
    private Invoice invoice;

    public PaymentController() {
        Scanner sc = new Scanner(System.in);
        
        Student student = new Student(sc.nextLine(), sc.nextLine());
        
        ArrayList<Subject> alSubject = new ArrayList<>();
        int credits = 0;
        int n = Integer.parseInt(sc.nextLine());
        while (n-- > 0) {
            String code = sc.nextLine();
            String name = sc.nextLine();
            int credit = Integer.parseInt(sc.nextLine());
            Subject subject = new Subject(name, code, credit);
            credits += subject.getCredit();
            alSubject.add(subject);            
        }
        
        Rule rule = new Rule(sc.nextLine(), sc.nextLine(), Double.parseDouble(sc.nextLine()));
        
        invoice = new Invoice(rule);
        invoice.setAlSubject(alSubject);
        invoice.setSt(student);
        invoice.setAmount(credits * rule.getCreditPrice());
        
        sc.close();
    }

    public Invoice getInvoice() {
        return invoice;
    }
}
