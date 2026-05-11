package Minggu_10.Script;

import java.util.Scanner;

public class AntrianKRS {
    Mahasiswa16[] data;
    int front;
    int rear;
    int size;
    int max;
    int kapasitasDPA;
    int jumlahDiproses;

    public AntrianKRS(int max, int kapasitasDPA) {
        this.max = max;
        this.kapasitasDPA = kapasitasDPA;
        data = new Mahasiswa16[max];
        size = 0;
        front = 0;
        rear = -1;
        jumlahDiproses = 0;
    }

    public boolean IsEmpty() {
        return size == 0;
    }

    public boolean IsFull() {
        return size == max;
    }

    public void KosongkanAntrian() {
        front = 0;
        rear = -1;
        size = 0;
        System.out.println("Antrian telah dikosongkan.");
    }

    public void TambahAntrian(Mahasiswa16 mhs) {
        if (IsFull()) {
            System.out.println(">> GAGAL: Antrian sudah penuh! Maksimal " + max + " antrian.");
        } else if (jumlahDiproses + size >= kapasitasDPA) {
            System.out.println(">> GAGAL: Kapasitas DPA sudah penuh (Maks " + kapasitasDPA + " mahasiswa).");
        } else {
            rear = (rear + 1) % max;
            data[rear] = mhs;
            size++;
            System.out.println(">> BERHASIL: " + mhs.nama + " telah masuk ke antrian.");
        }
    }

    public void ProsesKRS() {
        if (IsEmpty()) {
            System.out.println(">> Antrian kosong. Tidak ada mahasiswa yang bisa diproses.");
        } else {
            System.out.println(">> Sedang memproses KRS DPA...");
            // Proses 2 orang sekaligus, atau 1 jika hanya sisa 1 di antrian
            int jumlahPanggilan = Math.min(2, size); 
            
            for (int i = 0; i < jumlahPanggilan; i++) {
                Mahasiswa16 mhs = data[front];
                front = (front + 1) % max;
                size--;
                jumlahDiproses++;
                System.out.println("   [Panggilan " + (i + 1) + "] Mahasiswa diproses:");
                System.out.println("   - " + mhs.nama + " (" + mhs.nim + ")");
            }
            System.out.println(">> Selesai memproses " + jumlahPanggilan + " mahasiswa.");
        }
    }

    public void TampilkanSemua() {
        if (IsEmpty()) {
            System.out.println(">> Antrian saat ini kosong.");
        } else {
            System.out.println("=== DAFTAR ANTRIAN KRS ===");
            int i = front;
            for (int count = 0; count < size; count++) {
                System.out.println("Antrian ke-" + (count + 1) + ":");
                data[i].TampilkanData();
                i = (i + 1) % max;
            }
        }
    }

    public void LihatDuaTerdepan() {
        if (IsEmpty()) {
            System.out.println(">> Antrian kosong.");
        } else {
            System.out.println("=== 2 ANTRIAN TERDEPAN ===");
            int limit = Math.min(2, size);
            int i = front;
            for (int count = 0; count < limit; count++) {
                System.out.println("Terdepan ke-" + (count + 1) + ":");
                data[i].TampilkanData();
                i = (i + 1) % max;
            }
        }
    }

    public void LihatAkhir() {
        if (IsEmpty()) {
            System.out.println(">> Antrian kosong.");
        } else {
            System.out.println("=== ANTRIAN PALING AKHIR ===");
            data[rear].TampilkanData();
        }
    }

    public int GetJumlahAntrian() {
        return size;
    }

    public int GetJumlahDiproses() {
        return jumlahDiproses;
    }

    public int GetBelumKRS() {
        return kapasitasDPA - jumlahDiproses;
    }
}

