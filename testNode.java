public class testNode {
    public static void main(String[] args) {
        Node baru = new Node(10);
        Node baru2 = new Node();
        baru2.data = 15;
        // baru.data = 8;
        System.out.println(baru2.data);
        System.out.println(baru2.pointer);

         SinglyLinkedList list = new SinglyLinkedList();

        list.addFirst(10);
        list.addFirst(20);
        list.addFirst(30);

        System.out.println(list.get(0));
        System.out.println(list.get(1));
        System.out.println(list.get(2));

        System.out.println(list.indexOf(10));
        System.out.println(list.indexOf(99));
    }
}
