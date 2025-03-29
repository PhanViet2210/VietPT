package org.example;
import java.util.Scanner; // Import thư viện để nhập dữ liệu từ bàn phím

public class Bai3 {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Nhập một số thực: ");

            double soThuc = scanner.nextDouble();
            int soNguyen = (int) soThuc; // Ép kiểu từ double sang int

            System.out.println("Số thực ban đầu: " + soThuc);
            System.out.println("Số nguyên sau khi chuyển đổi: " + soNguyen);

            scanner.close();
        }
        catch (Exception e) {
            System.out.println("Không được nhập giá trị khác số thực...");
        }
    }
}