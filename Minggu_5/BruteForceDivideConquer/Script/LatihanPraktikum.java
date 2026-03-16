package Minggu_5.BruteForceDivideConquer.Script;

public class LatihanPraktikum {

    // a) Mencari Nilai UTS Tertinggi menggunakan Divide and Conquer
    static int cariMaxUTS(int[] arr, int l, int r) {
        if (l == r) {
            return arr[l];
        }
        int mid = (l + r) / 2;
        int maxL = cariMaxUTS(arr, l, mid);
        int maxR = cariMaxUTS(arr, mid + 1, r);
        
        return (maxL > maxR) ? maxL : maxR;
    }

    // b) Mencari Nilai UTS Terendah menggunakan Divide and Conquer
    static int cariMinUTS(int[] arr, int l, int r) {
        if (l == r) {
            return arr[l];
        }
        int mid = (l + r) / 2;
        int minL = cariMinUTS(arr, l, mid);
        int minR = cariMinUTS(arr, mid + 1, r);
        
        return (minL < minR) ? minL : minR;
    }

    // c) Menghitung Rata-rata UAS menggunakan Brute Force
    static double hitungRataUAS(int[] arr) {
        double total = 0;
        for (int nilai : arr) {
            total += nilai;
        }
        return total / arr.length;
    }

    public static void main(String[] args) {
        Mahasiswa[] daftarMhs = {
            new Mahasiswa("Ahmad", 78, 82),
            new Mahasiswa("Budi", 85, 88),
            new Mahasiswa("Cindy", 90, 87),
            new Mahasiswa("Dian", 76, 79),
            new Mahasiswa("Eko", 92, 95),
            new Mahasiswa("Fajar", 88, 85),
            new Mahasiswa("Gina", 80, 83),
            new Mahasiswa("Hadi", 82, 84)
        };

        int[] uts = new int[daftarMhs.length];
        int[] uas = new int[daftarMhs.length];
        for (int i = 0; i < daftarMhs.length; i++) {
            uts[i] = daftarMhs[i].nilaiUTS;
            uas[i] = daftarMhs[i].nilaiUAS;
        }

        // Output Hasil
        System.out.println("=== HASIL PERHITUNGAN DATA MAHASISWA ===");
        System.out.println("a) Nilai UTS Tertinggi (D&C) : " + cariMaxUTS(uts, 0, uts.length - 1));
        System.out.println("b) Nilai UTS Terendah (D&C)  : " + cariMinUTS(uts, 0, uts.length - 1));
        System.out.printf("c) Rata-rata Nilai UAS (BF)  : %.2f\n", hitungRataUAS(uas));
    }
}
