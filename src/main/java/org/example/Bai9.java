package org.example;

public class Bai9 {
    public static void main(String[] args) {
        for (int i = 1; i <= 10; i++) {
            System.out.println("==================================");
            System.out.println("Bảng cửu chương " + i );

            for (int j = 1; j <= 10; j++) {
                System.out.println(i + " x " + j + " = " + (i * j));
            }

            System.out.println();
        }
    }
}
