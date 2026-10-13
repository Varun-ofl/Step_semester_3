package oop.assignment_problems.problem4;

public class TrainCoachesBothWays {
    public static class Node {
        public String coach;
        public Node previous;
        public Node next;

        public Node(String coach) {
            this.coach = coach;
        }
    }

    public static class Train {
        private Node head;
        private Node tail;

        public void addFirst(String coach) {
            Node newNode = new Node(coach);
            if (head == null) {
                head = newNode;
                tail = newNode;
                return;
            }
            newNode.next = head;
            head.previous = newNode;
            head = newNode;
        }

        public void addLast(String coach) {
            Node newNode = new Node(coach);
            if (tail == null) {
                head = newNode;
                tail = newNode;
                return;
            }
            newNode.previous = tail;
            tail.next = newNode;
            tail = newNode;
        }

        public String forward() {
            return describe(head, false);
        }

        public String backward() {
            return describe(tail, true);
        }

        private String describe(Node start, boolean reverse) {
            StringBuilder result = new StringBuilder();
            Node current = start;
            while (current != null) {
                result.append(current.coach).append(" <-> ");
                current = reverse ? current.previous : current.next;
            }
            return result.append("null").toString();
        }
    }

    public static void main(String[] args) {
        Train train = new Train();
        train.addLast("Engine");
        train.addLast("Coach-A");
        train.addLast("Coach-B");
        train.addFirst("Guard");
        System.out.println("Forward: " + train.forward());
        System.out.println("Backward: " + train.backward());
    }
}
