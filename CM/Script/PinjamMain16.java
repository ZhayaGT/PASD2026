package CM.Script;

import java.util.Scanner;

public class PinjamMain16 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Scanner sc1 = new Scanner(System.in);

        Mahasiswa16[] mhs = new Mahasiswa16[3];
        mhs[0] = new Mahasiswa16("22001", "Andi", "Teknik Informatika");
        mhs[1] = new Mahasiswa16("22002", "Budi", "Teknik Informatika");
        mhs[2] = new Mahasiswa16("22003", "Citra", "Sistem Informasi Bisnis");

        Buku16[] buku = new Buku16[4];
        buku[0] = new Buku16("B001", "Algoritma", 2020);
        buku[1] = new Buku16("B002", "Basis Data", 2019);
        buku[2] = new Buku16("B003", "Pemrograman", 2021);
        buku[3] = new Buku16("B004", "Fisika", 2024);

        Peminjaman16[] pinjam = new Peminjaman16[5];
        pinjam[0] = new Peminjaman16(mhs[0], buku[0], 7);
        pinjam[1] = new Peminjaman16(mhs[1], buku[1], 3);
        pinjam[2] = new Peminjaman16(mhs[2], buku[2], 10);
        pinjam[3] = new Peminjaman16(mhs[2], buku[3], 6);
        pinjam[4] = new Peminjaman16(mhs[0], buku[1], 4);

        System.out.println("=== SISTEM INFORMASI PEMINJAMAN RUANG BACA JTI ===");
        System.out.println("1. Tampilkan Mahasiswa");
        System.out.println("2. Tampilkan Buku");
        System.out.println("3. Tampilkan Peminjaman");
        System.out.println("4. Urutkan Berdasarkan Denda");
        System.out.println("5. Cari Berdasarkan NIM");
        System.out.println("0. Keluar");
        System.out.print("Pilih: ");
        int pilih = sc.nextInt();

        switch (pilih) {
            case 1:
                System.out.println("Daftar Mahasiswa:");
                for (int i = 0; i < mhs.length; i++) {
                    mhs[i].tampilMahasiswa();
                }
                System.out.println();
                main(args);
                break;
            case 2:
                System.out.println("Daftar Buku:");
                for (int i = 0; i < buku.length; i++) {
                    buku[i].Tampil();
                }
                System.out.println();
                main(args);
                break;
            case 3:
                System.out.println("Data Peminjaman:");
                for (int i = 0; i < pinjam.length; i++) {
                    pinjam[i].HitungDenda();
                    pinjam[i].TampilPeminjaman();
                }
                System.out.println();
                main(args);
                break;
            case 4:
                System.out.println("Setelah Diurutkan (Denda terbesar");
                for (int i = 0; i < pinjam.length; i++) {
                    pinjam[i].HitungDenda();
                }
                InsertionSort(pinjam);
                for (int i = 0; i < pinjam.length; i++) {
                    pinjam[i].TampilPeminjaman();
                }
                System.out.println();
                main(args);
                break;
            case 5:
                System.out.print("Masukan NIM: ");
                String input = sc1.nextLine();
                SequentialSearch(input, pinjam);
                System.out.println();
                main(args);
                break;

            default:
                break;
        }
    }

    public static void InsertionSort(Peminjaman16[] pinjam){
        for (int i = 0; i < pinjam.length; i++) {
            Peminjaman16 temp = pinjam[i];
            int j=i;
            while (j>0 && pinjam[j-1].denda<temp.denda) {
                pinjam[j]=pinjam[j-1];
                j--;
            }
            pinjam[j]=temp;
        }
    }


    public static void SequentialSearch(String cari, Peminjaman16[] pinjam) {
        boolean found = false;
        for (int i = 0; i < pinjam.length; i++) {
            if (pinjam[i].Mhs.nim.equalsIgnoreCase(cari)) {
                pinjam[i].HitungDenda();
                pinjam[i].TampilPeminjaman();
                found = true;
            }
        }
        if (!found) {
            System.out.println("NIM " + cari + " tidak memiliki riwayat peminjaman.");
        }
    }
}
