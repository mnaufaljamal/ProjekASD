/**
 * SinglyLinkedList
 */
public class SinglyLinkedList implements LinkedList {

    public Node head, tail;
    private int size = 0;

    public SinglyLinkedList() {
        head = tail = null;
    }

    public boolean isEmpty() {
        return (size == 0);
    }

    public int size() {
        return size;
    }

    public void addFirst(Object inputData) {
        Node baru = new Node(inputData);
        if (isEmpty()) {
            head = baru;
            tail = baru;
            size++;
        } else {
            baru.pointer = head;
            head = baru;
            size++;
        }
    }

    public void addLast(Object inputData) {
        Node baru = new Node(inputData);
        if (isEmpty()) {
            head = baru;
            tail = baru;
            size++;
        } else {
            tail.pointer = baru;
            tail = baru;
            size++;
        }
    }

    public void addAfter(int index, Object inputData) {
        if (isEmpty() || index < 0 || index >= size) {
            System.err.println("Index tidak valid");
            return;
        }
        Node baru = new Node(inputData);
        Node C = head;
        for (int i = 0; i < index; i++) {
            C = C.pointer;
        }
        baru.pointer = C.pointer;
        C.pointer = baru;
        if (C == tail) {
            tail = baru;
        }
        size++;
    }

    public void deleteFirst() {
        if (isEmpty()) {
            System.err.println("Linked list kosong");
        } else if (size == 1) {
            head = null;
            tail = null;
            size--;
        } else {
            head = head.pointer;
            size--;
        }
    }

    public void deleteLast() {
        if (isEmpty()) {
            System.err.println("Linked list kosong");
        } else if (size == 1) {
            head = null;
            tail = null;
            size--;
        } else {
            Node temp = head;
            for (int i = 1; i < size - 1; i++) {
                temp = temp.pointer;
            }
            tail = temp;
            tail.pointer = null;
            size--;
        }
    }

    public void deleteAfter(int index) {
        if (index < 0 || index >= size - 1) {
            System.err.println("Tidak ada node setelah index tersebut");
            return;
        }
        Node temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.pointer;
        }
        if (temp.pointer == tail) {
            tail = temp;
        }
        temp.pointer = temp.pointer.pointer;
        size--;
    }

    public void print() {
        Node currentNode = head;
        for (int i = 0; i < size; i++) {
            System.out.println(currentNode.data);
            currentNode = currentNode.pointer;
        }
    }

    @Override
    public Object get(int index) {
        if (index < 0 || index >= size) {
            return null;
        }
        Node bantu = head;
        for (int i = 0; i < index; i++) {
            bantu = bantu.pointer;
        }
        return bantu.data;
    }

    @Override
    public int indexOf(Object targetData) {
        Node bantu = head;
        int index = 0;
        while (bantu != null) {
            if (java.util.Objects.equals(bantu.data, targetData)) {
                return index;
            }
            bantu = bantu.pointer;
            index++;
        }
        return -1;
    }

    @Override
    public void printReverse() {
        for (int i = size - 1; i >= 0; i--) {
            System.out.println(get(i));
        }
    }

    @Override
    public boolean remove(Object targetData) {
        Node bantu = head;
        Node prev = null;
        while (bantu != null) {
            if (java.util.Objects.equals(bantu.data, targetData)) { 
                if (prev == null) {
                    deleteFirst();
                } else {
                    prev.pointer = bantu.pointer;
                    if (bantu == tail) tail = prev;
                    size--;
                }
                return true;
            }
            prev = bantu;
            bantu = bantu.pointer;
        }
        return false;
    }

    @Override
    public Object[] toArray() {
        Object[] arr = new Object[size];
        Node current = head;
        for (int i = 0; i < size; i++) {
            arr[i] = current.data;
            current = current.pointer;
        }
        return arr;
    }
}
