package Tes;

import java.util.Random;

public class ReviewUTS {

    public static void main(String[] args) {
        Mahasiswa[] daftar = generateRandomData(10);
        
        System.out.println("=== DATA AWAL (RANDOM) ===");
        printArray(daftar);

        // --- DEMO SORTING (BRUTE FORCE) ---
        System.out.println("\n1. Bubble Sort (Berdasarkan IPK - Ascending):");
        bubbleSort(daftar);
        printArray(daftar);

        System.out.println("\n2. Selection Sort (Berdasarkan Nomor Absen - Ascending):");
        selectionSort(daftar);
        printArray(daftar);

        // --- DEMO SORTING (DIVIDE & CONQUER) ---
        System.out.println("\n3. Quick Sort (Berdasarkan Nama - Ascending):");
        quickSort(daftar, 0, daftar.length - 1);
        printArray(daftar);

        // --- NEW: BINARY INSERTION SORT ---
        System.out.println("\n4. Binary Insertion Sort (Berdasarkan IPK - Ascending):");
        binaryInsertionSort(daftar);
        printArray(daftar);

        // --- DEMO SEARCHING ---
        String cariNama = daftar[5].nama; // Mengambil nama salah satu mahasiswa sebagai contoh
        System.out.println("\n=== TESTING SEARCH (Cari Nama: " + cariNama + ") ===");
        
        int hasilSeq = sequentialSearch(daftar, cariNama);
        System.out.println("Sequential Search: Ditemukan di indeks " + hasilSeq);

        int hasilBin = binarySearch(daftar, cariNama);
        System.out.println("Binary Search (Syarat: Harus Sort by Name): Ditemukan di indeks " + hasilBin);

        // Interpolation search biasanya untuk angka (Nomor Absen)
        System.out.println("\n=== TESTING SEARCH (Cari Absen: 5 - Interpolation) ===");
        selectionSort(daftar); // Urutkan dulu berdasarkan absen
        int hasilInter = interpolationSearch(daftar, 5);
        System.out.println("Interpolation Search: Ditemukan di indeks " + hasilInter);
    }

    public static void binaryInsertionSort(Mahasiswa[] arr) {
        for (int i = 1; i < arr.length; i++) {
            Mahasiswa key = arr[i];
            
            // Temukan lokasi penyisipan menggunakan Binary Search
            int insertedPos = findInsertionPoint(arr, key.ipk, 0, i - 1);

            // Geser semua elemen ke kanan untuk memberi ruang
            for (int j = i - 1; j >= insertedPos; j--) {
                arr[j + 1] = arr[j];
            }
            arr[insertedPos] = key;
        }
    }

    private static int findInsertionPoint(Mahasiswa[] arr, double keyIpk, int low, int high) {
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (keyIpk < arr[mid].ipk) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }


    // ==========================================
    // BRUTE FORCE SECTION (SORTING)
    // ==========================================

    // Bubble Sort - $O(n^2)$
    public static void bubbleSort(Mahasiswa[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j].ipk > arr[j + 1].ipk) {
                    swap(arr, j, j + 1);
                }
            }
        }
    }

    // Selection Sort - $O(n^2)$
    public static void selectionSort(Mahasiswa[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j].nomorAbsen < arr[minIdx].nomorAbsen) minIdx = j;
            }
            swap(arr, i, minIdx);
        }
    }

    // ==========================================
    // DIVIDE & CONQUER SECTION (SORTING)
    // ==========================================

    // Quick Sort - Rata-rata $O(n \log n)$
    public static void quickSort(Mahasiswa[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    private static int partition(Mahasiswa[] arr, int low, int high) {
        String pivot = arr[high].nama;
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            // Menggunakan compareTo untuk String (Urutan Abjad)
            if (arr[j].nama.compareTo(pivot) < 0) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return i + 1;
    }

    // ==========================================
    // SEARCHING SECTION
    // ==========================================

    // Sequential Search - $O(n)$ - Bisa data acak
    public static int sequentialSearch(Mahasiswa[] arr, String target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].nama.equalsIgnoreCase(target)) return i;
        }
        return -1;
    }

    // Binary Search - $O(\log n)$ - Wajib SORTED
    public static int binarySearch(Mahasiswa[] arr, String target) {
        int low = 0, high = arr.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int res = target.compareToIgnoreCase(arr[mid].nama);
            if (res == 0) return mid;
            if (res > 0) low = mid + 1;
            else high = mid - 1;
        }
        return -1;
    }

    // Interpolation Search - $O(\log(\log n))$ - Untuk angka berdistribusi merata
    public static int interpolationSearch(Mahasiswa[] arr, int key) {
        int low = 0, high = arr.length - 1;
        while (low <= high && key >= arr[low].nomorAbsen && key <= arr[high].nomorAbsen) {
            if (low == high) {
                if (arr[low].nomorAbsen == key) return low;
                return -1;
            }
            // Rumus estimasi posisi
            int pos = low + (((high - low) / (arr[high].nomorAbsen - arr[low].nomorAbsen)) * (key - arr[low].nomorAbsen));

            if (arr[pos].nomorAbsen == key) return pos;
            if (arr[pos].nomorAbsen < key) low = pos + 1;
            else high = pos - 1;
        }
        return -1;
    }

    // ==========================================
    // UTILITY METHODS
    // ==========================================

    private static void swap(Mahasiswa[] arr, int i, int j) {
        Mahasiswa temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private static void printArray(Mahasiswa[] arr) {
        for (Mahasiswa m : arr) System.out.println(m);
    }

    private static Mahasiswa[] generateRandomData(int n) {
        Random rand = new Random();
        Mahasiswa[] data = new Mahasiswa[n];
        String[] namaDummy = {"Budi", "Ani", "Citra", "Dedi", "Eka", "Fani", "Gani", "Hani", "Iwan", "Joko"};
        
        for (int i = 0; i < n; i++) {
            data[i] = new Mahasiswa(namaDummy[i], 2.5 + (4.0 - 2.5) * rand.nextDouble(), i + 1);
        }
        
        // Acak posisi awal (Shuffle)
        for (int i = n - 1; i > 0; i--) {
            int index = rand.nextInt(i + 1);
            swap(data, index, i);
        }
        return data;
    }
}
