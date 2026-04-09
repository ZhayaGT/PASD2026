package Minggu_6.Praktikum05.Script;

public class SortingMain16 {
    public static void main(String[] args) {
        int a[] = {20,10,2,7,12};
        int b[] = {30, 20, 2, 88, 14};
        int c[] = {40, 10, 4, 9, 3};

        Sorting16 dataurut1 = new Sorting16(a, a.length);
        Sorting16 dataurut2 = new Sorting16(b, b.length);
        Sorting16 dataurut3 = new Sorting16(c, c.length);

        System.out.println("Data awal 1");
        dataurut1.tampil();
        dataurut1.bubbleSort();
        System.out.println("Data sudah diurutkan dengan BUBBLE SORT (ASC)");
        dataurut1.tampil();

        System.out.println("Data awal 2");
        dataurut2.tampil();
        dataurut2.SelectionSort();
        System.out.println("Data sudah diurutkan dengan SELECTION SORT (ASC)");
        dataurut2.tampil();

        System.out.println("Data awal 3");
        dataurut3.tampil();
        dataurut3.InsertionSort();
        System.out.println("Data sudah diurutkan dengan INSERTION SORT (ASC)");
        dataurut3.tampil();
    }
}
