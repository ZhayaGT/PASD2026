package Minggu_11.Script;

public class MahasiswaAntrian16 {
    String nim;
    String nama;

    public MahasiswaAntrian16(String nim, String nama) {
        this.nim = nim;
        this.nama = nama;
    }

    public void tampilData() {
        System.out.printf("%-12s | %s\n", nim, nama);
    }
}
