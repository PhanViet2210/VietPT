package org.example;
import java.util.Scanner;

public class Bai8 {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Nhập số tự nhiên N: ");

            int N = scanner.nextInt();
            int sum = 0;

            while (N < 1) {
                System.out.print("Vui lòng nhập số nguyên N >= 1: ");
                N = scanner.nextInt();
            }

            for (int i = 1; i <= N; i++) {
                sum = i + sum;
            }

            System.out.println("Tổng từ 1 đến N là: " + sum);
            scanner.close();
        }
        catch (Exception e) {
            System.out.println("Không được nhập giá trị khác số...");
        }
    }
}
