package Minggu_11.Script;

import java.util.Scanner;

// public class SLLMain16 {
//     public static void main(String[] args) {
//         SingleLinkedList16 sll = new SingleLinkedList16();
        
//         // Menggunakan try-with-resources (standar industri untuk keamanan memori)
//         try (Scanner sc = new Scanner(System.in)) {
//             System.out.print("Masukan Jumlah Mahasiswa: ");
//             int jumlah = sc.nextInt();
//             sc.nextLine();

//             for (int i = 0; i < jumlah; i++) {
//                 System.out.println("=== Input Data Mahasiswa ke-" + (i + 1) + " ===");
//                 System.out.print("NIM   : ");
//                 String nim = sc.nextLine();
//                 System.out.print("Nama  : ");
//                 String nama = sc.nextLine();
//                 System.out.print("Kelas : ");
//                 String kelas = sc.nextLine();
//                 System.out.print("IPK   : ");
//                 double ipk = sc.nextDouble();
                
//                 sc.nextLine(); 

//                 sll.addLast(new Mahasiswa16(nim, nama, kelas, ipk));
//             }
//         }
        
//         System.out.println("\n--- Hasil Setelah Input ---");
//         sll.print();
//     }
// }

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
