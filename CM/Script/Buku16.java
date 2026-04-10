package CM.Script;

public class Buku16 {
    String kodeBuku;
    String judul;
    int tahunTerbit;

    Buku16() {

    }

    Buku16(String kode, String jdl, int tahun) {
        kodeBuku = kode;
        judul = jdl;
        tahunTerbit = tahun;
    }

    void Tampil() {
        System.out.print("Kode Buku: " + kodeBuku);
        System.out.print(" | ");
        System.out.print("Judul: " + judul);
        System.out.print(" | ");
        System.out.print("Tahun Terbit: " + tahunTerbit);
        System.out.println();
    }
}
