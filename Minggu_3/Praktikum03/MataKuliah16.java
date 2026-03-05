package Minggu_3.Praktikum03;

import java.util.Scanner;

public class MataKuliah16 {
    public String kode;
    public String nama;
    public int sks;
    public int jumlahJam;

    public MataKuliah16() {

    }

    public MataKuliah16(String kode, String nama, int sks, int jumlahJam) {
        this.kode = kode;
        this.nama = nama;
        this.sks = sks;
        this.jumlahJam = jumlahJam;
    }

    public void tambahData(Scanner jonathan, int nomer) {
        String dummy;
        System.out.println("Masukan Data Matakuliah ke-" + nomer);
            System.out.print("Kode      : ");
            kode = jonathan.nextLine();
            dummy = jonathan.nextLine();
            System.out.print("Nama      : ");
            nama = jonathan.nextLine();
            System.out.print("Sks       : ");
            dummy = jonathan.nextLine();
            sks = Integer.parseInt(dummy);
            System.out.print("Jumlah Jam : ");
            dummy = jonathan.nextLine();
            jumlahJam = Integer.parseInt(dummy);
            System.out.println("------------------------------");
    }

    public void cetakInfo()
    {
        System.out.println("Kode              : " + kode);
        System.out.println("Nama              : " + nama);
        System.out.println("Sks               : " + sks);
        System.out.println("Jumlah Jam        : " + jumlahJam);
        System.out.println("------------------------------");
    }
}
