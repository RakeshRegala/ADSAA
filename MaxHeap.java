import java.util.*;

public class MaxHeap {
    private int[] heap;
    private int size;
    private int capacity;

    public MaxHeap(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        heap = new int[capacity];
    }

    private int parent(int index) { return (index - 1) / 2; }
    private int leftChild(int index) { return 2 * index + 1; }
    private int rightChild(int index) { return 2 * index + 2; }

    private void maxHeapify(int index) {
        int left = leftChild(index);
        int right = rightChild(index);
        int largest = index;

        if (left < size && heap[left] > heap[largest]) largest = left;
        if (right < size && heap[right] > heap[largest]) largest = right;

        if (largest != index) {
            swap(index, largest);
            maxHeapify(largest);
        }
    }

    private void swap(int i, int j) {
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    // **Insert Method with Heap-Up Process**
    public void insert(int value) {
        if (size == capacity) {
            System.out.println("Heap is full");
            return;
        }
        heap[size] = value;
        int current = size;
        size++;

        // Heap-Up Process (Bubble-Up)
        while (current > 0 && heap[current] > heap[parent(current)]) {
            swap(current, parent(current));
            current = parent(current); // Move up
        }
    }

    // **Removes the Maximum Element (Root)**
    public void removeMax() {
        if (size <= 0)
            System.out.println("No heap exists");
        else if (size == 1)
            size--; // Just decrease the size
        else {
            heap[0] = heap[size - 1]; // Replace root with last element
            size--;
            maxHeapify(0); // Restore heap property
        }
    }

    public void printHeap() {
        System.out.print("Heap: ");
        for (int i = 0; i < size; i++) {
            System.out.print(heap[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        MaxHeap maxHeap = new MaxHeap(10);

        maxHeap.insert(10);
        maxHeap.insert(20);
        maxHeap.insert(5);
        maxHeap.insert(30);
        maxHeap.insert(15);

        System.out.println("Heap after insertions:");
        maxHeap.printHeap();

        maxHeap.removeMax();
        System.out.println("Heap after removing max:");
        maxHeap.printHeap();
    }
}
