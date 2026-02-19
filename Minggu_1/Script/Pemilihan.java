package Minggu_1.Script;

import java.util.Scanner;

public class Pemilihan {

    public static boolean isValid16 = true;
    public static boolean isLulus16 = true;
    public static void main(String[] args) {
        Scanner jonathan16 = new Scanner(System.in);

        System.out.println("Program Menghitung Nilai Akhir");
        System.out.println("======================");

        double tugas16 = InputNilai(jonathan16, "Tugas");
        double kuis16 = InputNilai(jonathan16, "Kuis");
        double uts16 = InputNilai(jonathan16, "UTS");
        double uas16 = InputNilai(jonathan16, "UAS");

        System.out.println("======================");
        System.out.println("======================");
        
        if (!isValid16) {
            System.out.println("Nilai tidak valid");
        } else {
            double nilaiAkhir16 = ((tugas16 * 0.2) + (kuis16 * 0.2) + (uts16 * 0.3) + (uas16 * 0.3));
            System.out.println("nilai akhir : " + nilaiAkhir16);

            String nilaiHuruf16 = NilaiHuruf(nilaiAkhir16);
            System.out.println("Nilai Huruf : " + nilaiHuruf16);
            System.out.println("======================");
            
            if (isLulus16) {
                System.out.println("SELAMAT ANDA LULUS");
            } else {
                System.out.println("TIDAK LULUS");
            }
        }
        System.out.println("======================");
    }

    public static double InputNilai(Scanner jonathan, String namaNilai16) {
        double nilai16;
        System.out.print("Masukan nilai " + namaNilai16 + ": ");
        nilai16 = jonathan.nextDouble();
        if (nilai16 < 0 || nilai16 > 100) {
            isValid16 = false;
        }
        return nilai16;
    }

    public static String NilaiHuruf(double nilaiAkhir16)
    {
        String nilai16 = "";
        if (80 < nilaiAkhir16 && nilaiAkhir16 <= 100) {
            nilai16 = "A";
        }
        if (73 < nilaiAkhir16 && nilaiAkhir16 <= 80) {
            nilai16 = "B+";
        }
        if (65 < nilaiAkhir16 && nilaiAkhir16 <= 73) {
            nilai16 = "B";
        }
        if (60 < nilaiAkhir16 && nilaiAkhir16 <= 65) {
            nilai16 = "C+";
        }
        if (50 < nilaiAkhir16 && nilaiAkhir16 <= 60) {
            nilai16 = "C";
        }
        if (39 < nilaiAkhir16 && nilaiAkhir16 <= 50) {
            nilai16 = "D";
            isLulus16 = false;
        }
        if (nilaiAkhir16 <= 39) {
            nilai16 = "E";
            isLulus16 = false;
        }
        return nilai16;
    }
}