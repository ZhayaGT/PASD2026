package Minggu_6.Praktikum05.Script;

public class MahasiswaBerprestasi16 {
    Mahasiswa16[] listMhs = new Mahasiswa16[5];
    int idx;

    void Tambah (Mahasiswa16 m) {
        if (idx<listMhs.length) {
            listMhs[idx]=m;
            idx++;
        } else {
            System.out.println("data sudah penuh");
        }
    }

    void tampil() {
        for (Mahasiswa16 m : listMhs) {
            m.TampilInformasi();
            System.out.println("-----------------------------");
        }
    }

    void bubbleSort() {
        for (int i = 0; i < listMhs.length-1; i++) {
            for (int j = 1; j < listMhs.length-i; j++) {
                if (listMhs[j].ipk>listMhs[j-1].ipk) {
                    Mahasiswa16 tmp = listMhs[j];
                    listMhs[j] = listMhs[j-1];
                    listMhs[j-1]=tmp;
                }
            }
        }
    }

    void SelectionSort(){
        for (int i = 0; i < listMhs.length; i++) {
            int idxMin=i;
            for (int j = i+1; j < listMhs.length; j++) {
                if (listMhs[j].ipk<listMhs[idxMin].ipk) {
                    idxMin=j;
                }
                Mahasiswa16 tmp = listMhs[idxMin];
                listMhs[idxMin]=listMhs[i];
                listMhs[i]=tmp;
            }
        }
    }

    void InsertionSort(){
        for (int i = 1; i < listMhs.length; i++) {
            Mahasiswa16 temp = listMhs[i];
            int j=i;
            while (j>0 && listMhs[j-1].ipk>temp.ipk) {
                listMhs[j]=listMhs[j-1];
                j--;
            }
            listMhs[j]=temp;
        }
    }
}
