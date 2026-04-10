package CM.Script;

public class Mahasiswa16 {
    String nim;
    String nama;
    String prodi;

    Mahasiswa16(){

    }

    Mahasiswa16(String nm, String name, String prod) {
        nim = nm;
        nama = name;
        prodi = prod;
    }

    void tampilMahasiswa() {
        System.out.print("NIM: " + nim);
        System.out.print(" | ");
        System.out.print("Nama: " + nama);
        System.out.print(" | ");
        System.out.print("Prodi: " + prodi);
        System.out.println();
    }
}
