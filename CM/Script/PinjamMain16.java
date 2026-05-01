package CM.Script;

import java.util.Scanner;

public class PinjamMain16 {
    public static void main(String[] args) {
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
        pinjam[0] = new Peminjaman16(mhs[0], buku[0], 7, false);
        pinjam[1] = new Peminjaman16(mhs[1], buku[1], 3, false);
        pinjam[2] = new Peminjaman16(mhs[2], buku[2], 25, false);
        pinjam[3] = new Peminjaman16(mhs[2], buku[3], 6, false);
        pinjam[4] = new Peminjaman16(mhs[0], buku[1], 4,false);

        

        PilihMenu(mhs, buku, pinjam);
    }

    public static void PilihMenu(Mahasiswa16[] mhs, Buku16[] buku, Peminjaman16[] pinjam)
    {
        Scanner sc = new Scanner(System.in);
        Scanner sc1 = new Scanner(System.in);

        System.out.println("=== SISTEM INFORMASI PEMINJAMAN RUANG BACA JTI ===");
        System.out.println("1. Tampilkan Mahasiswa");
        System.out.println("2. Tampilkan Buku");
        System.out.println("3. Tampilkan Peminjaman");
        System.out.println("4. Urutkan Berdasarkan Denda");
        System.out.println("5. Cari Berdasarkan NIM");
        System.out.println("6. Pembatalan Berdasarkan NIM");
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
                PilihMenu(mhs, buku, pinjam);
                break;
            case 2:
                System.out.println("Daftar Buku:");
                for (int i = 0; i < buku.length; i++) {
                    buku[i].Tampil();
                }
                System.out.println();
                PilihMenu(mhs, buku, pinjam);
                break;
            case 3:
                System.out.println("Data Peminjaman:");
                for (int i = 0; i < pinjam.length; i++) {
                    pinjam[i].HitungDenda();
                    pinjam[i].TampilPeminjaman();
                }
                System.out.println();
                PilihMenu(mhs, buku, pinjam);
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
                PilihMenu(mhs, buku, pinjam);
                break;
            case 5:
                System.out.print("Masukan NIM: ");
                String input = sc1.nextLine();
                SequentialSearch(input, pinjam);
                System.out.println();
                PilihMenu(mhs, buku, pinjam);
                break;
            
            // Jawaban Soal B, sesi 1, menambahkan fungsi untuk menandai data
            case 6:
                System.out.print("Masukan NIM: ");
                String input1 = sc1.nextLine();
                pinjam = BatalTransaksi(input1, pinjam);
                System.out.println();
                PilihMenu(mhs, buku, pinjam);
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
            // Menambah Kondisi baru, Soal B. Sehingga hanya memunculkan yg is canceled false
            if (pinjam[i].Mhs.nim.equalsIgnoreCase(cari) || pinjam[i].isCanceled == false) {
                pinjam[i].HitungDenda();
                pinjam[i].TampilPeminjaman();
                found = true;
            }
        }
        if (!found) {
            System.out.println("NIM " + cari + " tidak memiliki riwayat peminjaman.");
        }
    }

    // Jawaban soal B, sesi 1, Menambahkan Menu Baru untuk membatalkan transaksi
    public static Peminjaman16[] BatalTransaksi(String cari, Peminjaman16[] pinjam) {
        boolean found = false;
        for (int i = 0; i < pinjam.length; i++) {
            if (pinjam[i].Mhs.nim.equalsIgnoreCase(cari)) {
                pinjam[i].Batalkan();
                pinjam[i].HitungDenda();
                // pinjam[i].TampilPeminjaman();
                found = true;
            }
        }
        
        if (!found) {
            System.out.println("NIM " + cari + " tidak memiliki riwayat peminjaman.");
        }

        // Gunakan Menu 3 untuk tampilkan data eminjaan
        // for (int i = 0; i < pinjam.length; i++) {
        //     pinjam[i].HitungDenda();
        //     pinjam[i].TampilPeminjaman();
        // }

        return pinjam;
    }
}
