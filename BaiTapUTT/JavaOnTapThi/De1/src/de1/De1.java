/*
    Câu 1:
        a. Hãy định nghĩa class Person với các thuộc tính. Họ Tên, ngày sinh, địa chỉ, giới tính, và các phương thức
        khởi tạo, hiển thị thông tin.
        b. Định nghĩa class Student kế thừa từ Person, có thêm các thuộc tính: mã sinh viên, email, điểm tổng kết, 
        và các phương thức khởi tạo, hiển thị thông tin.

    Câu 2:
        a. Thiết kế các phương thức cho phép nhập vào thông tin sinh viên như định nghĩa ở trên.
        b. Khi người dùng Thêm sinh viên thì chương trình khởi tạo đối tượng sinh viên với các giá trị thuộc tính
        lấy từ bàn phím người dùng, nhập và hiển thị thông tin lên màn hình console.
        c. Khi người dùng chọn chức năng Lưu dữ liệu thì ghi toàn bộ thông tin vào file sinhvien.dat, sinh viên tự
        bắt lỗi đầu vào và bổ sung menu chức năng nếu cần thiết.

    Cấu 3:
        Hãy cho biết kết quả và lý do của đoạn chương trình sau:
        
            class Msg {
                public Msg() {
                    System.out.println("Hello");
                }
                public void sayGoodbye() {
                    System.out.println("Goodbye");
                }
            }
            class TestMsg extends Msg {
                public TestMsg() {
                    super();
                    System.out.println("Hello Java");
                }
                public void sayGoodbye() {
                    System.out.println("Goodbye Java");
                }
            }
            public class Demo {
                public static void main(String args[]) {
                    Msg m1 = new Msg();
                    Msg m2 = new TestMsg();
                    m1.sayGoodbye();
                    m2.sayGoodbye();
                }
            }
        
                
*/

package de1;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author hoangtien2k3
 */

// phần của bài 2
public class De1 {
    static List<Student> danhSachSinhVien = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean tiepTuc = true;
        while (tiepTuc) {
            System.out.println("\n\n");
            System.out.println("+---------------------------------------+");
            System.out.println("|                 Menu                  |");
            System.out.println("|---------------------------------------|");
            System.out.println("|   1.   Thêm sinh viên                 |");
            System.out.println("|   2.   Hiển thị danh sách sinh viên   |"); 
            System.out.println("|   3.   Lưu dữ liệu                    |");
            System.out.println("|   4.   Thoát                          |");
            System.out.println("+---------------------------------------+");

            System.out.print("\t=> Lựa chọn: ");
            int luaChon = scanner.nextInt();
            scanner.nextLine();

            switch (luaChon) {
                case 1:
                    themSinhVien(scanner);
                    break;
                case 2:
                    hienThiDanhSachSinhVien();
                    break;
                case 3:
                    luuDanhSachSinhVien();
                    break;
                case 4:
                    tiepTuc = false;
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ");
                    break;
            }
        }
    }

    // BÀI 2: ý a
    private static void themSinhVien(Scanner scanner) {
        System.out.println("\n");
        System.out.println("+--------Thêm Thông Tin Sinh Viên-------+");
        System.out.print("\t+ Họ tên: ");
        String hoTen = scanner.nextLine();

        System.out.print("\t+ Ngày sinh: ");
        String ngaySinh = scanner.nextLine();

        System.out.print("\t+ Địa chỉ: ");
        String diaChi = scanner.nextLine();

        System.out.print("\t+ Giới tính: ");
        String gioiTinh = scanner.nextLine();

        System.out.print("\t+ Mã sinh viên: ");
        String maSinhVien = scanner.nextLine();

        System.out.print("\t+ Email: ");
        String email = scanner.nextLine();

        System.out.print("\t+ Điểm tổng kết: ");
        float diemTongKet = scanner.nextFloat();
        scanner.nextLine();

        Student sinhVien = new Student(hoTen, ngaySinh, diaChi, gioiTinh, maSinhVien, email, diemTongKet);
        danhSachSinhVien.add(sinhVien);

        System.out.println("+------Đã thêm sinh viên danh sách------+");
    }

    // BÀI 2: ý b
    private static void hienThiDanhSachSinhVien() {
        System.out.println("\n\n");
        System.out.println("\t\t\t\t\t\t------> Hiển Thị Danh Sách Sinh Viên <-----");
        if (danhSachSinhVien.isEmpty()) {
            System.out.println("Chưa có sinh viên nào trong danh sách");
        } else {
            for (Student sinhVien : danhSachSinhVien) {
                sinhVien.hienThiThongTin();
            }
        }
    }

    // BÀI 2: ý c
    private static void luuDanhSachSinhVien() {
        try (FileWriter writer = new FileWriter("sinhvien.dat", true)){
            for(Student student : danhSachSinhVien) {
                String line = student.getHoTen() + ", " +
                        student.getNgaySinh() +  ", " +
                        student.getDiaChi() + ", " +
                        student.getGioiTinh() + ", " +
                        student.getMaSinhVien() + ", " +
                        student.getEmail() + ", " +
                        student.getDiemTongKet();
                
                writer.write(line + System.lineSeparator());
            }
            System.out.println("\n");
            System.out.println("+-----Đã Lưu SV vào File Thành Công-----+");
        } catch (IOException e) {
            System.out.println("Lưu dữ liệu thất bại");
        }
    }
}
