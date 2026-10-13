public class DoublyLinkedList implements LinkedList {
    private Node2P head, tail;
    private int size = 0;

    public DoublyLinkedList() {
        head = tail = null;
    }

    public boolean isEmpty() {
        return (size == 0);
    }

    public int size() {
        return size;
    }

    public void addFirst(Object inputData) {
        Node2P baru = new Node2P(inputData);
        if (isEmpty()) {
            head = baru;
            tail = baru;
        } else {
            baru.next = head;
            head.prev = baru;
            head = baru;
        }
        size++;
    }

    public void addLast(Object inputData) {
        Node2P baru = new Node2P(inputData);
        if (isEmpty()) {
            head = baru;
            tail = baru;
        } else {
            tail.next = baru;
            baru.prev = tail;
            tail = baru;
        }
        size++;
    }

    public void addAfter(int index, Object inputData) {
        if (isEmpty() || index < 0 || index >= size) {
            System.out.println("Index tidak valid");
            return;
        }
        if (index == size - 1) { 
            addLast(inputData);
            return;
        }
        Node2P baru = new Node2P(inputData);
        Node2P temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        baru.prev = temp;
        baru.next = temp.next;
        temp.next.prev = baru;
        temp.next = baru;
        size++;
    }

    public void deleteFirst() {
        if (isEmpty()) {
            System.out.println("List kosong!");
        } else if (head == tail) {
            head = tail = null;
            size--;
        } else {
            head = head.next;
            head.prev = null;
            size--;
        }
    }

    public void deleteLast() {
        if (isEmpty()) {
            System.out.println("List kosong!");
        } else if (head == tail) {
            head = tail = null;
            size--;
        } else {
            tail = tail.prev;
            tail.next = null;
            size--;
        }
    }

    public void deleteAfter(int index) {
        if (index < 0) {
            System.out.println("Index tidak valid");
            return;
        }
        if (index < size - 2) {
            Node2P temp = head;
            for (int i = 0; i < index; i++) {
                temp = temp.next;
            }
            temp.next.next.prev = temp;
            temp.next = temp.next.next;
            size--;
        } else if (index == size - 2) { 
            deleteLast();
        } else {
            System.out.println("Index lebih besar atau sama dari ukuran list");
        }
    }

    public void print() {
        Node2P currentNode = head;
        for (int i = 0; i < size; i++) {
            System.out.println(currentNode.data);
            currentNode = currentNode.next;
        }
    }

    @Override
    public Object get(int index) {
        if (index < 0 || index >= size) {
            return null;
        }
        Node2P bantu;
        if (index < size / 2) { 
            bantu = head;
            for (int i = 0; i < index; i++) {
                bantu = bantu.next;
            }
        } else {             
            bantu = tail;
            for (int i = size - 1; i > index; i--) {
                bantu = bantu.prev;
            }
        }
        return bantu.data;
    }

    @Override
    public int indexOf(Object targetData) {
        Node2P bantu = head;
        int index = 0;
        while (bantu != null) {
            if (java.util.Objects.equals(bantu.data, targetData)) {
                return index;
            }
            bantu = bantu.next;
            index++;
        }
        return -1;
    }

    @Override
    public void printReverse() {
        Node2P currentNode = tail;
        while (currentNode != null) {
            System.out.println(currentNode.data);
            currentNode = currentNode.prev;
        }
    }

    @Override
    public boolean remove(Object targetData) {
        Node2P bantu = head;
        while (bantu != null) {
            if (java.util.Objects.equals(bantu.data, targetData)) {
                if (bantu == head) {
                    deleteFirst();
                } else if (bantu == tail) {
                    deleteLast();
                } else {
                    bantu.prev.next = bantu.next;
                    bantu.next.prev = bantu.prev;
                    size--;
                }
                return true;
            }
            bantu = bantu.next;
        }
        return false;
    }

    @Override
    public Object[] toArray() {
        Object[] arr = new Object[size];
        Node2P current = head;
        for (int i = 0; i < size; i++) {
            arr[i] = current.data;
            current = current.next;
        }
        return arr;
    }

    public Object[] toArrayReverse() {
        Object[] arr = new Object[size];
        Node2P current = tail;
        for (int i = 0; i < size; i++) {
            arr[i] = current.data;
            current = current.prev;
        }
        return arr;
    }
}
