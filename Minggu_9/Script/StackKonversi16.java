package Minggu_9.Script;

public class StackKonversi16 {
    int[] tumpukanBiner;
    int size;
    int top;

    public StackKonversi16() {
        this.size = 32;
        tumpukanBiner = new int[size];
        top = -1;
    }

    boolean isEmpty() {
        return top == -1;
    }

    boolean isFull() {
        return top == size - 1;
    }

    void push(int data) {
        if (isFull()) {
            System.out.println("Stack Penuh");
        } else {
            top++;
            tumpukanBiner[top] = data;
        }
    }

    int pop() {
        if (isEmpty()) {
            System.out.println("Stack kosong");
            return -1;
        } else {
            int data = tumpukanBiner[top];
            top--;
            return data;
        }
    }
}
