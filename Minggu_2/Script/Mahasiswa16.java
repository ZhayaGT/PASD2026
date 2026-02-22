package Minggu_2.Script;

public class Mahasiswa16 {
    String nama16;
    String nim16;
    String kelas16;
    double ipk16;

    public void tampilkanInformasi()
    {
        System.out.println("Nama: " + nama16);
        System.out.println("NIM: " + nim16);
        System.out.println("IPK: " + ipk16);
        System.out.println("Kelas: " + kelas16);
    }

    public void ubahKelas(String kelasBaru16)
    {
        kelas16 = kelasBaru16;
    }

    void updateIPK(double ipkBaru16)
    {
        if (ipkBaru16 >= 0.0 && ipkBaru16 <= 4.0) {
            ipk16 = ipkBaru16;
        } else {
            System.out.println("IPK tidak valid. Harus antara 0.0 dan 4.0");
        }
    }

    String nilaiKinerja(double ipk16)
    {
        if (ipk16 >= 3.5) {
            return "Kinerja sangat baik";
        } else if (ipk16 >= 3.0) {
            return "Kinerja baik";
        } else if (ipk16 >= 2.0) {
            return "Kinerja cukup";
        } else {
            return "Kinerja kurang";
        }
    }
}
