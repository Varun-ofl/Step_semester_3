public class EmployeeOverloading {
    private String empId;
    private String empName;
    private double salary;
    private boolean isIntern;

    public EmployeeOverloading(String empId, String empName, double salary) {
        this.empId = empId;
        this.empName = empName;
        this.salary = salary;
        isIntern = false;
    }

    public EmployeeOverloading(String empId, String empName) {
        this(empId, empName, 0);
        isIntern = true;
    }

    public void printProfile() {
        System.out.printf("%s | %s | Rs %.1f | Intern: %s%n",
                empId, empName, salary, isIntern);
    }

    public static void main(String[] args) {
        EmployeeOverloading permanent = new EmployeeOverloading("E-101", "Divya", 65000);
        EmployeeOverloading intern = new EmployeeOverloading("E-102", "Arjun");
        permanent.printProfile();
        intern.printProfile();
    }
}