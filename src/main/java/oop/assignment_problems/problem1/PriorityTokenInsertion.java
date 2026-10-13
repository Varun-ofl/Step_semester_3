package oop.assignment_problems.problem1;

public class PriorityTokenInsertion {
    public static class Node {
        public int data;
        public Node next;

        public Node(int data) {
            this.data = data;
        }
    }

    public static Node addFirst(Node head, int token) {
        Node newNode = new Node(token);
        newNode.next = head;
        return newNode;
    }

    public static Node addLast(Node head, int token) {
        Node newNode = new Node(token);
        if (head == null) {
            return newNode;
        }

        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
        return head;
    }

    public static Node insertAt(Node head, int index, int token) {
        if (index < 0) {
            throw new IndexOutOfBoundsException("Index cannot be negative");
        }
        if (index == 0) {
            return addFirst(head, token);
        }

        Node previous = head;
        for (int position = 0; position < index - 1 && previous != null; position++) {
            previous = previous.next;
        }
        if (previous == null) {
            throw new IndexOutOfBoundsException("Index is greater than the list size");
        }

        Node newNode = new Node(token);
        newNode.next = previous.next;
        previous.next = newNode;
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
        Node head = new Node(101);
        head.next = new Node(102);
        head.next.next = new Node(103);
        head = addFirst(head, 100);
        head = addLast(head, 104);
        head = insertAt(head, 2, 150);
        System.out.println(toString(head));
    }
}
