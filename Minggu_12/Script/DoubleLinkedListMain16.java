package Minggu_12.Script;

import java.util.Scanner;

public class DoubleLinkedListMain16 {
    public static void main(String[] args) {
        try (Scanner scan = new Scanner(System.in)) {
            DoubleLinkedList16 list = new DoubleLinkedList16();
            int pilihan;

            do {
                System.out.println("===== MENU TUGAS DOUBLE LINKED LIST =====");
                System.out.println("1. Tambah data di awal (addFirst)");
                System.out.println("2. Tambah data di akhir (addLast)");
                System.out.println("3. Sisipkan data setelah NIM (insertAfter)");
                System.out.println("4. Tambah data pada Indeks tertentu (add)");
                System.out.println("5. Hapus data di awal (removeFirst)");
                System.out.println("6. Hapus data di akhir (removeLast)");
                System.out.println("7. Hapus data setelah NIM (removeAfter)");
                System.out.println("8. Hapus data pada Indeks tertentu (remove)");
                System.out.println("9. Tampilkan Data Pertama (getFirst)");
                System.out.println("10. Tampilkan Data Terakhir (getLast)");
                System.out.println("11. Tampilkan Data Indeks tertentu (getIndex)");
                System.out.println("12. Tampilkan Semua Data & Jumlah (print & size)");
                System.out.println("0. Keluar");
                System.out.print("Pilih menu: ");
                pilihan = scan.nextInt();
                scan.nextLine();

                switch (pilihan) {
                    case 1:
                        list.addFirst(inputMahasiswa(scan));
                        break;
                    case 2:
                        list.addLast(inputMahasiswa(scan));
                        break;
                    case 3:
                        System.out.print("Masukkan NIM target: ");
                        String keyNim = scan.nextLine();
                        list.insertAfter(keyNim, inputMahasiswa(scan));
                        break;
                    case 4:
                        System.out.print("Masukkan Indeks tujuan: ");
                        int idxAdd = scan.nextInt();
                        scan.nextLine();
                        list.add(idxAdd, inputMahasiswa(scan));
                        break;
                    case 5:
                        list.removeFirst();
                        System.out.println("Data pertama berhasil dihapus.");
                        break;
                    case 6:
                        list.removeLast();
                        System.out.println("Data terakhir berhasil dihapus.");
                        break;
                    case 7:
                        System.out.print("Masukkan NIM target: ");
                        String keyRemAfter = scan.nextLine();
                        list.removeAfter(keyRemAfter);
                        break;
                    case 8:
                        System.out.print("Masukkan Indeks yang ingin dihapus: ");
                        int idxRem = scan.nextInt();
                        scan.nextLine();
                        list.remove(idxRem);
                        break;
                    case 9:
                        list.getFirst();
                        break;
                    case 10:
                        list.getLast();
                        break;
                    case 11:
                        System.out.print("Masukkan Indeks yang dicari: ");
                        int idxGet = scan.nextInt();
                        scan.nextLine();
                        list.getIndex(idxGet);
                        break;
                    case 12:
                        System.out.println("Jumlah data aktif (size): " + list.getSize());
                        list.print();
                        break;
                    case 0:
                        System.out.println("Program selesai.");
                        break;
                    default:
                        System.out.println("Menu tidak valid.");
                }
            } while (pilihan != 0);
        }
    }

    private static Mahasiswa16 inputMahasiswa(Scanner scan) {
        System.out.print("NIM   : ");
        String nim = scan.nextLine();
        System.out.print("Nama  : ");
        String nama = scan.nextLine();
        System.out.print("Kelas : ");
        String kelas = scan.nextLine();
        System.out.print("IPK   : ");
        double ipk = scan.nextDouble();
        scan.nextLine();
        return new Mahasiswa16(nim, nama, kelas, ipk);
    }
}