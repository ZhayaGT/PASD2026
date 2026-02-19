package Minggu_1.Script;

import java.util.Scanner;

public class Array {
    static String[] Mapel16 = {
        "Pancasila", 
        "Konsep Teknologi Informasi", 
        "Critical Thinking dan Problem Solving",
        "Matematika Dasar", 
        "Bahasa Inggris", 
        "Dasar Pemograman",
        "Pratikum Dasar Pemrograman", 
        "Keselamatan dan Kesehatan Kerja",
    };

    static double[] Nilai16 = new double[Mapel16.length];

    public static void main(String[] args) {
        Scanner jonathan = new Scanner(System.in);

        System.out.println("================================");
        System.out.println("Program Menghitung IP Semester");
        System.out.println("================================");

        for (int i = 0; i < Mapel16.length; i++) {
            Nilai16[i] = InputNilai(jonathan, Mapel16[i]);
        }

        System.out.println("================================");
        System.out.println("Hasil Konversi Nilai");
        System.out.println("================================");

        TampilkanNilai();
    }

    public static double InputNilai(Scanner jo, String namaNilai16) {
        double nilai;
        System.out.print("Masukan nilai Angka untuk MK " + namaNilai16 + ": ");
        nilai = jo.nextDouble();
        return nilai;
    }

    public static void TampilkanNilai()
    {
        System.out.printf("%-40s %-14s %-14s %-6s%n", 
            "Mata Kuliah", "Nilai Angka", "Nilai Huruf", "Bobot Nilai");
        
        for (int i = 0; i < Mapel16.length; i++) {
            String nilaiHuruf = KonversiNilaiHuruf(Nilai16[i]);
            double nilaiBobot = KonversiNilaiBobot(nilaiHuruf);

            System.out.printf("%-43s %-18s %-10s %-6s%n", 
            Mapel16[i], Nilai16[i], nilaiHuruf, nilaiBobot);
        }

        System.out.println("================================");
        System.out.println("IP : (tidak ada data SKS)");
    }

    static String KonversiNilaiHuruf(double nilaiAngka16)
    {
        if (nilaiAngka16 > 80) return "A";
        else if (nilaiAngka16 > 73) return "B+";
        else if (nilaiAngka16 > 65) return "B";
        else if (nilaiAngka16 > 60) return "C+";
        else if (nilaiAngka16 > 50) return "C";
        else if (nilaiAngka16 > 39) return "D";
        else return "E";

    }

    static double KonversiNilaiBobot(String huruf16)
    {
        switch (huruf16) {
            case "A": return 4.0;
            case "B+": return 3.5;
            case "B": return 3;
            case "C+": return 2.5;
            case "C": return 2;
            case "D": return 1;
            case "E": return 0;
            default: return 0;
        }
    }

}
