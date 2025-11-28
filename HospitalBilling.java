public class HospitalBilling {
    public void generateBill(Patient p, int amount) {
        printHeader("FINAL BILL");
        System.out.println("  Patient: " + p.getName());
        System.out.println("  Total Amount: BDT " + amount);
    }

    public void generateBill(Patient p, int amount, int insuranceCoverage) {
        printHeader("FINAL BILL (INSURANCE APPLIED)");
        System.out.println("  Patient: " + p.getName());
        System.out.println("  Base Amount: BDT " + amount);
        System.out.println("  Insurance Paid: -BDT " + insuranceCoverage);
        System.out.println("  Patient Pays: BDT " + (amount - insuranceCoverage));
    }
    
    private void printHeader(String title) {
        System.out.println("\n------ " + title + " ------");
    }
}