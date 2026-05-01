package Minggu_9.Script;

import java.util.Scanner;

public class SuratDemo16 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StackSurat16 stack = new StackSurat16(20);
        int pilihan;

        do {
            System.out.println("\n--- Sistem Kelola Surat Izin ---");
            System.out.println("1. Terima Surat Izin");
            System.out.println("2. Proses Surat Izin");
            System.out.println("3. Lihat Surat Izin Terakhir");
            System.out.println("4. Cari Surat");
            System.out.println("5. Keluar");
            System.out.print("Pilih: ");
            pilihan = sc.nextInt();
            sc.nextLine();

            switch (pilihan) {
                case 1:
                    System.out.print("ID Surat: ");
                    String id = sc.nextLine();
                    System.out.print("Nama Mahasiswa: ");
                    String nama = sc.nextLine();
                    System.out.print("Kelas: ");
                    String kelas = sc.nextLine();
                    System.out.print("Jenis Izin (S/I): ");
                    char jenis = sc.nextLine().charAt(0);
                    System.out.print("Durasi (hari): ");
                    int durasi = sc.nextInt();
                    
                    Surat16 s = new Surat16(id, nama, kelas, jenis, durasi);
                    stack.push(s);
                    break;

                case 2:
                    Surat16 diproses = stack.pop();
                    if (diproses != null) {
                        System.out.println("Berhasil memproses surat milik: " + diproses.namaMahasiswa);
                    }
                    break;

                case 3:
                    Surat16 terakhir = stack.peek();
                    if (terakhir != null) {
                        System.out.println("Surat Teratas:");
                        System.out.println("ID Surat: " + terakhir.idSurat);
                        System.out.println("Nama    : " + terakhir.namaMahasiswa);
                        System.out.println("Kelas   : " + terakhir.kelas);
                        System.out.println("Jenis   : " + terakhir.jenisIzin);
                        System.out.println("Durasi  : " + terakhir.durasi + " hari");
                    }
                    break;

                case 4:
                    System.out.print("Masukkan nama mahasiswa yang dicari: ");
                    String cariNama = sc.nextLine();
                    stack.cariSurat(cariNama);
                    break;

                case 5:
                    System.out.println("Program selesai.");
                    break;

                default:
                    System.out.println("Pilihan tidak valid.");
            }
        } while (pilihan != 5);
        
        sc.close();
    }
}
