package Minggu_7.Script;

import java.util.Scanner;

public class MahasiswaDemo16 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MahasiswaBerprestasi16 list = new MahasiswaBerprestasi16();
        
        System.out.print("Masukkan jumlah mahasiswa: ");
        int jmlMhs = sc.nextInt();
        sc.nextLine(); 

        for (int i = 0; i < jmlMhs; i++) {
            System.out.println("--- Masukkan Data Mahasiswa ke-" + (i + 1) + " ---");
            System.out.print("NIM   : ");
            String nim = sc.nextLine();
            System.out.print("Nama  : ");
            String nama = sc.nextLine();
            System.out.print("Kelas : ");
            String kelas = sc.nextLine();
            System.out.print("IPK   : ");
            double ipk = sc.nextDouble();
            sc.nextLine();

            Mahasiswa16 m = new Mahasiswa16(nim, nama, kelas, ipk);
            list.Tambah(m);
        }

        // list.tampil();
        System.out.println("----------------------------------------");
        System.out.println("Pencarian data");
        System.out.println("----------------------------------------");
        System.out.println("masukan ipk mahasiswa yang dicari: ");
        System.out.print("IPK: ");
        double cari = sc.nextDouble();

        System.out.println("Menggunakan sequential searching");
        double posisi = list.SequentialSearching(cari);
        int pss = (int)posisi;
        list.TampilPosisi(cari, pss);
        list.TampilDataSearch(cari, pss);

        System.out.println("----------------------------------------");
        System.out.println("Menggunakan binary search");
        System.out.println("----------------------------------------");
        double posisi2 = list.findBinarySearch(cari, 0, jmlMhs)-1;
        int pss2 = (int)posisi2;
        list.TampilPosisi(cari, pss2);
        list.TampilDataSearch(cari, pss2);   
    }

    
}
