import java.util.Arrays;

/**
 * testSinglyLinkedList
 */
public class testSinglyLinkedList {

    public static void main(String[] args) {
        SinglyLinkedList linkedList = new SinglyLinkedList();
        linkedList.addLast(1);
        linkedList.addLast(2);
        linkedList.addLast(3);
        linkedList.addLast(4);
        linkedList.addLast(5);
        linkedList.addLast(6);
        System.out.println(linkedList.get(2));       
        System.out.println(linkedList.get(12));     
        System.out.println(linkedList.indexOf(4));   
        System.out.println(linkedList.indexOf(10));  
        linkedList.printReverse();                   
        System.out.println(linkedList.remove(3));    
        System.out.println(linkedList.remove(8));   
        System.out.println(Arrays.toString(linkedList.toArray())); 
    }
}
