package Minggu_2.Script;

public class Dosen16 {
    String idDosen16;
    String nama16;
    boolean statusAktif16;
    int tahunBergabung16;
    String bidangKeahlian16;

    void tampilInformasi() {
        System.out.println("ID: " + idDosen16);
        System.out.println("Nama: " + nama16);
        System.out.println("Status: " + ((statusAktif16) ? "Aktif" : "NonAktif"));
        System.out.println("Tahun Bergabung: " + tahunBergabung16 + " (" + hitungMasaKerja(2026) + " Tahun)");
        System.out.println("Bidang Keahlian: " + bidangKeahlian16);
    }

    void setStatusAktif() {
        statusAktif16 = !statusAktif16;
    }

    int hitungMasaKerja(int thnkSkrg)
    {
        return thnkSkrg - tahunBergabung16;
    }

    void ubahKeahlian(String bidang) {
        bidangKeahlian16 = bidang;
    }

    Dosen16() {

    }

    Dosen16(String id, String nama, boolean status, int tGabung, String bKeahlian) {
        this.idDosen16 = id;
        this.nama16 = nama;
        this.statusAktif16 = status;
        this.tahunBergabung16 = tGabung;
        this.bidangKeahlian16 = bKeahlian;
    }
}
