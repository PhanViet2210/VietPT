package org.example;
import java.util.Scanner;

public class Bai11 {
    public static void main(String[] args) {
        while (true){
            try {
                Scanner scanner = new Scanner(System.in);
                System.out.print("Nhập số phần tử của mảng: ");
                int n = scanner.nextInt();

                // Khởi tạo mảng với kích thước n
                int[] arr = new int[n];

                System.out.println("Nhập các phần tử của mảng:");
                for (int i = 0; i < n; i++) {
                    System.out.print("Phần tử thứ " + (i + 1) + ": ");
                    arr[i] = scanner.nextInt();
                }

                // Tìm phần tử lớn nhất
                int max = arr[0]; // Giả sử phần tử đầu tiên là lớn nhất
                for (int i = 1; i < n; i++) {
                    if (arr[i] > max) {
                        max = arr[i]; // Cập nhật giá trị lớn nhất
                    }
                }

                // In kết quả
                System.out.println("Phần tử lớn nhất trong mảng là: " + max);
                scanner.close();
            } catch (Exception e) {
                System.out.println("Số phần tử của mảng phải là số nguyên dương, các phần tử trong mảng phải là số nguyên");
            }
        }
    }
}
