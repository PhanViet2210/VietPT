package org.example;
import java.util.Scanner;

public class Bai10 {
    public static void main(String[] args) {
        while(true) {
            try {
                Scanner scanner = new Scanner(System.in);
                System.out.print("Nhập số giờ làm việc trong tuần của nhân viên: ");
                Double A = scanner.nextDouble();
                System.out.print("Nhập mức lương của nhân viên (VNĐ/giờ): ");
                Double X = scanner.nextDouble();

                while (A < 0 || X <= 0) {
                    System.out.println("======================================================================");
                    System.out.println("Số giờ làm việc phải >= 0 và mức lương theo giờ của nhân viên phải > 0");
                    System.out.print("Nhập số giờ làm việc trong tuần của nhân viên: ");
                    A = scanner.nextDouble();
                    System.out.print("Nhập mức lương của nhân viên (VNĐ/giờ): ");
                    X = scanner.nextDouble();
                }

                Double Sum = 0.0;

                if (A > 40) {
                    Sum = 40 * X + (A - 40) * 1.5 * X;
                } else {
                    Sum = A * X;
                }

                System.out.println("Tổng lương trong tuần của nhân viên là: " + Sum);
                scanner.close();
            } catch (Exception e) {
                System.out.println("Không được nhập giá trị khác số...");
            }
        }
    }
}
