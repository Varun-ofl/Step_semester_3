public class ParkingTicket {
    private String vehicleNo;
    private double ratePerMinute;

    public ParkingTicket(String vehicleNo, double ratePerMinute) {
        this.vehicleNo = vehicleNo;
        this.ratePerMinute = ratePerMinute;
    }

    public final double calculateFine(int overstayMinutes) {
        return overstayMinutes * ratePerMinute;
    }

    public final void printReceipt(int overstayMinutes) {
        if (overstayMinutes > 0) {
            System.out.printf("%s - Fine: Rs %.1f%n", vehicleNo, calculateFine(overstayMinutes));
        } else {
            System.out.println(vehicleNo + " - No fine, within allotted time");
        }
    }

    public static void main(String[] args) {
        String[] vehicleNos = {"TN09AB1234", "TN22CD5678", "TN09EF9012", "TN10GH3456"};
        double[] rates = {2, 3, 2, 3};
        int[] overstayMinutes = {15, 0, -5, 8};

        for (int index = 0; index < vehicleNos.length; index++) {
            ParkingTicket ticket = new ParkingTicket(vehicleNos[index], rates[index]);
            ticket.printReceipt(overstayMinutes[index]);
        }
    }
}