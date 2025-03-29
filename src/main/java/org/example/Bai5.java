package org.example;
import java.util.Scanner;

public class Bai5 {
    public static void main(String[] args)
    {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Nhập chiều dài: ");
            double chieuDai = scanner.nextDouble();
            System.out.print("Nhập chiều rộng: ");
            double chieuRong = scanner.nextDouble();

            double dientich = chieuDai * chieuRong;
            double chuvi = (chieuDai + chieuRong) * 2;

            System.out.println("Chu vi hình chữ nhật là: " + chuvi);
            System.out.println("Diện tích hình chữ nhật là: " + dientich);

            scanner.close();
        }
        catch (Exception e) {
            System.out.println("Không được nhập giá trị khác số thực...");
        }
    }
}
