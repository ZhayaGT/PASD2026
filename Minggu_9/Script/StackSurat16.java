package Minggu_9.Script;

public class StackSurat16 {
    Surat16[] data;
    int size;
    int top;

    public StackSurat16(int size) {
        this.size = size;
        data = new Surat16[size];
        top = -1;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == size - 1;
    }

    public void push(Surat16 s) {
        if (!isFull()) {
            top++;
            data[top] = s;
            System.out.println("Surat berhasil diterima.");
        } else {
            System.out.println("Stack surat penuh!");
        }
    }

    public Surat16 pop() {
        if (!isEmpty()) {
            Surat16 s = data[top];
            top--;
            return s;
        } else {
            System.out.println("Tidak ada surat untuk diproses.");
            return null;
        }
    }

    public Surat16 peek() {
        if (!isEmpty()) {
            return data[top];
        } else {
            System.out.println("Tidak ada surat dalam tumpukan.");
            return null;
        }
    }

    public void cariSurat(String nama) {
        boolean ditemukan = false;
        for (int i = top; i >= 0; i--) {
            if (data[i].namaMahasiswa.equalsIgnoreCase(nama)) {
                System.out.println("Surat Ditemukan:");
                System.out.println("ID Surat: " + data[i].idSurat);
                System.out.println("Nama    : " + data[i].namaMahasiswa);
                System.out.println("Kelas   : " + data[i].kelas);
                System.out.println("Jenis   : " + data[i].jenisIzin);
                System.out.println("Durasi  : " + data[i].durasi + " hari");
                ditemukan = true;
                break;
            }
        }
        if (!ditemukan) {
            System.out.println("Surat dari " + nama + " tidak ditemukan.");
        }
    }
}
