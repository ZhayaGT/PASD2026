package Minggu_12.Script;

public class Mahasiswa16 {
    String nim;
    String nama;
    String kelas;
    double ipk;

    public Mahasiswa16(String nim, String nama, String kelas, double ipk) {
        this.nim = nim;
        this.nama = nama;
        this.kelas = kelas;
        this.ipk = ipk;
    }

    public void tampil() {
        System.out.printf("NIM   : %s\nNama  : %s\nKelas : %s\nIPK   : %.2f\n\n", nim, nama, kelas, ipk);
    }
}
