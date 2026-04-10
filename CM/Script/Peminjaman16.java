package CM.Script;

public class Peminjaman16 {
    
    Mahasiswa16 Mhs = new Mahasiswa16();
    Buku16 buku = new Buku16();
    int lamaPinjam = 0;
    int batasPinjam = 5;
    int terlambat = 0;
    int denda = 0;

    Peminjaman16() {

    }

    Peminjaman16 (Mahasiswa16 mh, Buku16 bk, int lama) {
        Mhs = mh;
        buku = bk;
        lamaPinjam =lama;
    }

    void HitungDenda() {
        if (lamaPinjam > batasPinjam) {
            terlambat = lamaPinjam-batasPinjam;
        }
        denda = terlambat * 2000;
    }

    void TampilPeminjaman() {
        System.out.println(Mhs.nama + " | " + buku.judul + " | Lama: " + lamaPinjam + 
        " | Terlambat: " + terlambat + " | Denda: " + denda);
    }


}
