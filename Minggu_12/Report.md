# Laporan Praktikum - Algoritma dan Struktur Data

| Data Mahasiswa | Keterangan |
|:--- |:--- |
| **NIM** | 254107020006 |
| **Nama** | Jonathan Emmanuel Kristanto |
| **Kelas** | TI - 1F |
| **Repository** | [ZhayaGT/PASD2026](https://github.com/ZhayaGT/PASD2026) |

---

# Jobsheet #12 Double Linked List

## Percobaan 1 : Pembuatan Single Linked List

**File Kode:** [Mahasiswa16.java](Script/Mahasiswa16.java) [Node16.java](Script/Node16.java) [DoubleLinkedList16.java](Script/DoubleLinkedList16.java) [DoubleLinkedList16.java](Script/DoubleLinkedListMain16.java)

### 1.1 Kode Program dan Hasil Running

**Kode Program:**
```java
    package Minggu_12.Script;

    public class DoubleLinkedList16 {
        Node16 head;
        Node16 tail;

        public DoubleLinkedList16() {
            head = null;
            tail = null;
        }

        public boolean isEmpty() {
            return head == null;
        }

        public void addFirst(Mahasiswa16 data) {
            Node16 newNode = new Node16(data);
            if (isEmpty()) {
                head = tail = newNode;
            } else {
                newNode.next = head;
                head.prev = newNode;
                head = newNode;
            }
        }

        public void addLast(Mahasiswa16 data) {
            Node16 newNode = new Node16(data);
            if (isEmpty()) {
                head = tail = newNode;
            } else {
                tail.next = newNode;
                newNode.prev = tail;
                tail = newNode;
            }
        }

        public void insertAfter(String keyNim, Mahasiswa16 data) {
            Node16 current = head;
            while (current != null && !current.data.nim.equals(keyNim)) {
                current = current.next;
            }

            if (current == null) {
                System.out.println("Data dengan NIM " + keyNim + " tidak ditemukan.");
                return;
            }

            Node16 newNode = new Node16(data);

            if (current == tail) {
                newNode.prev = current;
                current.next = newNode;
                tail = newNode;
            } else {
                newNode.prev = current;
                newNode.next = current.next;
                current.next.prev = newNode;
                current.next = newNode;
            }
            System.out.println("Data berhasil disisipkan setelah NIM " + keyNim);
        }

        public void print() {
            if (isEmpty()) {
                System.out.println("Linked List masih kosong.");
                return;
            }
            Node16 current = head;
            while (current != null) {
                current.data.tampil();
                current = current.next;
            }
        }

        public void printReverse() {
            if (isEmpty()) {
                System.out.println("Linked List masih kosong.");
                return;
            }
            System.out.println("--- Data (Reverse/Tail to Head) ---");
            Node16 current = tail;
            while (current != null) {
                current.data.tampil();
                current = current.prev;
            }
        }
    }

```

```java
    package Minggu_12.Script;

    import java.util.Scanner;

    public class DoubleLinkedListMain16 {
        public static void main(String[] args) {
            try (Scanner scan = new Scanner(System.in)) {
                DoubleLinkedList16 list = new DoubleLinkedList16();
                int pilihan;

                do {
                    System.out.println("===== MENU DOUBLE LINKED LIST =====");
                    System.out.println("1. Tambah data di awal");
                    System.out.println("2. Tambah data di akhir");
                    System.out.println("3. Sisipkan data di tengah (setelah NIM)");
                    System.out.println("4. Hapus data di awal");
                    System.out.println("5. Hapus data di akhir");
                    System.out.println("6. Tampilkan data");
                    System.out.println("7. Tampilkan data terbalik (Tail ke Head)");
                    System.out.println("0. Keluar");
                    System.out.print("Pilih menu: ");
                    pilihan = scan.nextInt();
                    scan.nextLine(); 

                    switch (pilihan) {
                        case 1:
                            list.addFirst(inputMahasiswa(scan));
                            break;
                        case 2:
                            list.addLast(inputMahasiswa(scan));
                            break;
                        case 3:
                            System.out.print("Masukkan NIM yang dicari: ");
                            String keyNim = scan.nextLine();
                            System.out.println("Masukkan data baru:");
                            list.insertAfter(keyNim, inputMahasiswa(scan));
                            break;
                        case 4:
                            System.out.println("Fitur hapus awal (akan diimplementasikan di percobaan 2)");
                            break;
                        case 5:
                            System.out.println("Fitur hapus akhir (akan diimplementasikan di percobaan 2)");
                            break;
                        case 6:
                            list.print();
                            break;
                        case 7:
                            list.printReverse();
                            break;
                        case 0:
                            System.out.println("Program selesai.");
                            break;
                        default:
                            System.out.println("Menu tidak valid.");
                    }
                } while (pilihan != 0);
            }
        }

        private static Mahasiswa16 inputMahasiswa(Scanner scan) {
            System.out.print("Masukkan NIM   : ");
            String nim = scan.nextLine();
            System.out.print("Masukkan Nama  : ");
            String nama = scan.nextLine();
            System.out.print("Masukkan Kelas : ");
            String kelas = scan.nextLine();
            System.out.print("Masukkan IPK   : ");
            double ipk = scan.nextDouble();
            scan.nextLine(); 
            return new Mahasiswa16(nim, nama, kelas, ipk);
        }
    }
```

```java
    package Minggu_12.Script;

    public class Mahasiswa16 {
        String nim;
        String nama;
        String kelas;
        double ipk;

        public Mahasiswa16(String nim, String nama, String kelas, double ipk) {
            this.nim = nim;
            this.nama = nama;
            this.kelas = kelas;
            this.ipk = ipk;
        }

        public void tampil() {
            System.out.printf("NIM   : %s\nNama  : %s\nKelas : %s\nIPK   : %.2f\n\n", nim, nama, kelas, ipk);
        }
    }

```

```java
    package Minggu_12.Script;

    public class Node16 {
        Mahasiswa16 data;
        Node16 prev;
        Node16 next;

        public Node16(Mahasiswa16 data) {
            this.data = data;
            this.prev = null;
            this.next = null;
        }
    }

```

**Hasil Running:**
```
    ===== MENU DOUBLE LINKED LIST =====
    1. Tambah data di awal
    2. Tambah data di akhir
    3. Sisipkan data di tengah (setelah NIM)
    4. Hapus data di awal
    5. Hapus data di akhir
    6. Tampilkan data
    7. Tampilkan data terbalik (Tail ke Head)
    0. Keluar
    Pilih menu: 2
    Masukkan NIM   : 123005
    Masukkan Nama  : Harry
    Masukkan Kelas : 1A
    Masukkan IPK   : 3.76

    ===== MENU DOUBLE LINKED LIST =====
    1. Tambah data di awal
    2. Tambah data di akhir
    3. Sisipkan data di tengah (setelah NIM)
    4. Hapus data di awal
    5. Hapus data di akhir
    6. Tampilkan data
    7. Tampilkan data terbalik (Tail ke Head)
    0. Keluar
    Pilih menu: 3
    Masukkan NIM yang dicari: 123005
    Masukkan data baru:
    Masukkan NIM   : 123005
    Masukkan Nama  : potter
    Masukkan Kelas : 1B
    Masukkan IPK   : 3.55 
    Data berhasil disisipkan setelah NIM 123005

    ===== MENU DOUBLE LINKED LIST =====
    1. Tambah data di awal
    2. Tambah data di akhir
    3. Sisipkan data di tengah (setelah NIM)
    4. Hapus data di awal
    5. Hapus data di akhir
    6. Tampilkan data
    7. Tampilkan data terbalik (Tail ke Head)
    0. Keluar
    Pilih menu: 6
    NIM   : 123005
    Nama  : Harry
    Kelas : 1A
    IPK   : 3.76

    NIM   : 123005
    Nama  : potter
    Kelas : 1B
    IPK   : 3.55
```


### Pertanyaan:

1. **Jelaskan perbedaan struktur dan mekanisme traversal antara Single Linked List dan Double Linked List!**
    * Single Linked List hanya memiliki satu pointer untuk bergerak ke arah depan menuju node selanjutnya, sehingga traversal hanya bisa dilakukan satu arah. Double Linked List memiliki pointer prev dan next, yang memungkinkan traversal dilakukan secara dua arah, baik maju (head ke tail) maupun mundur (tail ke head).

2. **Perhatikan class Node, di dalamnya terdapat atribut next dan prev. Jelaskan fungsi masing-masing atribut tersebut pada proses traversal dan manipulasi node!**
    * Atribut next: Berfungsi sebagai pointer yang merujuk pada node setelahnya, digunakan untuk traversal maju dan menyambungkan data ke arah belakang.
    
    * Atribut prev: Berfungsi sebagai pointer yang merujuk pada node sebelumnya, digunakan untuk traversal mundur dan menjaga agar koneksi antar node tidak terputus saat manipulasi data dilakukan. 

3. **Perhatikan konstruktor pada class DoubleLinkedList. Jelaskan fungsi konstruktor tersebut terhadap kondisi awal linked list!**
    * Fungsi konstruktor tersebut adalah untuk menginisialisasi linked list pada kondisi awal dengan mendeklarasikan secara eksplisit bahwa pointer head dan tail bernilai null. Hal ini mendefinisikan bahwa linked list tersebut masih dalam keadaan kosong.

4. **Perhatikan potongan kode berikut:**
    * Mengapa head dan tail harus menunjuk node yang sama ketika linked list masih kosong? Ketika linked list masih kosong dan sebuah node baru ditambahkan, node tunggal tersebut secara bersamaan berkedudukan sebagai elemen pertama sekaligus elemen terakhir di dalam antrian data. Oleh karena itu, pointer head dan tail harus sama-sama menunjuk ke objek node yang baru tersebut.

5. **Modifikasi method print() agar menampilkan pesan "Linked List masih kosong" ketika tidak terdapat data pada linked list!**
    * Kode modifikasi tersebut sudah terintegrasi secara efisien di dalam method print() pada kode di atas dengan memanfaatkan statement percabangan if (isEmpty()) { System.out.println("Linked List masih kosong."); return; }.  

6. **Modifikasi kode program dengan menambahkan method printReverse() untuk menampilkan seluruh data pada Double Linked List secara terbalik, dimulai dari node tail menuju head!**
    * Kode modifikasi telah ditambahkan ke dalam class DoubleLinkedList16 dalam bentuk method printReverse(), yang mengakses data dari tail lalu melakukan looping mundur menggunakan sintaks current = current.prev menuju head. Method ini juga telah diintegrasikan pada pilihan nomor 7 di menu switch-case DoubleLinkedListMain16.

    ---

## Percobaan 2 : Operasi Penghapusan pada Double Linked List

**File Kode:** [DoubleLinkedList16.java](Script/DoubleLinkedList16.java) [DoubleLinkedListMain16.java](Script/DoubleLinkedListMain16.java)

### 1.1 Kode Program dan Hasil Running

**Kode Program:**
```java
    public void removeFirst() {
        if (isEmpty()) {
            System.out.println("Linked List kosong.");
            return;
        }
        
        Mahasiswa16 deletedData = head.data;
        
        if (head == tail) {
            head = tail = null;
        } else {
            head = head.next;
            head.prev = null;
        }
        
        System.out.println("Data berhasil dihapus:");
        deletedData.tampil();
    }

    public void removeLast() {
        if (isEmpty()) {
            System.out.println("Linked List kosong.");
            return;
        }
        
        Mahasiswa16 deletedData = tail.data;
        
        if (head == tail) {
            head = tail = null;
        } else {
            tail = tail.prev;
            tail.next = null;
        }
        
        System.out.println("Data berhasil dihapus:");
        deletedData.tampil();
    }
```

```java
                    case 4:
                        list.removeFirst();
                        break;
                    case 5:
                        list.removeLast();
                        break;
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

1. **Perhatikan potongan kode berikut pada method removeFirst(): head = head.next; dan head.prev = null;. Jelaskan fungsi masing-masing statement tersebut pada proses penghapusan node!**
    * head = head.next;: Berfungsi untuk memindahkan pointer head ke node urutan kedua. Ini menjadikan node kedua tersebut sebagai elemen pertama (awal) yang baru dalam linked list.

    * head.prev = null;: Berfungsi untuk memutuskan koneksi (link) dari head yang baru ke node pertama yang lama dengan mengatur pointer mundurnya menjadi null. Ini memastikan node pertama yang lama benar-benar terlepas dari antrian sehingga memori dapat dibebaskan.

2. **Modifikasi method removeFirst() dan removeLast() agar program menampilkan data yang berhasil dihapus!**
    * Modifikasi tersebut sudah diterapkan langsung pada potongan kode di atas. Saya menambahkan variabel Mahasiswa16 deletedData untuk menyimpan sementara data dari node yang akan dihapus, lalu memanggil deletedData.tampil(); di akhir method untuk mencetaknya ke layar.

    ---

## TUGAS

### 1.1 Kode Program dan Hasil Running

**Kode Program:**
```java

    -----------------------------------------
    int size;

    public DoubleLinkedListTugas16() {
        head = null;
        tail = null;
        size = 0;
    }

    public int getSize() {
        return size;
    }

    -----------------------------------------

    public void addFirst(Mahasiswa16 data) {
        Node16 newNode = new Node16(data);
        if (isEmpty()) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        size++;
    }

    -----------------------------------------

    public void add(int index, MahasiswaTugas16 data) {
        if (index < 0 || index > size) {
            System.out.println("Indeks di luar jangkauan.");
            return;
        }
        if (index == 0) {
            addFirst(data);
        } else if (index == size) {
            addLast(data);
        } else {
            NodeTugas16 current = head;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
            NodeTugas16 newNode = new NodeTugas16(data);
            newNode.prev = current.prev;
            newNode.next = current;
            current.prev.next = newNode;
            current.prev = newNode;
            size++;
        }
    }

    public void removeAfter(String keyNim) {
        if (isEmpty()) {
            System.out.println("Linked List kosong.");
            return;
        }
        NodeTugas16 current = head;
        while (current != null && !current.data.nim.equals(keyNim)) {
            current = current.next;
        }
        if (current == null || current.next == null) {
            System.out.println("Data tidak ditemukan atau tidak ada data setelahnya.");
            return;
        }
        NodeTugas16 target = current.next;
        if (target == tail) {
            current.next = null;
            tail = current;
        } else {
            current.next = target.next;
            target.next.prev = current;
        }
        size--;
    }

    public void remove(int index) {
        if (index < 0 || index >= size) {
            System.out.println("Indeks di luar jangkauan.");
            return;
        }
        if (index == 0) {
            removeFirst();
        } else if (index == size - 1) {
            removeLast();
        } else {
            NodeTugas16 current = head;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
            current.prev.next = current.next;
            current.next.prev = current.prev;
            size--;
        }
    }

    public void getFirst() {
        if (!isEmpty()) head.data.tampil();
    }

    public void getLast() {
        if (!isEmpty()) tail.data.tampil();
    }

    public void getIndex(int index) {
        if (index < 0 || index >= size) {
            System.out.println("Indeks di luar jangkauan.");
            return;
        }
        NodeTugas16 current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        current.data.tampil();
    }

    -----------------------------------------

    case 4:
        System.out.print("Masukkan Indeks tujuan: ");
        int idxAdd = scan.nextInt();
        scan.nextLine();
        list.add(idxAdd, inputMahasiswa(scan));
        break;
    case 7:
        System.out.print("Masukkan NIM target: ");
        String keyRemAfter = scan.nextLine();
        list.removeAfter(keyRemAfter);
        break;
    case 8:
        System.out.print("Masukkan Indeks yang ingin dihapus: ");
        int idxRem = scan.nextInt();
        scan.nextLine();
        list.remove(idxRem);
        break;
    case 9:
        list.getFirst();
        break;
    case 10:
        list.getLast();
        break;
    case 11:
        System.out.print("Masukkan Indeks yang dicari: ");
        int idxGet = scan.nextInt();
        scan.nextLine();
        list.getIndex(idxGet);
        break;
    case 12:
        System.out.println("Jumlah data aktif (size): " + list.getSize());
        break;

```
