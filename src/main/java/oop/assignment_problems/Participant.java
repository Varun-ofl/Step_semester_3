public class Participant {
    private String name;
    private String teamName;
    private boolean registered;

    public Participant(String name, String teamName) {
        this.name = name;
        this.teamName = teamName;
        registered = true;
    }

    public Participant(String name) {
        this(name, "Unassigned");
    }

    public void printStatus() {
        System.out.println(name + " | " + teamName + " | Registered: " + registered);
    }

    public static void main(String[] args) {
        String[] names = {"Ravi", "Meera", "Karthik", "Divya"};
        String[] teamNames = {"ByteBusters", "", "CodeCrafters", ""};

        for (int index = 0; index < names.length; index++) {
            Participant participant;
            if (teamNames[index].isEmpty()) {
                participant = new Participant(names[index]);
            } else {
                participant = new Participant(names[index], teamNames[index]);
            }
            participant.printStatus();
        }
    }
}