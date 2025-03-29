package org.example;
import java.util.Scanner;

public class Bai6 {
    public static void main(String[] args){
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Nhập nhiệt độ C: ");
            Double c = scanner.nextDouble();

            double f = c * 9 / 5;
            System.out.print("Nhiệt độ F là: " + f + " độ F");

            scanner.close();
        }
        catch (Exception e) {
        System.out.println("Không được nhập giá trị khác số thực...");
        }
    }
}
