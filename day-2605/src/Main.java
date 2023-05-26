import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        LinkedList<Integer> ll = new LinkedList<>(List.of(1, 1, 1, 2, 2, 3));
        System.out.println(deleteDuplicates(ll));


        ListNode head = new ListNode(1);
        head.next = new ListNode(1);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(2);
        head.next.next.next.next.next = new ListNode(3);

        printList(head);
        head = reverseList(head);
        deleteDuplicates(head);
        printList(head);





    }

    // дан список. нужно его развернуть.
    public static ListNode reverseList(ListNode head) {
        ListNode prev = null;

        while (head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }



    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.value + " -> ");
            head = head.next;
        }
        System.out.println();
    }

    // дан отсортированный список
    // нужно пройтись по нему и вернуть список без дубликатов
    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode current = head;
        while (current.next != null) {
            if (current.value == current.next.value) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }
        return head;
    }

    // дан отсортированный линкедлист
    // нужно пройтись по нему и вернуть новый линкедлист без дубликатов
    public static LinkedList<Integer> deleteDuplicates(LinkedList<Integer> head) {
        LinkedList<Integer> result = new LinkedList<>();
        if (head.size() == 0) {
            return result;
        }
        result.add(head.get(0));
        for (int i = 1; i < head.size(); i++) {
            if (head.get(i - 1) != head.get(i)) {
                result.add(head.get(i));
            }
        }
        return result;
    }
}