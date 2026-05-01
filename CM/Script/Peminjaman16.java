package CM.Script;

public class Peminjaman16 {
    
    Mahasiswa16 Mhs = new Mahasiswa16();
    Buku16 buku = new Buku16();
    int lamaPinjam = 0;
    int batasPinjam = 5;
    int terlambat = 0;
    int denda = 0;

    // Jawaban Soal B, sesi 1. Menambahkan Variabel boolean isCanceled
    boolean isCanceled;

    Peminjaman16() {

    }

    Peminjaman16 (Mahasiswa16 mh, Buku16 bk, int lama, boolean cancel) {
        Mhs = mh;
        buku = bk;
        lamaPinjam =lama;
        isCanceled = cancel;
    }

    void HitungDenda() {
        if (lamaPinjam > batasPinjam) {
            terlambat = lamaPinjam-batasPinjam;
        }
        denda = terlambat * 2000;

        // Jawaban Soal A, sesi 1. Membuat limit menjadi 20.000
        if (denda > 20000) {
            denda = 20000;
        }
    }


    void TampilPeminjaman() {
        // Menambahakan Kondisi, Jawaban Soal B, sesi 1
        if (isCanceled == false) {
            System.out.println(Mhs.nama + " | " + buku.judul + " | Lama: " + lamaPinjam + 
            " | Terlambat: " + terlambat + " | Denda: " + denda);
        }
    }

    //Membuat fungsi untuk mengubah nilai boolean, Soal B
    void Batalkan(){
        isCanceled = true;
        System.out.println("Data di Tandai");
    }


}
