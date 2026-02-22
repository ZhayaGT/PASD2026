package Minggu_2.Script;

public class MahasiswaMain16 {
    public static void main(String[] args) {
        Mahasiswa16 mhs1 = new Mahasiswa16();
        mhs1.nama16 = "Muhammad Ali Farhan";
        mhs1.nim16 = "2241720171";
        mhs1.kelas16 = "SI 2J";
        mhs1.ipk16 = 3.55;

        mhs1.tampilkanInformasi();
        mhs1.ubahKelas("SI 2K");
        mhs1.updateIPK(3.60);
        mhs1.tampilkanInformasi();

        Mahasiswa16 mhs2 = new Mahasiswa16("Anisa Nabila", "2141720160", 3.25, "TI 2L");
        mhs2.updateIPK(3.30);
        mhs2.tampilkanInformasi();
    }
}
