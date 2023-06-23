package BaiTapUTT.BaiTapGhiFileVoiLuongByte.Bai1;

import java.io.BufferedReader;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;


public class Main {

    public static void main(String[] args) {
        ArrayList<NhanVien> employees = new ArrayList<>();


        // Nhập dữ liệu từ bàn phím và ghi vào file nhanvien.dat
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("nhanvien.dat"))) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

            System.out.print("Enter the number of employees: ");
            int numberOfEmployees = Integer.parseInt(reader.readLine());

            for (int i = 0; i < numberOfEmployees; i++) {
                System.out.println("Enter employee #" + (i + 1) + " information:");

                System.out.print("Full Name: ");
                String fullName = reader.readLine();

                System.out.print("Birth Date: ");
                String birthDate = reader.readLine();

                System.out.print("Address: ");
                String address = reader.readLine();

                System.out.print("Gender: ");
                String gender = reader.readLine();

                System.out.print("Department: ");
                String department = reader.readLine();

                System.out.print("Salary Factor: ");
                double salaryFactor = Double.parseDouble(reader.readLine());

                System.out.print("Seniority: ");
                int seniority = Integer.parseInt(reader.readLine());

                System.out.print("Base Salary: ");
                double baseSalary = Double.parseDouble(reader.readLine());

                NhanVien employee = new NhanVien(fullName, birthDate, address, gender,
                        department, salaryFactor, seniority, baseSalary);

                employees.add(employee);
                oos.writeObject(employee);
            }

            System.out.println("Data has been saved to nhanvien.dat.");
        } catch (IOException e) {
        }


        // Đọc dữ liệu từ file nhanvien.dat và hiển thị trên console
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("nhanvien.dat"))) {
            System.out.println("Employees:");

            while (true) {
                try {
                    NhanVien employee = (NhanVien) ois.readObject();
                    employees.add(employee);
                    employee.displayInfo();
                } catch (EOFException e) {
                    break; // Đã đọc hết file, thoát khỏi vòng lặp
                }
            }
        } catch (IOException | ClassNotFoundException e) {
        }


        // Ghi đối tượng sang file nhanvien.obj
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("nhanvien.obj"))) {
            for (NhanVien employee : employees) {
                oos.writeObject(employee);
            }
            System.out.println("Data has been saved to nhanvien.obj.");
        } catch (IOException e) {
        }


        System.out.print("Nhập vào file vần copy: ");
        // Sao chép nội dung sang file khác (tên file nhập từ bàn phím)
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             FileInputStream fis = new FileInputStream("nhanvien.obj");
             FileOutputStream fos = new FileOutputStream(reader.readLine())) {
            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = fis.read(buffer)) != -1) {
                fos.write(buffer, 0, bytesRead);
            }
            System.out.println("Data has been copied to the specified file.");
        } catch (IOException e) {
        }
    }

}

