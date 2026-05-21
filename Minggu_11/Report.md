# Laporan Praktikum - Algoritma dan Struktur Data

| Data Mahasiswa | Keterangan |
|:--- |:--- |
| **NIM** | 254107020006 |
| **Nama** | Jonathan Emmanuel Kristanto |
| **Kelas** | TI - 1F |
| **Repository** | [ZhayaGT/PASD2026](https://github.com/ZhayaGT/PASD2026) |

---

# Jobsheet #11 Single Linked List

## Percobaan 1 : Pembuatan Single Linked List

**File Kode:** [Mahasiswa.java](Script/Mahasiswa16.java) [NodeMahasiswa16.java](Script/NodeMahasiswa16.java) [SingleLinkedList16.java](Script/SingleLinkedList16.java) [SLLMain16.java](Script/SLLMain16.java)

### 1.1 Kode Program dan Hasil Running

**Kode Program:**
```java
    package Minggu_11.Script;

    public class Mahasiswa16 {
        String nim;
        String nama;
        String kelas;
        double ipk;

        public Mahasiswa16() {
        }

        public Mahasiswa16(String nm, String name, String kls, double ip) {
            nim = nm;
            nama = name;
            kelas = kls;
            ipk = ip;
        }

        public void tampilInformasi() {
            System.out.printf("%-14s %-17s %-11s %.1f\n", nama, nim, kelas, ipk);
        }
    }
```

```java
    package Minggu_11.Script;

    public class NodeMahasiswa16 {
        Mahasiswa16 data;
        NodeMahasiswa16 next;

        public NodeMahasiswa16(Mahasiswa16 data, NodeMahasiswa16 next) {
            this.data = data;
            this.next = next;
        }
    }
```

```java
    package Minggu_11.Script;

    public class SingleLinkedList16 {
        NodeMahasiswa16 head;
        NodeMahasiswa16 tail;

        boolean isEmpty() {
            return (head == null);
        }

        public void print() {
            if (!isEmpty()) {
                NodeMahasiswa16 tmp = head;
                System.out.println("Isi Linked List:");
                while (tmp != null) {
                    tmp.data.tampilInformasi();
                    tmp = tmp.next;
                }
                System.out.println("");
            } else {
                System.out.println("Linked list kosong");
            }
        }

        public void addFirst(Mahasiswa16 input) {
            NodeMahasiswa16 ndInput = new NodeMahasiswa16(input, null);
            if (isEmpty()) {
                head = ndInput;
                tail = ndInput;
            } else {
                ndInput.next = head;
                head = ndInput;
            }
        }

        public void addLast(Mahasiswa16 input) {
            NodeMahasiswa16 ndInput = new NodeMahasiswa16(input, null);
            if (isEmpty()) {
                head = ndInput;
                tail = ndInput;
            } else {
                tail.next = ndInput;
                tail = ndInput;
            }
        }

        public void insertAfter(String key, Mahasiswa16 input) {
            NodeMahasiswa16 ndInput = new NodeMahasiswa16(input, null);
            NodeMahasiswa16 temp = head;
            do {
                if (temp.data.nama.equalsIgnoreCase(key)) {
                    ndInput.next = temp.next;
                    temp.next = ndInput;
                    if (ndInput.next == null) {
                        tail = ndInput;
                    }
                    break;
                }
                temp = temp.next;
            } while (temp != null);
        }

        public void insertAt(int index, Mahasiswa16 input) {
            if (index < 0) {
                System.out.println("indeks salah");
            } else if (index == 0) {
                addFirst(input);
            } else {
                NodeMahasiswa16 temp = head;
                for (int i = 0; i < index - 1; i++) {
                    temp = temp.next;
                }
                temp.next = new NodeMahasiswa16(input, temp.next);
                if (temp.next.next == null) {
                    tail = temp.next;
                }
            }
        }
    }
```

```java
    package Minggu_11.Script;

    public class SLLMain16 {
        public static void main(String[] args) {
            SingleLinkedList16 sll = new SingleLinkedList16();
            
            Mahasiswa16 mhs1 = new Mahasiswa16("24212200", "Alvaro", "1A", 4.0);
            Mahasiswa16 mhs2 = new Mahasiswa16("23212201", "Bimon", "2B", 3.8);
            Mahasiswa16 mhs3 = new Mahasiswa16("22212202", "Cintia", "3C", 3.5);
            Mahasiswa16 mhs4 = new Mahasiswa16("21212203", "Dirga", "4D", 3.6);

            sll.print();
            
            sll.addFirst(mhs4);
            sll.print();
            
            sll.addLast(mhs1);
            sll.print();
            
            sll.insertAfter("Dirga", mhs3);
            sll.insertAt(2, mhs2);
            sll.print();
        }
    }
```

**Hasil Running:**
```
    Linked list kosong
    Isi Linked List:
    Dirga          21212203          4D          3.6

    Isi Linked List:
    Dirga          21212203          4D          3.6
    Alvaro         24212200          1A          4.0

    Isi Linked List:
    Dirga          21212203          4D          3.6
    Cintia         22212202          3C          3.5
    Bimon          23212201          2B          3.8
    Alvaro         24212200          1A          4.0
```


### Pertanyaan:

1. **Mengapa hasil compile kode program di baris pertama menghasilkan “Linked List Kosong”?**
    * Karena saat metode print() dipanggil pertama kali, belum ada data yang ditambahkan ke dalam linked list. Akibatnya, head masih bernilai null , sehingga program mengeksekusi kondisi else dan mencetak "Linked list kosong".

2. **Jelaskan kegunaan variable temp secara umum pada setiap method!**
    * temp berfungsi sebagai pointer (penunjuk) sementara untuk menelusuri (traverse) isi linked list dari node awal hingga akhir. Hal ini dilakukan agar kita bisa membaca atau mencari data tanpa mengubah posisi penunjuk utama (head).

3. **Lakukan modifikasi agar data dapat ditambahkan dari keyboard!**
    ```java
        package Minggu_11.Script;

            import java.util.Scanner;

            public class SLLMain16 {
                public static void main(String[] args) {
                    SingleLinkedList16 sll = new SingleLinkedList16();
                    
                    // Menggunakan try-with-resources (standar industri untuk keamanan memori)
                    try (Scanner sc = new Scanner(System.in)) {
                        System.out.print("Masukan Jumlah Mahasiswa: ");
                        int jumlah = sc.nextInt();
                        sc.nextLine();

                        for (int i = 0; i < jumlah; i++) {
                            System.out.println("=== Input Data Mahasiswa ke-" + (i + 1) + " ===");
                            System.out.print("NIM   : ");
                            String nim = sc.nextLine();
                            System.out.print("Nama  : ");
                            String nama = sc.nextLine();
                            System.out.print("Kelas : ");
                            String kelas = sc.nextLine();
                            System.out.print("IPK   : ");
                            double ipk = sc.nextDouble();
                            
                            sc.nextLine(); 

                            sll.addLast(new Mahasiswa16(nim, nama, kelas, ipk));
                        }
                    }
                    
                    System.out.println("\n--- Hasil Setelah Input ---");
                    sll.print();
                }
            }
    ```

    ---

## Percobaan 2 : Modifikasi Elemen pada Single Linked List

**File Kode:** [SingleLinkedList16.java](Script/SingleLinkedList16.java) [SLLMain16.java](Script/SLLMain16.java)

### 1.1 Kode Program dan Hasil Running

**Kode Program:**
```java
    public void getData(int index) {
        NodeMahasiswa16 tmp = head;
        for (int i = 0; i < index; i++) {
            tmp = tmp.next;
        }
        tmp.data.tampilInformasi();
    }

    public int indexOf(String key) {
        NodeMahasiswa16 tmp = head;
        int index = 0;
        while (tmp != null && !tmp.data.nama.equalsIgnoreCase(key)) {
            tmp = tmp.next;
            index++;
        }
        if (tmp == null) {
            return -1;
        } else {
            return index;
        }
    }

    public void removeFirst() {
        if (isEmpty()) {
            System.out.println("Linked List masih Kosong, tidak dapat dihapus!");
        } else if (head == tail) {
            head = tail = null;
        } else {
            head = head.next;
        }
    }

    public void removeLast() {
        if (isEmpty()) {
            System.out.println("Linked List masih Kosong, tidak dapat dihapus!");
        } else if (head == tail) {
            head = tail = null;
        } else {
            NodeMahasiswa16 temp = head;
            while (temp.next != tail) {
                temp = temp.next;
            }
            temp.next = null;
            tail = temp;
        }
    }

    public void remove(String key) {
        if (isEmpty()) {
            System.out.println("Linked List masih Kosong, tidak dapat dihapus!");
        } else if (head.data.nama.equalsIgnoreCase(key)) {
            removeFirst();
        } else {
            NodeMahasiswa16 temp = head;
            while (temp.next != null) {
                if (temp.next.data.nama.equalsIgnoreCase(key)) {
                    temp.next = temp.next.next;
                    if (temp.next == null) {
                        tail = temp;
                    }
                    break;
                }
                temp = temp.next;
            }
        }
    }

    public void removeAt(int index) {
        if (index == 0) {
            removeFirst();
        } else {
            NodeMahasiswa16 temp = head;
            for (int i = 0; i < index - 1; i++) {
                temp = temp.next;
            }
            temp.next = temp.next.next;
            if (temp.next == null) {
                tail = temp;
            }
        }
    }
```

```java
    public class SLLMain16 {
        public static void main(String[] args) {
            SingleLinkedList16 sll = new SingleLinkedList16();
            
            Mahasiswa16 mhs1 = new Mahasiswa16("24212200", "Alvaro", "1A", 4.0);
            Mahasiswa16 mhs2 = new Mahasiswa16("23212201", "Bimon", "2B", 3.8);
            Mahasiswa16 mhs3 = new Mahasiswa16("22212202", "Cintia", "3C", 3.5);
            Mahasiswa16 mhs4 = new Mahasiswa16("21212203", "Dirga", "4D", 3.6);

            sll.print();
            sll.addFirst(mhs4);
            sll.print();
            sll.addLast(mhs1);
            sll.print();
            sll.insertAfter("Dirga", mhs3);
            sll.insertAt(2, mhs2);
            sll.print();

            System.out.println("data index 1: ");
            sll.getData(1);
            System.out.println("data mahasiswa an Bimon berada pada index: " + sll.indexOf("bimon"));
            System.out.println();
            
            sll.removeFirst();
            sll.removeLast();
            sll.print();
            
            sll.removeAt(0);
            sll.print();
        }
    }
```

**Hasil Running:**
```
    data index 1: 
    Cintia         22212202          3C          3.5
    data mahasiswa an Bimon berada pada index: 2

    Isi Linked List:
    Cintia         22212202          3C          3.5
    Bimon          23212201          2B          3.8

    Isi Linked List:
    Bimon          23212201          2B          3.8
```


### Pertanyaan:

1. **Mengapa digunakan keyword break pada fungsi remove? Jelaskan!**
    * Keyword break digunakan untuk langsung menghentikan proses pencarian (looping) segera setelah data yang dituju berhasil ditemukan dan dihapus. Hal ini sangat efisien karena mencegah program membuang waktu memproses sisa linked list yang sudah tidak perlu lagi diperiksa.

2. **Jelaskan kegunaan kode dibawah pada method remove**
    * Berfungsi untuk "memutuskan" koneksi ke node yang ingin dihapus dengan cara melompatinya. Node sebelum target (temp) kini langsung menunjuk ke node setelah target.

    ---

## TUGAS

### 1.1 Kode Program dan Hasil Running

**Kode Program:**
```java
    package Minggu_11.Script;

    import java.util.Scanner;

    public class MainAntrian16 {
        public static void main(String[] args) {
            try (Scanner sc = new Scanner(System.in)) {
                System.out.print("Tentukan kapasitas maksimal antrian: ");
                int kapasitas = sc.nextInt();
                QueueLayanan16 antrian = new QueueLayanan16(kapasitas);
                int menu;

                do {
                    System.out.println("\n=== SISTEM ANTRIAN KEMAHASISWAAN ===");
                    System.out.println("1. Daftar Antrian Baru (Enqueue)");
                    System.out.println("2. Panggil Antrian (Dequeue)");
                    System.out.println("3. Cek Antrian Terdepan & Paling Akhir");
                    System.out.println("4. Status Antrian Saat Ini");
                    System.out.println("5. Tampilkan Seluruh Antrian");
                    System.out.println("6. Kosongkan Antrian (Clear)");
                    System.out.println("7. Keluar");
                    System.out.print("Pilih Menu (1-7): ");
                    menu = sc.nextInt();
                    sc.nextLine();

                    switch (menu) {
                        case 1:
                            if (!antrian.isFull()) {
                                System.out.print("Masukkan NIM  : ");
                                String nim = sc.nextLine();
                                System.out.print("Masukkan Nama : ");
                                String nama = sc.nextLine();
                                antrian.enqueue(new MahasiswaAntrian16(nim, nama));
                            } else {
                                System.out.println("Perhatian: Kapasitas antrian sudah penuh!");
                            }
                            break;
                        case 2:
                            antrian.dequeue();
                            break;
                        case 3:
                            antrian.peekFront();
                            System.out.println("-------------------------");
                            antrian.peekRear();
                            break;
                        case 4:
                            System.out.println("Status Kosong : " + antrian.isEmpty());
                            System.out.println("Status Penuh  : " + antrian.isFull());
                            System.out.println("Sisa Antrian  : " + antrian.getSize() + " mahasiswa");
                            break;
                        case 5:
                            antrian.printQueue();
                            break;
                        case 6:
                            antrian.clear();
                            break;
                        case 7:
                            System.out.println("Program dihentikan.");
                            break;
                        default:
                            System.out.println("Pilihan tidak tersedia, silakan coba lagi!");
                    }
                } while (menu != 7);
            } 
        }
    }

```

```java
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
```

```java
    package Minggu_11.Script;

    public class NodeLayanan16 {
        MahasiswaAntrian16 data;
        NodeLayanan16 next;

        public NodeLayanan16(MahasiswaAntrian16 data, NodeLayanan16 next) {
            this.data = data;
            this.next = next;
        }
    }
```

```java
    package Minggu_11.Script;

    public class MahasiswaAntrian16 {
        String nim;
        String nama;

        public MahasiswaAntrian16(String nim, String nama) {
            this.nim = nim;
            this.nama = nama;
        }

        public void tampilData() {
            System.out.printf("%-12s | %s\n", nim, nama);
        }
    }

```

**Hasil Running:**
```
    Tentukan kapasitas maksimal antrian: 3

    === SISTEM ANTRIAN KEMAHASISWAAN ===
    1. Daftar Antrian Baru (Enqueue)
    2. Panggil Antrian (Dequeue)
    3. Cek Antrian Terdepan & Paling Akhir
    4. Status Antrian Saat Ini
    5. Tampilkan Seluruh Antrian
    6. Kosongkan Antrian (Clear)
    7. Keluar
    Pilih Menu (1-7): 1
    Masukkan NIM  : 1
    Masukkan Nama : Joe
    Mahasiswa berhasil didaftarkan ke antrian.

    === SISTEM ANTRIAN KEMAHASISWAAN ===
    1. Daftar Antrian Baru (Enqueue)
    2. Panggil Antrian (Dequeue)
    3. Cek Antrian Terdepan & Paling Akhir
    4. Status Antrian Saat Ini
    5. Tampilkan Seluruh Antrian
    6. Kosongkan Antrian (Clear)
    7. Keluar
    Pilih Menu (1-7): 2
    Memanggil antrian mahasiswa:
    1            | Joe

    === SISTEM ANTRIAN KEMAHASISWAAN ===
    1. Daftar Antrian Baru (Enqueue)
    2. Panggil Antrian (Dequeue)
    3. Cek Antrian Terdepan & Paling Akhir
    4. Status Antrian Saat Ini
    5. Tampilkan Seluruh Antrian
    6. Kosongkan Antrian (Clear)
    7. Keluar
    Pilih Menu (1-7): 1
    Masukkan NIM  : 2
    Masukkan Nama : Pie
    Mahasiswa berhasil didaftarkan ke antrian.

    === SISTEM ANTRIAN KEMAHASISWAAN ===
    1. Daftar Antrian Baru (Enqueue)
    2. Panggil Antrian (Dequeue)
    3. Cek Antrian Terdepan & Paling Akhir
    4. Status Antrian Saat Ini
    5. Tampilkan Seluruh Antrian
    6. Kosongkan Antrian (Clear)
    7. Keluar
    Pilih Menu (1-7): 3
    --- Antrian Terdepan ---
    2            | Pie
    -------------------------
    --- Antrian Paling Akhir ---
    2            | Pie

    === SISTEM ANTRIAN KEMAHASISWAAN ===
    1. Daftar Antrian Baru (Enqueue)
    2. Panggil Antrian (Dequeue)
    3. Cek Antrian Terdepan & Paling Akhir
    4. Status Antrian Saat Ini
    5. Tampilkan Seluruh Antrian
    6. Kosongkan Antrian (Clear)
    7. Keluar
    Pilih Menu (1-7): 1
    Masukkan NIM  : 3
    Masukkan Nama : joe
    Mahasiswa berhasil didaftarkan ke antrian.

    === SISTEM ANTRIAN KEMAHASISWAAN ===
    1. Daftar Antrian Baru (Enqueue)
    2. Panggil Antrian (Dequeue)
    3. Cek Antrian Terdepan & Paling Akhir
    4. Status Antrian Saat Ini
    5. Tampilkan Seluruh Antrian
    6. Kosongkan Antrian (Clear)
    7. Keluar
    Pilih Menu (1-7): 3
    --- Antrian Terdepan ---
    2            | Pie
    -------------------------
    --- Antrian Paling Akhir ---
    3            | joe

    === SISTEM ANTRIAN KEMAHASISWAAN ===
    1. Daftar Antrian Baru (Enqueue)
    2. Panggil Antrian (Dequeue)
    3. Cek Antrian Terdepan & Paling Akhir
    4. Status Antrian Saat Ini
    5. Tampilkan Seluruh Antrian
    6. Kosongkan Antrian (Clear)
    7. Keluar
    Pilih Menu (1-7): 4
    Status Kosong : false
    Status Penuh  : false
    Sisa Antrian  : 2 mahasiswa

    === SISTEM ANTRIAN KEMAHASISWAAN ===
    1. Daftar Antrian Baru (Enqueue)
    2. Panggil Antrian (Dequeue)
    3. Cek Antrian Terdepan & Paling Akhir
    4. Status Antrian Saat Ini
    5. Tampilkan Seluruh Antrian
    6. Kosongkan Antrian (Clear)
    7. Keluar
    Pilih Menu (1-7): 5
    Daftar Antrian Layanan Unit Kemahasiswaan:
    1. 2            | Pie
    2. 3            | joe

    === SISTEM ANTRIAN KEMAHASISWAAN ===
    1. Daftar Antrian Baru (Enqueue)
    2. Panggil Antrian (Dequeue)
    3. Cek Antrian Terdepan & Paling Akhir
    4. Status Antrian Saat Ini
    5. Tampilkan Seluruh Antrian
    6. Kosongkan Antrian (Clear)
    7. Keluar
    Pilih Menu (1-7): 6
    Antrian layanan telah dikosongkan.

    === SISTEM ANTRIAN KEMAHASISWAAN ===
    1. Daftar Antrian Baru (Enqueue)
    2. Panggil Antrian (Dequeue)
    3. Cek Antrian Terdepan & Paling Akhir
    4. Status Antrian Saat Ini
    5. Tampilkan Seluruh Antrian
    6. Kosongkan Antrian (Clear)
    7. Keluar
    Pilih Menu (1-7): 5
    Daftar antrian saat ini kosong.
```
