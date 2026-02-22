package Minggu_2.Script;

public class DosenMain16 {
    public static void main(String[] args) {
        Dosen16 dosen1 = new Dosen16();
        dosen1.idDosen16 = "JEK";
        dosen1.nama16 = "Jonathan Emmanuel Kristanto";
        dosen1.statusAktif16 = true;
        dosen1.tahunBergabung16 = 2015;
        dosen1.bidangKeahlian16 = "Pemograman Game";
        dosen1.setStatusAktif();
        dosen1.hitungMasaKerja(2026);
        dosen1.ubahKeahlian("Compute Shader Programing");
        dosen1.tampilInformasi();

        System.out.println("======");

        Dosen16 dosen2 = new Dosen16("Ep", "Epan Ketumbar Budiman", false, 2023, "Game Technology");
        dosen2.setStatusAktif();
        dosen2.hitungMasaKerja(2026);
        dosen2.ubahKeahlian("Game Designer");
        dosen2.tampilInformasi();
    }
}
