public class Note {
    public static void main(String[] args) {
        //Giao 2 set: retainAll() | Chỉ có trong set1: set1.removeAll(set2) | Hợp 2 set: addAll()
        //count giu nguyen thu tu: LinkedHashMap - replace() - get() - put()
        //sort array reverse: thêm Collections.reverseOrder() và dùng kiểu dữ liệu Integer/Long/...
        //Dùng LinkedList thay cho queue: push() - removeLast()
        //change element in arraylist: set()

        //Tách từ nhiều kí tự khác nhau: split("[.,?!]")
        //Tách từ nhiều dấu cách: split("\\s+") | Bỏ cách 2 đầu: trim()
        //Format mã: String.format("KH%02d", KhachHang.STT);
        //làm tròn 1 số phần thập phân (sum là double): Math.round((sum / n) * 10) / 10.0
        //String -> Date: new SimpleDateFormat("dd/MM/yyyy").parse(ngaySinh)
        //Date -> String: new SimpleDateFormat("dd/MM/yyyy").format(ngaySinh)
        //Khoảng cách 2 date: TimeUnit.MILLISECONDS.toDays(end.getTime() - start.getTime());
        
        //Đọc file nhị phân: DataInputStream input = new DataInputStream(new FileInputStream("DATA.in"));
        //Đọc Object trong file nhị phân (thường là ArrayList):
        // ObjectInputStream inp = new ObjectInputStream(new FileInputStream("DATA.in"));
        // ArrayList<Integer> a = (ArrayList<Integer>) inp.readObject();

        //VD viết lớp kiểu Generic:
        // class Pair<T1, T2> {
        //     private T1 value_T1;
        //     private T2 value_T2; }
    }
}
