package Minggu_1.Script;

import java.util.Scanner;

public class Perulangan {
    public static void main(String[] args) {
        Scanner jonathan16 = new Scanner(System.in);

        System.out.print("Masukan NIM: ");
        long Nim = jonathan16.nextLong();

        long n = Nim % 100;
        if (n < 10) {
            n += 10;
        }

        System.out.println(n % 100);
        for (int i = 1; i < n+1; i++) {
            if (i == 15 || i == 10) {
                continue;
            }

            if (i % 3 == 0) {
                System.out.print(" #");
            } else if (i % 2 == 0) {
                System.out.print(" " + (i));
            } else if (i % 2 == 1) {
                System.out.print(" *");
            }
            
        }
    }
}
