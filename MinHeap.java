import java.util.*;

public class MinHeap {
    private int[] heap;
    private int size;
    private int capacity;

    public MinHeap(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        heap = new int[capacity];
    }

    private int parent(int index) { return (index - 1) / 2; }
    private int leftChild(int index) { return 2 * index + 1; }
    private int rightChild(int index) { return 2 * index + 2; }

    private void minHeapify(int index) {
        int left = leftChild(index);
        int right = rightChild(index);
        int smallest = index;

        if (left < size && heap[left] < heap[smallest]) smallest = left;
        if (right < size && heap[right] < heap[smallest]) smallest = right;

        if (smallest != index) {
            swap(index, smallest);
            minHeapify(smallest);
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

        // Heap-Up Process (Bubble-Up for Min Heap)
        while (current > 0 && heap[current] < heap[parent(current)]) {
            swap(current, parent(current));
            current = parent(current); // Move up
        }
    }

    // **Removes the Minimum Element (Root)**
    public void removeMin() {
        if (size <= 0)
            System.out.println("No heap exists");
        else if (size == 1)
            size--; // Just decrease the size
        else {
            heap[0] = heap[size - 1]; // Replace root with last element
            size--;
            minHeapify(0); // Restore heap property
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
        MinHeap minHeap = new MinHeap(10);

        minHeap.insert(10);
        minHeap.insert(20);
        minHeap.insert(5);
        minHeap.insert(30);
        minHeap.insert(15);

        System.out.println("Heap after insertions:");
        minHeap.printHeap();

        minHeap.removeMin();
        System.out.println("Heap after removing min:");
        minHeap.printHeap();
    }
}
