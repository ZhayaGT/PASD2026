package Minggu_3.Praktikum03;

import java.util.Scanner;

public class MataKuliahDemo16 {
    public static void main(String[] args) {
        Scanner jonathan = new Scanner(System.in);
        int n;
        System.out.print("Masukan banyak mata kuliah: ");
        n = jonathan.nextInt();
        MataKuliah16[] arrayOfMataKuliah = new MataKuliah16[n];
        String kode, nama, dumy;
        int sks, jumlahJam;

        for (int i = 0; i < n; i++) {
            arrayOfMataKuliah[i] = new MataKuliah16();
            arrayOfMataKuliah[i].tambahData(jonathan, (i + 1));
        }

        for (int i = 0; i < n; i++) {
            System.out.println("Data Mata Kuliah ke-" + (i +1));
            arrayOfMataKuliah[i].cetakInfo();
        }
    }
}
