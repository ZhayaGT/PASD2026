package Minggu_1.Script;

import java.util.Scanner;

public class PlatNomor {
    public static void main(String[] args) {
        Scanner jonathan16 = new Scanner(System.in);

        char[] KODE16 = {'A', 'B', 'D', 'E', 'F', 'G', 'H', 'L', 'N', 'T'};

        char[][] KOTA16 = {
            {'B', 'A', 'N', 'T', 'E', 'N'},
            {'J', 'A', 'K', 'A', 'R', 'T', 'A'},
            {'B', 'A', 'N', 'D', 'U', 'N', 'G'},
            {'C', 'I', 'R', 'E', 'B', 'O', 'N'},
            {'B', 'O', 'G', 'O', 'R'},
            {'P', 'E', 'K', 'A', 'L', 'O', 'N', 'G', 'A', 'N'},
            {'S', 'E', 'M', 'A', 'R', 'A', 'N', 'G'},
            {'S', 'U', 'R', 'A', 'B', 'A', 'Y', 'A'},
            {'M', 'A', 'L', 'A', 'N', 'G'},
            {'T', 'E', 'G', 'A', 'L'}
        };

        System.out.print("Masukan Kode Plat Nomor: ");
        char input16 = jonathan16.next().toUpperCase().charAt(0);

        int indexTemu16 = -1;

        for (int i = 0; i < KODE16.length; i++) {
            if (input16 == KODE16[i]) {
                indexTemu16 = i;
                break;
            }
        }

        if (indexTemu16 != -1) {
            System.out.print("Kota: ");
            for (int i = 0; i < KOTA16[indexTemu16].length; i++) {
                System.out.print(KOTA16[indexTemu16][i]);
            }
            System.out.println();
        } else {
            System.out.println("Kode plat nomor tidak ditemukan");
        }
    }
}
