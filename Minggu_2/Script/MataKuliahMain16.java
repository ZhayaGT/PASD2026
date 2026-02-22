package Minggu_2.Script;

public class MataKuliahMain16 {
    public static void main(String[] args) {
        MataKuliah16 matkul1 = new MataKuliah16("Daspro", "Dasar Pemograman", 2, 10);
        matkul1.ubahSKS(9);
        matkul1.tambahJam(2);
        matkul1.kurangiJam(1);
        matkul1.tampilInformasi();

        System.out.println("================");

        MataKuliah16 matkul2 = new MataKuliah16();
        matkul2.kodeMk16 = "Matdas";
        matkul2.nama16 = "Matematika Dasar";
        matkul2.sks16 = 3;
        matkul2.jumlahJam16 = 5;
        matkul2.ubahSKS(9);
        matkul2.tambahJam(2);
        matkul2.kurangiJam(1);
        matkul2.tampilInformasi();

    }
}
