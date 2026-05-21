package Minggu_12.Script;

public class DoubleLinkedList16 {
    Node16 head;
    Node16 tail;
    int size;

    public DoubleLinkedList16() {
        head = null;
        tail = null;
        size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int getSize() {
        return size;
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
        size++;
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
        size++;
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
        size++;
        System.out.println("Data berhasil disisipkan setelah NIM " + keyNim);
    }

    public void add(int index, Mahasiswa16 data) {
        if (index < 0 || index > size) {
            System.out.println("Indeks di luar jangkauan.");
            return;
        }
        if (index == 0) {
            addFirst(data);
        } else if (index == size) {
            addLast(data);
        } else {
            Node16 current = head;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
            Node16 newNode = new Node16(data);
            newNode.prev = current.prev;
            newNode.next = current;
            current.prev.next = newNode;
            current.prev = newNode;
            size++;
            System.out.println("Data berhasil ditambahkan pada indeks " + index);
        }
    }

    public void removeFirst() {
        if (isEmpty()) {
            System.out.println("Linked List kosong.");
            return;
        }
        if (head == tail) {
            head = tail = null;
        } else {
            head = head.next;
            head.prev = null;
        }
        size--;
    }

    public void removeLast() {
        if (isEmpty()) {
            System.out.println("Linked List kosong.");
            return;
        }
        if (head == tail) {
            head = tail = null;
        } else {
            tail = tail.prev;
            tail.next = null;
        }
        size--;
    }

    public void removeAfter(String keyNim) {
        if (isEmpty()) {
            System.out.println("Linked List kosong.");
            return;
        }
        Node16 current = head;
        while (current != null && !current.data.nim.equals(keyNim)) {
            current = current.next;
        }
        if (current == null) {
            System.out.println("Data dengan NIM " + keyNim + " tidak ditemukan.");
            return;
        }
        if (current.next == null) {
            System.out.println("Tidak ada data setelah NIM " + keyNim + " untuk dihapus.");
            return;
        }
        Node16 target = current.next;
        if (target == tail) {
            current.next = null;
            tail = current;
        } else {
            current.next = target.next;
            target.next.prev = current;
        }
        size--;
        System.out.println("Data setelah NIM " + keyNim + " berhasil dihapus.");
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
            Node16 current = head;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
            current.prev.next = current.next;
            current.next.prev = current.prev;
            size--;
            System.out.println("Data pada indeks " + index + " berhasil dihapus.");
        }
    }

    public void getFirst() {
        if (isEmpty()) {
            System.out.println("Linked List kosong.");
        } else {
            System.out.println("=== DATA PERTAMA ===");
            head.data.tampil();
        }
    }

    public void getLast() {
        if (isEmpty()) {
            System.out.println("Linked List kosong.");
        } else {
            System.out.println("=== DATA TERAKHIR ===");
            tail.data.tampil();
        }
    }

    public void getIndex(int index) {
        if (index < 0 || index >= size) {
            System.out.println("Indeks di luar jangkauan.");
            return;
        }
        Node16 current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        System.out.println("=== DATA INDEKS SLL ke-" + index + " ===");
        current.data.tampil();
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
}