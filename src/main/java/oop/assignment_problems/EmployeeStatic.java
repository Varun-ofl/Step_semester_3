public class EmployeeStatic {
    private String empName;
    private double salary;
    private static String companyName = "Bright Horizon Technologies";
    private static int employeeCount;

    public EmployeeStatic(String empName, double salary) {
        this.empName = empName;
        this.salary = salary;
        employeeCount++;
    }

    public static void printCompanyInfo() {
        System.out.println(companyName);
        System.out.println("Employees on record: " + employeeCount);
    }

    public static void main(String[] args) {
        new EmployeeStatic("Asha", 50000);
        new EmployeeStatic("Ravi", 55000);
        new EmployeeStatic("Meera", 60000);
        EmployeeStatic.printCompanyInfo();
    }
}