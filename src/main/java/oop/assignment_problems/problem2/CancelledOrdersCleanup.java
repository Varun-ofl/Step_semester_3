package oop.assignment_problems.problem2;

public class CancelledOrdersCleanup {
    public static class Node {
        public int data;
        public Node next;

        public Node(int data) {
            this.data = data;
        }
    }

    public static Node removeAll(Node head, int code) {
        while (head != null && head.data == code) {
            head = head.next;
        }

        Node previous = head;
        while (previous != null && previous.next != null) {
            if (previous.next.data == code) {
                previous.next = previous.next.next;
            } else {
                previous = previous.next;
            }
        }
        return head;
    }

    public static String toString(Node head) {
        StringBuilder result = new StringBuilder();
        Node current = head;
        while (current != null) {
            result.append(current.data).append(" -> ");
            current = current.next;
        }
        return result.append("null").toString();
    }

    public static void main(String[] args) {
        Node head = new Node(5);
        head.next = new Node(3);
        head.next.next = new Node(5);
        head.next.next.next = new Node(8);
        head.next.next.next.next = new Node(5);
        System.out.println(toString(removeAll(head, 5)));
    }
}
