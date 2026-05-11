package Minggu_10.Script;

public class Mahasiswa {
    String nim;
    String nama;
    String prodi;
    String kelas;

    Mahasiswa(String nim, String nama, String prodi, String kelas) {
        this.nim = nim;
        this.nama = nama;
        this.prodi = prodi;
        this.kelas = kelas;
    }
    

    void TampikanData() {
        System.out.println(nim + " - " + nama + " - " + prodi + " _ " + kelas);
    }
}
