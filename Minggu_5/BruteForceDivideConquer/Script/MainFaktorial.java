package Minggu_5.BruteForceDivideConquer.Script;

import java.util.Scanner;

public class MainFaktorial {
    public static void main(String[] args) {
        Scanner jonathan = new Scanner(System.in);
        System.out.print("Masukan nilai: ");
        int nilai = jonathan.nextInt();

        Faktorial fk = new Faktorial();
        System.out.println("Nilai faktorial " + nilai + " menggunakan BF: " + fk.faktorialBF(nilai));
        System.out.println("Nilai faktorial " + nilai + " menggunakan DC: " +fk.faktorialDC(nilai));
    }
}
