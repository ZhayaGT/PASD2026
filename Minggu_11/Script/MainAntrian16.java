package Minggu_11.Script;

import java.util.Scanner;

public class MainAntrian16 {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Tentukan kapasitas maksimal antrian: ");
            int kapasitas = sc.nextInt();
            QueueLayanan16 antrian = new QueueLayanan16(kapasitas);
            int menu;

            do {
                System.out.println("\n=== SISTEM ANTRIAN KEMAHASISWAAN ===");
                System.out.println("1. Daftar Antrian Baru (Enqueue)");
                System.out.println("2. Panggil Antrian (Dequeue)");
                System.out.println("3. Cek Antrian Terdepan & Paling Akhir");
                System.out.println("4. Status Antrian Saat Ini");
                System.out.println("5. Tampilkan Seluruh Antrian");
                System.out.println("6. Kosongkan Antrian (Clear)");
                System.out.println("7. Keluar");
                System.out.print("Pilih Menu (1-7): ");
                menu = sc.nextInt();
                sc.nextLine();

                switch (menu) {
                    case 1:
                        if (!antrian.isFull()) {
                            System.out.print("Masukkan NIM  : ");
                            String nim = sc.nextLine();
                            System.out.print("Masukkan Nama : ");
                            String nama = sc.nextLine();
                            antrian.enqueue(new MahasiswaAntrian16(nim, nama));
                        } else {
                            System.out.println("Perhatian: Kapasitas antrian sudah penuh!");
                        }
                        break;
                    case 2:
                        antrian.dequeue();
                        break;
                    case 3:
                        antrian.peekFront();
                        System.out.println("-------------------------");
                        antrian.peekRear();
                        break;
                    case 4:
                        System.out.println("Status Kosong : " + antrian.isEmpty());
                        System.out.println("Status Penuh  : " + antrian.isFull());
                        System.out.println("Sisa Antrian  : " + antrian.getSize() + " mahasiswa");
                        break;
                    case 5:
                        antrian.printQueue();
                        break;
                    case 6:
                        antrian.clear();
                        break;
                    case 7:
                        System.out.println("Program dihentikan.");
                        break;
                    default:
                        System.out.println("Pilihan tidak tersedia, silakan coba lagi!");
                }
            } while (menu != 7);
        } 
    }
}
