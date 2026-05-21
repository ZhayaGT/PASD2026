package Minggu_11.Script;

public class Mahasiswa16 {
    String nim;
    String nama;
    String kelas;
    double ipk;

    public Mahasiswa16() {
    }

    public Mahasiswa16(String nm, String name, String kls, double ip) {
        nim = nm;
        nama = name;
        kelas = kls;
        ipk = ip;
    }

    public void tampilInformasi() {
        System.out.printf("%-14s %-17s %-11s %.1f\n", nama, nim, kelas, ipk);
    }
}