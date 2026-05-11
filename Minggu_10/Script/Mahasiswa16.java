package Minggu_10.Script;

public class Mahasiswa16 {
    String nim;
    String nama;
    String prodi;
    String kelas;

    public Mahasiswa16(String nim, String nama, String prodi, String kelas) {
        this.nim = nim;
        this.nama = nama;
        this.prodi = prodi;
        this.kelas = kelas;
    }

    public void TampilkanData() {
        System.out.println("NIM   : " + nim);
        System.out.println("Nama  : " + nama);
        System.out.println("Prodi : " + prodi);
        System.out.println("Kelas : " + kelas);
        System.out.println("-------------------------");
    }
}
