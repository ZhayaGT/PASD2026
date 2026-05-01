package Tes;

class Mahasiswa {
    String nama;
    double ipk;
    int nomorAbsen;

    public Mahasiswa(String nama, double ipk, int nomorAbsen) {
        this.nama = nama;
        this.ipk = ipk;
        this.nomorAbsen = nomorAbsen;
    }

    @Override
    public String toString() {
        return String.format("Absen: %-2d | Nama: %-10s | IPK: %.2f", nomorAbsen, nama, ipk);
    }
}
