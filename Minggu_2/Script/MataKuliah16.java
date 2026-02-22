package Minggu_2.Script;

public class MataKuliah16 {
    String kodeMk16;
    String nama16;
    int sks16;
    int jumlahJam16;

    void tampilInformasi() {
        System.out.println("Kode: \t" + kodeMk16);
        System.out.println("Nama: \t" + nama16);
        System.out.println("Jumlah SKS: \t" + sks16);
        System.out.println("Jumlah Jam: \t" + jumlahJam16 + " Jam");
    }

    void ubahSKS(int sksBaru) {
        sks16 = sksBaru;
        System.out.println("SKS telah diubah!");
    }

    void tambahJam(int jam) {
        jumlahJam16 += jam;
    }

    void kurangiJam(int jam) {
        if (jumlahJam16 < jam) {
            System.out.println("Pengurangan tidak bisa dilakukan");
        } else {
            jumlahJam16 -= jam;
            System.out.println("Jumlah Jam Dikurangi!");
            System.out.println("Jumlah Jam: " + jumlahJam16);
        }
    }

    public MataKuliah16(String kode, String nama, int sks, int jJam) {
        this.kodeMk16 = kode;
        this.nama16 = nama;
        this.sks16 = sks;
        this.jumlahJam16 = jJam;
    }

    public MataKuliah16() {
        
    }
}
