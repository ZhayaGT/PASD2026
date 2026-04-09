package Minggu_6.Praktikum05.Script;

import java.util.Scanner;

public class DosenMain16 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DataDosen16 operatif = new DataDosen16();
        int pilih;

        do {
            System.out.println("\n=== MENU DATA DOSEN ===");
            System.out.println("1. Tambah Data Dosen");
            System.out.println("2. Tampil Semua Data");
            System.out.println("3. Sorting ASC (Usia Termuda)");
            System.out.println("4. Sorting DSC (Usia Tertua)");
            System.out.println("5. Keluar");
            System.out.print("Pilih menu: ");
            pilih = sc.nextInt();
            sc.nextLine(); // clear buffer

            switch (pilih) {
                case 1:
                    System.out.print("Kode          : "); String kd = sc.nextLine();
                    System.out.print("Nama          : "); String nm = sc.nextLine();
                    System.out.print("JK (P/W)      : "); String jkStr = sc.nextLine();
                    boolean jk = jkStr.equalsIgnoreCase("P");
                    System.out.print("Usia          : "); int us = sc.nextInt();
                    
                    Dosen16 d = new Dosen16(kd, nm, jk, us);
                    operatif.tambah(d);
                    break;
                case 2:
                    operatif.tampil();
                    break;
                case 3:
                    operatif.sortingASC();
                    System.out.println("Data berhasil diurutkan (Ascending).");
                    operatif.tampil();
                    break;
                case 4:
                    operatif.sortingDSC();
                    System.out.println("Data berhasil diurutkan (Descending).");
                    operatif.tampil();
                    break;
            }
        } while (pilih != 5);
        sc.close();
    }
}
