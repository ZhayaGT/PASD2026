package Minggu_1.Script;

import java.util.Scanner;

public class JadwalKuliah {
    public static void main(String[] args) {
        Scanner jonathan16 = new Scanner(System.in);

        System.out.print("Masukkan jumlah jadwal (n): ");
        int n = jonathan16.nextInt();
        jonathan16.nextLine();

        String[][] jadwal = new String[n][4];

        inputData(jadwal, jonathan16);
        
        System.out.println("\n--- Seluruh Jadwal Kuliah ---");
        TampilkanSemua(jadwal);

        System.out.print("\nCari berdasarkan Hari: ");
        String cariHari = jonathan16.nextLine();
        TampilkanByHari(jadwal, cariHari);

        System.out.print("\nCari berdasarkan Nama Mata Kuliah: ");
        String cariMatkul = jonathan16.nextLine();
        TampilkanByMatkul(jadwal, cariMatkul);
    }

    public static void inputData(String[][] jadwal, Scanner sc) {
        for (int i = 0; i < jadwal.length; i++) {
            System.out.println("Input Jadwal ke-" + (i + 1));
            System.out.print("Nama Mata Kuliah : ");
            jadwal[i][0] = sc.nextLine();
            System.out.print("Ruang            : ");
            jadwal[i][1] = sc.nextLine();
            System.out.print("Hari Kuliah      : ");
            jadwal[i][2] = sc.nextLine();
            System.out.print("Jam Kuliah       : ");
            jadwal[i][3] = sc.nextLine();
        }
    }

    public static void TampilkanSemua(String[][] jadwal) {
        System.out.printf("%-20s | %-10s | %-10s | %-10s\n", "Mata Kuliah", "Ruang", "Hari", "Jam");
        System.out.println("------------------------------------------------------------");
        for (String[] row : jadwal) {
            System.out.printf("%-20s | %-10s | %-10s | %-10s\n", row[0], row[1], row[2], row[3]);
        }
    }

    public static void TampilkanByHari(String[][] jadwal, String hari) {
        System.out.println("Jadwal pada hari " + hari + ":");
        for (int i = 0; i < jadwal.length; i++) {
            if (jadwal[i][2].equalsIgnoreCase(hari)) {
                System.out.println("- " + jadwal[i][0] + " di " + jadwal[i][1] + " jam " + jadwal[i][3]);
            }
        }
    }

    public static void TampilkanByMatkul(String[][] jadwal, String matkul) {
        System.out.println("Hasil pencarian matkul '" + matkul + "':");
        for (int i = 0; i < jadwal.length; i++) {
            if (jadwal[i][0].equalsIgnoreCase(matkul)) {
                System.out.println("- Hari: " + jadwal[i][2] + ", Ruang: " + jadwal[i][1] + ", Jam: " + jadwal[i][3]);
            }
        }
    }
}