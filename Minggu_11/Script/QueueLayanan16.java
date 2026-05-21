package Minggu_11.Script;

public class QueueLayanan16 {
    NodeLayanan16 front; 
    NodeLayanan16 rear;
    int size;
    int capacity;

    public QueueLayanan16(int capacity) {
        this.capacity = capacity;
        this.size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == capacity;
    }

    public void clear() {
        front = null;
        rear = null;
        size = 0;
        System.out.println("Antrian layanan telah dikosongkan.");
    }

    public void enqueue(MahasiswaAntrian16 data) {
        if (isFull()) {
            System.out.println("Antrian penuh! Tidak dapat menambahkan mahasiswa.");
            return;
        }
        NodeLayanan16 newNode = new NodeLayanan16(data, null);
        if (isEmpty()) {
            front = newNode;
            rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
        size++;
        System.out.println("Mahasiswa berhasil didaftarkan ke antrian.");
    }

    public void dequeue() {
        if (isEmpty()) {
            System.out.println("Antrian kosong! Tidak ada mahasiswa yang bisa dipanggil.");
            return;
        }
        System.out.println("Memanggil antrian mahasiswa:");
        front.data.tampilData();
        
        front = front.next;
        size--;
        if (isEmpty()) {
            rear = null;
        }
    }

    public void peekFront() {
        if (isEmpty()) {
            System.out.println("Antrian kosong!");
        } else {
            System.out.println("--- Antrian Terdepan ---");
            front.data.tampilData();
        }
    }

    public void peekRear() {
        if (isEmpty()) {
            System.out.println("Antrian kosong!");
        } else {
            System.out.println("--- Antrian Paling Akhir ---");
            rear.data.tampilData();
        }
    }

    public void printQueue() {
        if (isEmpty()) {
            System.out.println("Daftar antrian saat ini kosong.");
        } else {
            NodeLayanan16 tmp = front;
            int i = 1;
            System.out.println("Daftar Antrian Layanan Unit Kemahasiswaan:");
            while (tmp != null) {
                System.out.print(i + ". ");
                tmp.data.tampilData();
                tmp = tmp.next;
                i++;
            }
        }
    }

    public int getSize() {
        return size;
    }
}
