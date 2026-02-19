package Minggu_1.Script;

public class Fungsi {
    static String[] bunga16 = {"Aglonema", "Keladi", "Alocasia", "Mawar"};
    static String[] cabang16 = {"RoyalGarden 1", "RoyalGarden 2", "RoyalGarden 3", "RoyalGarden 4"};
    static int[][] stock16 = {
        {10, 5, 15 ,7},
        {6, 11, 9, 12},
        {2, 10, 10, 5},
        {5, 7 ,12 ,9}
    };
    static int[] harga16 = {75000, 50000, 60000, 10000};
    public static void main(String[] args) {
        TampilkanPendapatan();
    }

    static void TampilkanPendapatan() {
        int pendapatan16 = 0;

        System.out.println("PENDAPATAN SETIAP CABANG");
        System.out.println("==========================");

        for (int i = 0; i < cabang16.length; i++) {
            for (int j = 0; j < stock16[i].length; j++) {
                pendapatan16 += (stock16[i][j] * harga16[j]);
            }
            System.out.println(cabang16[i] + ": Rp." + pendapatan16 + StatusPendapatan(pendapatan16));
        }
    }

    static String StatusPendapatan(int pendapatan16)
    {
        if (pendapatan16 > 1500000) {
            return " (Sangat Baik)";
        } else {
            return " (Perlu Evaluasi)";
        }
    }
}
