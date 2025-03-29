package org.example;
import java.util.Scanner;

public class Bai7 {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Nhập số nguyên: ");

            int songuyen = scanner.nextInt();
            while (songuyen < 1) {
                System.out.print("Vui lòng nhập số nguyên >= 1: ");
                songuyen = scanner.nextInt();
            }
            int sodu = songuyen % 2;

            if (sodu == 0) {
                System.out.print("Số " + songuyen + " là số chẵn");
            } else {
                System.out.print("Số " + songuyen + " là số lẻ");
            }

            scanner.close();
        }
        catch (Exception e) {
            System.out.println("Không được nhập giá trị khác số...");
        }
    }
}
