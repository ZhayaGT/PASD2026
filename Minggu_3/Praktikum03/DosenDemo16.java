package Minggu_3.Praktikum03;

import java.util.Scanner;

public class DosenDemo16 {
    public static void main(String[] args) {
        Scanner jonathan = new Scanner(System.in);

        Dosen16[] dosen16 = new Dosen16[3]; 

        String kode = "",nama = "", jenisKelamin ="", dummy;
        int usia;
        boolean kelamin;
        for (int i = 0; i < 3; i++) {
            System.out.println("Masukan Data Dosen ke-" + (i+1));
            System.out.print("Kode               : ");
            kode = jonathan.nextLine();
            System.out.print("Nama               : ");
            nama = jonathan.nextLine();
            System.out.print("Jenis Kelamin      : ");
            jenisKelamin = jonathan.nextLine();
            if (jenisKelamin.equalsIgnoreCase("wanita")) {
                kelamin = true;
            } else {
                kelamin = false;
            }
            System.out.print("Usia               : ");
            usia = jonathan.nextInt();

            jonathan.nextLine();

            dosen16[i] = new Dosen16(kode, nama,kelamin, usia);
            System.out.println("-----------------------------------------");
        }

        int i = 1;
        for (Dosen16 dosen162 : dosen16) {
            System.out.println("Data Dosen ke-" + i);
            System.out.println("Kode             : " + dosen162.kode);
            System.out.println("Nama             : " + dosen162.nama);
            System.out.println("Jenis Kelamin    : " + ((dosen162.jenisKelamin) ?"Wanita" :"Pria"));
            System.out.println("Usia             : " + dosen162.usia);
            i++;
        }
    }
}
