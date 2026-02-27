package Minggu_3.Praktikum03;

import java.util.Scanner;

public class MataKuliahDemo16 {
    public static void main(String[] args) {
        Scanner jonathan = new Scanner(System.in);
        MataKuliah16[] arrayOfMataKuliah = new MataKuliah16[3];
        String kode, nama, dumy;
        int sks, jumlahJam;

        for (int i = 0; i < 3; i++) {
            System.out.println("Masukan Data Matakuliah ke-" + (i + 1));
            System.out.print("Kode      : ");
            kode = jonathan.nextLine();
            System.out.print("Nama      : ");
            nama = jonathan.nextLine();
            System.out.print("Sks       : ");
            dumy = jonathan.nextLine();
            sks = Integer.parseInt(dumy);
            System.out.print("Jumlah Jam : ");
            dumy = jonathan.nextLine();
            jumlahJam = Integer.parseInt(dumy);
            System.out.println("------------------------------");

            arrayOfMataKuliah[i] = new MataKuliah16(kode, nama, sks, jumlahJam);
        }

        for (int i = 0; i < 3; i++) {
            System.out.println("Data Mata Kuliah ke-" + (i +1));
            System.out.println("Kode              : " + arrayOfMataKuliah[i].kode);
            System.out.println("Nama              : " + arrayOfMataKuliah[i].nama);
            System.out.println("Sks               : " + arrayOfMataKuliah[i].sks);
            System.out.println("Jumlah Jam        : " + arrayOfMataKuliah[i].jumlahJam);
            System.out.println("------------------------------");
        }
    }
}
