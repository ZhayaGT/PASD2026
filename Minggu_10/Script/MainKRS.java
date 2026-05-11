package Minggu_10.Script;

import java.util.Scanner;

public class MainKRS {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        AntrianKRS antrian = new AntrianKRS(10, 30);
        int menu;

        do {
            System.out.println("\n=========================================");
            System.out.println("        SISTEM ANTRIAN KRS DPA           ");
            System.out.println("=========================================");
            System.out.println("1. Tambah Mahasiswa ke Antrian");
            System.out.println("2. Proses Antrian KRS (Panggil 2 Orang)");
            System.out.println("3. Tampilkan Semua Antrian");
            System.out.println("4. Lihat 2 Antrian Terdepan");
            System.out.println("5. Lihat Antrian Paling Akhir");
            System.out.println("6. Cek Status/Statistik Antrian");
            System.out.println("7. Kosongkan Antrian");
            System.out.println("0. Keluar Program");
            System.out.println("=========================================");
            System.out.print("Pilih Menu: ");
            menu = sc.nextInt();
            sc.nextLine();

            switch (menu) {
                case 1:
                    if (antrian.IsFull()) {
                        System.out.println(">> Antrian penuh, silakan tunggu diproses.");
                    } else {
                        System.out.println("--- Masukkan Data Mahasiswa ---");
                        System.out.print("NIM   : "); String nim = sc.nextLine();
                        System.out.print("Nama  : "); String nama = sc.nextLine();
                        System.out.print("Prodi : "); String prodi = sc.nextLine();
                        System.out.print("Kelas : "); String kelas = sc.nextLine();
                        Mahasiswa16 mhsBaru = new Mahasiswa16(nim, nama, prodi, kelas);
                        antrian.TambahAntrian(mhsBaru);
                    }
                    break;
                case 2:
                    antrian.ProsesKRS();
                    break;
                case 3:
                    antrian.TampilkanSemua();
                    break;
                case 4:
                    antrian.LihatDuaTerdepan();
                    break;
                case 5:
                    antrian.LihatAkhir();
                    break;
                case 6:
                    System.out.println("\n=== STATISTIK ANTRIAN ===");
                    System.out.println("Jumlah Menunggu di Antrian      : " + antrian.GetJumlahAntrian());
                    System.out.println("Jumlah Mahasiswa Sudah Proses KRS : " + antrian.GetJumlahDiproses());
                    System.out.println("Sisa Kuota DPA Belum Proses KRS   : " + antrian.GetBelumKRS());
                    System.out.println("Status Antrian Penuh?           : " + (antrian.IsFull() ? "Ya" : "Tidak"));
                    System.out.println("Status Antrian Kosong?          : " + (antrian.IsEmpty() ? "Ya" : "Tidak"));
                    break;
                case 7:
                    antrian.KosongkanAntrian();
                    break;
                case 0:
                    System.out.println("Keluar dari program. Terima kasih!");
                    break;
                default:
                    System.out.println("Pilihan tidak valid! Silakan pilih menu yang tersedia.");
            }
        } while (menu != 0);

        sc.close();
    }
}
