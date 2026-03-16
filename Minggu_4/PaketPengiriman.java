package Minggu_4;

public class PaketPengiriman {
    // Variabel yang dibutuhkan
    String nomorResi;
    double berat;
    double ongkosDasar;
    double totalPengiriman = 0;

    // Fungsi untuk menjumlahkan total ongkos
    double totalOngkos(PaketPengiriman paket)
    {
        return totalPengiriman += paket.ongkosDasar;
    }

    // Fungsi untuk menampilkan detail paket yang ada
    void printData(PaketPengiriman paket)
    {
        // Variabel yang dibutuhkan
        double totalKirim;
        double diskon = 0;

        // Menampilkan Data Barang
        System.out.println("Nomor Resi: " + paket.nomorResi);
        System.out.println("Berat: " + paket.berat);
        System.out.println("Ongkos Dasar: " + paket.ongkosDasar);
        paket.totalOngkos(paket);

        // Mendapatkan diskon 10% jika total pengiriman lebih dari 100.000
        if (totalPengiriman > 100000) {
            diskon = totalPengiriman * 0.1;
            totalPengiriman = totalPengiriman - diskon;
        }

        // Menampilkan total biaya pengiriman
        System.out.println("Total Biaya Pengiriman: " + totalPengiriman);

        // Menampilkan rata rat ongkos pengiriman
        System.out.println("RataRata Biaya Pengiriman: ");
        System.out.println();
        
    }
}
