package oop.assignment_problems.problem5;

public class RoundRobinGameTurns {
    public static class Node {
        public String player;
        public Node next;

        public Node(String player) {
            this.player = player;
        }
    }

    public static class Game {
        private Node current;

        public void addPlayer(String player) {
            Node newNode = new Node(player);
            if (current == null) {
                current = newNode;
                current.next = current;
                return;
            }

            Node last = current;
            while (last.next != current) {
                last = last.next;
            }
            newNode.next = current;
            last.next = newNode;
        }

        public String playTurn() {
            if (current == null) {
                return "No players";
            }
            String player = current.player;
            current = current.next;
            return player;
        }

        public void removePlayer(String player) {
            if (current == null) {
                return;
            }

            Node previous = current;
            while (previous.next != current && !previous.next.player.equals(player)) {
                previous = previous.next;
            }
            if (!previous.next.player.equals(player)) {
                return;
            }

            Node removed = previous.next;
            if (removed == current && removed.next == current) {
                current = null;
            } else {
                previous.next = removed.next;
                if (removed == current) {
                    current = removed.next;
                }
            }
        }
    }

    public static void main(String[] args) {
        Game game = new Game();
        game.addPlayer("Asha");
        game.addPlayer("Ravi");
        game.addPlayer("Neha");
        System.out.println(game.playTurn());
        System.out.println(game.playTurn());
        System.out.println(game.playTurn());
        System.out.println(game.playTurn());
    }
}
