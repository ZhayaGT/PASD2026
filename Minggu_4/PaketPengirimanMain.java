package Minggu_4;

import java.util.Scanner;

public class PaketPengirimanMain {
    int n = 2;
    PaketPengiriman[] paket = new PaketPengiriman[n];
    static Scanner jonathan = new Scanner(System.in);

    // Fungsi Main yang dijalankan pertamakali, dan berfungsi untuk menjalan fungsi IsiPaket dan Tampilkan
    public void main(String[] args) {
        IsiPaket();
        System.out.println("---------------------------");
        Tampilkan();
    }

    // Fungsi untuk mengisi data paket
    public void IsiPaket()
    {
        String dummy; // Untuk memperbaiki bug pada Scanner

        for (int i = 0; i < paket.length; i++) {
            System.out.println();
            paket[i] = new PaketPengiriman();
            System.out.println("Paket ke-" + (i+1));
            System.out.print("Nomor Resi: ");
            paket[i].nomorResi = jonathan.nextLine();
            System.out.print("Berat: ");
            paket[i].berat = jonathan.nextInt();
            dummy = jonathan.nextLine();
            System.out.print("Ongkos Dasar: ");
            paket[i].ongkosDasar = jonathan.nextDouble();
            dummy = jonathan.nextLine();
        }

    } 

    // Fungsi untuk menampilkan semua datapaket
    // Salah, seharunya mengirimkan array paket langsung alih alih dengan
    public void Tampilkan(){
        for (int i = 0; i < paket.length; i++) {
            System.out.println("Paket ke-" + (i+1));
            paket[i].printData(paket[i]);
        }
    }
}
